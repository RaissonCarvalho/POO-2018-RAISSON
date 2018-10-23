package com.company.model;


import java.util.ArrayList;

public class Repository {

    private String name;
    private ArrayList<File> filesCommited;

    public Repository(String name, ArrayList<File> filesCommited) {
        this.name = name;
        this.filesCommited = filesCommited;
    }

    public String getName() {
        return name;
    }

    public ArrayList<File> getFilesCommited() {
        return filesCommited;
    }

    public void setFilesCommited(ArrayList<File> filesCommited) {
        this.filesCommited = filesCommited;
    }
}
