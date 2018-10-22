package com.company.services;

import com.company.model.File;
import com.company.model.StageArea;

import java.util.ArrayList;

public class StageAreaServices {

    private StageArea stageArea;

    public StageArea getStageArea() {
        return stageArea;
    }

    public void gitAdd(ArrayList<File> fileList){
        stageArea = new StageArea();
        stageArea.setStageAreaFileList(fileList);

    }

    public String listingFilesToCommit(){

        String fileNamesToCommit = "Arquivos a serem commitados: \n ";

        if (stageArea.getStageAreaFileList().size() <= 0){

            return "Lista Vazia";

        }else{

            for (int i = 0; i < stageArea.getStageAreaFileList().size(); i++){

                fileNamesToCommit += "- " + stageArea.getStageAreaFileList().get(i).getName()+ " \n";

            }

            return fileNamesToCommit;

        }
    }

}
