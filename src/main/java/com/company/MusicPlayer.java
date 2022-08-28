package com.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("musicPlayer")
public class MusicPlayer {
    @Value("alan")
    String name;
    @Value("${musicPlayer.age}")
    int age;

    Music music;
    @PostConstruct //init
    public void myInit(){
        System.out.println("Doing init");
    }

    @PreDestroy //destroy
    public void myDestroy(){
        System.out.println("Doing destroy");
    }

    //IOC invertion of control
    @Autowired
    MusicPlayer(@Qualifier("musicBean") Music music){
        this.music=music;
    }



    void playMusic(){
        System.out.println(name+" ");
        music.playSong();
    }

    @Override
    public String toString() {
        return "MusicPlayer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", music="  +
                '}';
    }
}
