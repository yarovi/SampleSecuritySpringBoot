### 📌 API Requests Documentation (test)

#### 📝 **1. Register a New User**
```http
POST http://localhost:8081/api/auth/register
Content-Type: application/json

{
  "username": "example",
  "firstName": "your first name",
  "lastName": "your last name",
  "email": "youremail@example.com",
  "password": "123"
}
```
📌 **Response Files:**
- `2025-03-26T150258.201.txt`
- `2025-03-26T120050.201.txt`
- `2025-03-26T115847.201.txt`
- `2025-03-26T115622.201.txt`

---

#### 🔑 **2. Login to Obtain a Token**
```http
POST http://localhost:8081/api/auth/login
Content-Type: application/json

{
  "username": "example",
  "password": "123"
}
```
📌 **Response Files:**
- `2025-03-26T150303.200.txt`
- `2025-03-26T120103.200.txt`
- `2025-03-26T115855.200.txt`
- `2025-03-26T115638.200.txt`

---

#### 🔐 **3. Access a Protected Resource with Basic Auth**
```http
GET http://localhost:8081/api/v1/data/hello
Authorization: Basic eWFtaToxMjM=
Content-Type: application/json
```
📌 **Response File:**
- `2025-03-26T150532.200.txt`

---

#### 🔍 **Generate Basic Auth Token (Base64 Encoding)**
```sh
# Encode "yami:123" in Base64
 echo -n "yami:123" | base64
```
📌 **Output:**
```
eWFtaToxMjM=
```

---
💡 **Notes:**
- The login request returns a token if authentication is successful.
- Use the encoded Base64 credentials for Basic Auth in the `Authorization` header.
- Store and handle credentials securely in production environments.

