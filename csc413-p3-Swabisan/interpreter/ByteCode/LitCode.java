package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class LitCode extends ByteCode {
    int value;
    String variableName = "";

    @Override
    public void init(ArrayList args) {
        this.value = Integer.parseInt((String) args.get(0));
        if (args.size() == 2)
            this.variableName = (String) args.get(1);
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        System.out.println("running lit " + value + " " + variableName);
        virtualMachine.getRunTimeStack().push(value);
    }
}