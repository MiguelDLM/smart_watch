package com.goodix.ble.libcomx.util;

import com.goodix.ble.libcomx.event.Event;
import com.goodix.ble.libcomx.event.IEventListener;
import java.util.ArrayList;

/* loaded from: classes9.dex */
public class AccessLock {
    public static final int EVT_LOCKED = 970;
    public static final int EVT_LOCK_ACQUIRED = 355;
    private Object owner;
    private Event<Object> eventLocked = new Event<>(this, EVT_LOCKED);
    private ArrayList<Object> unlockQueue = new ArrayList<>();

    /* loaded from: classes9.dex */
    public interface CB {
        void onLockAcquired(AccessLock accessLock);
    }

    private boolean innerAcquireLock(Object obj) {
        boolean z = false;
        if (obj != null) {
            synchronized (this) {
                try {
                    if (this.owner != null) {
                        this.unlockQueue.add(obj);
                    } else {
                        this.owner = obj;
                        z = true;
                    }
                } finally {
                }
            }
        }
        if (z) {
            if (obj instanceof CB) {
                ((CB) obj).onLockAcquired(this);
            } else if (obj instanceof IEventListener) {
                ((IEventListener) obj).onEvent(this, EVT_LOCK_ACQUIRED, null);
            }
            this.eventLocked.postEvent(obj);
        }
        return z;
    }

    public boolean acquireLock(CB cb) {
        return innerAcquireLock(cb);
    }

    public Event<Object> evtLocked() {
        return this.eventLocked;
    }

    public <T> T getOwner() {
        return (T) this.owner;
    }

    public ArrayList<Object> getPendingList(ArrayList<Object> arrayList) {
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        synchronized (this) {
            arrayList.addAll(this.unlockQueue);
        }
        return arrayList;
    }

    public synchronized boolean isLocked() {
        boolean z;
        if (this.owner != null) {
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    public synchronized void releaseLock(Object obj) {
        Object obj2;
        boolean z = false;
        if (obj != null) {
            try {
                synchronized (this) {
                    if (this.owner == obj) {
                        this.owner = null;
                        if (!this.unlockQueue.isEmpty()) {
                            obj2 = this.unlockQueue.remove(0);
                            this.owner = obj2;
                        } else {
                            z = true;
                        }
                    } else {
                        this.unlockQueue.remove(obj);
                    }
                    obj2 = null;
                }
            } catch (Throwable th) {
                throw th;
            } finally {
            }
        } else {
            obj2 = null;
        }
        if (obj2 != null) {
            if (obj2 instanceof CB) {
                ((CB) obj2).onLockAcquired(this);
            } else if (obj2 instanceof IEventListener) {
                ((IEventListener) obj2).onEvent(this, EVT_LOCK_ACQUIRED, null);
            }
            this.eventLocked.postEvent(obj2);
        }
        if (z) {
            this.eventLocked.postEvent(null);
        }
    }

    public boolean acquireLock(IEventListener<Void> iEventListener) {
        return innerAcquireLock(iEventListener);
    }
}
