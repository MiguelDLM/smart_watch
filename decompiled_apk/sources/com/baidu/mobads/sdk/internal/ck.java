package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.mobads.sdk.internal.v;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;

/* loaded from: classes7.dex */
public class ck implements Observer {

    /* renamed from: a, reason: collision with root package name */
    private static final String f6274a = "APKParser";
    private static final String g = "__xadsdk_downloaded__version__";
    private static final String h = "version";
    private Context b;
    private URL c;
    private String d;
    private final bz e;
    private a f;
    private SharedPreferences i;
    private SharedPreferences.OnSharedPreferenceChangeListener j;

    /* loaded from: classes7.dex */
    public interface a {
        void a(bz bzVar);

        void b(bz bzVar);
    }

    public ck(Context context, URL url, bz bzVar, a aVar) {
        this.c = null;
        this.d = null;
        this.j = new cl(this);
        this.c = url;
        this.e = bzVar;
        a(context, aVar);
    }

    private void a(Context context, a aVar) {
        this.b = context;
        this.f = aVar;
        SharedPreferences sharedPreferences = context.getSharedPreferences(g, 0);
        this.i = sharedPreferences;
        sharedPreferences.registerOnSharedPreferenceChangeListener(this.j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        v vVar = (v) observable;
        if (vVar.l() == v.a.COMPLETED) {
            this.f.a(new bz(this.e, vVar.g(), Boolean.TRUE));
        }
        if (vVar.l() == v.a.ERROR) {
            this.f.b(new bz(this.e, vVar.g(), Boolean.FALSE));
        }
    }

    public void a(String str, String str2) {
        am amVar = new am(this.b, this.d != null ? new URL(this.d) : this.c, str, str2, false);
        amVar.addObserver(this);
        amVar.a();
        SharedPreferences.Editor edit = this.i.edit();
        edit.putString("version", this.e.toString());
        edit.apply();
    }

    public ck(Context context, String str, bz bzVar, a aVar) {
        this.c = null;
        this.d = null;
        this.j = new cl(this);
        this.d = str;
        this.e = bzVar;
        a(context, aVar);
    }
}
