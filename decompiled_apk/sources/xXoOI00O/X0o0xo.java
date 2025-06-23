package xXoOI00O;

import IO0XoXxO.xoIox;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.ViewCompat;
import com.google.android.exoplayer2.ExoPlayer;
import com.octopus.ad.NativeAdResponse;
import com.octopus.ad.R;
import com.octopus.ad.internal.view.AdViewImpl;
import com.octopus.ad.internal.view.xxIXOIIO;
import com.octopus.ad.model.II0xO0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import x0.I0oOoX;
import x0.OI0;
import x0.X00IoxXI;
import x0.oOXoIIIo;
import x0.ooXIXxIX;
import x0OxxIOxX.oIX0oI;

/* loaded from: classes11.dex */
public class X0o0xo implements NativeAdResponse {

    /* renamed from: I0X0x0oIo, reason: collision with root package name */
    public View.OnClickListener f34723I0X0x0oIo;

    /* renamed from: I0oOIX, reason: collision with root package name */
    public X0xII0I.oIX0oI f34724I0oOIX;

    /* renamed from: I0oOoX, reason: collision with root package name */
    public List<? extends View> f34725I0oOoX;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public String f34726II0XooXoX;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public boolean f34728IIXOooo;

    /* renamed from: IO, reason: collision with root package name */
    public View f34729IO;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public boolean f34730IXxxXO;

    /* renamed from: Io, reason: collision with root package name */
    public boolean f34731Io;

    /* renamed from: IoOoX, reason: collision with root package name */
    public x0OxxIOxX.oIX0oI f34732IoOoX;

    /* renamed from: O0Xx, reason: collision with root package name */
    public II0xO0.C0895II0xO0 f34733O0Xx;

    /* renamed from: OI0, reason: collision with root package name */
    public boolean f34735OI0;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public String f34736OOXIXo;

    /* renamed from: Oo, reason: collision with root package name */
    public boolean f34737Oo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public String f34739Oxx0IOOO;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public boolean f34740Oxx0xo;

    /* renamed from: X00IoxXI, reason: collision with root package name */
    public IO0XoXxO.xoIox f34742X00IoxXI;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public String f34744X0o0xo;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public String f34745XI0IXoo;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public HashMap<String, Object> f34746XIxXXX0x0;

    /* renamed from: XO, reason: collision with root package name */
    public String f34747XO;

    /* renamed from: XOxIOxOx, reason: collision with root package name */
    public boolean f34748XOxIOxOx;

    /* renamed from: XX, reason: collision with root package name */
    public boolean f34749XX;

    /* renamed from: XX0, reason: collision with root package name */
    public View.OnTouchListener f34750XX0;

    /* renamed from: Xo0, reason: collision with root package name */
    public ArrayList<com.octopus.ad.internal.xxIXOIIO> f34751Xo0;

    /* renamed from: XoX, reason: collision with root package name */
    public View f34753XoX;

    /* renamed from: Xx000oIo, reason: collision with root package name */
    public II0xO0.oI0IIXIo f34754Xx000oIo;

    /* renamed from: o0, reason: collision with root package name */
    public boolean f34756o0;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public boolean f34758oI0IIXIo;

    /* renamed from: oO, reason: collision with root package name */
    public int f34759oO;

    /* renamed from: oOXoIIIo, reason: collision with root package name */
    public AppCompatTextView f34760oOXoIIIo;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public String f34761oOoXoXO;

    /* renamed from: oX, reason: collision with root package name */
    public com.octopus.ad.internal.oO f34762oX;

    /* renamed from: oo, reason: collision with root package name */
    public oIX0oI.oxoX f34763oo;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public oIX0oI.oxoX f34764oo0xXOI0I;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public double f34765ooOOo0oXI;

    /* renamed from: oxXx0IX, reason: collision with root package name */
    public List<View> f34767oxXx0IX;

    /* renamed from: oxoX, reason: collision with root package name */
    public NativeAdResponse.b f34768oxoX;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public String f34770x0XOIxOo;

    /* renamed from: x0o, reason: collision with root package name */
    public ProgressBar f34771x0o;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public int f34772x0xO0oo;

    /* renamed from: xII, reason: collision with root package name */
    public VideoView f34774xII;

    /* renamed from: xXOx, reason: collision with root package name */
    public xXoOI00O.oIX0oI f34775xXOx;

    /* renamed from: xo0x, reason: collision with root package name */
    public List<View> f34777xo0x;

    /* renamed from: xoIox, reason: collision with root package name */
    public Bitmap f34778xoIox;

    /* renamed from: xoXoI, reason: collision with root package name */
    public boolean f34779xoXoI;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public Bitmap f34780xxIXOIIO;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public boolean f34741OxxIIOOXO = false;

    /* renamed from: o00, reason: collision with root package name */
    public int f34757o00 = 0;

    /* renamed from: OxI, reason: collision with root package name */
    public int f34738OxI = 0;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public boolean f34734O0xOxO = true;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public boolean f34743X0IIOO = false;

    /* renamed from: xxX, reason: collision with root package name */
    public boolean f34781xxX = false;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public final ArrayList<String> f34755XxX0x0xxx = new ArrayList<>();

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public final ArrayList<String> f34776xXxxox0I = new ArrayList<>();

    /* renamed from: IIX0o, reason: collision with root package name */
    public final ArrayList<String> f34727IIX0o = new ArrayList<>();

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public ArrayList<String> f34766ooXIXxIX = new ArrayList<>();

    /* renamed from: xI, reason: collision with root package name */
    public ArrayList<String> f34773xI = new ArrayList<>();

    /* renamed from: oxxXoxO, reason: collision with root package name */
    public final Runnable f34769oxxXoxO = new xxIXOIIO();

    /* renamed from: XoI0Ixx0, reason: collision with root package name */
    public String f34752XoI0Ixx0 = "";

    /* loaded from: classes11.dex */
    public class I0Io implements Runnable {

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ float f34783Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ View f34784XO;

        public I0Io(View view, float f) {
            this.f34784XO = view;
            this.f34783Oo = f;
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewGroup.LayoutParams layoutParams = this.f34784XO.getLayoutParams();
            layoutParams.width = (int) (this.f34784XO.getWidth() * this.f34783Oo);
            layoutParams.height = (int) (this.f34784XO.getHeight() * this.f34783Oo);
            this.f34784XO.setLayoutParams(layoutParams);
        }
    }

