package com.baidu.navisdk.jni.nativeif;

import android.os.Bundle;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class JNIUgcRoadControl {
    public static JNIUgcRoadControl sInstance = new JNIUgcRoadControl();

    private JNIUgcRoadControl() {
    }

    public native boolean add(int i);

    public native boolean addLinkItemInGuide(int i);

    public native boolean addLinkItemInGuideEnd(int i, int i2);

    public native boolean batchRemove(ArrayList<String> arrayList, int i);

    public native boolean getAllItems(ArrayList<Bundle> arrayList, int i);

    public native String getCurSelectLinkName();

    public native int getCurSelectYawPointIdx();

    public native boolean getCurYawPoint(ArrayList<Bundle> arrayList, int i);

    public native boolean login(String str);

    public native boolean modify(String str, int i);

    public native boolean remove(String str);

    public native boolean selectLink(int i, int i2);

    public native boolean setCurSelectYawPointIdx(int i);

    public native boolean submitAddUGCInGuideEnd();

    public native boolean syncData();
}
