package com.jd.ad.sdk.jad_oz;

import androidx.annotation.NonNull;
import com.jd.ad.sdk.jad_it.jad_dq;
import com.jd.ad.sdk.jad_oz.jad_na;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;

/* loaded from: classes10.dex */
public class jad_bo<Data> implements jad_na<byte[], Data> {
    public final InterfaceC0708jad_bo<Data> jad_an;

    /* loaded from: classes10.dex */
    public static class jad_an implements jad_ob<byte[], ByteBuffer> {

        /* renamed from: com.jd.ad.sdk.jad_oz.jad_bo$jad_an$jad_an, reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public class C0707jad_an implements InterfaceC0708jad_bo<ByteBuffer> {
            public C0707jad_an(jad_an jad_anVar) {
            }

            @Override // com.jd.ad.sdk.jad_oz.jad_bo.InterfaceC0708jad_bo
            public Class<ByteBuffer> jad_an() {
                return ByteBuffer.class;
            }

            @Override // com.jd.ad.sdk.jad_oz.jad_bo.InterfaceC0708jad_bo
            public ByteBuffer jad_an(byte[] bArr) {
                return ByteBuffer.wrap(bArr);
            }
        }

        @Override // com.jd.ad.sdk.jad_oz.jad_ob
        @NonNull
        public jad_na<byte[], ByteBuffer> jad_an(@NonNull jad_re jad_reVar) {
            return new jad_bo(new C0707jad_an(this));
        }
    }

    /* renamed from: com.jd.ad.sdk.jad_oz.jad_bo$jad_bo, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0708jad_bo<Data> {
        Class<Data> jad_an();

        Data jad_an(byte[] bArr);
    }

    /* loaded from: classes10.dex */
    public static class jad_cp<Data> implements com.jd.ad.sdk.jad_it.jad_dq<Data> {
        public final byte[] jad_an;
        public final InterfaceC0708jad_bo<Data> jad_bo;

        public jad_cp(byte[] bArr, InterfaceC0708jad_bo<Data> interfaceC0708jad_bo) {
            this.jad_an = bArr;
            this.jad_bo = interfaceC0708jad_bo;
        }

        @Override // com.jd.ad.sdk.jad_it.jad_dq
        @NonNull
        public Class<Data> jad_an() {
            return this.jad_bo.jad_an();
        }

        @Override // com.jd.ad.sdk.jad_it.jad_dq
        public void jad_bo() {
        }

        @Override // com.jd.ad.sdk.jad_it.jad_dq
        public void jad_cp() {
        }

        @Override // com.jd.ad.sdk.jad_it.jad_dq
        @NonNull
        public com.jd.ad.sdk.jad_hs.jad_an jad_dq() {
            return com.jd.ad.sdk.jad_hs.jad_an.LOCAL;
        }

        @Override // com.jd.ad.sdk.jad_it.jad_dq
        public void jad_an(@NonNull com.jd.ad.sdk.jad_ep.jad_jt jad_jtVar, @NonNull jad_dq.jad_an<? super Data> jad_anVar) {
            jad_anVar.jad_an((jad_dq.jad_an<? super Data>) this.jad_bo.jad_an(this.jad_an));
        }
    }

    /* loaded from: classes10.dex */
    public static class jad_dq implements jad_ob<byte[], InputStream> {

        /* loaded from: classes10.dex */
        public class jad_an implements InterfaceC0708jad_bo<InputStream> {
            public jad_an(jad_dq jad_dqVar) {
            }

            @Override // com.jd.ad.sdk.jad_oz.jad_bo.InterfaceC0708jad_bo
            public Class<InputStream> jad_an() {
                return InputStream.class;
            }

            @Override // com.jd.ad.sdk.jad_oz.jad_bo.InterfaceC0708jad_bo
            public InputStream jad_an(byte[] bArr) {
                return new ByteArrayInputStream(bArr);
            }
        }

        @Override // com.jd.ad.sdk.jad_oz.jad_ob
        @NonNull
        public jad_na<byte[], InputStream> jad_an(@NonNull jad_re jad_reVar) {
            return new jad_bo(new jad_an(this));
        }
    }

    public jad_bo(InterfaceC0708jad_bo<Data> interfaceC0708jad_bo) {
        this.jad_an = interfaceC0708jad_bo;
    }

    @Override // com.jd.ad.sdk.jad_oz.jad_na
    public /* bridge */ /* synthetic */ boolean jad_an(@NonNull byte[] bArr) {
        return true;
    }

    @Override // com.jd.ad.sdk.jad_oz.jad_na
    public jad_na.jad_an jad_an(@NonNull byte[] bArr, int i, int i2, @NonNull com.jd.ad.sdk.jad_hs.jad_jw jad_jwVar) {
        byte[] bArr2 = bArr;
        return new jad_na.jad_an(new com.jd.ad.sdk.jad_fo.jad_bo(bArr2), Collections.emptyList(), new jad_cp(bArr2, this.jad_an));
    }
}
