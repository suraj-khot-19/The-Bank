# Banking Application

A simple banking application built using **Spring Boot** and **MySQL** that provides functionalities like creating accounts, withdrawing, depositing, deleting accounts, and retrieving account details.

## Table of Contents
- [Features](#features)
- [Setup and Installation](#setup-and-installation)
- [API Endpoints](#api-endpoints)
- [Output Screenshots](#output-screenshots)
- [End](#end-)

## Features
- **Get All Accounts**: Retrieve a list of all bank accounts.
- **Get Account by ID**: Fetch details of a specific account using an account number.
- **Deposit Money**: Add funds to an account.
- **Withdraw Money**: Deduct funds from an account (ensuring sufficient balance).
- **Delete Account**: Remove an account from the system.

## Setup and Installation

1. Clone the repository:
   ```sh
   git clone https://github.com/your-repo/banking-app.git
   ```
2. Configure MySQL database in `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/banking_db
   spring.datasource.username=root
   spring.datasource.password=yourpassword
   ```
3. Run the application:
   ```sh
   mvn spring-boot:run
   ```

## API Endpoints

| Method | Endpoint                        | Description       |
|--------|---------------------------------|-------------------|
| GET    | api/v1/thebank/all              | Get all accounts  |
| GET    | api/v1/thebank/find/{accNo}     | Get account by ID |
| POST   | api/v1/thebank/deposit/{accNo}  | Deposit money     |
| POST   | api/v1/thebank/withdraw/{accNo} | Withdraw money    |
| DELETE | api/v1/thebank/delete/{accNo}   | Delete an account |
| POST   | api/v1/thebank/new              | Create an account |

## Output Screenshots
Below are screenshots of the application in action:

1. **Add an Account**  
   ![Img](Output/p1.png)
___
2. **find an account**  
   ![Img](Output/p2.png)
___
3. **find an account with no records**  
   ![Img](Output/p3.png)
___
4. **deposit an amount**  
   ![Img](Output/p4.png)
___
5. **deposit an amount with no record**  
   ![Img](Output/p5.png)
___
6. **withdraw an amount**  
   ![Img](Output/p6.png)
___
7. **withdraw an amount with no record**  
   ![Img](Output/p8.png)
___
8. **minimum balance should be 500**  
   ![Img](Output/p7.png)
___
9. **Get all Accounts**  
   ![Img](Output/p9.png)
___
10. **Delete an account**  
    ![Img](Output/p10.png)
___
11. **Delete an account with no reacord**  
    ![Img](Output/p11.png)

---

## End 

**Author:** Suraj Khot  
**Tech Stack:** Spring Boot, MySQL, Java, REST API

---
___
