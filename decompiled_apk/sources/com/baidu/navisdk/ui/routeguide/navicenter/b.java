package com.baidu.navisdk.ui.routeguide.navicenter;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import java.util.Stack;

/* loaded from: classes8.dex */
public class b {
    private static b c;

    /* renamed from: a, reason: collision with root package name */
    private Activity f9063a = null;
    private final a<Fragment> b = new a<>();

    /* loaded from: classes8.dex */
    public static class a<T> extends Stack<T> {
        @Override // java.util.Stack
        public T push(T t) {
            if (!contains(t)) {
                return (T) super.push(t);
            }
            int size = size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                if (t.equals(get(size))) {
                    remove(size);
                    break;
                }
                size--;
            }
            int size2 = size();
            if (size >= 1 && size < size2 && get(size - 1).equals(get(size))) {
                remove(size);
            }
            return (T) super.push(t);
        }
    }

    private b() {
    }

    public static b b() {
        if (c == null) {
            synchronized (b.class) {
                try {
                    if (c == null) {
                        c = new b();
                    }
                } finally {
                }
            }
        }
        return c;
    }

    public boolean a(String str) {
        if (this.b.empty()) {
            return false;
        }
        return this.b.peek().getClass().getName().equals(str);
    }

    public void a(Fragment fragment) {
        this.f9063a = com.baidu.navisdk.ui.routeguide.b.V().b();
        this.b.push(fragment);
        com.baidu.navisdk.ui.routeguide.b.V().L();
    }

    public void a() {
        if (this.b.isEmpty()) {
            return;
        }
        Fragment peek = this.b.peek();
        this.b.pop();
        if (peek != null) {
            b(peek);
        }
        com.baidu.navisdk.ui.routeguide.b.V().a((Bundle) null);
    }

    private void b(Fragment fragment) {
        FragmentTransaction beginTransaction = this.f9063a.getFragmentManager().beginTransaction();
        if (beginTransaction != null) {
            beginTransaction.remove(fragment);
            try {
                beginTransaction.commitAllowingStateLoss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
