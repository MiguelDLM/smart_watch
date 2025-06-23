package com.sma.smartv3.pop;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.KeyboardUtils;
import com.blankj.utilcode.util.RomUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.Utils;
import com.google.gson.Gson;
import com.huawei.openalliance.ad.constant.x;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.biz.StatManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.EvaluationTimeData;
import com.sma.smartv3.util.UtilsKt;

@kotlin.jvm.internal.XX({"SMAP\nEvaluationPopup.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EvaluationPopup.kt\ncom/sma/smartv3/pop/EvaluationPopup\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,144:1\n93#2,2:145\n90#2:147\n86#2,2:148\n*S KotlinDebug\n*F\n+ 1 EvaluationPopup.kt\ncom/sma/smartv3/pop/EvaluationPopup\n*L\n74#1:145,2\n74#1:147\n73#1:148,2\n*E\n"})
/* loaded from: classes12.dex */
public final class oOXoIIIo extends OOOI.oxoX {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public final View f21468II0XooXoX;

    /* renamed from: xoIox, reason: collision with root package name */
    @OXOo.OOXIXo
    public final TextView f21469xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final TextView f21470xxIXOIIO;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oOXoIIIo(@OXOo.OOXIXo Activity activity, int i) {
        super(activity);
        kotlin.jvm.internal.IIX0o.x0xO0oo(activity, "activity");
        x0xO0oo(false);
        LayoutInflater.from(Oxx0IOOO()).inflate(i, xxIXOIIO());
        View findViewById = xxIXOIIO().findViewById(R.id.pop_center_evaluation_praise);
        kotlin.jvm.internal.IIX0o.oO(findViewById, "findViewById(...)");
        this.f21468II0XooXoX = findViewById;
        View findViewById2 = xxIXOIIO().findViewById(R.id.pop_center_evaluation_feedback);
        kotlin.jvm.internal.IIX0o.oO(findViewById2, "findViewById(...)");
        TextView textView = (TextView) findViewById2;
        this.f21470xxIXOIIO = textView;
        View findViewById3 = xxIXOIIO().findViewById(R.id.pop_center_prompt_reminders);
        kotlin.jvm.internal.IIX0o.oO(findViewById3, "findViewById(...)");
        TextView textView2 = (TextView) findViewById3;
        this.f21469xoIox = textView2;
        StatManager.f20200oIX0oI.II0xO0(7);
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.xI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                oOXoIIIo.XIxXXX0x0(oOXoIIIo.this, view);
            }
        });
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.oo0xXOI0I
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                oOXoIIIo.xxX(oOXoIIIo.this, view);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.IoOoX
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                oOXoIIIo.XxX0x0xxx(oOXoIIIo.this, view);
            }
        });
    }

    public static final void XIxXXX0x0(oOXoIIIo this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        StatManager.f20200oIX0oI.II0xO0(4);
        ooXIXxIX(this$0, false, 1, null);
        this$0.xXxxox0I();
        this$0.dismiss();
    }

    public static final void XxX0x0xxx(oOXoIIIo this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        StatManager.f20200oIX0oI.II0xO0(6);
        this$0.IIX0o(true);
        this$0.dismiss();
    }

    public static /* synthetic */ void ooXIXxIX(oOXoIIIo ooxoiiio, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        ooxoiiio.IIX0o(z);
    }

    public static final void xxX(oOXoIIIo this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        StatManager.f20200oIX0oI.II0xO0(5);
        ooXIXxIX(this$0, false, 1, null);
        ProjectManager.f19822oIX0oI.xIxooxXX(this$0.Oxx0IOOO());
        this$0.dismiss();
    }

    public final void IIX0o(boolean z) {
        com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
        SPUtils oIX0oI2 = xo0.oIX0oI();
        SPUtils oIX0oI3 = xo0.oIX0oI();
        Object fromJson = new Gson().fromJson(oIX0oI3.getString(com.sma.smartv3.util.XoI0Ixx0.f24374Ix00oIoI + '_' + EvaluationTimeData.class.getName()), (Class<Object>) EvaluationTimeData.class);
        if (fromJson == null) {
            fromJson = EvaluationTimeData.class.newInstance();
        }
        EvaluationTimeData evaluationTimeData = (EvaluationTimeData) fromJson;
        evaluationTimeData.setClickTime(System.currentTimeMillis());
        evaluationTimeData.setNoShowPop(z);
        oIX0oI2.put(com.sma.smartv3.util.XoI0Ixx0.f24374Ix00oIoI + '_' + EvaluationTimeData.class.getName(), new Gson().toJson(fromJson));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    public final void xXxxox0I() {
        Uri uri = "market://details?id=";
        String appPackageName = AppUtils.getAppPackageName();
        String str = "";
        try {
            Application app = Utils.getApp();
            kotlin.jvm.internal.IIX0o.oO(app, "getApp(...)");
            if (UtilsKt.X00IoxXI(app)) {
                if (RomUtils.isOppo()) {
                    if (Build.VERSION.SDK_INT >= 29) {
                        str = "com.heytap.market";
                    } else {
                        str = "com.oppo.market";
                    }
                    uri = Uri.parse("oppomarket://details?packagename=" + appPackageName);
                } else if (RomUtils.isHuawei()) {
                    str = x.Y;
                    uri = Uri.parse("appmarket://details?id=" + appPackageName);
                } else if (RomUtils.isXiaomi()) {
                    str = "com.xiaomi.market";
                    uri = Uri.parse("mimarket://details?id=" + appPackageName);
                } else if (RomUtils.isVivo()) {
                    str = "com.bbk.appstore";
                    uri = Uri.parse("vivoMarket://details?id=" + appPackageName);
                } else {
                    uri = Uri.parse("market://details?id=" + appPackageName);
                }
            } else {
                uri = Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName);
            }
        } catch (Exception e) {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI("gotoApplicationMarket e = " + e);
            uri = Uri.parse(uri + appPackageName);
        }
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        if (str.length() > 0) {
            intent.setPackage(str);
        }
        intent.addFlags(268435456);
        if (intent.resolveActivity(Utils.getApp().getPackageManager()) != null) {
            Oxx0IOOO().startActivity(intent);
        }
    }

    @Override // OOOI.I0Io
    public void xoXoI(@OXOo.OOXIXo View anchor) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(anchor, "anchor");
        try {
            if (Oxx0IOOO().isFinishing()) {
                return;
            }
            showAtLocation(anchor, 80, 0, 0);
            oOXoIIIo.oIX0oI.I0Io(Oxx0IOOO(), 1.0f);
            oOoXoXO().setBackgroundResource(R.color.popup_root_bg_color);
            KeyboardUtils.hideSoftInput(anchor);
            Oox.oIX0oI<kotlin.oXIO0o0XI> OOXIXo2 = OOXIXo();
            if (OOXIXo2 != null) {
                OOXIXo2.invoke();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public /* synthetic */ oOXoIIIo(Activity activity, int i, int i2, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this(activity, (i2 & 2) != 0 ? R.layout.pop_center_evaluation : i);
    }
}
