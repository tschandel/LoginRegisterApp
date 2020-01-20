### Installation Setps

#### Pre-Requisites on Local Machine
* Java 1.8
* Maven
* Mysql running on port 3306


#### Installation

* Once Installation is done follow following steps:
    * Set the properties into the application.properties as:
        * spring.datasource.username=(set your Mysql UserName)
        * spring.datasource.password=(set your Mysql password)

#### Steps to Run
* Run you project with mvn spring-boot:run and launch from browser with [http://localhost:8080/]

#### Note
* /api/createUser is only api which can be accessed without login as it has been permitted in Spring Security. 
* /login is done using Spring Security (Form Based), and same has been added to Swagger as well. So login can be done from      designed form and swagger both.
* Already 1 user has been created with username - user1@gmail.com and password - 123 (in script it is written in Bcrypted Form)
* In Response Body of /login api, we are getting view code of directed page. As /login has been handled by Spring, and defaultSuccessUrl has been set to /api, thats why we are getting view code in response.
#### Documentation
* Once the app comes up you will find the documentation at http://localhost:8080/swagger-ui.html
