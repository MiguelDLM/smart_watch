package XIXIX;

import OoOoXO0.xoXoI;
import android.content.res.Resources;
import android.graphics.Color;
import com.google.firebase.crashlytics.buildtools.ndk.internal.elf.EMachine;
import com.jieli.jl_rcsp.constant.Command;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes9.dex */
public class oIX0oI {

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final int f3778II0xO0 = 1122868;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final int f3782oIX0oI = 1122867;

    /* renamed from: I0Io, reason: collision with root package name */
    public static final int[] f3776I0Io = {Color.rgb(207, 248, 246), Color.rgb(148, 212, 212), Color.rgb(136, 180, 187), Color.rgb(118, 174, EMachine.EM_MCST_ELBRUS), Color.rgb(42, 109, 130)};

    /* renamed from: oxoX, reason: collision with root package name */
    public static final int[] f3783oxoX = {Color.rgb(Command.CMD_GET_DEVICE_CONFIG_INFO, 80, 138), Color.rgb(254, 149, 7), Color.rgb(254, 247, 120), Color.rgb(106, 167, 134), Color.rgb(53, 194, 209)};

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final int[] f3780X0o0xo = {Color.rgb(64, 89, 128), Color.rgb(149, 165, 124), Color.rgb(Command.CMD_GET_DEVICE_CONFIG_INFO, 184, 162), Color.rgb(EMachine.EM_TILEGX, 134, 134), Color.rgb(EMachine.EM_SLE9X, 48, 80)};

    /* renamed from: XO, reason: collision with root package name */
    public static final int[] f3781XO = {Color.rgb(193, 37, 82), Color.rgb(255, 102, 0), Color.rgb(245, 199, 0), Color.rgb(106, 150, 31), Color.rgb(EMachine.EM_SLE9X, 100, 53)};

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final int[] f3779Oxx0IOOO = {Color.rgb(192, 255, 140), Color.rgb(255, 247, 140), Color.rgb(255, 208, 140), Color.rgb(140, 234, 255), Color.rgb(255, 140, 157)};

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int[] f3777II0XooXoX = {X0o0xo("#2ecc71"), X0o0xo("#f1c40f"), X0o0xo("#e74c3c"), X0o0xo("#3498db")};

    public static List<Integer> I0Io(int[] iArr) {
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            arrayList.add(Integer.valueOf(i));
        }
        return arrayList;
    }

    public static List<Integer> II0xO0(Resources resources, int[] iArr) {
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            arrayList.add(Integer.valueOf(resources.getColor(i)));
        }
        return arrayList;
    }

    public static int X0o0xo(String str) {
        int parseLong = (int) Long.parseLong(str.replace(xoXoI.f2670oxoX, ""), 16);
        return Color.rgb((parseLong >> 16) & 255, (parseLong >> 8) & 255, parseLong & 255);
    }

    public static int oIX0oI(int i, int i2) {
        return (i & 16777215) | ((i2 & 255) << 24);
    }

    public static int oxoX() {
        return Color.rgb(51, 181, 229);
    }
}
