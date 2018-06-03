package com.lrn.prgcr.stringarray;

import java.util.Stack;

public class ReversePolishNotation {

	public Integer evaluate(final String[] reversePolishNotation) {
		String arithmeticOperator = "+-*/";
		Stack<Integer> stack = new Stack<>();
		for (String element : reversePolishNotation) {
			int opIndex = arithmeticOperator.indexOf(element);
			/* not an operator so numeric value */
			if (opIndex == -1) {
				stack.push(Integer.valueOf(element));
			} /* Arithmetic operator */
			else {
				int operand1 = stack.pop();
				int operand2 = stack.pop();
				/* for calculation use operand2 then arithmetic operand operand1 */
				switch (opIndex) {
				case 0:
					stack.push(operand2 + operand1);
					break;
				case 1:
					stack.push(operand2 - operand1);
					break;
				case 2:
					stack.push(operand2 * operand1);
					break;
				case 3:
					stack.push(operand2 / operand1);
					break;
				default:
					System.out.println("invalid operator :" + element);
				}
			}

		}
		return stack.pop();
	}

}
