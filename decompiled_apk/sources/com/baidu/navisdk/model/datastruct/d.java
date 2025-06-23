package com.baidu.navisdk.model.datastruct;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class d<T> {

    /* renamed from: a, reason: collision with root package name */
    protected final List<T> f6914a = new ArrayList();

    public void a(T t) {
        this.f6914a.add(t);
    }

    public List<T> a() {
        return this.f6914a;
    }

    @Nullable
    public T a(int i) {
        if (i < 0 || i >= this.f6914a.size()) {
            return null;
        }
        return this.f6914a.get(i);
    }
}
