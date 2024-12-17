FROM openjdk:25-jdk

#Add the source and dest 
ADD target/rest-demo.jar rest-demo.jar

# create the image

ENTRYPOINT [ "java", "-jar", "/rest-demo.jar" ]

#build in terminal
# docker build -t java/rest-demo:v1 . # (for same dir)
