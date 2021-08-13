package com.revature.p0.services;

import com.revature.p0.models.Classes;
import com.revature.p0.repository.ClassRepository;

public class ClassService {

    public ClassService(ClassRepository classRepository){
        this.classRepository = classRepository;
    }

    ClassRepository classRepository;

    public void add(Classes c){
        classRepository.add(c);
    }

    public void remove(String cd){
        classRepository.remove(cd);
    }

    public void showAll(){
        classRepository.showAll();
    }

    public void show(String username){
        classRepository.show(username);
    }

    public void register(String cd, String username){
        classRepository.register(cd, username);
    }

    public void edit(Classes c, String cd){
        classRepository.edit(c, cd);
    }

    public void drop(String cd, String username){
        classRepository.drop(cd, username);
    }
}
