package calculator;

public class Operand {
	
	private double value;
	private Expression expr;

	public Operand(String value) {
		this.value = Double.parseDouble(value);
	}

	public Operand(Expression expr) {
		this.expr = expr;
		value = expr.getResult();
	}

	public double getValue() {
		return value;
	}

	@Override
	public String toString() {
		String str = (expr == null) ? String.valueOf(value) : expr.toString();
		return str;
	}
}
