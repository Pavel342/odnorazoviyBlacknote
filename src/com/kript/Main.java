package com.kript;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        System.out.println("Введите сообщение");
        String vvodText=in.nextLine();
        byte[] rab=vvodText.getBytes();
        byte[] key={5,11,16};
        byte[] encryptMas=new byte[rab.length];
        byte[] decryptMas=new byte[rab.length];
        for(int i=0;i< rab.length;i++)
            encryptMas[i]=(byte) (rab[i] ^ key[i%3]);
        for(int i=0;i< rab.length;i++)
            decryptMas[i]=(byte) (encryptMas[i] ^ key[i%3]);
        boolean proverka=Arrays.equals(rab, decryptMas);
        if(proverka)System.out.println("Шифрование и дешифрование прошло успешно!");
         else System.out.println("Ошибка");
         String otvet=new String(decryptMas);
         System.out.println(otvet);
    }
}
