package com.example.javaassign2200531948;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneChanger {

    public static void sceneChange(ActionEvent event, String fxmlFile) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFile));
        Scene scene = new Scene(fxmlLoader.load());

        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }

    public static void sceneChange(ActionEvent event, String fxmlFile, String id) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFile));
        Scene scene = new Scene(fxmlLoader.load());

        JokeLoader controller = fxmlLoader.getController();
        controller.loadJoke(id);

        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }
}
