# REST Assured API Automation Framework

A comprehensive REST API automation testing framework built with Java, REST Assured, and Maven for testing RESTful web services.

## Features

- **REST API Testing**: Comprehensive testing of RESTful web services
- **Request/Response Validation**: Built-in support for request and response validation
- **JSON & XML Parsing**: Parse and validate JSON and XML responses
- **Authentication Support**: Bearer token, Basic Auth, and OAuth
- **Parameterized Testing**: Data-driven testing with multiple test scenarios
- **Extent Reporting**: Detailed HTML test reports with screenshots and logs
- **TestNG Integration**: Powerful test execution and reporting capabilities
- **Maven Build**: Easy project build and dependency management
- **CI/CD Ready**: Jenkins and GitHub Actions compatible

## Prerequisites

- Java 11 or higher
- Maven 3.6 or higher
- Git

## Technologies Used

- **Framework**: REST Assured 5.3.1
- **Test Runner**: TestNG 7.7.1
- **Build Tool**: Maven 3.6+
- **Logging**: SLF4J
- **Reporting**: Extent Reports 5.0.9
- **JSON Processing**: Jackson 2.14.2

## Project Structure

```
REST-Assured-API-Automation-Framework/
├── src/
│   ├── test/
│   │   └── java/
│   │       ├── api/
│   │       │   └── endpoints/ (API endpoint definitions)
│   │       ├── payloads/ (Request and response models)
│   │       ├── tests/ (Test classes)
│   │       └── utilities/ (Helper and utility classes)
├── pom.xml
├── testng.xml
├── .gitignore
└── README.md
```

## Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/VishalGiram0842/REST-Assured-API-Automation-Framework.git
cd REST-Assured-API-Automation-Framework
```

### 2. Install Dependencies

```bash
mvn clean install
```

### 3. Run Tests

```bash
mvn test
```

### 4. Run Specific Test Suite

```bash
mvn test -Dtest=UserAPITests
```

## Configuration

### Test Configuration (testng.xml)

Update the `testng.xml` file to specify:
- Test class names
- Thread count for parallel execution
- Test listeners and reporters

### Maven Configuration (pom.xml)

Update the `pom.xml` to:
- Add/update dependency versions
- Configure plugins
- Set build properties

## Writing Tests

### Sample Test Structure

```java
public class UserAPITests {
    
    @BeforeTest
    public void setup() {
        // Initialize API client
    }
    
    @Test
    public void testGetUser() {
        Response response = RestAssured
            .given()
            .header("Authorization", "Bearer " + token)
            .when()
            .get("/api/users/1")
            .then()
            .statusCode(200)
            .extract()
            .response();
        
        // Assertions
        Assert.assertEquals(response.getBody().path("id"), 1);
    }
}
```

## Reports

Extent reports are generated in the `test-output/` directory after test execution.

## Best Practices

- Use Page Object Model or API Object Model pattern
- Maintain separate payload/request models
- Use meaningful test method names
- Implement proper logging
- Use data-driven testing for multiple scenarios
- Keep tests independent and isolated

## Continuous Integration

This framework is compatible with:
- Jenkins
- GitHub Actions
- GitLab CI
- Azure Pipelines

## Contributing

Contributions are welcome! Please follow the code style and structure of the project.

## License

This project is open source and available under the MIT License.

## Contact

For questions or support, please reach out to [VishalGiram0842](https://github.com/VishalGiram0842)
