package com.example.javaassign2200531948;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("joke-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Chuck-Norris-Jokes");
        stage.setScene(scene);
        stage.getIcons().add(new Image(Main.class.getResourceAsStream("images/Logo.png")));
        stage.show();
    }
    public static void main(String[] args) {launch();}
}
