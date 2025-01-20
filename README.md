# Spring Boot Authentication and Authorization API

This is a Spring Boot project that provides authentication and authorization functionalities, including login, signup, JWT-based security, and role-based access control.

## Features

- User registration and login.
- JWT-based authentication for secure APIs.
- Role-based access control.
- Secure password storage using BCrypt.
- API endpoints for user details.

## Prerequisites

Before setting up the project, ensure you have the following installed:

1. **Java**: JDK 17 or later
2. **Maven**: Version 3.6 or later
3. **Database**: MySQL Server and MySQL WorkBench
4. **Git**: Version control system

## Setup Instructions

### 1. Clone the Repository
Clone this repository from GitHub using the following command:

```bash
git clone https://github.com/DevHamxa/Social_Media_Platform.git
```

### 2. Importing the Database

The database schema and data for this project are provided in the `database.sql` file located in the root directory of the project.

### Steps to Import the Database using MySQL Workbench:

1. **Open MySQL Workbench** and connect to your MySQL server.
   
2. **Create a New Database**: 
   - In the MySQL Workbench window, click on the `+` button next to `MySQL Connections` to start a new connection if you haven't connected to the server yet.
   - Once connected, click on the `Create New Schema` icon.
   - Name the schema (e.g., `social`) and click `Apply`.

3. **Import the Database Schema**:
   - In the menu bar, go to **File > Open SQL Script**.
   - Browse to the root directory of your project and select the `Dump20250120.sql` file.
   - Once the file is open, click the `Execute` button (lightning bolt icon) to run the SQL script.

4. **Verify the Database**:
   - After executing the script, you should see the newly created database with all the tables and data populated in the **Schemas** section in MySQL Workbench.
   - You can expand the database and check the tables to confirm that the import was successful.

5. **Update Database Configuration**:
   - Ensure that your  `application.properties` file is configured to connect to the newly imported database. Update the database name, username, and password as required:
   
   ```yaml
   spring:
     datasource:
       url: jdbc:jdbc:mysql://127.0.0.1:3306/social
       username: your-username
       password: your-password
    ```

### 3. API Endpoints

  1. **User Signup** 
  
  **Endpoint**: `http://localhost:8080/users/signup?email=abc123hfg@gmail.com&password=pass123`  
  **Method**: `POST`  
  **Description**: Allows users to register a new account.  
  **Request Body**: null
  
  2. **User Login** 
  
  **Endpoint**: `http://localhost:8080/api/auth/login?username=abc123hfg@gmail.com&password=pass123`  
  **Method**: `POST`  
  **Description**: Allows users to login to there account.  
  **Request Body**: null

  3. **User Detail** 
  
  **Endpoint**: `http://localhost:8080/users/1`  
  **Method**: `GET`  
  **Description**: Allows users to login to there account.
  **Request Header**: JWT token
  **Request Body**: null

  4. **Following** 
  
  **Endpoint**: `http://localhost:8080/follows/following?userId=2`  
  **Method**: `GET`  
  **Description**: Allows users to get the users that are following him/her. 
  **Request Header**: JWT token
  **Request Body**: null
