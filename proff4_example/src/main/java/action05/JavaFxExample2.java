package action05;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class JavaFxExample2 extends Application {
	public static void main(String[] args) {
		launch(args);
	}
 
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Hint");
		stage.setScene(createScene());
		stage.show();
	}
	public Scene createScene(){
		HBox box = new HBox();
		Button btn = new Button("Ryjgrf");
		box.getChildren().add(btn);
		
		Tooltip tooltip = new Tooltip("Серега - это все для тебя");
		btn.setTooltip(tooltip);

		Scene scene = new Scene(box, 600, 400);
		return scene;		
	}

}
