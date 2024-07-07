package org.example.dto;

public class Motivation {
    private int id;
    private String body;
    private String source;
    private String regDate;
    private String updateDate;

    public Motivation(int id, String regDate, String updateDate, String body, String source) {
        this.id = id;
        this.regDate = regDate;
        this.updateDate = updateDate;
        this.body = body;
        this.source = source;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

}
