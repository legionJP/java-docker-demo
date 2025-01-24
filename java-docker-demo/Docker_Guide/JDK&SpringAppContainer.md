#
# Running JDK Docker Container 
```
- docker search openjdk
- docker pull openjdk:22-jdk
- docker run openjdk:22-jdk
```
# Running the docker continuosly 
```
- docker run -dit openjdk:22-jdk # detachable in backgorund
- docker run -it openjdk:22-jdk  # iteractive in foreground

(-it will open the jshell to run the commands inside the container, /exit)
```
# Running the Application in Conatiner 

-   ### [Spring Application ](/src/main/java/com/jp/demo/)

-  ### [Jar File](/rest-demo.jar)

# Putting jar file in container 
```
    - docker ps
    - docker exec "container_name OR ID" (execute it)
    [it will list all the folder lists in it ]

- docker cp {source-target/rest-demo.jar} {destfolder: coantainer_name:/tmp}
- ls /tmp
```

# making the image of the Container 
```
    - docker commit "Conatiner_name" "{image_name- jp/rest-demo:v1}"  #create the image

    - docker images 
    - docker run jp/rest-demo:v1 (# it will run in the jshell as it is default command)
```
#### change the default command for the container 
```
- docker commit --change='CMD ["java", "-jar", "/tmp/rest-demo.jar"]  "Conatiner_name" jp/rest-demo:v2  (#v2 image ) 

 -- It will be running on the port 8080 of the docker network 
```

### Exposing the port number 

- docker run -p 8080:8080 jp/rest-demo:v2

