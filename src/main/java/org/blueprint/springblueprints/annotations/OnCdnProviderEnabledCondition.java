package org.blueprint.springblueprints.annotations;

import org.springframework.boot.autoconfigure.condition.ConditionMessage;
import org.springframework.boot.autoconfigure.condition.ConditionOutcome;
import org.springframework.boot.autoconfigure.condition.SpringBootCondition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotatedTypeMetadata;
import lombok.val;

public class OnCdnProviderEnabledCondition extends SpringBootCondition {

    private static final String PROPERTY_TEMPLATE = "blueprint-config.cdn-providers.%s.enabled";

    @Override
    public ConditionOutcome getMatchOutcome(ConditionContext context, AnnotatedTypeMetadata metadata) {
        val annotationAttributes = AnnotationAttributes
                .fromMap(metadata.getAnnotationAttributes(ConditionalOnEnabledCdnProvider.class.getName()));
        val endpointName = annotationAttributes.getString("value");
        return getProductOutcome(context, endpointName);
    }

    private ConditionOutcome getProductOutcome(ConditionContext context, String productName) {
        val environment = context.getEnvironment();
        val enabledProperty = PROPERTY_TEMPLATE.formatted(productName);
        if (environment.containsProperty(enabledProperty)) {
            boolean match = environment.getProperty(enabledProperty, Boolean.class, false);
            return new ConditionOutcome(match, ConditionMessage.forCondition(ConditionalOnEnabledCdnProvider.class)
                    .because(enabledProperty + " is " + match));
        }
        return new ConditionOutcome(false, ConditionMessage.forCondition(ConditionalOnEnabledCdnProvider.class)
                .because("By default CDN providers are disabled"));
    }

}
