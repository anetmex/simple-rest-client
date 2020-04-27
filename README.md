# Simple Spring boot REST client

## 1 Description
This app is for testing basic REST commands:
- GET
- POST
- PUT
- DELETE

## 2 Used technologies

- Java 11
- Spring Boot

## 3 Quick RUN the app:

```
git clone git@github.com:NikCooler/simple-rest-client.git

cd simple-rest-client

java -jar client-1.0-app.jar
```

Go by this URL `http://localhost:8085/users/1`.
If everything is OK you will see JSON object:
```
{
    "id" : 1,
    "name" : "Nikolas"
}
```

## 4 Clone, Build, Modify and Run the application

```
git clone git@github.com:NikCooler/simple-rest-client.git

cd simple-rest-client

mvn clean install

cd client/target

java -jar client-1.0-app.jar
```

## 5 Endpoints

The app uses server port `8085` but it's possible to change it in the `client/src/main/resources/application.properties`.
Base path is `http://localhost:8085` by default.


- Create user
```
POST   http://localhost:8085/users/create
{
    "id" : 2,
    "name" : "Nikitos"
}
```

- Get user by ID
```
GET    http://localhost:8085/users/1
```

- Get all users
```
GET    http://localhost:8085/users/all
```

- Update user
```
PUT    http://localhost:8085/users/update
{
    "id" : 2,
    "name" : "Nikitos the best"
}
```

- Delete user by ID
```
DELETE    http://localhost:8085/users/1
```
