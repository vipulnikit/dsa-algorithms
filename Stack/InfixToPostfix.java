import java.util.*;

public class InfixToPostfix {
    // TC: O(n) | SC:O(n)
    String infixToPostfix(String A) {
        HashMap<Character, Integer> precedence = new HashMap<>();
        precedence.put('^', 3);
        precedence.put('/', 2);
        precedence.put('*', 2);
        precedence.put('+', 1);
        precedence.put('-', 1);
        precedence.put(')', 0);
        precedence.put('(', 0);
        Stack<Character> operators = new Stack<>();
        StringBuilder postfixExp = new StringBuilder();
        for (int i = 0; i < A.length(); i++) {
            char curChar = A.charAt(i);
            if (isOperator(curChar)) {
                while (!operators.empty() && precedence.get(operators.peek()) >= precedence.get(curChar)) {
                    postfixExp.append(operators.pop());
                }
                operators.push(curChar);
            } else if (curChar == ')') {
                while (operators.peek() != '(') {
                    postfixExp.append(operators.pop());
                }
                operators.pop();
            } else if (curChar == '(') {
                operators.push('(');
            } else {
                postfixExp.append(curChar);
            }
        }
        while (!operators.empty()) {
            postfixExp.append(operators.pop());
        }
        return postfixExp.toString();
    }

    public boolean isOperator(char ch) {
        if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^')
            return true;
        return false;
    }
}
