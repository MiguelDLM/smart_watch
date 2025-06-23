package com.microsoft.cognitiveservices.speech.diagnostics.logging;

/* loaded from: classes11.dex */
public final /* synthetic */ class oIX0oI {
    public static /* synthetic */ String oIX0oI(CharSequence charSequence, CharSequence[] charSequenceArr) {
        if (charSequence != null) {
            StringBuilder sb = new StringBuilder();
            if (charSequenceArr.length > 0) {
                sb.append(charSequenceArr[0]);
                for (int i = 1; i < charSequenceArr.length; i++) {
                    sb.append(charSequence);
                    sb.append(charSequenceArr[i]);
                }
            }
            return sb.toString();
        }
        throw new NullPointerException("delimiter");
    }
}
