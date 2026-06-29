# Hospital Management System (Java, SQL)

A simple management system designed to create and manage patients and doctors, using a database set up in MySQL.

<img width="940" height="283" alt="Screenshot 2026-06-27 182038" src="https://github.com/user-attachments/assets/b642f174-bc48-4177-9c5d-d147e58a7156" />

---

# Program Features

- **Create user** - Allows user to register a user into the database as a patient or doctor
- **View all users** - Retrieves database, listing all users
- **View all patients/doctors** - Specifically lists all relevant users under either role
- **View by ID** - Retrieve a specific user by their unique ID
- **Remove user by ID** - Remove a user from the database using their unique ID
- **Regex checks per input field** - Regex to ensure that only correct information is passed into the database
- **Exception Handling** - InputMismatchExceptions return suitable messages back to the user
- **Prepared Statements** - Appropriate SQL prepared statements to prevent SQL injection

---

# Software/Tools Used

- **Languages** - Java, SQL
- **IDE** - IntelliJ IDEA
- **Database** - MySQL
- **Build Tool** - Maven

---

# Table SQL Code

>[!IMPORTANT]
> The sql statement to create the table is found in the project files under "createtable.sql"

>[!IMPORTANT]
> Modifications to the database path, username and password may be required, these are found on the dbManager class
