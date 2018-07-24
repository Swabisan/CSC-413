package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class ArgsCode extends ByteCode {
    private int numberOfArgs;

    @Override
    public void init(ArrayList args) {
        numberOfArgs = Integer.parseInt((String) args.get(0));
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        System.out.println("running arg " + numberOfArgs);
        // numberOfArgs -> framePointerOffset
        virtualMachine.getRunTimeStack().newFrameAt(numberOfArgs);
    }
}
