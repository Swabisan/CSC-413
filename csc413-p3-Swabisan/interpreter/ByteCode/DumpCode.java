package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class DumpCode extends ByteCode {
    boolean isOn;

    @Override
    public void init(ArrayList args) {
        if ((String) args.get(0) == "ON") {
            isOn = true;
        } else {
            isOn = false;
        }
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        virtualMachine.getRunTimeStack().dump(virtualMachine);
    }
}
