Link Shortener  - [![Build Status](https://travis-ci.org/adaofeliz/link-shortener.png)](https://travis-ci.org/adaofeliz/link-shortener)
==================
A simple shortener REST  service implementing the basic CRUD methods

Service API
--------------

Response	| Method	| Path	| Description
--------------- | ------------- | ----- | -------------
ShortLink	| POST	| /v1/api/link	| Create a new Short Link.
ShortLink	| GET	| /v1/api/link/{shortUri}	| Get JSON representation of a given short uri.
N/A	| PUT	| /v1/api/link/{shortUri} | Update the urginal url of a given Short Link.
N/A	| DELETE	| /v1/api/link/{shortUri}	| Delete a Short Link from the database.
ShortLink	List | GET	| /v1/api/link/all	| Get All Short Links in the database.

Swagger UI
--------------
![Swagger UI][1]

Database
--------------
* H2 Database Engine - Mode: Embedded and In-memory 
* Connect to production database - [Spring Boot Docs]

Installation
--------------
* Clone this project
```sh
git clone https://github.com/adaofeliz/link-shortener.git link-shortener
```

* Start Up the Application
```sh
cd link-shortener
mvn clean install
java -jar target/link-shortener.jar
```

Try it
--------------
- Now open your browser: http://localhost:8080/
- Short link redirect to original url: http://localhost:8080/[shorturi]

[1]: ./.screenshots/swagger_ui.png

[Spring Boot Docs]: http://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-sql.html#boot-features-connect-to-production-database
