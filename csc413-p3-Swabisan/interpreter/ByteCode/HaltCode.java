package interpreter.ByteCode;

import interpreter.Program;
import interpreter.VirtualMachine;

import java.util.ArrayList;

public class HaltCode extends ByteCode {

    @Override
    public void init(ArrayList args) {

    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        System.out.println("running halt");
        virtualMachine.toggleIsRunning();
    }
}