    /* loaded from: classes11.dex */
    public class II0XooXoX implements Runnable {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public final /* synthetic */ float f34785IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ int f34786Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f34788XO;

        public II0XooXoX(ViewGroup viewGroup, int i, float f) {
            this.f34788XO = viewGroup;
            this.f34786Oo = i;
            this.f34785IXxxXO = f;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            if (X0o0xo.this.f34754Xx000oIo == null || X0o0xo.this.f34754Xx000oIo.oIX0oI() == 0) {
                X0o0xo.this.xII(this.f34788XO, 1.5d, XIXIX.OOXIXo.f3760XO, "摇动或点击了解更多", true, false, this.f34786Oo, this.f34785IXxxXO);
                return;
            }
            X0o0xo x0o0xo = X0o0xo.this;
            ViewGroup viewGroup = this.f34788XO;
            double II0XooXoX2 = x0o0xo.f34754Xx000oIo.II0XooXoX();
            double OOXIXo2 = X0o0xo.this.f34754Xx000oIo.OOXIXo();
            String xoIox2 = X0o0xo.this.f34754Xx000oIo.xoIox();
            boolean z2 = true;
            if (X0o0xo.this.f34754Xx000oIo.oOoXoXO() == 1) {
                z = true;
            } else {
                z = false;
            }
            if (X0o0xo.this.f34754Xx000oIo.X0o0xo() != 1) {
                z2 = false;
            }
            x0o0xo.xII(viewGroup, II0XooXoX2, OOXIXo2, xoIox2, z, z2, this.f34786Oo, this.f34785IXxxXO);
        }
    }

    /* loaded from: classes11.dex */
    public class II0xO0 implements Runnable {

        /* renamed from: IIXOooo, reason: collision with root package name */
        public final /* synthetic */ TextView f34789IIXOooo;

        /* renamed from: IXxxXO, reason: collision with root package name */
        public final /* synthetic */ ImageView f34790IXxxXO;

        /* renamed from: O0xOxO, reason: collision with root package name */
        public final /* synthetic */ FrameLayout f34791O0xOxO;

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ float f34792Oo;

        /* renamed from: OxI, reason: collision with root package name */
        public final /* synthetic */ View f34793OxI;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public final /* synthetic */ ImageView f34794Oxx0xo;

        /* renamed from: OxxIIOOXO, reason: collision with root package name */
        public final /* synthetic */ ImageView f34795OxxIIOOXO;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f34797XO;

        /* renamed from: o00, reason: collision with root package name */
        public final /* synthetic */ ImageView f34798o00;

        /* renamed from: oI0IIXIo, reason: collision with root package name */
        public final /* synthetic */ TextView f34799oI0IIXIo;

        /* renamed from: xoXoI, reason: collision with root package name */
        public final /* synthetic */ FrameLayout f34800xoXoI;

        /* renamed from: xXoOI00O.X0o0xo$II0xO0$II0xO0, reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        public class C1165II0xO0 implements oOXoIIIo.II0xO0 {
            public C1165II0xO0() {
            }

            @Override // x0.oOXoIIIo.II0xO0
            public void II0xO0(Bitmap bitmap) {
                II0xO0.this.f34798o00.setImageBitmap(bitmap);
                X0o0xo.this.f34771x0o.setVisibility(8);
            }

            @Override // x0.oOXoIIIo.II0xO0
            public void oIX0oI() {
                if (X0o0xo.this.f34775xXOx != null) {
                    X0o0xo.this.f34775xXOx.onAdRenderFailed(oOoIIO0.I0Io.f32015Oxx0IOOO);
                }
            }
        }

        /* loaded from: classes11.dex */
        public class oIX0oI implements Runnable {
            public oIX0oI() {
            }

            @Override // java.lang.Runnable
            public void run() {
                II0xO0.this.f34797XO.getLayoutParams().height += X0o0xo.this.f34760oOXoIIIo.getHeight();
            }
        }

        public II0xO0(ViewGroup viewGroup, float f, ImageView imageView, ImageView imageView2, TextView textView, ImageView imageView3, TextView textView2, FrameLayout frameLayout, ImageView imageView4, View view, FrameLayout frameLayout2) {
            this.f34797XO = viewGroup;
            this.f34792Oo = f;
            this.f34790IXxxXO = imageView;
            this.f34794Oxx0xo = imageView2;
            this.f34799oI0IIXIo = textView;
            this.f34795OxxIIOOXO = imageView3;
            this.f34789IIXOooo = textView2;
            this.f34800xoXoI = frameLayout;
            this.f34798o00 = imageView4;
            this.f34793OxI = view;
            this.f34791O0xOxO = frameLayout2;
        }

