package com.baidu.navisdk.module.brule;

import OoIXo.oOoXoXO;
import android.media.AudioManager;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.work.PeriodicWorkRequest;
import com.alibaba.fastjson.parser.JSONLexer;
import com.baidu.navisdk.asr.d;
import com.baidu.navisdk.comapi.commontool.BNPowerSaver;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.setting.SettingParams;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.framework.message.a;
import com.baidu.navisdk.h;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.jni.nativeif.JNITrajectoryControl;
import com.baidu.navisdk.model.modelfactory.f;
import com.baidu.navisdk.util.common.e0;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.common.x;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.voicesquare.interfaces.VoiceInterfaceImplProxy;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/* loaded from: classes7.dex */
public class a implements com.baidu.navisdk.behavrules.data.c, a.InterfaceC0201a {
    private static a d;

    /* renamed from: a, reason: collision with root package name */
    private long f7042a;
    private long b;
    private long c;

    private a() {
    }

    private String b(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith("instructions_history")) {
            String[] split = str.split("\\|");
            if (split.length == 2) {
                return String.valueOf(BNSettingManager.getXDInstructionCount(split[1]) >= 1);
            }
        }
        return null;
    }

    private String c(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith("instructions_history")) {
            return b(str);
        }
        return null;
    }

    public static a l() {
        if (d == null) {
            d = new a();
        }
        return d;
    }

    private int m() {
        Bundle bundle = new Bundle();
        BNRouteGuider.getInstance().getRouteInfoInUniform(25, bundle);
        return bundle.getInt("unTime");
    }

    private String n() {
        VoiceInterfaceImplProxy o = com.baidu.navisdk.framework.interfaces.c.p().o();
        if (o == null) {
            return "";
        }
        String currentVoice = o.getCurrentVoice();
        g gVar = g.ASR;
        if (gVar.d()) {
            gVar.e("BNBRuleBaseDataCenter", "getNowVoice(), taskId = " + currentVoice);
        }
        return o.getDownloadedVoiceOuterBeanName(currentVoice);
    }

    @Override // com.baidu.navisdk.behavrules.data.c
    public String a() {
        return TtmlNode.RUBY_BASE;
    }

    public int d() {
        return ((f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel")).e();
    }

    public int e() {
        AudioManager audioManager = (AudioManager) com.baidu.navisdk.framework.a.c().a().getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        return (int) ((audioManager.getStreamVolume(3) / audioManager.getStreamMaxVolume(3)) * 100.0d);
    }

    public String f() {
        return ((f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel")).g().getName();
    }

    public String g() {
        if (!d.B().t()) {
            return "user_set";
        }
        if (!x.h()) {
            return "low_power";
        }
        if (!x.x()) {
            return "other";
        }
        return null;
    }

    public void h() {
        com.baidu.navisdk.framework.message.a.a().a(this, com.baidu.navisdk.framework.message.bean.a.class, new Class[0]);
    }

    public boolean i() {
        return com.baidu.navisdk.framework.b.S();
    }

    public boolean j() {
        return BNRoutePlaner.getInstance().A();
    }

    public void k() {
        com.baidu.navisdk.framework.message.a.a().a((a.InterfaceC0201a) this);
    }

    @Override // com.baidu.navisdk.framework.message.a.InterfaceC0201a
    public void onEvent(Object obj) {
        if (obj instanceof com.baidu.navisdk.framework.message.bean.a) {
            if (((com.baidu.navisdk.framework.message.bean.a) obj).a() <= 5.0d) {
                if (System.currentTimeMillis() - this.c >= PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS) {
                    this.b = System.currentTimeMillis();
                    return;
                }
                return;
            }
            this.c = System.currentTimeMillis();
        }
    }

    @Override // com.baidu.navisdk.behavrules.data.c
    public String a(String str) {
        com.baidu.navisdk.module.nearbysearch.model.a aVar;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -2077038853:
                if (str.equals("time_hhm")) {
                    c = 0;
                    break;
                }
                break;
            case -2044834702:
                if (str.equals("gps_speed")) {
                    c = 1;
                    break;
                }
                break;
            case -1914620769:
                if (str.equals("rc_preview_type")) {
                    c = 2;
                    break;
                }
                break;
            case -1892024612:
                if (str.equals("continue_drive_time_all")) {
                    c = 3;
                    break;
                }
                break;
            case -1854547569:
                if (str.equals("has_show_rookie_guide")) {
                    c = 4;
                    break;
                }
                break;
            case -1814363219:
                if (str.equals("has_approach")) {
                    c = 5;
                    break;
                }
                break;
            case -1583766554:
                if (str.equals("next_speak_time")) {
                    c = 6;
                    break;
                }
                break;
            case -1577713210:
                if (str.equals("setting_power_save")) {
                    c = 7;
                    break;
                }
                break;
            case -1313927246:
                if (str.equals("time_hh")) {
                    c = '\b';
                    break;
                }
                break;
            case -1203637144:
                if (str.equals("remain_distance")) {
                    c = '\t';
                    break;
                }
                break;
            case -1096999257:
                if (str.equals("is_electric_car")) {
                    c = '\n';
                    break;
                }
                break;
            case -810883302:
                if (str.equals("volume")) {
                    c = 11;
                    break;
                }
                break;
            case -483842930:
                if (str.equals("rp_endnode_name")) {
                    c = '\f';
                    break;
                }
                break;
            case -385482916:
                if (str.equals("car_brand")) {
                    c = '\r';
                    break;
                }
                break;
            case -218660227:
                if (str.equals("record_permission")) {
                    c = 14;
                    break;
                }
                break;
            case -104111366:
                if (str.equals("continue_drive_time")) {
                    c = 15;
                    break;
                }
                break;
            case -44927877:
                if (str.equals("xd_cannot_wakeup_reason")) {
                    c = 16;
                    break;
                }
                break;
            case 36305106:
                if (str.equals("time_hhmm")) {
                    c = 17;
                    break;
                }
                break;
            case 57151491:
                if (str.equals("is_long_distance")) {
                    c = 18;
                    break;
                }
                break;
            case 106858757:
                if (str.equals("power")) {
                    c = 19;
                    break;
                }
                break;
            case 657776089:
                if (str.equals("is_bluetooth")) {
                    c = 20;
                    break;
                }
                break;
            case 861807107:
                if (str.equals("rg_highway")) {
                    c = 21;
                    break;
                }
                break;
            case 928092525:
                if (str.equals("driving_distance")) {
                    c = 22;
                    break;
                }
                break;
            case 950202539:
                if (str.equals("comfrom")) {
                    c = 23;
                    break;
                }
                break;
            case 1196276997:
                if (str.equals("is_day_time")) {
                    c = 24;
                    break;
                }
                break;
            case 1243876284:
                if (str.equals("setting_day_night_mode")) {
                    c = 25;
                    break;
                }
                break;
            case 1299191337:
                if (str.equals("highway_etc_fee")) {
                    c = JSONLexer.EOI;
                    break;
                }
                break;
            case 1299731016:
                if (str.equals("cloud_default_voice_switched")) {
                    c = 27;
                    break;
                }
                break;
            case 1425205564:
                if (str.equals("open_novice_setting")) {
                    c = 28;
                    break;
                }
                break;
            case 1509489764:
                if (str.equals("eta_to_end")) {
                    c = 29;
                    break;
                }
                break;
            case 1547843406:
                if (str.equals("current_voice_id")) {
                    c = 30;
                    break;
                }
                break;
            case 1954001812:
                if (str.equals("rp_approach_name_last")) {
                    c = 31;
                    break;
                }
                break;
            case 2085582055:
                if (str.equals("ischarg")) {
                    c = TokenParser.SP;
                    break;
                }
                break;
            case 2141701381:
                if (str.equals("star_voice")) {
                    c = oOoXoXO.f2346I0Io;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return String.valueOf(Integer.valueOf(new SimpleDateFormat("HHmm").format(new Date()).substring(0, 3)));
            case 1:
                com.baidu.navisdk.model.datastruct.g a2 = com.baidu.navisdk.util.logic.c.k().a(3000);
                return a2 == null ? "-1" : String.valueOf((int) a2.c);
            case 2:
                return String.valueOf(BNCommSettingManager.getInstance().getIsShowMapSwitch());
            case 3:
                return String.valueOf((System.currentTimeMillis() - this.f7042a) / 1000);
            case 4:
                return String.valueOf(e0.a(com.baidu.navisdk.framework.a.c().a()).a(SettingParams.Key.ROOKIE_MODE_SHOW, false));
            case 5:
                return String.valueOf(JNIGuidanceControl.getInstance().getViaCnt() >= 1);
            case 6:
                return String.valueOf(m());
            case 7:
                return String.valueOf(BNSettingManager.getPowerSaveMode() != 2);
            case '\b':
                return String.valueOf(Integer.valueOf(new SimpleDateFormat("HHmm").format(new Date()).substring(0, 2)));
            case '\t':
                return String.valueOf(x.d());
            case '\n':
                return String.valueOf(i());
            case 11:
                return String.valueOf(e());
            case '\f':
                String f = f();
                if (TextUtils.equals(f, JarUtils.getResources().getString(R.string.nsdk_string_route_plan_map_point))) {
                    return null;
                }
                return f;
            case '\r':
                String str2 = com.baidu.navisdk.module.routeresult.logic.plate.a.b().a().l;
                return TextUtils.isEmpty(str2) ? "无" : str2;
            case 14:
                return String.valueOf(com.baidu.navisdk.asr.f.b());
            case 15:
                return String.valueOf((System.currentTimeMillis() - this.b) / 1000);
            case 16:
                return g();
            case 17:
                return new SimpleDateFormat("HHmm").format(new Date());
            case 18:
                return String.valueOf(j());
            case 19:
                return String.valueOf(BNPowerSaver.getInstance().a());
            case 20:
                return String.valueOf(com.baidu.navisdk.bluetooth.b.i().f());
            case 21:
                return String.valueOf(x.r());
            case 22:
                return String.valueOf(JNITrajectoryControl.sInstance.getTrajectoryLength(JNITrajectoryControl.sInstance.getCurrentUUID()));
            case 23:
                return String.valueOf(d());
            case 24:
                return String.valueOf(com.baidu.navisdk.comapi.commontool.a.getInstance().a());
            case 25:
                return String.valueOf(BNSettingManager.getNaviDayAndNightMode());
            case 26:
                Bundle bundle = new Bundle();
                BNRouteGuider.getInstance().getRouteInfoInUniform(36, bundle);
                return Math.round(bundle.getDouble("fee")) + "";
            case 27:
                VoiceInterfaceImplProxy o = com.baidu.navisdk.framework.interfaces.c.p().o();
                if (o != null) {
                    return String.valueOf(o.isCloudDefaultTTSSwitched());
                }
                return null;
            case 28:
                return String.valueOf(BNSettingManager.isNoviceMode());
            case 29:
                return String.valueOf(b());
            case 30:
                VoiceInterfaceImplProxy o2 = com.baidu.navisdk.framework.interfaces.c.p().o();
                return o2 != null ? o2.getCurrentVoice() : "";
            case 31:
                ArrayList<com.baidu.navisdk.module.nearbysearch.model.a> b = com.baidu.navisdk.module.nearbysearch.model.b.INSTANCE.b();
                if (b == null || b.size() <= 0 || (aVar = b.get(b.size() - 1)) == null) {
                    return null;
                }
                return aVar.getName();
            case ' ':
                return String.valueOf(BNPowerSaver.getInstance().b());
            case '!':
                return n();
            default:
                return c(str);
        }
    }

    public String c() {
        return h.a();
    }

    public int b() {
        return x.e();
    }

    public void a(long j) {
        this.f7042a = j;
        this.b = j;
        this.c = j;
    }
}
