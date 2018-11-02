package services;

import model.Conta;
import model.ContaCorrente;
import model.Titular;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class BancoServices {

    private ArrayList<Conta> listaContas = new ArrayList<>();

    public ArrayList<Conta> getListaContas() {
        return listaContas;
    }

    public void criarContaCorrente(String nome, String cpf, String senha){

        try {

            Titular titular = new Titular(nome, cpf);

            /* Gerando número randômico para a conta */
            Random random = new Random();
            int numeroRandomConta = random.nextInt(9999 - 1000) + 1000;

            Conta conta = new ContaCorrente(titular, numeroRandomConta, 0, senha);

            showMsg("Cadastro realizado com Sucesso");

            listaContas.add(conta);

        }catch (Exception e){
            showMsg("Erro");

        }

    }

    public Conta logar(String cpfDigitado, String senhaDigitada){

        Conta conta = null;
        if (listaContas.size() > 0){

            for (int i = 0; i < listaContas.size(); i++){

                String cpfUsr = listaContas.get(i).getTitular().getCpf();
                String senhaUsr = listaContas.get(i).getSenha();

                /* Percorrendo Lista de Contas para verificação de CPF e senha */
                if (cpfUsr.equals(cpfDigitado) && senhaUsr.equals(senhaDigitada)){

                    conta = listaContas.get(i);
                    showMsg("Bem vindo "+conta.getTitular().getNome());

                }else{
                    showMsg("CPF ou senha Inválidos!");
                    break;
                }

            }

        }else{
            showMsg("Nenhuma conta cadastrada!");
        }
        return conta;
    }

    public boolean sacar(Conta conta, double valor){

        if (conta.sacar(valor)) {
            conta.sacar(valor);
            return true;
        }else
            return false;

    }

    public boolean depositarLogado(Conta contaLogada, double valor){
        if (contaLogada.depositar(valor)){
            contaLogada.depositar(valor);

            return true;
        }else{
            return false;
        }

    }

    private static void showMsg(String msg){
        JOptionPane.showMessageDialog(null, msg);
    }

}
