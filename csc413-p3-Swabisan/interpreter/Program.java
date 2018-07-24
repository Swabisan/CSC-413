package interpreter;

import interpreter.ByteCode.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Program {

    private ArrayList<ByteCode> program;
    private static HashMap<String, Integer> addresses = new HashMap<>();
    // constructor
    Program() {
        program = new ArrayList<>();
    }

    // getters
    protected ByteCode getCode(int pc) {
        return this.program.get(pc);
    }

    private int getSize() {
        return this.program.size();
    }

    // setters
    protected void addCode(ByteCode byteCode) {
        this.program.add(byteCode);

        // special case label exists -> store label and line number
        if (byteCode instanceof LabelCode) {
            addresses.put(((LabelCode) byteCode).getLabelName(), getSize());
        }
    }

    /**
     * This function goes through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter(PC)
     *
     * @param program Program object that holds a list of ByteCodes
     */
    public void resolveAddress(Program program) {
        for (ByteCode byteCode: program.program) {

            if (byteCode instanceof JumpCode) {
                String labelName = ((JumpCode) byteCode).getLabelName();
                if (addresses.containsKey(labelName))
                    ((JumpCode) byteCode).setTarget(addresses.get(labelName));
            }

        }
    }
}
