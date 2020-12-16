package main;

import java.util.ArrayDeque;
import java.util.Deque;

public class BracesChecker {
    public static boolean check(String string) {
        Deque<Character> bracesStack = new ArrayDeque<>();
        for (int i = 0; i < string.length(); i++) {
            char currentChar = string.charAt(i);
            if (!checkChar(currentChar)) {
                continue;
            }
            if (currentChar == '(' || currentChar == '<' ||
                currentChar == '{' || currentChar == '[') {
                bracesStack.push(currentChar);
            }
            if (!bracesStack.isEmpty()) {
                Character peek = bracesStack.peek();

                if (currentChar == ')' && peek == '(' || currentChar == '>' && peek == '<' ||
                    currentChar == ']' && peek == '[' || currentChar == '}' && peek == '{') {
                    bracesStack.pop();
                } else if (currentChar == '}' || currentChar == ']' ||
                           currentChar == ')' || currentChar == '>'){
                    bracesStack.push(currentChar);
                }
            } else {
                return false;
            }
        }

        return bracesStack.isEmpty();
    }

    private static boolean checkChar(char currentChar) {
        return currentChar == '{' || currentChar == '}' ||
                currentChar == '[' || currentChar == ']' ||
                currentChar == '(' || currentChar == ')' ||
                currentChar == '<' || currentChar == '>';
    }
}
