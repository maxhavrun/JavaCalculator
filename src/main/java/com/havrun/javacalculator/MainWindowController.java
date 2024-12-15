package com.havrun.javacalculator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;

public class MainWindowController {

	@FXML private Pane titlePane;

	@FXML private ImageView exitbtn, minimizebtn;

	@FXML private Label lableResult;


	private double x, y;
	private String operator = "+";
	private double num1 = 0;


	public void init(Stage stage) {


		//Moving window
		titlePane.setOnMousePressed(event -> {
			x = event.getSceneX();
			y = event.getSceneY();
		});

		titlePane.setOnMouseDragged(event -> {
			stage.setX(event.getScreenX() - x);
			stage.setY(event.getScreenY() - y);
		});

		//Buttons actions
		exitbtn.setOnMouseClicked(event -> {
			stage.close();
		});

		minimizebtn.setOnMouseClicked(event -> {
			stage.setIconified(true);
		});

	}

	@FXML
	void onNumberClicked(MouseEvent event) {
		int value = Integer.parseInt(
				((Pane)event.getSource()).getId().replace("btn", "")
		);
		lableResult.setText(
				Double.parseDouble(lableResult.getText()) == 0 ?
						String.valueOf(
								(double)value
						)
						:
						String.valueOf(
								Double.parseDouble(lableResult.getText()) * 10 + value
						)
		);
	}

	@FXML
	void onSymbolClicked(MouseEvent event) {
		String symbol = ((Pane)event.getSource()).getId().replace("btn","");
		if(symbol.equals("Equals")) {
			double num2 = Double.parseDouble(lableResult.getText());
			switch (operator) {
				case "+" -> lableResult.setText((num1+num2) + "");
				case "-" -> lableResult.setText((num1-num2) + "");
				case "*" -> lableResult.setText((num1*num2) + "");
				case "/" -> lableResult.setText((num1/num2) + "");
			}
			operator = ".";
		}
		else if(symbol.equals("Clear")) {
			lableResult.setText(String.valueOf(0.0));
			operator = ".";
		}
		else {
			switch (symbol) {
				case "Plus" -> operator = "+";
				case "Minus" -> operator = "-";
				case "Multiply" -> operator = "*";
				case "Divide" -> operator = "/";
			}
			num1 = Double.parseDouble(lableResult.getText());
			lableResult.setText(String.valueOf(0.0));
		}
	}

}