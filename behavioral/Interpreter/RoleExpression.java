// Terminal expression: matches a role
public class RoleExpression implements Expression {
    private final String expectedRole;

    public RoleExpression(String expectedRole) {
        this.expectedRole = expectedRole.toUpperCase();
    }

    @Override
    public boolean interpret(WorkflowContext ctx) {
        return ctx.getRole().equalsIgnoreCase(expectedRole);
    }
}
