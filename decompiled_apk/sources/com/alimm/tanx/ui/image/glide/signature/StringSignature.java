package com.alimm.tanx.ui.image.glide.signature;

import com.alimm.tanx.ui.image.glide.load.Key;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import oOxxXI.oIX0oI;

/* loaded from: classes.dex */
public class StringSignature implements Key {
    private final String signature;

    public StringSignature(String str) {
        if (str != null) {
            this.signature = str;
            return;
        }
        throw new NullPointerException("Signature cannot be null!");
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Key
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && StringSignature.class == obj.getClass()) {
            return this.signature.equals(((StringSignature) obj).signature);
        }
        return false;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Key
    public int hashCode() {
        return this.signature.hashCode();
    }

    public String toString() {
        StringBuilder oIX0oI2 = oIX0oI.oIX0oI("StringSignature{signature='");
        oIX0oI2.append(this.signature);
        oIX0oI2.append('\'');
        oIX0oI2.append('}');
        return oIX0oI2.toString();
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) throws UnsupportedEncodingException {
        messageDigest.update(this.signature.getBytes("UTF-8"));
    }
}
