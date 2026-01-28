# GDPR File Service with Qualifier Injection

Package: org.blueprint.springblueprints.service

## GDPRFileService Interface
- void check(File file)

## GDPRFileServiceImpl (service/impl/)
- @Service, @Slf4j
- Constructor injection with @GDPRCompliantCdn CdnService
- This ensures only GDPR-compliant CDN service is injected
- Download file using cdnService.download()
- Log file absolute path being checked
- Use Lombok val for local variables
