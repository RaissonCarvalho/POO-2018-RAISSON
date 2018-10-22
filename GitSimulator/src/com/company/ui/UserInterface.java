package com.company.ui;

import javax.swing.*;

public class UserInterface {

    public static int readMenuOption(){
        String menu = "-------- GIT SIMULATOR ---------";
        menu += "\n\n1 - Criar Repositório";
        menu += "\n2 - Add Arquivo";
        menu += "\n3 - Excluir Arquivo";
        menu += "\n\n0 - Sair";

        String strOpcao = JOptionPane.showInputDialog(null,menu);

        return Integer.parseInt(strOpcao);
    }

    public static void showMsg(String message){

        JOptionPane.showMessageDialog(null, message);

    }

    public static String requestName(){
        return JOptionPane.showInputDialog("Digite o nome do arquivo: ");
    }
}
