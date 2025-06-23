package com.sma.smartv3.ble;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.Utils;
import com.garmin.fit.OxXXx0X;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.jieli.jl_rcsp.model.device.settings.v0.DeviceState;
import com.realsil.sdk.dfu.utils.DfuAdapter;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.AppConfigInfo;
import com.sma.smartv3.model.CustomConfigInfo;
import com.sma.smartv3.model.DeviceConfigInfo;
import com.sma.smartv3.model.DeviceOnlineInfo;
import com.sma.smartv3.model.MacConfig;
import com.sma.smartv3.model.QrcodeTypeInfo;
import com.sma.smartv3.otherdevice.charge.ChargeMainActivity;
import com.sma.smartv3.ui.main.MainActivity;
import com.sma.smartv3.util.UtilsKt;
import com.sma.smartv3.util.XoI0Ixx0;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.component.BleCache;
import com.szabh.smable3.component.BleConnector;
import com.szabh.smable3.entity.BleDeviceInfo;
import com.szabh.smable3.entity.Languages;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Pair;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.OxxIIOOXO;
import kotlin.collections.Xo0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.text.OxI;
import kotlin.text.StringsKt__StringsKt;

@XX({"SMAP\nProductManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ProductManager.kt\ncom/sma/smartv3/ble/ProductManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,8991:1\n1855#2,2:8992\n1855#2,2:8994\n1549#2:9369\n1620#2,2:9370\n1622#2:9373\n69#3,3:8996\n72#3,5:9000\n69#3,3:9005\n72#3,5:9009\n69#3,3:9014\n72#3,5:9018\n69#3,3:9023\n72#3,5:9027\n69#3,3:9032\n72#3,5:9036\n69#3,3:9041\n72#3,5:9045\n69#3,3:9050\n72#3,5:9054\n69#3,3:9059\n72#3,5:9063\n69#3,3:9068\n72#3,5:9072\n69#3,3:9077\n72#3,5:9081\n69#3,3:9086\n72#3,5:9090\n69#3,3:9095\n72#3,5:9099\n69#3,3:9104\n72#3,5:9108\n69#3,3:9113\n72#3,5:9117\n69#3,3:9122\n72#3,5:9126\n69#3,3:9131\n72#3,5:9135\n69#3,3:9140\n72#3,5:9144\n69#3,3:9149\n72#3,5:9153\n69#3,3:9158\n72#3,5:9162\n69#3,3:9167\n72#3,5:9171\n69#3,3:9176\n72#3,5:9180\n69#3,3:9185\n72#3,5:9189\n69#3,3:9194\n72#3,5:9198\n69#3,3:9203\n72#3,5:9207\n69#3,3:9212\n72#3,5:9216\n69#3,3:9221\n72#3,5:9225\n69#3,3:9230\n72#3,5:9234\n69#3,3:9239\n72#3,5:9243\n69#3,3:9248\n72#3,5:9252\n69#3,3:9257\n72#3,5:9261\n69#3,3:9266\n72#3,5:9270\n69#3,3:9275\n72#3,5:9279\n69#3,3:9284\n72#3,5:9288\n69#3,3:9293\n72#3,5:9297\n69#3,3:9302\n72#3,5:9306\n69#3,3:9311\n72#3,5:9315\n69#3,3:9320\n72#3,5:9324\n69#3,3:9329\n72#3,5:9333\n69#3,3:9338\n72#3,5:9342\n69#3,3:9347\n72#3,5:9351\n69#3,3:9356\n72#3,5:9360\n69#3,3:9378\n72#3,5:9382\n69#3,3:9387\n72#3,5:9391\n1#4:8999\n1#4:9008\n1#4:9017\n1#4:9026\n1#4:9035\n1#4:9044\n1#4:9053\n1#4:9062\n1#4:9071\n1#4:9080\n1#4:9089\n1#4:9098\n1#4:9107\n1#4:9116\n1#4:9125\n1#4:9134\n1#4:9143\n1#4:9152\n1#4:9161\n1#4:9170\n1#4:9179\n1#4:9188\n1#4:9197\n1#4:9206\n1#4:9215\n1#4:9224\n1#4:9233\n1#4:9242\n1#4:9251\n1#4:9260\n1#4:9269\n1#4:9278\n1#4:9287\n1#4:9296\n1#4:9305\n1#4:9314\n1#4:9323\n1#4:9332\n1#4:9341\n1#4:9350\n1#4:9359\n1#4:9365\n1#4:9381\n1#4:9390\n50#5,3:9366\n53#5:9372\n55#5,2:9374\n15#5:9376\n15#5:9377\n19#5:9396\n15#5:9397\n19#5:9398\n15#5:9399\n*S KotlinDebug\n*F\n+ 1 ProductManager.kt\ncom/sma/smartv3/ble/ProductManager\n*L\n1853#1:8992,2\n1865#1:8994,2\n7877#1:9369\n7877#1:9370,2\n7877#1:9373\n6690#1:8996,3\n6690#1:9000,5\n6694#1:9005,3\n6694#1:9009,5\n6698#1:9014,3\n6698#1:9018,5\n6702#1:9023,3\n6702#1:9027,5\n6707#1:9032,3\n6707#1:9036,5\n6711#1:9041,3\n6711#1:9045,5\n6715#1:9050,3\n6715#1:9054,5\n6719#1:9059,3\n6719#1:9063,5\n6723#1:9068,3\n6723#1:9072,5\n6727#1:9077,3\n6727#1:9081,5\n6731#1:9086,3\n6731#1:9090,5\n6736#1:9095,3\n6736#1:9099,5\n6740#1:9104,3\n6740#1:9108,5\n6744#1:9113,3\n6744#1:9117,5\n6745#1:9122,3\n6745#1:9126,5\n6749#1:9131,3\n6749#1:9135,5\n6753#1:9140,3\n6753#1:9144,5\n6757#1:9149,3\n6757#1:9153,5\n6758#1:9158,3\n6758#1:9162,5\n6759#1:9167,3\n6759#1:9171,5\n6760#1:9176,3\n6760#1:9180,5\n6761#1:9185,3\n6761#1:9189,5\n6762#1:9194,3\n6762#1:9198,5\n6765#1:9203,3\n6765#1:9207,5\n6768#1:9212,3\n6768#1:9216,5\n6769#1:9221,3\n6769#1:9225,5\n6772#1:9230,3\n6772#1:9234,5\n6773#1:9239,3\n6773#1:9243,5\n6776#1:9248,3\n6776#1:9252,5\n6777#1:9257,3\n6777#1:9261,5\n6780#1:9266,3\n6780#1:9270,5\n6781#1:9275,3\n6781#1:9279,5\n6784#1:9284,3\n6784#1:9288,5\n6785#1:9293,3\n6785#1:9297,5\n6788#1:9302,3\n6788#1:9306,5\n6789#1:9311,3\n6789#1:9315,5\n6792#1:9320,3\n6792#1:9324,5\n6793#1:9329,3\n6793#1:9333,5\n6796#1:9338,3\n6796#1:9342,5\n6797#1:9347,3\n6797#1:9351,5\n6804#1:9356,3\n6804#1:9360,5\n8211#1:9378,3\n8211#1:9382,5\n8213#1:9387,3\n8213#1:9391,5\n6690#1:8999\n6694#1:9008\n6698#1:9017\n6702#1:9026\n6707#1:9035\n6711#1:9044\n6715#1:9053\n6719#1:9062\n6723#1:9071\n6727#1:9080\n6731#1:9089\n6736#1:9098\n6740#1:9107\n6744#1:9116\n6745#1:9125\n6749#1:9134\n6753#1:9143\n6757#1:9152\n6758#1:9161\n6759#1:9170\n6760#1:9179\n6761#1:9188\n6762#1:9197\n6765#1:9206\n6768#1:9215\n6769#1:9224\n6772#1:9233\n6773#1:9242\n6776#1:9251\n6777#1:9260\n6780#1:9269\n6781#1:9278\n6784#1:9287\n6785#1:9296\n6788#1:9305\n6789#1:9314\n6792#1:9323\n6793#1:9332\n6796#1:9341\n6797#1:9350\n6804#1:9359\n8211#1:9381\n8213#1:9390\n7877#1:9366,3\n7877#1:9372\n7877#1:9374,2\n7884#1:9376\n7894#1:9377\n8408#1:9396\n8408#1:9397\n8409#1:9398\n8409#1:9399\n*E\n"})
/* loaded from: classes12.dex */
public final class ProductManager {

    /* renamed from: I0 */
    @OOXIXo
    public static final String f20329I0 = "KUMI KU1";

    @OOXIXo
    public static final String I00 = "T68";

    @OOXIXo
    public static final String I000X = "TT08";

    @OOXIXo
    public static final String I00I = "KUBE V2";

    /* renamed from: I00O */
    @OOXIXo
    public static final String f20330I00O = "M-GPS WATCH";

    @OOXIXo
    public static final String I00XxoO = "CURVE 9";

    @OOXIXo
    public static final String I00oX = "F33";

    @OOXIXo
    public static final String I0I0IoIXO = "R9 AMOLED";

    @OOXIXo
    public static final String I0IIXxxo = "F3 Plus";

    /* renamed from: I0Io */
    @OOXIXo
    public static final String f20331I0Io = "Q3";

    @OOXIXo
    public static final String I0IoX00I = "MS01";

    /* renamed from: I0O00OI */
    @OOXIXo
    public static final String f20332I0O00OI = "MC11";

    /* renamed from: I0OO */
    @OOXIXo
    public static final String f20333I0OO = "Monster ET1";

    @OOXIXo
    public static final String I0OXXIoX = "GRC-STYLE";

    @OOXIXo
    public static final String I0X = "Go";

    @OOXIXo
    public static final String I0X0Ox = "SYSKA PROXIMA SW350";

    /* renamed from: I0X0x0oIo */
    @OOXIXo
    public static final String f20334I0X0x0oIo = "OT-F2";

    @OOXIXo
    public static final String I0XIOxO = "MetaNebulas";

    @OOXIXo
    public static final String I0XIOxXXX = "Watch 4";

    @OOXIXo
    public static final String I0XOIOO0I = "beatXP Vega X";

    @OOXIXo
    public static final String I0XOx = "AM13";

    @OOXIXo
    public static final String I0Xo = "MS02";

    @OOXIXo
    public static final String I0XoOIO = "Watch5 Pro";

    @OOXIXo
    public static final String I0o = "beatXP Marv Aura";

    @OOXIXo
    public static final String I0o0xoIIx = "M9039";

    @OOXIXo
    public static final String I0oOI0O = "SMA_BP_6x_PMC";

    /* renamed from: I0oOoX */
    @OOXIXo
    public static final String f20336I0oOoX = "SMA-F2";

    @OOXIXo
    public static final String I0ox0 = "FireBoltt";

    @OOXIXo
    public static final String I0x0IOXO = "IT Watch WR02";

    @OOXIXo
    public static final String I0xI0oI = "S3";

    /* renamed from: I0xX0 */
    @OOXIXo
    public static final String f20337I0xX0 = "Seeken Gravity";

    @OOXIXo
    public static final String I0xoO = "Watch4 mini";

    @OOXIXo
    public static final String I0xoOOIx = "Air 4";

    @OOXIXo
    public static final String I0xxIxxI = "GT4MAX";

    @OOXIXo
    public static final String II = "Elite 4";

    @OOXIXo
    public static final String II0 = "CURREN R2S";

    /* renamed from: II0OOXOx */
    @OOXIXo
    public static final String f20338II0OOXOx = "SBT-1";

    @OOXIXo
    public static final String II0XIox = "MI 10 Pro";

    @OOXIXo
    public static final String II0XOIoOO = "KW17";

    /* renamed from: II0XooXoX */
    @OOXIXo
    public static final String f20339II0XooXoX = "R4";

    /* renamed from: II0xO0 */
    @OOXIXo
    public static final String f20340II0xO0 = "SMA-Q3";

    @OOXIXo
    public static final String IIIXXXII = "HOCO Y10 Pro";

    @OOXIXo
    public static final String IIIo0Xo = "S1961A";

    /* renamed from: IIIxO */
    @OOXIXo
    public static final String f20341IIIxO = "YH04";

    @OOXIXo
    public static final String IIIxxOO = "GF010";

    @OOXIXo
    public static final String IIO = "AM05";

    @OOXIXo
    public static final String IIO0X0I = "A19";

    /* renamed from: IIOIX */
    @OOXIXo
    public static final String f20342IIOIX = "M4_LE";

    @OOXIXo
    public static final String IIOXx = "SH23";

    @OOXIXo
    public static final String IIX = "A8 plus";

    /* renamed from: IIX0 */
    @OOXIXo
    public static final String f20343IIX0 = "L1";

    /* renamed from: IIX0o */
    @OOXIXo
    public static final String f20344IIX0o = "FT1";

    /* renamed from: IIXOooo */
    @OOXIXo
    public static final String f20345IIXOooo = "TYME ELITE";

    /* renamed from: IIXOxIxOo */
    @OOXIXo
    public static final String f20346IIXOxIxOo = "POLAR SW300";

    @OOXIXo
    public static final String IIXOxX = "K99";

    @OOXIXo
    public static final String IIXxoXXox = "Veryfit V1 Ultra";

    @OOXIXo
    public static final String IIo0I0X0 = "BOSS";

    @OOXIXo
    public static final String IIoIIxx = "WAVEFURYBT";

    @OOXIXo
    public static final String IIoO0x = "S02";

    @OOXIXo
    public static final String IIoOIO0 = "HK87K";

    /* renamed from: IIoX0OoI */
    @OOXIXo
    public static final String f20347IIoX0OoI = "PA87";

    @OOXIXo
    public static final String IIx = "DCW-01";

    @OOXIXo
    public static final String IIxO = "LCDLC WATCH";

    /* renamed from: IIxOXoOo0 */
    @OOXIXo
    public static final String f20348IIxOXoOo0 = "Watch A1";

    @OOXIXo
    public static final String IIxOxOx0 = "HK98";

    @OOXIXo
    public static final String IIxxXX = "weight";

    /* renamed from: IO */
    @OOXIXo
    public static final String f20349IO = "HONG KONG";

    @OOXIXo
    public static final String IO0 = "R1522";

    @OOXIXo
    public static final String IO00 = "S2011";

    @OOXIXo
    public static final String IO0000X0X = "R18J";

    @OOXIXo
    public static final String IO00xOx0 = "F29 Pro";

    /* renamed from: IO0XoXxO */
    @OOXIXo
    public static final String f20350IO0XoXxO = "CONEKT Race 1i";

    @OOXIXo
    public static final String IO0Xox = "W34 Pro MAX";

    @OOXIXo
    public static final String IO0o = "KODAK205";

    @OOXIXo
    public static final String IO0xO = "blood_oxygen";

    /* renamed from: IO0xX */
    @OOXIXo
    public static final String f20351IO0xX = "CURREN S1";

    /* renamed from: IOI */
    @OOXIXo
    public static final String f20352IOI = "i-Watch Classic";

    @OOXIXo
    public static final String IOI0XxIo = "SW-2 PRO";

    @OOXIXo
    public static final String IOIOO0 = "DV06";

    @OOXIXo
    public static final String IOIOooXOx = "HX08";

    @OOXIXo
    public static final String IOIxx = "WS001";
    public static final int IOO = 1;

    @OOXIXo
    public static final String IOOOI = "FireBoltt 151";

    /* renamed from: IOOXOOOOo */
    @OOXIXo
    public static final String f20353IOOXOOOOo = "F7C";

    /* renamed from: IOOoXo0Ix */
    @OOXIXo
    public static final String f20354IOOoXo0Ix = "F3 Pro";

    @OOXIXo
    public static final String IOOx = "GRC_LITE";

    @OOXIXo
    public static final String IOOxxIox = "dv06Pro";

    @OOXIXo
    public static final String IOXI = "G7 Talk PRO";

    /* renamed from: IOXOxOII */
    @OOXIXo
    public static final String f20355IOXOxOII = "TRXF-002";

    @OOXIXo
    public static final String IOXX00X = "JETE-AM3";

    /* renamed from: IOo0 */
    @OOXIXo
    public static final String f20356IOo0 = "magnus";

    @OOXIXo
    public static final String IOoXX = "W102";

    /* renamed from: IOoo */
    @OOXIXo
    public static final String f20357IOoo = "FIT GO R1";

    @OOXIXo
    public static final String IOoxOXXx0 = "AK01";

    @OOXIXo
    public static final String IOx0XI0 = "MT37";

    @OOXIXo
    public static final String IOxO = "MI 10";

    @OOXIXo
    public static final String IOxOOIIO = "JX521C";

    @OOXIXo
    public static final String IOxoXoI = "X-Level X-WearSmart";

    @OOXIXo
    public static final String IOxoo = "TRXF-001";

    @OOXIXo
    public static final String IOxxIx = "BeatXP Vega Neo";

    @OOXIXo
    public static final String IX = "aigo-V2";

    @OOXIXo
    public static final String IX0 = "JR-FC2";

    @OOXIXo
    public static final String IX0IO = "F32";

    @OOXIXo
    public static final String IX0OOX = "F6 Plus";

    /* renamed from: IXI */
    @OOXIXo
    public static final String f20359IXI = "ARMODD Sil3GPS";

    /* renamed from: IXIIo */
    @OOXIXo
    public static final String f20360IXIIo = "IK-WSBB9";

    @OOXIXo
    public static final String IXIOOoxX = "GF09";

    /* renamed from: IXIxx0 */
    @OOXIXo
    public static final String f20361IXIxx0 = "YH03";

    /* renamed from: IXO */
    @OOXIXo
    public static final String f20362IXO = "JR-FT1";

    @OOXIXo
    public static final String IXOO0X0 = "MAREA 33";

    @OOXIXo
    public static final String IXOXoIo0x = "CY500";

    @OOXIXo
    public static final String IXOxX = "POLOYS04PRO";

    /* renamed from: IXX */
    @OOXIXo
    public static final String f20363IXX = "ROMA";

    /* renamed from: IXXIXx00I */
    @OOXIXo
    public static final String f20364IXXIXx00I = "Aerosmart F";

    @OOXIXo
    public static final String IXXOI = "M5";

    @OOXIXo
    public static final String IXXxOX00X = "H-WATCH";

    @OOXIXo
    public static final String IXXxo = "KRONOS OPTIMUM";

    /* renamed from: IXo */
    @OOXIXo
    public static final String f20365IXo = "SW300";

    /* renamed from: IXoIo */
    @OOXIXo
    public static final String f20366IXoIo = "GT01_LE";

    @OOXIXo
    public static final String IXoXxxO = "sportaland-X1";

    @OOXIXo
    public static final String IXooXOxI0 = "YH10";

    @OOXIXo
    public static final String IXoxO = "THORTON #Klok";

    @OOXIXo
    public static final String IXx = "S1836";

    @OOXIXo
    public static final String IXx0 = "Watch3 Pro";

    @OOXIXo
    public static final String IXx00O0Ox = "R21";

    @OOXIXo
    public static final String IXx0oOO = "SW-03";

    @OOXIXo
    public static final String IXx0x = "Gizmore PRIME";

    /* renamed from: IXxOIOO */
    @OOXIXo
    public static final String f20367IXxOIOO = "TICK-WSWE";

    @OOXIXo
    public static final String IXxoX0Ix = "V61_DR";

    /* renamed from: IXxxXO */
    @OOXIXo
    public static final String f20368IXxxXO = "R4-T";

    /* renamed from: Io */
    @OOXIXo
    public static final String f20369Io = "F13S";

    @OOXIXo
    public static final String Io00oOXox = "S2012";

    @OOXIXo
    public static final String Io0OXxX = "S80K";

    @OOXIXo
    public static final String IoI = "ISW-O43";

    /* renamed from: IoIOOxIIo */
    @OOXIXo
    public static final String f20370IoIOOxIIo = "PA89";

    @OOXIXo
    public static final String IoIOXX = "GF09-01";

    @OOXIXo
    public static final String IoIxoI = "SWIM 50";

    @OOXIXo
    public static final String IoO = "LEADER";

    @OOXIXo
    public static final String IoOIIOx = "MAREA 32";

    /* renamed from: IoOoX */
    @OOXIXo
    public static final String f20371IoOoX = "TYME JEWL";

    /* renamed from: IoOoo */
    @OOXIXo
    public static final String f20372IoOoo = "bfit";

    @OOXIXo
    public static final String IoOoo0XXX = "Spark watch";
    public static final int IoOxoIx = 2;

    /* renamed from: IoX */
    @OOXIXo
    public static final String f20373IoX = "F6J";

    @OOXIXo
    public static final String IoXI = "R20";

    @OOXIXo
    public static final String IoXIOI0O = "GT-S4";

    @OOXIXo
    public static final String IoXIOXo = "R1501";

    /* renamed from: IoXIXo */
    @OOXIXo
    public static final String f20374IoXIXo = "F1";

    @OOXIXo
    public static final String IoXIo = "HUFit5";

    /* renamed from: IoXO0XoX */
    @OOXIXo
    public static final String f20375IoXO0XoX = "GARETT_V10";

    @OOXIXo
    public static final String IoXOxx0o = "F95";

    @OOXIXo
    public static final String IoXx = "TM10";

    @OOXIXo
    public static final String Ioo = "beatXP vector";

    @OOXIXo
    public static final String Ioo0OxIo = "FWA11";

    @OOXIXo
    public static final String IooIo0OOO = "M6";

    @OOXIXo
    public static final String IooOI0x = "CGWatch Round";

    @OOXIXo
    public static final String IooOO = "R1391";

    @OOXIXo
    public static final String IooOox = "Madvell Talon";

    @OOXIXo
    public static final String IoooXox0 = "TOUCHMATE_500";

    @OOXIXo
    public static final String Iox = "AWSF25";

    @OOXIXo
    public static final String IoxOXXxXo = "FUT88";

    /* renamed from: IoxOx */
    @OOXIXo
    public static final String f20376IoxOx = "Zewa SW1";

    /* renamed from: IoxX */
    @OOXIXo
    public static final String f20377IoxX = "AMPM-215";

    @OOXIXo
    public static final String Ioxo0x0x0 = "F18";

    @OOXIXo
    public static final String IoxoI0IX = "i-Watch Sport";

    @OOXIXo
    public static final String IoxoIIx = "C70";

    @OOXIXo
    public static final String IoxooOOx = "X3";

    @OOXIXo
    public static final String Ioxx = "KRONOS EVOLUTION";

    @OOXIXo
    public static final String IoxxXOO = "JX943";

    /* renamed from: Ioxxx */
    @OOXIXo
    public static final String f20378Ioxxx = "Mixx S1";

    @OOXIXo
    public static final String Ix = "K900 Ultra";

    /* renamed from: Ix0 */
    @OOXIXo
    public static final String f20379Ix0 = "HVT02";

    @OOXIXo
    public static final String Ix00 = "P8 ULTRA";

    /* renamed from: Ix00oIoI */
    @OOXIXo
    public static final String f20380Ix00oIoI = "N61";

    @OOXIXo
    public static final String Ix00xIoO = "Elle Soleil";

    @OOXIXo
    public static final String Ix0X0oxX = "PLAYFIT SW71";

    @OOXIXo
    public static final String Ix0XO = "M7 Pro";

    @OOXIXo
    public static final String Ix0Xx = "HK89";

    /* renamed from: Ix0x */
    @OOXIXo
    public static final String f20381Ix0x = "NWF5";

    /* renamed from: IxI */
    @OOXIXo
    public static final String f20382IxI = "X29";

    @OOXIXo
    public static final String IxIOOxO = "RIRO WATCH W1 SE";

    /* renamed from: IxIX0I */
    @OOXIXo
    public static final String f20383IxIX0I = "LANE";

    @OOXIXo
    public static final String IxIXo = "FM U PLUS";

    @OOXIXo
    public static final String IxIXoo = "HML Snore Stopper";

    /* renamed from: IxIo */
    @OOXIXo
    public static final String f20384IxIo = "Explor_LE";

    @OOXIXo
    public static final String IxIoXOO = "V6H";

    /* renamed from: IxO0Oxo */
    @OOXIXo
    public static final String f20385IxO0Oxo = "PW13";

    @OOXIXo
    public static final String IxO0X0 = "DH PRO";

    /* renamed from: IxOIO */
    @OOXIXo
    public static final String f20386IxOIO = "LINSAY EX-10L";

    @OOXIXo
    public static final String IxOOI0Xo = "SIA-WOOH1";

    /* renamed from: IxOXOxO */
    @OOXIXo
    public static final String f20387IxOXOxO = "PW16";

    @OOXIXo
    public static final String IxX0 = "DANX-DR50";

    /* renamed from: IxX00 */
    @OOXIXo
    public static final String f20388IxX00 = "HiMate";

    @OOXIXo
    public static final String IxXOO0o0 = "S14 Ultra MAX";

    @OOXIXo
    public static final String IxXXI0Xo = "FireBoltt 186";

    @OOXIXo
    public static final String IxXxoIIO = "SSW-004";

    @OOXIXo
    public static final String Ixo0 = "A8 Ultra Pro";

    @OOXIXo
    public static final String IxoOxx = "U8";

    @OOXIXo
    public static final String IxoXXoXo = "K98";

    @OOXIXo
    public static final String IxoXx = "ERATACTIC-BTC";

    @OOXIXo
    public static final String IxoooIO0 = "S2011A";

    @OOXIXo
    public static final String Ixox0x = "MILANO OLED";

    @OOXIXo
    public static final String IxxOI = "Motive 5 pro";

    @OOXIXo
    public static final String IxxOIX = "XO-J9";

    @OOXIXo
    public static final String IxxXI0o = "ST AM05";

    @OOXIXo
    public static final String IxxxXx0I = "buzz Watch S1";

    /* renamed from: O0 */
    @OOXIXo
    public static final String f20389O0 = "DUBAI";

    /* renamed from: O00 */
    @OOXIXo
    public static final String f20390O00 = "TEMPUS SW70.3";

    @OOXIXo
    public static final String O000IX = "DSMART R16";

    @OOXIXo
    public static final String O00Ix = "GRC_FENIX";

    @OOXIXo
    public static final String O00X = "Tempo 4R";

    /* renamed from: O00XxXI */
    @OOXIXo
    public static final String f20391O00XxXI = "ITIME";

    @OOXIXo
    public static final String O00oxX0 = "Lunar Peak";

    @OOXIXo
    public static final String O0I = "MH 75";

    @OOXIXo
    public static final String O0IIO0 = "NINJA PRO";

    @OOXIXo
    public static final String O0IX = "Amoled Round Voice";

    /* renamed from: O0IoXXOx */
    @OOXIXo
    public static final String f20392O0IoXXOx = "CT-S2";

    @OOXIXo
    public static final String O0Ix00 = "AM08";

    /* renamed from: O0IxXx */
    @OOXIXo
    public static final String f20393O0IxXx = "D-Chain";

    /* renamed from: O0O0Io00X */
    @OOXIXo
    public static final String f20394O0O0Io00X = "Call Watch";

    @OOXIXo
    public static final String O0OO = "Phonemax Watch1";

    @OOXIXo
    public static final String O0OO0Ox = "SW-2U";

    /* renamed from: O0OOX0IIx */
    @OOXIXo
    public static final String f20395O0OOX0IIx = "M7_LE";

    @OOXIXo
    public static final String O0OOoIox = "FM U";

    @OOXIXo
    public static final String O0OoIOIxX = "R1521";

    /* renamed from: O0OoXI */
    @OOXIXo
    public static final String f20396O0OoXI = "Polartec POLS11";

    @OOXIXo
    public static final String O0OxXXox = "S5";

    /* renamed from: O0X */
    @OOXIXo
    public static final String f20397O0X = "CB-ORBIT";

    @OOXIXo
    public static final String O0X0xoXo = "S1";

    @OOXIXo
    public static final String O0XI0 = "SmartX03";

    @OOXIXo
    public static final String O0XI00X0o = "Black Shark S1 Pro";

    @OOXIXo
    public static final String O0XOI = "Kufone M80";

    @OOXIXo
    public static final String O0XX0IX = "beatXP nuke";

    @OOXIXo
    public static final String O0Xo = "A8";

    /* renamed from: O0Xx */
    @OOXIXo
    public static final String f20398O0Xx = "AT803T";

    @OOXIXo
    public static final String O0o = "Motive 6 Pro";

    /* renamed from: O0o0 */
    @OOXIXo
    public static final String f20399O0o0 = "L2";

    @OOXIXo
    public static final String O0o000XOX = "AM01J";

    @OOXIXo
    public static final String O0o0OI00 = "AW12";

    @OOXIXo
    public static final String O0o0OO = "V8 Pro";

    @OOXIXo
    public static final String O0oXOX0XX = "F24 R5";

    @OOXIXo
    public static final String O0oo0o = "Roam 4";

    /* renamed from: O0x */
    @OOXIXo
    public static final String f20400O0x = "HUFit3_LE";

    @OOXIXo
    public static final String O0x0XII = "HX08-S";

    @OOXIXo
    public static final String O0x0XXxI = "GRC_MAXX";

    /* renamed from: O0xO0 */
    @OOXIXo
    public static final String f20401O0xO0 = "KUBE";

    @OOXIXo
    public static final String O0xOXxxx = "Sones ISW-12U";

    @OOXIXo
    public static final String O0xOx0 = "RIRO WATCH W2 SE";

    /* renamed from: O0xOxO */
    @OOXIXo
    public static final String f20402O0xOxO = "R6";

    @OOXIXo
    public static final String O0xoXo00O = "FC2";

    /* renamed from: O0xxXxI */
    @OOXIXo
    public static final String f20403O0xxXxI = "R3H";

    @OOXIXo
    public static final String OI = "FW56";

    /* renamed from: OI0 */
    @OOXIXo
    public static final String f20404OI0 = "F13";

    @OOXIXo
    public static final String OI00 = "R16";

    @OOXIXo
    public static final String OI00Oo0 = "D12C";

    /* renamed from: OI0IXox */
    @OOXIXo
    public static final String f20405OI0IXox = "CB-ATLAS";

    @OOXIXo
    public static final String OI0OIIo = "QD36";

    @OOXIXo
    public static final String OI0xX = "MAX11";

    /* renamed from: OIII0O */
    @OOXIXo
    public static final String f20406OIII0O = "R10 Pro";

    @OOXIXo
    public static final String OIIO0oIoO = "S59MAX";

    @OOXIXo
    public static final String OIIOOoXx = "S99";

    @OOXIXo
    public static final String OIIXIIO0 = "F23";

    /* renamed from: OIIXOxo */
    @OOXIXo
    public static final String f20407OIIXOxo = "ZEST PRO";

    @OOXIXo
    public static final String OIIoIo = "CJ08";

    @OOXIXo
    public static final String OIIxOxx = "R13";

    @OOXIXo
    public static final String OIO = "SW-GIA102 PRO";

    @OOXIXo
    public static final String OIO0XIo = "KODAK210";

    @OOXIXo
    public static final String OIOIxOO = "HAYLOU WATCH";

    @OOXIXo
    public static final String OIOO = "T-fit 400 C";

    @OOXIXo
    public static final String OIOXo = "Infinity";

    /* renamed from: OIOoIIOIx */
    @OOXIXo
    public static final String f20408OIOoIIOIx = "GX-2";

    @OOXIXo
    public static final String OIOxOX = "JETE-FR12";

    @OOXIXo
    public static final String OIX0oXO0o = "WAVE VAST";

    @OOXIXo
    public static final String OIXI = "HT12";

    @OOXIXo
    public static final String OIXO = "KODAK203";

    @OOXIXo
    public static final String OIXXIXxX = "SW-2 Ultra";

    @OOXIXo
    public static final String OIXo = "Gizmore Vogue";

    @OOXIXo
    public static final String OIo = "SK29";

    @OOXIXo
    public static final String OIo0o = "KSIX CORE";

    /* renamed from: OIoxIx */
    @OOXIXo
    public static final String f20409OIoxIx = "86";

    @OOXIXo
    public static final String OIx = "smawatch";

    /* renamed from: OIx00oxx */
    @OOXIXo
    public static final String f20410OIx00oxx = "M9019G";

    @OOXIXo
    public static final String OIx0IoOx0 = "Motive 7E";

    /* renamed from: OIx0xoOo */
    @OOXIXo
    public static final String f20411OIx0xoOo = "IK-W55";

    /* renamed from: OIxI0O */
    @OOXIXo
    public static final String f20412OIxI0O = "AWSF6";

    /* renamed from: OIxOIX0II */
    @OOXIXo
    public static final String f20413OIxOIX0II = "OPTIMA";

    /* renamed from: OIxOX */
    @OOXIXo
    public static final String f20414OIxOX = "Redlemon BT_LE";

    @OOXIXo
    public static final String OIxOo0XI = "G-FORCE SMART";

    @OOXIXo
    public static final String OIxooI0 = "muWATCH1";

    /* renamed from: OIxx0I0 */
    @OOXIXo
    public static final String f20415OIxx0I0 = "TCRD_TGW1_LE";

    /* renamed from: OO */
    @OOXIXo
    public static final String f20416OO = "SF Lite";

    /* renamed from: OO0 */
    @OOXIXo
    public static final String f20417OO0 = "Trail Force Watch";

    @OOXIXo
    public static final String OO00 = "DANX-DR40";

    @OOXIXo
    public static final String OO00IOOo = "R21";

    @OOXIXo
    public static final String OO00XXI = "Motive 8";

    @OOXIXo
    public static final String OO00xO0I = "AM10A";

    /* renamed from: OO0x0xX */
    @OOXIXo
    public static final String f20418OO0x0xX = "Senturon";

    @OOXIXo
    public static final String OOI = "WELEVATEBT";

    @OOXIXo
    public static final String OOI00oxoO = "Gizmore 934";

    @OOXIXo
    public static final String OOI0Xo = "YS01PRO";

    @OOXIXo
    public static final String OOIX = "TC002";

    /* renamed from: OOIXx0x */
    @OOXIXo
    public static final String f20419OOIXx0x = "HW22 Pro_LE";

    @OOXIXo
    public static final String OOO = "IMS-758";

    /* renamed from: OOOI */
    @OOXIXo
    public static final String f20420OOOI = "F3D_LE";

    @OOXIXo
    public static final String OOOO = "LUNAR TIGON";

    /* renamed from: OOOox */
    @OOXIXo
    public static final String f20421OOOox = "CGWatch Classic";

    @OOXIXo
    public static final String OOOxXxoO = "smart time";

    @OOXIXo
    public static final String OOX0x = "SENS5";

    @OOXIXo
    public static final String OOXI0Ixxx = "CORN RW5";

    /* renamed from: OOXIXo */
    @OOXIXo
    public static final String f20422OOXIXo = "HiWave";

    /* renamed from: OOXIxO0 */
    @OOXIXo
    public static final String f20423OOXIxO0 = "F3B";

    @OOXIXo
    public static final String OOXIxoX = "R6pro";

    @OOXIXo
    public static final String OOXo0xOXx = "R5";

    @OOXIXo
    public static final String OOXx = "watch 11";

    @OOXIXo
    public static final String OOo = "Edyson3";

    /* renamed from: OOoOoO0o */
    @OOXIXo
    public static final String f20424OOoOoO0o = "Capri";

    @OOXIXo
    public static final String OOox = "HX10";

    @OOXIXo
    public static final String OOoxI = "HK21";

    /* renamed from: OOxOI */
    @OOXIXo
    public static final String f20425OOxOI = "P8 Pro_LE";

    /* renamed from: OOxOOxIO */
    @OOXIXo
    public static final String f20426OOxOOxIO = "F6";

    @OOXIXo
    public static final String OOxOXI0 = "Cosmic X";

    @OOXIXo
    public static final String OOxXXO = "PB Z3";

    @OOXIXo
    public static final String OOxXo = "SW-GTR9";

    @OOXIXo
    public static final String OOxxOOX = "RIRO WATCH W1P";

    /* renamed from: OX */
    @OOXIXo
    public static final String f20427OX = "FXR 2";

    /* renamed from: OX00O0xII */
    @OOXIXo
    public static final String f20428OX00O0xII = "IGNITE-S2";

    /* renamed from: OX00o0X */
    @OOXIXo
    public static final String f20429OX00o0X = "Urban 6X";

    @OOXIXo
    public static final String OX0xI0IO = "SK4Max";

    @OOXIXo
    public static final String OXI = "F24";

    @OOXIXo
    public static final String OXI0XXxIo = "MAREA 34";

    @OOXIXo
    public static final String OXIIo0 = "ERA ONE LITE";

    /* renamed from: OXIOoo0X0 */
    @OOXIXo
    public static final String f20430OXIOoo0X0 = "M5C-GPS WATCH";

    @OOXIXo
    public static final String OXIxXO0 = "X2";

    @OOXIXo
    public static final String OXO0 = "YH12";

    @OOXIXo
    public static final String OXO0oX = "A7";

    @OOXIXo
    public static final String OXOXxxOOO = "IMS-754";

    /* renamed from: OXOo */
    @OOXIXo
    public static final String f20431OXOo = "FW53";

    @OOXIXo
    public static final String OXOxXI = "W15";

    @OOXIXo
    public static final String OXX = "Parlent";

    @OOXIXo
    public static final String OXX0xxo = "WATCH 13";

    @OOXIXo
    public static final String OXXo0 = "RIRO WATCH W3";

    /* renamed from: OXXoIoXI */
    @OOXIXo
    public static final String f20432OXXoIoXI = "T88 Pro_LE";

    @OOXIXo
    public static final String OXXxXoO = "SEEKEN GRAVITY N";

    @OOXIXo
    public static final String OXoIOx = "THORTON #Geni";

    @OOXIXo
    public static final String OXoIXx = "F6 Pro";

    @OOXIXo
    public static final String OXoOxOxX = "G7 Talk PRO";

    @OOXIXo
    public static final String OXooXOXx = "RIRO W1Pro";

    /* renamed from: OXooXo */
    @OOXIXo
    public static final String f20433OXooXo = "F5";

    @OOXIXo
    public static final String OXx = "RIRO WATCH W2";

    @OOXIXo
    public static final String OXxIOxox = "OA88S";

    @OOXIXo
    public static final String OXxIXOxO = "DV05";

    @OOXIXo
    public static final String OXxO = "OA88";

    @OOXIXo
    public static final String OXxXX = "ecg";

    @OOXIXo
    public static final String OXxXoOx = "RS-9188";

    @OOXIXo
    public static final String OXxo = "R9max";
    public static final int OXxx = 3;

    /* renamed from: OXxx0OO */
    @OOXIXo
    public static final String f20434OXxx0OO = "HK--CSS";

    /* renamed from: Oo */
    @OOXIXo
    public static final String f20435Oo = "R5-T";

    @OOXIXo
    public static final String Oo00XooIO = "A8 Plus F5";

    @OOXIXo
    public static final String Oo0I0Io = "aigo GTS1";

    /* renamed from: Oo0IXI0 */
    @OOXIXo
    public static final String f20436Oo0IXI0 = "GRC_LIVE";

    @OOXIXo
    public static final String Oo0OxoOx = "SWIM 40";

    @OOXIXo
    public static final String Oo0oOO = "DV08";

    /* renamed from: Oo0xX */
    @OOXIXo
    public static final String f20437Oo0xX = "F2K";

    /* renamed from: OoI0OO */
    @OOXIXo
    public static final String f20438OoI0OO = "ManCity";

    @OOXIXo
    public static final String OoIO0OIX = "Kata Smartwatch AM10";

    /* renamed from: OoIXo */
    @OOXIXo
    public static final String f20439OoIXo = "UBON SW 81";

    @OOXIXo
    public static final String OoIo = "LANE3";

    @OOXIXo
    public static final String OoIoI0 = "F28";

    /* renamed from: OoO */
    @OOXIXo
    public static final String f20440OoO = "ZEST FIT";

    /* renamed from: OoOoXO0 */
    @OOXIXo
    public static final String f20441OoOoXO0 = "B9";

    @OOXIXo
    public static final String OoOoxX0xo = "W16";

    @OOXIXo
    public static final String OoX = "FireBoltt 175";

    @OOXIXo
    public static final String OoXX = "GL-3";

    @OOXIXo
    public static final String OoXx = "POLO YS02PRO";

    /* renamed from: OooI */
    @OOXIXo
    public static final String f20442OooI = "AFWG0721";

    @OOXIXo
    public static final String OooI0 = "V62";

    /* renamed from: OooO0XOx */
    @OOXIXo
    public static final String f20443OooO0XOx = "Michelin_LE";

    @OOXIXo
    public static final String OooOoX = "HX09";

    @OOXIXo
    public static final String OooXX0 = "GreyBand Horizon";

    @OOXIXo
    public static final String OoooxII = "PHANTOM";

    /* renamed from: Oox */
    @OOXIXo
    public static final String f20444Oox = "F10";

    @OOXIXo
    public static final String Oox0oOO0 = "KONKA WB10";

    /* renamed from: OoxOxII */
    @OOXIXo
    public static final String f20445OoxOxII = "FitShot Curl";

    /* renamed from: OoxxX */
    @OOXIXo
    public static final String f20446OoxxX = "LG19T";

    @OOXIXo
    public static final String Ooxxx = "JETE-AM2";

    /* renamed from: Ox */
    @OOXIXo
    public static final String f20447Ox = "Aerosmart R";

    @OOXIXo
    public static final String Ox0 = "JX695";

    /* renamed from: Ox00XOXoo */
    @OOXIXo
    public static final String f20448Ox00XOXoo = "X-AGE CLICK";

    /* renamed from: Ox0O */
    @OOXIXo
    public static final String f20449Ox0O = "R11";

    @OOXIXo
    public static final String Ox0O0X = "v6";

    /* renamed from: Ox0XO */
    @OOXIXo
    public static final String f20450Ox0XO = "B9C";

    @OOXIXo
    public static final String Ox0XX = "F6_V3_64M_Ignite_S3";

    /* renamed from: OxI */
    @OOXIXo
    public static final String f20451OxI = "R5";

    @OOXIXo
    public static final String OxI0 = "X-AGE BUZZ";

    @OOXIXo
    public static final String OxI0000XO = "F18Plus";

    @OOXIXo
    public static final String OxII = "R23";

    @OOXIXo
    public static final String OxIOX = "Black Shark GT3";

    @OOXIXo
    public static final String OxIX = "v8";

    @OOXIXo
    public static final String OxIXxXXI0 = "KODAK204";

    @OOXIXo
    public static final String OxIoXo = "Hapipola Curve";

    /* renamed from: OxIxx0 */
    @OOXIXo
    public static final String f20452OxIxx0 = "RC08";

    /* renamed from: OxO */
    @OOXIXo
    public static final String f20453OxO = "L8_LE";

    @OOXIXo
    public static final String OxX = "FireBoltt 179";

    @OOXIXo
    public static final String OxXIO = "S3 PRO";

    @OOXIXo
    public static final String OxXIoIX = "GSW-1020";

    @OOXIXo
    public static final String OxXIoIxIo = "S1835";

    @OOXIXo
    public static final String OxXO0oo = "FireBoltt 174";

    @OOXIXo
    public static final String OxXOo = "temperature";

    @OOXIXo
    public static final String OxXOoO = "ERA DAY";

    @OOXIXo
    public static final String OxXXx0OX = "R9J";

    /* renamed from: OxXXx0X */
    @OOXIXo
    public static final String f20454OxXXx0X = "F3_LE";

    @OOXIXo
    public static final String OxXooIXO = "R4_T_TCRD";

    /* renamed from: Oxo00O */
    @OOXIXo
    public static final String f20455Oxo00O = "M9016 Pro";

    @OOXIXo
    public static final String OxoIO00 = "HX 4Pro";

    @OOXIXo
    public static final String OxoOX0X0 = "JETE-MUSE";

    /* renamed from: Oxx */
    @OOXIXo
    public static final String f20456Oxx = "EraOne";

    /* renamed from: Oxx0IOOO */
    @OOXIXo
    public static final String f20457Oxx0IOOO = "SMA-R4";

    @OOXIXo
    public static final String Oxx0XxOI0 = "Swiss International";

    /* renamed from: Oxx0xo */
    @OOXIXo
    public static final String f20458Oxx0xo = "M9014";

    /* renamed from: OxxIIOOXO */
    @OOXIXo
    public static final String f20459OxxIIOOXO = "d:smart";

    @OOXIXo
    public static final String OxxIXIX = "FM SP U";

    /* renamed from: Oxxo */
    @OOXIXo
    public static final String f20460Oxxo = "QUID Plus";

    @OOXIXo
    public static final String Oxxx0X0oI = "Rizto R15";

    @OOXIXo
    public static final String X000ooOxx = "R1431";

    @OOXIXo
    public static final String X00IoX = "E_LAND";

    /* renamed from: X00IoxXI */
    @OOXIXo
    public static final String f20462X00IoxXI = "Zewa AT3";

    /* renamed from: X00IxOx */
    @OOXIXo
    public static final String f20463X00IxOx = "G3";

    @OOXIXo
    public static final String X00O = "FM SOUL";

    /* renamed from: X00xOoXI */
    @OOXIXo
    public static final String f20464X00xOoXI = "T80_LE";

    /* renamed from: X0IIOO */
    @OOXIXo
    public static final String f20465X0IIOO = "R8";

    /* renamed from: X0IOOI */
    @OOXIXo
    public static final String f20466X0IOOI = "KU1 Pro";

    @OOXIXo
    public static final String X0IXX = "ERA ARMY EROS";

    @OOXIXo
    public static final String X0Ix00XxO = "A8 ultra";

    /* renamed from: X0O0I0 */
    @OOXIXo
    public static final String f20467X0O0I0 = "L9_LE";

    @OOXIXo
    public static final String X0OIo0XxO = "Air4";

    @OOXIXo
    public static final String X0OXI = "F11";

    @OOXIXo
    public static final String X0OXIOxX = "blood_glucose2";

    /* renamed from: X0OXX */
    @OOXIXo
    public static final String f20468X0OXX = "OMT E-Joy SE";

    @OOXIXo
    public static final String X0OXoo0 = "Rizto_R20";

    @OOXIXo
    public static final String X0OXxIII = "GT-S1";

    @OOXIXo
    public static final String X0Ox = "R1";

    @OOXIXo
    public static final String X0OxoOx = "Eon+";

    @OOXIXo
    public static final String X0X = "GF03Pro";

    @OOXIXo
    public static final String X0X0 = "GT9";

    @OOXIXo
    public static final String X0XI = "IT Watch WR01";

    @OOXIXo
    public static final String X0XXxoOoX = "V61";

    /* renamed from: X0o0xo */
    @OOXIXo
    public static final String f20469X0o0xo = "FW47";

    @OOXIXo
    public static final String X0oO = "Curve";

    @OOXIXo
    public static final String X0oX = "GRC_CLASSIC";

    /* renamed from: X0ooXIooI */
    @OOXIXo
    public static final String f20470X0ooXIooI = "M5_LE";

    @OOXIXo
    public static final String X0oxOX = "Kata AM10";

    /* renamed from: X0x */
    @OOXIXo
    public static final String f20471X0x = "AWEI Watch";

    @OOXIXo
    public static final String X0xO = "MIAMI";

    /* renamed from: X0xOO */
    @OOXIXo
    public static final String f20473X0xOO = "Smart Watch";

    @OOXIXo
    public static final String X0xX = "A8";

    @OOXIXo
    public static final String X0xXOX = "BeatXP Marv-Ace";

    /* renamed from: X0xxXX0 */
    @OOXIXo
    public static final String f20474X0xxXX0 = "Kronos X2";

    /* renamed from: XI */
    @OOXIXo
    public static final String f20475XI = "Fitme Spectre";

    @OOXIXo
    public static final String XI0 = "FitRist Icon 2E";

    /* renamed from: XI0IXoo */
    @OOXIXo
    public static final String f20476XI0IXoo = "Redlemon BT";

    @OOXIXo
    public static final String XI0O = "R7";

    @OOXIXo
    public static final String XI0Ox = "buzz Watch S2";
    public static final int XI0oI = 101520;

    /* renamed from: XI0oooXX */
    @OOXIXo
    public static final String f20477XI0oooXX = "F3C";

    @OOXIXo
    public static final String XIIOIXoI = "AM09";

    @OOXIXo
    public static final String XIIo = "R1 MAX";

    @OOXIXo
    public static final String XIIxIX = "A7";

    @OOXIXo
    public static final String XIIxXO = "QOR9 TICKTALK";

    /* renamed from: XIOOI */
    @OOXIXo
    public static final String f20478XIOOI = "T9";

    @OOXIXo
    public static final String XIOOX0 = "AW46";

    @OOXIXo
    public static final String XIOX = "S80 PRO";

    @OOXIXo
    public static final String XIOoI = "Beat 5";

    @OOXIXo
    public static final String XIOxIIxxI = "twhite one";

    @OOXIXo
    public static final String XIX = "JM iTOUCH Air 4";

    @OOXIXo
    public static final String XIX0Oo0 = "W113 PRO";

    /* renamed from: XIXIX */
    @OOXIXo
    public static final String f20479XIXIX = "M WATCH";

    @OOXIXo
    public static final String XIXIo0OX = "GIZFIT 953";

    /* renamed from: XIXIxO */
    @OOXIXo
    public static final String f20480XIXIxO = "UP! Smart Active";

    @OOXIXo
    public static final String XIo = "JXJS-AM01";

    @OOXIXo
    public static final String XIo0IOI0 = "JR-FT5";

    /* renamed from: XIo0oOXIx */
    @OOXIXo
    public static final String f20481XIo0oOXIx = "HUFit1";

    @OOXIXo
    public static final String XIoox00ox = "JETE-FR11";

    @OOXIXo
    public static final String XIoxO00 = "heart_rate";

    @OOXIXo
    public static final String XIx = "FWA10";

    @OOXIXo
    public static final String XIx0 = "HAYLOU Watch R8";

    @OOXIXo
    public static final String XIxI = "GT-V2H";

    @OOXIXo
    public static final String XIxIO0XO = "FM U MAX";

    @OOXIXo
    public static final String XIxIOOOx = "K96";

    /* renamed from: XIxO */
    @OOXIXo
    public static final String f20482XIxO = "G5 TALK";

    @OOXIXo
    public static final String XIxOIII = "AW32";

    /* renamed from: XIxXXX0x0 */
    @OOXIXo
    public static final String f20483XIxXXX0x0 = "ZH02";

    @OOXIXo
    public static final String XIxoOo0oI = "HK90";

    /* renamed from: XO */
    @OOXIXo
    public static final String f20484XO = "F1N";

    /* renamed from: XO0 */
    @OOXIXo
    public static final String f20485XO0 = "Rhine 1";

    @OOXIXo
    public static final String XO000 = "Salpido SW-66";

    /* renamed from: XO00XOO */
    @OOXIXo
    public static final String f20486XO00XOO = "T88_LE";

    /* renamed from: XO0OX */
    @OOXIXo
    public static final String f20487XO0OX = "SECTOR S-03 PRO";

    @OOXIXo
    public static final String XO0XIXOo0 = "UM88";

    /* renamed from: XO0o */
    @OOXIXo
    public static final String f20488XO0o = "PT2";

    @OOXIXo
    public static final String XOIIOIx = "Wave Hype";

    @OOXIXo
    public static final String XOIoXxI = "AM06";

    @OOXIXo
    public static final String XOO = "D3C";

    @OOXIXo
    public static final String XOOI = "Black Shark S1 Lite";

    @OOXIXo
    public static final String XOOI0 = "A80";

    /* renamed from: XOOO0O */
    @OOXIXo
    public static final String f20489XOOO0O = "FM PRO S";

    @OOXIXo
    public static final String XOOXI0 = "SmartWatch";

    @OOXIXo
    public static final String XOOXX0II = "JX946C";

    @OOXIXo
    public static final String XOOoX0xo = "V92";

    @OOXIXo
    public static final String XOOooo = "PALL S ONE PLUS";

    @OOXIXo
    public static final String XOOxX = "FireBoltt 094";

    @OOXIXo
    public static final String XOX = "HX8";

    @OOXIXo
    public static final String XOX0XxOxI = "NK36";

    @OOXIXo
    public static final String XOX0x0XO = "Active Pro";

    @OOXIXo
    public static final String XOXo0 = "KODAK209";

    @OOXIXo
    public static final String XOXxX0 = "KRONOS PRIME";

    @OOXIXo
    public static final String XOXxxXo = "FC1";

    @OOXIXo
    public static final String XOo = "ALTSWATCALLBK";

    /* renamed from: XOo0 */
    @OOXIXo
    public static final String f20490XOo0 = "NWF6";

    @OOXIXo
    public static final String XOoI = "F17";

    @OOXIXo
    public static final String XOoxOOO = "HK24";

    @OOXIXo
    public static final String XOoxOo0oX = "SW01 Ultra";

    /* renamed from: XOx */
    @OOXIXo
    public static final String f20491XOx = "GRC_LIVE_G";

    @OOXIXo
    public static final String XOx0xX = "AM02S";

    /* renamed from: XOxIOxOx */
    @OOXIXo
    public static final String f20492XOxIOxOx = "AWS115";

    /* renamed from: XOxoX */
    @OOXIXo
    public static final String f20493XOxoX = "MS-GPSWATCH_LE";

    @OOXIXo
    public static final String XOxoXO = "Skyfit- Elevate";

    /* renamed from: XOxxooXI */
    @OOXIXo
    public static final String f20494XOxxooXI = "R10";

    @OOXIXo
    public static final String XOxxxx00X = "BeFit Watch Ultra 2";

    /* renamed from: XX */
    @OOXIXo
    public static final String f20495XX = "SW07C";

    /* renamed from: XX0 */
    @OOXIXo
    public static final String f20496XX0 = "KUMI KU1S";

    @OOXIXo
    public static final String XX00xxo = "X-Level X-WearUltra";

    /* renamed from: XX0xXo */
    @OOXIXo
    public static final String f20497XX0xXo = "F2D";
    public static final int XX0xxI = 5101520;

    @OOXIXo
    public static final String XXI00xO = "GK-S30A";

    @OOXIXo
    public static final String XXI0XXo = "HOCO Y15";

    @OOXIXo
    public static final String XXIX = "F2R_SMARTR";

    @OOXIXo
    public static final String XXIo = "R1301";

    @OOXIXo
    public static final String XXIo0OO = "T30_K";

    /* renamed from: XXIoX0 */
    @OOXIXo
    public static final String f20498XXIoX0 = "GT5";

    @OOXIXo
    public static final String XXO = "Air5PRO";

    /* renamed from: XXO0 */
    @OOXIXo
    public static final String f20499XXO0 = "MOTIVO";

    @OOXIXo
    public static final String XXOO = "Black Shark GT3 Neo";

    @OOXIXo
    public static final String XXOOoxx0x = "Thull TW1";

    @OOXIXo
    public static final String XXOXXx = "AMMO";

    @OOXIXo
    public static final String XXOo = "A8mini";

    @OOXIXo
    public static final String XXOoooXo = "VIDVIE_1619";

    /* renamed from: XXXI */
    @OOXIXo
    public static final String f20500XXXI = "AWSR10";

    @OOXIXo
    public static final String XXXOoIXXx = "Sveston Nitro";

    @OOXIXo
    public static final String XXXoOII = "M1";

    @OOXIXo
    public static final String XXoIoXOO = "W68 ULTRA";

    /* renamed from: XXoO0oX */
    @OOXIXo
    public static final String f20501XXoO0oX = "F2 Pro";

    @OOXIXo
    public static final String XXoOOO0I = "Air3";

    /* renamed from: XXoOx0 */
    @OOXIXo
    public static final String f20502XXoOx0 = "F1RT";

    @OOXIXo
    public static final String XXoXOI = "Go 2";

    @OOXIXo
    public static final String XXoo0 = "SY05";

    /* renamed from: XXooOOI */
    @OOXIXo
    public static final String f20503XXooOOI = "CURREN R3 PRO";

    @OOXIXo
    public static final String XXooo0 = "ALPS 4";

    /* renamed from: XXx0OXXXo */
    @OOXIXo
    public static final String f20504XXx0OXXXo = "IGNITE PRO";

    /* renamed from: Xo */
    @OOXIXo
    public static final String f20505Xo = "POWER G1";

    /* renamed from: Xo0 */
    @OOXIXo
    public static final String f20506Xo0 = "Neo";

    @OOXIXo
    public static final String Xo000XO0 = "W17";

    @OOXIXo
    public static final String Xo00XX = "FXR 3";

    @OOXIXo
    public static final String Xo0IXOO00 = "DANX-DR10";

    @OOXIXo
    public static final String Xo0OOoo = "R9 ultra max";

    @OOXIXo
    public static final String Xo0oxxX0 = "F18Pro";

    @OOXIXo
    public static final String Xo0xX = "GT10PRO";

    @OOXIXo
    public static final String XoI = "G3 Pro";

    @OOXIXo
    public static final String XoI0 = "JX627";

    /* renamed from: XoI0Ixx0 */
    @OOXIXo
    public static final String f20507XoI0Ixx0 = "SW SPORT";

    @OOXIXo
    public static final String XoI0OoX = "Motive 8 Ultra";

    @OOXIXo
    public static final String XoIoOXOIx = "Urban 4X";

    /* renamed from: XoIxOXIXo */
    @OOXIXo
    public static final String f20508XoIxOXIXo = "G4";

    @OOXIXo
    public static final String XoIxo = "myPhone Watch LS";

    @OOXIXo
    public static final String XoO = "S1836A";

    @OOXIXo
    public static final String XoOOOXox = "iTechGladiator2";

    @OOXIXo
    public static final String XoOOoX0 = "WATCH4";

    /* renamed from: XoOOx0IX */
    @OOXIXo
    public static final String f20509XoOOx0IX = "M9030";

    @OOXIXo
    public static final String XoOo0Ooo0 = "Wave Vivid";

    @OOXIXo
    public static final String XoOoxI0X = "IMS-756";

    @OOXIXo
    public static final String XoOoxIIx = "AM10B";

    /* renamed from: XoOxI0ox */
    @OOXIXo
    public static final String f20510XoOxI0ox = "MT05A_LE";

    /* renamed from: XoX */
    @OOXIXo
    public static final String f20511XoX = "F2C";

    @OOXIXo
    public static final String XoXIXxxI0 = "MAREA 39";

    @OOXIXo
    public static final String XoXO = "AW37";

    @OOXIXo
    public static final String XoXOIx = "HAYLOU Watch S8";

    @OOXIXo
    public static final String XoXX = "Black Shark S1 Classic";

    @OOXIXo
    public static final String XoXX0x00 = "W77 Pro MAX";

    @OOXIXo
    public static final String XoXoOo = "H9";

    @OOXIXo
    public static final String Xoo0 = "S13 Ultra MAX";

    /* renamed from: XooIO0oo0 */
    @OOXIXo
    public static final String f20512XooIO0oo0 = "AFTWS-0521_LE";

    @OOXIXo
    public static final String XooOx = "GF07-01";

    @OOXIXo
    public static final String Xooo0Xx = "HK8Ultra";

    @OOXIXo
    public static final String Xoooo = "Kata Smartwatch AM20";

    @OOXIXo
    public static final String XooooIO0 = "HX03";

    @OOXIXo
    public static final String Xox0o = "XO-J8";

    @OOXIXo
    public static final String XoxXOX0I = "Zeb-Hydra";

    @OOXIXo
    public static final String XoxXox = "JETE-AURA";

    @OOXIXo
    public static final String XoxoOo = "GF07";

    /* renamed from: Xx */
    @OOXIXo
    public static final String f20513Xx = "PLUTO SW250";

    /* renamed from: Xx0 */
    @OOXIXo
    public static final String f20514Xx0 = "QUO Plus";

    /* renamed from: Xx000oIo */
    @OOXIXo
    public static final String f20515Xx000oIo = "AMPM-216";

    @OOXIXo
    public static final String Xx0I = "PBL Dare";

    @OOXIXo
    public static final String Xx0IoOX = "Air10";

    @OOXIXo
    public static final String Xx0O0O = "ColorFit Hexa";

    @OOXIXo
    public static final String Xx0OXIoI = "i-Watch S2";

    @OOXIXo
    public static final String Xx0X = "M9030 Pro";

    @OOXIXo
    public static final String Xx0oX = "AM01";

    /* renamed from: XxI */
    @OOXIXo
    public static final String f20516XxI = "GIZFIT 910 PRO";

    @OOXIXo
    public static final String XxI0 = "AM02CE";

    /* renamed from: XxIIOXIXx */
    @OOXIXo
    public static final String f20517XxIIOXIXx = "F9";

    @OOXIXo
    public static final String XxIO0 = "Kronos X4";

    /* renamed from: XxIOX */
    @OOXIXo
    public static final String f20518XxIOX = "AUKEY SW-1";

    @OOXIXo
    public static final String XxIX = "F23C";

    /* renamed from: XxIo */
    @OOXIXo
    public static final String f20519XxIo = "iTIME F3 pro";

    @OOXIXo
    public static final String XxO = "C80";

    @OOXIXo
    public static final String XxOIoXI = "Rizto R19";

    @OOXIXo
    public static final String XxOOO0 = "A10";

    @OOXIXo
    public static final String XxOOX = "Amoled Square Voice";

    @OOXIXo
    public static final String XxOOoxOO = "alt GOAT_ Phone";

    @OOXIXo
    public static final String XxOX = "BeatXP Unbound Curv";

    @OOXIXo
    public static final String XxOXxXo = "R9";

    @OOXIXo
    public static final String XxOx = "HK85";

    /* renamed from: XxX0x0xxx */
    @OOXIXo
    public static final String f20520XxX0x0xxx = "KUMI K17";

    @OOXIXo
    public static final String XxX0xI = "SK24";

    @OOXIXo
    public static final String XxXOXo0Xx = "AM18";

    /* renamed from: XxXX */
    @OOXIXo
    public static final String f20521XxXX = "Explore_LE";

    @OOXIXo
    public static final String XxXxIx = "Air5";

    @OOXIXo
    public static final String Xxo = "Amoled Action Voice";

    @OOXIXo
    public static final String XxoOI00IX = "HK4";

    @OOXIXo
    public static final String XxoOX0I = "Ultra Pro Max";
    public static final int Xxx0o = 581015;

    @OOXIXo
    public static final String Xxx0o0XI = "Gizmore 966";

    /* renamed from: Xxx0oXX */
    @OOXIXo
    public static final String f20522Xxx0oXX = "Y2";

    @OOXIXo
    public static final String XxxIX = "HX12";

    @OOXIXo
    public static final String XxxXX0XO0 = "R1502";

    @OOXIXo
    public static final String XxxoIooX = "BeatXP Unbound Nova";

    @OOXIXo
    public static final String XxxoXoX = "A8 Plus+";

    /* renamed from: o0 */
    @OOXIXo
    public static final String f20523o0 = "HOCO GA10";

    /* renamed from: o00 */
    @OOXIXo
    public static final String f20524o00 = "SMA-R5";

    @OOXIXo
    public static final String o00OI00 = "GOALTAGE-SW03";

    @OOXIXo
    public static final String o00Ox0xOO = "iTOUCH Sport 4";

    /* renamed from: o00xOoIO */
    @OOXIXo
    public static final String f20525o00xOoIO = "TGP78";

    @OOXIXo
    public static final String o0I = "Aerosmart F Pro";

    @OOXIXo
    public static final String o0I0O0oXX = "X83";

    @OOXIXo
    public static final String o0IXI = "KODAK201-2";

    @OOXIXo
    public static final String o0IXO = "S55";

    /* renamed from: o0IXXIx */
    @OOXIXo
    public static final String f20526o0IXXIx = "Outdoor Watch";

    @OOXIXo
    public static final String o0Ixx = "JX621";

    @OOXIXo
    public static final String o0O0oo0 = "M3";

    @OOXIXo
    public static final String o0OI = "Lunar Space";

    /* renamed from: o0OO0 */
    @OOXIXo
    public static final String f20527o0OO0 = "TK78G";

    @OOXIXo
    public static final String o0OXIoI = "Watch Ultra";

    /* renamed from: o0Oo */
    @OOXIXo
    public static final String f20528o0Oo = "R2_LE";

    @OOXIXo
    public static final String o0OoX = "SW-21V PRO";

    @OOXIXo
    public static final String o0Oox0xox = "Abyx-Fit-8";

    @OOXIXo
    public static final String o0XO = "JX520C";

    @OOXIXo
    public static final String o0XOXI0x = "Geozon_new";

    /* renamed from: o0Xo */
    @OOXIXo
    public static final String f20529o0Xo = "MTS028_LE";

    @OOXIXo
    public static final String o0Xo0XII = "SBT-2";

    @OOXIXo
    public static final String o0Xo0XX = "B06";

    @OOXIXo
    public static final String o0XxxOIx = "ION";

    @OOXIXo
    public static final String o0o = "ERA CLASS";
    public static final int o0oI0 = 8;

    /* renamed from: o0oIxOo */
    @OOXIXo
    public static final String f20530o0oIxOo = "R15";

    /* renamed from: o0oIxXOx */
    @OOXIXo
    public static final String f20531o0oIxXOx = "Y1";

    @OOXIXo
    public static final String o0oo = "S5 PRO";

    @OOXIXo
    public static final String o0ooO = "MOJU M8";

    /* renamed from: o0oxo0oI */
    @OOXIXo
    public static final String f20532o0oxo0oI = "F3";

    @OOXIXo
    public static final String o0x0XOXx = "AWSF13B";

    /* renamed from: o0xIIX0 */
    @OOXIXo
    public static final String f20533o0xIIX0 = "HUFit4";

    @OOXIXo
    public static final String o0xIXX = "watch 10";

    /* renamed from: o0xIoII */
    @OOXIXo
    public static final String f20534o0xIoII = "Spark Watch V1";

    /* renamed from: o0xOIoxo */
    @OOXIXo
    public static final String f20535o0xOIoxo = "R9";

    /* renamed from: o0xxxXXxX */
    @OOXIXo
    public static final String f20536o0xxxXXxX = "IML";

    /* renamed from: oI */
    @OOXIXo
    public static final String f20537oI = "JR-";

    /* renamed from: oI0 */
    @OOXIXo
    public static final String f20538oI0 = "FitShot Zest";

    /* renamed from: oI00o */
    @OOXIXo
    public static final String f20539oI00o = "OLIKE OW-W2";

    /* renamed from: oI0IIXIo */
    @OOXIXo
    public static final String f20540oI0IIXIo = "OT-R4";

    /* renamed from: oI0X0 */
    @OOXIXo
    public static final String f20541oI0X0 = "FXS 2s";

    @OOXIXo
    public static final String oI0XIox = "S1968";

    @OOXIXo
    public static final String oI0XoXIXo = "FM SP ULTRA";

    @OOXIXo
    public static final String oI0xOX = "Motive 7C";

    @OOXIXo
    public static final String oI0xOoox = "T-ROUND2";

    @OOXIXo
    public static final String oI0xoXO = "JX624C";

    @OOXIXo
    public static final String oII = "KRONOS ULTIMATE";

    @OOXIXo
    public static final String oII00xox = "RIRO WATCH W1";

    @OOXIXo
    public static final String oIIOI = "AWSAM05";

    @OOXIXo
    public static final String oIIX = "hrv";

    @OOXIXo
    public static final String oIIXxXIox = "NWF18PRO";

    @OOXIXo
    public static final String oIIo0xX = "Apollo W1";

    /* renamed from: oIIxXoo */
    @OOXIXo
    public static final String f20542oIIxXoo = "SPORTY 1";

    @OOXIXo
    public static final String oIO = "Black Shark GS3";

    @OOXIXo
    public static final String oIO0X00 = "W113";

    @OOXIXo
    public static final String oIO0oIOO = "GT4 mini";

    @OOXIXo
    public static final String oIOIO = "G9 Signature";

    @OOXIXo
    public static final String oIOXxOI = "Boult Watch RI";

    @OOXIXo
    public static final String oIOoXooIO = "JX621D";

    @OOXIXo
    public static final String oIX = "Romance";

    /* renamed from: oIX0o */
    @OOXIXo
    public static final String f20543oIX0o = "ALTSWAT1BLK";

    @OOXIXo
    public static final String oIXIXIxx0 = "M8 Pro";

    @OOXIXo
    public static final String oIXXo = "Motive 6C Pro";

    /* renamed from: oIXoXx0 */
    @OOXIXo
    public static final String f20545oIXoXx0 = "FXS 2";

    @OOXIXo
    public static final String oIXx0o = "ERAFIT-BTC";

    @OOXIXo
    public static final String oIo = "GF03Pro";

    @OOXIXo
    public static final String oIo0 = "TINI 2";

    @OOXIXo
    public static final String oIo0OoXIo = "X7";

    @OOXIXo
    public static final String oIo0x = "AW51";

    @OOXIXo
    public static final String oIoIXxIO = "R11S";

    @OOXIXo
    public static final String oIoIxo = "ALTSWAT2BLK";

    @OOXIXo
    public static final String oIoXOooOO = "Noise Fit Defender";

    @OOXIXo
    public static final String oIoox0 = "JR-FT6";

    /* renamed from: oIoxI0xx */
    @OOXIXo
    public static final String f20546oIoxI0xx = "RIZTO R11";

    @OOXIXo
    public static final String oIx0 = "ANUDHA";

    @OOXIXo
    public static final String oIxIO = "HearFit REX";

    @OOXIXo
    public static final String oIxIOoOx = "YF120";

    /* renamed from: oIxOXo */
    @OOXIXo
    public static final String f20547oIxOXo = "ST R11";

    @OOXIXo
    public static final String oIxXOO = "Gizmore 953";

    @OOXIXo
    public static final String oIxXX0Xo = "JETE-AM1";

    @OOXIXo
    public static final String oIxXXOI = "beatXP Unbound Neo";

    /* renamed from: oIxxIo */
    @OOXIXo
    public static final String f20548oIxxIo = "HUFit6";

    /* renamed from: oO */
    @OOXIXo
    public static final String f20549oO = "UP! S. Slim";

    /* renamed from: oO0 */
    @OOXIXo
    public static final String f20550oO0 = "R12";

    @OOXIXo
    public static final String oO000oO = "SmartX Mini";
    public static final int oO0IOOOx = 51015;

    /* renamed from: oO0IXx */
    @OOXIXo
    public static final String f20551oO0IXx = "H56";

    /* renamed from: oO0OX0 */
    @OOXIXo
    public static final String f20552oO0OX0 = "eDiary Watch 1";

    @OOXIXo
    public static final String oO0XoIX = "RONIN WATCH R-012";

    @OOXIXo
    public static final String oO0XxoI = "Z02 Pro";

    @OOXIXo
    public static final String oO0o = "Motive 9 Pro";

    @OOXIXo
    public static final String oO0xxI = "BeatXP Flux";

    @OOXIXo
    public static final String oOI0IXOO = "iTOUCH Air 4";

    @OOXIXo
    public static final String oOI0ooOO = "S1912A";

    @OOXIXo
    public static final String oOII = "AW50";

    /* renamed from: oOIXoIXXI */
    @OOXIXo
    public static final String f20553oOIXoIXXI = "Kronos X1";

    @OOXIXo
    public static final String oOIoXOoI = "beatXP Raze";

    @OOXIXo
    public static final String oOIoXo = "X5L";

    /* renamed from: oOIx */
    @OOXIXo
    public static final String f20554oOIx = "GRC_WAY";

    @OOXIXo
    public static final String oOIxIIoI = "JOVIAL";

    @OOXIXo
    public static final String oOO = "RTER";

    @OOXIXo
    public static final String oOX = "R22";

    @OOXIXo
    public static final String oOXOxxoxO = "Kata AM10_Gold";

    /* renamed from: oOXoIIIo */
    @OOXIXo
    public static final String f20555oOXoIIIo = "SB-305";

    /* renamed from: oOo */
    @OOXIXo
    public static final String f20556oOo = "G26";

    @OOXIXo
    public static final String oOo0o = "DW01";

    /* renamed from: oOoIIO0 */
    @OOXIXo
    public static final String f20557oOoIIO0 = "F1R";
    public static int oOoIxI0x = 0;

    /* renamed from: oOoXoXO */
    @OOXIXo
    public static final String f20558oOoXoXO = "PT1";

    @OOXIXo
    public static final String oOx0IIo = "K10";

    @OOXIXo
    public static final String oOx0xoXI = "SEEKEN GRAVITY 2";

    @OOXIXo
    public static final String oOxoXxoX = "AM02J";

    /* renamed from: oOxxXI */
    @OOXIXo
    public static final String f20559oOxxXI = "W9";

    /* renamed from: oX */
    @OOXIXo
    public static final String f20560oX = "GT WATCH PLUS";

    /* renamed from: oX000x */
    @OOXIXo
    public static final String f20561oX000x = "M5S_LE";

    /* renamed from: oX0I0O */
    @OOXIXo
    public static final String f20562oX0I0O = "OT-R3";

    @OOXIXo
    public static final String oX0IoO = "KUMI KU7";

    /* renamed from: oX0O */
    @OOXIXo
    public static final String f20563oX0O = "LG19";

    @OOXIXo
    public static final String oX0OXOXOo = "HX05";

    @OOXIXo
    public static final String oX0Ox = "FWA24";

    @OOXIXo
    public static final String oX0XO = "Zeb-Winter";

    @OOXIXo
    public static final String oX0oO = "WATCH5 PRO";

    /* renamed from: oX0ooo0I0 */
    @OOXIXo
    public static final String f20564oX0ooo0I0 = "SW203";

    /* renamed from: oXIO0o0XI */
    @OOXIXo
    public static final String f20565oXIO0o0XI = "TIME";

    @OOXIXo
    public static final String oXIOOxX = "YH15";

    @OOXIXo
    public static final String oXIOxo = "RNCF11";

    @OOXIXo
    public static final String oXIX = "Tai8promax";

    @OOXIXo
    public static final String oXIo0X0x = "Boult Watch SD";

    /* renamed from: oXIoIo */
    @OOXIXo
    public static final String f20566oXIoIo = "KUBE Pro";

    /* renamed from: oXIoO */
    @OOXIXo
    public static final String f20567oXIoO = "The Outdoor Watch";

    @OOXIXo
    public static final String oXIxoOo = "FireBoltt 210";

    @OOXIXo
    public static final String oXIxxoI0x = "W-Round";

    /* renamed from: oXO0oOx0 */
    @OOXIXo
    public static final String f20568oXO0oOx0 = "M3";

    @OOXIXo
    public static final String oXO0x = "S1916";

    @OOXIXo
    public static final String oXOIxX = "GF08";

    @OOXIXo
    public static final String oXOXo = "Curv";

    @OOXIXo
    public static final String oXOxO0XXo = "DANX-DR20";

    @OOXIXo
    public static final String oXOxox = "IMS-755";

    @OOXIXo
    public static final String oXX0 = "S1833";

    /* renamed from: oXX0IoI */
    @OOXIXo
    public static final String f20569oXX0IoI = "NoiseFit Buzz";

    @OOXIXo
    public static final String oXXI0 = "GRC_STYLE";

    @OOXIXo
    public static final String oXXX = "iTOUCH Sport 4 SE";
    public static int oXXxI = 0;

    @OOXIXo
    public static final String oXo = "Motive 9";

    /* renamed from: oXoXxOo */
    @OOXIXo
    public static final String f20570oXoXxOo = "ECK0-TECH";

    @OOXIXo
    public static final String oXoxo0x = "pressure";

    @OOXIXo
    public static final String oXx = "R4";

    @OOXIXo
    public static final String oXx00I = "G30";

    @OOXIXo
    public static final String oXx0XO = "IS07";

    @OOXIXo
    public static final String oXx0XOX0 = "ROCK 31";

    @OOXIXo
    public static final String oXx0oXXo = "CA07";

    @OOXIXo
    public static final String oXx0xxxX = "AWSFR19";

    /* renamed from: oXxOI0oIx */
    @OOXIXo
    public static final String f20571oXxOI0oIx = "Urban 2X";

    /* renamed from: oXxOXOX */
    @OOXIXo
    public static final String f20572oXxOXOX = "TICK-R1A";

    @OOXIXo
    public static final String oXxOXxo0O = "TM09";

    @OOXIXo
    public static final String oXxXoox0 = "ALPS 3";

    @OOXIXo
    public static final String oXxo = "Air8";

    /* renamed from: oXxx000 */
    @OOXIXo
    public static final String f20573oXxx000 = "S2_LE";

    /* renamed from: oo */
    @OOXIXo
    public static final String f20574oo = "OT-RL";

    @OOXIXo
    public static final String oo0 = "HY-J05";

    /* renamed from: oo00 */
    @OOXIXo
    public static final String f20575oo00 = "AMPM-218";

    @OOXIXo
    public static final String oo00Io = "HK26";

    @OOXIXo
    public static final String oo0I0oI = "Fit-S";

    @OOXIXo
    public static final String oo0IoIIOo = "KUMI_NewHRIC";

    @OOXIXo
    public static final String oo0o = "GEN 9SE";

    /* renamed from: oo0oIXo */
    @OOXIXo
    public static final String f20576oo0oIXo = "Urban3 pro";

    @OOXIXo
    public static final String oo0oIoOIO = "D4PRO AMOLED";

    /* renamed from: oo0xXOI0I */
    @OOXIXo
    public static final String f20577oo0xXOI0I = "HX-H08";

    @OOXIXo
    public static final String ooIIx = "blood_glucose";

    @OOXIXo
    public static final String ooIoIX = "AW-S006";

    @OOXIXo
    public static final String ooIoIx0 = "LUNARVISTA";

    @OOXIXo
    public static final String ooIx = "HK95";

    @OOXIXo
    public static final String ooIxOOoOo = "ULTRA MAX";

    @OOXIXo
    public static final String ooO0 = "GEKO WATCH S";

    @OOXIXo
    public static final String ooO00o = "buzz Watch PRO";

    /* renamed from: ooO0oXxI */
    @OOXIXo
    public static final String f20578ooO0oXxI = "HW33";

    @OOXIXo
    public static final String ooO0xXX = "AW28";

    @OOXIXo
    public static final String ooOIo = "IMS-757";

    @OOXIXo
    public static final String ooOO0I0 = "Lema";

    /* renamed from: ooOOo0oXI */
    @OOXIXo
    public static final String f20579ooOOo0oXI = "TCRD_TBW1";

    @OOXIXo
    public static final String ooOX = "sleep";

    /* renamed from: ooOx */
    @OOXIXo
    public static final String f20580ooOx = "F3R";

    @OOXIXo
    public static final String ooOxox = "T18_K";

    @OOXIXo
    public static final String ooOxox0O0 = "PRIMIACELESTIAL";

    @OOXIXo
    public static final String ooX = "S59MAX Watch";

    @OOXIXo
    public static final String ooX0XXOI = "F25";

    @OOXIXo
    public static final String ooX0xXIoI = "F12Pro";

    /* renamed from: ooXIXxIX */
    @OOXIXo
    public static final String f20581ooXIXxIX = "LONDRA";

    @OOXIXo
    public static final String ooXOOxo = "FireBoltt 187";

    @OOXIXo
    public static final String ooXXoOx = "JX696";
    public static final int ooXoIoI = 5;

    @OOXIXo
    public static final String ooo = "R3";

    @OOXIXo
    public static final String oooIXI0o = "SSW001";

    @OOXIXo
    public static final String oooO0oo = "Zeb-Mamba";

    @OOXIXo
    public static final String oooO0ox = "X700";

    @OOXIXo
    public static final String oooOOIXX = "YS05PRO";

    @OOXIXo
    public static final String oooOX = "FireBoltt FBL08";

    @OOXIXo
    public static final String oox = "ultra k8";

    /* renamed from: oox000IX */
    @OOXIXo
    public static final String f20582oox000IX = "NEW YORK";

    @OOXIXo
    public static final String ooxI0 = "Motive 7";

    @OOXIXo
    public static final String ooxII = "KW16";
    public static final int ooxo0 = 510152030;

    @OOXIXo
    public static final String ooxooo = "R1 pro";

    /* renamed from: ox */
    @OOXIXo
    public static final String f20583ox = "Kessaris";

    /* renamed from: ox0 */
    @OOXIXo
    public static final String f20584ox0 = "Y3";

    /* renamed from: ox0I */
    @OOXIXo
    public static final String f20585ox0I = "Ignite S3";

    @OOXIXo
    public static final String ox0OO0x = "S2";

    @OOXIXo
    public static final String ox0xI00IX = "FM PRO X";

    @OOXIXo
    public static final String oxI0 = "SPETRA Arc";

    @OOXIXo
    public static final String oxI0IX = "Lunar Link";
    public static final int oxI0OXX = 0;

    @OOXIXo
    public static final String oxI0OxXoO = "S2016";

    @OOXIXo
    public static final String oxIIOOX = "POWER";

    /* renamed from: oxIIX0o */
    @OOXIXo
    public static final String f20586oxIIX0o = "R7J";

    /* renamed from: oxIO0IIo */
    @OOXIXo
    public static final String f20587oxIO0IIo = "infinity";

    @OOXIXo
    public static final String oxIXXxXx0 = "GEKO WATCH R";

    /* renamed from: oxO */
    @OOXIXo
    public static final String f20588oxO = "AT806";

    @OOXIXo
    public static final String oxOII = "Faster NERV Pro";

    /* renamed from: oxOIoIx */
    @OOXIXo
    public static final String f20589oxOIoIx = "OLIKE OW-W4";

    @OOXIXo
    public static final String oxOX0OXx = "FM ONE MAX";

    /* renamed from: oxOXxoXII */
    @OOXIXo
    public static final String f20590oxOXxoXII = "R3";

    @OOXIXo
    public static final String oxOoIOX = "RIRO WATCH W5";

    @OOXIXo
    public static final String oxOoo = "BC-1";

    @OOXIXo
    public static final String oxX = "Black Shark GSX";

    @OOXIXo
    public static final String oxX0o = "SPUNK PRO";

    @OOXIXo
    public static final String oxXIOXO = "ProWatch-M18";

    /* renamed from: oxXx0IX */
    @OOXIXo
    public static final String f20591oxXx0IX = "G-Stayer";

    @OOXIXo
    public static final String oxo0x0 = "DW05";

    @OOXIXo
    public static final String oxoIOxO = "HS2001";

    /* renamed from: oxoX */
    @OOXIXo
    public static final String f20592oxoX = "AFWG0720";

    @OOXIXo
    public static final String oxoo = "SW-2P";

    @OOXIXo
    public static final String oxoxO = "Hammer Luxor";

    @OOXIXo
    public static final String oxoxX0Oxo = "G5 MAX";

    @OOXIXo
    public static final String oxoxxo = "KW18";

    @OOXIXo
    public static final String oxxX = "Shaaimu Evolve";

    /* renamed from: oxxXoxO */
    @OOXIXo
    public static final String f20593oxxXoxO = "F2";

    /* renamed from: x0 */
    @OOXIXo
    public static final String f20594x0 = "V1";

    @OOXIXo
    public static final String x00 = "K9";

    @OOXIXo
    public static final String x000OxX = "SSW002";

    /* renamed from: x00IOx */
    @OOXIXo
    public static final String f20595x00IOx = "Amazon";

    @OOXIXo
    public static final String x00X = "AWEI H27";

    /* renamed from: x00X0xoXO */
    @OOXIXo
    public static final String f20596x00X0xoXO = "BSW015";

    @OOXIXo
    public static final String x00o = "Black Shark S1";

    @OOXIXo
    public static final String x0I = "GARETT_V12";

    @OOXIXo
    public static final String x0IOX0o = "Active 3 Pro";

    @OOXIXo
    public static final String x0IX = "POLO YS10";

    @OOXIXo
    public static final String x0Io0 = "P280";

    @OOXIXo
    public static final String x0Ix0O = "F13B";

    @OOXIXo
    public static final String x0O0O = "Watch4pro";

    @OOXIXo
    public static final String x0O0xO = "Motive 6 GT";

    @OOXIXo
    public static final String x0OI = "HK27";

    @OOXIXo
    public static final String x0OIOXo0 = "JX623";

    /* renamed from: x0OIX00oO */
    @OOXIXo
    public static final String f20597x0OIX00oO = "SMA-F1RT";

    /* renamed from: x0OOI */
    @OOXIXo
    public static final String f20598x0OOI = "UP! Smart Connect_LE";

    @OOXIXo
    public static final String x0OX = "aigo v8";

    @OOXIXo
    public static final String x0Oo0X = "HK48";

    @OOXIXo
    public static final String x0Ox = "aigo GTV2";

    /* renamed from: x0OxxIOxX */
    @OOXIXo
    public static final String f20599x0OxxIOxX = "GT02";

    @OOXIXo
    public static final String x0X = "YH11";

    @OOXIXo
    public static final String x0X0OIOx = "XO-J6";

    @OOXIXo
    public static final String x0XIoX00 = "Y96";

    /* renamed from: x0XOIxOo */
    @OOXIXo
    public static final String f20600x0XOIxOo = "UP! S.Slim";

    @OOXIXo
    public static final String x0XOOIXXO = "Rizto R10";

    @OOXIXo
    public static final String x0XOxo = "V63";

    @OOXIXo
    public static final String x0Xox = "FLASHGEN2BT";

    /* renamed from: x0o */
    @OOXIXo
    public static final String f20601x0o = "B8";

    @OOXIXo
    public static final String x0o0O0Oo = "AM19";

    @OOXIXo
    public static final String x0o0o0OX = "X6";

    @OOXIXo
    public static final String x0oXIXI = "V8";

    @OOXIXo
    public static final String x0oo = "AW47";

    @OOXIXo
    public static final String x0ooOIxO = "AUKEY LS02 PRO";

    /* renamed from: x0oox0 */
    @OOXIXo
    public static final String f20602x0oox0 = "FW37";

    /* renamed from: x0oxIIIX */
    @OOXIXo
    public static final String f20603x0oxIIIX = "GT04_LE";

    @OOXIXo
    public static final String x0x = "Core Ultra";

    @OOXIXo
    public static final String x0x000 = "W111";

    /* renamed from: x0xO */
    @OOXIXo
    public static final String f20604x0xO = "GT WATCH PLUS";

    /* renamed from: x0xO0oo */
    @OOXIXo
    public static final String f20605x0xO0oo = "Zboank-R4";

    /* renamed from: x0xOIoO */
    @OOXIXo
    public static final String f20606x0xOIoO = "PW12";

    @OOXIXo
    public static final String x0xoIx0 = "PBL Luxe 3";

    /* renamed from: xI */
    @OOXIXo
    public static final String f20607xI = "FT1-1";

    @OOXIXo
    public static final String xI00o = "ZEUS 2 PRO";

    /* renamed from: xI0OXooO */
    @OOXIXo
    public static final String f20608xI0OXooO = "V2";

    @OOXIXo
    public static final String xI0Ooxx0x = "F12";

    /* renamed from: xI0oxI00 */
    @OOXIXo
    public static final String f20609xI0oxI00 = "HUFit2";

    /* renamed from: xII */
    @OOXIXo
    public static final String f20610xII = "Synjones";

    @OOXIXo
    public static final String xIIO = "Action Plus GPS";

    @OOXIXo
    public static final String xIIOoXo = "MOJU J12";

    @OOXIXo
    public static final String xIIoO = "AM01S";

    @OOXIXo
    public static final String xIO = "YH08";

    @OOXIXo
    public static final String xIOI0xO = "ProWatch-B18";

    @OOXIXo
    public static final String xIOOIO = "IS10";

    @OOXIXo
    public static final String xIOOoxxxO = "SY04";

    @OOXIXo
    public static final String xIOXI = "CLASSIC 6";

    /* renamed from: xIOXX */
    @OOXIXo
    public static final String f20611xIOXX = "Active_LE";

    @OOXIXo
    public static final String xIOXox = "R16";

    @OOXIXo
    public static final String xIX0XOOX = "Pro";

    /* renamed from: xIXIOX */
    @OOXIXo
    public static final String f20612xIXIOX = "SW37_LE";

    /* renamed from: xIXOoI */
    @OOXIXo
    public static final String f20613xIXOoI = "SD-2";

    /* renamed from: xIXX */
    @OOXIXo
    public static final String f20614xIXX = "S1 Pro";

    @OOXIXo
    public static final String xIXXIo = "A8 Ultra";

    /* renamed from: xIXoO0Xx */
    @OOXIXo
    public static final String f20615xIXoO0Xx = "F7";

    @OOXIXo
    public static final String xIo0xoOOx = "ADYFHK IS8 ultra";

    @OOXIXo
    public static final String xIoIxoO = "BeatXP Marv Ultra";

    /* renamed from: xIoXXXIXo */
    @OOXIXo
    public static final String f20616xIoXXXIXo = "FitShot Ease";

    /* renamed from: xIx */
    @OOXIXo
    public static final String f20617xIx = "SX24 Pro_LE";

    /* renamed from: xIx0XO */
    @OOXIXo
    public static final String f20618xIx0XO = "HS4_LE";

    @OOXIXo
    public static final String xIxO0X0I = "ZERO PRO";

    @OOXIXo
    public static final String xIxXx0oI0 = "HK39";

    /* renamed from: xIxooxXX */
    @OOXIXo
    public static final String f20619xIxooxXX = "Urban 3 pro";

    @OOXIXo
    public static final String xIxxXXxx = "DSMART F3P";

    @OOXIXo
    public static final String xIxxxX0O = "HAYLOU  Watch R8";

    @OOXIXo
    public static final String xO = "DIZO Watch R2";

    @OOXIXo
    public static final String xO0x = "beatXP Sigma";

    @OOXIXo
    public static final String xO0x00ox = "Zeb-Force";

    @OOXIXo
    public static final String xO0xx0xxx = "alt Woke";

    @OOXIXo
    public static final String xO0xxOX = "YS09PRO";

    /* renamed from: xOI0 */
    @OOXIXo
    public static final String f20620xOI0 = "KESSARIS";

    @OOXIXo
    public static final String xOII = "KRONOS ELITE";

    @OOXIXo
    public static final String xOII0IIX = "DW07";

    @OOXIXo
    public static final String xOIIO0x = "DSMART A8U";

    @OOXIXo
    public static final String xOIIOoO = "GW6";

    /* renamed from: xOIO */
    @OOXIXo
    public static final String f20621xOIO = "PB Z5";

    @OOXIXo
    public static final String xOIXO = "YS04PRO";

    @OOXIXo
    public static final String xOIXxOo = "GEN 9X";

    @OOXIXo
    public static final String xOIx00 = "KRONOS SPORT";

    @OOXIXo
    public static final String xOIxOOI = "PARIGI";

    @OOXIXo
    public static final String xOO0X = "JETE-FR22";

    /* renamed from: xOOOX */
    @OOXIXo
    public static final String f20622xOOOX = "MK09";

    /* renamed from: xOOxI */
    @OOXIXo
    public static final String f20623xOOxI = "M9016_LE";

    /* renamed from: xOOxIO */
    @OOXIXo
    public static final String f20624xOOxIO = "Urban 8X";

    @OOXIXo
    public static final String xOOxIoOoO = "AM12";

    @OOXIXo
    public static final String xOOxX = "Edyson 3";

    @OOXIXo
    public static final String xOXI = "R10J";

    @OOXIXo
    public static final String xOXoooo = "Y809PRO";

    @OOXIXo
    public static final String xOXoxI = "FXS 3s";

    @OOXIXo
    public static final String xOo = "mibro ultra 8";

    /* renamed from: xOoIIIoXI */
    @OOXIXo
    public static final String f20625xOoIIIoXI = "MAREA 31";

    @OOXIXo
    public static final String xOoO0O0O = "SK30";

    /* renamed from: xOoOIoI */
    @OOXIXo
    public static final String f20626xOoOIoI = "SECTOR S-01";

    /* renamed from: xOx */
    @OOXIXo
    public static final String f20627xOx = "Exk Vip";

    @OOXIXo
    public static final String xOx0oO = "S12 Ultra MAX";

    @OOXIXo
    public static final String xOxIxO = "S35P";

    /* renamed from: xOxOoo */
    @OOXIXo
    public static final String f20628xOxOoo = "HS2000";

    @OOXIXo
    public static final String xOxXOOIx = "JX639C";

    @OOXIXo
    public static final String xOxxIxxI0 = "Motive 5 Pro";

    /* renamed from: xOxxXO */
    @OOXIXo
    public static final String f20629xOxxXO = "BSW013";

    /* renamed from: xX */
    @OOXIXo
    public static final String f20630xX = "PARIGI";

    @OOXIXo
    public static final String xX0 = "XO-J5";

    /* renamed from: xX0IIXIx0 */
    @OOXIXo
    public static final String f20631xX0IIXIx0 = "R7";

    @OOXIXo
    public static final String xX0O = "POLO YS04PRO";

    @OOXIXo
    public static final String xX0Oo = "W112";

    @OOXIXo
    public static final String xX0Ox = "F26";

    @OOXIXo
    public static final String xX0ooIII = "ORCHID";

    /* renamed from: xX0ox */
    @OOXIXo
    public static final String f20632xX0ox = "VIDIVE-SW1603";

    @OOXIXo
    public static final String xX0xI = "LUNARSPACEBT";

    @OOXIXo
    public static final String xX0xXooOO = "R1523";

    @OOXIXo
    public static final String xXIO = "A6";

    /* renamed from: xXIX0Xo */
    @OOXIXo
    public static final String f20633xXIX0Xo = "R3 Pro";

    @OOXIXo
    public static final String xXIxxo0x = "24-7 EVO";

    @OOXIXo
    public static final String xXO = "HS2002";

    @OOXIXo
    public static final String xXO0oXX = "AM11";

    @OOXIXo
    public static final String xXOO = "CGWatch Sport";

    @OOXIXo
    public static final String xXOOx = "QCY Watch GT2";

    @OOXIXo
    public static final String xXOXOOx = "HK9PRO";

    @OOXIXo
    public static final String xXOoI = "HX04";

    /* renamed from: xXOx */
    @OOXIXo
    public static final String f20634xXOx = "W-01";

    @OOXIXo
    public static final String xXOxII0xx = "LUNARMIRAGE";

    @OOXIXo
    public static final String xXXI0IX00 = "CH08";

    @OOXIXo
    public static final String xXXXox = "Motive 5T";

    @OOXIXo
    public static final String xXXXxOOI0 = "DANX-DR30";

    @OOXIXo
    public static final String xXXo = "R4_DAEWOO";

    /* renamed from: xXXxoI */
    @OOXIXo
    public static final String f20635xXXxoI = "SW-700";

    /* renamed from: xXo */
    @OOXIXo
    public static final String f20636xXo = "G16";

    @OOXIXo
    public static final String xXoIx00 = "HX02 mini";

    /* renamed from: xXoOI00O */
    @OOXIXo
    public static final String f20637xXoOI00O = "MILANO";

    @OOXIXo
    public static final String xXoOoxXIX = "BeFit Watch Ultra 1";

    @OOXIXo
    public static final String xXooxOx0O = "Motive 7S";

    @OOXIXo
    public static final String xXx0x0 = "Edyson";

    @OOXIXo
    public static final String xXxIoIXX0 = "F27";

    @OOXIXo
    public static final String xXxIxo = "GW60";

    @OOXIXo
    public static final String xXxox = "STORM U";

    @OOXIXo
    public static final String xXxx = "R17";

    /* renamed from: xXxxox0I */
    @OOXIXo
    public static final String f20638xXxxox0I = "M9015";

    /* renamed from: xo */
    @OOXIXo
    public static final String f20639xo = "T78";

    @OOXIXo
    public static final String xo000 = "BeatXP Flare";

    @OOXIXo
    public static final String xo0Io0Ooo = "AirX";

    @OOXIXo
    public static final String xo0OI = "W37 Pro MAX";

    @OOXIXo
    public static final String xo0XO = "AWSR13";

    @OOXIXo
    public static final String xo0Xo0xo = "X-AGE ARC";

    @OOXIXo
    public static final String xo0oXIOO = "AM05L";

    /* renamed from: xo0x */
    @OOXIXo
    public static final String f20640xo0x = "B2";

    @OOXIXo
    public static final String xo0xII0II = "W35 Pro MAX";

    @OOXIXo
    public static final String xoI = "PFB Dare";

    @OOXIXo
    public static final String xoIIIOI = "F13A";

    /* renamed from: xoIXOxX */
    @OOXIXo
    public static final String f20641xoIXOxX = "GIZFT 910 PRO";

    @OOXIXo
    public static final String xoIooI0 = "OA300";

    /* renamed from: xoIox */
    @OOXIXo
    public static final String f20642xoIox = "GT03";

    @OOXIXo
    public static final String xoO0 = "Thull TW2";

    @OOXIXo
    public static final String xoO0X = "AM05LE";

    /* renamed from: xoO0xx0 */
    @OOXIXo
    public static final String f20644xoO0xx0 = "KUMI KU1PRO";

    @OOXIXo
    public static final String xoOI00O0X = "SOUYIE L1";
    public static int xoOOIooI = 0;

    @OOXIXo
    public static final String xoOX00 = "Motive 5pro";

    @OOXIXo
    public static final String xoOXXoO0X = "F30";

    @OOXIXo
    public static final String xoOx = "T95 Pro";

    @OOXIXo
    public static final String xoOxO0 = "JX624F";

    /* renamed from: xoX */
    @OOXIXo
    public static final String f20645xoX = "MC-GPSWATCH_LE";

    @OOXIXo
    public static final String xoXI00O = "aigo v6";

    @OOXIXo
    public static final String xoXXXIX = "SW-WIA102 PRO";

    /* renamed from: xoXoI */
    @OOXIXo
    public static final String f20646xoXoI = "Reloj M9014";

    @OOXIXo
    public static final String xooXo = "IS08";

    @OOXIXo
    public static final String xoooOIO = "R9 MAX";

    /* renamed from: xooxxX */
    @OOXIXo
    public static final String f20647xooxxX = "VIDVIE-SW1603";

    @OOXIXo
    public static final String xooxxo = "JR-FC1";

    /* renamed from: xox */
    @OOXIXo
    public static final String f20648xox = "AceFit";

    @OOXIXo
    public static final String xoxOOxI = "POLO YS01PRO";

    @OOXIXo
    public static final String xoxX = "KUMI GW6";

    @OOXIXo
    public static final String xoxX0I = "AM07";

    /* renamed from: xoxXI */
    @OOXIXo
    public static final String f20649xoxXI = "F2R";

    @OOXIXo
    public static final String xoxXoXO = "F34";

    /* renamed from: xoxo */
    @OOXIXo
    public static final String f20650xoxo = "SW250";

    @OOXIXo
    public static final String xoxoXoxIo = "ERA DAY LINE";

    /* renamed from: xx */
    @OOXIXo
    public static final String f20651xx = "M-Watch C";

    /* renamed from: xx0 */
    @OOXIXo
    public static final String f20652xx0 = "V8_LE";

    @OOXIXo
    public static final String xx00 = "H03";

    @OOXIXo
    public static final String xx00OX = "C30";

    /* renamed from: xx00oOoI */
    @OOXIXo
    public static final String f20653xx00oOoI = "SPECTRE AMO";

    @OOXIXo
    public static final String xx0IXxxx0 = "BeatXP Terra";

    /* renamed from: xx0O */
    @OOXIXo
    public static final String f20654xx0O = "TICK-WSWD";

    /* renamed from: xx0X0 */
    @OOXIXo
    public static final String f20655xx0X0 = "ACTIVE 1";

    @OOXIXo
    public static final String xx0XoXxI = "SBT-X";

    /* renamed from: xx0o0O */
    @OOXIXo
    public static final String f20656xx0o0O = "AMPM-217";

    @OOXIXo
    public static final String xx0oII = "SmartR_Phy";

    @OOXIXo
    public static final String xxI0XIO = "blood_pressure";

    @OOXIXo
    public static final String xxI0x = "HK40";

    @OOXIXo
    public static final String xxIOx = "HX8 Ultra";

    @OOXIXo
    public static final String xxIOxXI = "BeatExtrem";

    /* renamed from: xxIXOIIO */
    @OOXIXo
    public static final String f20658xxIXOIIO = "GT-03";

    @OOXIXo
    public static final String xxIXxx0o = "VIDVIE-1620";

    @OOXIXo
    public static final String xxOOXo = "itel ISW-O43";

    /* renamed from: xxOXOOoIX */
    @OOXIXo
    public static final String f20659xxOXOOoIX = "B1";

    @OOXIXo
    public static final String xxOoXO = "NY58";

    /* renamed from: xxX */
    @OOXIXo
    public static final String f20660xxX = "R6 Pro";

    @OOXIXo
    public static final String xxX0X = "A8 Plus";

    @OOXIXo
    public static final String xxX0oIX0I = "SPUNK";

    @OOXIXo
    public static final String xxXI = "JX951C";

    @OOXIXo
    public static final String xxXIIXIxx = "FXS 3";

    @OOXIXo
    public static final String xxXX0 = "DOM 3";

    /* renamed from: xxXXXxIxo */
    @OOXIXo
    public static final String f20661xxXXXxIxo = "P270";

    @OOXIXo
    public static final String xxXooOI = "W112 Plus";

    @OOXIXo
    public static final String xxXxI = "JETE-FR21";

    @OOXIXo
    public static final String xxo00 = "JX683";

    @OOXIXo
    public static final String xxo0o = "RNCF10";

    /* renamed from: xxoXO */
    @OOXIXo
    public static final String f20662xxoXO = "S1";

    @OOXIXo
    public static final String xxooOxoO = "OA89";

    @OOXIXo
    public static final String xxooXo = "R9_FLS_HR";

    @OOXIXo
    public static final String xxox = "Thull TW3";

    @OOXIXo
    public static final String xxoxO0O = "DV07";
    public static final int xxoxx0 = 0;

    /* renamed from: xxx */
    @OOXIXo
    public static final String f20663xxx = "LINSAY EX-11L";

    /* renamed from: xxx00 */
    @OOXIXo
    public static final String f20664xxx00 = "S82_LE";

    /* renamed from: xxxI */
    @OOXIXo
    public static final String f20665xxxI = "GT-M5";

    @OOXIXo
    public static final String xxxIO = "G10 Professional";

    @OOXIXo
    public static final String xxxO = "GT4MAXpro";

    @OOXIXo
    public static final String xxxoXXo0X = "T97";

    /* renamed from: xxxoo0XI */
    @OOXIXo
    public static final String f20666xxxoo0XI = "ENFIT PRO";

    @OOXIXo
    public static final String xxxxxo = "M-Watch S";

    /* renamed from: oIX0oI */
    @OOXIXo
    public static final ProductManager f20544oIX0oI = new ProductManager();

    @OOXIXo
    public static final X0IIOO XIIxIxOOo = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ArrayList<String>>() { // from class: com.sma.smartv3.ble.ProductManager$noShowLanguageSelectPopFirmwareFlag$2
        @Override // Oox.oIX0oI
        @OOXIXo
        public final ArrayList<String> invoke() {
            return CollectionsKt__CollectionsKt.Oxx0xo("SmartWatch101", ProductManager.XOOXI0, "SmartWatch_8007", "SmartWatch_New", "SmartWatch_pah8007", ProductManager.f20595x00IOx, "SmartCare", "Amazon_A", "SmartWatch_A", "SMA_Amazon_SCRN", "SMA-Amazon", "F2Pro_DK_AT803T", "SmartWatch_JD9851", "R11_Sergio", "R11_Sergio_ST");
        }
    });

    @OOXIXo
    public static final X0IIOO III0I = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ArrayList<String>>() { // from class: com.sma.smartv3.ble.ProductManager$noShowLanguageSelectFirmwareFlag$2
        @Override // Oox.oIX0oI
        @OOXIXo
        public final ArrayList<String> invoke() {
            return CollectionsKt__CollectionsKt.Oxx0xo("ZX1662_EU");
        }
    });

    /* renamed from: I0oOIX */
    @OOXIXo
    public static final String f20335I0oOIX = "TX_WA3V1_";

    /* renamed from: xoIxX */
    @OOXIXo
    public static final String f20643xoIxX = "MERCURY_";

    /* renamed from: X0xII0I */
    @OOXIXo
    public static final String f20472X0xII0I = "TX_WA9V1_";

    /* renamed from: X0 */
    @OOXIXo
    public static final String f20461X0 = "PRIMIA_";

    /* renamed from: IOooo0o */
    @OOXIXo
    public static final String f20358IOooo0o = "TX_WA10V1_";

    /* renamed from: xxIO */
    @OOXIXo
    public static final String f20657xxIO = "SPACEFIT_";

    @OOXIXo
    public static final String x0I0 = "WGENESISBT";

    @OOXIXo
    public static final String XoOOxOo0o = "WGLORYBT";

    @OOXIXo
    public static final String oxox0OIx = "ELEVATEPRO_";

    @OOXIXo
    public static final String ox0OIxO = "GENESISPRO_";

    @OOXIXo
    public static final String Oxx0 = "GLORYPRO_";

    @OOXIXo
    public static final String Xo0oxx = "ULTIMAVOGUE_";

    @OOXIXo
    public static final String x0OOxoo = "LUNARCOMET_";

    @OOXIXo
    public static final String Ioo0Ooox = "LUNARSEEK_";

    @OOXIXo
    public static final String oxIO = "LUNARVELOCITY_";

    @OOXIXo
    public static final String OOxIO = "HORIZON";

    @OOXIXo
    public static final String xOxxO = "Radiant_";

    @OOXIXo
    public static final String XIXI = "RADIANT_";

    @OOXIXo
    public static final String OOIXoIX = "ENIGMAORION_";

    @OOXIXo
    public static final String Xxo0x = "ASCEND_";

    @OOXIXo
    public static final Set<String> oOII0 = Xo0.OxxIIOOXO(f20335I0oOIX, f20643xoIxX, f20472X0xII0I, f20461X0, f20358IOooo0o, f20657xxIO, x0I0, XoOOxOo0o, oxox0OIx, ox0OIxO, Oxx0, Xo0oxx, x0OOxoo, Ioo0Ooox, oxIO, OOxIO, xOxxO, XIXI, OOIXoIX, Xxo0x);

    @OOXIXo
    public static final X0IIOO xXo0X0 = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<Collection<? extends String>>() { // from class: com.sma.smartv3.ble.ProductManager$SUPPORT_DEVICES$2
        @Override // Oox.oIX0oI
        @OOXIXo
        public final Collection<? extends String> invoke() {
            return CollectionsKt___CollectionsKt.oIxOXo(Xo0.OxxIIOOXO(ProductManager.f20340II0xO0, ProductManager.f20331I0Io, "SMA-R4", ProductManager.f20422OOXIXo, ProductManager.f20558oOoXoXO, ProductManager.f20579ooOOo0oXI, ProductManager.f20600x0XOIxOo, ProductManager.f20549oO, ProductManager.f20605x0xO0oo, ProductManager.f20435Oo, ProductManager.f20368IXxxXO, ProductManager.f20458Oxx0xo, ProductManager.f20540oI0IIXIo, "R4", ProductManager.f20459OxxIIOOXO, ProductManager.f20345IIXOooo, ProductManager.f20646xoXoI, "SMA-R5", ProductManager.f20476XI0IXoo, "R5", ProductManager.f20462X00IoxXI, ProductManager.f20349IO, ProductManager.f20610xII, ProductManager.f20601x0o, ProductManager.f20492XOxIOxOx, ProductManager.f20402O0xOxO, ProductManager.f20465X0IIOO, ProductManager.f20483XIxXXX0x0, ProductManager.f20660xxX, ProductManager.f20515Xx000oIo, ProductManager.f20520XxX0x0xxx, ProductManager.f20638xXxxox0I, ProductManager.f20344IIX0o, ProductManager.f20581ooXIXxIX, ProductManager.f20607xI, ProductManager.f20577oo0xXOI0I, ProductManager.f20574oo, ProductManager.f20371IoOoX, ProductManager.f20555oOXoIIIo, "SMA-F2", ProductManager.f20640xo0x, ProductManager.f20418OO0x0xX, ProductManager.f20481XIo0oOXIx, ProductManager.f20378Ioxxx, ProductManager.f20634xXOx, ProductManager.f20496XX0, ProductManager.f20591oxXx0IX, "GT WATCH PLUS", ProductManager.f20506Xo0, ProductManager.f20507XoI0Ixx0, ProductManager.f20398O0Xx, ProductManager.f20335I0oOIX, "F2R", ProductManager.f20416OO, ProductManager.f20643xoIxX, ProductManager.f20657xxIO, ProductManager.f20372IoOoo, "GT WATCH PLUS", ProductManager.f20593oxxXoxO, ProductManager.f20334I0X0x0oIo, ProductManager.f20511XoX, "R10", ProductManager.f20475XI, ProductManager.f20357IOoo, ProductManager.f20542oIIxXoo, ProductManager.f20569oXX0IoI, ProductManager.f20500XXXI, ProductManager.f20337I0xX0, ProductManager.f20456Oxx, ProductManager.f20427OX, ProductManager.f20567oXIoO, ProductManager.f20526o0IXXIx, ProductManager.f20417OO0, ProductManager.f20508XoIxOXIXo, ProductManager.f20442OooI, ProductManager.f20410OIx00oxx, ProductManager.f20477XI0oooXX, ProductManager.f20423OOXIxO0, ProductManager.f20348IIxOXoOo0, ProductManager.f20329I0, ProductManager.f20580ooOx, ProductManager.f20644xoO0xx0, ProductManager.f20428OX00O0xII, "R7", ProductManager.f20622xOOOX, "TIME", ProductManager.f20479XIXIX, ProductManager.f20556oOo, ProductManager.f20397O0X, ProductManager.f20626xOoOIoI, "L1", "R11", ProductManager.f20389O0, ProductManager.f20446OoxxX, ProductManager.f20563oX0O, ProductManager.f20655xx0X0, ProductManager.f20609xI0oxI00, ProductManager.f20370IoIOOxIIo, ProductManager.f20586oxIIX0o, ProductManager.f20592oxoX, ProductManager.f20484XO, ProductManager.f20469X0o0xo, ProductManager.f20614xIXX, ProductManager.f20665xxxI, ProductManager.f20390O00, ProductManager.f20624xOOxIO, "R3H", ProductManager.f20562oX0I0O, ProductManager.f20595x00IOx, "PARIGI", ProductManager.f20564oX0ooo0I0, ProductManager.f20575oo00, ProductManager.f20388IxX00, ProductManager.f20488XO0o, "R3", "SMA-F1RT", ProductManager.f20380Ix00oIoI, ProductManager.f20393O0IxXx, "F1", ProductManager.f20362IXO, ProductManager.f20537oI, ProductManager.f20557oOoIIO0, ProductManager.f20502XXoOx0, ProductManager.f20659xxOXOOoIX, ProductManager.f20637xXoOI00O, ProductManager.f20599x0OxxIOxX, ProductManager.f20594x0, ProductManager.f20472X0xII0I, ProductManager.f20474X0xxXX0, ProductManager.f20350IO0XoXxO, ProductManager.f20571oXxOI0oIx, ProductManager.f20454OxXXx0X, "F3", ProductManager.f20420OOOI, ProductManager.f20383IxIX0I, ProductManager.f20505Xo, "M3", ProductManager.f20467X0O0I0, ProductManager.f20453OxO, ProductManager.f20664xxx00, ProductManager.f20529o0Xo, ProductManager.f20464X00xOoXI, ProductManager.f20425OOxOI, ProductManager.f20486XO00XOO, ProductManager.f20432OXXoIoXI, ProductManager.f20512XooIO0oo0, ProductManager.f20419OOIXx0x, ProductManager.f20618xIx0XO, ProductManager.f20573oXxx000, ProductManager.f20623xOOxI, ProductManager.f20617xIx, ProductManager.f20658xxIXOIIO, ProductManager.f20642xoIox, ProductManager.f20342IIOIX, ProductManager.f20510XoOxI0ox, ProductManager.f20493XOxoX, ProductManager.f20612xIXIOX, ProductManager.f20470X0ooXIooI, ProductManager.f20561oX000x, ProductManager.f20611xIOXX, ProductManager.f20384IxIo, ProductManager.f20603x0oxIIIX, ProductManager.f20395O0OOX0IIx, ProductManager.f20330I00O, ProductManager.f20645xoX, ProductManager.f20430OXIOoo0X0, ProductManager.f20415OIxx0I0, ProductManager.f20602x0oox0, ProductManager.f20652xx0, ProductManager.f20443OooO0XOx, ProductManager.f20521XxXX, ProductManager.f20400O0x, ProductManager.f20528o0Oo, ProductManager.f20414OIxOX, ProductManager.f20598x0OOI, ProductManager.f20366IXoIo, ProductManager.f20404OI0, ProductManager.f20369Io, ProductManager.f20523o0, ProductManager.f20495XX, ProductManager.f20551oO0IXx, ProductManager.f20578ooO0oXxI, ProductManager.f20527o0OO0, ProductManager.f20636xXo, ProductManager.f20525o00xOoIO, ProductManager.f20382IxI, ProductManager.f20613xIXOoI, "F6", ProductManager.f20478XIOOI, ProductManager.f20582oox000IX, ProductManager.f20585ox0I, ProductManager.f20399O0o0, ProductManager.f20412OIxI0O, ProductManager.f20363IXX, ProductManager.f20596x00X0xoXO, ProductManager.f20490XOo0, ProductManager.f20373IoX, ProductManager.f20538oI0, ProductManager.f20616xIoXXXIXo, ProductManager.f20364IXXIXx00I, ProductManager.f20656xx0o0O, ProductManager.f20482XIxO, ProductManager.f20439OoIXo, ProductManager.f20473X0xOO, ProductManager.f20517XxIIOXIXx, ProductManager.f20394O0O0Io00X, ProductManager.f20407OIIXOxo, ProductManager.f20541oI0X0, ProductManager.f20545oIXoXx0, ProductManager.f20516XxI, ProductManager.f20367IXxOIOO, ProductManager.f20632xX0ox, ProductManager.f20641xoIXOxX, ProductManager.f20647xooxxX, ProductManager.f20401O0xO0, ProductManager.f20361IXIxx0, ProductManager.f20666xxxoo0XI, ProductManager.f20341IIIxO, ProductManager.f20661xxXXXxIxo, ProductManager.f20471X0x, "R9", ProductManager.f20461X0, ProductManager.f20333I0OO, ProductManager.f20629xOxxXO, ProductManager.f20385IxO0Oxo, ProductManager.f20509XoOOx0IX, ProductManager.f20653xx00oOoI, ProductManager.f20355IOXOxOII, ProductManager.f20572oXxOXOX, ProductManager.f20534o0xIoII, ProductManager.f20498XXIoX0, ProductManager.f20438OoI0OO, ProductManager.f20352IOI, ProductManager.f20421OOOox, ProductManager.f20375IoXO0XoX, ProductManager.f20651xx, "F7", ProductManager.f20452OxIxx0, ProductManager.f20353IOOXOOOOo, ProductManager.f20504XXx0OXXXo, ProductManager.f20376IoxOx, ProductManager.f20347IIoX0OoI, ProductManager.f20553oOIXoIXXI, ProductManager.f20539oI00o, ProductManager.f20589oxOIoIx, ProductManager.f20411OIx0xoOo, ProductManager.f20499XXO0, ProductManager.f20606x0xOIoO, ProductManager.f20513Xx, ProductManager.f20434OXxx0OO, ProductManager.f20650xoxo, ProductManager.f20468X0OXX, ProductManager.f20448Ox00XOXoo, ProductManager.f20489XOOO0O, ProductManager.f20552oO0OX0, ProductManager.f20533o0xIIX0, ProductManager.f20514Xx0, ProductManager.f20351IO0xX, ProductManager.f20338II0OOXOx, ProductManager.f20356IOo0, ProductManager.f20518XxIOX, ProductManager.f20413OIxOIX0II, ProductManager.f20497XX0xXo, ProductManager.f20536o0xxxXXxX, ProductManager.f20391O00XxXI, ProductManager.f20583ox, "T78", ProductManager.f20354IOOoXo0Ix, ProductManager.f20466X0IOOI, ProductManager.f20455Oxo00O, ProductManager.f20379Ix0, ProductManager.f20648xox, ProductManager.f20619xIxooxXX, ProductManager.f20519XxIo, ProductManager.f20587oxIO0IIo, ProductManager.f20576oo0oIXo, "F5", ProductManager.f20381Ix0x, "Y1", ProductManager.f20627xOx, "V2", ProductManager.f20358IOooo0o, ProductManager.f20429OX00o0X, "Y3", ProductManager.f20409OIoxIx, ProductManager.f20570oXoXxOo, ProductManager.f20445OoxOxII, ProductManager.f20633xXIX0Xo, ProductManager.f20460Oxxo, ProductManager.f20503XXooOOI, ProductManager.xOIx00, ProductManager.f20406OIII0O, "Y2", ProductManager.f20501XXoO0oX, ProductManager.f20620xOI0, ProductManager.f20543oIX0o, ProductManager.f20392O0IoXXOx, "B9", ProductManager.f20450Ox0XO, ProductManager.f20424OOoOoO0o, ProductManager.f20377IoxX, ProductManager.f20360IXIIo, ProductManager.f20588oxO, ProductManager.f20359IXI, ProductManager.f20491XOx, ProductManager.f20436Oo0IXI0, ProductManager.f20431OXOo, ProductManager.f20332I0O00OI, ProductManager.f20386IxOIO, ProductManager.f20663xxx, "S1", ProductManager.f20530o0oIxOo, ProductManager.f20480XIXIxO, ProductManager.f20440OoO, ProductManager.f20408OIOoIIOIx, ProductManager.f20487XO0OX, ProductManager.f20566oXIoIo, ProductManager.f20444Oox, ProductManager.f20405OI0IXox, ProductManager.f20463X00IxOx, ProductManager.f20625xOoIIIoXI, ProductManager.f20554oOIx, ProductManager.f20628xOxOoo, "F2K", "W9", ProductManager.XoIoOXOIx, "R11S", ProductManager.II0, ProductManager.x0Io0, ProductManager.XoOOOXox, ProductManager.f20387IxOXOxO, ProductManager.f20346IIXOxIxOo, ProductManager.f20654xx0O, ProductManager.f20635xXXxoI, ProductManager.f20365IXo, ProductManager.f20447Ox, ProductManager.f20550oO0, ProductManager.f20396O0OoXI, ProductManager.f20546oIoxI0xx, ProductManager.f20547oIxOXo, ProductManager.f20621xOIO, ProductManager.f20548oIxxIo, "NY58", "F12", "AM01", "AM01J", ProductManager.oxXIOXO, ProductManager.I0XIOxO, ProductManager.xIIoO, ProductManager.x0OI, ProductManager.oo00Io, ProductManager.IxoOxx, ProductManager.X0oX, "AM11", ProductManager.XIo, ProductManager.o0Oox0xox, ProductManager.oOo0o, ProductManager.XxOOoxOO, ProductManager.XxOOoxOO, ProductManager.oIxXXOI, ProductManager.oII, ProductManager.oOx0xoXI, ProductManager.xOXoxI, ProductManager.IoOIIOx, ProductManager.OIO, ProductManager.oXIX, ProductManager.oOIoXOoI, "G7 Talk PRO", ProductManager.o0IXO, ProductManager.xX0Ox, ProductManager.XXoXOI, ProductManager.x0XOOIXXO, ProductManager.I0X0Ox, ProductManager.OxXOoO, ProductManager.xOIIO0x, ProductManager.OXooXOXx, ProductManager.IO00xOx0, ProductManager.xoOXXoO0X, ProductManager.XxIX, ProductManager.OOxxOOX, ProductManager.IOOx, "AM02J", ProductManager.XOx0xX, ProductManager.OxxIXIX, ProductManager.oIxXX0Xo, ProductManager.O0x0XXxI, ProductManager.oooO0oo, ProductManager.o0I0O0oXX, "R9J", "F11", ProductManager.oIoIxo, "F13A", ProductManager.xOOxX, ProductManager.OOo, ProductManager.OOX0x, ProductManager.xIOI0xO, "F13B", ProductManager.xXx0x0, ProductManager.OOOxXxoO, ProductManager.XxIO0, ProductManager.OXoIXx, ProductManager.xooXo, ProductManager.O0OOoIox, ProductManager.I0IIXxxo, ProductManager.XIoox00ox, ProductManager.OIOxOX, ProductManager.xxX0X, ProductManager.Xooo0Xx, ProductManager.I000X, ProductManager.oox, ProductManager.OxI0, ProductManager.IoxoI0IX, ProductManager.X0Ix00XxO, ProductManager.xIXXIo, ProductManager.xIo0xoOOx, ProductManager.IIIo0Xo, ProductManager.xoO0, ProductManager.XoIxo, ProductManager.OI, ProductManager.o0OoX, ProductManager.XXOOoxx0x, ProductManager.x0ooOIxO, ProductManager.o0x0XOXx, ProductManager.XX00xxo, ProductManager.xXXXox, ProductManager.xxIOxXI, ProductManager.Io0OXxX, ProductManager.xXxIoIXX0, ProductManager.XXOo, ProductManager.IXOO0X0, ProductManager.xOo, ProductManager.IXoxO, ProductManager.XOO, ProductManager.o0I, ProductManager.xO0x00ox, ProductManager.oX0Ox, ProductManager.OoIoI0, ProductManager.XOX0XxOxI, ProductManager.I0o, ProductManager.oXIo0X0x, ProductManager.xXIxxo0x, ProductManager.X0xO, ProductManager.OOxOXI0, ProductManager.XIOoI, ProductManager.OIXO, ProductManager.OxIXxXXI0, ProductManager.x0I0, ProductManager.OOI, ProductManager.XoOOxOo0o, ProductManager.Ix00, ProductManager.xIOOIO, ProductManager.Ox0, ProductManager.xoOX00, ProductManager.IxxOI, ProductManager.xOxxIxxI0, ProductManager.XOOI0, ProductManager.xoOI00O0X, ProductManager.IoXIo, ProductManager.OXXxXoO, ProductManager.IXXxo, ProductManager.OXoIOx, ProductManager.Xx0OXIoI, ProductManager.XoI0OoX, ProductManager.o0Ixx, ProductManager.x0x, ProductManager.IxoXXoXo, ProductManager.OXI, ProductManager.xXOO, ProductManager.xoOx, ProductManager.IX0OOX, ProductManager.IoooXox0, "A7", "A8", ProductManager.oXxo, ProductManager.xIO, ProductManager.oo0, ProductManager.OXO0, ProductManager.oIo0OoXIo, ProductManager.XIOX, ProductManager.oxxX, ProductManager.IOxoo, ProductManager.xxI0x, ProductManager.O0o, ProductManager.xxo00, ProductManager.IXx, ProductManager.OxXIoIxIo, ProductManager.oXX0, ProductManager.IIoIIxx, ProductManager.o0Xo0XX, ProductManager.oIxIO, "F17", ProductManager.IxIXo, ProductManager.oXXI0, ProductManager.I0OXXIoX, ProductManager.XOXo0, ProductManager.X0OIo0XxO, ProductManager.XXoOOO0I, ProductManager.oOI0IXOO, ProductManager.XIX, ProductManager.I0xoOOIx, ProductManager.o00Ox0xOO, ProductManager.oXXX, "F12Pro", ProductManager.IIx, ProductManager.Xo0oxxX0, ProductManager.oIoox0, ProductManager.oIxIOoOx, ProductManager.XOOooo, ProductManager.ox0xI00IX, ProductManager.ooXXoOx, ProductManager.oIIXxXIox, ProductManager.xXIO, ProductManager.ooOxox, ProductManager.O0o0OI00, ProductManager.I00, ProductManager.oXIOOxX, ProductManager.OIIxOxx, ProductManager.ooO0xXX, ProductManager.oXx0XO, "V61", ProductManager.XXIo, ProductManager.oIXXo, ProductManager.x0O0xO, ProductManager.xo0XO, ProductManager.o0OI, ProductManager.xX0xI, ProductManager.I0XoOIO, ProductManager.IO0o, ProductManager.oI0xOoox, ProductManager.x0Xox, ProductManager.IXx0, ProductManager.oOX, ProductManager.OXIIo0, ProductManager.XI0Ox, ProductManager.XoI, ProductManager.IOOOI, "AM05", ProductManager.xoxX0I, ProductManager.XOOxX, ProductManager.XxOx, ProductManager.Ooxxx, ProductManager.oI0XoXIXo, ProductManager.XOIoXxI, ProductManager.OIx, ProductManager.I0XOIOO0I, ProductManager.xO, ProductManager.oxX0o, ProductManager.X0OXoo0, ProductManager.OIXXIXxX, ProductManager.x0I, ProductManager.ooOO0I0, ProductManager.IOxO, ProductManager.xoXXXIX, ProductManager.OOxXo, ProductManager.Xo00XX, ProductManager.Ix0Xx, ProductManager.oIIOI, ProductManager.XIxOIII, ProductManager.x00X, ProductManager.xxoxO0O, ProductManager.Xx0X, ProductManager.xOOxIoOoO, ProductManager.Ioxo0x0x0, ProductManager.IxO0X0, ProductManager.IXoXxxO, ProductManager.IxOOI0Xo, ProductManager.IIOXx, ProductManager.xo0oXIOO, ProductManager.Oox0oOO0, ProductManager.x0XOxo, ProductManager.IOxxIx, ProductManager.O0XOI, ProductManager.oOO, ProductManager.XO000, ProductManager.O0OO0Ox, ProductManager.XXI0XXo, ProductManager.IIoOIO0, ProductManager.oxo0x0, ProductManager.xOII0IIX, ProductManager.XoXX, ProductManager.x00o, ProductManager.IxxXI0o, ProductManager.O00oxX0, ProductManager.OX0xI0IO, ProductManager.xX0, ProductManager.II, "R5", ProductManager.OIOIxOO, ProductManager.IoxxXOO, ProductManager.I0XOx, ProductManager.o0o, ProductManager.xo0Io0Ooo, ProductManager.IxIXoo, ProductManager.oXIOxo, ProductManager.xxo0o, ProductManager.o00OI00, ProductManager.XxXOXo0Xx, ProductManager.oXx0oXXo, ProductManager.ooOIo, ProductManager.oXOxox, ProductManager.OXOXxxOOO, ProductManager.xxXX0, ProductManager.X000ooOxx, ProductManager.XoXX0x00, ProductManager.x0xoIx0, ProductManager.oIo0x, ProductManager.oO0o, ProductManager.OIo0o, ProductManager.OI0xX, ProductManager.IooOox, ProductManager.OxX, ProductManager.OOOO, ProductManager.I0XIOxXXX, ProductManager.OIxooI0, ProductManager.I0xI0oI, ProductManager.oXx00I, ProductManager.xXXI0IX00, ProductManager.XOOI, ProductManager.IOoxOXXx0, ProductManager.XOOXX0II, ProductManager.XXIo0OO, "FC1", ProductManager.xooxxo, ProductManager.X00O, ProductManager.OOxXXO, ProductManager.X0oxOX, ProductManager.OxIoXo, ProductManager.xOII, ProductManager.O00Ix, ProductManager.OOIX, ProductManager.oXo, ProductManager.xoxoXoxIo, ProductManager.XoOoxI0X, ProductManager.XxxoIooX, ProductManager.XxOX, ProductManager.Oo0OxoOx, ProductManager.IxXXI0Xo, ProductManager.XIx, ProductManager.ooXOOxo, ProductManager.ooIoIX, ProductManager.XOxoXO, ProductManager.Xx0O0O, ProductManager.OIxOo0XI, ProductManager.XoOo0Ooo0, ProductManager.oxox0OIx, ProductManager.ox0OIxO, ProductManager.Oxx0, ProductManager.Xo0oxx, ProductManager.OxII, ProductManager.x0OOxoo, ProductManager.Ioo0Ooox, ProductManager.oxIO, "FC2", ProductManager.IX0, ProductManager.IO0000X0X, ProductManager.XIo0IOI0, "R16", ProductManager.OXxIXOxO, ProductManager.oxOX0OXx, ProductManager.OXx, ProductManager.xI00o, ProductManager.IOIOO0, ProductManager.Oo0oOO, ProductManager.X0X0, ProductManager.X0OXxIII, ProductManager.Oo0I0Io, ProductManager.Ioxx, ProductManager.xxX0oIX0I, ProductManager.oXIxxoI0x, ProductManager.IOIOooXOx, ProductManager.IOI0XxIo, ProductManager.xxox, ProductManager.XxXxIx, ProductManager.oxoIOxO, ProductManager.xxxxxo, ProductManager.IX, ProductManager.x0Ox, ProductManager.IOOxxIox, ProductManager.IXx0x, ProductManager.o0IXI, ProductManager.O0x0XII, "R21", ProductManager.oO0xxI, ProductManager.oxoo, ProductManager.O000IX, ProductManager.oxoxO, ProductManager.OoXX, ProductManager.IxxxXx0I, ProductManager.XoxXOX0I, ProductManager.XO0XIXOo0, ProductManager.OIIoIo, ProductManager.OXxXoOx, ProductManager.xOXI, ProductManager.OooXX0, ProductManager.Ixo0, ProductManager.XIxIO0XO, ProductManager.OIIXIIO0, ProductManager.oII00xox, ProductManager.OIOXo, ProductManager.x0XIoX00, ProductManager.IIXOxX, ProductManager.XxxoXoX, ProductManager.x00, ProductManager.xxXIIXIxx, ProductManager.IoOIIOx, ProductManager.OIO, ProductManager.oXIX, ProductManager.oOIoXOoI, "G7 Talk PRO", ProductManager.o0IXO, ProductManager.xX0Ox, ProductManager.XXoXOI, ProductManager.x0XOOIXXO, ProductManager.I0X0Ox, ProductManager.OxXOoO, ProductManager.xOIIO0x, ProductManager.OXooXOXx, ProductManager.IO00xOx0, ProductManager.xoOXXoO0X, ProductManager.XxIX, ProductManager.OOxxOOX, ProductManager.IOOx, "AM08", ProductManager.ooIx, ProductManager.XIxoOo0oI, ProductManager.oo0oIoOIO, ProductManager.XxoOI00IX, ProductManager.XIIOIXoI, ProductManager.OO00xO0I, ProductManager.Oxxx0X0oI, ProductManager.OXxO, ProductManager.xxooOxoO, ProductManager.IIO0X0I, ProductManager.O0o0OO, ProductManager.oI0XIox, ProductManager.XOOoX0xo, "JX621D", ProductManager.xxxoXXo0X, ProductManager.xIxO0X0I, ProductManager.OO00XXI, ProductManager.xXooxOx0O, ProductManager.ooxI0, ProductManager.IXooXOxI0, ProductManager.XIxIOOOx, ProductManager.oOI0ooOO, ProductManager.oXO0x, ProductManager.XOXxX0, ProductManager.o0OXIoI, ProductManager.OIIOOoXx, ProductManager.x0X, ProductManager.XIIxXO, ProductManager.IOxoXoI, ProductManager.xo0Xo0xo, ProductManager.oO000oO, ProductManager.OIO0XIo, ProductManager.XxOOO0, ProductManager.XXoIoXOO, ProductManager.XoXoOo, ProductManager.IO00, ProductManager.Io00oOXox, ProductManager.xIoIxoO, ProductManager.Oo00XooIO, ProductManager.xOxIxO, ProductManager.OIx0IoOx0, ProductManager.Xo0OOoo, ProductManager.Xx0IoOX, ProductManager.OIXo, ProductManager.x0OIOXo0, ProductManager.X0OxoOx, ProductManager.IIX, ProductManager.ooX0XXOI, ProductManager.XoxoOo, ProductManager.oXOIxX, ProductManager.IoXI, ProductManager.IXxoX0Ix, ProductManager.xIxXx0oI0, ProductManager.x0Oo0X, ProductManager.xOxXOOIx, ProductManager.XooOx, ProductManager.OooI0, ProductManager.O0OoIOIxX, ProductManager.ooIoIx0, ProductManager.IXIOOoxX, ProductManager.OI00Oo0, ProductManager.IIIxxOO, ProductManager.xx0IXxxx0, ProductManager.OIIO0oIoO, ProductManager.ooX, ProductManager.xXOxII0xx, ProductManager.ooOxox0O0, ProductManager.OOO, ProductManager.XooooIO0, ProductManager.xXOoI, ProductManager.oxoxX0Oxo, ProductManager.XIIo, ProductManager.IO0, ProductManager.O0oo0o, ProductManager.IoXx, ProductManager.xO0xx0xxx, ProductManager.OxIX, ProductManager.IoIOXX, ProductManager.oI0xOX, ProductManager.OOXIxoX, ProductManager.IOx0XI0, ProductManager.oX0OXOXOo, "AW37", ProductManager.oOII, ProductManager.Ioo0OxIo, ProductManager.oX0XO, ProductManager.Ix, ProductManager.xOO0X, ProductManager.oIx0, ProductManager.OxoOX0X0, ProductManager.oIOIO, ProductManager.OXOxXI, ProductManager.Ox0O0X, ProductManager.ooO00o, ProductManager.xIxxXXxx, ProductManager.xXO, ProductManager.IooOI0x, ProductManager.XXOXXx, ProductManager.O00X, ProductManager.oxOoo, ProductManager.oI0xoXO, ProductManager.XIXIo0OX, ProductManager.oxI0, ProductManager.xXoOoxXIX, ProductManager.XOxxxx00X, ProductManager.IOXX00X, ProductManager.OIOO, ProductManager.o0Xo0XII, ProductManager.OxXIoIX, ProductManager.IoO, ProductManager.OoooxII, ProductManager.O0oXOX0XX, ProductManager.xx0XoXxI, ProductManager.oIXx0o, ProductManager.XOoxOo0oX, ProductManager.x0x000, ProductManager.oXx0xxxX, ProductManager.O0OxXXox, ProductManager.IxoooIO0, ProductManager.IOoXX, ProductManager.xoO0X, ProductManager.OIXI, ProductManager.oIIOI, ProductManager.XoxXox, ProductManager.xo0XO, ProductManager.O0oXOX0XX, ProductManager.XxxIX, ProductManager.f20543oIX0o, ProductManager.o0x0XOXx, "S1", "S2", ProductManager.XXoo0, ProductManager.Iox, ProductManager.XOX0x0XO, ProductManager.I00I, ProductManager.oXOXo, ProductManager.X0XI, ProductManager.XI0, ProductManager.xoIooI0, ProductManager.OooOoX, ProductManager.xIX0XOOX, ProductManager.Ixox0x, ProductManager.OOox, ProductManager.XoO, ProductManager.xIOOoxxxO, ProductManager.I00oX, ProductManager.xXxIxo, ProductManager.xo000, ProductManager.XOX, ProductManager.OXxIOxox, ProductManager.IxoXx, ProductManager.X0IXX, ProductManager.oO0XoIX, ProductManager.X0xXOX, "R16", ProductManager.x0o0O0Oo, ProductManager.xO0x, ProductManager.I0o0xoIIx, ProductManager.O0OO, ProductManager.OIo, ProductManager.IIIXXXII, "R7", ProductManager.xOoO0O0O, ProductManager.oXxOXxo0O, ProductManager.XxOIoXI, ProductManager.IoxoIIx, ProductManager.IooOO, ProductManager.I00I, ProductManager.OIX0oXO0o, ProductManager.IoXIOI0O, ProductManager.OOoxI, ProductManager.IoXOxx0o, ProductManager.o0XxxOIx, ProductManager.IIXxoXXox, ProductManager.OoOoxX0xo, ProductManager.XxI0, ProductManager.xo0OI, ProductManager.oooOX, ProductManager.IxXOO0o0, "R9", "WS001", ProductManager.oIxXOO, ProductManager.I0IoX00I, ProductManager.I0Xo, ProductManager.xOx0oO, ProductManager.O0XI00X0o, ProductManager.xX0xXooOO, ProductManager.O0IIO0, ProductManager.xoOxO0, ProductManager.I0X, ProductManager.OxoIO00, ProductManager.O0xOx0, ProductManager.oo0I0oI, ProductManager.xXxox, ProductManager.x0IOX0o, ProductManager.OxXO0oo, ProductManager.OoX, ProductManager.xoI, ProductManager.oOIxIIoI, ProductManager.II0XIox, ProductManager.IO0Xox, ProductManager.xo0xII0II, ProductManager.O0XX0IX, ProductManager.Xoo0, ProductManager.IxIOOxO, ProductManager.xxIOx, "A7", "G7 Talk PRO", ProductManager.oIIo0xX, ProductManager.XOIIOIx, ProductManager.Xo000XO0, ProductManager.oIO0X00, ProductManager.IIxO, ProductManager.xX0Oo, "R4", "GF03Pro", ProductManager.ooO0, ProductManager.oOXOxxoxO, ProductManager.O0I, ProductManager.OI0OIIo, ProductManager.oxIXXxXx0, ProductManager.oIOXxOI, ProductManager.IIxOxOx0, ProductManager.xoxX, "GF03Pro", ProductManager.o0XO, ProductManager.IxXxoIIO, "R3", ProductManager.xxXxI, ProductManager.oX0IoO, ProductManager.IXx0oOO, ProductManager.Ioo, ProductManager.xXoIx00, ProductManager.IXOXoIo0x, ProductManager.oxI0OxXoO, ProductManager.ooxooo, ProductManager.IoXIOXo, ProductManager.X0Ox, ProductManager.XxxXX0XO0, ProductManager.oXx0XOX0, ProductManager.IX0IO, ProductManager.xoxXoXO, ProductManager.IoIxoI, ProductManager.oxOII, ProductManager.f20485XO0, ProductManager.O0xOXxxx, ProductManager.XIOxIIxxI, ProductManager.XXO, ProductManager.XIxI, ProductManager.OxI0000XO, ProductManager.XIOOX0, ProductManager.x0oo, ProductManager.o0xIXX, ProductManager.XIx0, ProductManager.xIxxxX0O, ProductManager.xXOOx, ProductManager.OoIO0OIX, ProductManager.XxoOX0I, "R21", "A8", ProductManager.o0OXIoI, ProductManager.IXXOI, ProductManager.IXXxOX00X, ProductManager.oxI0IX, ProductManager.oo0o, ProductManager.I0ox0, ProductManager.xx00OX, ProductManager.xXxx, ProductManager.OXxo, ProductManager.IoxOXXxXo, ProductManager.xoooOIO, ProductManager.ooIxOOoOo, ProductManager.OOXx, ProductManager.I0I0IoIXO, ProductManager.X0oO, ProductManager.IxxOIX, ProductManager.o0oo, ProductManager.oooIXI0o, ProductManager.OXX0xxo, ProductManager.IxX0, ProductManager.OO00, ProductManager.I00XxoO, ProductManager.XoOoxIIx, ProductManager.Xo0IXOO00, ProductManager.OOxIO, ProductManager.XoXOIx, ProductManager.Xx0I, ProductManager.OxXIO, ProductManager.XOo, ProductManager.XoI0, ProductManager.xXOXOOx, ProductManager.xxxIO, ProductManager.XXOO, ProductManager.OxIOX, ProductManager.oIO, ProductManager.O0XI0, ProductManager.oxOoIOX, ProductManager.OXXo0, "M6", ProductManager.IxIoXOO, ProductManager.xoXI00O, ProductManager.Xxx0o0XI, "M3", ProductManager.XXI00xO, ProductManager.OXX, ProductManager.xIIOoXo, ProductManager.oIX, ProductManager.IOxOOIIO, ProductManager.x0OX, ProductManager.x0oXIXI, ProductManager.OOI00oxoO, ProductManager.oIXIXIxx0, ProductManager.Ix0XO, ProductManager.XXXoOII, ProductManager.xxXooOI, ProductManager.Xox0o, ProductManager.x0X0OIOx, ProductManager.oooO0ox, ProductManager.oXIxoOo, ProductManager.o0ooO, ProductManager.x000OxX, ProductManager.XIX0Oo0, ProductManager.xxXI, ProductManager.oXOxO0XXo, ProductManager.xXXXxOOI0, ProductManager.xOIXxOo, ProductManager.XxX0xI, ProductManager.IoOoo0XXX, ProductManager.Ix0X0oxX, ProductManager.IoI));
        }
    });

    @OOXIXo
    public static final X0IIOO IIOx = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ArrayList<String>>() { // from class: com.sma.smartv3.ble.ProductManager$REALTE_DEVICES$2
        @Override // Oox.oIX0oI
        @OOXIXo
        public final ArrayList<String> invoke() {
            return CollectionsKt__CollectionsKt.Oxx0xo("SMA-R4", ProductManager.f20458Oxx0xo, ProductManager.f20540oI0IIXIo, "R4", ProductManager.f20459OxxIIOOXO, ProductManager.f20345IIXOooo, ProductManager.f20646xoXoI, ProductManager.f20658xxIXOIIO, ProductManager.f20642xoIox, ProductManager.f20422OOXIXo, ProductManager.f20558oOoXoXO, ProductManager.f20579ooOOo0oXI, ProductManager.f20600x0XOIxOo, ProductManager.f20549oO, ProductManager.f20605x0xO0oo, ProductManager.f20435Oo, ProductManager.f20368IXxxXO, "SMA-R5", "R5", ProductManager.f20402O0xOxO, ProductManager.f20465X0IIOO, ProductManager.f20476XI0IXoo, ProductManager.f20483XIxXXX0x0, ProductManager.f20660xxX, ProductManager.f20515Xx000oIo, ProductManager.f20520XxX0x0xxx, ProductManager.f20638xXxxox0I, ProductManager.f20344IIX0o, ProductManager.f20581ooXIXxIX, ProductManager.f20607xI, ProductManager.f20577oo0xXOI0I, ProductManager.f20574oo, ProductManager.f20371IoOoX, ProductManager.f20555oOXoIIIo, ProductManager.f20462X00IoxXI, ProductManager.f20349IO, ProductManager.f20610xII, ProductManager.f20601x0o, ProductManager.f20492XOxIOxOx, "SMA-F2", ProductManager.f20593oxxXoxO, ProductManager.f20511XoX, ProductManager.f20591oxXx0IX, ProductManager.f20640xo0x, ProductManager.f20418OO0x0xX, ProductManager.f20481XIo0oOXIx, ProductManager.f20378Ioxxx, ProductManager.f20634xXOx, ProductManager.f20496XX0, ProductManager.f20334I0X0x0oIo, "GT WATCH PLUS", ProductManager.f20506Xo0, ProductManager.f20477XI0oooXX, ProductManager.f20423OOXIxO0, ProductManager.f20348IIxOXoOo0, ProductManager.f20329I0, ProductManager.f20580ooOx, ProductManager.f20644xoO0xx0, ProductManager.f20428OX00O0xII, "R7", ProductManager.f20622xOOOX, "TIME", ProductManager.f20479XIXIX, ProductManager.f20556oOo, ProductManager.f20397O0X, ProductManager.f20626xOoOIoI, "L1", "R11", ProductManager.f20389O0, ProductManager.f20446OoxxX, ProductManager.f20563oX0O, ProductManager.f20655xx0X0, ProductManager.f20530o0oIxOo, ProductManager.f20480XIXIxO, ProductManager.f20440OoO, ProductManager.f20408OIOoIIOIx, ProductManager.f20609xI0oxI00, ProductManager.f20370IoIOOxIIo, ProductManager.f20586oxIIX0o, "SMA-F1RT", ProductManager.f20502XXoOx0, ProductManager.f20383IxIX0I, ProductManager.f20557oOoIIO0, ProductManager.f20362IXO, ProductManager.f20380Ix00oIoI, ProductManager.f20393O0IxXx, "F1", ProductManager.f20537oI, ProductManager.f20659xxOXOOoIX, ProductManager.f20404OI0, ProductManager.f20369Io, ProductManager.f20523o0, ProductManager.f20495XX, "R10", ProductManager.f20475XI, ProductManager.f20357IOoo, ProductManager.f20542oIIxXoo, ProductManager.f20569oXX0IoI, ProductManager.f20500XXXI, ProductManager.f20337I0xX0, ProductManager.f20456Oxx, ProductManager.f20427OX, ProductManager.f20567oXIoO, ProductManager.f20526o0IXXIx, ProductManager.f20417OO0, ProductManager.f20508XoIxOXIXo, ProductManager.f20442OooI, ProductManager.f20410OIx00oxx, "F6", ProductManager.f20478XIOOI, ProductManager.f20582oox000IX, ProductManager.f20585ox0I, ProductManager.f20399O0o0, ProductManager.f20412OIxI0O, ProductManager.f20363IXX, ProductManager.f20596x00X0xoXO, ProductManager.f20490XOo0, ProductManager.f20373IoX, ProductManager.f20538oI0, ProductManager.f20616xIoXXXIXo, ProductManager.f20364IXXIXx00I, ProductManager.f20656xx0o0O, ProductManager.f20482XIxO, ProductManager.f20439OoIXo, ProductManager.f20473X0xOO, ProductManager.f20517XxIIOXIXx, ProductManager.f20394O0O0Io00X, ProductManager.f20407OIIXOxo, ProductManager.f20541oI0X0, ProductManager.f20545oIXoXx0, ProductManager.f20516XxI, ProductManager.f20367IXxOIOO, ProductManager.f20632xX0ox, ProductManager.f20641xoIXOxX, ProductManager.f20647xooxxX, ProductManager.f20401O0xO0, ProductManager.f20361IXIxx0, ProductManager.f20666xxxoo0XI, ProductManager.f20341IIIxO, ProductManager.f20661xxXXXxIxo, ProductManager.f20471X0x, ProductManager.f20507XoI0Ixx0, ProductManager.f20398O0Xx, ProductManager.f20335I0oOIX, "F2R", ProductManager.f20416OO, ProductManager.f20643xoIxX, ProductManager.f20657xxIO, ProductManager.f20372IoOoo, "GT WATCH PLUS", ProductManager.f20637xXoOI00O, ProductManager.f20599x0OxxIOxX, ProductManager.f20594x0, ProductManager.f20472X0xII0I, ProductManager.f20474X0xxXX0, ProductManager.f20350IO0XoXxO, ProductManager.f20571oXxOI0oIx, "R9", ProductManager.f20461X0, ProductManager.f20333I0OO, ProductManager.f20629xOxxXO, ProductManager.f20385IxO0Oxo, ProductManager.f20509XoOOx0IX, ProductManager.f20653xx00oOoI, ProductManager.f20355IOXOxOII, ProductManager.f20572oXxOXOX, ProductManager.f20534o0xIoII, ProductManager.f20498XXIoX0, ProductManager.f20438OoI0OO, ProductManager.f20352IOI, ProductManager.f20421OOOox, ProductManager.f20375IoXO0XoX, ProductManager.f20651xx, "F7", ProductManager.f20452OxIxx0, ProductManager.f20353IOOXOOOOo, ProductManager.f20504XXx0OXXXo, ProductManager.f20376IoxOx, ProductManager.f20347IIoX0OoI, ProductManager.f20553oOIXoIXXI, ProductManager.f20539oI00o, ProductManager.f20589oxOIoIx, ProductManager.f20411OIx0xoOo, ProductManager.f20499XXO0, ProductManager.f20606x0xOIoO, ProductManager.f20513Xx, ProductManager.f20434OXxx0OO, ProductManager.f20650xoxo, ProductManager.f20468X0OXX, ProductManager.f20448Ox00XOXoo, ProductManager.f20489XOOO0O, ProductManager.f20552oO0OX0, ProductManager.f20533o0xIIX0, ProductManager.f20514Xx0, ProductManager.f20351IO0xX, ProductManager.f20338II0OOXOx, ProductManager.f20356IOo0, ProductManager.f20518XxIOX, ProductManager.f20413OIxOIX0II, ProductManager.f20497XX0xXo, ProductManager.f20536o0xxxXXxX, ProductManager.f20391O00XxXI, ProductManager.f20583ox, ProductManager.f20419OOIXx0x, ProductManager.f20618xIx0XO, ProductManager.f20573oXxx000, ProductManager.f20623xOOxI, ProductManager.f20617xIx, "T78", ProductManager.f20354IOOoXo0Ix, ProductManager.f20466X0IOOI, ProductManager.f20455Oxo00O, ProductManager.f20379Ix0, ProductManager.f20648xox, ProductManager.f20619xIxooxXX, ProductManager.f20519XxIo, ProductManager.f20587oxIO0IIo, ProductManager.f20576oo0oIXo, "F5", ProductManager.f20381Ix0x, "Y1", ProductManager.f20627xOx, "V2", ProductManager.f20358IOooo0o, ProductManager.f20429OX00o0X, "Y3", ProductManager.f20445OoxOxII, ProductManager.f20633xXIX0Xo, ProductManager.f20460Oxxo, ProductManager.f20503XXooOOI, ProductManager.xOIx00, ProductManager.f20406OIII0O, "Y2", ProductManager.f20501XXoO0oX, ProductManager.f20620xOI0, ProductManager.f20543oIX0o, ProductManager.f20392O0IoXXOx, "B9", ProductManager.f20450Ox0XO, ProductManager.f20424OOoOoO0o, ProductManager.f20377IoxX, ProductManager.f20360IXIIo, ProductManager.f20588oxO, ProductManager.f20359IXI, ProductManager.f20491XOx, ProductManager.f20436Oo0IXI0, ProductManager.f20431OXOo, ProductManager.f20332I0O00OI, ProductManager.f20386IxOIO, ProductManager.f20663xxx, ProductManager.f20614xIXX, ProductManager.f20665xxxI, ProductManager.f20390O00, ProductManager.f20624xOOxIO, "S1", ProductManager.f20487XO0OX, ProductManager.f20566oXIoIo, ProductManager.f20444Oox, ProductManager.f20405OI0IXox, ProductManager.f20463X00IxOx, ProductManager.f20625xOoIIIoXI, ProductManager.f20554oOIx, ProductManager.f20628xOxOoo, "F2K", "W9", ProductManager.XoIoOXOIx, "R11S", ProductManager.II0, ProductManager.x0Io0, ProductManager.XoOOOXox, ProductManager.f20387IxOXOxO, ProductManager.f20346IIXOxIxOo, ProductManager.f20654xx0O, ProductManager.f20635xXXxoI, ProductManager.f20365IXo, ProductManager.f20447Ox, ProductManager.f20550oO0, ProductManager.f20396O0OoXI, ProductManager.f20546oIoxI0xx, ProductManager.f20547oIxOXo, ProductManager.f20621xOIO, ProductManager.f20548oIxxIo, "NY58", "F12", "AM01", "F11", ProductManager.oIoIxo, "F13A", ProductManager.xOOxX, ProductManager.OOo, ProductManager.OOX0x, ProductManager.xIOI0xO, ProductManager.X0OIo0XxO, ProductManager.XXoOOO0I, ProductManager.oOI0IXOO, ProductManager.XIX, ProductManager.I0xoOOIx, ProductManager.o00Ox0xOO, ProductManager.oXXX, ProductManager.f20575oo00, "F3", ProductManager.OIIoIo, ProductManager.OXxXoOx, ProductManager.xOXI, ProductManager.OooXX0, ProductManager.IooOI0x, ProductManager.xx0XoXxI, ProductManager.f20485XO0);
        }
    });

    @OOXIXo
    public static final X0IIOO IOX0Xo = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ArrayList<String>>() { // from class: com.sma.smartv3.ble.ProductManager$REALTE_SMA_DEVICES$2
        @Override // Oox.oIX0oI
        @OOXIXo
        public final ArrayList<String> invoke() {
            return CollectionsKt__CollectionsKt.Oxx0xo("F6", ProductManager.f20478XIOOI, ProductManager.f20582oox000IX, ProductManager.f20585ox0I, ProductManager.f20399O0o0, ProductManager.f20412OIxI0O, ProductManager.f20363IXX, ProductManager.f20596x00X0xoXO, ProductManager.f20490XOo0, ProductManager.f20373IoX, "F5", "F7", ProductManager.f20452OxIxx0, ProductManager.f20353IOOXOOOOo, ProductManager.f20504XXx0OXXXo, ProductManager.f20376IoxOx, ProductManager.f20347IIoX0OoI, ProductManager.f20553oOIXoIXXI, ProductManager.f20539oI00o, ProductManager.f20589oxOIoIx, ProductManager.f20411OIx0xoOo, "R10", ProductManager.f20499XXO0, ProductManager.f20475XI, ProductManager.f20357IOoo, ProductManager.f20542oIIxXoo, ProductManager.f20569oXX0IoI, ProductManager.f20500XXXI, ProductManager.f20337I0xX0, ProductManager.f20456Oxx, ProductManager.f20427OX, ProductManager.f20567oXIoO, ProductManager.f20526o0IXXIx, ProductManager.f20417OO0, ProductManager.f20508XoIxOXIXo, ProductManager.f20627xOx, "Y3", ProductManager.f20461X0, "T78", ProductManager.f20354IOOoXo0Ix, "V2", ProductManager.f20445OoxOxII, ProductManager.f20406OIII0O, ProductManager.f20629xOxxXO, "R9", ProductManager.f20410OIx00oxx, ProductManager.f20633xXIX0Xo, ProductManager.f20460Oxxo, ProductManager.f20503XXooOOI, ProductManager.xOIx00, ProductManager.f20538oI0, ProductManager.f20616xIoXXXIXo, ProductManager.f20501XXoO0oX, ProductManager.f20392O0IoXXOx, "B9", ProductManager.f20450Ox0XO, ProductManager.f20424OOoOoO0o, ProductManager.f20358IOooo0o, ProductManager.f20332I0O00OI, ProductManager.f20439OoIXo, ProductManager.f20517XxIIOXIXx, ProductManager.f20394O0O0Io00X, ProductManager.f20407OIIXOxo, ProductManager.f20541oI0X0, ProductManager.f20545oIXoXx0, ProductManager.f20516XxI, ProductManager.f20367IXxOIOO, ProductManager.f20632xX0ox, ProductManager.f20641xoIXOxX, ProductManager.f20647xooxxX, ProductManager.f20401O0xO0, ProductManager.f20361IXIxx0, ProductManager.f20666xxxoo0XI, ProductManager.f20341IIIxO, ProductManager.f20661xxXXXxIxo, ProductManager.f20471X0x, ProductManager.f20466X0IOOI, ProductManager.f20386IxOIO, ProductManager.f20473X0xOO, ProductManager.f20663xxx, ProductManager.f20455Oxo00O, ProductManager.f20379Ix0, ProductManager.f20614xIXX, "S1", ProductManager.f20487XO0OX, ProductManager.f20566oXIoIo, ProductManager.f20444Oox, ProductManager.f20405OI0IXox, ProductManager.f20463X00IxOx, ProductManager.f20625xOoIIIoXI, ProductManager.f20554oOIx, ProductManager.f20628xOxOoo, ProductManager.f20648xox, ProductManager.f20619xIxooxXX, ProductManager.f20576oo0oIXo, ProductManager.f20519XxIo, ProductManager.f20587oxIO0IIo, "F2K", ProductManager.f20665xxxI, "W9", ProductManager.XoIoOXOIx, ProductManager.XoOOOXox, ProductManager.f20390O00, ProductManager.f20385IxO0Oxo, ProductManager.f20606x0xOIoO, "NY58", "F12", "AM01", ProductManager.f20513Xx, ProductManager.f20434OXxx0OO, ProductManager.f20509XoOOx0IX, ProductManager.f20429OX00o0X, ProductManager.f20624xOOxIO, ProductManager.f20653xx00oOoI, ProductManager.f20381Ix0x, ProductManager.f20650xoxo, ProductManager.f20513Xx, ProductManager.f20468X0OXX, ProductManager.f20448Ox00XOXoo, ProductManager.f20489XOOO0O, ProductManager.f20552oO0OX0, ProductManager.f20533o0xIIX0, ProductManager.f20514Xx0, ProductManager.f20351IO0xX, ProductManager.f20338II0OOXOx, ProductManager.f20356IOo0, ProductManager.f20518XxIOX, "F11", ProductManager.oIoIxo, ProductManager.f20355IOXOxOII, "F13A", ProductManager.xOOxX, ProductManager.OOo, ProductManager.OOX0x, ProductManager.xIOI0xO, ProductManager.f20377IoxX, ProductManager.f20572oXxOXOX, ProductManager.f20534o0xIoII, ProductManager.f20498XXIoX0, ProductManager.f20438OoI0OO, ProductManager.f20352IOI, ProductManager.f20421OOOox, ProductManager.f20375IoXO0XoX, ProductManager.f20651xx, ProductManager.f20364IXXIXx00I, ProductManager.f20656xx0o0O, ProductManager.f20482XIxO, ProductManager.f20360IXIIo, ProductManager.f20588oxO, ProductManager.f20359IXI, ProductManager.f20491XOx, ProductManager.f20436Oo0IXI0, ProductManager.f20431OXOo, ProductManager.f20620xOI0, ProductManager.f20543oIX0o, ProductManager.X0OIo0XxO, ProductManager.XXoOOO0I, ProductManager.oOI0IXOO, ProductManager.XIX, ProductManager.I0xoOOIx, ProductManager.o00Ox0xOO, ProductManager.oXXX, ProductManager.IooOI0x, ProductManager.xx0XoXxI, ProductManager.f20485XO0);
        }
    });

    @OOXIXo
    public static final X0IIOO oo0I = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ArrayList<String>>() { // from class: com.sma.smartv3.ble.ProductManager$GOODIX_DEVICES$2
        @Override // Oox.oIX0oI
        @OOXIXo
        public final ArrayList<String> invoke() {
            return CollectionsKt__CollectionsKt.Oxx0xo("R3H", "R3", ProductManager.f20388IxX00, ProductManager.f20488XO0o, ProductManager.f20562oX0I0O, ProductManager.f20595x00IOx, "PARIGI", ProductManager.f20564oX0ooo0I0);
        }
    });

    @OOXIXo
    public static final X0IIOO XOOXIXxxI = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ArrayList<String>>() { // from class: com.sma.smartv3.ble.ProductManager$NORDIC_DEVICES$2
        @Override // Oox.oIX0oI
        @OOXIXo
        public final ArrayList<String> invoke() {
            return CollectionsKt__CollectionsKt.Oxx0xo(ProductManager.f20340II0xO0, ProductManager.f20331I0Io, ProductManager.f20592oxoX, ProductManager.f20484XO, ProductManager.f20469X0o0xo, ProductManager.f20551oO0IXx, ProductManager.f20578ooO0oXxI, ProductManager.f20527o0OO0, ProductManager.f20382IxI, ProductManager.f20613xIXOoI, ProductManager.f20409OIoxIx, ProductManager.f20570oXoXxOo, ProductManager.f20332I0O00OI, ProductManager.f20636xXo, ProductManager.f20525o00xOoIO);
        }
    });

    @OOXIXo
    public static final X0IIOO O0oXIX0oX = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ArrayList<String>>() { // from class: com.sma.smartv3.ble.ProductManager$JL_DEVICES$2
        @Override // Oox.oIX0oI
        @OOXIXo
        public final ArrayList<String> invoke() {
            return CollectionsKt__CollectionsKt.Oxx0xo("AM01J", ProductManager.oxXIOXO, ProductManager.I0XIOxO, ProductManager.xIIoO, ProductManager.oII, ProductManager.oOx0xoXI, ProductManager.xOXoxI, ProductManager.oIxXXOI, ProductManager.x0OI, ProductManager.oo00Io, ProductManager.IxoOxx, ProductManager.X0oX, "AM11", ProductManager.XIo, ProductManager.o0Oox0xox, ProductManager.oOo0o, ProductManager.XxOOoxOO, ProductManager.XxOOoxOO, "R9J", "F13B", ProductManager.xXx0x0, ProductManager.OOOxXxoO, ProductManager.XxIO0, ProductManager.OXoIXx, ProductManager.xooXo, ProductManager.O0OOoIox, ProductManager.I0IIXxxo, ProductManager.XIoox00ox, ProductManager.OIOxOX, "A7", "A8", ProductManager.oXxo, ProductManager.xIO, ProductManager.oo0, ProductManager.OXO0, ProductManager.oIo0OoXIo, ProductManager.XIOX, ProductManager.oxxX, ProductManager.IOxoo, ProductManager.xxI0x, ProductManager.O0o, ProductManager.xxo00, ProductManager.oIxIO, ProductManager.IXx, ProductManager.OxXIoIxIo, ProductManager.oXX0, ProductManager.IIoIIxx, ProductManager.o0Xo0XX, "F17", ProductManager.IxIXo, ProductManager.oXXI0, ProductManager.I0OXXIoX, ProductManager.XOXo0, "AM02J", ProductManager.XOx0xX, ProductManager.OxxIXIX, ProductManager.oIxXX0Xo, ProductManager.O0x0XXxI, ProductManager.oooO0oo, ProductManager.o0I0O0oXX, ProductManager.f20463X00IxOx, ProductManager.OIIoIo, ProductManager.OXxXoOx, ProductManager.xOXI, ProductManager.f20404OI0, "F12Pro", ProductManager.IIx, ProductManager.Xo0oxxX0, ProductManager.oIoox0, ProductManager.oIxIOoOx, ProductManager.XOOooo, ProductManager.ox0xI00IX, ProductManager.ooXXoOx, ProductManager.oIIXxXIox, ProductManager.xXIO, ProductManager.ooOxox, ProductManager.O0o0OI00, ProductManager.I00, ProductManager.oXIOOxX, ProductManager.OIIxOxx, ProductManager.ooO0xXX, ProductManager.oXx0XO, "V61", ProductManager.XXIo, ProductManager.oIXXo, ProductManager.x0O0xO, ProductManager.xo0XO, ProductManager.o0OI, ProductManager.xX0xI, ProductManager.I0XoOIO, ProductManager.IO0o, ProductManager.oI0xOoox, ProductManager.x0Xox, ProductManager.IXx0, ProductManager.oOX, ProductManager.OXIIo0, ProductManager.XI0Ox, ProductManager.XoI, ProductManager.IOOOI, "AM05", ProductManager.xoxX0I, ProductManager.XOOxX, ProductManager.XxOx, ProductManager.Ooxxx, ProductManager.oI0XoXIXo, ProductManager.XOIoXxI, ProductManager.OIx, ProductManager.I0XOIOO0I, ProductManager.xO, ProductManager.oxX0o, ProductManager.X0OXoo0, ProductManager.OIXXIXxX, ProductManager.x0I, ProductManager.ooOO0I0, ProductManager.IOxO, ProductManager.xoXXXIX, ProductManager.OOxXo, ProductManager.Xo00XX, ProductManager.Ix0Xx, ProductManager.oIIOI, ProductManager.XIxOIII, ProductManager.x00X, ProductManager.xxoxO0O, ProductManager.Xx0X, ProductManager.xOOxIoOoO, ProductManager.Ioxo0x0x0, ProductManager.IxO0X0, ProductManager.IXoXxxO, ProductManager.IxOOI0Xo, ProductManager.IIOXx, ProductManager.xo0oXIOO, ProductManager.Oox0oOO0, ProductManager.x0XOxo, ProductManager.IOxxIx, ProductManager.O0XOI, ProductManager.oOO, ProductManager.XO000, ProductManager.O0OO0Ox, ProductManager.XXI0XXo, ProductManager.IIoOIO0, ProductManager.oxo0x0, ProductManager.xOII0IIX, ProductManager.XoXX, ProductManager.x00o, ProductManager.IxxXI0o, ProductManager.O00oxX0, ProductManager.OX0xI0IO, ProductManager.xX0, ProductManager.II, "R5", ProductManager.OIOIxOO, ProductManager.IoxxXOO, ProductManager.I0XOx, ProductManager.o0o, ProductManager.xo0Io0Ooo, ProductManager.IxIXoo, ProductManager.oXIOxo, ProductManager.xxo0o, ProductManager.o00OI00, ProductManager.XxXOXo0Xx, ProductManager.oXx0oXXo, ProductManager.ooOIo, ProductManager.oXOxox, ProductManager.OXOXxxOOO, ProductManager.oIo0x, ProductManager.oO0o, ProductManager.OIo0o, ProductManager.OI0xX, ProductManager.IooOox, ProductManager.OxX, ProductManager.OOOO, ProductManager.I0XIOxXXX, ProductManager.OIxooI0, ProductManager.I0xI0oI, ProductManager.oXx00I, ProductManager.xXXI0IX00, ProductManager.XOOI, ProductManager.IOoxOXXx0, ProductManager.XOOXX0II, ProductManager.XXIo0OO, "FC1", ProductManager.xooxxo, ProductManager.X00O, ProductManager.OOxXXO, ProductManager.X0oxOX, ProductManager.OxIoXo, ProductManager.xOII, ProductManager.O00Ix, ProductManager.OOIX, ProductManager.oXo, ProductManager.xoxoXoxIo, ProductManager.XoOoxI0X, ProductManager.xxXX0, ProductManager.XxxoIooX, ProductManager.XxOX, ProductManager.Oo0OxoOx, ProductManager.IxXXI0Xo, ProductManager.XIx, ProductManager.ooXOOxo, ProductManager.ooIoIX, ProductManager.XOxoXO, ProductManager.Xx0O0O, ProductManager.OIxOo0XI, ProductManager.XoOo0Ooo0, ProductManager.oxox0OIx, ProductManager.ox0OIxO, ProductManager.Oxx0, ProductManager.Xo0oxx, ProductManager.OxII, ProductManager.x0OOxoo, ProductManager.Ioo0Ooox, ProductManager.oxIO, "FC2", ProductManager.IX0, ProductManager.IO0000X0X, ProductManager.XIo0IOI0, "R16", ProductManager.OXxIXOxO, ProductManager.oxOX0OXx, ProductManager.OXx, ProductManager.xI00o, ProductManager.IOIOO0, ProductManager.Oo0oOO, ProductManager.X0X0, ProductManager.X0OXxIII, ProductManager.Oo0I0Io, ProductManager.Ioxx, ProductManager.xxX0oIX0I, ProductManager.oXIxxoI0x, ProductManager.IOIOooXOx, ProductManager.IOI0XxIo, ProductManager.xxox, ProductManager.XxXxIx, ProductManager.oxoIOxO, ProductManager.xxxxxo, ProductManager.IX, ProductManager.x0Ox, ProductManager.IOOxxIox, ProductManager.IXx0x, ProductManager.o0IXI, ProductManager.O0x0XII, "R21", ProductManager.oO0xxI, ProductManager.oxoo, ProductManager.O000IX, ProductManager.oxoxO, ProductManager.OoXX, ProductManager.IxxxXx0I, ProductManager.XoxXOX0I, ProductManager.XO0XIXOo0, ProductManager.xxX0X, ProductManager.Xooo0Xx, ProductManager.I000X, ProductManager.oox, ProductManager.OxI0, ProductManager.IoxoI0IX, ProductManager.X0Ix00XxO, ProductManager.xIXXIo, ProductManager.xIo0xoOOx, ProductManager.IIIo0Xo, ProductManager.xoO0, ProductManager.XoIxo, ProductManager.OI, ProductManager.o0OoX, ProductManager.XXOOoxx0x, ProductManager.x0ooOIxO, ProductManager.o0x0XOXx, ProductManager.XX00xxo, ProductManager.xXXXox, ProductManager.xxIOxXI, ProductManager.Io0OXxX, ProductManager.xXxIoIXX0, ProductManager.XXOo, ProductManager.IXOO0X0, ProductManager.xOo, ProductManager.IXoxO, ProductManager.XOO, ProductManager.o0I, ProductManager.xO0x00ox, ProductManager.oX0Ox, ProductManager.OoIoI0, ProductManager.XOX0XxOxI, ProductManager.I0o, ProductManager.oXIo0X0x, ProductManager.xXIxxo0x, ProductManager.X0xO, ProductManager.OOxOXI0, ProductManager.XIOoI, "Y1", ProductManager.OIXO, ProductManager.OxIXxXXI0, ProductManager.x0I0, ProductManager.OOI, ProductManager.XoOOxOo0o, ProductManager.X000ooOxx, ProductManager.XoXX0x00, ProductManager.x0xoIx0, ProductManager.Ix00, ProductManager.xIOOIO, ProductManager.Ox0, ProductManager.xoOX00, ProductManager.IxxOI, ProductManager.xOxxIxxI0, ProductManager.XOOI0, ProductManager.xoOI00O0X, ProductManager.IoXIo, ProductManager.OXXxXoO, ProductManager.IXXxo, ProductManager.OXoIOx, ProductManager.Xx0OXIoI, ProductManager.XoI0OoX, ProductManager.o0Ixx, ProductManager.x0x, ProductManager.IxoXXoXo, ProductManager.IoooXox0, ProductManager.OXI, ProductManager.xXOO, ProductManager.xoOx, ProductManager.IX0OOX, ProductManager.Ixo0, ProductManager.XIxIO0XO, ProductManager.OIIXIIO0, ProductManager.oII00xox, ProductManager.OIOXo, ProductManager.x0XIoX00, ProductManager.IIXOxX, ProductManager.XxxoXoX, ProductManager.x00, ProductManager.xxXIIXIxx, ProductManager.IoOIIOx, ProductManager.OIO, ProductManager.oXIX, ProductManager.oOIoXOoI, "G7 Talk PRO", ProductManager.o0IXO, ProductManager.xX0Ox, ProductManager.XXoXOI, ProductManager.x0XOOIXXO, ProductManager.I0X0Ox, ProductManager.OxXOoO, ProductManager.xOIIO0x, ProductManager.OXooXOXx, ProductManager.IO00xOx0, ProductManager.xoOXXoO0X, ProductManager.XxIX, ProductManager.OOxxOOX, ProductManager.IOOx, "F12", "AM08", ProductManager.ooIx, ProductManager.XIxoOo0oI, ProductManager.oo0oIoOIO, ProductManager.XxoOI00IX, ProductManager.XIIOIXoI, ProductManager.OO00xO0I, ProductManager.Oxxx0X0oI, ProductManager.OXxO, ProductManager.xxooOxoO, ProductManager.O0o0OO, ProductManager.oI0XIox, ProductManager.XOOoX0xo, ProductManager.IIO0X0I, "JX621D", ProductManager.xxxoXXo0X, ProductManager.xIxO0X0I, ProductManager.OO00XXI, ProductManager.xXooxOx0O, ProductManager.ooxI0, ProductManager.IXooXOxI0, ProductManager.XIxIOOOx, ProductManager.oOI0ooOO, ProductManager.oXO0x, ProductManager.XOXxX0, ProductManager.o0OXIoI, ProductManager.OIIOOoXx, ProductManager.x0X, ProductManager.XIIxXO, ProductManager.IOxoXoI, ProductManager.OIO0XIo, ProductManager.XxOOO0, ProductManager.XXoIoXOO, ProductManager.XoXoOo, ProductManager.IO00, ProductManager.Io00oOXox, ProductManager.xIoIxoO, ProductManager.Oo00XooIO, ProductManager.xOxIxO, ProductManager.OIx0IoOx0, ProductManager.Xo0OOoo, ProductManager.Xx0IoOX, ProductManager.OIXo, ProductManager.x0OIOXo0, ProductManager.X0OxoOx, ProductManager.IIX, ProductManager.ooX0XXOI, ProductManager.XoxoOo, ProductManager.oXOIxX, ProductManager.xIxXx0oI0, ProductManager.x0Oo0X, ProductManager.xOxXOOIx, ProductManager.XooOx, ProductManager.OooI0, ProductManager.O0OoIOIxX, ProductManager.ooIoIx0, ProductManager.IXIOOoxX, ProductManager.OI00Oo0, ProductManager.IIIxxOO, ProductManager.f20444Oox, "Y3", ProductManager.xo0Xo0xo, ProductManager.oO000oO, ProductManager.xx0IXxxx0, ProductManager.OIIO0oIoO, ProductManager.ooX, ProductManager.xXOxII0xx, ProductManager.ooOxox0O0, ProductManager.OOO, ProductManager.XooooIO0, ProductManager.xXOoI, ProductManager.oxoxX0Oxo, ProductManager.XIIo, ProductManager.IO0, ProductManager.O0oo0o, ProductManager.IoXx, ProductManager.xO0xx0xxx, ProductManager.OxIX, ProductManager.IoIOXX, ProductManager.oI0xOX, ProductManager.OOXIxoX, ProductManager.IOx0XI0, ProductManager.oX0OXOXOo, ProductManager.IoXI, ProductManager.IXxoX0Ix, "AW37", ProductManager.oOII, ProductManager.Ioo0OxIo, ProductManager.oX0XO, ProductManager.Ix, ProductManager.xOO0X, ProductManager.oIx0, ProductManager.OxoOX0X0, ProductManager.oIOIO, ProductManager.OXOxXI, ProductManager.Ox0O0X, ProductManager.ooO00o, ProductManager.xIxxXXxx, ProductManager.xXO, ProductManager.XXOXXx, ProductManager.O00X, ProductManager.oxOoo, ProductManager.oI0xoXO, ProductManager.XIXIo0OX, ProductManager.oxI0, ProductManager.xXoOoxXIX, ProductManager.XOxxxx00X, ProductManager.IOXX00X, ProductManager.OIOO, ProductManager.o0Xo0XII, ProductManager.OxXIoIX, ProductManager.IoO, ProductManager.OoooxII, ProductManager.O0oXOX0XX, ProductManager.oIXx0o, ProductManager.XOoxOo0oX, ProductManager.x0x000, "X2", ProductManager.oXx0xxxX, ProductManager.O0OxXXox, ProductManager.IxoooIO0, ProductManager.IOoXX, ProductManager.xoO0X, ProductManager.OIXI, ProductManager.oIIOI, ProductManager.XoxXox, ProductManager.xo0XO, ProductManager.O0oXOX0XX, ProductManager.XxxIX, ProductManager.f20543oIX0o, ProductManager.o0x0XOXx, "S1", "S2", ProductManager.XXoo0, ProductManager.Iox, ProductManager.XOX0x0XO, ProductManager.I00I, ProductManager.oXOXo, ProductManager.X0XI, ProductManager.XI0, ProductManager.xoIooI0, ProductManager.OooOoX, ProductManager.xIX0XOOX, ProductManager.Ixox0x, ProductManager.OOox, ProductManager.XoO, ProductManager.xIOOoxxxO, ProductManager.Oo0oOO, ProductManager.I00oX, ProductManager.xXxIxo, ProductManager.xo000, ProductManager.XOX, ProductManager.OXxIOxox, ProductManager.IxoXx, ProductManager.X0IXX, ProductManager.IooOI0x, ProductManager.f20421OOOox, ProductManager.oO0XoIX, ProductManager.X0xXOX, "R16", ProductManager.x0o0O0Oo, ProductManager.xO0x, ProductManager.I0o0xoIIx, ProductManager.O0OO, ProductManager.OIo, ProductManager.IIIXXXII, "R7", ProductManager.xOoO0O0O, ProductManager.oXxOXxo0O, ProductManager.XxOIoXI, ProductManager.IoxoIIx, ProductManager.IooOO, ProductManager.I00I, ProductManager.OIX0oXO0o, ProductManager.IoXIOI0O, ProductManager.OOoxI, ProductManager.IoXOxx0o, ProductManager.o0XxxOIx, ProductManager.IIXxoXXox, ProductManager.OoOoxX0xo, ProductManager.XxI0, ProductManager.xo0OI, ProductManager.oooOX, ProductManager.IxXOO0o0, "R9", "WS001", ProductManager.oIxXOO, ProductManager.I0IoX00I, ProductManager.I0Xo, ProductManager.xOx0oO, ProductManager.O0XI00X0o, ProductManager.xX0xXooOO, ProductManager.O0IIO0, ProductManager.xoOxO0, ProductManager.I0X, ProductManager.OxoIO00, ProductManager.O0xOx0, ProductManager.oo0I0oI, ProductManager.xXxox, ProductManager.x0IOX0o, ProductManager.OxXO0oo, ProductManager.OoX, ProductManager.xoI, ProductManager.oOIxIIoI, ProductManager.II0XIox, ProductManager.IO0Xox, ProductManager.xo0xII0II, ProductManager.O0XX0IX, ProductManager.Xoo0, ProductManager.IxIOOxO, ProductManager.xxIOx, "A7", "G7 Talk PRO", ProductManager.oIIo0xX, ProductManager.XOIIOIx, ProductManager.Xo000XO0, ProductManager.oIO0X00, ProductManager.IIxO, ProductManager.xX0Oo, "R4", "GF03Pro", ProductManager.ooO0, ProductManager.oOXOxxoxO, ProductManager.O0I, ProductManager.OI0OIIo, ProductManager.oxIXXxXx0, ProductManager.oIOXxOI, ProductManager.IIxOxOx0, ProductManager.xoxX, "GF03Pro", ProductManager.o0XO, ProductManager.IxXxoIIO, "R3", ProductManager.xxXxI, ProductManager.oX0IoO, ProductManager.IXx0oOO, ProductManager.Ioo, ProductManager.xXoIx00, ProductManager.IXOXoIo0x, ProductManager.oxI0OxXoO, ProductManager.ooxooo, ProductManager.IoXIOXo, ProductManager.X0Ox, ProductManager.XxxXX0XO0, ProductManager.oXx0XOX0, ProductManager.IX0IO, ProductManager.xoxXoXO, ProductManager.IoIxoI, ProductManager.oxOII, ProductManager.O0xOXxxx, ProductManager.XIOxIIxxI, ProductManager.XXO, ProductManager.XIxI, ProductManager.OxI0000XO, ProductManager.XIOOX0, ProductManager.x0oo, ProductManager.o0xIXX, ProductManager.XIx0, ProductManager.xIxxxX0O, ProductManager.xXOOx, ProductManager.OoIO0OIX, ProductManager.XxoOX0I, "R21", "A8", ProductManager.o0OXIoI, ProductManager.IXXOI, ProductManager.IXXxOX00X, ProductManager.oxI0IX, ProductManager.oo0o, ProductManager.I0ox0, ProductManager.xx00OX, ProductManager.xXxx, ProductManager.OXxo, ProductManager.IoxOXXxXo, ProductManager.xoooOIO, ProductManager.ooIxOOoOo, ProductManager.OOXx, ProductManager.I0I0IoIXO, ProductManager.X0oO, ProductManager.IxxOIX, ProductManager.o0oo, ProductManager.oooIXI0o, ProductManager.OXX0xxo, ProductManager.IxX0, ProductManager.OO00, ProductManager.I00XxoO, ProductManager.XoOoxIIx, ProductManager.Xo0IXOO00, ProductManager.OOxIO, ProductManager.XoXOIx, ProductManager.Xx0I, ProductManager.OxXIO, ProductManager.XOo, "M6", ProductManager.XoI0, ProductManager.OXXo0, ProductManager.IxIoXOO, ProductManager.xoXI00O, ProductManager.Xxx0o0XI, "M3", ProductManager.XXI00xO, ProductManager.OXX, ProductManager.xIIOoXo, ProductManager.oIX, ProductManager.IOxOOIIO, ProductManager.x0OX, ProductManager.x0oXIXI, ProductManager.OOI00oxoO, ProductManager.oIXIXIxx0, ProductManager.Ix0XO, ProductManager.XXXoOII, ProductManager.xxXooOI, ProductManager.Xox0o, ProductManager.xXOXOOx, ProductManager.xxxIO, ProductManager.XXOO, ProductManager.OxIOX, ProductManager.oIO, ProductManager.O0XI0, ProductManager.oxOoIOX, ProductManager.x0X0OIOx, ProductManager.oooO0ox, ProductManager.oXIxoOo, ProductManager.o0ooO, ProductManager.x000OxX, ProductManager.XIX0Oo0, ProductManager.xxXI, ProductManager.oXOxO0XXo, ProductManager.xXXXxOOI0, ProductManager.xOIXxOo, ProductManager.XxX0xI, ProductManager.IoOoo0XXX, ProductManager.Ix0X0oxX, ProductManager.IoI);
        }
    });
    public static int X0o0O0x = 1;
    public static int X0XoO = 1;
    public static int x00xXx0o = 1;
    public static int oXXI0OO = 1;
    public static final int xIXoXOXx = 5;
    public static final int o0oxo0o0 = 5;

    @OOXIXo
    public static final X0IIOO o0O0Xx = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ArrayList<String>>() { // from class: com.sma.smartv3.ble.ProductManager$deviceBindingCopyWriting$2
        @Override // Oox.oIX0oI
        @OOXIXo
        public final ArrayList<String> invoke() {
            return CollectionsKt__CollectionsKt.Oxx0xo(BleDeviceInfo.PROTOTYPE_RN01);
        }
    });
    public static final int Oo0 = 1;

    /* loaded from: classes12.dex */
    public static final class oIX0oI extends TypeToken<HashMap<Integer, Integer>> {
    }

    public static /* synthetic */ boolean IXX(ProductManager productManager, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = productManager.IXxOIOO(i);
        }
        return productManager.OIxI0O(i, z);
    }

    public static /* synthetic */ void O0OoXI(ProductManager productManager, Activity activity, Bundle bundle, int i, Object obj) {
        if ((i & 2) != 0) {
            bundle = null;
        }
        productManager.oO0(activity, bundle);
    }

    public static /* synthetic */ boolean OXIOoo0X0(ProductManager productManager, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = BleCache.INSTANCE.getMBleName();
        }
        return productManager.IXoIo(str);
    }

    public static /* synthetic */ Pair XoIxOXIXo(ProductManager productManager, BleDeviceInfo bleDeviceInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            bleDeviceInfo = BleCache.INSTANCE.getMDeviceInfo();
            IIX0o.ooOOo0oXI(bleDeviceInfo);
        }
        return productManager.o0IXXIx(bleDeviceInfo);
    }

    public static /* synthetic */ boolean XxXX(ProductManager productManager, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = productManager.IXxOIOO(i);
        }
        return productManager.OooO0XOx(i, z);
    }

    public static /* synthetic */ int oO(ProductManager productManager, BleDeviceInfo bleDeviceInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            bleDeviceInfo = BleCache.INSTANCE.getMDeviceInfo();
            IIX0o.ooOOo0oXI(bleDeviceInfo);
        }
        return productManager.x0XOIxOo(bleDeviceInfo);
    }

    public static /* synthetic */ boolean xOOxIO(ProductManager productManager, BleDeviceInfo bleDeviceInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            bleDeviceInfo = BleCache.INSTANCE.getMDeviceInfo();
        }
        return productManager.O00(bleDeviceInfo);
    }

    public static /* synthetic */ boolean xOx(ProductManager productManager, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = productManager.IXxOIOO(i);
        }
        return productManager.o0oIxXOx(i, z);
    }

    public final boolean I0() {
        return BleCache.INSTANCE.getMDataKeys().contains(Integer.valueOf(BleKey.ECG.getMKey()));
    }

    public final boolean I00O() {
        if (BleCache.INSTANCE.getMSupportBloodOxyGenSet() == 1) {
            return true;
        }
        return false;
    }

    @oOoXoXO
    public final String I0Io() {
        return com.sma.smartv3.util.Xo0.f24349oIX0oI.XO().getString(XoI0Ixx0.f24480xOOOX);
    }

    public final void I0O00OI(int i) {
        oOoIxI0x = i;
    }

    public final boolean I0OO() {
        if (BleCache.INSTANCE.getMSupportNewsfeed() == 1) {
            return true;
        }
        return false;
    }

    public final int I0X0x0oIo() {
        return 1;
    }

    public final boolean I0oOIX() {
        BleCache bleCache = BleCache.INSTANCE;
        if (!IIX0o.Oxx0IOOO(bleCache.getMPlatform(), BleDeviceInfo.PLATFORM_NORDIC) && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), BleDeviceInfo.PROTOTYPE_R3Q) && oxxXoxO().isEmpty() && !IIX0o.Oxx0IOOO(bleCache.getMPlatform(), BleDeviceInfo.PLATFORM_JL) && !IIX0o.Oxx0IOOO(bleCache.getMPlatform(), BleDeviceInfo.PLATFORM_JL707) && !IIX0o.Oxx0IOOO(bleCache.getMPlatform(), BleDeviceInfo.PLATFORM_JL707LITE) && !IIX0o.Oxx0IOOO(bleCache.getMPlatform(), BleDeviceInfo.PLATFORM_SIFLI)) {
            return false;
        }
        return true;
    }

    public final int I0oOoX() {
        return IIX0o.Oxx0IOOO(BleCache.INSTANCE.getMPrototype(), BleDeviceInfo.PROTOTYPE_10G) ? 1 : 0;
    }

    @OOXIXo
    public final ArrayList<String> I0xX0() {
        return (ArrayList) IIOx.getValue();
    }

    public final boolean II0OOXOx() {
        return false;
    }

    public final int II0XooXoX() {
        return !xIx() ? 1 : 0;
    }

    public final int II0xO0(int i) {
        BleCache bleCache = BleCache.INSTANCE;
        if (IIX0o.Oxx0IOOO(bleCache.getMBleName(), "AF28") && IIX0o.Oxx0IOOO(bleCache.getMFirmwareFlag(), "AM28_AF28")) {
            return 4;
        }
        return i;
    }

    public final boolean IIIxO() {
        BleCache bleCache = BleCache.INSTANCE;
        if (IIX0o.Oxx0IOOO(bleCache.getMFirmwareFlag(), "JL09_A10TMini_bazik") || bleCache.getMSupportIncomingCallRing() != 1) {
            return false;
        }
        return true;
    }

    public final boolean IIOIX() {
        if (!xIx0XO() && XXoO0oX()) {
            return true;
        }
        return false;
    }

    public final boolean IIX0() {
        DeviceConfigInfo IOoo2 = IOoo();
        if (IOoo2 != null) {
            return oOXoIIIo.I0Io.II0xO0(IOoo2.getSupportNFC());
        }
        return false;
    }

    public final boolean IIX0o() {
        BleCache bleCache = BleCache.INSTANCE;
        String mPrototype = bleCache.getMPrototype();
        int hashCode = mPrototype.hashCode();
        if (hashCode != 2071) {
            if (hashCode != 73650) {
                if (hashCode == 2134106 && mPrototype.equals("F13B") && IIX0o.Oxx0IOOO(bleCache.getMBleName(), OxXIoIX)) {
                    return false;
                }
            } else if (mPrototype.equals(BleDeviceInfo.PROTOTYPE_K18) && (IIX0o.Oxx0IOOO(bleCache.getMFirmwareFlag(), "SmartWatch_AW12_W3_HR3301") || IIX0o.Oxx0IOOO(bleCache.getMFirmwareFlag(), "AW12_W3_FireBoltt"))) {
                return false;
            }
        } else if (mPrototype.equals("A8") && (IIX0o.Oxx0IOOO(bleCache.getMBleName(), xooXo) || IIX0o.Oxx0IOOO(bleCache.getMBleName(), xIOOIO))) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0053, code lost:
    
        if (r1.equals(com.szabh.smable3.entity.BleDeviceInfo.PROTOTYPE_AM22) == false) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006b, code lost:
    
        if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(r0.getMBleName(), com.sma.smartv3.ble.ProductManager.XxOx) == false) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x006d, code lost:
    
        return com.sma.smartv3.ble.ProductManager.ooxo0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:?, code lost:
    
        return 5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005d, code lost:
    
        if (r1.equals("AM05") == false) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00dc, code lost:
    
        if (r1.equals(com.szabh.smable3.entity.BleDeviceInfo.PROTOTYPE_F13) == false) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0016, code lost:
    
        if (r1.equals(com.szabh.smable3.entity.BleDeviceInfo.PROTOTYPE_F13J) == false) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x00df, code lost:
    
        return 3;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000b. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00f5 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int IIXOooo() {
        /*
            r4 = this;
            com.szabh.smable3.component.BleCache r0 = com.szabh.smable3.component.BleCache.INSTANCE
            java.lang.String r1 = r0.getMPrototype()
            int r2 = r1.hashCode()
            r3 = 5
            switch(r2) {
                case -1380743070: goto Le1;
                case -1380722878: goto Ld6;
                case 2224: goto Lbd;
                case 2623: goto L98;
                case 82485: goto L72;
                case 2011953: goto L57;
                case 2012012: goto L4d;
                case 2134105: goto L1a;
                case 2134114: goto L10;
                default: goto Le;
            }
        Le:
            goto Le9
        L10:
            java.lang.String r2 = "F13J"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto Ldf
            goto Le9
        L1a:
            java.lang.String r2 = "F13A"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L24
            goto Le9
        L24:
            java.lang.String r1 = r0.getMBleName()
            java.lang.String r2 = "Edyson 3"
            boolean r1 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r1, r2)
            if (r1 != 0) goto L48
            java.lang.String r1 = r0.getMBleName()
            java.lang.String r2 = "Edyson3"
            boolean r1 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r1, r2)
            if (r1 != 0) goto L48
            java.lang.String r0 = r0.getMBleName()
            java.lang.String r1 = "SENS5"
            boolean r0 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r0, r1)
            if (r0 == 0) goto Lf9
        L48:
            r3 = 5101520(0x4dd7d0, float:7.148752E-39)
            goto Lf9
        L4d:
            java.lang.String r2 = "AM22"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L61
            goto Le9
        L57:
            java.lang.String r2 = "AM05"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L61
            goto Le9
        L61:
            java.lang.String r0 = r0.getMBleName()
            java.lang.String r1 = "HK85"
            boolean r0 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r0, r1)
            if (r0 == 0) goto Lf9
            r3 = 510152030(0x1e684d5e, float:1.2297977E-20)
            goto Lf9
        L72:
            java.lang.String r2 = "T78"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L7c
            goto Le9
        L7c:
            java.lang.String r1 = r0.getMBleName()
            java.lang.String r2 = "AceFit"
            boolean r1 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r1, r2)
            if (r1 != 0) goto L94
            java.lang.String r0 = r0.getMBleName()
            java.lang.String r1 = "F7"
            boolean r0 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r0, r1)
            if (r0 == 0) goto Lf9
        L94:
            r3 = 581015(0x8dd97, float:8.14175E-40)
            goto Lf9
        L98:
            java.lang.String r2 = "S2"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto La1
            goto Le9
        La1:
            java.lang.String r1 = r0.getMFirmwareFlag()
            java.lang.String r2 = "S2_Girl"
            boolean r1 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r1, r2)
            if (r1 != 0) goto Lb9
            java.lang.String r0 = r0.getMFirmwareFlag()
            java.lang.String r1 = "S2_V2"
            boolean r0 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r0, r1)
            if (r0 == 0) goto Lf9
        Lb9:
            r3 = 51015(0xc747, float:7.1487E-41)
            goto Lf9
        Lbd:
            java.lang.String r2 = "F6"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto Lc6
            goto Le9
        Lc6:
            java.lang.String r0 = r0.getMBleName()
            java.lang.String r1 = "G5 TALK"
            boolean r0 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r0, r1)
            if (r0 == 0) goto Lf9
            r3 = 101520(0x18c90, float:1.4226E-40)
            goto Lf9
        Ld6:
            java.lang.String r2 = "SMA-F13"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto Ldf
            goto Le9
        Ldf:
            r3 = 3
            goto Lf9
        Le1:
            java.lang.String r2 = "SMA-10G"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto Lf8
        Le9:
            java.lang.String r0 = r0.getMPlatform()
            java.lang.String r1 = "MTK"
            boolean r0 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r0, r1)
            if (r0 == 0) goto Lf9
            r3 = 8
            goto Lf9
        Lf8:
            r3 = 0
        Lf9:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ble.ProductManager.IIXOooo():int");
    }

    public final void IIXOxIxOo(int i) {
        oXXxI = i;
    }

    public final boolean IIoX0OoI() {
        if (BleCache.INSTANCE.getMSupportReadPackageStatus() == 1) {
            return true;
        }
        return false;
    }

    public final boolean IIxOXoOo0() {
        BleCache bleCache = BleCache.INSTANCE;
        if (IIX0o.Oxx0IOOO(bleCache.getMBleName(), f20660xxX)) {
            return IIX0o.Oxx0IOOO(bleCache.getMFirmwareFlag(), "R8_r6_pro_EBOHR");
        }
        return true;
    }

    public final boolean IO() {
        DeviceConfigInfo IOoo2 = IOoo();
        if (IOoo2 != null) {
            return oOXoIIIo.I0Io.II0xO0(IOoo2.getAlarmWithTag());
        }
        return xXxxox0I();
    }

    public final ArrayList<String> IO0XoXxO() {
        return (ArrayList) III0I.getValue();
    }

    public final boolean IO0xX() {
        if (BleCache.INSTANCE.getMSupportSOSSet2() == 1) {
            return true;
        }
        return false;
    }

    public final boolean IOI(int i, @OOXIXo String platform) {
        IIX0o.x0xO0oo(platform, "platform");
        if (i != 10) {
            return false;
        }
        if (!xxx00() && !o0Xo(platform)) {
            return false;
        }
        return true;
    }

    public final boolean IOOXOOOOo() {
        if (BleCache.INSTANCE.getMSupportQrcode() == 1) {
            return true;
        }
        return false;
    }

    public final boolean IOOoXo0Ix() {
        return oXxOI0oIx().contains(BleCache.INSTANCE.getMFirmwareFlag());
    }

    public final boolean IOXOxOII() {
        if (BleCache.INSTANCE.getMSupportNotificationLightScreenSet() == 1) {
            return true;
        }
        return false;
    }

    public final boolean IOo0() {
        BleCache bleCache = BleCache.INSTANCE;
        if (IIX0o.Oxx0IOOO(bleCache.getMFirmwareFlag(), "AM10A_KUMI_KU7_L02A") || bleCache.getMSupportSetWatchPassword() != 1) {
            return false;
        }
        return true;
    }

    @oOoXoXO
    public final DeviceConfigInfo IOoo() {
        return (DeviceConfigInfo) new Gson().fromJson(com.sma.smartv3.util.Xo0.f24349oIX0oI.II0xO0().getString(DeviceConfigInfo.class.getName()), DeviceConfigInfo.class);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:3:0x0005 A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean IOooo0o(int r3) {
        /*
            r2 = this;
            r0 = 1
            r1 = 0
            switch(r3) {
                case 7: goto L20;
                case 8: goto L20;
                case 9: goto L20;
                case 12: goto L20;
                case 13: goto L20;
                case 16: goto L20;
                case 17: goto L20;
                case 18: goto L20;
                case 19: goto L20;
                case 20: goto L20;
                case 21: goto L1a;
                case 23: goto L20;
                case 25: goto L13;
                case 26: goto Lc;
                case 27: goto L20;
                case 33: goto L20;
                case 34: goto L20;
                case 37: goto L20;
                case 39: goto L20;
                case 40: goto L20;
                case 42: goto L20;
                case 43: goto L20;
                case 45: goto L20;
                case 46: goto L20;
                case 47: goto L7;
                case 49: goto L20;
                case 50: goto L20;
                case 51: goto L20;
                case 53: goto L20;
                case 61: goto L20;
                case 66: goto L20;
                case 88: goto L20;
                case 91: goto L20;
                case 92: goto L20;
                case 102: goto L20;
                case 105: goto L20;
                case 106: goto L20;
                default: goto L5;
            }
        L5:
            r0 = 0
            goto L20
        L7:
            boolean r0 = r2.xxx00()
            goto L20
        Lc:
            boolean r3 = r2.xxx00()
            if (r3 != 0) goto L5
            goto L20
        L13:
            boolean r3 = r2.xxx00()
            if (r3 != 0) goto L5
            goto L20
        L1a:
            boolean r3 = r2.xxx00()
            if (r3 != 0) goto L5
        L20:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ble.ProductManager.IOooo0o(int):boolean");
    }

    public final boolean IXI() {
        if (BleCache.INSTANCE.getMSupportWorldClock() == 1) {
            return true;
        }
        return false;
    }

    public final boolean IXIIo() {
        if (BleCache.INSTANCE.getMSupportWeather2() == 1) {
            return true;
        }
        return false;
    }

    public final boolean IXIxx0() {
        if (oXXI0OO == 1) {
            return true;
        }
        return false;
    }

    public final boolean IXO() {
        BleCache bleCache = BleCache.INSTANCE;
        if (!IIX0o.Oxx0IOOO(bleCache.getMPlatform(), BleDeviceInfo.PLATFORM_REALTEK)) {
            return true;
        }
        if (!IIX0o.Oxx0IOOO(bleCache.getMPrototype(), "R10") && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), "F7") && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), "F5") && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), "R9") && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), BleDeviceInfo.PROTOTYPE_R10PRO) && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), "R11") && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), "R11S") && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), "F6")) {
            return true;
        }
        return false;
    }

    public final boolean IXXIXx00I() {
        return false;
    }

    public final void IXo(int i) {
        oXXI0OO = i;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x01d7, code lost:
    
        if (r4.equals(com.sma.smartv3.ble.ProductManager.XIxOIII) == false) goto L454;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x01e1, code lost:
    
        if (r4.equals(com.sma.smartv3.ble.ProductManager.XOOoX0xo) == false) goto L454;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x01eb, code lost:
    
        if (r4.equals(com.sma.smartv3.ble.ProductManager.XxoOI00IX) == false) goto L454;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x01f5, code lost:
    
        if (r4.equals(com.sma.smartv3.ble.ProductManager.IIO0X0I) == false) goto L454;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x01ff, code lost:
    
        if (r4.equals(com.sma.smartv3.ble.ProductManager.O0OxXXox) == false) goto L454;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0209, code lost:
    
        if (r4.equals(com.sma.smartv3.ble.ProductManager.X0Ox) == false) goto L454;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0213, code lost:
    
        if (r4.equals(com.sma.smartv3.ble.ProductManager.Oox0oOO0) == false) goto L454;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x021d, code lost:
    
        if (r4.equals(com.sma.smartv3.ble.ProductManager.IOXX00X) == false) goto L454;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0227, code lost:
    
        if (r4.equals(com.sma.smartv3.ble.ProductManager.IxIXoo) == false) goto L454;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0231, code lost:
    
        if (r4.equals(com.sma.smartv3.ble.ProductManager.OIo0o) == false) goto L454;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x023b, code lost:
    
        if (r4.equals(com.sma.smartv3.ble.ProductManager.OIxOo0XI) == false) goto L454;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0245, code lost:
    
        if (r4.equals(com.sma.smartv3.ble.ProductManager.x0OX) == false) goto L454;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x024f, code lost:
    
        if (r4.equals(com.sma.smartv3.ble.ProductManager.O00oxX0) == false) goto L454;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0259, code lost:
    
        if (r4.equals(com.sma.smartv3.ble.ProductManager.xOo) == false) goto L454;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0263, code lost:
    
        if (r4.equals(com.sma.smartv3.ble.ProductManager.I0I0IoIXO) == false) goto L454;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0270, code lost:
    
        if (r4.equals(com.sma.smartv3.ble.ProductManager.OIOO) == false) goto L454;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x027a, code lost:
    
        if (r4.equals(com.sma.smartv3.ble.ProductManager.OOO) == false) goto L454;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x0284, code lost:
    
        if (r4.equals(com.sma.smartv3.ble.ProductManager.ooOIo) == false) goto L454;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x028d, code lost:
    
        if (r4.equals(com.sma.smartv3.ble.ProductManager.XoOoxI0X) == false) goto L454;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x0296, code lost:
    
        if (r4.equals(com.sma.smartv3.ble.ProductManager.oXOxox) == false) goto L454;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x029f, code lost:
    
        if (r4.equals(com.sma.smartv3.ble.ProductManager.OXOXxxOOO) == false) goto L454;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x02a8, code lost:
    
        if (r4.equals(com.sma.smartv3.ble.ProductManager.OX0xI0IO) == false) goto L454;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x02b1, code lost:
    
        if (r4.equals(com.sma.smartv3.ble.ProductManager.o0oo) == false) goto L454;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x02ba, code lost:
    
        if (r4.equals(com.sma.smartv3.ble.ProductManager.oXIOxo) == false) goto L454;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x02c3, code lost:
    
        if (r4.equals(com.sma.smartv3.ble.ProductManager.x0xoIx0) == false) goto L454;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x02cc, code lost:
    
        if (r4.equals(com.sma.smartv3.ble.ProductManager.XOxxxx00X) == false) goto L454;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x02d5, code lost:
    
        if (r4.equals(com.sma.smartv3.ble.ProductManager.xXoOoxXIX) == false) goto L454;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x02de, code lost:
    
        if (r4.equals(com.sma.smartv3.ble.ProductManager.oIXIXIxx0) == false) goto L454;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0046, code lost:
    
        if (r4.equals(com.sma.smartv3.ble.ProductManager.XO000) == false) goto L454;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0267, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0050, code lost:
    
        if (r4.equals(com.sma.smartv3.ble.ProductManager.oxI0) == false) goto L454;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005a, code lost:
    
        if (r4.equals(com.sma.smartv3.ble.ProductManager.oIx0) == false) goto L454;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0064, code lost:
    
        if (r4.equals(com.sma.smartv3.ble.ProductManager.X0oxOX) == false) goto L454;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006e, code lost:
    
        if (r4.equals(com.sma.smartv3.ble.ProductManager.O0OO) == false) goto L454;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0078, code lost:
    
        if (r4.equals(com.sma.smartv3.ble.ProductManager.Xx0O0O) == false) goto L454;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0082, code lost:
    
        if (r4.equals(com.sma.smartv3.ble.ProductManager.oO0o) == false) goto L454;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x008c, code lost:
    
        if (r4.equals(com.sma.smartv3.ble.ProductManager.oOXOxxoxO) == false) goto L454;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0096, code lost:
    
        if (r4.equals(com.sma.smartv3.ble.ProductManager.oo0oIoOIO) == false) goto L454;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00a0, code lost:
    
        if (r4.equals(com.sma.smartv3.ble.ProductManager.Ix0X0oxX) == false) goto L454;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00aa, code lost:
    
        if (r4.equals(com.sma.smartv3.ble.ProductManager.XoOo0Ooo0) == false) goto L454;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00b4, code lost:
    
        if (r4.equals(com.sma.smartv3.ble.ProductManager.Xoooo) == false) goto L454;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00be, code lost:
    
        if (r4.equals(com.sma.smartv3.ble.ProductManager.OoIO0OIX) == false) goto L454;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00c9, code lost:
    
        if (r4.equals(com.sma.smartv3.ble.ProductManager.o0xIXX) == false) goto L454;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00d3, code lost:
    
        if (r4.equals(com.sma.smartv3.ble.ProductManager.Xooo0Xx) == false) goto L454;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00dd, code lost:
    
        if (r4.equals(com.sma.smartv3.ble.ProductManager.xIIOoXo) == false) goto L454;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00e7, code lost:
    
        if (r4.equals(com.sma.smartv3.ble.ProductManager.IxxOIX) == false) goto L454;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00f1, code lost:
    
        if (r4.equals(com.sma.smartv3.ble.ProductManager.Xox0o) == false) goto L454;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00fb, code lost:
    
        if (r4.equals(com.sma.smartv3.ble.ProductManager.x0X0OIOx) == false) goto L454;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0105, code lost:
    
        if (r4.equals(com.sma.smartv3.ble.ProductManager.xX0) == false) goto L454;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x010f, code lost:
    
        if (r4.equals(com.sma.smartv3.ble.ProductManager.o00OI00) == false) goto L454;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0119, code lost:
    
        if (r4.equals(com.sma.smartv3.ble.ProductManager.X000ooOxx) == false) goto L454;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0123, code lost:
    
        if (r4.equals(com.sma.smartv3.ble.ProductManager.O0I) == false) goto L454;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x012d, code lost:
    
        if (r4.equals(com.sma.smartv3.ble.ProductManager.OI0xX) == false) goto L454;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0137, code lost:
    
        if (r4.equals(com.sma.smartv3.ble.ProductManager.IoxxXOO) == false) goto L454;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0141, code lost:
    
        if (r4.equals(com.sma.smartv3.ble.ProductManager.IIoOIO0) == false) goto L454;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x014b, code lost:
    
        if (r4.equals(com.sma.smartv3.ble.ProductManager.IIIxxOO) == false) goto L454;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0155, code lost:
    
        if (r4.equals(com.sma.smartv3.ble.ProductManager.XXI0XXo) == false) goto L454;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x015f, code lost:
    
        if (r4.equals(com.sma.smartv3.ble.ProductManager.xOoO0O0O) == false) goto L454;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0169, code lost:
    
        if (r4.equals(com.sma.smartv3.ble.ProductManager.oX0OXOXOo) == false) goto L454;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0173, code lost:
    
        if (r4.equals(com.sma.smartv3.ble.ProductManager.IIxOxOx0) == false) goto L454;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x017d, code lost:
    
        if (r4.equals(com.sma.smartv3.ble.ProductManager.ooIx) != false) goto L415;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0187, code lost:
    
        if (r4.equals(com.sma.smartv3.ble.ProductManager.XIxoOo0oI) == false) goto L454;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0191, code lost:
    
        if (r4.equals(com.sma.smartv3.ble.ProductManager.Ix0Xx) == false) goto L454;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x019b, code lost:
    
        if (r4.equals(com.sma.smartv3.ble.ProductManager.XxOx) == false) goto L454;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01a5, code lost:
    
        if (r4.equals(com.sma.smartv3.ble.ProductManager.xxI0x) == false) goto L454;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01af, code lost:
    
        if (r4.equals(com.sma.smartv3.ble.ProductManager.x0OI) == false) goto L454;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01b9, code lost:
    
        if (r4.equals(com.sma.smartv3.ble.ProductManager.IXIOOoxX) == false) goto L454;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01c3, code lost:
    
        if (r4.equals(com.sma.smartv3.ble.ProductManager.XoxoOo) == false) goto L454;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01cd, code lost:
    
        if (r4.equals(com.sma.smartv3.ble.ProductManager.xo0Io0Ooo) == false) goto L454;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean IXoIo(@OXOo.oOoXoXO java.lang.String r4) {
        /*
            Method dump skipped, instructions count: 1016
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ble.ProductManager.IXoIo(java.lang.String):boolean");
    }

    public final boolean IXxOIOO(int i) {
        switch (i) {
            case 7:
            case 9:
            case 10:
            case 12:
            case 13:
            case 19:
            case 21:
            case 28:
            case 29:
            case 30:
            case 33:
            case 50:
            case 51:
            case 63:
            case 81:
            case 84:
            case 86:
            case 89:
            case 96:
            case 97:
            case 98:
            case 100:
            case 101:
            case 109:
                return true;
            case 65:
                if (!xxx00()) {
                    return true;
                }
            default:
                return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00a9 A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean IXxxXO() {
        /*
            r31 = this;
            com.sma.smartv3.util.Xo0 r0 = com.sma.smartv3.util.Xo0.f24349oIX0oI
            com.blankj.utilcode.util.SPUtils r0 = r0.XO()
            com.sma.smartv3.model.AppUser r30 = new com.sma.smartv3.model.AppUser
            r1 = r30
            r28 = 67108863(0x3ffffff, float:1.5046327E-36)
            r29 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29)
            com.google.gson.Gson r1 = new com.google.gson.Gson
            r1.<init>()
            java.lang.Class<com.sma.smartv3.model.AppUser> r2 = com.sma.smartv3.model.AppUser.class
            java.lang.String r3 = r2.getName()
            java.lang.String r0 = r0.getString(r3)
            java.lang.Object r0 = r1.fromJson(r0, r2)
            if (r0 != 0) goto L4e
            goto L50
        L4e:
            r30 = r0
        L50:
            com.sma.smartv3.model.AppUser r30 = (com.sma.smartv3.model.AppUser) r30
            int r0 = r30.getGender()
            r1 = 0
            r2 = 1
            if (r0 != r2) goto Lc7
            com.szabh.smable3.component.BleCache r0 = com.szabh.smable3.component.BleCache.INSTANCE
            java.lang.String r3 = r0.getMBleName()
            int r4 = r3.hashCode()
            switch(r4) {
                case -1741633179: goto Lb4;
                case -1136913133: goto Lab;
                case 66171: goto L7c;
                case 1558014514: goto L68;
                default: goto L67;
            }
        L67:
            goto Lc7
        L68:
            java.lang.String r2 = "Watch4 mini"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L71
            goto Lc7
        L71:
            java.lang.String r0 = r0.getMFirmwareFlag()
            java.lang.String r1 = "V61_WATCH4_MINI"
            boolean r1 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r0, r1)
            goto Lc7
        L7c:
            java.lang.String r4 = "C80"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L85
            goto Lc7
        L85:
            java.lang.String r3 = r0.getMFirmwareFlag()
            java.lang.String r4 = "G6_C80"
            boolean r3 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r3, r4)
            if (r3 != 0) goto La9
            java.lang.String r3 = r0.getMFirmwareFlag()
            java.lang.String r4 = "G6_C80_V2"
            boolean r3 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r3, r4)
            if (r3 != 0) goto La9
            java.lang.String r0 = r0.getMFirmwareFlag()
            java.lang.String r3 = "G6_C80_V3"
            boolean r0 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r0, r3)
            if (r0 == 0) goto Lc7
        La9:
            r1 = 1
            goto Lc7
        Lab:
            java.lang.String r0 = "Swiss International"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto La9
            goto Lc7
        Lb4:
            java.lang.String r2 = "WATCH4"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto Lbd
            goto Lc7
        Lbd:
            java.lang.String r0 = r0.getMFirmwareFlag()
            java.lang.String r1 = "GT10PRO_WATCH4"
            boolean r1 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r0, r1)
        Lc7:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ble.ProductManager.IXxxXO():boolean");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:17:0x0035. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0028 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x011d A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0107 A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int Io() {
        /*
            Method dump skipped, instructions count: 454
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ble.ProductManager.Io():int");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final boolean IoIOOxIIo() {
        if (IxI()) {
            BleCache bleCache = BleCache.INSTANCE;
            String mPlatform = bleCache.getMPlatform();
            switch (mPlatform.hashCode()) {
                case -1549651556:
                    if (mPlatform.equals(BleDeviceInfo.PLATFORM_REALTEK)) {
                        return true;
                    }
                    break;
                case 2370:
                    if (mPlatform.equals(BleDeviceInfo.PLATFORM_JL)) {
                        return true;
                    }
                    break;
                case 76676:
                    if (mPlatform.equals(BleDeviceInfo.PLATFORM_MTK) && (IIX0o.Oxx0IOOO(bleCache.getMBleName(), f20443OooO0XOx) || IIX0o.Oxx0IOOO(bleCache.getMBleName(), f20652xx0))) {
                        return true;
                    }
                    break;
                case 70659068:
                    if (mPlatform.equals(BleDeviceInfo.PLATFORM_JL707)) {
                        return true;
                    }
                    break;
                case 78896685:
                    if (mPlatform.equals(BleDeviceInfo.PLATFORM_SIFLI)) {
                        return true;
                    }
                    break;
                case 1697379018:
                    if (mPlatform.equals(BleDeviceInfo.PLATFORM_JL707LITE)) {
                        return true;
                    }
                    break;
            }
        } else {
            String mPrototype = BleCache.INSTANCE.getMPrototype();
            int hashCode = mPrototype.hashCode();
            if (hashCode == 2623 ? !mPrototype.equals("S2") : hashCode == 68895 ? !mPrototype.equals("F2K") : !(hashCode == 2410926 && mPrototype.equals("NY58"))) {
                if (!xIx() || !xxxI()) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:297:0x0073 A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean IoOoX() {
        /*
            Method dump skipped, instructions count: 1424
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ble.ProductManager.IoOoX():boolean");
    }

    public final int IoOoo() {
        return o0oxo0o0;
    }

    public final boolean IoX() {
        if (IIX0o.Oxx0IOOO(BleCache.INSTANCE.getMPrototype(), BleDeviceInfo.PROTOTYPE_AM22)) {
            return true;
        }
        return xOOxIO(this, null, 1, null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b7 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:5:0x00b9 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean IoXIXo() {
        /*
            r2 = this;
            com.szabh.smable3.component.BleCache r0 = com.szabh.smable3.component.BleCache.INSTANCE
            java.lang.String r0 = r0.getMBleName()
            int r1 = r0.hashCode()
            switch(r1) {
                case -1812308561: goto Laf;
                case -1787781584: goto La6;
                case -1581529391: goto L9d;
                case -1575689774: goto L94;
                case -1362187409: goto L8b;
                case -1190224620: goto L82;
                case -1087173636: goto L79;
                case 2599: goto L70;
                case 2134123: goto L67;
                case 2468457: goto L5e;
                case 38015379: goto L55;
                case 72856961: goto L4b;
                case 277734348: goto L41;
                case 403224033: goto L37;
                case 1209049054: goto L2d;
                case 1680621744: goto L23;
                case 1833239668: goto L19;
                case 1968815724: goto Lf;
                default: goto Ld;
            }
        Ld:
            goto Lb7
        Lf:
            java.lang.String r1 = "BSW013"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto Lb9
            goto Lb7
        L19:
            java.lang.String r1 = "SPACEFIT_"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto Lb9
            goto Lb7
        L23:
            java.lang.String r1 = "Kronos X2"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto Lb7
            goto Lb9
        L2d:
            java.lang.String r1 = "R10 Pro"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto Lb9
            goto Lb7
        L37:
            java.lang.String r1 = "PRIMIA_"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto Lb9
            goto Lb7
        L41:
            java.lang.String r1 = "MERCURY_"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto Lb9
            goto Lb7
        L4b:
            java.lang.String r1 = "M9030"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto Lb9
            goto Lb7
        L55:
            java.lang.String r1 = "CONEKT Race 1i"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto Lb9
            goto Lb7
        L5e:
            java.lang.String r1 = "PW13"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto Lb9
            goto Lb7
        L67:
            java.lang.String r1 = "F13S"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto Lb9
            goto Lb7
        L70:
            java.lang.String r1 = "R9"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto Lb9
            goto Lb7
        L79:
            java.lang.String r1 = "Monster ET1"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto Lb9
            goto Lb7
        L82:
            java.lang.String r1 = "Urban 2X"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto Lb9
            goto Lb7
        L8b:
            java.lang.String r1 = "SPECTRE AMO"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto Lb9
            goto Lb7
        L94:
            java.lang.String r1 = "TICK-R1A"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto Lb9
            goto Lb7
        L9d:
            java.lang.String r1 = "TRXF-002"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto Lb9
            goto Lb7
        La6:
            java.lang.String r1 = "TX_WA9V1_"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto Lb9
            goto Lb7
        Laf:
            java.lang.String r1 = "Spark Watch V1"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto Lb9
        Lb7:
            r0 = 0
            goto Lba
        Lb9:
            r0 = 1
        Lba:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ble.ProductManager.IoXIXo():boolean");
    }

    public final boolean IoXO0XoX() {
        if (BleCache.INSTANCE.getMSupportPowerSaveMode() == 1) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000a. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0034 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:5:0x0037 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0029 A[RETURN, SYNTHETIC] */
    @OXOo.OOXIXo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String IoxOx() {
        /*
            r2 = this;
            com.szabh.smable3.component.BleCache r0 = com.szabh.smable3.component.BleCache.INSTANCE
            java.lang.String r0 = r0.getMFirmwareFlag()
            int r1 = r0.hashCode()
            switch(r1) {
                case -1861407550: goto L2c;
                case -1441684849: goto L20;
                case -846744416: goto L17;
                case 62930663: goto Le;
                default: goto Ld;
            }
        Ld:
            goto L34
        Le:
            java.lang.String r1 = "WSQ_GR_1"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L37
            goto L34
        L17:
            java.lang.String r1 = "AM05_AURAFIT"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L29
            goto L34
        L20:
            java.lang.String r1 = "F34_WSQ_GT"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L29
            goto L34
        L29:
            java.lang.String r0 = "openAIService"
            goto L39
        L2c:
            java.lang.String r1 = "KW17_WSQ_GR"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L37
        L34:
            java.lang.String r0 = ""
            goto L39
        L37:
            java.lang.String r0 = "ChatGpt"
        L39:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ble.ProductManager.IoxOx():java.lang.String");
    }

    public final boolean IoxX() {
        if (BleCache.INSTANCE.getMSupportWearWay() == 1) {
            return true;
        }
        return false;
    }

    public final boolean Ioxxx() {
        return false;
    }

    public final boolean Ix0() {
        String mPrototype = BleCache.INSTANCE.getMPrototype();
        int hashCode = mPrototype.hashCode();
        if (hashCode == 2623 ? mPrototype.equals("S2") : !(hashCode == 68895 ? !mPrototype.equals("F2K") : !(hashCode == 2410926 && mPrototype.equals("NY58")))) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0087 A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean Ix00oIoI() {
        /*
            Method dump skipped, instructions count: 512
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ble.ProductManager.Ix00oIoI():boolean");
    }

    @OOXIXo
    public final String Ix0x() {
        String supCreate;
        AppConfigInfo XI2 = XI();
        if (XI2 == null || (supCreate = XI2.getSupCreate()) == null) {
            return "0";
        }
        return supCreate;
    }

    public final boolean IxI() {
        BleCache bleCache = BleCache.INSTANCE;
        if (bleCache.getMClassicAddress().length() > 0 && !IIX0o.Oxx0IOOO(bleCache.getMClassicAddress(), "FF:FF:FF:FF:FF:FF") && !IIX0o.Oxx0IOOO(bleCache.getMClassicAddress(), DeviceState.INVALID_ADDRESS)) {
            return true;
        }
        return false;
    }

    public final boolean IxIX0I() {
        return !IIX0o.Oxx0IOOO(BleCache.INSTANCE.getMFirmwareFlag(), "K10_Argom");
    }

    public final boolean IxIo() {
        boolean Oxx0IOOO2;
        String mPrototype = BleCache.INSTANCE.getMPrototype();
        if (IIX0o.Oxx0IOOO(mPrototype, "X5L")) {
            Oxx0IOOO2 = true;
        } else {
            Oxx0IOOO2 = IIX0o.Oxx0IOOO(mPrototype, "X6");
        }
        return !Oxx0IOOO2;
    }

    public final boolean IxO0Oxo() {
        if (BleCache.INSTANCE.getMSupportNoDisturbSet2() == 1) {
            return true;
        }
        return false;
    }

    public final void IxOXOxO(int i) {
        xoOOIooI = i;
    }

    public final boolean IxX00() {
        String str;
        MacConfig macConfig;
        DeviceConfigInfo IOoo2 = IOoo();
        if (IOoo2 != null && (macConfig = IOoo2.getMacConfig()) != null) {
            str = macConfig.getAiModelService();
        } else {
            str = null;
        }
        return IIX0o.Oxx0IOOO(str, "openAIService");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x001e. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:9:0x004d A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean O0() {
        /*
            r3 = this;
            com.szabh.smable3.component.BleCache r0 = com.szabh.smable3.component.BleCache.INSTANCE
            java.util.List r1 = r0.getMDataKeys()
            com.szabh.smable3.BleKey r2 = com.szabh.smable3.BleKey.TEMPERATURE
            int r2 = r2.getMKey()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            boolean r1 = r1.contains(r2)
            if (r1 == 0) goto L5b
            java.lang.String r1 = r0.getMBleName()
            int r2 = r1.hashCode()
            switch(r2) {
                case -2134349300: goto L58;
                case -1408821114: goto L55;
                case -1408821112: goto L4f;
                case 69042: goto L38;
                case 419746052: goto L22;
                default: goto L21;
            }
        L21:
            goto L5b
        L22:
            java.lang.String r2 = "Gizmore 953"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L2b
            goto L5b
        L2b:
            java.lang.String r0 = r0.getMFirmwareFlag()
            java.lang.String r1 = "GIZFIT_953"
            boolean r0 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r0, r1)
            if (r0 != 0) goto L5b
            goto L4d
        L38:
            java.lang.String r2 = "F7C"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L41
            goto L5b
        L41:
            java.lang.String r0 = r0.getMFirmwareFlag()
            java.lang.String r1 = "F7C_notemperature"
            boolean r0 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r0, r1)
            if (r0 != 0) goto L5b
        L4d:
            r0 = 1
            goto L5c
        L4f:
            java.lang.String r0 = "OLIKE OW-W4"
        L51:
            r1.equals(r0)
            goto L5b
        L55:
            java.lang.String r0 = "OLIKE OW-W2"
            goto L51
        L58:
            java.lang.String r0 = "IK-W55"
            goto L51
        L5b:
            r0 = 0
        L5c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ble.ProductManager.O0():boolean");
    }

    public final boolean O00(@oOoXoXO BleDeviceInfo bleDeviceInfo) {
        String str;
        int hashCode;
        if (bleDeviceInfo != null) {
            str = bleDeviceInfo.getMPrototype();
        } else {
            str = null;
        }
        if (str != null && ((hashCode = str.hashCode()) == 2778 ? str.equals("X2") : hashCode == 2779 ? str.equals("X3") : hashCode == 2782 ? str.equals("X6") : hashCode == 86287 && str.equals("X5L"))) {
            return true;
        }
        return false;
    }

    public final int O00XxXI() {
        return Oo0;
    }

    public final boolean O0IoXXOx() {
        BleCache bleCache = BleCache.INSTANCE;
        String mBleName = bleCache.getMBleName();
        switch (mBleName.hashCode()) {
            case -2090704072:
                if (mBleName.equals(IIIXXXII)) {
                    return false;
                }
                break;
            case -2051999760:
                if (mBleName.equals(oIO0oIOO)) {
                    return false;
                }
                break;
            case -1938751886:
                if (mBleName.equals("Ultima classic")) {
                    return false;
                }
                break;
            case -1937739972:
                if (mBleName.equals("RIMLO-RS1")) {
                    return false;
                }
                break;
            case -1926556112:
                if (mBleName.equals("PS-WT7")) {
                    return false;
                }
                break;
            case -1924617913:
                if (mBleName.equals("Kratos Octane Pro")) {
                    return false;
                }
                break;
            case -1904191851:
                if (mBleName.equals("R-5010")) {
                    return false;
                }
                break;
            case -1884144381:
                if (mBleName.equals("RBK-QB")) {
                    return false;
                }
                break;
            case -1873277441:
                if (mBleName.equals(oXIOxo)) {
                    return false;
                }
                break;
            case -1870615379:
                if (mBleName.equals(OxXIO)) {
                    return false;
                }
                break;
            case -1868768337:
                if (mBleName.equals(o0oo)) {
                    return false;
                }
                break;
            case -1792442115:
                if (mBleName.equals("jbtx801")) {
                    return false;
                }
                break;
            case -1792442114:
                if (mBleName.equals("jbtx802")) {
                    return false;
                }
                break;
            case -1762929843:
                if (mBleName.equals("VIRGIN")) {
                    return false;
                }
                break;
            case -1759163808:
                if (mBleName.equals(Xxo)) {
                    return false;
                }
                break;
            case -1701230573:
                if (mBleName.equals("XO-J10")) {
                    return false;
                }
                break;
            case -1649216008:
                if (mBleName.equals(OXOXxxOOO)) {
                    return false;
                }
                break;
            case -1649216007:
                if (mBleName.equals(oXOxox)) {
                    return false;
                }
                break;
            case -1649216006:
                if (mBleName.equals(XoOoxI0X)) {
                    return false;
                }
                break;
            case -1649216004:
                if (mBleName.equals(OOO)) {
                    return false;
                }
                break;
            case -1632414290:
                if (mBleName.equals("Alewa Strike")) {
                    return false;
                }
                break;
            case -1504351997:
                if (mBleName.equals(I0XIOxXXX)) {
                    return false;
                }
                break;
            case -1252611329:
                if (mBleName.equals(oIX)) {
                    return false;
                }
                break;
            case -1149135068:
                if (mBleName.equals(oxI0IX)) {
                    return false;
                }
                break;
            case -1149020151:
                if (mBleName.equals(O00oxX0)) {
                    return false;
                }
                break;
            case -1074728796:
                if (mBleName.equals("GARETT_LOVE")) {
                    return false;
                }
                break;
            case -990077042:
                if (mBleName.equals(OIxOo0XI)) {
                    return false;
                }
                break;
            case -951758312:
                if (mBleName.equals("Mypower M707")) {
                    return false;
                }
                break;
            case -915442320:
                if (mBleName.equals("GT4mini-HK42")) {
                    return false;
                }
                break;
            case -876477048:
                if (mBleName.equals(OIo0o)) {
                    return false;
                }
                break;
            case -806223987:
                if (mBleName.equals(XOIIOIx)) {
                    return false;
                }
                break;
            case -785038163:
                if (mBleName.equals("K-Watch")) {
                    return false;
                }
                break;
            case -692412266:
                if (mBleName.equals("GEKO WATCHG")) {
                    return false;
                }
                break;
            case -633435991:
                if (mBleName.equals(IxIXoo)) {
                    return false;
                }
                break;
            case -497651036:
                if (mBleName.equals("Enigma X700")) {
                    return false;
                }
                break;
            case -430291988:
                if (mBleName.equals("TOG2002")) {
                    return false;
                }
                break;
            case -376969206:
                if (mBleName.equals(Oox0oOO0)) {
                    return false;
                }
                break;
            case -327275269:
                if (mBleName.equals("XO-Watch4")) {
                    return false;
                }
                break;
            case -204071929:
                if (mBleName.equals(XxOOX)) {
                    return false;
                }
                break;
            case -176549922:
                if (mBleName.equals("OG PEARL")) {
                    return false;
                }
                break;
            case -176362336:
                if (mBleName.equals("VL41 PRO")) {
                    return false;
                }
                break;
            case -34846468:
                if (mBleName.equals("KICK NEKXA NEBULA")) {
                    return false;
                }
                break;
            case 2595:
                if (mBleName.equals("R5")) {
                    return false;
                }
                break;
            case 2662:
                if (mBleName.equals("SY")) {
                    return false;
                }
                break;
            case 65590:
                if (mBleName.equals("BD8")) {
                    return false;
                }
                break;
            case 67168:
                if (mBleName.equals("D95")) {
                    return false;
                }
                break;
            case 67171:
                if (mBleName.equals("D98")) {
                    return false;
                }
                break;
            case 71569:
                if (mBleName.equals(XxoOI00IX)) {
                    return false;
                }
                break;
            case 76653:
                if (mBleName.equals("MT4")) {
                    return false;
                }
                break;
            case 84463:
                if (mBleName.equals(XOOoX0xo)) {
                    return false;
                }
                break;
            case 85711:
                if (mBleName.equals("WAY")) {
                    return false;
                }
                break;
            case 86205:
                if (mBleName.equals("X38")) {
                    return false;
                }
                break;
            case 86355:
                if (mBleName.equals(o0I0O0oXX)) {
                    return false;
                }
                break;
            case 87101:
                if (mBleName.equals("Y15")) {
                    return false;
                }
                break;
            case 87102:
                if (mBleName.equals("Y16")) {
                    return false;
                }
                break;
            case 87104:
                if (mBleName.equals("Y18")) {
                    return false;
                }
                break;
            case 87127:
                if (mBleName.equals("Y20")) {
                    return false;
                }
                break;
            case 87128:
                if (mBleName.equals("Y21")) {
                    return false;
                }
                break;
            case 2040905:
                if (mBleName.equals(XXoOOO0I)) {
                    return false;
                }
                break;
            case 2040942:
                if (mBleName.equals(xo0Io0Ooo)) {
                    return false;
                }
                break;
            case 2083218:
                if (mBleName.equals("CXT1")) {
                    return false;
                }
                break;
            case 2083223:
                if (mBleName.equals("CXT6")) {
                    return false;
                }
                break;
            case 2083224:
                if (mBleName.equals("CXT7")) {
                    return false;
                }
                break;
            case 2083225:
                if (mBleName.equals("CXT8")) {
                    return false;
                }
                break;
            case 2083226:
                if (mBleName.equals("CXT9")) {
                    return false;
                }
                break;
            case 2109688:
                if (mBleName.equals("DUEL")) {
                    return false;
                }
                break;
            case 2182298:
                if (mBleName.equals("GD85")) {
                    return false;
                }
                break;
            case 2218626:
                if (mBleName.equals(OOoxI)) {
                    return false;
                }
                break;
            case 2218631:
                if (mBleName.equals(oo00Io)) {
                    return false;
                }
                break;
            case 2218687:
                if (mBleName.equals(xxI0x)) {
                    return false;
                }
                break;
            case 2218688:
                if (mBleName.equals("HK41")) {
                    return false;
                }
                break;
            case 2218689:
                if (mBleName.equals("HK42")) {
                    return false;
                }
                break;
            case 2218816:
                if (mBleName.equals(XxOx)) {
                    return false;
                }
                break;
            case 2218820:
                if (mBleName.equals(Ix0Xx)) {
                    return false;
                }
                break;
            case 2218842:
                if (mBleName.equals(XIxoOo0oI)) {
                    return false;
                }
                break;
            case 2218847:
                if (mBleName.equals(ooIx)) {
                    return false;
                }
                break;
            case 2218850:
                if (mBleName.equals(IIxOxOx0)) {
                    return false;
                }
                break;
            case 2222509:
                if (mBleName.equals("Glow")) {
                    return false;
                }
                break;
            case 2241657:
                if (mBleName.equals("ICON")) {
                    return false;
                }
                break;
            case 2309898:
                if (mBleName.equals("KM19")) {
                    return false;
                }
                break;
            case 2543446:
                if (mBleName.equals(IIOXx)) {
                    return false;
                }
                break;
            case 6424303:
                if (mBleName.equals("Spovan Apeiron")) {
                    return false;
                }
                break;
            case 18769481:
                if (mBleName.equals("HOCO BD8")) {
                    return false;
                }
                break;
            case 18790992:
                if (mBleName.equals(XXI0XXo)) {
                    return false;
                }
                break;
            case 63894869:
                if (mBleName.equals("CAT98")) {
                    return false;
                }
                break;
            case 64579806:
                if (mBleName.equals("CXT10")) {
                    return false;
                }
                break;
            case 67010470:
                if (mBleName.equals(x0IOX0o)) {
                    return false;
                }
                break;
            case 68779269:
                if (mBleName.equals("HK4-A")) {
                    return false;
                }
                break;
            case 72856970:
                if (mBleName.equals(I0o0xoIIx)) {
                    return false;
                }
                break;
            case 73133668:
                if (mBleName.equals(OI0xX)) {
                    return false;
                }
                break;
            case 73288579:
                if (mBleName.equals(O0I)) {
                    return false;
                }
                break;
            case 74224372:
                if (mBleName.equals("NH-01")) {
                    return false;
                }
                break;
            case 74229425:
                if (mBleName.equals("Mento")) {
                    return false;
                }
                break;
            case 74945121:
                if (mBleName.equals(xoIooI0)) {
                    return false;
                }
                break;
            case 76320997:
                if (mBleName.equals(oxIIOOX)) {
                    return false;
                }
                break;
            case 79329241:
                if (mBleName.equals("SWW17")) {
                    return false;
                }
                break;
            case 79329242:
                if (mBleName.equals("SWW18")) {
                    return false;
                }
                break;
            case 83668929:
                if (mBleName.equals(xX0)) {
                    return false;
                }
                break;
            case 83668930:
                if (mBleName.equals(x0X0OIOx)) {
                    return false;
                }
                break;
            case 83668932:
                if (mBleName.equals(Xox0o)) {
                    return false;
                }
                break;
            case 83668933:
                if (mBleName.equals(IxxOIX)) {
                    return false;
                }
                break;
            case 118761308:
                if (mBleName.equals("Ultima magnum E400")) {
                    return false;
                }
                break;
            case 118762269:
                if (mBleName.equals("Ultima magnum E500")) {
                    return false;
                }
                break;
            case 180091524:
                if (mBleName.equals("COMMANDO")) {
                    return false;
                }
                break;
            case 348838840:
                if (mBleName.equals(xIIOoXo)) {
                    return false;
                }
                break;
            case 348838869:
                if (mBleName.equals("MOJU J20")) {
                    return false;
                }
                break;
            case 355581457:
                if (mBleName.equals("GEKO WATCH 3 PRO")) {
                    return false;
                }
                break;
            case 374434003:
                if (mBleName.equals(oX0oO)) {
                    return false;
                }
                break;
            case 406302539:
                if (mBleName.equals("PS-WT15")) {
                    return false;
                }
                break;
            case 428497841:
                if (mBleName.equals("HK89 PRO")) {
                    return false;
                }
                break;
            case 514667848:
                if (mBleName.equals(O0IX)) {
                    return false;
                }
                break;
            case 538490060:
                if (mBleName.equals("G-FRC GS-60")) {
                    return false;
                }
                break;
            case 545084177:
                if (mBleName.equals(OOXx)) {
                    return false;
                }
                break;
            case 602400330:
                if (mBleName.equals("T-Fit 430 A")) {
                    return false;
                }
                break;
            case 602467600:
                if (mBleName.equals("T-Fit 458 A")) {
                    return false;
                }
                break;
            case 609728304:
                if (mBleName.equals("Watch 10")) {
                    return false;
                }
                break;
            case 654300678:
                if (mBleName.equals("XO-GT4 mini")) {
                    return false;
                }
                break;
            case 697026626:
                if (mBleName.equals("BLP5254")) {
                    return false;
                }
                break;
            case 697387017:
                if (mBleName.equals("V92plus")) {
                    return false;
                }
                break;
            case 789318807:
                if (mBleName.equals(XoOo0Ooo0)) {
                    return false;
                }
                break;
            case 967095973:
                if (mBleName.equals("RONIN WATCH")) {
                    return false;
                }
                break;
            case 988610958:
                if (mBleName.equals("Madvell Frontier")) {
                    return false;
                }
                break;
            case 1044475326:
                if (mBleName.equals("GT4mini")) {
                    return false;
                }
                break;
            case 1056021741:
                if (mBleName.equals("t-fit 335")) {
                    return false;
                }
                break;
            case 1102107269:
                if (mBleName.equals("iWatch10")) {
                    return false;
                }
                break;
            case 1232131037:
                if (mBleName.equals(IooOox)) {
                    return false;
                }
                break;
            case 1258458523:
                if (mBleName.equals("Zedx z4")) {
                    return false;
                }
                break;
            case 1313613390:
                if (mBleName.equals("SIA SW-8002")) {
                    return false;
                }
                break;
            case 1363330879:
                if (mBleName.equals(oxOII)) {
                    return false;
                }
                break;
            case 1378453521:
                if (mBleName.equals("Axon Clever")) {
                    return false;
                }
                break;
            case 1430385123:
                if (mBleName.equals("DEFENDER")) {
                    return false;
                }
                break;
            case 1490462776:
                if (mBleName.equals(oIOXxOI)) {
                    return false;
                }
                break;
            case 1560128293:
                if (mBleName.equals("HML-II Snore Arrester")) {
                    return false;
                }
                break;
            case 1586130016:
                if (mBleName.equals("Pepsi Watch")) {
                    return false;
                }
                break;
            case 1653415113:
                if (mBleName.equals("RS TEMPO PRO")) {
                    return false;
                }
                break;
            case 1721068336:
                if (mBleName.equals("RBK-SBQ")) {
                    return false;
                }
                break;
            case 1737813868:
                if (mBleName.equals(O0OO)) {
                    return false;
                }
                break;
            case 1743043177:
                if (mBleName.equals("VS43 PRO")) {
                    return false;
                }
                break;
            case 1772781487:
                if (mBleName.equals(O0XOI)) {
                    return false;
                }
                break;
            case 1885090075:
                if (mBleName.equals(oO0XoIX)) {
                    return false;
                }
                break;
            case 1885090076:
                if (mBleName.equals("RONIN WATCH R-013")) {
                    return false;
                }
                break;
            case 1885090077:
                if (mBleName.equals("RONIN WATCH R-014")) {
                    return false;
                }
                break;
            case 1950915614:
                if (mBleName.equals(o0ooO)) {
                    return false;
                }
                break;
            case 2013050634:
                if (mBleName.equals("DESIRE")) {
                    return false;
                }
                break;
            case 2029466514:
                if (mBleName.equals("TimeSqr-8")) {
                    return false;
                }
                break;
            case 2098545930:
                if (mBleName.equals(Ixox0x)) {
                    return false;
                }
                break;
            case 2111874118:
                if (mBleName.equals("GT4PRO")) {
                    return false;
                }
                break;
            case 2123848235:
                if (mBleName.equals(XO000)) {
                    return false;
                }
                break;
            case 2132101046:
                if (mBleName.equals("HK21-A")) {
                    return false;
                }
                break;
            case 2132340535:
                if (mBleName.equals(xXOXOOx)) {
                    return false;
                }
                break;
        }
        String mFirmwareFlag = bleCache.getMFirmwareFlag();
        switch (mFirmwareFlag.hashCode()) {
            case -1117094443:
                if (mFirmwareFlag.equals("AC02_HK95_S5_PRO")) {
                    return false;
                }
                break;
            case -343535378:
                if (mFirmwareFlag.equals("HK4_6_POWER")) {
                    return false;
                }
                break;
            case -106276009:
                if (mFirmwareFlag.equals("V61_HK39_ROMANCE")) {
                    return false;
                }
                break;
            case -87041003:
                if (mFirmwareFlag.equals("HK89_ZFB_R5_PRO")) {
                    return false;
                }
                break;
            case 68780806:
                if (mFirmwareFlag.equals("HK4_4")) {
                    return false;
                }
                break;
            case 444840799:
                if (mFirmwareFlag.equals("JX621D_S2015_HK21_S3_PRO")) {
                    return false;
                }
                break;
            case 1265597758:
                if (mFirmwareFlag.equals("JL_PULSE02")) {
                    return false;
                }
                break;
        }
        DeviceConfigInfo IOoo2 = IOoo();
        if (IOoo2 == null || IOoo2.getSupWarnTipGuide() != 0) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:52:0x002e A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean O0IxXx() {
        /*
            r5 = this;
            com.szabh.smable3.component.BleCache r0 = com.szabh.smable3.component.BleCache.INSTANCE
            java.lang.String r1 = r0.getMPrototype()
            int r2 = r1.hashCode()
            r3 = 0
            r4 = 1
            switch(r2) {
                case -1845654391: goto L5a;
                case -1777888780: goto L51;
                case 2225: goto L3b;
                case 70326: goto L31;
                case 73650: goto L19;
                case 147328027: goto L10;
                default: goto Lf;
            }
        Lf:
            goto L62
        L10:
            java.lang.String r0 = "SMA-GTM5"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto Ld1
            goto L62
        L19:
            java.lang.String r2 = "K18"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L22
            goto L62
        L22:
            java.lang.String r0 = r0.getMFirmwareFlag()
            java.lang.String r1 = "CY30_WATCH3_V4_PRO"
            boolean r0 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r0, r1)
            if (r0 != 0) goto Ld1
        L2e:
            r3 = 1
            goto Ld1
        L31:
            java.lang.String r0 = "GB1"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L2e
            goto Ld1
        L3b:
            java.lang.String r2 = "F7"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L44
            goto L62
        L44:
            java.lang.String r0 = r0.getMBleName()
            java.lang.String r1 = "eDiary Watch 1"
            boolean r0 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r0, r1)
            if (r0 != 0) goto Ld1
            goto L2e
        L51:
            java.lang.String r0 = "R6_PRO_DK"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto Ld1
            goto L62
        L5a:
            java.lang.String r2 = "SMA-R5"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L63
        L62:
            goto L2e
        L63:
            java.lang.String r1 = r0.getMBleName()
            java.lang.String r2 = "R6"
            boolean r1 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r1, r2)
            if (r1 != 0) goto Ld1
            java.lang.String r1 = r0.getMBleName()
            java.lang.String r2 = "R6 Pro"
            boolean r1 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r1, r2)
            if (r1 != 0) goto Ld1
            java.lang.String r1 = r0.getMBleName()
            java.lang.String r2 = "KUMI K17"
            boolean r1 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r1, r2)
            if (r1 != 0) goto Ld1
            java.lang.String r1 = r0.getMBleName()
            java.lang.String r2 = "M9015"
            boolean r1 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r1, r2)
            if (r1 != 0) goto Ld1
            java.lang.String r1 = r0.getMBleName()
            java.lang.String r2 = "R8"
            boolean r1 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r1, r2)
            if (r1 != 0) goto Ld1
            java.lang.String r1 = r0.getMBleName()
            java.lang.String r2 = "OT-RL"
            boolean r1 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r1, r2)
            if (r1 != 0) goto Ld1
            java.lang.String r1 = r0.getMBleName()
            java.lang.String r2 = "TYME JEWL"
            boolean r1 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r1, r2)
            if (r1 != 0) goto Ld1
            java.lang.String r1 = r0.getMBleName()
            java.lang.String r2 = "SB-305"
            boolean r1 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r1, r2)
            if (r1 != 0) goto Ld1
            java.lang.String r0 = r0.getMBleName()
            java.lang.String r1 = "AMPM-216"
            boolean r0 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r0, r1)
            if (r0 != 0) goto Ld1
            goto L2e
        Ld1:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ble.ProductManager.O0IxXx():boolean");
    }

    public final boolean O0O0Io00X() {
        BleCache bleCache = BleCache.INSTANCE;
        if (IIX0o.Oxx0IOOO(bleCache.getMBleName(), f20392O0IoXXOx) && IIX0o.Oxx0IOOO(bleCache.getMFirmwareFlag(), "S2_V2")) {
            return true;
        }
        return false;
    }

    public final boolean O0OOX0IIx() {
        if (oOoIxI0x == 1) {
            return true;
        }
        return false;
    }

    public final boolean O0X() {
        DeviceConfigInfo IOoo2 = IOoo();
        if (IOoo2 != null) {
            return oOXoIIIo.I0Io.II0xO0(IOoo2.getSupportMusic());
        }
        return IoOoX();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01fd A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int O0Xx() {
        /*
            Method dump skipped, instructions count: 534
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ble.ProductManager.O0Xx():int");
    }

    @OOXIXo
    public final String O0o0() {
        CustomConfigInfo customConfig;
        String supDirectAI;
        String obj;
        MacConfig macConfig;
        String supDirectAI2;
        String obj2;
        DeviceConfigInfo IOoo2 = IOoo();
        if (IOoo2 != null && (macConfig = IOoo2.getMacConfig()) != null && (supDirectAI2 = macConfig.getSupDirectAI()) != null && (obj2 = StringsKt__StringsKt.oIoIXxIO(supDirectAI2).toString()) != null && obj2.length() > 0) {
            DeviceConfigInfo IOoo3 = IOoo();
            IIX0o.ooOOo0oXI(IOoo3);
            MacConfig macConfig2 = IOoo3.getMacConfig();
            IIX0o.ooOOo0oXI(macConfig2);
            return StringsKt__StringsKt.oIoIXxIO(macConfig2.getSupDirectAI()).toString();
        }
        DeviceConfigInfo IOoo4 = IOoo();
        if (IOoo4 == null || (customConfig = IOoo4.getCustomConfig()) == null || (supDirectAI = customConfig.getSupDirectAI()) == null || (obj = StringsKt__StringsKt.oIoIXxIO(supDirectAI).toString()) == null) {
            return "";
        }
        return obj;
    }

    public final boolean O0x() {
        if (Oo0 == 1) {
            return true;
        }
        return false;
    }

    public final boolean O0xO0() {
        CustomConfigInfo customConfig;
        String supRideCode;
        DeviceConfigInfo IOoo2 = IOoo();
        if (IOoo2 != null && (customConfig = IOoo2.getCustomConfig()) != null && (supRideCode = customConfig.getSupRideCode()) != null) {
            return supRideCode.equals("1");
        }
        return false;
    }

    @OOXIXo
    public final String O0xOxO() {
        MacConfig macConfig;
        String aiModelService;
        String obj;
        DeviceConfigInfo IOoo2 = IOoo();
        if (IOoo2 == null || (macConfig = IOoo2.getMacConfig()) == null || (aiModelService = macConfig.getAiModelService()) == null || (obj = StringsKt__StringsKt.oIoIXxIO(aiModelService).toString()) == null) {
            return "";
        }
        return obj;
    }

    public final boolean O0xxXxI() {
        return IIX0o.Oxx0IOOO(oI0IIXIo(), "sparkAIService");
    }

    public final int OI0() {
        boolean Oxx0IOOO2;
        BleCache bleCache = BleCache.INSTANCE;
        String mBleName = bleCache.getMBleName();
        if (IIX0o.Oxx0IOOO(mBleName, f20386IxOIO)) {
            Oxx0IOOO2 = true;
        } else {
            Oxx0IOOO2 = IIX0o.Oxx0IOOO(mBleName, f20663xxx);
        }
        if (Oxx0IOOO2) {
            return 100;
        }
        int mSupportContactSize = bleCache.getMSupportContactSize();
        if (mSupportContactSize == 0) {
            return 20;
        }
        return mSupportContactSize;
    }

    public final boolean OI0IXox() {
        return BleCache.INSTANCE.getMDataKeys().contains(Integer.valueOf(BleKey.MATCH_RECORD2.getMKey()));
    }

    public final boolean OIII0O() {
        if (xoOOIooI == 1) {
            return true;
        }
        return false;
    }

    public final boolean OIIXOxo() {
        if (BleCache.INSTANCE.getMSupportGameTimeReminder() == 1) {
            return true;
        }
        return false;
    }

    @OOXIXo
    public final String OIOoIIOIx() {
        List<Integer> mDataKeys = BleCache.INSTANCE.getMDataKeys();
        if (mDataKeys.isEmpty()) {
            if (ProjectManager.f19822oIX0oI.OX00O0xII()) {
                return "heart_rate,sleep,pressure,weight";
            }
            return "heart_rate,sleep,pressure";
        }
        ArrayList arrayList = new ArrayList();
        if (mDataKeys.contains(Integer.valueOf(BleKey.HEART_RATE.getMKey()))) {
            arrayList.add("heart_rate");
        }
        if (I0()) {
            arrayList.add(OXxXX);
        }
        if (mDataKeys.contains(Integer.valueOf(BleKey.HRV.getMKey()))) {
            arrayList.add(oIIX);
        }
        ProjectManager projectManager = ProjectManager.f19822oIX0oI;
        if (projectManager.xo0x()) {
            arrayList.add(xxI0XIO);
        }
        if (mDataKeys.contains(Integer.valueOf(BleKey.BLOOD_OXYGEN.getMKey())) && oO0IXx()) {
            arrayList.add(IO0xO);
        }
        if (mDataKeys.contains(Integer.valueOf(BleKey.SLEEP.getMKey()))) {
            arrayList.add("sleep");
        }
        if (mDataKeys.contains(Integer.valueOf(BleKey.TEMPERATURE.getMKey()))) {
            arrayList.add("temperature");
        }
        if (mDataKeys.contains(Integer.valueOf(BleKey.PRESSURE.getMKey()))) {
            arrayList.add(oXoxo0x);
        }
        if (mDataKeys.contains(Integer.valueOf(BleKey.BLOOD_GLUCOSE.getMKey()))) {
            arrayList.add(ooIIx);
        }
        if (X00IxOx()) {
            arrayList.add(X0OXIOxX);
        }
        if (projectManager.OX00O0xII()) {
            arrayList.add("weight");
        }
        return CollectionsKt___CollectionsKt.OoIXo(arrayList, ",", null, null, 0, null, null, 62, null);
    }

    public final boolean OIoxIx() {
        if (BleCache.INSTANCE.getMSupportConnectReminder() == 1) {
            return true;
        }
        return false;
    }

    @oOoXoXO
    public final String OIx00oxx(@oOoXoXO String str) {
        for (String str2 : oOII0) {
            if (str != null && OxI.IOOoXo0Ix(str, str2, false, 2, null)) {
                return str2;
            }
        }
        return null;
    }

    public final boolean OIx0xoOo() {
        if (BleCache.INSTANCE.getMSupportRecordNote() == 1) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0002. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:3:0x0005 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x000d A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean OIxI0O(int r3, boolean r4) {
        /*
            r2 = this;
            r0 = 1
            r1 = 0
            switch(r3) {
                case 7: goto Ld;
                case 8: goto Ld;
                case 9: goto Ld;
                case 10: goto Ld;
                case 12: goto Ld;
                case 13: goto Ld;
                case 14: goto L5;
                case 15: goto L5;
                case 16: goto Ld;
                case 17: goto Ld;
                case 18: goto Ld;
                case 19: goto Ld;
                case 20: goto Ld;
                case 21: goto L7;
                case 22: goto Ld;
                case 23: goto Ld;
                case 24: goto L5;
                case 28: goto Le;
                case 29: goto Le;
                case 30: goto Le;
                case 32: goto L5;
                case 33: goto Ld;
                case 36: goto L5;
                case 37: goto Ld;
                case 40: goto Ld;
                case 49: goto Ld;
                case 50: goto Ld;
                case 51: goto Ld;
                case 53: goto Ld;
                case 61: goto Ld;
                case 63: goto Ld;
                case 65: goto Ld;
                case 66: goto Ld;
                case 68: goto Le;
                case 81: goto Le;
                case 86: goto Ld;
                case 88: goto Ld;
                case 89: goto Ld;
                case 91: goto Ld;
                case 92: goto Ld;
                case 96: goto Ld;
                case 97: goto Ld;
                case 98: goto Ld;
                case 100: goto Ld;
                case 101: goto Ld;
                case 102: goto Ld;
                case 103: goto Ld;
                case 109: goto Le;
                case 133: goto Ld;
                case 134: goto Ld;
                case 136: goto Ld;
                case 147: goto Ld;
                case 148: goto Ld;
                default: goto L5;
            }
        L5:
            r4 = 0
            goto Le
        L7:
            boolean r3 = r2.xxx00()
            if (r3 != 0) goto L5
        Ld:
            r4 = 1
        Le:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ble.ProductManager.OIxI0O(int, boolean):boolean");
    }

    public final boolean OIxOIX0II() {
        if (x00xXx0o == 1) {
            return true;
        }
        return false;
    }

    public final boolean OIxOX() {
        if (BleCache.INSTANCE.getMSupportAppStore() == 1) {
            return true;
        }
        return false;
    }

    public final boolean OIxx0I0() {
        BleCache bleCache = BleCache.INSTANCE;
        if (IIX0o.Oxx0IOOO(bleCache.getMFirmwareFlag(), "AM07_HK89<>HK85") || bleCache.getMSupportAlipay() != 1) {
            return false;
        }
        return true;
    }

    public final boolean OO() {
        DeviceConfigInfo IOoo2 = IOoo();
        if (IOoo2 != null) {
            return oOXoIIIo.I0Io.II0xO0(IOoo2.getRequireReadNoDisturb());
        }
        return xI();
    }

    public final int OO0() {
        BleCache bleCache = BleCache.INSTANCE;
        if (IIX0o.Oxx0IOOO(bleCache.getMBleName(), XO0XIXOo0)) {
            return 1;
        }
        return BleCache.getInt$default(bleCache, BleKey.TEMPERATURE_UNIT, 0, null, 6, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0050, code lost:
    
        r0 = com.blankj.utilcode.util.Utils.getApp();
        kotlin.jvm.internal.IIX0o.oO(r0, "getApp(...)");
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x005d, code lost:
    
        if (com.sma.smartv3.util.UtilsKt.X00IoxXI(r0) == false) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x005f, code lost:
    
        r2 = com.blankj.utilcode.util.Utils.getApp().getString(com.sma.smartv3.co_fit.R.string.wenxinyiyan);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0068, code lost:
    
        r2 = "Ernie Bot";
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0042, code lost:
    
        if (r0.equals("BS_S1_PRO_VC30FS") == false) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x00b6, code lost:
    
        r2 = com.blankj.utilcode.util.Utils.getApp().getString(com.sma.smartv3.co_fit.R.string.wenxinyiyan);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004c, code lost:
    
        if (r0.equals("BS_S3_PRO_CC1165W") == false) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0071, code lost:
    
        if (r0.equals("BS_S3_PRO") == false) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007d, code lost:
    
        if (r0.equals("BS_S3_PRO_CC1165W_ZFB") == false) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00aa, code lost:
    
        if (r0.equals("BLACK_SHARK_S1_PRO") == false) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b3, code lost:
    
        if (r0.equals("BS_S1_PRO_LOCKFACE") == false) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0038, code lost:
    
        if (r0.equals("S1_LITE_V6") == false) goto L96;
     */
    @OXOo.OOXIXo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String OO0x0xX() {
        /*
            r4 = this;
            com.szabh.smable3.component.BleCache r0 = com.szabh.smable3.component.BleCache.INSTANCE
            java.lang.String r0 = r0.getMFirmwareFlag()
            int r1 = r0.hashCode()
            java.lang.String r2 = "SharkGPT"
            r3 = 2132022199(0x7f1413b7, float:1.968281E38)
            switch(r1) {
                case -1957226515: goto Lad;
                case -1652604122: goto La4;
                case -1546093392: goto La1;
                case -1465289155: goto L95;
                case -1354240341: goto L80;
                case -1029950260: goto L77;
                case -275859767: goto L74;
                case 431191996: goto L6b;
                case 1115516277: goto L46;
                case 1153115964: goto L3c;
                case 1462006480: goto L32;
                case 1503770892: goto L2b;
                case 1955322739: goto L14;
                default: goto L12;
            }
        L12:
            goto Lbe
        L14:
            java.lang.String r1 = "SF04_SEM2023E"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L1e
            goto Lbe
        L1e:
            android.app.Application r0 = com.blankj.utilcode.util.Utils.getApp()
            r1 = 2132022085(0x7f141345, float:1.968258E38)
            java.lang.String r2 = r0.getString(r1)
            goto Lbe
        L2b:
            java.lang.String r1 = "BLACK_SHARK_GT3"
        L2d:
            r0.equals(r1)
            goto Lbe
        L32:
            java.lang.String r1 = "S1_LITE_V6"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L50
            goto Lbe
        L3c:
            java.lang.String r1 = "BS_S1_PRO_VC30FS"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto Lb6
            goto Lbe
        L46:
            java.lang.String r1 = "BS_S3_PRO_CC1165W"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L50
            goto Lbe
        L50:
            android.app.Application r0 = com.blankj.utilcode.util.Utils.getApp()
            java.lang.String r1 = "getApp(...)"
            kotlin.jvm.internal.IIX0o.oO(r0, r1)
            boolean r0 = com.sma.smartv3.util.UtilsKt.X00IoxXI(r0)
            if (r0 == 0) goto L68
            android.app.Application r0 = com.blankj.utilcode.util.Utils.getApp()
            java.lang.String r2 = r0.getString(r3)
            goto Lbe
        L68:
            java.lang.String r2 = "Ernie Bot"
            goto Lbe
        L6b:
            java.lang.String r1 = "BS_S3_PRO"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto Lb6
            goto Lbe
        L74:
            java.lang.String r1 = "F34_BS_GT3_NEO"
            goto L2d
        L77:
            java.lang.String r1 = "BS_S3_PRO_CC1165W_ZFB"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto Lb6
            goto Lbe
        L80:
            java.lang.String r1 = "S1_PRO_OVERSEAS"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L89
            goto Lbe
        L89:
            android.app.Application r0 = com.blankj.utilcode.util.Utils.getApp()
            r1 = 2132017901(0x7f1402ed, float:1.9674093E38)
            java.lang.String r2 = r0.getString(r1)
            goto Lbe
        L95:
            java.lang.String r1 = "MWC_MW01_HW"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L9e
            goto Lbe
        L9e:
            java.lang.String r2 = "ChatGPT"
            goto Lbe
        La1:
            java.lang.String r1 = "S1_PRO_OVERSEAS_V2"
            goto L2d
        La4:
            java.lang.String r1 = "BLACK_SHARK_S1_PRO"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto Lb6
            goto Lbe
        Lad:
            java.lang.String r1 = "BS_S1_PRO_LOCKFACE"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto Lb6
            goto Lbe
        Lb6:
            android.app.Application r0 = com.blankj.utilcode.util.Utils.getApp()
            java.lang.String r2 = r0.getString(r3)
        Lbe:
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ble.ProductManager.OO0x0xX():java.lang.String");
    }

    public final boolean OOIXx0x() {
        return true;
    }

    public final boolean OOOI() {
        if (IIX0o.Oxx0IOOO(BleCache.INSTANCE.getMPrototype(), BleDeviceInfo.PROTOTYPE_AM22) || xOOxIO(this, null, 1, null)) {
            return false;
        }
        return IxI();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0031 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:5:0x0033 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean OOOox() {
        /*
            r2 = this;
            com.szabh.smable3.component.BleCache r0 = com.szabh.smable3.component.BleCache.INSTANCE
            java.lang.String r0 = r0.getMFirmwareFlag()
            int r1 = r0.hashCode()
            switch(r1) {
                case -1783583951: goto L29;
                case -648005195: goto L20;
                case 1053453618: goto L17;
                case 1933474765: goto Le;
                default: goto Ld;
            }
        Ld:
            goto L31
        Le:
            java.lang.String r1 = "BS_W2406_OVERSEA"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L33
            goto L31
        L17:
            java.lang.String r1 = "BS_GS3_OS_GM_LITE"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L31
            goto L33
        L20:
            java.lang.String r1 = "BS_GS3_KR_GM_LITE"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L33
            goto L31
        L29:
            java.lang.String r1 = "BS_W2406"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L33
        L31:
            r0 = 1
            goto L34
        L33:
            r0 = 0
        L34:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ble.ProductManager.OOOox():boolean");
    }

    public final int OOXIXo() {
        if (xIx()) {
            return 120;
        }
        return 60;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final boolean OOXIxO0() {
        BleCache bleCache = BleCache.INSTANCE;
        int mWatchFaceType = bleCache.getMWatchFaceType();
        if (mWatchFaceType == 2 || mWatchFaceType == 3 || mWatchFaceType == 6 || mWatchFaceType == 7) {
            return true;
        }
        if (mWatchFaceType != 99) {
            switch (mWatchFaceType) {
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                    return true;
                default:
                    switch (mWatchFaceType) {
                        case 15:
                        case 16:
                        case 17:
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                            return true;
                    }
            }
        }
        String mPrototype = bleCache.getMPrototype();
        switch (mPrototype.hashCode()) {
            case -2093481923:
                if (mPrototype.equals("JX621D")) {
                    return true;
                }
                break;
            case -1595662850:
                if (mPrototype.equals(BleDeviceInfo.PROTOTYPE_SF15GUC)) {
                    return true;
                }
                break;
            case -75924174:
                if (mPrototype.equals(BleDeviceInfo.PROTOTYPE_A8_ULTRA_PRO)) {
                    return true;
                }
                break;
            case OxXXx0X.f13148o0oIxOo /* 2070 */:
                if (mPrototype.equals("A7")) {
                    return true;
                }
                break;
            case DfuAdapter.STATE_BACKCONNECT_CONNECTING /* 2071 */:
                if (mPrototype.equals("A8")) {
                    return true;
                }
                break;
            case 2103:
                if (mPrototype.equals("B9")) {
                    return true;
                }
                break;
            case OxXXx0X.f13144o0IXXIx /* 2219 */:
                if (mPrototype.equals("F1")) {
                    return true;
                }
                break;
            case OxXXx0X.f13216x0OOI /* 2623 */:
                if (mPrototype.equals("S2")) {
                    return true;
                }
                break;
            case 2625:
                if (mPrototype.equals(BleDeviceInfo.PROTOTYPE_S4)) {
                    return true;
                }
                break;
            case 2716:
                if (mPrototype.equals("V2")) {
                    return true;
                }
                break;
            case 2754:
                if (mPrototype.equals("W9")) {
                    return true;
                }
                break;
            case 68839:
                if (mPrototype.equals("F12")) {
                    return true;
                }
                break;
            case 68844:
                if (mPrototype.equals("F17")) {
                    return true;
                }
                break;
            case 68895:
                if (mPrototype.equals("F2K")) {
                    return true;
                }
                break;
            case 68902:
                if (mPrototype.equals("F2R")) {
                    return true;
                }
                break;
            case 69396:
                if (mPrototype.equals("FC1")) {
                    return true;
                }
                break;
            case 69397:
                if (mPrototype.equals("FC2")) {
                    return true;
                }
                break;
            case 69927:
                if (mPrototype.equals(BleDeviceInfo.PROTOTYPE_FT5)) {
                    return true;
                }
                break;
            case 73642:
                if (mPrototype.equals("K10")) {
                    return true;
                }
                break;
            case 73650:
                if (mPrototype.equals(BleDeviceInfo.PROTOTYPE_K18)) {
                    return true;
                }
                break;
            case 80375:
                if (mPrototype.equals("R16")) {
                    return true;
                }
                break;
            case 84369:
                if (mPrototype.equals("V61")) {
                    return true;
                }
                break;
            case 2011949:
                if (mPrototype.equals("AM01")) {
                    return true;
                }
                break;
            case 2011953:
                if (mPrototype.equals("AM05")) {
                    return true;
                }
                break;
            case 2011956:
                if (mPrototype.equals("AM08")) {
                    return true;
                }
                break;
            case 2011980:
                if (mPrototype.equals("AM11")) {
                    return true;
                }
                break;
            case 2012012:
                if (mPrototype.equals(BleDeviceInfo.PROTOTYPE_AM22)) {
                    return true;
                }
                break;
            case 2012015:
                if (mPrototype.equals(BleDeviceInfo.PROTOTYPE_AM25)) {
                    return true;
                }
                break;
            case 2021658:
                if (mPrototype.equals("AW37")) {
                    return true;
                }
                break;
            case 2134105:
                if (mPrototype.equals("F13A")) {
                    return true;
                }
                break;
            case 2134106:
                if (mPrototype.equals("F13B")) {
                    return true;
                }
                break;
            case 2230096:
                if (mPrototype.equals(BleDeviceInfo.PROTOTYPE_HW01)) {
                    return true;
                }
                break;
            case 2410926:
                if (mPrototype.equals("NY58")) {
                    return true;
                }
                break;
            case 62370493:
                if (mPrototype.equals("AM01J")) {
                    return true;
                }
                break;
            case 62370524:
                if (mPrototype.equals("AM02J")) {
                    return true;
                }
                break;
            case 82866645:
                if (mPrototype.equals("WS001")) {
                    return true;
                }
                break;
            case 1916887151:
                if (mPrototype.equals(BleDeviceInfo.PROTOTYPE_A9MINI)) {
                    return true;
                }
                break;
            case 1944254325:
                if (mPrototype.equals(BleDeviceInfo.PROTOTYPE_B9C_JL)) {
                    return true;
                }
                break;
            case 2050863174:
                if (mPrototype.equals("F12Pro")) {
                    return true;
                }
                break;
        }
        return false;
    }

    public final boolean OOoOoO0o() {
        if (BleCache.INSTANCE.getMSupportWatchFaceId() == 1) {
            return true;
        }
        return false;
    }

    public final boolean OOxOI() {
        BleCache.INSTANCE.getMPrototype();
        return xOOxIO(this, null, 1, null);
    }

    public final boolean OOxOOxIO() {
        return false;
    }

    @OOXIXo
    public final Collection<String> OX() {
        return (Collection) xXo0X0.getValue();
    }

    public final int OX00O0xII() {
        return oXXxI;
    }

    public final boolean OX00o0X() {
        if (BleCache.INSTANCE.getMSupportStock() == 1) {
            return true;
        }
        return false;
    }

    public final boolean OXOo() {
        String language = Utils.getApp().getResources().getConfiguration().locale.getLanguage();
        if (!xIx0XO() && !IIX0o.Oxx0IOOO(language, Languages.DEFAULT_LANGUAGE_ZH) && !IIX0o.Oxx0IOOO(language, Languages.DEFAULT_LANGUAGE)) {
            return true;
        }
        return false;
    }

    public final boolean OXXoIoXI() {
        String mFirmwareFlag = BleCache.INSTANCE.getMFirmwareFlag();
        if (IIX0o.Oxx0IOOO(mFirmwareFlag, "BS_W2406_OVERSEA")) {
            return true;
        }
        return IIX0o.Oxx0IOOO(mFirmwareFlag, "BS_W2406");
    }

    public final boolean OXooXo() {
        if (!XxIo() && !IIX0o.Oxx0IOOO(BleCache.INSTANCE.getMPlatform(), BleDeviceInfo.PLATFORM_SIFLI)) {
            return false;
        }
        return true;
    }

    public final boolean OXxx0OO() {
        if (BleCache.INSTANCE.getMSupportSDCardInfo() == 1) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0026, code lost:
    
        if (r1.equals("S1833D_WAVECALL2_XXXX") == false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0038, code lost:
    
        if (r1.equals("AM24_Radiant") == false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0041, code lost:
    
        if (r1.equals("FT5Plus_ASCEND") == false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0014, code lost:
    
        if (r1.equals("R1382_ENIGMA") == false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0076, code lost:
    
        return r0.getMBleName() + com.sma.smartv3.util.UtilsKt.Io(r0.getMBleAddress());
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001d, code lost:
    
        if (r1.equals("ENIGMA_X400_Radiant") == false) goto L53;
     */
    @OXOo.OOXIXo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String Oo() {
        /*
            r3 = this;
            com.szabh.smable3.component.BleCache r0 = com.szabh.smable3.component.BleCache.INSTANCE
            java.lang.String r1 = r0.getMFirmwareFlag()
            int r2 = r1.hashCode()
            switch(r2) {
                case -1235740824: goto L3b;
                case -1163231614: goto L32;
                case 78785406: goto L29;
                case 1784782969: goto L20;
                case 1842933076: goto L17;
                case 1977454796: goto Le;
                default: goto Ld;
            }
        Ld:
            goto L43
        Le:
            java.lang.String r2 = "R1382_ENIGMA"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L5b
            goto L43
        L17:
            java.lang.String r2 = "ENIGMA_X400_Radiant"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L5b
            goto L43
        L20:
            java.lang.String r2 = "S1833D_WAVECALL2_XXXX"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L5b
            goto L43
        L29:
            java.lang.String r2 = "SENS5"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L76
            goto L43
        L32:
            java.lang.String r2 = "AM24_Radiant"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L5b
            goto L43
        L3b:
            java.lang.String r2 = "FT5Plus_ASCEND"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L5b
        L43:
            java.lang.String r1 = r0.getMBleCustomName()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L52
            java.lang.String r0 = r0.getMBleCustomName()
            goto L56
        L52:
            java.lang.String r0 = r0.getMBleName()
        L56:
            java.lang.String r2 = r3.oIX0oI(r0)
            goto L76
        L5b:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r0.getMBleName()
            r1.append(r2)
            java.lang.String r0 = r0.getMBleAddress()
            java.lang.String r0 = com.sma.smartv3.util.UtilsKt.Io(r0)
            r1.append(r0)
            java.lang.String r2 = r1.toString()
        L76:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ble.ProductManager.Oo():java.lang.String");
    }

    public final boolean Oo0IXI0() {
        BleCache bleCache = BleCache.INSTANCE;
        if (IIX0o.Oxx0IOOO(bleCache.getMPlatform(), BleDeviceInfo.PLATFORM_JL)) {
            if (IIX0o.Oxx0IOOO(bleCache.getMBleName(), XxOx)) {
                return false;
            }
        } else if (IIX0o.Oxx0IOOO(bleCache.getMBleName(), XxxXX0XO0)) {
            return false;
        }
        return true;
    }

    public final boolean OoI0OO() {
        BleCache bleCache = BleCache.INSTANCE;
        if (IIX0o.Oxx0IOOO(bleCache.getMBleName(), "KUMI KU7 Meta")) {
            return IIX0o.Oxx0IOOO(bleCache.getMFirmwareFlag(), "KUMI_KU7_META");
        }
        return false;
    }

    public final boolean OoIXo() {
        BleCache bleCache = BleCache.INSTANCE;
        String mBleName = bleCache.getMBleName();
        if (IIX0o.Oxx0IOOO(mBleName, xxOOXo)) {
            return IIX0o.Oxx0IOOO(bleCache.getMFirmwareFlag(), "itel_ISW_O43");
        }
        if (IIX0o.Oxx0IOOO(mBleName, XxO)) {
            return IIX0o.Oxx0IOOO(bleCache.getMFirmwareFlag(), "G6_C80");
        }
        return IIX0o.Oxx0IOOO(bleCache.getMFirmwareFlag(), "ENIGMA_X400_Radiant");
    }

    public final int OoO() {
        return x00xXx0o;
    }

    public final boolean OoOoXO0() {
        if (BleCache.INSTANCE.getMSupportWashSet() == 1) {
            return true;
        }
        return false;
    }

    public final int OooI() {
        if (IIX0o.Oxx0IOOO(BleCache.INSTANCE.getMPlatform(), BleDeviceInfo.PLATFORM_SIFLI)) {
            return R.string.notification_shock;
        }
        return R.string.shock;
    }

    public final boolean OooO0XOx(int i, boolean z) {
        switch (i) {
            case 7:
            case 9:
            case 10:
            case 12:
            case 13:
            case 19:
            case 22:
            case 28:
            case 29:
            case 30:
            case 33:
            case 50:
            case 63:
            case 68:
            case 81:
            case 84:
            case 86:
            case 89:
            case 96:
            case 97:
            case 98:
            case 100:
            case 101:
            case 109:
                return z;
            case 65:
                if (!xxx00()) {
                    return true;
                }
            default:
                return false;
        }
    }

    public final boolean Oox() {
        return IIX0o.Oxx0IOOO(BleCache.INSTANCE.getMBleName(), f20434OXxx0OO);
    }

    public final boolean OoxOxII() {
        if (BleCache.INSTANCE.getMSupportSyncAGPSInBackground() == 1) {
            return true;
        }
        return false;
    }

    public final void Ox(int i) {
        x00xXx0o = i;
    }

    public final boolean Ox00XOXoo() {
        if (BleCache.INSTANCE.getMSupportSimultaneousTranslation() == 1) {
            return true;
        }
        return false;
    }

    public final boolean Ox0O() {
        DeviceConfigInfo IOoo2 = IOoo();
        if (IOoo2 != null) {
            return oOXoIIIo.I0Io.II0xO0(IOoo2.getSupportPeriodicHeartRateMonitoring());
        }
        return oOXoIIIo();
    }

    public final boolean Ox0XO() {
        DeviceConfigInfo IOoo2 = IOoo();
        if (IOoo2 != null) {
            return oOXoIIIo.I0Io.II0xO0(IOoo2.getSupWf());
        }
        return false;
    }

    public final int OxI() {
        if (!xOOxIO(this, null, 1, null) && !Xo()) {
            return R.string.goto_faq_solutions;
        }
        return R.string.not_connected;
    }

    public final boolean OxIxx0() {
        if (BleCache.INSTANCE.getMSupportQiblaSet() == 1) {
            return true;
        }
        return false;
    }

    public final boolean OxO(int i) {
        if (i != 10 && i != 63 && i != 70 && i != 81 && i != 86 && i != 89 && i != 109 && i != 136 && i != 28 && i != 29 && i != 100 && i != 101 && i != 133 && i != 134 && i != 147 && i != 148) {
            switch (i) {
                case 96:
                case 97:
                case 98:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    public final boolean OxXXx0X() {
        String mPlatform = BleCache.INSTANCE.getMPlatform();
        if (IIX0o.Oxx0IOOO(mPlatform, BleDeviceInfo.PLATFORM_SIFLI)) {
            return true;
        }
        return IIX0o.Oxx0IOOO(mPlatform, BleDeviceInfo.PLATFORM_JL707);
    }

    public final boolean Oxo00O() {
        if (!xIx() && !xxxI() && !x0xOIoO()) {
            return false;
        }
        return true;
    }

    @OOXIXo
    public final ArrayList<String> Oxx() {
        return (ArrayList) IOX0Xo.getValue();
    }

    public final int Oxx0IOOO() {
        if (xIx()) {
            return 120;
        }
        return 30;
    }

    @OOXIXo
    public final ArrayList<String> Oxx0xo() {
        return (ArrayList) oo0I.getValue();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0030, code lost:
    
        if (r0.equals(com.sma.smartv3.ble.ProductManager.XXooo0) == false) goto L165;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x003a, code lost:
    
        if (r0.equals(com.sma.smartv3.ble.ProductManager.oXxXoox0) == false) goto L165;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0044, code lost:
    
        if (r0.equals("G7 Talk PRO") == false) goto L165;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004e, code lost:
    
        if (r0.equals(com.sma.smartv3.ble.ProductManager.xxxIO) != false) goto L168;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0058, code lost:
    
        if (r0.equals(com.sma.smartv3.ble.ProductManager.oX0oO) == false) goto L165;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0062, code lost:
    
        if (r0.equals(com.sma.smartv3.ble.ProductManager.f20482XIxO) == false) goto L165;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x006c, code lost:
    
        if (r0.equals(com.sma.smartv3.ble.ProductManager.oxIIOOX) == false) goto L165;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0076, code lost:
    
        if (r0.equals(com.sma.smartv3.ble.ProductManager.xxXX0) == false) goto L165;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0080, code lost:
    
        if (r0.equals(com.sma.smartv3.ble.ProductManager.II) == false) goto L165;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x008a, code lost:
    
        if (r0.equals(com.sma.smartv3.ble.ProductManager.XxOx) == false) goto L165;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0094, code lost:
    
        if (r0.equals(com.sma.smartv3.ble.ProductManager.XOoxOOO) == false) goto L165;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x009e, code lost:
    
        if (r0.equals(com.sma.smartv3.ble.ProductManager.XxOOO0) == false) goto L165;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00a8, code lost:
    
        if (r0.equals("R5") == false) goto L165;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b1, code lost:
    
        if (r0.equals(com.sma.smartv3.ble.ProductManager.xXIO) == false) goto L165;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00c6, code lost:
    
        if (r0.equals(com.sma.smartv3.ble.ProductManager.Ix00xIoO) == false) goto L165;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00cf, code lost:
    
        if (r0.equals(com.sma.smartv3.ble.ProductManager.oIIo0xX) == false) goto L165;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00d8, code lost:
    
        if (r0.equals(com.sma.smartv3.ble.ProductManager.oIX) == false) goto L165;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00e1, code lost:
    
        if (r0.equals(com.sma.smartv3.ble.ProductManager.I0XIOxXXX) == false) goto L165;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00ea, code lost:
    
        if (r0.equals(com.sma.smartv3.ble.ProductManager.xIOXI) == false) goto L165;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00f3, code lost:
    
        if (r0.equals(com.sma.smartv3.ble.ProductManager.o0oo) == false) goto L165;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00ff, code lost:
    
        if (r0.equals(com.sma.smartv3.ble.ProductManager.oIOIO) == false) goto L165;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0026, code lost:
    
        if (r0.equals(com.sma.smartv3.ble.ProductManager.xXOXOOx) == false) goto L165;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x00f6, code lost:
    
        return 10;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x001b. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:12:0x010b A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0109 A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int OxxIIOOXO() {
        /*
            Method dump skipped, instructions count: 364
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ble.ProductManager.OxxIIOOXO():int");
    }

    public final boolean Oxxo() {
        if (BleCache.INSTANCE.getMSupportTimerStandbySet() == 1) {
            return true;
        }
        return false;
    }

    public final boolean X0() {
        if (BleCache.INSTANCE.getMSupportNetwork() == 1) {
            return true;
        }
        return false;
    }

    public final int X00IoxXI() {
        BleCache.INSTANCE.getMPrototype();
        return 5;
    }

    public final boolean X00IxOx() {
        if (BleCache.INSTANCE.getMSupportMeasurementBloodGlucose() == 1) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:3:0x0005 A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean X00xOoXI(int r3) {
        /*
            r2 = this;
            r0 = 1
            r1 = 0
            switch(r3) {
                case 10: goto Le;
                case 16: goto L14;
                case 18: goto L14;
                case 33: goto L14;
                case 49: goto L14;
                case 65: goto L7;
                case 68: goto L14;
                case 89: goto L14;
                case 102: goto L14;
                case 109: goto L14;
                case 133: goto L14;
                case 134: goto L14;
                case 136: goto L14;
                case 147: goto L14;
                case 148: goto L14;
                default: goto L5;
            }
        L5:
            r0 = 0
            goto L14
        L7:
            boolean r3 = r2.xxx00()
            if (r3 != 0) goto L5
            goto L14
        Le:
            boolean r3 = r2.xxx00()
            if (r3 != 0) goto L5
        L14:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ble.ProductManager.X00xOoXI(int):boolean");
    }

    public final int X0IIOO() {
        if (xIx()) {
            return R.string.guide_warm_tip_2;
        }
        return R.string.guide_warm_tip;
    }

    public final boolean X0IOOI() {
        BleCache bleCache = BleCache.INSTANCE;
        if (!IIX0o.Oxx0IOOO(bleCache.getMBleName(), f20592oxoX) && !IIX0o.Oxx0IOOO(bleCache.getMBleName(), f20469X0o0xo) && !IIX0o.Oxx0IOOO(bleCache.getMBleName(), f20614xIXX) && !IIX0o.Oxx0IOOO(bleCache.getMBleName(), f20665xxxI) && !IIX0o.Oxx0IOOO(bleCache.getMBleName(), f20390O00) && !IIX0o.Oxx0IOOO(bleCache.getMBleName(), f20624xOOxIO) && bleCache.getMHideDigitalPower() == 0) {
            return true;
        }
        return false;
    }

    public final boolean X0O0I0(int i) {
        return i == 7 || i == 19 || i == 33 || i == 50 || i == 63 || i == 70 || i == 81 || i == 89 || i == 100 || i == 136 || i == 9 || i == 10 || i == 12 || i == 13 || i == 96 || i == 97 || i == 133 || i == 134;
    }

    public final boolean X0OXX() {
        if (PermissionUtils.getPermissions().contains("android.permission.SEND_SMS") && BleCache.INSTANCE.getMSupportSMSQuickReply() == 1) {
            return true;
        }
        return false;
    }

    public final int X0o0xo() {
        return 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001e, code lost:
    
        if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(r0, "1") != false) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean X0ooXIooI() {
        /*
            r2 = this;
            boolean r0 = r2.XoOxI0ox()
            if (r0 == 0) goto L20
            com.sma.smartv3.model.DeviceConfigInfo r0 = r2.IOoo()
            if (r0 == 0) goto L17
            com.sma.smartv3.model.CustomConfigInfo r0 = r0.getCustomConfig()
            if (r0 == 0) goto L17
            java.lang.String r0 = r0.getSupOpenScreenAds()
            goto L18
        L17:
            r0 = 0
        L18:
            java.lang.String r1 = "1"
            boolean r0 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r0, r1)
            if (r0 == 0) goto L26
        L20:
            boolean r0 = r2.xIOXX()
            if (r0 == 0) goto L28
        L26:
            r0 = 1
            goto L29
        L28:
            r0 = 0
        L29:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ble.ProductManager.X0ooXIooI():boolean");
    }

    public final boolean X0x() {
        if (X0o0O0x == 1) {
            return true;
        }
        return false;
    }

    public final int X0xII0I() {
        BleCache.INSTANCE.getMPrototype();
        return 5;
    }

    public final boolean X0xOO() {
        if (BleCache.INSTANCE.getMSupportGPSFirmwareFile() == 1) {
            return true;
        }
        return false;
    }

    @OOXIXo
    public final ArrayList<String> X0xxXX0() {
        return (ArrayList) XOOXIXxxI.getValue();
    }

    @oOoXoXO
    public final AppConfigInfo XI() {
        return (AppConfigInfo) new Gson().fromJson(com.sma.smartv3.util.Xo0.f24349oIX0oI.oIX0oI().getString(AppConfigInfo.class.getName()), AppConfigInfo.class);
    }

    public final boolean XI0IXoo() {
        String str;
        CustomConfigInfo customConfig;
        String transModel;
        DeviceConfigInfo IOoo2 = IOoo();
        if (IOoo2 != null && (customConfig = IOoo2.getCustomConfig()) != null && (transModel = customConfig.getTransModel()) != null) {
            str = StringsKt__StringsKt.oIoIXxIO(transModel).toString();
        } else {
            str = null;
        }
        return IIX0o.Oxx0IOOO(str, "azureTransService");
    }

    public final boolean XI0oooXX() {
        BleCache bleCache = BleCache.INSTANCE;
        String mBleName = bleCache.getMBleName();
        switch (mBleName.hashCode()) {
            case OxXXx0X.f13032OIxOX /* 2622 */:
                if (!mBleName.equals("S1")) {
                    return true;
                }
                break;
            case 68895:
                if (!mBleName.equals("F2K")) {
                    return true;
                }
                break;
            case 68917:
                if (!mBleName.equals(f20423OOXIxO0)) {
                    return true;
                }
                break;
            case 2410926:
                if (!mBleName.equals("NY58")) {
                    return true;
                }
                break;
            case 64424219:
                if (!mBleName.equals(f20392O0IoXXOx)) {
                    return true;
                }
                break;
            case 609728801:
                if (!mBleName.equals(f20348IIxOXoOo0)) {
                    return true;
                }
                break;
            default:
                return true;
        }
        if (!IIX0o.Oxx0IOOO(bleCache.getMPlatform(), BleDeviceInfo.PLATFORM_REALTEK)) {
            return true;
        }
        return false;
    }

    public final boolean XIOOI() {
        if (BleCache.INSTANCE.getMSupportCustomLogo() == 1) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0101 A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean XIXIX() {
        /*
            r4 = this;
            com.szabh.smable3.component.BleCache r0 = com.szabh.smable3.component.BleCache.INSTANCE
            java.lang.String r1 = r0.getMPlatform()
            java.lang.String r2 = "Realtek"
            boolean r1 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r1, r2)
            java.lang.String r2 = "F6"
            if (r1 == 0) goto L1e
            java.util.ArrayList r1 = r4.IO0XoXxO()
            java.lang.String r3 = r0.getMFirmwareFlag()
            boolean r1 = r1.contains(r3)
            if (r1 == 0) goto Lac
        L1e:
            java.lang.String r1 = r0.getMPrototype()
            java.lang.String r3 = "R10"
            boolean r1 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r1, r3)
            if (r1 != 0) goto Lac
            java.lang.String r1 = r0.getMPrototype()
            java.lang.String r3 = "REALTEK_GTM5"
            boolean r1 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r1, r3)
            if (r1 != 0) goto Lac
            java.lang.String r1 = r0.getMPrototype()
            boolean r1 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r1, r2)
            if (r1 != 0) goto Lac
            java.lang.String r1 = r0.getMPrototype()
            java.lang.String r3 = "F7"
            boolean r1 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r1, r3)
            if (r1 != 0) goto Lac
            java.lang.String r1 = r0.getMPrototype()
            java.lang.String r3 = "SMA-ND08"
            boolean r1 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r1, r3)
            if (r1 != 0) goto Lac
            java.lang.String r1 = r0.getMPrototype()
            java.lang.String r3 = "SMA-ND09"
            boolean r1 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r1, r3)
            if (r1 != 0) goto Lac
            java.lang.String r1 = r0.getMPrototype()
            java.lang.String r3 = "F3-LH"
            boolean r1 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r1, r3)
            if (r1 != 0) goto Lac
            java.lang.String r1 = r0.getMPrototype()
            java.lang.String r3 = "Y3"
            boolean r1 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r1, r3)
            if (r1 != 0) goto Lac
            java.lang.String r1 = r0.getMPrototype()
            java.lang.String r3 = "R10Pro"
            boolean r1 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r1, r3)
            if (r1 != 0) goto Lac
            java.lang.String r1 = r0.getMPrototype()
            java.lang.String r3 = "R11"
            boolean r1 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r1, r3)
            if (r1 != 0) goto Lac
            java.lang.String r1 = r0.getMPrototype()
            java.lang.String r3 = "R11S"
            boolean r1 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r1, r3)
            if (r1 != 0) goto Lac
            java.lang.String r1 = r0.getMPrototype()
            java.lang.String r3 = "SMA_S03"
            boolean r1 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r1, r3)
            if (r1 == 0) goto L103
        Lac:
            java.lang.String r1 = r0.getMBleName()
            int r3 = r1.hashCode()
            switch(r3) {
                case -1456332965: goto Lf9;
                case 2224: goto Le5;
                case 2410926: goto Ldc;
                case 2508793: goto Ld3;
                case 530514912: goto Lca;
                case 1872060859: goto Lc1;
                case 1968815726: goto Lb8;
                default: goto Lb7;
            }
        Lb7:
            goto L101
        Lb8:
            java.lang.String r0 = "BSW015"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L103
            goto L101
        Lc1:
            java.lang.String r0 = "AFWG0721"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L103
            goto L101
        Lca:
            java.lang.String r0 = "Trail Force Watch"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L101
            goto L103
        Ld3:
            java.lang.String r0 = "RC08"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L103
            goto L101
        Ldc:
            java.lang.String r0 = "NY58"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L103
            goto L101
        Le5:
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto Lec
            goto L101
        Lec:
            java.lang.String r0 = r0.getMFirmwareFlag()
            java.lang.String r1 = "F6_V3_64M_Ignite_S3"
            boolean r0 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r0, r1)
            if (r0 != 0) goto L103
            goto L101
        Lf9:
            java.lang.String r0 = "Rhine 1"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L103
        L101:
            r0 = 1
            goto L104
        L103:
            r0 = 0
        L104:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ble.ProductManager.XIXIX():boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x00f9 A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean XIXIxO() {
        /*
            Method dump skipped, instructions count: 686
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ble.ProductManager.XIXIxO():boolean");
    }

    public final boolean XIo0oOXIx() {
        boolean Oxx0IOOO2;
        String mBleName = BleCache.INSTANCE.getMBleName();
        if (IIX0o.Oxx0IOOO(mBleName, f20334I0X0x0oIo)) {
            Oxx0IOOO2 = true;
        } else {
            Oxx0IOOO2 = IIX0o.Oxx0IOOO(mBleName, f20562oX0I0O);
        }
        if (!Oxx0IOOO2 && !xxxI()) {
            return true;
        }
        return false;
    }

    public final boolean XIxO() {
        if (BleCache.INSTANCE.getMSupportHrWarnSet() == 1) {
            return true;
        }
        return false;
    }

    @OOXIXo
    public final String XIxXXX0x0() {
        String string;
        if (IIX0o.Oxx0IOOO(BleCache.INSTANCE.getMPrototype(), "S2")) {
            string = Utils.getApp().getString(R.string.backlight_never);
        } else {
            string = Utils.getApp().getString(R.string.off);
        }
        IIX0o.ooOOo0oXI(string);
        return string;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:1001:0x1331, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xoOXXoO0X) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1003:0x133b, code lost:
    
        if (r12.equals("F2K") == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1005:0x134a, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20497XX0xXo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1007:0x1354, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20511XoX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1009:0x135e, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OoIoI0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1011:0x1368, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xXxIoIXX0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1013:0x1372, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xX0Ox) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1015:0x137c, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.ooX0XXOI) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1017:0x1386, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OXI) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x01d3, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.IxO0X0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1021:0x1398, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OIIXIIO0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1023:0x13a2, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20484XO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1025:0x13ac, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.Ioxo0x0x0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1027:0x13b6, code lost:
    
        if (r12.equals("F17") == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1029:0x13c0, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20404OI0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1031:0x13ca, code lost:
    
        if (r12.equals("F12") == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1033:0x13d9, code lost:
    
        if (r12.equals("F11") == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1039:0x140a, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XOO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x01dd, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.IIx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1041:0x1414, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.IoxoIIx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1043:0x141e, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20450Ox0XO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1045:0x1428, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.o0Xo0XX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1047:0x1432, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XOOI0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1049:0x143c, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.IIO0X0I) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1051:0x1446, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XxOOO0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1053:0x1450, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oIo0OoXIo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1055:0x145a, code lost:
    
        if (r12.equals("V2") == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x01e7, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XIOoI) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1060:0x146e, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.IxoOxx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1062:0x1478, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20478XIOOI) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1064:0x1482, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.O0OxXXox) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1066:0x148c, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.I0xI0oI) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1068:0x1496, code lost:
    
        if (r12.equals("S2") == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1070:0x14a0, code lost:
    
        if (r12.equals("S1") == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1072:0x14aa, code lost:
    
        if (r12.equals("R9") == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1074:0x14b4, code lost:
    
        if (r12.equals("R7") == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1076:0x14be, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20402O0xOxO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1077:0x1d06, code lost:
    
        return com.sma.smartv3.co_fit.R.drawable.r6_pair;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1079:0x14c8, code lost:
    
        if (r12.equals("R5") == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x01f1, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.Xo0oxx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1081:0x14d2, code lost:
    
        if (r12.equals("R4") == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1083:0x14dc, code lost:
    
        if (r12.equals("R3") == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1085:0x14e6, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20331I0Io) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1086:0x1c52, code lost:
    
        return com.sma.smartv3.co_fit.R.drawable.sma_q3_pair;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1088:0x14f0, code lost:
    
        if (r12.equals("M6") == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1090:0x14fa, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.IXXOI) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1092:0x1504, code lost:
    
        if (r12.equals("M3") == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1094:0x1513, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XXXoOII) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1096:0x151d, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20399O0o0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1098:0x1527, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.x00) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x01fb, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20596x00X0xoXO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0039, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OXXxXoO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1100:0x1531, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.I0X) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1102:0x153b, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XoXoOo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1104:0x1545, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20463X00IxOx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1106:0x154f, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20517XxIIOXIXx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1108:0x1559, code lost:
    
        if (r12.equals("F7") == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1110:0x1563, code lost:
    
        if (r12.equals("F6") == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1112:0x156d, code lost:
    
        if (r12.equals("F5") == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1114:0x1577, code lost:
    
        if (r12.equals("F3") == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1116:0x1581, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20593oxxXoxO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1118:0x158b, code lost:
    
        if (r12.equals("F1") == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0205, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20629xOxxXO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1120:0x1595, code lost:
    
        if (r12.equals("B9") == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1122:0x159f, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20601x0o) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1124:0x15ae, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20640xo0x) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1126:0x15b8, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20659xxOXOOoIX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1128:0x15c2, code lost:
    
        if (r12.equals("A8") == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1130:0x15cc, code lost:
    
        if (r12.equals("A7") == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1132:0x15d6, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xXIO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1134:0x15e0, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20487XO0OX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1136:0x15ea, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.o0Oox0xox) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1138:0x15f4, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.Xx0X) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x020f, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20595x00IOx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1140:0x15fe, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.ooIxOOoOo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1142:0x1608, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.X00O) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1144:0x1612, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OxxIXIX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1146:0x161c, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20455Oxo00O) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1148:0x1626, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OIO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x1f23, code lost:
    
        return com.sma.smartv3.co_fit.R.drawable.r3h_pair;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1150:0x1630, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oXo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1152:0x163a, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OO00XXI) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1154:0x1644, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.ooxI0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1156:0x164e, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xIo0xoOOx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1158:0x1658, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.IxIXo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1160:0x1662, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.ox0OIxO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1162:0x166c, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20514Xx0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1164:0x1676, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.IoooXox0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1166:0x1680, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1168:0x168a, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XoXX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0219, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20648xox) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1170:0x1694, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OOo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1172:0x169e, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xoxoXoxIo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1174:0x16a8, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XOXxX0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1176:0x16b2, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xx0IXxxx0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1178:0x16bc, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xOII) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1180:0x16c6, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XOX0x0XO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1182:0x16d0, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.IoOoo0XXX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1184:0x16da, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20510XoOxI0ox) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1186:0x16e4, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20473X0xOO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1188:0x16ee, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OIXo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0223, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.o0ooO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1190:0x16f8, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20513Xx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1192:0x1702, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oOI0IXOO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1194:0x170c, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OOxOXI0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1196:0x1716, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.Oox0oOO0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1198:0x1720, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.o0o) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1200:0x172a, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OOxxOOX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1202:0x1734, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oXXI0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1204:0x173e, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20507XoI0Ixx0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1206:0x1748, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.O00Ix) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1208:0x1752, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oIxIO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x022d, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oxI0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1210:0x175c, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20421OOOox) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1212:0x1766, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.Ixo0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1214:0x1770, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OIx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1216:0x177a, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.IOXX00X) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1218:0x1784, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.Ooxxx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1220:0x178e, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oIxXX0Xo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1222:0x1798, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20538oI0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1224:0x17a2, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20616xIoXXXIXo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1226:0x17ac, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XxxoIooX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1228:0x17b6, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XxOX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0237, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20566oXIoIo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1230:0x17c0, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.IxIXoo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1232:0x17ca, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.Oxx0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1234:0x17d4, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20575oo00) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1236:0x17de, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20656xx0o0O) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1238:0x17e8, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20377IoxX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1240:0x17f2, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.IX0OOX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1242:0x17fc, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.x00X) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1244:0x1806, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.x00o) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1246:0x1810, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OxXOoO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1248:0x181a, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.x0Ox) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0241, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.Iox) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1250:0x1824, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.Oo0I0Io) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1252:0x182e, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.IIX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1254:0x1838, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XOIIOIx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1256:0x1842, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xxX0X) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1258:0x184c, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.I0IIXxxo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1260:0x1856, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.IO00xOx0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1262:0x1860, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.Xoo0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1264:0x186a, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OxI0000XO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1266:0x1874, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20351IO0xX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1268:0x187e, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xXOO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x024b, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20492XOxIOxOx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1270:0x1888, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.IooOI0x) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1272:0x1892, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OIo0o) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1274:0x189c, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XoI0OoX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1276:0x18a6, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20414OIxOX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1278:0x18b0, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oIIo0xX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x15a3, code lost:
    
        return com.sma.smartv3.co_fit.R.drawable.b5c_pair;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1280:0x18ba, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xoO0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1282:0x18c4, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XXOOoxx0x) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1284:0x18ce, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OIxOo0XI) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1286:0x18d8, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OIOIxOO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1288:0x18e2, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.IX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1290:0x18ec, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XIX0Oo0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1292:0x18f6, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20364IXXIXx00I) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1294:0x1900, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xoOx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1296:0x190a, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20356IOo0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1298:0x1914, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.IoIxoI) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0255, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20398O0Xx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0043, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.O0x0XII) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1300:0x191e, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.Oo0OxoOx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1302:0x1928, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20333I0OO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1304:0x1932, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20612xIXIOX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1306:0x193c, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OOxXo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1308:0x1946, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xxXooOI) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1310:0x1950, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.x0I0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1312:0x195a, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.O00oxX0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1314:0x1964, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20471X0x) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1316:0x196e, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xXxox) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1318:0x1978, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20645xoX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x025f, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oIx0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1320:0x1982, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.IxXxoIIO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1322:0x198c, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20429OX00o0X) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1327:0x19a0, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.Oo00XooIO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1329:0x19aa, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xIoIxoO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1331:0x19b4, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.IxxXI0o) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1333:0x19be, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20428OX00O0xII) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1335:0x19c8, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xI00o) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1337:0x19d2, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.x0ooOIxO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1339:0x19dc, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.O00X) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0269, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xoO0X) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1341:0x19e6, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20330I00O) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1343:0x19f0, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20576oo0oIXo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1345:0x19fa, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20591oxXx0IX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1347:0x1a04, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xOo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1349:0x1a0e, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OxoOX0X0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1351:0x1a18, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xOO0X) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1353:0x1a22, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xxXxI) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1355:0x1a2c, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OIOxOX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1357:0x1a36, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XIoox00ox) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1359:0x1a40, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.I0I0IoIXO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0273, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XxI0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1361:0x1a4a, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.IO0Xox) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1363:0x1a54, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20653xx00oOoI) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1365:0x1a5e, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oIXx0o) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1367:0x1a68, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xO0x00ox) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1369:0x1a72, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OIOO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x13ce, code lost:
    
        return com.sma.smartv3.co_fit.R.drawable.v2_pair;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1371:0x1a7c, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20589oxOIoIx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1373:0x1a86, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20539oI00o) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1375:0x1a90, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OxIOX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1377:0x1a9a, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oIO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1379:0x1aa4, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.IOxxIx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1381:0x1aae, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.IXoxO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1383:0x1ab8, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OXoIOx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1385:0x1ac2, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OOI) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1387:0x1acc, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20468X0OXX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1389:0x1ad6, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20485XO0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x027d, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XXOo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1391:0x1ae0, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.I0XIOxXXX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1393:0x1aea, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XxOOoxOO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1395:0x1af4, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XIX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1397:0x1b03, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20378Ioxxx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1399:0x1b0d, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XOOI) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1401:0x1b17, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oxX0o) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1403:0x1b21, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20493XOxoX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1405:0x1b2b, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20572oXxOXOX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1407:0x1b35, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20355IOXOxOII) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1409:0x1b3f, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.IOxoo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x0287, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.IxOOI0Xo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1411:0x1b49, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.IXXxo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1413:0x1b53, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20367IXxOIOO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1415:0x1b5d, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20416OO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1417:0x1b67, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XX00xxo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1419:0x1b71, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.IOxoXoI) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1421:0x1b7b, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.ooOIo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1423:0x1b85, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XoOoxI0X) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1425:0x1b8f, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oXOxox) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1427:0x1b99, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OXOXxxOOO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1429:0x1ba3, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.Xx0I) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x0291, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20610xII) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1431:0x1bad, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xIxxxX0O) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1433:0x1bb7, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OxIoXo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1435:0x1bc2, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oox) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1437:0x1bcc, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.O0o0OO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1439:0x1bdb, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20491XOx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x1d6f, code lost:
    
        return com.sma.smartv3.co_fit.R.drawable.b5c_long_pair;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1441:0x1bea, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.x0x) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1443:0x1bf4, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20666xxxoo0XI) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1445:0x1bfe, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20438OoI0OO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1447:0x1c08, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20534o0xIoII) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1449:0x1c12, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.X0XI) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1451:0x1c1c, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oIo0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1453:0x1c26, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20486XO00XOO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1455:0x1c30, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20464X00xOoXI) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1457:0x1c3a, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.x000OxX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1459:0x1c44, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oooIXI0o) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x029b, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20360IXIIo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1461:0x1c4e, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20340II0xO0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1463:0x1c5d, code lost:
    
        if (r12.equals("SMA-F2") == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1465:0x1c67, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OX0xI0IO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1467:0x1c71, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OOOxXxoO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1469:0x1c7b, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20664xxx00) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x1bdf, code lost:
    
        return com.sma.smartv3.co_fit.R.drawable.b9_pair;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1471:0x1c8a, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.o0oo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1473:0x1c94, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OxXIO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1475:0x1c9e, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.IxoooIO0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1477:0x1ca8, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.IIIo0Xo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1479:0x1cb2, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oOI0ooOO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1481:0x1cbc, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XoO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1483:0x1cc6, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oXIOxo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1485:0x1cd0, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xxo0o) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1487:0x1cda, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xoOX00) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1489:0x1ce4, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XoXOIx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x02a5, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oO0XoIX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1491:0x1cee, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XIx0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1493:0x1cf8, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xoooOIO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1495:0x1d02, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20660xxX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1497:0x1d11, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.I0OXXIoX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1499:0x1d20, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OxXIoIX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1501:0x1d2a, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OxI0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1503:0x1d34, code lost:
    
        if (r12.equals("PARIGI") == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1505:0x1d3e, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20518XxIOX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1507:0x1d48, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XIxIO0XO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1509:0x1d57, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.ox0xI00IX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x02af, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oXIxoOo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1511:0x1d61, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20489XOOO0O) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1513:0x1d6b, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20413OIxOIX0II) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1515:0x1d7a, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20384IxIo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1517:0x1d84, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XOxxxx00X) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1519:0x1d8e, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xXoOoxXIX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1521:0x1d98, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oIOIO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1523:0x1da2, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20552oO0OX0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1525:0x1db1, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XIOX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1527:0x1dbb, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oIxXXOI) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1529:0x1dc5, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20499XXO0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x02b9, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.ooXOOxo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1531:0x1dcf, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20585ox0I) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1533:0x1dd9, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20637xXoOI00O) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1535:0x1de3, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.o0OoX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1537:0x1ded, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oX0IoO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1539:0x1df7, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20329I0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1541:0x1e01, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xoxX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1543:0x1e0b, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oIXIXIxx0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1545:0x1e15, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.Ix0XO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1547:0x1e1f, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20561oX000x) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1549:0x1e29, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20415OIxx0I0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x02c3, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.IxXXI0Xo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1551:0x1e33, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.IoO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1553:0x1e3d, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oxox0OIx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1555:0x1e47, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XIXIo0OX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1557:0x1e51, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.I0XIOxO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1559:0x1e5b, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20611xIOXX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1561:0x1e6a, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.IIIXXXII) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1563:0x1e74, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oII00xox) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1565:0x1e83, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xxXI) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1567:0x1e8d, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XOOXX0II) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1569:0x1e97, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xOxXOOIx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x02cd, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OxX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1571:0x1ea1, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xoOxO0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1573:0x1eab, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oI0xoXO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1575:0x1eb5, code lost:
    
        if (r12.equals("JX621D") == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1577:0x1ebf, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oIoox0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1579:0x1ec9, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XIo0IOI0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1581:0x1ed3, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20362IXO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1583:0x1edc, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.IX0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1585:0x1ee5, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xooxxo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1587:0x1eee, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oOIxIIoI) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1589:0x1ef7, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XOOooo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x02d7, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XOOxX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1591:0x1f05, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.x0I) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1593:0x1f0e, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20375IoXO0XoX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1595:0x1f17, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20651xx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1597:0x1f20, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20388IxX00) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1599:0x1f2d, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20411OIx0xoOo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x004d, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.IoXIo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x02e1, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.IIxO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x1e78, code lost:
    
        return com.sma.smartv3.co_fit.R.drawable.a8_pair_3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x02eb, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.I00XxoO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x02f5, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XOoxOo0oX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x02ff, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OOxIO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x0309, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20663xxx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x1d4c, code lost:
    
        return com.sma.smartv3.co_fit.R.drawable.f13b_pair;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x0317, code lost:
    
        return com.sma.smartv3.co_fit.R.drawable.pic_pair_confirm_2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x0313, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20386IxOIO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x0322, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.O0IIO0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x032c, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.X0oxOX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x0a18, code lost:
    
        return com.sma.smartv3.co_fit.R.drawable.fc_pair;
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x0336, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XIo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x0340, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xo0OI) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x034a, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.IoxoI0IX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x0354, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OIXXIXxX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x035e, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.I0X0Ox) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x0368, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.O0XOI) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0057, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20533o0xIIX0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x0372, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.O0OO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x037c, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.Xx0O0O) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x0386, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.Xx0OXIoI) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x0390, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XXOO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:199:0x039a, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XxIO0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x1da6, code lost:
    
        return com.sma.smartv3.co_fit.R.drawable.f6_pair_2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:204:0x03ae, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20553oOIXoIXXI) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:206:0x03b8, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20434OXxx0OO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:208:0x03c2, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.IxXOO0o0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:210:0x03cc, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.IXoXxxO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:212:0x03d6, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20505Xo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:213:0x1508, code lost:
    
        return com.sma.smartv3.co_fit.R.drawable.power_g1_pair;
     */
    /* JADX WARN: Code restructure failed: missing block: B:215:0x03e0, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xoI) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:217:0x03ea, code lost:
    
        if (r12.equals("GT WATCH PLUS") == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:219:0x03f4, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20393O0IxXx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0061, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20481XIo0oOXIx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:221:0x03fe, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.IxIOOxO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:223:0x0408, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XoIxo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:225:0x0412, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OXooXOXx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:227:0x041c, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oxxX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:229:0x0426, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oO0o) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:231:0x0430, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20519XxIo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:233:0x043a, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.O0o) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:235:0x0444, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.IxxOI) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:237:0x044e, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xOxxIxxI0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:239:0x0458, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20349IO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:241:0x0462, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20623xOOxI) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:243:0x046c, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.O0XX0IX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:245:0x0476, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oOIoXOoI) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:247:0x0480, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oXIo0X0x) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:249:0x048a, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oIOXxOI) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x006b, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XoOOxOo0o) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:251:0x0494, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xXIxxo0x) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:253:0x049e, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xIxO0X0I) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:255:0x04a8, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oOXOxxoxO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:257:0x04b2, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20496XX0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:259:0x04bc, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xXooxOx0O) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:261:0x04c6, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OIx0IoOx0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:263:0x04d0, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oI0xOX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:265:0x04df, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xXXXox) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:267:0x04e9, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oxOII) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:269:0x04f3, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20419OOIXx0x) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0075, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20618xIx0XO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:271:0x04fd, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.O0XI00X0o) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:273:0x0507, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20418OO0x0xX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:275:0x0511, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OXX0xxo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:277:0x051c, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XIOxIIxxI) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:279:0x0526, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.IIoIIxx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x13dd, code lost:
    
        return com.sma.smartv3.co_fit.R.drawable.f3_pair;
     */
    /* JADX WARN: Code restructure failed: missing block: B:281:0x0530, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xoOI00O0X) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:283:0x053a, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20619xIxooxXX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:285:0x0544, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xxIOxXI) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:287:0x054e, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.IooOox) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:289:0x0558, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oXIX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:291:0x0562, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20352IOI) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:293:0x056c, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.O0xOXxxx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:295:0x0576, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.X0xXOX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:297:0x0580, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.Ix00) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:299:0x058a, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20620xOI0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x007f, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xXO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:301:0x0594, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xo0xII0II) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:303:0x059e, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.X0oX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:305:0x05a8, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.o00Ox0xOO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:307:0x05b7, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xoXXXIX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:309:0x05c1, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20603x0oxIIIX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:310:0x1e5f, code lost:
    
        return com.sma.smartv3.co_fit.R.drawable.m7_pair;
     */
    /* JADX WARN: Code restructure failed: missing block: B:312:0x05cb, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20366IXoIo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:313:0x1c7f, code lost:
    
        return com.sma.smartv3.co_fit.R.drawable.m4_pair;
     */
    /* JADX WARN: Code restructure failed: missing block: B:315:0x05d5, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.o0OXIoI) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:317:0x05df, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XoXIXxxI0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:319:0x05e9, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OXI0XXxIo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0089, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oxoIOxO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:321:0x05f3, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.IXOO0X0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:323:0x05fd, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.IoOIIOx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:325:0x0607, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20625xOoIIIoXI) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:327:0x0611, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oxOX0OXx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:329:0x061b, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20641xoIXOxX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:331:0x0625, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20554oOIx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:333:0x062f, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20425OOxOI) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:335:0x0639, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OIO0XIo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:337:0x0643, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XOXo0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:338:0x1d15, code lost:
    
        return com.sma.smartv3.co_fit.R.drawable.f17_pair;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0093, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20628xOxOoo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:340:0x064d, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OxIXxXXI0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:342:0x0657, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OIXO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:344:0x0661, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xOx0oO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:346:0x066b, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.O0x0XXxI) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:348:0x0675, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20436Oo0IXI0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:350:0x067f, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.IOOx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:352:0x0689, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xxIOx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:354:0x0693, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.Ix) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:356:0x069d, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20430OXIOoo0X0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:358:0x06a7, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20632xX0ox) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:360:0x06b1, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20376IoxOx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:362:0x06bb, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20462X00IoxXI) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:364:0x06c5, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.O000IX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:366:0x06cf, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xIxxXXxx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:368:0x06d9, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xOIIO0x) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x009d, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xXOXOOx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:370:0x06e3, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.IXXxOX00X) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:372:0x06ed, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.X0Ix00XxO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:374:0x06f7, code lost:
    
        if (r12.equals("G7 Talk PRO") == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:376:0x0701, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XoOo0Ooo0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:378:0x070b, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xXOOx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:380:0x0715, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xIXXIo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:382:0x071f, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XxxoXoX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:384:0x0729, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20598x0OOI) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:386:0x0733, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XxoOX0I) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:388:0x073d, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.II0XIox) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00a7, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XI0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:390:0x0747, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oI0XoXIXo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:392:0x0751, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xxxIO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:397:0x076a, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.IIXxoXXox) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:399:0x0774, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XXO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:401:0x077e, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OoIO0OIX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:403:0x0788, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20512XooIO0oo0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:405:0x0792, code lost:
    
        if (r12.equals("GF03Pro") == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:407:0x079c, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XOxoXO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:409:0x07a6, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xo0Xo0xo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00b1, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20582oox000IX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:411:0x07b0, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20348IIxOXoOo0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:413:0x07ba, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20359IXI) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:415:0x07c4, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20405OI0IXox) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:417:0x07ce, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20523o0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:419:0x07d8, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20443OooO0XOx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:421:0x07e3, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OOXx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:423:0x07ee, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.o0xIXX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:428:0x0807, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.X0OXoo0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00bb, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xOOxX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:430:0x0811, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.Xooo0Xx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:432:0x081b, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.Oxxx0X0oI) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:434:0x0825, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.x0XOOIXXO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:436:0x082f, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oIIXxXIox) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:438:0x0839, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XXoIoXOO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:440:0x0843, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oIxXOO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:442:0x084d, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OOI00oxoO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:444:0x0857, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20583ox) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:446:0x0861, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20358IOooo0o) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:448:0x086b, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XIIxXO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00c5, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XO000) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:450:0x0875, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20504XXx0OXXXo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:452:0x087f, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.I0XOIOO0I) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:454:0x0889, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oIoIxo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:456:0x0893, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20543oIX0o) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:458:0x089d, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20647xooxxX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:460:0x08a7, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20644xoO0xx0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:462:0x08b1, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.I00I) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:464:0x08bb, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oII) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:466:0x08c5, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20466X0IOOI) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:468:0x08cf, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20448Ox00XOXoo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00cf, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oxoxO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:473:0x08e8, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oIXXo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:475:0x08f2, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oX0XO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:477:0x08fc, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OOOO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:479:0x0906, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20587oxIO0IIo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:481:0x0910, code lost:
    
        if (r12.equals("SMA-F1RT") == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:483:0x091a, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.ooO00o) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:485:0x0924, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20482XIxO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:487:0x092e, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oxXIOXO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:489:0x0938, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xIOI0xO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00d9, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XIxI) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:491:0x0942, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.o0x0XOXx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:493:0x094c, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oIIOI) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:495:0x0956, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OoooxII) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:497:0x0960, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.ooIoIX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:499:0x096a, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oIxIOoOx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:501:0x0974, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.IxxOIX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:503:0x097e, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.Xox0o) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:505:0x0988, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.x0X0OIOx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:507:0x0992, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xX0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:509:0x099c, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.o00OI00) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00e3, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.Xo0OOoo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:511:0x09a6, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20652xx0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:513:0x09b0, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20527o0OO0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:515:0x09ba, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20525o00xOoIO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:517:0x09c4, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OOIX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:519:0x09ce, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20650xoxo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:521:0x09d8, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20564oX0ooo0I0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:523:0x09e2, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20495XX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:525:0x09ec, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.O0OO0Ox) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:527:0x09f6, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oxoo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:529:0x0a00, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.IXx0oOO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00ed, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xOIXxOo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:531:0x0a0a, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XXIo0OO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:533:0x0a14, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.ooOxox) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:535:0x0a23, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OOX0x) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:537:0x0a2d, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xx0XoXxI) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:538:0x1af8, code lost:
    
        return com.sma.smartv3.co_fit.R.drawable.s4_pair;
     */
    /* JADX WARN: Code restructure failed: missing block: B:540:0x0a37, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.o0Xo0XII) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:542:0x0a41, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20338II0OOXOx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:544:0x0a4b, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20573oXxx000) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:546:0x0a55, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oxI0OxXoO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:548:0x0a5f, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.Io00oOXox) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00f7, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.Ixox0x) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:550:0x0a69, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.IO00) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:552:0x0a73, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oI0XIox) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:554:0x0a7d, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oXO0x) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:556:0x0a87, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.IXx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:558:0x0a91, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OxXIoIxIo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:560:0x0a9b, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oXX0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:562:0x0aa5, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OXxo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:564:0x0aaf, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20528o0Oo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:566:0x0ab9, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XxxXX0XO0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:567:0x0ac7, code lost:
    
        return com.sma.smartv3.co_fit.R.drawable.r1_fc1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:569:0x0ac3, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.IoXIOXo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0101, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oXx0XOX0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:571:0x0ad2, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.X000ooOxx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:573:0x0adc, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.IooOO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:575:0x0ae6, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OOxXXO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:577:0x0af0, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20562oX0I0O) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:579:0x0afa, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20334I0X0x0oIo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:581:0x0b04, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OXxIOxox) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:583:0x0b0e, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xoIooI0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:585:0x0b18, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.X0xO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:587:0x0b22, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.IOxO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:589:0x0b2c, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.O0I) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x010b, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20432OXXoIoXI) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:591:0x0b36, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OI0xX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:593:0x0b40, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.I0o0xoIIx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:595:0x0b4a, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20509XoOOx0IX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:597:0x0b54, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20395O0OOX0IIx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:599:0x0b5e, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20470X0ooXIooI) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:601:0x0b68, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20342IIOIX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:603:0x0b72, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20446OoxxX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:604:0x0ef0, code lost:
    
        return com.sma.smartv3.co_fit.R.drawable.lg19t_pair;
     */
    /* JADX WARN: Code restructure failed: missing block: B:606:0x0b7c, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OoIo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:608:0x0b86, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20467X0O0I0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0115, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20516XxI) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:610:0x0b90, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20453OxO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:612:0x0b9a, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.IoxxXOO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:614:0x0ba4, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.ooXXoOx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:616:0x0bae, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.Ox0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:618:0x0bb8, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xxo00) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:620:0x0bc2, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XoI0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:622:0x0bcc, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.o0Ixx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:624:0x0bd6, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20391O00XxXI) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:626:0x0be0, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20379Ix0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:628:0x0bea, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.IIoOIO0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x011f, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XOo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:630:0x0bf4, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.IoXIOI0O) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:632:0x0bfe, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oo0I0oI) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:634:0x0c08, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xxXIIXIxx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:636:0x0c12, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.Xo00XX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:638:0x0c1c, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oX0Ox) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:640:0x0c26, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.Ioo0OxIo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:642:0x0c30, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XIx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:644:0x0c3a, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.IoxOXXxXo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:646:0x0c44, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.x0IOX0o) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:648:0x0c4e, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20454OxXXx0X) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0129, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xXx0x0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:650:0x0c58, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.X0oO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:652:0x0c62, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xxXX0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:654:0x0c6c, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20424OOoOoO0o) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:656:0x0c76, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.IXOXoIo0x) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:661:0x0c8f, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.I0xoOOIx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:663:0x0c99, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20412OIxI0O) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:665:0x0ca3, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20588oxO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:667:0x0cad, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XoOoxIIx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:669:0x0cb7, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OO00xO0I) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0133, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OXoIXx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:671:0x0cc1, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xo0oXIOO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:673:0x0ccb, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XOx0xX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:675:0x0cd5, code lost:
    
        if (r12.equals("AM02J") == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:677:0x0cdf, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xIIoO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:679:0x0ce9, code lost:
    
        if (r12.equals("AM01J") == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:681:0x0cf3, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.o0I) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:686:0x0d07, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XXI0XXo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:688:0x0d11, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.ooO0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x013d, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20420OOOI) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:690:0x0d1b, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oxIXXxXx0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:692:0x0d25, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OIX0oXO0o) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:694:0x0d2f, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.II) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:696:0x0d39, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OIxooI0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:698:0x0d43, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20372IoOoo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x002f, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oo0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:700:0x0d4d, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oXIOOxX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:701:0x11d4, code lost:
    
        return com.sma.smartv3.co_fit.R.drawable.pic_pair_confirm_3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:703:0x0d57, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OXO0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:705:0x0d61, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.x0X) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:707:0x0d6b, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.IXooXOxI0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:709:0x0d75, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xIO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0147, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20354IOOoXo0Ix) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:711:0x0d7f, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20341IIIxO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:713:0x0d89, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20361IXIxx0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:715:0x0d93, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oooO0ox) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:717:0x0d9d, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oIO0X00) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:719:0x0da7, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xX0Oo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:721:0x0db1, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.x0x000) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:723:0x0dbb, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.IOoXX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:725:0x0dc5, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20634xXOx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0151, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.O0oXOX0XX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:730:0x0dde, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.I000X) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:732:0x0de8, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XXoo0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:734:0x0df2, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xIOOoxxxO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:736:0x0dfc, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OIo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:738:0x0e06, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XxX0xI) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:740:0x0e10, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.IIOXx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:742:0x0e1a, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20613xIXOoI) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:743:0x1189, code lost:
    
        return com.sma.smartv3.co_fit.R.drawable.nd08_pair;
     */
    /* JADX WARN: Code restructure failed: missing block: B:745:0x0e24, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.Io0OXxX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:747:0x0e2e, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oOO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:749:0x0e38, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xOxIxO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x015b, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20617xIx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:751:0x0e42, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20363IXX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:753:0x0e4c, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20452OxIxx0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:755:0x0e56, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.IO0000X0X) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:757:0x0e60, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OI0OIIo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:759:0x0e6a, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20385IxO0Oxo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:761:0x0e74, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20606x0xOIoO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:763:0x0e7e, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20347IIoX0OoI) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:765:0x0e88, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20661xxXXXxIxo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:767:0x0e92, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xxooOxoO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:769:0x0e9c, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OXxO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0165, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20501XXoO0oX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:771:0x0ea6, code lost:
    
        if (r12.equals("NY58") == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:773:0x0eb0, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20490XOo0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:775:0x0eba, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20381Ix0x) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:777:0x0ec4, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XOX0XxOxI) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:779:0x0ece, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.I0Xo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:781:0x0ed8, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.I0IoX00I) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:783:0x0ee2, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.ooOO0I0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:785:0x0eec, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20563oX0O) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:787:0x0efb, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20383IxIX0I) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:789:0x0f05, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20401O0xO0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x016f, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.Xo0oxxX0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:791:0x0f0f, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xIOOIO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:793:0x0f19, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xooXo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:795:0x0f23, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XxxIX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:797:0x0f2d, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OOox) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:799:0x0f37, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OooOoX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x1efa, code lost:
    
        return com.sma.smartv3.co_fit.R.drawable.f12pro_pair;
     */
    /* JADX WARN: Code restructure failed: missing block: B:801:0x0f41, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.IOIOooXOx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:803:0x0f4b, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xXOoI) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:805:0x0f55, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XooooIO0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:807:0x0f5f, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20578ooO0oXxI) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:809:0x0f69, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OIXI) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:811:0x0f73, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XXoXOI) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:813:0x0f7d, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.IIxOxOx0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:815:0x0f87, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.ooIx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:817:0x0f91, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.Ix0Xx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:819:0x0f9b, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XxOx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0179, code lost:
    
        if (r12.equals("F12Pro") == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:821:0x0fa5, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xxI0x) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:823:0x0faf, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.x0OI) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:825:0x0fb9, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oo00Io) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:827:0x0fc3, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OOoxI) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:829:0x0fcd, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20599x0OxxIOxX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:831:0x0fd7, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OoXX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:833:0x0fe1, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OI) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:835:0x0feb, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20431OXOo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:837:0x0ff5, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20602x0oox0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:839:0x0fff, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.X0OxoOx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0183, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.I0o) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:841:0x1009, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.O0OOoIox) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:843:0x1013, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20502XXoOx0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:845:0x101d, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XxIX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:847:0x1027, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20369Io) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:849:0x1031, code lost:
    
        if (r12.equals("F13B") == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:851:0x103b, code lost:
    
        if (r12.equals("F13A") == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:853:0x1045, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oXOXo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:855:0x104f, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xOII0IIX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:857:0x1059, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oxo0x0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:859:0x1063, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oOo0o) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x018d, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.IxX0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:861:0x106d, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.Oo0oOO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:863:0x1077, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xxoxO0O) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:865:0x1081, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OXxIXOxO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:867:0x108b, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xXXI0IX00) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:869:0x1095, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oXx0oXXo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x1bd0, code lost:
    
        return com.sma.smartv3.co_fit.R.drawable.am08_pair;
     */
    /* JADX WARN: Code restructure failed: missing block: B:871:0x109f, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xo0Io0Ooo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:873:0x10a9, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oXxo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:875:0x10b3, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.X0OIo0XxO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:877:0x10bd, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XXoOOO0I) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:879:0x10c7, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oxOoo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:881:0x10d1, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oIo0x) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:883:0x10db, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.x0oo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:885:0x10e5, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XIOOX0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:887:0x10ef, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XIxOIII) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:889:0x10f9, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XXOXXx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0197, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OO00) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:891:0x1103, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.x0o0O0Oo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:893:0x110d, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XxXOXo0Xx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:895:0x1117, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.I0XOx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:897:0x1121, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xOOxIoOoO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:899:0x112b, code lost:
    
        if (r12.equals("AM11") == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:901:0x1135, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XIIOIXoI) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:903:0x113f, code lost:
    
        if (r12.equals("AM08") == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:905:0x1149, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xoxX0I) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:907:0x1153, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XOIoXxI) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:909:0x115d, code lost:
    
        if (r12.equals("AM05") == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01a1, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xXXXxOOI0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:911:0x1167, code lost:
    
        if (r12.equals("AM01") == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:913:0x1171, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.IOoxOXXx0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:915:0x117b, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.x0XIoX00) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:917:0x1185, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20382IxI) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:919:0x1194, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.Xo000XO0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:921:0x119e, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OoOoxX0xo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:923:0x11a8, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XOOoX0xo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:925:0x11b2, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.x0XOxo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:927:0x11bc, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xxxoXXo0X) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:929:0x11c6, code lost:
    
        if (r12.equals("T78") == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01ab, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oXOxO0XXo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:931:0x11d0, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.I00) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:933:0x11df, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OIIOOoXx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:935:0x11e9, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.o0IXO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:937:0x11f3, code lost:
    
        if (r12.equals("R9J") == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:939:0x11fd, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xIX0XOOX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:941:0x1207, code lost:
    
        if (r12.equals("R3H") == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:943:0x1211, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OxII) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:945:0x121b, code lost:
    
        if (r12.equals("R21") == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:947:0x1225, code lost:
    
        if (r12.equals("R16") == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:949:0x122f, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20488XO0o) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01b5, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.Xo0IXOO00) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:951:0x1239, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20506Xo0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:953:0x1243, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20380Ix00oIoI) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:955:0x124d, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.IIXOxX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:957:0x1257, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.IxoXXoXo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:959:0x1261, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XIxIOOOx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:961:0x126b, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20537oI) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:963:0x1275, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.o0XxxOIx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:965:0x127f, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20536o0xxxXXxX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:967:0x1289, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.XOX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:969:0x1293, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20551oO0IXx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01bf, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.OxoIO00) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:971:0x129d, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20498XXIoX0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:973:0x12a7, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oXx00I) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:975:0x12b1, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20636xXo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:977:0x12bb, code lost:
    
        if (r12.equals("FC2") == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:979:0x12c5, code lost:
    
        if (r12.equals("FC1") == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:981:0x12cf, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.IoXOxx0o) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:983:0x12d9, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20353IOOXOOOOo) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:985:0x12e3, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20373IoX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:987:0x12ed, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20580ooOx) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:989:0x12f7, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20477XI0oooXX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01c9, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.oXXX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:991:0x1301, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.f20423OOXIxO0) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:993:0x130b, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.xoxXoXO) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:997:0x131d, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.I00oX) == false) goto L4801;
     */
    /* JADX WARN: Code restructure failed: missing block: B:999:0x1327, code lost:
    
        if (r12.equals(com.sma.smartv3.ble.ProductManager.IX0IO) == false) goto L4801;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:1603:0x1f39. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0024. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:22:0x133f A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int XO(@OXOo.oOoXoXO java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 11174
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ble.ProductManager.XO(java.lang.String):int");
    }

    @OOXIXo
    public final String XO0(@OOXIXo String titleStr) {
        IIX0o.x0xO0oo(titleStr, "titleStr");
        switch (titleStr.hashCode()) {
            case -1671190941:
                if (titleStr.equals("openAIService")) {
                    return UtilsKt.oI0IIXIo(R.string.chatgpt);
                }
                break;
            case -361646967:
                if (titleStr.equals("deepseekAIService")) {
                    return UtilsKt.oI0IIXIo(R.string.pay_dail_aigc_deep_seek);
                }
                break;
            case -345876046:
                if (titleStr.equals("baiduAIService")) {
                    return UtilsKt.oI0IIXIo(R.string.wenxinyiyan);
                }
                break;
            case 1088442160:
                if (titleStr.equals("sparkAIService")) {
                    return UtilsKt.oI0IIXIo(R.string.ai_model_spark_desk);
                }
                break;
        }
        if (titleStr.length() <= 0) {
            return UtilsKt.oI0IIXIo(R.string.pay_dail_aigc_modle);
        }
        return titleStr;
    }

    public final boolean XO00XOO() {
        return !IIX0o.Oxx0IOOO(BleCache.INSTANCE.getMBleName(), f20648xox);
    }

    public final boolean XO0OX() {
        if (BleCache.INSTANCE.getMSupportLoveTap() == 1) {
            return true;
        }
        return false;
    }

    public final boolean XO0o() {
        String str;
        MacConfig macConfig;
        DeviceConfigInfo IOoo2 = IOoo();
        if (IOoo2 != null && (macConfig = IOoo2.getMacConfig()) != null) {
            str = macConfig.getAiModelService();
        } else {
            str = null;
        }
        return IIX0o.Oxx0IOOO(str, "sparkAIService");
    }

    public final boolean XOOO0O() {
        return false;
    }

    public final boolean XOo0() {
        if (BleCache.INSTANCE.getMSupportDrinkWaterSet() == 1) {
            return true;
        }
        return false;
    }

    public final boolean XOx() {
        if (O0o0().length() != 0 && !IIX0o.Oxx0IOOO(O0o0(), "") && !IIX0o.Oxx0IOOO(O0o0(), "-1")) {
            return oOXoIIIo.I0Io.II0xO0(Integer.parseInt(O0o0()));
        }
        XooIO0oo0();
        return false;
    }

    public final int XOxIOxOx() {
        BleCache.INSTANCE.getMPrototype();
        return 6;
    }

    public final boolean XOxoX() {
        if (BleCache.INSTANCE.getMShowAntiLostSwitch() == 1) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0076 A[Catch: Exception -> 0x002a, TryCatch #0 {Exception -> 0x002a, blocks: (B:2:0x0000, B:4:0x000e, B:7:0x001b, B:10:0x0032, B:12:0x0076, B:13:0x007a, B:15:0x0085), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0085 A[Catch: Exception -> 0x002a, TRY_LEAVE, TryCatch #0 {Exception -> 0x002a, blocks: (B:2:0x0000, B:4:0x000e, B:7:0x001b, B:10:0x0032, B:12:0x0076, B:13:0x007a, B:15:0x0085), top: B:1:0x0000 }] */
    @OXOo.OOXIXo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<com.sma.smartv3.model.WatchFaceInfo> XOxxooXI() {
        /*
            r10 = this;
            com.sma.smartv3.network.Api r0 = com.sma.smartv3.network.Api.INSTANCE     // Catch: java.lang.Exception -> L2a
            java.lang.String r1 = r0.getBASE_URL()     // Catch: java.lang.Exception -> L2a
            java.lang.String r2 = "https://ceshi.smawatch.cn/kotlinweb"
            boolean r1 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r1, r2)     // Catch: java.lang.Exception -> L2a
            if (r1 != 0) goto L30
            java.lang.String r1 = r0.getBASE_URL()     // Catch: java.lang.Exception -> L2a
            java.lang.String r2 = "https://dev.iot-solution.net/kotlinweb"
            boolean r1 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r1, r2)     // Catch: java.lang.Exception -> L2a
            if (r1 == 0) goto L1b
            goto L30
        L1b:
            java.lang.String r0 = r0.getBASE_URL()     // Catch: java.lang.Exception -> L2a
            java.lang.String r1 = "https://api-usa.iot-solution.net/kotlinweb"
            boolean r0 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r0, r1)     // Catch: java.lang.Exception -> L2a
            if (r0 == 0) goto L2d
            java.lang.String r0 = "https://coding-usa-oss.iot-solution.net"
            goto L32
        L2a:
            r0 = move-exception
            goto Ld6
        L2d:
            java.lang.String r0 = "https://api-oss.iot-solution.net"
            goto L32
        L30:
            java.lang.String r0 = "https://test-oss.iot-solution.net"
        L32:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L2a
            r1.<init>()     // Catch: java.lang.Exception -> L2a
            r1.append(r0)     // Catch: java.lang.Exception -> L2a
            java.lang.String r0 = "/watchFace/WatchFaceType"
            r1.append(r0)     // Catch: java.lang.Exception -> L2a
            java.lang.String r0 = r1.toString()     // Catch: java.lang.Exception -> L2a
            com.google.gson.Gson r1 = new com.google.gson.Gson     // Catch: java.lang.Exception -> L2a
            r1.<init>()     // Catch: java.lang.Exception -> L2a
            java.lang.String r2 = "wft"
            java.lang.String r2 = com.blankj.utilcode.util.ResourceUtils.readAssets2String(r2)     // Catch: java.lang.Exception -> L2a
            com.sma.smartv3.ble.ProductManager$oIX0oI r3 = new com.sma.smartv3.ble.ProductManager$oIX0oI     // Catch: java.lang.Exception -> L2a
            r3.<init>()     // Catch: java.lang.Exception -> L2a
            java.lang.reflect.Type r3 = r3.getType()     // Catch: java.lang.Exception -> L2a
            java.lang.Object r1 = r1.fromJson(r2, r3)     // Catch: java.lang.Exception -> L2a
            java.lang.String r2 = "fromJson(...)"
            kotlin.jvm.internal.IIX0o.oO(r1, r2)     // Catch: java.lang.Exception -> L2a
            java.util.HashMap r1 = (java.util.HashMap) r1     // Catch: java.lang.Exception -> L2a
            com.szabh.smable3.component.BleCache r2 = com.szabh.smable3.component.BleCache.INSTANCE     // Catch: java.lang.Exception -> L2a
            int r2 = r2.getMWatchFaceType()     // Catch: java.lang.Exception -> L2a
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Exception -> L2a
            java.lang.Object r1 = r1.get(r3)     // Catch: java.lang.Exception -> L2a
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch: java.lang.Exception -> L2a
            r3 = 0
            if (r1 != 0) goto L7a
            java.lang.Integer r1 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Exception -> L2a
        L7a:
            int r1 = r1.intValue()     // Catch: java.lang.Exception -> L2a
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch: java.lang.Exception -> L2a
            r4.<init>(r1)     // Catch: java.lang.Exception -> L2a
        L83:
            if (r3 >= r1) goto Ld5
            int r5 = r3 + 1
            com.sma.smartv3.model.WatchFaceInfo r6 = new com.sma.smartv3.model.WatchFaceInfo     // Catch: java.lang.Exception -> L2a
            int r3 = r3 + 101
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L2a
            r7.<init>()     // Catch: java.lang.Exception -> L2a
            r7.append(r0)     // Catch: java.lang.Exception -> L2a
            java.lang.String r8 = "/preview/dial_"
            r7.append(r8)     // Catch: java.lang.Exception -> L2a
            r7.append(r2)     // Catch: java.lang.Exception -> L2a
            r8 = 95
            r7.append(r8)     // Catch: java.lang.Exception -> L2a
            r7.append(r5)     // Catch: java.lang.Exception -> L2a
            java.lang.String r8 = ".webp"
            r7.append(r8)     // Catch: java.lang.Exception -> L2a
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Exception -> L2a
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L2a
            r8.<init>()     // Catch: java.lang.Exception -> L2a
            r8.append(r0)     // Catch: java.lang.Exception -> L2a
            java.lang.String r9 = "/bin/dial_"
            r8.append(r9)     // Catch: java.lang.Exception -> L2a
            r8.append(r2)     // Catch: java.lang.Exception -> L2a
            java.lang.String r9 = "/dial"
            r8.append(r9)     // Catch: java.lang.Exception -> L2a
            r8.append(r5)     // Catch: java.lang.Exception -> L2a
            java.lang.String r9 = ".bin"
            r8.append(r9)     // Catch: java.lang.Exception -> L2a
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Exception -> L2a
            r6.<init>(r3, r7, r8)     // Catch: java.lang.Exception -> L2a
            r4.add(r6)     // Catch: java.lang.Exception -> L2a
            r3 = r5
            goto L83
        Ld5:
            return r4
        Ld6:
            r0.printStackTrace()
            java.util.List r0 = kotlin.collections.CollectionsKt__CollectionsKt.ooXIXxIX()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ble.ProductManager.XOxxooXI():java.util.List");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x01bc, code lost:
    
        if (r0.equals(com.sma.smartv3.ble.ProductManager.IIoO0x) == false) goto L316;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0242, code lost:
    
        return "default_1";
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0209, code lost:
    
        if (r0.equals(com.sma.smartv3.ble.ProductManager.oO0XxoI) == false) goto L316;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x021b, code lost:
    
        if (r0.equals(com.sma.smartv3.ble.ProductManager.x0IX) == false) goto L316;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x0224, code lost:
    
        if (r0.equals(com.sma.smartv3.ble.ProductManager.xX0O) == false) goto L316;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x023f, code lost:
    
        if (r0.equals(com.sma.smartv3.ble.ProductManager.xX0ooIII) == false) goto L316;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x029a, code lost:
    
        if (XxIo() != false) goto L323;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x02ac, code lost:
    
        if (XxIo() == false) goto L316;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x004c, code lost:
    
        if (XxIo() == false) goto L316;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x02be, code lost:
    
        if (XxIo() == false) goto L316;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x02de, code lost:
    
        if (XxIo() != false) goto L323;
     */
    /* JADX WARN: Code restructure failed: missing block: B:209:0x035c, code lost:
    
        if (r0.equals(com.sma.smartv3.ble.ProductManager.f20555oOXoIIIo) == false) goto L316;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006a, code lost:
    
        if (XxIo() == false) goto L316;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0094, code lost:
    
        if (XxIo() != false) goto L323;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x009d, code lost:
    
        if (r1.equals(com.szabh.smable3.entity.BleDeviceInfo.PROTOTYPE_AM22) == false) goto L316;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00fa, code lost:
    
        r0 = r0.getMBleName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0102, code lost:
    
        switch(r0.hashCode()) {
            case -1892957467: goto L411;
            case -1818891005: goto L407;
            case -1668118167: goto L404;
            case -1415426325: goto L400;
            case -1001155647: goto L397;
            case 2319506: goto L394;
            case 2319507: goto L391;
            case 2525807: goto L388;
            case 1884159604: goto L381;
            default: goto L316;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x010d, code lost:
    
        if (r0.equals(com.sma.smartv3.ble.ProductManager.XOOxX) != false) goto L384;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0114, code lost:
    
        if (XxIo() == false) goto L387;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0118, code lost:
    
        return com.sma.smartv3.ble.ProductManager.I0ox0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0120, code lost:
    
        if (r0.equals(com.sma.smartv3.ble.ProductManager.oOO) != false) goto L364;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0129, code lost:
    
        if (r0.equals(com.sma.smartv3.ble.ProductManager.oxoxxo) != false) goto L581;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:?, code lost:
    
        return com.sma.smartv3.ble.ProductManager.oxoxxo;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0132, code lost:
    
        if (r0.equals(com.sma.smartv3.ble.ProductManager.II0XOIoOO) != false) goto L582;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:?, code lost:
    
        return com.sma.smartv3.ble.ProductManager.II0XOIoOO;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x013b, code lost:
    
        if (r0.equals(com.sma.smartv3.ble.ProductManager.OIOIxOO) != false) goto L583;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:?, code lost:
    
        return "HAYLOU";
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0144, code lost:
    
        if (r0.equals(com.sma.smartv3.ble.ProductManager.oIO) != false) goto L403;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0147, code lost:
    
        return "GS3";
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0151, code lost:
    
        if (r0.equals(com.sma.smartv3.ble.ProductManager.xIxxxX0O) != false) goto L585;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:?, code lost:
    
        return "HAYLOU";
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x015a, code lost:
    
        if (r0.equals(com.sma.smartv3.ble.ProductManager.I0x0IOXO) != false) goto L410;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x015d, code lost:
    
        return "IT_WATCH_WR02";
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0167, code lost:
    
        if (r0.equals(com.sma.smartv3.ble.ProductManager.XIx0) != false) goto L587;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:?, code lost:
    
        return "HAYLOU";
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00ca, code lost:
    
        if (r0.equals(com.sma.smartv3.ble.ProductManager.OoIo) == false) goto L316;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x00f6, code lost:
    
        if (r1.equals("AM05") == false) goto L316;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0013. Please report as an issue. */
    @OXOo.OOXIXo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String XX() {
        /*
            Method dump skipped, instructions count: 1108
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ble.ProductManager.XX():java.lang.String");
    }

    public final int XX0() {
        return BleCache.INSTANCE.getMSupportMyCardCodeSize();
    }

    public final int XX0xXo() {
        return oOoIxI0x;
    }

    public final boolean XXIoX0() {
        if (IxI()) {
            BleCache bleCache = BleCache.INSTANCE;
            if (IIX0o.Oxx0IOOO(bleCache.getMBleAddress(), bleCache.getMClassicAddress())) {
                return true;
            }
        }
        return false;
    }

    public final boolean XXO0() {
        BleCache.INSTANCE.getMSupportRelaxReminder();
        return false;
    }

    @OOXIXo
    public final List<QrcodeTypeInfo> XXXI(@OOXIXo Context context, int i) {
        IIX0o.x0xO0oo(context, "context");
        ArrayList arrayList = new ArrayList();
        if (i != 1) {
            if (i == 2) {
                String string = context.getString(R.string.wechat);
                IIX0o.oO(string, "getString(...)");
                arrayList.add(new QrcodeTypeInfo(i, 2, R.drawable.icon_app_wechat, string, 0L, 0, null, 112, null));
                String string2 = context.getString(R.string.qq);
                IIX0o.oO(string2, "getString(...)");
                arrayList.add(new QrcodeTypeInfo(i, 3, R.drawable.icon_app_qq, string2, 0L, 0, null, 112, null));
                arrayList.add(new QrcodeTypeInfo(i, 4, R.drawable.icon_app_skype, "Skype", 0L, 0, null, 112, null));
                arrayList.add(new QrcodeTypeInfo(i, 5, R.drawable.icon_app_facebook, O0xxXxI.oIX0oI.f1498I0Io, 0L, 0, null, 112, null));
                arrayList.add(new QrcodeTypeInfo(i, 6, R.drawable.icon_app_twitter, "X", 0L, 0, null, 112, null));
                arrayList.add(new QrcodeTypeInfo(i, 7, R.drawable.icon_app_whatapp, "Whatsapp", 0L, 0, null, 112, null));
                arrayList.add(new QrcodeTypeInfo(i, 8, R.drawable.icon_app_line, "Line", 0L, 0, null, 112, null));
                arrayList.add(new QrcodeTypeInfo(i, 9, R.drawable.icon_app_ins, "Instagram", 0L, 0, null, 112, null));
            }
        } else if (oXX0IoI()) {
            arrayList.add(new QrcodeTypeInfo(i, 11, R.drawable.icon_app_paypal, "Paypal", 0L, 0, null, 112, null));
        } else {
            String string3 = context.getString(R.string.wechat);
            IIX0o.oO(string3, "getString(...)");
            arrayList.add(new QrcodeTypeInfo(i, 2, R.drawable.icon_app_wechat, string3, 0L, 0, null, 112, null));
            String string4 = context.getString(R.string.qq);
            IIX0o.oO(string4, "getString(...)");
            arrayList.add(new QrcodeTypeInfo(i, 3, R.drawable.icon_app_qq, string4, 0L, 0, null, 112, null));
            arrayList.add(new QrcodeTypeInfo(i, 10, R.drawable.icon_app_alipay, UtilsKt.oI0IIXIo(R.string.alipay_set), 0L, 0, null, 112, null));
            arrayList.add(new QrcodeTypeInfo(i, 11, R.drawable.icon_app_paypal, "Paypal", 0L, 0, null, 112, null));
        }
        return arrayList;
    }

    public final boolean XXoO0oX() {
        if (BleCache.INSTANCE.getMSupportVoice() == 1) {
            return true;
        }
        return false;
    }

    public final boolean XXoOx0() {
        return IIX0o.Oxx0IOOO(BleCache.INSTANCE.getMBleName(), f20413OIxOIX0II);
    }

    public final boolean XXooOOI() {
        if (BleCache.INSTANCE.getMSupportTouchSet() == 1) {
            return true;
        }
        return false;
    }

    public final boolean XXx0OXXXo() {
        if (BleCache.INSTANCE.getMSupportQuran() == 1) {
            return true;
        }
        return false;
    }

    public final boolean Xo() {
        if (!xIx() && !xxxI()) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:5:0x0177 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0175 A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean Xo0() {
        /*
            Method dump skipped, instructions count: 528
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ble.ProductManager.Xo0():boolean");
    }

    public final int XoI0Ixx0() {
        return BleCache.INSTANCE.getMSupportReceiptCodeSize();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000b. Please report as an issue. */
    public final boolean XoOOx0IX() {
        BleCache bleCache = BleCache.INSTANCE;
        String mBleName = bleCache.getMBleName();
        switch (mBleName.hashCode()) {
            case -1790768875:
                if (mBleName.equals(f20666xxxoo0XI)) {
                    return true;
                }
                return xOxxXO();
            case -1160619927:
                if (mBleName.equals(f20471X0x)) {
                    return true;
                }
                return xOxxXO();
            case -806526941:
                if (mBleName.equals(xxX0X)) {
                    return true;
                }
                return xOxxXO();
            case -310056072:
                if (mBleName.equals(f20473X0xOO)) {
                    if (IIX0o.Oxx0IOOO(bleCache.getMFirmwareFlag(), "SmartWatch_LC201_64M") || IIX0o.Oxx0IOOO(bleCache.getMFirmwareFlag(), "SmartWatch_lc302") || IIX0o.Oxx0IOOO(bleCache.getMFirmwareFlag(), "SmartWatch_LC201_64M_NOCALL")) {
                        return true;
                    }
                    return false;
                }
                return xOxxXO();
            case 2405:
                if (mBleName.equals("L1")) {
                    return true;
                }
                return xOxxXO();
            case OxXXx0X.f13191oXxx000 /* 2406 */:
                if (mBleName.equals(f20399O0o0)) {
                    return true;
                }
                return xOxxXO();
            case 2594:
                if (mBleName.equals("R4")) {
                    return true;
                }
                return xOxxXO();
            case 62370533:
                if (mBleName.equals(XOx0xX)) {
                    return true;
                }
                return xOxxXO();
            case 75506068:
                if (mBleName.equals(f20334I0X0x0oIo)) {
                    return true;
                }
                return xOxxXO();
            case 75506441:
                if (mBleName.equals(f20562oX0I0O)) {
                    return true;
                }
                return xOxxXO();
            case 75506442:
                if (mBleName.equals(f20540oI0IIXIo)) {
                    return true;
                }
                return xOxxXO();
            case 75506466:
                if (mBleName.equals(f20574oo)) {
                    return true;
                }
                return xOxxXO();
            case 357059640:
                if (mBleName.equals(f20647xooxxX)) {
                    return true;
                }
                return xOxxXO();
            case 530514912:
                if (mBleName.equals(f20417OO0)) {
                    return true;
                }
                return xOxxXO();
            case 889663666:
                if (mBleName.equals(f20632xX0ox)) {
                    return true;
                }
                return xOxxXO();
            case 1099799110:
                if (mBleName.equals(f20579ooOOo0oXI)) {
                    return true;
                }
                return xOxxXO();
            case 1238518160:
                if (mBleName.equals(f20546oIoxI0xx)) {
                    return true;
                }
                return xOxxXO();
            default:
                return xOxxXO();
        }
    }

    public final boolean XoOxI0ox() {
        if (BleConnector.INSTANCE.isBound() && !ProjectManager.f19822oIX0oI.IxIo() && com.sma.smartv3.app.II0xO0.f19811OxxIIOOXO.oIX0oI() >= 3) {
            return true;
        }
        return false;
    }

    @OOXIXo
    public final String XoX() {
        if (IIX0o.Oxx0IOOO(BleCache.INSTANCE.getMBleName(), f20383IxIX0I)) {
            return "korean_lane.bin";
        }
        return "arialuni_U24.bin";
    }

    public final boolean XooIO0oo0() {
        String supMember;
        AppConfigInfo XI2 = XI();
        if (XI2 != null && (supMember = XI2.getSupMember()) != null) {
            return supMember.equals("0");
        }
        return false;
    }

    public final boolean Xx() {
        if (BleCache.INSTANCE.getMSupportSHSYAlgorithm() == 1) {
            return true;
        }
        return false;
    }

    public final boolean Xx0() {
        CustomConfigInfo customConfig;
        String supFallDetection;
        DeviceConfigInfo IOoo2 = IOoo();
        if (IOoo2 != null && (customConfig = IOoo2.getCustomConfig()) != null && (supFallDetection = customConfig.getSupFallDetection()) != null) {
            return supFallDetection.equals("1");
        }
        return false;
    }

    public final boolean Xx000oIo() {
        BleCache bleCache = BleCache.INSTANCE;
        if (!IIX0o.Oxx0IOOO(bleCache.getMBleName(), f20580ooOx) && !IIX0o.Oxx0IOOO(bleCache.getMBleName(), f20644xoO0xx0) && !IIX0o.Oxx0IOOO(bleCache.getMBleName(), f20428OX00O0xII) && !IIX0o.Oxx0IOOO(bleCache.getMBleName(), "R7") && !IIX0o.Oxx0IOOO(bleCache.getMBleName(), f20556oOo) && !IIX0o.Oxx0IOOO(bleCache.getMBleName(), f20397O0X) && !IIX0o.Oxx0IOOO(bleCache.getMBleName(), f20622xOOOX) && !IIX0o.Oxx0IOOO(bleCache.getMBleName(), "TIME") && !IIX0o.Oxx0IOOO(bleCache.getMBleName(), f20479XIXIX) && !IIX0o.Oxx0IOOO(bleCache.getMBleName(), "R10") && !IIX0o.Oxx0IOOO(bleCache.getMBleName(), f20626xOoOIoI) && !IIX0o.Oxx0IOOO(bleCache.getMBleName(), "L1") && !IIX0o.Oxx0IOOO(bleCache.getMBleName(), f20389O0) && ((!IIX0o.Oxx0IOOO(bleCache.getMPrototype(), "F6") || IIX0o.Oxx0IOOO(bleCache.getMBleName(), f20341IIIxO) || IIX0o.Oxx0IOOO(bleCache.getMFirmwareFlag(), "SmartWatch_LC201_64M_NOCALL")) && !IIX0o.Oxx0IOOO(bleCache.getMBleName(), "R9") && !IIX0o.Oxx0IOOO(bleCache.getMBleName(), f20461X0) && !IIX0o.Oxx0IOOO(bleCache.getMBleName(), f20369Io) && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), "T78") && !IIX0o.Oxx0IOOO(bleCache.getMBleName(), f20446OoxxX) && !IIX0o.Oxx0IOOO(bleCache.getMBleName(), f20655xx0X0) && !IIX0o.Oxx0IOOO(bleCache.getMBleName(), f20609xI0oxI00) && !IIX0o.Oxx0IOOO(bleCache.getMBleName(), f20370IoIOOxIIo) && !IIX0o.Oxx0IOOO(bleCache.getMBleName(), f20586oxIIX0o) && !IIX0o.Oxx0IOOO(bleCache.getMBleName(), f20475XI) && !IIX0o.Oxx0IOOO(bleCache.getMBleName(), f20357IOoo) && !IIX0o.Oxx0IOOO(bleCache.getMBleName(), f20542oIIxXoo) && !IIX0o.Oxx0IOOO(bleCache.getMBleName(), f20569oXX0IoI) && !IIX0o.Oxx0IOOO(bleCache.getMBleName(), f20500XXXI) && !IIX0o.Oxx0IOOO(bleCache.getMBleName(), "Y1") && !IIX0o.Oxx0IOOO(bleCache.getMBleName(), f20627xOx) && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), "V2") && !IIX0o.Oxx0IOOO(bleCache.getMBleName(), "Y3") && !IIX0o.Oxx0IOOO(bleCache.getMBleName(), f20406OIII0O) && !IIX0o.Oxx0IOOO(bleCache.getMBleName(), f20629xOxxXO) && !IIX0o.Oxx0IOOO(bleCache.getMBleName(), f20612xIXIOX) && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), "R11") && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), "R11S") && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), BleDeviceInfo.PROTOTYPE_V5) && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), BleDeviceInfo.PROTOTYPE_V3) && ((!IIX0o.Oxx0IOOO(bleCache.getMBleName(), f20459OxxIIOOXO) || !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), BleDeviceInfo.PROTOTYPE_R7)) && !IIX0o.Oxx0IOOO(bleCache.getMBleName(), f20530o0oIxOo) && !IIX0o.Oxx0IOOO(bleCache.getMBleName(), f20480XIXIxO) && !IIX0o.Oxx0IOOO(bleCache.getMBleName(), f20493XOxoX) && !IIX0o.Oxx0IOOO(bleCache.getMBleName(), f20487XO0OX) && !IIX0o.Oxx0IOOO(bleCache.getMBleName(), f20566oXIoIo) && !IIX0o.Oxx0IOOO(bleCache.getMBleName(), f20628xOxOoo) && !IIX0o.Oxx0IOOO(bleCache.getMBleName(), f20395O0OOX0IIx) && ((!IIX0o.Oxx0IOOO(bleCache.getMBleName(), f20473X0xOO) || IIX0o.Oxx0IOOO(bleCache.getMFirmwareFlag(), "SmartWatch_LC201_64M_NOCALL")) && !IIX0o.Oxx0IOOO(bleCache.getMBleName(), f20440OoO) && !IIX0o.Oxx0IOOO(bleCache.getMBleName(), f20337I0xX0) && !IIX0o.Oxx0IOOO(bleCache.getMBleName(), f20456Oxx) && !IIX0o.Oxx0IOOO(bleCache.getMBleName(), f20385IxO0Oxo) && !IIX0o.Oxx0IOOO(bleCache.getMBleName(), f20427OX) && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), "F12") && !IIX0o.Oxx0IOOO(bleCache.getMBleName(), f20509XoOOx0IX) && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), "R9J") && !IIX0o.Oxx0IOOO(bleCache.getMBleName(), f20653xx00oOoI) && !IIX0o.Oxx0IOOO(bleCache.getMBleName(), f20405OI0IXox) && !IIX0o.Oxx0IOOO(bleCache.getMBleName(), f20355IOXOxOII) && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), "F13A") && !IIX0o.Oxx0IOOO(bleCache.getMBleName(), f20408OIOoIIOIx) && !IIX0o.Oxx0IOOO(bleCache.getMBleName(), f20463X00IxOx) && ((!IIX0o.Oxx0IOOO(bleCache.getMPrototype(), "F13B") || IIX0o.Oxx0IOOO(bleCache.getMBleName(), oxoIOxO) || IIX0o.Oxx0IOOO(bleCache.getMBleName(), x0ooOIxO) || IIX0o.Oxx0IOOO(bleCache.getMBleName(), OXI) || IIX0o.Oxx0IOOO(bleCache.getMFirmwareFlag(), "JL08_F27") || IIX0o.Oxx0IOOO(bleCache.getMBleName(), IXOO0X0)) && ((!IIX0o.Oxx0IOOO(bleCache.getMPrototype(), "A8") || IIX0o.Oxx0IOOO(bleCache.getMBleName(), xOxxIxxI0)) && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), "AM01") && !IIX0o.Oxx0IOOO(bleCache.getMBleName(), f20572oXxOXOX) && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), "A7") && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), "AM01J") && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), "AM02J") && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), "F17") && !IIX0o.Oxx0IOOO(bleCache.getMBleName(), f20534o0xIoII) && !IIX0o.Oxx0IOOO(bleCache.getMBleName(), f20498XXIoX0) && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), BleDeviceInfo.PROTOTYPE_HW01) && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), "F12Pro") && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), BleDeviceInfo.PROTOTYPE_K18) && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), "AM05") && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), BleDeviceInfo.PROTOTYPE_K30) && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), BleDeviceInfo.PROTOTYPE_AM22) && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), "FC1") && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), "FC2") && !IIX0o.Oxx0IOOO(bleCache.getMBleName(), f20438OoI0OO) && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), BleDeviceInfo.PROTOTYPE_FT5) && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), "R16") && !IIX0o.Oxx0IOOO(bleCache.getMBleName(), f20567oXIoO) && !IIX0o.Oxx0IOOO(bleCache.getMBleName(), f20526o0IXXIx) && !IIX0o.Oxx0IOOO(bleCache.getMBleName(), f20352IOI) && !IIX0o.Oxx0IOOO(bleCache.getMBleName(), f20421OOOox) && !IIX0o.Oxx0IOOO(bleCache.getMBleName(), IooOI0x) && !IIX0o.Oxx0IOOO(bleCache.getMBleName(), f20375IoXO0XoX) && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), BleDeviceInfo.PROTOTYPE_A8_ULTRA_PRO) && !IIX0o.Oxx0IOOO(bleCache.getMBleName(), f20508XoIxOXIXo) && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), "AM08") && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), "JX621D") && !IIX0o.Oxx0IOOO(bleCache.getMBleName(), f20651xx) && !IIX0o.Oxx0IOOO(bleCache.getMBleName(), f20417OO0) && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), "V61") && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), "AM11") && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), "AW37") && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), "B9"))))))) {
            return false;
        }
        return true;
    }

    public final boolean XxI() {
        return false;
    }

    public final boolean XxIIOXIXx() {
        if (BleCache.INSTANCE.getMSupportGameControl() == 1) {
            return true;
        }
        return false;
    }

    public final boolean XxIOX() {
        if (!xIx() && !xxxI()) {
            return false;
        }
        return true;
    }

    public final boolean XxIo() {
        if (BleCache.INSTANCE.getMSupport2DAcceleration() == 1) {
            return true;
        }
        return false;
    }

    @OOXIXo
    public final ArrayList<String> XxX0x0xxx() {
        return (ArrayList) O0oXIX0oX.getValue();
    }

    public final boolean Xxx0oXX() {
        return X0xOO();
    }

    public final int o0() {
        if (IIX0o.Oxx0IOOO(BleCache.INSTANCE.getMPlatform(), BleDeviceInfo.PLATFORM_SIFLI)) {
            return 5;
        }
        return 1;
    }

    public final int o00() {
        BleCache.INSTANCE.getMPrototype();
        return R.string.classic_note_content_middle;
    }

    public final boolean o00xOoIO() {
        if (BleCache.INSTANCE.getMSupportChangeClassicBluetoothState() == 1) {
            return true;
        }
        return false;
    }

    @OOXIXo
    public final Pair<Integer, Integer> o0IXXIx(@OOXIXo BleDeviceInfo deviceInfo) {
        IIX0o.x0xO0oo(deviceInfo, "deviceInfo");
        String mBleName = deviceInfo.getMBleName();
        if (IIX0o.Oxx0IOOO(mBleName, "X6")) {
            return new Pair<>(Integer.valueOf(R.drawable.x6_1), Integer.valueOf(R.drawable.x6_2));
        }
        if (IIX0o.Oxx0IOOO(mBleName, "X5L")) {
            return new Pair<>(Integer.valueOf(R.drawable.x5l_1), Integer.valueOf(R.drawable.x5l_2));
        }
        return new Pair<>(Integer.valueOf(R.drawable.x3_1), Integer.valueOf(R.drawable.x3_2));
    }

    public final boolean o0OO0() {
        return false;
    }

    public final boolean o0Oo() {
        if (BleCache.INSTANCE.getMSupportAppSport() == 1) {
            return true;
        }
        return false;
    }

    public final boolean o0Xo(@OOXIXo String platform) {
        IIX0o.x0xO0oo(platform, "platform");
        if (!IIX0o.Oxx0IOOO(platform, BleDeviceInfo.PLATFORM_SIFLI) && !IIX0o.Oxx0IOOO(platform, BleDeviceInfo.PLATFORM_JL707)) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000a. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0062 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0064 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean o0oIxOo() {
        /*
            r3 = this;
            com.szabh.smable3.component.BleCache r0 = com.szabh.smable3.component.BleCache.INSTANCE
            java.lang.String r1 = r0.getMPrototype()
            int r2 = r1.hashCode()
            switch(r2) {
                case 2221: goto L5a;
                case 2592: goto L51;
                case 2810: goto L48;
                case 80369: goto L34;
                case 80455: goto L2b;
                case 80464: goto L22;
                case 82485: goto Le;
                default: goto Ld;
            }
        Ld:
            goto L64
        Le:
            java.lang.String r2 = "T78"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L17
            goto L64
        L17:
            java.lang.String r0 = r0.getMBleName()
            java.lang.String r1 = "AceFit"
            boolean r0 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r0, r1)
            goto L65
        L22:
            java.lang.String r0 = "R3Q"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L62
            goto L64
        L2b:
            java.lang.String r0 = "R3H"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L62
            goto L64
        L34:
            java.lang.String r2 = "R10"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L3d
            goto L64
        L3d:
            java.lang.String r0 = r0.getMBleName()
            java.lang.String r1 = "Smart Watch"
            boolean r0 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r0, r1)
            goto L65
        L48:
            java.lang.String r0 = "Y3"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L62
            goto L64
        L51:
            java.lang.String r0 = "R2"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L62
            goto L64
        L5a:
            java.lang.String r0 = "F3"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L64
        L62:
            r0 = 1
            goto L65
        L64:
            r0 = 0
        L65:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ble.ProductManager.o0oIxOo():boolean");
    }

    public final boolean o0oIxXOx(int i, boolean z) {
        if (i == 12) {
            if (!xxx00()) {
                return true;
            }
            return false;
        }
        return OIxI0O(i, z);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:49:0x0060. Please report as an issue. */
    public final boolean o0oxo0oI(int i) {
        if (i != 12 && i != 13 && i != 19 && i != 20 && i != 28 && i != 29 && i != 33 && i != 40 && i != 50 && i != 63 && i != 70 && i != 81 && i != 86 && i != 89 && i != 109 && i != 136 && i != 42 && i != 43 && i != 100 && i != 101 && i != 133 && i != 134 && i != 147 && i != 148) {
            switch (i) {
                default:
                    switch (i) {
                        case 96:
                        case 97:
                        case 98:
                            break;
                        default:
                            return false;
                    }
                case 7:
                case 8:
                case 9:
                case 10:
                    return true;
            }
        }
        return true;
    }

    public final boolean o0xIIX0() {
        String mPlatform = BleCache.INSTANCE.getMPlatform();
        int hashCode = mPlatform.hashCode();
        if (hashCode == 2370 ? !mPlatform.equals(BleDeviceInfo.PLATFORM_JL) : !(hashCode == 70659068 ? mPlatform.equals(BleDeviceInfo.PLATFORM_JL707) : !(hashCode != 1697379018 || !mPlatform.equals(BleDeviceInfo.PLATFORM_JL707LITE)))) {
            return false;
        }
        return true;
    }

    public final boolean o0xIoII() {
        if (BleCache.INSTANCE.getMSupportOTAFile() == 1) {
            return true;
        }
        return false;
    }

    public final boolean o0xOIoxo() {
        if (BleCache.INSTANCE.getMSupportNavigation() == 1) {
            return true;
        }
        return false;
    }

    public final int o0xxxXXxX() {
        return xoOOIooI;
    }

    public final boolean oI() {
        if (!O0IxXx() && !Ix00oIoI()) {
            return false;
        }
        return true;
    }

    public final boolean oI0() {
        if (BleCache.INSTANCE.getMSupportEbookTransfer() == 1) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0026, code lost:
    
        if (r0.equals(com.sma.smartv3.ble.ProductManager.XO0XIXOo0) != false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x002f, code lost:
    
        if (r0.equals(com.sma.smartv3.ble.ProductManager.IoooXox0) == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0038, code lost:
    
        if (r0.equals(com.sma.smartv3.ble.ProductManager.OXoIOx) == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0014, code lost:
    
        if (r0.equals(com.sma.smartv3.ble.ProductManager.xO0xx0xxx) == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x003f, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001d, code lost:
    
        if (r0.equals(com.sma.smartv3.ble.ProductManager.oIoXOooOO) == false) goto L42;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean oI00o() {
        /*
            r2 = this;
            com.szabh.smable3.component.BleCache r0 = com.szabh.smable3.component.BleCache.INSTANCE
            java.lang.String r0 = r0.getMBleName()
            int r1 = r0.hashCode()
            switch(r1) {
                case -1429244104: goto L32;
                case -172603174: goto L29;
                case 2608024: goto L20;
                case 1040994488: goto L17;
                case 1968263785: goto Le;
                default: goto Ld;
            }
        Ld:
            goto L3a
        Le:
            java.lang.String r1 = "alt Woke"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L3f
            goto L3a
        L17:
            java.lang.String r1 = "Noise Fit Defender"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L3f
            goto L3a
        L20:
            java.lang.String r1 = "UM88"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L3a
            goto L3f
        L29:
            java.lang.String r1 = "TOUCHMATE_500"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L3f
            goto L3a
        L32:
            java.lang.String r1 = "THORTON #Geni"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L3f
        L3a:
            boolean r0 = r2.IOOXOOOOo()
            goto L40
        L3f:
            r0 = 0
        L40:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ble.ProductManager.oI00o():boolean");
    }

    @OOXIXo
    public final String oI0IIXIo() {
        CustomConfigInfo customConfig;
        String aiModelService;
        String obj;
        DeviceConfigInfo IOoo2 = IOoo();
        if (IOoo2 == null || (customConfig = IOoo2.getCustomConfig()) == null || (aiModelService = customConfig.getAiModelService()) == null || (obj = StringsKt__StringsKt.oIoIXxIO(aiModelService).toString()) == null) {
            return "";
        }
        return obj;
    }

    public final boolean oI0X0() {
        if (BleCache.INSTANCE.getMSupportGestureWake2() == 1) {
            return true;
        }
        return false;
    }

    @OOXIXo
    public final List<DeviceOnlineInfo> oIIxXoo() {
        try {
            JsonArray asJsonArray = JsonParser.parseString(com.sma.smartv3.util.Xo0.f24349oIX0oI.XO().getString(XoI0Ixx0.f24393OOXIxO0)).getAsJsonArray();
            IIX0o.ooOOo0oXI(asJsonArray);
            ArrayList arrayList = new ArrayList(OxxIIOOXO.xo0x(asJsonArray, 10));
            Iterator<JsonElement> it = asJsonArray.iterator();
            while (it.hasNext()) {
                arrayList.add(new Gson().fromJson(it.next(), DeviceOnlineInfo.class));
            }
            return arrayList;
        } catch (Exception unused) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
    }

    public final boolean oIX0o() {
        if (BleCache.INSTANCE.getMSupportWalkAndBike() == 1) {
            return true;
        }
        return false;
    }

    @OOXIXo
    public final String oIX0oI(@OOXIXo String bleName) {
        IIX0o.x0xO0oo(bleName, "bleName");
        return bleName;
    }

    public final boolean oIXoXx0() {
        if (BleCache.INSTANCE.getMSupportGoMoreSet() == 1) {
            return true;
        }
        return false;
    }

    public final void oIoxI0xx(@OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "context");
        if (IIX0o.Oxx0IOOO(BleCache.INSTANCE.getMBleName(), "S1")) {
            Intent intent = new Intent();
            intent.setClassName(context, "com.sma.smartv3.ui.status.MatchSettings2Activity");
            context.startActivity(intent);
        } else {
            Intent intent2 = new Intent();
            intent2.setClassName(context, "com.sma.smartv3.ui.status.MatchSettingsActivity");
            context.startActivity(intent2);
        }
    }

    public final void oIxOXo(@OOXIXo Activity activity) {
        IIX0o.x0xO0oo(activity, "activity");
        try {
            BleCache.INSTANCE.getMPrototype();
            if (xOOxIO(this, null, 1, null)) {
                activity.startActivity(new Intent(activity, (Class<?>) ChargeMainActivity.class));
            } else {
                activity.startActivity(new Intent(activity, (Class<?>) MainActivity.class));
            }
            activity.finish();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x0327, code lost:
    
        if (r8 == null) goto L567;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0329, code lost:
    
        r0.putExtras(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x032c, code lost:
    
        r7.startActivity(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0129, code lost:
    
        if (r0.equals("AM01J") == false) goto L643;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0133, code lost:
    
        if (r0.equals("NY58") == false) goto L643;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0394, code lost:
    
        r0 = new android.content.Intent(r7, (java.lang.Class<?>) com.sma.smartv3.ui.device.dial.DialCustomize240Activity.class);
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x039b, code lost:
    
        if (r8 == null) goto L597;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x039d, code lost:
    
        r0.putExtras(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x03a0, code lost:
    
        r7.startActivity(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x013d, code lost:
    
        if (r0.equals(com.szabh.smable3.entity.BleDeviceInfo.PROTOTYPE_HW01) == false) goto L643;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x02bf, code lost:
    
        if (com.sma.smartv3.app.ProjectManager.f19822oIX0oI.XoOxI0ox() == false) goto L541;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x02c1, code lost:
    
        r0 = new android.content.Intent(r7, (java.lang.Class<?>) com.sma.smartv3.ui.device.watchface.WatchFaceCustomActivity.class);
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x02c6, code lost:
    
        if (r8 == null) goto L540;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x02c8, code lost:
    
        r0.putExtras(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x02cb, code lost:
    
        r7.startActivity(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x02d0, code lost:
    
        r0 = new android.content.Intent(r7, (java.lang.Class<?>) com.sma.smartv3.ui.device.dial.old.DialCustomize15Activity.class);
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x02d5, code lost:
    
        if (r8 == null) goto L544;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x02d7, code lost:
    
        r0.putExtras(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x02da, code lost:
    
        r7.startActivity(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0147, code lost:
    
        if (r0.equals("F13B") == false) goto L643;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x03da, code lost:
    
        if (com.sma.smartv3.app.ProjectManager.f19822oIX0oI.XoOxI0ox() == false) goto L617;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x03dc, code lost:
    
        r0 = new android.content.Intent(r7, (java.lang.Class<?>) com.sma.smartv3.ui.device.watchface.WatchFaceCustomActivity.class);
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x03e1, code lost:
    
        if (r8 == null) goto L616;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x03e3, code lost:
    
        r0.putExtras(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x03e6, code lost:
    
        r7.startActivity(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x03eb, code lost:
    
        r0 = new android.content.Intent(r7, (java.lang.Class<?>) com.sma.smartv3.ui.device.dial.DialCustomize240_286Activity.class);
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x03f0, code lost:
    
        if (r8 == null) goto L620;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x03f2, code lost:
    
        r0.putExtras(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x03f5, code lost:
    
        r7.startActivity(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x016a, code lost:
    
        if (r0.equals("AW37") == false) goto L643;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x018f, code lost:
    
        if (r0.equals(com.szabh.smable3.entity.BleDeviceInfo.PROTOTYPE_AM22) == false) goto L643;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x01f0, code lost:
    
        if (com.sma.smartv3.app.ProjectManager.f19822oIX0oI.XoOxI0ox() == false) goto L486;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x01f2, code lost:
    
        r0 = new android.content.Intent(r7, (java.lang.Class<?>) com.sma.smartv3.ui.device.watchface.WatchFaceCustomActivity.class);
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x01f7, code lost:
    
        if (r8 == null) goto L485;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x01f9, code lost:
    
        r0.putExtras(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x01fc, code lost:
    
        r7.startActivity(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x0201, code lost:
    
        r0 = new android.content.Intent(r7, (java.lang.Class<?>) com.sma.smartv3.ui.device.dial.DialCustomize466Activity.class);
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x0208, code lost:
    
        if (r8 == null) goto L489;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x020a, code lost:
    
        r0.putExtras(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x020d, code lost:
    
        r7.startActivity(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x01e6, code lost:
    
        if (r0.equals("AM05") == false) goto L643;
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x0218, code lost:
    
        if (r0.equals("AM01") == false) goto L643;
     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x0222, code lost:
    
        if (r0.equals("V61") == false) goto L643;
     */
    /* JADX WARN: Code restructure failed: missing block: B:234:0x02ab, code lost:
    
        if (r0.equals(com.szabh.smable3.entity.BleDeviceInfo.PROTOTYPE_FT5) == false) goto L643;
     */
    /* JADX WARN: Code restructure failed: missing block: B:236:0x02b5, code lost:
    
        if (r0.equals("FC2") == false) goto L643;
     */
    /* JADX WARN: Code restructure failed: missing block: B:245:0x02fe, code lost:
    
        if (r0.equals("F2R") == false) goto L643;
     */
    /* JADX WARN: Code restructure failed: missing block: B:247:0x0308, code lost:
    
        if (r0.equals("F2K") == false) goto L643;
     */
    /* JADX WARN: Code restructure failed: missing block: B:248:0x0379, code lost:
    
        r0 = new android.content.Intent(r7, (java.lang.Class<?>) com.sma.smartv3.ui.device.dial.DialCustomize128Activity.class);
     */
    /* JADX WARN: Code restructure failed: missing block: B:249:0x0380, code lost:
    
        if (r8 == null) goto L590;
     */
    /* JADX WARN: Code restructure failed: missing block: B:250:0x0382, code lost:
    
        r0.putExtras(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:251:0x0385, code lost:
    
        r7.startActivity(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:252:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:254:0x0312, code lost:
    
        if (r0.equals("F17") == false) goto L643;
     */
    /* JADX WARN: Code restructure failed: missing block: B:255:0x0345, code lost:
    
        r0 = new android.content.Intent(r7, (java.lang.Class<?>) com.sma.smartv3.ui.device.dial.DialCustomize360_400Activity.class);
     */
    /* JADX WARN: Code restructure failed: missing block: B:256:0x034c, code lost:
    
        if (r8 == null) goto L577;
     */
    /* JADX WARN: Code restructure failed: missing block: B:257:0x034e, code lost:
    
        r0.putExtras(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:258:0x0351, code lost:
    
        r7.startActivity(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:259:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:261:0x031c, code lost:
    
        if (r0.equals("F12") == false) goto L643;
     */
    /* JADX WARN: Code restructure failed: missing block: B:263:0x0337, code lost:
    
        if (r0.equals("W9") == false) goto L643;
     */
    /* JADX WARN: Code restructure failed: missing block: B:265:0x0341, code lost:
    
        if (r0.equals("V2") == false) goto L643;
     */
    /* JADX WARN: Code restructure failed: missing block: B:274:0x0377, code lost:
    
        if (r0.equals("S2") != false) goto L587;
     */
    /* JADX WARN: Code restructure failed: missing block: B:276:0x0390, code lost:
    
        if (r0.equals("F1") == false) goto L643;
     */
    /* JADX WARN: Code restructure failed: missing block: B:278:0x03ab, code lost:
    
        if (r0.equals("B9") == false) goto L643;
     */
    /* JADX WARN: Code restructure failed: missing block: B:280:0x03c6, code lost:
    
        if (r0.equals("A8") == false) goto L643;
     */
    /* JADX WARN: Code restructure failed: missing block: B:282:0x03d0, code lost:
    
        if (r0.equals("A7") == false) goto L643;
     */
    /* JADX WARN: Code restructure failed: missing block: B:284:0x0400, code lost:
    
        if (r0.equals(com.szabh.smable3.entity.BleDeviceInfo.PROTOTYPE_A8_ULTRA_PRO) == false) goto L643;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00f0, code lost:
    
        if (r0.equals("F12Pro") == false) goto L643;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0409, code lost:
    
        if (com.sma.smartv3.app.ProjectManager.f19822oIX0oI.XoOxI0ox() == false) goto L630;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x040b, code lost:
    
        r0 = new android.content.Intent(r7, (java.lang.Class<?>) com.sma.smartv3.ui.device.watchface.WatchFaceCustomActivity.class);
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0410, code lost:
    
        if (r8 == null) goto L629;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0412, code lost:
    
        r0.putExtras(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0415, code lost:
    
        r7.startActivity(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x041a, code lost:
    
        r0 = new android.content.Intent(r7, (java.lang.Class<?>) com.sma.smartv3.ui.device.dial.DialCustomize320_386Activity.class);
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0421, code lost:
    
        if (r8 == null) goto L633;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0423, code lost:
    
        r0.putExtras(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0426, code lost:
    
        r7.startActivity(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x00fa, code lost:
    
        if (r0.equals(com.szabh.smable3.entity.BleDeviceInfo.PROTOTYPE_B9C_JL) == false) goto L643;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x03af, code lost:
    
        r0 = new android.content.Intent(r7, (java.lang.Class<?>) com.sma.smartv3.ui.device.dial.DialCustomize172_320Activity.class);
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x03b6, code lost:
    
        if (r8 == null) goto L604;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x03b8, code lost:
    
        r0.putExtras(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x03bb, code lost:
    
        r7.startActivity(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x011f, code lost:
    
        if (r0.equals("AM02J") == false) goto L643;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0320, code lost:
    
        r0 = new android.content.Intent(r7, (java.lang.Class<?>) com.sma.smartv3.ui.device.dial.DialCustomize368_448Activity.class);
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:68:0x00e5. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void oO0(@OXOo.OOXIXo android.app.Activity r7, @OXOo.oOoXoXO android.os.Bundle r8) {
        /*
            Method dump skipped, instructions count: 1342
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ble.ProductManager.oO0(android.app.Activity, android.os.Bundle):void");
    }

    public final boolean oO0IXx() {
        return true;
    }

    public final boolean oO0OX0() {
        if (XO0o()) {
            return XO0o();
        }
        if (!oxOXxoXII() && !IxX00()) {
            return O0xxXxI();
        }
        return false;
    }

    public final boolean oOIXoIXXI() {
        if (BleCache.INSTANCE.getMSupportRealTimeMeasurement() == 1) {
            return true;
        }
        return false;
    }

    public final boolean oOIx() {
        if (BleCache.INSTANCE.getMSupportMusicTransfer() == 1) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0089 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean oOXoIIIo() {
        /*
            Method dump skipped, instructions count: 1656
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ble.ProductManager.oOXoIIIo():boolean");
    }

    public final boolean oOo() {
        String mPrototype = BleCache.INSTANCE.getMPrototype();
        int hashCode = mPrototype.hashCode();
        if (hashCode != 2623) {
            if (hashCode != 68895) {
                if (hashCode == 2410926 && mPrototype.equals("NY58")) {
                    return false;
                }
            } else if (mPrototype.equals("F2K")) {
                return false;
            }
        } else if (mPrototype.equals("S2")) {
            return false;
        }
        if (xIx() && xxxI()) {
            return false;
        }
        return true;
    }

    public final boolean oOoIIO0() {
        return !IIX0o.Oxx0IOOO(BleCache.INSTANCE.getMPrototype(), "NY58");
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0026, code lost:
    
        if (r0.equals(com.sma.smartv3.ble.ProductManager.IoooXox0) != false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002f, code lost:
    
        if (r0.equals(com.sma.smartv3.ble.ProductManager.XxOOX) == false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0038, code lost:
    
        if (r0.equals(com.sma.smartv3.ble.ProductManager.Xxo) == false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0014, code lost:
    
        if (r0.equals(com.sma.smartv3.ble.ProductManager.O0IX) == false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0061, code lost:
    
        return com.sma.smartv3.util.DateTimeFormat.ddMMyyyy;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001d, code lost:
    
        if (r0.equals(com.sma.smartv3.ble.ProductManager.xIIO) == false) goto L50;
     */
    @OXOo.OOXIXo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.sma.smartv3.util.DateTimeFormat oOoXoXO() {
        /*
            r2 = this;
            com.szabh.smable3.component.BleCache r0 = com.szabh.smable3.component.BleCache.INSTANCE
            java.lang.String r0 = r0.getMBleName()
            int r1 = r0.hashCode()
            switch(r1) {
                case -1759163808: goto L32;
                case -204071929: goto L29;
                case -172603174: goto L20;
                case 159837102: goto L17;
                case 514667848: goto Le;
                default: goto Ld;
            }
        Ld:
            goto L3a
        Le:
            java.lang.String r1 = "Amoled Round Voice"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L5f
            goto L3a
        L17:
            java.lang.String r1 = "Action Plus GPS"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L5f
            goto L3a
        L20:
            java.lang.String r1 = "TOUCHMATE_500"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L3a
            goto L5f
        L29:
            java.lang.String r1 = "Amoled Square Voice"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L5f
            goto L3a
        L32:
            java.lang.String r1 = "Amoled Action Voice"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L5f
        L3a:
            android.app.Application r0 = com.blankj.utilcode.util.Utils.getApp()
            java.lang.String r1 = "getApp(...)"
            kotlin.jvm.internal.IIX0o.oO(r0, r1)
            boolean r0 = com.sma.smartv3.util.UtilsKt.IO(r0)
            if (r0 == 0) goto L4c
            com.sma.smartv3.util.DateTimeFormat r0 = com.sma.smartv3.util.DateTimeFormat.yyyyMMdd
            goto L61
        L4c:
            android.app.Application r0 = com.blankj.utilcode.util.Utils.getApp()
            kotlin.jvm.internal.IIX0o.oO(r0, r1)
            boolean r0 = com.sma.smartv3.util.UtilsKt.ooXIXxIX(r0)
            if (r0 == 0) goto L5c
            com.sma.smartv3.util.DateTimeFormat r0 = com.sma.smartv3.util.DateTimeFormat.ddMMyyyy
            goto L61
        L5c:
            com.sma.smartv3.util.DateTimeFormat r0 = com.sma.smartv3.util.DateTimeFormat.MMddyyyy
            goto L61
        L5f:
            com.sma.smartv3.util.DateTimeFormat r0 = com.sma.smartv3.util.DateTimeFormat.ddMMyyyy
        L61:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ble.ProductManager.oOoXoXO():com.sma.smartv3.util.DateTimeFormat");
    }

    public final int oX() {
        return !IIX0o.Oxx0IOOO(BleCache.INSTANCE.getMBleName(), "IT Exceed Pro WR03") ? 1 : 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001e, code lost:
    
        if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(r0, "1") != false) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean oX000x() {
        /*
            r2 = this;
            boolean r0 = r2.XoOxI0ox()
            if (r0 == 0) goto L20
            com.sma.smartv3.model.DeviceConfigInfo r0 = r2.IOoo()
            if (r0 == 0) goto L17
            com.sma.smartv3.model.CustomConfigInfo r0 = r0.getCustomConfig()
            if (r0 == 0) goto L17
            java.lang.String r0 = r0.getSupOtherAds()
            goto L18
        L17:
            r0 = 0
        L18:
            java.lang.String r1 = "1"
            boolean r0 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r0, r1)
            if (r0 == 0) goto L26
        L20:
            boolean r0 = r2.xIOXX()
            if (r0 == 0) goto L28
        L26:
            r0 = 1
            goto L29
        L28:
            r0 = 0
        L29:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ble.ProductManager.oX000x():boolean");
    }

    public final boolean oX0I0O(int i) {
        if (IIX0o.Oxx0IOOO(BleCache.INSTANCE.getMPlatform(), BleDeviceInfo.PLATFORM_GOODIX)) {
            if (i != 0) {
                return false;
            }
        } else if (i == 0) {
            return false;
        }
        return true;
    }

    public final boolean oX0ooo0I0() {
        return IIX0o.Oxx0IOOO(BleCache.INSTANCE.getMFirmwareFlag(), "G6_C80");
    }

    public final int oXIO0o0XI() {
        return X0o0O0x;
    }

    public final boolean oXIoIo() {
        if (BleCache.INSTANCE.getMSupportMedicationAlarm() == 1) {
            return true;
        }
        return false;
    }

    @OOXIXo
    public final Set<String> oXIoO() {
        return oOII0;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000b. Please report as an issue. */
    public final boolean oXO0oOx0() {
        String str;
        String mFirmwareFlag = BleCache.INSTANCE.getMFirmwareFlag();
        switch (mFirmwareFlag.hashCode()) {
            case -1957226515:
                str = "BS_S1_PRO_LOCKFACE";
                mFirmwareFlag.equals(str);
                return true;
            case -1652604122:
                str = "BLACK_SHARK_S1_PRO";
                mFirmwareFlag.equals(str);
                return true;
            case -1546093392:
                mFirmwareFlag.equals("S1_PRO_OVERSEAS_V2");
                return true;
            case -1354240341:
                if (!mFirmwareFlag.equals("S1_PRO_OVERSEAS")) {
                    return true;
                }
                return false;
            case 431191996:
                str = "BS_S3_PRO";
                mFirmwareFlag.equals(str);
                return true;
            case 1503770892:
                str = "BLACK_SHARK_GT3";
                mFirmwareFlag.equals(str);
                return true;
            default:
                return true;
        }
    }

    public final boolean oXX0IoI() {
        return IIX0o.Oxx0IOOO(BleCache.INSTANCE.getMBleName(), xxOOXo);
    }

    public final boolean oXoXxOo() {
        if (BleCache.INSTANCE.getMSupportContactSort() == 1) {
            return true;
        }
        return false;
    }

    public final ArrayList<String> oXxOI0oIx() {
        return (ArrayList) XIIxIxOOo.getValue();
    }

    public final boolean oXxOXOX() {
        return true;
    }

    public final boolean oXxx000() {
        BleCache.INSTANCE.getMPrototype();
        return xOOxIO(this, null, 1, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x00a5 A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean oo() {
        /*
            Method dump skipped, instructions count: 1420
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ble.ProductManager.oo():boolean");
    }

    public final boolean oo00() {
        BleCache bleCache = BleCache.INSTANCE;
        if (IIX0o.Oxx0IOOO(bleCache.getMBleName(), oX0IoO)) {
            return IIX0o.Oxx0IOOO(bleCache.getMFirmwareFlag(), "JL14_AM08_AM10A_V12_KUMI_KU7");
        }
        return false;
    }

    public final boolean oo0oIXo() {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0050 A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int oo0xXOI0I() {
        /*
            Method dump skipped, instructions count: 1162
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ble.ProductManager.oo0xXOI0I():int");
    }

    public final boolean ooO0oXxI() {
        if (BleCache.INSTANCE.getMSupportBloodPressureCalibration() == 1) {
            return true;
        }
        return false;
    }

    @OOXIXo
    public final ArrayList<String> ooOOo0oXI() {
        return (ArrayList) o0O0Xx.getValue();
    }

    public final boolean ooOx() {
        BleCache bleCache = BleCache.INSTANCE;
        if (!IIX0o.Oxx0IOOO(bleCache.getMBleName(), f20383IxIX0I) && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), "R10") && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), BleDeviceInfo.PROTOTYPE_REALTEK_GTM5) && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), BleDeviceInfo.PROTOTYPE_ND08) && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), "R9") && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), "F7") && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), "F6") && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), BleDeviceInfo.PROTOTYPE_ND09) && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), "Y1") && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), BleDeviceInfo.PROTOTYPE_F3_LH) && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), "V2") && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), "T78") && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), BleDeviceInfo.PROTOTYPE_R3PRO) && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), BleDeviceInfo.PROTOTYPE_R10PRO) && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), "Y2") && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), BleDeviceInfo.PROTOTYPE_F2PRO) && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), "B9") && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), BleDeviceInfo.PROTOTYPE_F13J) && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), "R11") && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), BleDeviceInfo.PROTOTYPE_V5) && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), BleDeviceInfo.PROTOTYPE_V3) && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), BleDeviceInfo.PROTOTYPE_MATCH_S1) && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), BleDeviceInfo.PROTOTYPE_FA86) && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), BleDeviceInfo.PROTOTYPE_S03) && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), "Y3") && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), "W9") && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), "R11S") && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), BleDeviceInfo.PROTOTYPE_EXPLORER) && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), "F12") && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), "F2K") && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), "F11") && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), "F13A") && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), "F13B") && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), "R9J") && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), "AM01") && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), "A7") && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), "A8") && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), "AM01J") && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), "F17") && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), BleDeviceInfo.PROTOTYPE_S4) && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), "AM02J") && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), "S2") && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), BleDeviceInfo.PROTOTYPE_HW01) && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), "F12Pro") && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), BleDeviceInfo.PROTOTYPE_K18) && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), "AM05") && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), BleDeviceInfo.PROTOTYPE_AM22) && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), BleDeviceInfo.PROTOTYPE_K30) && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), "FC1") && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), "FC2") && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), BleDeviceInfo.PROTOTYPE_FT5) && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), "R16") && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), BleDeviceInfo.PROTOTYPE_A8_ULTRA_PRO) && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), BleDeviceInfo.PROTOTYPE_SPORT4) && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), "JX621D") && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), "AM08") && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), "V61") && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), "AM11") && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), "AW37") && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), "X3") && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), "X6") && !IIX0o.Oxx0IOOO(bleCache.getMPrototype(), "X2")) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x02bf A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean ooXIXxIX() {
        /*
            Method dump skipped, instructions count: 1412
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ble.ProductManager.ooXIXxIX():boolean");
    }

    public final boolean oox000IX() {
        if (BleCache.INSTANCE.getMSupportDateFormatSet() == 1) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0055, code lost:
    
        if (r1.equals(com.szabh.smable3.entity.BleDeviceInfo.PROTOTYPE_AM22) == false) goto L132;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006d, code lost:
    
        if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(r0.getMBleName(), com.sma.smartv3.ble.ProductManager.XxOx) != false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0079, code lost:
    
        if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(r0.getMBleName(), com.sma.smartv3.ble.ProductManager.IooOox) == false) goto L139;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:?, code lost:
    
        return com.sma.smartv3.co_fit.R.array.backlight_time_secondary;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x007b, code lost:
    
        return com.sma.smartv3.co_fit.R.array.backlight_time_ten;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005f, code lost:
    
        if (r1.equals("AM05") == false) goto L132;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0018, code lost:
    
        if (r1.equals(com.szabh.smable3.entity.BleDeviceInfo.PROTOTYPE_F13J) == false) goto L132;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00ea, code lost:
    
        if (r1.equals(com.szabh.smable3.entity.BleDeviceInfo.PROTOTYPE_F13) == false) goto L132;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x00ed, code lost:
    
        return com.sma.smartv3.co_fit.R.array.backlight_time_four;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000d. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0105 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int ox() {
        /*
            Method dump skipped, instructions count: 308
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ble.ProductManager.ox():int");
    }

    public final boolean ox0() {
        if (BleCache.INSTANCE.getMSupportStudyCards() == 1) {
            return true;
        }
        return false;
    }

    public final boolean ox0I() {
        if (BleCache.INSTANCE.getMSupportDeviceSportData() == 1) {
            return true;
        }
        return false;
    }

    public final boolean oxIIX0o() {
        String mPrototype = BleCache.INSTANCE.getMPrototype();
        int hashCode = mPrototype.hashCode();
        if (hashCode == 2623 ? mPrototype.equals("S2") : !(hashCode == 68895 ? !mPrototype.equals("F2K") : !(hashCode == 2410926 && mPrototype.equals("NY58")))) {
            return false;
        }
        return true;
    }

    public final boolean oxIO0IIo() {
        if (BleCache.INSTANCE.getMSupportAITranslation() == 1) {
            return true;
        }
        return false;
    }

    public final boolean oxO() {
        BleCache bleCache = BleCache.INSTANCE;
        if (!bleCache.getMDataKeys().contains(Integer.valueOf(BleKey.WORKOUT.getMKey())) && !bleCache.getMDataKeys().contains(Integer.valueOf(BleKey.WORKOUT2.getMKey())) && !bleCache.getMDataKeys().contains(Integer.valueOf(BleKey.WORKOUT3.getMKey()))) {
            return false;
        }
        return true;
    }

    public final boolean oxOIoIx() {
        if (BleCache.INSTANCE.getMSupportReceiptCodeSize() > 0) {
            return true;
        }
        return false;
    }

    public final boolean oxOXxoXII() {
        String str;
        MacConfig macConfig;
        DeviceConfigInfo IOoo2 = IOoo();
        if (IOoo2 != null && (macConfig = IOoo2.getMacConfig()) != null) {
            str = macConfig.getAiModelService();
        } else {
            str = null;
        }
        return IIX0o.Oxx0IOOO(str, "baiduAIService");
    }

    public final int oxXx0IX() {
        return !IIX0o.Oxx0IOOO(BleCache.INSTANCE.getMBleName(), f20383IxIX0I) ? 1 : 0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0049 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int oxoX() {
        /*
            r3 = this;
            com.szabh.smable3.component.BleCache r0 = com.szabh.smable3.component.BleCache.INSTANCE
            java.lang.String r1 = r0.getMPlatform()
            java.lang.String r2 = "SIFLI"
            boolean r1 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r1, r2)
            r2 = 30
            if (r1 == 0) goto L11
            goto L4b
        L11:
            java.lang.String r0 = r0.getMBleName()
            int r1 = r0.hashCode()
            switch(r1) {
                case -1415426288: goto L41;
                case -738395238: goto L38;
                case -197382676: goto L2f;
                case 66171: goto L26;
                case 77240952: goto L1d;
                default: goto L1c;
            }
        L1c:
            goto L49
        L1d:
            java.lang.String r1 = "R1502"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L4b
            goto L49
        L26:
            java.lang.String r1 = "C80"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L49
            goto L4b
        L2f:
            java.lang.String r1 = "Black Shark S1 Classic"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L4b
            goto L49
        L38:
            java.lang.String r1 = "Black Shark S1"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L4b
            goto L49
        L41:
            java.lang.String r1 = "Black Shark GSX"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L4b
        L49:
            r2 = 20
        L4b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ble.ProductManager.oxoX():int");
    }

    @OOXIXo
    public final List<String> oxxXoxO() {
        BleCache bleCache = BleCache.INSTANCE;
        if (IIX0o.Oxx0IOOO(bleCache.getMBleName(), f20496XX0)) {
            if (IIX0o.Oxx0IOOO(bleCache.getMFirmwareFlag(), oo0IoIIOo)) {
                return CollectionsKt__CollectionsKt.X00IoxXI("https://sma-test.oss-accelerate.aliyuncs.com/firmwareVersion/f2_KUMI_NewHRIC_MP_repair_0.0.0.7.bin", "https://sma-test.oss-accelerate.aliyuncs.com/firmwareVersion/f2_SLW_KUMI_NewHRIC_MP_repair_0.0.0.8.bin");
            }
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        return CollectionsKt__CollectionsKt.ooXIXxIX();
    }

    public final int x0() {
        String mPrototype = BleCache.INSTANCE.getMPrototype();
        int hashCode = mPrototype.hashCode();
        if (hashCode == 2778 ? !mPrototype.equals("X2") : !(hashCode == 2779 ? mPrototype.equals("X3") : hashCode == 2782 ? mPrototype.equals("X6") : hashCode == 86287 && mPrototype.equals("X5L"))) {
            return R.string.dial;
        }
        return R.string.online_screensavers;
    }

    public final int x00IOx() {
        return 400;
    }

    public final boolean x00X0xoXO() {
        if (BleCache.INSTANCE.getMSupportDoubleScreen() == 1) {
            return true;
        }
        return false;
    }

    public final boolean x0OIX00oO() {
        DeviceConfigInfo IOoo2 = IOoo();
        if (IOoo2 != null) {
            return oOXoIIIo.I0Io.II0xO0(IOoo2.getSupportSyncContact());
        }
        return Xx000oIo();
    }

    public final boolean x0OOI() {
        if (BleCache.INSTANCE.getMSupportAudioBooks() == 1) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0049, code lost:
    
        if (r0.equals("JL13_AM18_AM18_V1") == false) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x011b, code lost:
    
        r0 = com.blankj.utilcode.util.Utils.getApp().getString(com.sma.smartv3.co_fit.R.string.chatgpt);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0053, code lost:
    
        if (r0.equals("AM10B_RIRO_V1") == false) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00b0, code lost:
    
        r0 = com.blankj.utilcode.util.Utils.getApp();
        kotlin.jvm.internal.IIX0o.oO(r0, "getApp(...)");
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00bd, code lost:
    
        if (com.sma.smartv3.util.UtilsKt.X00IoxXI(r0) == false) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00bf, code lost:
    
        r0 = com.blankj.utilcode.util.Utils.getApp().getString(com.sma.smartv3.co_fit.R.string.wenxinyiyan);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00c8, code lost:
    
        r0 = com.blankj.utilcode.util.Utils.getApp().getString(com.sma.smartv3.co_fit.R.string.chatgpt);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005d, code lost:
    
        if (r0.equals("Y66_V1_NEW") == false) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0067, code lost:
    
        if (r0.equals("A9MINI_AM28_A10_PROMAX") == false) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0071, code lost:
    
        if (r0.equals("AM07_RIRO") == false) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x007b, code lost:
    
        if (r0.equals("R13E_Sveston2") == false) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0085, code lost:
    
        if (r0.equals("AURAFIT_AM10B") == false) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x008f, code lost:
    
        if (r0.equals("AM10B_RIRO") == false) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0099, code lost:
    
        if (r0.equals("AM18P_AM28_AURAFIT_KO") == false) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00a3, code lost:
    
        if (r0.equals("AM05_AURAFIT") == false) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00ad, code lost:
    
        if (r0.equals("SF04_RIRO") == false) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00d7, code lost:
    
        if (r0.equals("MWC_MW01") == false) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00f2, code lost:
    
        if (r0.equals("MWC_MW01_HW") == false) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00fb, code lost:
    
        if (r0.equals("A10C_2_AURAFIT_IW11PRO") == false) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0104, code lost:
    
        if (r0.equals("AM05_AURAFIT_NEW") == false) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x010d, code lost:
    
        if (r0.equals("AM18P_AM28_AURAFIT") == false) goto L138;
     */
    @OXOo.OOXIXo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String x0OxxIOxX() {
        /*
            Method dump skipped, instructions count: 366
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ble.ProductManager.x0OxxIOxX():java.lang.String");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:1297:0x1809, code lost:
    
        if (r0.equals(com.sma.smartv3.ble.ProductManager.f20602x0oox0) == false) goto L7341;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1859:0x237c, code lost:
    
        if (r0.equals(com.sma.smartv3.ble.ProductManager.f20507XoI0Ixx0) == false) goto L7341;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1871:0x23c6, code lost:
    
        if (r0.equals(com.sma.smartv3.ble.ProductManager.f20521XxXX) == false) goto L7341;
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x0366, code lost:
    
        if (r0.equals(com.sma.smartv3.ble.ProductManager.f20398O0Xx) == false) goto L7341;
     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x238a, code lost:
    
        if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(r25.getMPrototype(), com.szabh.smable3.entity.BleDeviceInfo.PROTOTYPE_F2PRO) == false) goto L4194;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2022:0x26e0, code lost:
    
        if (r0.equals(com.sma.smartv3.ble.ProductManager.f20612xIXIOX) == false) goto L7341;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2024:0x2a11, code lost:
    
        if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(r25.getMPrototype(), com.szabh.smable3.entity.BleDeviceInfo.PROTOTYPE_M4S) == false) goto L6758;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2047:0x2753, code lost:
    
        if (r0.equals(com.sma.smartv3.ble.ProductManager.f20645xoX) == false) goto L7341;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2085:0x2820, code lost:
    
        if (r0.equals(com.sma.smartv3.ble.ProductManager.f20330I00O) == false) goto L7341;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2167:0x2a03, code lost:
    
        if (r0.equals(com.sma.smartv3.ble.ProductManager.f20493XOxoX) == false) goto L7341;
     */
    /* JADX WARN: Code restructure failed: missing block: B:338:0x05e2, code lost:
    
        if (r0.equals(com.sma.smartv3.ble.ProductManager.f20400O0x) == false) goto L7341;
     */
    /* JADX WARN: Code restructure failed: missing block: B:339:0x2824, code lost:
    
        r0 = r25.getMPrototype();
     */
    /* JADX WARN: Code restructure failed: missing block: B:340:0x282e, code lost:
    
        if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(r0, com.szabh.smable3.entity.BleDeviceInfo.PROTOTYPE_M6C) == false) goto L6755;
     */
    /* JADX WARN: Code restructure failed: missing block: B:341:0x2830, code lost:
    
        return com.sma.smartv3.co_fit.R.drawable.m6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:343:0x283b, code lost:
    
        if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(r0, com.szabh.smable3.entity.BleDeviceInfo.PROTOTYPE_M4C) == false) goto L6758;
     */
    /* JADX WARN: Code restructure failed: missing block: B:557:0x09f0, code lost:
    
        if (r0.equals(com.sma.smartv3.ble.ProductManager.f20430OXIOoo0X0) == false) goto L7341;
     */
    /* JADX WARN: Code restructure failed: missing block: B:655:0x0bbf, code lost:
    
        if (r0.equals(com.sma.smartv3.ble.ProductManager.f20443OooO0XOx) == false) goto L7341;
     */
    /* JADX WARN: Code restructure failed: missing block: B:800:0x0e6a, code lost:
    
        if (r0.equals(com.sma.smartv3.ble.ProductManager.f20652xx0) == false) goto L7341;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x004a. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:100:0x295d A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1050:0x255c A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1053:0x2b32 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0e96 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1099:0x1413 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x1821 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1126:0x1a44 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1137:0x14cc A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1147:0x2ffb A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0da2 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1203:0x1611 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1247:0x1a71 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x086c A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1256:0x1745 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1316:0x1876 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1335:0x1df4 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x2e66 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1405:0x290d A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1423:0x1b39 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1457:0x1e21 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1522:0x1ca5 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:152:0x2dae A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1557:0x2890 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1571:0x21cb A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x2f47 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1626:0x1ec4 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1635:0x2784 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1665:0x1f89 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:166:0x1aee A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:172:0x24b2 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1741:0x21b2 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:175:0x2944 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1778:0x2f01 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1800:0x2460 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1806:0x2d36 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:180:0x2dea A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1857:0x2d27 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:188:0x2321 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x1698 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:193:0x2dc7 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:2006:0x2699 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0ee1 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0c5b A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:214:0x2b14 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x2e7f A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:233:0x1969 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:241:0x2d5e A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:2468:0x307e A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x1b8b A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:258:0x047e A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:265:0x2cdf A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0ce2 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:286:0x300a A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:301:0x1722 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:306:0x2ed9 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x2082 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:312:0x1e44 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:318:0x2815 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x1b90 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:344:0x283f A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:345:0x22bb A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:355:0x2fec A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:367:0x13be A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0483 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:376:0x0672 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:379:0x2cd0 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:386:0x216c A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:394:0x06c2 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:405:0x1d5a A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:413:0x130f A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:420:0x2194 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:429:0x25cf A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x20a2 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x093b A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x2c94 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:551:0x09d1 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:560:0x1ca0 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:567:0x2fbf A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:584:0x0a9c A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x209d A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:5:0x08a5 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:600:0x25de A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x2234 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:626:0x17d6 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:635:0x0b5f A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x1706 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:650:0x1d9e A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:667:0x202d A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:673:0x297b A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:695:0x2f10 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:702:0x1a12 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:707:0x13a0 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x2f60 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:715:0x1dc9 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:727:0x27c5 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:752:0x28fe A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:779:0x2ef2 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:789:0x19c7 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x3019 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:794:0x263f A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:798:0x2cc1 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:803:0x16ca A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:806:0x1c62 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:813:0x2312 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:822:0x2617 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:837:0x29d0 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x1f19 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:853:0x19d6 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:858:0x2a3d A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:930:0x2f2e A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:935:0x1620 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:938:0x2c3a A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x2d4f A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:972:0x1c17 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:977:0x1790 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x2b8c A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:996:0x120b A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int x0XOIxOo(@OXOo.OOXIXo com.szabh.smable3.entity.BleDeviceInfo r25) {
        /*
            Method dump skipped, instructions count: 16388
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ble.ProductManager.x0XOIxOo(com.szabh.smable3.entity.BleDeviceInfo):int");
    }

    public final int x0o() {
        BleCache.INSTANCE.getMPrototype();
        return 12;
    }

    public final boolean x0oox0() {
        IIX0o.Oxx0IOOO(BleCache.INSTANCE.getMPrototype(), BleDeviceInfo.PROTOTYPE_GB1);
        return false;
    }

    public final boolean x0oxIIIX() {
        if (!com.sma.smartv3.util.Xo0.f24349oIX0oI.XO().getBoolean(XoI0Ixx0.f24399Ox0O, false) && !xx0()) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000d. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:10:0x009d A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:5:0x00aa A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int x0xO() {
        /*
            r3 = this;
            com.szabh.smable3.component.BleCache r0 = com.szabh.smable3.component.BleCache.INSTANCE
            java.lang.String r0 = r0.getMFirmwareFlag()
            int r1 = r0.hashCode()
            r2 = 2131234438(0x7f080e86, float:1.8085042E38)
            switch(r1) {
                case -2140600391: goto La1;
                case -1957226515: goto L94;
                case -1652604122: goto L8b;
                case -1546093392: goto L82;
                case -1546093389: goto L79;
                case -1354240341: goto L72;
                case -1029950260: goto L69;
                case -496016204: goto L60;
                case -275859767: goto L57;
                case 431191996: goto L4e;
                case 603864480: goto L44;
                case 1115516277: goto L3a;
                case 1153115964: goto L30;
                case 1298570543: goto L26;
                case 1462006480: goto L1c;
                case 1503770892: goto L12;
                default: goto L10;
            }
        L10:
            goto Lad
        L12:
            java.lang.String r1 = "BLACK_SHARK_GT3"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto Laa
            goto Lad
        L1c:
            java.lang.String r1 = "S1_LITE_V6"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L9d
            goto Lad
        L26:
            java.lang.String r1 = "BLACK_SHARK_GT3_V101"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto Laa
            goto Lad
        L30:
            java.lang.String r1 = "BS_S1_PRO_VC30FS"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L9d
            goto Lad
        L3a:
            java.lang.String r1 = "BS_S3_PRO_CC1165W"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L9d
            goto Lad
        L44:
            java.lang.String r1 = "BS_S3_PRO_KOREAN_CC1165W"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto Laa
            goto Lad
        L4e:
            java.lang.String r1 = "BS_S3_PRO"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L9d
            goto Lad
        L57:
            java.lang.String r1 = "F34_BS_GT3_NEO"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto Laa
            goto Lad
        L60:
            java.lang.String r1 = "BS_S3_PRO_OVERSEAS_CC1165W"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto Laa
            goto Lad
        L69:
            java.lang.String r1 = "BS_S3_PRO_CC1165W_ZFB"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L9d
            goto Lad
        L72:
            java.lang.String r1 = "S1_PRO_OVERSEAS"
            boolean r0 = r0.equals(r1)
            goto Lad
        L79:
            java.lang.String r1 = "S1_PRO_OVERSEAS_V5"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto Laa
            goto Lad
        L82:
            java.lang.String r1 = "S1_PRO_OVERSEAS_V2"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto Laa
            goto Lad
        L8b:
            java.lang.String r1 = "BLACK_SHARK_S1_PRO"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L9d
            goto Lad
        L94:
            java.lang.String r1 = "BS_S1_PRO_LOCKFACE"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L9d
            goto Lad
        L9d:
            r2 = 2131234434(0x7f080e82, float:1.8085034E38)
            goto Lad
        La1:
            java.lang.String r1 = "BS_GT3_NEO_KV"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto Laa
            goto Lad
        Laa:
            r2 = 2131234439(0x7f080e87, float:1.8085044E38)
        Lad:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ble.ProductManager.x0xO():int");
    }

    @OOXIXo
    public final String x0xO0oo(@OOXIXo String name) {
        IIX0o.x0xO0oo(name, "name");
        for (String str : oOII0) {
            if (OxI.IOOoXo0Ix(name, str, false, 2, null)) {
                return str;
            }
        }
        return name;
    }

    public final boolean x0xOIoO() {
        if (BleCache.INSTANCE.getMSupportRestoreFactory() == 1) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x004d A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean xI() {
        /*
            Method dump skipped, instructions count: 1212
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ble.ProductManager.xI():boolean");
    }

    public final boolean xI0OXooO() {
        if (BleCache.INSTANCE.getMSupportStandbySet() == 1) {
            return true;
        }
        return false;
    }

    public final boolean xI0oxI00() {
        if (BleCache.INSTANCE.getMSupportRequestRealtimeWeather() == 1) {
            return true;
        }
        return false;
    }

    public final int xII() {
        BleCache.INSTANCE.getMBleName();
        return 0;
    }

    public final boolean xIOXX() {
        return com.sma.smartv3.util.Xo0.f24349oIX0oI.II0xO0().getBoolean(XoI0Ixx0.f24411X0xxXX0, false);
    }

    public final boolean xIXIOX() {
        return false;
    }

    public final boolean xIXOoI() {
        String supComment;
        AppConfigInfo XI2 = XI();
        if (XI2 != null && (supComment = XI2.getSupComment()) != null) {
            return supComment.equals("0");
        }
        return false;
    }

    @OOXIXo
    public final String xIXX(int i) {
        String string;
        try {
            int identifier = Utils.getApp().getResources().getIdentifier(NotificationCompat.CATEGORY_WORKOUT + i, TypedValues.Custom.S_STRING, Utils.getApp().getPackageName());
            if (identifier == 0) {
                string = Utils.getApp().getString(R.string.workout9);
            } else if (xxx00()) {
                int identifier2 = Utils.getApp().getResources().getIdentifier(NotificationCompat.CATEGORY_WORKOUT + i + "_2", TypedValues.Custom.S_STRING, Utils.getApp().getPackageName());
                if (identifier2 == 0) {
                    string = Utils.getApp().getString(identifier);
                } else {
                    string = Utils.getApp().getString(identifier2);
                }
            } else {
                string = Utils.getApp().getString(identifier);
            }
        } catch (Exception e) {
            e.printStackTrace();
            string = Utils.getApp().getString(R.string.workout9);
        }
        IIX0o.ooOOo0oXI(string);
        return string;
    }

    public final boolean xIXoO0Xx() {
        if (BleCache.INSTANCE.getMSupportPressureTimingMeasurement() == 1) {
            return true;
        }
        return false;
    }

    public final boolean xIoXXXIXo() {
        if (BleCache.INSTANCE.getMSupportFallSet() == 1) {
            return true;
        }
        return false;
    }

    public final boolean xIx() {
        return IIX0o.Oxx0IOOO(BleCache.INSTANCE.getMPrototype(), BleDeviceInfo.PROTOTYPE_RN01);
    }

    public final boolean xIx0XO() {
        if (IIX0o.Oxx0IOOO(oI0IIXIo(), "baiduAIService") || oxOXxoXII()) {
            return true;
        }
        if (!IxX00() && (!IIX0o.Oxx0IOOO(oI0IIXIo(), "openAIService") || XOx())) {
            BleCache bleCache = BleCache.INSTANCE;
            if (!IIX0o.Oxx0IOOO(bleCache.getMBleName(), XXOoooXo) || !IIX0o.Oxx0IOOO(bleCache.getMFirmwareFlag(), "AC02K_AM07_W113_BW115C")) {
                return true;
            }
        }
        return false;
    }

    public final boolean xIxooxXX() {
        String mFirmwareFlag = BleCache.INSTANCE.getMFirmwareFlag();
        if (IIX0o.Oxx0IOOO(mFirmwareFlag, "KUMI_KU7_Plus")) {
            return true;
        }
        return IIX0o.Oxx0IOOO(mFirmwareFlag, "KUMI_DeepSeek");
    }

    public final boolean xOI0() {
        if (BleCache.INSTANCE.getMSupportVoiceMaxLength() == 1) {
            return true;
        }
        return false;
    }

    public final void xOIO() {
        if (IIX0o.Oxx0IOOO(BleCache.INSTANCE.getMPrototype(), BleDeviceInfo.PROTOTYPE_HW01)) {
            BleConnector.INSTANCE.setDisableStreamLog(false);
        }
    }

    public final int xOOOX() {
        return X0XoO;
    }

    public final boolean xOOxI() {
        if (BleCache.getInt$default(BleCache.INSTANCE, BleKey.POWER_SAVE_MODE, 0, null, 6, null) == 1) {
            return true;
        }
        return false;
    }

    public final boolean xOoIIIoXI() {
        if (BleCache.INSTANCE.getMSupportMedicationReminder() == 1) {
            return true;
        }
        return false;
    }

    public final boolean xOoOIoI() {
        boolean Oxx0IOOO2;
        String mPrototype = BleCache.INSTANCE.getMPrototype();
        if (IIX0o.Oxx0IOOO(mPrototype, "F3")) {
            Oxx0IOOO2 = true;
        } else {
            Oxx0IOOO2 = IIX0o.Oxx0IOOO(mPrototype, BleDeviceInfo.PROTOTYPE_R2);
        }
        return !Oxx0IOOO2;
    }

    public final boolean xOxOoo() {
        if (BleCache.INSTANCE.getMSupportMyCardCodeSize() > 0) {
            return true;
        }
        return false;
    }

    public final boolean xOxxXO() {
        if (BleCache.INSTANCE.getMSupportNoDisturbSet() == 1) {
            return true;
        }
        return false;
    }

    public final int xX() {
        if (xOI0()) {
            return 250;
        }
        if (xOOxIO(this, null, 1, null)) {
            return 50;
        }
        return 150;
    }

    public final int xX0IIXIx0() {
        return oXXI0OO;
    }

    public final boolean xX0ox() {
        if (oXXxI == 1) {
            return true;
        }
        return false;
    }

    public final boolean xXIX0Xo() {
        if (BleCache.INSTANCE.getMSupportTemperatureUnitSet() == 1) {
            return true;
        }
        return false;
    }

    public final int xXOx() {
        BleCache.INSTANCE.getMPrototype();
        return 9;
    }

    public final void xXXxoI(int i) {
        X0o0O0x = i;
    }

    public final boolean xXo() {
        return false;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000d. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:13:0x002c A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0049 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int xXoOI00O() {
        /*
            r3 = this;
            com.szabh.smable3.component.BleCache r0 = com.szabh.smable3.component.BleCache.INSTANCE
            java.lang.String r0 = r0.getMFirmwareFlag()
            int r1 = r0.hashCode()
            r2 = 2131234433(0x7f080e81, float:1.8085032E38)
            switch(r1) {
                case -1022723492: goto L30;
                case 7551622: goto L23;
                case 1418122242: goto L1a;
                case 1718400542: goto L11;
                default: goto L10;
            }
        L10:
            goto L4c
        L11:
            java.lang.String r1 = "AM10B_RIRO_V1"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L39
            goto L4c
        L1a:
            java.lang.String r1 = "Y66_V1_NEW"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L2c
            goto L4c
        L23:
            java.lang.String r1 = "AURAFIT_AM10B"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L2c
            goto L4c
        L2c:
            r2 = 2131234439(0x7f080e87, float:1.8085044E38)
            goto L4c
        L30:
            java.lang.String r1 = "SF04_RIRO"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L39
            goto L4c
        L39:
            android.app.Application r0 = com.blankj.utilcode.util.Utils.getApp()
            java.lang.String r1 = "getApp(...)"
            kotlin.jvm.internal.IIX0o.oO(r0, r1)
            boolean r0 = com.sma.smartv3.util.UtilsKt.X00IoxXI(r0)
            if (r0 == 0) goto L49
            goto L4c
        L49:
            r2 = 2131234438(0x7f080e86, float:1.8085042E38)
        L4c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ble.ProductManager.xXoOI00O():int");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0107 A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean xXxxox0I() {
        /*
            Method dump skipped, instructions count: 530
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ble.ProductManager.xXxxox0I():boolean");
    }

    public final boolean xo() {
        if (BleCache.INSTANCE.getMSupportFindWatch() == 1) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int xo0x() {
        boolean z;
        String mBleName = BleCache.INSTANCE.getMBleName();
        if (IIX0o.Oxx0IOOO(mBleName, f20432OXXoIoXI)) {
            z = 1;
        } else {
            z = IIX0o.Oxx0IOOO(mBleName, f20419OOIXx0x);
        }
        return !z;
    }

    public final boolean xoIXOxX() {
        if (BleCache.INSTANCE.getMSupportHID() == 1) {
            return true;
        }
        return false;
    }

    public final int xoIox() {
        if (xIx()) {
            return 60;
        }
        return 30;
    }

    public final int xoIxX() {
        DeviceConfigInfo IOoo2 = IOoo();
        if (IOoo2 != null) {
            return IOoo2.getScheduleMax();
        }
        return oo0xXOI0I();
    }

    public final boolean xoO0xx0() {
        DeviceConfigInfo IOoo2 = IOoo();
        if (IOoo2 != null) {
            return oOXoIIIo.I0Io.II0xO0(IOoo2.getSupportGirlCare());
        }
        return oo();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0026, code lost:
    
        if (r0.equals("S1_LITE_OVERSEAS") == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x002f, code lost:
    
        if (r0.equals("BLACK_SHARK_NEW_105") != false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0038, code lost:
    
        if (r0.equals("BLACK_SHARK_S1_LITE") == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0041, code lost:
    
        if (r0.equals("BLACK_SHARK") == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004a, code lost:
    
        if (r0.equals("AIGO_V6H_V8_V51") == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0053, code lost:
    
        if (r0.equals("S1_LITE_OVERSEAS_300") == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0014, code lost:
    
        if (r0.equals("BS_W2406_OVERSEA") == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x005a, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001d, code lost:
    
        if (r0.equals("BLACK_SHARK_NEW") == false) goto L60;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean xoX() {
        /*
            r2 = this;
            com.szabh.smable3.component.BleCache r0 = com.szabh.smable3.component.BleCache.INSTANCE
            java.lang.String r0 = r0.getMFirmwareFlag()
            int r1 = r0.hashCode()
            switch(r1) {
                case -1413929540: goto L4d;
                case -975303333: goto L44;
                case -464146587: goto L3b;
                case 308752181: goto L32;
                case 731937757: goto L29;
                case 765392136: goto L20;
                case 1503777190: goto L17;
                case 1933474765: goto Le;
                default: goto Ld;
            }
        Ld:
            goto L55
        Le:
            java.lang.String r1 = "BS_W2406_OVERSEA"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L5a
            goto L55
        L17:
            java.lang.String r1 = "BLACK_SHARK_NEW"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L5a
            goto L55
        L20:
            java.lang.String r1 = "S1_LITE_OVERSEAS"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L5a
            goto L55
        L29:
            java.lang.String r1 = "BLACK_SHARK_NEW_105"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L55
            goto L5a
        L32:
            java.lang.String r1 = "BLACK_SHARK_S1_LITE"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L5a
            goto L55
        L3b:
            java.lang.String r1 = "BLACK_SHARK"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L5a
            goto L55
        L44:
            java.lang.String r1 = "AIGO_V6H_V8_V51"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L5a
            goto L55
        L4d:
            java.lang.String r1 = "S1_LITE_OVERSEAS_300"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L5a
        L55:
            boolean r0 = r2.OOXIxO0()
            goto L5b
        L5a:
            r0 = 0
        L5b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ble.ProductManager.xoX():boolean");
    }

    public final int xoXoI() {
        if (IIX0o.Oxx0IOOO(BleCache.INSTANCE.getMPlatform(), BleDeviceInfo.PLATFORM_MTK)) {
            return 5;
        }
        return 0;
    }

    public final boolean xooxxX() {
        CustomConfigInfo customConfig;
        String supHardwareAliPay;
        DeviceConfigInfo IOoo2 = IOoo();
        if (IOoo2 != null && (customConfig = IOoo2.getCustomConfig()) != null && (supHardwareAliPay = customConfig.getSupHardwareAliPay()) != null) {
            return supHardwareAliPay.equals("1");
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000a. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0034 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:5:0x0037 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0029 A[RETURN, SYNTHETIC] */
    @OXOo.OOXIXo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String xox() {
        /*
            r2 = this;
            com.szabh.smable3.component.BleCache r0 = com.szabh.smable3.component.BleCache.INSTANCE
            java.lang.String r0 = r0.getMFirmwareFlag()
            int r1 = r0.hashCode()
            switch(r1) {
                case -1861407550: goto L2c;
                case -1441684849: goto L20;
                case -846744416: goto L17;
                case 62930663: goto Le;
                default: goto Ld;
            }
        Ld:
            goto L34
        Le:
            java.lang.String r1 = "WSQ_GR_1"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L37
            goto L34
        L17:
            java.lang.String r1 = "AM05_AURAFIT"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L29
            goto L34
        L20:
            java.lang.String r1 = "F34_WSQ_GT"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L29
            goto L34
        L29:
            java.lang.String r0 = "openAIService"
            goto L39
        L2c:
            java.lang.String r1 = "KW17_WSQ_GR"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L37
        L34:
            java.lang.String r0 = ""
            goto L39
        L37:
            java.lang.String r0 = "ChatGpt"
        L39:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ble.ProductManager.xox():java.lang.String");
    }

    public final boolean xoxXI() {
        DeviceConfigInfo IOoo2 = IOoo();
        if (IOoo2 != null) {
            return oOXoIIIo.I0Io.II0xO0(IOoo2.getRequireReadAlarm());
        }
        return ooXIXxIX();
    }

    public final boolean xoxo() {
        if (BleCache.INSTANCE.getMSupportRingVibrationSet() == 1) {
            return true;
        }
        return false;
    }

    public final boolean xx(int i) {
        return i == 116;
    }

    public final boolean xx0() {
        if (!oIXoXx0() && !Xx()) {
            return false;
        }
        return true;
    }

    public final boolean xx00oOoI() {
        return true;
    }

    public final void xx0O(int i) {
        X0XoO = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x002b A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean xx0X0() {
        /*
            r5 = this;
            com.szabh.smable3.component.BleCache r0 = com.szabh.smable3.component.BleCache.INSTANCE
            java.lang.String r1 = r0.getMPlatform()
            int r2 = r1.hashCode()
            r3 = 0
            r4 = 1
            switch(r2) {
                case -1955887059: goto L36;
                case -1549651556: goto L2d;
                case 2370: goto L22;
                case 70659068: goto L19;
                case 1697379018: goto L10;
                default: goto Lf;
            }
        Lf:
            goto L70
        L10:
            java.lang.String r0 = "JL707Lite"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L2b
            goto L70
        L19:
            java.lang.String r0 = "JL707"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L2b
            goto L70
        L22:
            java.lang.String r0 = "JL"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L2b
            goto L70
        L2b:
            r3 = 1
            goto L70
        L2d:
            java.lang.String r0 = "Realtek"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L70
            goto L2b
        L36:
            java.lang.String r2 = "Nordic"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L3f
            goto L70
        L3f:
            java.lang.String r1 = r0.getMPrototype()
            java.lang.String r2 = "SMA-ND09"
            boolean r1 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r1, r2)
            if (r1 != 0) goto L2b
            java.lang.String r1 = r0.getMPrototype()
            java.lang.String r2 = "SMA-ND08"
            boolean r1 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r1, r2)
            if (r1 != 0) goto L2b
            java.lang.String r1 = r0.getMPrototype()
            java.lang.String r2 = "SMA_FA_86"
            boolean r1 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r1, r2)
            if (r1 != 0) goto L2b
            java.lang.String r0 = r0.getMPrototype()
            java.lang.String r1 = "SMA_MC_11"
            boolean r0 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r0, r1)
            if (r0 == 0) goto L70
            goto L2b
        L70:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ble.ProductManager.xx0X0():boolean");
    }

    public final boolean xx0o0O() {
        if (X0XoO == 1) {
            return true;
        }
        return false;
    }

    public final int xxIO() {
        return xIXoXOXx;
    }

    public final boolean xxIXOIIO() {
        DeviceConfigInfo IOoo2 = IOoo();
        if (IOoo2 != null) {
            return oOXoIIIo.I0Io.II0xO0(IOoo2.getDefHeartRateMonitoringSwitch());
        }
        return IIX0o();
    }

    public final int xxOXOOoIX() {
        BleCache bleCache = BleCache.INSTANCE;
        String mBleName = bleCache.getMBleName();
        if (IIX0o.Oxx0IOOO(mBleName, f20404OI0)) {
            if (bleCache.getMWatchFaceType() == 10) {
                return 19;
            }
            return bleCache.getMWatchFaceType();
        }
        if (IIX0o.Oxx0IOOO(mBleName, f20369Io)) {
            if (bleCache.getMWatchFaceType() == 10) {
                return 20;
            }
            return bleCache.getMWatchFaceType();
        }
        return bleCache.getMWatchFaceType();
    }

    @OOXIXo
    public final String xxX() {
        if (IIX0o.Oxx0IOOO(BleCache.INSTANCE.getMFirmwareFlag(), OOX0x)) {
            return "Woman Health Tracker";
        }
        String string = Utils.getApp().getString(R.string.health_care);
        IIX0o.oO(string, "getString(...)");
        return string;
    }

    public final boolean xxXXXxIxo() {
        if (BleCache.INSTANCE.getMSupportJLTransport() == 1) {
            return true;
        }
        return false;
    }

    public final boolean xxx00() {
        BleCache bleCache = BleCache.INSTANCE;
        if (!IIX0o.Oxx0IOOO(bleCache.getMPlatform(), BleDeviceInfo.PLATFORM_SIFLI) && !IIX0o.Oxx0IOOO(bleCache.getMPlatform(), BleDeviceInfo.PLATFORM_JL707)) {
            return false;
        }
        return true;
    }

    public final boolean xxxI() {
        return IIX0o.Oxx0IOOO(BleCache.INSTANCE.getMPrototype(), BleDeviceInfo.PROTOTYPE_BC01);
    }

    public final boolean xxxoo0XI() {
        if (BleCache.INSTANCE.getMSupportIBeaconSet() == 1) {
            return true;
        }
        return false;
    }
}
