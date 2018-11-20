package ui;

import javax.swing.*;

public class UserInterface {

    public static int readMenuOption(){
        String menu = "------------  TRELLO  ------------";
        menu += "\n\n1 - Criar novo Quadro";
        menu += "\n2 - Adicionar Lista a Quadro";
        menu += "\n3 - Adicionar Cartão a Listas";
        menu += "\n4 - Exibir Quadros";
        menu += "\n5 - Exibir listas";
        menu += "\n6 - Exibir Cartões";
        menu += "\n\n0 - Sair";

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

    public static String requestCardTitle(){
        return JOptionPane.showInputDialog(null, "Digite o titulo do Cartão: ");
    }

}
