package com.company;

import java.util.List;

public interface HumanDao {
    void add(Human human);
    int remove(String lastName);
    List <Human>  getAll();
    int changeByLastName(String lastName, Human human);
    Human searchByLastName(String lastName);
}
