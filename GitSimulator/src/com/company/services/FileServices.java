package com.company.services;

import com.company.model.File;

import java.util.ArrayList;

public class FileServices {

    private ArrayList<File> trackedFileList = new ArrayList<>();
    private ArrayList<File> untrackedFileList = new ArrayList<>();


    public ArrayList<File> getTrackedFileList() {
        return trackedFileList;
    }


    public ArrayList<File> getUntrackedFileList() {
        return untrackedFileList;
    }



    public boolean createFile(String name, int numberLines, boolean modified){

        File file = new File(name, numberLines, false);
        untrackedFileList.add(file);

        return true;
    }
    public boolean removeFile(String fileName, ArrayList<File> fileList){

        File file = searchFileByName(fileName, fileList);
        fileList.remove(file);

        return true;

    }

    public File searchFileByName(String name, ArrayList<File> fileList){
        File foundFile = null;

        try {

            for (int i = 0; i < trackedFileList.size(); i++){

                if (fileList.get(i).getName() == name){

                    foundFile = fileList.get(i);

                }

            }

        }catch (NullPointerException e){
            System.out.println("Null pointer exception");
        }

        return foundFile;

    }

    public String listiningUntrackedFiles(){

        String fileNames = "";

        try{

            for (int i = 0; i < this.untrackedFileList.size(); i++){

                fileNames += "- " + untrackedFileList.get(i).getName() + "\n";

            }

            return fileNames;

        }catch (NullPointerException e){

            return  "Não possui arquivos untracked";

        }

    }

    public String listiningTrackedFiles(){

        String fileNames = "";

        try{

            for (int i = 0; i < getTrackedFileList().size(); i++){

                fileNames += "- " + getTrackedFileList().get(i).getName() + "\n";

            }

            return fileNames;

        }catch (NullPointerException e){

            return "Não possui arquivos tracked";

        }

    }
}
