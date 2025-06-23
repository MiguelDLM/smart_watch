package com.goodix.ble.libcomx.event;

import com.goodix.ble.libcomx.pool.IRecyclable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/* loaded from: classes9.dex */
public class Event<T> implements IEventListener<T> {
    private int defaultEvtType;
    private Object defaultSrc;
    private Executor executor;
    private boolean isOneshot;
    private boolean isShotted;
    private Event parent;
    private Object tag;
    private int dispatcherPoolMaxItem = 16;
    private CopyOnWriteArrayList<IEventListener> callbackList = new CopyOnWriteArrayList<>();
    private ArrayList<Event<T>.Dispatcher> dispatcherPool = new ArrayList<>(this.dispatcherPoolMaxItem);

    /* loaded from: classes9.dex */
    public class Dispatcher extends CopyOnWriteArrayList<IEventListener> implements Runnable {
        Object dat;
        Object src;
        int type;

        public Dispatcher(Object obj, int i, Object obj2, Collection<? extends IEventListener> collection) {
            super(collection);
            this.src = obj;
            this.type = i;
            this.dat = obj2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Iterator<IEventListener> it = iterator();
            while (it.hasNext()) {
                IEventListener next = it.next();
                try {
                    next.onEvent(this.src, this.type, this.dat);
                } catch (Exception e) {
                    throw new RuntimeException("Error in event listener: " + next.getClass().getName() + ": " + e.getMessage(), e);
                }
            }
            Object obj = this.dat;
            if (obj instanceof IRecyclable) {
                ((IRecyclable) obj).release();
            }
            Event.this.freeDispatcher(this);
            if (Event.this.isOneshot) {
                clear();
            }
        }
    }

    public Event() {
    }

    private synchronized Event<T>.Dispatcher allocDispatcher(Object obj, int i, Object obj2, Collection<? extends IEventListener> collection) {
        Event<T>.Dispatcher remove;
        try {
            if (this.dispatcherPool.isEmpty()) {
                remove = new Dispatcher(obj, i, obj2, collection);
            } else {
                remove = this.dispatcherPool.remove(r0.size() - 1);
                remove.src = obj;
                remove.type = i;
                remove.dat = obj2;
                remove.addAll(collection);
            }
            if (obj2 instanceof IRecyclable) {
                ((IRecyclable) obj2).retain();
            }
        } catch (Throwable th) {
            throw th;
        }
        return remove;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void freeDispatcher(Event<T>.Dispatcher dispatcher) {
        dispatcher.clear();
        if (this.dispatcherPool.size() < this.dispatcherPoolMaxItem) {
            this.dispatcherPool.add(dispatcher);
        }
    }

    public Event<T> clear() {
        return clear(null);
    }

    @Override // com.goodix.ble.libcomx.event.IEventListener
    @Deprecated
    public void onEvent(Object obj, int i, Object obj2) {
        if (this.isOneshot) {
            if (this.isShotted) {
                return;
            }
            synchronized (this) {
                try {
                    if (this.isShotted) {
                        return;
                    } else {
                        this.isShotted = true;
                    }
                } finally {
                }
            }
        }
        Executor executor = this.executor;
        if (executor == null) {
            boolean z = obj2 instanceof IRecyclable;
            if (z) {
                ((IRecyclable) obj2).retain();
            }
            Iterator<IEventListener> it = this.callbackList.iterator();
            while (it.hasNext()) {
                IEventListener next = it.next();
                try {
                    next.onEvent(obj, i, obj2);
                } catch (Exception e) {
                    throw new RuntimeException("Error in dispatch event to " + next.getClass().getName() + ": " + e.getMessage(), e);
                }
            }
            if (this.isOneshot) {
                clear();
            }
            if (z) {
                ((IRecyclable) obj2).release();
                return;
            }
            return;
        }
        executor.execute(allocDispatcher(obj, i, obj2, this.callbackList));
    }

    public void postEvent(T t) {
        Object obj = this.defaultSrc;
        if (obj != null) {
            onEvent(obj, this.defaultEvtType, t);
            return;
        }
        throw new IllegalStateException("Please specify event src.");
    }

    public synchronized Event<T> register(IEventListener iEventListener) {
        this.callbackList.addIfAbsent(iEventListener);
        return this;
    }

    public synchronized Event<T> register2(IEventListener<T> iEventListener) {
        this.callbackList.addIfAbsent(iEventListener);
        return this;
    }

    public synchronized Event<T> remove(IEventListener iEventListener) {
        boolean z;
        if (this.callbackList.size() > 0) {
            z = true;
        } else {
            z = false;
        }
        this.callbackList.remove(iEventListener);
        if (z && this.parent != null && this.callbackList.size() == 0) {
            this.parent.remove(this);
            this.parent = null;
        }
        return this;
    }

    public Event<T> setDisposer(EventDisposer eventDisposer) {
        if (eventDisposer != null) {
            eventDisposer.add(this);
        }
        return this;
    }

    public Event<T> setExecutor(Executor executor) {
        this.executor = executor;
        return this;
    }

    public Event<T> subEvent() {
        return subEvent(null, false);
    }

    public synchronized Event<T> clear(Object obj) {
        if (obj != null) {
            try {
                Iterator<IEventListener> it = this.callbackList.iterator();
                while (it.hasNext()) {
                    IEventListener next = it.next();
                    if (next instanceof Event) {
                        ((Event) next).clear(obj);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (obj == null || this.tag == obj) {
            this.callbackList.clear();
            Event event = this.parent;
            if (event != null) {
                event.remove(this);
                this.parent = null;
            }
            this.tag = null;
        }
        return this;
    }

    public Event<T> subEvent(Object obj) {
        return subEvent(obj, false);
    }

    public synchronized Event<T> subEvent(Object obj, boolean z) {
        Event<T> event;
        event = new Event<>();
        event.tag = obj;
        event.parent = this;
        event.isOneshot = z;
        event.isShotted = false;
        this.callbackList.addIfAbsent(event);
        return event;
    }

    public void postEvent(Object obj, int i, T t) {
        onEvent(obj, i, t);
    }

    public Event(Object obj, int i) {
        this.defaultSrc = obj;
        this.defaultEvtType = i;
    }
}
