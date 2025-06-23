package com.jieli.jl_bt_ota.tool;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes10.dex */
public class CallbackRunnable<T> implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList<T> f17737a;
    private final ICallbackHandler<T> b;

    public CallbackRunnable(ArrayList<T> arrayList, ICallbackHandler<T> iCallbackHandler) {
        this.f17737a = arrayList;
        this.b = iCallbackHandler;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public void run() {
        ArrayList<T> arrayList = this.f17737a;
        if (arrayList != null && !arrayList.isEmpty() && this.b != null) {
            Iterator it = new ArrayList(this.f17737a).iterator();
            while (it.hasNext()) {
                this.b.onHandle(it.next());
            }
        }
    }
}
