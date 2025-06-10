# 🧾 Sales Tax Calculator

This is a Java-based command-line application to calculate sales tax and generate purchase receipts from user input.

## Features

- Parses shopping basket items with flexible input format
- Applies:
  - **Basic Sales Tax (10%)** on non-exempt items
  - **Import Duty (5%)** on imported goods
- Automatically detects item categories (food, books, medicine) via keywords
- Rounds up tax to the nearest 0.05
- Cleanly prints formatted receipts for each input group
- Fully modular structure with testable services

## Tech Stack

- Java 17+ (tested on Java 21)
- JUnit 5 for unit testing
- IntelliJ IDEA (recommended)
- Maven (optional)

## How to Run

```bash
# Compile
javac -d out src/main/java/org/apache/taxcalculatorapp/**/*.java

# Run
java -cp out org.apache.taxcalculatorapp.Main
