package calculator;

public enum	Operator {
	ADD("+"), SUBTRACT("-"), MULTIPLY("*"), DIVIDE("/"), POSITIVE_SIGN(""), NEGATIVE_SIGN("-");
	private String symbol;

	private Operator(String symbol) {
		this.symbol = symbol;
	}

	public String toString() {
		return symbol;
	}
}
