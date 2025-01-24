#
#  Docker Guide

### 1. [Docker Intro](/Docker_Guide/DockerIntro.md)

### 2. [Virtualization and Containerization](/Docker_Guide/Virtualization_Container.md)

### 3. [Docker Set Up](/Docker_Guide/DockerSetup.md) 

### 4. [Running the First Container](/Docker_Guide/RunningContainer.md) 

### 5. [Docker Commands](/Docker_Guide/RunningContainer.md)

#### 6. [Docker Architecture](Docker_Guide/Docker_Arch.md)

### 7. [Running JDK Docker Container](/Docker_Guide/JDK&SpringAppContainer.md)

### 8. [Spring App Packaging & Running on Docker Container](Docker_Guide/JDK&SpringAppContainer.md)

### 9.  [Docker File for Docker Image]()

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
