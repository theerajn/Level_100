# State Design Pattern

## Definition
Allows an object to change its behavior when its internal state changes, making it appear as if the object changed its class.

## Example Use Case
ATM Machine Simulation

## Advantage
Avoids large conditional logic by encapsulating state-specific behavior in separate classes. Without it, code becomes cluttered with complex if-else statements.

## Impact Analysis

### With State Pattern
- Clean separation of state-specific behavior
- Easy addition of new states
- Elimination of complex conditional logic
- Better code organization and readability
- Simplified state transition management

### Without State Pattern
- Complex conditional statements for state handling
- Difficult to add new states
- Cluttered code with nested if-else logic
- Poor maintainability and readability
- Error-prone state management
