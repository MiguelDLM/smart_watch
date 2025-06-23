package com.alimm.tanx.ui.image.glide.load.engine;

import com.alimm.tanx.ui.image.glide.load.Key;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

/* loaded from: classes.dex */
class OriginalKey implements Key {
    private final String id;
    private final Key signature;

    public OriginalKey(String str, Key key) {
        this.id = str;
        this.signature = key;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Key
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || OriginalKey.class != obj.getClass()) {
            return false;
        }
        OriginalKey originalKey = (OriginalKey) obj;
        if (this.id.equals(originalKey.id) && this.signature.equals(originalKey.signature)) {
            return true;
        }
        return false;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Key
    public int hashCode() {
        return this.signature.hashCode() + (this.id.hashCode() * 31);
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) throws UnsupportedEncodingException {
        messageDigest.update(this.id.getBytes("UTF-8"));
        this.signature.updateDiskCacheKey(messageDigest);
    }
}
