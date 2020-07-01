package stakeAndQueque.stack;

import java.util.Stack;

public class ReverseRun {
    public static void main(String[] args) {
        String code = "[[]]({})";

        System.out.println(isCorrectCode(code));
    }


    public static boolean isCorrectCode(String code) {
        Stack<String> stack = new Stack<>();
        for (var letter : code.split("")) {
            try {
                if (letter.equals("{") || letter.equals("[") || letter.equals("(")) stack.push(letter);
                if (letter.equals("}") && stack.peek().equals("{")) stack.pop();
                if (letter.equals(")") && stack.peek().equals("(")) stack.pop();
                if (letter.equals("]") && stack.peek().equals("[")) stack.pop();
            } catch (Exception e) {
                return false;
        }
    }
        return stack.isEmpty();
}

    public static String reverse(String string) {
        Stack<Character> stack = new Stack<>();
        for (char letter : string.toCharArray()) {
            stack.push(letter);
        }
        String result = "";
        for (int i = 0; i < string.length(); i++) {
            result += stack.pop().toString();
        }
        return result;
    }


}
