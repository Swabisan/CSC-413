package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class LoadCode extends ByteCode {
    private int offset;
    private String variableName;

    @Override
    public void init(ArrayList args) {
        this.offset = Integer.parseInt((String) args.get(0));
        this.variableName = (String) args.get(1);
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        System.out.println("running load " + offset + " " + variableName);
        virtualMachine.getRunTimeStack().load(offset);
    }
}
