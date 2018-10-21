package com.company.services;

import com.company.model.File;
import com.company.model.StageArea;

import java.util.ArrayList;

public class StageAreaServices {

    private FileServices fileServices;

    private StageArea stageArea = new StageArea();

    private ArrayList<File> listFileStageArea = stageArea.getListFileStageArea();

    public void gitAdd(){

       try {

           listFileStageArea = fileServices.searchModifiedFiles();

           for (int i = 0; i < listFileStageArea.size(); i++){

               listFileStageArea.get(i).setModified(false);

           }

       }catch (NullPointerException e){
           System.out.println(e.getMessage());
       }

    }

}
