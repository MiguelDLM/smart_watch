package oO;

import IIXOooo.XO;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.Nullable;
import com.airbnb.lottie.I0Io;
import java.util.HashMap;
import java.util.Map;
import x0xO0oo.II0XooXoX;

/* loaded from: classes.dex */
public class oI0IIXIo {

    /* renamed from: X0o0xo, reason: collision with root package name */
    @Nullable
    public I0Io f31836X0o0xo;

    /* renamed from: oxoX, reason: collision with root package name */
    public final AssetManager f31839oxoX;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final II0XooXoX<String> f31838oIX0oI = new II0XooXoX<>();

    /* renamed from: II0xO0, reason: collision with root package name */
    public final Map<II0XooXoX<String>, Typeface> f31835II0xO0 = new HashMap();

    /* renamed from: I0Io, reason: collision with root package name */
    public final Map<String, Typeface> f31834I0Io = new HashMap();

    /* renamed from: XO, reason: collision with root package name */
    public String f31837XO = ".ttf";

    public oI0IIXIo(Drawable.Callback callback, @Nullable I0Io i0Io) {
        this.f31836X0o0xo = i0Io;
        if (!(callback instanceof View)) {
            XO.X0o0xo("LottieDrawable must be inside of a view for images to work.");
            this.f31839oxoX = null;
        } else {
            this.f31839oxoX = ((View) callback).getContext().getAssets();
        }
    }

    public void I0Io(String str) {
        this.f31837XO = str;
    }

    public Typeface II0xO0(String str, String str2) {
        this.f31838oIX0oI.II0xO0(str, str2);
        Typeface typeface = this.f31835II0xO0.get(this.f31838oIX0oI);
        if (typeface != null) {
            return typeface;
        }
        Typeface X0o0xo2 = X0o0xo(oIX0oI(str), str2);
        this.f31835II0xO0.put(this.f31838oIX0oI, X0o0xo2);
        return X0o0xo2;
    }

    public final Typeface X0o0xo(Typeface typeface, String str) {
        int i;
        boolean contains = str.contains("Italic");
        boolean contains2 = str.contains("Bold");
        if (contains && contains2) {
            i = 3;
        } else if (contains) {
            i = 2;
        } else if (contains2) {
            i = 1;
        } else {
            i = 0;
        }
        if (typeface.getStyle() == i) {
            return typeface;
        }
        return Typeface.create(typeface, i);
    }

    public final Typeface oIX0oI(String str) {
        Typeface typeface;
        String II0xO02;
        Typeface typeface2 = this.f31834I0Io.get(str);
        if (typeface2 != null) {
            return typeface2;
        }
        I0Io i0Io = this.f31836X0o0xo;
        if (i0Io != null) {
            typeface = i0Io.oIX0oI(str);
        } else {
            typeface = null;
        }
        I0Io i0Io2 = this.f31836X0o0xo;
        if (i0Io2 != null && typeface == null && (II0xO02 = i0Io2.II0xO0(str)) != null) {
            typeface = Typeface.createFromAsset(this.f31839oxoX, II0xO02);
        }
        if (typeface == null) {
            typeface = Typeface.createFromAsset(this.f31839oxoX, "fonts/" + str + this.f31837XO);
        }
        this.f31834I0Io.put(str, typeface);
        return typeface;
    }

    public void oxoX(@Nullable I0Io i0Io) {
        this.f31836X0o0xo = i0Io;
    }
}
