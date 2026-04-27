# 🏥 Hospital Appointment & Queue Optimization System

(Java Swing + JDBC + MySQL)

## 📌 Overview

This project is a desktop-based **Hospital Appointment and Queue Optimization System** developed using **Java Swing** for the user interface, **JDBC** for database connectivity, and **MySQL** as the backend.

It helps manage patients, doctors, appointments, and optimizes queues by assigning tokens and tracking consultation order efficiently.

---

## 🚀 Features

* 👤 Add Patients
* 👨‍⚕️ Add Doctors
* 📅 Book Appointments
* 🎟️ Automatic Token Generation (Queue System)
* 📊 View Appointment Queue
* ✔️ Mark Patients as Completed
* 🔄 Automatic UI refresh after each operation
* ⚡ Basic queue optimization using token ordering

---

## 🛠️ Technologies Used

* Java (Swing for GUI)
* JDBC (Java Database Connectivity)
* MySQL Database

---

## 📁 Project Structure

```
DBConnection.java        → Database connection  
Dashboard.java           → Main dashboard UI  
AddPatient.java          → Add patient details  
AddDoctor.java           → Add doctor details  
BookAppointment.java     → Appointment booking  
ViewQueue.java           → View queue status  
CompleteAppointment.java → Mark appointment complete  
Main.java                → Entry point  
```

---

## 🗄️ Database Setup

```sql
CREATE DATABASE hospital_db;
USE hospital_db;

-- Patients table
CREATE TABLE patients (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    age INT,
    contact VARCHAR(20)
);

-- Doctors table
CREATE TABLE doctors (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    specialization VARCHAR(100)
);

-- Appointments / Queue table
CREATE TABLE appointments (
    id INT AUTO_INCREMENT PRIMARY KEY,
    patient_id INT,
    doctor_id INT,
    appointment_date DATE,
    token_no INT,
    status VARCHAR(20),
    FOREIGN KEY (patient_id) REFERENCES patients(id),
    FOREIGN KEY (doctor_id) REFERENCES doctors(id)
);
```

---

## ▶️ How to Run

1. Install MySQL Server
2. Create database using the above SQL commands
3. Add **MySQL Connector/J** to your Java project
4. Update database credentials in `DBConnection.java`
5. Run `Main.java`

---

## 💾 Backup & Restore

### Export Database

```
mysqldump -u root -p hospital_db > hospital_db.sql
```

### Import Database

```
mysql -u root -p hospital_db < hospital_db.sql
```

---

## ⚠️ Important Notes

* Ensure MySQL server is running before executing the program
* Default username: `root`
* Update password in the code accordingly
* Token number determines queue priority
* One patient is handled at a time per doctor

---

## 🎯 Future Enhancements

* 📅 Time-slot based scheduling
* 📱 SMS/Email notifications
* 📊 Dashboard analytics
* 🔐 Login system for admin/staff
* ⚡ Advanced queue optimization algorithm

---

## 👨‍💻 Author

Hospital Appointment & Queue Optimization System
(Java Swing + JDBC + MySQL)
