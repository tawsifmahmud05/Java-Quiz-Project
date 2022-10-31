package org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class startQuiz {
    public static void startingQuiz() throws IOException, ParseException {
        Scanner input = new Scanner(System.in);

        ArrayList<Integer> selectedQues = new ArrayList<Integer>(5);
        int i = 0;
        int point = 0;

        String fileName =  "./src/main/resources/QuestionBank.json";

        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(fileName));
        JSONArray quesList = (JSONArray) obj;

        System.out.println(quesList.size());
        int max = quesList.size() - 1;
        int min = 0;

        System.out.println(" You will be asked 5 questions, each questions has 1 marks");


        do{

            System.out.println("---------------------");
            int randomQuesNo = (int)Math.floor(Math.random()*(max-min+1)+min);


            if(!selectedQues.contains(randomQuesNo)){
                selectedQues.add(randomQuesNo);
//                System.out.println(randomQuesNo);

                JSONObject json = (JSONObject) quesList.get(randomQuesNo);

                System.out.println(i+1 + "." + json.get("Question"));
                System.out.println("a. " + json.get("option a"));
                System.out.println("b. " + json.get("option b"));
                System.out.println("c. " + json.get("option c"));
                System.out.println("d. " + json.get("option d"));
                Object correctAnswer = json.get("answer");

                System.out.print("Enter answer: ");
                String userAnswer = input.nextLine();
                System.out.println("---------------------");
                if(correctAnswer.equals(userAnswer)){
                    System.out.println("Correct");
                    point++;
                }else System.out.println("Not Correct");

                i++;
            }



        }while(i<5);

        System.out.println("---------------------");
        System.out.println("Result: You got "+point+" out of 5");
        System.out.println("---------------------");




    }
}
