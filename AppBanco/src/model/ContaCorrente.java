package model;

public class ContaCorrente extends Conta {

    private Titular titular;
    private int numero;
    private String senha;
    private double saldo;

    public ContaCorrente(Titular titular, Integer numero, double saldo, String senha){
        super(titular, numero, saldo, senha);
    }

    @Override
    public boolean depositar(double valor) {
        if (valor > 0){

            this.saldo += valor;

            return true;
        }else
            return false;

    }

    @Override
    public boolean sacar(double valor) {

        if (this.saldo > 0){
            this.saldo -= valor;

            return true;
        }else{
            return false;
        }

    }

    @Override
    public boolean transferir(double valor, Conta contaDestino) {

        if (this.saldo > 0 && this.saldo >= valor){

            sacar(valor);
            contaDestino.depositar(valor);

            return true;
        }else{
            return false;
        }

    }

    @Override
    public String consultarSaldo() {

        String strSaldo = String.valueOf(this.saldo);

        return strSaldo;

    }
}
