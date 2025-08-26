# Template Method Design Pattern

## Definition
Defines the skeleton of an algorithm in a base class, letting subclasses override specific steps without changing the algorithm's overall structure.

## Example Use Case
Resume Screening System

## Advantage
Promotes code reuse by defining common algorithm structure while allowing customization. Without it, algorithms must be duplicated with small variations.

## Impact Analysis

### With Template Method Pattern
- Reusable algorithm structure
- Consistent process flow across implementations
- Easy customization of specific steps
- Reduced code duplication
- Enforced algorithm integrity

### Without Template Method Pattern
- Duplicated algorithm implementations
- Inconsistent process flows
- Difficult maintenance of similar algorithms
- Higher risk of implementation errors
- Poor code reusability