        @Override // java.lang.Runnable
        public void run() {
            float f;
            if (this.f34797XO.getLayoutParams().width <= 0) {
                this.f34797XO.getLayoutParams().width = I0oOoX.Oxx0xo(this.f34797XO.getContext());
            }
            if (this.f34797XO.getLayoutParams().height <= 0) {
                this.f34797XO.getLayoutParams().height = (int) (this.f34797XO.getLayoutParams().width / this.f34792Oo);
            }
            int OxI2 = I0oOoX.OxI(this.f34797XO.getContext(), this.f34797XO.getWidth());
            float f2 = 1.0f;
            if (OxI2 > 0) {
                f = OxI2 / 360.0f;
            } else {
                f = 1.0f;
            }
            if (f <= 1.0f) {
                f2 = f;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f34790IXxxXO);
            arrayList.add(this.f34794Oxx0xo);
            arrayList.add(this.f34799oI0IIXIo);
            arrayList.add(this.f34795OxxIIOOXO);
            arrayList.add(this.f34789IIXOooo);
            arrayList.add(X0o0xo.this.f34771x0o);
            X0o0xo.this.XX(arrayList, f2);
            if (X0o0xo.this.f34724I0oOIX != null) {
                X0o0xo.this.f34760oOXoIIIo = I0oOoX.XO(this.f34797XO.getContext(), X0o0xo.this.f34724I0oOIX, f2, true);
                if (X0o0xo.this.f34757o00 == 3 || X0o0xo.this.f34757o00 == 4) {
                    X0o0xo.this.f34760oOXoIIIo.post(new oIX0oI());
                }
            }
            if (X0o0xo.this.isVideo()) {
                if (X0o0xo.this.II0xO0().size() > 0) {
                    this.f34800xoXoI.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
                    X0o0xo.this.oOo();
                }
            } else if (!TextUtils.isEmpty(X0o0xo.this.getImageUrl())) {
                oOXoIIIo.II0XooXoX(null).X0o0xo(X0o0xo.this.getImageUrl(), new C1165II0xO0());
            }
            X0o0xo.this.XOxIOxOx(this.f34797XO, this.f34793OxI, this.f34791O0xOxO);
            if (X0o0xo.this.f34754Xx000oIo != null && X0o0xo.this.f34754Xx000oIo.oIX0oI() == 1) {
                X0o0xo.this.f34731Io = true;
                if (X0o0xo.this.f34757o00 != 3 && X0o0xo.this.f34757o00 != 4) {
                    X0o0xo.this.OxI(this.f34800xoXoI, 100, 10.0f);
                } else {
                    X0o0xo.this.OxI(this.f34800xoXoI, 130, 13.0f);
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public class IXxxXO implements View.OnClickListener {
        public IXxxXO() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (X0o0xo.this.f34748XOxIOxOx) {
                X0o0xo.this.oOXoIIIo(view);
                X0o0xo.this.f34748XOxIOxOx = false;
                return;
            }
            if (X0o0xo.this.f34775xXOx != null) {
                X0o0xo.this.f34775xXOx.onAdClose();
            }
            if (X0o0xo.this.f34732IoOoX != null) {
                X0o0xo.this.f34732IoOoX.x0xO();
            }
        }
    }

    /* loaded from: classes11.dex */
    public class OOXIXo implements AdViewImpl.IoOoX {
        public OOXIXo() {
        }

        @Override // com.octopus.ad.internal.view.AdViewImpl.IoOoX
        public void a() {
            if (!X0o0xo.this.f34730IXxxXO && !X0o0xo.this.f34740Oxx0xo && X0o0xo.this.f34753XoX != null && X0o0xo.this.f34732IoOoX != null) {
                if (AdViewImpl.xxIO(X0o0xo.this.f34732IoOoX)) {
                    X0o0xo.this.f34758oI0IIXIo = false;
                    X0o0xo.this.f34734O0xOxO = true;
                    X0o0xo.this.f34738OxI = 0;
                } else {
                    X0o0xo.this.f34758oI0IIXIo = true;
                    X0o0xo.this.f34738OxI = 9;
                }
                X0o0xo x0o0xo = X0o0xo.this;
                x0o0xo.oOXoIIIo(x0o0xo.f34753XoX);
            }
        }
    }

    /* loaded from: classes11.dex */
    public class Oxx0IOOO implements xoIox.oxoX {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f34806oIX0oI;

        public Oxx0IOOO(ViewGroup viewGroup) {
            this.f34806oIX0oI = viewGroup;
        }

        @Override // IO0XoXxO.xoIox.oxoX
        public void a() {
            X0o0xo.this.oOXoIIIo(this.f34806oIX0oI);
        }
    }

    /* loaded from: classes11.dex */
    public class XO implements xXoOI00O.II0xO0 {
        public XO() {
        }

        @Override // xXoOI00O.II0xO0
        public void oIX0oI(boolean z) {
            X0o0xo.this.ooOx(z);
        }
    }

    /* loaded from: classes11.dex */
    public class oIX0oI implements xXoOI00O.II0xO0 {
        public oIX0oI() {
        }

        @Override // xXoOI00O.II0xO0
        public void oIX0oI(boolean z) {
            X0o0xo.this.ooOx(z);
        }
    }

    /* loaded from: classes11.dex */
    public class oO implements Runnable {
        public oO() {
        }

        @Override // java.lang.Runnable
        public void run() {
            X0o0xo.this.oOXoIIIo(null);
        }
    }

    /* loaded from: classes11.dex */
    public class oOoXoXO implements Runnable {
        public oOoXoXO() {
        }

        @Override // java.lang.Runnable
        public void run() {
            X0o0xo.this.xOoOIoI();
        }
    }

    /* loaded from: classes11.dex */
    public class ooOOo0oXI implements Runnable {
        public ooOOo0oXI() {
        }

        @Override // java.lang.Runnable
        public void run() {
            X0o0xo.this.oOXoIIIo(null);
        }
    }

    /* loaded from: classes11.dex */
    public class oxoX implements MediaPlayer.OnPreparedListener {
        public oxoX() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            mediaPlayer.setVolume(0.0f, 0.0f);
            if (X0o0xo.this.f34771x0o != null) {
                X0o0xo.this.f34771x0o.setVisibility(8);
            }
        }
    }

    /* loaded from: classes11.dex */
    public class x0XOIxOo implements Runnable {
        public x0XOIxOo() {
        }

        @Override // java.lang.Runnable
        public void run() {
            X0o0xo.this.xOoOIoI();
        }
    }

    /* loaded from: classes11.dex */
    public class x0xO0oo implements xxIXOIIO.oIX0oI {
        public x0xO0oo() {
        }

        @Override // com.octopus.ad.internal.view.xxIXOIIO.oIX0oI
        public void a(View view) {
            if (X0o0xo.this.f34743X0IIOO) {
                X0o0xo.this.f34738OxI = 12;
            }
            X0o0xo.this.oOXoIIIo(view);
        }
    }

    /* loaded from: classes11.dex */
    public class xoIox implements ooXIXxIX.II0xO0 {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ xXoOI00O.II0xO0 f34817oIX0oI;

        public xoIox(xXoOI00O.II0xO0 iI0xO0) {
            this.f34817oIX0oI = iI0xO0;
        }

        @Override // x0.ooXIXxIX.II0xO0
        public void oIX0oI(boolean z, String str) {
            xXoOI00O.II0xO0 iI0xO0 = this.f34817oIX0oI;
            if (iI0xO0 != null) {
                iI0xO0.oIX0oI(z);
            }
        }
    }

    /* loaded from: classes11.dex */
    public class xxIXOIIO implements Runnable {
        public xxIXOIIO() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Log.e("expireRunnable", "expireRunnable");
            X0o0xo.this.f34781xxX = true;
            X0o0xo.this.f34753XoX = null;
            X0o0xo.this.f34767oxXx0IX = null;
            X0o0xo.this.f34777xo0x = null;
            if (X0o0xo.this.f34762oX != null) {
                X0o0xo.this.f34762oX.xoIox();
                X0o0xo.this.f34762oX = null;
            }
            X0o0xo.this.f34751Xo0 = null;
            X0o0xo.this.f34775xXOx = null;
            if (X0o0xo.this.f34778xoIox != null) {
                X0o0xo.this.f34778xoIox.recycle();
                X0o0xo.this.f34778xoIox = null;
            }
            if (X0o0xo.this.f34780xxIXOIIO != null) {
                X0o0xo.this.f34780xxIXOIIO.recycle();
                X0o0xo.this.f34780xxIXOIIO = null;
            }
        }
    }

