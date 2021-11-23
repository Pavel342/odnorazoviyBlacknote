package com.kript;
import java.util.Scanner;
import java.util.Random;

public class blocknotBit {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        System.out.println("Введите двоичные данные");
        String vvodText=in.nextLine();
        byte[] bloknotMas = new byte[1000];
        Random rand = new Random();
        rand.nextBytes(bloknotMas);
        byte[] vvodBite = vvodText.getBytes();
        int kolvo=1;
        for (byte b : vvodBite) if (b == 32) kolvo++;
        byte[][] matr=new byte[kolvo][vvodBite.length];
        int index = 0;
        byte[][] masshifr = new byte[kolvo][vvodBite.length];
        for(int i = 0, j=0; i < kolvo; i++, j++) {
            try{if (vvodBite[i] != 32) {
                matr[i][j] = vvodBite[index];
                index++;
                i--;
            }}
            catch(Exception e){ break;}
        }
        index=0;
        for( int i = 0; i < kolvo; i++, index++) {
            if(index >= bloknotMas.length)
            {
                rand.nextBytes(bloknotMas);
                index = 0;
            }
            for(int j=0; j<matr[i].length;j++){
                masshifr[i][j] = (byte)(matr[i][j] ^ bloknotMas[index]);
                index++;
            }
        }
        byte[][] deshifr=new byte[kolvo][vvodBite.length];
        index=0;
        for( int i = 0; i < kolvo; i++) {
            for(int j=0;j<masshifr[i].length;j++,index++)
                deshifr[i][j] = (byte)(masshifr[i][j] ^ bloknotMas[index]);
            index+=masshifr[i].length;
        }
        String otvet = new String(deshifr[0]);
        System.out.print(otvet+" ");
    }
}
