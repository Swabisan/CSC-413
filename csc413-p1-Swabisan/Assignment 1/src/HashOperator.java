public class HashOperator extends Operator {
    
    private final int priority = 0;

    @Override
    public int priority() {
        return this.priority;
    }

    // special use operator, execute method
    // should never be run on this operator
    @Override
    public Operand execute(Operand op1, Operand op2) {
        return null;
    }
    
}
