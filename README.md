# Java Object-Oriented Programming (OOP) Assignments

This repository contains a collection of Java projects created to demonstrate fundamental concepts of Object-Oriented Programming (OOP) and Data Structures. 

## 📁 Workspace Structure

The workspace is divided into two main projects, each focusing on different programming paradigms and Java features:

```text
OOP-Assignment/
├── Array-and-Arraylist/            # Project 1: Bank System Simulation
├── Inheritance_and_polymorphism/   # Project 2: Geometry Shapes Calculator
└── README.md                       # This main documentation file
```

---

## 🚀 Projects Overview

### 1. Bank System Simulation
**Folder:** `Array-and-Arraylist/`

A console-based banking application that allows users to manage customers, open multiple bank accounts, and process transactions (deposits and withdrawals). This project highlights the practical differences between fixed and dynamic data collections.

* **Core Concepts Demonstrated:**
  * **Java Arrays:** Used to manage a fixed-size list of Bank Customers.
  * **Java ArrayLists:** Used to manage a dynamic list of Accounts for each customer.
  * **Encapsulation:** Protecting account balances using private access modifiers.
  * **Static Variables:** Keeping a global count of total bank transactions.
* **Main Execution File:** `BankDemo.java`

### 2. Geometry Shapes Calculator
**Folder:** `Inheritance_and_polymorphism/`

A geometric calculator that models both 2D shapes (Squares, Circles) and 3D shapes (Cylinders) to calculate their areas and volumes. This project is a pure demonstration of OOP hierarchy.

* **Core Concepts Demonstrated:**
  * **Inheritance:** Establishing Parent-Child relationships (`extends`), allowing child classes to inherit attributes (like color) from the root `Bentuk` class.
  * **Polymorphism:** Utilizing method overriding (`@Override`) so the `printInfo()` method behaves differently depending on whether it is called on a Square, Circle, or Cylinder.
  * **Encapsulation:** Using Getters and Setters to control state.
* **Main Execution File:** `Main.java`

---

## 💻 How to Run

Ensure you have the Java Development Kit (JDK) installed. Open your terminal at the root of this workspace (`OOP-Assignment/`).

**To run the Bank System:**
```bash
cd Array-and-Arraylist
javac *.java
java BankDemo
```

**To run the Geometry Project:**
```bash
javac Inheritance_and_polymorphism/*.java
java Inheritance_and_polymorphism.Main
```