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

        if (file.getNumberOfLines() > 0 ){

            file.setNumberOfLines(file.getNumberOfLines() - numberOfLines);
            file.setModified(true);

        }

        return true;

    }

    public boolean removeFile(String fileName){

        File file = searchFileByName(fileName);
        fileList.remove(file);

        return true;

    }


    public File searchFileByName(String name){
        File foundFile = null;

        try {

            for (int i = 0; i < fileList.size(); i++){

                if (fileList.get(i).getName() == name){

                    foundFile = fileList.get(i);

                }

            }

        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }

        return foundFile;

    }

    public ArrayList<File> searchModifiedFiles(){

        ArrayList<File> modifiedFilesList = new ArrayList<>();

        File foundFile = null;

        for (int i = 0; i < fileList.size(); i++){

            if (fileList.get(i).isModified()){

                foundFile = fileList.get(i);
                modifiedFilesList.add(foundFile);

            }

        }

        return modifiedFilesList;

    }

    public String listingFileNames(){

        String fileNames = "";

        if (fileList.size() <= 0){

            return "Lista Vazia";
        }else{

            for (int i = 0; i < fileList.size(); i++){

                fileNames += "- " + fileList.get(i).getName()+ " \n";

            }

            return fileNames;

        }
    }

}
