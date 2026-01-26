package org.blueprint.springblueprints.annotations;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * The annotation to toggle CDN providers.
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Conditional({OnCdnProviderEnabledCondition.class})
public @interface ConditionalOnEnabledCdnProvider {

    /**
     * CDN provider name.
     *
     * @return CDN provider name
     */
    String value();

}
