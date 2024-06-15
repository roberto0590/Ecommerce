# Ecommerce

Purchase and Sales Cart Management with Spring Boot 3.3.0

## Description

Online shopping cart simulation

* Microservices architecture
* API Gateway
* Eureka
* Swagger
* Mapper
* Validator

## Getting Started

### Dependencies

* OpenJdk 17, Maven Plugin, Spring Boot 3.3.0, Spring Cloud 2023.0.2
* ex. Windows 10

### Installing

* Run parent pom to compile the projects

### Executing program

* Parent Pom
```
    <parent>
        <artifactId>ecommerce</artifactId>
        <groupId>com.technical</groupId>
        <version>0.0.1-SNAPSHOT</version>
    </parent>
```

* Modules
```
 <modules>
        <module>entity</module>
        <module>products</module>
        <module>orders</module>
        <module>pays</module>
        <module>discovery-server</module>
        <module>api-getway</module>
</modules>
```

## Module Description

*entity
```
library with entities & DTO
```

*products
```
Product Management Microservice
```

*orders
```
Purchasing Management Microservice
```

*pays
```
Payment Management Microservice
```

*discovery-server
```
Microservice Product Management
```

*api-getway
```
Microservice Product Management
```


## Authors

Contributors names and contact info

ex. Roberto Recinos  
ex. [@Robero0590](www.linkedin.com/in/roberto-recinos-956a8596)

## Version History

* 0.0.1-SNAPSHOT
    * Initial Release

## License

Open source program

## Acknowledgments

Inspiration, code snippets, etc.
* [awesome-readme](https://github.com/matiassingers/awesome-readme)
* [PurpleBooth](https://gist.github.com/PurpleBooth/109311bb0361f32d87a2)
* [dbader](https://github.com/dbader/readme-template)
* [zenorocha](https://gist.github.com/zenorocha/4526327)
* [fvcproductions](https://gist.github.com/fvcproductions/1bfc2d4aecb01a834b46)
