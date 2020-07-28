package com.sondahum.multithread.actormodel.mailbox;

public interface MyMailBox {
    void receiveMail(MyMail mail);
    boolean hasNext();
    MyMail next();
}
