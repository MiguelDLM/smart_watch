package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes9.dex */
final class Count implements Serializable {
    private int value;

    public Count(int i) {
        this.value = i;
    }

    public void add(int i) {
        this.value += i;
    }

    public int addAndGet(int i) {
        int i2 = this.value + i;
        this.value = i2;
        return i2;
    }

    public boolean equals(@CheckForNull Object obj) {
        if ((obj instanceof Count) && ((Count) obj).value == this.value) {
            return true;
        }
        return false;
    }

    public int get() {
        return this.value;
    }

    public int getAndSet(int i) {
        int i2 = this.value;
        this.value = i;
        return i2;
    }

    public int hashCode() {
        return this.value;
    }

    public void set(int i) {
        this.value = i;
    }

    public String toString() {
        return Integer.toString(this.value);
    }
}
