package BankingApplication;

import javax.swing.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Customer customer1 = new Customer();
        Customer customer2 = new Customer();
        String notice = "WELCOME TO GOLDMAN SACHS\n" +
                "Enter 1 to create an Account\n" +
                "Enter 2 to Deposit into an Account. Disclaimer: for existing customers\n"+
                "Enter 3 to withdraw from an Account. Disclaimer: for existing customers\n"+
                "Enter 4 to Transfer from one account to another. Disclaimer:  for users with existing Customer accounts\n"+
                "Enter 5 to Exit bank";


       int userInput = Integer.parseInt(JOptionPane.showInputDialog(null, notice));

       switch (userInput){
//           case 1 -> customer1.
       }

    }

}
