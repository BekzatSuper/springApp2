package com.company;

import org.springframework.stereotype.Component;

@Component("rockMusic")
public class RockMusic implements Music{
    @Override
    public void playSong() {
        System.out.println("Rock");
    }
}
