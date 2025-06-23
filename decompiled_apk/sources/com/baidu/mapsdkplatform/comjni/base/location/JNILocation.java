package com.baidu.mapsdkplatform.comjni.base.location;

import android.os.Bundle;

/* loaded from: classes7.dex */
public class JNILocation {
    public native boolean CoordinateEncryptEx(int i, float f, float f2, Bundle bundle, String str);

    public native int Create();

    public native int QueryInterface(int i);

    public native int Release(int i);
}
