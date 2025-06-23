package org.apache.commons.lang3.mutable;

import XxIOX.oIX0oI;
import java.io.Serializable;

/* loaded from: classes6.dex */
public class MutableObject<T> implements oIX0oI<T>, Serializable {
    private static final long serialVersionUID = 86241875189L;
    private T value;

    public MutableObject() {
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        return this.value.equals(((MutableObject) obj).value);
    }

    @Override // XxIOX.oIX0oI
    public T getValue() {
        return this.value;
    }

    public int hashCode() {
        T t = this.value;
        if (t == null) {
            return 0;
        }
        return t.hashCode();
    }

    @Override // XxIOX.oIX0oI
    public void setValue(T t) {
        this.value = t;
    }

    public String toString() {
        T t = this.value;
        if (t == null) {
            return "null";
        }
        return t.toString();
    }

    public MutableObject(T t) {
        this.value = t;
    }
}
