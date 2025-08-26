import java.util.HashMap;
import java.util.Map;

// Holds and evaluates workflow rules using the Interpreter pattern
public class WorkflowEngine {
    // Map action -> rule (which may be a composition of expressions)
    private final Map<String, Expression> rules = new HashMap<>();

    public WorkflowEngine() {
        // Terminals
        Expression admin   = new RoleExpression("ADMIN");
        Expression manager = new RoleExpression("MANAGER");
        Expression user    = new RoleExpression("USER");

        Expression approve  = new ActionExpression("APPROVE");
        Expression reject   = new ActionExpression("REJECT");
        Expression escalate = new ActionExpression("ESCALATE");

        // Example composite rules (read like mini-grammar):
        // APPROVE can be done by ADMIN or MANAGER
        Expression approveRule = new AndExpression(
            approve,
            new OrExpression(admin, manager)
        );

        // REJECT can be done by ADMIN or MANAGER
        Expression rejectRule = new AndExpression(
            reject,
            new OrExpression(admin, manager)
        );

        // ESCALATE can be done by ADMIN only
        Expression escalateRule = new AndExpression(
            escalate,
            admin
        );

        // Register rules keyed by action
        rules.put("APPROVE", approveRule);
        rules.put("REJECT",  rejectRule);
        rules.put("ESCALATE", escalateRule);
    }

    public boolean executeWorkflow(String role, String action) {
        String key = action.toUpperCase();
        Expression rule = rules.get(key);

        if (rule == null) {
            System.out.println("No rule found for action: " + action);
            return false;
        }

        WorkflowContext ctx = new WorkflowContext(role, action);
        boolean ok = rule.interpret(ctx);

        if (ok) {
            System.out.println("Workflow executed: " + role + " -> " + action);
        } else {
            System.out.println("Not allowed: " + role + " cannot perform " + action);
        }
        return ok;
    }
}
