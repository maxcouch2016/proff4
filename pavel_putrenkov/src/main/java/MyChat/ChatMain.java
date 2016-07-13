package MyChat;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChatMain extends Application {
	private boolean isServer = true;//true for server,false for client
	private TextArea messages = new TextArea();
	private NetworkConection conection = isServer ? createServer() : createClient();

	private Parent createContent() {
		messages.setPrefHeight(550);
		TextField input = new TextField();
		input.setOnAction(event ->{
			String message= isServer? "Server:" : "Cient:";
			message +=input.getText();
			input.clear();
			messages.appendText(message+ "\n");
			
			try {
				conection.send(message);
			} catch (Exception e) {
				messages.appendText("Failed send"+ "\n");
			}
		});
		VBox root = new VBox(20, messages, input);
		root.setPrefSize(600, 600);
		return root;
	}

	@Override
	public void init() throws Exception {
		conection.startConnection();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setScene(new Scene(createContent()));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void stop() throws Exception {
		conection.closeConnection();
	}

	private Server createServer() {
		return new Server(5555, data -> {
			Platform.runLater(() -> {
				messages.appendText(data.toString() + "\n");
			});
		});

	}

	private Client createClient() {
		return new Client("127.0.0.1", 5555, data -> {
			Platform.runLater(() -> {
				messages.appendText(data.toString() + "\n");
			});
		});
	}

}
