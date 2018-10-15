[![Build Status](https://travis-ci.org/VitaliyKolesnik/back-sql.svg?branch=develop)](https://travis-ci.org/VitaliyKolesnik/back-sql)
# back-sql

To run the application in a vagrant virtual machine, run the command in the
console from the project root:
```sh
$ vagrant up
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