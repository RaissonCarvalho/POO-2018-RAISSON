package com.company.ui;

import javax.swing.*;

public class UserInterface {

    public static int readMenuOption(){
        String menu = "--------  GIT SIMULATOR  --------";
        menu += "\n\n1 - Criar Repositório";
        menu += "\n\n2 - Criar Arquivo";
        menu += "\n\n3 - Excluir Arquivo";
        menu += "\n\n4 - Git Add";
        menu += "\n\n5 - Git Reset";
        menu += "\n\n6 - Git Commit";
        menu += "\n\n7 - Listar Arquivos Untracked";
        menu += "\n\n8 - Listar Arquvios Tracked";
        menu += "\n\n\n0 - Sair";

        String strOpcao = JOptionPane.showInputDialog(null,menu);

        return Integer.parseInt(strOpcao);
    }

    public static void showMsg(String message){

        JOptionPane.showMessageDialog(null, message);

    }

    public static String requestFileName(){
        try {

            return JOptionPane.showInputDialog("Digite o nome do arquivo: ");

        }catch (NumberFormatException e){

            return "Digite caracteres validos";
        }
    }

    public static String requestRepositoryName(){
        return JOptionPane.showInputDialog("Digite o nome do repositorio:  ");
    }
}
