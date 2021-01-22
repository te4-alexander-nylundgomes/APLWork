package com.alexwork;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import static java.lang.System.exit;

public class Main {

    public static Coordinate[][] init(){
        Coordinate[][] playingField = new Coordinate[3][3];

        for(Coordinate[] row: playingField){
            for(int i=0; i<row.length; i++){
                row[i] = new Coordinate();
            }
        }

        return playingField;
    }

    public static void puts(String s){
        System.out.println(s);
    }

    public static Coordinate[][] round(Coordinate[][] playingField){
        int randomNum = ThreadLocalRandom.current().nextInt(0, 10 + 1);
        String message = String.format("This rounds number is: %s", randomNum);

        puts(message);
        puts("Do you have this number in your playing card? (y/n/w)");

        toMatrix(playingField);
        String answer = getUserInput();

        if(answer.toLowerCase().equals("y")){
            boolean truthfulAnswer = validInput(playingField, randomNum);
            if(!truthfulAnswer){
                System.out.println("Trying to cheat the system are we? We'll then, no more playing for you!");
                exit(0);
            }
        }else if(answer.toLowerCase().equals("w")){
            boolean won = hasWon(playingField);
            if(won){
                System.out.println("My god! You beat me in my own game!");
                System.out.println("Well then, congratulations!");
                exit(0);
            }else{
                System.out.println("Trying to cheat the system are we? We'll then, no more playing for you!");
                exit(0);
            }
        }

        return playingField;
    }

    public static boolean hasWon(Coordinate[][] playingField){

        //Check all rows
        for(Coordinate[] row: playingField){
            int counter = 0;
            for(int i=0; i<row.length; i++){
                if(row[i].found){
                    counter++;
                }
            }

            if(counter == row.length){
                System.out.println("Found a row!");
                return true;
            }
        }

        //Check all columns


        for(int i=0; i<playingField.length; i++){
            int counter = 0;
            for(Coordinate[] row: playingField){
                if(row[i].found){
                    counter++;
                }


                if(counter == playingField.length){
                    System.out.println("Found a column!");
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean validInput(Coordinate[][] playingField, int number){
        boolean isValid = false;
        for(Coordinate[] row: playingField){
            for(int i=0; i<row.length; i++){
                if(row[i].value == number && row[i].found == false){
                    row[i].found = true;
                    isValid = true;
                }
            }
        }

        return isValid;
    }

    public static String getUserInput(){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        return s;
    }

    public static void toMatrix(Coordinate[][] playingField){
        for(Coordinate[] row: playingField){
            for(int i=0; i<row.length; i++){
                if(row[i].found){
                    System.out.print("X" + " ");
                }else{
                    System.out.print(Integer.toString(row[i].value) + " ");
                }

            }
            System.out.println();
        }
    }

    public static boolean noValuesLeft(Coordinate[][] playingField){
        int counter = 0;

        for(Coordinate[] row: playingField){
            for(int i=0; i<row.length; i++){
                if(row[i].found){
                    counter++;
                }
            }
        }

        return counter == 9;
    }

    public static void greeting() {
        System.out.println("Greetings!");
        System.out.println("Welcome to the towns finest bingo! Heres how to play:");
        System.out.println("You will recieve a playing card. Each round, a number will be presented. \n" +
                "If your playing card includes the number, press y and then enter.\n" +
                "If your card however does not include the number, press n and then enter.\n" +
                "When you've won press w and enter.\n\n" +
                "And don't you dare try to cheat the system! Understood? (y/n)");
        String answer = "";
        while(!answer.toLowerCase().equals("y")){
            answer = getUserInput();
            if(answer.toLowerCase().equals("y")){
                System.out.println("Great! Here we go!\n\n\n");
            }else if(answer.toLowerCase().equals("n")){
                System.out.println("Who on earth doesn't understand bingo!? Read it again, chump!");
            }else{
                System.out.println("Wrong button!");
            }
        }


    }

    public static void main(String[] args) throws InterruptedException {
	// write your code here
        Coordinate[][] playingField = init();

        greeting();
        TimeUnit.SECONDS.sleep(2);
        while(!noValuesLeft(playingField)){
            round(playingField);
        }

        toMatrix(playingField);
        System.out.println("The whole playing field is crossed out!? Do you even know how to play bingo?");

    }
}