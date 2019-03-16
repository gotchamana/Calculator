package calculator;

public class BinaryExpression extends Expression {

	private Operand op1, op2;
	private Operator opt;

	public BinaryExpression (Operand op1, Operator opt, Operand op2) {
		this.op1 = op1;
		this.op2 = op2;
		this.opt = opt;
	}

	@Override
	public double getResult() {
		double result = 0;

		switch (opt) {
			case ADD: 
				result = op1.getValue() + op2.getValue();
				break;

			case SUBTRACT:
				result = op1.getValue() - op2.getValue();
				break;

			case MULTIPLY:
				result = op1.getValue() * op2.getValue();
				break;

			case DIVIDE:
				result = op1.getValue() / op2.getValue();
				break;
		}
		return result;
	}

	@Override
	public String toString() {
		String str = "(" + op1.toString() + " " + opt.toString() + " " + op2.toString() + ")";
		return str;
	}
}
