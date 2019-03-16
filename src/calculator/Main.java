package calculator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;

public class Main extends Application {

	@Override
	public void start(Stage stage) {
		CalculatorPane root = new CalculatorPane();

		Scene scene = new Scene(root);
		scene.getStylesheets().add("/res/css/style.css");

		stage.setScene(scene);
		stage.setTitle("Calculator");
		stage.getIcons().add(new Image(getClass().getResourceAsStream("/res/img/calc.png")));
		stage.setMinWidth(400.0);
		stage.setMinHeight(350.0);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
