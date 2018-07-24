package interpreter;

import interpreter.ByteCode.*;
import java.util.Stack;

public class VirtualMachine {

    private RunTimeStack runStack;
    private Stack<Integer> returnAddrs;
    private Program program;
    private int pc; // program counter
    private boolean isRunning;

    protected VirtualMachine(Program program) {
        this.program = program;
    }

    public void executeProgram() {
        pc = 0;
        runStack = new RunTimeStack();
        returnAddrs = new Stack<>();
        isRunning = true;
        while (isRunning) {
            ByteCode code = program.getCode(pc);
            code.execute(this);
            // runStack.dump(); // check that the operation is correct
            pc++;
            System.out.println("pc: " + pc);
            System.out.println("PEEK: " + runStack.frames());
            System.out.println("RTS: " + runStack.runTimeStack.size());
            System.out.println("FPS: " + runStack.getFrameSize() + "\n");
        }
    }

    public void toggleIsRunning() {
        isRunning = !isRunning;
    }

    public RunTimeStack getRunTimeStack() {
        return runStack;
    }

    public int getFrameSize () {
        return this.runStack.getFrameSize();
    }

    public void pushReturnAddress() {
        returnAddrs.push(pc);
    }

    public int popReturnAddress() {
        return returnAddrs.pop();
    }

    public void setPc(int i) {
        this.pc = i;
    }

    public String getByteCodeName() {
        return "Implement me";
    }
}
