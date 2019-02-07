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

    private  Boolean cch1;
    private  Boolean cch2;
    private  Boolean cch3;
    private  Boolean cch4;
    private  Boolean cch5;
    private  Boolean cch6;
    private  Boolean cch7;
    private  Boolean cch8;


    public User(String id, String username, String imageURL, String status, String lawyer_status, String search, String e2, String ch, String autoc, Boolean cch1, Boolean cch2, Boolean cch3, Boolean cch4, Boolean cch5, Boolean cch6, Boolean cch7, Boolean cch8) {
        this.id = id;
        this.username = username;
        this.imageURL = imageURL;
        this.status = status;
        this.lawyer_status = lawyer_status;
        this.search = search;
        this.e2 = e2;
        this.ch = ch;
        this.autoc = autoc;

        this.cch1 = cch1;
        this.cch2 = cch2;
        this.cch3 = cch3;
        this.cch4 = cch4;
        this.cch5 = cch5;
        this.cch6 = cch6;
        this.cch7 = cch7;
        this.cch8 = cch8;


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

    public Boolean getCch1() {
        return cch1;
    }

    public void setCch1(Boolean cch1) {
        this.cch1 = cch1;
    }

    public Boolean getCch2() {
        return cch2;
    }

    public void setCch2(Boolean cch2) {
        this.cch2 = cch2;
    }

    public Boolean getCch3() {
        return cch3;
    }

    public void setCch3(Boolean cch3) {
        this.cch3 = cch3;
    }

    public Boolean getCch4() {
        return cch4;
    }

    public void setCch4(Boolean cch4) {
        this.cch4 = cch4;
    }

    public Boolean getCch5() {
        return cch5;
    }

    public void setCch5(Boolean cch5) {
        this.cch5 = cch5;
    }

    public Boolean getCch6() {
        return cch6;
    }

    public void setCch6(Boolean cch6) {
        this.cch6 = cch6;
    }

    public Boolean getCch7() {
        return cch7;
    }

    public void setCch7(Boolean cch7) {
        this.cch7 = cch7;
    }

    public Boolean getCch8() {
        return cch8;
    }

    public void setCch8(Boolean cch8) {
        this.cch8 = cch8;
    }

    public void setAutoc(String autoc) {
        this.autoc = autoc;
    }
}
