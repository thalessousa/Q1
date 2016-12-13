/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q1;

import java.util.Scanner;

/**
 *
 * @author thale
 */
public class Main {

    private static double aux;
    static Scanner input = new Scanner(System.in);
    static int opçao = 1, aux2 = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conta contanova = new Conta();
        Correntista clientenovo = new Correntista();
        EstadoDevedor estadoDevedor = new EstadoDevedor();
        EstadoDisponivel estadoDisponivel = new EstadoDisponivel();

        System.out.println("Insira o seu CPF");
        aux = input.nextDouble();
        clientenovo.setCpf(aux);
        estadoDisponivel.doAction(contanova);

        Thread t = new Thread() {
            long endTime = System.currentTimeMillis();
            public void run() {
            }
        };
        long startTime = System.nanoTime();
        t.start();
        while (opçao != 0) {
            System.out.println("O que deseja fazer ?\n1 - Saque \n2 - Depósito\n3 - Simular juros\n0 - Sair");
            opçao = input.nextInt();
            if (opçao == 1) {
                System.out.println("Deseja sacar quanto? \n");
                aux = input.nextDouble();
                contanova.realizarSaque(contanova, aux);

            } else if (opçao == 2) {
                System.out.println("Deseja depositar quanto? \n");
                aux = input.nextDouble();
                contanova.realizarDeposito(contanova, aux);

            } else if (opçao == 3) {
                System.out.println("Insira o numero de meses para a simualação \n");
                long endTime = System.nanoTime();
                long time = (endTime - startTime)/1000000;
                contanova.checarFundos(contanova, estadoDevedor, time);
            }
        }
        System.out.println("Saldo final de : " + contanova.getSaldo());
    }
}
