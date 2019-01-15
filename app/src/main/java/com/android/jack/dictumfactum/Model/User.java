package com.android.jack.dictumfactum.Model;

public class User {

    private String id;
    private String username;
    private String imageURL;
    private String status;
    private String lawyer_status;

    public User(String id, String username, String imageURL, String status, String lawyer_status) {
        this.id = id;
        this.username = username;
        this.imageURL = imageURL;
        this.status = status;
        this.lawyer_status = lawyer_status;


    }

    public User() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLawyer_status() {
        return lawyer_status;
    }

    public void setLawyer_status(String lawyer_status) {
        this.lawyer_status = lawyer_status;
    }
}
