# spring-modules

The project is defined as a multi-module maven project. Each module includes examples of some Spring features as:
* REST services
* Web content using Thymeleaf, Bootstrap and jQuery
* JMS messaging
* Access to Database using Spring Data (JPA)

To install and to execute the application, execute next maven commands:

```
mvn clean install
mvn spring-boot:run -pl web-content
```
Then, you can navigate to `http://localhost:8080/` to test all the different features.
