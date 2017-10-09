# catalog-service

REST Endpoit for Product-Catalog service .Two methods exposed
#GET    -List all the products
#POST -  Add aproduct to catalog

What you Require :

1.Mysql database
2.gradle
3.J2ee 1.8

How to Build

#build
gradle build

#run
gradle bootrun


Invoking endpoints
curl -X POST -H 'content-type: application/json;charset=UTF-8'  -d '{"productName":"HD SetupBox", "usoc":"H23123", "regionCode":"Chicago","stateCode":"IL","isAvailable":"Yes"}' http://localhost:7070/catalog

curl -X GET http://localhost:7070/catalog
