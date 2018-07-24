package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public abstract class ByteCode {

    public abstract void init(ArrayList args);
    public abstract void execute(VirtualMachine virtualMachine);
}
