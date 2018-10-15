[![Build Status](https://travis-ci.org/VitaliyKolesnik/back-sql.svg?branch=develop)](https://travis-ci.org/VitaliyKolesnik/back-sql)
# back-sql

To run database into vagrant virtual machine run:
```sh
$ vagrant up
```
Build a project with:
```sh
$ mvn clean package
```
And start the application using:
 ```sh
$ java -jar target/sql-1.0.jar
 ```
 
 To load data into the database use http request:
 ```sh
 POST /hello/contacts HTTP/1.1
 Host: localhost:8080
 Content-Type: application/json
 Cache-Control: no-cache
 body:
 {
 	"name": "whatyouwant"
 }
 ```