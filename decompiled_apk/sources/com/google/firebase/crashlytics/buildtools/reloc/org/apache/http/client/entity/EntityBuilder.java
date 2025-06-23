package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.entity;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpEntity;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.NameValuePair;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.entity.AbstractHttpEntity;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.entity.BasicHttpEntity;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.entity.ByteArrayEntity;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.entity.ContentType;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.entity.FileEntity;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.entity.InputStreamEntity;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.entity.SerializableEntity;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.entity.StringEntity;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes10.dex */
public class EntityBuilder {
    private byte[] binary;
    private boolean chunked;
    private String contentEncoding;
    private ContentType contentType;
    private File file;
    private boolean gzipCompress;
    private List<NameValuePair> parameters;
    private Serializable serializable;
    private InputStream stream;
    private String text;

    private void clearContent() {
        this.text = null;
        this.binary = null;
        this.stream = null;
        this.parameters = null;
        this.serializable = null;
        this.file = null;
    }

    public static EntityBuilder create() {
        return new EntityBuilder();
    }

    private ContentType getContentOrDefault(ContentType contentType) {
        ContentType contentType2 = this.contentType;
        if (contentType2 != null) {
            return contentType2;
        }
        return contentType;
    }

    public HttpEntity build() {
        AbstractHttpEntity basicHttpEntity;
        Charset charset;
        ContentType contentType;
        String str = this.text;
        if (str != null) {
            basicHttpEntity = new StringEntity(str, getContentOrDefault(ContentType.DEFAULT_TEXT));
        } else {
            byte[] bArr = this.binary;
            if (bArr != null) {
                basicHttpEntity = new ByteArrayEntity(bArr, getContentOrDefault(ContentType.DEFAULT_BINARY));
            } else {
                InputStream inputStream = this.stream;
                if (inputStream != null) {
                    basicHttpEntity = new InputStreamEntity(inputStream, -1L, getContentOrDefault(ContentType.DEFAULT_BINARY));
                } else {
                    List<NameValuePair> list = this.parameters;
                    if (list != null) {
                        ContentType contentType2 = this.contentType;
                        if (contentType2 != null) {
                            charset = contentType2.getCharset();
                        } else {
                            charset = null;
                        }
                        basicHttpEntity = new UrlEncodedFormEntity(list, charset);
                    } else {
                        Serializable serializable = this.serializable;
                        if (serializable != null) {
                            basicHttpEntity = new SerializableEntity(serializable);
                            basicHttpEntity.setContentType(ContentType.DEFAULT_BINARY.toString());
                        } else {
                            File file = this.file;
                            if (file != null) {
                                basicHttpEntity = new FileEntity(file, getContentOrDefault(ContentType.DEFAULT_BINARY));
                            } else {
                                basicHttpEntity = new BasicHttpEntity();
                            }
                        }
                    }
                }
            }
        }
        if (basicHttpEntity.getContentType() != null && (contentType = this.contentType) != null) {
            basicHttpEntity.setContentType(contentType.toString());
        }
        basicHttpEntity.setContentEncoding(this.contentEncoding);
        basicHttpEntity.setChunked(this.chunked);
        if (this.gzipCompress) {
            return new GzipCompressingEntity(basicHttpEntity);
        }
        return basicHttpEntity;
    }

    public EntityBuilder chunked() {
        this.chunked = true;
        return this;
    }

    public byte[] getBinary() {
        return this.binary;
    }

    public String getContentEncoding() {
        return this.contentEncoding;
    }

    public ContentType getContentType() {
        return this.contentType;
    }

    public File getFile() {
        return this.file;
    }

    public List<NameValuePair> getParameters() {
        return this.parameters;
    }

    public Serializable getSerializable() {
        return this.serializable;
    }

    public InputStream getStream() {
        return this.stream;
    }

    public String getText() {
        return this.text;
    }

    public EntityBuilder gzipCompress() {
        this.gzipCompress = true;
        return this;
    }

    public boolean isChunked() {
        return this.chunked;
    }

    public boolean isGzipCompress() {
        return this.gzipCompress;
    }

    public EntityBuilder setBinary(byte[] bArr) {
        clearContent();
        this.binary = bArr;
        return this;
    }

    public EntityBuilder setContentEncoding(String str) {
        this.contentEncoding = str;
        return this;
    }

    public EntityBuilder setContentType(ContentType contentType) {
        this.contentType = contentType;
        return this;
    }

    public EntityBuilder setFile(File file) {
        clearContent();
        this.file = file;
        return this;
    }

    public EntityBuilder setParameters(List<NameValuePair> list) {
        clearContent();
        this.parameters = list;
        return this;
    }

    public EntityBuilder setSerializable(Serializable serializable) {
        clearContent();
        this.serializable = serializable;
        return this;
    }

    public EntityBuilder setStream(InputStream inputStream) {
        clearContent();
        this.stream = inputStream;
        return this;
    }

    public EntityBuilder setText(String str) {
        clearContent();
        this.text = str;
        return this;
    }

    public EntityBuilder setParameters(NameValuePair... nameValuePairArr) {
        return setParameters(Arrays.asList(nameValuePairArr));
    }
}
