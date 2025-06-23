package com.baidu.navisdk.comapi.base;

import android.os.Handler;
import android.os.Looper;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes7.dex */
public abstract class d extends Handler {
    private Set<Integer> mInterests;

    public d(Looper looper) {
        super(looper);
        this.mInterests = new HashSet();
        careAbout();
    }

    public abstract void careAbout();

    public Set<Integer> getInterests() {
        return this.mInterests;
    }

    public synchronized boolean ignore(int i) {
        Set<Integer> set = this.mInterests;
        if (set == null) {
            return false;
        }
        return set.remove(Integer.valueOf(i));
    }

    public synchronized boolean isObserved(int i) {
        Set<Integer> set = this.mInterests;
        if (set != null) {
            if (set.contains(Integer.valueOf(i))) {
                return true;
            }
        }
        return false;
    }

    public synchronized void observe(int i) {
        Set<Integer> set = this.mInterests;
        if (set != null) {
            set.add(Integer.valueOf(i));
        }
    }

    public synchronized void ignore(Collection<Integer> collection) {
        Set<Integer> set = this.mInterests;
        if (set != null && !set.isEmpty() && collection != null) {
            this.mInterests.removeAll(collection);
        }
    }

    public synchronized void observe(Collection<Integer> collection) {
        Set<Integer> set = this.mInterests;
        if (set != null && collection != null) {
            set.addAll(collection);
        }
    }

    public d() {
        this.mInterests = new HashSet();
        careAbout();
    }

    public synchronized void ignore(Integer[] numArr) {
        Set<Integer> set = this.mInterests;
        if (set != null && !set.isEmpty() && numArr != null) {
            this.mInterests.removeAll(Arrays.asList(numArr));
        }
    }

    public synchronized void observe(int[] iArr) {
        if (this.mInterests != null && iArr != null) {
            for (int i : iArr) {
                this.mInterests.add(Integer.valueOf(i));
            }
        }
    }
}
