// TODO refactor entire class and add some more validations
public class StackCalculator {
    private Stack<Double> stack;

    StackCalculator() {
        stack = new DynamicStack<>();
    }


    public double calculate(String expression) throws InvalidExpressionException {
        String[] elements = expression.split(" ");

        for (int i=0; i<elements.length; i++) {
            String element = elements[i];

            if (isNumeric(element)) {
                stack.push(Double.parseDouble(element));
            } else {
                try {
                    new Operator(element).operate();
                } catch (Operator.InvalidOperatorException e) {
                    throw new InvalidExpressionException();
                }
            }
        }

        return stack.pop();
    }

    private boolean isNumeric(String element) {
        try {
            Double.parseDouble(element);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private class Operator {
        private char op;

        private boolean isValid(String element) {
            return element.length() == 1 &&  "+-*/".contains(element);
        }

        Operator(String op) throws InvalidOperatorException {
            if (isValid(op)) {
                this.op = op.charAt(0);
            } else {
                throw new InvalidOperatorException();
            }
        }

        void operate() {
            double aux = initializer();
            while (stack.size() > 0) {
                aux = evaluate(aux, stack.pop());
            }
            stack.push(aux);
        }

        private double initializer() {
            if (op == '+') {
                return 0.0;
            } else if (op == '-') {
                return stack.pop();
            } else if (op == '*') {
                return 1.0;
            } else if (op == '/') {
                return stack.pop();
            } else {
                throw new RuntimeException();
            }
        }

        private double evaluate(double n1, double n2) {
            if (op == '+') {
                return n1 + n2;
            } else if(op == '-') {
                return n1 - n2;
            } else if (op == '*') {
                return n1 * n2;
            } else if(op == '/') {
                return n1 / n2;
            } else {
                throw new RuntimeException("TILT");
            }
        }

        class InvalidOperatorException extends Exception {}
    }

    class InvalidExpressionException extends Exception {}
}
