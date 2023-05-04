package application;

import javafx.application.Application;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class main extends Application {
	public static final int WIDTH = 1200, HEIGHT = 800;

	public void start(Stage stage) // start up method
	{
		StackPane root = new StackPane();
		GameInterface mainPane = new GameInterface();
		root.getChildren().add(mainPane);

		Scene scene = new Scene(root);
		stage.setTitle("NBA Guesser Game"); // name
		stage.getIcons().add(new Image("https://seeklogo.com/images/N/nba-logo-59F0731E03-seeklogo.com.png"));
		stage.setScene(scene);
		stage.show(); // shows scene, displays
	}

	public static void main(String[] args) {
		launch(args); // launch
	}

}
