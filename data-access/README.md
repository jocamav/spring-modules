# data-access

## Description

This module contains an example of JPA Data access using Spring Data. Basically we have created a Customer Entity with the annotation `@Entity` and a Repository extending the interface `JpaRepository`

> In this case, the Entity include some Jackson annotations just for using the Entity as DTO and avoid problems with the Lazy fetch

To verify the operations of the JPA Repository, just execute the tests:

```
mvn clean test
```

## References

* [Spring Data JPA](https://docs.spring.io/spring-data/jpa/docs/2.1.4.RELEASE/reference/html/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
