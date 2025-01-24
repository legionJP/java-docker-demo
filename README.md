#
#  Docker Guide

-   # Installation
    ```markdown
    1. Check the virtualization , kvm-ok
    2. sudo apt update 
    3. sudo apt-get install ./docker_deb(package)
    4. or use dpkg-i /path/to/file/docker.deb
    ```

### 1. Docker Intro

### 2. Virtualization and Containerization

### 3. Docker SetUP

### Running the First Container 

### Docker Commands 

#### Docker Architecture 

### Running JDK Docker Container 

### Spring Boot App Packing and Running on Docker 

### Docker File for Docker Image 

### Spring Web App with Postgres 

### Docker Compose

### Running Multiple Docker Containers 

### Docker Volumes 
# Java Docker Image

## Steps for java Docker Image project

-1 . put the  mvn package---  in pom.xml 
~~~
<build>
# <finalName>rest-demo</finalName>
~~~


#  Commands

```
#2. java mvn package
#3. java -jar traget/rest/-demo.jar
#( docker start openjdk:25-jdk)
#4. docker run -it openjdk:25-jdk -- run image
#5. docker run -it java/rest-demo -- run the container
#6. commit the container changes--
#7. docker commit --change='CMD ["java", "-jar", "/tmp/rest-demo.jar"]' name-of-container java/rest-demo:v1
#8. docker run -p 8080:8080 java/rest-demo:v1
```
