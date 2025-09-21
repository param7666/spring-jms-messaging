---

## File: README.md

# spring-jms-messaging

> A Spring Boot JMS (ActiveMQ) example — send and receive messages using queues and topics. 

## Table of contents

* [Overview](#overview)
* [Features](#features)
* [Tech stack](#tech-stack)
* [Prerequisites](#prerequisites)
* [Getting started (local)](#getting-started-local)

  * [Clone repository](#clone-repository)
  * [Run ActiveMQ (Docker)](#run-activemq-docker)
  * [Build and run app](#build-and-run-app)
* [Configuration](#configuration)
* [How it works](#how-it-works)
* [Examples](#examples)
* [Project structure](#project-structure)
* [Contributing](#contributing)
* [License](#license)

## Overview

This repository demonstrates how to build a simple JMS-based messaging application using Spring Boot and ActiveMQ. It contains examples for:

* Sending and receiving text messages.
* Using queues (point-to-point) and topics (pub/sub).
* Basic configuration and tests for local development.

The project is intentionally simple and educational — suitable for learning or as a starter template for a portfolio project.

## Features

* Spring Boot integration with JMS (spring-boot-starter-activemq / spring-jms)
* Example producers and consumers
* Queue and topic examples
* Configurable broker URL and destination names
* Unit and integration test examples (optional)

## Tech stack

* Java (17+ recommended)
* Spring Boot
* Spring JMS
* Apache ActiveMQ (broker)
* Maven

## Prerequisites

* Java JDK 17 or above
* Maven 3.6+


## Getting started (local)

### Clone repository

```bash
git clone https://github.com/param7666/spring-jms-messaging.git
cd spring-jms-messaging
```

### Run ActiveMQ (Docker)

Run a local ActiveMQ broker using Docker:

```bash
docker run -d --name activemq -p 61616:61616 -p 8161:8161 rmohr/activemq:5.15.9
```

* Broker port: `61616`
* Web console: `http://localhost:8161` (default user/pass: `admin/admin` for this image)

> If you prefer to install ActiveMQ directly, download it from the Apache ActiveMQ site and follow their instructions.

### Build and run app

Build with Maven and run:

```bash
mvn clean package
java -jar target/<REPO_NAME>-0.0.1-SNAPSHOT.jar
```

Or run using the Spring Boot plugin:

```bash
mvn spring-boot:run
```

## Configuration

Application configuration is found in `src/main/resources/application.yml` or `application.properties`.

Example `application.properties` values:

```
spring.activemq.broker-url=tcp://localhost:61616
spring.activemq.user=admin
spring.activemq.password=admin
# Destination names (customize as needed)
app.jms.queue.sample=sample.queue
app.jms.topic.sample=sample.topic
```

## How it works

* **Producer**: builds a `TextMessage` and sends it to a configured destination (queue or topic) using `JmsTemplate`.
* **Consumer**: listens on the destination using `@JmsListener` and processes incoming messages.
* Spring Boot manages connection factory and listener container.

## Examples

See `EXAMPLES.md` for runnable usage examples showing how to send messages from the command line or tests.

## Project structure

```
src/
├── main/
│   ├── java/com/example/jms/
│   │   ├── config/            # JMS and broker configuration
│   │   ├── producer/          # Message producers
│   │   ├── consumer/          # Message listeners
│   │   └── Application.java   # Spring Boot main class
│   └── resources/
│       └── application.properties
└── test/
    └── java/                 # Unit and integration tests
```

## Contributing

See `CONTRIBUTING.md` for guidelines.

## License

This project is released under the MIT License — see the `LICENSE` file for details.

---

## File: EXAMPLES.md

# Examples & Usage

This file contains quick examples you can copy/paste to verify the JMS flow.

> Replace property values and destination names with those used in your `application.properties`.

## 1) Sending a message (programmatic example)

You can create a simple runner or service that autowires `JmsTemplate` and sends a text message:

```java
// Example pseudocode (place inside a @Component or @Service runner)
@Autowired
private JmsTemplate jmsTemplate;

public void sendSample() {
    String destination = "${app.jms.queue.sample}"; // or hardcode
    String body = "Hello from JMS!";
    jmsTemplate.convertAndSend(destination, body);
}
```

Run the application and call `sendSample()` from an ApplicationRunner to verify the broker receives the message.

## 2) Listening for messages (consumer example)

```java
@Component
public class SampleListener {
    @JmsListener(destination = "${app.jms.queue.sample}")
    public void receive(String text) {
        System.out.println("Received: " + text);
    }
}
```

## 3) Using topics for pub/sub

* Use a topic destination name and make sure listeners are configured appropriately. Topics broadcast messages to all subscribed consumers.

## 4) Testing locally

* Start the ActiveMQ Docker container as described in `README.md`.
* Run the application with `mvn spring-boot:run` and watch logs for producer/consumer lines.
* Optionally use the ActiveMQ web console at `http://localhost:8161` to inspect queues and messages.

---

## File: CONTRIBUTING.md

# Contributing

Thanks for your interest in contributing! Please follow these simple guidelines.

## How to contribute

1. Fork the repository.
2. Create a feature branch: `git checkout -b feat/your-feature`.
3. Commit changes with clear messages.
4. Open a Pull Request describing your changes.

## Coding style

* Follow standard Java naming conventions.
* Keep methods small and focused.
* Add JUnit tests for new logic.

## Issues

* Use GitHub Issues to report bugs or request features. Provide clear steps to reproduce.

## License

By contributing, you agree that your contributions will be licensed under the project license (MIT).

