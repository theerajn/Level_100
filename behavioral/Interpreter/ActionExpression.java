// Terminal expression: matches an action
public class ActionExpression implements Expression {
    private final String expectedAction;

    public ActionExpression(String expectedAction) {
        this.expectedAction = expectedAction.toUpperCase();
    }

    @Override
    public boolean interpret(WorkflowContext ctx) {
        return ctx.getAction().equalsIgnoreCase(expectedAction);
    }
}
