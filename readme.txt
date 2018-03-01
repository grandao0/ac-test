# README #

### What is this repository for? ###

Quick summary

   + Build a Restful service using JAX-RS to perform CRUD operations on a Product resource using Image as a sub-resource of Product.
   + Build API classes to perform operations such as:

		 - Create, update and delete Products
		 - Create, update and delete Images
         - Get all products excluding relationships (child products, images)
		 - Same as above using specific product identity
         - Get all products including specified relationships (child product and/or images)
		 - Same as above using specific product identity
         - Get set of child products for specific product
         - Get set of images for specific product

   + Build JPA/Hibernate classes using annotations to persist objects in database

* Version 1.0a

* [avenuecode](https://bitbucket.org/grandao0/avenuecode)

### How do I get set up? ###

* Summary of set up:

         + Maven must be used to build, run tests and start the application
         + The application must start with a Maven command: mvn spring-boot:run
		 + The application must have a stateless API and use a database to store data
         + An embedded in-memory database is used: H2
         + The database and tables creation should be done by Maven or by the application


* Maven POM Configuration

* Packaging:

		 - jar


* Parent:

		 - spring-boot-starter-parent
		 - version 1.5.10.RELEASE


* Dependencies:

         - spring-boot-starter-data-rest
		 - spring-boot-starter-data-jpa
		 - spring-boot-starter-jersey
		 - spring-boot-starter-web
		 - spring-boot-starter-test
		 - spring-boot-devtools
		 - h2
		 - springfox-swagger2
		 - springfox-swagger-ui


* Plugins:

		 - spring-boot-maven-plugin
		 - maven-jar-plugin


* Database configuration:

         + H2 in-memory database


* How to run tests:

		 + Before running the tests, choose the test profile by changing the value of spring.profiles.active in the application.properties file to test (spring.profiles.active=test)
         + The tests must be started with the Maven command: mvn test


* How to compile and run from a jar file:

		 + Before compiling the application, choose the desired profile (dev / prod) by changing the value of spring.profiles.active in the application.properties file
		 + To compile the application in a .jar file, use the Maven command: mvn package
		 + An executable jar named ac-test-1.0a.jar will be created in the /target root folder of the project
		 + To run the application, use the Java command: java -jar ac-test-1.0a.jar in the file mentioned above


* How to run the application directly through Maven:

		 + Before running the application, choose the desired profile (dev / prod) by changing the value of spring.profiles.active in the application.properties file
         + The application must start with a Maven command: mvn spring-boot:run


* Example of calls:

		 + After the application is running, open the browser and type http://localhost:9091/swagger-ui.html for dev profile or http://localhost:9090/swagger-ui.html for prod profile
		 + Swagger UI let's you make calls easily by choosing the desired Operations for each Entity in the most intuitive and easy way
		 + Choose the Image Resource for Image operations
		 + Choose the Product Resource for Product operations


* Example of calls with CURL (https://curl.haxx.se) in dev profile (dev PORT: 9091 / prod PORT: 9090):

	Product calls:
		 + Creating a Product (with parent) with CURL:
			- curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{ \ 
			   "description": "Gamer Mouse Cable", \ 
			   "name": "Mouse Cable", \ 
			   "parent": { "id": 1 } \ 
			 }' 'http://localhost:9091/products'

		 + Creating a Product (without parent) with CURL:
			- curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{ \ 
			   "description": "Gamer Pad", \ 
			   "name": "Mouse Pad" \ 
			 }' 'http://localhost:9091/products'

		 + Updating a Product with CURL:
			- curl -X PUT --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{ \ 
			   "description": "Gamer Mouse", \ 
			   "name": "Mouse", \ 
			   "parent": { "id": 2} \ 
			 }' 'http://localhost:9091/products/1'

		 + Deleting a Product with CURL:
			- curl -X DELETE --header 'Accept: application/json' 'http://localhost:9091/products/4'

		 + Get all products excluding relationships with CURL:
			- curl -X GET --header 'Accept: application/json' 'http://localhost:9091/products/excluding'

		 + Get a Product excluding relationships using specific product identity with CURL
			- curl -X GET --header 'Accept: application/json' 'http://localhost:9091/products/excluding/2'
			
		 + Get all products including specified relationships with CURL:
			- curl -X GET --header 'Accept: application/json' 'http://localhost:9091/products'

		 + Get a Product including specified relationships using specific product identity with CURL:
			- curl -X GET --header 'Accept: application/json' 'http://localhost:9091/products/1'

		 + Get set of child products for specific product with CURL:
			- curl -X GET --header 'Accept: application/json' 'http://localhost:9091/products/childs/2'


	Image calls:
		 + Creating an Image with CURL:
			- curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{ \ 
			   "imageType": "tiff", \ 
			   "product": { \ 
				 "id": 1 \ 
			   } \ 
			 }' 'http://localhost:9091/images'

		 + Updating an Image with CURL:
			- curl -X PUT --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{ \ 
			   "imageType": "svg", \ 
			   "product": { \ 
				 "id": 3 \ 
			   } \ 
			 }' 'http://localhost:9091/images/1'

		 + Deleting an Image with CURL:
			- curl -X DELETE --header 'Accept: application/json' 'http://localhost:9091/images/4'

		 + Get set of images for specific product with CURL:
			- curl -X GET --header 'Accept: application/json' 'http://localhost:9091/images/products/1'

		 + Get all images excluding relationships with CURL:
			- curl -X GET --header 'Accept: application/json' 'http://localhost:9091/images'

		 + Get a Image excluding relationships using specific image identity with CURL:
			- curl -X GET --header 'Accept: */*' 'http://localhost:9091/images/16'


### Contribution guidelines ###

* Writing tests
* Code review
* Other guidelines

### Who do I talk to? ###

* Repository owner and admin

         cassio.babilonia at gmail.com

### Mention anything that was asked but not delivered and why, and any additional comments ###

First of all, I´m happy with how cool it was to build and run some of the best features from spring boot, always working with JSON as is one of the best open-standard file formats to work with massive JavaScript front-ends out there.
I had no time to build the front-end for this project but I would if I had more time as I know even a simple and poor one is better then none even though it was not asked in the test scenario.
I lack the experience when it comes to writing automated tests as you can see but I tried my best to make them cover what was most important as writing good tests is in my priority list of study (The company I work does not have automated tests in their codes).
I did what I was asked to and I hope you will like it!
Sincerely and hoping the best,

Cássio Simões.