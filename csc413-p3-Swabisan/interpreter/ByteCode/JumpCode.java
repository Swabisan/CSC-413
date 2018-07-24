package interpreter.ByteCode;

public abstract class JumpCode extends ByteCode {

    /**
     * called by interpreter.Program.resolveAddress()
     * This function replaces labelName (args[0]) with the
     * line number of the target destination.
     *
     * @param n Line number of second instance of labelName
     */
    abstract public void setTarget(int n);
    abstract public String getLabelName();
}