    public static X0o0xo oo0xXOI0I(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        ArrayList<String> II0XooXoX2 = X00IoxXI.II0XooXoX(X00IoxXI.oIX0oI(jSONObject, "ImpressionTrackers"));
        X0o0xo x0o0xo = new X0o0xo();
        if (II0XooXoX2 != null) {
            x0o0xo.f34766ooXIXxIX = II0XooXoX2;
        }
        x0o0xo.f34744X0o0xo = X00IoxXI.Oxx0IOOO(jSONObject, "Headline");
        x0o0xo.f34747XO = X00IoxXI.Oxx0IOOO(jSONObject, "Body");
        x0o0xo.f34739Oxx0IOOO = X00IoxXI.Oxx0IOOO(jSONObject, "Image");
        x0o0xo.f34757o00 = X00IoxXI.oxoX(jSONObject, "LayoutType");
        x0o0xo.f34728IIXOooo = X00IoxXI.II0xO0(jSONObject, "IsShowClose");
        JSONArray oIX0oI2 = X00IoxXI.oIX0oI(jSONObject, "Images");
        JSONArray oIX0oI3 = X00IoxXI.oIX0oI(jSONObject, "Videos");
        JSONArray oIX0oI4 = X00IoxXI.oIX0oI(jSONObject, "Texts");
        if (oIX0oI2 != null) {
            for (int i = 0; i < oIX0oI2.length(); i++) {
                x0o0xo.f34755XxX0x0xxx.add((String) oIX0oI2.get(i));
            }
        }
        if (oIX0oI3 != null) {
            for (int i2 = 0; i2 < oIX0oI3.length(); i2++) {
                x0o0xo.f34776xXxxox0I.add((String) oIX0oI3.get(i2));
            }
        }
        if (oIX0oI4 != null) {
            for (int i3 = 0; i3 < oIX0oI4.length(); i3++) {
                x0o0xo.f34727IIX0o.add((String) oIX0oI4.get(i3));
            }
        }
        if (jSONObject.has("AppIcon")) {
            x0o0xo.f34768oxoX = NativeAdResponse.b.APP_INSTALL;
            x0o0xo.f34726II0XooXoX = X00IoxXI.Oxx0IOOO(jSONObject, "AppIcon");
            x0o0xo.f34761oOoXoXO = X00IoxXI.Oxx0IOOO(jSONObject, "Action");
            x0o0xo.f34765ooOOo0oXI = X00IoxXI.I0Io(jSONObject, "Star");
            x0o0xo.f34770x0XOIxOo = X00IoxXI.Oxx0IOOO(jSONObject, "Store");
            x0o0xo.f34759oO = X00IoxXI.oxoX(jSONObject, "Price");
        } else {
            x0o0xo.f34768oxoX = NativeAdResponse.b.CONTENT;
            x0o0xo.f34726II0XooXoX = X00IoxXI.Oxx0IOOO(jSONObject, "Logo");
            x0o0xo.f34761oOoXoXO = X00IoxXI.Oxx0IOOO(jSONObject, "Action");
            x0o0xo.f34745XI0IXoo = X00IoxXI.Oxx0IOOO(jSONObject, "Advertiser");
        }
        ArrayList<String> II0XooXoX3 = X00IoxXI.II0XooXoX(X00IoxXI.oIX0oI(jSONObject, "ClickTrackers"));
        if (II0XooXoX3 != null) {
            x0o0xo.f34773xI = II0XooXoX3;
        }
        x0o0xo.f34746XIxXXX0x0 = X00IoxXI.xoIox(X00IoxXI.X0o0xo(jSONObject, TypedValues.Custom.NAME));
        new Handler(Looper.getMainLooper()).postDelayed(x0o0xo.f34769oxxXoxO, com.octopus.ad.internal.xoIox.f19058ooXIXxIX);
        return x0o0xo;
    }

    public void I0() {
        II0xO0.IIXOooo XOxIOxOx2;
        II0xO0.x0XOIxOo x0XOIxOo2;
        x0OxxIOxX.oIX0oI oix0oi = this.f34732IoOoX;
        if (oix0oi != null && (XOxIOxOx2 = oix0oi.XOxIOxOx()) != null && (x0XOIxOo2 = XOxIOxOx2.x0XOIxOo()) != null && x0XOIxOo2.oIX0oI() == 1) {
            xxIO(true);
            new Handler().postDelayed(new x0XOIxOo(), x0XOIxOo2.X0o0xo());
            if (x0XOIxOo2.I0Io() == 1) {
                this.f34758oI0IIXIo = true;
                new Handler().postDelayed(new oO(), x0XOIxOo2.Oxx0IOOO());
            }
        }
    }

    @Override // com.octopus.ad.NativeAdResponse
    public String I0Io() {
        oIX0oI.oxoX oxox = this.f34764oo0xXOI0I;
        if (oxox != null && oxox.oxoX() == oIX0oI.oxoX.f33946I0Io) {
            return this.f34764oo0xXOI0I.I0Io();
        }
        return null;
    }

    public void I0oOIX(String str) {
        this.f34736OOXIXo = str;
    }

