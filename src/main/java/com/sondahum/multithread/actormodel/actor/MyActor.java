package com.sondahum.multithread.actormodel.actor;

import com.sondahum.multithread.actormodel.mailbox.MyMail;

public interface MyActor extends Runnable {
    void tell(MyMail mail);
}
