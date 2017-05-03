package com.lessons.Ex3;

import java.util.Scanner;


public class XorEncrypting {
    public static void main(String[] args) throws Exception{
        byte[] text;
        byte[] key;
        byte[] encriptedText, decrText;

        Scanner scanner = new Scanner(System.in);


            System.out.println("Enter text:");
            text = scanner.nextLine().getBytes();
            System.out.println("Enter key:");
            key = scanner.nextLine().getBytes();
            encriptedText = new byte[text.length];

            for (int i = 0; i < text.length; i++){
                encriptedText[i] = (byte) (text[i]^key[i%key.length]);
            }
            System.out.println("Encripted text:");
            System.out.println(new String(encriptedText));

            System.out.println("Decription:");

            decrText = new byte[encriptedText.length];
            for (int i=0; i<encriptedText.length; i++){
                decrText[i]=(byte)(encriptedText[i]^key[i%key.length]);
            }
            System.out.println("Decripted text:");
            System.out.println(new String(decrText));

    }
}
