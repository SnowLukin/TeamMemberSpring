# Java Spring Json Local Server

## Description

This is a simple Java Spring Json Local Server.
It uses json file as a database.

## Requests

### Get all users
```http request
GET http://localhost:8080/api/team-members
```

### Get user by id
```http request
GET http://localhost:8080/api/team-members/{id}
```

### Create user
```http request
POST http://localhost:8080/api/team-members
Content-Type: application/json

{
  "firstName": "John",
  "lastName": "Doe",
  "middleName": "K",
  "role": "Developer",
  "specialization": "Backend",
  "hiringDate": "2023-01-01"
}
```

### Update user
```http request
PUT http://localhost:8080/api/team-members/{id}
Content-Type: application/json

{
  "firstName": "John",
  "lastName": "Doe",
  "middleName": "K",
  "role": "Developer",
  "specialization": "Backend",
  "hiringDate": "2023-01-01"
}
```

### Delete all users
```http request
DELETE http://localhost:8080/api/team-members
```

### Delete user
```http request
DELETE http://localhost:8080/api/team-members/{id}
```

