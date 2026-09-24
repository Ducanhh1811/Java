package Stack;

import DoublyLinkedList.Student;

public class Test {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(new Student(1, "Nguyen Van A", 7.5));
        stack.push(new Student(2, "Nguyen Van Ninh", 8.5));
        stack.push("Test string");
        stack.traverse();

        decimal2Binary(13);
        String exp = "{()}()(x+2)";
        System.out.println(isValidExpression(exp));
    }

    public static  void decimal2Binary(int x) {
        if (x == 0) {
            System.out.println("Binary of 0 ís 0");
        }else if(x > 0){
            MyStack stack = new MyStack();
            System.out.print("Binary of " + x + " is ");
            while (x > 0) {
                stack.push(x % 2);
                x /= 2;
            }
            while(!stack.isEmpty()){
                System.out.print(stack.pop());
            }
        }
    }
    
    public static boolean isValidExpression(String exp) {
        MyStack stack = new MyStack();
        for(char c : exp.toCharArray()){
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else if(c == ')' || c == ']' || c == '}'){
                if (stack.isEmpty()) {
                    return false;
                }
                char c1 = (char) stack.pop();
                if(!((c1 == '(' && c == ')') || (c1 == '[' && c == ']') || (c1 == '{' && c == '}'))){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static double calculatePostfixExp(String exp) {
        if (exp == null || exp.trim().isEmpty()) {
            throw new IllegalArgumentException("Expression cannot be empty.");
        }

        MyStack stack = new MyStack();
        String[] tokens = exp.trim().split("\\s+");

        if (tokens.length == 1 && tokens[0].length() > 1) {
            tokens = tokens[0].split("");
        }

        for (String token : tokens) {
            if (isNumber(token)) {
                stack.push(Double.parseDouble(token));
            } else if (isOperator(token)) {
                if (stack.isEmpty()) {
                    throw new IllegalArgumentException("Invalid postfix expression.");
                }
                double right = (double) stack.pop();
                if (stack.isEmpty()) {
                    throw new IllegalArgumentException("Invalid postfix expression.");
                }
                double left = (double) stack.pop();

                switch (token.charAt(0)) {
                    case '+':
                        stack.push(left + right);
                        break;
                    case '-':
                        stack.push(left - right);
                        break;
                    case '*':
                        stack.push(left * right);
                        break;
                    case '/':
                        if (right == 0) {
                            throw new ArithmeticException("Cannot divide by zero.");
                        }
                        stack.push(left / right);
                        break;
                    default:
                        throw new IllegalArgumentException("Unsupported operator: " + token);
                }
            } else {
                throw new IllegalArgumentException("Invalid token: " + token);
            }
        }

        if (stack.isEmpty()) {
            throw new IllegalArgumentException("Invalid postfix expression.");
        }

        double result = (double) stack.pop();
        if (!stack.isEmpty()) {
            throw new IllegalArgumentException("Invalid postfix expression.");
        }
        return result;
    }

    private static boolean isNumber(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isOperator(String token) {
        return token.length() == 1 && "+-*/".indexOf(token.charAt(0)) >= 0;
    }
}
