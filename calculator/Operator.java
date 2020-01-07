package calculator;
import calculator.operators.*;
import java.util.HashMap;

public abstract class Operator {
    private static HashMap<String, Operator> operators = new HashMap<String, Operator>();
    private static final String OPERATORS = "+-*^/";

    public abstract int priority();

    public abstract Operand execute(Operand operand1, Operand operand2);

    static boolean check(String token) {
        if (OPERATORS.contains(token)) {
            return true;
        } else {
            return false;
        }
    }

    static void createKeyTokens() {
        operators.put("+", new AdditionOperator());
        operators.put("-", new SubtractionOperator());
        operators.put("*", new MultiplicationOperator());
        operators.put("/", new DivisionOperator());
        operators.put("^", new ExponentialOperator());
        operators.put("(", new ParenthesesOperator());
    }

    static Operator newOperator(String token) {
        return operators.get(token);
    }
}
