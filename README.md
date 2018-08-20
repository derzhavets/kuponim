# Kuponim project / server

Spring-boot based backend part of the coupons system, which allows companies to issue coupons for a certain services or goods, and customers to buy the coupons.


## Project structure

- Controllers - layer to handle incoming and outgoing REST requests
- Services - layer to handle business logic and connect between REST endpoints and database services
- Dao - layer to handle database logic and errors
- Repositories - connection to the database


## Installation

1. Clone this repository to your local folder
2. Import as Maven project
3. Install Maven dependencies
4. Start MySQL service and create database called "kuponim"
5. In the application.properties configure datasource according to your MySQL configuration
6. In the application.properties change property spring.jpa.hibernate.ddl-auto to "create" and start application. This will create all the necessary database data structure
7. In the application.properties change property spring.jpa.hibernate.ddl-auto back to "update" and start application
