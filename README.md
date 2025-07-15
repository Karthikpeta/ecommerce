# 🛒 Spring Boot E-Commerce REST API

A simple and modular **Spring Boot** based **E-Commerce backend API** that allows customers and admins to interact with products, manage carts, place orders, and authenticate securely using **JWT tokens**.

---

## 📌 Table of Contents

- [📦 Features](#-features)
- [🧰 Technologies Used](#-technologies-used)
- [📁 Project Structure](#-project-structure)
- [⚙️ How to Run](#️-how-to-run)
- [📄 API Endpoints](#-api-endpoints)
- [🔐 User Roles](#-user-roles)
- [💡 Notes](#-notes)
- [🙋‍♂️ Author](#-author)
- [📃 License](#-license)

---

## 📦 Features

- 🔐 User authentication with JWT
- 👥 Role-based access control (Customer & Admin)
- 📦 Product listing with optional search
- 🛒 Add to Cart / View Cart / Remove from Cart
- 📤 Place Orders from Cart
- 🧾 Order History
- 🧪 In-memory H2 database (easy to test)

---

## 🧰 Technologies Used

- Java 17+
- Spring Boot
- Spring Security
- Spring Data JPA
- H2 Database
- JWT (JSON Web Token)
- Maven

## 📁 Project Structure

src/
├── main/
│ ├── java/com/example/ecommerce/
│ │ ├── controller/ # REST APIs
│ │ ├── model/ # Entity classes
│ │ ├── repository/ # Spring Data JPA Repositories
│ │ ├── service/ # Business logic (optional)
│ │ ├── config/ # Security / JWT config
│ │ └── EcommerceApplication.java
│ └── resources/
│ ├── application.properties



---

## ⚙️ How to Run

### 🧱 Prerequisites

- Java 17+
- Maven
- Git
- Eclipse or IntelliJ

### ▶️ Run the App

1. Clone the project:

```bash
git clone https://github.com/Karthikpeta/ecommerce.git
cd ecommerce

2.Open the project in Eclipse or IntelliJ

3.Run the main class:
com.example.ecommerce.EcommerceApplication.java

4.Access the app at
http://localhost:8080

5.Access H2 Console (for dev testing):
http://localhost:8080/h2-console

JDBC URL: jdbc:h2:mem:testdb
Username: sa
Password: (leave empty)


📄 API Endpoints
🔑 Auth
Method	Endpoint	Description
POST	/auth/signup	Register a new user
POST	/auth/login	Login & get JWT token

📦 Product Management
Method	Endpoint	Role Required	Description
GET	/products	Any	List/search products
POST	/products	Admin	Add a new product
PUT	/products/{id}	Admin	Update product by ID
DELETE	/products/{id}	Admin	Delete product by ID

🛒 Cart Management
Method	Endpoint	Description
POST	/cart/add	Add item to user's cart
GET	/cart/{userId}	Get user's cart items
DELETE	/cart/{itemId}	Remove item from cart

📤 Order Management
Method	Endpoint	Description
POST	/orders/{userId}	Place an order
GET	/orders/{userId}	Get user’s order history

🔐 User Roles
Role	Permissions
CUSTOMER	Can view products, manage cart, place orders
ADMIN	Can add/update/delete products

🙋‍♂️ Author
Karthik Peta
