package oo00;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.ImageUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.blankj.utilcode.util.Utils;
import com.google.gson.Gson;
import com.jieli.eq.EQPlotCore;
import com.jieli.jl_rcsp.model.device.EqInfo;
import com.jieli.jl_rcsp.model.device.EqPresetInfo;
import com.jieli.jl_rcsp.util.CHexConver;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.util.Xo0;
import java.io.File;
import java.util.ArrayList;

/* loaded from: classes12.dex */
public class oIX0oI {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final String f32216I0Io = "KEY_EQ_CURRENT_VALUE";

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final byte[] f32217II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final String f32218II0xO0 = "KEY_EQ_PRESET";

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final byte[][] f32219OOXIXo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final byte[] f32220Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final byte[] f32221X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public static final byte[] f32222XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final String f32223oIX0oI = "KEY_EQ_VALUE";

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static int[] f32224oOoXoXO = {31, 63, 125, 250, 500, 1000, 2000, 4000, 8000, 16000};

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final Gson f32225ooOOo0oXI = new Gson();

    /* renamed from: oxoX, reason: collision with root package name */
    public static final byte[] f32226oxoX;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final byte[] f32227xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final byte[] f32228xxIXOIIO;

    static {
        byte[] bArr = new byte[10];
        f32226oxoX = bArr;
        byte[] bArr2 = {-2, 0, 2, 4, -2, -2, 0, 0, 4, 4};
        f32221X0o0xo = bArr2;
        byte[] bArr3 = {3, 1, 0, -2, -4, -4, -2, 0, 1, 2};
        f32222XO = bArr3;
        byte[] bArr4 = {0, 8, 8, 4, 0, 0, 0, 0, 2, 2};
        f32220Oxx0IOOO = bArr4;
        byte[] bArr5 = {0, 0, 0, 4, 4, 4, 0, 2, 3, 4};
        f32217II0XooXoX = bArr5;
        byte[] bArr6 = {-2, 0, 0, 2, 2, 0, 0, 0, 4, 4};
        f32228xxIXOIIO = bArr6;
        byte[] bArr7 = new byte[10];
        f32227xoIox = bArr7;
        f32219OOXIXo = new byte[][]{bArr, bArr2, bArr3, bArr4, bArr5, bArr6, bArr7};
    }

    public static String I0Io(EqInfo eqInfo) {
        Bitmap II0xO02 = II0xO0(eqInfo);
        String X0o0xo2 = X0o0xo(eqInfo);
        ImageUtils.save(II0xO02, X0o0xo2, Bitmap.CompressFormat.JPEG);
        return X0o0xo2;
    }

    public static String II0XooXoX(int modeIndex) {
        return Xo0.f24349oIX0oI.oIX0oI().getString(oOoXoXO(f32223oIX0oI + modeIndex), "");
    }

    public static Bitmap II0xO0(EqInfo eqInfo) {
        int dp2px = SizeUtils.dp2px(250.0f);
        int dp2px2 = SizeUtils.dp2px(50.0f);
        int[] freqs = eqInfo.getFreqs();
        byte[] value = eqInfo.getValue();
        EQPlotCore eQPlotCore = new EQPlotCore(dp2px, freqs.length, freqs);
        float[] fArr = new float[((dp2px - 2) * 4) + 4];
        for (int i = 0; i < freqs.length && i < value.length; i++) {
            eQPlotCore.updatePara(i, freqs[i], value[i]);
            eQPlotCore.getEQPlotData(fArr, i);
        }
        float[] II0xO02 = new II0xO0(dp2px, dp2px2).II0xO0(fArr);
        Bitmap createBitmap = Bitmap.createBitmap(dp2px, dp2px2, Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(-1);
        Paint paint = new Paint();
        paint.setStrokeWidth(SizeUtils.dp2px(2.0f));
        paint.setColor(Utils.getApp().getResources().getColor(R.color.color_eq_wave_top));
        canvas.drawLines(II0xO02, paint);
        return createBitmap;
    }

    public static EqPresetInfo OOXIXo() {
        String string = Xo0.f24349oIX0oI.oIX0oI().getString(oOoXoXO(f32218II0xO0), "");
        if (TextUtils.isEmpty(string)) {
            EqPresetInfo eqPresetInfo = new EqPresetInfo();
            eqPresetInfo.setNumber(7);
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 7; i++) {
                EqInfo eqInfo = new EqInfo();
                eqInfo.setMode(i);
                eqInfo.setValue((byte[]) f32219OOXIXo[i].clone());
                eqInfo.setFreqs(f32224oOoXoXO);
                arrayList.add(eqInfo);
            }
            eqPresetInfo.setEqInfos(arrayList);
            return eqPresetInfo;
        }
        return (EqPresetInfo) f32225ooOOo0oXI.fromJson(string, EqPresetInfo.class);
    }

