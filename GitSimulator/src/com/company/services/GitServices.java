package com.company.services;

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

//                              TODO
//    public void gitCommit(ArrayList<File> filesToCommit, String mensagem, Repository repository){
//
//    }


}
