package model;

public abstract class Conta {

    private Titular titular;
    private int numero;
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

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getSenha() {
        return senha;
    }

    public abstract boolean depositar(double valor);

    public abstract boolean sacar(double valor);

    public abstract boolean transferir(double valor, Conta contaDestino);

    public abstract String consultarSaldo();
}
