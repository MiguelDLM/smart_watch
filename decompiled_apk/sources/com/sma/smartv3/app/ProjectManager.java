package com.sma.smartv3.app;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.bestmafen.androidbase.base.BaseActivity;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.Utils;
import com.facebook.login.widget.ToolTipPopup;
import com.google.gson.Gson;
import com.huawei.openalliance.ad.utils.bc;
import com.sma.smartv3.biz.AIWatchFaceManager;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.AppUser;
import com.sma.smartv3.model.DeviceLaseRecord;
import com.sma.smartv3.model.UserMember;
import com.sma.smartv3.model.WatchFaceCategory;
import com.sma.smartv3.model.WatchFaceInfo;
import com.sma.smartv3.network.Api;
import com.sma.smartv3.ui.device.dial.DialActivity;
import com.sma.smartv3.ui.device.dial.category.DialCategoryActivity;
import com.sma.smartv3.ui.device.dialpay.WatchFaceDialPayActivity;
import com.sma.smartv3.ui.device.watchface.WatchFaceActivity;
import com.sma.smartv3.ui.login.EmailBindActivity;
import com.sma.smartv3.ui.login.LoginActivity;
import com.sma.smartv3.ui.login.PersonalInformationActivity;
import com.sma.smartv3.ui.login.PrivacyActivity;
import com.sma.smartv3.ui.login.ServerSelectActivity;
import com.sma.smartv3.ui.login.StartActivity;
import com.sma.smartv3.ui.login.StartGoogleActivity;
import com.sma.smartv3.ui.login.ooOOo0oXI;
import com.sma.smartv3.ui.main.MainActivity;
import com.sma.smartv3.ui.me.AboutActivity;
import com.sma.smartv3.ui.me.ContactUsActivity;
import com.sma.smartv3.ui.me.O0X;
import com.sma.smartv3.ui.me.ResetPasswordActivity;
import com.sma.smartv3.ui.me.WebViewActivity;
import com.sma.smartv3.ui.me.WebViewV2Activity;
import com.sma.smartv3.util.DateTimeFormat;
import com.sma.smartv3.util.UtilsKt;
import com.sma.smartv3.util.XoI0Ixx0;
import com.sma.smartv3.util.x0xO0oo;
import com.sma.smartv3.util.xoIox;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.component.BleCache;
import com.szabh.smable3.component.BleConnector;
import com.szabh.smable3.entity.BleNotification;
import com.szabh.smable3.entity.Languages;
import java.util.Iterator;
import java.util.Set;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.collections.Xo0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.text.OxI;
import oIxOXo.oxoX;

