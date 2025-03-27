# Lead Capture Service

## Background
The **Lead Capture Service** is a full-stack web application designed to collect and manage leads efficiently. It consists of a **ReactJS** frontend and a **Spring Boot** backend, communicating via a REST API. The system allows users to submit lead information, store it in a database, and retrieve or delete leads as needed.

### Tech Stack
- **Frontend:** ReactJS, Bootstrap, Axios
- **Backend:** Spring Boot, Spring Data JPA, Hibernate
- **Database:** PostgreSQL/MySQL (or H2 for in-memory testing)
- **Build Tools:** Maven (backend), Node.js with npm (frontend)

## Project Structure
```
lead-capture-service/
│── backend/
│   ├── src/main/java/com/lead/capture
│   │   ├── controller/  # Handles API requests and responses
│   │   ├── dto/  		 # Handles API requests JSON
│   │   ├── exception/ 	 # Global exception handling
│   │   ├── service/     # Contains business logic for lead management
│   │   ├── model/       # Entity and DTO definitions
│   │   ├── repository/  # JPA repositories for database interaction
│   │   ├── LeadCaptureServiceApplication.java  # Main Spring Boot application entry point
│── frontend/
│   ├── src/
│   │   ├── components/  # React components (LeadForm, LeadList, Spinner)
│   │   ├── services/    # API service functions using Axios
│   │   ├── App.js       # Main application component
│── README.md
```

## Setup Instructions
### Backend Setup
1. **Install Java 8** (or compatible JDK version)
2. **Install Maven**
3. **Clone the repository:**
   ```sh
   git clone https://github.com/your-repo/lead-capture-service.git
   cd lead-capture-service
   ```
4. **Configure database connection** in `application.properties` (or use in-memory H2 for testing)
5. **Run the application:**
   ```sh
   mvn spring-boot:run
   ```
6. The backend will be available at `http://localhost:8080/lead-capture-service/`

### Frontend Setup
1. **Install Node.js and npm**
2. **Navigate to the frontend directory:**
   ```sh
   git clone https://github.com/hksunny86/lead-capture-frontend.git
   cd lead-capture-frontend
   ```
3. **Install dependencies:**
   ```sh
   npm install
   ```
4. **Start the React application:**
   ```sh
   npm start
   ```
5. The frontend will be available at `http://localhost:3000`

## API Endpoints
### Lead Management
| Method | Endpoint | Description |
|--------|---------|-------------|
| **POST** | `/leads/addLead` | Adds a new lead |
| **GET** | `/leads/getLeads` | Retrieves all leads |
| **DELETE** | `/leads/{id}` | Deletes a lead by ID |

## Testing & Error Handling
- **Frontend**: Uses form validation and API response handling to manage errors.
- **Backend**: Implements exception handling for missing fields, invalid input, and database errors.

## Deployment Guide
- The backend can be deployed to **AWS, Heroku, or any cloud provider**.
- The frontend can be hosted on **Vercel, Netlify, or an Nginx server**.
- Use Docker to containerize the application if needed.

---
This document serves as a comprehensive guide to setting up, running, and managing the Lead Capture Service.
"# lead-capture-service" 
"# lead-capture-service" 
"# lead-capture-service" 
