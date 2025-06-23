package IO0XoXxO;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.octopus.ad.widget.RegionClickView;

/* loaded from: classes11.dex */
public class II0XooXoX {

    /* renamed from: I0Io, reason: collision with root package name */
    public static String f385I0Io;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static String f386X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public static String f387XO;

    /* renamed from: oxoX, reason: collision with root package name */
    public static String f388oxoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public I0Io f389II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public Context f390oIX0oI;

    /* loaded from: classes11.dex */
    public interface I0Io {
        void oIX0oI(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8);
    }

    /* loaded from: classes11.dex */
    public class II0xO0 implements View.OnTouchListener {
        public II0xO0() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            try {
                if (motionEvent.getAction() == 0) {
                    String unused = II0XooXoX.f385I0Io = motionEvent.getX() + "";
                    String unused2 = II0XooXoX.f388oxoX = motionEvent.getY() + "";
                    String unused3 = II0XooXoX.f386X0o0xo = motionEvent.getRawX() + "";
                    String unused4 = II0XooXoX.f387XO = motionEvent.getRawY() + "";
                    return false;
                }
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    /* loaded from: classes11.dex */
    public class oIX0oI implements View.OnClickListener {
        public oIX0oI() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (II0XooXoX.this.f389II0xO0 != null) {
                II0XooXoX.this.f389II0xO0.oIX0oI(II0XooXoX.f385I0Io, II0XooXoX.f388oxoX, II0XooXoX.f386X0o0xo, II0XooXoX.f387XO, II0XooXoX.f385I0Io, II0XooXoX.f388oxoX, II0XooXoX.f386X0o0xo, II0XooXoX.f387XO);
            }
        }
    }

    public II0XooXoX(Context context) {
        this.f390oIX0oI = context;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00d9, code lost:
    
        if (r0 >= 400) goto L35;
     */
    @androidx.annotation.NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.ViewGroup.MarginLayoutParams I0Io(int r12, int r13, float r14) {
        /*
            Method dump skipped, instructions count: 366
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: IO0XoXxO.II0XooXoX.I0Io(int, int, float):android.view.ViewGroup$MarginLayoutParams");
    }

    public View II0xO0(int i, int i2, String str, boolean z) {
        if (this.f390oIX0oI == null) {
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            str = "点击跳转至第三方应用或详情页";
        }
        o0IXXIx.II0XooXoX.I0Io("OctopusAd", "adWidthDp = " + i + ",adHeightDp = " + i2);
        float f = ((float) i) / 360.0f;
        RegionClickView regionClickView = new RegionClickView(this.f390oIX0oI);
        regionClickView.I0Io(str, f);
        regionClickView.setLayoutParams(I0Io(i, i2, f));
        if (z) {
            regionClickView.setOnClickListener(new oIX0oI());
            regionClickView.setOnTouchListener(new II0xO0());
        }
        return regionClickView;
    }

    public void X0o0xo() {
        this.f390oIX0oI = null;
        this.f389II0xO0 = null;
    }

    public void XO(I0Io i0Io) {
        this.f389II0xO0 = i0Io;
    }
}
