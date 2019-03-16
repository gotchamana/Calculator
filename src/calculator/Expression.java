package calculator;

public abstract class Expression {

	public abstract double getResult();

	public abstract String toString();

	public static Expression parse(String expr) {
		StringBuilder exprStr = new StringBuilder(expr);
		String leftSide, rightSide;

		Operand leftSideOp = null;
		Operand rightSideOp = null;
		Operator opt = null;

		// First, check parentheses
		for (int leftParenthesesIndex = exprStr.indexOf("("), i = leftParenthesesIndex + 1, count = 1; i < exprStr.length(); i++) {
			if (leftParenthesesIndex < 0) {
				break;
			}

			if (exprStr.charAt(i) == '(') {
				count++;
			} else if (exprStr.charAt(i) == ')') {
				count--;
			}

			if (count == 0) {
				String subExprStr = exprStr.substring(leftParenthesesIndex + 1, i);
				Expression subExpr = parse(subExprStr);
				exprStr.replace(leftParenthesesIndex, i + 1, String.valueOf(subExpr.getResult()));

				// Continue to find next parentheses
				leftParenthesesIndex = exprStr.indexOf("(");
				i = leftParenthesesIndex + 1;
				count = 1;
			}
		}

		// Second, divide the expression by priority
		int optIndex = 0;
		int addIndex = exprStr.lastIndexOf("+");
		int subtractIndex = exprStr.lastIndexOf("-");
		int multiplyIndex = exprStr.lastIndexOf("*");
		int divideIndex = exprStr.lastIndexOf("/");

		// Check addition and subtraction
		if (addIndex > 0 && subtractIndex > 0) {
			if (addIndex < subtractIndex && !hasOperator(String.valueOf(exprStr.charAt(subtractIndex - 1)))) {
				opt = Operator.SUBTRACT;
				optIndex = subtractIndex;
			} else {
				opt = Operator.ADD;
				optIndex = addIndex;
			}
		} else if (addIndex > 0) {
			opt = Operator.ADD;
			optIndex = addIndex;
		} else if (subtractIndex > 0 && !hasOperator(String.valueOf(exprStr.charAt(subtractIndex - 1)))) {
			opt = Operator.SUBTRACT;
			optIndex = subtractIndex;
		} else if (subtractIndex > 0 && exprStr.charAt(subtractIndex - 1) == '-') {
			opt = Operator.SUBTRACT;
			optIndex = subtractIndex - 1;

			if (optIndex == 0) {
				exprStr.delete(optIndex, subtractIndex + 1);
				return new UnaryExpression(Operator.POSITIVE_SIGN, new Operand(exprStr.toString()));
			}

			// Check multiplition and division
		} else if (multiplyIndex > 0 && divideIndex > 0) {
			opt = (multiplyIndex < divideIndex) ? Operator.DIVIDE : Operator.MULTIPLY;
			optIndex = (multiplyIndex < divideIndex) ? divideIndex : multiplyIndex;
		} else if (multiplyIndex > 0) {
			opt = Operator.MULTIPLY;
			optIndex = multiplyIndex;
		} else if (divideIndex > 0) {
			opt = Operator.DIVIDE;
			optIndex = divideIndex;
		} else {
			return new UnaryExpression(Operator.POSITIVE_SIGN, new Operand(exprStr.toString()));
		}

		leftSide = exprStr.substring(0, optIndex);
		rightSide = exprStr.substring(optIndex + 1);

		leftSideOp = hasOperator(leftSide) ? new Operand(parse(leftSide)) : new Operand(leftSide);
		rightSideOp = hasOperator(rightSide) ? new Operand(parse(rightSide)) : new Operand(rightSide);

		return new BinaryExpression(leftSideOp, opt, rightSideOp);
	}

	private static boolean hasOperator(String str) {
		return str.contains("+") || str.contains("-") || str.contains("*") || str.contains("/");
	}
}
