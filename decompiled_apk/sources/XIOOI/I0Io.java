package XIOOI;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.util.Linkify;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

/* loaded from: classes6.dex */
public class I0Io {

    /* renamed from: I0Io, reason: collision with root package name */
    public View f3732I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f3733II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public int f3734X0o0xo;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public SparseArray<View> f3735oIX0oI = new SparseArray<>();

    /* renamed from: oxoX, reason: collision with root package name */
    public Context f3736oxoX;

    public I0Io(Context context, View view, ViewGroup viewGroup, int i) {
        this.f3736oxoX = context;
        this.f3732I0Io = view;
        this.f3733II0xO0 = i;
        this.f3732I0Io.setTag(this);
    }

    public static I0Io oIX0oI(Context context, View view, ViewGroup viewGroup, int i, int i2) {
        if (view == null) {
            I0Io i0Io = new I0Io(context, LayoutInflater.from(context).inflate(i, viewGroup, false), viewGroup, i2);
            i0Io.f3734X0o0xo = i;
            return i0Io;
        }
        I0Io i0Io2 = (I0Io) view.getTag();
        i0Io2.f3733II0xO0 = i2;
        return i0Io2;
    }

    public int I0Io() {
        return this.f3733II0xO0;
    }

    public I0Io II0XooXoX(int i, int i2) {
        X0o0xo(i).setBackgroundColor(i2);
        return this;
    }

    public View II0xO0() {
        return this.f3732I0Io;
    }

    public I0Io IIXOooo(int i, int i2, Object obj) {
        X0o0xo(i).setTag(i2, obj);
        return this;
    }

    public I0Io IXxxXO(int i, int i2) {
        ((ProgressBar) X0o0xo(i)).setProgress(i2);
        return this;
    }

    public I0Io O0xOxO(int i, int i2) {
        ((TextView) X0o0xo(i)).setTextColor(this.f3736oxoX.getResources().getColor(i2));
        return this;
    }

    public I0Io OOXIXo(int i, Bitmap bitmap) {
        ((ImageView) X0o0xo(i)).setImageBitmap(bitmap);
        return this;
    }

    public I0Io Oo(int i, View.OnTouchListener onTouchListener) {
        X0o0xo(i).setOnTouchListener(onTouchListener);
        return this;
    }

    public I0Io OxI(int i, int i2) {
        ((TextView) X0o0xo(i)).setTextColor(i2);
        return this;
    }

    @SuppressLint({"NewApi"})
    public I0Io Oxx0IOOO(int i, float f) {
        X0o0xo(i).setAlpha(f);
        return this;
    }

    public I0Io Oxx0xo(int i, int i2, int i3) {
        ProgressBar progressBar = (ProgressBar) X0o0xo(i);
        progressBar.setMax(i3);
        progressBar.setProgress(i2);
        return this;
    }

    public I0Io OxxIIOOXO(int i, float f, int i2) {
        RatingBar ratingBar = (RatingBar) X0o0xo(i);
        ratingBar.setMax(i2);
        ratingBar.setRating(f);
        return this;
    }

    public I0Io X0IIOO(Typeface typeface, int... iArr) {
        for (int i : iArr) {
            TextView textView = (TextView) X0o0xo(i);
            textView.setTypeface(typeface);
            textView.setPaintFlags(textView.getPaintFlags() | 128);
        }
        return this;
    }

    public <T extends View> T X0o0xo(int i) {
        T t = (T) this.f3735oIX0oI.get(i);
        if (t == null) {
            T t2 = (T) this.f3732I0Io.findViewById(i);
            this.f3735oIX0oI.put(i, t2);
            return t2;
        }
        return t;
    }

    public I0Io XI0IXoo(int i, boolean z) {
        int i2;
        View X0o0xo2 = X0o0xo(i);
        if (z) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        X0o0xo2.setVisibility(i2);
        return this;
    }

    public void XIxXXX0x0(int i) {
        this.f3733II0xO0 = i;
    }

    public I0Io XO(int i) {
        Linkify.addLinks((TextView) X0o0xo(i), 15);
        return this;
    }

    public I0Io o00(int i, String str) {
        ((TextView) X0o0xo(i)).setText(str);
        return this;
    }

    public I0Io oI0IIXIo(int i, float f) {
        ((RatingBar) X0o0xo(i)).setRating(f);
        return this;
    }

    public I0Io oO(int i, View.OnClickListener onClickListener) {
        X0o0xo(i).setOnClickListener(onClickListener);
        return this;
    }

    public I0Io oOoXoXO(int i, Drawable drawable) {
        ((ImageView) X0o0xo(i)).setImageDrawable(drawable);
        return this;
    }

    public I0Io ooOOo0oXI(int i, int i2) {
        ((ImageView) X0o0xo(i)).setImageResource(i2);
        return this;
    }

    public int oxoX() {
        return this.f3734X0o0xo;
    }

    public I0Io x0XOIxOo(int i, int i2) {
        ((ProgressBar) X0o0xo(i)).setMax(i2);
        return this;
    }

    public I0Io x0xO0oo(int i, View.OnLongClickListener onLongClickListener) {
        X0o0xo(i).setOnLongClickListener(onLongClickListener);
        return this;
    }

    public I0Io xoIox(int i, boolean z) {
        ((Checkable) X0o0xo(i)).setChecked(z);
        return this;
    }

    public I0Io xoXoI(int i, Object obj) {
        X0o0xo(i).setTag(obj);
        return this;
    }

    public I0Io xxIXOIIO(int i, int i2) {
        X0o0xo(i).setBackgroundResource(i2);
        return this;
    }
}
