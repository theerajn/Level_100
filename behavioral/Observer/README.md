# Observer Design Pattern

## Definition
Establishes a one-to-many dependency relationship where changes in one object automatically notify and update multiple dependent objects.

## Example Use Case
Live Sports Score Update System

## Advantage
Decouples subject from observers enabling loose coupling. Without it, subjects must track and call each dependent manually, creating tight coupling.

## Impact Analysis

### With Observer Pattern
- Automatic notification of state changes
- Loose coupling between subject and observers
- Dynamic subscription and unsubscription
- Easy addition of new observer types
- Centralized event management

### Without Observer Pattern
- Manual notification of dependent objects
- Tight coupling between subject and dependents
- Difficult to add new dependent objects
- Complex dependency management
- Scattered notification logic throughout code
