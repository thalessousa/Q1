/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q1;

/**
 *
 * @author thale
 */
public class Conta {

    private State state;
    private int numeroDeConta;
    private float saldo, limite;

    public Conta() {
        this.state = state;
        this.numeroDeConta = numeroDeConta;
        this.saldo = saldo;
        this.limite = limite;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public int getNumeroDeConta() {
        return numeroDeConta;
    }

    public float getSaldo() {
        return saldo;
    }

    public float getLimite() {
        return limite;
    }

    public void setNumeroDeConta(int numeroDeConta) {
        this.numeroDeConta = numeroDeConta;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public void setLimite(float limite) {
        this.limite = limite;
    }

    public void realizarSaque(Conta contanova, double aux) {
        if (contanova.saldo < 0.0) {
            System.out.println("Sua conta está zerada\n");
        } else if (contanova.saldo <= aux) {
            System.out.println("Saldo antes da transação:" + contanova.saldo);
            this.saldo = (float) (this.saldo - aux);
            System.out.println("Saque realizado com sucesso");
            System.out.println("Saldo atual :" + contanova.saldo);
        }
    }

    public void realizarDeposito(Conta contanova, double aux) {
        System.out.println("Saldo antes da transação:" + contanova.saldo);
        this.saldo = (float) (this.saldo + aux);
        System.out.println("Saldo atual :" + contanova.saldo);
    }

    public void checarFundos(Conta contanova, EstadoDevedor estadoDevedor, long time) {
        
        if (contanova.saldo < -1) {
            this.saldo = (this.saldo + this.saldo /time );
            System.out.println("Foi aplicado : " + this.saldo /time + " em sua conta\nSeu saldo atual é de : " + this.saldo);

        }
        estadoDevedor.doAction(contanova);
    }
}
