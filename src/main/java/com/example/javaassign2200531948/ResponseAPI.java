package com.example.javaassign2200531948;

import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ResponseAPI {

    private String total;
    @SerializedName("result")
    private ArrayList<Joke> jokes;


    public String getTotal() {
        return total;
    }
    public ArrayList<Joke> getJokes() {
        return jokes;
    }
}
