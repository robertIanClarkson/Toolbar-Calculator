package calculator.operators;
import calculator.*;

public class AdditionOperator extends Operator {
    public int priority() {
        return 2;
    }

    public Operand execute(Operand operand1, Operand operand2) {
        Operand result = new Operand(operand1.getValue() + operand2.getValue());
        return result;
    }
}
