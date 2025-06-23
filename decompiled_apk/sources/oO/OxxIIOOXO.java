package oO;

import IIXOooo.XO;
import IIXOooo.xoIox;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import androidx.annotation.Nullable;
import com.airbnb.lottie.OOXIXo;
import com.airbnb.lottie.oxoX;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class OxxIIOOXO {

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final Object f31829X0o0xo = new Object();

    /* renamed from: I0Io, reason: collision with root package name */
    @Nullable
    public oxoX f31830I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public String f31831II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final Context f31832oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public final Map<String, OOXIXo> f31833oxoX;

    public OxxIIOOXO(Drawable.Callback callback, String str, oxoX oxox, Map<String, OOXIXo> map) {
        this.f31831II0xO0 = str;
        if (!TextUtils.isEmpty(str)) {
            if (this.f31831II0xO0.charAt(r4.length() - 1) != '/') {
                this.f31831II0xO0 += IOUtils.DIR_SEPARATOR_UNIX;
            }
        }
        if (!(callback instanceof View)) {
            XO.X0o0xo("LottieDrawable must be inside of a view for images to work.");
            this.f31833oxoX = new HashMap();
            this.f31832oIX0oI = null;
        } else {
            this.f31832oIX0oI = ((View) callback).getContext();
            this.f31833oxoX = map;
            oxoX(oxox);
        }
    }

    public final Bitmap I0Io(String str, @Nullable Bitmap bitmap) {
        synchronized (f31829X0o0xo) {
            this.f31833oxoX.get(str).II0XooXoX(bitmap);
        }
        return bitmap;
    }

    public boolean II0xO0(Context context) {
        if ((context == null && this.f31832oIX0oI == null) || this.f31832oIX0oI.equals(context)) {
            return true;
        }
        return false;
    }

    @Nullable
    public Bitmap X0o0xo(String str, @Nullable Bitmap bitmap) {
        if (bitmap == null) {
            OOXIXo oOXIXo = this.f31833oxoX.get(str);
            Bitmap oIX0oI2 = oOXIXo.oIX0oI();
            oOXIXo.II0XooXoX(null);
            return oIX0oI2;
        }
        Bitmap oIX0oI3 = this.f31833oxoX.get(str).oIX0oI();
        I0Io(str, bitmap);
        return oIX0oI3;
    }

    @Nullable
    public Bitmap oIX0oI(String str) {
        OOXIXo oOXIXo = this.f31833oxoX.get(str);
        if (oOXIXo == null) {
            return null;
        }
        Bitmap oIX0oI2 = oOXIXo.oIX0oI();
        if (oIX0oI2 != null) {
            return oIX0oI2;
        }
        oxoX oxox = this.f31830I0Io;
        if (oxox != null) {
            Bitmap oIX0oI3 = oxox.oIX0oI(oOXIXo);
            if (oIX0oI3 != null) {
                I0Io(str, oIX0oI3);
            }
            return oIX0oI3;
        }
        String I0Io2 = oOXIXo.I0Io();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (I0Io2.startsWith("data:") && I0Io2.indexOf("base64,") > 0) {
            try {
                byte[] decode = Base64.decode(I0Io2.substring(I0Io2.indexOf(44) + 1), 0);
                return I0Io(str, BitmapFactory.decodeByteArray(decode, 0, decode.length, options));
            } catch (IllegalArgumentException e) {
                XO.XO("data URL did not have correct base64 format.", e);
                return null;
            }
        }
        try {
            if (!TextUtils.isEmpty(this.f31831II0xO0)) {
                return I0Io(str, xoIox.ooOOo0oXI(BitmapFactory.decodeStream(this.f31832oIX0oI.getAssets().open(this.f31831II0xO0 + I0Io2), null, options), oOXIXo.XO(), oOXIXo.oxoX()));
            }
            throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
        } catch (IOException e2) {
            XO.XO("Unable to open asset.", e2);
            return null;
        }
    }

    public void oxoX(@Nullable oxoX oxox) {
        this.f31830I0Io = oxox;
    }
}
