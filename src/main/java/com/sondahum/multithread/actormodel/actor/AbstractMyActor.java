package com.sondahum.multithread.actormodel.actor;

import com.sondahum.multithread.actormodel.mailbox.MyMail;
import com.sondahum.multithread.actormodel.mailbox.MyMailBox;
import com.sondahum.multithread.actormodel.mailbox.MyMailBoxImpl;
import com.sondahum.multithread.actormodel.mailbox.MyMailImpl;

public abstract class AbstractMyActor implements MyActor {
    private MyMailBox mailBox = new MyMailBoxImpl();

    @Override
    public void tell(MyMail mail) {
        mailBox.receiveMail(mail);
    }

    @Override
    public void run() {
        while(true) {
            receiveMail();
            doWork();
            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void receiveMail() {
        while (mailBox.hasNext()) {
            MyMail mail = mailBox.next();
            processMail(mail);
        }
    }
    abstract void processMail(MyMail mail);
    abstract void doWork();
}
