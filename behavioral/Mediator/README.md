# Mediator Design Pattern

## Definition
Defines an object that coordinates and controls the interaction between multiple objects, promoting loose coupling by preventing direct communication.

## Example Use Case
Loan Approval Workflow

## Advantage
All departments interact via the mediator instead of tightly coupling with each other. Centralizes complex communication and coordination logic.

## Impact Analysis

### With Mediator Pattern
- Centralized interaction management
- Loose coupling between communicating objects
- Simplified object relationships
- Easy modification of interaction logic
- Reduced dependencies between objects

### Without Mediator Pattern
- Direct communication between multiple objects
- Complex web of object dependencies
- Difficult to modify interaction patterns
- Tight coupling between communicating objects
- Scattered communication logic throughout system