    public void I0oOoX(oIX0oI.oxoX oxox) {
        this.f34764oo0xXOI0I = oxox;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public String II0XooXoX() {
        return this.f34736OOXIXo;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public ArrayList<String> II0xO0() {
        return this.f34776xXxxox0I;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public oIX0oI.oxoX IIXOooo() {
        return this.f34763oo;
    }

    public final void IO(ViewGroup viewGroup) {
        x0OxxIOxX.oIX0oI oix0oi;
        II0xO0.ooOOo0oXI oo0xXOI0I2;
        if (viewGroup != null && (oix0oi = this.f34732IoOoX) != null && (oo0xXOI0I2 = oix0oi.oo0xXOI0I()) != null) {
            II0xO0.oI0IIXIo Oxx0IOOO2 = oo0xXOI0I2.Oxx0IOOO();
            this.f34754Xx000oIo = Oxx0IOOO2;
            if (Oxx0IOOO2 != null && Oxx0IOOO2.oIX0oI() == 1) {
                O0Xx(viewGroup);
            }
        }
    }

    @Override // com.octopus.ad.NativeAdResponse
    public ArrayList<String> IXxxXO() {
        return this.f34727IIX0o;
    }

    public void Io(II0xO0.C0895II0xO0 c0895II0xO0) {
        this.f34733O0Xx = c0895II0xO0;
        if (c0895II0xO0 != null) {
            this.f34724I0oOIX = c0895II0xO0.IIXOooo();
        }
    }

    public void IoOoX(int i, String str, String str2) {
        List<II0xO0.xxIXOIIO> XI0IXoo2;
        II0xO0.C0895II0xO0 c0895II0xO0 = this.f34733O0Xx;
        if (c0895II0xO0 != null && (XI0IXoo2 = c0895II0xO0.XI0IXoo()) != null) {
            for (int i2 = 0; i2 < XI0IXoo2.size(); i2++) {
                II0xO0.xxIXOIIO xxixoiio = XI0IXoo2.get(i2);
                if (xxixoiio != null && !TextUtils.isEmpty(xxixoiio.ooOOo0oXI())) {
                    new com.octopus.ad.internal.Oxx0IOOO(OI0.I0Io(xxixoiio.ooOOo0oXI(), i, str, str2)).XO();
                }
            }
        }
    }

    public void Ioxxx(String str) {
        this.f34766ooXIXxIX.add(str);
    }

    public final void O0() {
        this.f34750XX0 = new com.octopus.ad.internal.view.xxIXOIIO(this.f34743X0IIOO, new x0xO0oo());
    }

    public void O00XxXI() {
        x0OxxIOxX.oIX0oI oix0oi;
        II0xO0.IIXOooo XOxIOxOx2;
        II0xO0.x0XOIxOo x0XOIxOo2;
        if (!this.f34741OxxIIOOXO && (oix0oi = this.f34732IoOoX) != null && (XOxIOxOx2 = oix0oi.XOxIOxOx()) != null && (x0XOIxOo2 = XOxIOxOx2.x0XOIxOo()) != null && x0XOIxOo2.oIX0oI() == 1) {
            xoIxX(true);
            new Handler().postDelayed(new oOoXoXO(), x0XOIxOo2.X0o0xo());
            if (x0XOIxOo2.I0Io() == 1) {
                this.f34758oI0IIXIo = true;
                new Handler().postDelayed(new ooOOo0oXI(), x0XOIxOo2.Oxx0IOOO());
            }
        }
    }

    public final void O0Xx(ViewGroup viewGroup) {
        if (this.f34742X00IoxXI == null) {
            IO0XoXxO.xoIox xoiox = new IO0XoXxO.xoIox(viewGroup.getContext());
            this.f34742X00IoxXI = xoiox;
            xoiox.OOXIXo(viewGroup);
            this.f34742X00IoxXI.xoIox(new Oxx0IOOO(viewGroup));
        }
        this.f34742X00IoxXI.o00();
    }

    public int O0xOxO() {
        return this.f34772x0xO0oo;
    }

    public final void OI0(FrameLayout frameLayout) {
        AppCompatTextView appCompatTextView = this.f34760oOXoIIIo;
        if (appCompatTextView != null) {
            I0oOoX.O0xOxO(appCompatTextView);
            frameLayout.addView(this.f34760oOXoIIIo, new FrameLayout.LayoutParams(-1, -2));
        }
    }

    public void OO0x0xX() {
        String str = II0xO0().get(0);
        if (this.f34774xII != null && !TextUtils.isEmpty(str)) {
            try {
                O0IxXx.II0XooXoX II0XooXoX2 = com.octopus.ad.internal.xoIox.oIX0oI().II0XooXoX();
                String oIX0oI2 = II0XooXoX2.oIX0oI(str);
                if (II0XooXoX2.ooOOo0oXI(str)) {
                    this.f34774xII.setVideoPath(oIX0oI2);
                } else {
                    this.f34774xII.setVideoPath(str);
                }
            } catch (Exception unused) {
                xXoOI00O.oIX0oI oix0oi = this.f34775xXOx;
                if (oix0oi != null) {
                    oix0oi.onAdRenderFailed(oOoIIO0.I0Io.f32018oOoXoXO);
                }
            }
        }
    }

    @Override // com.octopus.ad.NativeAdResponse
    public oIX0oI.oxoX OOXIXo() {
        return this.f34764oo0xXOI0I;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public List<? extends View> Oo() {
        return this.f34725I0oOoX;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public void OxI(ViewGroup viewGroup, int i, float f) {
        if (viewGroup == null) {
            return;
        }
        viewGroup.post(new II0XooXoX(viewGroup, i, f));
    }

    @Override // com.octopus.ad.NativeAdResponse
    public View Oxx0IOOO(Context context, int i) {
        float f;
        if (this.f34724I0oOIX != null) {
            float oI0IIXIo2 = I0oOoX.oI0IIXIo(context);
            if (oI0IIXIo2 > 0.0f && i > 0) {
                float f2 = i;
                if (oI0IIXIo2 > f2) {
                    f = f2 / oI0IIXIo2;
                    return I0oOoX.XO(context, this.f34724I0oOIX, f, true);
                }
            }
            f = 1.0f;
            return I0oOoX.XO(context, this.f34724I0oOIX, f, true);
        }
        return null;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public String Oxx0xo() {
        return this.f34745XI0IXoo;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public void OxxIIOOXO(ViewGroup viewGroup, xXoOI00O.oIX0oI oix0oi) {
        this.f34775xXOx = oix0oi;
        IO(viewGroup);
        int i = this.f34757o00;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        x0o(viewGroup, R.layout.oct_native_one_img, 1.78f);
                        return;
                    } else {
                        x0o(viewGroup, R.layout.oct_native_text_left_img, 4.74f);
                        return;
                    }
                }
                x0o(viewGroup, R.layout.oct_native_text_right_img, 4.74f);
                return;
            }
            x0o(viewGroup, R.layout.oct_native_text_below_img, 1.4f);
            return;
        }
        x0o(viewGroup, R.layout.oct_native_text_above_img, 1.4f);
    }

    public final void X00IoxXI(View view, xXoOI00O.II0xO0 iI0xO0) {
        if (!this.f34781xxX && view != null) {
            com.octopus.ad.internal.oO oOVar = this.f34762oX;
            if (oOVar != null) {
                oOVar.xoIox();
            }
            Object tag = view.getTag(55665918);
            if (tag instanceof com.octopus.ad.internal.oO) {
                ((com.octopus.ad.internal.oO) tag).xoIox();
            }
            com.octopus.ad.internal.oO II0xO02 = com.octopus.ad.internal.oO.II0xO0(view);
            this.f34762oX = II0xO02;
            view.setTag(55665918, II0xO02);
            if (this.f34762oX == null) {
                return;
            }
            x0OxxIOxX.oIX0oI oix0oi = this.f34732IoOoX;
            if (oix0oi != null) {
                oix0oi.o0xxxXXxX();
            }
            com.octopus.ad.internal.XO.II0xO0(view, null);
            this.f34751Xo0 = new ArrayList<>();
            Iterator<String> it = this.f34766ooXIXxIX.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next.contains("?rv=1")) {
                    I0oOoX.xoXoI(next);
                } else {
                    if (!this.f34732IoOoX.O0Xx()) {
                        next = next + "&opt=11";
                    }
                    com.octopus.ad.internal.xxIXOIIO xoIox2 = com.octopus.ad.internal.xxIXOIIO.xoIox(this.f34752XoI0Ixx0, next, this.f34762oX, view.getContext(), this.f34766ooXIXxIX);
                    if (xoIox2 != null && next.startsWith("http://v.adintl.cn/imp")) {
                        xoIox2.OOXIXo(new xoIox(iI0xO0));
                    }
                    if (xoIox2 != null) {
                        this.f34751Xo0.add(xoIox2);
                    }
                }
            }
            this.f34753XoX = view;
            new Handler(Looper.getMainLooper()).removeCallbacks(this.f34769oxxXoxO);
            x0OxxIOxX.oIX0oI oix0oi2 = this.f34732IoOoX;
            if (oix0oi2 != null && !this.f34779xoXoI) {
                this.f34779xoXoI = true;
                AdViewImpl.oI(oix0oi2, new OOXIXo());
                boolean XX0xXo2 = AdViewImpl.XX0xXo(this.f34732IoOoX);
                this.f34734O0xOxO = XX0xXo2;
                if (!XX0xXo2) {
                    this.f34738OxI = 8;
                }
            }
        }
    }

    @Override // com.octopus.ad.NativeAdResponse
    @NonNull
    public Bitmap X0o0xo(@NonNull Context context) {
        return BitmapFactory.decodeResource(context.getResources(), R.drawable.oct_logo);
    }

    public void XI0oooXX(boolean z) {
        x0OxxIOxX.oIX0oI oix0oi = this.f34732IoOoX;
        if (oix0oi != null) {
            oix0oi.XI0oooXX(z);
        }
    }

    public final void XIo0oOXIx(ViewGroup viewGroup) {
        View view;
        if (viewGroup != null && (view = this.f34729IO) != null) {
            I0oOoX.O0xOxO(view);
            if (viewGroup instanceof RelativeLayout) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(13, -1);
                viewGroup.addView(this.f34729IO, layoutParams);
                return;
            }
            viewGroup.addView(this.f34729IO);
        }
    }

