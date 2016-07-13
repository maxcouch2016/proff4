package myCalc;

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
		Scene scene = new Scene(root, 295, 390);
		scene.getStylesheets().add(getClass().getResource("application1.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setMaxWidth(289);
		primaryStage.setMaxHeight(389);
		primaryStage.setMinWidth(289);
		primaryStage.setMinHeight(389);
		primaryStage.setTitle("Mystic Calc");

		// IconAdd.
		primaryStage.getIcons().add(new Image("myCalc/calculator.png"));

	}

	public static void main(String[] args) {
		launch(args);
	}
}
