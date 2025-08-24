// Nonterminal: logical OR of two expressions
public class OrExpression implements Expression {
    private final Expression left;
    private final Expression right;

    public OrExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean interpret(WorkflowContext ctx) {
        return left.interpret(ctx) || right.interpret(ctx);
    }
}
