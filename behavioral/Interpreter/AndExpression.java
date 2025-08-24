// Nonterminal: logical AND of two expressions
public class AndExpression implements Expression {
    private final Expression left;
    private final Expression right;

    public AndExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean interpret(WorkflowContext ctx) {
        return left.interpret(ctx) && right.interpret(ctx);
    }
}
