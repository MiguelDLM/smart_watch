package com.alimm.tanx.ui.image.glide.signature;

import com.alimm.tanx.ui.image.glide.load.Key;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public class MediaStoreSignature implements Key {
    private final long dateModified;
    private final String mimeType;
    private final int orientation;

    public MediaStoreSignature(String str, long j, int i) {
        this.mimeType = str;
        this.dateModified = j;
        this.orientation = i;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Key
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || MediaStoreSignature.class != obj.getClass()) {
            return false;
        }
        MediaStoreSignature mediaStoreSignature = (MediaStoreSignature) obj;
        if (this.dateModified != mediaStoreSignature.dateModified || this.orientation != mediaStoreSignature.orientation) {
            return false;
        }
        String str = this.mimeType;
        String str2 = mediaStoreSignature.mimeType;
        if (str == null ? str2 == null : str.equals(str2)) {
            return true;
        }
        return false;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Key
    public int hashCode() {
        int i;
        String str = this.mimeType;
        if (str != null) {
            i = str.hashCode();
        } else {
            i = 0;
        }
        long j = this.dateModified;
        return (((i * 31) + ((int) (j ^ (j >>> 32)))) * 31) + this.orientation;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) throws UnsupportedEncodingException {
        messageDigest.update(ByteBuffer.allocate(12).putLong(this.dateModified).putInt(this.orientation).array());
        messageDigest.update(this.mimeType.getBytes("UTF-8"));
    }
}
