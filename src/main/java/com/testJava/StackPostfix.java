package com.testJava;

public class StackPostfix {
	static int count;

	public static int size(char[] stack) {
		return count;
	}

	public static void push(char[] stack, char c) {
		count++;
		stack[count - 1] = c;
	}

	public static char pop(char[] stack) {
		char data = stack[count - 1];
		count--;
		return data;

	}

	public static char peek(char[] stack) {
		if (size(stack) == 0) {
			return 0;
		} else {
			return stack[size(stack) - 1];
		}
	}

	public static boolean isEmpty(char[] stack) {
		if (stack[0] == 0) {
			return true;
		} else {
			return false;
		}
	}

	public static String convert(String infix) {
		String result = "";
		char[] stack = new char[infix.length()];

		for (int i = 0; i < infix.length(); i++) {
			char c = infix.charAt(i);
			if (priority(c) > 0) { // 연산자일 경우
				while (isEmpty(stack) == false && priority(peek(stack)) >= priority(c)) {
					result += pop(stack);
				}
				push(stack, c);
			} else if (c == ')') {
				char x = pop(stack);
				while (x != '(') {
					result += x;
					x = pop(stack);
				}
			} else if (c == '(') {
				push(stack, c);
			} else { // 일반 숫자나 문자인 경우
				result += c;
			}
		}

		for (int i = 0; i <= size(stack); i++) {
			result += pop(stack);
		}

		return result;
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
		String test = "(A+B)*C/D";
		String result = convert(test);
		System.out.println(result);
	}
}
