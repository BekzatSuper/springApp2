package com.company;

import org.springframework.stereotype.Component;

@Component("musicBean")
public class ClassicalMusic implements Music{
    @Override
    public void playSong() {
        System.out.println("Classical");
    }
}
