package com.company.services;

import com.company.model.File;
import com.company.model.Repository;

import java.util.ArrayList;

public class GitServices {

    public void gitAdd(FileServices fileServices){

        try{

            for (int i = 0; i < fileServices.getUntrackedFileList().size(); i++){

                fileServices.getTrackedFileList().add(fileServices.getUntrackedFileList().get(i));
                fileServices.getUntrackedFileList().remove(i);

            }



        }catch (NullPointerException e){
            System.out.println("Empty List");
        }

    }


    public void gitCommit(ArrayList<File> filesToCommit, String mensagem, Repository repository){

    }


}
