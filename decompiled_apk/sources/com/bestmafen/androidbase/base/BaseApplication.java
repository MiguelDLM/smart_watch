package com.bestmafen.androidbase.base;

import OXOo.OOXIXo;
import android.app.Application;
import androidx.annotation.CallSuper;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public class BaseApplication extends Application {

    /* renamed from: XO, reason: collision with root package name */
    @OOXIXo
    public final Set<II0xO0> f10327XO = new LinkedHashSet();

    /* renamed from: Oo, reason: collision with root package name */
    @OOXIXo
    public static final oIX0oI f10326Oo = new oIX0oI(null);

    /* renamed from: IXxxXO, reason: collision with root package name */
    @OOXIXo
    public static final LinkedBlockingQueue<List<Object>> f10325IXxxXO = new LinkedBlockingQueue<>();

    /* loaded from: classes8.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(IIXOooo iIXOooo) {
            this();
        }

        @OOXIXo
        public final LinkedBlockingQueue<List<Object>> oIX0oI() {
            return BaseApplication.f10325IXxxXO;
        }

        public oIX0oI() {
        }
    }

    public void II0xO0(@OOXIXo Set<II0xO0> initInitializers) {
        IIX0o.x0xO0oo(initInitializers, "initInitializers");
    }

    @Override // android.app.Application
    @CallSuper
    public void onCreate() {
        super.onCreate();
        II0xO0(this.f10327XO);
        Iterator<II0xO0> it = this.f10327XO.iterator();
        while (it.hasNext()) {
            it.next().oIX0oI(this);
        }
    }
}
