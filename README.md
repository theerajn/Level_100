# Design Patterns

This document lists important **Design Patterns**, grouped into **Creational, Structural, and Behavioural**, with simple definitions, examples, and advantages.

---

## Creational Design Patterns

### 🔹 Singleton
- **Definition**: Ensures only one instance of a class exists and provides global access.  
- **Example**: Database Configuration 
- **Advantage**: Prevents multiple instances that could cause conflicts; without it, resources may be wasted or states may become inconsistent.  

### 🔹 Factory Method
- **Definition**: Provides an interface to create objects, letting subclasses decide which class to instantiate.  
- **Example**: Notification System
- **Advantage**: The Factory Method pattern provides a centralized way of creating objects without exposing the creation logic. Without it, the client would need to handle object instantiation manually using new, which increases coupling and reduces flexibility. 

### 🔹 Builder
- **Definition**: Constructs complex objects step by step.  
- **Example**: Building structured and customizable emails
- **Advantage**: Allows step-by-step construction of complex objects without requiring a telescoping constructor, and makes the code more readable, flexible, and maintainable.

### 🔹 Prototype
- **Definition**: Creates new objects by cloning an existing object.  
- **Example**: Car Model Customization
- **Advantage**: Prototype allows creating new objects by cloning existing ones, which avoids the overhead of building objects from scratch. Without it, object creation could be slow, complex, or resource-heavy.  

### 🔹 Abstract Factory
- **Definition**: Provides an interface to create families of related objects without specifying their concrete classes.  
- **Example**: Document Processing System
- **Advantage**: Allows creating families of related objects without binding client code to specific classes, making the system easily extensible for new product types without changing existing code.

---

## Structural Design Patterns

### 🔹 Adapter
- **Definition**: Converts one interface into another interface clients expect.  
- **Example**: Smart Home Device Adapter  
- **Advantage**: Makes incompatible systems work together; without it, integration becomes impossible.  

### 🔹 Decorator
- **Definition**: Dynamically adds new responsibilities to objects without changing their code.  
- **Example**: ETL Data Cleaning Pipeline
- **Advantage**: Adds new functionality dynamically without altering existing classes; avoids an explosion of subclasses.

### 🔹 Proxy
- **Definition**: Provides a placeholder or surrogate to control access to another object.  
- **Example**: Role-Based Access Control 
- **Advantage**: The Proxy Design Pattern provides a surrogate or placeholder for another object to control access to it.

### 🔹 Composite
- **Definition**: Treats individual objects and groups of objects uniformly.  
- **Example**: IoT Sensor Management System 
- **Advantage**: Simplifies working with tree structures; without it, client code must treat single objects and groups differently.  

### 🔹 Facade
- **Definition**: Provides a simplified interface to a larger system.  
- **Example**: Travel Booking System
- **Advantage**: Reduces complexity; without it, clients must manage multiple subsystem calls directly.  

### 🔹 Flyweight
- **Definition**: Reduces memory usage by sharing common object data.  
- **Example**: City Traffic Monitoring System
- **Advantage**: Saves memory by reusing shared instances; without it, repeated objects consume large amounts of resources.  

### 🔹 Bridge
- **Definition**: Separates abstraction from implementation so they can vary independently.  
- **Example**:Robot Management
- **Advantage**: Decouples interface from implementation; without it, changes in one force changes in the other.  

