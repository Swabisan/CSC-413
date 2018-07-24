public class PowerOperator extends Operator {
    
    private int priority = 4;

    @Override
    public int priority() {
        return this.priority;
    }

    @Override
    public Operand execute(Operand op1, Operand op2) {
        int result = (int) Math.pow(op1.getValue(), op2.getValue());
        Operand operand = new Operand(result);
        return operand;
    }
    
}
