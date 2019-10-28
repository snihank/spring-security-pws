# spring-security-pws

## Overview
This project is a backend application written in Java using spring boot. This is mainly a dummy online retail store, comprised of products as models, sales tax and processing fee, and invoice view model. In addition, this application is wrapped with spring security where different end points are authenticated and authorized. Besides, it is deployed using pivotal web services. The following url is the deployed app:

* https://capstone-service-fearless-hyena.cfapps.io


## Tools and Teachnologies
* spring boot
* spring cloud
* spring security
* spring jdbc template
* java 303
* jUnit
* mockito
* swagger api
* pivotal web services

## Download
To test or use this application, open your terminal in Mac or command prompt/git bash in Windows and type the following: 

* git clone https://github.com/snihank/spring-security-pws.git

## Postman
Open postman and try the following end points with "localhost:8081":
* username: adminUser, password: admin, 
* username: managerUser, password: manager
* username: staffUser, password: staff

* Login endpoint: /login
* Logout endpoint: /logout, /allDone

* GET:
/console, /console/{id}, /game, /game/{id}, /tshirt, /tshirt/{id}

* POST: Only Manager and Admin
/console, /game, /invoice, /tshirt

* PUT: Staff, Manager and Admin
/console, /game, /tshirt

* DELETE: Admin
/console/{id}, /game/{id}, /tshirt/{id}







