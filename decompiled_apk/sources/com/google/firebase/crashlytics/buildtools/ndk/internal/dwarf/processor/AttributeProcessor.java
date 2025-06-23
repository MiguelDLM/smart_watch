package com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf.processor;

import com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf.DWAttribute;
import com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf.DWForm;

/* loaded from: classes10.dex */
public interface AttributeProcessor<T> {
    T finishProcessingAttributes();

    void processAttribute(DWAttribute dWAttribute, long j);

    void processAttribute(DWAttribute dWAttribute, DWForm dWForm, byte[] bArr);

    void processAttribute(DWAttribute dWAttribute, String str);
}