@XX({"SMAP\nProjectManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ProjectManager.kt\ncom/sma/smartv3/app/ProjectManager\n+ 2 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 5 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,3541:1\n69#2,3:3542\n72#2,5:3546\n69#2,3:3553\n72#2,5:3557\n69#2,3:3562\n72#2,5:3566\n69#2,3:3571\n72#2,5:3575\n87#2,7:3580\n94#2,3:3588\n70#2,7:3591\n97#2:3598\n87#2,7:3599\n94#2,3:3607\n70#2,7:3610\n97#2:3617\n87#2,7:3618\n94#2,3:3626\n70#2,7:3629\n97#2:3636\n87#2,7:3637\n94#2,3:3645\n70#2,7:3648\n97#2:3655\n87#2,7:3656\n94#2,3:3664\n70#2,7:3667\n97#2:3674\n87#2,7:3675\n94#2,3:3683\n70#2,7:3686\n97#2:3693\n87#2,7:3694\n94#2,3:3702\n70#2,7:3705\n97#2:3712\n87#2,7:3713\n94#2,3:3721\n70#2,7:3724\n97#2:3731\n87#2,7:3732\n94#2,3:3740\n70#2,7:3743\n97#2:3750\n87#2,7:3751\n94#2,3:3759\n70#2,7:3762\n97#2:3769\n87#2,7:3770\n94#2,3:3778\n70#2,7:3781\n97#2:3788\n87#2,7:3789\n94#2,3:3797\n70#2,7:3800\n97#2:3807\n87#2,7:3808\n94#2,3:3816\n70#2,7:3819\n97#2:3826\n87#2,7:3827\n94#2,3:3835\n70#2,7:3838\n97#2:3845\n87#2,7:3846\n94#2,3:3854\n70#2,7:3857\n97#2:3864\n87#2,7:3865\n94#2,3:3873\n70#2,7:3876\n97#2:3883\n87#2,7:3884\n94#2,3:3892\n70#2,7:3895\n97#2:3902\n87#2,7:3903\n94#2,3:3911\n70#2,7:3914\n97#2:3921\n87#2,7:3922\n94#2,3:3930\n70#2,7:3933\n97#2:3940\n87#2,7:3941\n94#2,3:3949\n70#2,7:3952\n97#2:3959\n87#2,7:3960\n94#2,3:3968\n70#2,7:3971\n97#2:3978\n87#2,7:3979\n94#2,3:3987\n70#2,7:3990\n97#2:3997\n87#2,7:3998\n94#2,3:4006\n70#2,7:4009\n97#2:4016\n87#2,7:4017\n94#2,3:4025\n70#2,7:4028\n97#2:4035\n87#2,7:4036\n94#2,3:4044\n70#2,7:4047\n97#2:4054\n87#2,7:4055\n94#2,3:4063\n70#2,7:4066\n97#2:4073\n87#2,7:4074\n94#2,3:4082\n70#2,7:4085\n97#2:4092\n87#2,7:4093\n94#2,3:4101\n70#2,7:4104\n97#2:4111\n87#2,7:4112\n94#2,3:4120\n70#2,7:4123\n97#2:4130\n87#2,7:4131\n94#2,3:4139\n70#2,7:4142\n97#2:4149\n87#2,7:4150\n94#2,3:4158\n70#2,7:4161\n97#2:4168\n87#2,7:4169\n94#2,3:4177\n70#2,7:4180\n97#2:4187\n87#2,7:4188\n94#2,3:4196\n70#2,7:4199\n97#2:4206\n87#2,7:4207\n94#2,3:4215\n70#2,7:4218\n97#2:4225\n87#2,7:4226\n94#2,3:4234\n70#2,7:4237\n97#2:4244\n87#2,7:4245\n94#2,3:4253\n70#2,7:4256\n97#2:4263\n87#2,7:4264\n94#2,3:4272\n70#2,7:4275\n97#2:4282\n87#2,7:4283\n94#2,3:4291\n70#2,7:4294\n97#2:4301\n87#2,7:4302\n94#2,3:4310\n70#2,7:4313\n97#2:4320\n87#2,7:4321\n94#2,3:4329\n70#2,7:4332\n97#2:4339\n69#2,3:4340\n72#2,5:4344\n69#2,3:4349\n72#2,5:4353\n87#2,7:4358\n94#2,3:4366\n70#2,7:4369\n97#2:4376\n87#2,7:4377\n94#2,3:4385\n70#2,7:4388\n97#2:4395\n87#2,7:4396\n94#2,3:4404\n70#2,7:4407\n97#2:4414\n87#2,7:4415\n94#2,3:4423\n70#2,7:4426\n97#2:4433\n69#2,3:4434\n72#2,5:4438\n69#2,3:4444\n72#2,5:4448\n69#2,3:4453\n72#2,5:4457\n69#2,3:4462\n72#2,5:4466\n69#2,3:4471\n72#2,5:4475\n69#2,3:4480\n72#2,5:4484\n69#2,3:4489\n72#2,5:4493\n69#2,3:4498\n72#2,5:4502\n69#2,3:4508\n72#2,5:4512\n69#2,3:4517\n72#2,5:4521\n69#2,3:4530\n72#2,5:4534\n69#2,3:4539\n72#2,5:4543\n87#2,7:4556\n94#2,3:4564\n70#2,7:4567\n97#2:4574\n1#3:3545\n1#3:3556\n1#3:3565\n1#3:3574\n1#3:3587\n1#3:3606\n1#3:3625\n1#3:3644\n1#3:3663\n1#3:3682\n1#3:3701\n1#3:3720\n1#3:3739\n1#3:3758\n1#3:3777\n1#3:3796\n1#3:3815\n1#3:3834\n1#3:3853\n1#3:3872\n1#3:3891\n1#3:3910\n1#3:3929\n1#3:3948\n1#3:3967\n1#3:3986\n1#3:4005\n1#3:4024\n1#3:4043\n1#3:4062\n1#3:4081\n1#3:4100\n1#3:4119\n1#3:4138\n1#3:4157\n1#3:4176\n1#3:4195\n1#3:4214\n1#3:4233\n1#3:4252\n1#3:4271\n1#3:4290\n1#3:4309\n1#3:4328\n1#3:4343\n1#3:4352\n1#3:4365\n1#3:4384\n1#3:4403\n1#3:4422\n1#3:4437\n1#3:4443\n1#3:4447\n1#3:4456\n1#3:4465\n1#3:4474\n1#3:4483\n1#3:4492\n1#3:4501\n1#3:4511\n1#3:4520\n1#3:4533\n1#3:4542\n1#3:4563\n19#4:3551\n15#4:3552\n90#4:4507\n86#4,2:4528\n19#4:4548\n15#4:4549\n93#4,2:4550\n90#4:4552\n93#4,2:4553\n90#4:4555\n37#5,2:4526\n*S KotlinDebug\n*F\n+ 1 ProjectManager.kt\ncom/sma/smartv3/app/ProjectManager\n*L\n440#1:3542,3\n440#1:3546,5\n770#1:3553,3\n770#1:3557,5\n796#1:3562,3\n796#1:3566,5\n814#1:3571,3\n814#1:3575,5\n843#1:3580,7\n843#1:3588,3\n843#1:3591,7\n843#1:3598\n857#1:3599,7\n857#1:3607,3\n857#1:3610,7\n857#1:3617\n861#1:3618,7\n861#1:3626,3\n861#1:3629,7\n861#1:3636\n873#1:3637,7\n873#1:3645,3\n873#1:3648,7\n873#1:3655\n877#1:3656,7\n877#1:3664,3\n877#1:3667,7\n877#1:3674\n888#1:3675,7\n888#1:3683,3\n888#1:3686,7\n888#1:3693\n894#1:3694,7\n894#1:3702,3\n894#1:3705,7\n894#1:3712\n904#1:3713,7\n904#1:3721,3\n904#1:3724,7\n904#1:3731\n936#1:3732,7\n936#1:3740,3\n936#1:3743,7\n936#1:3750\n946#1:3751,7\n946#1:3759,3\n946#1:3762,7\n946#1:3769\n954#1:3770,7\n954#1:3778,3\n954#1:3781,7\n954#1:3788\n962#1:3789,7\n962#1:3797,3\n962#1:3800,7\n962#1:3807\n973#1:3808,7\n973#1:3816,3\n973#1:3819,7\n973#1:3826\n987#1:3827,7\n987#1:3835,3\n987#1:3838,7\n987#1:3845\n995#1:3846,7\n995#1:3854,3\n995#1:3857,7\n995#1:3864\n1007#1:3865,7\n1007#1:3873,3\n1007#1:3876,7\n1007#1:3883\n1011#1:3884,7\n1011#1:3892,3\n1011#1:3895,7\n1011#1:3902\n1023#1:3903,7\n1023#1:3911,3\n1023#1:3914,7\n1023#1:3921\n1027#1:3922,7\n1027#1:3930,3\n1027#1:3933,7\n1027#1:3940\n1038#1:3941,7\n1038#1:3949,3\n1038#1:3952,7\n1038#1:3959\n1044#1:3960,7\n1044#1:3968,3\n1044#1:3971,7\n1044#1:3978\n1052#1:3979,7\n1052#1:3987,3\n1052#1:3990,7\n1052#1:3997\n1058#1:3998,7\n1058#1:4006,3\n1058#1:4009,7\n1058#1:4016\n1064#1:4017,7\n1064#1:4025,3\n1064#1:4028,7\n1064#1:4035\n1070#1:4036,7\n1070#1:4044,3\n1070#1:4047,7\n1070#1:4054\n1077#1:4055,7\n1077#1:4063,3\n1077#1:4066,7\n1077#1:4073\n1085#1:4074,7\n1085#1:4082,3\n1085#1:4085,7\n1085#1:4092\n1089#1:4093,7\n1089#1:4101,3\n1089#1:4104,7\n1089#1:4111\n1113#1:4112,7\n1113#1:4120,3\n1113#1:4123,7\n1113#1:4130\n1137#1:4131,7\n1137#1:4139,3\n1137#1:4142,7\n1137#1:4149\n1148#1:4150,7\n1148#1:4158,3\n1148#1:4161,7\n1148#1:4168\n1154#1:4169,7\n1154#1:4177,3\n1154#1:4180,7\n1154#1:4187\n1164#1:4188,7\n1164#1:4196,3\n1164#1:4199,7\n1164#1:4206\n1174#1:4207,7\n1174#1:4215,3\n1174#1:4218,7\n1174#1:4225\n1191#1:4226,7\n1191#1:4234,3\n1191#1:4237,7\n1191#1:4244\n1320#1:4245,7\n1320#1:4253,3\n1320#1:4256,7\n1320#1:4263\n1331#1:4264,7\n1331#1:4272,3\n1331#1:4275,7\n1331#1:4282\n1339#1:4283,7\n1339#1:4291,3\n1339#1:4294,7\n1339#1:4301\n1426#1:4302,7\n1426#1:4310,3\n1426#1:4313,7\n1426#1:4320\n1472#1:4321,7\n1472#1:4329,3\n1472#1:4332,7\n1472#1:4339\n1483#1:4340,3\n1483#1:4344,5\n1520#1:4349,3\n1520#1:4353,5\n1675#1:4358,7\n1675#1:4366,3\n1675#1:4369,7\n1675#1:4376\n1683#1:4377,7\n1683#1:4385,3\n1683#1:4388,7\n1683#1:4395\n1747#1:4396,7\n1747#1:4404,3\n1747#1:4407,7\n1747#1:4414\n1755#1:4415,7\n1755#1:4423,3\n1755#1:4426,7\n1755#1:4433\n1759#1:4434,3\n1759#1:4438,5\n2676#1:4444,3\n2676#1:4448,5\n2678#1:4453,3\n2678#1:4457,5\n2698#1:4462,3\n2698#1:4466,5\n2717#1:4471,3\n2717#1:4475,5\n2748#1:4480,3\n2748#1:4484,5\n2889#1:4489,3\n2889#1:4493,5\n2892#1:4498,3\n2892#1:4502,5\n2903#1:4508,3\n2903#1:4512,5\n2906#1:4517,3\n2906#1:4521,5\n2914#1:4530,3\n2914#1:4534,5\n2973#1:4539,3\n2973#1:4543,5\n3227#1:4556,7\n3227#1:4564,3\n3227#1:4567,7\n3227#1:4574\n440#1:3545\n770#1:3556\n796#1:3565\n814#1:3574\n843#1:3587\n857#1:3606\n861#1:3625\n873#1:3644\n877#1:3663\n888#1:3682\n894#1:3701\n904#1:3720\n936#1:3739\n946#1:3758\n954#1:3777\n962#1:3796\n973#1:3815\n987#1:3834\n995#1:3853\n1007#1:3872\n1011#1:3891\n1023#1:3910\n1027#1:3929\n1038#1:3948\n1044#1:3967\n1052#1:3986\n1058#1:4005\n1064#1:4024\n1070#1:4043\n1077#1:4062\n1085#1:4081\n1089#1:4100\n1113#1:4119\n1137#1:4138\n1148#1:4157\n1154#1:4176\n1164#1:4195\n1174#1:4214\n1191#1:4233\n1320#1:4252\n1331#1:4271\n1339#1:4290\n1426#1:4309\n1472#1:4328\n1483#1:4343\n1520#1:4352\n1675#1:4365\n1683#1:4384\n1747#1:4403\n1755#1:4422\n1759#1:4437\n2676#1:4447\n2678#1:4456\n2698#1:4465\n2717#1:4474\n2748#1:4483\n2889#1:4492\n2892#1:4501\n2903#1:4511\n2906#1:4520\n2914#1:4533\n2973#1:4542\n3227#1:4563\n646#1:3551\n646#1:3552\n2896#1:4507\n2911#1:4528,2\n2987#1:4548\n2987#1:4549\n3010#1:4550,2\n3010#1:4552\n3174#1:4553,2\n3174#1:4555\n2912#1:4526,2\n*E\n"})
/* loaded from: classes12.dex */
public final class ProjectManager {

