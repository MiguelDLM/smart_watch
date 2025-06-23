package com.alimm.tanx.ui.image.glide.util;

import oOxxXI.oIX0oI;

/* loaded from: classes.dex */
public class MultiClassKey {
    private Class<?> first;
    private Class<?> second;

    public MultiClassKey() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || MultiClassKey.class != obj.getClass()) {
            return false;
        }
        MultiClassKey multiClassKey = (MultiClassKey) obj;
        if (this.first.equals(multiClassKey.first) && this.second.equals(multiClassKey.second)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.second.hashCode() + (this.first.hashCode() * 31);
    }

    public void set(Class<?> cls, Class<?> cls2) {
        this.first = cls;
        this.second = cls2;
    }

    public String toString() {
        StringBuilder oIX0oI2 = oIX0oI.oIX0oI("MultiClassKey{first=");
        oIX0oI2.append(this.first);
        oIX0oI2.append(", second=");
        oIX0oI2.append(this.second);
        oIX0oI2.append('}');
        return oIX0oI2.toString();
    }

    public MultiClassKey(Class<?> cls, Class<?> cls2) {
        set(cls, cls2);
    }
}
