package com.company.model;

import java.util.ArrayList;

public class File {

    private String name;
    private int numberOfLines = 0;
    private boolean modified = false;

    public File(String name, int numberOfLines, boolean modified) {
        this.name = name;
        this.numberOfLines = numberOfLines;
        this.modified = modified;

    }

    public String getName() {
        return name;
    }

    public int getNumberOfLines() {
        return numberOfLines;
    }

    public void setNumberOfLines(int numberOfLines) {
        this.numberOfLines = numberOfLines;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isModified() {
        return modified;
    }

    public void setModified(boolean modified) {
        this.modified = modified;
    }


    public boolean addLine(int numberOfLines){

        this.numberOfLines += numberOfLines;
        this.setModified(true);

        return true;

    }

    public boolean deleteLine(int numberOfLines){

        if (this.numberOfLines > 0 ){

            this.numberOfLines -= numberOfLines;
            this.modified = true;

        }

        return true;

    }




}
