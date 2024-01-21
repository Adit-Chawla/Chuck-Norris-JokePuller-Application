package com.example.javaassign2200531948;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JokeDetails {
    @SerializedName("categories")
    private List<String> categories;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("icon_url")
    private String iconUrlLabel;

    @SerializedName("id")
    private String idLabel;

    @SerializedName("updated_at")
    private String updatedAtLabel;

    @SerializedName("url")
    private String urlLabel;

    @SerializedName("value")
    private String valueLabel;

    public String getCategories() {
        return categories.toString();
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getIconUrlLabel() {
        return iconUrlLabel;
    }

    public String getIdLabel() {
        return idLabel;
    }

    public String getUpdatedAtLabel() {
        return updatedAtLabel;
    }

    public String getUrlLabel() {
        return urlLabel;
    }

    public String getValueLabel() {
        return valueLabel;
    }
}
