# Purpose 

This is a standalone microservice that contains bits and pieces of code from the MERLIN_SOS_ENDPOINT and the MERLIN_Microservice_POC.  

# Project Structure

* `src/main/java` - the service source code

This is a `Spring Boot` application which should be deployed locally. I am running it in Spring Tool Suite 3 so that I can run the debugger.

## Configuration

Right now the application has a hard-coded value for the kafka server.  Kafka should be running on port 9092.

### In order to run Kafka locally, download the latest Kafka release and unzip it in its own directory:

```shell
tar -xzf kafka_2.13-3.2.1.tgz
cd kafka_2.13-3.2.1
```

Start zookeeper service:

```shell
bin/zookeeper-server-start.sh config/zookeeper.properties
```

Start the Kafka broker service:

```shell
bin/kafka-server-start.sh config/server.properties
```

### In order to run Kafka in a Docker container:

cd to your project root directory and run:

```shell
docker-compose -f src/main/resources/simple-docker-kafka.yml up
```

### Kafka Troubleshooting (Substitute for Kafka UI)

In order to see kafka topics, install the "Tools for Apache Kafka" by Jeppe Andersen extension in VS Code.

  
## Dependencies

The project uses these modules:

* `spring-boot-starter-actuator` - This module allows us to monitor the service health and metrics through `HTTP`.
* `spring-kafka` - a Spring library for connecting to `Kafka` and using it in a Spring-like fashion.

# Build

To build the project:

```shell
mvn clean install
```


# Deployment
## Local Development
Just right click on HelloKafkaApplication.java in the Project Explorer view and choose either Run As or Debug As Spring Boot App.

# Testing
In order to test the application run the following curl command from git bash:

```shell
curl -v localhost:8080/hello -H 'Content-Type:application/json' -d '{"name": "Elrond", "role": "Elf Lord"}'
```

This will send the json content to the SosEndpointResource.java which is a RestController that expects a post request.



