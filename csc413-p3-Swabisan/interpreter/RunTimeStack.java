package interpreter;

import java.util.ArrayList;
import java.util.Stack;

public class RunTimeStack {

    public ArrayList<Integer> runTimeStack;
    private Stack<Integer> framePointer;

    RunTimeStack()
    {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();

        // Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }

    // TODO
    // dumps the RunTimeStack information for debugging
    public void dump(VirtualMachine virtualMachine) {
        System.out.println(virtualMachine.getFrameSize());
    }

    // returns the top item on the runTimeStack
    public int peek() {
        if(runTimeStack.isEmpty()){
            System.out.println("PEEK: Empty.");
            return 0;
        }
        return runTimeStack.get(runTimeStack.size() - 1);
    }

    // pop the top item from the runTimeStack
    public int pop() {
        if(runTimeStack.size() == 0){
            System.out.println("Empty runTimeStack.");
            System.exit(-2);
        }
        return runTimeStack.remove(runTimeStack.size() - 1);
    }

    // pushes i onto the runTimeStack
    // returns the item just pushed, i
    public int push(int i) {
        runTimeStack.add(i);
        return i;
    }

    // loads literals onto the stack
    // e.g. for lit 5 we'll call push with 5
    public Integer push(Integer i) {
        runTimeStack.add(i);
        return i;
    }

    // starts new frame
    // offset - indicates the number of slots down from
    // the top of the runTimeStack for starting a new frame
    public void newFrameAt(int offset) {
        framePointer.push(runTimeStack.size() - offset);
    }

    // We pop the top frame when returning from a function.
    // Before popping, the function's return value is at
    // the top of the stack so we'll save the value, pop
    // the top frame, and then push the return value.
    public void popFrame() {
        int value = peek();
        int fp = framePointer.pop();
        while (runTimeStack.size() >= fp) {
            if(runTimeStack.isEmpty()){
                System.out.println("Empty runTimeStack.");
                System.exit(-3);
            }
            pop();
        }
        push(value);
    }

    public int frames() {
        return framePointer.peek();
    }

    // stores variables
    public int store(int offset) {
        if(runTimeStack.isEmpty()){
            System.out.println("Empty runTimeStack.");
            System.exit(-4);
        }
        int n = pop();
        runTimeStack.add(framePointer.peek() - offset, n);
        return n;
    }

    // loads variables onto the stack
    public int load(int offset) {
        if(runTimeStack.isEmpty()){
            System.out.println("Empty runTimeStack.");
            System.exit(-5);
        }
        int n = runTimeStack.get(framePointer.peek() - offset);
        push(n);
        return n;
    }

    public int getFrameSize() {
        return runTimeStack.size() - framePointer.peek();
    }
}
