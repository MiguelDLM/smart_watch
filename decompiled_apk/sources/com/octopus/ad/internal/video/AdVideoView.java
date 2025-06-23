package com.octopus.ad.internal.video;

import O0IxXx.II0XooXoX;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.res.AssetFileDescriptor;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import com.octopus.ad.R;
import com.octopus.ad.internal.Oxx0IOOO;
import com.octopus.ad.internal.l;
import com.octopus.ad.internal.video.a;
import com.octopus.ad.internal.view.AdViewImpl;
import com.octopus.ad.internal.view.AdWebView;
import com.octopus.ad.internal.view.InterstitialAdViewImpl;
import com.octopus.ad.internal.view.xxIXOIIO;
import com.octopus.ad.internal.xoIox;
import java.io.FileDescriptor;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import oOoIIO0.xoXoI;
import org.json.JSONException;
import org.json.JSONObject;
import x0.I0oOoX;
import x0.ooXIXxIX;
import x0.x0o;

/* loaded from: classes11.dex */
public class AdVideoView extends TextureView implements MediaPlayer.OnVideoSizeChangedListener, TextureView.SurfaceTextureListener, com.octopus.ad.internal.view.I0Io {

    /* renamed from: IIX0o, reason: collision with root package name */
    public IXO.oIX0oI f18710IIX0o;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public String f18711IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public boolean f18712IXxxXO;

    /* renamed from: IoOoX, reason: collision with root package name */
    public a.b f18713IoOoX;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public int f18714O0xOxO;

    /* renamed from: Oo, reason: collision with root package name */
    public boolean f18715Oo;

    /* renamed from: OxI, reason: collision with root package name */
    public int f18716OxI;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public boolean f18717Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public boolean f18718OxxIIOOXO;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public int f18719X0IIOO;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public int f18720XI0IXoo;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public boolean f18721XIxXXX0x0;

    /* renamed from: XO, reason: collision with root package name */
    public AdWebView f18722XO;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public boolean f18723XxX0x0xxx;

    /* renamed from: o00, reason: collision with root package name */
    public int f18724o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public boolean f18725oI0IIXIo;

    /* renamed from: oOXoIIIo, reason: collision with root package name */
    public int f18726oOXoIIIo;

    /* renamed from: oo, reason: collision with root package name */
    public MediaPlayer f18727oo;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public Pair<String, Integer> f18728oo0xXOI0I;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public String f18729ooXIXxIX;

    /* renamed from: xI, reason: collision with root package name */
    public a f18730xI;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public xxIXOIIO f18731xXxxox0I;

    /* renamed from: xoXoI, reason: collision with root package name */
    public int f18732xoXoI;

    /* renamed from: xxX, reason: collision with root package name */
    public boolean f18733xxX;

