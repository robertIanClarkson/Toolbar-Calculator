package calculator;

class EvaluatorTester {
    public static void main(String[] args) {
        Evaluator evaluator = new Evaluator();
        
        for (String arg : args) {
            System.out.format("%s = %d\n", arg, evaluator.eval(arg));
        }
    }
}
