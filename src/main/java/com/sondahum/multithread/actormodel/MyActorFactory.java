package com.sondahum.multithread.actormodel;

import com.sondahum.multithread.actormodel.actor.DatabaseActor;
import com.sondahum.multithread.actormodel.actor.MyActor;

import java.util.HashMap;
import java.util.Map;

public class MyActorFactory {

    private static Map<Class, MyActor> actorMap = new HashMap<>();

    public static MyActor create(Class actorClass) {
        MyActor actor = actorMap.get(actorClass);
        if (actor != null) return actor;

        try {
            actor = (MyActor)actorClass.newInstance();
            new Thread(actor).start();
            actorMap.put(actorClass, actor);
            return actor;
        } catch (InstantiationException instantiationException) {
            instantiationException.printStackTrace();
        } catch (IllegalAccessException illegalAccessException) {
            illegalAccessException.printStackTrace();
        }
        return null;
    }
}
