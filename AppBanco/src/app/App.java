package app;

import model.Conta;
import services.BancoServices;
import ui.UserInterface;

import javax.swing.*;


public class App {

    public static void main(String[] args) {

        BancoServices bancoServices = new BancoServices();

        /* Criando constantes para criação opções de Menu */
        final int CRIAR_CONTA = 1;
        final int FAZER_LOGIN = 2;
        final int DEPOSITAR = 3;
        final int SAIR = 0;

        while (true){

            int opcao  = UserInterface.lerOpcaoMenu();

            switch (opcao){

                case CRIAR_CONTA:{

                    String nome = UserInterface.solicitaNome();
                    String cpf = UserInterface.solicitaCPF();
                    String senha = UserInterface.solicitaSenha();

                    bancoServices.criarContaCorrente(nome, cpf, senha);

                    break;

                }
                case FAZER_LOGIN:

                    if (bancoServices.getListaContas().size() <= 0){

                        UserInterface.showMsg("Nenhuma conta cadastrada!");
                        break;

                    }else{

                        String cpfDigitado = UserInterface.solicitaCPF();
                        String senhaDigitada = UserInterface.solicitaSenha();
                        Conta conta = bancoServices.logar(cpfDigitado, senhaDigitada);

                        final int SACAR = 1;
                        final int DEPOSITAR_LOGADO = 2;
                        final int TRANSFERIR = 3;
                        final int MOSTRAR_SALDO = 4;
                        final int FAZER_LOGOUT = 0;

                        while (true){

                            int op = UserInterface.lerOpcaoMenuLogado();

                            switch (op){
                                case SACAR:

                                    double valor = UserInterface.solicitaValor();
                                    if (bancoServices.sacar(conta, valor)) {
                                        bancoServices.sacar(conta, valor);
                                        UserInterface.showMsg("Saque realizado com sucesso");
                                    }else
                                        UserInterface.showMsg("Saldo Insuficiente!");

                                    break;
                                case DEPOSITAR_LOGADO:
                                    double valorDeposito = UserInterface.solicitaValor();

                                    if (bancoServices.depositarLogado(conta, valorDeposito)){

                                        bancoServices.depositarLogado(conta, valorDeposito);
                                        UserInterface.showMsg("Depositado com sucesso!");

                                    }else{
                                        UserInterface.showMsg("Verifique o valor digitado!");
                                    }

                                    break;
                                case TRANSFERIR:

//                           TODO
//
//                                    Conta contaTransferencia = null;
//
//                                    double valorTransferido = Double.valueOf(JOptionPane
//                                            .showInputDialog("Digite o valor a ser transferido: "));
//
//                                    String cpfDigitadoParaDeposito = solicitaCPFContaDeposito();
//
//                                    for (int z = 0; z < listaContas.size(); z++){
//0
//                                        String cpfUsrContaDeposito = listaContas.get(i).getTitular().getCpf();
//
//                                        if (cpfUsrContaDeposito.equals(cpfDigitadoParaDeposito)){
//
//                                            contaTransferencia = listaContas.get(i);
//
//                                            if (conta.transferir(valorTransferido, contaTransferencia)){
//
//                                                conta.sacar(valorTransferido);
//                                                contaTransferencia.depositar(valorTransferido);
//
//                                            }else{
//                                                showMsg("Saldo Insuficiente!");
//                                            }
//
//                                        }else{
//                                            showMsg("CPF inválido!");
//                                        }
//
//                                    }

                                    break;
                                case MOSTRAR_SALDO:
                                    showMsg(conta.consultarSaldo());
                                    break;
                                case FAZER_LOGOUT:
                                    return;
                                default:
                                    UserInterface.showMsg("Opção Inválida!");

                            }

                        }

                    }

                    /* Criando constantes para criação de Menu enquanto logado */


//                    break;
//                case DEPOSITAR:
//                    TODO
//
//                    Conta contaDeposito = null;
//
//                    if (listaContas.size() > 0){
//
//                        String cpfDigitado = solicitaCPF();
//                        double valorDeposito = Double.valueOf(JOptionPane
//                                .showInputDialog(null, "Digite o valor a depositado: "));
//
//                        for (int i = 0; i < listaContas.size(); i++){
//
//                            String cpfUsr = listaContas.get(i).getTitular().getCpf();
//
//                            if (cpfUsr.equals(cpfDigitado)){
//
//                                contaDeposito = listaContas.get(i);
//                                depositar(contaDeposito, valorDeposito);
//
//                                break;
//
//                            }
//
//                        }
//                    }
//
//                    break;
                case SAIR:
                    return;
                default:
                    showMsg("Opção Inválida");
                    break;

            }

        }

    }

    private static void showMsg(String msg){
        JOptionPane.showMessageDialog(null, msg);
    }

    private static void depositar(Conta contaDestino, double valor){
        contaDestino.depositar(valor);
    }

}
