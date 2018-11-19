package ui;

import javax.swing.*;

public class UserInterface {

    public static int readMenuOption(){
        String menu = "--------  TRELLO  --------";
        menu += "\n1 - Criar novo Quadro";
        menu += "\n2 - Adicionar Lista a Quadro";
        menu += "\n3 - Exibir Quadros";
        menu += "\n4 - Exibir Listas";
        menu += "\n5 - Adicionando Cartão a Listas";
        menu += "\n\n0 - sair";

        String strOpcao = JOptionPane.showInputDialog(null,menu);

        return Integer.parseInt(strOpcao);
    }

    public static void showMsg(String message){

        JOptionPane.showMessageDialog(null, message);

    }

    public static String requestBoardTitle(){
        return JOptionPane.showInputDialog(null, "Digite o título do quadro: ");
    }

    public static String requestListTitle(){
        return JOptionPane.showInputDialog(null, "Digite o titulo da Lista: ");
    }

    public static String requestVisibility(){
        return JOptionPane.showInputDialog(null, "Digite a visibilidade do quadro: (Private ou Public)");
    }

}
