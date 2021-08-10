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

    public void edit(Classes c, String cd){
        classRepository.edit(c, cd);
    }
}
