RENTAL FILM STORE PROJECT

Project consists of four modules. Three of them are support modules which defines general project structure and some common functionality.
Other module is actual service application which implements required business functions.

MODULES

- store-commons-bom
This is "bill of materials" module listing all the external and internal libraries project depends on. If a module requires an internal
or external library it defines maven group/artifact/version information in this module. Later, that module defines required
library in its own pom file without specifying its version information as version information is already managed by "bom" module.
By doing this, project dependencies can be controlled from a single point.

- store-commons-parent
This module defines default dependencies/plugins to be used by other modules. By defining required module in parent project,
other modules does not need to define or customize the configuration parameters again.

- store-commons-lib
This module implements some common functionality other modules of the project might use. This way we may save development time
and increase the software quality

- store-core
This is main service of the project. It mostly implements backend API requirements. Other modules can call API methods this module has been built.
"core" module inherits from "store-commons-parent" module and has all the features parent project has.
"core" module has 4 properties file to get configuration parameters from. These are;

application.properties
All common parameters defined here

application-dev.properties
Parameters used while developing the service

application-prod.properties
Parameters used on production servers

application-test.properties
Parameters active when running unit tests

Codes of "core" service divided into these main packages below;

- commons
Constants/error codes used by the service

- configuration
All configuration related classes are here. Also, most of the dependency injection definitions reside here. I tried to
avoid defining Spring injection annotations like "Autowired" on business objects as much as possible. By doing this,
objects implementing business functionality becomes free of Spring-dependent annotations and that makes it easier to test and
use business objects on other contexts.

- domain
Business logic related objects are here.

- repository
Database objects is placed here. For now, there is no direct database functionality but some repository classes defined for
scaffolding and simulating database interaction.

- resources
REST interfaces defined here. There are two of them. One is implementing business logic named "RentalFilmsResource". The other
is status resource which gives information about the application environment, configuration, version etc.
"RentalFilmsResource" is only implemented for "Regular" films as this is an example project. It also receives "codes" as
a parameters, and it is used for both identifying film and film rental process. In short "codes" are something used for
identifying things, it is not a real implementation.
REST methods return its result as a "StoreHttpResponseEntity" instance. This way frontend or other applications using this service
can expect a standard structure of return data. Error codes are also returned as a part of this structure.

- services
Service objects implementing interfaces exposed over REST is under "services" package.

- spring
Spring specific classes are located here. I implemented a handler to handle exceptions occurring in the service. By doing this, I could
customize error handling by giving detailed information like error code without displaying unnecessary information like stack trace to user.

In addition to this, swagger-ui is defined and accessible over path "/swagger-ui/index.html".

There are some other folders, these are;
- docs
    Some notes about the module which is useful while developing. Also there is postman collections file to test the application quickly.
- deploy
    Deployment configuration files like Dockerfiles, Kubernetes ymls, Flyway configurations. These files is required while deploying
    the service using CI/CD servers like Jenkins

BUILDING

Building steps are as follows;

- Build "store-commons-bom" by issuing command "mvn clean install" under folder "store-commons-bom"
- Build "store-commons-parent" by issuing command "mvn clean install" under folder "store-commons-parent"
- Build "store-commons-lib" by issuing command "mvn clean install" under folder "store-commons-lib"
- Build "store-core" by issuing command "mvn clean package spring-boot:repackage" under folder "store-core"

RUNNING

Single jar file are built under "target" folder of "store-core" module. Run the command below;

java -Dspring.profiles.active=prod -jar store-core-1.0.0-SNAPSHOT.jar

This should start the service and access it over browser by navigating to http://localhost:8080/swagger-ui/index.html.
This is swagger-ui page listing all REST interfaces. You either try the APIs here, or I attached Postman collections
under "docs" folder, you can import collections and run them too.

Example test requests;

Renting films

curl --location --request POST 'localhost:8080/rentalfilms/rent' \
--header 'Content-Type: application/json' \
--data-raw '{
    "codes" : ["1", "2"],
    "days": 2
}'

Returning films

curl --location --request POST 'localhost:8080/rentalfilms/return' \
--header 'Content-Type: application/json' \
--data-raw '{
    "codes" : ["1", "2"]
}'