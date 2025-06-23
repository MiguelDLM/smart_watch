package com.sma.smartv3.biz;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.ImageUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.Utils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.kuaishou.weapon.p0.bq;
import com.sma.androidnetworklib.method.NetWork;
import com.sma.androidnetworklib.model.Response;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.initializer.IXxxXO;
import com.sma.smartv3.model.AppConfigInfo;
import com.sma.smartv3.model.AppVersion;
import com.sma.smartv3.model.DeviceConfigInfo;
import com.sma.smartv3.model.DeviceKeyManager;
import com.sma.smartv3.model.DeviceOnlineInfo;
import com.sma.smartv3.model.ExtraPackVersions;
import com.sma.smartv3.model.ExtraPackageData;
import com.sma.smartv3.model.FirmwareVersion;
import com.sma.smartv3.model.LanguageTranslationData;
import com.sma.smartv3.model.OnlineWatchFace;
import com.sma.smartv3.model.WatchFaceCategory;
import com.sma.smartv3.model.WatchFaceInfo;
import com.sma.smartv3.network.Api;
import com.sma.smartv3.network.AppVersionLatest;
import com.sma.smartv3.network.BleExtraPackVersionFont;
import com.sma.smartv3.network.BleExtraPackVersionGPSFirmware;
import com.sma.smartv3.network.BleExtraPackVersionLanguage;
import com.sma.smartv3.network.BleExtraPackVersionUi;
import com.sma.smartv3.network.BleFirmwareCheck;
import com.sma.smartv3.network.ExtraPackVersionLatest;
import com.sma.smartv3.network.FirmwareVersionLatest;
import com.sma.smartv3.network.GetDeviceInfo;
import com.sma.smartv3.network.GetDeviceListObject;
import com.sma.smartv3.network.GetGomoreAuthKey;
import com.sma.smartv3.network.GetMicrosoft;
import com.sma.smartv3.network.GetSparkAuthorize;
import com.sma.smartv3.network.NetWorkUtils;
import com.sma.smartv3.network.RequestBodyKt;
import com.sma.smartv3.pop.I0X0x0oIo;
import com.sma.smartv3.pop.XoI0Ixx0;
import com.sma.smartv3.ui.device.FirmwareUpgradeGQActivity;
import com.sma.smartv3.ui.device.FirmwareUpgradeJSma2Activity;
import com.sma.smartv3.ui.device.FirmwareUpgradeJSmaActivity;
import com.sma.smartv3.ui.device.FirmwareUpgradeNSmaActivity;
import com.sma.smartv3.ui.device.FirmwareUpgradeRActivity;
import com.sma.smartv3.ui.device.FirmwareUpgradeRSmaActivity;
import com.sma.smartv3.ui.device.FontRepairRActivity;
import com.sma.smartv3.ui.device.FontRepairSmaActivity;
import com.sma.smartv3.ui.device.GPSFirmwareRepairSmaActivity;
import com.sma.smartv3.ui.device.UiRepairRActivity;
import com.sma.smartv3.ui.device.UiRepairSmaActivity;
import com.sma.smartv3.ui.me.O0X;
import com.sma.smartv3.util.MicrosoftSDKManage;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.x0xO0oo;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.BleKeyFlag;
import com.szabh.smable3.component.BleCache;
import com.szabh.smable3.component.BleConnector;
import com.szabh.smable3.entity.BleDeviceInfo;
import com.szabh.smable3.entity.BleGoMoreSettings;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.o0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlin.text.OxI;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONObject;

@XX({"SMAP\nDeviceInfoChecker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeviceInfoChecker.kt\ncom/sma/smartv3/biz/DeviceInfoChecker\n+ 2 NetWorkUtils.kt\ncom/sma/smartv3/network/NetWorkUtils\n+ 3 NetWork.kt\ncom/sma/androidnetworklib/method/NetWork\n+ 4 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 6 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,833:1\n151#2,11:834\n171#2:853\n151#2,11:854\n171#2:873\n151#2,11:874\n171#2:893\n151#2,11:894\n171#2:913\n151#2,11:914\n171#2:933\n151#2,11:988\n171#2:1007\n151#2,11:1008\n171#2:1027\n151#2,11:1028\n171#2:1047\n151#2,11:1048\n171#2:1067\n173#2,12:1068\n194#2:1089\n173#2,12:1091\n194#2:1112\n173#2,12:1113\n194#2:1134\n151#2,11:1135\n171#2:1154\n173#2,12:1155\n194#2:1176\n158#2,4:1177\n171#2:1189\n151#2,11:1190\n171#2:1209\n208#3,7:845\n226#3:852\n208#3,7:865\n226#3:872\n208#3,7:885\n226#3:892\n208#3,7:905\n226#3:912\n208#3,7:925\n226#3:932\n208#3,7:999\n226#3:1006\n208#3,7:1019\n226#3:1026\n208#3,7:1039\n226#3:1046\n208#3,7:1059\n226#3:1066\n234#3,8:1080\n254#3:1088\n234#3,8:1103\n254#3:1111\n234#3,8:1125\n254#3:1133\n208#3,7:1146\n226#3:1153\n234#3,8:1167\n254#3:1175\n208#3,7:1181\n226#3:1188\n208#3,7:1201\n226#3:1208\n69#4,3:934\n72#4,5:938\n69#4,3:943\n72#4,5:947\n69#4,3:952\n72#4,5:956\n69#4,3:961\n72#4,5:965\n69#4,3:970\n72#4,5:974\n69#4,3:979\n72#4,5:983\n1#5:937\n1#5:946\n1#5:955\n1#5:964\n1#5:973\n1#5:982\n15#6:1090\n*S KotlinDebug\n*F\n+ 1 DeviceInfoChecker.kt\ncom/sma/smartv3/biz/DeviceInfoChecker\n*L\n69#1:834,11\n69#1:853\n89#1:854,11\n89#1:873\n115#1:874,11\n115#1:893\n139#1:894,11\n139#1:913\n174#1:914,11\n174#1:933\n269#1:988,11\n269#1:1007\n286#1:1008,11\n286#1:1027\n388#1:1028,11\n388#1:1047\n468#1:1048,11\n468#1:1067\n520#1:1068,12\n520#1:1089\n575#1:1091,12\n575#1:1112\n602#1:1113,12\n602#1:1134\n692#1:1135,11\n692#1:1154\n731#1:1155,12\n731#1:1176\n757#1:1177,4\n757#1:1189\n804#1:1190,11\n804#1:1209\n69#1:845,7\n69#1:852\n89#1:865,7\n89#1:872\n115#1:885,7\n115#1:892\n139#1:905,7\n139#1:912\n174#1:925,7\n174#1:932\n269#1:999,7\n269#1:1006\n286#1:1019,7\n286#1:1026\n388#1:1039,7\n388#1:1046\n468#1:1059,7\n468#1:1066\n520#1:1080,8\n520#1:1088\n575#1:1103,8\n575#1:1111\n602#1:1125,8\n602#1:1133\n692#1:1146,7\n692#1:1153\n731#1:1167,8\n731#1:1175\n757#1:1181,7\n757#1:1188\n804#1:1201,7\n804#1:1208\n237#1:934,3\n237#1:938,5\n239#1:943,3\n239#1:947,5\n244#1:952,3\n244#1:956,5\n248#1:961,3\n248#1:965,5\n253#1:970,3\n253#1:974,5\n256#1:979,3\n256#1:983,5\n237#1:937\n239#1:946\n244#1:955\n248#1:964\n253#1:973\n256#1:982\n566#1:1090\n*E\n"})
/* loaded from: classes12.dex */
public final class DeviceInfoChecker {

    /* renamed from: oIX0oI */
    @OXOo.OOXIXo
    public static final DeviceInfoChecker f19983oIX0oI = new DeviceInfoChecker();

    @XX({"SMAP\nDeviceInfoChecker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeviceInfoChecker.kt\ncom/sma/smartv3/biz/DeviceInfoChecker$toFontRepair$1\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,833:1\n11#2,2:834\n27#2,2:854\n27#2,2:856\n69#3,3:836\n72#3,5:840\n69#3,3:845\n72#3,5:849\n69#3,3:858\n72#3,5:862\n69#3,3:867\n72#3,5:871\n1#4:839\n1#4:848\n1#4:861\n1#4:870\n*S KotlinDebug\n*F\n+ 1 DeviceInfoChecker.kt\ncom/sma/smartv3/biz/DeviceInfoChecker$toFontRepair$1\n*L\n439#1:834,2\n445#1:854,2\n451#1:856,2\n441#1:836,3\n441#1:840,5\n442#1:845,3\n442#1:849,5\n456#1:858,3\n456#1:862,5\n457#1:867,3\n457#1:871,5\n441#1:839\n442#1:848\n456#1:861\n457#1:870\n*E\n"})
    /* loaded from: classes12.dex */
    public static final class oIX0oI implements II0XooXoX<ExtraPackageData[]> {

        /* renamed from: oIX0oI */
        public final /* synthetic */ Activity f20067oIX0oI;

        public oIX0oI(Activity activity) {
            this.f20067oIX0oI = activity;
        }

        @Override // com.sma.smartv3.biz.II0XooXoX
        /* renamed from: oIX0oI */
        public void onSuccess(@OXOo.oOoXoXO ExtraPackageData[] extraPackageDataArr) {
            if (extraPackageDataArr != null && extraPackageDataArr.length != 0) {
                LogUtils.d(extraPackageDataArr[0]);
                Xo0.f24349oIX0oI.oxoX().put(ExtraPackageData.class.getName(), new Gson().toJson(extraPackageDataArr[0]));
                int oxXx0IX2 = ProductManager.f20544oIX0oI.oxXx0IX();
                if (oxXx0IX2 != 0) {
                    if (oxXx0IX2 == 1) {
                        Activity activity = this.f20067oIX0oI;
                        activity.startActivity(new Intent(activity, (Class<?>) FontRepairSmaActivity.class));
                        return;
                    }
                    return;
                }
                Activity activity2 = this.f20067oIX0oI;
                activity2.startActivity(new Intent(activity2, (Class<?>) FontRepairRActivity.class));
                return;
            }
            Xo0.f24349oIX0oI.oxoX().remove(ExtraPackageData.class.getName());
            ToastUtils.showLong(R.string.not_found_repair_version);
        }

        @Override // com.sma.smartv3.biz.II0XooXoX
        public void onFailure(@OXOo.OOXIXo String error) {
            IIX0o.x0xO0oo(error, "error");
            Xo0.f24349oIX0oI.oxoX().remove(ExtraPackageData.class.getName());
            if (IIX0o.Oxx0IOOO(BleCache.INSTANCE.getMPlatform(), BleDeviceInfo.PLATFORM_JL)) {
                ToastUtils.showLong(R.string.not_found_repair_version);
                return;
            }
            int oxXx0IX2 = ProductManager.f20544oIX0oI.oxXx0IX();
            if (oxXx0IX2 != 0) {
                if (oxXx0IX2 == 1) {
                    Activity activity = this.f20067oIX0oI;
                    activity.startActivity(new Intent(activity, (Class<?>) FontRepairSmaActivity.class));
                    return;
                }
                return;
            }
            Activity activity2 = this.f20067oIX0oI;
            activity2.startActivity(new Intent(activity2, (Class<?>) FontRepairRActivity.class));
        }
    }

