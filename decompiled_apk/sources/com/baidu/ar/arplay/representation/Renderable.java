package com.baidu.ar.arplay.representation;

import java.io.Serializable;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes7.dex */
public class Renderable implements Serializable {
    private static final long serialVersionUID = 6701586807666461858L;
    protected boolean dirty = true;
    protected ReentrantLock lock = new ReentrantLock();

    public boolean dirty() {
        return this.dirty;
    }

    public ReentrantLock getLock() {
        return this.lock;
    }

    public void setClean() {
        this.dirty = false;
    }

    public void setDirty() {
        this.dirty = true;
    }
}
