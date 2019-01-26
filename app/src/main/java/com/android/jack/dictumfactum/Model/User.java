package com.android.jack.dictumfactum.Model;

public class User {

    private String id;
    private String username;
    private String imageURL;
    private String status;
    private String lawyer_status;
    private String search;
    private String e2;
    private String ch;
    private String autoc;


    public User(String id, String username, String imageURL, String status, String lawyer_status, String search, String e2, String ch, String autoc) {
        this.id = id;
        this.username = username;
        this.imageURL = imageURL;
        this.status = status;
        this.lawyer_status = lawyer_status;
        this.search = search;
        this.e2 = e2;
        this.ch = ch;
        this.autoc = autoc;


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

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getE2() {
        return e2;
    }

    public void setE2(String e2) {
        this.e2 = e2;
    }

    public String getCh() {
        return ch;
    }

    public void setCh(String ch) {
        this.ch = ch;
    }

    public String getAutoc() {
        return autoc;
    }

    public void setAutoc(String autoc) {
        this.autoc = autoc;
    }
}
