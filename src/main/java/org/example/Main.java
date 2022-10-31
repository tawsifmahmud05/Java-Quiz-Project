package org.example;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {

        boolean flag = true;
        char c ;
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to Quiz Mania");
        System.out.println("---------------------");

        while(flag) {
            System.out.println("Choose from the below options:\n1. Add Quiz\n2. Start Quiz\n0. Exit ");
            System.out.println("---------------------");
            System.out.print("Enter digit: ");
            int a = input.nextInt();
            switch (a) {
                case 0:
                    System.out.println("---------------------");
                    System.out.println("Shutting down....");
                    flag = false;
                    break;
                case 1:
                    System.out.println("---------------------");
                    System.out.println("You choose 'Add Quiz'");
                    do {
                        addQuiz.addToQuizBank();
                        System.out.println("Do you want to add more? (y/n)");
                        c = input.next().charAt(0);
                    }while( c == 'y' || c == 'Y');
                    break;
                case 2:
                    System.out.println("---------------------");
                    System.out.println("You choose 'Start Quiz'");
                    startQuiz.startingQuiz();
                    break;
            }
        }

    }
}