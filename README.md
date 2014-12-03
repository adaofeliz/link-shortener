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

Short Link redirect to Original URL
--------------
http://localhost:8080/[shorturi]


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

[1]: ./.screenshots/swagger_ui.png

