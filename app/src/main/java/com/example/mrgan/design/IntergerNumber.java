package com.example.mrgan.design;

public class IntergerNumber {
     int level,number;
     public IntergerNumber(int level){
         this.level = level;
     }
     public int createNumber(){
         switch (level){
             case 0:
                 number = (int) (Math.random()*(11-0)+0);
                 break;
             case 1:
                 number = (int) (Math.random()*(21-11)+11);
                 break;
             case 2:
                 number = (int) (Math.random()*(51-21)+21);
                 break;
             case 3:
                 number = (int) (Math.random()*(101-51)+51);
                 break;
         }
         return number;
     }
}
