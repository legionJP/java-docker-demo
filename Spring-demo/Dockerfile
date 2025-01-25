FROM openjdk:22-jdk

# source and dest to add app file
ADD target/rest-demo.jar rest-demo.jar 

ENTRYPOINT [ "java", "-jar", "/rest-demo.jar" ]