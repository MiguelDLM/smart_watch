package com.baidu.tts;

import java.io.Serializable;

/* loaded from: classes8.dex */
public abstract class a5<T> implements Cloneable, Serializable {
    public T a() {
        try {
            return (T) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
