package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;

/* loaded from: classes9.dex */
public final /* synthetic */ class XO {
    public static void II0xO0(TrackOutput trackOutput, ParsableByteArray parsableByteArray, int i) {
        trackOutput.sampleData(parsableByteArray, i, 0);
    }

    public static int oIX0oI(TrackOutput trackOutput, DataReader dataReader, int i, boolean z) throws IOException {
        return trackOutput.sampleData(dataReader, i, z, 0);
    }
}
