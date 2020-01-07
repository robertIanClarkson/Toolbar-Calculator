package calculator.operators;
import calculator.*;

public class ExponentialOperator extends Operator {
    public int priority() {
        return 4;
    }

    public Operand execute(Operand operand1, Operand operand2) {
        int power = (int) Math.pow(operand1.getValue(), operand2.getValue());
        Operand result = new Operand(power);
        return result;
    }
}