    /* loaded from: classes11.dex */
    public class I0Io implements MediaPlayer.OnErrorListener {
        public I0Io() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            AdVideoView.this.OxI(oOoIIO0.I0Io.f32018oOoXoXO);
            return false;
        }
    }

    /* loaded from: classes11.dex */
    public class II0xO0 implements MediaPlayer.OnInfoListener {

        /* loaded from: classes11.dex */
        public class oIX0oI implements xoXoI {
            public oIX0oI() {
            }

            @Override // oOoIIO0.xoXoI
            public void a(boolean z) {
                AdViewImpl adViewImpl;
                AdWebView adWebView = AdVideoView.this.f18722XO;
                if (adWebView != null && (adViewImpl = adWebView.f18916Oo) != null && adViewImpl.getAdDispatcher() != null) {
                    AdVideoView.this.f18722XO.f18916Oo.getAdDispatcher().a(z);
                }
            }
        }

        public II0xO0() {
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            AdViewImpl adViewImpl;
            AdViewImpl adViewImpl2;
            if (i == 3) {
                AdWebView adWebView = AdVideoView.this.f18722XO;
                if (adWebView != null && (adViewImpl2 = adWebView.f18916Oo) != null && adViewImpl2.getAdDispatcher() != null) {
                    if (!AdVideoView.this.f18712IXxxXO) {
                        AdVideoView.this.f18712IXxxXO = true;
                        if (AdVideoView.this.f18722XO.f18916Oo.OOXIxO0() && AdVideoView.this.f18710IIX0o == null) {
                            AdVideoView adVideoView = AdVideoView.this;
                            adVideoView.f18722XO.f18916Oo.oo0xXOI0I(adVideoView.f18720XI0IXoo, AdVideoView.this.f18722XO.getShowSkipBtnTime(), AdVideoView.this.f18722XO.getAutoCloseTime());
                        }
                        AdVideoView adVideoView2 = AdVideoView.this;
                        adVideoView2.f18722XO.f18911IXxxXO.XX0(adVideoView2, new oIX0oI());
                    }
                    AdVideoView.this.f18722XO.f18916Oo.oX();
                    AdVideoView.this.f18722XO.f18916Oo.getAdDispatcher().e();
                }
                if (AdVideoView.this.f18710IIX0o != null) {
                    AdVideoView.this.f18710IIX0o.oOoXoXO();
                    return false;
                }
                return false;
            }
            if (AdVideoView.this.f18710IIX0o != null) {
                AdVideoView.this.f18710IIX0o.xxIXOIIO();
            }
            AdVideoView adVideoView3 = AdVideoView.this;
            AdWebView adWebView2 = adVideoView3.f18722XO;
            if (adWebView2 != null && (adViewImpl = adWebView2.f18916Oo) != null) {
                adViewImpl.x0(adVideoView3);
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes11.dex */
    public class X0o0xo implements ooXIXxIX.II0xO0 {
        public X0o0xo() {
        }

        @Override // x0.ooXIXxIX.II0xO0
        public void oIX0oI(boolean z, String str) {
            AdVideoView adVideoView;
            AdWebView adWebView;
            if (z && !TextUtils.isEmpty(str)) {
                try {
                    if (new JSONObject(str).optBoolean("isValid") && (adWebView = (adVideoView = AdVideoView.this).f18722XO) != null && adWebView.f18916Oo != null && adVideoView.f18728oo0xXOI0I != null) {
                        AdVideoView adVideoView2 = AdVideoView.this;
                        adVideoView2.f18722XO.f18916Oo.oxIIX0o((String) adVideoView2.f18728oo0xXOI0I.first, ((Integer) AdVideoView.this.f18728oo0xXOI0I.second).intValue());
                    }
                } catch (Exception e) {
                    AdVideoView.this.f18725oI0IIXIo = false;
                    e.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public class XO implements xxIXOIIO.oIX0oI {
        public XO() {
        }

        @Override // com.octopus.ad.internal.view.xxIXOIIO.oIX0oI
        public void a(View view) {
            if (AdVideoView.this.f18723XxX0x0xxx) {
                AdVideoView.this.f18726oOXoIIIo = 12;
            }
            AdVideoView.this.x0xO0oo();
        }
    }

    /* loaded from: classes11.dex */
    public enum a {
        NRF_NONE,
        NRF_START,
        NRF_PAUSE
    }

    /* loaded from: classes11.dex */
    public class oIX0oI implements MediaPlayer.OnCompletionListener {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ AdWebView f18741XO;

        public oIX0oI(AdWebView adWebView) {
            this.f18741XO = adWebView;
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            AdVideoView.this.f18717Oxx0xo = true;
            AdVideoView.this.f18722XO.f18911IXxxXO.oxXx0IX();
            if (AdVideoView.this.f18712IXxxXO) {
                AdVideoView.this.O0xOxO();
                AdVideoView.this.o00();
            }
            if (!AdVideoView.this.f18722XO.I0X0x0oIo(1)) {
                Log.d("octopus", "We can't go next, just stand here");
                return;
            }
            AdViewImpl adViewImpl = this.f18741XO.f18916Oo;
            if (adViewImpl instanceof InterstitialAdViewImpl) {
                if (((InterstitialAdViewImpl) adViewImpl).getAdImplementation() != null) {
                    ((oI.II0xO0) ((InterstitialAdViewImpl) this.f18741XO.f18916Oo).getAdImplementation()).II0xO0();
                } else {
                    Log.d("octopus", "Error in incentive video ad adaptation model !");
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public class oxoX implements MediaPlayer.OnPreparedListener {
        public oxoX() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            AdVideoView.this.f18720XI0IXoo = mediaPlayer.getDuration() / 1000;
            Log.d("octopus", "mPlayTime:" + AdVideoView.this.f18720XI0IXoo);
            if (AdVideoView.this.f18721XIxXXX0x0) {
                com.octopus.ad.internal.utilities.oIX0oI.oxoX(com.octopus.ad.internal.utilities.oIX0oI.f18685II0xO0, "Video start called!");
                AdVideoView.this.Xx000oIo(0);
                AdVideoView.this.f18730xI = a.NRF_START;
            } else {
                AdVideoView.this.f18730xI = a.NRF_PAUSE;
            }
            if (AdVideoView.this.f18720XI0IXoo <= 0) {
                AdVideoView.this.OxI(oOoIIO0.I0Io.f32018oOoXoXO);
            }
        }
    }

    public AdVideoView(AdWebView adWebView) {
        super(new MutableContextWrapper(adWebView.getContextFromMutableContext()));
        this.f18715Oo = false;
        this.f18712IXxxXO = false;
        this.f18717Oxx0xo = false;
        this.f18725oI0IIXIo = false;
        this.f18718OxxIIOOXO = false;
        this.f18720XI0IXoo = -1;
        this.f18721XIxXXX0x0 = false;
        this.f18733xxX = false;
        this.f18723XxX0x0xxx = false;
        this.f18730xI = a.NRF_NONE;
        this.f18728oo0xXOI0I = null;
        this.f18713IoOoX = a.b.FIT_CENTER;
        this.f18726oOXoIIIo = 0;
        this.f18722XO = adWebView;
        AdViewImpl adViewImpl = adWebView.f18916Oo;
        if (adViewImpl != null) {
            adViewImpl.setAdVideoView(this);
        }
    }

    private void X0o0xo() {
        if (this.f18727oo == null) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.f18727oo = mediaPlayer;
            mediaPlayer.setOnVideoSizeChangedListener(this);
            setSurfaceTextureListener(this);
            return;
        }
        IIX0o();
    }

    private void oOoXoXO() {
        XxX0x0xxx(new oxoX());
    }

    private void setDataSource(@NonNull AssetFileDescriptor assetFileDescriptor) throws IOException {
        oo(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        assetFileDescriptor.close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0xO0oo() {
        AdViewImpl adViewImpl;
        AdWebView adWebView = this.f18722XO;
        if (adWebView != null && (adViewImpl = adWebView.f18916Oo) != null && adViewImpl.getAdDispatcher() != null) {
            AdViewImpl adViewImpl2 = this.f18722XO.f18916Oo;
            adViewImpl2.f18832xoxXI++;
            if (!this.f18723XxX0x0xxx) {
                adViewImpl2.getAdDispatcher().c();
            }
            AdWebView adWebView2 = this.f18722XO;
            adWebView2.f18911IXxxXO.XI0oooXX(adWebView2.f18916Oo.getOpensNativeBrowser());
            this.f18722XO.f18911IXxxXO.XoX(this, this.f18726oOXoIIIo);
        }
    }

    @Override // com.octopus.ad.internal.view.I0Io
    public void II0xO0() {
        AdViewImpl adViewImpl;
        AdWebView adWebView = this.f18722XO;
        if (adWebView != null && (adViewImpl = adWebView.f18916Oo) != null) {
            boolean IIxOXoOo02 = AdViewImpl.IIxOXoOo0(adViewImpl.f18782Oxx0xo);
            this.f18723XxX0x0xxx = IIxOXoOo02;
            this.f18731xXxxox0I = new xxIXOIIO(IIxOXoOo02, new XO());
            this.f18722XO.setVisibility(0);
            this.f18722XO.f18916Oo.xxOXOOoIX(this);
            this.f18722XO.f18916Oo.oo(this);
            if (this.f18722XO.XoI0Ixx0()) {
                l mediaType = this.f18722XO.f18916Oo.getMediaType();
                l lVar = l.SPLASH;
                if (mediaType == lVar) {
                    this.f18722XO.f18916Oo.Ix00oIoI(0, 25, 0, 0);
                }
                if (this.f18722XO.f18916Oo.getMediaType() == l.INTERSTITIAL) {
                    AdWebView adWebView2 = this.f18722XO;
                    adWebView2.f18916Oo.IoOoX(adWebView2.getShowSkipBtnTime(), this.f18722XO.getAutoCloseTime(), this);
                } else {
                    AdWebView adWebView3 = this.f18722XO;
                    adWebView3.f18916Oo.oo0xXOI0I(this.f18720XI0IXoo, adWebView3.getShowSkipBtnTime(), Math.min(this.f18722XO.getAutoCloseTime(), this.f18720XI0IXoo));
                }
                this.f18722XO.f18916Oo.oOXoIIIo(this, this.f18733xxX);
                AdWebView adWebView4 = this.f18722XO;
                adWebView4.f18916Oo.setAdWebView(adWebView4);
                this.f18722XO.f18916Oo.x0(this);
                if (this.f18722XO.f18916Oo.getMediaType() != lVar) {
                    X00IoxXI();
                }
            }
        }
    }

    public void IIX0o() {
        this.f18727oo.reset();
    }

    public boolean IIXOooo() {
        return this.f18727oo.isLooping();
    }

    public void IO() {
        MediaPlayer mediaPlayer = this.f18727oo;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }

    public void IoOoX() {
        this.f18715Oo = true;
    }

    public void O0xOxO() {
        AdWebView adWebView;
        AdViewImpl adViewImpl;
        if (!this.f18725oI0IIXIo && (adWebView = this.f18722XO) != null && (adViewImpl = adWebView.f18916Oo) != null && this.f18728oo0xXOI0I != null && adViewImpl.o0xxxXXxX()) {
            this.f18725oI0IIXIo = true;
            if (TextUtils.isEmpty(this.f18711IIXOooo)) {
                AdViewImpl adViewImpl2 = this.f18722XO.f18916Oo;
                Pair<String, Integer> pair = this.f18728oo0xXOI0I;
                adViewImpl2.oxIIX0o((String) pair.first, ((Integer) pair.second).intValue());
                return;
            }
            new Oxx0IOOO(this.f18711IIXOooo).xoIox(new X0o0xo()).XO();
        }
    }

    public void OxI(int i) {
        AdViewImpl adViewImpl = this.f18722XO.f18916Oo;
        if (adViewImpl != null && adViewImpl.getRewaredVideoAdListener() != null) {
            this.f18722XO.f18916Oo.getRewaredVideoAdListener().II0xO0(i);
        }
    }

    public final void Oxx0IOOO(HashMap hashMap) {
        AdWebView adWebView;
        AdViewImpl adViewImpl;
        if (hashMap.isEmpty()) {
            return;
        }
        if (hashMap.containsKey(x0OxxIOxX.oIX0oI.f33874XIo0oOXIx)) {
            String str = (String) hashMap.get(x0OxxIOxX.oIX0oI.f33874XIo0oOXIx);
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case -2092301763:
                    if (str.equals("RIGHT_TOP_CROP")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1943089714:
                    if (str.equals("RIGHT_BOTTOM")) {
                        c = 1;
                        break;
                    }
                    break;
                case -1923874824:
                    if (str.equals("RIGHT_CENTER")) {
                        c = 2;
                        break;
                    }
                    break;
                case -1792626435:
                    if (str.equals("LEFT_TOP")) {
                        c = 3;
                        break;
                    }
                    break;
                case -1629510025:
                    if (str.equals("RIGHT_CENTER_CROP")) {
                        c = 4;
                        break;
                    }
                    break;
                case -1130639214:
                    if (str.equals("LEFT_TOP_CROP")) {
                        c = 5;
                        break;
                    }
                    break;
                case -1092027392:
                    if (str.equals("END_INSIDE")) {
                        c = 6;
                        break;
                    }
                    break;
                case -1025888925:
                    if (str.equals("LEFT_BOTTOM")) {
                        c = 7;
                        break;
                    }
                    break;
                case -1006674035:
                    if (str.equals("LEFT_CENTER")) {
                        c = '\b';
                        break;
                    }
                    break;
                case -440887238:
                    if (str.equals("CENTER_CROP")) {
                        c = '\t';
                        break;
                    }
                    break;
                case -438941894:
                    if (str.equals("CENTER_BOTTOM_CROP")) {
                        c = '\n';
                        break;
                    }
                    break;
                case -188276732:
                    if (str.equals("CENTER_TOP_CROP")) {
                        c = 11;
                        break;
                    }
                    break;
                case -172377086:
                    if (str.equals("LEFT_CENTER_CROP")) {
                        c = '\f';
                        break;
                    }
                    break;
                case -128849043:
                    if (str.equals("FIT_END")) {
                        c = '\r';
                        break;
                    }
                    break;
                case 378209945:
                    if (str.equals("START_INSIDE")) {
                        c = 14;
                        break;
                    }
                    break;
                case 384437857:
                    if (str.equals("RIGHT_BOTTOM_CROP")) {
                        c = 15;
                        break;
                    }
                    break;
                case 743229044:
                    if (str.equals("FIT_START")) {
                        c = 16;
                        break;
                    }
                    break;
                case 1093733475:
                    if (str.equals("FIT_CENTER")) {
                        c = 17;
                        break;
                    }
                    break;
                case 1218764914:
                    if (str.equals("RIGHT_TOP")) {
                        c = 18;
                        break;
                    }
                    break;
                case 1477882197:
                    if (str.equals("CENTER_BOTTOM")) {
                        c = 19;
                        break;
                    }
                    break;
                case 1648362059:
                    if (str.equals("CENTER_TOP")) {
                        c = 20;
                        break;
                    }
                    break;
                case 1677322022:
                    if (str.equals("CENTER_INSIDE")) {
                        c = 21;
                        break;
                    }
                    break;
                case 1841570796:
                    if (str.equals("LEFT_BOTTOM_CROP")) {
                        c = 22;
                        break;
                    }
                    break;
                case 1984282709:
                    if (str.equals("CENTER")) {
                        c = 23;
                        break;
                    }
                    break;
                case 2074054159:
                    if (str.equals("FIT_XY")) {
                        c = 24;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    this.f18713IoOoX = a.b.RIGHT_TOP_CROP;
                    break;
                case 1:
                    this.f18713IoOoX = a.b.RIGHT_BOTTOM;
                    break;
                case 2:
                    this.f18713IoOoX = a.b.RIGHT_CENTER;
                    break;
                case 3:
                    this.f18713IoOoX = a.b.LEFT_TOP;
                    break;
                case 4:
                    this.f18713IoOoX = a.b.RIGHT_CENTER_CROP;
                    break;
                case 5:
                    this.f18713IoOoX = a.b.LEFT_TOP_CROP;
                    break;
                case 6:
                    this.f18713IoOoX = a.b.END_INSIDE;
                    break;
                case 7:
                    this.f18713IoOoX = a.b.LEFT_BOTTOM;
                    break;
                case '\b':
                    this.f18713IoOoX = a.b.LEFT_CENTER;
                    break;
                case '\t':
                    this.f18713IoOoX = a.b.CENTER_CROP;
                    break;
                case '\n':
                    this.f18713IoOoX = a.b.CENTER_BOTTOM_CROP;
                    break;
                case 11:
                    this.f18713IoOoX = a.b.CENTER_TOP_CROP;
                    break;
                case '\f':
                    this.f18713IoOoX = a.b.LEFT_CENTER_CROP;
                    break;
                case '\r':
                    this.f18713IoOoX = a.b.FIT_END;
                    break;
                case 14:
                    this.f18713IoOoX = a.b.START_INSIDE;
                    break;
                case 15:
                    this.f18713IoOoX = a.b.RIGHT_BOTTOM_CROP;
                    break;
                case 16:
                    this.f18713IoOoX = a.b.FIT_START;
                    break;
                case 17:
                    this.f18713IoOoX = a.b.FIT_CENTER;
                    break;
                case 18:
                    this.f18713IoOoX = a.b.RIGHT_TOP;
                    break;
                case 19:
                    this.f18713IoOoX = a.b.CENTER_BOTTOM;
                    break;
                case 20:
                    this.f18713IoOoX = a.b.CENTER_TOP;
                    break;
                case 21:
                    this.f18713IoOoX = a.b.CENTER_INSIDE;
                    break;
                case 22:
                    this.f18713IoOoX = a.b.LEFT_BOTTOM_CROP;
                    break;
                case 23:
                    this.f18713IoOoX = a.b.CENTER;
                    break;
                case 24:
                    this.f18713IoOoX = a.b.FIT_XY;
                    break;
                default:
                    this.f18713IoOoX = a.b.FIT_CENTER;
                    break;
            }
        }
        if (hashMap.containsKey(x0OxxIOxX.oIX0oI.f33872Ioxxx)) {
            String str2 = (String) hashMap.get(x0OxxIOxX.oIX0oI.f33872Ioxxx);
            try {
                if (str2 != null) {
                    JSONObject jSONObject = new JSONObject(str2);
                    this.f18711IIXOooo = jSONObject.optString("callback_url");
                    this.f18728oo0xXOI0I = Pair.create(jSONObject.optString("name"), Integer.valueOf(jSONObject.optInt("amount")));
                    if (!TextUtils.isEmpty(this.f18711IIXOooo) && (adWebView = this.f18722XO) != null && (adViewImpl = adWebView.f18916Oo) != null && adViewImpl.getAdParameters() != null) {
                        String extraData = this.f18722XO.f18916Oo.getExtraData();
                        if (!TextUtils.isEmpty(extraData)) {
                            this.f18711IIXOooo += "&extra=" + extraData;
                        }
                        String userId = this.f18722XO.f18916Oo.getUserId();
                        if (!TextUtils.isEmpty(userId)) {
                            this.f18711IIXOooo += "&userId=" + userId;
                            return;
                        }
                        return;
                    }
                    return;
                }
                this.f18728oo0xXOI0I = Pair.create("", 0);
            } catch (JSONException unused) {
                com.octopus.ad.internal.utilities.oIX0oI.oxoX(com.octopus.ad.internal.utilities.oIX0oI.f18709xxIXOIIO, "Error parse reward item: " + str2);
                this.f18728oo0xXOI0I = Pair.create("", 0);
            }
        }
    }

    public void X00IoxXI() {
        if (TextUtils.isEmpty(this.f18729ooXIXxIX)) {
            return;
        }
        try {
            II0XooXoX II0XooXoX2 = xoIox.oIX0oI().II0XooXoX();
            if (II0XooXoX2 != null && II0XooXoX2.ooOOo0oXI(this.f18729ooXIXxIX)) {
                setDataSource(II0XooXoX2.oIX0oI(this.f18729ooXIXxIX));
            } else {
                setDataSource(this.f18729ooXIXxIX);
            }
            oOoXoXO();
        } catch (Exception e) {
            OxI(oOoIIO0.I0Io.f32018oOoXoXO);
            com.octopus.ad.internal.utilities.oIX0oI.oxoX(com.octopus.ad.internal.utilities.oIX0oI.f18705x0XOIxOo, com.octopus.ad.internal.utilities.oIX0oI.Oxx0xo(R.string.failed_video_load, this.f18729ooXIXxIX, e.getMessage()));
        }
    }

    public void X0IIOO() {
        MediaPlayer mediaPlayer = this.f18727oo;
        if (mediaPlayer != null) {
            mediaPlayer.pause();
            this.f18722XO.f18911IXxxXO.xo0x(this);
        }
    }

    public void XI0IXoo() throws IOException, IllegalStateException {
        XIxXXX0x0(null);
    }

    public void XIxXXX0x0(@Nullable MediaPlayer.OnPreparedListener onPreparedListener) throws IOException, IllegalStateException {
        this.f18727oo.setOnPreparedListener(onPreparedListener);
        this.f18727oo.prepare();
    }

    public final void XO(int i, int i2) {
        Matrix X0o0xo2;
        if (i != 0 && i2 != 0 && (X0o0xo2 = new com.octopus.ad.internal.video.a(new a.II0xO0(getWidth(), getHeight()), new a.II0xO0(i, i2)).X0o0xo(this.f18713IoOoX)) != null) {
            setTransform(X0o0xo2);
        }
    }

    public void Xx000oIo(int i) {
        MediaPlayer mediaPlayer = this.f18727oo;
        if (mediaPlayer != null) {
            mediaPlayer.start();
            this.f18722XO.f18911IXxxXO.xXOx(this, i);
        }
    }

    public void XxX0x0xxx(@Nullable MediaPlayer.OnPreparedListener onPreparedListener) throws IllegalStateException {
        this.f18727oo.setOnPreparedListener(onPreparedListener);
        this.f18727oo.prepareAsync();
    }

    @Override // com.octopus.ad.internal.view.I0Io
    public void destroy() {
        IO();
        I0oOoX.O0xOxO(this);
    }

    public AdWebView getAdWebView() {
        return this.f18722XO;
    }

    @Override // com.octopus.ad.internal.view.I0Io
    public int getCreativeHeight() {
        return this.f18714O0xOxO;
    }

    public int getCreativeLeft() {
        return this.f18732xoXoI;
    }

    public int getCreativeTop() {
        return this.f18724o00;
    }

    @Override // com.octopus.ad.internal.view.I0Io
    public int getCreativeWidth() {
        return this.f18716OxI;
    }

    public int getCurrentPosition() {
        return this.f18727oo.getCurrentPosition();
    }

    public int getDuration() {
        return this.f18727oo.getDuration();
    }

    @Override // com.octopus.ad.internal.view.I0Io
    public int getRefreshInterval() {
        return this.f18719X0IIOO;
    }

    public int getVideoHeight() {
        return this.f18727oo.getVideoHeight();
    }

    public String getVideoUrl() {
        return this.f18729ooXIXxIX;
    }

    public int getVideoWidth() {
        return this.f18727oo.getVideoWidth();
    }

    @Override // com.octopus.ad.internal.view.I0Io
    public View getView() {
        return this;
    }

    public void o00() {
        AdViewImpl adViewImpl;
        if (!this.f18718OxxIIOOXO && (adViewImpl = this.f18722XO.f18916Oo) != null) {
            this.f18718OxxIIOOXO = true;
            adViewImpl.XIXIxO();
        }
    }

    @Override // com.octopus.ad.internal.view.I0Io
    public boolean oIX0oI() {
        return this.f18715Oo;
    }

    public void oOXoIIIo(float f, float f2) {
        MediaPlayer mediaPlayer = this.f18727oo;
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(f, f2);
        }
    }

    @Override // com.octopus.ad.internal.view.I0Io
    public void onDestroy() {
        destroy();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f18727oo == null) {
            return;
        }
        if (xoXoI()) {
            IO();
        }
        xXxxox0I();
    }

    @Override // com.octopus.ad.internal.view.I0Io
    public void onPause() {
        if (!this.f18717Oxx0xo && this.f18730xI == a.NRF_START) {
            X0IIOO();
            IXO.oIX0oI oix0oi = this.f18710IIX0o;
            if (oix0oi != null) {
                oix0oi.xxIXOIIO();
            }
            this.f18730xI = a.NRF_PAUSE;
        }
    }

    @Override // com.octopus.ad.internal.view.I0Io
    public void onResume() {
        if (!this.f18717Oxx0xo && this.f18730xI == a.NRF_PAUSE) {
            Xx000oIo(1);
            IXO.oIX0oI oix0oi = this.f18710IIX0o;
            if (oix0oi != null) {
                oix0oi.oOoXoXO();
            }
            this.f18730xI = a.NRF_START;
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        Surface surface = new Surface(surfaceTexture);
        MediaPlayer mediaPlayer = this.f18727oo;
        if (mediaPlayer != null) {
            mediaPlayer.setSurface(surface);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        xxIXOIIO xxixoiio = this.f18731xXxxox0I;
        if (xxixoiio != null) {
            return xxixoiio.onTouch(this, motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
    }

    @Override // android.view.TextureView, android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        ooOOo0oXI(getWindowVisibility(), i);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        ooOOo0oXI(i, getVisibility());
    }

    public void oo(@NonNull FileDescriptor fileDescriptor, long j, long j2) throws IOException {
        X0o0xo();
        this.f18727oo.setDataSource(fileDescriptor, j, j2);
    }

    public void oo0xXOI0I(@NonNull Context context, @NonNull Uri uri, @Nullable Map<String, String> map) throws IOException {
        X0o0xo();
        this.f18727oo.setDataSource(context, uri, map);
    }

    public final void ooOOo0oXI(int i, int i2) {
        if (i == 0 && i2 == 0) {
            onResume();
            this.f18721XIxXXX0x0 = true;
        } else {
            onPause();
            this.f18721XIxXXX0x0 = false;
        }
    }

    public void ooXIXxIX(int i) {
        MediaPlayer mediaPlayer = this.f18727oo;
        if (mediaPlayer != null) {
            mediaPlayer.seekTo(i);
        }
    }

    public void setAssetData(@NonNull String str) throws IOException {
        setDataSource(getContext().getAssets().openFd(str));
    }

    public void setCountDownTimer(IXO.oIX0oI oix0oi) {
        this.f18710IIX0o = oix0oi;
    }

    public void setCreativeLeft(int i) {
        this.f18732xoXoI = i;
    }

    public void setCreativeTop(int i) {
        this.f18724o00 = i;
    }

    public void setLooping(boolean z) {
        MediaPlayer mediaPlayer = this.f18727oo;
        if (mediaPlayer != null) {
            mediaPlayer.setLooping(z);
        }
    }

    public void setOnCompletionListener(@Nullable MediaPlayer.OnCompletionListener onCompletionListener) {
        this.f18727oo.setOnCompletionListener(onCompletionListener);
    }

    public void setOnErrorListener(@Nullable MediaPlayer.OnErrorListener onErrorListener) {
        this.f18727oo.setOnErrorListener(onErrorListener);
    }

    public void setOnInfoListener(@Nullable MediaPlayer.OnInfoListener onInfoListener) {
        this.f18727oo.setOnInfoListener(onInfoListener);
    }

    public void setOpt(int i) {
        this.f18726oOXoIIIo = i;
    }

    public void setRawData(@RawRes int i) throws IOException {
        setDataSource(getResources().openRawResourceFd(i));
    }

    public void setRefreshInterval(int i) {
        this.f18719X0IIOO = i;
    }

    public void setScalableType(a.b bVar) {
        this.f18713IoOoX = bVar;
        XO(getVideoWidth(), getVideoHeight());
    }

    public void x0o(AdWebView adWebView, String str) {
        int creativeWidth;
        int creativeHeight;
        if (x0o.II0XooXoX(str)) {
            IoOoX();
            OxI(oOoIIO0.I0Io.f32022xoIox);
            return;
        }
        this.f18714O0xOxO = adWebView.getCreativeHeight();
        this.f18716OxI = adWebView.getCreativeWidth();
        this.f18724o00 = adWebView.getCreativeTop();
        this.f18732xoXoI = adWebView.getCreativeLeft();
        this.f18719X0IIOO = adWebView.getRefreshInterval();
        try {
            new URI(str);
            this.f18713IoOoX = a.b.FIT_CENTER;
            com.octopus.ad.internal.utilities.oIX0oI.ooXIXxIX(com.octopus.ad.internal.utilities.oIX0oI.f18705x0XOIxOo, com.octopus.ad.internal.utilities.oIX0oI.x0xO0oo(R.string.videoview_loading, str));
            Oxx0IOOO(adWebView.getAdExtras());
            this.f18729ooXIXxIX = str;
            X0o0xo();
            boolean o02 = adWebView.o0();
            this.f18733xxX = o02;
            if (o02) {
                oOXoIIIo(0.0f, 0.0f);
            } else {
                oOXoIIIo(1.0f, 1.0f);
            }
            float oI0IIXIo2 = xoIox.oIX0oI().oI0IIXIo();
            float OxxIIOOXO2 = xoIox.oIX0oI().OxxIIOOXO();
            if (getCreativeWidth() == 1 && getCreativeHeight() == 1) {
                creativeHeight = -1;
                creativeWidth = -1;
            } else {
                creativeWidth = (int) ((getCreativeWidth() * oI0IIXIo2) + 0.5f);
                creativeHeight = (int) ((getCreativeHeight() * OxxIIOOXO2) + 0.5f);
            }
            if (getCreativeLeft() == 0 && getCreativeTop() == 0) {
                setLayoutParams(new FrameLayout.LayoutParams(creativeWidth, creativeHeight, 17));
            } else {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(creativeWidth, creativeHeight, 8388659);
                layoutParams.setMargins((int) ((getCreativeLeft() * oI0IIXIo2) + 0.5f), (int) ((getCreativeTop() * OxxIIOOXO2) + 0.5f), 0, 0);
                setLayoutParams(layoutParams);
                setScalableType(a.b.FIT_START);
            }
            setOnCompletionListener(new oIX0oI(adWebView));
            setOnInfoListener(new II0xO0());
            setOnErrorListener(new I0Io());
        } catch (NullPointerException | URISyntaxException unused) {
            com.octopus.ad.internal.utilities.oIX0oI.oxoX(com.octopus.ad.internal.utilities.oIX0oI.f18705x0XOIxOo, com.octopus.ad.internal.utilities.oIX0oI.x0xO0oo(R.string.invalid_video_url, str));
            IoOoX();
            OxI(oOoIIO0.I0Io.f32014OOXIXo);
        }
    }

    public void xI(@NonNull Context context, @NonNull Uri uri) throws IOException {
        X0o0xo();
        this.f18727oo.setDataSource(context, uri);
    }

    public boolean xII() {
        boolean z = this.f18733xxX;
        this.f18733xxX = !z;
        if (!z) {
            oOXoIIIo(0.0f, 0.0f);
        } else {
            oOXoIIIo(1.0f, 1.0f);
        }
        return this.f18733xxX;
    }

    public void xXxxox0I() {
        IIX0o();
        this.f18727oo.release();
        this.f18727oo = null;
    }

    public boolean xoXoI() {
        return this.f18727oo.isPlaying();
    }

    public void xxX() throws IllegalStateException {
        XxX0x0xxx(null);
    }

    public void setDataSource(@NonNull String str) throws IOException {
        X0o0xo();
        this.f18727oo.setDataSource(str);
    }

    public void setDataSource(@NonNull FileDescriptor fileDescriptor) throws IOException {
        X0o0xo();
        this.f18727oo.setDataSource(fileDescriptor);
    }
}
