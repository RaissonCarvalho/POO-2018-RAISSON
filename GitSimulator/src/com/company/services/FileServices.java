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

}
