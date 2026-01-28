# File Upload REST Controller

Package: org.blueprint.springblueprints

## FileController
- @RestController
- Constructor injection:
  - FileService
  - @Value("classpath:business-data.json") Resource businessData
- @PostMapping("/upload")
  - Call fileService.upload(businessData.getFile())
  - Return Collection<URI>
  - Handle IOException and throw UncheckedIOException

## business-data.json (src/main/resources/)
```json
{
  "employees": [
    {
      "id": 1,
      "name": "Gilfoyle",
      "position": "Software Engineer",
      "department": "Development",
      "salary": 90000
    },
    {
      "id": 2,
      "name": "Richard Hendricks",
      "position": "CTO",
      "department": "Development",
      "salary": 105000
    },
    {
      "id": 3,
      "name": "Big Head",
      "position": "N/A",
      "department": "Rooftop",
      "salary": 2000000
    }
  ]
}
```
