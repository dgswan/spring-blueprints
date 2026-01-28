# Configuration Properties with Records

Package: org.blueprint.springblueprints.config

Create ApplicationConfiguration record with @ConfigurationProperties(prefix = "blueprint-config"):
- Set<String> features
- String primaryCdnProvider
- Add @PostConstruct method to log initialization

Enable in main application with @EnableConfigurationProperties(ApplicationConfiguration.class)

## application.yaml
```yaml
blueprint-config:
  features:
    - GDPR-verification
    - preview-mode
  primary-cdn-provider: azure
  cdn-providers:
    azure:
      enabled: true
    tencent:
      enabled: true
    cloud-front:
      enabled: false
```
