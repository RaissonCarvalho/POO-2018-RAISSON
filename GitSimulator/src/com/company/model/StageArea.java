package com.company.model;

import java.util.ArrayList;

public class StageArea {

    private ArrayList<File> stageAreaFileList = new ArrayList<>(); /* Arquivos que estão no Stage Area */

    public ArrayList<File> getStageAreaFileList() {
        return stageAreaFileList;
    }

    public void setStageAreaFileList(ArrayList<File> stageAreaFileList) {
        this.stageAreaFileList = stageAreaFileList;
    }
}
