# Java Spring Json Local Server

## Description

This is a simple Java Spring Json Local Server.
It uses json file as a database.

## Requests

### Get all users
```http request
GET http://localhost:8080/api/v1/team-members
```

### Get user by id
```http request
GET http://localhost:8080/api/v1/team-members/{id}
```

### Create user
```http request
POST http://localhost:8080/api/v1/team-members
Content-Type: application/json

{
  "name": "John",
  "surname": "Doe",
  "middleName": "K",
  "role": "Developer",
  "specialization": "Backend",
  "hiringDate": "2023-01-01"
}
```

### Update user
```http request
PUT http://localhost:8080/api/v1/team-members/{id}
Content-Type: application/json

{
  "name": "John",
  "surname": "Doe",
  "middleName": "K",
  "role": "Developer",
  "specialization": "Backend",
  "hiringDate": "2023-01-01"
}
```

### Delete all users
```http request
DELETE http://localhost:8080/api/v1/team-members
```

### Delete user
```http request
DELETE http://localhost:8080/api/v1/team-members/{id}
```

### Update hiring date for user
```http request
PUT http://localhost:8080/api/v1/team-members/hiring/{id}

2023-12-02
```

### Update role for user
```http request
PUT http://localhost:8080/api/v1/team-members/role/{id}

Developer
```

### Update specialization for user
```http request
PUT http://localhost:8080/api/v1/team-members/spec/{id}

Mobile Developer
```