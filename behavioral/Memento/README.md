# Memento Design Pattern

## Definition
Captures and stores an object's internal state without violating encapsulation, allowing the object to be restored to this state later.

## Example Use Case
Database Rollback System

## Advantage
Restores previous state safely without exposing object internals. Without it, rollback would require exposing object internals or complex state recreation.

## Impact Analysis

### With Memento Pattern
- Safe state capture and restoration
- Preserved object encapsulation
- Support for multiple state snapshots
- Clean undo/redo functionality
- Simplified state management

### Without Memento Pattern
- Violation of object encapsulation for state access
- Complex state recreation mechanisms
- Difficult implementation of undo functionality
- Exposed internal object structure
- Compromised data integrity during rollback
