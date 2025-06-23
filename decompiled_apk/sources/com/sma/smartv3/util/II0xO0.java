package com.sma.smartv3.util;

import Xx000oIo.oxoX;
import android.content.Context;
import android.net.Uri;
import android.provider.MediaStore;
import android.widget.ImageView;
import com.blankj.utilcode.util.LogUtils;
import com.sma.smartv3.pop.xx0X0;

/* loaded from: classes12.dex */
public final class II0xO0 {

    /* renamed from: com.sma.smartv3.util.II0xO0$II0xO0, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public static final class C1030II0xO0 implements oxoX.II0xO0 {

        /* renamed from: I0Io, reason: collision with root package name */
        public final /* synthetic */ xx0X0 f24238I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        @OXOo.OOXIXo
        public final Uri f24239II0xO0;

        /* renamed from: X0o0xo, reason: collision with root package name */
        public final /* synthetic */ ImageView f24240X0o0xo;

        /* renamed from: oIX0oI, reason: collision with root package name */
        @OXOo.OOXIXo
        public final Uri f24241oIX0oI;

        /* renamed from: oxoX, reason: collision with root package name */
        public final /* synthetic */ Context f24242oxoX;

        public C1030II0xO0(xx0X0 xx0x0, Context context, ImageView imageView) {
            this.f24238I0Io = xx0x0;
            this.f24242oxoX = context;
            this.f24240X0o0xo = imageView;
            X00IoxXI.oIX0oI oix0oi = X00IoxXI.oIX0oI.f3233oIX0oI;
            this.f24241oIX0oI = oix0oi.oxoX(com.sma.smartv3.initializer.IXxxXO.xoIox(oix0oi));
            Uri fromFile = Uri.fromFile(com.sma.smartv3.initializer.IXxxXO.II0XooXoX(oix0oi));
            kotlin.jvm.internal.IIX0o.oO(fromFile, "fromFile(...)");
            this.f24239II0xO0 = fromFile;
        }

        @Override // Xx000oIo.oxoX.II0xO0
        public void II0xO0(@OXOo.OOXIXo Uri uri) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(uri, "uri");
            xx0X0 xx0x0 = this.f24238I0Io;
            if (xx0x0 != null) {
                xx0x0.dismiss();
            }
            LogUtils.d("onCropped dismiss ");
            try {
                this.f24240X0o0xo.setImageBitmap(MediaStore.Images.Media.getBitmap(this.f24242oxoX.getContentResolver(), uri));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // Xx000oIo.oxoX.II0xO0
        @OXOo.OOXIXo
        public Uri getResult() {
            return this.f24239II0xO0;
        }

        @Override // Xx000oIo.oxoX.II0xO0
        @OXOo.OOXIXo
        public Uri oIX0oI() {
            return this.f24241oIX0oI;
        }
    }

    /* loaded from: classes12.dex */
    public static final class oIX0oI implements oxoX.II0xO0 {

        /* renamed from: I0Io, reason: collision with root package name */
        public final /* synthetic */ xx0X0 f24243I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        @OXOo.OOXIXo
        public final Uri f24244II0xO0;

        /* renamed from: X0o0xo, reason: collision with root package name */
        public final /* synthetic */ ImageView f24245X0o0xo;

        /* renamed from: oIX0oI, reason: collision with root package name */
        @OXOo.OOXIXo
        public final Uri f24246oIX0oI;

        /* renamed from: oxoX, reason: collision with root package name */
        public final /* synthetic */ Context f24247oxoX;

        public oIX0oI(xx0X0 xx0x0, Context context, ImageView imageView) {
            this.f24243I0Io = xx0x0;
            this.f24247oxoX = context;
            this.f24245X0o0xo = imageView;
            X00IoxXI.oIX0oI oix0oi = X00IoxXI.oIX0oI.f3233oIX0oI;
            this.f24246oIX0oI = oix0oi.oxoX(com.sma.smartv3.initializer.IXxxXO.oO(oix0oi));
            Uri fromFile = Uri.fromFile(com.sma.smartv3.initializer.IXxxXO.x0XOIxOo(oix0oi));
            kotlin.jvm.internal.IIX0o.oO(fromFile, "fromFile(...)");
            this.f24244II0xO0 = fromFile;
        }

        @Override // Xx000oIo.oxoX.II0xO0
        public void II0xO0(@OXOo.OOXIXo Uri uri) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(uri, "uri");
            xx0X0 xx0x0 = this.f24243I0Io;
            if (xx0x0 != null) {
                xx0x0.dismiss();
            }
            LogUtils.d("onCropped dismiss ");
            try {
                this.f24245X0o0xo.setImageBitmap(MediaStore.Images.Media.getBitmap(this.f24247oxoX.getContentResolver(), uri));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // Xx000oIo.oxoX.II0xO0
        @OXOo.OOXIXo
        public Uri getResult() {
            return this.f24244II0xO0;
        }

        @Override // Xx000oIo.oxoX.II0xO0
        @OXOo.OOXIXo
        public Uri oIX0oI() {
            return this.f24246oIX0oI;
        }
    }

    @OXOo.OOXIXo
    public static final Xx000oIo.oxoX II0xO0(@OXOo.OOXIXo Context mContext, @OXOo.oOoXoXO xx0X0 xx0x0, @OXOo.OOXIXo ImageView ivAvatar) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(mContext, "mContext");
        kotlin.jvm.internal.IIX0o.x0xO0oo(ivAvatar, "ivAvatar");
        return new Xx000oIo.oxoX(mContext, new C1030II0xO0(xx0x0, mContext, ivAvatar));
    }

    @OXOo.OOXIXo
    public static final Xx000oIo.oxoX oIX0oI(@OXOo.OOXIXo Context mContext, @OXOo.oOoXoXO xx0X0 xx0x0, @OXOo.OOXIXo ImageView ivAvatar) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(mContext, "mContext");
        kotlin.jvm.internal.IIX0o.x0xO0oo(ivAvatar, "ivAvatar");
        return new Xx000oIo.oxoX(mContext, new oIX0oI(xx0x0, mContext, ivAvatar));
    }
}
