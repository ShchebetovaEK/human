package com.company;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

import static com.company.Sex.*;

public class Main {


        private  static  final  Gson GSON  = new GsonBuilder().setPrettyPrinting().create();

        public static void main(String[] args) {


        Human human = new Human("Simon","Pirko",27,MALE);
       System.out.println(human);

        String json = GSON.toJson(human);
        System.out.println(json);

        Human human2 = GSON.fromJson(json,Human.class);
        System.out.println(human2.getFirstName());
        System.out.println(human2.getSecondName());
        System.out.println(human2.getAge());
        System.out.println(human2.getSex());

        File fileHuman = new File("human.txt");

        try {
                BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileHuman));
                fileWriter.write(json);
                fileWriter.close();
        }catch (IOException ex){
                ex.printStackTrace();
        }


        try {
                FileReader reader = new FileReader("human.txt");
                int c;
                while((c=reader.read())!=-1){

                        System.out.print((char)c);
                }

        }catch (IOException ex){
                ex.printStackTrace();
        }

    }
}
