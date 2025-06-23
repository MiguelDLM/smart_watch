package com.goodix.ble.libcomx.pool;

import java.util.ArrayList;

/* loaded from: classes9.dex */
public class Pool {
    private Class<? extends IRecyclable> itemClass;
    private int maxInstanceCount = 0;
    private ArrayList<IRecyclable> pool;

    public Pool(Class<? extends IRecyclable> cls, int i) {
        this.itemClass = cls;
        this.pool = new ArrayList<>(i);
    }

    public synchronized <T> T get() {
        IRecyclable iRecyclable;
        if (this.pool.isEmpty()) {
            IRecyclable iRecyclable2 = null;
            try {
                iRecyclable = (T) this.itemClass.newInstance();
            } catch (IllegalAccessException | InstantiationException unused) {
            }
            try {
                iRecyclable.reuse(this);
                this.maxInstanceCount++;
            } catch (IllegalAccessException | InstantiationException unused2) {
                iRecyclable2 = iRecyclable;
                iRecyclable = (T) iRecyclable2;
                return (T) iRecyclable;
            }
        } else {
            int size = this.pool.size() - 1;
            while (size > 0 && this.pool.get(size).getRefCnt() >= 1) {
                size--;
            }
            iRecyclable = (T) this.pool.remove(size);
            iRecyclable.reuse(this);
        }
        return (T) iRecyclable;
    }

    public synchronized void recycle(IRecyclable iRecyclable) {
        this.pool.add(iRecyclable);
    }
}
