// Context passed to expressions (role + action)
public class WorkflowContext {
    private final String role;   // e.g., ADMIN, MANAGER, USER
    private final String action; // e.g., APPROVE, REJECT, ESCALATE

    public WorkflowContext(String role, String action) {
        this.role = role.toUpperCase();
        this.action = action.toUpperCase();
    }

    public String getRole() {
        return role;
    }

    public String getAction() {
        return action;
    }
}
