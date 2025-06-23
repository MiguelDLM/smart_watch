package com.bytedance.pangle.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.os.Bundle;

@SuppressLint({"NewApi"})
/* loaded from: classes8.dex */
public final class c implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a, reason: collision with root package name */
    Fragment f10554a;

    public c(Fragment fragment) {
        this.f10554a = fragment;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0053, code lost:
    
        r0 = (java.lang.Object[]) java.lang.reflect.Array.newInstance(java.lang.Class.forName("android.app.FragmentState"), r10.length - 1);
        r2 = new int[r10.length - 1];
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0069, code lost:
    
        if (r3 >= r10.length) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006b, code lost:
    
        r6 = r10[r3];
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006d, code lost:
    
        if (r6 == r5) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006f, code lost:
    
        r0[r4] = r6;
        r2[r4] = r3;
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0075, code lost:
    
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0078, code lost:
    
        com.bytedance.pangle.util.FieldUtils.writeField(r9, "mActive", r0);
        com.bytedance.pangle.util.FieldUtils.writeField(r9, "mAdded", r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0080, code lost:
    
        return;
     */
    @Override // android.app.Application.ActivityLifecycleCallbacks
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onActivityPostSaveInstanceState(@androidx.annotation.NonNull android.app.Activity r9, @androidx.annotation.NonNull android.os.Bundle r10) {
        /*
            r8 = this;
            java.lang.String r0 = "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag_pangle"
            java.lang.String r1 = "mActive"
            android.app.Fragment r2 = r8.f10554a
            android.app.Activity r2 = r2.getActivity()
            if (r2 == r9) goto Ld
            return
        Ld:
            java.lang.String r9 = "android:fragments"
            android.os.Parcelable r9 = r10.getParcelable(r9)     // Catch: java.lang.Throwable -> L4b
            if (r9 != 0) goto L16
            return
        L16:
            java.lang.Object r10 = com.bytedance.pangle.util.FieldUtils.readField(r9, r1)     // Catch: java.lang.Throwable -> L4b
            java.lang.Object[] r10 = (java.lang.Object[]) r10     // Catch: java.lang.Throwable -> L4b
            if (r10 != 0) goto L1f
            return
        L1f:
            int r2 = r10.length     // Catch: java.lang.Throwable -> L4b
            r3 = 0
            r4 = 0
        L22:
            if (r4 >= r2) goto L50
            r5 = r10[r4]     // Catch: java.lang.Throwable -> L4b
            java.lang.String r6 = "mTag"
            java.lang.Object r6 = com.bytedance.pangle.util.FieldUtils.readField(r5, r6)     // Catch: java.lang.Throwable -> L4b
            java.lang.String r7 = "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag_plugin"
            boolean r7 = r7.equals(r6)     // Catch: java.lang.Throwable -> L4b
            if (r7 == 0) goto L35
            goto L51
        L35:
            boolean r7 = r6 instanceof java.lang.String     // Catch: java.lang.Throwable -> L4b
            if (r7 == 0) goto L4d
            r7 = r6
            java.lang.String r7 = (java.lang.String) r7     // Catch: java.lang.Throwable -> L4b
            boolean r7 = r7.contains(r0)     // Catch: java.lang.Throwable -> L4b
            if (r7 != 0) goto L51
            java.lang.String r6 = (java.lang.String) r6     // Catch: java.lang.Throwable -> L4b
            boolean r6 = r6.contains(r0)     // Catch: java.lang.Throwable -> L4b
            if (r6 == 0) goto L4d
            goto L51
        L4b:
            r9 = move-exception
            goto L81
        L4d:
            int r4 = r4 + 1
            goto L22
        L50:
            r5 = 0
        L51:
            if (r5 == 0) goto L80
            java.lang.String r0 = "android.app.FragmentState"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch: java.lang.Throwable -> L4b
            int r2 = r10.length     // Catch: java.lang.Throwable -> L4b
            int r2 = r2 + (-1)
            java.lang.Object r0 = java.lang.reflect.Array.newInstance(r0, r2)     // Catch: java.lang.Throwable -> L4b
            java.lang.Object[] r0 = (java.lang.Object[]) r0     // Catch: java.lang.Throwable -> L4b
            int r2 = r10.length     // Catch: java.lang.Throwable -> L4b
            int r2 = r2 + (-1)
            int[] r2 = new int[r2]     // Catch: java.lang.Throwable -> L4b
            r4 = 0
        L68:
            int r6 = r10.length     // Catch: java.lang.Throwable -> L4b
            if (r3 >= r6) goto L78
            r6 = r10[r3]     // Catch: java.lang.Throwable -> L4b
            if (r6 == r5) goto L75
            r0[r4] = r6     // Catch: java.lang.Throwable -> L4b
            r2[r4] = r3     // Catch: java.lang.Throwable -> L4b
            int r4 = r4 + 1
        L75:
            int r3 = r3 + 1
            goto L68
        L78:
            com.bytedance.pangle.util.FieldUtils.writeField(r9, r1, r0)     // Catch: java.lang.Throwable -> L4b
            java.lang.String r10 = "mAdded"
            com.bytedance.pangle.util.FieldUtils.writeField(r9, r10, r2)     // Catch: java.lang.Throwable -> L4b
        L80:
            return
        L81:
            r9.printStackTrace()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.fragment.c.onActivityPostSaveInstanceState(android.app.Activity, android.os.Bundle):void");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0053, code lost:
    
        r0 = (java.lang.Object[]) java.lang.reflect.Array.newInstance(java.lang.Class.forName("android.app.FragmentState"), r10.length - 1);
        r2 = new int[r10.length - 1];
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0069, code lost:
    
        if (r3 >= r10.length) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006b, code lost:
    
        r6 = r10[r3];
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006d, code lost:
    
        if (r6 == r5) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006f, code lost:
    
        r0[r4] = r6;
        r2[r4] = r3;
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0075, code lost:
    
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0078, code lost:
    
        com.bytedance.pangle.util.FieldUtils.writeField(r9, "mActive", r0);
        com.bytedance.pangle.util.FieldUtils.writeField(r9, "mAdded", r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0080, code lost:
    
        return;
     */
    @Override // android.app.Application.ActivityLifecycleCallbacks
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onActivitySaveInstanceState(android.app.Activity r9, android.os.Bundle r10) {
        /*
            r8 = this;
            java.lang.String r0 = "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag_pangle"
            java.lang.String r1 = "mActive"
            android.app.Fragment r2 = r8.f10554a
            android.app.Activity r2 = r2.getActivity()
            if (r2 == r9) goto Ld
            return
        Ld:
            java.lang.String r9 = "android:fragments"
            android.os.Parcelable r9 = r10.getParcelable(r9)     // Catch: java.lang.Throwable -> L4b
            if (r9 != 0) goto L16
            return
        L16:
            java.lang.Object r10 = com.bytedance.pangle.util.FieldUtils.readField(r9, r1)     // Catch: java.lang.Throwable -> L4b
            java.lang.Object[] r10 = (java.lang.Object[]) r10     // Catch: java.lang.Throwable -> L4b
            if (r10 != 0) goto L1f
            return
        L1f:
            int r2 = r10.length     // Catch: java.lang.Throwable -> L4b
            r3 = 0
            r4 = 0
        L22:
            if (r4 >= r2) goto L50
            r5 = r10[r4]     // Catch: java.lang.Throwable -> L4b
            java.lang.String r6 = "mTag"
            java.lang.Object r6 = com.bytedance.pangle.util.FieldUtils.readField(r5, r6)     // Catch: java.lang.Throwable -> L4b
            java.lang.String r7 = "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag_plugin"
            boolean r7 = r7.equals(r6)     // Catch: java.lang.Throwable -> L4b
            if (r7 == 0) goto L35
            goto L51
        L35:
            boolean r7 = r6 instanceof java.lang.String     // Catch: java.lang.Throwable -> L4b
            if (r7 == 0) goto L4d
            r7 = r6
            java.lang.String r7 = (java.lang.String) r7     // Catch: java.lang.Throwable -> L4b
            boolean r7 = r7.contains(r0)     // Catch: java.lang.Throwable -> L4b
            if (r7 != 0) goto L51
            java.lang.String r6 = (java.lang.String) r6     // Catch: java.lang.Throwable -> L4b
            boolean r6 = r6.contains(r0)     // Catch: java.lang.Throwable -> L4b
            if (r6 == 0) goto L4d
            goto L51
        L4b:
            r9 = move-exception
            goto L81
        L4d:
            int r4 = r4 + 1
            goto L22
        L50:
            r5 = 0
        L51:
            if (r5 == 0) goto L80
            java.lang.String r0 = "android.app.FragmentState"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch: java.lang.Throwable -> L4b
            int r2 = r10.length     // Catch: java.lang.Throwable -> L4b
            int r2 = r2 + (-1)
            java.lang.Object r0 = java.lang.reflect.Array.newInstance(r0, r2)     // Catch: java.lang.Throwable -> L4b
            java.lang.Object[] r0 = (java.lang.Object[]) r0     // Catch: java.lang.Throwable -> L4b
            int r2 = r10.length     // Catch: java.lang.Throwable -> L4b
            int r2 = r2 + (-1)
            int[] r2 = new int[r2]     // Catch: java.lang.Throwable -> L4b
            r4 = 0
        L68:
            int r6 = r10.length     // Catch: java.lang.Throwable -> L4b
            if (r3 >= r6) goto L78
            r6 = r10[r3]     // Catch: java.lang.Throwable -> L4b
            if (r6 == r5) goto L75
            r0[r4] = r6     // Catch: java.lang.Throwable -> L4b
            r2[r4] = r3     // Catch: java.lang.Throwable -> L4b
            int r4 = r4 + 1
        L75:
            int r3 = r3 + 1
            goto L68
        L78:
            com.bytedance.pangle.util.FieldUtils.writeField(r9, r1, r0)     // Catch: java.lang.Throwable -> L4b
            java.lang.String r10 = "mAdded"
            com.bytedance.pangle.util.FieldUtils.writeField(r9, r10, r2)     // Catch: java.lang.Throwable -> L4b
        L80:
            return
        L81:
            r9.printStackTrace()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.fragment.c.onActivitySaveInstanceState(android.app.Activity, android.os.Bundle):void");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }
}
