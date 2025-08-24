// Interface: Defines the common operations for all robot types
public interface Robot {
    void pick();
    void place();
    void scan();
    void charge();
    String getRobotName();
}
