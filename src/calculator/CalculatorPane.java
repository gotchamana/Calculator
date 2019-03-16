package calculator;

import com.jfoenix.controls.JFXButton;

import javafx.geometry.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;

public class CalculatorPane extends GridPane {

	private ColumnConstraints col1, col2, col3, col4, col5, col6;
	private RowConstraints row1, row2, row3, row4, row5;

	private TextField display;
	private Button zero, one, two, three, four, five, six, seven, eight, nine;
	private Button sign, dot, addition, subtraction, multiplication, division, delete, clear, leftParentheses, rightParentheses, equal;

	public CalculatorPane() {
		setMinHeight(350.0);
		setMinWidth(400.0);
		setPrefHeight(350.0);
		setPrefWidth(400.0);
		setHgap(5.0);
		setVgap(5.0);
		setPadding(new Insets(5.0));
		getStyleClass().add("background");

		col1 = new ColumnConstraints();
		col1.setHgrow(Priority.SOMETIMES);
		col1.setMinWidth(10.0);
		col1.setPrefWidth(100.0);

		col2 = new ColumnConstraints();
		col2.setHgrow(Priority.SOMETIMES);
		col2.setMinWidth(10.0);
		col2.setPrefWidth(100.0);

		col3 = new ColumnConstraints();
		col3.setHgrow(Priority.SOMETIMES);
		col3.setMinWidth(10.0);
		col3.setPrefWidth(100.0);

		col4 = new ColumnConstraints();
		col4.setHgrow(Priority.SOMETIMES);
		col4.setMinWidth(10.0);
		col4.setPrefWidth(100.0);

		col5 = new ColumnConstraints();
		col5.setHgrow(Priority.SOMETIMES);
		col5.setMinWidth(10.0);
		col5.setPrefWidth(100.0);

		col6 = new ColumnConstraints();
		col6.setHgrow(Priority.SOMETIMES);
		col6.setMinWidth(10.0);
		col6.setPrefWidth(100.0);
		getColumnConstraints().addAll(col1, col2, col3, col4, col5, col6);

		row1 = new RowConstraints();
		row1.setVgrow(Priority.SOMETIMES);
		row1.setMinHeight(10.0);
		row1.setPrefHeight(30.0);

		row2 = new RowConstraints();
		row2.setVgrow(Priority.SOMETIMES);
		row2.setMinHeight(10.0);
		row2.setPrefHeight(30.0);

		row3 = new RowConstraints();
		row3.setVgrow(Priority.SOMETIMES);
		row3.setMinHeight(10.0);
		row3.setPrefHeight(30.0);

		row4 = new RowConstraints();
		row4.setVgrow(Priority.SOMETIMES);
		row4.setMinHeight(10.0);
		row4.setPrefHeight(30.0);

		row5 = new RowConstraints();
		row5.setVgrow(Priority.SOMETIMES);
		row5.setMinHeight(10.0);
		row5.setPrefHeight(30.0);
		getRowConstraints().addAll(row1, row2, row3, row4, row5);

		display = new TextField() {
			@Override 
			public void replaceText(int start, int end, String text) {
				if (!text.matches("[a-zA-Z~!@#$%^&_=\\e\\[\\]{};:\"'?,<>|\\h]")) {
					super.replaceText(start, end, text);
				}
			}

			@Override 
			public void replaceSelection(String text) {
				if (!text.matches("[a-zA-Z~!@#$%^&_=\\e\\[\\]{};:\"'?,<>|\\h]")) {
					super.replaceSelection(text);
				}
			}
		};
		display.setMaxHeight(Double.MAX_VALUE);
		display.setMaxWidth(Double.MAX_VALUE);
		display.setAlignment(Pos.CENTER_RIGHT);
		display.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.ESCAPE) {
				display.clear();
			}
		});
		add(display, 0, 0, 6, 1);

		zero = new JFXButton("0");
		zero.setMaxHeight(Double.MAX_VALUE);
		zero.setMaxWidth(Double.MAX_VALUE);
		zero.setFocusTraversable(false);
		zero.setOnAction(e -> {
			display.requestFocus();
			display.replaceSelection("0");
		});
		add(zero, 1, 4);

		one = new JFXButton("1");
		one.setMaxHeight(Double.MAX_VALUE);
		one.setMaxWidth(Double.MAX_VALUE);
		one.setFocusTraversable(false);
		one.setOnAction(e -> {
			display.requestFocus();
			display.replaceSelection("1");
		});
		add(one, 0, 3);

		two = new JFXButton("2");
		two.setMaxHeight(Double.MAX_VALUE);
		two.setMaxWidth(Double.MAX_VALUE);
		two.setFocusTraversable(false);
		two.setOnAction(e -> {
			display.requestFocus();
			display.replaceSelection("2");
		});
		add(two, 1, 3);

		three = new JFXButton("3");
		three.setMaxHeight(Double.MAX_VALUE);
		three.setMaxWidth(Double.MAX_VALUE);
		three.setFocusTraversable(false);
		three.setOnAction(e -> {
			display.requestFocus();
			display.replaceSelection("3");
		});
		add(three, 2, 3);

		four = new JFXButton("4");
		four.setMaxHeight(Double.MAX_VALUE);
		four.setMaxWidth(Double.MAX_VALUE);
		four.setFocusTraversable(false);
		four.setOnAction(e -> {
			display.requestFocus();
			display.replaceSelection("4");
		});
		add(four, 0, 2);

		five = new JFXButton("5");
		five.setMaxHeight(Double.MAX_VALUE);
		five.setMaxWidth(Double.MAX_VALUE);
		five.setFocusTraversable(false);
		five.setOnAction(e -> {
			display.requestFocus();
			display.replaceSelection("5");
		});
		add(five, 1, 2);

		six = new JFXButton("6");
		six.setMaxHeight(Double.MAX_VALUE);
		six.setMaxWidth(Double.MAX_VALUE);
		six.setFocusTraversable(false);
		six.setOnAction(e -> {
			display.requestFocus();
			display.replaceSelection("6");
		});
		add(six, 2, 2);

		seven = new JFXButton("7");
		seven.setMaxHeight(Double.MAX_VALUE);
		seven.setMaxWidth(Double.MAX_VALUE);
		seven.setFocusTraversable(false);
		seven.setOnAction(e -> {
			display.requestFocus();
			display.replaceSelection("7");
		});
		add(seven, 0, 1);

		eight = new JFXButton("8");
		eight.setMaxHeight(Double.MAX_VALUE);
		eight.setMaxWidth(Double.MAX_VALUE);
		eight.setFocusTraversable(false);
		eight.setOnAction(e -> {
			display.requestFocus();
			display.replaceSelection("8");
		});
		add(eight, 1, 1);

		nine = new JFXButton("9");
		nine.setMaxHeight(Double.MAX_VALUE);
		nine.setMaxWidth(Double.MAX_VALUE);
		nine.setFocusTraversable(false);
		nine.setOnAction(e -> {
			display.requestFocus();
			display.replaceSelection("9");
		});
		add(nine, 2, 1);

		sign = new JFXButton("+/-");
		sign.setMaxHeight(Double.MAX_VALUE);
		sign.setMaxWidth(Double.MAX_VALUE);
		sign.setFocusTraversable(false);
		sign.setOnAction(e -> {
			display.requestFocus();

			String text = display.getText();

			// First check the number if negative
			for (int i = display.getCaretPosition(); i >= 0; i--) {
				if (i != display.getCaretPosition() && !String.valueOf(text.charAt(i)).toString().matches("[\\d.\\-()]")) break;

				if (i + 2 < text.length() && text.substring(i, i + 2).equals("(-")) {
					text = new StringBuilder(text).delete(i, i + 2).toString();
					for (int j = i; j < text.length(); j++) {
						if (text.charAt(j) == ')') {
							text = new StringBuilder(text).deleteCharAt(j).toString();
							display.setText(text);
							display.positionCaret(j);
							return;
						}
					}

				} 
			}

			// And then add the negative sign
			loop:
			for (int i = display.getCaretPosition(); i >= 0; i--) {
				if (i == 0 || !String.valueOf(text.charAt(i - 1)).matches("[\\d.]")) {
					if(i == text.length() || !String.valueOf(text.charAt(i)).matches("[\\d]")) break;
					
					display.insertText(i, "(-");
					text = display.getText();

					for (int j = i + 2; j <= text.length(); j++) {
						if (j == text.length() || !String.valueOf(text.charAt(j)).matches("[\\d.]")) {
							display.insertText(j, ")");
							break loop;
						}
					}
				}
			}
		});
		add(sign, 0, 4);

		dot = new JFXButton(".");
		dot.setMaxHeight(Double.MAX_VALUE);
		dot.setMaxWidth(Double.MAX_VALUE);
		dot.setFocusTraversable(false);
		dot.setOnAction(e -> {
			display.requestFocus();
			display.replaceSelection(".");
		});
		add(dot, 2, 4);

		addition = new JFXButton("+");
		addition.setMaxHeight(Double.MAX_VALUE);
		addition.setMaxWidth(Double.MAX_VALUE);
		addition.setFocusTraversable(false);
		addition.setOnAction(e -> {
			display.requestFocus();
			display.replaceSelection("+");
		});
		add(addition, 3, 4);

		subtraction = new JFXButton("-");
		subtraction.setMaxHeight(Double.MAX_VALUE);
		subtraction.setMaxWidth(Double.MAX_VALUE);
		subtraction.setFocusTraversable(false);
		subtraction.setOnAction(e -> {
			display.requestFocus();
			display.replaceSelection("-");
		});
		add(subtraction, 3, 3);

		multiplication = new JFXButton("*");
		multiplication.setMaxHeight(Double.MAX_VALUE);
		multiplication.setMaxWidth(Double.MAX_VALUE);
		multiplication.setFocusTraversable(false);
		multiplication.setOnAction(e -> {
			display.requestFocus();
			display.replaceSelection("*");
		});
		add(multiplication, 3, 2);

		division = new JFXButton("/");
		division.setMaxHeight(Double.MAX_VALUE);
		division.setMaxWidth(Double.MAX_VALUE);
		division.setFocusTraversable(false);
		division.setOnAction(e -> {
			display.requestFocus();
			display.replaceSelection("/");
		});
		add(division, 3, 1);

		delete = new JFXButton("Del");
		delete.setMaxHeight(Double.MAX_VALUE);
		delete.setMaxWidth(Double.MAX_VALUE);
		delete.setFocusTraversable(false);
		delete.setOnAction(e -> {
			display.requestFocus();
			display.end();
			display.deletePreviousChar();
		});
		add(delete, 4, 3, 2, 1);

		clear = new JFXButton("C");
		clear.setMaxHeight(Double.MAX_VALUE);
		clear.setMaxWidth(Double.MAX_VALUE);
		clear.setFocusTraversable(false);
		clear.setOnAction(e -> {
			display.requestFocus();
			display.clear();
		});
		add(clear, 4, 2, 2, 1);

		leftParentheses = new JFXButton("(");
		leftParentheses.setMaxHeight(Double.MAX_VALUE);
		leftParentheses.setMaxWidth(Double.MAX_VALUE);
		leftParentheses.setFocusTraversable(false);
		leftParentheses.setOnAction(e -> {
			display.requestFocus();
			display.replaceSelection("(");
		});
		add(leftParentheses, 4, 1);

		rightParentheses = new JFXButton(")");
		rightParentheses.setMaxHeight(Double.MAX_VALUE);
		rightParentheses.setMaxWidth(Double.MAX_VALUE);
		rightParentheses.setFocusTraversable(false);
		rightParentheses.setOnAction(e -> {
			display.requestFocus();
			display.replaceSelection(")");
		});
		add(rightParentheses, 5, 1);

		equal = new JFXButton("=");
		equal.setMaxHeight(Double.MAX_VALUE);
		equal.setMaxWidth(Double.MAX_VALUE);
		equal.setFocusTraversable(false);
		equal.setDefaultButton(true);
		equal.getStyleClass().add("equal-button");
		equal.setOnAction(e -> {
			display.requestFocus();
			try {
				String text = display.getText();
				if(text.isEmpty()) return;

				Expression expr = Expression.parse(text);
				double rlt = expr.getResult();
				String rltStr = canConvertToInt(rlt) ? String.valueOf((int)rlt) : String.valueOf(rlt);

				display.setText(rltStr);
				display.end();
			} catch(NumberFormatException ex){
				display.setText("Malformed expression");
				display.end();
				ex.printStackTrace();
			} finally {
				display.selectAll();
			}
		});
		add(equal, 4, 4, 2, 1);
	}

	private boolean canConvertToInt(double before) {
		int after = (int)before;
		return before == after;
	}
}
