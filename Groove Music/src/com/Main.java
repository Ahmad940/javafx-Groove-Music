package com;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static Stage stage;

    double xOffset;
    double yOffset;

    @Override
    public void start(Stage primaryStage) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/com/mak/assets/fxml/mainwindow.fxml"));
        } catch (IOException e) {
            System.out.println("Could`nt load fxml file");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/com/mak/assets/css/styles.css").toExternalForm());
        primaryStage.getIcons().add(new Image("/com/mak/assets/images/GrooveIcons/icons8_play_100px.png"));
        primaryStage.setTitle("Groove Music");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);

        stage = primaryStage;

        root.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });

        root.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() - xOffset);
            stage.setY(event.getScreenY() - yOffset);
            stage.setOpacity(0.5f);
        });

        root.setOnMouseReleased(event -> {
            stage.setOpacity(1);
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
