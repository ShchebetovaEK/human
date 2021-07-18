package com.company;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class HumanDaoFile implements HumanDao {

    private final String fileName;

    public HumanDaoFile(String fileName) {
        this.fileName = fileName;
    }


    @Override
    public void add(Human human) {
        List<Human> list = getAll();
        list.add(human);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            Gson gson = new Gson();
            String json = gson.toJson(list);
            bufferedWriter.write(json);

        } catch (IOException ex) {
            throw new RuntimeException(ex);

        }


    }

    @Override
    public int remove(String lastName) {
        int count = 0;
        List<Human> list = getAll();
        for (int i = 0; i < list.size(); i++) {
            Human human = list.get(i);
            if (human.getLastName().equals(lastName)) {
                count++;
                list.remove(human);
                i--;
            }

        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            Gson gson = new Gson();
            String json = gson.toJson(list);
            bufferedWriter.write(json);

        } catch (IOException ex) {
            throw new RuntimeException(ex);

        }

        return count;
    }


    @Override
    public List<Human> getAll() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {

            String json = "";


            while (bufferedReader.ready()) {
                json += bufferedReader.readLine();
            }

            Gson gson = new Gson();
            Type targetClassType = new TypeToken<ArrayList<Human>>() {
            }.getType();
            List<Human> targetCollection = gson.fromJson(json, targetClassType);
            return targetCollection;


        } catch (IOException ex) {
            throw new RuntimeException(ex);

        }

    }

    @Override
    public int changeByLastName(String lastName, Human human) {
        int count = 0;
        List<Human> list = getAll();
        for (int i = 0; i < list.size(); i++) {
            Human human1 = list.get(i);
            if (human1.getLastName().equals(lastName)) {
                count++;
                list.set(i, human);
                i--;
            }
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            Gson gson = new Gson();
            String json = gson.toJson(list);
            bufferedWriter.write(json);

        } catch (IOException ex) {
            throw new RuntimeException(ex);

        }

        return count;
    }

    @Override
    public Human searchByLastName(String lastName) {

        List<Human> list = getAll();
        for (int i = 0; i < list.size(); i++) {
            Human human = list.get(i);
            if (human.getLastName().equals(lastName)) {
                return human;
            }
        }
        return null;
    }
}
