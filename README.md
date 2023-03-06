# rick-and-morty-characteres-service
This project aims to provide information on a character from the famous television series "Rick and Morty", including his first appearance chapter and the list of each chapter in which he appears. The information is obtained through a RESTful API that exposes an endpoint to obtain the information of a specific character.

# Project details

The project is built using the hexagonal architecture, which allows the application layers to be clearly separated and promotes modularity. Additionally, unit tests have been included to ensure code quality and prevent bugs.


The project uses the following technologies:

# The project uses the following technologies:

- Spring Boot
- Java 17
- Gradle
- Docker
- Hexagonal architecture
- Unit testing with JUnit and Mockito

# Running the Docker image
To build the Docker image and run it, follow these steps:

1. Make sure you have Docker installed on your machine. If you don't have it, you can download it [here](https://www.docker.com/get-started).
2. Open a terminal at the root of the project.
3. Run the following command to build the Docker image:

```
docker build -t rick-and-morty-characteres-service .
```

4. Once the Docker image has been built, run the following command to run the image:

```
docker run -p 8070:8070 rick-and-morty-characteres-service
```

5. The app will now be available on: [http://localhost:8070/api/v1/rick-and-morty/search-character-appearance?name=birdperson](http://localhost:8070/api/v1/rick-and-morty/search-character-appearance?name=birdperson)


# Documentation with Swagger

The project includes Swagger3, a tool for documenting and testing RESTful APIs. Once the app is running, Swagger can be accessed via the following URL: [http://localhost:8070/swagger-ui/index.html](http://localhost:8070/swagger-ui/index.html)


# Conclusion

The hexagonal architecture allows the different layers of the application to be clearly separated, which makes the code easier to understand and promotes modularity. Unit tests and clear documentation, like Swagger, are effective ways to demonstrate strong technical skills in a recruiting process.