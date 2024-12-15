package com.havrun.javacalculator;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainWindowController {

	@FXML private Pane titlePane;

	private double x, y;


	public void init(Stage stage) {

		titlePane.setOnMousePressed(event -> {
			x = event.getSceneX();
			y = event.getSceneY();
		});

		titlePane.setOnMouseDragged(event -> {
			stage.setX(event.getScreenX() - x);
			stage.setY(event.getScreenY() - y);
		});

	}
}