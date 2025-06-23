package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.language;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.EncoderException;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.StringEncoder;

/* loaded from: classes10.dex */
public abstract class AbstractCaverphone implements StringEncoder {
    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.Encoder
    public Object encode(Object obj) throws EncoderException {
        if (obj instanceof String) {
            return encode((String) obj);
        }
        throw new EncoderException("Parameter supplied to Caverphone encode is not of type java.lang.String");
    }

    public boolean isEncodeEqual(String str, String str2) throws EncoderException {
        return encode(str).equals(encode(str2));
    }
}
