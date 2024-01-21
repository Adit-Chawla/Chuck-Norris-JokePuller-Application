package com.example.javaassign2200531948;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class JokeViewController{

    private int totalJokes = 0;

    @FXML
    private ListView<Joke> listView;

    @FXML
    private Label msgLabel;

    @FXML
    private ImageView posterImageView;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private HBox resultsBox;

    @FXML
    private Label resultsMsgLabel;

    @FXML
    private TextField searchTextField;

    @FXML
    private VBox selectedVBox;

    @FXML
    private VBox titlesVBox;

    @FXML
    private void initialize(){
        progressBar.setVisible(false);
        selectedVBox.setVisible(false);
        titlesVBox.setVisible(false);
        msgLabel.setVisible(false);
        fetchTotalJokesCount();

        listView.getSelectionModel()
                .selectedItemProperty()
                .addListener((obs, oldValue, selectedJoke) -> {
                    if(selectedJoke != null)
                    {
                        selectedVBox.setVisible(true);
                        try{
                            posterImageView.setImage(new Image(selectedJoke.getIconUrl()));
                        } catch (IllegalArgumentException e)
                        {
                            posterImageView.setImage(new Image(Main.class.getResourceAsStream("images/default_poster.png")));
                        }
                    }
                    else
                    {
                        selectedVBox.setVisible(false);
                    }
                });
    }



    private void fetchTotalJokesCount() {
        try {
            ResponseAPI allJokesResponse = APIUtility.searchJokes("chuck");
            totalJokes = allJokesResponse.getJokes().size();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            totalJokes = -1;
        }
    }

    @FXML
    private void searchForJokes(ActionEvent event) throws IOException, InterruptedException {
        String joke = searchTextField.getText().trim();
        ResponseAPI responseAPI = APIUtility.searchJokes(joke);

        if(responseAPI.getJokes() != null){
            titlesVBox.setVisible(true);
            listView.getItems().clear();
            listView.getItems().addAll(responseAPI.getJokes());
            resultsMsgLabel.setText("Displaying " + listView.getItems().size() + " of " + totalJokes);
        }
        else{
            titlesVBox.setVisible(false);
            msgLabel.setVisible(true);
            msgLabel.setText("Please enter a joke and click the 'Search' button");
        }
    }

    @FXML
    void getJokeDetails(ActionEvent event) throws IOException {
        Joke selectedJoke = listView.getSelectionModel().getSelectedItem();
        SceneChanger.sceneChange(event, "detail-view.fxml", selectedJoke.getId());
    }
}