    @Override // com.octopus.ad.NativeAdResponse
    public NativeAdResponse.a XO() {
        return NativeAdResponse.a.OCTOPUS;
    }

    public void XOxIOxOx(ViewGroup viewGroup, View view, FrameLayout frameLayout) {
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        OI0(frameLayout);
        Xx000oIo(viewGroup, this.f34767oxXx0IX, this.f34777xo0x);
        X00IoxXI(viewGroup, new XO());
    }

    public final void XX(ArrayList<View> arrayList, float f) {
        View next;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<View> it = arrayList.iterator();
            while (it.hasNext() && (next = it.next()) != null) {
                if (next instanceof TextView) {
                    TextView textView = (TextView) next;
                    textView.setTextSize(0, textView.getTextSize() * f);
                } else {
                    next.post(new I0Io(next, f));
                }
            }
        }
    }

    public void XoI0Ixx0(int i) {
        List<II0xO0.xxIXOIIO> XI0IXoo2;
        II0xO0.C0895II0xO0 c0895II0xO0 = this.f34733O0Xx;
        if (c0895II0xO0 != null && (XI0IXoo2 = c0895II0xO0.XI0IXoo()) != null) {
            for (int i2 = 0; i2 < XI0IXoo2.size(); i2++) {
                II0xO0.xxIXOIIO xxixoiio = XI0IXoo2.get(i2);
                if (xxixoiio != null && !TextUtils.isEmpty(xxixoiio.OOXIXo())) {
                    new com.octopus.ad.internal.Oxx0IOOO(OI0.Oxx0IOOO(xxixoiio.OOXIXo(), i)).XO();
                }
            }
        }
    }

