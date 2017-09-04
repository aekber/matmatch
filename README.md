
# About

Matmatch technical assignment application by Ali Ekber Celik.This application developed under Ubuntu 16.04 x64 OS with Java 8.

The project is based on a small web service which uses the following technologies:

* Java 1.8
* Spring MVC with Spring Boot
* Database H2 (In-Memory)
* Maven
* Docker
* Swagger (as rest api endpoint ui)
* Eclipse


Go http://localhost:8080 address,then choose controller and endpoint.You can search user by their name and gender.Entered name is searched in first_name and last_name columns in table.

Also you can query the db by this link;

http://localhost:8080/v1/userinfo/search/name/search_name_here/gender/search_gender_here 


Docker repo link;

https://hub.docker.com/r/aekbercelik/repo1/


## Enter application folder

$> cd your_application_folder_path


## Build application from source

$> mvn clean install


## Docker build

$> sudo mvn package docker:build -Dmaven.test.skip=true


## Docker run image

$> sudo docker run -p 8080:8080 -t aekbercelik/repo1


## Docker create tag

$> sudo docker tag docker.io/aekbercelik/repo1:latest docker.io/aekbercelik/repo1:tag1


## Docker push

$> sudo docker push aekbercelik/repo1
