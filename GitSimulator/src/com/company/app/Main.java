package com.company.app;

import com.company.model.File;
import com.company.model.Repository;
import com.company.services.FileServices;
import com.company.services.GitServices;
import com.company.ui.UserInterface;

import java.util.ArrayList;
import java.util.WeakHashMap;

public class Main {

    public static void main(String[] args) {

        ArrayList<File> files = new ArrayList<>();

        FileServices fileServices = new FileServices();
        GitServices gitServices = new GitServices();

        final int CRIAR_REPOSITORIO = 1;
        final int CRIAR_ARQUIVO = 2;
        final int EXCLUIR_ARQUVIVO = 3;
        final int GIT_ADD = 4;
        final int GIT_COMMIT = 5;
        final int LISTAR_ARQUIVOS_UNTRACKED = 6;
        final int LISTAR_ARQUIVOS_TRACKED = 7;
        final int SAIR = 0;

        while (true){

            int opcao = UserInterface.readMenuOption();

            switch (opcao){

                case CRIAR_REPOSITORIO:

                    String repositoryName = UserInterface.requestRepositoryName();
                    Repository repository = new Repository(repositoryName, null);

                    break;
                case CRIAR_ARQUIVO:

                    String fileName = UserInterface.requestFileName();
                    fileServices.createFile(fileName, 0, false);

                    break;
                case EXCLUIR_ARQUVIVO:


                    break;
                case GIT_ADD:

                    gitServices.gitAdd(fileServices);


                    break;
                case GIT_COMMIT:

                    break;
                case LISTAR_ARQUIVOS_UNTRACKED:

                    UserInterface.showMsg(fileServices.listiningUntrackedFiles());

                    break;
                case LISTAR_ARQUIVOS_TRACKED:

                    UserInterface.showMsg(fileServices.listiningTrackedFiles());

                    break;

                case SAIR:
                    return;
                default:
                    UserInterface.showMsg("Opção Inválida!");


            }

        }

    }
}
