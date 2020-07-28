package com.sondahum.multithread.actormodel;

import com.sondahum.multithread.actormodel.actor.MyActor;
import com.sondahum.multithread.actormodel.actor.MyControlActor;
import com.sondahum.multithread.actormodel.mailbox.MyMailImpl;

import java.util.Scanner;

public class ActorRunner {

    public static void main(String[] args) {
        MyActor actor = MyActorFactory.create(MyControlActor.class);
        Scanner sc = new Scanner(System.in);
        while (true) {
            Integer temperature = sc.nextInt();
            actor.tell(new MyMailImpl(temperature));
        }

    }
}
