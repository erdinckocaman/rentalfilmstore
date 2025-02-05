
# RENTAL FILM STORE PROJECT

The project is structured into four key modules, each serving a distinct role in organizing functionality and supporting the overall system. Three of them are support modules which define the general project structure and some common functionality. The other module is the actual service application which implements the required business functions.

## MODULES

### store-commons-bom
This is the "bill of materials" module listing all the external and internal libraries the project depends on. If a module requires an internal or external library, it defines the Maven group/artifact/version information in this module. Later, that module defines the required library in its own POM file without specifying its version information, as the version information is already managed by the "bom" module. By doing this, project dependencies can be controlled from a single point.

### store-commons-parent
This module defines default dependencies/plugins to be used by other modules. By defining the required module in the parent project, other modules do not need to define or customize the configuration parameters again.

### store-commons-lib
This module implements some common functionality other modules of the project might use. This way, we may save development time and increase software quality.

### store-core
This is the main service of the project. It mostly implements backend API requirements. Other modules can call API methods this module has been built.

The `core` module inherits from the `store-commons-parent` module and has all the features the parent project has.

The `core` module has four properties files to get configuration parameters from:

- `application.properties` - All common parameters defined here.
- `application-dev.properties` - Parameters used while developing the service.
- `application-prod.properties` - Parameters used on production servers.
- `application-test.properties` - Parameters active when running unit tests.

Codes of the `core` service are divided into these main packages below:

#### commons
Constants/error codes used by the service.

#### configuration
All configuration-related classes are here. Also, most of the dependency injection definitions reside here. I tried to avoid defining Spring injection annotations like `@Autowired` on business objects as much as possible. By doing this, objects implementing business functionality become free of Spring-dependent annotations, making it easier to test and use business objects in other contexts.

#### domain
Business logic-related objects are here.

#### repository
Database objects are placed here. For now, there is no direct database functionality, but some repository classes are defined for scaffolding and simulating database interaction.

#### resources
REST interfaces are defined here. There are two of them:
- One implements business logic named `RentalFilmsResource`.
- The other is a status resource that provides information about the application environment, configuration, version, etc.

`RentalFilmsResource` is only implemented for "Regular" films as this is an example project. It also receives `codes` as parameters, used for both identifying films and the film rental process. In short, `codes` are something used for identifying things, but it is not a real implementation.

REST methods return their results as a `StoreHttpResponseEntity` instance. This way, the frontend or other applications using this service can expect a standard structure of return data. Error codes are also returned as a part of this structure.

#### services
Service objects implementing interfaces exposed over REST are under the `services` package.

#### spring
Spring-specific classes are located here. I implemented a handler to handle exceptions occurring in the service. By doing this, I could customize error handling by giving detailed information like error codes without displaying unnecessary information like stack traces to users.

In addition to this, Swagger-UI is defined and accessible over the path `/swagger-ui/index.html`.

There are some other folders:

- **docs**: Some notes about the module which are useful while developing. Also, there is a Postman collections file to test the application quickly.
- **deploy**: Deployment configuration files like Dockerfiles, Kubernetes YAMLs, and Flyway configurations. These files are required while deploying the service using CI/CD servers like Jenkins.

## BUILDING

Building steps are as follows:

1. Build `store-commons-bom` by issuing the command:
   ```sh
   mvn clean install
   ```
   under the folder `store-commons-bom`.

2. Build `store-commons-parent` by issuing the command:
   ```sh
   mvn clean install
   ```
   under the folder `store-commons-parent`.

3. Build `store-commons-lib` by issuing the command:
   ```sh
   mvn clean install
   ```
   under the folder `store-commons-lib`.

4. Build `store-core` by issuing the command:
   ```sh
   mvn clean package spring-boot:repackage
   ```
   under the folder `store-core`.

## RUNNING

A single JAR file is built under the `target` folder of the `store-core` module. Run the command below:

```sh
java -Dspring.profiles.active=prod -jar store-core-1.0.0-SNAPSHOT.jar
```

This should start the service, and you can access it via a browser by navigating to:

[http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

This is the Swagger-UI page listing all REST interfaces. You can either try the APIs here, or you can import the Postman collections under the `docs` folder and run them.

### Example Test Requests

#### Renting Films

```sh
curl --location --request POST 'localhost:8080/rentalfilms/rent' \
--header 'Content-Type: application/json' \
--data-raw '{
    "codes" : ["1", "2"],
    "days": 2
}'
```

#### Returning Films

```sh
curl --location --request POST 'localhost:8080/rentalfilms/return' \
--header 'Content-Type: application/json' \
--data-raw '{
    "codes" : ["1", "2"]
}'
```

