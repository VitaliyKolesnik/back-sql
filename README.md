[![Build Status](https://travis-ci.org/VitaliyKolesnik/back-sql.svg?branch=develop)](https://travis-ci.org/VitaliyKolesnik/back-sql)
# back-sql

To run the application in a vagrant virtual machine, execute the command in the
console from the project root:
```sh
$ vagrant up
```
You should have free 8080 port on your host.
If you want run the application on enother port just find raw in Vagrantfile:
```sh
config.vm.forward_port 8080, 8080
```
and change second param:
```sh
config.vm.forward_port 8080, another_port
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
