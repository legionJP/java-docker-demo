# Add the Data 

```java

    @RequestMapping("/addStudents")
        public void addStudents(){
            Student s = new Student();
            s.setName("Raj");
            s.setAge(21);
            repo.save(s);
        }
```
- docker compose down 
- docker compose up --build  
##### Before this use the "mvn clean package"

- But after building and saving students details using the /addStudents , when we will restart the build the data we be lost to solve this we have to use the volumes storage on the local 

```yml

services:

    postgres:
        image: postgres:latest
        environment:
        POSTGRES_USER: jp
        POSTGRES_PASSWORD: 1234
        POSTGRES_DB: Spring-POSTGRES_DB
        ports:
         - "5432:5432"
        networks:
            - my-network
        volumes:
            - postgres-s-data:/var/lib/postgresql/data #local storage: docker storage 

    networks:
        my-network:
        driver: bridge
    
    volumes:
        postgres-s-data:  # name of the storage

```


