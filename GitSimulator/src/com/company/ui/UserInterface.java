package com.company.ui;

import javax.swing.*;

public class UserInterface {

    public static int readMenuOption(){
        String menu = "-------- GIT SIMULATOR ---------";
        menu += "\n\n1 - Criar Repositório";
        menu += "\n2 - Criar Arquivo";
        menu += "\n3 - Excluir Arquivo";
        menu += "\n4 - Git Add";
        menu += "\n5 - Git Commit";
        menu += "\n6 - Listar Arquivos Untracked";
        menu += "\n7 - Listar Arquvios Tracked";
        menu += "\n\n0 - Sair";

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