    public final void Xx000oIo(View view, List<View> list, List<View> list2) {
        this.f34743X0IIOO = AdViewImpl.IIxOXoOo0(this.f34732IoOoX);
        O0();
        xI0oxI00();
        if (list != null && !list.isEmpty()) {
            view.setOnClickListener(null);
            Iterator<View> it = list.iterator();
            while (it.hasNext()) {
                it.next().setOnTouchListener(this.f34750XX0);
            }
        }
        if (list2 != null && !list2.isEmpty()) {
            view.setOnClickListener(null);
            Iterator<View> it2 = list2.iterator();
            while (it2.hasNext()) {
                it2.next().setOnClickListener(this.f34723I0X0x0oIo);
            }
        }
        this.f34767oxXx0IX = list;
        this.f34777xo0x = list2;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public void destroy() {
        this.f34730IXxxXO = true;
        IO0XoXxO.xoIox xoiox = this.f34742X00IoxXI;
        if (xoiox != null) {
            xoiox.Oo();
            this.f34742X00IoxXI = null;
        }
        Handler handler = new Handler(Looper.getMainLooper());
        handler.removeCallbacks(this.f34769oxxXoxO);
        handler.post(this.f34769oxxXoxO);
    }

    @Override // com.octopus.ad.NativeAdResponse
    public String getButtonText() {
        if (TextUtils.isEmpty(this.f34761oOoXoXO)) {
            return "查看详情";
        }
        return this.f34761oOoXoXO;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public X0xII0I.oIX0oI getComplianceInfo() {
        return this.f34724I0oOIX;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public String getDescription() {
        return this.f34747XO;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public Bitmap getIcon() {
        return this.f34778xoIox;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public String getIconUrl() {
        return this.f34726II0XooXoX;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public Bitmap getImage() {
        return this.f34780xxIXOIIO;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public String getImageUrl() {
        return this.f34739Oxx0IOOO;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public ArrayList<String> getImageUrls() {
        return this.f34755XxX0x0xxx;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public int getInteractionType() {
        II0xO0.C0895II0xO0 c0895II0xO0 = this.f34733O0Xx;
        if (c0895II0xO0 != null) {
            return c0895II0xO0.oOoXoXO();
        }
        return 4;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public String getLogoUrl() {
        oIX0oI.oxoX oxox = this.f34763oo;
        if (oxox != null && oxox.oxoX() == oIX0oI.oxoX.f33946I0Io) {
            return this.f34763oo.I0Io();
        }
        return null;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public int getMaterialType() {
        if (isVideo()) {
            return 2;
        }
        return 1;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public int getPictureHeight() {
        x0OxxIOxX.oIX0oI oix0oi = this.f34732IoOoX;
        if (oix0oi != null) {
            return oix0oi.xI();
        }
        return 0;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public int getPictureWidth() {
        x0OxxIOxX.oIX0oI oix0oi = this.f34732IoOoX;
        if (oix0oi != null) {
            return oix0oi.oxxXoxO();
        }
        return 0;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public int getPrice() {
        return this.f34759oO;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public double getStarRating() {
        return this.f34765ooOOo0oXI;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public String getTitle() {
        return this.f34744X0o0xo;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public boolean isVideo() {
        return this.f34756o0;
    }

    public void o0(String str) {
        this.f34752XoI0Ixx0 = str;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public HashMap<String, Object> o00() {
        return this.f34746XIxXXX0x0;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public String oI0IIXIo() {
        return this.f34770x0XOIxOo;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public void oIX0oI(ViewGroup viewGroup, List<View> list, xXoOI00O.oIX0oI oix0oi) {
        x0xO0oo(viewGroup, list, null, oix0oi);
    }

    @Override // com.octopus.ad.NativeAdResponse
    public void oO(Bitmap bitmap) {
        this.f34780xxIXOIIO = bitmap;
    }

    public final void oOXoIIIo(View view) {
        xXoOI00O.oIX0oI oix0oi;
        if (!this.f34735OI0 && !this.f34737Oo && !this.f34741OxxIIOOXO) {
            return;
        }
        if (System.currentTimeMillis() - IO0XoXxO.xoIox.f420XI0IXoo > ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS) {
            this.f34740Oxx0xo = true;
            if (this.f34749XX && (oix0oi = this.f34775xXOx) != null && this.f34734O0xOxO && !this.f34758oI0IIXIo && !this.f34743X0IIOO) {
                oix0oi.onAdClick();
            }
            x0OxxIOxX.oIX0oI oix0oi2 = this.f34732IoOoX;
            if (oix0oi2 != null) {
                oix0oi2.oI0IIXIo(view, this.f34738OxI, this.f34737Oo, this.f34741OxxIIOOXO);
            }
            IO0XoXxO.xoIox.f420XI0IXoo = System.currentTimeMillis();
            return;
        }
        this.f34758oI0IIXIo = false;
        this.f34734O0xOxO = true;
        this.f34738OxI = 0;
    }

    public final void oOo() {
        VideoView videoView = this.f34774xII;
        if (videoView == null) {
            return;
        }
        videoView.setOnPreparedListener(new oxoX());
        this.f34774xII.getHolder().addCallback(new SurfaceHolderCallbackC1166X0o0xo());
        OO0x0xX();
    }

    @Override // com.octopus.ad.NativeAdResponse
    public NativeAdResponse.b oOoXoXO() {
        return this.f34768oxoX;
    }

    public String oX() {
        x0OxxIOxX.oIX0oI oix0oi = this.f34732IoOoX;
        if (oix0oi != null) {
            return oix0oi.xxX();
        }
        return "";
    }

    public boolean oXIO0o0XI() {
        return this.f34741OxxIIOOXO;
    }

    public void oo(int i) {
        this.f34772x0xO0oo = i;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public void ooOOo0oXI(List<? extends View> list) {
        this.f34725I0oOoX = list;
    }

    public final void ooOx(boolean z) {
        xXoOI00O.oIX0oI oix0oi;
        x0OxxIOxX.oIX0oI oix0oi2;
        if (!this.f34735OI0) {
            this.f34735OI0 = true;
            this.f34749XX = z;
            if (z && (oix0oi2 = this.f34732IoOoX) != null) {
                this.f34749XX = oix0oi2.O0Xx();
            }
            if (this.f34749XX && (oix0oi = this.f34775xXOx) != null) {
                oix0oi.onADExposed();
            }
        }
    }

    public void ox(String str) {
        this.f34773xI.add(str);
    }

    @Override // com.octopus.ad.NativeAdResponse
    public void oxoX() {
        View view = this.f34753XoX;
        if (view != null) {
            view.setOnClickListener(null);
        }
        List<View> list = this.f34767oxXx0IX;
        if (list != null && !list.isEmpty()) {
            Iterator<View> it = this.f34767oxXx0IX.iterator();
            while (it.hasNext()) {
                it.next().setOnClickListener(null);
            }
        }
        List<View> list2 = this.f34777xo0x;
        if (list2 != null && !list2.isEmpty()) {
            Iterator<View> it2 = this.f34777xo0x.iterator();
            while (it2.hasNext()) {
                it2.next().setOnClickListener(null);
            }
        }
        destroy();
    }

    public void oxxXoxO(x0OxxIOxX.oIX0oI oix0oi) {
        this.f34732IoOoX = oix0oi;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public void setIcon(Bitmap bitmap) {
        this.f34778xoIox = bitmap;
    }

    @Override // com.octopus.ad.NativeAdResponse
    @NonNull
    public Bitmap x0XOIxOo(@NonNull Context context) {
        return BitmapFactory.decodeResource(context.getResources(), R.drawable.oct_logo_text);
    }

    public final void x0o(ViewGroup viewGroup, int i, float f) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i, (ViewGroup) null);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.fl_container);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.ad_image);
        FrameLayout frameLayout2 = (FrameLayout) inflate.findViewById(R.id.ad_compliance);
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.ad_logo);
        ImageView imageView3 = (ImageView) inflate.findViewById(R.id.ad_logo_text);
        ImageView imageView4 = (ImageView) inflate.findViewById(R.id.ad_close);
        TextView textView = (TextView) inflate.findViewById(R.id.ad_title);
        TextView textView2 = (TextView) inflate.findViewById(R.id.ad_action);
        this.f34774xII = (VideoView) inflate.findViewById(R.id.ad_video);
        this.f34771x0o = (ProgressBar) inflate.findViewById(R.id.ad_loading);
        if (!TextUtils.isEmpty(getTitle())) {
            textView.setText(getTitle());
        }
        if (!TextUtils.isEmpty(getButtonText())) {
            textView2.setText(getButtonText());
        }
        if (!TextUtils.isEmpty(getLogoUrl())) {
            oOXoIIIo.II0XooXoX(null).Oxx0IOOO(getLogoUrl()).I0Io(imageView2);
        }
        if (!TextUtils.isEmpty(I0Io())) {
            oOXoIIIo.II0XooXoX(null).Oxx0IOOO(I0Io()).I0Io(imageView3);
        }
        ArrayList arrayList = new ArrayList();
        this.f34767oxXx0IX = arrayList;
        arrayList.add(inflate);
        if (this.f34728IIXOooo) {
            imageView4.setVisibility(0);
            ArrayList arrayList2 = new ArrayList();
            this.f34777xo0x = arrayList2;
            arrayList2.add(imageView4);
        } else {
            imageView4.setVisibility(8);
        }
        viewGroup.post(new II0xO0(viewGroup, f, imageView2, imageView3, textView, imageView4, textView2, frameLayout, imageView, inflate, frameLayout2));
    }

    @Override // com.octopus.ad.NativeAdResponse
    public void x0xO0oo(ViewGroup viewGroup, List<View> list, List<View> list2, xXoOI00O.oIX0oI oix0oi) {
        try {
            this.f34775xXOx = oix0oi;
            if (viewGroup != null) {
                Xx000oIo(viewGroup, list, list2);
                X00IoxXI(viewGroup, new oIX0oI());
                IO(viewGroup);
            } else if (oix0oi != null) {
                oix0oi.onAdRenderFailed(oOoIIO0.I0Io.f32015Oxx0IOOO);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            xXoOI00O.oIX0oI oix0oi2 = this.f34775xXOx;
            if (oix0oi2 != null) {
                oix0oi2.onAdRenderFailed(oOoIIO0.I0Io.f32015Oxx0IOOO);
            }
        }
    }

    public final void xI0oxI00() {
        this.f34723I0X0x0oIo = new IXxxXO();
    }

    public final void xII(ViewGroup viewGroup, double d, double d2, String str, boolean z, boolean z2, int i, float f) {
        String str2;
        if (viewGroup == null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(str)) {
                str2 = "摇动或点击了解更多";
            } else {
                str2 = str;
            }
            if (this.f34742X00IoxXI == null) {
                O0Xx(viewGroup);
            }
            int OxI2 = I0oOoX.OxI(viewGroup.getContext(), viewGroup.getWidth());
            int OxI3 = I0oOoX.OxI(viewGroup.getContext(), viewGroup.getHeight());
            this.f34742X00IoxXI.oOoXoXO("50%", "50%", i + "", i + "");
            this.f34742X00IoxXI.Oxx0IOOO(d, d2);
            View oxoX2 = this.f34742X00IoxXI.oxoX(OxI2, OxI3, f, str2, true, this.f34731Io);
            this.f34729IO = oxoX2;
            if (oxoX2 != null) {
                if (z2) {
                    this.f34738OxI = 7;
                }
                if (z) {
                    XIo0oOXIx(viewGroup);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void xOoOIoI() {
        Iterator<String> it = this.f34766ooXIXxIX.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (next.contains("?rv=1")) {
                I0oOoX.xoXoI(next);
            } else {
                if (this.f34737Oo) {
                    next = next + "&opt=10";
                } else if (this.f34741OxxIIOOXO) {
                    next = next + "&opt=1";
                }
                new com.octopus.ad.internal.Oxx0IOOO(next).XO();
            }
        }
    }

    public void xX0IIXIx0() {
        II0xO0.IIXOooo XOxIOxOx2;
        II0xO0.oO oIX0oI2;
        x0OxxIOxX.oIX0oI oix0oi = this.f34732IoOoX;
        if (oix0oi != null && (XOxIOxOx2 = oix0oi.XOxIOxOx()) != null && (oIX0oI2 = XOxIOxOx2.oIX0oI()) != null) {
            boolean z = true;
            if (oIX0oI2.oIX0oI() != 1) {
                z = false;
            }
            this.f34748XOxIOxOx = z;
        }
    }

    public void xo0x(boolean z) {
        this.f34756o0 = z;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public View xoIox(Context context) {
        X0xII0I.oIX0oI oix0oi = this.f34724I0oOIX;
        if (oix0oi != null) {
            return I0oOoX.XO(context, oix0oi, 1.0f, true);
        }
        return null;
    }

    public void xoIxX(boolean z) {
        this.f34741OxxIIOOXO = z;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public boolean xoXoI() {
        return this.f34781xxX;
    }

    public void xoxXI(oIX0oI.oxoX oxox) {
        this.f34763oo = oxox;
    }

    public void xxIO(boolean z) {
        this.f34737Oo = z;
    }

    @Override // com.octopus.ad.NativeAdResponse
    public View xxIXOIIO(Context context) {
        if (context != null && isVideo() && II0xO0().size() > 0) {
            if (this.f34774xII == null) {
                this.f34774xII = new VideoView(context);
                oOo();
            }
            return this.f34774xII;
        }
        return null;
    }

    /* renamed from: xXoOI00O.X0o0xo$X0o0xo, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class SurfaceHolderCallbackC1166X0o0xo implements SurfaceHolder.Callback {
        public SurfaceHolderCallbackC1166X0o0xo() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
            if (X0o0xo.this.f34774xII != null && !X0o0xo.this.f34774xII.isPlaying()) {
                X0o0xo.this.f34774xII.start();
                if (X0o0xo.this.f34771x0o != null) {
                    X0o0xo.this.f34771x0o.setVisibility(0);
                }
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        }
    }
}
