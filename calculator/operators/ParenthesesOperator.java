package calculator.operators;
import calculator.*;

public class ParenthesesOperator extends Operator {
    public int priority() {
        return 0;
    }

    public Operand execute(Operand operand1, Operand operand2) {
        Operand result = new Operand(0);
        return result;
    }
}
