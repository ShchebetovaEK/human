package com.company;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

import static com.company.Sex.*;

public class Main {
    private static Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        HumanDao humanDao = new HumanDaoFile("human.txt");

        Human human = new Human("Simon", "Pirko", 27, MALE);
        Human human3 = new Human("Lev", "Pirko", 27, MALE);
        Human human2 = new Human("Elena", "Shchebetova", 28, FEMALE);

        humanDao.add(human);
        humanDao.add(human);
        humanDao.add(human2);
        humanDao.add(human3);
        humanDao.remove("Shchebetova");
        humanDao.add(human2);
        humanDao.changeByLastName("Shchebetova", human3);
        System.out.println(humanDao.searchByLastName("Pirko"));


    }
}
