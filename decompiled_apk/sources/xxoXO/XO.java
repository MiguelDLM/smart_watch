package xxoXO;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.SeekBar;
import skin.support.appcompat.R;

/* loaded from: classes6.dex */
public class XO extends X0o0xo {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public final SeekBar f35542II0XooXoX;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public int f35543xxIXOIIO;

    public XO(SeekBar seekBar) {
        super(seekBar);
        this.f35543xxIXOIIO = 0;
        this.f35542II0XooXoX = seekBar;
    }

    @Override // xxoXO.X0o0xo
    public void X0o0xo(AttributeSet attributeSet, int i) {
        super.X0o0xo(attributeSet, i);
        TypedArray obtainStyledAttributes = this.f35542II0XooXoX.getContext().obtainStyledAttributes(attributeSet, R.styleable.AppCompatSeekBar, i, 0);
        this.f35543xxIXOIIO = obtainStyledAttributes.getResourceId(R.styleable.AppCompatSeekBar_android_thumb, 0);
        obtainStyledAttributes.recycle();
        oIX0oI();
    }

    @Override // xxoXO.X0o0xo, xxoXO.I0Io
    public void oIX0oI() {
        super.oIX0oI();
        int II0xO02 = I0Io.II0xO0(this.f35543xxIXOIIO);
        this.f35543xxIXOIIO = II0xO02;
        if (II0xO02 != 0) {
            SeekBar seekBar = this.f35542II0XooXoX;
            seekBar.setThumb(oIxOXo.II0XooXoX.oIX0oI(seekBar.getContext(), this.f35543xxIXOIIO));
        }
    }
}
