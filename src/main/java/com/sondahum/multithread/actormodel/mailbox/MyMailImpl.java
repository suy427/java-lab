package com.sondahum.multithread.actormodel.mailbox;

public class MyMailImpl implements MyMail {
    private Object content;

    public MyMailImpl(Object content) {
        this.content = content;
    }

    @Override
    public Object getContent() {
        return this.content;
    }
}