    public static /* synthetic */ void II0XooXoX(DeviceInfoChecker deviceInfoChecker, II0XooXoX iI0XooXoX, Activity activity, View view, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            activity = null;
        }
        if ((i & 4) != 0) {
            view = null;
        }
        if ((i & 8) != 0) {
            str = Api.Y;
        }
        deviceInfoChecker.Oxx0IOOO(iI0XooXoX, activity, view, str);
    }

    public static /* synthetic */ void OOXIXo(DeviceInfoChecker deviceInfoChecker, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = BleCache.INSTANCE.getMBleName();
        }
        if ((i & 2) != 0) {
            str2 = BleCache.INSTANCE.getMFirmwareFlag();
        }
        deviceInfoChecker.xoIox(str, str2);
    }

    public static /* synthetic */ void Oo(DeviceInfoChecker deviceInfoChecker, II0XooXoX iI0XooXoX, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = Api.Y;
        }
        deviceInfoChecker.x0xO0oo(iI0XooXoX, str);
    }

    public static /* synthetic */ void OxI(DeviceInfoChecker deviceInfoChecker, Activity activity, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = Api.Y;
        }
        deviceInfoChecker.o00(activity, str);
    }

    public static /* synthetic */ void X0IIOO(DeviceInfoChecker deviceInfoChecker, Activity activity, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = Api.Y;
        }
        deviceInfoChecker.O0xOxO(activity, str);
    }

    public static /* synthetic */ void XIxXXX0x0(DeviceInfoChecker deviceInfoChecker, Activity activity, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = Api.Y;
        }
        deviceInfoChecker.XI0IXoo(activity, str);
    }

    public static /* synthetic */ void XO(DeviceInfoChecker deviceInfoChecker, II0XooXoX iI0XooXoX, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = Api.Y;
        }
        deviceInfoChecker.X0o0xo(iI0XooXoX, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void x0XOIxOo(DeviceInfoChecker deviceInfoChecker, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 1) != 0) {
            oooxoxo = null;
        }
        deviceInfoChecker.ooOOo0oXI(oooxoxo);
    }

    public static /* synthetic */ void xoXoI(DeviceInfoChecker deviceInfoChecker, Activity activity, FirmwareVersion firmwareVersion, int i, Object obj) {
        if ((i & 2) != 0) {
            firmwareVersion = null;
        }
        deviceInfoChecker.IIXOooo(activity, firmwareVersion);
    }

    public final void I0Io(@OXOo.OOXIXo final Activity activity) {
        IIX0o.x0xO0oo(activity, "activity");
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        HashMap<String, String> checkExtraPackVersionBody = RequestBodyKt.getCheckExtraPackVersionBody();
        final xxxI.II0xO0<ExtraPackVersions> iI0xO0 = new xxxI.II0xO0<ExtraPackVersions>() { // from class: com.sma.smartv3.biz.DeviceInfoChecker$checkExtraPack$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                Xo0.f24349oIX0oI.II0xO0().remove(ExtraPackVersions.class.getName());
                ToastUtils.showLong(R.string.already_the_latest_version);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO ExtraPackVersions extraPackVersions) {
                FirmwareVersion firmwareVersion;
                Integer valueOf;
                FirmwareVersion firmwareVersion2;
                FirmwareVersion firmwareVersion3;
                FirmwareVersion firmwareVersion4;
                FirmwareVersion firmwareVersion5;
                FirmwareVersion firmwareVersion6;
                Xo0 xo0 = Xo0.f24349oIX0oI;
                xo0.II0xO0().put(ExtraPackVersions.class.getName(), new Gson().toJson(extraPackVersions));
                final FirmwareVersion firmwareVersion7 = (FirmwareVersion) new Gson().fromJson(xo0.II0xO0().getString(FirmwareVersion.class.getName()), FirmwareVersion.class);
                if (firmwareVersion7 == null) {
                    if (extraPackVersions != null) {
                        firmwareVersion2 = extraPackVersions.getUiPackVersion();
                    } else {
                        firmwareVersion2 = null;
                    }
                    if (firmwareVersion2 == null) {
                        if (extraPackVersions != null) {
                            firmwareVersion3 = extraPackVersions.getLanguagePackVersion();
                        } else {
                            firmwareVersion3 = null;
                        }
                        if (firmwareVersion3 == null) {
                            if (extraPackVersions != null) {
                                firmwareVersion4 = extraPackVersions.getFontPackVersion();
                            } else {
                                firmwareVersion4 = null;
                            }
                            if (firmwareVersion4 == null) {
                                if (extraPackVersions != null) {
                                    firmwareVersion5 = extraPackVersions.getGpsFirmwareVersion();
                                } else {
                                    firmwareVersion5 = null;
                                }
                                if (firmwareVersion5 == null) {
                                    if (extraPackVersions != null) {
                                        firmwareVersion6 = extraPackVersions.getNetworkFirmwareVersion();
                                    } else {
                                        firmwareVersion6 = null;
                                    }
                                    if (firmwareVersion6 == null) {
                                        ToastUtils.showLong(R.string.already_the_latest_version);
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
                XoI0Ixx0 xoI0Ixx0 = new XoI0Ixx0(activity, 0, 2, null);
                final Activity activity2 = activity;
                xoI0Ixx0.x0xO0oo(false);
                xoI0Ixx0.IoOoX(R.string.upgrade_reminder);
                xoI0Ixx0.oo0xXOI0I(17);
                if (extraPackVersions != null) {
                    firmwareVersion = extraPackVersions.getGpsFirmwareVersion();
                } else {
                    firmwareVersion = null;
                }
                if (firmwareVersion != null) {
                    XoI0Ixx0.IO(xoI0Ixx0, null, null, 2, null);
                    valueOf = Integer.valueOf(R.string.new_gps_firmware_version_remind);
                } else {
                    XoI0Ixx0.IO(xoI0Ixx0, Integer.valueOf(R.string.upgrade_later), null, 2, null);
                    valueOf = Integer.valueOf(R.string.new_version_remind);
                }
                xoI0Ixx0.xI(valueOf);
                xoI0Ixx0.x0o(R.string.confirm, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.biz.DeviceInfoChecker$checkExtraPack$1$handleResponse$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // Oox.oIX0oI
                    @OXOo.OOXIXo
                    public final Boolean invoke() {
                        if (Xo0.f24349oIX0oI.II0xO0().getInt(com.sma.smartv3.util.XoI0Ixx0.f24396Oo, 0) >= 50) {
                            DeviceInfoChecker.f19983oIX0oI.IIXOooo(activity2, firmwareVersion7);
                        } else {
                            ToastUtils.showLong(R.string.firmware_upgrade_tip_toast);
                        }
                        return Boolean.TRUE;
                    }
                });
                xoI0Ixx0.IIXOooo();
            }
        };
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(activity, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), ExtraPackVersionLatest.URL);
        netWorkUtils.printParam(convertBaseUrl + ExtraPackVersionLatest.URL, checkExtraPackVersionBody);
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + ExtraPackVersionLatest.URL;
        final xxxI.II0xO0<Response<ExtraPackVersions>> iI0xO02 = new xxxI.II0xO0<Response<ExtraPackVersions>>() { // from class: com.sma.smartv3.biz.DeviceInfoChecker$checkExtraPack$$inlined$post$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<ExtraPackVersions> response) {
                NetWorkUtils netWorkUtils2 = NetWorkUtils.INSTANCE;
                Activity activity2 = activity;
                xxxI.II0xO0 iI0xO03 = iI0xO0;
                I0X0x0oIo i0X0x0oIo = loadPopup;
                LogUtils.d(x0xO.XO.f34062II0XooXoX + response);
                if (response == null) {
                    response = new Response<>();
                    response.setCode(-1000);
                }
                netWorkUtils2.responseWhenCheck(activity2, response, iI0xO03);
                if (i0X0x0oIo != null) {
                    i0X0x0oIo.dismiss();
                }
            }
        };
        AndroidNetworking.post(str).addBodyParameter((Map<String, String>) checkExtraPackVersionBody).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, ExtraPackVersions.class), new ParsedRequestListener<Response<ExtraPackVersions>>() { // from class: com.sma.smartv3.biz.DeviceInfoChecker$checkExtraPack$$inlined$post$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<ExtraPackVersions> response) {
                IIX0o.x0xO0oo(response, "response");
                xxxI.II0xO0.this.handleResponse(response);
            }

            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onError(@OXOo.oOoXoXO ANError aNError) {
                Integer num;
                String str2;
                String str3;
                Response response;
                StringBuilder sb = new StringBuilder();
                sb.append("errorCode:");
                Integer num2 = null;
                if (aNError != null) {
                    num = Integer.valueOf(aNError.getErrorCode());
                } else {
                    num = null;
                }
                sb.append(num);
                sb.append(", errorBody:");
                if (aNError != null) {
                    str2 = aNError.getErrorBody();
                } else {
                    str2 = null;
                }
                sb.append(str2);
                sb.append(", ");
                if (aNError != null) {
                    str3 = aNError.getErrorDetail();
                } else {
                    str3 = null;
                }
                sb.append(str3);
                LogUtils.d(sb.toString());
                if (aNError != null && (response = (Response) aNError.getErrorAsObject(Response.class)) != null) {
                    num2 = Integer.valueOf(response.getCode());
                } else if (aNError != null) {
                    num2 = Integer.valueOf(aNError.getErrorCode());
                }
                xxxI.II0xO0.this.handleError(String.valueOf(num2));
            }
        });
    }

    public final void II0xO0(@OXOo.OOXIXo final Oox.oOoXoXO<? super AppVersion, oXIO0o0XI> action) {
        IIX0o.x0xO0oo(action, "action");
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        HashMap<String, String> checkAppVersionBody = RequestBodyKt.getCheckAppVersionBody();
        final xxxI.II0xO0<AppVersion> iI0xO0 = new xxxI.II0xO0<AppVersion>() { // from class: com.sma.smartv3.biz.DeviceInfoChecker$checkAppVersion$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO AppVersion appVersion) {
                if (appVersion != null) {
                    action.invoke(appVersion);
                }
            }
        };
        final Activity activity = null;
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), AppVersionLatest.URL);
        netWorkUtils.printParam(convertBaseUrl + AppVersionLatest.URL, checkAppVersionBody);
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + AppVersionLatest.URL;
        final xxxI.II0xO0<Response<AppVersion>> iI0xO02 = new xxxI.II0xO0<Response<AppVersion>>() { // from class: com.sma.smartv3.biz.DeviceInfoChecker$checkAppVersion$$inlined$post$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<AppVersion> response) {
                NetWorkUtils netWorkUtils2 = NetWorkUtils.INSTANCE;
                Activity activity2 = activity;
                xxxI.II0xO0 iI0xO03 = iI0xO0;
                I0X0x0oIo i0X0x0oIo = loadPopup;
                LogUtils.d(x0xO.XO.f34062II0XooXoX + response);
                if (response == null) {
                    response = new Response<>();
                    response.setCode(-1000);
                }
                netWorkUtils2.responseWhenCheck(activity2, response, iI0xO03);
                if (i0X0x0oIo != null) {
                    i0X0x0oIo.dismiss();
                }
            }
        };
        AndroidNetworking.post(str).addBodyParameter((Map<String, String>) checkAppVersionBody).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, AppVersion.class), new ParsedRequestListener<Response<AppVersion>>() { // from class: com.sma.smartv3.biz.DeviceInfoChecker$checkAppVersion$$inlined$post$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<AppVersion> response) {
                IIX0o.x0xO0oo(response, "response");
                xxxI.II0xO0.this.handleResponse(response);
            }

            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onError(@OXOo.oOoXoXO ANError aNError) {
                Integer num;
                String str2;
                String str3;
                Response response;
                StringBuilder sb = new StringBuilder();
                sb.append("errorCode:");
                Integer num2 = null;
                if (aNError != null) {
                    num = Integer.valueOf(aNError.getErrorCode());
                } else {
                    num = null;
                }
                sb.append(num);
                sb.append(", errorBody:");
                if (aNError != null) {
                    str2 = aNError.getErrorBody();
                } else {
                    str2 = null;
                }
                sb.append(str2);
                sb.append(", ");
                if (aNError != null) {
                    str3 = aNError.getErrorDetail();
                } else {
                    str3 = null;
                }
                sb.append(str3);
                LogUtils.d(sb.toString());
                if (aNError != null && (response = (Response) aNError.getErrorAsObject(Response.class)) != null) {
                    num2 = Integer.valueOf(response.getCode());
                } else if (aNError != null) {
                    num2 = Integer.valueOf(aNError.getErrorCode());
                }
                xxxI.II0xO0.this.handleError(String.valueOf(num2));
            }
        });
    }

    public final void IIXOooo(@OXOo.OOXIXo Activity activity, @OXOo.oOoXoXO FirmwareVersion firmwareVersion) {
        String str;
        IIX0o.x0xO0oo(activity, "activity");
        String mPlatform = BleCache.INSTANCE.getMPlatform();
        switch (mPlatform.hashCode()) {
            case -1955887059:
                if (mPlatform.equals(BleDeviceInfo.PLATFORM_NORDIC)) {
                    activity.startActivity(new Intent(activity, (Class<?>) FirmwareUpgradeNSmaActivity.class));
                    return;
                }
                return;
            case -1549651556:
                if (mPlatform.equals(BleDeviceInfo.PLATFORM_REALTEK)) {
                    if (ProductManager.f20544oIX0oI.Xo0()) {
                        activity.startActivity(new Intent(activity, (Class<?>) FirmwareUpgradeRSmaActivity.class));
                        return;
                    } else {
                        activity.startActivity(new Intent(activity, (Class<?>) FirmwareUpgradeRActivity.class));
                        return;
                    }
                }
                return;
            case 2370:
                if (!mPlatform.equals(BleDeviceInfo.PLATFORM_JL)) {
                    return;
                }
                break;
            case 70659068:
                if (!mPlatform.equals(BleDeviceInfo.PLATFORM_JL707)) {
                    return;
                }
                break;
            case 1697379018:
                if (!mPlatform.equals(BleDeviceInfo.PLATFORM_JL707LITE)) {
                    return;
                }
                break;
            case 2138586828:
                if (mPlatform.equals(BleDeviceInfo.PLATFORM_GOODIX)) {
                    activity.startActivity(new Intent(activity, (Class<?>) FirmwareUpgradeGQActivity.class));
                    return;
                }
                return;
            default:
                return;
        }
        if (firmwareVersion != null) {
            str = firmwareVersion.getFileUrl2();
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            activity.startActivity(new Intent(activity, (Class<?>) FirmwareUpgradeJSmaActivity.class));
        } else {
            activity.startActivity(new Intent(activity, (Class<?>) FirmwareUpgradeJSma2Activity.class));
        }
    }

    public final void IXxxXO(@OXOo.OOXIXo final II0XooXoX<ExtraPackageData[]> callback, @OXOo.OOXIXo String valid) {
        IIX0o.x0xO0oo(callback, "callback");
        IIX0o.x0xO0oo(valid, "valid");
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        HashMap<String, String> extraPackVersionFontBody = RequestBodyKt.getExtraPackVersionFontBody(valid);
        final xxxI.II0xO0<ExtraPackageData[]> iI0xO0 = new xxxI.II0xO0<ExtraPackageData[]>() { // from class: com.sma.smartv3.biz.DeviceInfoChecker$getLatestFont$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                callback.onFailure(error);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO ExtraPackageData[] extraPackageDataArr) {
                callback.onSuccess(extraPackageDataArr);
            }
        };
        final Activity activity = null;
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), BleExtraPackVersionFont.URL);
        netWorkUtils.printParam(convertBaseUrl + BleExtraPackVersionFont.URL, extraPackVersionFontBody);
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + BleExtraPackVersionFont.URL;
        final xxxI.II0xO0<Response<ExtraPackageData[]>> iI0xO02 = new xxxI.II0xO0<Response<ExtraPackageData[]>>() { // from class: com.sma.smartv3.biz.DeviceInfoChecker$getLatestFont$$inlined$post$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<ExtraPackageData[]> response) {
                NetWorkUtils netWorkUtils2 = NetWorkUtils.INSTANCE;
                Activity activity2 = activity;
                xxxI.II0xO0 iI0xO03 = iI0xO0;
                I0X0x0oIo i0X0x0oIo = loadPopup;
                LogUtils.d(x0xO.XO.f34062II0XooXoX + response);
                if (response == null) {
                    response = new Response<>();
                    response.setCode(-1000);
                }
                netWorkUtils2.responseWhenCheck(activity2, response, iI0xO03);
                if (i0X0x0oIo != null) {
                    i0X0x0oIo.dismiss();
                }
            }
        };
        AndroidNetworking.post(str).addBodyParameter((Map<String, String>) extraPackVersionFontBody).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, ExtraPackageData[].class), new ParsedRequestListener<Response<ExtraPackageData[]>>() { // from class: com.sma.smartv3.biz.DeviceInfoChecker$getLatestFont$$inlined$post$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<ExtraPackageData[]> response) {
                IIX0o.x0xO0oo(response, "response");
                xxxI.II0xO0.this.handleResponse(response);
            }

            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onError(@OXOo.oOoXoXO ANError aNError) {
                Integer num;
                String str2;
                String str3;
                Response response;
                StringBuilder sb = new StringBuilder();
                sb.append("errorCode:");
                Integer num2 = null;
                if (aNError != null) {
                    num = Integer.valueOf(aNError.getErrorCode());
                } else {
                    num = null;
                }
                sb.append(num);
                sb.append(", errorBody:");
                if (aNError != null) {
                    str2 = aNError.getErrorBody();
                } else {
                    str2 = null;
                }
                sb.append(str2);
                sb.append(", ");
                if (aNError != null) {
                    str3 = aNError.getErrorDetail();
                } else {
                    str3 = null;
                }
                sb.append(str3);
                LogUtils.d(sb.toString());
                if (aNError != null && (response = (Response) aNError.getErrorAsObject(Response.class)) != null) {
                    num2 = Integer.valueOf(response.getCode());
                } else if (aNError != null) {
                    num2 = Integer.valueOf(aNError.getErrorCode());
                }
                xxxI.II0xO0.this.handleError(String.valueOf(num2));
            }
        });
    }

    public final void O0xOxO(@OXOo.OOXIXo final Activity activity, @OXOo.OOXIXo String valid) {
        IIX0o.x0xO0oo(activity, "activity");
        IIX0o.x0xO0oo(valid, "valid");
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        HashMap<String, String> extraPackVersionGPSFirmwareBody = RequestBodyKt.getExtraPackVersionGPSFirmwareBody("0", valid);
        final xxxI.II0xO0<ExtraPackageData[]> iI0xO0 = new xxxI.II0xO0<ExtraPackageData[]>() { // from class: com.sma.smartv3.biz.DeviceInfoChecker$toGPSFirmwareRepair$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                ToastUtils.showLong(R.string.not_found_repair_version);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO ExtraPackageData[] extraPackageDataArr) {
                boolean z;
                if (extraPackageDataArr != null) {
                    if (extraPackageDataArr.length == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        SPUtils II0xO02 = Xo0.f24349oIX0oI.II0xO0();
                        ExtraPackVersions extraPackVersions = new ExtraPackVersions(null, null, null, null, null, null, 63, null);
                        String fileUrl = extraPackageDataArr[0].getFileUrl();
                        extraPackVersions.setGpsFirmwareVersion(new FirmwareVersion(extraPackageDataArr[0].getFileName(), extraPackageDataArr[0].getFileSize(), fileUrl, extraPackageDataArr[0].getVersion(), extraPackageDataArr[0].getInfo(), extraPackageDataArr[0].getFileSize(), null, null, null, 448, null));
                        II0xO02.put(ExtraPackVersions.class.getName(), new Gson().toJson(extraPackVersions));
                        Activity activity2 = activity;
                        activity2.startActivity(new Intent(activity2, (Class<?>) GPSFirmwareRepairSmaActivity.class));
                        return;
                    }
                }
                ToastUtils.showLong(R.string.not_found_repair_version);
            }
        };
        final Activity activity2 = null;
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), BleExtraPackVersionGPSFirmware.URL);
        netWorkUtils.printParam(convertBaseUrl + BleExtraPackVersionGPSFirmware.URL, extraPackVersionGPSFirmwareBody);
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + BleExtraPackVersionGPSFirmware.URL;
        final xxxI.II0xO0<Response<ExtraPackageData[]>> iI0xO02 = new xxxI.II0xO0<Response<ExtraPackageData[]>>() { // from class: com.sma.smartv3.biz.DeviceInfoChecker$toGPSFirmwareRepair$$inlined$post$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<ExtraPackageData[]> response) {
                NetWorkUtils netWorkUtils2 = NetWorkUtils.INSTANCE;
                Activity activity3 = activity2;
                xxxI.II0xO0 iI0xO03 = iI0xO0;
                I0X0x0oIo i0X0x0oIo = loadPopup;
                LogUtils.d(x0xO.XO.f34062II0XooXoX + response);
                if (response == null) {
                    response = new Response<>();
                    response.setCode(-1000);
                }
                netWorkUtils2.responseWhenCheck(activity3, response, iI0xO03);
                if (i0X0x0oIo != null) {
                    i0X0x0oIo.dismiss();
                }
            }
        };
        AndroidNetworking.post(str).addBodyParameter((Map<String, String>) extraPackVersionGPSFirmwareBody).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, ExtraPackageData[].class), new ParsedRequestListener<Response<ExtraPackageData[]>>() { // from class: com.sma.smartv3.biz.DeviceInfoChecker$toGPSFirmwareRepair$$inlined$post$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<ExtraPackageData[]> response) {
                IIX0o.x0xO0oo(response, "response");
                xxxI.II0xO0.this.handleResponse(response);
            }

            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onError(@OXOo.oOoXoXO ANError aNError) {
                Integer num;
                String str2;
                String str3;
                Response response;
                StringBuilder sb = new StringBuilder();
                sb.append("errorCode:");
                Integer num2 = null;
                if (aNError != null) {
                    num = Integer.valueOf(aNError.getErrorCode());
                } else {
                    num = null;
                }
                sb.append(num);
                sb.append(", errorBody:");
                if (aNError != null) {
                    str2 = aNError.getErrorBody();
                } else {
                    str2 = null;
                }
                sb.append(str2);
                sb.append(", ");
                if (aNError != null) {
                    str3 = aNError.getErrorDetail();
                } else {
                    str3 = null;
                }
                sb.append(str3);
                LogUtils.d(sb.toString());
                if (aNError != null && (response = (Response) aNError.getErrorAsObject(Response.class)) != null) {
                    num2 = Integer.valueOf(response.getCode());
                } else if (aNError != null) {
                    num2 = Integer.valueOf(aNError.getErrorCode());
                }
                xxxI.II0xO0.this.handleError(String.valueOf(num2));
            }
        });
    }

    public final void Oxx0IOOO(@OXOo.OOXIXo final II0XooXoX<ExtraPackageData> callback, @OXOo.oOoXoXO final Activity activity, @OXOo.oOoXoXO View view, @OXOo.OOXIXo String valid) {
        IIX0o.x0xO0oo(callback, "callback");
        IIX0o.x0xO0oo(valid, "valid");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("checkGPSFirmwareVersion");
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        HashMap<String, String> extraPackVersionGPSFirmwareBody = RequestBodyKt.getExtraPackVersionGPSFirmwareBody(null, valid);
        final xxxI.II0xO0<ExtraPackageData[]> iI0xO0 = new xxxI.II0xO0<ExtraPackageData[]>() { // from class: com.sma.smartv3.biz.DeviceInfoChecker$checkGPSFirmwareVersion$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                callback.onFailure(error);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO ExtraPackageData[] extraPackageDataArr) {
                boolean z;
                if (extraPackageDataArr != null) {
                    if (extraPackageDataArr.length == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        if (IIX0o.Oxx0IOOO(extraPackageDataArr[0].getVersion(), BleCache.getString$default(BleCache.INSTANCE, BleKey.GPS_FIRMWARE_VERSION, bq.e, null, 4, null))) {
                            OI0.oIX0oI.f1507oIX0oI.oIX0oI("checkGPSFirmwareVersion -> same version");
                            callback.onFailure("null");
                            return;
                        }
                        OI0.oIX0oI.f1507oIX0oI.oIX0oI("checkGPSFirmwareVersion -> new version: " + extraPackageDataArr);
                        SPUtils II0xO02 = Xo0.f24349oIX0oI.II0xO0();
                        ExtraPackVersions extraPackVersions = new ExtraPackVersions(null, null, null, null, null, null, 63, null);
                        II0XooXoX<ExtraPackageData> iI0XooXoX = callback;
                        extraPackVersions.setGpsFirmwareVersion(new FirmwareVersion(extraPackageDataArr[0].getFileName(), extraPackageDataArr[0].getFileSize(), extraPackageDataArr[0].getFileUrl(), extraPackageDataArr[0].getVersion(), extraPackageDataArr[0].getInfo(), extraPackageDataArr[0].getFileSize(), null, null, null, 448, null));
                        iI0XooXoX.onSuccess(extraPackageDataArr[0]);
                        II0xO02.put(ExtraPackVersions.class.getName(), new Gson().toJson(extraPackVersions));
                        return;
                    }
                }
                callback.onFailure("null");
            }
        };
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(activity, view);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), BleExtraPackVersionGPSFirmware.URL);
        netWorkUtils.printParam(convertBaseUrl + BleExtraPackVersionGPSFirmware.URL, extraPackVersionGPSFirmwareBody);
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + BleExtraPackVersionGPSFirmware.URL;
        final xxxI.II0xO0<Response<ExtraPackageData[]>> iI0xO02 = new xxxI.II0xO0<Response<ExtraPackageData[]>>() { // from class: com.sma.smartv3.biz.DeviceInfoChecker$checkGPSFirmwareVersion$$inlined$post$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<ExtraPackageData[]> response) {
                NetWorkUtils netWorkUtils2 = NetWorkUtils.INSTANCE;
                Activity activity2 = activity;
                xxxI.II0xO0 iI0xO03 = iI0xO0;
                I0X0x0oIo i0X0x0oIo = loadPopup;
                LogUtils.d(x0xO.XO.f34062II0XooXoX + response);
                if (response == null) {
                    response = new Response<>();
                    response.setCode(-1000);
                }
                netWorkUtils2.responseWhenCheck(activity2, response, iI0xO03);
                if (i0X0x0oIo != null) {
                    i0X0x0oIo.dismiss();
                }
            }
        };
        AndroidNetworking.post(str).addBodyParameter((Map<String, String>) extraPackVersionGPSFirmwareBody).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, ExtraPackageData[].class), new ParsedRequestListener<Response<ExtraPackageData[]>>() { // from class: com.sma.smartv3.biz.DeviceInfoChecker$checkGPSFirmwareVersion$$inlined$post$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<ExtraPackageData[]> response) {
                IIX0o.x0xO0oo(response, "response");
                xxxI.II0xO0.this.handleResponse(response);
            }

            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onError(@OXOo.oOoXoXO ANError aNError) {
                Integer num;
                String str2;
                String str3;
                Response response;
                StringBuilder sb = new StringBuilder();
                sb.append("errorCode:");
                Integer num2 = null;
                if (aNError != null) {
                    num = Integer.valueOf(aNError.getErrorCode());
                } else {
                    num = null;
                }
                sb.append(num);
                sb.append(", errorBody:");
                if (aNError != null) {
                    str2 = aNError.getErrorBody();
                } else {
                    str2 = null;
                }
                sb.append(str2);
                sb.append(", ");
                if (aNError != null) {
                    str3 = aNError.getErrorDetail();
                } else {
                    str3 = null;
                }
                sb.append(str3);
                LogUtils.d(sb.toString());
                if (aNError != null && (response = (Response) aNError.getErrorAsObject(Response.class)) != null) {
                    num2 = Integer.valueOf(response.getCode());
                } else if (aNError != null) {
                    num2 = Integer.valueOf(aNError.getErrorCode());
                }
                xxxI.II0xO0.this.handleError(String.valueOf(num2));
            }
        });
    }

    public final void Oxx0xo(@OXOo.OOXIXo final II0XooXoX<ExtraPackageData[]> callback, @OXOo.OOXIXo String valid) {
        IIX0o.x0xO0oo(callback, "callback");
        IIX0o.x0xO0oo(valid, "valid");
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        HashMap<String, String> extraPackVersionUIBody = RequestBodyKt.getExtraPackVersionUIBody(valid);
        final xxxI.II0xO0<ExtraPackageData[]> iI0xO0 = new xxxI.II0xO0<ExtraPackageData[]>() { // from class: com.sma.smartv3.biz.DeviceInfoChecker$getLatestUi$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                callback.onFailure(error);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO ExtraPackageData[] extraPackageDataArr) {
                callback.onSuccess(extraPackageDataArr);
            }
        };
        final Activity activity = null;
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), BleExtraPackVersionUi.URL);
        netWorkUtils.printParam(convertBaseUrl + BleExtraPackVersionUi.URL, extraPackVersionUIBody);
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + BleExtraPackVersionUi.URL;
        final xxxI.II0xO0<Response<ExtraPackageData[]>> iI0xO02 = new xxxI.II0xO0<Response<ExtraPackageData[]>>() { // from class: com.sma.smartv3.biz.DeviceInfoChecker$getLatestUi$$inlined$post$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<ExtraPackageData[]> response) {
                NetWorkUtils netWorkUtils2 = NetWorkUtils.INSTANCE;
                Activity activity2 = activity;
                xxxI.II0xO0 iI0xO03 = iI0xO0;
                I0X0x0oIo i0X0x0oIo = loadPopup;
                LogUtils.d(x0xO.XO.f34062II0XooXoX + response);
                if (response == null) {
                    response = new Response<>();
                    response.setCode(-1000);
                }
                netWorkUtils2.responseWhenCheck(activity2, response, iI0xO03);
                if (i0X0x0oIo != null) {
                    i0X0x0oIo.dismiss();
                }
            }
        };
        AndroidNetworking.post(str).addBodyParameter((Map<String, String>) extraPackVersionUIBody).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, ExtraPackageData[].class), new ParsedRequestListener<Response<ExtraPackageData[]>>() { // from class: com.sma.smartv3.biz.DeviceInfoChecker$getLatestUi$$inlined$post$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<ExtraPackageData[]> response) {
                IIX0o.x0xO0oo(response, "response");
                xxxI.II0xO0.this.handleResponse(response);
            }

            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onError(@OXOo.oOoXoXO ANError aNError) {
                Integer num;
                String str2;
                String str3;
                Response response;
                StringBuilder sb = new StringBuilder();
                sb.append("errorCode:");
                Integer num2 = null;
                if (aNError != null) {
                    num = Integer.valueOf(aNError.getErrorCode());
                } else {
                    num = null;
                }
                sb.append(num);
                sb.append(", errorBody:");
                if (aNError != null) {
                    str2 = aNError.getErrorBody();
                } else {
                    str2 = null;
                }
                sb.append(str2);
                sb.append(", ");
                if (aNError != null) {
                    str3 = aNError.getErrorDetail();
                } else {
                    str3 = null;
                }
                sb.append(str3);
                LogUtils.d(sb.toString());
                if (aNError != null && (response = (Response) aNError.getErrorAsObject(Response.class)) != null) {
                    num2 = Integer.valueOf(response.getCode());
                } else if (aNError != null) {
                    num2 = Integer.valueOf(aNError.getErrorCode());
                }
                xxxI.II0xO0.this.handleError(String.valueOf(num2));
            }
        });
    }

    public final void OxxIIOOXO() {
        DeviceKeyManager deviceKeyManager = (DeviceKeyManager) new Gson().fromJson(Xo0.f24349oIX0oI.oIX0oI().getString(DeviceKeyManager.class.getName()), DeviceKeyManager.class);
        if (deviceKeyManager != null) {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI("initMicrosoftSDK cache");
            MicrosoftSDKManage.f24259Xx000oIo.oIX0oI().xOoOIoI(deviceKeyManager.getFirst(), deviceKeyManager.getSecond());
            return;
        }
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("initMicrosoftSDK NetWork");
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        final Activity activity = null;
        HashMap microsoftBody$default = RequestBodyKt.getMicrosoftBody$default(null, 1, null);
        final xxxI.II0xO0<DeviceKeyManager> iI0xO0 = new xxxI.II0xO0<DeviceKeyManager>() { // from class: com.sma.smartv3.biz.DeviceInfoChecker$initMicrosoftSDK$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("initMicrosoftSDK error -> " + error);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO DeviceKeyManager deviceKeyManager2) {
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("initMicrosoftSDK handle -> " + deviceKeyManager2);
                if (deviceKeyManager2 != null) {
                    Xo0.f24349oIX0oI.oIX0oI().put(DeviceKeyManager.class.getName(), new Gson().toJson(deviceKeyManager2));
                    MicrosoftSDKManage.f24259Xx000oIo.oIX0oI().xOoOIoI(deviceKeyManager2.getFirst(), deviceKeyManager2.getSecond());
                }
            }
        };
        Map<String, String> headersMap = netWorkUtils.getHeadersMap();
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), GetMicrosoft.URL);
        netWorkUtils.printParam(convertBaseUrl + GetMicrosoft.URL, o0.xoIxX(microsoftBody$default, headersMap));
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + GetMicrosoft.URL;
        final xxxI.II0xO0<Response<DeviceKeyManager>> iI0xO02 = new xxxI.II0xO0<Response<DeviceKeyManager>>() { // from class: com.sma.smartv3.biz.DeviceInfoChecker$initMicrosoftSDK$$inlined$postV2$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<DeviceKeyManager> response) {
                NetWorkUtils netWorkUtils2 = NetWorkUtils.INSTANCE;
                Activity activity2 = activity;
                xxxI.II0xO0 iI0xO03 = iI0xO0;
                I0X0x0oIo i0X0x0oIo = loadPopup;
                LogUtils.d(x0xO.XO.f34062II0XooXoX + response);
                if (response == null) {
                    response = new Response<>();
                    response.setCode(-1000);
                }
                netWorkUtils2.responseWhenCheck(activity2, response, iI0xO03);
                if (i0X0x0oIo != null) {
                    i0X0x0oIo.dismiss();
                }
            }
        };
        AndroidNetworking.post(str).addHeaders(headersMap).addBodyParameter((Map<String, String>) microsoftBody$default).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, DeviceKeyManager.class), new ParsedRequestListener<Response<DeviceKeyManager>>() { // from class: com.sma.smartv3.biz.DeviceInfoChecker$initMicrosoftSDK$$inlined$postV2$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<DeviceKeyManager> response) {
                IIX0o.x0xO0oo(response, "response");
                xxxI.II0xO0.this.handleResponse(response);
            }

            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onError(@OXOo.oOoXoXO ANError aNError) {
                Integer num;
                String str2;
                String str3;
                String str4;
                Response response;
                if (aNError != null) {
                    aNError.printStackTrace();
                }
                StringBuilder sb = new StringBuilder();
                sb.append("errorCode:");
                Integer num2 = null;
                if (aNError != null) {
                    num = Integer.valueOf(aNError.getErrorCode());
                } else {
                    num = null;
                }
                sb.append(num);
                sb.append(", errorBody:");
                if (aNError != null) {
                    str2 = aNError.getErrorBody();
                } else {
                    str2 = null;
                }
                sb.append(str2);
                sb.append(", errorDetail:");
                if (aNError != null) {
                    str3 = aNError.getErrorDetail();
                } else {
                    str3 = null;
                }
                sb.append(str3);
                sb.append(", exception:");
                if (aNError != null) {
                    str4 = aNError.getLocalizedMessage();
                } else {
                    str4 = null;
                }
                sb.append(str4);
                LogUtils.d(sb.toString());
                if (aNError != null && (response = (Response) aNError.getErrorAsObject(Response.class)) != null) {
                    num2 = Integer.valueOf(response.getCode());
                } else if (aNError != null) {
                    num2 = Integer.valueOf(aNError.getErrorCode());
                }
                xxxI.II0xO0.this.handleError(String.valueOf(num2));
            }
        });
    }

    public final void X0o0xo(@OXOo.OOXIXo final II0XooXoX<FirmwareVersion> callback, @OXOo.OOXIXo String valid) {
        IIX0o.x0xO0oo(callback, "callback");
        IIX0o.x0xO0oo(valid, "valid");
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        HashMap checkFirmwareVersionBody$default = RequestBodyKt.getCheckFirmwareVersionBody$default(null, valid, null, null, 12, null);
        final xxxI.II0xO0<FirmwareVersion> iI0xO0 = new xxxI.II0xO0<FirmwareVersion>() { // from class: com.sma.smartv3.biz.DeviceInfoChecker$checkFirmwareVersion$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                Xo0.f24349oIX0oI.II0xO0().remove(FirmwareVersion.class.getName());
                callback.onFailure(error);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO FirmwareVersion firmwareVersion) {
                Xo0.f24349oIX0oI.II0xO0().put(FirmwareVersion.class.getName(), new Gson().toJson(firmwareVersion));
                callback.onSuccess(firmwareVersion);
            }
        };
        final Activity activity = null;
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), FirmwareVersionLatest.URL);
        netWorkUtils.printParam(convertBaseUrl + FirmwareVersionLatest.URL, checkFirmwareVersionBody$default);
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + FirmwareVersionLatest.URL;
        final xxxI.II0xO0<Response<FirmwareVersion>> iI0xO02 = new xxxI.II0xO0<Response<FirmwareVersion>>() { // from class: com.sma.smartv3.biz.DeviceInfoChecker$checkFirmwareVersion$$inlined$post$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<FirmwareVersion> response) {
                NetWorkUtils netWorkUtils2 = NetWorkUtils.INSTANCE;
                Activity activity2 = activity;
                xxxI.II0xO0 iI0xO03 = iI0xO0;
                I0X0x0oIo i0X0x0oIo = loadPopup;
                LogUtils.d(x0xO.XO.f34062II0XooXoX + response);
                if (response == null) {
                    response = new Response<>();
                    response.setCode(-1000);
                }
                netWorkUtils2.responseWhenCheck(activity2, response, iI0xO03);
                if (i0X0x0oIo != null) {
                    i0X0x0oIo.dismiss();
                }
            }
        };
        AndroidNetworking.post(str).addBodyParameter((Map<String, String>) checkFirmwareVersionBody$default).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, FirmwareVersion.class), new ParsedRequestListener<Response<FirmwareVersion>>() { // from class: com.sma.smartv3.biz.DeviceInfoChecker$checkFirmwareVersion$$inlined$post$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<FirmwareVersion> response) {
                IIX0o.x0xO0oo(response, "response");
                xxxI.II0xO0.this.handleResponse(response);
            }

            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onError(@OXOo.oOoXoXO ANError aNError) {
                Integer num;
                String str2;
                String str3;
                Response response;
                StringBuilder sb = new StringBuilder();
                sb.append("errorCode:");
                Integer num2 = null;
                if (aNError != null) {
                    num = Integer.valueOf(aNError.getErrorCode());
                } else {
                    num = null;
                }
                sb.append(num);
                sb.append(", errorBody:");
                if (aNError != null) {
                    str2 = aNError.getErrorBody();
                } else {
                    str2 = null;
                }
                sb.append(str2);
                sb.append(", ");
                if (aNError != null) {
                    str3 = aNError.getErrorDetail();
                } else {
                    str3 = null;
                }
                sb.append(str3);
                LogUtils.d(sb.toString());
                if (aNError != null && (response = (Response) aNError.getErrorAsObject(Response.class)) != null) {
                    num2 = Integer.valueOf(response.getCode());
                } else if (aNError != null) {
                    num2 = Integer.valueOf(aNError.getErrorCode());
                }
                xxxI.II0xO0.this.handleError(String.valueOf(num2));
            }
        });
    }

    public final void XI0IXoo(@OXOo.OOXIXo final Activity activity, @OXOo.OOXIXo String valid) {
        IIX0o.x0xO0oo(activity, "activity");
        IIX0o.x0xO0oo(valid, "valid");
        Oxx0xo(new II0XooXoX<ExtraPackageData[]>() { // from class: com.sma.smartv3.biz.DeviceInfoChecker$toUIRepair$1
            @Override // com.sma.smartv3.biz.II0XooXoX
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onSuccess(@OXOo.oOoXoXO ExtraPackageData[] extraPackageDataArr) {
                if (extraPackageDataArr != null && extraPackageDataArr.length != 0) {
                    LogUtils.d(extraPackageDataArr[0]);
                    Xo0.f24349oIX0oI.oxoX().put(ExtraPackageData.class.getName(), new Gson().toJson(extraPackageDataArr[0]));
                    int O0Xx2 = ProductManager.f20544oIX0oI.O0Xx();
                    if (O0Xx2 != 0) {
                        if (O0Xx2 != 1) {
                            ToastUtils.showLong(R.string.stay_tuned);
                            return;
                        } else {
                            final Activity activity2 = activity;
                            com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, oXIO0o0XI>() { // from class: com.sma.smartv3.biz.DeviceInfoChecker$toUIRepair$1$onSuccess$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // Oox.oOoXoXO
                                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(BleConnector bleConnector) {
                                    invoke2(bleConnector);
                                    return oXIO0o0XI.f29392oIX0oI;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(@OXOo.OOXIXo BleConnector it) {
                                    IIX0o.x0xO0oo(it, "it");
                                    Activity activity3 = activity2;
                                    activity3.startActivity(new Intent(activity3, (Class<?>) UiRepairSmaActivity.class));
                                }
                            }, 1, null);
                            return;
                        }
                    }
                    Activity activity3 = activity;
                    activity3.startActivity(new Intent(activity3, (Class<?>) UiRepairRActivity.class));
                    return;
                }
                ToastUtils.showLong(R.string.not_found_repair_version);
            }

            @Override // com.sma.smartv3.biz.II0XooXoX
            public void onFailure(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                ToastUtils.showLong(R.string.not_found_repair_version);
            }
        }, valid);
    }

    public final void o00(@OXOo.OOXIXo Activity activity, @OXOo.OOXIXo String valid) {
        IIX0o.x0xO0oo(activity, "activity");
        IIX0o.x0xO0oo(valid, "valid");
        IXxxXO(new oIX0oI(activity), valid);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [T, java.lang.String] */
    public final void oI0IIXIo() {
        T t;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Api api = Api.INSTANCE;
        if (!IIX0o.Oxx0IOOO(api.getBASE_URL(), O0X.f23385II0xO0) && !IIX0o.Oxx0IOOO(api.getBASE_URL(), O0X.f23389oIX0oI)) {
            if (IIX0o.Oxx0IOOO(api.getBASE_URL(), com.sma.smartv3.ui.login.ooOOo0oXI.f23073X0o0xo)) {
                t = O0X.f23387X0o0xo;
            } else {
                t = O0X.f23390oxoX;
            }
        } else {
            t = O0X.f23384I0Io;
        }
        objectRef.element = t;
        StringBuilder sb = new StringBuilder();
        sb.append((String) objectRef.element);
        sb.append("/watchFace/");
        BleCache bleCache = BleCache.INSTANCE;
        sb.append(bleCache.getMPlatform());
        sb.append(IOUtils.DIR_SEPARATOR_UNIX);
        sb.append(bleCache.getMPrototype());
        sb.append(IOUtils.DIR_SEPARATOR_UNIX);
        ProductManager productManager = ProductManager.f20544oIX0oI;
        sb.append(productManager.XX());
        objectRef.element = sb.toString();
        Xo0.f24349oIX0oI.I0Io().put(com.sma.smartv3.util.XoI0Ixx0.f24355I0oOoX, (String) objectRef.element);
        String str = ((String) objectRef.element) + "/info.txt";
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("watchFaceInfoUrl = " + str);
        NetWorkUtils.INSTANCE.get(str, new xxxI.II0xO0<JSONObject>() { // from class: com.sma.smartv3.biz.DeviceInfoChecker$getWatchFaceInfo$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                LogUtils.d("test " + error);
                Xo0 xo0 = Xo0.f24349oIX0oI;
                xo0.I0Io().remove(com.sma.smartv3.util.XoI0Ixx0.f24467oxxXoxO);
                xo0.I0Io().remove(com.sma.smartv3.util.XoI0Ixx0.f24465oxXx0IX + '_' + WatchFaceCategory[].class.getName());
                xo0.I0Io().remove(com.sma.smartv3.util.XoI0Ixx0.f24488xo0x + '_' + WatchFaceInfo[].class.getName());
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO JSONObject jSONObject) {
                Iterator it;
                String str2;
                int i = 1;
                LogUtils.d(jSONObject);
                try {
                    if (jSONObject != null) {
                        OnlineWatchFace onlineWatchFace = (OnlineWatchFace) new Gson().fromJson(jSONObject.toString(), OnlineWatchFace.class);
                        WatchFaceCategory[] categorys = onlineWatchFace.getCategorys();
                        if (categorys == null) {
                            LogUtils.d("getWatchFace -> list=" + onlineWatchFace.getTotal());
                            Xo0 xo0 = Xo0.f24349oIX0oI;
                            xo0.I0Io().put(com.sma.smartv3.util.XoI0Ixx0.f24467oxxXoxO, onlineWatchFace.getTotal());
                            xo0.I0Io().remove(com.sma.smartv3.util.XoI0Ixx0.f24465oxXx0IX + '_' + WatchFaceCategory[].class.getName());
                            ArrayList arrayList = new ArrayList();
                            int total = onlineWatchFace.getTotal();
                            if (1 <= total) {
                                int i2 = 1;
                                while (true) {
                                    arrayList.add(new WatchFaceInfo(i2 + 100, objectRef.element + "/preview/" + i2 + ".png", objectRef.element + "/bin/" + i2 + ".bin"));
                                    if (i2 == total) {
                                        break;
                                    } else {
                                        i2++;
                                    }
                                }
                            }
                            Xo0.f24349oIX0oI.I0Io().put(com.sma.smartv3.util.XoI0Ixx0.f24488xo0x + '_' + WatchFaceInfo[].class.getName(), new Gson().toJson(arrayList.toArray(new WatchFaceInfo[0])));
                        } else {
                            LogUtils.d("getWatchFace -> category");
                            Xo0.f24349oIX0oI.I0Io().remove(com.sma.smartv3.util.XoI0Ixx0.f24467oxxXoxO);
                            Iterator oIX0oI2 = kotlin.jvm.internal.II0XooXoX.oIX0oI(categorys);
                            while (oIX0oI2.hasNext()) {
                                WatchFaceCategory watchFaceCategory = (WatchFaceCategory) oIX0oI2.next();
                                ArrayList arrayList2 = new ArrayList();
                                int total2 = watchFaceCategory.getTotal();
                                if (i <= total2) {
                                    int i3 = 1;
                                    while (true) {
                                        int type = (watchFaceCategory.getType() * 10000) + i3;
                                        StringBuilder sb2 = new StringBuilder();
                                        sb2.append(objectRef.element);
                                        sb2.append("/category/");
                                        sb2.append(watchFaceCategory.getDir());
                                        sb2.append(IOUtils.DIR_SEPARATOR_UNIX);
                                        sb2.append(type);
                                        sb2.append('.');
                                        it = oIX0oI2;
                                        if (watchFaceCategory.getType() == 1) {
                                            str2 = "gif";
                                        } else {
                                            str2 = "png";
                                        }
                                        sb2.append(str2);
                                        arrayList2.add(new WatchFaceInfo(type, sb2.toString(), objectRef.element + "/category/" + watchFaceCategory.getDir() + IOUtils.DIR_SEPARATOR_UNIX + type + ".bin"));
                                        if (i3 == total2) {
                                            break;
                                        }
                                        i3++;
                                        oIX0oI2 = it;
                                    }
                                } else {
                                    it = oIX0oI2;
                                }
                                watchFaceCategory.setList((WatchFaceInfo[]) arrayList2.toArray(new WatchFaceInfo[0]));
                                oIX0oI2 = it;
                                i = 1;
                            }
                            Xo0.f24349oIX0oI.I0Io().put(com.sma.smartv3.util.XoI0Ixx0.f24465oxXx0IX + '_' + WatchFaceCategory[].class.getName(), new Gson().toJson(categorys));
                        }
                        Date parse = com.sma.smartv3.util.xoIox.I0Io().parse(onlineWatchFace.getTime());
                        IIX0o.ooOOo0oXI(parse);
                        long time = parse.getTime();
                        Xo0 xo02 = Xo0.f24349oIX0oI;
                        if (xo02.I0Io().getLong(com.sma.smartv3.util.XoI0Ixx0.f24431XoX, 0L) < time) {
                            LogUtils.d("The watch face has been updated and is cleaning the cache...");
                            xo02.I0Io().put(com.sma.smartv3.util.XoI0Ixx0.f24431XoX, time);
                            FileUtils.delete(IXxxXO.oOoXoXO(X00IoxXI.oIX0oI.f3233oIX0oI));
                            FileUtils.delete(Utils.getApp().getCacheDir());
                            return;
                        }
                        return;
                    }
                    Xo0 xo03 = Xo0.f24349oIX0oI;
                    xo03.I0Io().remove(com.sma.smartv3.util.XoI0Ixx0.f24467oxxXoxO);
                    xo03.I0Io().remove(com.sma.smartv3.util.XoI0Ixx0.f24465oxXx0IX + '_' + WatchFaceCategory[].class.getName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, productManager.I0X0x0oIo());
    }

    public final void oIX0oI(@OXOo.OOXIXo final Oox.oOoXoXO<? super String, oXIO0o0XI> action) {
        IIX0o.x0xO0oo(action, "action");
        if (ProjectManager.f19822oIX0oI.oOoXoXO() && BleConnector.INSTANCE.isBound()) {
            NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
            HashMap<String, String> checkAppFirmwareBody = RequestBodyKt.getCheckAppFirmwareBody();
            final xxxI.II0xO0<String> iI0xO0 = new xxxI.II0xO0<String>() { // from class: com.sma.smartv3.biz.DeviceInfoChecker$checkApp$1
                @Override // xxxI.II0xO0
                public void handleError(@OXOo.OOXIXo String error) {
                    IIX0o.x0xO0oo(error, "error");
                    if (StringsKt__StringsKt.O0O0Io00X(error, "code", 0, false, 6, null) == -1 && error.length() > 5) {
                        action.invoke(error);
                    }
                }

                @Override // xxxI.II0xO0
                /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
                public void handleResponse(@OXOo.oOoXoXO String str) {
                }
            };
            final Activity activity = null;
            final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
            String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), BleFirmwareCheck.URL);
            netWorkUtils.printParam(convertBaseUrl + BleFirmwareCheck.URL, checkAppFirmwareBody);
            NetWork netWork = NetWork.f19682oIX0oI;
            String str = convertBaseUrl + BleFirmwareCheck.URL;
            final xxxI.II0xO0<Response<String>> iI0xO02 = new xxxI.II0xO0<Response<String>>() { // from class: com.sma.smartv3.biz.DeviceInfoChecker$checkApp$$inlined$post$default$1
                @Override // xxxI.II0xO0
                public void handleError(@OXOo.OOXIXo String error) {
                    IIX0o.x0xO0oo(error, "error");
                    NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
                }

                @Override // xxxI.II0xO0
                /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
                public void handleResponse(@OXOo.oOoXoXO Response<String> response) {
                    NetWorkUtils netWorkUtils2 = NetWorkUtils.INSTANCE;
                    Activity activity2 = activity;
                    xxxI.II0xO0 iI0xO03 = iI0xO0;
                    I0X0x0oIo i0X0x0oIo = loadPopup;
                    LogUtils.d(x0xO.XO.f34062II0XooXoX + response);
                    if (response == null) {
                        response = new Response<>();
                        response.setCode(-1000);
                    }
                    netWorkUtils2.responseWhenCheck(activity2, response, iI0xO03);
                    if (i0X0x0oIo != null) {
                        i0X0x0oIo.dismiss();
                    }
                }
            };
            AndroidNetworking.post(str).addBodyParameter((Map<String, String>) checkAppFirmwareBody).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, String.class), new ParsedRequestListener<Response<String>>() { // from class: com.sma.smartv3.biz.DeviceInfoChecker$checkApp$$inlined$post$default$2
                @Override // com.androidnetworking.interfaces.ParsedRequestListener
                /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
                public void onResponse(@OXOo.OOXIXo Response<String> response) {
                    IIX0o.x0xO0oo(response, "response");
                    xxxI.II0xO0.this.handleResponse(response);
                }

                @Override // com.androidnetworking.interfaces.ParsedRequestListener
                public void onError(@OXOo.oOoXoXO ANError aNError) {
                    Integer num;
                    String str2;
                    String str3;
                    Response response;
                    StringBuilder sb = new StringBuilder();
                    sb.append("errorCode:");
                    Integer num2 = null;
                    if (aNError != null) {
                        num = Integer.valueOf(aNError.getErrorCode());
                    } else {
                        num = null;
                    }
                    sb.append(num);
                    sb.append(", errorBody:");
                    if (aNError != null) {
                        str2 = aNError.getErrorBody();
                    } else {
                        str2 = null;
                    }
                    sb.append(str2);
                    sb.append(", ");
                    if (aNError != null) {
                        str3 = aNError.getErrorDetail();
                    } else {
                        str3 = null;
                    }
                    sb.append(str3);
                    LogUtils.d(sb.toString());
                    if (aNError != null && (response = (Response) aNError.getErrorAsObject(Response.class)) != null) {
                        num2 = Integer.valueOf(response.getCode());
                    } else if (aNError != null) {
                        num2 = Integer.valueOf(aNError.getErrorCode());
                    }
                    xxxI.II0xO0.this.handleError(String.valueOf(num2));
                }
            });
        }
    }

    public final void oO(@OXOo.OOXIXo final String uuid, final int i) {
        IIX0o.x0xO0oo(uuid, "uuid");
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        HashMap<String, String> gomoreAuthKeyBody = RequestBodyKt.getGomoreAuthKeyBody(uuid, i);
        final xxxI.II0xO0<JsonObject> iI0xO0 = new xxxI.II0xO0<JsonObject>() { // from class: com.sma.smartv3.biz.DeviceInfoChecker$getGoMoreAuthKey$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("getGoMoreAuthKey -> GoMore activate error! " + error);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO JsonObject jsonObject) {
                String asString;
                OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
                oix0oi.oIX0oI("getGoMoreAuthKey -> " + jsonObject);
                if (jsonObject != null) {
                    try {
                        JsonElement jsonElement = jsonObject.get("key");
                        if (jsonElement != null && (asString = jsonElement.getAsString()) != null) {
                            String str = uuid;
                            int i2 = i;
                            BleGoMoreSettings bleGoMoreSettings = new BleGoMoreSettings(str, asString, i2);
                            BleConnector.sendObject$default(BleConnector.INSTANCE, BleKey.GOMORE_SET, BleKeyFlag.UPDATE, bleGoMoreSettings, false, false, 24, null);
                            Xo0.f24349oIX0oI.I0Io().put(BleGoMoreSettings.class.getName(), new Gson().toJson(bleGoMoreSettings));
                            oix0oi.oIX0oI("getGoMoreAuthKey -> " + i2 + " - GoMore activated!");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        OI0.oIX0oI.f1507oIX0oI.oIX0oI("getGoMoreAuthKey -> GoMore activate error! " + e.getMessage());
                    }
                }
            }
        };
        final Activity activity = null;
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), GetGomoreAuthKey.URL);
        netWorkUtils.printParam(convertBaseUrl + GetGomoreAuthKey.URL, gomoreAuthKeyBody);
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + GetGomoreAuthKey.URL;
        final xxxI.II0xO0<Response<JsonObject>> iI0xO02 = new xxxI.II0xO0<Response<JsonObject>>() { // from class: com.sma.smartv3.biz.DeviceInfoChecker$getGoMoreAuthKey$$inlined$post$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<JsonObject> response) {
                NetWorkUtils netWorkUtils2 = NetWorkUtils.INSTANCE;
                Activity activity2 = activity;
                xxxI.II0xO0 iI0xO03 = iI0xO0;
                I0X0x0oIo i0X0x0oIo = loadPopup;
                LogUtils.d(x0xO.XO.f34062II0XooXoX + response);
                if (response == null) {
                    response = new Response<>();
                    response.setCode(-1000);
                }
                netWorkUtils2.responseWhenCheck(activity2, response, iI0xO03);
                if (i0X0x0oIo != null) {
                    i0X0x0oIo.dismiss();
                }
            }
        };
        AndroidNetworking.post(str).addBodyParameter((Map<String, String>) gomoreAuthKeyBody).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, JsonObject.class), new ParsedRequestListener<Response<JsonObject>>() { // from class: com.sma.smartv3.biz.DeviceInfoChecker$getGoMoreAuthKey$$inlined$post$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<JsonObject> response) {
                IIX0o.x0xO0oo(response, "response");
                xxxI.II0xO0.this.handleResponse(response);
            }

            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onError(@OXOo.oOoXoXO ANError aNError) {
                Integer num;
                String str2;
                String str3;
                Response response;
                StringBuilder sb = new StringBuilder();
                sb.append("errorCode:");
                Integer num2 = null;
                if (aNError != null) {
                    num = Integer.valueOf(aNError.getErrorCode());
                } else {
                    num = null;
                }
                sb.append(num);
                sb.append(", errorBody:");
                if (aNError != null) {
                    str2 = aNError.getErrorBody();
                } else {
                    str2 = null;
                }
                sb.append(str2);
                sb.append(", ");
                if (aNError != null) {
                    str3 = aNError.getErrorDetail();
                } else {
                    str3 = null;
                }
                sb.append(str3);
                LogUtils.d(sb.toString());
                if (aNError != null && (response = (Response) aNError.getErrorAsObject(Response.class)) != null) {
                    num2 = Integer.valueOf(response.getCode());
                } else if (aNError != null) {
                    num2 = Integer.valueOf(aNError.getErrorCode());
                }
                xxxI.II0xO0.this.handleError(String.valueOf(num2));
            }
        });
    }

    public final void oOoXoXO() {
        BleCache bleCache = BleCache.INSTANCE;
        if (bleCache.getMBleAddress().length() == 0) {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI("getSparkAuthorize spark/exist BleCache.mBleAddress.isEmpty() return false");
            AISparkChainManager.f19871oIX0oI.xXOx(false);
            return;
        }
        Xo0 xo0 = Xo0.f24349oIX0oI;
        if (IIX0o.Oxx0IOOO(xo0.II0xO0().getString(com.sma.smartv3.util.XoI0Ixx0.f24455oXxOI0oIx + OxI.IIOIX(bleCache.getMBleAddress(), ":", "", false, 4, null), ""), OxI.IIOIX(bleCache.getMBleAddress(), ":", "", false, 4, null))) {
            OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
            StringBuilder sb = new StringBuilder();
            sb.append("getSparkAuthorize spark/exist mBleAddress = ");
            sb.append(xo0.II0xO0().getString(com.sma.smartv3.util.XoI0Ixx0.f24455oXxOI0oIx + OxI.IIOIX(bleCache.getMBleAddress(), ":", "", false, 4, null), ""));
            sb.append(" return true");
            oix0oi.oIX0oI(sb.toString());
            AISparkChainManager.f19871oIX0oI.xXOx(true);
            return;
        }
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        HashMap<String, String> sparkAuthorizeBody = RequestBodyKt.getSparkAuthorizeBody();
        final xxxI.II0xO0<Boolean> iI0xO0 = new xxxI.II0xO0<Boolean>() { // from class: com.sma.smartv3.biz.DeviceInfoChecker$getDeviceIsSparkAuthorize$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                Xo0.f24349oIX0oI.II0xO0().put(com.sma.smartv3.util.XoI0Ixx0.f24455oXxOI0oIx + OxI.IIOIX(BleCache.INSTANCE.getMBleAddress(), ":", "", false, 4, null), "");
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("getSparkAuthorize error -> " + error);
                AISparkChainManager.f19871oIX0oI.xXOx(false);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Boolean bool) {
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("getSparkAuthorize result -> " + bool);
                if (bool != null && bool.booleanValue()) {
                    SPUtils II0xO02 = Xo0.f24349oIX0oI.II0xO0();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(com.sma.smartv3.util.XoI0Ixx0.f24455oXxOI0oIx);
                    BleCache bleCache2 = BleCache.INSTANCE;
                    sb2.append(OxI.IIOIX(bleCache2.getMBleAddress(), ":", "", false, 4, null));
                    II0xO02.put(sb2.toString(), OxI.IIOIX(bleCache2.getMBleAddress(), ":", "", false, 4, null));
                    AISparkChainManager.f19871oIX0oI.xXOx(bool.booleanValue());
                    return;
                }
                Xo0.f24349oIX0oI.II0xO0().put(com.sma.smartv3.util.XoI0Ixx0.f24455oXxOI0oIx + OxI.IIOIX(BleCache.INSTANCE.getMBleAddress(), ":", "", false, 4, null), "");
                AISparkChainManager.f19871oIX0oI.xXOx(false);
            }
        };
        Map<String, String> headersMap = netWorkUtils.getHeadersMap();
        final Activity activity = null;
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), GetSparkAuthorize.URL);
        netWorkUtils.printParam(convertBaseUrl + GetSparkAuthorize.URL, o0.xoIxX(sparkAuthorizeBody, headersMap));
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + GetSparkAuthorize.URL;
        final xxxI.II0xO0<Response<Boolean>> iI0xO02 = new xxxI.II0xO0<Response<Boolean>>() { // from class: com.sma.smartv3.biz.DeviceInfoChecker$getDeviceIsSparkAuthorize$$inlined$postV2$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<Boolean> response) {
                NetWorkUtils netWorkUtils2 = NetWorkUtils.INSTANCE;
                Activity activity2 = activity;
                xxxI.II0xO0 iI0xO03 = iI0xO0;
                I0X0x0oIo i0X0x0oIo = loadPopup;
                LogUtils.d(x0xO.XO.f34062II0XooXoX + response);
                if (response == null) {
                    response = new Response<>();
                    response.setCode(-1000);
                }
                netWorkUtils2.responseWhenCheck(activity2, response, iI0xO03);
                if (i0X0x0oIo != null) {
                    i0X0x0oIo.dismiss();
                }
            }
        };
        AndroidNetworking.post(str).addHeaders(headersMap).addBodyParameter((Map<String, String>) sparkAuthorizeBody).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, Boolean.class), new ParsedRequestListener<Response<Boolean>>() { // from class: com.sma.smartv3.biz.DeviceInfoChecker$getDeviceIsSparkAuthorize$$inlined$postV2$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<Boolean> response) {
                IIX0o.x0xO0oo(response, "response");
                xxxI.II0xO0.this.handleResponse(response);
            }

            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onError(@OXOo.oOoXoXO ANError aNError) {
                Integer num;
                String str2;
                String str3;
                String str4;
                Response response;
                if (aNError != null) {
                    aNError.printStackTrace();
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("errorCode:");
                Integer num2 = null;
                if (aNError != null) {
                    num = Integer.valueOf(aNError.getErrorCode());
                } else {
                    num = null;
                }
                sb2.append(num);
                sb2.append(", errorBody:");
                if (aNError != null) {
                    str2 = aNError.getErrorBody();
                } else {
                    str2 = null;
                }
                sb2.append(str2);
                sb2.append(", errorDetail:");
                if (aNError != null) {
                    str3 = aNError.getErrorDetail();
                } else {
                    str3 = null;
                }
                sb2.append(str3);
                sb2.append(", exception:");
                if (aNError != null) {
                    str4 = aNError.getLocalizedMessage();
                } else {
                    str4 = null;
                }
                sb2.append(str4);
                LogUtils.d(sb2.toString());
                if (aNError != null && (response = (Response) aNError.getErrorAsObject(Response.class)) != null) {
                    num2 = Integer.valueOf(response.getCode());
                } else if (aNError != null) {
                    num2 = Integer.valueOf(aNError.getErrorCode());
                }
                xxxI.II0xO0.this.handleError(String.valueOf(num2));
            }
        });
    }

    public final void ooOOo0oXI(@OXOo.oOoXoXO final Oox.oOoXoXO<? super Boolean, oXIO0o0XI> oooxoxo) {
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        final Activity activity = null;
        HashMap deviceListObjectBody$default = RequestBodyKt.getDeviceListObjectBody$default(null, 1, null);
        final xxxI.II0xO0<DeviceOnlineInfo[]> iI0xO0 = new xxxI.II0xO0<DeviceOnlineInfo[]>() { // from class: com.sma.smartv3.biz.DeviceInfoChecker$getDeviceListObject$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                LogUtils.d("getDeviceListObject -> error = " + error);
                Oox.oOoXoXO<Boolean, oXIO0o0XI> oooxoxo2 = oooxoxo;
                if (oooxoxo2 != null) {
                    oooxoxo2.invoke(Boolean.FALSE);
                }
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO DeviceOnlineInfo[] deviceOnlineInfoArr) {
                List list;
                StringBuilder sb = new StringBuilder();
                sb.append("getDeviceListObject -> ");
                if (deviceOnlineInfoArr != null) {
                    list = ArraysKt___ArraysKt.X0XOOO(deviceOnlineInfoArr);
                } else {
                    list = null;
                }
                sb.append(list);
                LogUtils.d(sb.toString());
                if (deviceOnlineInfoArr != null) {
                    Xo0.f24349oIX0oI.XO().put(com.sma.smartv3.util.XoI0Ixx0.f24393OOXIxO0, new Gson().toJson(ArraysKt___ArraysKt.X0XOOO(deviceOnlineInfoArr)));
                    Oox.oOoXoXO<Boolean, oXIO0o0XI> oooxoxo2 = oooxoxo;
                    if (oooxoxo2 != null) {
                        oooxoxo2.invoke(Boolean.TRUE);
                        return;
                    }
                    return;
                }
                Oox.oOoXoXO<Boolean, oXIO0o0XI> oooxoxo3 = oooxoxo;
                if (oooxoxo3 != null) {
                    oooxoxo3.invoke(Boolean.FALSE);
                }
            }
        };
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), GetDeviceListObject.URL);
        netWorkUtils.printParam(convertBaseUrl + GetDeviceListObject.URL, deviceListObjectBody$default);
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + GetDeviceListObject.URL;
        final xxxI.II0xO0<Response<DeviceOnlineInfo[]>> iI0xO02 = new xxxI.II0xO0<Response<DeviceOnlineInfo[]>>() { // from class: com.sma.smartv3.biz.DeviceInfoChecker$getDeviceListObject$$inlined$post$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<DeviceOnlineInfo[]> response) {
                NetWorkUtils netWorkUtils2 = NetWorkUtils.INSTANCE;
                Activity activity2 = activity;
                xxxI.II0xO0 iI0xO03 = iI0xO0;
                I0X0x0oIo i0X0x0oIo = loadPopup;
                LogUtils.d(x0xO.XO.f34062II0XooXoX + response);
                if (response == null) {
                    response = new Response<>();
                    response.setCode(-1000);
                }
                netWorkUtils2.responseWhenCheck(activity2, response, iI0xO03);
                if (i0X0x0oIo != null) {
                    i0X0x0oIo.dismiss();
                }
            }
        };
        AndroidNetworking.post(str).addBodyParameter((Map<String, String>) deviceListObjectBody$default).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, DeviceOnlineInfo[].class), new ParsedRequestListener<Response<DeviceOnlineInfo[]>>() { // from class: com.sma.smartv3.biz.DeviceInfoChecker$getDeviceListObject$$inlined$post$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<DeviceOnlineInfo[]> response) {
                IIX0o.x0xO0oo(response, "response");
                xxxI.II0xO0.this.handleResponse(response);
            }

            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onError(@OXOo.oOoXoXO ANError aNError) {
                Integer num;
                String str2;
                String str3;
                Response response;
                StringBuilder sb = new StringBuilder();
                sb.append("errorCode:");
                Integer num2 = null;
                if (aNError != null) {
                    num = Integer.valueOf(aNError.getErrorCode());
                } else {
                    num = null;
                }
                sb.append(num);
                sb.append(", errorBody:");
                if (aNError != null) {
                    str2 = aNError.getErrorBody();
                } else {
                    str2 = null;
                }
                sb.append(str2);
                sb.append(", ");
                if (aNError != null) {
                    str3 = aNError.getErrorDetail();
                } else {
                    str3 = null;
                }
                sb.append(str3);
                LogUtils.d(sb.toString());
                if (aNError != null && (response = (Response) aNError.getErrorAsObject(Response.class)) != null) {
                    num2 = Integer.valueOf(response.getCode());
                } else if (aNError != null) {
                    num2 = Integer.valueOf(aNError.getErrorCode());
                }
                xxxI.II0xO0.this.handleError(String.valueOf(num2));
            }
        });
    }

    public final void oxoX(@OXOo.OOXIXo final Activity activity) {
        IIX0o.x0xO0oo(activity, "activity");
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        HashMap<String, String> checkExtraPackVersionBody = RequestBodyKt.getCheckExtraPackVersionBody();
        final xxxI.II0xO0<ExtraPackVersions> iI0xO0 = new xxxI.II0xO0<ExtraPackVersions>() { // from class: com.sma.smartv3.biz.DeviceInfoChecker$checkExtraPackVersion$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                Xo0.f24349oIX0oI.II0xO0().remove(ExtraPackVersions.class.getName());
                ToastUtils.showLong(R.string.already_the_latest_version);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO ExtraPackVersions extraPackVersions) {
                FirmwareVersion firmwareVersion;
                FirmwareVersion firmwareVersion2;
                FirmwareVersion firmwareVersion3;
                FirmwareVersion firmwareVersion4;
                Xo0 xo0 = Xo0.f24349oIX0oI;
                xo0.II0xO0().put(ExtraPackVersions.class.getName(), new Gson().toJson(extraPackVersions));
                FirmwareVersion firmwareVersion5 = (FirmwareVersion) new Gson().fromJson(xo0.II0xO0().getString(FirmwareVersion.class.getName()), FirmwareVersion.class);
                if (firmwareVersion5 == null) {
                    FirmwareVersion firmwareVersion6 = null;
                    if (extraPackVersions != null) {
                        firmwareVersion = extraPackVersions.getUiPackVersion();
                    } else {
                        firmwareVersion = null;
                    }
                    if (firmwareVersion == null) {
                        if (extraPackVersions != null) {
                            firmwareVersion2 = extraPackVersions.getLanguagePackVersion();
                        } else {
                            firmwareVersion2 = null;
                        }
                        if (firmwareVersion2 == null) {
                            if (extraPackVersions != null) {
                                firmwareVersion3 = extraPackVersions.getFontPackVersion();
                            } else {
                                firmwareVersion3 = null;
                            }
                            if (firmwareVersion3 == null) {
                                if (extraPackVersions != null) {
                                    firmwareVersion4 = extraPackVersions.getGpsFirmwareVersion();
                                } else {
                                    firmwareVersion4 = null;
                                }
                                if (firmwareVersion4 == null) {
                                    if (extraPackVersions != null) {
                                        firmwareVersion6 = extraPackVersions.getNetworkFirmwareVersion();
                                    }
                                    if (firmwareVersion6 == null) {
                                        ToastUtils.showLong(R.string.already_the_latest_version);
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
                DeviceInfoChecker.f19983oIX0oI.IIXOooo(activity, firmwareVersion5);
            }
        };
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(activity, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), ExtraPackVersionLatest.URL);
        netWorkUtils.printParam(convertBaseUrl + ExtraPackVersionLatest.URL, checkExtraPackVersionBody);
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + ExtraPackVersionLatest.URL;
        final xxxI.II0xO0<Response<ExtraPackVersions>> iI0xO02 = new xxxI.II0xO0<Response<ExtraPackVersions>>() { // from class: com.sma.smartv3.biz.DeviceInfoChecker$checkExtraPackVersion$$inlined$post$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<ExtraPackVersions> response) {
                NetWorkUtils netWorkUtils2 = NetWorkUtils.INSTANCE;
                Activity activity2 = activity;
                xxxI.II0xO0 iI0xO03 = iI0xO0;
                I0X0x0oIo i0X0x0oIo = loadPopup;
                LogUtils.d(x0xO.XO.f34062II0XooXoX + response);
                if (response == null) {
                    response = new Response<>();
                    response.setCode(-1000);
                }
                netWorkUtils2.responseWhenCheck(activity2, response, iI0xO03);
                if (i0X0x0oIo != null) {
                    i0X0x0oIo.dismiss();
                }
            }
        };
        AndroidNetworking.post(str).addBodyParameter((Map<String, String>) checkExtraPackVersionBody).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, ExtraPackVersions.class), new ParsedRequestListener<Response<ExtraPackVersions>>() { // from class: com.sma.smartv3.biz.DeviceInfoChecker$checkExtraPackVersion$$inlined$post$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<ExtraPackVersions> response) {
                IIX0o.x0xO0oo(response, "response");
                xxxI.II0xO0.this.handleResponse(response);
            }

            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onError(@OXOo.oOoXoXO ANError aNError) {
                Integer num;
                String str2;
                String str3;
                Response response;
                StringBuilder sb = new StringBuilder();
                sb.append("errorCode:");
                Integer num2 = null;
                if (aNError != null) {
                    num = Integer.valueOf(aNError.getErrorCode());
                } else {
                    num = null;
                }
                sb.append(num);
                sb.append(", errorBody:");
                if (aNError != null) {
                    str2 = aNError.getErrorBody();
                } else {
                    str2 = null;
                }
                sb.append(str2);
                sb.append(", ");
                if (aNError != null) {
                    str3 = aNError.getErrorDetail();
                } else {
                    str3 = null;
                }
                sb.append(str3);
                LogUtils.d(sb.toString());
                if (aNError != null && (response = (Response) aNError.getErrorAsObject(Response.class)) != null) {
                    num2 = Integer.valueOf(response.getCode());
                } else if (aNError != null) {
                    num2 = Integer.valueOf(aNError.getErrorCode());
                }
                xxxI.II0xO0.this.handleError(String.valueOf(num2));
            }
        });
    }

    public final void x0xO0oo(@OXOo.OOXIXo final II0XooXoX<ExtraPackageData[]> callback, @OXOo.OOXIXo String valid) {
        IIX0o.x0xO0oo(callback, "callback");
        IIX0o.x0xO0oo(valid, "valid");
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        HashMap<String, String> extraPackVersionLanguageBody = RequestBodyKt.getExtraPackVersionLanguageBody(valid);
        final xxxI.II0xO0<ExtraPackageData[]> iI0xO0 = new xxxI.II0xO0<ExtraPackageData[]>() { // from class: com.sma.smartv3.biz.DeviceInfoChecker$getLanguageList$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                callback.onFailure(error);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO ExtraPackageData[] extraPackageDataArr) {
                callback.onSuccess(extraPackageDataArr);
            }
        };
        final Activity activity = null;
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), BleExtraPackVersionLanguage.URL);
        netWorkUtils.printParam(convertBaseUrl + BleExtraPackVersionLanguage.URL, extraPackVersionLanguageBody);
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + BleExtraPackVersionLanguage.URL;
        final xxxI.II0xO0<Response<ExtraPackageData[]>> iI0xO02 = new xxxI.II0xO0<Response<ExtraPackageData[]>>() { // from class: com.sma.smartv3.biz.DeviceInfoChecker$getLanguageList$$inlined$post$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<ExtraPackageData[]> response) {
                NetWorkUtils netWorkUtils2 = NetWorkUtils.INSTANCE;
                Activity activity2 = activity;
                xxxI.II0xO0 iI0xO03 = iI0xO0;
                I0X0x0oIo i0X0x0oIo = loadPopup;
                LogUtils.d(x0xO.XO.f34062II0XooXoX + response);
                if (response == null) {
                    response = new Response<>();
                    response.setCode(-1000);
                }
                netWorkUtils2.responseWhenCheck(activity2, response, iI0xO03);
                if (i0X0x0oIo != null) {
                    i0X0x0oIo.dismiss();
                }
            }
        };
        AndroidNetworking.post(str).addBodyParameter((Map<String, String>) extraPackVersionLanguageBody).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, ExtraPackageData[].class), new ParsedRequestListener<Response<ExtraPackageData[]>>() { // from class: com.sma.smartv3.biz.DeviceInfoChecker$getLanguageList$$inlined$post$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<ExtraPackageData[]> response) {
                IIX0o.x0xO0oo(response, "response");
                xxxI.II0xO0.this.handleResponse(response);
            }

            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onError(@OXOo.oOoXoXO ANError aNError) {
                Integer num;
                String str2;
                String str3;
                Response response;
                StringBuilder sb = new StringBuilder();
                sb.append("errorCode:");
                Integer num2 = null;
                if (aNError != null) {
                    num = Integer.valueOf(aNError.getErrorCode());
                } else {
                    num = null;
                }
                sb.append(num);
                sb.append(", errorBody:");
                if (aNError != null) {
                    str2 = aNError.getErrorBody();
                } else {
                    str2 = null;
                }
                sb.append(str2);
                sb.append(", ");
                if (aNError != null) {
                    str3 = aNError.getErrorDetail();
                } else {
                    str3 = null;
                }
                sb.append(str3);
                LogUtils.d(sb.toString());
                if (aNError != null && (response = (Response) aNError.getErrorAsObject(Response.class)) != null) {
                    num2 = Integer.valueOf(response.getCode());
                } else if (aNError != null) {
                    num2 = Integer.valueOf(aNError.getErrorCode());
                }
                xxxI.II0xO0.this.handleError(String.valueOf(num2));
            }
        });
    }

    public final void xoIox(@OXOo.OOXIXo final String bleName, @OXOo.OOXIXo final String firmwareFlag) {
        IIX0o.x0xO0oo(bleName, "bleName");
        IIX0o.x0xO0oo(firmwareFlag, "firmwareFlag");
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        final Activity activity = null;
        HashMap deviceInfoBody$default = RequestBodyKt.getDeviceInfoBody$default(null, bleName, firmwareFlag, 1, null);
        final xxxI.II0xO0<DeviceConfigInfo> iI0xO0 = new xxxI.II0xO0<DeviceConfigInfo>() { // from class: com.sma.smartv3.biz.DeviceInfoChecker$getDeviceInfo$1

            /* loaded from: classes12.dex */
            public static final class II0xO0 extends SimpleTarget<Bitmap> {

                /* renamed from: Oo, reason: collision with root package name */
                public final /* synthetic */ String f20056Oo;

                /* renamed from: XO, reason: collision with root package name */
                public final /* synthetic */ String f20057XO;

                public II0xO0(String str, String str2) {
                    this.f20057XO = str;
                    this.f20056Oo = str2;
                }

                @Override // com.bumptech.glide.request.target.Target
                public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
                    onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
                }

                public void onResourceReady(@OXOo.OOXIXo Bitmap resource, @OXOo.oOoXoXO Transition<? super Bitmap> transition) {
                    IIX0o.x0xO0oo(resource, "resource");
                    ImageUtils.save(resource, IXxxXO.IoOoo(X00IoxXI.oIX0oI.f3233oIX0oI, this.f20057XO, this.f20056Oo), Bitmap.CompressFormat.PNG);
                    x0xO0oo.II0xO0(x0xO0oo.f24631oOXoIIIo, null, 2, null);
                }
            }

            /* loaded from: classes12.dex */
            public static final class oIX0oI extends SimpleTarget<Bitmap> {

                /* renamed from: Oo, reason: collision with root package name */
                public final /* synthetic */ String f20058Oo;

                /* renamed from: XO, reason: collision with root package name */
                public final /* synthetic */ String f20059XO;

                public oIX0oI(String str, String str2) {
                    this.f20059XO = str;
                    this.f20058Oo = str2;
                }

                @Override // com.bumptech.glide.request.target.Target
                public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
                    onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
                }

                public void onResourceReady(@OXOo.OOXIXo Bitmap resource, @OXOo.oOoXoXO Transition<? super Bitmap> transition) {
                    IIX0o.x0xO0oo(resource, "resource");
                    ImageUtils.save(resource, IXxxXO.I0oOIX(X00IoxXI.oIX0oI.f3233oIX0oI, this.f20059XO, this.f20058Oo), Bitmap.CompressFormat.PNG);
                    x0xO0oo.II0xO0(x0xO0oo.f24577IoOoX, null, 2, null);
                }
            }

            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("getDeviceInfo -> error = " + error);
                x0xO0oo.oIX0oI(x0xO0oo.f24572IO, Boolean.FALSE);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO DeviceConfigInfo deviceConfigInfo) {
                OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
                oix0oi.oIX0oI("getDeviceInfo -> " + deviceConfigInfo);
                if (deviceConfigInfo != null) {
                    Xo0 xo0 = Xo0.f24349oIX0oI;
                    xo0.II0xO0().put(DeviceConfigInfo.class.getName(), new Gson().toJson(deviceConfigInfo));
                    ProductManager productManager = ProductManager.f20544oIX0oI;
                    if (productManager.O0xxXxI()) {
                        DeviceInfoChecker.f19983oIX0oI.oOoXoXO();
                    }
                    if (productManager.XO0o()) {
                        AISparkChainManager.f19871oIX0oI.xXOx(true);
                    }
                    if (productManager.XI0IXoo()) {
                        DeviceInfoChecker.f19983oIX0oI.OxxIIOOXO();
                    }
                    oix0oi.oIX0oI("getDeviceInfo -> download image from net, " + deviceConfigInfo.getDeviceImage());
                    RequestBuilder skipMemoryCache = Glide.with(Utils.getApp()).asBitmap().skipMemoryCache(true);
                    DiskCacheStrategy diskCacheStrategy = DiskCacheStrategy.NONE;
                    skipMemoryCache.diskCacheStrategy(diskCacheStrategy).load(deviceConfigInfo.getDeviceImage()).into((RequestBuilder) new oIX0oI(bleName, firmwareFlag));
                    if (deviceConfigInfo.getDeviceImage2().length() > 0) {
                        Glide.with(Utils.getApp()).asBitmap().skipMemoryCache(true).diskCacheStrategy(diskCacheStrategy).load(deviceConfigInfo.getDeviceImage2()).into((RequestBuilder) new II0xO0(bleName, firmwareFlag));
                    }
                    com.sma.smartv3.ble.II0xO0.f20317oIX0oI.X0IIOO();
                    if (ProjectManager.f19822oIX0oI.XoX()) {
                        x0xO0oo.II0xO0(x0xO0oo.f24571IIxOXoOo0, null, 2, null);
                    }
                    xo0.I0Io().remove(com.sma.smartv3.util.XoI0Ixx0.f24365IOoo + '_' + LanguageTranslationData.class.getName());
                    xo0.I0Io().remove(com.sma.smartv3.util.XoI0Ixx0.f24442oIIxXoo + '_' + LanguageTranslationData.class.getName());
                }
                x0xO0oo.oIX0oI(x0xO0oo.f24572IO, Boolean.FALSE);
            }
        };
        Map<String, String> headersMap = netWorkUtils.getHeadersMap();
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), GetDeviceInfo.URL);
        netWorkUtils.printParam(convertBaseUrl + GetDeviceInfo.URL, o0.xoIxX(deviceInfoBody$default, headersMap));
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + GetDeviceInfo.URL;
        final xxxI.II0xO0<Response<DeviceConfigInfo>> iI0xO02 = new xxxI.II0xO0<Response<DeviceConfigInfo>>() { // from class: com.sma.smartv3.biz.DeviceInfoChecker$getDeviceInfo$$inlined$postV2$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<DeviceConfigInfo> response) {
                NetWorkUtils netWorkUtils2 = NetWorkUtils.INSTANCE;
                Activity activity2 = activity;
                xxxI.II0xO0 iI0xO03 = iI0xO0;
                I0X0x0oIo i0X0x0oIo = loadPopup;
                LogUtils.d(x0xO.XO.f34062II0XooXoX + response);
                if (response == null) {
                    response = new Response<>();
                    response.setCode(-1000);
                }
                netWorkUtils2.responseWhenCheck(activity2, response, iI0xO03);
                if (i0X0x0oIo != null) {
                    i0X0x0oIo.dismiss();
                }
            }
        };
        AndroidNetworking.post(str).addHeaders(headersMap).addBodyParameter((Map<String, String>) deviceInfoBody$default).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, DeviceConfigInfo.class), new ParsedRequestListener<Response<DeviceConfigInfo>>() { // from class: com.sma.smartv3.biz.DeviceInfoChecker$getDeviceInfo$$inlined$postV2$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<DeviceConfigInfo> response) {
                IIX0o.x0xO0oo(response, "response");
                xxxI.II0xO0.this.handleResponse(response);
            }

            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onError(@OXOo.oOoXoXO ANError aNError) {
                Integer num;
                String str2;
                String str3;
                String str4;
                Response response;
                if (aNError != null) {
                    aNError.printStackTrace();
                }
                StringBuilder sb = new StringBuilder();
                sb.append("errorCode:");
                Integer num2 = null;
                if (aNError != null) {
                    num = Integer.valueOf(aNError.getErrorCode());
                } else {
                    num = null;
                }
                sb.append(num);
                sb.append(", errorBody:");
                if (aNError != null) {
                    str2 = aNError.getErrorBody();
                } else {
                    str2 = null;
                }
                sb.append(str2);
                sb.append(", errorDetail:");
                if (aNError != null) {
                    str3 = aNError.getErrorDetail();
                } else {
                    str3 = null;
                }
                sb.append(str3);
                sb.append(", exception:");
                if (aNError != null) {
                    str4 = aNError.getLocalizedMessage();
                } else {
                    str4 = null;
                }
                sb.append(str4);
                LogUtils.d(sb.toString());
                if (aNError != null && (response = (Response) aNError.getErrorAsObject(Response.class)) != null) {
                    num2 = Integer.valueOf(response.getCode());
                } else if (aNError != null) {
                    num2 = Integer.valueOf(aNError.getErrorCode());
                }
                xxxI.II0xO0.this.handleError(String.valueOf(num2));
            }
        });
    }

    public final void xxIXOIIO() {
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        HashMap<String, String> appConfigInfoBody = RequestBodyKt.getAppConfigInfoBody();
        final xxxI.II0xO0<AppConfigInfo> iI0xO0 = new xxxI.II0xO0<AppConfigInfo>() { // from class: com.sma.smartv3.biz.DeviceInfoChecker$getAppConfigInfo$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO AppConfigInfo appConfigInfo) {
                if (appConfigInfo != null) {
                    Xo0.f24349oIX0oI.oIX0oI().put(AppConfigInfo.class.getName(), new Gson().toJson(appConfigInfo));
                }
            }
        };
        Map<String, String> headersMap = netWorkUtils.getHeadersMap();
        final Activity activity = null;
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), "/appConfigInfo/getAppConfigById");
        netWorkUtils.printParam(convertBaseUrl + "/appConfigInfo/getAppConfigById", o0.xoIxX(appConfigInfoBody, headersMap));
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + "/appConfigInfo/getAppConfigById";
        final xxxI.II0xO0<Response<AppConfigInfo>> iI0xO02 = new xxxI.II0xO0<Response<AppConfigInfo>>() { // from class: com.sma.smartv3.biz.DeviceInfoChecker$getAppConfigInfo$$inlined$postV2$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<AppConfigInfo> response) {
                NetWorkUtils netWorkUtils2 = NetWorkUtils.INSTANCE;
                Activity activity2 = activity;
                xxxI.II0xO0 iI0xO03 = iI0xO0;
                I0X0x0oIo i0X0x0oIo = loadPopup;
                LogUtils.d(x0xO.XO.f34062II0XooXoX + response);
                if (response == null) {
                    response = new Response<>();
                    response.setCode(-1000);
                }
                netWorkUtils2.responseWhenCheck(activity2, response, iI0xO03);
                if (i0X0x0oIo != null) {
                    i0X0x0oIo.dismiss();
                }
            }
        };
        AndroidNetworking.post(str).addHeaders(headersMap).addBodyParameter((Map<String, String>) appConfigInfoBody).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, AppConfigInfo.class), new ParsedRequestListener<Response<AppConfigInfo>>() { // from class: com.sma.smartv3.biz.DeviceInfoChecker$getAppConfigInfo$$inlined$postV2$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<AppConfigInfo> response) {
                IIX0o.x0xO0oo(response, "response");
                xxxI.II0xO0.this.handleResponse(response);
            }

            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onError(@OXOo.oOoXoXO ANError aNError) {
                Integer num;
                String str2;
                String str3;
                String str4;
                Response response;
                if (aNError != null) {
                    aNError.printStackTrace();
                }
                StringBuilder sb = new StringBuilder();
                sb.append("errorCode:");
                Integer num2 = null;
                if (aNError != null) {
                    num = Integer.valueOf(aNError.getErrorCode());
                } else {
                    num = null;
                }
                sb.append(num);
                sb.append(", errorBody:");
                if (aNError != null) {
                    str2 = aNError.getErrorBody();
                } else {
                    str2 = null;
                }
                sb.append(str2);
                sb.append(", errorDetail:");
                if (aNError != null) {
                    str3 = aNError.getErrorDetail();
                } else {
                    str3 = null;
                }
                sb.append(str3);
                sb.append(", exception:");
                if (aNError != null) {
                    str4 = aNError.getLocalizedMessage();
                } else {
                    str4 = null;
                }
                sb.append(str4);
                LogUtils.d(sb.toString());
                if (aNError != null && (response = (Response) aNError.getErrorAsObject(Response.class)) != null) {
                    num2 = Integer.valueOf(response.getCode());
                } else if (aNError != null) {
                    num2 = Integer.valueOf(aNError.getErrorCode());
                }
                xxxI.II0xO0.this.handleError(String.valueOf(num2));
            }
        });
    }
}
