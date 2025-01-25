# Docker compose 

- go to in th app directory

- docker-compose up --build

#### Need to give the config file : named docker-compose 

- #### [Docker Compose](/java-docker-demo/dockerpostgres/docker-compose.yml)
```yml
version: '3.7'

# Here we have to services means want to run two cotainer  app and postgres 

services:
  app:
    build: .
    ports:
      - "8080:8080"
    volumes:
      - .:/app
    environment:
      - name=value
  postgres:
    image: postgres:latest
    environment:
       POSTGRES_USER: jp
       POSTGRES_PASSWORD: 1234
       POSTGRES_DB: Spring-POSTGRES_DB
    ports:
      - "5432:5432"

```
- docker-compose up --build 
##### It will create the container images 
- docker images 
- docker compose down 

# Solving the Connection Issue with docker and  container services 

-   ### 1. Chnage the application Properties 
```html
    
    # Postgres 
    spring.datasource.url= jdbc:postgresql://postgres:5432/Spring-DB
    spring.datasource.username=jp
    spring.datasource.password=ThisisMyDB@23
    spring.datasource.driver-class-name=org.postgresql.Driver
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
  
```

-   ### 2. Run the Container on same Network (bridge them )
    - docker network ls 
    ```yml
    services:
        app:
            build: .
            ports:
            - "8080:8080"
            networks: my-network    
        
    ```