    /* renamed from: I0Io, reason: collision with root package name */
    @OOXIXo
    public static DateTimeFormat f19819I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    @OOXIXo
    public static final X0IIOO f19820II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final boolean f19821X0o0xo = false;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OOXIXo
    public static final ProjectManager f19822oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    @OOXIXo
    public static final Set<String> f19823oxoX;

    static {
        ProjectManager projectManager = new ProjectManager();
        f19822oIX0oI = projectManager;
        f19820II0xO0 = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<String[]>() { // from class: com.sma.smartv3.app.ProjectManager$defaultNotificationList$2
            @Override // Oox.oIX0oI
            @OOXIXo
            public final String[] invoke() {
                return new String[]{BleNotification.ZALO, BleNotification.SKYPE, "com.facebook.orca", BleNotification.FACEBOOK_MESSENGER_LITE, "com.facebook.katana", BleNotification.FACEBOOK_LITE, BleNotification.WHATS_APP, BleNotification.LINE, BleNotification.INSTAGRAM, BleNotification.KAKAO_TALK, BleNotification.GMAIL, BleNotification.TWITTER, BleNotification.LINKED_IN, "com.sina.weibo", "com.tencent.mobileqq", "com.tencent.mm", BleNotification.OUT_LOOK, BleNotification.OUT_LOOK2, BleNotification.YAHOO_MAIL, BleNotification.VIBER, BleNotification.BAND, BleNotification.TELEGRAM, BleNotification.BETWEEN, BleNotification.NAVERCAFE, BleNotification.YOUTUBE, BleNotification.NETFLIX, BleNotification.GOOGLE_DUO, BleNotification.SNAPCHAT, BleNotification.TRILL, BleNotification.SEARCH, BleNotification.SECURESMS, BleNotification.UC, BleNotification.VK, BleNotification.TOWNEERS, BleNotification.HEROMTS, BleNotification.CAFE, BleNotification.MEITUAN, BleNotification.ALIBABA_RIMET, BleNotification.MEITUAN_TAKEOUTNEW};
            }
        });
        f19819I0Io = DateTimeFormat.Companion.oIX0oI(BleCache.getInt$default(BleCache.INSTANCE, BleKey.DATE_FORMAT, projectManager.IXxxXO().getType(), null, 4, null));
        f19823oxoX = Xo0.OOXIXo();
    }

    public final boolean I0() {
        return !ProductManager.xOOxIO(ProductManager.f20544oIX0oI, null, 1, null);
    }

    public final void I0Io() {
        com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
        if (!xo0.XO().contains(XoI0Ixx0.f24383O0xOxO)) {
            xo0.XO().put(XoI0Ixx0.f24383O0xOxO, ooOOo0oXI.f23074oIX0oI);
        }
    }

    public final boolean I0X0x0oIo() {
        IIX0o.oO(Utils.getApp(), "getApp(...)");
        return !UtilsKt.X00IoxXI(r0);
    }

    public final boolean I0oOIX() {
        SPUtils XO2 = com.sma.smartv3.util.Xo0.f24349oIX0oI.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        if (fromJson != null) {
            appUser = fromJson;
        }
        if (((AppUser) appUser).getGender() == 1 && ProductManager.f20544oIX0oI.IXxxXO()) {
            return false;
        }
        return ProductManager.f20544oIX0oI.xoO0xx0();
    }

    public final boolean I0oOoX() {
        return ProductManager.f20544oIX0oI.oXxx000();
    }

    public final boolean I0xX0() {
        return true;
    }

    public final void II0XooXoX() {
        com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
        if (!xo0.oIX0oI().contains(XoI0Ixx0.f24490xoIxX)) {
            Application app = Utils.getApp();
            IIX0o.oO(app, "getApp(...)");
            if (UtilsKt.X00IoxXI(app)) {
                xo0.oIX0oI().put(XoI0Ixx0.f24490xoIxX, 0);
            } else {
                xo0.oIX0oI().put(XoI0Ixx0.f24490xoIxX, 1);
            }
        }
    }

    public final void II0xO0() {
        com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
        if (!xo0.XO().contains(XoI0Ixx0.f24492xoXoI)) {
            xo0.XO().put(XoI0Ixx0.f24492xoXoI, true);
        }
    }

    public final boolean IIOIX() {
        return false;
    }

    public final boolean IIX0() {
        if (oOo() && ProductManager.f20544oIX0oI.oX000x()) {
            return true;
        }
        return false;
    }

    @OOXIXo
    public final String IIX0o() {
        return "https://api.c.iot-solution.net/web/Shark_Wear/webs/user_agreement.html";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004c A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:5:0x004f A[ORIG_RETURN, RETURN] */
    @OXOo.OOXIXo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String IIXOooo() {
        /*
            r2 = this;
            com.szabh.smable3.component.BleCache r0 = com.szabh.smable3.component.BleCache.INSTANCE
            java.lang.String r0 = r0.getMBleName()
            int r1 = r0.hashCode()
            switch(r1) {
                case -2059344592: goto L44;
                case -328841332: goto L3b;
                case -322406165: goto L32;
                case 419745991: goto L29;
                case 419746052: goto L20;
                case 419746086: goto L17;
                case 2080171678: goto Le;
                default: goto Ld;
            }
        Ld:
            goto L4c
        Le:
            java.lang.String r1 = "GIZFIT 910 PRO"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L4f
            goto L4c
        L17:
            java.lang.String r1 = "Gizmore 966"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L4f
            goto L4c
        L20:
            java.lang.String r1 = "Gizmore 953"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L4f
            goto L4c
        L29:
            java.lang.String r1 = "Gizmore 934"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L4f
            goto L4c
        L32:
            java.lang.String r1 = "Gizmore Vogue"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L4f
            goto L4c
        L3b:
            java.lang.String r1 = "Gizmore PRIME"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L4c
            goto L4f
        L44:
            java.lang.String r1 = "GIZFIT 953"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L4f
        L4c:
            java.lang.String r0 = "https://www.facebook.com/goingfit.aftersales"
            goto L51
        L4f:
            java.lang.String r0 = "https://www.facebook.com/gizmoreindia/"
        L51:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.app.ProjectManager.IIXOooo():java.lang.String");
    }

    public final boolean IIxOXoOo0() {
        return false;
    }

    public final boolean IO() {
        return xoIox.ooXIXxIX();
    }

    public final boolean IO0XoXxO() {
        return false;
    }

    public final void IOOoXo0Ix(@OOXIXo Activity activity) {
        IIX0o.x0xO0oo(activity, "activity");
        if (!com.sma.smartv3.util.Xo0.f24349oIX0oI.XO().getBoolean(XoI0Ixx0.f24370IoOoX, false)) {
            activity.startActivity(new Intent(activity, (Class<?>) EmailBindActivity.class));
        }
    }

    public final boolean IOoo() {
        return false;
    }

    public final boolean IXO() {
        return true;
    }

    @OOXIXo
    public final DateTimeFormat IXxxXO() {
        return ProductManager.f20544oIX0oI.oOoXoXO();
    }

    public final boolean Io() {
        return true;
    }

    public final boolean IoIOOxIIo() {
        return false;
    }

    public final boolean IoOoX() {
        return oXO0oOx0();
    }

    public final boolean IoOoo() {
        return false;
    }

    public final boolean IoXIXo() {
        return false;
    }

    public final boolean Ioxxx() {
        return true;
    }

    public final void Ix0(@OOXIXo Activity context) {
        IIX0o.x0xO0oo(context, "context");
        context.startActivity(new Intent(context, (Class<?>) ContactUsActivity.class));
    }

    public final boolean Ix00oIoI() {
        return o0oxo0oI();
    }

    public final boolean IxIX0I() {
        return false;
    }

    public final boolean IxIo() {
        if (xI().getLatestDateTime() > 0 && xI().getServerDateTime() > 0 && xI().getServerDateTime() < xI().getLatestDateTime() && xIOXX()) {
            return true;
        }
        return false;
    }

    public final boolean IxX00() {
        return false;
    }

    public final boolean O0() {
        return true;
    }

    public final boolean O00() {
        return false;
    }

    public final boolean O00XxXI() {
        return false;
    }

    public final boolean O0IxXx() {
        return false;
    }

    public final void O0OOX0IIx(@OOXIXo Activity activity) {
        IIX0o.x0xO0oo(activity, "activity");
        activity.startActivity(new Intent(activity, (Class<?>) PersonalInformationActivity.class));
    }

    public final boolean O0X() {
        if (oOo() && ProductManager.f20544oIX0oI.X0ooXIooI()) {
            return true;
        }
        return false;
    }

    public final boolean O0Xx() {
        return true;
    }

    public final void O0x(@OOXIXo Activity activity) {
        IIX0o.x0xO0oo(activity, "activity");
        ToastUtils.showLong("no function", new Object[0]);
    }

    public final int O0xOxO() {
        return 3000;
    }

    public final boolean O0xxXxI() {
        return true;
    }

    public final boolean OI0() {
        return true;
    }

    public final boolean OIOoIIOIx() {
        return true;
    }

    public final boolean OIx00oxx() {
        return false;
    }

    public final void OIxOX(@OOXIXo Activity context) {
        IIX0o.x0xO0oo(context, "context");
        if (AIWatchFaceManager.f19897oIX0oI.oO()) {
            ToastUtils.showLong(R.string.watchface_sycning_tip);
            return;
        }
        OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
        StringBuilder sb = new StringBuilder();
        sb.append("Online WatchFaceData Server = ");
        ProductManager productManager = ProductManager.f20544oIX0oI;
        sb.append(productManager.Ox0XO());
        sb.append(" , pay = ");
        sb.append(oOoIIO0());
        oix0oi.oIX0oI(sb.toString());
        if (productManager.Ox0XO()) {
            if (oOoIIO0()) {
                context.startActivity(new Intent(context, (Class<?>) WatchFaceDialPayActivity.class));
                return;
            } else {
                context.startActivity(new Intent(context, (Class<?>) WatchFaceActivity.class));
                return;
            }
        }
        com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
        SPUtils I0Io2 = xo0.I0Io();
        WatchFaceCategory[] watchFaceCategoryArr = (WatchFaceCategory[]) new Gson().fromJson(I0Io2.getString(XoI0Ixx0.f24465oxXx0IX + '_' + WatchFaceCategory[].class.getName()), WatchFaceCategory[].class);
        if (watchFaceCategoryArr == null && !xo0.I0Io().contains(XoI0Ixx0.f24467oxxXoxO) && !XX()) {
            oix0oi.oIX0oI("Old WatchFace");
            xo0.I0Io().put(XoI0Ixx0.f24488xo0x + '_' + WatchFaceInfo[].class.getName(), new Gson().toJson(productManager.XOxxooXI().toArray(new WatchFaceInfo[0])));
            context.startActivity(new Intent(context, (Class<?>) DialActivity.class));
            return;
        }
        if (watchFaceCategoryArr != null) {
            oix0oi.oIX0oI("Category WatchFace");
            context.startActivity(new Intent(context, (Class<?>) DialCategoryActivity.class));
        } else {
            oix0oi.oIX0oI("List WatchFace");
            context.startActivity(new Intent(context, (Class<?>) DialActivity.class));
        }
    }

    public final void OIxx0I0(@OOXIXo Activity activity) {
        IIX0o.x0xO0oo(activity, "activity");
        Bundle bundle = new Bundle();
        bundle.putString("mArg0", "https://api.c.iot-solution.net/web/cn/co_fit/webs/privacy.html");
        bundle.putParcelable("mArg2", null);
        bundle.putSerializable("mArg3", null);
        Intent intent = new Intent(activity, (Class<?>) WebViewActivity.class);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    public final boolean OO() {
        Application app = Utils.getApp();
        IIX0o.oO(app, "getApp(...)");
        return UtilsKt.X00IoxXI(app);
    }

    public final boolean OO0() {
        return true;
    }

    public final boolean OO0x0xX() {
        return true;
    }

    public final boolean OOIXx0x() {
        return false;
    }

    public final boolean OOOI() {
        return true;
    }

    public final String OOXIXo(Activity activity) {
        String string = activity.getString(R.string.app_name);
        IIX0o.oO(string, "getString(...)");
        return OxI.IIOIX(string, " ", "%20", false, 4, null);
    }

    public final boolean OOXIxO0() {
        return false;
    }

    public final boolean OOxOI() {
        return true;
    }

    public final boolean OX() {
        return true;
    }

    public final boolean OX00O0xII() {
        return true;
    }

    public final boolean OXXoIoXI() {
        return true;
    }

    public final int Oo() {
        return 2;
    }

    public final boolean OoO() {
        return true;
    }

    public final boolean OooI() {
        return BleConnector.INSTANCE.isBound();
    }

    public final void OooO0XOx(@OOXIXo Activity activity) {
        IIX0o.x0xO0oo(activity, "activity");
        activity.startActivity(new Intent(activity, (Class<?>) ServerSelectActivity.class));
    }

    public final boolean Ox0O() {
        return false;
    }

    @OOXIXo
    public final String OxI() {
        return "https://line.me";
    }

    public final boolean OxO() {
        return true;
    }

    public final boolean OxXXx0X() {
        return false;
    }

    public final void Oxo00O(@OOXIXo Activity activity) {
        IIX0o.x0xO0oo(activity, "activity");
        Bundle bundle = new Bundle();
        bundle.putString("mArg0", "https://api.iot-solution.net/web/help/blood_glucose.html");
        bundle.putInt("mArg1", 2);
        bundle.putParcelable("mArg2", null);
        bundle.putSerializable("mArg3", null);
        Intent intent = new Intent(activity, (Class<?>) WebViewActivity.class);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    public final boolean Oxx() {
        return false;
    }

    public final void Oxx0IOOO() {
        String[] strArr = {BleNotification.SKYPE, "com.facebook.orca", BleNotification.FACEBOOK_MESSENGER_LITE, "com.facebook.katana", BleNotification.FACEBOOK_LITE, BleNotification.WHATS_APP, BleNotification.LINE, BleNotification.INSTAGRAM, BleNotification.KAKAO_TALK, BleNotification.GMAIL, BleNotification.TWITTER, BleNotification.LINKED_IN, "com.sina.weibo", "com.tencent.mobileqq", "com.tencent.mm", BleNotification.OUT_LOOK, BleNotification.OUT_LOOK2, BleNotification.YAHOO_MAIL, BleNotification.VIBER, "com.android.mms", BleNotification.GOOGLE_MMS, BleNotification.SAMSUNG_MMS, BleNotification.ANDROID_INCALLUI, BleNotification.ANDROID_TELECOM, BleNotification.GOOGLE_TELECOM, BleNotification.SAMSUNG_TELECOM, BleNotification.SAMSUNG_INCALLUI, BleNotification.BAND, BleNotification.TELEGRAM, BleNotification.BETWEEN, BleNotification.NAVERCAFE, BleNotification.YOUTUBE, BleNotification.NETFLIX, BleNotification.GOOGLE_DUO, BleNotification.SNAPCHAT, BleNotification.TRILL, BleNotification.SEARCH, BleNotification.SECURESMS, BleNotification.UC, BleNotification.TOWNEERS, BleNotification.HEROMTS, BleNotification.CAFE, BleNotification.VK, BleNotification.MEITUAN, BleNotification.ALIBABA_RIMET, BleNotification.MEITUAN_TAKEOUTNEW, BleNotification.ZALO};
        for (int i = 0; i < 47; i++) {
            String str = strArr[i];
            com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
            if (!xo0.I0Io().contains(XoI0Ixx0.f24443oIX0oI + str)) {
                xo0.I0Io().put(XoI0Ixx0.f24443oIX0oI + str, true);
            }
        }
    }

    public final boolean Oxx0xo() {
        return x0o();
    }

    public final long OxxIIOOXO() {
        return 60000L;
    }

    public final boolean X00IoxXI() {
        return false;
    }

    public final boolean X00xOoXI() {
        return false;
    }

    public final long X0IIOO() {
        if (O0X() || XIXIX()) {
            return ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME;
        }
        return 1000L;
    }

    public final void X0IOOI(@OOXIXo Activity activity) {
        IIX0o.x0xO0oo(activity, "activity");
        String str = "https://api.iot-solution.net/web/help/faq.html?pid=2&app=" + OOXIXo(activity) + kotlin.text.XIxXXX0x0.f29558oxoX + oO() + "&lang=" + o00(activity);
        Bundle bundle = new Bundle();
        bundle.putString("mArg0", str);
        bundle.putInt("mArg1", 2);
        bundle.putParcelable("mArg2", null);
        bundle.putSerializable("mArg3", null);
        Intent intent = new Intent(activity, (Class<?>) WebViewActivity.class);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    public final boolean X0O0I0() {
        return true;
    }

    public final void X0o0xo() {
    }

    public final boolean X0ooXIooI() {
        return false;
    }

    public final boolean X0xII0I() {
        return false;
    }

    public final boolean X0xxXX0() {
        return false;
    }

    public final boolean XI() {
        return false;
    }

    public final int XI0IXoo() {
        return 108;
    }

    public final boolean XI0oooXX() {
        return true;
    }

    public final boolean XIXIX() {
        if (xOOOX() && ProductManager.f20544oIX0oI.X0ooXIooI()) {
            return true;
        }
        return false;
    }

    public final boolean XIXIxO() {
        return false;
    }

    public final boolean XIo0oOXIx() {
        return true;
    }

    public final boolean XIxXXX0x0() {
        return true;
    }

    public final void XO(@OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "context");
        com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
        if (!xo0.oIX0oI().contains(XoI0Ixx0.f24367IXxxXO)) {
            xo0.oIX0oI().put(XoI0Ixx0.f24367IXxxXO, true);
        }
    }

    public final boolean XO00XOO() {
        return false;
    }

    public final boolean XO0o() {
        return false;
    }

    public final boolean XOxIOxOx() {
        SPUtils oIX0oI2 = com.sma.smartv3.util.Xo0.f24349oIX0oI.oIX0oI();
        Object fromJson = new Gson().fromJson(oIX0oI2.getString(XoI0Ixx0.f24463oxIIX0o + '_' + DeviceLaseRecord.class.getName()), (Class<Object>) DeviceLaseRecord.class);
        if (fromJson == null) {
            fromJson = DeviceLaseRecord.class.newInstance();
        }
        if (((DeviceLaseRecord) fromJson).getBleVersion().length() > 0) {
            return true;
        }
        return false;
    }

    public final void XOxoX(@OOXIXo DateTimeFormat dateTimeFormat) {
        IIX0o.x0xO0oo(dateTimeFormat, "<set-?>");
        f19819I0Io = dateTimeFormat;
    }

    public final boolean XOxxooXI() {
        return false;
    }

    public final boolean XX() {
        if (BleCache.INSTANCE.getMWatchFaceType() == 99) {
            return true;
        }
        return false;
    }

    public final boolean XX0() {
        ProductManager productManager = ProductManager.f20544oIX0oI;
        if (!ProductManager.xOOxIO(productManager, null, 1, null) && !productManager.Xo()) {
            return true;
        }
        return false;
    }

    public final boolean XX0xXo() {
        return false;
    }

    public final boolean XXXI() {
        return false;
    }

    public final boolean XXoOx0() {
        return false;
    }

    public final boolean Xo() {
        return true;
    }

    public final boolean Xo0() {
        return ProductManager.f20544oIX0oI.IIxOXoOo0();
    }

    public final boolean XoI0Ixx0() {
        return ProductManager.f20544oIX0oI.XIo0oOXIx();
    }

    public final boolean XoIxOXIXo() {
        return true;
    }

    public final boolean XoOxI0ox() {
        oxxXoxO();
        return false;
    }

    public final boolean XoX() {
        return false;
    }

    public final boolean XooIO0oo0() {
        return false;
    }

    public final boolean Xx000oIo() {
        return false;
    }

    public final void XxIo(@OOXIXo Activity activity) {
        IIX0o.x0xO0oo(activity, "activity");
        if (ProductManager.f20544oIX0oI.xIx()) {
            String str = "https://api.iot-solution.net/web/help/ring_help.html?pid=2&app=" + OOXIXo(activity) + kotlin.text.XIxXXX0x0.f29558oxoX + oO() + "&lang=" + o00(activity);
            Bundle bundle = new Bundle();
            bundle.putString("mArg0", str);
            bundle.putInt("mArg1", 2);
            bundle.putParcelable("mArg2", null);
            bundle.putSerializable("mArg3", null);
            Intent intent = new Intent(activity, (Class<?>) WebViewActivity.class);
            intent.putExtras(bundle);
            activity.startActivity(intent);
            return;
        }
        String str2 = "https://api.iot-solution.net/web/help/doc/#/index?pid=2&app=" + OOXIXo(activity) + kotlin.text.XIxXXX0x0.f29558oxoX + oO() + "&lang=" + o00(activity);
        Bundle bundle2 = new Bundle();
        bundle2.putString("mArg0", str2);
        bundle2.putInt("mArg1", 2);
        bundle2.putParcelable("mArg2", null);
        bundle2.putSerializable("mArg3", null);
        Intent intent2 = new Intent(activity, (Class<?>) WebViewActivity.class);
        intent2.putExtras(bundle2);
        activity.startActivity(intent2);
    }

    public final int XxX0x0xxx() {
        return 0;
    }

    public final void XxXX(@OOXIXo Activity activity) {
        IIX0o.x0xO0oo(activity, "activity");
        if (f19821X0o0xo) {
            activity.startActivity(new Intent(activity, (Class<?>) StartGoogleActivity.class));
        } else {
            activity.startActivity(new Intent(activity, (Class<?>) StartActivity.class));
        }
    }

    public final boolean o0() {
        return true;
    }

    @OOXIXo
    public final String o00(@OOXIXo Activity activity) {
        IIX0o.x0xO0oo(activity, "activity");
        String language = activity.getResources().getConfiguration().locale.getLanguage();
        if (language != null) {
            int hashCode = language.hashCode();
            if (hashCode != 3246) {
                if (hashCode != 3383) {
                    if (hashCode != 3428) {
                        if (hashCode != 3580) {
                            if (hashCode != 3588) {
                                if (hashCode != 3886) {
                                    if (hashCode != 115813226) {
                                        if (hashCode == 115813762 && language.equals("zh-TW")) {
                                            return "zh_TW";
                                        }
                                        return Languages.DEFAULT_LANGUAGE;
                                    }
                                    if (language.equals(bc.Code)) {
                                        return "zh_CN";
                                    }
                                    return Languages.DEFAULT_LANGUAGE;
                                }
                                if (language.equals(Languages.DEFAULT_LANGUAGE_ZH)) {
                                    return "zh_CN";
                                }
                                return Languages.DEFAULT_LANGUAGE;
                            }
                            if (language.equals("pt")) {
                                return "pt";
                            }
                            return Languages.DEFAULT_LANGUAGE;
                        }
                        if (language.equals("pl")) {
                            return "pl";
                        }
                        return Languages.DEFAULT_LANGUAGE;
                    }
                    if (language.equals("ko")) {
                        return "ko";
                    }
                    return Languages.DEFAULT_LANGUAGE;
                }
                if (language.equals("ja")) {
                    return "ja";
                }
                return Languages.DEFAULT_LANGUAGE;
            }
            if (language.equals("es")) {
                return "es";
            }
            return Languages.DEFAULT_LANGUAGE;
        }
        return Languages.DEFAULT_LANGUAGE;
    }

    public final boolean o0IXXIx() {
        return false;
    }

    public final void o0Oo(@OOXIXo Activity activity) {
        IIX0o.x0xO0oo(activity, "activity");
    }

    public final boolean o0Xo() {
        return false;
    }

    public final boolean o0oIxOo() {
        return true;
    }

    public final boolean o0oxo0oI() {
        return false;
    }

    public final boolean o0xxxXXxX() {
        return false;
    }

    public final boolean oI() {
        return true;
    }

    @OOXIXo
    public final String[] oI0IIXIo() {
        return (String[]) f19820II0xO0.getValue();
    }

    public final boolean oIIxXoo() {
        return true;
    }

    public final boolean oIX0oI(@oOoXoXO String str) {
        Object obj;
        Iterator<T> it = f19823oxoX.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (OxI.oX0I0O((String) obj, str, true)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        if (((String) obj) != null) {
            return true;
        }
        return false;
    }

    public final String oO() {
        return "isDarkMode=" + oxoX.II0XooXoX().OxxIIOOXO();
    }

    public final boolean oOXoIIIo() {
        return false;
    }

    public final boolean oOo() {
        return com.sma.smartv3.util.Xo0.f24349oIX0oI.oIX0oI().getBoolean(XoI0Ixx0.f24489xoIox, false);
    }

    public final boolean oOoIIO0() {
        return false;
    }

    public final boolean oOoXoXO() {
        return false;
    }

    public final boolean oX() {
        return ProductManager.f20544oIX0oI.oox000IX();
    }

    public final boolean oX000x() {
        return true;
    }

    public final boolean oX0I0O() {
        return false;
    }

    public final boolean oX0ooo0I0(@oOoXoXO String str) {
        return false;
    }

    public final boolean oXIO0o0XI() {
        if (xOOOX() && ProductManager.f20544oIX0oI.oX000x()) {
            return true;
        }
        return false;
    }

    public final boolean oXIoO() {
        return true;
    }

    public final boolean oXO0oOx0() {
        String base_url = Api.INSTANCE.getBASE_URL();
        int hashCode = base_url.hashCode();
        if (hashCode == -267129270 ? !base_url.equals(O0X.f23385II0xO0) : !(hashCode == 1582655416 ? base_url.equals(ooOOo0oXI.f23071I0Io) : !(hashCode != 1816079795 || !base_url.equals(O0X.f23389oIX0oI)))) {
            return false;
        }
        return true;
    }

    public final boolean oXX0IoI() {
        return true;
    }

    public final boolean oXxOI0oIx() {
        return false;
    }

    public final boolean oXxx000() {
        return true;
    }

    public final int oo() {
        return 0;
    }

    public final boolean oo00() {
        return true;
    }

    public final void oo0oIXo(@OOXIXo Activity activity) {
        IIX0o.x0xO0oo(activity, "activity");
        oOXoIIIo.oIX0oI.xxX(activity, "https://api.iot-solution.net/web/help/message_reminder.html");
    }

    @OOXIXo
    public final String oo0xXOI0I() {
        return "https://www.whatsapp.com/";
    }

    @OOXIXo
    public final String ooOOo0oXI() {
        return "";
    }

    public final boolean ooOx() {
        if (XooIO0oo0() && xIOXX() && XOxIOxOx()) {
            return true;
        }
        return false;
    }

    @OOXIXo
    public final String ooXIXxIX() {
        SPUtils XO2 = com.sma.smartv3.util.Xo0.f24349oIX0oI.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        if (fromJson != null) {
            appUser = fromJson;
        }
        return ((AppUser) appUser).getIdentity();
    }

    public final boolean ox() {
        return false;
    }

    public final boolean oxIIX0o() {
        return false;
    }

    public final void oxIO0IIo(@OOXIXo Activity activity) {
        IIX0o.x0xO0oo(activity, "activity");
        activity.startActivity(new Intent(activity, (Class<?>) LoginActivity.class));
    }

    public final boolean oxOXxoXII() {
        return true;
    }

    public final boolean oxXx0IX() {
        return true;
    }

    public final void oxoX() {
        SPUtils.getInstance().put(BaseActivity.SCREEN_ORIENTATION_PORTRAIT, true);
    }

    public final boolean oxxXoxO() {
        return true;
    }

    public final boolean x0() {
        return false;
    }

    public final boolean x00IOx() {
        return true;
    }

    public final boolean x0OIX00oO() {
        return true;
    }

    public final boolean x0OxxIOxX() {
        return false;
    }

    @OOXIXo
    public final DateTimeFormat x0XOIxOo() {
        return f19819I0Io;
    }

    public final boolean x0o() {
        return false;
    }

    public final void x0oxIIIX(@OOXIXo Activity context) {
        IIX0o.x0xO0oo(context, "context");
        context.startActivity(new Intent(context, (Class<?>) MainActivity.class));
    }

    public final boolean x0xO() {
        return ProductManager.f20544oIX0oI.XIXIX();
    }

    public final int x0xO0oo() {
        return 2;
    }

    @OOXIXo
    public final UserMember xI() {
        SPUtils XO2 = com.sma.smartv3.util.Xo0.f24349oIX0oI.XO();
        Object fromJson = new Gson().fromJson(XO2.getString(x0xO0oo.f24656xOoOIoI + '_' + UserMember.class.getName()), (Class<Object>) UserMember.class);
        if (fromJson == null) {
            fromJson = UserMember.class.newInstance();
        }
        return (UserMember) fromJson;
    }

    public final boolean xI0oxI00() {
        return false;
    }

    public final boolean xII() {
        return f19821X0o0xo;
    }

    public final boolean xIOXX() {
        if (ooXIXxIX().length() > 0) {
            return true;
        }
        return false;
    }

    public final void xIXIOX(@oOoXoXO View view, @oOoXoXO View view2, @oOoXoXO View view3, @oOoXoXO View view4, @oOoXoXO View view5, @oOoXoXO View view6) {
        if (view != null) {
            view.setVisibility(0);
        }
        if (view2 != null) {
            view2.setVisibility(0);
        }
        if (view3 != null) {
            view3.setVisibility(0);
        }
        if (view4 != null) {
            view4.setVisibility(8);
        }
        if (view5 != null) {
            view5.setVisibility(8);
        }
        if (view6 != null) {
            view6.setVisibility(0);
        }
    }

    public final boolean xIXX() {
        return true;
    }

    public final boolean xIx() {
        return false;
    }

    public final boolean xIx0XO() {
        return false;
    }

    public final void xIxooxXX(@OOXIXo Activity activity) {
        String str;
        IIX0o.x0xO0oo(activity, "activity");
        if (oXIoO()) {
            if (IIX0o.Oxx0IOOO(Api.INSTANCE.getBASE_URL(), O0X.f23389oIX0oI)) {
                str = "https://dev.iot-solution.net/feedback/";
            } else {
                str = "https://api.iot-solution.net/feedback/";
            }
            Bundle bundle = new Bundle();
            bundle.putString("mArg0", str);
            bundle.putParcelable("mArg2", null);
            bundle.putSerializable("mArg3", null);
            Intent intent = new Intent(activity, (Class<?>) WebViewV2Activity.class);
            intent.putExtras(bundle);
            activity.startActivity(intent);
            return;
        }
        oOXoIIIo.oIX0oI.xxX(activity, "https://support.qq.com/product/496210");
    }

    public final boolean xOOOX() {
        com.sma.smartv3.util.Xo0.f24349oIX0oI.oIX0oI().getBoolean(XoI0Ixx0.f24489xoIox, false);
        return false;
    }

    public final boolean xOOxI() {
        return true;
    }

    public final boolean xOOxIO() {
        return false;
    }

    public final boolean xOoOIoI() {
        return ProductManager.f20544oIX0oI.XXoO0oX();
    }

    public final boolean xX() {
        return false;
    }

    public final boolean xX0IIXIx0() {
        return false;
    }

    public final boolean xXOx() {
        return false;
    }

    public final boolean xXoOI00O() {
        return false;
    }

    @OOXIXo
    public final Set<String> xXxxox0I() {
        return f19823oxoX;
    }

    public final void xo(@OOXIXo Activity activity) {
        IIX0o.x0xO0oo(activity, "activity");
        activity.startActivity(new Intent(activity, (Class<?>) AboutActivity.class));
    }

    public final boolean xo0x() {
        return BleCache.INSTANCE.getMDataKeys().contains(Integer.valueOf(BleKey.BLOOD_PRESSURE.getMKey()));
    }

    public final void xoIox() {
        com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
        if (!xo0.oIX0oI().contains(XoI0Ixx0.f24444oO)) {
            xo0.oIX0oI().put(XoI0Ixx0.f24444oO, 1);
        }
    }

    public final boolean xoIxX() {
        return true;
    }

    public final boolean xoO0xx0() {
        return true;
    }

    public final void xoX(@OOXIXo Activity activity) {
        IIX0o.x0xO0oo(activity, "activity");
        activity.startActivity(new Intent(activity, (Class<?>) PrivacyActivity.class));
    }

    public final int xoXoI() {
        return R.string.alt_trirdparty_tip;
    }

    public final void xox(@OOXIXo Activity activity) {
        IIX0o.x0xO0oo(activity, "activity");
        if (ProductManager.f20544oIX0oI.xIx()) {
            String str = "https://api.iot-solution.net/web/help/ring_faq.html?pid=2&app=" + OOXIXo(activity) + kotlin.text.XIxXXX0x0.f29558oxoX + oO() + "&lang=" + o00(activity);
            Bundle bundle = new Bundle();
            bundle.putString("mArg0", str);
            bundle.putInt("mArg1", 2);
            bundle.putParcelable("mArg2", null);
            bundle.putSerializable("mArg3", null);
            Intent intent = new Intent(activity, (Class<?>) WebViewActivity.class);
            intent.putExtras(bundle);
            activity.startActivity(intent);
            return;
        }
        String str2 = "https://api.iot-solution.net/web/help/doc/#/faq?pid=2&app=" + OOXIXo(activity) + kotlin.text.XIxXXX0x0.f29558oxoX + oO() + "&lang=" + o00(activity);
        Bundle bundle2 = new Bundle();
        bundle2.putString("mArg0", str2);
        bundle2.putInt("mArg1", 2);
        bundle2.putParcelable("mArg2", null);
        bundle2.putSerializable("mArg3", null);
        Intent intent2 = new Intent(activity, (Class<?>) WebViewActivity.class);
        intent2.putExtras(bundle2);
        activity.startActivity(intent2);
    }

    public final boolean xoxXI() {
        return !ProductManager.f20544oIX0oI.xxxI();
    }

    public final void xx0(@OOXIXo Activity activity) {
        IIX0o.x0xO0oo(activity, "activity");
        activity.startActivity(new Intent(activity, (Class<?>) ResetPasswordActivity.class));
    }

    public final boolean xx0X0() {
        if (!xOOOX() && !oOo()) {
            return false;
        }
        return true;
    }

    public final boolean xxIO() {
        return ProductManager.f20544oIX0oI.XXoOx0();
    }

    public final void xxIXOIIO() {
        com.sma.smartv3.util.Xo0.f24349oIX0oI.XO().put(XoI0Ixx0.f24487xXxxox0I, 1);
    }

    public final boolean xxOXOOoIX() {
        return true;
    }

    @OOXIXo
    public final String xxX() {
        return "https://api.iot-solution.net/Shark-Wear/gptPage/index.html";
    }

    public final boolean xxx00() {
        return true;
    }

    public final boolean xxxI() {
        return false;
    }
}
