public class CloseParenOperator extends Operator {

    private final int priority = 1;

    @Override
    public int priority() {
        return this.priority;
    }

    @Override
    public Operand execute(Operand op1, Operand op2) {
        return null;
    }

}
