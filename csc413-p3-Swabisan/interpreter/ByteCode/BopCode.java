package interpreter.ByteCode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class BopCode extends ByteCode {
    String operator;

    @Override
    public void init(ArrayList args) {
        operator = (String) args.get(0);
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        System.out.println("running bop " + operator);
        int secondOperator = virtualMachine.getRunTimeStack().pop();
        int firstOperator = virtualMachine.getRunTimeStack().pop();

        switch (operator) {
            case "+":
                virtualMachine.getRunTimeStack().push(firstOperator + secondOperator);
                break;

            case "-":
                virtualMachine.getRunTimeStack().push(firstOperator - secondOperator);
                break;

            case "*":
                virtualMachine.getRunTimeStack().push(firstOperator * secondOperator);
                break;

            case "/":
                virtualMachine.getRunTimeStack().push(firstOperator / secondOperator);
                break;

            case "==":
                virtualMachine.getRunTimeStack().push((firstOperator == secondOperator) ? 1 : 0);
                break;

            case "!=":
                virtualMachine.getRunTimeStack().push((firstOperator != secondOperator) ? 1 : 0);
                break;

            case "<=":
                virtualMachine.getRunTimeStack().push((firstOperator <= secondOperator) ? 1 : 0);
                break;

            case "<":
                virtualMachine.getRunTimeStack().push((firstOperator < secondOperator) ? 1 : 0);
                break;

            case ">=":
                virtualMachine.getRunTimeStack().push((firstOperator >= secondOperator) ? 1 : 0);
                break;

            case ">":
                virtualMachine.getRunTimeStack().push((firstOperator > secondOperator) ? 1 : 0);
                break;

            case "|":
                if (firstOperator == 1) {
                    virtualMachine.getRunTimeStack().push(1);
                    break;
                }

                if (firstOperator == 0) {
                    if (secondOperator == 1) {
                        virtualMachine.getRunTimeStack().push(1);
                        break;
                    }
                }

                virtualMachine.getRunTimeStack().push(0);
                break;
            case "&":
                if (firstOperator >= 0 && firstOperator <= 1) {
                    if (secondOperator >= 0 && secondOperator <= 1) {
                        if (firstOperator == secondOperator) {
                            virtualMachine.getRunTimeStack().push(1);
                            break;
                        }
                    }
                }

                virtualMachine.getRunTimeStack().push(0);
                break;
            default:
                virtualMachine.getRunTimeStack().push(0);
        }
    }
}
