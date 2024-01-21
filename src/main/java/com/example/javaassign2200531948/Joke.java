package com.example.javaassign2200531948;

import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.util.List;

public class Joke {
    private String total;
    @SerializedName("icon_url")
    private String iconUrl;
    private String id;
    private String url;
    private String value;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("updated_at")
    private String updatedAt;
    private List<String> categories;


    public String getIconUrl() {
        return iconUrl;
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getTotal(){return total;}

    public String getValue() {
        return value;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public List<String> getCategories() {
        return categories;
    }

    public String toString(){
        String categoryString = categories.isEmpty() ? "No Category" : String.join(", ", categories);
        return String.format("Joke: %s, Category: %s", value, categoryString);
    }
}
