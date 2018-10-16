package ui;

import javax.swing.*;

public class UserInterface {

    public static int lerOpcaoMenu(){
        String menu = "-------- CAIXA ELETRÔNICO ---------";
        menu += "\n\n1 - Criar Conta";
        menu += "\n2 - Fazer Login";
        menu += "\n3 - Depositar";
        menu += "\n\n0 - Sair";

        String strOpcao = JOptionPane.showInputDialog(null,menu);

        return Integer.parseInt(strOpcao);
    }

    public static int lerOpcaoMenuLogado(){
        String menu = "-------- CAIXA ELETRÔNICO ---------";
        menu += "\n\n1 - Sacar";
        menu += "\n2 - Depositar";
        menu += "\n3 - Transferir";
        menu += "\n4 - Mostrar Saldo";
        menu += "\n\n0 - Logout";

        String strOpcao = JOptionPane.showInputDialog(null,menu);

        return Integer.parseInt(strOpcao);
    }

    public static String solicitaNome(){
        return JOptionPane.showInputDialog("Digite seu nome: ");
    }

    public static String solicitaCPF(){
        return JOptionPane.showInputDialog("Digite seu CPF: ");
    }

    public static String solicitaSenha() {
        return JOptionPane.showInputDialog("Digite sua senha: ");
    }

    public static Double solicitaValor(){
        double valor = Double.valueOf(JOptionPane.showInputDialog("Digite o valor desejado: "));

        return valor;
    }

    public static String solicitaCPFContaDeposito(){
        return JOptionPane.showInputDialog("Digite o CPF do titular da conta para transferência: ");
    }

    public static void showMsg(String msg){
        JOptionPane.showMessageDialog(null, msg);
    }

}
