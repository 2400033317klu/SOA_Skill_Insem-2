# Task Repository Integration Testing

A small Spring Boot 3 / Spring Data JPA Maven project demonstrating repository integration testing with an embedded H2 in-memory database.

## Requirements
- JDK 17 or later
- Eclipse IDE with Maven support (Eclipse IDE for Enterprise Java and Web Developers, or Maven Integration for Eclipse)

## Import into Eclipse
1. Extract `task-repository-integration-testing.zip`.
2. Open Eclipse.
3. Select **File → Import → Maven → Existing Maven Projects**.
4. Browse to the extracted project folder and select it.
5. Ensure `pom.xml` is detected, then click **Finish**.
6. If dependencies do not load, right-click the project → **Maven → Update Project**.

## Run the repository test
- In Package Explorer, open `src/test/java/com/example/demo/TaskRepositoryTest.java`.
- Right-click the file → **Run As → JUnit Test**.

Alternatively, from a terminal in the project folder run:

```bash
mvn test
```

The test saves a `Task` using `taskRepository.save(...)`, retrieves it using `findById(...)`, and verifies that the generated ID is not null and the saved fields are present.

## Important notes
- `@DataJpaTest` loads the JPA-focused test slice rather than the entire application context. This makes the test lighter and faster.
- H2 is an embedded in-memory database, so no separate database server or credentials are required.
- Spring test transactions are rolled back after each test method by default, keeping tests isolated and repeatable.
