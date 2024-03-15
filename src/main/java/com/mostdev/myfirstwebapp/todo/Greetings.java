package com.mostdev.myfirstwebapp.todo;

import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.Calendar;

@Component
public class Greetings {
    Calendar currentTime;
    int hour;

    String greetMsg = "";


    public int getHour() {
        currentTime = Calendar.getInstance();
        hour = currentTime.get(Calendar.HOUR_OF_DAY);
        return hour;
    }

    public String greetings(int hour) {
        if (hour < 12) {
            greetMsg = "Good Morning";
        } else if (hour < 16) {
            greetMsg = "Good Afternoon";
        } else if (hour < 20) {
            greetMsg = "Good Evening";
        }
        else {
            greetMsg = "GoodNight";
        }
        return greetMsg;
    }
}
