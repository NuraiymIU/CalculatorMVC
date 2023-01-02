public class ReversePolishNotation {

    public double getResult(String exp){
        return calculateReversePolishNotation(expressionToReversePolishNotation(exp));
    }

    private String expressionToReversePolishNotation(String expression) {
        StackRealization stack = new StackRealization();
        String current = " ";
        int priority;

        for (int i = 0; i < expression.length(); i++) {
            priority = getPriority(expression.charAt(i));

            if (priority == 0) {
                current = current + expression.charAt(i);
            }

            if (priority >= 2) {
                current = current + ' ';
                while (!stack.empty()) {
                    if (getPriority(stack.peek()) >= priority) {
                        current = current + stack.pop();
                    }
                    else break;
                }
                stack.push(expression.charAt(i));
            }
        }
        while (!stack.empty())
            current = current + stack.pop();
        return current;
    }

    private double calculateReversePolishNotation(String rpn) {
        String operand = "";
        StackRealization stack = new StackRealization();

        for (int i = 0; i < rpn.length(); i++) {
            if (rpn.charAt(i) == ' ') {
                continue;
            }

            if (getPriority(rpn.charAt(i)) == 0) {
                while (rpn.charAt(i) != ' ' && getPriority(rpn.charAt(i)) == 0) {
                    operand = operand + rpn.charAt(i++);
                    if (i == rpn.length()) {
                        break;
                    }
                }
                stack.pushDouble(Double.parseDouble(operand));
                operand = new String();
            }
            if (getPriority(rpn.charAt(i)) > 1) {
                double leftValue = stack.popDouble();
                double rightValue = stack.popDouble();
                switch (rpn.charAt(i)){
                    case '+':
                        stack.pushDouble(rightValue + leftValue);
                        break;
                    case '-':
                        stack.pushDouble(rightValue - leftValue);
                        break;
                    case '*':
                        stack.pushDouble(rightValue * leftValue);
                        break;
                    case '/':
                        stack.pushDouble(rightValue / leftValue);
                        break;
                }
            }
        }
        return stack.popDouble();
    }

    private int getPriority(char operator) {
        if ((operator == '*') || (operator == '/') || operator == '^')
            return 3;
        else if (operator == '+' || operator == '-')
            return 2;
        else
            return 0;
    }

}