    public static EqInfo Oxx0IOOO() {
        String string = Xo0.f24349oIX0oI.oIX0oI().getString(oOoXoXO(f32216I0Io), "");
        if (TextUtils.isEmpty(string)) {
            return new EqInfo(0, new byte[10]);
        }
        return oO(string);
    }

    public static String X0o0xo(EqInfo eqInfo) {
        StringBuilder sb = new StringBuilder();
        sb.append(Utils.getApp().getExternalCacheDir().getPath());
        sb.append(File.separator);
        sb.append("eq=");
        sb.append(CHexConver.byte2HexStr(eqInfo.getValue(), eqInfo.getValue().length));
        for (int i : eqInfo.getFreqs()) {
            sb.append(i);
        }
        return sb.toString();
    }

    public static EqInfo XO(int modeIndex) {
        String string = Xo0.f24349oIX0oI.oIX0oI().getString(oOoXoXO(f32223oIX0oI + modeIndex), "");
        if (TextUtils.isEmpty(string)) {
            return new EqInfo(modeIndex, f32219OOXIXo[modeIndex]);
        }
        return oO(string);
    }

    public static void oIX0oI() {
        Xo0 xo0 = Xo0.f24349oIX0oI;
        xo0.oIX0oI().remove(oOoXoXO(f32216I0Io));
        xo0.oIX0oI().remove(oOoXoXO(f32218II0xO0));
    }

    public static EqInfo oO(String string) {
        LogUtils.e("sen", "eq cache value-->" + string);
        return (EqInfo) f32225ooOOo0oXI.fromJson(string, EqInfo.class);
    }

    public static void ooOOo0oXI(EqInfo eqInfo) {
        String xxIXOIIO2 = xxIXOIIO(eqInfo);
        String oxoX2 = oxoX(eqInfo);
        if (!xxIXOIIO2.equals(oxoX2) && eqInfo.getMode() != 6) {
            FileUtils.delete(new File(X0o0xo(eqInfo)));
        }
        Xo0 xo0 = Xo0.f24349oIX0oI;
        xo0.oIX0oI().put(oOoXoXO(f32223oIX0oI + eqInfo.getMode()), oxoX2);
        xo0.oIX0oI().put(oOoXoXO(f32216I0Io), oxoX2);
    }

    public static String oxoX(EqInfo eqInfo) {
        return f32225ooOOo0oXI.toJson(eqInfo);
    }

    public static void x0XOIxOo(EqPresetInfo eqPresetInfo) {
        Xo0.f24349oIX0oI.oIX0oI().put(oOoXoXO(f32218II0xO0), f32225ooOOo0oXI.toJson(eqPresetInfo));
    }

    public static String xoIox(EqInfo eqInfo) {
        String X0o0xo2 = X0o0xo(eqInfo);
        LogUtils.e("sen", "path--->" + X0o0xo2);
        if (new File(X0o0xo2).exists()) {
            return X0o0xo2;
        }
        return I0Io(eqInfo);
    }

    public static String xxIXOIIO(EqInfo eqInfo) {
        return II0XooXoX(eqInfo.getMode());
    }

    public static String oOoXoXO(String key) {
        return key;
    }
}
