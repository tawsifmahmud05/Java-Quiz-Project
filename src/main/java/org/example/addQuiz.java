package org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class addQuiz {

    public static void addToQuizBank() throws IOException, ParseException {
        Scanner input = new Scanner(System.in);

        String question,a,b,c,d;

        String answer;

        System.out.print("Enter the Question here: ");
        question = input.nextLine();

        System.out.print("Option a: ");
        a = input.nextLine();

        System.out.print("Option b: ");
        b = input.nextLine();

        System.out.print("Option c: ");
        c = input.nextLine();

        System.out.print("Option d: ");
        d = input.nextLine();

        do {
            System.out.print("correct answer:");
            answer = String.valueOf(input.next().charAt(0));
            System.out.println();
        }while ( !answer.equals("a") && !answer.equals("b") && !answer.equals("c") && !answer.equals("d"));

//        System.out.println(question + a + b + c + d + answer);

        String fileName =  "./src/main/resources/QuestionBank.json";

        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(fileName));

        JSONObject quesObj = new JSONObject();

        quesObj.put("Question",question);
        quesObj.put("option a", a);
        quesObj.put("option b", b);
        quesObj.put("option c", c);
        quesObj.put("option d", d);
        quesObj.put("answer", answer);

        JSONArray quesList = (JSONArray) obj;
        quesList.add(quesObj);

        System.out.println();

        FileWriter file = new FileWriter(fileName);
        file.write(quesList.toJSONString());
        file.flush();
        file.close();

        System.out.println("Quiz saved at the database");


    }
}
