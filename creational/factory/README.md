# Factory Method Design Pattern

## Definition
Provides an interface to create objects, letting subclasses decide which class to instantiate without specifying the exact class of object that will be created.

## Example Use Case
Notification System

## Advantage
Provides a centralized way of creating objects without exposing the creation logic. Promotes loose coupling between classes and makes the system easily extensible for new product types.

## Impact Analysis

### With Factory Method Pattern
- Centralized object creation logic
- Easy addition of new product types
- Loose coupling between client and concrete classes
- Consistent object creation process
- Enhanced code maintainability

### Without Factory Method Pattern
- Direct object instantiation increases coupling
- Difficult to add new object types
- Creation logic scattered throughout codebase
- Hard to maintain and modify creation process
- Reduced flexibility in object creation
