# Email Sender

A Java 21 and Spring Boot project for sending email through Gmail SMTP using Jakarta Mail.

## Requirements

- Java 21
- A Gmail account with 2-Step Verification enabled
- A Gmail App Password for SMTP authentication

## Configuration

The standalone sender currently uses Gmail SMTP with these settings:

- Host: `smtp.gmail.com`
- Port: `587`
- Authentication: enabled
- STARTTLS: enabled

Before running it, update the recipient, sender, and app-password values in `src/main/java/com/java_email/email/emailSender.java`.

Do not commit real passwords or API credentials. Prefer environment variables or a secrets manager for shared code. The app password currently present in the sender source should be revoked and regenerated.

## Run the Spring Boot application

On Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

On macOS or Linux:

```bash
./mvnw spring-boot:run
```

This starts `EmailApplication`. The application name is configured as `email` in `src/main/resources/application.properties`.

## Run the standalone email sender

Compile the project first:

```powershell
.\mvnw.cmd compile
```

Then run `emailSender` from your IDE, or execute it with the compiled classes and Maven dependencies configured on the classpath.

The sender prints SMTP debug output and reports whether the message was sent successfully.

## Test

On Windows:

```powershell
.\mvnw.cmd test
```

On macOS or Linux:

```bash
./mvnw test
```

## Project structure

```text
src/main/java/com/java_email/email/
├── EmailApplication.java   # Spring Boot entry point
└── emailSender.java        # Standalone Jakarta Mail sender
```
