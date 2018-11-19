package ui;

import javax.swing.*;

public class UserInterface {

    public static int readMenuOption(){
        String menu = "--------  TRELLO  --------";
        menu += "\n\n1 - Criar novo Quadro";

        String strOpcao = JOptionPane.showInputDialog(null,menu);

        return Integer.parseInt(strOpcao);
    }

    public static void showMsg(String message){

        JOptionPane.showMessageDialog(null, message);

    }

    public static String requestTitle(){
        return JOptionPane.showInputDialog(null, "Digite o título");
    }

}
