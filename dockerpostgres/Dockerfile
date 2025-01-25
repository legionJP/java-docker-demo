FROM openjdk:22-jdk

# source and dest to add app file
ADD target/student-app.jar student-app.jar 

ENTRYPOINT [ "java", "-jar", "/student-app.jar" ]