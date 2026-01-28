# File Service Orchestration

Package: org.blueprint.springblueprints.service

## FileService Interface
- Collection<URI> upload(File file)

## FileServiceImpl (service/impl/)
- @Service
- @RequiredArgsConstructor
- Inject Collection<CdnService> - all enabled CDN services
- Inject ApplicationConfiguration
- Upload file to all enabled CDN services
- Return Collection<URI> of all upload locations
- Use streams and collect to unmodifiable set
