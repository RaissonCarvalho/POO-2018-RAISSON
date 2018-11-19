package ui;

import javax.swing.*;

public class UserInterface {

    public static int readMenuOption(){
        String menu = "--------  TRELLO  --------";
        menu += "\n1 - Criar novo Quadro";
        menu += "\n2 - Adicionar Lista a Quadro";
        menu += "\n\n0 - sair";

        String strOpcao = JOptionPane.showInputDialog(null,menu);

        return Integer.parseInt(strOpcao);
    }

    public static void showMsg(String message){

        JOptionPane.showMessageDialog(null, message);

    }

    public static String requestTitle(){
        return JOptionPane.showInputDialog(null, "Digite o título: ");
    }

    public static String requestType(){
        return JOptionPane.showInputDialog(null, "Digite o tipo do quadro: (Private ou Public)");
    }

}
