package ui;

import javax.swing.*;

public class UserInterface {

    public static int readMenuOption(){
        String menu = "------------  TRELLO  ------------";
        menu += "\n\n1 - Criar novo Quadro";
        menu += "\n2 - Adicionar Lista a Quadro";
        menu += "\n3 - Adicionar Cartão a Listas";
        menu += "\n4 - Mover Lista para outro Quadro";
        menu += "\n";
        menu += "\n5 - Excluir Quadro";
        menu += "\n6 - Excluir Lista";
        menu += "\n7 - Excluir cartão";
        menu +="\n";
        menu += "\n8 - Exibir Quadros";
        menu += "\n9 - Exibir listas";
        menu += "\n10 - Exibir Cartões";
        menu +="\n";
        menu += "\n11 - Exibir Atividade";
        menu += "\n\n0 - Sair";

        String strOpcao = JOptionPane.showInputDialog(null,menu);

        return Integer.parseInt(strOpcao);
    }

    public static void showMsg(String message){

        JOptionPane.showMessageDialog(null, message);

    }

    public static String requestBoardTitle(){
        return JOptionPane.showInputDialog(null, "Digite o título do Quadro: ");
    }

    public static String requestNewBoardTitle(){
        return JOptionPane.showInputDialog(null, "Digite o título do Quadro para qual deseja mover: ");
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
