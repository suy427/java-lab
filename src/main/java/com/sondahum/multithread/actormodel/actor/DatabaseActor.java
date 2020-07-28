package com.sondahum.multithread.actormodel.actor;

import com.sondahum.multithread.actormodel.mailbox.MyMail;

public class DatabaseActor extends AbstractMyActor {

    protected void processMail(MyMail mail) {
        System.out.println("db:" + mail.getContent());
    }

    @Override
    void doWork() {

    }
}
