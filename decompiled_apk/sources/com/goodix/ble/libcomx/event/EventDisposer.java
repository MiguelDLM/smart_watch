package com.goodix.ble.libcomx.event;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes9.dex */
public class EventDisposer {
    private ArrayList<Event> events = new ArrayList<>(64);

    public void add(Event event) {
        if (!this.events.contains(event)) {
            this.events.add(event);
        }
    }

    public void clearListener(Object obj) {
        Iterator<Event> it = this.events.iterator();
        while (it.hasNext()) {
            it.next().clear(obj);
        }
    }

    public void disposeAll(Object obj) {
        Iterator<Event> it = this.events.iterator();
        while (it.hasNext()) {
            Event next = it.next();
            next.clear(obj);
            if (obj != null) {
                next.clear();
            }
        }
        this.events.clear();
    }

    public static void clearListener(Object obj, Object obj2, boolean z) {
        if (obj == null) {
            return;
        }
        for (Class<?> cls = obj.getClass(); cls != null && cls.equals(Object.class); cls = cls.getSuperclass()) {
            for (Field field : cls.getDeclaredFields()) {
                if (field.getDeclaringClass().equals(Event.class)) {
                    try {
                        field.setAccessible(true);
                        Event event = (Event) field.get(obj);
                        if (event != null) {
                            event.clear(obj2);
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
            if (!z) {
                return;
            }
        }
    }
}
