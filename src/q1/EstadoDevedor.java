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
public class EstadoDevedor implements State {

   public void doAction(Conta context) {
      System.out.println("Conta está com saldo devedor");
      context.setState(this);	
   }

   public String toString(){
      return "Conta Devedora";
   }
}
