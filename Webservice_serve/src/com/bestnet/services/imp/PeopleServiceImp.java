package com.bestnet.services.imp;

import org.springframework.stereotype.Service;
import com.bestnet.services.PeopleService;

@Service
public class PeopleServiceImp implements PeopleService {

    @Override
    public void speak() {
        System.out.println("In PeopleServiceImp speak...");
    }

    @Override
    public void running() {
        System.out.println("In PeopleServiceImp running...");
    }

    @Override
    public void eat() {
        System.out.println("In PeopleServiceImp eat...");
    }

    public PeopleServiceImp() {
        System.out.println("In PeopleServiceImp constructor ...");
    }
}
