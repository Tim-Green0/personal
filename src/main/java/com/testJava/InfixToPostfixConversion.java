package com.testJava;

public class InfixToPostfixConversion {
	static int COUNT;

	public static String convert(String str) {
		String ans = "";
		char[] stack = new char[str.length()];
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (priority(c) > 0) {
				while (isEmpty(stack) == false && priority(peek(stack)) >= priority(c)) {
					ans += pop(stack);
				}
				push(stack, c);
			} else if (c == ')') {
				char x = pop(stack);
				while (x != '(') {
					ans += x;
					x = pop(stack);
				}
			} else if (c == '(') {
				push(stack, c);
			} else {
				ans += c;
			}
		}
		for (int i = 0; i <= size(stack); i++) {
			ans += pop(stack);
		}
		return ans;
	}

	public static int size(char[] stack) {
		return COUNT;
	}

	public static void push(char[] stack, char c) {
		COUNT++;
		stack[COUNT - 1] = c;
	}

	public static char pop(char[] stack) {
		char ch = stack[COUNT - 1];
		COUNT--;
		return (ch);
	}

	public static char peek(char[] stack) {
		if (size(stack) == 0)
			return 0;
		else
			return stack[size(stack) - 1];
	}

	public static boolean isEmpty(char[] stack) {
		if (stack[0] == 0)
			return true;
		else
			return false;
	}

	public static int priority(char c) {
		switch (c) {
		case '+':
			return 1;
		case '-':
			return 1;
		case '*':
			return 2;
		case '/':
			return 2;
		case '%':
			return 2; 
		case '^':
			return 3;
		default:
			return -1;
		}
	}

	public static void main(String[] args) {
		String exp = "(A+B)*C/D";
		System.out.println("Infix Expression: " + exp);
		System.out.println("Postfix Expression: " + convert(exp));
	}
}
