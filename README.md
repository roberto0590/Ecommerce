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

* OpenJdk 17, Maven Plugin, Spring Boot 3.3.0, Spring Cloud 2023.0.2, PostgreSQL Database
* ex. Windows 10
* PostgreSQL database is needed to create tables used in the system
* The data in the database is temporary, it is a temporary database in PostgreSQL deployed in Azure

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

* entity
```
library with entities & DTO
```

### products
* Product Management Microservice
  
```
**Search all product catalog database**
/product/findAllBD

***Search all product catalog from external source https://fakestoreapi.com/products***
/product/findAllExternal

***Search for all the product catalog from the external source ttps://fakestoreapi.com/products
and if it is the first time, enter them in the database, this in case the endpoint is not available***
/product/findAllAndSaveBD

***Deleting a product based on its database id***
/product/delete/{idProducto}
```

### orders
* Purchasing Management Microservice

```
***Show the total balance of a purchase according to the order id***
/orders/findBalanceByOrder/{orderId}

***Register a purchase, according to the customer and the product
The purchase can be made by sending the customer's ID or the customer's email, in addition the product
code must be included in the database or the name of the product can also be sent.
Validations
    1. If a purchase order does not exist, it will be created
    2. If the customer has all purchase orders paid, a new one will also be created
    3. If the customer has an active order, which has not been paid, then the product will
       be associated with the purchase order.***
/orders/buys
Input
    {
        "customerCode": 1,
        "productCode": 175
    }


***The search can be by the client's code or the client's email
The details of the customer's orders, their associated products, and the payment for each order
will be displayed, or the payment object will be shown as null if an order is active and
payment has not been made and has not been deleted.***
/orders/findOrderByClient
Input
{
    "customerCode":  {clientId},
    "mailCustomer" : {clientMail}
}


***Search for orders by dates, shows all orders only using the date filter***
/orders/findOrderByDate
Input
{
    "fecha1": "YYYY-MM-DD",
    "fecha2" :"YYYY-MM-DD"
}


***Delete order according to the order id, it is validated that the order does not have
associated payments and secondly that it does not have products associated with the order
Validations
    1. The order already has a payment, the order cannot be deleted, if you want to delete it,
       you must cancel the payment
    1. The order has associated products, you must proceed to, delete the products,
       and then delete the order***
/orders/delete/{orderId}


***Deleting a product based on its database id***
Validations
    1. The order already has a payment, the product cannot be removed from the order.
       If you want to modify the order you must cancel the payment***
/detailOrder/delete/{orderId}


***The order and its associated products will be deleted completely,
as long as the order does not have a related payment.
Validations
    1. The order already has a payment, I can't delete the order,
       if you want to delete it, you need to cancel the payment
***
/orders/deleteOrderComplete/{orderId}
```

#### pays
* Payment Management Microservice
```
***To enter a payment for an order, send the order ID***
/pay/insert/{orderId}

***Search for payments by customer code***
/pay/findByOrderClientID/{clientId}

***Deleting a payment by payment id***
/pay/delete/{payId}

**Search for payments by order code***
/pay/findByOrder

{
    "order":{
        "id":{orderId}
    }
}
```

*api-getway
```
Eureka Server
```

*api-getway
```
LoadBalancer
```


## Authors

Contributors names and contact info

ex. Roberto Recinos  
ex. [@Robero0590](http://www.linkedin.com/in/roberto-recinos-956a8596)

## Version History

* 0.0.1-SNAPSHOT
    * Initial Release

## License

Open source program
