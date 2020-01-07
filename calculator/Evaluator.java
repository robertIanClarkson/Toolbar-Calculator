package calculator;
import java.util.*;

class Evaluator {
    private Stack<Operand> operandStack;
    private Stack<Operator> operatorStack;

    private StringTokenizer tokenizer;
    private static final String DELIMITERS = "+-*^/() ";

    Evaluator() {
        operandStack = new Stack<>();
        operatorStack = new Stack<>();
    }

    private boolean isOperand(String token) {
        return Operand.check(token);
    }

    private boolean isOperator(String token) {
        return Operator.check(token);
    }

    private boolean isStartParentheses(String token) {
        if (token.equals("(")) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isEndParentheses(String token) {
        if (token.equals(")")) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isSpace(String token) {
        if (token.equals(" ")) {
            return true;
        } else {
            return false;
        }
    }

    private void processOperator(String token) {
        Operator pushOperator = Operator.newOperator(token);
        if (operatorStack.isEmpty()) {
            operatorStack.push(pushOperator);
        } else if (pushOperator.priority() > operatorStack.peek().priority()) {
            operatorStack.push(pushOperator);
        } else {
            while (pushOperator.priority() <= operatorStack.peek().priority()) {
                process();
                if (operatorStack.isEmpty()) {
                    break;
                }
            }
            operatorStack.push(pushOperator);
        }
    }

    private void processOperand(String token) {
        operandStack.push(new Operand(token));
    }

    private void processStartParentheses(String token) {
        Operator startParentheses = Operator.newOperator(token);
        operatorStack.push(startParentheses);
    }

    private void processEndParentheses() {
        try {
            while (operatorStack.peek().priority() != 0) {
                process();
                if (operatorStack.isEmpty()) {
                    break;
                }
            }
            operatorStack.pop();
        } catch (EmptyStackException e) {
            System.out.println("*****invalid equation******");
            System.exit(1);
        }
    }

    private void process() {
        try {
            Operand operand2 = operandStack.pop();
            Operand operand1 = operandStack.pop();
            Operator executeOperator = operatorStack.pop();
            operandStack.push(executeOperator.execute(operand1, operand2));
        } catch (EmptyStackException e) {
            System.out.println("*****invalid equation******");
            System.exit(1);
        }
    }

    public int eval(String expression) {
        String token;
        this.tokenizer = new StringTokenizer(expression, DELIMITERS, true);
        Operator.createKeyTokens();
        while (this.tokenizer.hasMoreTokens()) {
            token = this.tokenizer.nextToken();
            if (isOperand(token)) {
                processOperand(token);
            } else if (isOperator(token)) {
                processOperator(token);
            } else if (isStartParentheses(token)) {
                processStartParentheses(token);
            } else if (isEndParentheses(token)) {
                processEndParentheses();
            } else if (isSpace(token)) {
                continue;
            } else {
                System.out.println("*****invalid token******");
                System.exit(1);
            }
        }
        try {
            while (!(operatorStack.isEmpty())) {
                process();
            }
            return operandStack.pop().getValue();
        } catch (EmptyStackException e) {
            System.out.println("*****invalid equation******");
            System.exit(1);
            return 0;
        }
    }
}
