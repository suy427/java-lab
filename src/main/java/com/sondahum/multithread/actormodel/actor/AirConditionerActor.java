package com.sondahum.multithread.actormodel.actor;

import com.sondahum.multithread.actormodel.mailbox.MyMail;


public class AirConditionerActor extends AbstractMyActor {

    protected void processMail(MyMail mail) {
        Integer  temp = (Integer) mail.getContent();
        if (temp > 30) System.out.println("Therm : cooling");
        else if (temp < 10) System.out.println("Therm : warming");
        else System.out.println("Therm : keep going");
    }

    @Override
    void doWork() {

    }
}
