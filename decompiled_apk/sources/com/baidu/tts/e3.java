package com.baidu.tts;

import android.content.Context;
import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.tools.GetCUID;
import java.lang.ref.WeakReference;
import java.util.Hashtable;

/* loaded from: classes8.dex */
public class e3 implements i3 {
    public static volatile e3 d;

    /* renamed from: a, reason: collision with root package name */
    public Hashtable<WeakReference<Context>, d3> f10080a = new Hashtable<>();
    public WeakReference<Context> b;
    public Hashtable<String, Object> c;

    public e3() {
        Hashtable<String, Object> hashtable = new Hashtable<>();
        this.c = hashtable;
        hashtable.put(q2.CTP.b(), "10");
    }

    public static e3 e() {
        if (d == null) {
            synchronized (e3.class) {
                try {
                    if (d == null) {
                        d = new e3();
                    }
                } finally {
                }
            }
        }
        return d;
    }

    public d3 b() {
        WeakReference<Context> weakReference = this.b;
        if (weakReference == null) {
            return null;
        }
        d3 d3Var = this.f10080a.get(weakReference);
        if (d3Var == null) {
            d3Var = new d3(weakReference);
            this.f10080a.put(weakReference, d3Var);
        }
        return d3Var;
    }

    public Context c() {
        return this.b.get();
    }

    @Override // com.baidu.tts.i3
    public TtsError create() {
        return null;
    }

    public String d() {
        Context context;
        try {
            d3 b = b();
            if (b == null) {
                return null;
            }
            if (b.b == null) {
                WeakReference<Context> weakReference = b.f10071a;
                if (weakReference == null) {
                    context = null;
                } else {
                    context = weakReference.get();
                }
                b.b = GetCUID.getCUID(context);
            }
            return b.b;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.baidu.tts.i3
    public void destroy() {
        Hashtable<WeakReference<Context>, d3> hashtable = this.f10080a;
        if (hashtable != null) {
            hashtable.clear();
        }
        this.b = null;
    }

    @Override // com.baidu.tts.i3
    public void pause() {
    }

    @Override // com.baidu.tts.i3
    public void resume() {
    }

    public void setContext(Context context) {
        this.b = new WeakReference<>(context);
    }

    @Override // com.baidu.tts.i3
    public void start() {
    }

    @Override // com.baidu.tts.i3
    public void stop() {
    }
}
