// Package name the files are in
package com.example.javaassign2200531948;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Utility class providing methods to interact with an external API for joke retrieval and processing.
public class APIUtility {

//    Searches jokes from the API based on a query string.
    public static ResponseAPI searchJokes(String joke) throws IOException, InterruptedException
    {
        joke = joke.replaceAll(" ", "%20");
        String uri = "https://api.chucknorris.io/jokes/search?query=" + joke;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).build();
        HttpResponse<String> httpResponse = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
//        System.out.println(httpResponse.body());

        Gson gson = new Gson();
        return gson.fromJson(httpResponse.body(), ResponseAPI.class);
    }

//    Retrieves details of a specific joke using its ID from the API.
    public static JokeDetails getJokeDetails(String id) throws IOException, InterruptedException
    {
        id = id.trim().replaceAll(" ", "%20");
        String uri = "https://api.chucknorris.io/jokes/" + id;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).build();
        HttpResponse<String> httpResponse = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        return gson.fromJson(httpResponse.body(), JokeDetails.class);
    }

//    Reads jokes from a JSON file and returns them as a list

    public static List<Joke> getJokesFromFile(String fileName)
    {
        Gson gson = new Gson();

        try(
                FileReader fileReader = new FileReader(fileName);
                JsonReader jsonReader = new JsonReader(fileReader);
        )
        {
            Joke[] jokes = gson.fromJson(jsonReader, Joke[].class);
            return Arrays.asList(jokes);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
