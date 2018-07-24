package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class PopCode extends ByteCode {
    private int valuesToPop;

    @Override
    public void init(ArrayList args) {
        this.valuesToPop = Integer.parseInt((String) args.get(0));
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        System.out.println("running pop " + valuesToPop);
        if (this.valuesToPop > virtualMachine.getFrameSize())
            this.valuesToPop = virtualMachine.getFrameSize();

        while (this.valuesToPop > 0) {
            virtualMachine.getRunTimeStack().pop();
        }
    }
}
