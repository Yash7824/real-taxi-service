# Real Taxi Service  

Real-Taxi-Service is a backend application built with **Java & Spring Boot** that powers a cab booking platform similar to Uber/Ola. It manages users, drivers, ride bookings, payments, and real-time ride tracking.  

---

## 📌 Overview  
This project provides a scalable backend for a taxi booking service. It allows **users** to book rides, **drivers** to accept and complete rides, and **admins** to manage the system.  

The backend is built with:  
- **Spring Boot** (REST APIs)  
- **Spring Security + JWT** (Authentication & Authorization)  
- **Postgres** (Persistence with Hibernate/JPA)  

---

## 🚀 Features  
- **User & Driver Authentication** – Secure registration & login with JWT.  
- **Ride Booking** – Request rides, match with nearby drivers.  
- **Ride Lifecycle Management** – Track statuses (`REQUESTED → ACCEPTED → ONGOING → COMPLETED → CANCELED`).  
- **Fare Calculation** – Distance + time-based pricing.  
- **Payment System** – Mock wallet transactions for ride payments.  
- **Real-time Notifications** – WebSocket support for ride updates.  
- **Admin Dashboard APIs** – Revenue tracking, active rides, driver stats.  
- **Scalable Microservice-Ready Design** – Modular services for Users, Drivers, Rides, Payments.  

---

## ⚙️ Setup  

### 1. Clone the Repository  
```bash
git clone https://github.com/Yash7824/real-taxi-service.git
cd real-taxi-service
```
---

## 🛠️ Tech Stack  

- **Backend:** Java, Spring Boot, Spring Data JPA, Spring Security, JWT  
- **Database:** Postgres  
- **Caching:** Redis *(optional, for driver availability & ride lookups)*  
- **Messaging:** Kafka / RabbitMQ *(optional, for ride events)*  
- **Testing:** JUnit, Mockito  
- **Deployment:** Docker, Kubernetes, AWS/GCP  

---

## ☁️ Deployment  

- **CI/CD** with GitHub Actions for automated builds & deployments.  
- **Dockerized services** for easy scaling & containerized deployment.  
- **Database hosted on AWS RDS** for reliable and scalable storage.  

