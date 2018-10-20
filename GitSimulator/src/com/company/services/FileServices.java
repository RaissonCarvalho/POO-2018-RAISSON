package com.company.services;

import com.company.model.File;

import java.util.ArrayList;

public class FileServices {

    private ArrayList<File> fileList = new ArrayList<>();

    public ArrayList<File> getFileList() {
        return fileList;
    }

    public boolean createFile(String name, int numberLines, boolean modified){

        File file = new File(name, numberLines, false);
        fileList.add(file);

        return true;
    }

    public boolean addLine(String fileName, int numberOfLines){

        File file = searchFileByName(fileName);

        file.setNumberOfLines(file.getNumberOfLines() + numberOfLines);
        file.setModified(true);

        return true;

    }

    public boolean deleteLine(String fileName, int numberOfLines){

        File file = searchFileByName(fileName);

        file.setNumberOfLines(file.getNumberOfLines() - numberOfLines);
        file.setModified(true);

        return true;

    }

    public boolean removeFile(String fileName){

        File file = searchFileByName(fileName);
        fileList.remove(file);

        return true;

    }


    public File searchFileByName(String name){
        File foundFile = null;
        for (int i = 0; i < fileList.size(); i++){

            if (fileList.get(i).getName() == name){

                foundFile = fileList.get(i);

            }

        }

        return foundFile;

    }

    public File searchModifiedFile(){

        File foundFile = null;
        for (int i = 0; i < fileList.size(); i++){

            if (fileList.get(i).isModified()){

                foundFile = fileList.get(i);

            }

        }

        return foundFile;

    }

}
