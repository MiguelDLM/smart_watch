package com.alimm.tanx.ui.image.glide.load.engine;

import com.alimm.tanx.ui.image.glide.load.Encoder;
import com.alimm.tanx.ui.image.glide.load.Key;
import com.alimm.tanx.ui.image.glide.load.ResourceDecoder;
import com.alimm.tanx.ui.image.glide.load.ResourceEncoder;
import com.alimm.tanx.ui.image.glide.load.Transformation;
import com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import oOxxXI.oIX0oI;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class EngineKey implements Key {
    private static final String EMPTY_LOG_STRING = "";
    private final ResourceDecoder cacheDecoder;
    private final ResourceDecoder decoder;
    private final ResourceEncoder encoder;
    private int hashCode;
    private final int height;
    private final String id;
    private Key originalKey;
    private final Key signature;
    private final Encoder sourceEncoder;
    private String stringKey;
    private final ResourceTranscoder transcoder;
    private final Transformation transformation;
    private final int width;

    public EngineKey(String str, Key key, int i, int i2, ResourceDecoder resourceDecoder, ResourceDecoder resourceDecoder2, Transformation transformation, ResourceEncoder resourceEncoder, ResourceTranscoder resourceTranscoder, Encoder encoder) {
        this.id = str;
        this.signature = key;
        this.width = i;
        this.height = i2;
        this.cacheDecoder = resourceDecoder;
        this.decoder = resourceDecoder2;
        this.transformation = transformation;
        this.encoder = resourceEncoder;
        this.transcoder = resourceTranscoder;
        this.sourceEncoder = encoder;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Key
    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean z12;
        if (this == obj) {
            return true;
        }
        if (obj == null || EngineKey.class != obj.getClass()) {
            return false;
        }
        EngineKey engineKey = (EngineKey) obj;
        if (!this.id.equals(engineKey.id) || !this.signature.equals(engineKey.signature) || this.height != engineKey.height || this.width != engineKey.width) {
            return false;
        }
        Transformation transformation = this.transformation;
        if (transformation == null) {
            z = true;
        } else {
            z = false;
        }
        if (engineKey.transformation == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z ^ z2) {
            return false;
        }
        if (transformation != null && !transformation.getId().equals(engineKey.transformation.getId())) {
            return false;
        }
        ResourceDecoder resourceDecoder = this.decoder;
        if (resourceDecoder == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (engineKey.decoder == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 ^ z4) {
            return false;
        }
        if (resourceDecoder != null && !resourceDecoder.getId().equals(engineKey.decoder.getId())) {
            return false;
        }
        ResourceDecoder resourceDecoder2 = this.cacheDecoder;
        if (resourceDecoder2 == null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (engineKey.cacheDecoder == null) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z5 ^ z6) {
            return false;
        }
        if (resourceDecoder2 != null && !resourceDecoder2.getId().equals(engineKey.cacheDecoder.getId())) {
            return false;
        }
        ResourceEncoder resourceEncoder = this.encoder;
        if (resourceEncoder == null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (engineKey.encoder == null) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z7 ^ z8) {
            return false;
        }
        if (resourceEncoder != null && !resourceEncoder.getId().equals(engineKey.encoder.getId())) {
            return false;
        }
        ResourceTranscoder resourceTranscoder = this.transcoder;
        if (resourceTranscoder == null) {
            z9 = true;
        } else {
            z9 = false;
        }
        if (engineKey.transcoder == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z9 ^ z10) {
            return false;
        }
        if (resourceTranscoder != null && !resourceTranscoder.getId().equals(engineKey.transcoder.getId())) {
            return false;
        }
        Encoder encoder = this.sourceEncoder;
        if (encoder == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (engineKey.sourceEncoder == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z11 ^ z12) {
            return false;
        }
        if (encoder == null || encoder.getId().equals(engineKey.sourceEncoder.getId())) {
            return true;
        }
        return false;
    }

    public Key getOriginalKey() {
        if (this.originalKey == null) {
            this.originalKey = new OriginalKey(this.id, this.signature);
        }
        return this.originalKey;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Key
    public int hashCode() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        if (this.hashCode == 0) {
            int hashCode = this.id.hashCode();
            this.hashCode = hashCode;
            int hashCode2 = ((((this.signature.hashCode() + (hashCode * 31)) * 31) + this.width) * 31) + this.height;
            this.hashCode = hashCode2;
            int i6 = hashCode2 * 31;
            ResourceDecoder resourceDecoder = this.cacheDecoder;
            int i7 = 0;
            if (resourceDecoder != null) {
                i = resourceDecoder.getId().hashCode();
            } else {
                i = 0;
            }
            int i8 = i6 + i;
            this.hashCode = i8;
            int i9 = i8 * 31;
            ResourceDecoder resourceDecoder2 = this.decoder;
            if (resourceDecoder2 != null) {
                i2 = resourceDecoder2.getId().hashCode();
            } else {
                i2 = 0;
            }
            int i10 = i9 + i2;
            this.hashCode = i10;
            int i11 = i10 * 31;
            Transformation transformation = this.transformation;
            if (transformation != null) {
                i3 = transformation.getId().hashCode();
            } else {
                i3 = 0;
            }
            int i12 = i11 + i3;
            this.hashCode = i12;
            int i13 = i12 * 31;
            ResourceEncoder resourceEncoder = this.encoder;
            if (resourceEncoder != null) {
                i4 = resourceEncoder.getId().hashCode();
            } else {
                i4 = 0;
            }
            int i14 = i13 + i4;
            this.hashCode = i14;
            int i15 = i14 * 31;
            ResourceTranscoder resourceTranscoder = this.transcoder;
            if (resourceTranscoder != null) {
                i5 = resourceTranscoder.getId().hashCode();
            } else {
                i5 = 0;
            }
            int i16 = i15 + i5;
            this.hashCode = i16;
            int i17 = i16 * 31;
            Encoder encoder = this.sourceEncoder;
            if (encoder != null) {
                i7 = encoder.getId().hashCode();
            }
            this.hashCode = i17 + i7;
        }
        return this.hashCode;
    }

    public String toString() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        if (this.stringKey == null) {
            StringBuilder oIX0oI2 = oIX0oI.oIX0oI("EngineKey{");
            oIX0oI2.append(this.id);
            oIX0oI2.append('+');
            oIX0oI2.append(this.signature);
            oIX0oI2.append("+[");
            oIX0oI2.append(this.width);
            oIX0oI2.append('x');
            oIX0oI2.append(this.height);
            oIX0oI2.append("]+");
            oIX0oI2.append('\'');
            ResourceDecoder resourceDecoder = this.cacheDecoder;
            if (resourceDecoder != null) {
                str = resourceDecoder.getId();
            } else {
                str = EMPTY_LOG_STRING;
            }
            oIX0oI2.append(str);
            oIX0oI2.append('\'');
            oIX0oI2.append('+');
            oIX0oI2.append('\'');
            ResourceDecoder resourceDecoder2 = this.decoder;
            if (resourceDecoder2 != null) {
                str2 = resourceDecoder2.getId();
            } else {
                str2 = EMPTY_LOG_STRING;
            }
            oIX0oI2.append(str2);
            oIX0oI2.append('\'');
            oIX0oI2.append('+');
            oIX0oI2.append('\'');
            Transformation transformation = this.transformation;
            if (transformation != null) {
                str3 = transformation.getId();
            } else {
                str3 = EMPTY_LOG_STRING;
            }
            oIX0oI2.append(str3);
            oIX0oI2.append('\'');
            oIX0oI2.append('+');
            oIX0oI2.append('\'');
            ResourceEncoder resourceEncoder = this.encoder;
            if (resourceEncoder != null) {
                str4 = resourceEncoder.getId();
            } else {
                str4 = EMPTY_LOG_STRING;
            }
            oIX0oI2.append(str4);
            oIX0oI2.append('\'');
            oIX0oI2.append('+');
            oIX0oI2.append('\'');
            ResourceTranscoder resourceTranscoder = this.transcoder;
            if (resourceTranscoder != null) {
                str5 = resourceTranscoder.getId();
            } else {
                str5 = EMPTY_LOG_STRING;
            }
            oIX0oI2.append(str5);
            oIX0oI2.append('\'');
            oIX0oI2.append('+');
            oIX0oI2.append('\'');
            Encoder encoder = this.sourceEncoder;
            if (encoder != null) {
                str6 = encoder.getId();
            } else {
                str6 = EMPTY_LOG_STRING;
            }
            oIX0oI2.append(str6);
            oIX0oI2.append('\'');
            oIX0oI2.append('}');
            this.stringKey = oIX0oI2.toString();
        }
        return this.stringKey;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) throws UnsupportedEncodingException {
        String str;
        String str2;
        String str3;
        String str4;
        byte[] array = ByteBuffer.allocate(8).putInt(this.width).putInt(this.height).array();
        this.signature.updateDiskCacheKey(messageDigest);
        messageDigest.update(this.id.getBytes("UTF-8"));
        messageDigest.update(array);
        ResourceDecoder resourceDecoder = this.cacheDecoder;
        String str5 = "";
        if (resourceDecoder == null) {
            str = "";
        } else {
            str = resourceDecoder.getId();
        }
        messageDigest.update(str.getBytes("UTF-8"));
        ResourceDecoder resourceDecoder2 = this.decoder;
        if (resourceDecoder2 == null) {
            str2 = "";
        } else {
            str2 = resourceDecoder2.getId();
        }
        messageDigest.update(str2.getBytes("UTF-8"));
        Transformation transformation = this.transformation;
        if (transformation == null) {
            str3 = "";
        } else {
            str3 = transformation.getId();
        }
        messageDigest.update(str3.getBytes("UTF-8"));
        ResourceEncoder resourceEncoder = this.encoder;
        if (resourceEncoder == null) {
            str4 = "";
        } else {
            str4 = resourceEncoder.getId();
        }
        messageDigest.update(str4.getBytes("UTF-8"));
        Encoder encoder = this.sourceEncoder;
        if (encoder != null) {
            str5 = encoder.getId();
        }
        messageDigest.update(str5.getBytes("UTF-8"));
    }
}
