package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class CallCode extends JumpCode {
    private String labelName;
    private int target;

    @Override
    public void init(ArrayList args) {
        this.labelName = (String) args.get(0);
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        System.out.println("running call " + labelName + " " + target);
        virtualMachine.pushReturnAddress();
        // virtual machine increments pc right after so
        // we reduce by one to compensate when changing pc
        virtualMachine.setPc(target - 1);
    }

    /** called by interpreter.Program.resolveAddress()
     * This function replaces labelName (args[0]) with the
     * line number of the target destination.
     *
     * @param target Line number of second instance of labelName
     */
    public void setTarget (int target) {
        this.target = target;
    }

    public String getLabelName() {
        return this.labelName;
    }

    public int getTarget() {
        return this.target;
    }
}
