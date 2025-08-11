
# Paperless Office System for Educational Administration

## Overview
Paperless Office is a desktop application designed to streamline document management, approval workflows, and administrative tasks for educational institutions. It enables staff, teachers, and students to manage documents efficiently in a secure, digital environment.

## Features
- **Document Preparation:** Create, edit, and manage official documents (notices, office orders, applications).
- **Approval Workflow:** Route documents for approval to department heads and administrators.
- **Teacher Functions:** Compose applications, submit compensation bills, and manage personal documents.
- **Student Services:** Apply for transcripts, certificates, and club positions.
- **PDF Generation & Preview:** Generate and preview PDF documents with custom fonts and branding.
- **Notifications:** Receive updates on document status and approvals.
- **User Roles:** Role-based access for Office Staff, Teachers, Students, and Administrators.

## Technology Stack
- **Java** (Swing for UI)
- **MySQL** (JDBC for database access)
- **Gmail API** (for email notifications)
- **PDFBox & ICEpdf** (for PDF generation and viewing)

## Getting Started
### Prerequisites
- Java 8 or higher
- MySQL Server
- Required JAR dependencies (see `jars/` directory)

### Setup
1. **Clone the repository:**
   ```bash
   git clone https://github.com/MonzurElahiShamim/paperless_office.git
   cd paperless_office
   ```
2. **Configure Database:**
   - Create a MySQL database named `paperless_office` (or choose another and update properties).
   - Create the required tables (see Schema section below) or run the provided script.
   - Provide connection settings either via `src/main/resources/database.properties` (create it) or system properties.
3. **Add Fonts:**
   - Place required fonts in the `Fonts/` directory.
4. **Build the Project:**
   - Use your IDE or run Ant (`build.xml`) to build the project.
5. **Run the Application:**
   - Launch from your IDE or run the generated JAR file.

### Usage
- **Login:** Use your credentials to access the system.
- **Document Management:** Prepare, submit, and approve documents based on your role.
- **Notifications:** Check for updates and approval status.

## Contributing
Contributions are welcome! Please follow these steps:
1. Fork the repository.
2. Create a new branch (`git checkout -b feature/your-feature`).
3. Commit your changes (`git commit -am 'Add new feature'`).
4. Push to your branch (`git push origin feature/your-feature`).
5. Create a Pull Request.

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Contact
For questions or feedback:
- Email: monzureelahi032@gmail.com
- LinkedIn: [Monzur Elahi Shamim](https://linkedin.com/in/monzur-elahi-shamim)

---
For more details, refer to the source code and documentation within the repository.

## Database Schema

MySQL DDL (production example):

```sql
CREATE TABLE IF NOT EXISTS student (
   st_id VARCHAR(50) PRIMARY KEY,
   stNameEn VARCHAR(100),
   stNameBn VARCHAR(100),
   fatherNameEn VARCHAR(100),
   fatherNameBn VARCHAR(100),
   mobile VARCHAR(30),
   session VARCHAR(50),
   eduEmail VARCHAR(150) UNIQUE,
   personalEmail VARCHAR(150),
   password VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS teacher (
   id VARCHAR(50) PRIMARY KEY,
   nameEn VARCHAR(100),
   nameBn VARCHAR(100),
   mobile VARCHAR(30),
   designation VARCHAR(100),
   email VARCHAR(150) UNIQUE,
   dept VARCHAR(100)
);
```

You can also reference the test schema at `src/test/resources/schema.sql` (H2-compatible) which mirrors this structure.