package model;

public class Conta {

    private Titular titular;
    private Integer numero;
    private String senha;
    private double saldo;

    public Conta(Titular titular, Integer numero, double saldo, String senha) {
        this.titular = titular;
        this.numero = numero;
        this.saldo = saldo;
        this.senha = senha;
    }

    public Titular getTitular() {
        return titular;
    }

    public Integer getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getSenha() {
        return senha;
    }

    public boolean depositar(double valor){

        if (valor > 0){

            this.saldo += valor;

            return true;
        }else
            return false;

    }

    public boolean sacar(double valor){

        if (this.saldo > 0){
            this.saldo -= valor;

            return true;
        }else{
            return false;
        }

    }


    public boolean transferir(double valor, Conta contaDestino){

        if (this.saldo > 0 && this.saldo >= valor){

            sacar(valor);
            contaDestino.depositar(valor);

            return true;
        }else{
            return false;
        }

    }

    public String consultarSaldo(){
        String strSaldo = String.valueOf(this.saldo);

        return strSaldo;
    }
}
