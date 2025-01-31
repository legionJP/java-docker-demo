FROM openjdk:22-jdk

# source and dest to add app file
ADD target/student-app.jar student-app.jar 

ENTRYPOINT [ "java", "-jar", "/student-app.jar" ]

# Build the image
# docker build -t student-app .

# Docker File 2 


# FROM ubuntu:24.04

# RUN apt-get update
# RUN apt-get install -y postgresql
# RUN apt-get install -y postgresql-client
# RUN apt-get upgrade -y 
# RUN apt-get install -y openjdk-21-jdk

# WORKDIR  /my-app

# COPY target/my-app.jar  my-app.jar

# COPY main.sh main.sh

# RUN chmod +x main.sh

# COPY . . 

#COPY all files from current directory to docker image, add the dockerignore to ignore the unwanted files 


# ENTRYPOINT [ "java" , "-jar", "/my-app.jar"]

# Build the image
# docker build -t my-app .  
# this will choose the default Dockerfile for building the image
# docker build -f Dockerfile.dev -t myapp:dev .



# # attach the volume
# docker volume create myvol2
# docker volume inspect myvol2
# docker run -v myvol2:/app ubuntu:24.04

# Mount the volume

# docker run -d --name devtest -mount source=myvol2, target=/app nginx:latest

# docker execute 
# docker exec-it my-app /bin/bash
