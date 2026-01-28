# Custom Qualifier Annotation

Package: org.blueprint.springblueprints.annotations

Create @GDPRCompliantCdn annotation:
- @Qualifier
- @Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE})
- @Retention(RetentionPolicy.RUNTIME)

Use this annotation to:
- Mark CDN services that are GDPR compliant
- Inject specific GDPR-compliant CDN service in other services
