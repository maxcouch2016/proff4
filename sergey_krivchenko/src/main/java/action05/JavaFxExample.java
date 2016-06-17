package action05;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

@SuppressWarnings("restriction")
public class JavaFxExample extends Application {
	public static void main(String[] args) {
		launch();
	}
  
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("MyApp");
		primaryStage.setScene(newScene());
		primaryStage.show();

	}

	public Scene newScene() {
		HBox box = new HBox();
		box.getChildren().add(new Button("aa"));
		box.getChildren().add(new Button("ab"));
		return new Scene(box, 200, 100);
		
	}

}
