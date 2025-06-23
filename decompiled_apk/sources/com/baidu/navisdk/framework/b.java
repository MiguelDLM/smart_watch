package com.baidu.navisdk.framework;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import androidx.annotation.Nullable;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.navisdk.framework.interfaces.walk.a;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.g;
import com.baidu.platform.comapi.basestruct.Point;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.realsil.sdk.dfu.image.constants.SubBinId;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static a f6799a;
    private static com.baidu.navisdk.framework.interfaces.walk.a b;

    /* loaded from: classes7.dex */
    public interface a {
        Bundle a(int i, int i2, Object obj, Object... objArr);

        Object b(int i, int i2, Object obj, Object... objArr);

        boolean c(int i, int i2, Object obj, Object... objArr);
    }

    /* renamed from: com.baidu.navisdk.framework.b$b, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0197b {
    }

    public static int A() {
        Bundle a2;
        a aVar = f6799a;
        if (aVar == null || (a2 = aVar.a(30, -1, null, new Object[0])) == null || !a2.containsKey("key.outchina.cityid")) {
            return -1;
        }
        return a2.getInt("key.outchina.cityid", -1);
    }

    public static Bundle B() {
        a aVar = f6799a;
        if (aVar == null) {
            return null;
        }
        return aVar.a(113, 0, null, new Object[0]);
    }

    public static int C() {
        a aVar = f6799a;
        if (aVar != null) {
            Object b2 = aVar.b(112, 0, null, new Object[0]);
            if (b2 instanceof Integer) {
                return ((Integer) b2).intValue();
            }
        }
        return 0;
    }

    public static Bundle D() {
        a aVar = f6799a;
        if (aVar == null) {
            return null;
        }
        Bundle a2 = aVar.a(TTAdConstant.INIT_FAILED_LOAD_PLUGIN_FAILED, 0, null, new Object[0]);
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNMapProxy", "getTruckPlate bundle: " + a2);
        }
        return a2;
    }

    public static String E() {
        Bundle a2;
        a aVar = f6799a;
        if (aVar == null || (a2 = aVar.a(47, 0, null, new Object[0])) == null || !a2.containsKey("uid")) {
            return null;
        }
        return a2.getString("uid");
    }

    @Nullable
    public static String F() {
        Bundle B = B();
        if (B == null) {
            return "";
        }
        return B.getString("zid", "");
    }

    public static boolean G() {
        a aVar = f6799a;
        if (aVar == null) {
            return false;
        }
        return aVar.c(2021, 0, null, new Object[0]);
    }

    public static void H() {
        a aVar = f6799a;
        if (aVar != null) {
            aVar.a(25, 0, null, new Object[0]);
        }
    }

    public static void I() {
        a aVar = f6799a;
        if (aVar != null) {
            aVar.a(27, 0, null, new Object[0]);
        }
    }

    public static boolean J() {
        a aVar = f6799a;
        if (aVar != null) {
            return aVar.c(2, 0, null, new Object[0]);
        }
        return true;
    }

    public static boolean K() {
        a aVar = f6799a;
        if (aVar == null) {
            return false;
        }
        return aVar.c(99, 0, null, new Object[0]);
    }

    public static boolean L() {
        a aVar = f6799a;
        if (aVar == null) {
            return false;
        }
        return aVar.c(17, 0, null, new Object[0]);
    }

    public static boolean M() {
        if (i() != 0) {
            return true;
        }
        return false;
    }

    public static boolean N() {
        return f6799a.c(1006, 0, null, new Object[0]);
    }

    public static boolean O() {
        a aVar = f6799a;
        if (aVar == null) {
            return false;
        }
        return aVar.c(10, 0, null, new Object[0]);
    }

    public static boolean P() {
        a aVar = f6799a;
        if (aVar == null) {
            return false;
        }
        return aVar.c(119, 0, null, new Object[0]);
    }

    public static boolean Q() {
        a aVar = f6799a;
        if (aVar == null) {
            return false;
        }
        return aVar.c(78, 0, null, new Object[0]);
    }

    public static boolean R() {
        a aVar = f6799a;
        if (aVar != null) {
            Object b2 = aVar.b(1018, 0, null, new Object[0]);
            if (b2 instanceof Boolean) {
                return ((Boolean) b2).booleanValue();
            }
        }
        return false;
    }

    public static boolean S() {
        a aVar = f6799a;
        if (aVar == null) {
            return false;
        }
        return aVar.c(59, 0, null, new Object[0]);
    }

    public static boolean T() {
        a aVar = f6799a;
        if (aVar == null) {
            return false;
        }
        return aVar.c(77, 0, null, new Object[0]);
    }

    public static boolean U() {
        a aVar = f6799a;
        if (aVar == null) {
            return false;
        }
        boolean c = aVar.c(72, 0, null, new Object[0]);
        LogUtil.e("BNMapProxy", "isOppoChannel() " + c);
        return c;
    }

    public static boolean V() {
        a aVar = f6799a;
        if (aVar == null) {
            return false;
        }
        return aVar.c(54, 0, null, new Object[0]);
    }

    public static boolean W() {
        return f6799a.c(1003, 0, null, new Object[0]);
    }

    public static void X() {
        a aVar = f6799a;
        if (aVar != null) {
            aVar.a(19, 0, null, new Object[0]);
        }
    }

    public static void Y() {
        a aVar = f6799a;
        if (aVar != null) {
            aVar.c(3001, 0, null, new Object[0]);
        }
    }

    public static void Z() {
        a aVar = f6799a;
        if (aVar != null) {
            aVar.c(3, 0, null, new Object[0]);
        }
    }

    private static String a(int i, int i2) {
        return i == 1 ? i2 == 1 ? "newenergy" : "car" : i == 2 ? "motor" : i == 3 ? "truck" : "";
    }

    public static void a0() {
        a(true);
    }

    public static void b(Object obj) {
        a aVar = f6799a;
        if (aVar != null) {
            aVar.b(130, 0, obj, new Object[0]);
        }
    }

    public static boolean b0() {
        a aVar = f6799a;
        if (aVar == null) {
            return false;
        }
        boolean c = aVar.c(74, 0, null, new Object[0]);
        LogUtil.e("BNMapProxy", "stopVdrLocation() " + c);
        return c;
    }

    private static String c() {
        Bundle a2;
        a aVar = f6799a;
        if (aVar == null || (a2 = aVar.a(53, 0, null, new Object[0])) == null || !a2.containsKey("baseline_vertime")) {
            return null;
        }
        return a2.getString("baseline_vertime");
    }

    public static void c0() {
        a aVar = f6799a;
        if (aVar != null) {
            aVar.c(80, 0, null, new Object[0]);
        }
    }

    public static String d() {
        String c = c();
        if (TextUtils.isEmpty(c)) {
            return "";
        }
        return FileUtils.FILE_EXTENSION_SEPARATOR + c;
    }

    public static void d0() {
        a aVar = f6799a;
        if (aVar != null) {
            aVar.c(5, 0, null, new Object[0]);
        }
    }

    public static boolean e(String str) {
        return f6799a.c(1005, 0, str, new Object[0]);
    }

    public static boolean e0() {
        Bundle a2;
        a aVar = f6799a;
        if (aVar == null || (a2 = aVar.a(45, 0, null, new Object[0])) == null || !a2.containsKey("UserIsLogin")) {
            return false;
        }
        return a2.getBoolean("UserIsLogin");
    }

    public static boolean f(String str) {
        a aVar = f6799a;
        if (aVar != null) {
            return aVar.c(18, 0, str, new Object[0]);
        }
        return false;
    }

    @Deprecated
    public static String g() {
        Bundle a2;
        a aVar = f6799a;
        return (aVar == null || (a2 = aVar.a(44, 0, null, new Object[0])) == null || !a2.containsKey("carNum")) ? "" : a2.getString("carNum");
    }

    public static void h(Bundle bundle) {
        a aVar = f6799a;
        if (aVar != null) {
            aVar.a(26, 0, bundle, new Object[0]);
        }
    }

    private static int i() {
        Bundle a2;
        a aVar = f6799a;
        if (aVar == null || (a2 = aVar.a(52, 0, null, new Object[0])) == null || !a2.containsKey("carType")) {
            return 0;
        }
        return a2.getInt("carType");
    }

    public static Bundle j() {
        a aVar = f6799a;
        if (aVar != null) {
            return aVar.a(49, 0, null, new Object[0]);
        }
        return null;
    }

    public static void k(int i) {
        a aVar = f6799a;
        if (aVar != null) {
            aVar.b(1024, 0, Integer.valueOf(i), new Object[0]);
        }
    }

    public static void l(int i) {
        a aVar = f6799a;
        if (aVar != null) {
            aVar.c(4, i, null, new Object[0]);
        }
    }

    public static Bundle m() {
        a aVar = f6799a;
        if (aVar == null) {
            return null;
        }
        return aVar.a(48, 0, null, new Object[0]);
    }

    public static Bundle n() {
        a aVar = f6799a;
        if (aVar == null) {
            return null;
        }
        return aVar.a(101, 0, null, new Object[0]);
    }

    public static com.baidu.navisdk.network.a o() {
        a aVar = f6799a;
        if (aVar != null) {
            Object b2 = aVar.b(91, 0, null, new Object[0]);
            if (b2 instanceof com.baidu.navisdk.network.a) {
                return (com.baidu.navisdk.network.a) b2;
            }
        }
        return null;
    }

    public static int[] p() {
        String str;
        a aVar = f6799a;
        if (aVar != null) {
            Bundle a2 = aVar.a(89, 0, null, new Object[0]);
            if (LogUtil.LOGGABLE) {
                StringBuilder sb = new StringBuilder();
                sb.append("getHwViaductState bundle:");
                if (a2 != null) {
                    str = a2.toString();
                } else {
                    str = "null";
                }
                sb.append(str);
                LogUtil.e("BNMapProxy", sb.toString());
            }
            if (a2 != null) {
                return a2.getIntArray("hw_viaduct_state");
            }
        }
        return new int[0];
    }

    public static String q() {
        Bundle a2;
        a aVar = f6799a;
        if (aVar == null || (a2 = aVar.a(139, 0, null, new Object[0])) == null || !a2.containsKey("indoor_local_info")) {
            return null;
        }
        return a2.getString("indoor_local_info");
    }

    public static int r() {
        Bundle a2;
        a aVar = f6799a;
        if (aVar != null && (a2 = aVar.a(22, 0, null, new Object[0])) != null && a2.containsKey("KEY_PREFER_VALUE")) {
            return a2.getInt("KEY_PREFER_VALUE");
        }
        return 1;
    }

    public static int s() {
        if (f6799a != null) {
            Object b2 = f6799a.b(97, 0, new Bundle(), new Object[0]);
            if (b2 instanceof Integer) {
                return ((Integer) b2).intValue();
            }
            return -1;
        }
        return -1;
    }

    public static float t() {
        a aVar = f6799a;
        if (aVar == null) {
            return -1.0f;
        }
        float f = aVar.a(92, 0, null, new Object[0]).getFloat("map_sensor_angle", -1.0f);
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNMapProxy", "getMapSensorAngle angle:" + f);
        }
        return f;
    }

    public static int u() {
        Bundle a2;
        a aVar = f6799a;
        if (aVar == null || (a2 = aVar.a(2026, 0, null, new Object[0])) == null || !a2.containsKey("max_linkid_list_size")) {
            return 0;
        }
        return a2.getInt("max_linkid_list_size");
    }

    public static Bundle v() {
        a aVar = f6799a;
        if (aVar == null) {
            return null;
        }
        Bundle a2 = aVar.a(4000, 0, null, new Object[0]);
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNMapProxy", "getMotorPlate bundle: " + a2);
        }
        return a2;
    }

    public static long w() {
        Object b2;
        a aVar = f6799a;
        if (aVar != null && (b2 = aVar.b(1021, 0, null, new Object[0])) != null) {
            return ((Long) b2).longValue();
        }
        return 0L;
    }

    public static long x() {
        Object b2;
        a aVar = f6799a;
        if (aVar != null && (b2 = aVar.b(1020, 0, null, new Object[0])) != null) {
            return ((Long) b2).longValue();
        }
        return 0L;
    }

    public static Bundle y() {
        a aVar = f6799a;
        if (aVar == null) {
            return null;
        }
        Bundle a2 = aVar.a(1032, 1, null, new Object[0]);
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNMapProxy", "getNewEnergyPlate bundle: " + a2);
        }
        return a2;
    }

    public static boolean z() {
        a aVar = f6799a;
        if (aVar == null) {
            return false;
        }
        return aVar.c(129, 0, null, new Object[0]);
    }

    public static void a(a aVar) {
        f6799a = aVar;
    }

    public static void a(com.baidu.navisdk.framework.interfaces.walk.a aVar) {
        b = aVar;
    }

    public static void b(String str, int i, int i2) {
        if (f6799a != null) {
            Bundle bundle = new Bundle();
            bundle.putString("addr", str);
            bundle.putInt("MCx", i);
            bundle.putInt("MCy", i2);
            f6799a.c(50, 0, bundle, new Object[0]);
        }
    }

    public static String e() {
        Bundle a2;
        a aVar = f6799a;
        if (aVar == null || (a2 = aVar.a(1, 0, null, new Object[0])) == null || !a2.containsKey("bduss")) {
            return null;
        }
        return a2.getString("bduss");
    }

    @Deprecated
    public static void h(int i) {
        a aVar = f6799a;
        if (aVar != null) {
            aVar.a(42, i, null, new Object[0]);
        }
    }

    public static int l() {
        Object b2;
        a aVar = f6799a;
        if (aVar == null || (b2 = aVar.b(1009, 0, null, new Object[0])) == null) {
            return -1;
        }
        return ((Integer) b2).intValue();
    }

    public static boolean a(double d, double d2, int i) {
        if (f6799a == null) {
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putDouble("x", d);
        bundle.putDouble("y", d2);
        bundle.putInt("cityId", i);
        return f6799a.c(ARPMessageType.MSG_TYPE_VIDEO_PLAY_INFO_UPDATE, -1, bundle, new Object[0]);
    }

    public static String d(String str) {
        Bundle a2;
        a aVar = f6799a;
        return (aVar == null || (a2 = aVar.a(66, 0, null, new Object[0])) == null || !a2.containsKey("login_name")) ? str : a2.getString("login_name");
    }

    public static void f(boolean z) {
        a aVar = f6799a;
        if (aVar != null) {
            aVar.c(55, 0, Boolean.valueOf(z), new Object[0]);
        }
    }

    public static void j(int i) {
        a aVar = f6799a;
        if (aVar != null) {
            aVar.c(3002, i, null, new Object[0]);
        }
    }

    public static Bundle k() {
        a aVar = f6799a;
        if (aVar != null) {
            return aVar.a(102, 0, null, new Object[0]);
        }
        return null;
    }

    public static void c(Bundle bundle) {
        a aVar = f6799a;
        if (aVar != null) {
            aVar.a(96, 0, bundle, new Object[0]);
        }
    }

    public static void g(int i) {
        a aVar = f6799a;
        if (aVar != null) {
            aVar.a(41, i, null, new Object[0]);
        }
    }

    public static boolean h(String str) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNMapProxy", "notifyNaviInfo2LocaltionSdk,info:" + str);
        }
        if (f6799a == null) {
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putString("info", str);
        return f6799a.c(6000, 0, bundle, new Object[0]);
    }

    public static void i(int i) {
        a aVar = f6799a;
        if (aVar != null) {
            aVar.a(23, 0, Integer.valueOf(i), new Object[0]);
        }
    }

    public static void e(boolean z) {
        a aVar = f6799a;
        if (aVar != null) {
            aVar.c(62, z ? 1 : 0, null, new Object[0]);
        }
    }

    public static boolean f(int i) {
        a aVar;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNMapProxy", "isOutOfLocalCity cityCode:" + i);
        }
        if (i > 0 && (aVar = f6799a) != null) {
            return aVar.c(94, 0, Integer.valueOf(i), new Object[0]);
        }
        return false;
    }

    public static int d(int i) {
        a aVar = f6799a;
        if (aVar == null) {
            return i;
        }
        Object b2 = aVar.b(1009, 0, null, new Object[0]);
        if (b2 == null) {
            return -1;
        }
        return ((Integer) b2).intValue();
    }

    public static boolean i(String str) {
        a aVar = f6799a;
        if (aVar != null) {
            return aVar.c(106, 0, str, new Object[0]);
        }
        return false;
    }

    public static void b(boolean z) {
        a aVar = f6799a;
        if (aVar != null) {
            aVar.c(60, z ? 0 : -1, null, new Object[0]);
        }
    }

    public static int c(int i) {
        a aVar = f6799a;
        if (aVar != null) {
            return ((Integer) aVar.b(69, i, null, new Object[0])).intValue();
        }
        return -1;
    }

    public static void e(Bundle bundle, Object obj) {
        a aVar = f6799a;
        if (aVar != null) {
            Bundle bundle2 = (Bundle) aVar.b(1038, 0, bundle, obj);
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BNMapProxy", "getCarPlateList bundle: " + bundle2);
            }
        }
    }

    public static boolean g(String str) {
        a aVar = f6799a;
        if (aVar != null) {
            return aVar.c(68, 0, str, new Object[0]);
        }
        return false;
    }

    public static void a(int i, Object obj) {
        Bundle a2;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNMapProxy", "jumpPage -> pageType: " + i + ", arg: " + obj);
        }
        a aVar = f6799a;
        if (aVar == null || (a2 = aVar.a(67, i, obj, new Object[0])) == null || !a2.containsKey("ret")) {
            return;
        }
        int i2 = a2.getInt("ret");
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNMapProxy", "jumpPage -> pageType: " + i + ", ret: " + i2);
            if (i2 != i) {
                LogUtil.e("BNMapProxy", "请确认基线pageJumpFromNavi是否及时return");
            }
        }
    }

    public static void c(String str) {
        a aVar = f6799a;
        if (aVar != null) {
            aVar.c(71, 0, str, new Object[0]);
        }
    }

    public static boolean f() {
        a aVar = f6799a;
        if (aVar != null) {
            return aVar.c(99, 2, null, new Object[0]);
        }
        return false;
    }

    public static void g(boolean z) {
        a aVar = f6799a;
        if (aVar != null) {
            aVar.c(107, 0, Boolean.valueOf(z), new Object[0]);
        }
    }

    public static void b(int i, Object obj) {
        a aVar = f6799a;
        if (aVar != null) {
            aVar.b(1014, i, obj, new Object[0]);
        }
    }

    public static void d(Bundle bundle, Object obj) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNMapProxy", "modifyCarInfo2CarOwner,arg:" + bundle);
        }
        a aVar = f6799a;
        if (aVar != null) {
            aVar.b(1041, 0, bundle, obj);
        }
    }

    public static Bundle h() {
        a aVar = f6799a;
        if (aVar == null) {
            return null;
        }
        Bundle a2 = aVar.a(1032, 0, null, new Object[0]);
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNMapProxy", "getCarPlate bundle: " + a2);
        }
        return a2;
    }

    public static boolean c(Object obj) {
        a aVar = f6799a;
        if (aVar != null) {
            return aVar.c(85, 0, obj, new Object[0]);
        }
        return false;
    }

    public static void g(Bundle bundle) {
        a aVar = f6799a;
        if (aVar != null) {
            aVar.c(123, 0, bundle, new Object[0]);
        }
    }

    public static void e(Bundle bundle) {
        a aVar = f6799a;
        if (aVar != null) {
            aVar.a(127, 0, bundle, new Object[0]);
        }
    }

    public static boolean f(Bundle bundle) {
        a aVar = f6799a;
        if (aVar != null) {
            return aVar.c(100, 0, bundle, new Object[0]);
        }
        return false;
    }

    public static void b(Bundle bundle, Object obj) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNMapProxy", "deleteCarInfo2CarOwner,arg:" + bundle);
        }
        a aVar = f6799a;
        if (aVar != null) {
            aVar.b(SubBinId.Bbpro.DSP_UI_PARAMETER_FILE, 0, bundle, obj);
        }
    }

    public static void c(boolean z) {
        if (f6799a != null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("enable", z);
            f6799a.c(99, 1, bundle, new Object[0]);
        }
    }

    public static void d(Bundle bundle) {
        a aVar = f6799a;
        if (aVar != null) {
            aVar.a(124, 0, bundle, new Object[0]);
        }
    }

    public static Object e(int i) {
        a aVar = f6799a;
        if (aVar != null) {
            return aVar.b(130, i, null, new Object[0]);
        }
        return Boolean.FALSE;
    }

    public static boolean d(boolean z) {
        a aVar = f6799a;
        if (aVar != null) {
            return aVar.c(128, 0, Boolean.valueOf(z), new Object[0]);
        }
        return false;
    }

    public static void a(Context context) {
        a aVar = f6799a;
        if (aVar != null) {
            aVar.a(32, 0, context, new Object[0]);
        }
    }

    public static Bundle b(String str) {
        a aVar = f6799a;
        if (aVar != null) {
            return aVar.a(3003, 0, str, new Object[0]);
        }
        return null;
    }

    public static void c(Bundle bundle, Object obj) {
        a aVar = f6799a;
        if (aVar != null) {
            Bundle bundle2 = (Bundle) aVar.b(1037, 0, bundle, obj);
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BNMapProxy", "getCarPlateList bundle: " + bundle2);
            }
        }
    }

    public static void b(Bundle bundle) {
        a aVar = f6799a;
        if (aVar != null) {
            aVar.a(125, 0, bundle, new Object[0]);
        }
    }

    public static void a(Bundle bundle, int i, Object obj) {
        a aVar = f6799a;
        if (aVar != null) {
            Bundle bundle2 = (Bundle) aVar.b(132, i, bundle, obj);
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BNMapProxy", "inNaviGotoModelPage bundle: " + bundle2);
            }
        }
    }

    public static void b(int i) {
        com.baidu.navisdk.framework.interfaces.walk.a aVar = b;
        if (aVar != null) {
            aVar.a(i);
        }
    }

    public static void b() {
        com.baidu.navisdk.framework.interfaces.walk.a aVar = b;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Deprecated
    public static void a(int i, boolean z) {
        a aVar = f6799a;
        if (aVar != null) {
            aVar.a(43, i, Boolean.valueOf(z), new Object[0]);
        }
    }

    public static void a(String str, int i, int i2) {
        if (f6799a != null) {
            Bundle bundle = new Bundle();
            bundle.putString("addr", str);
            bundle.putInt("MCx", i);
            bundle.putInt("MCy", i2);
            f6799a.c(51, 0, bundle, new Object[0]);
        }
    }

    public static void a() {
        a aVar = f6799a;
        if (aVar != null) {
            aVar.c(56, 0, null, new Object[0]);
        }
    }

    public static void a(Window window, boolean z) {
        a aVar = f6799a;
        if (aVar == null || window == null) {
            return;
        }
        aVar.c(57, !z ? 1 : 0, window, new Object[0]);
    }

    public static void a(boolean z) {
        a aVar = f6799a;
        if (aVar != null) {
            aVar.c(58, z ? 1 : 0, null, new Object[0]);
        }
    }

    public static boolean a(ArrayList<String> arrayList) {
        a aVar = f6799a;
        if (aVar == null) {
            return false;
        }
        boolean c = aVar.c(73, 0, arrayList, new Object[0]);
        LogUtil.e("BNMapProxy", "startVdrLocation() " + c);
        return c;
    }

    public static boolean a(Context context, Object obj) {
        a aVar = f6799a;
        if (aVar != null) {
            return aVar.c(2000, 0, context, obj);
        }
        return false;
    }

    public static String a(String str, String str2) {
        if (f6799a == null) {
            return "";
        }
        Bundle bundle = new Bundle();
        bundle.putString("url", str);
        bundle.putString("cachePath", str2);
        return (String) f6799a.b(84, 0, bundle, new Object[0]);
    }

    public static void a(long j) {
        a aVar = f6799a;
        if (aVar != null) {
            aVar.b(1023, 0, Long.valueOf(j), new Object[0]);
        }
    }

    public static void a(Object obj) {
        a aVar = f6799a;
        if (aVar != null) {
            aVar.c(93, 0, obj, new Object[0]);
        }
    }

    public static Object a(String str) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNMapProxy", "callOpenApi --> url:" + str);
        }
        if (TextUtils.isEmpty(str) || f6799a == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("url", str);
        return f6799a.b(1026, 0, bundle, new Object[0]);
    }

    public static void a(JSONObject jSONObject) {
        if (f6799a != null) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BNMapProxy", "dispatchNaviExtraInfoToLocSDKEvent: " + jSONObject);
            }
            f6799a.c(98, 0, jSONObject, new Object[0]);
        }
    }

    public static JSONArray a(int i, String str) {
        String str2;
        Bundle a2;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNMapProxy", "getPassportInfos() --> vehicle = " + i + " plate = " + str);
        }
        a aVar = f6799a;
        if (aVar != null && (a2 = aVar.a(109, i, str, new Object[0])) != null && a2.containsKey("carPassportInfos")) {
            str2 = a2.getString("carPassportInfos");
        } else {
            str2 = "";
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNMapProxy", "getPassportInfos --> passportInfos = " + str2);
        }
        if (!TextUtils.isEmpty(str2)) {
            try {
                return new JSONArray(str2);
            } catch (JSONException e) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("BNMapProxy", "getPassportInfos --> JSONException e = " + e);
                }
            }
        }
        return null;
    }

    public static void a(int i, String str, boolean z) {
        if (f6799a != null) {
            Bundle bundle = new Bundle();
            bundle.putString("plate", str);
            bundle.putBoolean("is_in_navi", z);
            f6799a.a(110, i, bundle, new Object[0]);
        }
    }

    public static void a(com.baidu.navisdk.framework.interfaces.account.a aVar) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNMapProxy", "toLogin---");
            LogUtil.printCallStack();
        }
        a aVar2 = f6799a;
        if (aVar2 != null) {
            aVar2.a(118, 0, aVar, new Object[0]);
        }
    }

    public static Bundle a(Bundle bundle, int i) {
        a aVar = f6799a;
        if (aVar == null) {
            return null;
        }
        Bundle a2 = aVar.a(1042, i, bundle, new Object[0]);
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNMapProxy", "getEngModelFragment,bundle:" + a2);
        }
        return a2;
    }

    public static void a(Bundle bundle, Object obj) {
        a aVar = f6799a;
        if (aVar != null) {
            Bundle bundle2 = (Bundle) aVar.b(1033, 0, bundle, obj);
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BNMapProxy", "setCarInfo2CarOwnerList bundle: " + bundle2);
                LogUtil.e("BNMapProxy", "setCarInfo2CarOwnerList plateRequestListener: " + obj);
            }
        }
    }

    public static void a(Bundle bundle) {
        a aVar = f6799a;
        if (aVar != null) {
            aVar.c(122, 0, bundle, new Object[0]);
        }
    }

    public static int a(com.baidu.nplatform.comapi.basestruct.c cVar, String str, String str2, a.InterfaceC0200a interfaceC0200a) {
        if (b == null) {
            return -1;
        }
        Point point = new Point();
        point.setDoubleX(cVar.a());
        point.setDoubleY(cVar.b());
        return b.a(point, str, str2, interfaceC0200a);
    }

    public static boolean a(InterfaceC0197b interfaceC0197b) {
        a aVar = f6799a;
        if (aVar != null) {
            return aVar.c(2023, 0, interfaceC0197b, new Object[0]);
        }
        return false;
    }

    public static void a(int i) {
        a aVar = f6799a;
        if (aVar != null) {
            aVar.a(136, i, null, new Object[0]);
        }
    }

    public static void a(int i, int i2, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("trigger_position", a(i, i2));
        bundle.putString("trigger_scene", str);
        g gVar = g.ROUTE_RESULT;
        if (gVar.d()) {
            gVar.e("BNMapProxy", "location dialog bundle trigger_position = " + bundle.getString("trigger_position") + " trigger_scene " + bundle.getString("trigger_scene"));
        }
        a aVar = f6799a;
        if (aVar != null) {
            aVar.a(2025, 0, bundle, new Object[0]);
        }
    }
}
