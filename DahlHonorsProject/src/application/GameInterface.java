package application;

import java.util.Random;
import javafx.application.Application;
import javafx.application.Platform;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.NotSerializableException;
import java.util.ArrayList;

import java.util.Collection;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class GameInterface extends HBox {
	public static final int WIDTH = 1200, HEIGHT = 800;
	// global variables
	ArrayList<Player> playerList = new ArrayList<>(); // list of players
	ArrayList<Player> starterList = new ArrayList<>(); // list of starters
	Button start = new Button("Start Game"); // buttons
	Button exitGame = new Button("Exit Game");
	Button newGame = new Button("New Game");
	Button easyNewGame = new Button("New Game");
	Button copy = new Button("Copy");
	Button forfeit = new Button("Give Up?");
	Button easyMode = new Button("Easy Mode");
	Button normalMode = new Button("Basic Mode");
	TextField guessField = new TextField(); // text field for input
	ComboBox playerNames; // combobox for names
	ComboBox modeList; // does nothing
	Label triesCounter; // label
	Label winsCounter;
	int counter;
	int wins = 0;
	// random number
	Random rand = new Random(); // random count to find player to guess
	int randomNumber;
	// guessing pane nodes
	GridPane resultsPane;
	String randomName, randomConf, randomDiv, randomTeam, randomPos; // random player attributes
	int randomNum, randomHeight, randomWeight;
	String inputName, inputConf, inputDiv, inputTeam, inputPos; // input player attributes
	int inputNum, inputHeight, inputWeight;
	// labels for putting in grid box
	Label name1, conf1, div1, team1, num1, height1, weight1, pos1;
	Label name2, conf2, div2, team2, num2, height2, weight2, pos2;
	Label name3, conf3, div3, team3, num3, height3, weight3, pos3;
	Label name4, conf4, div4, team4, num4, height4, weight4, pos4;
	Label name5, conf5, div5, team5, num5, height5, weight5, pos5;
	Label name6, conf6, div6, team6, num6, height6, weight6, pos6;
	Label name7, conf7, div7, team7, num7, height7, weight7, pos7;
	Label name8, conf8, div8, team8, num8, height8, weight8, pos8;
	Label name9, conf9, div9, team9, num9, height9, weight9, pos9;

	public GameInterface() { // game interface is the first thing that runs, runs methods
		playerList = InterfaceHelper.playerReader();
		starterList = InterfaceHelper.starterReader();
		startMenu();
	}

	public void startMenu() {
		// main menu stuff
		BorderPane menuPane = new BorderPane();
		GridPane centerPane = new GridPane();
		// layout
		centerPane.add(start, 0, 0);
		centerPane.setVgap(10);
		centerPane.setAlignment(Pos.CENTER);
		// handlers
		start.setOnAction(new ButtonHandler());
		start.setStyle("-fx-font-size: 15px;" + "-fx-font-family: Helvetica;");
		start.setPadding(new Insets(5, 5, 5, 5));
		start.setPrefWidth(100);
		// compiles
		getChildren().add(menuPane);
		menuPane.setPrefHeight(600);
		menuPane.setPrefWidth(1600);
		menuPane.setCenter(centerPane);
		this.setPrefHeight(HEIGHT);
		// this.setMaxHeight(800);
		this.setPrefWidth(WIDTH);
		// this.setMaxWidth(1600);
	}

	public void gameLayout() {
		// general panes
		BorderPane mainPane = new BorderPane();
		BorderPane topPane = new BorderPane();
		BorderPane middlePane = new BorderPane();
		BorderPane leftPane = new BorderPane();
		BorderPane helper = new BorderPane();
		BorderPane bottomPane = new BorderPane();
		// top
		GridPane topGridPane = new GridPane();
		// top center
		Label guessLabel = new Label("Enter Player Name:");
		playerNames = new ComboBox();
		// mid mid pane
		resultsPane = new GridPane();
		// mid mid Labels
		Label name = new Label("Name");
		Label conference = new Label("Conference");
		Label division = new Label("Division");
		Label team = new Label("Team");
		Label number = new Label("Number");
		Label height = new Label("Height");
		Label weight = new Label("Weight");
		Label position = new Label("Position");
		// left
		BorderPane leftLayout = new BorderPane();
		GridPane settingsPane = new GridPane();
		winsCounter = new Label("Wins: " + wins);
		// bottom
		GridPane bottomGrid = new GridPane();
		Label atlantic = new Label("Atlantic: Celtics, Nets, Knicks, 76ers, Raptors");
		Label central = new Label("Central: Cavaliers, Bulls, Pistons, Pacers, Bucks");
		Label southeast = new Label("South East: Hawks, Hornets, Heat, Magic, Wizards");
		Label northwest = new Label("North West: Nuggets, Timberwolves, Trail Blazers, Thunder, Jazz");
		Label pacific = new Label("Pacific: Warriors, Clippers, Lakers, Suns, Kings");
		Label southwest = new Label("South West: Mavericks, Rockets, Grizzlies, Pelicans, Spurs");

		// middle middle VBoxes/labels
		resultsPane.add(name, 0, 0);
		name.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
		name.setPadding(new Insets(5, 5, 5, 5));
		name.setPrefWidth(210);
		name.setAlignment(Pos.CENTER);

		resultsPane.add(conference, 1, 0);
		conference.setPadding(new Insets(5, 5, 5, 5));
		conference.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
		conference.setPrefWidth(210);
		conference.setAlignment(Pos.CENTER);

		resultsPane.add(division, 2, 0);
		division.setPadding(new Insets(5, 5, 5, 5));
		division.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
		division.setPrefWidth(210);
		division.setAlignment(Pos.CENTER);

		resultsPane.add(team, 3, 0);
		team.setPadding(new Insets(5, 5, 5, 5));
		team.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
		team.setPrefWidth(210);
		team.setAlignment(Pos.CENTER);

		resultsPane.add(number, 4, 0);
		number.setPadding(new Insets(5, 5, 5, 5));
		number.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
		number.setPrefWidth(210);
		number.setAlignment(Pos.CENTER);

		resultsPane.add(height, 5, 0);
		height.setPadding(new Insets(5, 5, 5, 5));
		height.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
		height.setPrefWidth(210);
		height.setAlignment(Pos.CENTER);

		resultsPane.add(weight, 6, 0);
		weight.setPadding(new Insets(5, 5, 5, 5));
		weight.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
		weight.setPrefWidth(210);
		weight.setAlignment(Pos.CENTER);

		resultsPane.add(position, 7, 0);
		position.setPadding(new Insets(5, 5, 5, 5));
		position.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
		position.setPrefWidth(210);
		position.setAlignment(Pos.CENTER);
		// middle padding and gap
		resultsPane.setGridLinesVisible(true);
		middlePane.setCenter(resultsPane);
		resultsPane.setAlignment(Pos.TOP_CENTER);
		middlePane.setPadding(new Insets(10, 10, 10, 10));
		// top middle
		InterfaceHelper.quickSortByName(playerList); // sorts list for combo box
		for (int i = 0; i < playerList.size(); i++) {
			playerNames.getItems().add(playerList.get(i).getName());
		}

		triesCounter = new Label("Tries Left: 8");
		topGridPane.setHgap(10);
		topGridPane.setAlignment(Pos.CENTER);
		topGridPane.add(triesCounter, 0, 0);
		topGridPane.add(guessLabel, 1, 0);
		topGridPane.add(guessField, 2, 0);
		topGridPane.add(playerNames, 3, 0);
		topGridPane.add(copy, 4, 0);
		guessField.setOnAction(new TextFieldHandler());
		copy.setOnAction(new ButtonHandler());
		triesCounter.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
		guessLabel.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
		guessField.setStyle("-fx-font-size: 14px;" + "-fx-font-family: Helvetica;");
		playerNames.setStyle("-fx-font-size: 14px;" + "-fx-font-family: Helvetica;");
		copy.setStyle("-fx-font-size: 14px;" + "-fx-font-family: Helvetica;");
		playerNames.setPrefWidth(225);
		topPane.setCenter(topGridPane);
		topPane.setPadding(new Insets(10, 10, 10, 10));
		// left
		settingsPane.add(newGame, 0, 1);
		newGame.setStyle("-fx-font-size: 15px;" + "-fx-font-family: Helvetica;");
		newGame.setPadding(new Insets(5, 5, 5, 5));
		newGame.setOnAction(new ButtonHandler());

		settingsPane.add(easyMode, 0, 2);
		easyMode.setStyle("-fx-font-size: 15px;" + "-fx-font-family: Helvetica;");
		easyMode.setPadding(new Insets(5, 5, 5, 5));
		easyMode.setOnAction(new ButtonHandler());

		settingsPane.add(forfeit, 0, 3);
		forfeit.setStyle("-fx-font-size: 15px;" + "-fx-font-family: Helvetica;");
		forfeit.setPadding(new Insets(5, 5, 5, 5));
		forfeit.setOnAction(new ButtonHandler());

		settingsPane.add(exitGame, 0, 4);
		exitGame.setStyle("-fx-font-size: 15px;" + "-fx-font-family: Helvetica;");
		exitGame.setPadding(new Insets(5, 5, 5, 5));
		exitGame.setOnAction(new ButtonHandler());

		settingsPane.add(winsCounter, 0, 5);
		winsCounter.setStyle("-fx-font-size: 14px;" + "-fx-font-family: Helvetica;");
		winsCounter.setPadding(new Insets(5, 5, 5, 5));

		settingsPane.setVgap(5);
		settingsPane.setPrefWidth(100);
		settingsPane.setMaxWidth(100);
		settingsPane.setPrefHeight(200);
		settingsPane.setMaxHeight(100);

		leftLayout.setCenter(settingsPane);
		// bottom
		bottomGrid.add(southwest, 0, 0);
		bottomGrid.add(pacific, 0, 1);
		bottomGrid.add(northwest, 0, 2);
		bottomGrid.add(atlantic, 1, 0);
		bottomGrid.add(central, 1, 1);
		bottomGrid.add(southeast, 1, 2);

		bottomGrid.setAlignment(Pos.CENTER);
		bottomGrid.setHgap(5);
		bottomGrid.setVgap(1);

		bottomPane.setPadding(new Insets(5, 5, 5, 5));
		bottomPane.setCenter(bottomGrid);
		// main border set
		topPane.setStyle("-fx-border-style: solid;");
		middlePane.setStyle("-fx-border-style: solid;");
		// finalization
		helper.setCenter(middlePane);
		helper.setTop(topPane);
		mainPane.setCenter(helper);
		mainPane.setLeft(settingsPane);
		mainPane.setBottom(bottomPane);
		mainPane.setPrefWidth(1600);
		mainPane.setPrefHeight(800);
		getChildren().add(mainPane);
		this.setPadding(new Insets(10, 10, 10, 10));
		this.setPrefHeight(600);
		this.setMaxHeight(800);
		this.setPrefWidth(1600);
		this.setMaxWidth(1600);
	}

	public void easyGameLayout() {
		// general panes
		BorderPane mainPane = new BorderPane();
		BorderPane topPane = new BorderPane();
		BorderPane middlePane = new BorderPane();
		BorderPane leftPane = new BorderPane();
		BorderPane helper = new BorderPane();
		BorderPane bottomPane = new BorderPane();
		// top
		GridPane topGridPane = new GridPane();
		// top center
		Label guessLabel = new Label("Enter Player Name:");
		playerNames = new ComboBox();
		// mid mid pane
		resultsPane = new GridPane();
		// mid mid Labels
		Label name = new Label("Name");
		Label conference = new Label("Conference");
		Label division = new Label("Division");
		Label team = new Label("Team");
		Label number = new Label("Number");
		Label height = new Label("Height");
		Label weight = new Label("Weight");
		Label position = new Label("Position");
		// left
		BorderPane leftLayout = new BorderPane();
		GridPane settingsPane = new GridPane();
		winsCounter = new Label("Wins: " + wins);
		// bottom
		GridPane bottomGrid = new GridPane();
		Label atlantic = new Label("Atlantic: Celtics, Nets, Knicks, 76ers, Raptors");
		Label central = new Label("Central: Cavaliers, Bulls, Pistons, Pacers, Bucks");
		Label southeast = new Label("South East: Hawks, Hornets, Heat, Magic, Wizards");
		Label northwest = new Label("North West: Nuggets, Timberwolves, Trail Blazers, Thunder, Jazz");
		Label pacific = new Label("Pacific: Warriors, Clippers, Lakers, Suns, Kings");
		Label southwest = new Label("South West: Mavericks, Rockets, Grizzlies, Pelicans, Spurs");

		// middle middle VBoxes/labels
		resultsPane.add(name, 0, 0);
		name.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
		name.setPadding(new Insets(5, 5, 5, 5));
		name.setPrefWidth(210);
		name.setAlignment(Pos.CENTER);

		resultsPane.add(conference, 1, 0);
		conference.setPadding(new Insets(5, 5, 5, 5));
		conference.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
		conference.setPrefWidth(210);
		conference.setAlignment(Pos.CENTER);

		resultsPane.add(division, 2, 0);
		division.setPadding(new Insets(5, 5, 5, 5));
		division.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
		division.setPrefWidth(210);
		division.setAlignment(Pos.CENTER);

		resultsPane.add(team, 3, 0);
		team.setPadding(new Insets(5, 5, 5, 5));
		team.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
		team.setPrefWidth(210);
		team.setAlignment(Pos.CENTER);

		resultsPane.add(number, 4, 0);
		number.setPadding(new Insets(5, 5, 5, 5));
		number.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
		number.setPrefWidth(210);
		number.setAlignment(Pos.CENTER);

		resultsPane.add(height, 5, 0);
		height.setPadding(new Insets(5, 5, 5, 5));
		height.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
		height.setPrefWidth(210);
		height.setAlignment(Pos.CENTER);

		resultsPane.add(weight, 6, 0);
		weight.setPadding(new Insets(5, 5, 5, 5));
		weight.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
		weight.setPrefWidth(210);
		weight.setAlignment(Pos.CENTER);

		resultsPane.add(position, 7, 0);
		position.setPadding(new Insets(5, 5, 5, 5));
		position.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
		position.setPrefWidth(210);
		position.setAlignment(Pos.CENTER);
		// middle padding and gap
		resultsPane.setGridLinesVisible(true);
		middlePane.setCenter(resultsPane);
		resultsPane.setAlignment(Pos.TOP_CENTER);
		middlePane.setPadding(new Insets(10, 10, 10, 10));
		// top middle
		InterfaceHelper.quickSortByName(starterList); // sorts list for combo box
		for (int i = 0; i < starterList.size(); i++) {
			playerNames.getItems().add(starterList.get(i).getName());
		}

		triesCounter = new Label("Tries Left: 8");
		topGridPane.setHgap(10);
		topGridPane.setAlignment(Pos.CENTER);
		topGridPane.add(triesCounter, 0, 0);
		topGridPane.add(guessLabel, 1, 0);
		topGridPane.add(guessField, 2, 0);
		topGridPane.add(playerNames, 3, 0);
		topGridPane.add(copy, 4, 0);
		guessField.setOnAction(new TextFieldHandler());
		copy.setOnAction(new ButtonHandler());
		triesCounter.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
		guessLabel.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
		guessField.setStyle("-fx-font-size: 14px;" + "-fx-font-family: Helvetica;");
		playerNames.setStyle("-fx-font-size: 14px;" + "-fx-font-family: Helvetica;");
		copy.setStyle("-fx-font-size: 14px;" + "-fx-font-family: Helvetica;");
		playerNames.setPrefWidth(225);
		topPane.setCenter(topGridPane);
		topPane.setPadding(new Insets(10, 10, 10, 10));
		// left
		settingsPane.add(easyNewGame, 0, 1);
		easyNewGame.setStyle("-fx-font-size: 15px;" + "-fx-font-family: Helvetica;");
		easyNewGame.setPadding(new Insets(5, 5, 5, 5));
		easyNewGame.setOnAction(new ButtonHandler());

		settingsPane.add(normalMode, 0, 2);
		normalMode.setStyle("-fx-font-size: 15px;" + "-fx-font-family: Helvetica;");
		normalMode.setPadding(new Insets(5, 5, 5, 5));
		normalMode.setOnAction(new ButtonHandler());

		settingsPane.add(forfeit, 0, 3);
		forfeit.setStyle("-fx-font-size: 15px;" + "-fx-font-family: Helvetica;");
		forfeit.setPadding(new Insets(5, 5, 5, 5));
		forfeit.setOnAction(new ButtonHandler());

		settingsPane.add(exitGame, 0, 4);
		exitGame.setStyle("-fx-font-size: 15px;" + "-fx-font-family: Helvetica;");
		exitGame.setPadding(new Insets(5, 5, 5, 5));
		exitGame.setOnAction(new ButtonHandler());

		settingsPane.add(winsCounter, 0, 5);
		winsCounter.setStyle("-fx-font-size: 14px;" + "-fx-font-family: Helvetica;");
		winsCounter.setPadding(new Insets(5, 5, 5, 5));

		settingsPane.setVgap(5);
		settingsPane.setPrefWidth(100);
		settingsPane.setMaxWidth(100);
		settingsPane.setPrefHeight(200);
		settingsPane.setMaxHeight(100);

		leftLayout.setCenter(settingsPane);
		// bottom
		bottomGrid.add(southwest, 0, 0);
		bottomGrid.add(pacific, 0, 1);
		bottomGrid.add(northwest, 0, 2);
		bottomGrid.add(atlantic, 1, 0);
		bottomGrid.add(central, 1, 1);
		bottomGrid.add(southeast, 1, 2);

		bottomGrid.setAlignment(Pos.CENTER);
		bottomGrid.setHgap(5);
		bottomGrid.setVgap(1);

		bottomPane.setPadding(new Insets(5, 5, 5, 5));
		bottomPane.setCenter(bottomGrid);
		// main border set
		topPane.setStyle("-fx-border-style: solid;");
		middlePane.setStyle("-fx-border-style: solid;");
		// finalization
		helper.setCenter(middlePane);
		helper.setTop(topPane);
		mainPane.setCenter(helper);
		mainPane.setLeft(settingsPane);
		mainPane.setBottom(bottomPane);
		mainPane.setPrefWidth(1600);
		mainPane.setPrefHeight(800);
		getChildren().add(mainPane);
		this.setPadding(new Insets(10, 10, 10, 10));
		this.setPrefHeight(600);
		this.setMaxHeight(800);
		this.setPrefWidth(1600);
		this.setMaxWidth(1600);
	}

	private class TextFieldHandler implements EventHandler<ActionEvent> { // text field handler
		public void handle(ActionEvent e) { // handler
			Object source = e.getSource();
			if (source == guessField) { // if source is player guesser
				inputName = guessField.getText();
				int index = 0;
				for (int i = 0; i < playerList.size(); i++) { // checks the list if the player exists, and tracks index
					index++;
					if (inputName.equalsIgnoreCase(playerList.get(i).getName())) {
						index = i;
						i = playerList.size();
					}
				}
				if (index < playerList.size()) { // if the index is within the bounds, then it checks
					int feet;
					int inch;
					// creates variables for input
					inputConf = playerList.get(index).getConf();
					inputDiv = playerList.get(index).getDiv();
					inputTeam = playerList.get(index).getTeam();
					inputNum = playerList.get(index).getNum();
					inputHeight = playerList.get(index).getHt();
					inputWeight = playerList.get(index).getWt();
					inputPos = playerList.get(index).getPos();
					guessField.clear(); // clears guess field
					counter++; // ups counter for tries

					if (inputName.equalsIgnoreCase(randomName)) { // if the guess is right to the random player
						feet = randomHeight / 12;
						inch = randomHeight % 12;
						triesCounter.setText("Tries Left: " + (8 - counter)); // docks counter
						// initializes the labels for entry
						name9 = new Label(randomName);
						conf9 = new Label(randomConf);
						div9 = new Label(randomDiv);
						team9 = new Label(randomTeam);
						num9 = new Label(String.valueOf(randomNum));
						height9 = new Label(String.valueOf(feet) + "'" + String.valueOf(inch) + "\"");
						weight9 = new Label(String.valueOf(randomWeight) + " lbs");
						pos9 = new Label(randomPos);

						name9.setPrefWidth(210);
						conf9.setPrefWidth(210);
						div9.setPrefWidth(210);
						team9.setPrefWidth(210);
						num9.setPrefWidth(210);
						height9.setPrefWidth(210);
						weight9.setPrefWidth(210);
						pos9.setPrefWidth(210);

						name9.setStyle("-fx-background-color: limegreen;" + "-fx-font-size: 20px;"
								+ "-fx-font-family: Helvetica;");
						conf9.setStyle("-fx-background-color: limegreen;" + "-fx-font-size: 20px;"
								+ "-fx-font-family: Helvetica;");
						div9.setStyle("-fx-background-color: limegreen;" + "-fx-font-size: 20px;"
								+ "-fx-font-family: Helvetica;");
						team9.setStyle("-fx-background-color: limegreen;" + "-fx-font-size: 20px;"
								+ "-fx-font-family: Helvetica;");
						num9.setStyle("-fx-background-color: limegreen;" + "-fx-font-size: 20px;"
								+ "-fx-font-family: Helvetica;");
						height9.setStyle("-fx-background-color: limegreen;" + "-fx-font-size: 20px;"
								+ "-fx-font-family: Helvetica;");
						weight9.setStyle("-fx-background-color: limegreen;" + "-fx-font-size: 20px;"
								+ "-fx-font-family: Helvetica;");
						pos9.setStyle("-fx-background-color: limegreen;" + "-fx-font-size: 20px;"
								+ "-fx-font-family: Helvetica;");

						name9.setAlignment(Pos.CENTER);
						conf9.setAlignment(Pos.CENTER);
						div9.setAlignment(Pos.CENTER);
						team9.setAlignment(Pos.CENTER);
						num9.setAlignment(Pos.CENTER);
						height9.setAlignment(Pos.CENTER);
						weight9.setAlignment(Pos.CENTER);
						pos9.setAlignment(Pos.CENTER);

						resultsPane.add(name9, 0, 9);
						resultsPane.add(conf9, 1, 9);
						resultsPane.add(div9, 2, 9);
						resultsPane.add(team9, 3, 9);
						resultsPane.add(num9, 4, 9);
						resultsPane.add(height9, 5, 9);
						resultsPane.add(weight9, 6, 9);
						resultsPane.add(pos9, 7, 9);

						wins++;

					} else { // if not right, it then sequentially goes through each counter to update new
								// labels
						if (counter == 1) {
							feet = inputHeight / 12;
							inch = inputHeight % 12;
							triesCounter.setText("Tries Left: " + (8 - counter));
							name1 = new Label(inputName);
							conf1 = new Label(inputConf);
							div1 = new Label(inputDiv);
							team1 = new Label(inputTeam);
							num1 = new Label(String.valueOf(inputNum));
							height1 = new Label(String.valueOf(feet) + "'" + String.valueOf(inch) + "\"");
							weight1 = new Label(String.valueOf(inputWeight) + " lbs");
							pos1 = new Label(inputPos);

							name1.setPrefWidth(210);
							conf1.setPrefWidth(210);
							div1.setPrefWidth(210);
							team1.setPrefWidth(210);
							num1.setPrefWidth(210);
							height1.setPrefWidth(210);
							weight1.setPrefWidth(210);
							pos1.setPrefWidth(210);

							name1.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
							if (randomConf.equals(inputConf))
								conf1.setStyle("-fx-background-color: limegreen;" + "-fx-font-size: 20px;"
										+ "-fx-font-family: Helvetica;");
							else
								conf1.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
							if (randomDiv.equals(inputDiv))
								div1.setStyle("-fx-background-color: limegreen;" + "-fx-font-size: 20px;"
										+ "-fx-font-family: Helvetica;");
							else
								div1.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
							if (randomTeam.equals(inputTeam))
								team1.setStyle("-fx-background-color: limegreen;" + "-fx-font-size: 20px;"
										+ "-fx-font-family: Helvetica;");
							else
								team1.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
							if (randomNum == inputNum) {
								num1.setStyle("-fx-background-color: limegreen;" + "-fx-font-size: 20px;"
										+ "-fx-font-family: Helvetica;");
							} else {
								if (randomNum <= inputNum + 8 && randomNum >= inputNum - 8) {
									num1.setStyle("-fx-background-color: yellow;" + "-fx-font-size: 20px;"
											+ "-fx-font-family: Helvetica;");
								} else {
									num1.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
								}
							}
							if (randomHeight == inputHeight) {
								height1.setStyle("-fx-background-color: limegreen;" + "-fx-font-size: 20px;"
										+ "-fx-font-family: Helvetica;");
							} else {
								if (randomHeight <= inputHeight + 2 && randomHeight >= inputHeight - 2) {
									height1.setStyle("-fx-background-color: yellow;" + "-fx-font-size: 20px;"
											+ "-fx-font-family: Helvetica;");
								} else {
									height1.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
								}
							}
							if (randomWeight == inputWeight) {
								weight1.setStyle("-fx-background-color: limegreen;" + "-fx-font-size: 20px;"
										+ "-fx-font-family: Helvetica;");
							} else {
								if (randomWeight <= inputWeight + 15 && randomWeight >= inputWeight - 15) {
									weight1.setStyle("-fx-background-color: yellow;" + "-fx-font-size: 20px;"
											+ "-fx-font-family: Helvetica;");
								} else {
									weight1.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
								}
							}
							if (randomPos.equals(inputPos))
								pos1.setStyle("-fx-background-color: limegreen;" + "-fx-font-size: 20px;"
										+ "-fx-font-family: Helvetica;");
							else
								pos1.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");

							name1.setAlignment(Pos.CENTER);
							conf1.setAlignment(Pos.CENTER);
							div1.setAlignment(Pos.CENTER);
							team1.setAlignment(Pos.CENTER);
							num1.setAlignment(Pos.CENTER);
							height1.setAlignment(Pos.CENTER);
							weight1.setAlignment(Pos.CENTER);
							pos1.setAlignment(Pos.CENTER);

							resultsPane.add(name1, 0, 1);
							resultsPane.add(conf1, 1, 1);
							resultsPane.add(div1, 2, 1);
							resultsPane.add(team1, 3, 1);
							resultsPane.add(num1, 4, 1);
							resultsPane.add(height1, 5, 1);
							resultsPane.add(weight1, 6, 1);
							resultsPane.add(pos1, 7, 1);
						}
						if (counter == 2) {
							feet = inputHeight / 12;
							inch = inputHeight % 12;
							triesCounter.setText("Tries Left: " + (8 - counter));
							name2 = new Label(inputName);
							conf2 = new Label(inputConf);
							div2 = new Label(inputDiv);
							team2 = new Label(inputTeam);
							num2 = new Label(String.valueOf(inputNum));
							height2 = new Label(String.valueOf(feet) + "'" + String.valueOf(inch) + "\"");
							weight2 = new Label(String.valueOf(inputWeight) + " lbs");
							pos2 = new Label(inputPos);

							name2.setPrefWidth(210);
							conf2.setPrefWidth(210);
							div2.setPrefWidth(210);
							team2.setPrefWidth(210);
							num2.setPrefWidth(210);
							height2.setPrefWidth(210);
							weight2.setPrefWidth(210);
							pos2.setPrefWidth(210);

							name2.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
							if (randomConf.equals(inputConf))
								conf2.setStyle("-fx-background-color: limegreen;" + "-fx-font-size: 20px;"
										+ "-fx-font-family: Helvetica;");
							else
								conf2.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
							if (randomDiv.equals(inputDiv))
								div2.setStyle("-fx-background-color: limegreen;" + "-fx-font-size: 20px;"
										+ "-fx-font-family: Helvetica;");
							else
								div2.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
							if (randomTeam.equals(inputTeam))
								team2.setStyle("-fx-background-color: limegreen;" + "-fx-font-size: 20px;"
										+ "-fx-font-family: Helvetica;");
							else
								team2.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
							if (randomNum == inputNum) {
								num2.setStyle("-fx-background-color: limegreen;" + "-fx-font-size: 20px;"
										+ "-fx-font-family: Helvetica;");
							} else {
								if (randomNum <= inputNum + 8 && randomNum >= inputNum - 8) {
									num2.setStyle("-fx-background-color: yellow;" + "-fx-font-size: 20px;"
											+ "-fx-font-family: Helvetica;");
								} else {
									num2.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
								}
							}
							if (randomHeight == inputHeight) {
								height2.setStyle("-fx-background-color: limegreen;" + "-fx-font-size: 20px;"
										+ "-fx-font-family: Helvetica;");
							} else {
								if (randomHeight <= inputHeight + 2 && randomHeight >= inputHeight - 2) {
									height2.setStyle("-fx-background-color: yellow;" + "-fx-font-size: 20px;"
											+ "-fx-font-family: Helvetica;");
								} else {
									height2.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
								}
							}
							if (randomWeight == inputWeight) {
								weight2.setStyle("-fx-background-color: limegreen;" + "-fx-font-size: 20px;"
										+ "-fx-font-family: Helvetica;");
							} else {
								if (randomWeight <= inputWeight + 15 && randomWeight >= inputWeight - 15) {
									weight2.setStyle("-fx-background-color: yellow;" + "-fx-font-size: 20px;"
											+ "-fx-font-family: Helvetica;");
								} else {
									weight2.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
								}
							}
							if (randomPos.equals(inputPos))
								pos2.setStyle("-fx-background-color: limegreen;" + "-fx-font-size: 20px;"
										+ "-fx-font-family: Helvetica;");
							else
								pos2.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");

							name2.setAlignment(Pos.CENTER);
							conf2.setAlignment(Pos.CENTER);
							div2.setAlignment(Pos.CENTER);
							team2.setAlignment(Pos.CENTER);
							num2.setAlignment(Pos.CENTER);
							height2.setAlignment(Pos.CENTER);
							weight2.setAlignment(Pos.CENTER);
							pos2.setAlignment(Pos.CENTER);

							resultsPane.add(name2, 0, 2);
							resultsPane.add(conf2, 1, 2);
							resultsPane.add(div2, 2, 2);
							resultsPane.add(team2, 3, 2);
							resultsPane.add(num2, 4, 2);
							resultsPane.add(height2, 5, 2);
							resultsPane.add(weight2, 6, 2);
							resultsPane.add(pos2, 7, 2);
						}
						if (counter == 3) {
							feet = inputHeight / 12;
							inch = inputHeight % 12;
							triesCounter.setText("Tries Left: " + (8 - counter));
							name3 = new Label(inputName);
							conf3 = new Label(inputConf);
							div3 = new Label(inputDiv);
							team3 = new Label(inputTeam);
							num3 = new Label(String.valueOf(inputNum));
							height3 = new Label(String.valueOf(feet) + "'" + String.valueOf(inch) + "\"");
							weight3 = new Label(String.valueOf(inputWeight) + " lbs");
							pos3 = new Label(inputPos);

							name3.setPrefWidth(210);
							conf3.setPrefWidth(210);
							div3.setPrefWidth(210);
							team3.setPrefWidth(210);
							num3.setPrefWidth(210);
							height3.setPrefWidth(210);
							weight3.setPrefWidth(210);
							pos3.setPrefWidth(210);

							name3.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
							if (randomConf.equals(inputConf))
								conf3.setStyle("-fx-background-color: limegreen;" + "-fx-font-size: 20px;"
										+ "-fx-font-family: Helvetica;");
							else
								conf3.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
							if (randomDiv.equals(inputDiv))
								div3.setStyle("-fx-background-color: limegreen;" + "-fx-font-size: 20px;"
										+ "-fx-font-family: Helvetica;");
							else
								div3.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
							if (randomTeam.equals(inputTeam))
								team3.setStyle("-fx-background-color: limegreen;" + "-fx-font-size: 20px;"
										+ "-fx-font-family: Helvetica;");
							else
								team3.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
							if (randomNum == inputNum) {
								num3.setStyle("-fx-background-color: limegreen;" + "-fx-font-size: 20px;"
										+ "-fx-font-family: Helvetica;");
							} else {
								if (randomNum <= inputNum + 8 && randomNum >= inputNum - 8) {
									num3.setStyle("-fx-background-color: yellow;" + "-fx-font-size: 20px;"
											+ "-fx-font-family: Helvetica;");
								} else {
									num3.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
								}
							}
							if (randomHeight == inputHeight) {
								height3.setStyle("-fx-background-color: limegreen;" + "-fx-font-size: 20px;"
										+ "-fx-font-family: Helvetica;");
							} else {
								if (randomHeight <= inputHeight + 2 && randomHeight >= inputHeight - 2) {
									height3.setStyle("-fx-background-color: yellow;" + "-fx-font-size: 20px;"
											+ "-fx-font-family: Helvetica;");
								} else {
									height3.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
								}
							}
							if (randomWeight == inputWeight) {
								weight3.setStyle("-fx-background-color: limegreen;" + "-fx-font-size: 20px;"
										+ "-fx-font-family: Helvetica;");
							} else {
								if (randomWeight <= inputWeight + 15 && randomWeight >= inputWeight - 15) {
									weight3.setStyle("-fx-background-color: yellow;" + "-fx-font-size: 20px;"
											+ "-fx-font-family: Helvetica;");
								} else {
									weight3.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
								}
							}
							if (randomPos.equals(inputPos))
								pos3.setStyle("-fx-background-color: limegreen;" + "-fx-font-size: 20px;"
										+ "-fx-font-family: Helvetica;");
							else
								pos3.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");

							name3.setAlignment(Pos.CENTER);
							conf3.setAlignment(Pos.CENTER);
							div3.setAlignment(Pos.CENTER);
							team3.setAlignment(Pos.CENTER);
							num3.setAlignment(Pos.CENTER);
							height3.setAlignment(Pos.CENTER);
							weight3.setAlignment(Pos.CENTER);
							pos3.setAlignment(Pos.CENTER);

							resultsPane.add(name3, 0, 3);
							resultsPane.add(conf3, 1, 3);
							resultsPane.add(div3, 2, 3);
							resultsPane.add(team3, 3, 3);
							resultsPane.add(num3, 4, 3);
							resultsPane.add(height3, 5, 3);
							resultsPane.add(weight3, 6, 3);
							resultsPane.add(pos3, 7, 3);

						}
						if (counter == 4) {
							feet = inputHeight / 12;
							inch = inputHeight % 12;
							triesCounter.setText("Tries Left: " + (8 - counter));
							name4 = new Label(inputName);
							conf4 = new Label(inputConf);
							div4 = new Label(inputDiv);
							team4 = new Label(inputTeam);
							num4 = new Label(String.valueOf(inputNum));
							height4 = new Label(String.valueOf(feet) + "'" + String.valueOf(inch) + "\"");
							weight4 = new Label(String.valueOf(inputWeight) + " lbs");
							pos4 = new Label(inputPos);

							name4.setPrefWidth(210);
							conf4.setPrefWidth(210);
							div4.setPrefWidth(210);
							team4.setPrefWidth(210);
							num4.setPrefWidth(210);
							height4.setPrefWidth(210);
							weight4.setPrefWidth(210);
							pos4.setPrefWidth(210);

							name4.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
							if (randomConf.equals(inputConf))
								conf4.setStyle("-fx-background-color: limegreen;" + "-fx-font-size: 20px;"
										+ "-fx-font-family: Helvetica;");
							else
								conf4.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
							if (randomDiv.equals(inputDiv))
								div4.setStyle("-fx-background-color: limegreen;" + "-fx-font-size: 20px;"
										+ "-fx-font-family: Helvetica;");
							else
								div4.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
							if (randomTeam.equals(inputTeam))
								team4.setStyle("-fx-background-color: limegreen;" + "-fx-font-size: 20px;"
										+ "-fx-font-family: Helvetica;");
							else
								team4.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
							if (randomNum == inputNum) {
								num4.setStyle("-fx-background-color: limegreen;" + "-fx-font-size: 20px;"
										+ "-fx-font-family: Helvetica;");
							} else {
								if (randomNum <= inputNum + 8 && randomNum >= inputNum - 8) {
									num4.setStyle("-fx-background-color: yellow;" + "-fx-font-size: 20px;"
											+ "-fx-font-family: Helvetica;");
								} else {
									num4.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
								}
							}
							if (randomHeight == inputHeight) {
								height4.setStyle("-fx-background-color: limegreen;" + "-fx-font-size: 20px;"
										+ "-fx-font-family: Helvetica;");
							} else {
								if (randomHeight <= inputHeight + 2 && randomHeight >= inputHeight - 2) {
									height4.setStyle("-fx-background-color: yellow;" + "-fx-font-size: 20px;"
											+ "-fx-font-family: Helvetica;");
								} else {
									height4.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
								}
							}
							if (randomWeight == inputWeight) {
								weight4.setStyle("-fx-background-color: limegreen;" + "-fx-font-size: 20px;"
										+ "-fx-font-family: Helvetica;");
							} else {
								if (randomWeight <= inputWeight + 15 && randomWeight >= inputWeight - 15) {
									weight4.setStyle("-fx-background-color: yellow;" + "-fx-font-size: 20px;"
											+ "-fx-font-family: Helvetica;");
								} else {
									weight4.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
								}
							}
							if (randomPos.equals(inputPos))
								pos4.setStyle("-fx-background-color: limegreen;" + "-fx-font-size: 20px;"
										+ "-fx-font-family: Helvetica;");
							else
								pos4.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");

							name4.setAlignment(Pos.CENTER);
							conf4.setAlignment(Pos.CENTER);
							div4.setAlignment(Pos.CENTER);
							team4.setAlignment(Pos.CENTER);
							num4.setAlignment(Pos.CENTER);
							height4.setAlignment(Pos.CENTER);
							weight4.setAlignment(Pos.CENTER);
							pos4.setAlignment(Pos.CENTER);

							resultsPane.add(name4, 0, 4);
							resultsPane.add(conf4, 1, 4);
							resultsPane.add(div4, 2, 4);
							resultsPane.add(team4, 3, 4);
							resultsPane.add(num4, 4, 4);
							resultsPane.add(height4, 5, 4);
							resultsPane.add(weight4, 6, 4);
							resultsPane.add(pos4, 7, 4);

						}
						if (counter == 5) {
							feet = inputHeight / 12;
							inch = inputHeight % 12;
							triesCounter.setText("Tries Left: " + (8 - counter));
							name5 = new Label(inputName);
							conf5 = new Label(inputConf);
							div5 = new Label(inputDiv);
							team5 = new Label(inputTeam);
							num5 = new Label(String.valueOf(inputNum));
							height5 = new Label(String.valueOf(feet) + "'" + String.valueOf(inch) + "\"");
							weight5 = new Label(String.valueOf(inputWeight) + " lbs");
							pos5 = new Label(inputPos);

							name5.setPrefWidth(210);
							conf5.setPrefWidth(210);
							div5.setPrefWidth(210);
							team5.setPrefWidth(210);
							num5.setPrefWidth(210);
							height5.setPrefWidth(210);
							weight5.setPrefWidth(210);
							pos5.setPrefWidth(210);

							name5.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
							if (randomConf.equals(inputConf))
								conf5.setStyle("-fx-background-color: limegreen;" + "-fx-font-size: 20px;"
										+ "-fx-font-family: Helvetica;");
							else
								conf5.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
							if (randomDiv.equals(inputDiv))
								div5.setStyle("-fx-background-color: limegreen;" + "-fx-font-size: 20px;"
										+ "-fx-font-family: Helvetica;");
							else
								div5.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
							if (randomTeam.equals(inputTeam))
								team5.setStyle("-fx-background-color: limegreen;" + "-fx-font-size: 20px;"
										+ "-fx-font-family: Helvetica;");
							else
								team5.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
							if (randomNum == inputNum) {
								num5.setStyle("-fx-background-color: limegreen;" + "-fx-font-size: 20px;"
										+ "-fx-font-family: Helvetica;");
							} else {
								if (randomNum <= inputNum + 8 && randomNum >= inputNum - 8) {
									num5.setStyle("-fx-background-color: yellow;" + "-fx-font-size: 20px;"
											+ "-fx-font-family: Helvetica;");
								} else {
									num5.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
								}
							}
							if (randomHeight == inputHeight) {
								height5.setStyle("-fx-background-color: limegreen;" + "-fx-font-size: 20px;"
										+ "-fx-font-family: Helvetica;");
							} else {
								if (randomHeight <= inputHeight + 2 && randomHeight >= inputHeight - 2) {
									height5.setStyle("-fx-background-color: yellow;" + "-fx-font-size: 20px;"
											+ "-fx-font-family: Helvetica;");
								} else {
									height5.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
								}
							}
							if (randomWeight == inputWeight) {
								weight5.setStyle("-fx-background-color: limegreen;" + "-fx-font-size: 20px;"
										+ "-fx-font-family: Helvetica;");
							} else {
								if (randomWeight <= inputWeight + 15 && randomWeight >= inputWeight - 15) {
									weight5.setStyle("-fx-background-color: yellow;" + "-fx-font-size: 20px;"
											+ "-fx-font-family: Helvetica;");
								} else {
									weight5.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
								}
							}
							if (randomPos.equals(inputPos))
								pos5.setStyle("-fx-background-color: limegreen;" + "-fx-font-size: 20px;"
										+ "-fx-font-family: Helvetica;");
							else
								pos5.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");

							name5.setAlignment(Pos.CENTER);
							conf5.setAlignment(Pos.CENTER);
							div5.setAlignment(Pos.CENTER);
							team5.setAlignment(Pos.CENTER);
							num5.setAlignment(Pos.CENTER);
							height5.setAlignment(Pos.CENTER);
							weight5.setAlignment(Pos.CENTER);
							pos5.setAlignment(Pos.CENTER);

							resultsPane.add(name5, 0, 5);
							resultsPane.add(conf5, 1, 5);
							resultsPane.add(div5, 2, 5);
							resultsPane.add(team5, 3, 5);
							resultsPane.add(num5, 4, 5);
							resultsPane.add(height5, 5, 5);
							resultsPane.add(weight5, 6, 5);
							resultsPane.add(pos5, 7, 5);

						}
						if (counter == 6) {
							feet = inputHeight / 12;
							inch = inputHeight % 12;
							triesCounter.setText("Tries Left: " + (8 - counter));
							name6 = new Label(inputName);
							conf6 = new Label(inputConf);
							div6 = new Label(inputDiv);
							team6 = new Label(inputTeam);
							num6 = new Label(String.valueOf(inputNum));
							height6 = new Label(String.valueOf(feet) + "'" + String.valueOf(inch) + "\"");
							weight6 = new Label(String.valueOf(inputWeight) + " lbs");
							pos6 = new Label(inputPos);

							name6.setPrefWidth(210);
							conf6.setPrefWidth(210);
							div6.setPrefWidth(210);
							team6.setPrefWidth(210);
							num6.setPrefWidth(210);
							height6.setPrefWidth(210);
							weight6.setPrefWidth(210);
							pos6.setPrefWidth(210);

							name6.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
							if (randomConf.equals(inputConf))
								conf6.setStyle("-fx-background-color: limegreen;" + "-fx-font-size: 20px;"
										+ "-fx-font-family: Helvetica;");
							else
								conf6.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
							if (randomDiv.equals(inputDiv))
								div6.setStyle("-fx-background-color: limegreen;" + "-fx-font-size: 20px;"
										+ "-fx-font-family: Helvetica;");
							else
								div6.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
							if (randomTeam.equals(inputTeam))
								team6.setStyle("-fx-background-color: limegreen;" + "-fx-font-size: 20px;"
										+ "-fx-font-family: Helvetica;");
							else
								team6.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
							if (randomNum == inputNum) {
								num6.setStyle("-fx-background-color: limegreen;" + "-fx-font-size: 20px;"
										+ "-fx-font-family: Helvetica;");
							} else {
								if (randomNum <= inputNum + 8 && randomNum >= inputNum - 8) {
									num6.setStyle("-fx-background-color: yellow;" + "-fx-font-size: 20px;"
											+ "-fx-font-family: Helvetica;");
								} else {
									num6.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
								}
							}
							if (randomHeight == inputHeight) {
								height6.setStyle("-fx-background-color: limegreen;" + "-fx-font-size: 20px;"
										+ "-fx-font-family: Helvetica;");
							} else {
								if (randomHeight <= inputHeight + 2 && randomHeight >= inputHeight - 2) {
									height6.setStyle("-fx-background-color: yellow;" + "-fx-font-size: 20px;"
											+ "-fx-font-family: Helvetica;");
								} else {
									height6.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
								}
							}
							if (randomWeight == inputWeight) {
								weight6.setStyle("-fx-background-color: limegreen;" + "-fx-font-size: 20px;"
										+ "-fx-font-family: Helvetica;");
							} else {
								if (randomWeight <= inputWeight + 15 && randomWeight >= inputWeight - 15) {
									weight6.setStyle("-fx-background-color: yellow;" + "-fx-font-size: 20px;"
											+ "-fx-font-family: Helvetica;");
								} else {
									weight6.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
								}
							}
							if (randomPos.equals(inputPos))
								pos6.setStyle("-fx-background-color: limegreen;" + "-fx-font-size: 20px;"
										+ "-fx-font-family: Helvetica;");
							else
								pos6.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");

							name6.setAlignment(Pos.CENTER);
							conf6.setAlignment(Pos.CENTER);
							div6.setAlignment(Pos.CENTER);
							team6.setAlignment(Pos.CENTER);
							num6.setAlignment(Pos.CENTER);
							height6.setAlignment(Pos.CENTER);
							weight6.setAlignment(Pos.CENTER);
							pos6.setAlignment(Pos.CENTER);

							resultsPane.add(name6, 0, 6);
							resultsPane.add(conf6, 1, 6);
							resultsPane.add(div6, 2, 6);
							resultsPane.add(team6, 3, 6);
							resultsPane.add(num6, 4, 6);
							resultsPane.add(height6, 5, 6);
							resultsPane.add(weight6, 6, 6);
							resultsPane.add(pos6, 7, 6);

						}
						if (counter == 7) {
							feet = inputHeight / 12;
							inch = inputHeight % 12;
							triesCounter.setText("Tries Left: " + (8 - counter));
							name7 = new Label(inputName);
							conf7 = new Label(inputConf);
							div7 = new Label(inputDiv);
							team7 = new Label(inputTeam);
							num7 = new Label(String.valueOf(inputNum));
							height7 = new Label(String.valueOf(feet) + "'" + String.valueOf(inch) + "\"");
							weight7 = new Label(String.valueOf(inputWeight) + " lbs");
							pos7 = new Label(inputPos);

							name7.setPrefWidth(210);
							conf7.setPrefWidth(210);
							div7.setPrefWidth(210);
							team7.setPrefWidth(210);
							num7.setPrefWidth(210);
							height7.setPrefWidth(210);
							weight7.setPrefWidth(210);
							pos7.setPrefWidth(210);

							name7.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
							if (randomConf.equals(inputConf))
								conf7.setStyle("-fx-background-color: limegreen;" + "-fx-font-size: 20px;"
										+ "-fx-font-family: Helvetica;");
							else
								conf7.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
							if (randomDiv.equals(inputDiv))
								div7.setStyle("-fx-background-color: limegreen;" + "-fx-font-size: 20px;"
										+ "-fx-font-family: Helvetica;");
							else
								div7.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
							if (randomTeam.equals(inputTeam))
								team7.setStyle("-fx-background-color: limegreen;" + "-fx-font-size: 20px;"
										+ "-fx-font-family: Helvetica;");
							else
								team7.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
							if (randomNum == inputNum) {
								num7.setStyle("-fx-background-color: limegreen;" + "-fx-font-size: 20px;"
										+ "-fx-font-family: Helvetica;");
							} else {
								if (randomNum <= inputNum + 8 && randomNum >= inputNum - 8) {
									num7.setStyle("-fx-background-color: yellow;" + "-fx-font-size: 20px;"
											+ "-fx-font-family: Helvetica;");
								} else {
									num7.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
								}
							}
							if (randomHeight == inputHeight) {
								height7.setStyle("-fx-background-color: limegreen;" + "-fx-font-size: 20px;"
										+ "-fx-font-family: Helvetica;");
							} else {
								if (randomHeight <= inputHeight + 2 && randomHeight >= inputHeight - 2) {
									height7.setStyle("-fx-background-color: yellow;" + "-fx-font-size: 20px;"
											+ "-fx-font-family: Helvetica;");
								} else {
									height7.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
								}
							}
							if (randomWeight == inputWeight) {
								weight7.setStyle("-fx-background-color: limegreen;" + "-fx-font-size: 20px;"
										+ "-fx-font-family: Helvetica;");
							} else {
								if (randomWeight <= inputWeight + 15 && randomWeight >= inputWeight - 15) {
									weight7.setStyle("-fx-background-color: yellow;" + "-fx-font-size: 20px;"
											+ "-fx-font-family: Helvetica;");
								} else {
									weight7.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
								}
							}
							if (randomPos.equals(inputPos))
								pos7.setStyle("-fx-background-color: limegreen;" + "-fx-font-size: 20px;"
										+ "-fx-font-family: Helvetica;");
							else
								pos7.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");

							name7.setAlignment(Pos.CENTER);
							conf7.setAlignment(Pos.CENTER);
							div7.setAlignment(Pos.CENTER);
							team7.setAlignment(Pos.CENTER);
							num7.setAlignment(Pos.CENTER);
							height7.setAlignment(Pos.CENTER);
							weight7.setAlignment(Pos.CENTER);
							pos7.setAlignment(Pos.CENTER);

							resultsPane.add(name7, 0, 7);
							resultsPane.add(conf7, 1, 7);
							resultsPane.add(div7, 2, 7);
							resultsPane.add(team7, 3, 7);
							resultsPane.add(num7, 4, 7);
							resultsPane.add(height7, 5, 7);
							resultsPane.add(weight7, 6, 7);
							resultsPane.add(pos7, 7, 7);

						}
						if (counter == 8) {
							feet = inputHeight / 12;
							inch = inputHeight % 12;
							triesCounter.setText("Tries Left: " + (8 - counter));
							name8 = new Label(inputName);
							conf8 = new Label(inputConf);
							div8 = new Label(inputDiv);
							team8 = new Label(inputTeam);
							num8 = new Label(String.valueOf(inputNum));
							height8 = new Label(String.valueOf(feet) + "'" + String.valueOf(inch) + "\"");
							weight8 = new Label(String.valueOf(inputWeight) + " lbs");
							pos8 = new Label(inputPos);

							name8.setPrefWidth(210);
							conf8.setPrefWidth(210);
							div8.setPrefWidth(210);
							team8.setPrefWidth(210);
							num8.setPrefWidth(210);
							height8.setPrefWidth(210);
							weight8.setPrefWidth(210);
							pos8.setPrefWidth(210);

							name8.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
							if (randomConf.equals(inputConf))
								conf8.setStyle("-fx-background-color: limegreen;" + "-fx-font-size: 20px;"
										+ "-fx-font-family: Helvetica;");
							else
								conf8.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
							if (randomDiv.equals(inputDiv))
								div8.setStyle("-fx-background-color: limegreen;" + "-fx-font-size: 20px;"
										+ "-fx-font-family: Helvetica;");
							else
								div8.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
							if (randomTeam.equals(inputTeam))
								team8.setStyle("-fx-background-color: limegreen;" + "-fx-font-size: 20px;"
										+ "-fx-font-family: Helvetica;");
							else
								team8.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
							if (randomNum == inputNum) {
								num8.setStyle("-fx-background-color: limegreen;" + "-fx-font-size: 20px;"
										+ "-fx-font-family: Helvetica;");
							} else {
								if (randomNum <= inputNum + 8 && randomNum >= inputNum - 8) {
									num8.setStyle("-fx-background-color: yellow;" + "-fx-font-size: 20px;"
											+ "-fx-font-family: Helvetica;");
								} else {
									num8.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
								}
							}
							if (randomHeight == inputHeight) {
								height8.setStyle("-fx-background-color: limegreen;" + "-fx-font-size: 20px;"
										+ "-fx-font-family: Helvetica;");
							} else {
								if (randomHeight <= inputHeight + 2 && randomHeight >= inputHeight - 2) {
									height8.setStyle("-fx-background-color: yellow;" + "-fx-font-size: 20px;"
											+ "-fx-font-family: Helvetica;");
								} else {
									height8.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
								}
							}
							if (randomWeight == inputWeight) {
								weight8.setStyle("-fx-background-color: limegreen;" + "-fx-font-size: 20px;"
										+ "-fx-font-family: Helvetica;");
							} else {
								if (randomWeight <= inputWeight + 15 && randomWeight >= inputWeight - 15) {
									weight8.setStyle("-fx-background-color: yellow;" + "-fx-font-size: 20px;"
											+ "-fx-font-family: Helvetica;");
								} else {
									weight8.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
								}
							}
							if (randomPos.equals(inputPos))
								pos8.setStyle("-fx-background-color: limegreen;" + "-fx-font-size: 20px;"
										+ "-fx-font-family: Helvetica;");
							else
								pos8.setStyle("-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");

							name8.setAlignment(Pos.CENTER);
							conf8.setAlignment(Pos.CENTER);
							div8.setAlignment(Pos.CENTER);
							team8.setAlignment(Pos.CENTER);
							num8.setAlignment(Pos.CENTER);
							height8.setAlignment(Pos.CENTER);
							weight8.setAlignment(Pos.CENTER);
							pos8.setAlignment(Pos.CENTER);

							resultsPane.add(name8, 0, 8);
							resultsPane.add(conf8, 1, 8);
							resultsPane.add(div8, 2, 8);
							resultsPane.add(team8, 3, 8);
							resultsPane.add(num8, 4, 8);
							resultsPane.add(height8, 5, 8);
							resultsPane.add(weight8, 6, 8);
							resultsPane.add(pos8, 7, 8);

							feet = randomHeight / 12;
							inch = randomHeight % 12;
							triesCounter.setText("Tries Left: " + (8 - counter));
							name9 = new Label(randomName);
							conf9 = new Label(randomConf);
							div9 = new Label(randomDiv);
							team9 = new Label(randomTeam);
							num9 = new Label(String.valueOf(randomNum));
							height9 = new Label(String.valueOf(feet) + "'" + String.valueOf(inch) + "\"");
							weight9 = new Label(String.valueOf(randomWeight) + " lbs");
							pos9 = new Label(randomPos);

							name9.setPrefWidth(210);
							conf9.setPrefWidth(210);
							div9.setPrefWidth(210);
							team9.setPrefWidth(210);
							num9.setPrefWidth(210);
							height9.setPrefWidth(210);
							weight9.setPrefWidth(210);
							pos9.setPrefWidth(210);

							name9.setStyle("-fx-background-color: red;" + "-fx-font-size: 20px;"
									+ "-fx-font-family: Helvetica;");
							conf9.setStyle("-fx-background-color: red;" + "-fx-font-size: 20px;"
									+ "-fx-font-family: Helvetica;");
							div9.setStyle("-fx-background-color: red;" + "-fx-font-size: 20px;"
									+ "-fx-font-family: Helvetica;");
							team9.setStyle("-fx-background-color: red;" + "-fx-font-size: 20px;"
									+ "-fx-font-family: Helvetica;");
							num9.setStyle("-fx-background-color: red;" + "-fx-font-size: 20px;"
									+ "-fx-font-family: Helvetica;");
							height9.setStyle("-fx-background-color: red;" + "-fx-font-size: 20px;"
									+ "-fx-font-family: Helvetica;");
							weight9.setStyle("-fx-background-color: red;" + "-fx-font-size: 20px;"
									+ "-fx-font-family: Helvetica;");
							pos9.setStyle("-fx-background-color: red;" + "-fx-font-size: 20px;"
									+ "-fx-font-family: Helvetica;");

							name9.setAlignment(Pos.CENTER);
							conf9.setAlignment(Pos.CENTER);
							div9.setAlignment(Pos.CENTER);
							team9.setAlignment(Pos.CENTER);
							num9.setAlignment(Pos.CENTER);
							height9.setAlignment(Pos.CENTER);
							weight9.setAlignment(Pos.CENTER);
							pos9.setAlignment(Pos.CENTER);

							resultsPane.add(name9, 0, 9);
							resultsPane.add(conf9, 1, 9);
							resultsPane.add(div9, 2, 9);
							resultsPane.add(team9, 3, 9);
							resultsPane.add(num9, 4, 9);
							resultsPane.add(height9, 5, 9);
							resultsPane.add(weight9, 6, 9);
							resultsPane.add(pos9, 7, 9);
						}
					}
				} else {
					guessField.clear();
					guessField.setText("ERROR");
				}
			}
		}
	}

	private class ButtonHandler implements EventHandler<ActionEvent> { // button handler
		public void handle(ActionEvent e) {
			Object source = e.getSource(); // grabs source
			if (source == start) { // if the start button is pressed, clears screen and generates random player.
				getChildren().clear();
				randomNumber = rand.nextInt(playerList.size());
				randomName = playerList.get(randomNumber).getName();
				randomConf = playerList.get(randomNumber).getConf();
				randomDiv = playerList.get(randomNumber).getDiv();
				randomTeam = playerList.get(randomNumber).getTeam();
				randomNum = playerList.get(randomNumber).getNum();
				randomHeight = playerList.get(randomNumber).getHt();
				randomWeight = playerList.get(randomNumber).getWt();
				randomPos = playerList.get(randomNumber).getPos();
				System.out.println(playerList.get(randomNumber).toString());
				counter = 0;
				gameLayout(); // gameLayout called for playing
			}

			if (source == exitGame) { // clears and goes to start menu
				getChildren().clear();
				startMenu();
			}

			if (source == newGame) { // if new game is pressed, creates a new random player,
										// resets
				System.out.println("normal new game!");
				getChildren().clear();
				randomNumber = rand.nextInt(playerList.size());
				randomName = playerList.get(randomNumber).getName();
				randomConf = playerList.get(randomNumber).getConf();
				randomDiv = playerList.get(randomNumber).getDiv();
				randomTeam = playerList.get(randomNumber).getTeam();
				randomNum = playerList.get(randomNumber).getNum();
				randomHeight = playerList.get(randomNumber).getHt();
				randomWeight = playerList.get(randomNumber).getWt();
				randomPos = playerList.get(randomNumber).getPos();
				System.out.println(playerList.get(randomNumber).toString());
				counter = 0;
				gameLayout();
			}

			if (source == normalMode) {
				System.out.println("nromal mode!");
				getChildren().clear();
				randomNumber = rand.nextInt(playerList.size());
				randomName = playerList.get(randomNumber).getName();
				randomConf = playerList.get(randomNumber).getConf();
				randomDiv = playerList.get(randomNumber).getDiv();
				randomTeam = playerList.get(randomNumber).getTeam();
				randomNum = playerList.get(randomNumber).getNum();
				randomHeight = playerList.get(randomNumber).getHt();
				randomWeight = playerList.get(randomNumber).getWt();
				randomPos = playerList.get(randomNumber).getPos();
				System.out.println(playerList.get(randomNumber).toString());
				counter = 0;
				gameLayout();
			}

			if (source == easyNewGame) {
				System.out.println("easy new game!");
				getChildren().clear();
				randomNumber = rand.nextInt(starterList.size());
				randomName = starterList.get(randomNumber).getName();
				randomConf = starterList.get(randomNumber).getConf();
				randomDiv = starterList.get(randomNumber).getDiv();
				randomTeam = starterList.get(randomNumber).getTeam();
				randomNum = starterList.get(randomNumber).getNum();
				randomHeight = starterList.get(randomNumber).getHt();
				randomWeight = starterList.get(randomNumber).getWt();
				randomPos = starterList.get(randomNumber).getPos();
				System.out.println(starterList.get(randomNumber).toString());
				counter = 0;
				easyGameLayout();
			}

			if (source == easyMode) {
				System.out.println("easy mode!");
				getChildren().clear();
				randomNumber = rand.nextInt(starterList.size());
				randomName = starterList.get(randomNumber).getName();
				randomConf = starterList.get(randomNumber).getConf();
				randomDiv = starterList.get(randomNumber).getDiv();
				randomTeam = starterList.get(randomNumber).getTeam();
				randomNum = starterList.get(randomNumber).getNum();
				randomHeight = starterList.get(randomNumber).getHt();
				randomWeight = starterList.get(randomNumber).getWt();
				randomPos = starterList.get(randomNumber).getPos();
				System.out.println(starterList.get(randomNumber).toString());
				counter = 0;
				easyGameLayout();
			}

			if (source == copy) { // copies selected combo box item into textfield
				guessField.setText((String) playerNames.getSelectionModel().getSelectedItem());
			}

			if (source == forfeit) { // gives up the game, showing the right player
				int feet;
				int inch;
				counter = 9;

				feet = randomHeight / 12;
				inch = randomHeight % 12;
				name9 = new Label(randomName);
				conf9 = new Label(randomConf);
				div9 = new Label(randomDiv);
				team9 = new Label(randomTeam);
				num9 = new Label(String.valueOf(randomNum));
				height9 = new Label(String.valueOf(feet) + "'" + String.valueOf(inch) + "\"");
				weight9 = new Label(String.valueOf(randomWeight) + " lbs");
				pos9 = new Label(randomPos);

				name9.setPrefWidth(210);
				conf9.setPrefWidth(210);
				div9.setPrefWidth(210);
				team9.setPrefWidth(210);
				num9.setPrefWidth(210);
				height9.setPrefWidth(210);
				weight9.setPrefWidth(210);
				pos9.setPrefWidth(210);

				name9.setStyle("-fx-background-color: red;" + "-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
				conf9.setStyle("-fx-background-color: red;" + "-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
				div9.setStyle("-fx-background-color: red;" + "-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
				team9.setStyle("-fx-background-color: red;" + "-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
				num9.setStyle("-fx-background-color: red;" + "-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
				height9.setStyle("-fx-background-color: red;" + "-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
				weight9.setStyle("-fx-background-color: red;" + "-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");
				pos9.setStyle("-fx-background-color: red;" + "-fx-font-size: 20px;" + "-fx-font-family: Helvetica;");

				name9.setAlignment(Pos.CENTER);
				conf9.setAlignment(Pos.CENTER);
				div9.setAlignment(Pos.CENTER);
				team9.setAlignment(Pos.CENTER);
				num9.setAlignment(Pos.CENTER);
				height9.setAlignment(Pos.CENTER);
				weight9.setAlignment(Pos.CENTER);
				pos9.setAlignment(Pos.CENTER);

				resultsPane.add(name9, 0, 9);
				resultsPane.add(conf9, 1, 9);
				resultsPane.add(div9, 2, 9);
				resultsPane.add(team9, 3, 9);
				resultsPane.add(num9, 4, 9);
				resultsPane.add(height9, 5, 9);
				resultsPane.add(weight9, 6, 9);
				resultsPane.add(pos9, 7, 9);

			}

		}
	}

}
