# Custom Conditional Annotations

Package: org.blueprint.springblueprints.annotations

## @ConditionalOnEnabledCdnProvider
Custom annotation with:
- @Retention(RetentionPolicy.RUNTIME)
- @Target(ElementType.TYPE)
- @Conditional(OnCdnProviderEnabledCondition.class)
- String value() - CDN provider name

## OnCdnProviderEnabledCondition
Extends SpringBootCondition:
- Check property: "blueprint-config.cdn-providers.{value}.enabled"
- Return ConditionOutcome based on property value
- Default to false if property not found

Enable TRACE logging for the condition:
```yaml
logging:
  level:
    org.blueprint.springblueprints.annotations.OnCdnProviderEnabledCondition: TRACE
```
Update `application.yaml` with
## application.yaml
```yaml
blueprint-config:
  cdn-providers:
    azure:
      enabled: true
    tencent:
      enabled: true
    cloud-front:
      enabled: false
```