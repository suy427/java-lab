package com.sondahum.multithread.actormodel.mailbox;

import java.util.LinkedList;
import java.util.List;

public class MyMailBoxImpl implements MyMailBox {
    private List<MyMail> in = new LinkedList<>();

    @Override
    public synchronized void receiveMail(MyMail mail) {
        in.add(mail);
    }

    @Override
    public boolean hasNext() {
        return !in.isEmpty();
    }

    @Override
    public MyMail next() {
        MyMail mail = in.get(0);
        in.remove(0);
        return mail;
    }
}
