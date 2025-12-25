# LearnTrack – Console-Based Java Application

LearnTrack is a simple console-based Java application created to practice core Java and object-oriented programming concepts.

The focus of this project is not on UI frameworks or databases, but on clean code, proper package structure, and clear separation of responsibilities.

The application allows users to:
- Manage students and courses
- Enroll students into courses
- Update enrollment status
- Work with the system using a menu-driven console interface

All data is stored in memory using Java collections, which keeps the project easy to understand and suitable for learning purposes.

---

## Tech Stack

- Java (Core Java, OOP concepts)
- No external libraries
- Console-based input and output

---

## Project Structure

```
com.airtribe.learntrack
├── entity
├── service
├── exception
├── util
├── Main.java
└── docs
```

---

## How to Compile and Run Mac OS/Linux

### Compile

From the project root directory:

```bash
       find . -name "*.java" -exec javac -d out {} +
```

### Run

```bash 
      java -cp out com.airtribe.learntrack.Main
```

---

## Notes

- This application does not use any database or file storage
- All data exists only during runtime
- Restarting the application will reset all data