package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class WriteCode extends ByteCode {

    @Override
    public void init(ArrayList args) {

    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        System.out.println("running write");
        int value = virtualMachine.getRunTimeStack().peek();
        System.out.println(value);
    }
}
