# Home assignment 

Create a RESTful system using Java and Spring Boot which exposes data published by the Open FDA (Food and Drug Administration) 
# Requirements 
The service APIs must fulfill the following requirements: 
As a user I would like to search for drug record applications submitted to FDA for approval 
# Use the follow API: 
https://open.fda.gov/apis/drug/drugsfda/how-to-use-the-endpoint/ 
# Search by 
- FDA Manufacturer name 
- Optional FDA brand name 
- Results are presented in pages 
- As a user I would like to store specific drug record applications details in my system ○ Create and persist an entry for a given drug record application 
- Application number (as id) 
- Manufacturer name 
- Substance name 
- All product numbers 

# As a user I would like to see the drug record applications stored in the system ○ Provide read API 
- Your code should be “production ready” 
- Demonstrate Clean Code behavior towards code using TDD, BDD, SOLID, etc. 
- Provide a README on how to build, test and run the system locally 
- Document the endpoints of your API either in Swagger or in README file 
- Provide a storage solution for persisting data used in the API 




_______________________________________________________________________________________________________________________

#solution

This solution is using Spring Boot on which the CQRS is implemented and Event sourcing patterns are implemented using Axon.
Project is divided into several modules:
- fdarecord-domain contains the dao layer and shared events
- fdarecord-api service for communicating with FDA API 
- fdarecord-command covers the CUD operations. 
- fdarecord-query has the read operations. 

The project is dockerized and we can run it by the docker-compose up

Postman collection fda.postman_collection.json is located in src/main/resources



