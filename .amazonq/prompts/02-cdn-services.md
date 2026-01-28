# CDN Service Layer

Package: org.blueprint.springblueprints.service

## CdnService Interface
- URI upload(File file)
- default File download(String fileKey) - creates temp file

## Implementations (service/impl/)

### AzureCdnServiceImpl
- @Service, @Slf4j
- @GDPRCompliantCdn
- @ConditionalOnEnabledCdnProvider("azure")
- Upload to https://spring-blueprints-bucket.azure.com/
- Use FileCopyUtils.copyToByteArray() and log bytes uploaded

### CloudFrontCdnServiceImpl
- @Service, @Slf4j
- @ConditionalOnEnabledCdnProvider("cloud-front")
- Upload to https://spring-blueprints-bucket.aws.com/

### TencentCdnServiceImpl
- @Service, @Slf4j
- @ConditionalOnEnabledCdnProvider("tencent")
- Upload to https://spring-blueprints-bucket.tencent.com/

All implementations should handle IOException and throw UncheckedIOException.
