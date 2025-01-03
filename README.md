#  
# Java Docker Image

## Steps for java Docker Image project

-1 . mvn package--- , in pom.xml put

- 2.	<build>
```
# <finalName>rest-demo</finalName>
```
-3. Commands
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
