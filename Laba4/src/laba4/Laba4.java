/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laba4;

import java.util.Scanner;

/**
 *
 * @author andre
 */
public class Laba4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner;
        scanner = new Scanner(System.in);
        
        System.out.print("Number of elements = ");
        int size = scanner.nextInt();
        
        ForwardList el = new ForwardList();
        for (int i = 0; i < size; i++){
            String el1;
            el1 = scanner.next();
            el.addElement(el1);
        }
        
        
        System.out.print("Our list: ");
        el.printList();
    }
    
}
