package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.net;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.Charsets;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.DecoderException;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.EncoderException;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.StringDecoder;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.StringEncoder;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.binary.Base64;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* loaded from: classes10.dex */
public class BCodec extends RFC1522Codec implements StringEncoder, StringDecoder {
    private final Charset charset;

    public BCodec() {
        this(Charsets.UTF_8);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.StringDecoder
    public String decode(String str) throws DecoderException {
        if (str == null) {
            return null;
        }
        try {
            return decodeText(str);
        } catch (UnsupportedEncodingException e) {
            throw new DecoderException(e.getMessage(), e);
        }
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.net.RFC1522Codec
    public byte[] doDecoding(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return Base64.decodeBase64(bArr);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.net.RFC1522Codec
    public byte[] doEncoding(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return Base64.encodeBase64(bArr);
    }

    public String encode(String str, Charset charset) throws EncoderException {
        if (str == null) {
            return null;
        }
        return encodeText(str, charset);
    }

    public Charset getCharset() {
        return this.charset;
    }

    public String getDefaultCharset() {
        return this.charset.name();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.net.RFC1522Codec
    public String getEncoding() {
        return "B";
    }

    public BCodec(Charset charset) {
        this.charset = charset;
    }

    public String encode(String str, String str2) throws EncoderException {
        if (str == null) {
            return null;
        }
        try {
            return encodeText(str, str2);
        } catch (UnsupportedEncodingException e) {
            throw new EncoderException(e.getMessage(), e);
        }
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.Decoder
    public Object decode(Object obj) throws DecoderException {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            return decode((String) obj);
        }
        throw new DecoderException("Objects of type " + obj.getClass().getName() + " cannot be decoded using BCodec");
    }

    public BCodec(String str) {
        this(Charset.forName(str));
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.StringEncoder
    public String encode(String str) throws EncoderException {
        if (str == null) {
            return null;
        }
        return encode(str, getCharset());
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.Encoder
    public Object encode(Object obj) throws EncoderException {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            return encode((String) obj);
        }
        throw new EncoderException("Objects of type " + obj.getClass().getName() + " cannot be encoded using BCodec");
    }
}
