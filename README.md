# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.1/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.1/maven-plugin/reference/html/#build-image)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.2.1/reference/htmlsingle/index.html#using.devtools)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.2.1/reference/htmlsingle/index.html#web)
* [Validation](https://docs.spring.io/spring-boot/docs/3.2.1/reference/htmlsingle/index.html#io.validation)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.2.1/reference/htmlsingle/index.html#data.sql.jpa-and-spring-data)

### Guides

The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Validation](https://spring.io/guides/gs/validating-form-input/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)



## YOU CAN CONNECT TO PROJECT WITH localhost:3000

### THERE ARE 2 ENTITIES RIGHT NOW see(src/main/java/com/enoca/enocacasestudy/Entity) :

1- COMPANY
localhost:3000/company
2- EMPLOYEE
localhost:3000/employee

### THERE ARE 5 ENDPOINTS FOR EACH ENTITY FOR CRUD OPERATIONS see(src/main/java/com/enoca/enocacasestudy/Controller/CRUDController.java):

#### 1-ADD 
Adds a new Entity.RequestBody needs to be an EntitySaveRequestDto such as com/enoca/enocacasestudy/DTOs/Company/CompanySaveRequestDto.java for a Company to add.
see(com/enoca/enocacasestudy/DTOs) for Dtos.
localhost:3000/company/add
RequestBody:
{
    "companyName":"ANKARA BÜYÜK ŞEHİR"
}
#### 2-DELETE
Deletes a entity based on entity's id.Request needs to have a parameter called id to execute.
localhost:3000/company/delete?id=1
#### 3-GETALL
Gets a entity list.
localhost:3000/company/getAll
#### 4-GETBYID
Gets a entity based on entity's id.Request needs to have a parameter called id to execute.
localhost:3000/company/getById?id=1
#### 5-UPDATEBYID
Gets a entity based on entity's dto.RequestBody needs to be an EntityDto such as com/enoca/enocacasestudy/DTOs/Company/CompanyDto.java for a Company to update.
localhost:3000/company/updateById
RequestBody:
{
    "id":1,
    "companyName":"ANKARA BÜYÜK ŞEHİR BELEDİYESİ"
}







