package com.android.jack.dictumfactum.Model;

public class News {
    private String id;
    private String header;
    private String field;


    public News(String id, String header, String field) {
        this.id = id;
        this.header = header;
        this.field = field;
    }

    public News() {
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}


