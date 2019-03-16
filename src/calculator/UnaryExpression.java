package calculator;

public class UnaryExpression extends Expression {

	private Operand op;
	private Operator opt;

	public UnaryExpression(Operand op) {
		this.op = op;
	}

	public UnaryExpression(Operator opt, Operand op) {
		this.opt = opt;
		this.op = op;
	}

	@Override
	public double getResult() {
		double result = 0;

		if (opt == Operator.NEGATIVE_SIGN) {
			result = -(op.getValue());
		} else {
			result = op.getValue();
		}

		return result;
	}

	@Override
	public String toString() {
		String str = "(" + opt.toString() + op.toString() + ")";
		return str;
	}
}
