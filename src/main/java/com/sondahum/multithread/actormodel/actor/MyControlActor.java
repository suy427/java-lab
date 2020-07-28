package com.sondahum.multithread.actormodel.actor;

import com.sondahum.multithread.actormodel.MyActorFactory;
import com.sondahum.multithread.actormodel.mailbox.MyMail;

public class MyControlActor extends AbstractMyActor {
    MyActor db;
    MyActor thermostat;

    public MyControlActor() {
        db = MyActorFactory.create(DatabaseActor.class);
        thermostat = MyActorFactory.create(AirConditionerActor.class);
    }

    @Override
    protected void processMail(MyMail mail) {
        db.tell(mail);
        thermostat.tell(mail);
    }

    @Override
    protected void doWork() {

    }
}
