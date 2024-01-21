package com.example.javaassign2200531948;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;


//Contoller which Handles the display of joke details.
public class DetailViewController implements JokeLoader{

    @FXML
    private Label categoriesLabel;

    @FXML
    private Label createdAtLabel;

    @FXML
    private Label iconUrlLabel;

    @FXML
    private Label idLabel;

    @FXML
    private ImageView imageView;

    @FXML
    private Label updatedAtLabel;

    @FXML
    private Label urlLabel;

    @FXML
    private Label valueLabel;

//    Event handler to navigate back to the search view from detail view.
    @FXML
    void goToSearch(ActionEvent event) throws IOException {
        SceneChanger.sceneChange(event, "joke-view.fxml");
    }

//    Loads a joke's details and displays them in the detailed view.
    public void loadJoke(String id)
    {
        try {
            JokeDetails joke = APIUtility.getJokeDetails(id);
            categoriesLabel.setText(joke.getCategories());
            createdAtLabel.setText(joke.getCreatedAt());
            iconUrlLabel.setText(joke.getIconUrlLabel());
            idLabel.setText(joke.getIdLabel());
            updatedAtLabel.setText(joke.getUpdatedAtLabel());
            urlLabel.setText(joke.getUrlLabel());
            valueLabel.setText(joke.getValueLabel());
            imageView.setImage(new Image(joke.getIconUrlLabel()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }catch (IllegalArgumentException e)
        {
            imageView.setImage(new Image(Main.class.getResourceAsStream("images/default-poster.png")));
        }

    }
}
