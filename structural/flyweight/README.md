# Flyweight Design Pattern

## Definition
Reduces memory usage by sharing common object data among multiple similar objects, separating intrinsic state (shared) from extrinsic state (unique).

## Example Use Case
City Traffic Monitoring System

## Advantage
Saves memory by reusing shared instances and storing intrinsic state separately. Without it, repeated objects consume large amounts of resources.

## Impact Analysis

### With Flyweight Pattern
- Significant memory usage reduction
- Efficient handling of large object collections
- Shared intrinsic state management
- Better performance with numerous similar objects
- Optimized resource utilization

### Without Flyweight Pattern
- High memory consumption with duplicate objects
- Poor performance with large object collections
- Redundant storage of similar data
- Resource wastage through repeated object creation
- Scalability issues with memory usage
