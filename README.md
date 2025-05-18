🚀 Java Project - Dockerized
This project is Dockerized and can be easily built and executed using Docker or Maven.

📦 Requirements
Docker installed on your machine

Java and Maven installed (for running locally without Docker)

🛠️ Run Tests Using Maven
From the project root directory:
mvn clean test -PfullSuite

🐳 Build the Docker Image
From the project root directory (where the Dockerfile is located), run:
docker build -t java-app .

Run Tests Inside Docker Container
After building the Docker image:

docker run --rm java-app
This will execute the tests using the CMD ["mvn", "test"] defined in your Dockerfile.



