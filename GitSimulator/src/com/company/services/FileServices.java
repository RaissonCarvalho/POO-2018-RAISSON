package com.company.services;

import com.company.model.File;

import java.util.ArrayList;

public class FileServices {

    private ArrayList<File> fileArrayList;

    public boolean createFile(){

        File file = new File("", 0, false);

        fileArrayList.add(file);

        return true;
    }

    public boolean addLine(File file, int numberOfLines){

        file.setNumberOfLines(file.getNumberOfLines() + numberOfLines);

        file.setModified(true);

        return true;

    }

    public boolean removeLine(File file, int numberOfLines){

        file.setNumberOfLines(file.getNumberOfLines() - numberOfLines);

        file.setModified(true);

        return true;

    }

    public boolean removeFile(File file){

        fileArrayList.remove(file);

        return true;

    }

}
