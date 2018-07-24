package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class StoreCode extends ByteCode {
    private int offset;

    @Override
    public void init(ArrayList args) {
        this.offset = Integer.parseInt((String) args.get(0));
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        System.out.println("running store " + offset);
        virtualMachine.getRunTimeStack().store(offset);
    }
}
