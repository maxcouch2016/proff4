package calc2;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;

public class Main1 extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("ui2.fxml"));
		Scene scene = new Scene(root,252,310);
		scene.getStylesheets().add(getClass().getResource("application1.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setMaxWidth(268);
		primaryStage.setMaxHeight(345);
		primaryStage.setMinWidth(268);
		primaryStage.setMinHeight(345);
		primaryStage.setTitle("Mystic Calc");
		// Устанавливаем иконку приложения.
		primaryStage.getIcons().add(new Image("calc2/calculator.png"));
	}

	public static void main(String[] args) {
		launch(args);
	}
}
