# URL SHORTENER

## Prerequisites

Before you can run the application, ensure you have the following installed:

- **PostgreSQL** 
- **Java** 
- **Spring Boot** 
- **Node.js** and **npm** 

---

## Setup

### 1. Set up PostgreSQL Database

1. Start the PostgreSQL server:
   - On Windows: Open the PostgreSQL app and click on "Start".
   - On macOS/Linux: You can use the following command to start PostgreSQL:
     ```bash
     sudo service postgresql start
     ```

2. Update `application.properties` for backend connection:
   - Set the PostgreSQL username and password in the `application.properties` file located in `src/main/resources/`.

   Example:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/your_database
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update



### 2. Run the Backend

1. Open your terminal and navigate to the backend project directory.

2. Run the application using Maven:
     ```bash
     mvn spring-boot:run
     ```
3. The backend should be running on `http://localhost:8080` (or the port specified in the `application.properties`).

### 3. Run the Frontend

1. Open your terminal and navigate to the frontend project directory.

2. Install the required dependencies:
   ```bash
   npm install
   ```

3. Start the frontend application:
   ```bash
   npm start
   ```

4. The frontend should be accessible at `http://localhost:3000`.

---

## Usage

- Access the frontend at `http://localhost:3000` and interact with the application.
- The frontend will communicate with the backend via API requests.

---
