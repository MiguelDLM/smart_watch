package com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf;

import com.google.firebase.crashlytics.buildtools.utils.io.ByteReader;
import java.io.IOException;

/* loaded from: classes10.dex */
public interface DebugLineOpcode {
    boolean process(DebugLineContext debugLineContext, ByteReader byteReader) throws IOException;
}
