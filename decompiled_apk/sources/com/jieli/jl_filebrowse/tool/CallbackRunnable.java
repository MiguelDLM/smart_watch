package com.jieli.jl_filebrowse.tool;

import java.util.ArrayList;
import java.util.Iterator;

@Deprecated
/* loaded from: classes10.dex */
public class CallbackRunnable<T> implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList<T> f17833a;
    public final CallbackImpl<T> b;

    public CallbackRunnable(ArrayList<T> arrayList, CallbackImpl<T> callbackImpl) {
        this.f17833a = arrayList;
        this.b = callbackImpl;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public void run() {
        ArrayList<T> arrayList = this.f17833a;
        if (arrayList != null && this.b != null && !arrayList.isEmpty()) {
            Iterator it = new ArrayList(this.f17833a).iterator();
            while (it.hasNext()) {
                this.b.onCallback(it.next());
            }
        }
    }
}
