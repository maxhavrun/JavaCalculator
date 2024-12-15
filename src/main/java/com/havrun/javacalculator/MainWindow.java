package com.havrun.javacalculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;

public class MainWindow extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader =
                new FXMLLoader(
                        Objects.requireNonNull(
                                getClass().
                                        getResource("/com/havrun/javacalculator/MainWindowInterface.fxml")
                        )
                );

        Scene scene = new Scene(fxmlLoader.load());

        scene.setFill(Color.TRANSPARENT);

        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setResizable(false);
        stage.setTitle("Java Calculator");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/icon.png")));

        ((MainWindowController)fxmlLoader.getController()).init(stage);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}