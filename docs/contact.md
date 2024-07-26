# Contact API Spec

## Create Contact

Endpoint : POST /api/contacts

Request Header :

- X-API-TOKEN : Token (Mandatory)

Request Body :

```json
{
  "firstName" : "Aidil Adam",
  "lastName" : "Adam",
  "email" : "aidil@example.com",
  "phone" : "0899889998"
}
```

Response Body (Success) : 

```json
{
  "data": {
    "id" : "random-string",
    "firstName": "Aidil Adam",
    "lastName": "Adam",
    "email": "aidil@example.com",
    "phone": "0899889998"
  }
}
```

Response Body (Failed) :

```json
{
  "errors" : "Email format invalid, phone formar invalid, ..."
}
```

## Update Contact

Endpoint : PUT /api/contacts/{idContact}

Request Header :

- X-API-TOKEN : Token (Mandatory)

Request Body :

```json
{
  "firstName" : "Aidil Adam",
  "lastName" : "Adam",
  "email" : "aidil@example.com",
  "phone" : "0899889998"
}
```

Response Body (Success) :

```json
{
  "data": {
    "id" : "random-string",
    "firstName" : "Aidil Adam",
    "lastName" : "Adam",
    "email" : "aidil@example.com",
    "phone" : "0899889998"
  }
}
```

Response Body (Failed) :

```json
{
  "errors" : "Email format invalid, phone format invalid, ..."
}
```

## Get Contact

Endpoint : GET /api/contacts/{idContact}

Request Header :

- X-API-TOKEN : Token (Mandatory)

Response Body (Success) :

```json
{
  "data": {
    "id" : "random-string",
    "firstName" : "Aidil Adam",
    "lastName" : "Adam",
    "email" : "aidil@example.com",
    "phone" : "0899889998"
  }
}
```

Response Body (Failed, 404) :

```json
{
  "errors" : "Contact is not found"
}
```

## Remove Contact

Endpoint : DELETE /api/contacts/{idContact}

Request Header :

- X-API-TOKEN : Token (Mandatory)

Response Body (Success) :

```json
{
  "data" : "OK"
}
```

Response Body (Failed) :

```json
{
  "errors" : "Contact is not found"
}
```
