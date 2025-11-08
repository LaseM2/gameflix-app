# GameFlix
GameFlix is a Spring Boot application for streaming movie data.

## Build & Run

### Using Docker
**Building the Docker image:**
docker build -t gameflix-backend . (dont leave out the dot!!!)
**Running the Container**
docker run -p 8080:8080 gameflix-backend
**Access the app**
http://localhost:8080
**Stop the container**
docker ps
docker stop <container-id>

**Run the Docker container detached (in the background) so it keeps running even if you close IntelliJ or the terminal (not sure if this works yet)**
docker run -d -p 8080:8080 --name gameflix-backend gameflix-backend
