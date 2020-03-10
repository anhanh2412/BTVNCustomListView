package com.example.btvncustomlistview.model.model;

public class Contact {
    private String nameBH;
    private String nameCS;
    private String time;

    public Contact( String nameBH, String nameCS, String time) {
        this.nameBH = nameBH;
        this.nameCS = nameCS;
        this.time = time;
    }

    public String getNameBH() {
        return nameBH;
    }

    public void setNameBH(String nameBH) {
        this.nameBH = nameBH;
    }

    public String getNameCS() {
        return nameCS;
    }

    public void setNameCS(String nameCS) {
        this.nameCS = nameCS;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
