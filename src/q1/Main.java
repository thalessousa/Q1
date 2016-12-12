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
    static int opçao = 1;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conta contanova = new Conta();
        Correntista clientenovo = new Correntista();

        EstadoInativo estadoInicial = new EstadoInativo();

        System.out.println("Insira o seu CPF");
        aux = input.nextDouble();
        clientenovo.setCpf(aux);
        System.out.println("Iremos checar o estado de sua conta...");
        estadoInicial.doAction(contanova);

        {
            System.out.println("Gostaria de ativar a sua conta?\n1 - Sim\n0 - Não");
            aux = input.nextInt();
            if (aux == 1) {
                EstadoAtivo estadoAtual = new EstadoAtivo();
                estadoAtual.doAction(contanova);

                while (opçao != 0) {
                    System.out.println("O que deseja fazer ?\n1 - Saque \n2 - Depósito\n3 - Fechar conta\n0 - Sair");
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
                        System.out.println("Deseja cancelar sua conta? \n");
                        estadoInicial.doAction(contanova);

                    }
                }
                contanova.checarFundos(contanova);
            } else {
                opçao = 0;
            }
        }
    }
}
