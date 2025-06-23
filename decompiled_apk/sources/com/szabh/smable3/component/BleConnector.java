package com.szabh.smable3.component;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import X0.IIXOooo;
import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.content.Context;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.bestmafen.baseble.connector.AbsBleConnector;
import com.bestmafen.baseble.data.BleBuffer;
import com.bestmafen.baseble.data.ByteArrayExtKt;
import com.realsil.sdk.core.RtkConfigure;
import com.realsil.sdk.core.RtkCore;
import com.realsil.sdk.dfu.RtkDfu;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.BleKeyFlag;
import com.szabh.smable3.component.BleHandleCallback;
import com.szabh.smable3.entity.BleCoaching;
import com.szabh.smable3.entity.BleCoachingIds;
import com.szabh.smable3.entity.BleDeviceInfo;
import com.szabh.smable3.entity.BleIdObject;
import com.szabh.smable3.entity.BleLoveTapUser;
import com.szabh.smable3.entity.BleMusicControl;
import com.szabh.smable3.entity.BleStream;
import com.szabh.smable3.entity.BleStreamPacket;
import com.szabh.smable3.entity.MusicAttr;
import com.szabh.smable3.entity.MusicEntity;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.OxxIIOOXO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlin.random.Random;
import kotlin.text.OxI;
import kotlin.text.oxoX;
import no.nordicsemi.android.dfu.DfuServiceInitiator;
import xII.II0XooXoX;
import xII.X0o0xo;

@XX({"SMAP\nBleConnector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleConnector.kt\ncom/szabh/smable3/component/BleConnector\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 BleReadable.kt\ncom/bestmafen/baseble/data/BleReadable$Companion\n+ 5 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,3531:1\n350#2,7:3532\n1549#2:3539\n1620#2,3:3540\n350#2,7:3543\n350#2,7:3550\n1549#2:3557\n1620#2,3:3558\n1855#2,2:3561\n1864#2,3:3563\n1855#2,2:3566\n766#2:3569\n857#2,2:3570\n1549#2:3572\n1620#2,3:3573\n350#2,7:3634\n350#2,7:3641\n350#2,7:3824\n350#2,7:3831\n350#2,7:3856\n350#2,7:3863\n350#2,7:3903\n350#2,7:3910\n350#2,7:4665\n350#2,7:4685\n1855#2,2:4790\n1855#2,2:4792\n1#3:3568\n277#4,5:3576\n277#4,5:3581\n277#4,5:3586\n277#4,5:3591\n277#4,5:3596\n277#4,5:3601\n277#4,5:3606\n277#4,5:3611\n289#4,7:3616\n277#4,5:3623\n298#4:3628\n277#4,5:3629\n277#4,5:3648\n277#4,5:3653\n277#4,5:3658\n277#4,5:3663\n277#4,5:3668\n289#4,7:3673\n277#4,5:3680\n298#4:3685\n289#4,7:3686\n277#4,5:3693\n298#4:3698\n289#4,7:3699\n277#4,5:3706\n298#4:3711\n289#4,7:3712\n277#4,5:3719\n298#4:3724\n289#4,7:3725\n277#4,5:3732\n298#4:3737\n277#4,5:3738\n289#4,7:3743\n277#4,5:3750\n298#4:3755\n277#4,5:3756\n277#4,5:3761\n277#4,5:3766\n277#4,5:3771\n277#4,5:3776\n277#4,5:3781\n277#4,5:3786\n277#4,5:3791\n277#4,5:3796\n277#4,5:3801\n289#4,7:3806\n277#4,5:3813\n298#4:3818\n277#4,5:3819\n289#4,7:3838\n277#4,5:3845\n298#4:3850\n277#4,5:3851\n277#4,5:3870\n277#4,5:3875\n277#4,5:3880\n289#4,7:3885\n277#4,5:3892\n298#4:3897\n277#4,5:3898\n277#4,5:3917\n277#4,5:3922\n277#4,5:3927\n277#4,5:3932\n277#4,5:3937\n277#4,5:3942\n277#4,5:3947\n277#4,5:3952\n277#4,5:3957\n277#4,5:3962\n277#4,5:3967\n277#4,5:3972\n277#4,5:3977\n277#4,5:3982\n277#4,5:3987\n277#4,5:3992\n277#4,5:3997\n277#4,5:4002\n277#4,5:4007\n277#4,5:4012\n277#4,5:4017\n277#4,5:4022\n277#4,5:4027\n277#4,5:4032\n277#4,5:4037\n277#4,5:4042\n277#4,5:4047\n277#4,5:4052\n277#4,5:4057\n277#4,5:4062\n277#4,5:4067\n277#4,5:4072\n277#4,5:4077\n277#4,5:4082\n277#4,5:4087\n277#4,5:4092\n277#4,5:4097\n277#4,5:4102\n277#4,5:4107\n277#4,5:4112\n277#4,5:4117\n277#4,5:4122\n277#4,5:4127\n277#4,5:4132\n277#4,5:4137\n277#4,5:4142\n277#4,5:4147\n277#4,5:4152\n277#4,5:4157\n277#4,5:4162\n277#4,5:4167\n277#4,5:4172\n277#4,5:4177\n277#4,5:4182\n277#4,5:4187\n289#4,7:4192\n277#4,5:4199\n298#4:4204\n289#4,7:4205\n277#4,5:4212\n298#4:4217\n289#4,7:4218\n277#4,5:4225\n298#4:4230\n289#4,7:4231\n277#4,5:4238\n298#4:4243\n277#4,5:4244\n277#4,5:4249\n289#4,7:4258\n277#4,5:4265\n298#4:4270\n289#4,7:4271\n277#4,5:4278\n298#4:4283\n289#4,7:4284\n277#4,5:4291\n298#4:4296\n289#4,7:4297\n277#4,5:4304\n298#4:4309\n289#4,7:4310\n277#4,5:4317\n298#4:4322\n289#4,7:4323\n277#4,5:4330\n298#4:4335\n289#4,7:4336\n277#4,5:4343\n298#4:4348\n289#4,7:4349\n277#4,5:4356\n298#4:4361\n289#4,7:4362\n277#4,5:4369\n298#4:4374\n289#4,7:4375\n277#4,5:4382\n298#4:4387\n289#4,7:4388\n277#4,5:4395\n298#4:4400\n289#4,7:4401\n277#4,5:4408\n298#4:4413\n289#4,7:4414\n277#4,5:4421\n298#4:4426\n289#4,7:4427\n277#4,5:4434\n298#4:4439\n289#4,7:4440\n277#4,5:4447\n298#4:4452\n289#4,7:4453\n277#4,5:4460\n298#4:4465\n289#4,7:4466\n277#4,5:4473\n298#4:4478\n289#4,7:4479\n277#4,5:4486\n298#4:4491\n289#4,7:4492\n277#4,5:4499\n298#4:4504\n289#4,7:4505\n277#4,5:4512\n298#4:4517\n289#4,7:4518\n277#4,5:4525\n298#4:4530\n289#4,7:4531\n277#4,5:4538\n298#4:4543\n289#4,7:4544\n277#4,5:4551\n298#4:4556\n289#4,7:4557\n277#4,5:4564\n298#4:4569\n289#4,7:4570\n277#4,5:4577\n298#4:4582\n289#4,7:4583\n277#4,5:4590\n298#4:4595\n289#4,7:4596\n277#4,5:4603\n298#4:4608\n289#4,7:4609\n277#4,5:4616\n298#4:4621\n277#4,5:4622\n277#4,5:4627\n277#4,5:4632\n277#4,5:4637\n277#4,5:4642\n277#4,5:4647\n289#4,7:4652\n277#4,5:4659\n298#4:4664\n289#4,7:4672\n277#4,5:4679\n298#4:4684\n277#4,5:4692\n277#4,5:4697\n277#4,5:4702\n277#4,5:4707\n277#4,5:4712\n277#4,5:4717\n277#4,5:4722\n277#4,5:4727\n277#4,5:4732\n277#4,5:4737\n277#4,5:4742\n277#4,5:4747\n277#4,5:4752\n277#4,5:4757\n277#4,5:4762\n277#4,5:4767\n277#4,5:4772\n289#4,7:4777\n277#4,5:4784\n298#4:4789\n11075#5:4254\n11410#5,3:4255\n*S KotlinDebug\n*F\n+ 1 BleConnector.kt\ncom/szabh/smable3/component/BleConnector\n*L\n378#1:3532,7\n436#1:3539\n436#1:3540,3\n447#1:3543,7\n464#1:3550,7\n491#1:3557\n491#1:3558,3\n492#1:3561,2\n507#1:3563,3\n519#1:3566,2\n800#1:3569\n800#1:3570,2\n801#1:3572\n801#1:3573,3\n1061#1:3634,7\n1077#1:3641,7\n1519#1:3824,7\n1535#1:3831,7\n1560#1:3856,7\n1576#1:3863,7\n1631#1:3903,7\n1647#1:3910,7\n2994#1:4665,7\n3024#1:4685,7\n3370#1:4790,2\n3376#1:4792,2\n917#1:3576,5\n959#1:3581,5\n968#1:3586,5\n977#1:3591,5\n985#1:3596,5\n1013#1:3601,5\n1023#1:3606,5\n1033#1:3611,5\n1044#1:3616,7\n1044#1:3623,5\n1044#1:3628\n1059#1:3629,5\n1085#1:3648,5\n1107#1:3653,5\n1126#1:3658,5\n1138#1:3663,5\n1147#1:3668,5\n1165#1:3673,7\n1165#1:3680,5\n1165#1:3685\n1175#1:3686,7\n1175#1:3693,5\n1175#1:3698\n1185#1:3699,7\n1185#1:3706,5\n1185#1:3711\n1195#1:3712,7\n1195#1:3719,5\n1195#1:3724\n1205#1:3725,7\n1205#1:3732,5\n1205#1:3737\n1215#1:3738,5\n1225#1:3743,7\n1225#1:3750,5\n1225#1:3755\n1285#1:3756,5\n1320#1:3761,5\n1328#1:3766,5\n1361#1:3771,5\n1371#1:3776,5\n1387#1:3781,5\n1397#1:3786,5\n1406#1:3791,5\n1414#1:3796,5\n1427#1:3801,5\n1506#1:3806,7\n1506#1:3813,5\n1506#1:3818\n1517#1:3819,5\n1547#1:3838,7\n1547#1:3845,5\n1547#1:3850\n1558#1:3851,5\n1587#1:3870,5\n1597#1:3875,5\n1608#1:3880,5\n1618#1:3885,7\n1618#1:3892,5\n1618#1:3897\n1629#1:3898,5\n1655#1:3917,5\n1666#1:3922,5\n1676#1:3927,5\n1684#1:3932,5\n1694#1:3937,5\n1708#1:3942,5\n1718#1:3947,5\n1728#1:3952,5\n1736#1:3957,5\n1746#1:3962,5\n1756#1:3967,5\n1767#1:3972,5\n1776#1:3977,5\n1786#1:3982,5\n1796#1:3987,5\n1804#1:3992,5\n1831#1:3997,5\n1841#1:4002,5\n1853#1:4007,5\n1863#1:4012,5\n1887#1:4017,5\n1897#1:4022,5\n1907#1:4027,5\n1915#1:4032,5\n1925#1:4037,5\n1933#1:4042,5\n1957#1:4047,5\n1967#1:4052,5\n1975#1:4057,5\n1999#1:4062,5\n2009#1:4067,5\n2017#1:4072,5\n2027#1:4077,5\n2058#1:4082,5\n2066#1:4087,5\n2076#1:4092,5\n2084#1:4097,5\n2094#1:4102,5\n2104#1:4107,5\n2112#1:4112,5\n2122#1:4117,5\n2130#1:4122,5\n2140#1:4127,5\n2148#1:4132,5\n2158#1:4137,5\n2168#1:4142,5\n2183#1:4147,5\n2193#1:4152,5\n2203#1:4157,5\n2213#1:4162,5\n2228#1:4167,5\n2236#1:4172,5\n2254#1:4177,5\n2264#1:4182,5\n2274#1:4187,5\n2285#1:4192,7\n2285#1:4199,5\n2285#1:4204\n2298#1:4205,7\n2298#1:4212,5\n2298#1:4217\n2311#1:4218,7\n2311#1:4225,5\n2311#1:4230\n2324#1:4231,7\n2324#1:4238,5\n2324#1:4243\n2348#1:4244,5\n2374#1:4249,5\n2431#1:4258,7\n2431#1:4265,5\n2431#1:4270\n2443#1:4271,7\n2443#1:4278,5\n2443#1:4283\n2455#1:4284,7\n2455#1:4291,5\n2455#1:4296\n2467#1:4297,7\n2467#1:4304,5\n2467#1:4309\n2479#1:4310,7\n2479#1:4317,5\n2479#1:4322\n2491#1:4323,7\n2491#1:4330,5\n2491#1:4335\n2503#1:4336,7\n2503#1:4343,5\n2503#1:4348\n2515#1:4349,7\n2515#1:4356,5\n2515#1:4361\n2527#1:4362,7\n2527#1:4369,5\n2527#1:4374\n2539#1:4375,7\n2539#1:4382,5\n2539#1:4387\n2559#1:4388,7\n2559#1:4395,5\n2559#1:4400\n2571#1:4401,7\n2571#1:4408,5\n2571#1:4413\n2583#1:4414,7\n2583#1:4421,5\n2583#1:4426\n2595#1:4427,7\n2595#1:4434,5\n2595#1:4439\n2607#1:4440,7\n2607#1:4447,5\n2607#1:4452\n2619#1:4453,7\n2619#1:4460,5\n2619#1:4465\n2631#1:4466,7\n2631#1:4473,5\n2631#1:4478\n2643#1:4479,7\n2643#1:4486,5\n2643#1:4491\n2655#1:4492,7\n2655#1:4499,5\n2655#1:4504\n2667#1:4505,7\n2667#1:4512,5\n2667#1:4517\n2679#1:4518,7\n2679#1:4525,5\n2679#1:4530\n2691#1:4531,7\n2691#1:4538,5\n2691#1:4543\n2703#1:4544,7\n2703#1:4551,5\n2703#1:4556\n2715#1:4557,7\n2715#1:4564,5\n2715#1:4569\n2727#1:4570,7\n2727#1:4577,5\n2727#1:4582\n2739#1:4583,7\n2739#1:4590,5\n2739#1:4595\n2751#1:4596,7\n2751#1:4603,5\n2751#1:4608\n2763#1:4609,7\n2763#1:4616,5\n2763#1:4621\n2821#1:4622,5\n2851#1:4627,5\n2872#1:4632,5\n2917#1:4637,5\n2928#1:4642,5\n2936#1:4647,5\n2976#1:4652,7\n2976#1:4659,5\n2976#1:4664\n3006#1:4672,7\n3006#1:4679,5\n3006#1:4684\n3041#1:4692,5\n3053#1:4697,5\n3063#1:4702,5\n3071#1:4707,5\n3103#1:4712,5\n3113#1:4717,5\n3123#1:4722,5\n3135#1:4727,5\n3145#1:4732,5\n3166#1:4737,5\n3176#1:4742,5\n3185#1:4747,5\n3195#1:4752,5\n3221#1:4757,5\n3235#1:4762,5\n3242#1:4767,5\n3278#1:4772,5\n3309#1:4777,7\n3309#1:4784,5\n3309#1:4789\n2405#1:4254\n2405#1:4255,3\n*E\n"})
@SuppressLint({"StaticFieldLeak"})
/* loaded from: classes13.dex */
public final class BleConnector extends AbsBleConnector {

    @OOXIXo
    private static final String BLE_CH_NOTIFY = "6e400003-b5a3-f393-e0a9-e50e24dcca9e";

    @OOXIXo
    private static final String BLE_CH_WRITE = "6e400002-b5a3-f393-e0a9-e50e24dcca9e";

    @OOXIXo
    private static final String BLE_SERVICE = "6e400001-b5a3-f393-e0a9-e50e24dcca9e";

    @OOXIXo
    private static final String CH_MTK_OTA_DATA = "c6a22924-f821-18bf-9704-0266f20e80fd";

    @OOXIXo
    private static final String CH_MTK_OTA_FLAG = "c6a22922-f821-18bf-9704-0266f20e80fd";

    @OOXIXo
    private static final String CH_MTK_OTA_MD5 = "c6a22926-f821-18bf-9704-0266f20e80fd";

    @OOXIXo
    public static final String CH_MTK_OTA_META = "c6a22916-f821-18bf-9704-0266f20e80fd";

    @OOXIXo
    private static final String CH_MTK_OTA_SIZE = "c6a22920-f821-18bf-9704-0266f20e80fd";
    private static final int MTK_OTA_PACKET_SIZE = 180;

    @OOXIXo
    public static final String SERVICE_MTK = "c6a22905-f821-18bf-9704-0266f20e80fd";

    @OOXIXo
    private static final String SERVICE_MTK_OTA = "c6a2b98b-f821-18bf-9704-0266f20e80fd";

    @OOXIXo
    private static final String TAG = "BleConnector";
    private static boolean isConnecting;
    private static boolean isNordicOtaMode;
    private static boolean isRefreshDeviceInfo;

    @oOoXoXO
    private static BleStream mBleStream;
    private static int mHidState;

    @OOXIXo
    public static final BleConnector INSTANCE = new BleConnector();
    private static boolean isDataKeyAutoDelete = true;

    @OOXIXo
    private static final X0IIOO mService$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<String>() { // from class: com.szabh.smable3.component.BleConnector$mService$2
        @Override // Oox.oIX0oI
        @OOXIXo
        public final String invoke() {
            return "6e400001-b5a3-f393-e0a9-e50e24dcca9e";
        }
    });

    @OOXIXo
    private static final X0IIOO mNotify$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<String>() { // from class: com.szabh.smable3.component.BleConnector$mNotify$2
        @Override // Oox.oIX0oI
        @OOXIXo
        public final String invoke() {
            return "6e400003-b5a3-f393-e0a9-e50e24dcca9e";
        }
    });

    @OOXIXo
    private static final X0IIOO mBleMessenger$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<BleMessenger>() { // from class: com.szabh.smable3.component.BleConnector$mBleMessenger$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OOXIXo
        public final BleMessenger invoke() {
            BleMessenger bleMessenger = new BleMessenger();
            bleMessenger.setMMessengerCallback(new BleMessengerCallback() { // from class: com.szabh.smable3.component.BleConnector$mBleMessenger$2$1$1
                @Override // com.szabh.smable3.component.BleMessengerCallback
                public void onRetry() {
                    BleConnector.INSTANCE.getMBleParser().reset();
                }

                @Override // com.szabh.smable3.component.BleMessengerCallback
                public void onTimeout(@OOXIXo xII.II0xO0 message) {
                    BleStream bleStream;
                    IIX0o.x0xO0oo(message, "message");
                    bleStream = BleConnector.mBleStream;
                    if (bleStream != null) {
                        BleConnector bleConnector = BleConnector.INSTANCE;
                        bleConnector.getMBleMessenger().reset();
                        bleConnector.setMBleStream(null);
                    }
                    if (message instanceof II0XooXoX) {
                        II0XooXoX iI0XooXoX = (II0XooXoX) message;
                        final BleKey oIX0oI2 = BleKey.Companion.oIX0oI(ByteArrayExtKt.getInt$default(iI0XooXoX.II0xO0(), 6, 2, null, 4, null));
                        final BleKeyFlag oIX0oI3 = BleKeyFlag.Companion.oIX0oI(iI0XooXoX.II0xO0()[8]);
                        OI0.oIX0oI.f1507oIX0oI.oIX0oI("BleConnector onCommandSendTimeout -> key=" + oIX0oI2 + ", keyFlag=" + oIX0oI3);
                        BleConnector.INSTANCE.notifyHandlers(new Oox.oOoXoXO<BleHandleCallback, oXIO0o0XI>() { // from class: com.szabh.smable3.component.BleConnector$mBleMessenger$2$1$1$onTimeout$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // Oox.oOoXoXO
                            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(BleHandleCallback bleHandleCallback) {
                                invoke2(bleHandleCallback);
                                return oXIO0o0XI.f29392oIX0oI;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@OOXIXo BleHandleCallback it) {
                                IIX0o.x0xO0oo(it, "it");
                                it.onCommandSendTimeout(BleKey.this, oIX0oI3);
                            }
                        });
                    }
                }
            });
            return bleMessenger;
        }
    });

    @OOXIXo
    private static final X0IIOO mBleParser$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<BleParser>() { // from class: com.szabh.smable3.component.BleConnector$mBleParser$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OOXIXo
        public final BleParser invoke() {
            return BleParser.INSTANCE;
        }
    });

    @OOXIXo
    private static final X0IIOO mBleHandleCallbacks$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<CopyOnWriteArrayList<BleHandleCallback>>() { // from class: com.szabh.smable3.component.BleConnector$mBleHandleCallbacks$2
        @Override // Oox.oIX0oI
        @OOXIXo
        public final CopyOnWriteArrayList<BleHandleCallback> invoke() {
            return new CopyOnWriteArrayList<>();
        }
    });
    private static int mBleState = -1;

    @OOXIXo
    private static List<BleKey> mDataKeys = new ArrayList();

    @OOXIXo
    private static final Runnable mSyncTimeout = new Runnable() { // from class: com.szabh.smable3.component.oIX0oI
        @Override // java.lang.Runnable
        public final void run() {
            BleConnector.mSyncTimeout$lambda$0();
        }
    };

    @OOXIXo
    private static final Map<MusicEntity, List<MusicAttr>> mMusicSubscriptions = new EnumMap(MusicEntity.class);
    private static int mStreamProgressTotal = -1;
    private static int mStreamProgressCompleted = -1;
    private static boolean mSupportFilterEmpty = true;
    private static boolean isNeedBind = true;

    /* loaded from: classes13.dex */
    public static final class Builder {

        @OOXIXo
        private final Context context;
        private int mtu;
        private boolean supportFilterEmpty;
        private boolean supportLauncher;
        private boolean supportMtkOta;
        private boolean supportNordicOta;
        private boolean supportRealtekDfu;

        public Builder(@OOXIXo Context context) {
            IIX0o.x0xO0oo(context, "context");
            this.context = context;
            this.supportLauncher = true;
            this.supportFilterEmpty = true;
            this.mtu = xII.I0Io.oIX0oI();
        }

        @OOXIXo
        public final BleConnector build() {
            return BleConnector.INSTANCE.init(this.context, this.supportNordicOta, this.supportRealtekDfu, this.supportMtkOta, this.supportLauncher, this.supportFilterEmpty, this.mtu);
        }

        @OOXIXo
        public final Builder setMtu(int i) {
            this.mtu = i;
            return this;
        }

        @OOXIXo
        public final Builder supportFilterEmpty(boolean z) {
            this.supportFilterEmpty = z;
            return this;
        }

        @OOXIXo
        public final Builder supportLauncher(boolean z) {
            this.supportLauncher = z;
            return this;
        }

        @OOXIXo
        public final Builder supportMtkOta(boolean z) {
            this.supportMtkOta = z;
            return this;
        }

        @OOXIXo
        public final Builder supportNordicOta(boolean z) {
            this.supportNordicOta = z;
            return this;
        }

        @OOXIXo
        public final Builder supportRealtekDfu(boolean z) {
            this.supportRealtekDfu = z;
            return this;
        }
    }

    /* loaded from: classes13.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BleKey.values().length];
            try {
                iArr[BleKey.FIRMWARE_VERSION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BleKey.UI_PACK_VERSION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BleKey.GPS_FIRMWARE_VERSION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[BleKey.NETWORK_FIRMWARE_VERSION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[BleKey.IPC_VERSION.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[BleKey.OTA.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[BleKey.XMODEM.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[BleKey.TIME.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[BleKey.POWER.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[BleKey.LANGUAGE_PACK_VERSION.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[BleKey.BLE_ADDRESS.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[BleKey.USER_PROFILE.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[BleKey.STEP_GOAL.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[BleKey.SEDENTARINESS.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[BleKey.NO_DISTURB_RANGE.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[BleKey.ALARM.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[BleKey.UNIT_SET.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[BleKey.COACHING.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[BleKey.FIND_PHONE.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[BleKey.HR_MONITORING.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr[BleKey.SLEEP_QUALITY.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr[BleKey.REALTIME_LOG.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr[BleKey.AGPS_PREREQUISITE.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr[BleKey.GSENSOR_RAW.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr[BleKey.GSENSOR_SHSY.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr[BleKey.PPG_SHSY.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr[BleKey.HR_RAW.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                iArr[BleKey.MOTION_DETECT.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                iArr[BleKey.LOCATION_GGA.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                iArr[BleKey.LOCATION_GSV.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                iArr[BleKey.LANGUAGE.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                iArr[BleKey.TEMPERATURE_UNIT.ordinal()] = 32;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                iArr[BleKey.DATE_FORMAT.ordinal()] = 33;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                iArr[BleKey.WATCH_FACE_SWITCH.ordinal()] = 34;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                iArr[BleKey.DRINK_WATER.ordinal()] = 35;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                iArr[BleKey.VIBRATION.ordinal()] = 36;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                iArr[BleKey.BACK_LIGHT.ordinal()] = 37;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                iArr[BleKey.GESTURE_WAKE.ordinal()] = 38;
            } catch (NoSuchFieldError unused38) {
            }
            try {
                iArr[BleKey.HOUR_SYSTEM.ordinal()] = 39;
            } catch (NoSuchFieldError unused39) {
            }
            try {
                iArr[BleKey.APP_SPORT_DATA.ordinal()] = 40;
            } catch (NoSuchFieldError unused40) {
            }
            try {
                iArr[BleKey.REAL_TIME_HEART_RATE.ordinal()] = 41;
            } catch (NoSuchFieldError unused41) {
            }
            try {
                iArr[BleKey.WATCHFACE_ID.ordinal()] = 42;
            } catch (NoSuchFieldError unused42) {
            }
            try {
                iArr[BleKey.REAL_TIME_TEMPERATURE.ordinal()] = 43;
            } catch (NoSuchFieldError unused43) {
            }
            try {
                iArr[BleKey.REAL_TIME_BLOOD_PRESSURE.ordinal()] = 44;
            } catch (NoSuchFieldError unused44) {
            }
            try {
                iArr[BleKey.SET_WATCH_PASSWORD.ordinal()] = 45;
            } catch (NoSuchFieldError unused45) {
            }
            try {
                iArr[BleKey.REALTIME_MEASUREMENT.ordinal()] = 46;
            } catch (NoSuchFieldError unused46) {
            }
            try {
                iArr[BleKey.POWER_SAVE_MODE.ordinal()] = 47;
            } catch (NoSuchFieldError unused47) {
            }
            try {
                iArr[BleKey.CALORIES_GOAL.ordinal()] = 48;
            } catch (NoSuchFieldError unused48) {
            }
            try {
                iArr[BleKey.DISTANCE_GOAL.ordinal()] = 49;
            } catch (NoSuchFieldError unused49) {
            }
            try {
                iArr[BleKey.SLEEP_GOAL.ordinal()] = 50;
            } catch (NoSuchFieldError unused50) {
            }
            try {
                iArr[BleKey.LOVE_TAP_USER.ordinal()] = 51;
            } catch (NoSuchFieldError unused51) {
            }
            try {
                iArr[BleKey.MEDICATION_REMINDER.ordinal()] = 52;
            } catch (NoSuchFieldError unused52) {
            }
            try {
                iArr[BleKey.DEVICE_INFO.ordinal()] = 53;
            } catch (NoSuchFieldError unused53) {
            }
            try {
                iArr[BleKey.TUYA_KEY_SET.ordinal()] = 54;
            } catch (NoSuchFieldError unused54) {
            }
            try {
                iArr[BleKey.BAC_RESULT.ordinal()] = 55;
            } catch (NoSuchFieldError unused55) {
            }
            try {
                iArr[BleKey.MEDICATION_ALARM.ordinal()] = 56;
            } catch (NoSuchFieldError unused56) {
            }
            try {
                iArr[BleKey.PACKAGE_STATUS.ordinal()] = 57;
            } catch (NoSuchFieldError unused57) {
            }
            try {
                iArr[BleKey.NOTIFICATION_REMINDER2.ordinal()] = 58;
            } catch (NoSuchFieldError unused58) {
            }
            try {
                iArr[BleKey.ALIPAY_SET.ordinal()] = 59;
            } catch (NoSuchFieldError unused59) {
            }
            try {
                iArr[BleKey.RECORD_PACKET.ordinal()] = 60;
            } catch (NoSuchFieldError unused60) {
            }
            try {
                iArr[BleKey.NAVI_INFO.ordinal()] = 61;
            } catch (NoSuchFieldError unused61) {
            }
            try {
                iArr[BleKey.SOS_SET.ordinal()] = 62;
            } catch (NoSuchFieldError unused62) {
            }
            try {
                iArr[BleKey.GIRL_CARE.ordinal()] = 63;
            } catch (NoSuchFieldError unused63) {
            }
            try {
                iArr[BleKey.DEVICE_LANGUAGES.ordinal()] = 64;
            } catch (NoSuchFieldError unused64) {
            }
            try {
                iArr[BleKey.DEVICE_SPORT_DATA.ordinal()] = 65;
            } catch (NoSuchFieldError unused65) {
            }
            try {
                iArr[BleKey.PRESSURE_TIMING_MEASUREMENT.ordinal()] = 66;
            } catch (NoSuchFieldError unused66) {
            }
            try {
                iArr[BleKey.BLOOD_OXYGEN_SET.ordinal()] = 67;
            } catch (NoSuchFieldError unused67) {
            }
            try {
                iArr[BleKey.STANDBY_WATCH_FACE_SET.ordinal()] = 68;
            } catch (NoSuchFieldError unused68) {
            }
            try {
                iArr[BleKey.FALL_SET.ordinal()] = 69;
            } catch (NoSuchFieldError unused69) {
            }
            try {
                iArr[BleKey.BW_NAVI_INFO.ordinal()] = 70;
            } catch (NoSuchFieldError unused70) {
            }
            try {
                iArr[BleKey.SDCARD_INFO.ordinal()] = 71;
            } catch (NoSuchFieldError unused71) {
            }
            try {
                iArr[BleKey.ACTIVITY_DETAIL.ordinal()] = 72;
            } catch (NoSuchFieldError unused72) {
            }
            try {
                iArr[BleKey.NOTIFICATION_LIGHT_SCREEN_SET.ordinal()] = 73;
            } catch (NoSuchFieldError unused73) {
            }
            try {
                iArr[BleKey.BLOOD_PRESSURE_CALIBRATION.ordinal()] = 74;
            } catch (NoSuchFieldError unused74) {
            }
            try {
                iArr[BleKey.EARPHONE_POWER.ordinal()] = 75;
            } catch (NoSuchFieldError unused75) {
            }
            try {
                iArr[BleKey.EARPHONE_ANC_SET.ordinal()] = 76;
            } catch (NoSuchFieldError unused76) {
            }
            try {
                iArr[BleKey.EARPHONE_SOUND_EFFECTS_SET.ordinal()] = 77;
            } catch (NoSuchFieldError unused77) {
            }
            try {
                iArr[BleKey.SCREEN_BRIGHTNESS_SET.ordinal()] = 78;
            } catch (NoSuchFieldError unused78) {
            }
            try {
                iArr[BleKey.EARPHONE_INFO.ordinal()] = 79;
            } catch (NoSuchFieldError unused79) {
            }
            try {
                iArr[BleKey.EARPHONE_STATE.ordinal()] = 80;
            } catch (NoSuchFieldError unused80) {
            }
            try {
                iArr[BleKey.EARPHONE_CALL.ordinal()] = 81;
            } catch (NoSuchFieldError unused81) {
            }
            try {
                iArr[BleKey.GOMORE_SET.ordinal()] = 82;
            } catch (NoSuchFieldError unused82) {
            }
            try {
                iArr[BleKey.RING_VIBRATION_SET.ordinal()] = 83;
            } catch (NoSuchFieldError unused83) {
            }
            try {
                iArr[BleKey.ECG_SET.ordinal()] = 84;
            } catch (NoSuchFieldError unused84) {
            }
            try {
                iArr[BleKey.SPORT_DURATION_GOAL.ordinal()] = 85;
            } catch (NoSuchFieldError unused85) {
            }
            try {
                iArr[BleKey.FIND_WATCH.ordinal()] = 86;
            } catch (NoSuchFieldError unused86) {
            }
            try {
                iArr[BleKey.WATCHFACE_INDEX.ordinal()] = 87;
            } catch (NoSuchFieldError unused87) {
            }
            try {
                iArr[BleKey.SOS_CONTACT.ordinal()] = 88;
            } catch (NoSuchFieldError unused88) {
            }
            try {
                iArr[BleKey.GIRL_CARE_MONTHLY.ordinal()] = 89;
            } catch (NoSuchFieldError unused89) {
            }
            try {
                iArr[BleKey.CHECK_IN_EVERY_DAY.ordinal()] = 90;
            } catch (NoSuchFieldError unused90) {
            }
            try {
                iArr[BleKey.GESTURE_WAKE2.ordinal()] = 91;
            } catch (NoSuchFieldError unused91) {
            }
            try {
                iArr[BleKey.EARPHONE_KEY.ordinal()] = 92;
            } catch (NoSuchFieldError unused92) {
            }
            try {
                iArr[BleKey.HANBAO_SET.ordinal()] = 93;
            } catch (NoSuchFieldError unused93) {
            }
            try {
                iArr[BleKey.QIBLA_SET.ordinal()] = 94;
            } catch (NoSuchFieldError unused94) {
            }
            try {
                iArr[BleKey.FIND_EARPHONE.ordinal()] = 95;
            } catch (NoSuchFieldError unused95) {
            }
            try {
                iArr[BleKey.CALIBRATION_DATA.ordinal()] = 96;
            } catch (NoSuchFieldError unused96) {
            }
            try {
                iArr[BleKey.BATTERY_USAGE.ordinal()] = 97;
            } catch (NoSuchFieldError unused97) {
            }
            try {
                iArr[BleKey.DEVICE_UNIQUE_DATA_SET.ordinal()] = 98;
            } catch (NoSuchFieldError unused98) {
            }
            try {
                iArr[BleKey.IPC_STORES_INFO.ordinal()] = 99;
            } catch (NoSuchFieldError unused99) {
            }
            try {
                iArr[BleKey.SLEEP_QUALITY_SCORE.ordinal()] = 100;
            } catch (NoSuchFieldError unused100) {
            }
            try {
                iArr[BleKey.RELAX_REMINDER.ordinal()] = 101;
            } catch (NoSuchFieldError unused101) {
            }
            try {
                iArr[BleKey.CP_USER_INFO.ordinal()] = 102;
            } catch (NoSuchFieldError unused102) {
            }
            try {
                iArr[BleKey.POWER2.ordinal()] = 103;
            } catch (NoSuchFieldError unused103) {
            }
            try {
                iArr[BleKey.TRAINING_STATUS.ordinal()] = 104;
            } catch (NoSuchFieldError unused104) {
            }
            try {
                iArr[BleKey.VITALITY.ordinal()] = 105;
            } catch (NoSuchFieldError unused105) {
            }
            try {
                iArr[BleKey.HRV2.ordinal()] = 106;
            } catch (NoSuchFieldError unused106) {
            }
            try {
                iArr[BleKey.RESPIRATORY_RATE.ordinal()] = 107;
            } catch (NoSuchFieldError unused107) {
            }
            try {
                iArr[BleKey.IDENTITY.ordinal()] = 108;
            } catch (NoSuchFieldError unused108) {
            }
            try {
                iArr[BleKey.SESSION.ordinal()] = 109;
            } catch (NoSuchFieldError unused109) {
            }
            try {
                iArr[BleKey.MUSIC_CONTROL.ordinal()] = 110;
            } catch (NoSuchFieldError unused110) {
            }
            try {
                iArr[BleKey.SCHEDULE.ordinal()] = 111;
            } catch (NoSuchFieldError unused111) {
            }
            try {
                iArr[BleKey.ACTIVITY.ordinal()] = 112;
            } catch (NoSuchFieldError unused112) {
            }
            try {
                iArr[BleKey.HEART_RATE.ordinal()] = 113;
            } catch (NoSuchFieldError unused113) {
            }
            try {
                iArr[BleKey.BLOOD_PRESSURE.ordinal()] = 114;
            } catch (NoSuchFieldError unused114) {
            }
            try {
                iArr[BleKey.SLEEP.ordinal()] = 115;
            } catch (NoSuchFieldError unused115) {
            }
            try {
                iArr[BleKey.WORKOUT.ordinal()] = 116;
            } catch (NoSuchFieldError unused116) {
            }
            try {
                iArr[BleKey.LOCATION.ordinal()] = 117;
            } catch (NoSuchFieldError unused117) {
            }
            try {
                iArr[BleKey.TEMPERATURE.ordinal()] = 118;
            } catch (NoSuchFieldError unused118) {
            }
            try {
                iArr[BleKey.BLOOD_OXYGEN.ordinal()] = 119;
            } catch (NoSuchFieldError unused119) {
            }
            try {
                iArr[BleKey.HRV.ordinal()] = 120;
            } catch (NoSuchFieldError unused120) {
            }
            try {
                iArr[BleKey.LOG.ordinal()] = 121;
            } catch (NoSuchFieldError unused121) {
            }
            try {
                iArr[BleKey.SLEEP_RAW_DATA.ordinal()] = 122;
            } catch (NoSuchFieldError unused122) {
            }
            try {
                iArr[BleKey.RAW_SLEEP.ordinal()] = 123;
            } catch (NoSuchFieldError unused123) {
            }
            try {
                iArr[BleKey.PRESSURE.ordinal()] = 124;
            } catch (NoSuchFieldError unused124) {
            }
            try {
                iArr[BleKey.WORKOUT2.ordinal()] = 125;
            } catch (NoSuchFieldError unused125) {
            }
            try {
                iArr[BleKey.MATCH_RECORD.ordinal()] = 126;
            } catch (NoSuchFieldError unused126) {
            }
            try {
                iArr[BleKey.BLOOD_GLUCOSE.ordinal()] = 127;
            } catch (NoSuchFieldError unused127) {
            }
            try {
                iArr[BleKey.BODY_STATUS.ordinal()] = 128;
            } catch (NoSuchFieldError unused128) {
            }
            try {
                iArr[BleKey.MIND_STATUS.ordinal()] = 129;
            } catch (NoSuchFieldError unused129) {
            }
            try {
                iArr[BleKey.CALORIE_INTAKE.ordinal()] = 130;
            } catch (NoSuchFieldError unused130) {
            }
            try {
                iArr[BleKey.FOOD_BALANCE.ordinal()] = 131;
            } catch (NoSuchFieldError unused131) {
            }
            try {
                iArr[BleKey.BAC.ordinal()] = 132;
            } catch (NoSuchFieldError unused132) {
            }
            try {
                iArr[BleKey.MATCH_RECORD2.ordinal()] = 133;
            } catch (NoSuchFieldError unused133) {
            }
            try {
                iArr[BleKey.AVG_HEART_RATE.ordinal()] = 134;
            } catch (NoSuchFieldError unused134) {
            }
            try {
                iArr[BleKey.ALIPAY_BIND_INFO.ordinal()] = 135;
            } catch (NoSuchFieldError unused135) {
            }
            try {
                iArr[BleKey.RRI.ordinal()] = 136;
            } catch (NoSuchFieldError unused136) {
            }
            try {
                iArr[BleKey.ECG.ordinal()] = 137;
            } catch (NoSuchFieldError unused137) {
            }
            try {
                iArr[BleKey.HANBAO_VIBRATION.ordinal()] = 138;
            } catch (NoSuchFieldError unused138) {
            }
            try {
                iArr[BleKey.SOS_CALL_LOG.ordinal()] = 139;
            } catch (NoSuchFieldError unused139) {
            }
            try {
                iArr[BleKey.WORKOUT3.ordinal()] = 140;
            } catch (NoSuchFieldError unused140) {
            }
            try {
                iArr[BleKey.DAILY_POWER.ordinal()] = 141;
            } catch (NoSuchFieldError unused141) {
            }
            try {
                iArr[BleKey.CAMERA.ordinal()] = 142;
            } catch (NoSuchFieldError unused142) {
            }
            try {
                iArr[BleKey.REQUEST_LOCATION.ordinal()] = 143;
            } catch (NoSuchFieldError unused143) {
            }
            try {
                iArr[BleKey.INCOMING_CALL.ordinal()] = 144;
            } catch (NoSuchFieldError unused144) {
            }
            try {
                iArr[BleKey.APP_SPORT_STATE.ordinal()] = 145;
            } catch (NoSuchFieldError unused145) {
            }
            try {
                iArr[BleKey.CLASSIC_BLUETOOTH_STATE.ordinal()] = 146;
            } catch (NoSuchFieldError unused146) {
            }
            try {
                iArr[BleKey.FACTORY_TEST.ordinal()] = 147;
            } catch (NoSuchFieldError unused147) {
            }
            try {
                iArr[BleKey.WATCH_FACE.ordinal()] = 148;
            } catch (NoSuchFieldError unused148) {
            }
            try {
                iArr[BleKey.AGPS_FILE.ordinal()] = 149;
            } catch (NoSuchFieldError unused149) {
            }
            try {
                iArr[BleKey.FONT_FILE.ordinal()] = 150;
            } catch (NoSuchFieldError unused150) {
            }
            try {
                iArr[BleKey.CONTACT.ordinal()] = 151;
            } catch (NoSuchFieldError unused151) {
            }
            try {
                iArr[BleKey.UI_FILE.ordinal()] = 152;
            } catch (NoSuchFieldError unused152) {
            }
            try {
                iArr[BleKey.LANGUAGE_FILE.ordinal()] = 153;
            } catch (NoSuchFieldError unused153) {
            }
            try {
                iArr[BleKey.BRAND_INFO_FILE.ordinal()] = 154;
            } catch (NoSuchFieldError unused154) {
            }
            try {
                iArr[BleKey.QRCODE.ordinal()] = 155;
            } catch (NoSuchFieldError unused155) {
            }
            try {
                iArr[BleKey.THIRD_PARTY_DATA.ordinal()] = 156;
            } catch (NoSuchFieldError unused156) {
            }
            try {
                iArr[BleKey.QRCODE2.ordinal()] = 157;
            } catch (NoSuchFieldError unused157) {
            }
            try {
                iArr[BleKey.LOGO_FILE.ordinal()] = 158;
            } catch (NoSuchFieldError unused158) {
            }
            try {
                iArr[BleKey.OTA_FILE.ordinal()] = 159;
            } catch (NoSuchFieldError unused159) {
            }
            try {
                iArr[BleKey.GPS_FIRMWARE_FILE.ordinal()] = 160;
            } catch (NoSuchFieldError unused160) {
            }
            try {
                iArr[BleKey.CONTACT_SORT.ordinal()] = 161;
            } catch (NoSuchFieldError unused161) {
            }
            try {
                iArr[BleKey.NAVI_IMAGE.ordinal()] = 162;
            } catch (NoSuchFieldError unused162) {
            }
            try {
                iArr[BleKey.APP_FILE.ordinal()] = 163;
            } catch (NoSuchFieldError unused163) {
            }
            try {
                iArr[BleKey.FAT_BIN_FILE.ordinal()] = 164;
            } catch (NoSuchFieldError unused164) {
            }
            try {
                iArr[BleKey.AGPS_FILE2.ordinal()] = 165;
            } catch (NoSuchFieldError unused165) {
            }
            try {
                iArr[BleKey.DEVICE_FILE.ordinal()] = 166;
            } catch (NoSuchFieldError unused166) {
            }
            try {
                iArr[BleKey.WEATHER_REALTIME.ordinal()] = 167;
            } catch (NoSuchFieldError unused167) {
            }
            try {
                iArr[BleKey.HID.ordinal()] = 168;
            } catch (NoSuchFieldError unused168) {
            }
            try {
                iArr[BleKey.WORLD_CLOCK.ordinal()] = 169;
            } catch (NoSuchFieldError unused169) {
            }
            try {
                iArr[BleKey.STOCK.ordinal()] = 170;
            } catch (NoSuchFieldError unused170) {
            }
            try {
                iArr[BleKey.DEVICE_SMS_QUICK_REPLY.ordinal()] = 171;
            } catch (NoSuchFieldError unused171) {
            }
            try {
                iArr[BleKey.LOVE_TAP.ordinal()] = 172;
            } catch (NoSuchFieldError unused172) {
            }
            try {
                iArr[BleKey.BAC_CALIBRATION.ordinal()] = 173;
            } catch (NoSuchFieldError unused173) {
            }
            try {
                iArr[BleKey.INCOMING_CALL_RING.ordinal()] = 174;
            } catch (NoSuchFieldError unused174) {
            }
            try {
                iArr[BleKey.SPORT_END_NOTIFY.ordinal()] = 175;
            } catch (NoSuchFieldError unused175) {
            }
            try {
                iArr[BleKey.DOUBLE_SCREEN.ordinal()] = 176;
            } catch (NoSuchFieldError unused176) {
            }
            try {
                iArr[BleKey.FILE_PATH.ordinal()] = 177;
            } catch (NoSuchFieldError unused177) {
            }
            try {
                iArr[BleKey.APP_OP.ordinal()] = 178;
            } catch (NoSuchFieldError unused178) {
            }
            try {
                iArr[BleKey.HANBAO_VIBRATION_STATE.ordinal()] = 179;
            } catch (NoSuchFieldError unused179) {
            }
            try {
                iArr[BleKey.MEASUREMENT.ordinal()] = 180;
            } catch (NoSuchFieldError unused180) {
            }
            try {
                iArr[BleKey.GAME_CONTROL.ordinal()] = 181;
            } catch (NoSuchFieldError unused181) {
            }
            try {
                iArr[BleKey.APP_API_VERSION.ordinal()] = 182;
            } catch (NoSuchFieldError unused182) {
            }
            try {
                iArr[BleKey.RECEIVE_DEVICE_FILE.ordinal()] = 183;
            } catch (NoSuchFieldError unused183) {
            }
            try {
                iArr[BleKey.IPC_WIFI_STATE.ordinal()] = 184;
            } catch (NoSuchFieldError unused184) {
            }
            try {
                iArr[BleKey.IPC_WIFI_INFO.ordinal()] = 185;
            } catch (NoSuchFieldError unused185) {
            }
            try {
                iArr[BleKey.AI_COACH_PLAN.ordinal()] = 186;
            } catch (NoSuchFieldError unused186) {
            }
            try {
                iArr[BleKey.WEAR_STATE.ordinal()] = 187;
            } catch (NoSuchFieldError unused187) {
            }
            try {
                iArr[BleKey.SG_TEST.ordinal()] = 188;
            } catch (NoSuchFieldError unused188) {
            }
            try {
                iArr[BleKey.SG_KEYWORD_AWAKE.ordinal()] = 189;
            } catch (NoSuchFieldError unused189) {
            }
            try {
                iArr[BleKey.SG_SLEEP_SET.ordinal()] = 190;
            } catch (NoSuchFieldError unused190) {
            }
            try {
                iArr[BleKey.LACTATE_THRESHOLD.ordinal()] = 191;
            } catch (NoSuchFieldError unused191) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private BleConnector() {
    }

    public final void bind() {
        sendInt32$default(this, BleKey.IDENTITY, BleKeyFlag.CREATE, Random.Default.nextInt(), null, false, false, 56, null);
    }

    public final void checkStreamProgress() {
        int i;
        if (isAvailable()) {
            if (mStreamProgressTotal > 0 && mStreamProgressCompleted > 0) {
                OI0.oIX0oI.f1507oIX0oI.XO("BleConnector onStreamProgress -> mStreamProgressTotal=" + mStreamProgressTotal + ", mStreamProgressCompleted=" + mStreamProgressCompleted);
                notifyHandlersThen(new Oox.oOoXoXO<BleHandleCallback, oXIO0o0XI>() { // from class: com.szabh.smable3.component.BleConnector$checkStreamProgress$1
                    @Override // Oox.oOoXoXO
                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(BleHandleCallback bleHandleCallback) {
                        invoke2(bleHandleCallback);
                        return oXIO0o0XI.f29392oIX0oI;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@OOXIXo BleHandleCallback it) {
                        int i2;
                        int i3;
                        IIX0o.x0xO0oo(it, "it");
                        i2 = BleConnector.mStreamProgressTotal;
                        i3 = BleConnector.mStreamProgressCompleted;
                        BleHandleCallback.DefaultImpls.onStreamProgress$default(it, true, 0, i2, i3, null, 16, null);
                    }
                }, new Oox.oIX0oI<oXIO0o0XI>() { // from class: com.szabh.smable3.component.BleConnector$checkStreamProgress$2
                    @Override // Oox.oIX0oI
                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke() {
                        invoke2();
                        return oXIO0o0XI.f29392oIX0oI;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        int i2;
                        int i3;
                        i2 = BleConnector.mStreamProgressTotal;
                        i3 = BleConnector.mStreamProgressCompleted;
                        if (i2 == i3) {
                            BleConnector bleConnector = BleConnector.INSTANCE;
                            BleConnector.mStreamProgressTotal = -1;
                            BleConnector.mStreamProgressCompleted = -1;
                        }
                    }
                });
                return;
            }
            return;
        }
        int i2 = mStreamProgressTotal;
        if (i2 > 0 && (i = mStreamProgressCompleted) >= 0 && i < i2) {
            notifyHandlersThen(new Oox.oOoXoXO<BleHandleCallback, oXIO0o0XI>() { // from class: com.szabh.smable3.component.BleConnector$checkStreamProgress$3
                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(BleHandleCallback bleHandleCallback) {
                    invoke2(bleHandleCallback);
                    return oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OOXIXo BleHandleCallback it) {
                    int i3;
                    int i4;
                    IIX0o.x0xO0oo(it, "it");
                    i3 = BleConnector.mStreamProgressTotal;
                    i4 = BleConnector.mStreamProgressCompleted;
                    BleHandleCallback.DefaultImpls.onStreamProgress$default(it, false, -1, i3, i4, null, 16, null);
                }
            }, new Oox.oIX0oI<oXIO0o0XI>() { // from class: com.szabh.smable3.component.BleConnector$checkStreamProgress$4
                @Override // Oox.oIX0oI
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke() {
                    invoke2();
                    return oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    int i3;
                    int i4;
                    i3 = BleConnector.mStreamProgressTotal;
                    i4 = BleConnector.mStreamProgressCompleted;
                    if (i3 == i4) {
                        BleConnector bleConnector = BleConnector.INSTANCE;
                        BleConnector.mStreamProgressTotal = -1;
                        BleConnector.mStreamProgressCompleted = -1;
                    }
                }
            });
        }
    }

    private final Boolean createBond(String str) {
        if (!BluetoothAdapter.checkBluetoothAddress(str)) {
            return Boolean.FALSE;
        }
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        Boolean bool = null;
        BluetoothDevice remoteDevice = defaultAdapter != null ? defaultAdapter.getRemoteDevice(str) : null;
        if (remoteDevice != null) {
            try {
                bool = Boolean.valueOf(remoteDevice.createBond());
            } catch (Exception e) {
                OI0.oIX0oI.f1507oIX0oI.Oxx0IOOO("BleConnector createBond error -> " + e.getLocalizedMessage());
                return Boolean.FALSE;
            }
        }
        return bool;
    }

    private final CopyOnWriteArrayList<BleHandleCallback> getMBleHandleCallbacks() {
        return (CopyOnWriteArrayList) mBleHandleCallbacks$delegate.getValue();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:12:0x0082. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:21:0x6030 A[Catch: Exception -> 0x0014, TryCatch #0 {Exception -> 0x0014, blocks: (B:3:0x0004, B:5:0x000c, B:6:0x0018, B:10:0x001f, B:15:0x0099, B:16:0x00a4, B:21:0x6030, B:23:0x6038, B:25:0x603c, B:27:0x6040, B:29:0x6047, B:30:0x6059, B:32:0x605d, B:37:0x6067, B:39:0x6071, B:40:0x6076, B:42:0x607e, B:44:0x6086, B:46:0x609f, B:48:0x60a9, B:50:0x60c2, B:54:0x60d3, B:56:0x60d9, B:63:0x00bd, B:65:0x00c1, B:69:0x00cf, B:71:0x00fb, B:72:0x0133, B:77:0x014e, B:79:0x0152, B:82:0x0156, B:83:0x0186, B:86:0x0194, B:88:0x0198, B:91:0x019c, B:92:0x01cc, B:95:0x01dd, B:97:0x01e1, B:98:0x0253, B:104:0x0278, B:106:0x027e, B:109:0x0282, B:111:0x02f0, B:113:0x02ae, B:115:0x02b2, B:118:0x02cb, B:122:0x030d, B:124:0x0313, B:129:0x0398, B:131:0x03e0, B:134:0x031c, B:135:0x035a, B:138:0x03a3, B:140:0x03a7, B:143:0x03be, B:147:0x03f9, B:149:0x03fd, B:150:0x0459, B:155:0x046c, B:157:0x0470, B:160:0x0474, B:162:0x04e2, B:164:0x04a1, B:166:0x04a5, B:169:0x04ba, B:172:0x04fd, B:174:0x0503, B:175:0x0543, B:179:0x0558, B:181:0x055c, B:182:0x05aa, B:185:0x05bf, B:187:0x05c3, B:188:0x0600, B:191:0x0615, B:193:0x0619, B:196:0x0630, B:197:0x0670, B:201:0x0688, B:203:0x068e, B:204:0x06d8, B:209:0x06ed, B:211:0x06f1, B:213:0x072e, B:214:0x073b, B:216:0x079e, B:218:0x074c, B:220:0x0750, B:223:0x07b9, B:225:0x07bf, B:227:0x081c, B:229:0x080e, B:231:0x0812, B:235:0x083d, B:237:0x0841, B:239:0x0878, B:240:0x088e, B:242:0x08f9, B:244:0x0897, B:246:0x089b, B:249:0x0911, B:251:0x0917, B:252:0x0961, B:257:0x0970, B:259:0x0974, B:260:0x09f7, B:262:0x09ac, B:264:0x09b0, B:267:0x0a0c, B:269:0x0a10, B:270:0x0ab1, B:272:0x0a5d, B:274:0x0a61, B:277:0x0ac8, B:280:0x0acc, B:281:0x0b1d, B:285:0x0b32, B:288:0x0b36, B:289:0x0b82, B:292:0x0b97, B:294:0x0b9d, B:298:0x0bae, B:300:0x0bdb, B:303:0x0cc5, B:304:0x0c11, B:306:0x0c18, B:309:0x0c1c, B:311:0x0c54, B:312:0x0c79, B:313:0x0c58, B:314:0x0c5d, B:316:0x0c63, B:322:0x0c76, B:318:0x0c70, B:325:0x0ca5, B:327:0x0caa, B:330:0x0cde, B:332:0x0ce2, B:336:0x0cf3, B:338:0x0d1e, B:340:0x0ddd, B:341:0x0d50, B:343:0x0d54, B:346:0x0d58, B:348:0x0d8e, B:349:0x0db3, B:350:0x0d92, B:351:0x0d97, B:353:0x0d9d, B:359:0x0db0, B:355:0x0daa, B:362:0x0de2, B:365:0x0df5, B:366:0x0e09, B:369:0x0e0d, B:371:0x0e7e, B:375:0x0e3e, B:377:0x0e44, B:380:0x0e56, B:383:0x0e8c, B:385:0x0e90, B:386:0x0ea8, B:389:0x0ebd, B:391:0x0ec1, B:393:0x0ec5, B:395:0x0f73, B:397:0x0f14, B:399:0x0f18, B:402:0x0f90, B:404:0x0f96, B:407:0x0f9a, B:409:0x0fd1, B:411:0x0fdb, B:412:0x1015, B:414:0x0fe2, B:416:0x0fe6, B:418:0x0ff6, B:419:0x100f, B:420:0x1024, B:422:0x102a, B:425:0x1031, B:428:0x1122, B:431:0x106f, B:433:0x107b, B:435:0x107f, B:436:0x10b7, B:438:0x10bd, B:440:0x10c1, B:441:0x1132, B:444:0x1148, B:445:0x115c, B:448:0x1160, B:451:0x11aa, B:455:0x11c8, B:457:0x11cc, B:460:0x11d0, B:462:0x1240, B:464:0x11fd, B:466:0x1201, B:469:0x1218, B:472:0x125c, B:475:0x1260, B:476:0x12b1, B:482:0x12d3, B:485:0x12d7, B:486:0x1308, B:489:0x131b, B:492:0x131f, B:493:0x1356, B:496:0x136a, B:499:0x136e, B:502:0x1375, B:503:0x13dd, B:505:0x13a2, B:508:0x13a6, B:509:0x13e1, B:512:0x13f6, B:516:0x1406, B:518:0x1433, B:520:0x1452, B:522:0x1462, B:523:0x1467, B:525:0x1458, B:527:0x1479, B:530:0x148f, B:534:0x14a0, B:536:0x14cc, B:538:0x14ea, B:540:0x14fa, B:541:0x14fe, B:542:0x14f0, B:544:0x1502, B:547:0x1518, B:551:0x1529, B:553:0x1555, B:555:0x1573, B:557:0x1583, B:558:0x1587, B:559:0x1579, B:561:0x158b, B:564:0x15a1, B:568:0x15b0, B:570:0x15dc, B:572:0x15fa, B:574:0x160a, B:575:0x160e, B:576:0x1600, B:578:0x1612, B:581:0x1628, B:585:0x1638, B:587:0x1664, B:589:0x1682, B:591:0x1692, B:592:0x1696, B:593:0x1688, B:595:0x169a, B:598:0x16b0, B:602:0x16bf, B:604:0x16eb, B:606:0x1709, B:608:0x1719, B:609:0x171d, B:610:0x170f, B:612:0x1721, B:615:0x1737, B:619:0x1746, B:621:0x1772, B:623:0x1790, B:625:0x17a0, B:626:0x17a4, B:627:0x1796, B:629:0x17a8, B:632:0x17be, B:636:0x17cd, B:638:0x17f9, B:640:0x1817, B:642:0x1827, B:643:0x182b, B:644:0x181d, B:646:0x182f, B:649:0x1845, B:653:0x1856, B:655:0x1882, B:657:0x18a0, B:659:0x18b0, B:660:0x18b4, B:661:0x18a6, B:663:0x18b8, B:666:0x18ce, B:670:0x18de, B:672:0x190a, B:674:0x1928, B:676:0x1938, B:677:0x193c, B:678:0x192e, B:680:0x1940, B:683:0x1956, B:687:0x1966, B:689:0x1992, B:691:0x19b0, B:693:0x19c0, B:694:0x19c4, B:695:0x19b6, B:697:0x19c8, B:700:0x19de, B:704:0x19ee, B:706:0x1a1a, B:708:0x1a38, B:710:0x1a48, B:711:0x1a4c, B:712:0x1a3e, B:714:0x1a50, B:717:0x1a66, B:721:0x1a76, B:723:0x1aa2, B:725:0x1ac0, B:727:0x1ad0, B:728:0x1ad4, B:729:0x1ac6, B:731:0x1ad8, B:734:0x1aee, B:738:0x1afe, B:740:0x1b2a, B:742:0x1b48, B:744:0x1b58, B:745:0x1b5c, B:746:0x1b4e, B:748:0x1b60, B:751:0x1b76, B:755:0x1b86, B:757:0x1bb2, B:759:0x1bd0, B:761:0x1be0, B:762:0x1be4, B:763:0x1bd6, B:765:0x1be8, B:768:0x1bfe, B:772:0x1c0f, B:774:0x1c3b, B:776:0x1c59, B:778:0x1c69, B:779:0x1c6d, B:780:0x1c5f, B:782:0x1c71, B:785:0x1c87, B:789:0x1c98, B:791:0x1cc4, B:793:0x1ce2, B:795:0x1cf2, B:796:0x1cf6, B:797:0x1ce8, B:799:0x1cfa, B:802:0x1d10, B:806:0x1d20, B:808:0x1d4c, B:810:0x1d6a, B:812:0x1d7a, B:813:0x1d7e, B:814:0x1d70, B:816:0x1d82, B:819:0x1d96, B:822:0x1d9a, B:823:0x1da7, B:824:0x1db0, B:827:0x1dc6, B:831:0x1dd7, B:833:0x1e03, B:835:0x1e23, B:836:0x1e2d, B:837:0x1e31, B:839:0x1e35, B:842:0x1e4b, B:846:0x1e5b, B:848:0x1e87, B:850:0x1ea5, B:852:0x1eb5, B:853:0x1eb9, B:854:0x1eab, B:856:0x1ebd, B:859:0x1ed3, B:863:0x1ee3, B:865:0x1f0f, B:867:0x1f2d, B:869:0x1f3d, B:870:0x1f41, B:871:0x1f33, B:873:0x1f45, B:876:0x1f5b, B:880:0x1f6b, B:882:0x1f97, B:884:0x1fb5, B:886:0x1fc5, B:887:0x1fc9, B:888:0x1fbb, B:890:0x1fcd, B:893:0x1fe3, B:897:0x1ff3, B:899:0x201f, B:901:0x203d, B:903:0x204d, B:904:0x2051, B:905:0x2043, B:907:0x2055, B:910:0x206b, B:914:0x207c, B:916:0x20a8, B:918:0x20c6, B:920:0x20d6, B:921:0x20da, B:922:0x20cc, B:924:0x20de, B:927:0x20f4, B:931:0x2104, B:933:0x2130, B:935:0x214e, B:937:0x215e, B:938:0x2162, B:939:0x2154, B:941:0x2166, B:944:0x217c, B:948:0x218c, B:950:0x21b8, B:952:0x21d6, B:954:0x21e6, B:955:0x21ea, B:956:0x21dc, B:958:0x21ee, B:961:0x2204, B:965:0x2214, B:967:0x2240, B:969:0x225e, B:971:0x226e, B:972:0x2272, B:973:0x2264, B:975:0x2276, B:978:0x228c, B:982:0x229c, B:984:0x22c8, B:986:0x22e6, B:988:0x22f6, B:989:0x22fa, B:990:0x22ec, B:992:0x22fe, B:996:0x2342, B:998:0x2346, B:1001:0x234a, B:1002:0x2355, B:1004:0x235a, B:1006:0x237b, B:1008:0x2391, B:1010:0x23ab, B:1012:0x23ce, B:1014:0x23d2, B:1017:0x23d8, B:1018:0x241e, B:1021:0x242d, B:1024:0x243c, B:1026:0x2442, B:1027:0x244c, B:1028:0x245b, B:1031:0x246b, B:1034:0x2474, B:1037:0x247a, B:1040:0x25f0, B:1043:0x248f, B:1045:0x2493, B:1047:0x24b0, B:1049:0x250e, B:1050:0x251d, B:1053:0x252a, B:1055:0x2540, B:1056:0x2543, B:1057:0x254c, B:1058:0x2582, B:1060:0x258b, B:1063:0x2591, B:1065:0x25ce, B:1071:0x2612, B:1073:0x2616, B:1077:0x2626, B:1079:0x2651, B:1081:0x266f, B:1083:0x267f, B:1084:0x2683, B:1086:0x2675, B:1090:0x26a6, B:1092:0x26aa, B:1096:0x26ba, B:1098:0x26e5, B:1100:0x2703, B:1102:0x2713, B:1103:0x2717, B:1104:0x2709, B:1108:0x272c, B:1110:0x2730, B:1114:0x2740, B:1116:0x276b, B:1118:0x2789, B:1120:0x2799, B:1121:0x279d, B:1122:0x278f, B:1126:0x27b2, B:1128:0x27b6, B:1132:0x27c6, B:1134:0x27f1, B:1136:0x280f, B:1138:0x281f, B:1139:0x2823, B:1140:0x2815, B:1144:0x2838, B:1146:0x283c, B:1147:0x2888, B:1150:0x289d, B:1152:0x28a1, B:1153:0x28ed, B:1156:0x2902, B:1158:0x2906, B:1159:0x2952, B:1162:0x2963, B:1164:0x2967, B:1165:0x29a4, B:1169:0x29b9, B:1171:0x29bd, B:1173:0x2a7a, B:1175:0x2a0f, B:1177:0x2a13, B:1180:0x2a94, B:1182:0x2a98, B:1184:0x2b27, B:1186:0x2aeb, B:1188:0x2aef, B:1191:0x2af8, B:1196:0x2b43, B:1198:0x2b47, B:1199:0x2b92, B:1202:0x2ba1, B:1204:0x2ba5, B:1205:0x2bf0, B:1208:0x2c00, B:1210:0x2c04, B:1211:0x2c75, B:1218:0x2c95, B:1220:0x2c99, B:1222:0x2d07, B:1225:0x2ce9, B:1227:0x2ced, B:1230:0x2d18, B:1232:0x2d1c, B:1233:0x2d6c, B:1237:0x2d7f, B:1239:0x2d83, B:1240:0x2e34, B:1242:0x2dd2, B:1244:0x2dd6, B:1247:0x2e47, B:1249:0x2e4b, B:1250:0x2efc, B:1252:0x2e9a, B:1254:0x2e9e, B:1257:0x2f0f, B:1259:0x2f13, B:1260:0x2fc4, B:1262:0x2f62, B:1264:0x2f66, B:1267:0x2fd7, B:1269:0x2fdb, B:1270:0x3027, B:1273:0x303a, B:1275:0x303e, B:1276:0x30ef, B:1277:0x308b, B:1280:0x3091, B:1283:0x3102, B:1285:0x3106, B:1286:0x31c9, B:1288:0x3114, B:1290:0x3118, B:1291:0x3165, B:1294:0x316b, B:1297:0x31d8, B:1299:0x31dc, B:1300:0x3216, B:1304:0x3225, B:1306:0x3229, B:1309:0x322d, B:1310:0x326b, B:1315:0x327d, B:1317:0x3281, B:1318:0x32cd, B:1321:0x32dd, B:1323:0x32e1, B:1325:0x3395, B:1327:0x3331, B:1329:0x3335, B:1332:0x33a9, B:1334:0x33ad, B:1335:0x33f9, B:1338:0x3409, B:1340:0x340d, B:1341:0x3490, B:1343:0x3445, B:1345:0x3449, B:1348:0x34a4, B:1350:0x34a8, B:1351:0x3559, B:1353:0x34f7, B:1355:0x34fb, B:1358:0x356d, B:1360:0x3571, B:1361:0x35bd, B:1364:0x35cd, B:1366:0x35d1, B:1367:0x3654, B:1369:0x3609, B:1371:0x360d, B:1374:0x3668, B:1376:0x366c, B:1377:0x371d, B:1379:0x36bb, B:1381:0x36bf, B:1384:0x3731, B:1386:0x3735, B:1387:0x37e6, B:1389:0x3784, B:1391:0x3788, B:1394:0x37fa, B:1396:0x37fe, B:1397:0x384a, B:1400:0x385e, B:1402:0x3862, B:1403:0x38ae, B:1406:0x38be, B:1408:0x38c2, B:1409:0x3945, B:1411:0x38fa, B:1413:0x38fe, B:1416:0x3959, B:1418:0x395d, B:1419:0x39a9, B:1422:0x39bd, B:1424:0x39c1, B:1426:0x39fa, B:1427:0x3a07, B:1428:0x3a78, B:1430:0x3a16, B:1432:0x3a1a, B:1435:0x3a8c, B:1437:0x3a90, B:1438:0x3aee, B:1441:0x3afe, B:1443:0x3b02, B:1446:0x3b08, B:1447:0x3b81, B:1449:0x3b38, B:1451:0x3b3c, B:1454:0x3b52, B:1457:0x3b95, B:1459:0x3b99, B:1460:0x3c4a, B:1462:0x3be8, B:1464:0x3bec, B:1467:0x3c5e, B:1469:0x3c62, B:1470:0x3cae, B:1473:0x3cc2, B:1475:0x3cc6, B:1476:0x3d12, B:1479:0x3d26, B:1481:0x3d2a, B:1482:0x3d7b, B:1486:0x3d8c, B:1488:0x3d90, B:1489:0x3de0, B:1493:0x3df4, B:1495:0x3df8, B:1496:0x3e44, B:1499:0x3e58, B:1501:0x3e5c, B:1502:0x3f0d, B:1503:0x3ea9, B:1506:0x3eaf, B:1509:0x3f21, B:1511:0x3f25, B:1512:0x3f83, B:1513:0x3f87, B:1516:0x3f9b, B:1517:0x3fad, B:1520:0x3fb3, B:1521:0x3ff4, B:1526:0x4005, B:1528:0x4009, B:1529:0x4059, B:1533:0x406d, B:1535:0x4071, B:1537:0x4123, B:1538:0x40bf, B:1541:0x40c5, B:1544:0x4134, B:1546:0x4138, B:1547:0x4184, B:1550:0x4198, B:1552:0x419c, B:1556:0x41ae, B:1558:0x41da, B:1560:0x43b0, B:1561:0x4210, B:1563:0x4215, B:1564:0x425e, B:1566:0x4264, B:1572:0x427b, B:1573:0x427e, B:1568:0x4275, B:1576:0x42ac, B:1578:0x42b4, B:1581:0x42ba, B:1583:0x42ef, B:1584:0x4314, B:1586:0x42f3, B:1587:0x42f8, B:1589:0x42fe, B:1595:0x4311, B:1591:0x430b, B:1598:0x4342, B:1600:0x4347, B:1601:0x43bc, B:1604:0x43d0, B:1605:0x441f, B:1608:0x442f, B:1610:0x4433, B:1611:0x4483, B:1616:0x4494, B:1618:0x4498, B:1619:0x44e4, B:1622:0x44f6, B:1624:0x44fa, B:1628:0x450d, B:1630:0x453c, B:1632:0x469f, B:1633:0x4571, B:1635:0x4576, B:1636:0x45bf, B:1638:0x45c5, B:1644:0x45dc, B:1645:0x45df, B:1640:0x45d6, B:1648:0x460b, B:1650:0x4611, B:1653:0x4617, B:1655:0x4650, B:1656:0x4675, B:1657:0x4654, B:1658:0x4659, B:1660:0x465f, B:1666:0x4672, B:1662:0x466c, B:1671:0x46b5, B:1673:0x46b9, B:1677:0x46cc, B:1679:0x46fb, B:1681:0x485e, B:1682:0x4730, B:1684:0x4735, B:1685:0x477e, B:1687:0x4784, B:1693:0x479b, B:1694:0x479e, B:1689:0x4795, B:1697:0x47ca, B:1699:0x47d0, B:1702:0x47d6, B:1704:0x480f, B:1705:0x4834, B:1706:0x4813, B:1707:0x4818, B:1709:0x481e, B:1715:0x4831, B:1711:0x482b, B:1720:0x486d, B:1722:0x4871, B:1725:0x4875, B:1726:0x48b2, B:1730:0x48c1, B:1732:0x48c5, B:1735:0x48c9, B:1736:0x4959, B:1737:0x4904, B:1740:0x490b, B:1743:0x4969, B:1745:0x496d, B:1748:0x4971, B:1749:0x49ff, B:1750:0x49ab, B:1753:0x49b1, B:1754:0x4a03, B:1757:0x4a13, B:1758:0x4a28, B:1761:0x4a2e, B:1762:0x4abc, B:1766:0x4a6a, B:1768:0x4a6e, B:1771:0x4a84, B:1772:0x4ac0, B:1775:0x4ad4, B:1776:0x4ae3, B:1778:0x4b23, B:1781:0x4b37, B:1783:0x4b3b, B:1784:0x4beb, B:1786:0x4b8a, B:1788:0x4b8e, B:1789:0x4bef, B:1792:0x4c03, B:1793:0x4c54, B:1796:0x4c59, B:1799:0x4c6a, B:1800:0x4cb7, B:1803:0x4cc7, B:1805:0x4ccb, B:1806:0x4d2a, B:1807:0x4d19, B:1809:0x4d1e, B:1812:0x4d2e, B:1815:0x4d42, B:1816:0x4d93, B:1820:0x4da2, B:1823:0x4da6, B:1826:0x4daf, B:1828:0x4db7, B:1831:0x4dc7, B:1833:0x4dcb, B:1834:0x4e4f, B:1837:0x4e05, B:1839:0x4e09, B:1842:0x4e63, B:1844:0x4e67, B:1845:0x4f17, B:1847:0x4eb6, B:1849:0x4eba, B:1852:0x4f27, B:1854:0x4f2b, B:1855:0x4fab, B:1857:0x4f63, B:1859:0x4f67, B:1862:0x4f7d, B:1865:0x4fbb, B:1867:0x4fbf, B:1870:0x4fd5, B:1871:0x5003, B:1874:0x5017, B:1876:0x501b, B:1877:0x5067, B:1880:0x5077, B:1882:0x507b, B:1885:0x5081, B:1886:0x50af, B:1888:0x50b3, B:1890:0x50be, B:1893:0x50ce, B:1895:0x50d2, B:1898:0x50d8, B:1899:0x5105, B:1902:0x5115, B:1904:0x5119, B:1907:0x511f, B:1908:0x514c, B:1911:0x515c, B:1913:0x5160, B:1916:0x5167, B:1918:0x51bd, B:1921:0x5185, B:1923:0x5189, B:1926:0x518f, B:1929:0x51d0, B:1931:0x51d4, B:1935:0x51f6, B:1937:0x5225, B:1938:0x524b, B:1942:0x525d, B:1944:0x5261, B:1945:0x52ae, B:1948:0x52bf, B:1950:0x52c3, B:1954:0x52e3, B:1956:0x5310, B:1957:0x5332, B:1960:0x5343, B:1962:0x5347, B:1966:0x5367, B:1968:0x5395, B:1969:0x53b7, B:1972:0x53c8, B:1974:0x53cc, B:1978:0x53ec, B:1980:0x541a, B:1981:0x543c, B:1984:0x544d, B:1986:0x5451, B:1990:0x5471, B:1992:0x549f, B:1993:0x54c1, B:1996:0x54d2, B:1998:0x54d6, B:2002:0x54f6, B:2004:0x5524, B:2005:0x5546, B:2008:0x5557, B:2010:0x555b, B:2011:0x5573, B:2014:0x5585, B:2016:0x5589, B:2017:0x55d6, B:2020:0x55e8, B:2022:0x55ec, B:2025:0x55f2, B:2026:0x5637, B:2031:0x5656, B:2033:0x565a, B:2034:0x56ab, B:2039:0x56bf, B:2041:0x56c3, B:2044:0x56c9, B:2047:0x56d2, B:2050:0x56f9, B:2051:0x5710, B:2057:0x572e, B:2059:0x5734, B:2060:0x5777, B:2064:0x578b, B:2066:0x578f, B:2069:0x5795, B:2070:0x57c5, B:2075:0x57dd, B:2077:0x57e1, B:2081:0x57f4, B:2083:0x5821, B:2084:0x5a47, B:2085:0x585d, B:2087:0x5887, B:2089:0x5891, B:2090:0x58e5, B:2092:0x58eb, B:2098:0x5902, B:2099:0x5905, B:2094:0x58fc, B:2102:0x5934, B:2104:0x5946, B:2107:0x594c, B:2109:0x5982, B:2110:0x59a7, B:2112:0x5986, B:2113:0x598b, B:2115:0x5991, B:2121:0x59a4, B:2117:0x599e, B:2124:0x59d6, B:2126:0x59db, B:2129:0x5a5c, B:2131:0x5a62, B:2133:0x5a9d, B:2134:0x5ab4, B:2136:0x5b21, B:2139:0x5abd, B:2141:0x5ac1, B:2145:0x5b37, B:2147:0x5b3b, B:2148:0x5b87, B:2151:0x5b97, B:2153:0x5b9b, B:2156:0x5b9f, B:2157:0x5c30, B:2158:0x5bdb, B:2161:0x5be2, B:2164:0x5c45, B:2166:0x5c49, B:2167:0x5cfc, B:2169:0x5c98, B:2171:0x5c9c, B:2172:0x5d00, B:2175:0x5d72, B:2177:0x5d76, B:2178:0x5dc4, B:2181:0x5dd5, B:2182:0x5dea, B:2185:0x5df0, B:2187:0x5dfd, B:2188:0x5e02, B:2193:0x5e44, B:2195:0x5e48, B:2196:0x5e66, B:2199:0x5e6b, B:2200:0x5e79, B:2203:0x5e8b, B:2206:0x5e94, B:2210:0x5ec5, B:2212:0x5ec9, B:2221:0x5f00, B:2222:0x6026, B:2223:0x602b, B:2224:0x5f05, B:2225:0x5f36, B:2226:0x5f66, B:2227:0x5f96, B:2228:0x5fc5, B:2230:0x5fef, B:2232:0x5ff5, B:2234:0x5ffb, B:2235:0x600e), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x6067 A[Catch: Exception -> 0x0014, TryCatch #0 {Exception -> 0x0014, blocks: (B:3:0x0004, B:5:0x000c, B:6:0x0018, B:10:0x001f, B:15:0x0099, B:16:0x00a4, B:21:0x6030, B:23:0x6038, B:25:0x603c, B:27:0x6040, B:29:0x6047, B:30:0x6059, B:32:0x605d, B:37:0x6067, B:39:0x6071, B:40:0x6076, B:42:0x607e, B:44:0x6086, B:46:0x609f, B:48:0x60a9, B:50:0x60c2, B:54:0x60d3, B:56:0x60d9, B:63:0x00bd, B:65:0x00c1, B:69:0x00cf, B:71:0x00fb, B:72:0x0133, B:77:0x014e, B:79:0x0152, B:82:0x0156, B:83:0x0186, B:86:0x0194, B:88:0x0198, B:91:0x019c, B:92:0x01cc, B:95:0x01dd, B:97:0x01e1, B:98:0x0253, B:104:0x0278, B:106:0x027e, B:109:0x0282, B:111:0x02f0, B:113:0x02ae, B:115:0x02b2, B:118:0x02cb, B:122:0x030d, B:124:0x0313, B:129:0x0398, B:131:0x03e0, B:134:0x031c, B:135:0x035a, B:138:0x03a3, B:140:0x03a7, B:143:0x03be, B:147:0x03f9, B:149:0x03fd, B:150:0x0459, B:155:0x046c, B:157:0x0470, B:160:0x0474, B:162:0x04e2, B:164:0x04a1, B:166:0x04a5, B:169:0x04ba, B:172:0x04fd, B:174:0x0503, B:175:0x0543, B:179:0x0558, B:181:0x055c, B:182:0x05aa, B:185:0x05bf, B:187:0x05c3, B:188:0x0600, B:191:0x0615, B:193:0x0619, B:196:0x0630, B:197:0x0670, B:201:0x0688, B:203:0x068e, B:204:0x06d8, B:209:0x06ed, B:211:0x06f1, B:213:0x072e, B:214:0x073b, B:216:0x079e, B:218:0x074c, B:220:0x0750, B:223:0x07b9, B:225:0x07bf, B:227:0x081c, B:229:0x080e, B:231:0x0812, B:235:0x083d, B:237:0x0841, B:239:0x0878, B:240:0x088e, B:242:0x08f9, B:244:0x0897, B:246:0x089b, B:249:0x0911, B:251:0x0917, B:252:0x0961, B:257:0x0970, B:259:0x0974, B:260:0x09f7, B:262:0x09ac, B:264:0x09b0, B:267:0x0a0c, B:269:0x0a10, B:270:0x0ab1, B:272:0x0a5d, B:274:0x0a61, B:277:0x0ac8, B:280:0x0acc, B:281:0x0b1d, B:285:0x0b32, B:288:0x0b36, B:289:0x0b82, B:292:0x0b97, B:294:0x0b9d, B:298:0x0bae, B:300:0x0bdb, B:303:0x0cc5, B:304:0x0c11, B:306:0x0c18, B:309:0x0c1c, B:311:0x0c54, B:312:0x0c79, B:313:0x0c58, B:314:0x0c5d, B:316:0x0c63, B:322:0x0c76, B:318:0x0c70, B:325:0x0ca5, B:327:0x0caa, B:330:0x0cde, B:332:0x0ce2, B:336:0x0cf3, B:338:0x0d1e, B:340:0x0ddd, B:341:0x0d50, B:343:0x0d54, B:346:0x0d58, B:348:0x0d8e, B:349:0x0db3, B:350:0x0d92, B:351:0x0d97, B:353:0x0d9d, B:359:0x0db0, B:355:0x0daa, B:362:0x0de2, B:365:0x0df5, B:366:0x0e09, B:369:0x0e0d, B:371:0x0e7e, B:375:0x0e3e, B:377:0x0e44, B:380:0x0e56, B:383:0x0e8c, B:385:0x0e90, B:386:0x0ea8, B:389:0x0ebd, B:391:0x0ec1, B:393:0x0ec5, B:395:0x0f73, B:397:0x0f14, B:399:0x0f18, B:402:0x0f90, B:404:0x0f96, B:407:0x0f9a, B:409:0x0fd1, B:411:0x0fdb, B:412:0x1015, B:414:0x0fe2, B:416:0x0fe6, B:418:0x0ff6, B:419:0x100f, B:420:0x1024, B:422:0x102a, B:425:0x1031, B:428:0x1122, B:431:0x106f, B:433:0x107b, B:435:0x107f, B:436:0x10b7, B:438:0x10bd, B:440:0x10c1, B:441:0x1132, B:444:0x1148, B:445:0x115c, B:448:0x1160, B:451:0x11aa, B:455:0x11c8, B:457:0x11cc, B:460:0x11d0, B:462:0x1240, B:464:0x11fd, B:466:0x1201, B:469:0x1218, B:472:0x125c, B:475:0x1260, B:476:0x12b1, B:482:0x12d3, B:485:0x12d7, B:486:0x1308, B:489:0x131b, B:492:0x131f, B:493:0x1356, B:496:0x136a, B:499:0x136e, B:502:0x1375, B:503:0x13dd, B:505:0x13a2, B:508:0x13a6, B:509:0x13e1, B:512:0x13f6, B:516:0x1406, B:518:0x1433, B:520:0x1452, B:522:0x1462, B:523:0x1467, B:525:0x1458, B:527:0x1479, B:530:0x148f, B:534:0x14a0, B:536:0x14cc, B:538:0x14ea, B:540:0x14fa, B:541:0x14fe, B:542:0x14f0, B:544:0x1502, B:547:0x1518, B:551:0x1529, B:553:0x1555, B:555:0x1573, B:557:0x1583, B:558:0x1587, B:559:0x1579, B:561:0x158b, B:564:0x15a1, B:568:0x15b0, B:570:0x15dc, B:572:0x15fa, B:574:0x160a, B:575:0x160e, B:576:0x1600, B:578:0x1612, B:581:0x1628, B:585:0x1638, B:587:0x1664, B:589:0x1682, B:591:0x1692, B:592:0x1696, B:593:0x1688, B:595:0x169a, B:598:0x16b0, B:602:0x16bf, B:604:0x16eb, B:606:0x1709, B:608:0x1719, B:609:0x171d, B:610:0x170f, B:612:0x1721, B:615:0x1737, B:619:0x1746, B:621:0x1772, B:623:0x1790, B:625:0x17a0, B:626:0x17a4, B:627:0x1796, B:629:0x17a8, B:632:0x17be, B:636:0x17cd, B:638:0x17f9, B:640:0x1817, B:642:0x1827, B:643:0x182b, B:644:0x181d, B:646:0x182f, B:649:0x1845, B:653:0x1856, B:655:0x1882, B:657:0x18a0, B:659:0x18b0, B:660:0x18b4, B:661:0x18a6, B:663:0x18b8, B:666:0x18ce, B:670:0x18de, B:672:0x190a, B:674:0x1928, B:676:0x1938, B:677:0x193c, B:678:0x192e, B:680:0x1940, B:683:0x1956, B:687:0x1966, B:689:0x1992, B:691:0x19b0, B:693:0x19c0, B:694:0x19c4, B:695:0x19b6, B:697:0x19c8, B:700:0x19de, B:704:0x19ee, B:706:0x1a1a, B:708:0x1a38, B:710:0x1a48, B:711:0x1a4c, B:712:0x1a3e, B:714:0x1a50, B:717:0x1a66, B:721:0x1a76, B:723:0x1aa2, B:725:0x1ac0, B:727:0x1ad0, B:728:0x1ad4, B:729:0x1ac6, B:731:0x1ad8, B:734:0x1aee, B:738:0x1afe, B:740:0x1b2a, B:742:0x1b48, B:744:0x1b58, B:745:0x1b5c, B:746:0x1b4e, B:748:0x1b60, B:751:0x1b76, B:755:0x1b86, B:757:0x1bb2, B:759:0x1bd0, B:761:0x1be0, B:762:0x1be4, B:763:0x1bd6, B:765:0x1be8, B:768:0x1bfe, B:772:0x1c0f, B:774:0x1c3b, B:776:0x1c59, B:778:0x1c69, B:779:0x1c6d, B:780:0x1c5f, B:782:0x1c71, B:785:0x1c87, B:789:0x1c98, B:791:0x1cc4, B:793:0x1ce2, B:795:0x1cf2, B:796:0x1cf6, B:797:0x1ce8, B:799:0x1cfa, B:802:0x1d10, B:806:0x1d20, B:808:0x1d4c, B:810:0x1d6a, B:812:0x1d7a, B:813:0x1d7e, B:814:0x1d70, B:816:0x1d82, B:819:0x1d96, B:822:0x1d9a, B:823:0x1da7, B:824:0x1db0, B:827:0x1dc6, B:831:0x1dd7, B:833:0x1e03, B:835:0x1e23, B:836:0x1e2d, B:837:0x1e31, B:839:0x1e35, B:842:0x1e4b, B:846:0x1e5b, B:848:0x1e87, B:850:0x1ea5, B:852:0x1eb5, B:853:0x1eb9, B:854:0x1eab, B:856:0x1ebd, B:859:0x1ed3, B:863:0x1ee3, B:865:0x1f0f, B:867:0x1f2d, B:869:0x1f3d, B:870:0x1f41, B:871:0x1f33, B:873:0x1f45, B:876:0x1f5b, B:880:0x1f6b, B:882:0x1f97, B:884:0x1fb5, B:886:0x1fc5, B:887:0x1fc9, B:888:0x1fbb, B:890:0x1fcd, B:893:0x1fe3, B:897:0x1ff3, B:899:0x201f, B:901:0x203d, B:903:0x204d, B:904:0x2051, B:905:0x2043, B:907:0x2055, B:910:0x206b, B:914:0x207c, B:916:0x20a8, B:918:0x20c6, B:920:0x20d6, B:921:0x20da, B:922:0x20cc, B:924:0x20de, B:927:0x20f4, B:931:0x2104, B:933:0x2130, B:935:0x214e, B:937:0x215e, B:938:0x2162, B:939:0x2154, B:941:0x2166, B:944:0x217c, B:948:0x218c, B:950:0x21b8, B:952:0x21d6, B:954:0x21e6, B:955:0x21ea, B:956:0x21dc, B:958:0x21ee, B:961:0x2204, B:965:0x2214, B:967:0x2240, B:969:0x225e, B:971:0x226e, B:972:0x2272, B:973:0x2264, B:975:0x2276, B:978:0x228c, B:982:0x229c, B:984:0x22c8, B:986:0x22e6, B:988:0x22f6, B:989:0x22fa, B:990:0x22ec, B:992:0x22fe, B:996:0x2342, B:998:0x2346, B:1001:0x234a, B:1002:0x2355, B:1004:0x235a, B:1006:0x237b, B:1008:0x2391, B:1010:0x23ab, B:1012:0x23ce, B:1014:0x23d2, B:1017:0x23d8, B:1018:0x241e, B:1021:0x242d, B:1024:0x243c, B:1026:0x2442, B:1027:0x244c, B:1028:0x245b, B:1031:0x246b, B:1034:0x2474, B:1037:0x247a, B:1040:0x25f0, B:1043:0x248f, B:1045:0x2493, B:1047:0x24b0, B:1049:0x250e, B:1050:0x251d, B:1053:0x252a, B:1055:0x2540, B:1056:0x2543, B:1057:0x254c, B:1058:0x2582, B:1060:0x258b, B:1063:0x2591, B:1065:0x25ce, B:1071:0x2612, B:1073:0x2616, B:1077:0x2626, B:1079:0x2651, B:1081:0x266f, B:1083:0x267f, B:1084:0x2683, B:1086:0x2675, B:1090:0x26a6, B:1092:0x26aa, B:1096:0x26ba, B:1098:0x26e5, B:1100:0x2703, B:1102:0x2713, B:1103:0x2717, B:1104:0x2709, B:1108:0x272c, B:1110:0x2730, B:1114:0x2740, B:1116:0x276b, B:1118:0x2789, B:1120:0x2799, B:1121:0x279d, B:1122:0x278f, B:1126:0x27b2, B:1128:0x27b6, B:1132:0x27c6, B:1134:0x27f1, B:1136:0x280f, B:1138:0x281f, B:1139:0x2823, B:1140:0x2815, B:1144:0x2838, B:1146:0x283c, B:1147:0x2888, B:1150:0x289d, B:1152:0x28a1, B:1153:0x28ed, B:1156:0x2902, B:1158:0x2906, B:1159:0x2952, B:1162:0x2963, B:1164:0x2967, B:1165:0x29a4, B:1169:0x29b9, B:1171:0x29bd, B:1173:0x2a7a, B:1175:0x2a0f, B:1177:0x2a13, B:1180:0x2a94, B:1182:0x2a98, B:1184:0x2b27, B:1186:0x2aeb, B:1188:0x2aef, B:1191:0x2af8, B:1196:0x2b43, B:1198:0x2b47, B:1199:0x2b92, B:1202:0x2ba1, B:1204:0x2ba5, B:1205:0x2bf0, B:1208:0x2c00, B:1210:0x2c04, B:1211:0x2c75, B:1218:0x2c95, B:1220:0x2c99, B:1222:0x2d07, B:1225:0x2ce9, B:1227:0x2ced, B:1230:0x2d18, B:1232:0x2d1c, B:1233:0x2d6c, B:1237:0x2d7f, B:1239:0x2d83, B:1240:0x2e34, B:1242:0x2dd2, B:1244:0x2dd6, B:1247:0x2e47, B:1249:0x2e4b, B:1250:0x2efc, B:1252:0x2e9a, B:1254:0x2e9e, B:1257:0x2f0f, B:1259:0x2f13, B:1260:0x2fc4, B:1262:0x2f62, B:1264:0x2f66, B:1267:0x2fd7, B:1269:0x2fdb, B:1270:0x3027, B:1273:0x303a, B:1275:0x303e, B:1276:0x30ef, B:1277:0x308b, B:1280:0x3091, B:1283:0x3102, B:1285:0x3106, B:1286:0x31c9, B:1288:0x3114, B:1290:0x3118, B:1291:0x3165, B:1294:0x316b, B:1297:0x31d8, B:1299:0x31dc, B:1300:0x3216, B:1304:0x3225, B:1306:0x3229, B:1309:0x322d, B:1310:0x326b, B:1315:0x327d, B:1317:0x3281, B:1318:0x32cd, B:1321:0x32dd, B:1323:0x32e1, B:1325:0x3395, B:1327:0x3331, B:1329:0x3335, B:1332:0x33a9, B:1334:0x33ad, B:1335:0x33f9, B:1338:0x3409, B:1340:0x340d, B:1341:0x3490, B:1343:0x3445, B:1345:0x3449, B:1348:0x34a4, B:1350:0x34a8, B:1351:0x3559, B:1353:0x34f7, B:1355:0x34fb, B:1358:0x356d, B:1360:0x3571, B:1361:0x35bd, B:1364:0x35cd, B:1366:0x35d1, B:1367:0x3654, B:1369:0x3609, B:1371:0x360d, B:1374:0x3668, B:1376:0x366c, B:1377:0x371d, B:1379:0x36bb, B:1381:0x36bf, B:1384:0x3731, B:1386:0x3735, B:1387:0x37e6, B:1389:0x3784, B:1391:0x3788, B:1394:0x37fa, B:1396:0x37fe, B:1397:0x384a, B:1400:0x385e, B:1402:0x3862, B:1403:0x38ae, B:1406:0x38be, B:1408:0x38c2, B:1409:0x3945, B:1411:0x38fa, B:1413:0x38fe, B:1416:0x3959, B:1418:0x395d, B:1419:0x39a9, B:1422:0x39bd, B:1424:0x39c1, B:1426:0x39fa, B:1427:0x3a07, B:1428:0x3a78, B:1430:0x3a16, B:1432:0x3a1a, B:1435:0x3a8c, B:1437:0x3a90, B:1438:0x3aee, B:1441:0x3afe, B:1443:0x3b02, B:1446:0x3b08, B:1447:0x3b81, B:1449:0x3b38, B:1451:0x3b3c, B:1454:0x3b52, B:1457:0x3b95, B:1459:0x3b99, B:1460:0x3c4a, B:1462:0x3be8, B:1464:0x3bec, B:1467:0x3c5e, B:1469:0x3c62, B:1470:0x3cae, B:1473:0x3cc2, B:1475:0x3cc6, B:1476:0x3d12, B:1479:0x3d26, B:1481:0x3d2a, B:1482:0x3d7b, B:1486:0x3d8c, B:1488:0x3d90, B:1489:0x3de0, B:1493:0x3df4, B:1495:0x3df8, B:1496:0x3e44, B:1499:0x3e58, B:1501:0x3e5c, B:1502:0x3f0d, B:1503:0x3ea9, B:1506:0x3eaf, B:1509:0x3f21, B:1511:0x3f25, B:1512:0x3f83, B:1513:0x3f87, B:1516:0x3f9b, B:1517:0x3fad, B:1520:0x3fb3, B:1521:0x3ff4, B:1526:0x4005, B:1528:0x4009, B:1529:0x4059, B:1533:0x406d, B:1535:0x4071, B:1537:0x4123, B:1538:0x40bf, B:1541:0x40c5, B:1544:0x4134, B:1546:0x4138, B:1547:0x4184, B:1550:0x4198, B:1552:0x419c, B:1556:0x41ae, B:1558:0x41da, B:1560:0x43b0, B:1561:0x4210, B:1563:0x4215, B:1564:0x425e, B:1566:0x4264, B:1572:0x427b, B:1573:0x427e, B:1568:0x4275, B:1576:0x42ac, B:1578:0x42b4, B:1581:0x42ba, B:1583:0x42ef, B:1584:0x4314, B:1586:0x42f3, B:1587:0x42f8, B:1589:0x42fe, B:1595:0x4311, B:1591:0x430b, B:1598:0x4342, B:1600:0x4347, B:1601:0x43bc, B:1604:0x43d0, B:1605:0x441f, B:1608:0x442f, B:1610:0x4433, B:1611:0x4483, B:1616:0x4494, B:1618:0x4498, B:1619:0x44e4, B:1622:0x44f6, B:1624:0x44fa, B:1628:0x450d, B:1630:0x453c, B:1632:0x469f, B:1633:0x4571, B:1635:0x4576, B:1636:0x45bf, B:1638:0x45c5, B:1644:0x45dc, B:1645:0x45df, B:1640:0x45d6, B:1648:0x460b, B:1650:0x4611, B:1653:0x4617, B:1655:0x4650, B:1656:0x4675, B:1657:0x4654, B:1658:0x4659, B:1660:0x465f, B:1666:0x4672, B:1662:0x466c, B:1671:0x46b5, B:1673:0x46b9, B:1677:0x46cc, B:1679:0x46fb, B:1681:0x485e, B:1682:0x4730, B:1684:0x4735, B:1685:0x477e, B:1687:0x4784, B:1693:0x479b, B:1694:0x479e, B:1689:0x4795, B:1697:0x47ca, B:1699:0x47d0, B:1702:0x47d6, B:1704:0x480f, B:1705:0x4834, B:1706:0x4813, B:1707:0x4818, B:1709:0x481e, B:1715:0x4831, B:1711:0x482b, B:1720:0x486d, B:1722:0x4871, B:1725:0x4875, B:1726:0x48b2, B:1730:0x48c1, B:1732:0x48c5, B:1735:0x48c9, B:1736:0x4959, B:1737:0x4904, B:1740:0x490b, B:1743:0x4969, B:1745:0x496d, B:1748:0x4971, B:1749:0x49ff, B:1750:0x49ab, B:1753:0x49b1, B:1754:0x4a03, B:1757:0x4a13, B:1758:0x4a28, B:1761:0x4a2e, B:1762:0x4abc, B:1766:0x4a6a, B:1768:0x4a6e, B:1771:0x4a84, B:1772:0x4ac0, B:1775:0x4ad4, B:1776:0x4ae3, B:1778:0x4b23, B:1781:0x4b37, B:1783:0x4b3b, B:1784:0x4beb, B:1786:0x4b8a, B:1788:0x4b8e, B:1789:0x4bef, B:1792:0x4c03, B:1793:0x4c54, B:1796:0x4c59, B:1799:0x4c6a, B:1800:0x4cb7, B:1803:0x4cc7, B:1805:0x4ccb, B:1806:0x4d2a, B:1807:0x4d19, B:1809:0x4d1e, B:1812:0x4d2e, B:1815:0x4d42, B:1816:0x4d93, B:1820:0x4da2, B:1823:0x4da6, B:1826:0x4daf, B:1828:0x4db7, B:1831:0x4dc7, B:1833:0x4dcb, B:1834:0x4e4f, B:1837:0x4e05, B:1839:0x4e09, B:1842:0x4e63, B:1844:0x4e67, B:1845:0x4f17, B:1847:0x4eb6, B:1849:0x4eba, B:1852:0x4f27, B:1854:0x4f2b, B:1855:0x4fab, B:1857:0x4f63, B:1859:0x4f67, B:1862:0x4f7d, B:1865:0x4fbb, B:1867:0x4fbf, B:1870:0x4fd5, B:1871:0x5003, B:1874:0x5017, B:1876:0x501b, B:1877:0x5067, B:1880:0x5077, B:1882:0x507b, B:1885:0x5081, B:1886:0x50af, B:1888:0x50b3, B:1890:0x50be, B:1893:0x50ce, B:1895:0x50d2, B:1898:0x50d8, B:1899:0x5105, B:1902:0x5115, B:1904:0x5119, B:1907:0x511f, B:1908:0x514c, B:1911:0x515c, B:1913:0x5160, B:1916:0x5167, B:1918:0x51bd, B:1921:0x5185, B:1923:0x5189, B:1926:0x518f, B:1929:0x51d0, B:1931:0x51d4, B:1935:0x51f6, B:1937:0x5225, B:1938:0x524b, B:1942:0x525d, B:1944:0x5261, B:1945:0x52ae, B:1948:0x52bf, B:1950:0x52c3, B:1954:0x52e3, B:1956:0x5310, B:1957:0x5332, B:1960:0x5343, B:1962:0x5347, B:1966:0x5367, B:1968:0x5395, B:1969:0x53b7, B:1972:0x53c8, B:1974:0x53cc, B:1978:0x53ec, B:1980:0x541a, B:1981:0x543c, B:1984:0x544d, B:1986:0x5451, B:1990:0x5471, B:1992:0x549f, B:1993:0x54c1, B:1996:0x54d2, B:1998:0x54d6, B:2002:0x54f6, B:2004:0x5524, B:2005:0x5546, B:2008:0x5557, B:2010:0x555b, B:2011:0x5573, B:2014:0x5585, B:2016:0x5589, B:2017:0x55d6, B:2020:0x55e8, B:2022:0x55ec, B:2025:0x55f2, B:2026:0x5637, B:2031:0x5656, B:2033:0x565a, B:2034:0x56ab, B:2039:0x56bf, B:2041:0x56c3, B:2044:0x56c9, B:2047:0x56d2, B:2050:0x56f9, B:2051:0x5710, B:2057:0x572e, B:2059:0x5734, B:2060:0x5777, B:2064:0x578b, B:2066:0x578f, B:2069:0x5795, B:2070:0x57c5, B:2075:0x57dd, B:2077:0x57e1, B:2081:0x57f4, B:2083:0x5821, B:2084:0x5a47, B:2085:0x585d, B:2087:0x5887, B:2089:0x5891, B:2090:0x58e5, B:2092:0x58eb, B:2098:0x5902, B:2099:0x5905, B:2094:0x58fc, B:2102:0x5934, B:2104:0x5946, B:2107:0x594c, B:2109:0x5982, B:2110:0x59a7, B:2112:0x5986, B:2113:0x598b, B:2115:0x5991, B:2121:0x59a4, B:2117:0x599e, B:2124:0x59d6, B:2126:0x59db, B:2129:0x5a5c, B:2131:0x5a62, B:2133:0x5a9d, B:2134:0x5ab4, B:2136:0x5b21, B:2139:0x5abd, B:2141:0x5ac1, B:2145:0x5b37, B:2147:0x5b3b, B:2148:0x5b87, B:2151:0x5b97, B:2153:0x5b9b, B:2156:0x5b9f, B:2157:0x5c30, B:2158:0x5bdb, B:2161:0x5be2, B:2164:0x5c45, B:2166:0x5c49, B:2167:0x5cfc, B:2169:0x5c98, B:2171:0x5c9c, B:2172:0x5d00, B:2175:0x5d72, B:2177:0x5d76, B:2178:0x5dc4, B:2181:0x5dd5, B:2182:0x5dea, B:2185:0x5df0, B:2187:0x5dfd, B:2188:0x5e02, B:2193:0x5e44, B:2195:0x5e48, B:2196:0x5e66, B:2199:0x5e6b, B:2200:0x5e79, B:2203:0x5e8b, B:2206:0x5e94, B:2210:0x5ec5, B:2212:0x5ec9, B:2221:0x5f00, B:2222:0x6026, B:2223:0x602b, B:2224:0x5f05, B:2225:0x5f36, B:2226:0x5f66, B:2227:0x5f96, B:2228:0x5fc5, B:2230:0x5fef, B:2232:0x5ff5, B:2234:0x5ffb, B:2235:0x600e), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x609f A[Catch: Exception -> 0x0014, TryCatch #0 {Exception -> 0x0014, blocks: (B:3:0x0004, B:5:0x000c, B:6:0x0018, B:10:0x001f, B:15:0x0099, B:16:0x00a4, B:21:0x6030, B:23:0x6038, B:25:0x603c, B:27:0x6040, B:29:0x6047, B:30:0x6059, B:32:0x605d, B:37:0x6067, B:39:0x6071, B:40:0x6076, B:42:0x607e, B:44:0x6086, B:46:0x609f, B:48:0x60a9, B:50:0x60c2, B:54:0x60d3, B:56:0x60d9, B:63:0x00bd, B:65:0x00c1, B:69:0x00cf, B:71:0x00fb, B:72:0x0133, B:77:0x014e, B:79:0x0152, B:82:0x0156, B:83:0x0186, B:86:0x0194, B:88:0x0198, B:91:0x019c, B:92:0x01cc, B:95:0x01dd, B:97:0x01e1, B:98:0x0253, B:104:0x0278, B:106:0x027e, B:109:0x0282, B:111:0x02f0, B:113:0x02ae, B:115:0x02b2, B:118:0x02cb, B:122:0x030d, B:124:0x0313, B:129:0x0398, B:131:0x03e0, B:134:0x031c, B:135:0x035a, B:138:0x03a3, B:140:0x03a7, B:143:0x03be, B:147:0x03f9, B:149:0x03fd, B:150:0x0459, B:155:0x046c, B:157:0x0470, B:160:0x0474, B:162:0x04e2, B:164:0x04a1, B:166:0x04a5, B:169:0x04ba, B:172:0x04fd, B:174:0x0503, B:175:0x0543, B:179:0x0558, B:181:0x055c, B:182:0x05aa, B:185:0x05bf, B:187:0x05c3, B:188:0x0600, B:191:0x0615, B:193:0x0619, B:196:0x0630, B:197:0x0670, B:201:0x0688, B:203:0x068e, B:204:0x06d8, B:209:0x06ed, B:211:0x06f1, B:213:0x072e, B:214:0x073b, B:216:0x079e, B:218:0x074c, B:220:0x0750, B:223:0x07b9, B:225:0x07bf, B:227:0x081c, B:229:0x080e, B:231:0x0812, B:235:0x083d, B:237:0x0841, B:239:0x0878, B:240:0x088e, B:242:0x08f9, B:244:0x0897, B:246:0x089b, B:249:0x0911, B:251:0x0917, B:252:0x0961, B:257:0x0970, B:259:0x0974, B:260:0x09f7, B:262:0x09ac, B:264:0x09b0, B:267:0x0a0c, B:269:0x0a10, B:270:0x0ab1, B:272:0x0a5d, B:274:0x0a61, B:277:0x0ac8, B:280:0x0acc, B:281:0x0b1d, B:285:0x0b32, B:288:0x0b36, B:289:0x0b82, B:292:0x0b97, B:294:0x0b9d, B:298:0x0bae, B:300:0x0bdb, B:303:0x0cc5, B:304:0x0c11, B:306:0x0c18, B:309:0x0c1c, B:311:0x0c54, B:312:0x0c79, B:313:0x0c58, B:314:0x0c5d, B:316:0x0c63, B:322:0x0c76, B:318:0x0c70, B:325:0x0ca5, B:327:0x0caa, B:330:0x0cde, B:332:0x0ce2, B:336:0x0cf3, B:338:0x0d1e, B:340:0x0ddd, B:341:0x0d50, B:343:0x0d54, B:346:0x0d58, B:348:0x0d8e, B:349:0x0db3, B:350:0x0d92, B:351:0x0d97, B:353:0x0d9d, B:359:0x0db0, B:355:0x0daa, B:362:0x0de2, B:365:0x0df5, B:366:0x0e09, B:369:0x0e0d, B:371:0x0e7e, B:375:0x0e3e, B:377:0x0e44, B:380:0x0e56, B:383:0x0e8c, B:385:0x0e90, B:386:0x0ea8, B:389:0x0ebd, B:391:0x0ec1, B:393:0x0ec5, B:395:0x0f73, B:397:0x0f14, B:399:0x0f18, B:402:0x0f90, B:404:0x0f96, B:407:0x0f9a, B:409:0x0fd1, B:411:0x0fdb, B:412:0x1015, B:414:0x0fe2, B:416:0x0fe6, B:418:0x0ff6, B:419:0x100f, B:420:0x1024, B:422:0x102a, B:425:0x1031, B:428:0x1122, B:431:0x106f, B:433:0x107b, B:435:0x107f, B:436:0x10b7, B:438:0x10bd, B:440:0x10c1, B:441:0x1132, B:444:0x1148, B:445:0x115c, B:448:0x1160, B:451:0x11aa, B:455:0x11c8, B:457:0x11cc, B:460:0x11d0, B:462:0x1240, B:464:0x11fd, B:466:0x1201, B:469:0x1218, B:472:0x125c, B:475:0x1260, B:476:0x12b1, B:482:0x12d3, B:485:0x12d7, B:486:0x1308, B:489:0x131b, B:492:0x131f, B:493:0x1356, B:496:0x136a, B:499:0x136e, B:502:0x1375, B:503:0x13dd, B:505:0x13a2, B:508:0x13a6, B:509:0x13e1, B:512:0x13f6, B:516:0x1406, B:518:0x1433, B:520:0x1452, B:522:0x1462, B:523:0x1467, B:525:0x1458, B:527:0x1479, B:530:0x148f, B:534:0x14a0, B:536:0x14cc, B:538:0x14ea, B:540:0x14fa, B:541:0x14fe, B:542:0x14f0, B:544:0x1502, B:547:0x1518, B:551:0x1529, B:553:0x1555, B:555:0x1573, B:557:0x1583, B:558:0x1587, B:559:0x1579, B:561:0x158b, B:564:0x15a1, B:568:0x15b0, B:570:0x15dc, B:572:0x15fa, B:574:0x160a, B:575:0x160e, B:576:0x1600, B:578:0x1612, B:581:0x1628, B:585:0x1638, B:587:0x1664, B:589:0x1682, B:591:0x1692, B:592:0x1696, B:593:0x1688, B:595:0x169a, B:598:0x16b0, B:602:0x16bf, B:604:0x16eb, B:606:0x1709, B:608:0x1719, B:609:0x171d, B:610:0x170f, B:612:0x1721, B:615:0x1737, B:619:0x1746, B:621:0x1772, B:623:0x1790, B:625:0x17a0, B:626:0x17a4, B:627:0x1796, B:629:0x17a8, B:632:0x17be, B:636:0x17cd, B:638:0x17f9, B:640:0x1817, B:642:0x1827, B:643:0x182b, B:644:0x181d, B:646:0x182f, B:649:0x1845, B:653:0x1856, B:655:0x1882, B:657:0x18a0, B:659:0x18b0, B:660:0x18b4, B:661:0x18a6, B:663:0x18b8, B:666:0x18ce, B:670:0x18de, B:672:0x190a, B:674:0x1928, B:676:0x1938, B:677:0x193c, B:678:0x192e, B:680:0x1940, B:683:0x1956, B:687:0x1966, B:689:0x1992, B:691:0x19b0, B:693:0x19c0, B:694:0x19c4, B:695:0x19b6, B:697:0x19c8, B:700:0x19de, B:704:0x19ee, B:706:0x1a1a, B:708:0x1a38, B:710:0x1a48, B:711:0x1a4c, B:712:0x1a3e, B:714:0x1a50, B:717:0x1a66, B:721:0x1a76, B:723:0x1aa2, B:725:0x1ac0, B:727:0x1ad0, B:728:0x1ad4, B:729:0x1ac6, B:731:0x1ad8, B:734:0x1aee, B:738:0x1afe, B:740:0x1b2a, B:742:0x1b48, B:744:0x1b58, B:745:0x1b5c, B:746:0x1b4e, B:748:0x1b60, B:751:0x1b76, B:755:0x1b86, B:757:0x1bb2, B:759:0x1bd0, B:761:0x1be0, B:762:0x1be4, B:763:0x1bd6, B:765:0x1be8, B:768:0x1bfe, B:772:0x1c0f, B:774:0x1c3b, B:776:0x1c59, B:778:0x1c69, B:779:0x1c6d, B:780:0x1c5f, B:782:0x1c71, B:785:0x1c87, B:789:0x1c98, B:791:0x1cc4, B:793:0x1ce2, B:795:0x1cf2, B:796:0x1cf6, B:797:0x1ce8, B:799:0x1cfa, B:802:0x1d10, B:806:0x1d20, B:808:0x1d4c, B:810:0x1d6a, B:812:0x1d7a, B:813:0x1d7e, B:814:0x1d70, B:816:0x1d82, B:819:0x1d96, B:822:0x1d9a, B:823:0x1da7, B:824:0x1db0, B:827:0x1dc6, B:831:0x1dd7, B:833:0x1e03, B:835:0x1e23, B:836:0x1e2d, B:837:0x1e31, B:839:0x1e35, B:842:0x1e4b, B:846:0x1e5b, B:848:0x1e87, B:850:0x1ea5, B:852:0x1eb5, B:853:0x1eb9, B:854:0x1eab, B:856:0x1ebd, B:859:0x1ed3, B:863:0x1ee3, B:865:0x1f0f, B:867:0x1f2d, B:869:0x1f3d, B:870:0x1f41, B:871:0x1f33, B:873:0x1f45, B:876:0x1f5b, B:880:0x1f6b, B:882:0x1f97, B:884:0x1fb5, B:886:0x1fc5, B:887:0x1fc9, B:888:0x1fbb, B:890:0x1fcd, B:893:0x1fe3, B:897:0x1ff3, B:899:0x201f, B:901:0x203d, B:903:0x204d, B:904:0x2051, B:905:0x2043, B:907:0x2055, B:910:0x206b, B:914:0x207c, B:916:0x20a8, B:918:0x20c6, B:920:0x20d6, B:921:0x20da, B:922:0x20cc, B:924:0x20de, B:927:0x20f4, B:931:0x2104, B:933:0x2130, B:935:0x214e, B:937:0x215e, B:938:0x2162, B:939:0x2154, B:941:0x2166, B:944:0x217c, B:948:0x218c, B:950:0x21b8, B:952:0x21d6, B:954:0x21e6, B:955:0x21ea, B:956:0x21dc, B:958:0x21ee, B:961:0x2204, B:965:0x2214, B:967:0x2240, B:969:0x225e, B:971:0x226e, B:972:0x2272, B:973:0x2264, B:975:0x2276, B:978:0x228c, B:982:0x229c, B:984:0x22c8, B:986:0x22e6, B:988:0x22f6, B:989:0x22fa, B:990:0x22ec, B:992:0x22fe, B:996:0x2342, B:998:0x2346, B:1001:0x234a, B:1002:0x2355, B:1004:0x235a, B:1006:0x237b, B:1008:0x2391, B:1010:0x23ab, B:1012:0x23ce, B:1014:0x23d2, B:1017:0x23d8, B:1018:0x241e, B:1021:0x242d, B:1024:0x243c, B:1026:0x2442, B:1027:0x244c, B:1028:0x245b, B:1031:0x246b, B:1034:0x2474, B:1037:0x247a, B:1040:0x25f0, B:1043:0x248f, B:1045:0x2493, B:1047:0x24b0, B:1049:0x250e, B:1050:0x251d, B:1053:0x252a, B:1055:0x2540, B:1056:0x2543, B:1057:0x254c, B:1058:0x2582, B:1060:0x258b, B:1063:0x2591, B:1065:0x25ce, B:1071:0x2612, B:1073:0x2616, B:1077:0x2626, B:1079:0x2651, B:1081:0x266f, B:1083:0x267f, B:1084:0x2683, B:1086:0x2675, B:1090:0x26a6, B:1092:0x26aa, B:1096:0x26ba, B:1098:0x26e5, B:1100:0x2703, B:1102:0x2713, B:1103:0x2717, B:1104:0x2709, B:1108:0x272c, B:1110:0x2730, B:1114:0x2740, B:1116:0x276b, B:1118:0x2789, B:1120:0x2799, B:1121:0x279d, B:1122:0x278f, B:1126:0x27b2, B:1128:0x27b6, B:1132:0x27c6, B:1134:0x27f1, B:1136:0x280f, B:1138:0x281f, B:1139:0x2823, B:1140:0x2815, B:1144:0x2838, B:1146:0x283c, B:1147:0x2888, B:1150:0x289d, B:1152:0x28a1, B:1153:0x28ed, B:1156:0x2902, B:1158:0x2906, B:1159:0x2952, B:1162:0x2963, B:1164:0x2967, B:1165:0x29a4, B:1169:0x29b9, B:1171:0x29bd, B:1173:0x2a7a, B:1175:0x2a0f, B:1177:0x2a13, B:1180:0x2a94, B:1182:0x2a98, B:1184:0x2b27, B:1186:0x2aeb, B:1188:0x2aef, B:1191:0x2af8, B:1196:0x2b43, B:1198:0x2b47, B:1199:0x2b92, B:1202:0x2ba1, B:1204:0x2ba5, B:1205:0x2bf0, B:1208:0x2c00, B:1210:0x2c04, B:1211:0x2c75, B:1218:0x2c95, B:1220:0x2c99, B:1222:0x2d07, B:1225:0x2ce9, B:1227:0x2ced, B:1230:0x2d18, B:1232:0x2d1c, B:1233:0x2d6c, B:1237:0x2d7f, B:1239:0x2d83, B:1240:0x2e34, B:1242:0x2dd2, B:1244:0x2dd6, B:1247:0x2e47, B:1249:0x2e4b, B:1250:0x2efc, B:1252:0x2e9a, B:1254:0x2e9e, B:1257:0x2f0f, B:1259:0x2f13, B:1260:0x2fc4, B:1262:0x2f62, B:1264:0x2f66, B:1267:0x2fd7, B:1269:0x2fdb, B:1270:0x3027, B:1273:0x303a, B:1275:0x303e, B:1276:0x30ef, B:1277:0x308b, B:1280:0x3091, B:1283:0x3102, B:1285:0x3106, B:1286:0x31c9, B:1288:0x3114, B:1290:0x3118, B:1291:0x3165, B:1294:0x316b, B:1297:0x31d8, B:1299:0x31dc, B:1300:0x3216, B:1304:0x3225, B:1306:0x3229, B:1309:0x322d, B:1310:0x326b, B:1315:0x327d, B:1317:0x3281, B:1318:0x32cd, B:1321:0x32dd, B:1323:0x32e1, B:1325:0x3395, B:1327:0x3331, B:1329:0x3335, B:1332:0x33a9, B:1334:0x33ad, B:1335:0x33f9, B:1338:0x3409, B:1340:0x340d, B:1341:0x3490, B:1343:0x3445, B:1345:0x3449, B:1348:0x34a4, B:1350:0x34a8, B:1351:0x3559, B:1353:0x34f7, B:1355:0x34fb, B:1358:0x356d, B:1360:0x3571, B:1361:0x35bd, B:1364:0x35cd, B:1366:0x35d1, B:1367:0x3654, B:1369:0x3609, B:1371:0x360d, B:1374:0x3668, B:1376:0x366c, B:1377:0x371d, B:1379:0x36bb, B:1381:0x36bf, B:1384:0x3731, B:1386:0x3735, B:1387:0x37e6, B:1389:0x3784, B:1391:0x3788, B:1394:0x37fa, B:1396:0x37fe, B:1397:0x384a, B:1400:0x385e, B:1402:0x3862, B:1403:0x38ae, B:1406:0x38be, B:1408:0x38c2, B:1409:0x3945, B:1411:0x38fa, B:1413:0x38fe, B:1416:0x3959, B:1418:0x395d, B:1419:0x39a9, B:1422:0x39bd, B:1424:0x39c1, B:1426:0x39fa, B:1427:0x3a07, B:1428:0x3a78, B:1430:0x3a16, B:1432:0x3a1a, B:1435:0x3a8c, B:1437:0x3a90, B:1438:0x3aee, B:1441:0x3afe, B:1443:0x3b02, B:1446:0x3b08, B:1447:0x3b81, B:1449:0x3b38, B:1451:0x3b3c, B:1454:0x3b52, B:1457:0x3b95, B:1459:0x3b99, B:1460:0x3c4a, B:1462:0x3be8, B:1464:0x3bec, B:1467:0x3c5e, B:1469:0x3c62, B:1470:0x3cae, B:1473:0x3cc2, B:1475:0x3cc6, B:1476:0x3d12, B:1479:0x3d26, B:1481:0x3d2a, B:1482:0x3d7b, B:1486:0x3d8c, B:1488:0x3d90, B:1489:0x3de0, B:1493:0x3df4, B:1495:0x3df8, B:1496:0x3e44, B:1499:0x3e58, B:1501:0x3e5c, B:1502:0x3f0d, B:1503:0x3ea9, B:1506:0x3eaf, B:1509:0x3f21, B:1511:0x3f25, B:1512:0x3f83, B:1513:0x3f87, B:1516:0x3f9b, B:1517:0x3fad, B:1520:0x3fb3, B:1521:0x3ff4, B:1526:0x4005, B:1528:0x4009, B:1529:0x4059, B:1533:0x406d, B:1535:0x4071, B:1537:0x4123, B:1538:0x40bf, B:1541:0x40c5, B:1544:0x4134, B:1546:0x4138, B:1547:0x4184, B:1550:0x4198, B:1552:0x419c, B:1556:0x41ae, B:1558:0x41da, B:1560:0x43b0, B:1561:0x4210, B:1563:0x4215, B:1564:0x425e, B:1566:0x4264, B:1572:0x427b, B:1573:0x427e, B:1568:0x4275, B:1576:0x42ac, B:1578:0x42b4, B:1581:0x42ba, B:1583:0x42ef, B:1584:0x4314, B:1586:0x42f3, B:1587:0x42f8, B:1589:0x42fe, B:1595:0x4311, B:1591:0x430b, B:1598:0x4342, B:1600:0x4347, B:1601:0x43bc, B:1604:0x43d0, B:1605:0x441f, B:1608:0x442f, B:1610:0x4433, B:1611:0x4483, B:1616:0x4494, B:1618:0x4498, B:1619:0x44e4, B:1622:0x44f6, B:1624:0x44fa, B:1628:0x450d, B:1630:0x453c, B:1632:0x469f, B:1633:0x4571, B:1635:0x4576, B:1636:0x45bf, B:1638:0x45c5, B:1644:0x45dc, B:1645:0x45df, B:1640:0x45d6, B:1648:0x460b, B:1650:0x4611, B:1653:0x4617, B:1655:0x4650, B:1656:0x4675, B:1657:0x4654, B:1658:0x4659, B:1660:0x465f, B:1666:0x4672, B:1662:0x466c, B:1671:0x46b5, B:1673:0x46b9, B:1677:0x46cc, B:1679:0x46fb, B:1681:0x485e, B:1682:0x4730, B:1684:0x4735, B:1685:0x477e, B:1687:0x4784, B:1693:0x479b, B:1694:0x479e, B:1689:0x4795, B:1697:0x47ca, B:1699:0x47d0, B:1702:0x47d6, B:1704:0x480f, B:1705:0x4834, B:1706:0x4813, B:1707:0x4818, B:1709:0x481e, B:1715:0x4831, B:1711:0x482b, B:1720:0x486d, B:1722:0x4871, B:1725:0x4875, B:1726:0x48b2, B:1730:0x48c1, B:1732:0x48c5, B:1735:0x48c9, B:1736:0x4959, B:1737:0x4904, B:1740:0x490b, B:1743:0x4969, B:1745:0x496d, B:1748:0x4971, B:1749:0x49ff, B:1750:0x49ab, B:1753:0x49b1, B:1754:0x4a03, B:1757:0x4a13, B:1758:0x4a28, B:1761:0x4a2e, B:1762:0x4abc, B:1766:0x4a6a, B:1768:0x4a6e, B:1771:0x4a84, B:1772:0x4ac0, B:1775:0x4ad4, B:1776:0x4ae3, B:1778:0x4b23, B:1781:0x4b37, B:1783:0x4b3b, B:1784:0x4beb, B:1786:0x4b8a, B:1788:0x4b8e, B:1789:0x4bef, B:1792:0x4c03, B:1793:0x4c54, B:1796:0x4c59, B:1799:0x4c6a, B:1800:0x4cb7, B:1803:0x4cc7, B:1805:0x4ccb, B:1806:0x4d2a, B:1807:0x4d19, B:1809:0x4d1e, B:1812:0x4d2e, B:1815:0x4d42, B:1816:0x4d93, B:1820:0x4da2, B:1823:0x4da6, B:1826:0x4daf, B:1828:0x4db7, B:1831:0x4dc7, B:1833:0x4dcb, B:1834:0x4e4f, B:1837:0x4e05, B:1839:0x4e09, B:1842:0x4e63, B:1844:0x4e67, B:1845:0x4f17, B:1847:0x4eb6, B:1849:0x4eba, B:1852:0x4f27, B:1854:0x4f2b, B:1855:0x4fab, B:1857:0x4f63, B:1859:0x4f67, B:1862:0x4f7d, B:1865:0x4fbb, B:1867:0x4fbf, B:1870:0x4fd5, B:1871:0x5003, B:1874:0x5017, B:1876:0x501b, B:1877:0x5067, B:1880:0x5077, B:1882:0x507b, B:1885:0x5081, B:1886:0x50af, B:1888:0x50b3, B:1890:0x50be, B:1893:0x50ce, B:1895:0x50d2, B:1898:0x50d8, B:1899:0x5105, B:1902:0x5115, B:1904:0x5119, B:1907:0x511f, B:1908:0x514c, B:1911:0x515c, B:1913:0x5160, B:1916:0x5167, B:1918:0x51bd, B:1921:0x5185, B:1923:0x5189, B:1926:0x518f, B:1929:0x51d0, B:1931:0x51d4, B:1935:0x51f6, B:1937:0x5225, B:1938:0x524b, B:1942:0x525d, B:1944:0x5261, B:1945:0x52ae, B:1948:0x52bf, B:1950:0x52c3, B:1954:0x52e3, B:1956:0x5310, B:1957:0x5332, B:1960:0x5343, B:1962:0x5347, B:1966:0x5367, B:1968:0x5395, B:1969:0x53b7, B:1972:0x53c8, B:1974:0x53cc, B:1978:0x53ec, B:1980:0x541a, B:1981:0x543c, B:1984:0x544d, B:1986:0x5451, B:1990:0x5471, B:1992:0x549f, B:1993:0x54c1, B:1996:0x54d2, B:1998:0x54d6, B:2002:0x54f6, B:2004:0x5524, B:2005:0x5546, B:2008:0x5557, B:2010:0x555b, B:2011:0x5573, B:2014:0x5585, B:2016:0x5589, B:2017:0x55d6, B:2020:0x55e8, B:2022:0x55ec, B:2025:0x55f2, B:2026:0x5637, B:2031:0x5656, B:2033:0x565a, B:2034:0x56ab, B:2039:0x56bf, B:2041:0x56c3, B:2044:0x56c9, B:2047:0x56d2, B:2050:0x56f9, B:2051:0x5710, B:2057:0x572e, B:2059:0x5734, B:2060:0x5777, B:2064:0x578b, B:2066:0x578f, B:2069:0x5795, B:2070:0x57c5, B:2075:0x57dd, B:2077:0x57e1, B:2081:0x57f4, B:2083:0x5821, B:2084:0x5a47, B:2085:0x585d, B:2087:0x5887, B:2089:0x5891, B:2090:0x58e5, B:2092:0x58eb, B:2098:0x5902, B:2099:0x5905, B:2094:0x58fc, B:2102:0x5934, B:2104:0x5946, B:2107:0x594c, B:2109:0x5982, B:2110:0x59a7, B:2112:0x5986, B:2113:0x598b, B:2115:0x5991, B:2121:0x59a4, B:2117:0x599e, B:2124:0x59d6, B:2126:0x59db, B:2129:0x5a5c, B:2131:0x5a62, B:2133:0x5a9d, B:2134:0x5ab4, B:2136:0x5b21, B:2139:0x5abd, B:2141:0x5ac1, B:2145:0x5b37, B:2147:0x5b3b, B:2148:0x5b87, B:2151:0x5b97, B:2153:0x5b9b, B:2156:0x5b9f, B:2157:0x5c30, B:2158:0x5bdb, B:2161:0x5be2, B:2164:0x5c45, B:2166:0x5c49, B:2167:0x5cfc, B:2169:0x5c98, B:2171:0x5c9c, B:2172:0x5d00, B:2175:0x5d72, B:2177:0x5d76, B:2178:0x5dc4, B:2181:0x5dd5, B:2182:0x5dea, B:2185:0x5df0, B:2187:0x5dfd, B:2188:0x5e02, B:2193:0x5e44, B:2195:0x5e48, B:2196:0x5e66, B:2199:0x5e6b, B:2200:0x5e79, B:2203:0x5e8b, B:2206:0x5e94, B:2210:0x5ec5, B:2212:0x5ec9, B:2221:0x5f00, B:2222:0x6026, B:2223:0x602b, B:2224:0x5f05, B:2225:0x5f36, B:2226:0x5f66, B:2227:0x5f96, B:2228:0x5fc5, B:2230:0x5fef, B:2232:0x5ff5, B:2234:0x5ffb, B:2235:0x600e), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void handleData(byte[] r66) {
        /*
            Method dump skipped, instructions count: 25226
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.szabh.smable3.component.BleConnector.handleData(byte[]):void");
    }

    public final BleConnector init(Context context, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, int i) {
        mSupportFilterEmpty = z5;
        setMMtu(i);
        super.init(context, new com.bestmafen.baseble.connector.I0Io() { // from class: com.szabh.smable3.component.BleConnector$init$1
            @Override // com.bestmafen.baseble.connector.I0Io
            public void onCharacteristicChanged(@OOXIXo byte[] value) {
                IIX0o.x0xO0oo(value, "value");
                BleConnector.INSTANCE.handleData(value);
            }

            @Override // com.bestmafen.baseble.connector.I0Io
            public void onCharacteristicRead(@OOXIXo String characteristicUuid, @OOXIXo byte[] value, @OOXIXo String text) {
                IIX0o.x0xO0oo(characteristicUuid, "characteristicUuid");
                IIX0o.x0xO0oo(value, "value");
                IIX0o.x0xO0oo(text, "text");
                if (IIX0o.Oxx0IOOO(characteristicUuid, BleConnector.CH_MTK_OTA_META)) {
                    BleCache.INSTANCE.putMtkOtaMeta(text);
                    BleConnector.INSTANCE.notifyHandlers(new Oox.oOoXoXO<BleHandleCallback, oXIO0o0XI>() { // from class: com.szabh.smable3.component.BleConnector$init$1$onCharacteristicRead$1
                        @Override // Oox.oOoXoXO
                        public /* bridge */ /* synthetic */ oXIO0o0XI invoke(BleHandleCallback bleHandleCallback) {
                            invoke2(bleHandleCallback);
                            return oXIO0o0XI.f29392oIX0oI;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@OOXIXo BleHandleCallback it) {
                            IIX0o.x0xO0oo(it, "it");
                            it.onReadMtkOtaMeta();
                        }
                    });
                }
            }

            @Override // com.bestmafen.baseble.connector.I0Io
            public void onCharacteristicWrite(@OOXIXo String characteristicUuid, @OOXIXo byte[] value) {
                int i2;
                IIX0o.x0xO0oo(characteristicUuid, "characteristicUuid");
                IIX0o.x0xO0oo(value, "value");
                if (IIX0o.Oxx0IOOO(characteristicUuid, "c6a22924-f821-18bf-9704-0266f20e80fd")) {
                    BleConnector bleConnector = BleConnector.INSTANCE;
                    i2 = BleConnector.mStreamProgressCompleted;
                    BleConnector.mStreamProgressCompleted = i2 + 1;
                    bleConnector.checkStreamProgress();
                }
            }

            @Override // com.bestmafen.baseble.connector.I0Io
            public void onConnectionStateChange(boolean z6) {
                List list;
                BleStream bleStream;
                List list2;
                List list3;
                String mTargetAddress;
                final BluetoothDevice remoteDevice;
                if (z6) {
                    BleConnector bleConnector = BleConnector.INSTANCE;
                    BluetoothGatt mBluetoothGatt = bleConnector.getMBluetoothGatt();
                    if (mBluetoothGatt == null || (remoteDevice = mBluetoothGatt.getDevice()) == null) {
                        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                        mTargetAddress = bleConnector.getMTargetAddress();
                        remoteDevice = defaultAdapter.getRemoteDevice(mTargetAddress);
                    }
                    OI0.oIX0oI.f1507oIX0oI.oIX0oI("BleConnector onDeviceConnected -> " + remoteDevice);
                    BleConnector.mBleState = 0;
                    bleConnector.notifyHandlers(new Oox.oOoXoXO<BleHandleCallback, oXIO0o0XI>() { // from class: com.szabh.smable3.component.BleConnector$init$1$onConnectionStateChange$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // Oox.oOoXoXO
                        public /* bridge */ /* synthetic */ oXIO0o0XI invoke(BleHandleCallback bleHandleCallback) {
                            invoke2(bleHandleCallback);
                            return oXIO0o0XI.f29392oIX0oI;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@OOXIXo BleHandleCallback it) {
                            IIX0o.x0xO0oo(it, "it");
                            BluetoothDevice device = remoteDevice;
                            IIX0o.oO(device, "$device");
                            it.onDeviceConnected(device);
                        }
                    });
                    BleConnector.mStreamProgressTotal = -1;
                    BleConnector.mStreamProgressCompleted = -1;
                } else {
                    OI0.oIX0oI.f1507oIX0oI.oIX0oI("BleConnector onSessionStateChange -> false");
                    BleConnector bleConnector2 = BleConnector.INSTANCE;
                    BleConnector.mBleState = -1;
                    bleConnector2.notifyHandlers(new Oox.oOoXoXO<BleHandleCallback, oXIO0o0XI>() { // from class: com.szabh.smable3.component.BleConnector$init$1$onConnectionStateChange$2
                        @Override // Oox.oOoXoXO
                        public /* bridge */ /* synthetic */ oXIO0o0XI invoke(BleHandleCallback bleHandleCallback) {
                            invoke2(bleHandleCallback);
                            return oXIO0o0XI.f29392oIX0oI;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@OOXIXo BleHandleCallback it) {
                            IIX0o.x0xO0oo(it, "it");
                            it.onSessionStateChange(false);
                        }
                    });
                    list = BleConnector.mDataKeys;
                    if (!list.isEmpty()) {
                        list2 = BleConnector.mDataKeys;
                        bleConnector2.notifySyncState(-2, (BleKey) list2.get(0));
                        list3 = BleConnector.mDataKeys;
                        list3.clear();
                        bleConnector2.removeSyncTimeout();
                    }
                    bleStream = BleConnector.mBleStream;
                    if (bleStream != null) {
                        bleConnector2.notifyHandlers(new Oox.oOoXoXO<BleHandleCallback, oXIO0o0XI>() { // from class: com.szabh.smable3.component.BleConnector$init$1$onConnectionStateChange$3
                            @Override // Oox.oOoXoXO
                            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(BleHandleCallback bleHandleCallback) {
                                invoke2(bleHandleCallback);
                                return oXIO0o0XI.f29392oIX0oI;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@OOXIXo BleHandleCallback it) {
                                IIX0o.x0xO0oo(it, "it");
                                BleHandleCallback.DefaultImpls.onStreamProgress$default(it, false, -1, 0, 0, null, 16, null);
                            }
                        });
                    }
                    bleConnector2.checkStreamProgress();
                }
                BleConnector.INSTANCE.setMBleStream(null);
            }

            @Override // com.bestmafen.baseble.connector.I0Io
            public void onMtuChanged() {
                boolean z6;
                boolean z7;
                BleConnector bleConnector = BleConnector.INSTANCE;
                BleConnector.mBleState = 1;
                z6 = BleConnector.isNordicOtaMode;
                if (z6) {
                    if (bleConnector.isNeedBind()) {
                        bleConnector.sendOta();
                        return;
                    }
                    return;
                }
                BleDeviceInfo mDeviceInfo = BleCache.INSTANCE.getMDeviceInfo();
                if (mDeviceInfo != null) {
                    z7 = BleConnector.isRefreshDeviceInfo;
                    if (!z7) {
                        OI0.oIX0oI.f1507oIX0oI.XO("BleConnector DeviceInfo not null -> login");
                        if (IIX0o.Oxx0IOOO(mDeviceInfo.getMPlatform(), BleDeviceInfo.PLATFORM_SIFLI)) {
                            bleConnector.setRefreshDeviceCache(true);
                        }
                        bleConnector.login(mDeviceInfo.getMId());
                        return;
                    }
                }
                OI0.oIX0oI.f1507oIX0oI.XO("BleConnector DeviceInfo is null or needs to be refreshed -> bind");
                if (bleConnector.isNeedBind()) {
                    bleConnector.bind();
                }
            }
        });
        BleCache bleCache = BleCache.INSTANCE;
        bleCache.setMDeviceInfo((BleDeviceInfo) BleCache.getObject$default(bleCache, BleKey.IDENTITY, BleDeviceInfo.class, null, 4, null));
        if (z4) {
            launch();
        }
        if (z && Build.VERSION.SDK_INT >= 26 && OI0.I0Io.oIX0oI("no.nordicsemi.android.dfu.DfuServiceInitiator") != null) {
            DfuServiceInitiator.createDfuNotificationChannel(getMContext());
        }
        if (z2) {
            RtkCore.initialize(context, new RtkConfigure.Builder().debugEnabled(false).printLog(false).logTag("RealtekDfu").build());
            RtkDfu.initialize(context, false);
        }
        return this;
    }

    public final void login(int i) {
        sendInt32$default(this, BleKey.SESSION, BleKeyFlag.CREATE, i, null, false, false, 56, null);
    }

    public static final void mSyncTimeout$lambda$0() {
        if (!mDataKeys.isEmpty()) {
            INSTANCE.notifySyncState(-1, mDataKeys.get(0));
            mDataKeys.clear();
        } else {
            INSTANCE.notifySyncState(-1, BleKey.NONE);
        }
    }

    public final void notifyHandlers(final Oox.oOoXoXO<? super BleHandleCallback, oXIO0o0XI> oooxoxo) {
        getMHandler().post(new Runnable() { // from class: com.szabh.smable3.component.II0xO0
            @Override // java.lang.Runnable
            public final void run() {
                BleConnector.notifyHandlers$lambda$208(Oox.oOoXoXO.this);
            }
        });
    }

    public static final void notifyHandlers$lambda$208(Oox.oOoXoXO action) {
        IIX0o.x0xO0oo(action, "$action");
        for (BleHandleCallback bleHandleCallback : INSTANCE.getMBleHandleCallbacks()) {
            IIX0o.ooOOo0oXI(bleHandleCallback);
            action.invoke(bleHandleCallback);
        }
    }

    private final void notifyHandlersThen(final Oox.oOoXoXO<? super BleHandleCallback, oXIO0o0XI> oooxoxo, final Oox.oIX0oI<oXIO0o0XI> oix0oi) {
        getMHandler().post(new Runnable() { // from class: com.szabh.smable3.component.I0Io
            @Override // java.lang.Runnable
            public final void run() {
                BleConnector.notifyHandlersThen$lambda$210(Oox.oIX0oI.this, oooxoxo);
            }
        });
    }

    public static final void notifyHandlersThen$lambda$210(Oox.oIX0oI then, Oox.oOoXoXO action) {
        IIX0o.x0xO0oo(then, "$then");
        IIX0o.x0xO0oo(action, "$action");
        for (BleHandleCallback bleHandleCallback : INSTANCE.getMBleHandleCallbacks()) {
            IIX0o.ooOOo0oXI(bleHandleCallback);
            action.invoke(bleHandleCallback);
        }
        then.invoke();
    }

    public final void notifySyncState(final int i, final BleKey bleKey) {
        OI0.oIX0oI.f1507oIX0oI.XO("BleConnector onSyncData -> " + SyncState.INSTANCE.getState(i) + ", " + bleKey);
        notifyHandlers(new Oox.oOoXoXO<BleHandleCallback, oXIO0o0XI>() { // from class: com.szabh.smable3.component.BleConnector$notifySyncState$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(BleHandleCallback bleHandleCallback) {
                invoke2(bleHandleCallback);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OOXIXo BleHandleCallback it) {
                IIX0o.x0xO0oo(it, "it");
                it.onSyncData(i, bleKey);
            }
        });
    }

    private final void postDelaySyncTimeout() {
        removeSyncTimeout();
        getMHandler().postDelayed(mSyncTimeout, AbsBleConnector.TIMEOUT);
    }

    private final void removeBond(String str) {
        if ((Build.VERSION.SDK_INT >= 31 && ContextCompat.checkSelfPermission(getMContext(), "android.permission.BLUETOOTH_CONNECT") != 0) || !BluetoothAdapter.checkBluetoothAddress(str)) {
            return;
        }
        for (BluetoothDevice bluetoothDevice : BluetoothAdapter.getDefaultAdapter().getBondedDevices()) {
            if (OxI.oX0I0O(bluetoothDevice.getAddress(), str, true)) {
                try {
                    Object invoke = bluetoothDevice.getClass().getMethod("removeBond", null).invoke(bluetoothDevice, null);
                    OI0.oIX0oI.f1507oIX0oI.XO("BleConnector removeBond -> " + invoke);
                    return;
                } catch (Exception e) {
                    OI0.oIX0oI.f1507oIX0oI.Oxx0IOOO("BleConnector removeBond -> " + e);
                    return;
                }
            }
        }
    }

    public final void removeSyncTimeout() {
        getMHandler().removeCallbacks(mSyncTimeout);
    }

    public static /* synthetic */ boolean sendBoolean$default(BleConnector bleConnector, BleKey bleKey, BleKeyFlag bleKeyFlag, boolean z, boolean z2, boolean z3, int i, Object obj) {
        boolean z4;
        boolean z5;
        if ((i & 8) != 0) {
            z4 = false;
        } else {
            z4 = z2;
        }
        if ((i & 16) != 0) {
            z5 = false;
        } else {
            z5 = z3;
        }
        return bleConnector.sendBoolean(bleKey, bleKeyFlag, z, z4, z5);
    }

    public static /* synthetic */ boolean sendData$default(BleConnector bleConnector, BleKey bleKey, BleKeyFlag bleKeyFlag, byte[] bArr, boolean z, boolean z2, int i, Object obj) {
        boolean z3;
        boolean z4;
        if ((i & 4) != 0) {
            bArr = null;
        }
        byte[] bArr2 = bArr;
        if ((i & 8) != 0) {
            z3 = false;
        } else {
            z3 = z;
        }
        if ((i & 16) != 0) {
            z4 = false;
        } else {
            z4 = z2;
        }
        return bleConnector.sendData(bleKey, bleKeyFlag, bArr2, z3, z4);
    }

    public static /* synthetic */ boolean sendInt16$default(BleConnector bleConnector, BleKey bleKey, BleKeyFlag bleKeyFlag, int i, ByteOrder BIG_ENDIAN, boolean z, boolean z2, int i2, Object obj) {
        boolean z3;
        boolean z4;
        if ((i2 & 8) != 0) {
            BIG_ENDIAN = ByteOrder.BIG_ENDIAN;
            IIX0o.oO(BIG_ENDIAN, "BIG_ENDIAN");
        }
        ByteOrder byteOrder = BIG_ENDIAN;
        if ((i2 & 16) != 0) {
            z3 = false;
        } else {
            z3 = z;
        }
        if ((i2 & 32) != 0) {
            z4 = false;
        } else {
            z4 = z2;
        }
        return bleConnector.sendInt16(bleKey, bleKeyFlag, i, byteOrder, z3, z4);
    }

    public static /* synthetic */ boolean sendInt24$default(BleConnector bleConnector, BleKey bleKey, BleKeyFlag bleKeyFlag, int i, ByteOrder BIG_ENDIAN, boolean z, boolean z2, int i2, Object obj) {
        boolean z3;
        boolean z4;
        if ((i2 & 8) != 0) {
            BIG_ENDIAN = ByteOrder.BIG_ENDIAN;
            IIX0o.oO(BIG_ENDIAN, "BIG_ENDIAN");
        }
        ByteOrder byteOrder = BIG_ENDIAN;
        if ((i2 & 16) != 0) {
            z3 = false;
        } else {
            z3 = z;
        }
        if ((i2 & 32) != 0) {
            z4 = false;
        } else {
            z4 = z2;
        }
        return bleConnector.sendInt24(bleKey, bleKeyFlag, i, byteOrder, z3, z4);
    }

    public static /* synthetic */ boolean sendInt32$default(BleConnector bleConnector, BleKey bleKey, BleKeyFlag bleKeyFlag, int i, ByteOrder BIG_ENDIAN, boolean z, boolean z2, int i2, Object obj) {
        boolean z3;
        boolean z4;
        if ((i2 & 8) != 0) {
            BIG_ENDIAN = ByteOrder.BIG_ENDIAN;
            IIX0o.oO(BIG_ENDIAN, "BIG_ENDIAN");
        }
        ByteOrder byteOrder = BIG_ENDIAN;
        if ((i2 & 16) != 0) {
            z3 = false;
        } else {
            z3 = z;
        }
        if ((i2 & 32) != 0) {
            z4 = false;
        } else {
            z4 = z2;
        }
        return bleConnector.sendInt32(bleKey, bleKeyFlag, i, byteOrder, z3, z4);
    }

    public static /* synthetic */ boolean sendInt8$default(BleConnector bleConnector, BleKey bleKey, BleKeyFlag bleKeyFlag, int i, boolean z, boolean z2, int i2, Object obj) {
        boolean z3;
        boolean z4;
        if ((i2 & 8) != 0) {
            z3 = false;
        } else {
            z3 = z;
        }
        if ((i2 & 16) != 0) {
            z4 = false;
        } else {
            z4 = z2;
        }
        return bleConnector.sendInt8(bleKey, bleKeyFlag, i, z3, z4);
    }

    public static /* synthetic */ boolean sendList$default(BleConnector bleConnector, BleKey bleKey, BleKeyFlag bleKeyFlag, List list, boolean z, boolean z2, int i, Object obj) {
        boolean z3;
        boolean z4;
        if ((i & 8) != 0) {
            z3 = false;
        } else {
            z3 = z;
        }
        if ((i & 16) != 0) {
            z4 = false;
        } else {
            z4 = z2;
        }
        return bleConnector.sendList(bleKey, bleKeyFlag, list, z3, z4);
    }

    public static /* synthetic */ boolean sendObject$default(BleConnector bleConnector, BleKey bleKey, BleKeyFlag bleKeyFlag, BleBuffer bleBuffer, boolean z, boolean z2, int i, Object obj) {
        boolean z3;
        boolean z4;
        if ((i & 8) != 0) {
            z3 = false;
        } else {
            z3 = z;
        }
        if ((i & 16) != 0) {
            z4 = false;
        } else {
            z4 = z2;
        }
        return bleConnector.sendObject(bleKey, bleKeyFlag, bleBuffer, z3, z4);
    }

    public final void sendOta() {
        sendData$default(this, BleKey.OTA, BleKeyFlag.UPDATE, null, false, false, 28, null);
    }

    public static /* synthetic */ boolean sendStream$default(BleConnector bleConnector, BleKey bleKey, byte[] bArr, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return bleConnector.sendStream(bleKey, bArr, i);
    }

    public final void setMBleStream(BleStream bleStream) {
        boolean z;
        mBleStream = bleStream;
        if (bleStream != null) {
            z = true;
        } else {
            z = false;
        }
        setDisableStreamLog(z);
    }

    private final boolean syncData() {
        List<Integer> mDataKeys2 = BleCache.INSTANCE.getMDataKeys();
        ArrayList arrayList = new ArrayList();
        for (Object obj : mDataKeys2) {
            if (((Number) obj).intValue() != BleKey.DATA_ALL.getMKey()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(OxxIIOOXO.xo0x(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(BleKey.Companion.oIX0oI(((Number) it.next()).intValue()));
        }
        List<BleKey> o0Xo0XII = CollectionsKt___CollectionsKt.o0Xo0XII(arrayList2);
        mDataKeys = o0Xo0XII;
        if (o0Xo0XII.isEmpty()) {
            notifySyncState(0, BleKey.NONE);
            return true;
        }
        postDelaySyncTimeout();
        return sendData$default(this, mDataKeys.get(0), BleKeyFlag.READ, null, false, false, 28, null);
    }

    public final void addHandleCallback(@OOXIXo BleHandleCallback bleHandleCallback) {
        IIX0o.x0xO0oo(bleHandleCallback, "bleHandleCallback");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("BleConnector addHandleCallback -> " + bleHandleCallback);
        if (!isHandlerCallbackExist(bleHandleCallback)) {
            getMBleHandleCallbacks().add(bleHandleCallback);
        }
    }

    public final void connectClassic() {
        connectClassic(BleCache.INSTANCE.getMClassicAddress());
    }

    public final void connectHID() {
        Boolean createBond = createBond(BleCache.INSTANCE.getMBleAddress());
        OI0.oIX0oI.f1507oIX0oI.XO("connectHID -> " + createBond);
    }

    public final int getMHidState() {
        return mHidState;
    }

    @Override // com.bestmafen.baseble.connector.AbsBleConnector
    @OOXIXo
    public String getMNotify() {
        return (String) mNotify$delegate.getValue();
    }

    @Override // com.bestmafen.baseble.connector.AbsBleConnector
    @OOXIXo
    public String getMService() {
        return (String) mService$delegate.getValue();
    }

    public final boolean isAvailable() {
        if (mBleState >= 1) {
            return true;
        }
        return false;
    }

    public final boolean isBound() {
        if (BleCache.INSTANCE.getMDeviceInfo() != null) {
            return true;
        }
        return false;
    }

    public final boolean isBoundClassic() {
        return isBoundClassic(BleCache.INSTANCE.getMClassicAddress());
    }

    public final boolean isBoundHID() {
        return isBoundHID(BleCache.INSTANCE.getMBleAddress());
    }

    @Override // com.bestmafen.baseble.connector.AbsBleConnector
    public boolean isConnecting() {
        return isConnecting;
    }

    public final boolean isHandlerCallbackExist(@OOXIXo BleHandleCallback bleHandleCallback) {
        IIX0o.x0xO0oo(bleHandleCallback, "bleHandleCallback");
        return getMBleHandleCallbacks().contains(bleHandleCallback);
    }

    public final boolean isNeedBind() {
        return isNeedBind;
    }

    public final boolean isSendStream() {
        if (mBleStream != null) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0024, code lost:
    
        if (r1 != 0) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void launch() {
        /*
            r5 = this;
            com.szabh.smable3.component.BleCache r0 = com.szabh.smable3.component.BleCache.INSTANCE
            com.szabh.smable3.entity.BleDeviceInfo r1 = r0.getMDeviceInfo()
            if (r1 == 0) goto L72
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 31
            if (r1 < r2) goto L2e
            android.content.Context r1 = r5.getMContext()
            java.lang.String r2 = "android.permission.BLUETOOTH_SCAN"
            int r1 = androidx.core.app.IXxxXO.oIX0oI(r1, r2)
            if (r1 != 0) goto L26
            android.content.Context r1 = r5.getMContext()
            java.lang.String r2 = "android.permission.BLUETOOTH_CONNECT"
            int r1 = androidx.core.app.IXxxXO.oIX0oI(r1, r2)
            if (r1 == 0) goto L2e
        L26:
            OI0.oIX0oI r0 = OI0.oIX0oI.f1507oIX0oI
            java.lang.String r1 = "BleConnector launch -> Need new bluetooth permission!!!"
            r0.II0xO0(r1)
            return
        L2e:
            com.szabh.smable3.entity.BleDeviceInfo r1 = r0.getMDeviceInfo()
            if (r1 == 0) goto L39
            java.lang.String r1 = r1.getMPlatform()
            goto L3a
        L39:
            r1 = 0
        L3a:
            java.lang.String r2 = "SIFLI"
            boolean r1 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r1, r2)
            r2 = 1
            if (r1 == 0) goto L46
            r5.setRefreshDeviceCache(r2)
        L46:
            OI0.oIX0oI r1 = OI0.oIX0oI.f1507oIX0oI
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "BleConnector launch -> deviceInfo="
            r3.append(r4)
            com.szabh.smable3.entity.BleDeviceInfo r4 = r0.getMDeviceInfo()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r1.oIX0oI(r3)
            com.szabh.smable3.entity.BleDeviceInfo r0 = r0.getMDeviceInfo()
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(r0)
            java.lang.String r0 = r0.getMBleAddress()
            r5.setAddress(r0)
            r5.connect(r2)
            goto L79
        L72:
            OI0.oIX0oI r0 = OI0.oIX0oI.f1507oIX0oI
            java.lang.String r1 = "BleConnector launch -> deviceInfo=null"
            r0.oIX0oI(r1)
        L79:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.szabh.smable3.component.BleConnector.launch():void");
    }

    public final void mtkOta(@OOXIXo byte[] bytes) {
        int length;
        IIX0o.x0xO0oo(bytes, "bytes");
        if (isAvailable() && bytes.length != 0) {
            if (bytes.length % 180 == 0) {
                length = bytes.length / 180;
            } else {
                length = (bytes.length / 180) + 1;
            }
            mStreamProgressTotal = length;
            mStreamProgressCompleted = 0;
            BleMessenger mBleMessenger = getMBleMessenger();
            int length2 = bytes.length;
            ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
            IIX0o.oO(LITTLE_ENDIAN, "LITTLE_ENDIAN");
            mBleMessenger.enqueueWritePackets(new II0XooXoX(SERVICE_MTK_OTA, CH_MTK_OTA_SIZE, ByteArrayExtKt.byteArrayOfInt32(length2, LITTLE_ENDIAN)));
            getMBleMessenger().enqueueWritePackets(new II0XooXoX(SERVICE_MTK_OTA, CH_MTK_OTA_FLAG, new byte[]{1}));
            int i = mStreamProgressTotal;
            int i2 = 0;
            while (i2 < i) {
                int i3 = i2 + 1;
                getMBleMessenger().enqueueWritePackets(new II0XooXoX(SERVICE_MTK_OTA, CH_MTK_OTA_DATA, ArraysKt___ArraysKt.oIoIxO0(bytes, IIXOooo.X00xOoXI(i2 * 180, Math.min(i3 * 180, bytes.length)))));
                i2 = i3;
            }
            getMBleMessenger().enqueueWritePackets(new II0XooXoX(SERVICE_MTK_OTA, CH_MTK_OTA_FLAG, new byte[]{2}));
            BleMessenger mBleMessenger2 = getMBleMessenger();
            byte[] bytes2 = "b3b27696771768c6648f237a43c37a39".getBytes(oxoX.f29581II0xO0);
            IIX0o.oO(bytes2, "getBytes(...)");
            mBleMessenger2.enqueueWritePackets(new II0XooXoX(SERVICE_MTK_OTA, CH_MTK_OTA_MD5, bytes2));
            return;
        }
        notifyHandlers(new Oox.oOoXoXO<BleHandleCallback, oXIO0o0XI>() { // from class: com.szabh.smable3.component.BleConnector$mtkOta$1
            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(BleHandleCallback bleHandleCallback) {
                invoke2(bleHandleCallback);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OOXIXo BleHandleCallback it) {
                IIX0o.x0xO0oo(it, "it");
                BleHandleCallback.DefaultImpls.onStreamProgress$default(it, false, -1, 0, 0, null, 16, null);
            }
        });
    }

    public final boolean read(@OOXIXo String service, @OOXIXo String characteristic) {
        IIX0o.x0xO0oo(service, "service");
        IIX0o.x0xO0oo(characteristic, "characteristic");
        if (!isAvailable()) {
            return false;
        }
        getMBleMessenger().enqueueMessage(new X0o0xo(service, characteristic));
        return true;
    }

    public final void removeHandleCallback(@OOXIXo BleHandleCallback bleHandleCallback) {
        IIX0o.x0xO0oo(bleHandleCallback, "bleHandleCallback");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("BleConnector removeHandleCallback -> " + bleHandleCallback);
        if (isHandlerCallbackExist(bleHandleCallback)) {
            getMBleHandleCallbacks().remove(bleHandleCallback);
        }
    }

    public final void removeHandleCallbackAll() {
        getMBleHandleCallbacks().clear();
    }

    public final boolean sendBoolean(@OOXIXo BleKey bleKey, @OOXIXo BleKeyFlag bleKeyFlag, boolean z, boolean z2, boolean z3) {
        IIX0o.x0xO0oo(bleKey, "bleKey");
        IIX0o.x0xO0oo(bleKeyFlag, "bleKeyFlag");
        boolean sendData = sendData(bleKey, bleKeyFlag, ByteArrayExtKt.byteArrayOfBoolean(z), z2, z3);
        if (sendData) {
            BleCache bleCache = BleCache.INSTANCE;
            if (bleCache.requireCache(bleKey, bleKeyFlag)) {
                BleCache.putBoolean$default(bleCache, bleKey, z, null, 4, null);
            }
        }
        return sendData;
    }

    public final boolean sendData(@OOXIXo BleKey bleKey, @OOXIXo BleKeyFlag bleKeyFlag, @oOoXoXO byte[] bArr, boolean z, boolean z2) {
        IIX0o.x0xO0oo(bleKey, "bleKey");
        IIX0o.x0xO0oo(bleKeyFlag, "bleKeyFlag");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("BleConnector sendData -> " + bleKey + ", " + bleKeyFlag);
        int i = 0;
        if (!isAvailable()) {
            return false;
        }
        if (bleKey == BleKey.DATA_ALL && bleKeyFlag == BleKeyFlag.READ) {
            return syncData();
        }
        if (z) {
            i = 16;
        }
        if (z2) {
            i |= 32;
        }
        II0XooXoX iI0XooXoX = new II0XooXoX(BLE_SERVICE, BLE_CH_WRITE, MessageFactory.INSTANCE.create(i, bleKey, bleKeyFlag, bArr));
        if (z) {
            INSTANCE.getMBleMessenger().replyMessage(iI0XooXoX);
            return true;
        }
        INSTANCE.getMBleMessenger().enqueueMessage(iI0XooXoX);
        return true;
    }

    public final boolean sendInt16(@OOXIXo BleKey bleKey, @OOXIXo BleKeyFlag bleKeyFlag, int i, @OOXIXo ByteOrder order, boolean z, boolean z2) {
        IIX0o.x0xO0oo(bleKey, "bleKey");
        IIX0o.x0xO0oo(bleKeyFlag, "bleKeyFlag");
        IIX0o.x0xO0oo(order, "order");
        boolean sendData = sendData(bleKey, bleKeyFlag, ByteArrayExtKt.byteArrayOfInt16(i, order), z, z2);
        if (sendData) {
            BleCache bleCache = BleCache.INSTANCE;
            if (bleCache.requireCache(bleKey, bleKeyFlag)) {
                BleCache.putInt$default(bleCache, bleKey, i, null, 4, null);
            }
        }
        return sendData;
    }

    public final boolean sendInt24(@OOXIXo BleKey bleKey, @OOXIXo BleKeyFlag bleKeyFlag, int i, @OOXIXo ByteOrder order, boolean z, boolean z2) {
        IIX0o.x0xO0oo(bleKey, "bleKey");
        IIX0o.x0xO0oo(bleKeyFlag, "bleKeyFlag");
        IIX0o.x0xO0oo(order, "order");
        boolean sendData = sendData(bleKey, bleKeyFlag, ByteArrayExtKt.byteArrayOfInt24(i, order), z, z2);
        if (sendData) {
            BleCache bleCache = BleCache.INSTANCE;
            if (bleCache.requireCache(bleKey, bleKeyFlag)) {
                BleCache.putInt$default(bleCache, bleKey, i, null, 4, null);
            }
        }
        return sendData;
    }

    public final boolean sendInt32(@OOXIXo BleKey bleKey, @OOXIXo BleKeyFlag bleKeyFlag, int i, @OOXIXo ByteOrder order, boolean z, boolean z2) {
        IIX0o.x0xO0oo(bleKey, "bleKey");
        IIX0o.x0xO0oo(bleKeyFlag, "bleKeyFlag");
        IIX0o.x0xO0oo(order, "order");
        boolean sendData = sendData(bleKey, bleKeyFlag, ByteArrayExtKt.byteArrayOfInt32(i, order), z, z2);
        if (sendData) {
            BleCache bleCache = BleCache.INSTANCE;
            if (bleCache.requireCache(bleKey, bleKeyFlag)) {
                BleCache.putInt$default(bleCache, bleKey, i, null, 4, null);
            }
        }
        return sendData;
    }

    public final boolean sendInt8(@OOXIXo BleKey bleKey, @OOXIXo BleKeyFlag bleKeyFlag, int i, boolean z, boolean z2) {
        IIX0o.x0xO0oo(bleKey, "bleKey");
        IIX0o.x0xO0oo(bleKeyFlag, "bleKeyFlag");
        boolean sendData = sendData(bleKey, bleKeyFlag, ByteArrayExtKt.byteArrayOfInt8(i), z, z2);
        if (sendData) {
            BleCache bleCache = BleCache.INSTANCE;
            if (bleCache.requireCache(bleKey, bleKeyFlag)) {
                if (bleKey.isIdObjectKey()) {
                    List<BleIdObject> idObjects = bleCache.getIdObjects(bleKey);
                    if (bleKeyFlag == BleKeyFlag.DELETE) {
                        if (i == 255) {
                            idObjects.clear();
                        } else {
                            Iterator<BleIdObject> it = idObjects.iterator();
                            int i2 = 0;
                            while (true) {
                                if (it.hasNext()) {
                                    if (it.next().getMId() == i) {
                                        break;
                                    }
                                    i2++;
                                } else {
                                    i2 = -1;
                                    break;
                                }
                            }
                            if (i2 > -1) {
                                idObjects.remove(i2);
                            }
                        }
                    }
                    BleCache.putList$default(BleCache.INSTANCE, bleKey, idObjects, null, 4, null);
                } else {
                    BleCache.putInt$default(bleCache, bleKey, i, null, 4, null);
                }
            }
        }
        return sendData;
    }

    public final boolean sendList(@OOXIXo BleKey bleKey, @OOXIXo BleKeyFlag bleKeyFlag, @oOoXoXO List<? extends BleBuffer> list, boolean z, boolean z2) {
        List list2;
        BleKeyFlag bleKeyFlag2;
        IIX0o.x0xO0oo(bleKey, "bleKey");
        IIX0o.x0xO0oo(bleKeyFlag, "bleKeyFlag");
        int i = 0;
        if (!isAvailable()) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        byte[] bArr = null;
        if (bleKey.isIdObjectKey()) {
            list2 = BleCache.INSTANCE.getIdObjects(bleKey);
            if (bleKeyFlag == BleKeyFlag.CREATE) {
                List list3 = list2;
                ArrayList arrayList2 = new ArrayList(OxxIIOOXO.xo0x(list3, 10));
                Iterator it = list3.iterator();
                while (it.hasNext()) {
                    arrayList2.add(Integer.valueOf(((BleIdObject) it.next()).getMId()));
                }
                List o0Xo0XII = CollectionsKt___CollectionsKt.o0Xo0XII(arrayList2);
                if (list != null) {
                    for (BleBuffer bleBuffer : list) {
                        if (bleBuffer instanceof BleIdObject) {
                            int i2 = 0;
                            while (true) {
                                if (i2 >= 255) {
                                    break;
                                }
                                if (!o0Xo0XII.contains(Integer.valueOf(i2))) {
                                    ((BleIdObject) bleBuffer).setMId(i2);
                                    bArr = ByteArrayExtKt.append(bArr, bleBuffer.toByteArray());
                                    list2.add(bleBuffer);
                                    o0Xo0XII.add(Integer.valueOf(i2));
                                    break;
                                }
                                i2++;
                            }
                        }
                    }
                }
            } else if (bleKeyFlag == BleKeyFlag.RESET) {
                list2.clear();
                if (list != null) {
                    for (Object obj : list) {
                        int i3 = i + 1;
                        if (i < 0) {
                            CollectionsKt__CollectionsKt.XoX();
                        }
                        BleBuffer bleBuffer2 = (BleBuffer) obj;
                        if (bleBuffer2 instanceof BleIdObject) {
                            ((BleIdObject) bleBuffer2).setMId(i);
                            byte[] append = ByteArrayExtKt.append(bArr, bleBuffer2.toByteArray());
                            list2.add(bleBuffer2);
                            bArr = append;
                        }
                        i = i3;
                    }
                }
                sendInt8$default(this, bleKey, BleKeyFlag.DELETE, 255, false, false, 24, null);
                bArr = bArr;
            }
        } else {
            if (bleKeyFlag == BleKeyFlag.CREATE && list != null) {
                Iterator<T> it2 = list.iterator();
                while (it2.hasNext()) {
                    bArr = ByteArrayExtKt.append(bArr, ((BleBuffer) it2.next()).toByteArray());
                }
            }
            list2 = arrayList;
        }
        BleKeyFlag bleKeyFlag3 = BleKeyFlag.RESET;
        if (bleKeyFlag == bleKeyFlag3) {
            bleKeyFlag2 = BleKeyFlag.CREATE;
        } else {
            bleKeyFlag2 = bleKeyFlag;
        }
        boolean sendData = sendData(bleKey, bleKeyFlag2, bArr, z, z2);
        if (sendData) {
            BleCache bleCache = BleCache.INSTANCE;
            if (bleCache.requireCache(bleKey, bleKeyFlag)) {
                if (bleKey.isIdObjectKey()) {
                    if (bleKeyFlag == BleKeyFlag.CREATE || bleKeyFlag == bleKeyFlag3) {
                        BleCache.putList$default(bleCache, bleKey, list2, null, 4, null);
                    }
                } else {
                    BleCache.putList$default(bleCache, bleKey, list, null, 4, null);
                }
            }
        }
        return sendData;
    }

    public final boolean sendObject(@OOXIXo BleKey bleKey, @OOXIXo BleKeyFlag bleKeyFlag, @oOoXoXO BleBuffer bleBuffer, boolean z, boolean z2) {
        byte[] bArr;
        BleCoachingIds bleCoachingIds;
        IIX0o.x0xO0oo(bleKey, "bleKey");
        IIX0o.x0xO0oo(bleKeyFlag, "bleKeyFlag");
        int i = 0;
        if (!isAvailable()) {
            return false;
        }
        List<BleIdObject> arrayList = new ArrayList<>();
        boolean z3 = bleBuffer instanceof BleIdObject;
        if (z3) {
            arrayList = BleCache.INSTANCE.getIdObjects(bleKey);
            if (bleKeyFlag == BleKeyFlag.CREATE) {
                List<BleIdObject> list = arrayList;
                ArrayList arrayList2 = new ArrayList(OxxIIOOXO.xo0x(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList2.add(Integer.valueOf(((BleIdObject) it.next()).getMId()));
                }
                List o0Xo0XII = CollectionsKt___CollectionsKt.o0Xo0XII(arrayList2);
                if ((bleBuffer instanceof BleCoaching) && (bleCoachingIds = (BleCoachingIds) BleCache.INSTANCE.getObject(BleKey.COACHING, BleCoachingIds.class, BleKeyFlag.READ)) != null) {
                    o0Xo0XII.addAll(bleCoachingIds.getMIds());
                }
                if (bleBuffer instanceof BleLoveTapUser) {
                    Iterator<BleIdObject> it2 = arrayList.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (it2.next().getMId() == ((BleIdObject) bleBuffer).getMId()) {
                                break;
                            }
                            i++;
                        } else {
                            i = -1;
                            break;
                        }
                    }
                    if (i > -1) {
                        arrayList.set(i, bleBuffer);
                    } else {
                        arrayList.add(bleBuffer);
                    }
                } else {
                    while (true) {
                        if (i >= 255) {
                            break;
                        }
                        if (!o0Xo0XII.contains(Integer.valueOf(i))) {
                            ((BleIdObject) bleBuffer).setMId(i);
                            break;
                        }
                        i++;
                    }
                    arrayList.add(bleBuffer);
                }
            } else if (bleKeyFlag == BleKeyFlag.UPDATE) {
                Iterator<BleIdObject> it3 = arrayList.iterator();
                while (true) {
                    if (it3.hasNext()) {
                        if (it3.next().getMId() == ((BleIdObject) bleBuffer).getMId()) {
                            break;
                        }
                        i++;
                    } else {
                        i = -1;
                        break;
                    }
                }
                if (i > -1) {
                    arrayList.set(i, bleBuffer);
                }
            }
        }
        List<BleIdObject> list2 = arrayList;
        if (bleBuffer != null) {
            bArr = bleBuffer.toByteArray();
        } else {
            bArr = null;
        }
        boolean sendData = sendData(bleKey, bleKeyFlag, bArr, z, z2);
        if (sendData) {
            BleCache bleCache = BleCache.INSTANCE;
            if (bleCache.requireCache(bleKey, bleKeyFlag)) {
                if (z3) {
                    BleCache.putList$default(bleCache, bleKey, list2, null, 4, null);
                } else {
                    BleCache.putObject$default(bleCache, bleKey, bleBuffer, null, 4, null);
                }
            }
        }
        return sendData;
    }

    public final boolean sendStream(@OOXIXo BleKey bleKey, @OOXIXo byte[] bytes, int i) {
        IIX0o.x0xO0oo(bleKey, "bleKey");
        IIX0o.x0xO0oo(bytes, "bytes");
        if (bytes.length == 0) {
            return false;
        }
        setMBleStream(new BleStream(bleKey, i, bytes));
        BleStream bleStream = mBleStream;
        BleStreamPacket packet = bleStream != null ? bleStream.getPacket(0, BleCache.INSTANCE.getMIOBufferSize()) : null;
        if (packet == null) {
            return false;
        }
        BleStream bleStream2 = mBleStream;
        IIX0o.ooOOo0oXI(bleStream2);
        return sendObject$default(this, bleStream2.getMBleKey(), BleKeyFlag.UPDATE, packet, false, false, 24, null);
    }

    @Override // com.bestmafen.baseble.connector.AbsBleConnector
    public void setConnecting(final boolean z) {
        isConnecting = z;
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("BleConnector onDeviceConnecting -> " + z);
        notifyHandlers(new Oox.oOoXoXO<BleHandleCallback, oXIO0o0XI>() { // from class: com.szabh.smable3.component.BleConnector$isConnecting$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(BleHandleCallback bleHandleCallback) {
                invoke2(bleHandleCallback);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OOXIXo BleHandleCallback it) {
                IIX0o.x0xO0oo(it, "it");
                it.onDeviceConnecting(z);
            }
        });
    }

    public final void setDataKeyAutoDelete(boolean z) {
        isDataKeyAutoDelete = z;
    }

    public final void setMHidState(int i) {
        mHidState = i;
    }

    public final void setNeedBind(boolean z) {
        isNeedBind = z;
    }

    public final void setOtaMode(boolean z) {
        isNordicOtaMode = z;
    }

    public final void setRefreshDeviceInfo(boolean z) {
        isRefreshDeviceInfo = z;
    }

    public final void stopStream() {
        setMBleStream(null);
    }

    public final void unbind() {
        BleCache bleCache = BleCache.INSTANCE;
        unbindClassic(bleCache.getMClassicAddress());
        if (bleCache.getMSupportHID() == 1) {
            unbindHID(bleCache.getMBleAddress());
        }
        bleCache.setMDeviceInfo(null);
        BleCache.remove$default(bleCache, BleKey.IDENTITY, null, 2, null);
        closeConnection(true);
    }

    public final void unbindClassic(@OOXIXo String address) {
        IIX0o.x0xO0oo(address, "address");
        removeBond(address);
    }

    public final void unbindHID(@OOXIXo String address) {
        IIX0o.x0xO0oo(address, "address");
        removeBond(address);
    }

    public final boolean updateMusic(@OOXIXo BleMusicControl bleMusicControl) {
        IIX0o.x0xO0oo(bleMusicControl, "bleMusicControl");
        Map<MusicEntity, List<MusicAttr>> map = mMusicSubscriptions;
        if (map.get(bleMusicControl.getMMusicEntity()) != null) {
            List<MusicAttr> list = map.get(bleMusicControl.getMMusicEntity());
            IIX0o.ooOOo0oXI(list);
            if (list.contains(bleMusicControl.getMMusicAttr())) {
                return sendObject$default(this, BleKey.MUSIC_CONTROL, BleKeyFlag.UPDATE, bleMusicControl, false, false, 24, null);
            }
            return true;
        }
        return true;
    }

    public static /* synthetic */ boolean sendStream$default(BleConnector bleConnector, BleKey bleKey, InputStream inputStream, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return bleConnector.sendStream(bleKey, inputStream, i);
    }

    public final void connectClassic(@OOXIXo String address) {
        Boolean createBond;
        IIX0o.x0xO0oo(address, "address");
        if (Build.VERSION.SDK_INT >= 23) {
            BleCache bleCache = BleCache.INSTANCE;
            if (IIX0o.Oxx0IOOO(bleCache.getMPlatform(), BleDeviceInfo.PLATFORM_JL) || IIX0o.Oxx0IOOO(bleCache.getMPlatform(), BleDeviceInfo.PLATFORM_JL707) || IIX0o.Oxx0IOOO(bleCache.getMPlatform(), BleDeviceInfo.PLATFORM_JL707LITE) || IIX0o.Oxx0IOOO(bleCache.getMPlatform(), BleDeviceInfo.PLATFORM_SIFLI)) {
                createBond = createBond(address, 1);
                OI0.oIX0oI.f1507oIX0oI.XO("connectClassic -> " + address + ", " + createBond);
            }
        }
        createBond = createBond(address);
        OI0.oIX0oI.f1507oIX0oI.XO("connectClassic -> " + address + ", " + createBond);
    }

    @Override // com.bestmafen.baseble.connector.AbsBleConnector
    @OOXIXo
    public BleMessenger getMBleMessenger() {
        return (BleMessenger) mBleMessenger$delegate.getValue();
    }

    @Override // com.bestmafen.baseble.connector.AbsBleConnector
    @OOXIXo
    public BleParser getMBleParser() {
        return (BleParser) mBleParser$delegate.getValue();
    }

    public final boolean isBoundClassic(@OOXIXo String address) {
        Object obj;
        IIX0o.x0xO0oo(address, "address");
        try {
            Set<BluetoothDevice> bondedDevices = BluetoothAdapter.getDefaultAdapter().getBondedDevices();
            IIX0o.oO(bondedDevices, "getBondedDevices(...)");
            Iterator<T> it = bondedDevices.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (IIX0o.Oxx0IOOO(((BluetoothDevice) obj).getAddress(), address)) {
                    break;
                }
            }
            return obj != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public final boolean isBoundHID(@OOXIXo String address) {
        Object obj;
        IIX0o.x0xO0oo(address, "address");
        try {
            Set<BluetoothDevice> bondedDevices = BluetoothAdapter.getDefaultAdapter().getBondedDevices();
            IIX0o.oO(bondedDevices, "getBondedDevices(...)");
            Iterator<T> it = bondedDevices.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (IIX0o.Oxx0IOOO(((BluetoothDevice) obj).getAddress(), address)) {
                    break;
                }
            }
            return obj != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static /* synthetic */ boolean sendStream$default(BleConnector bleConnector, BleKey bleKey, File file, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return bleConnector.sendStream(bleKey, file, i);
    }

    public static /* synthetic */ boolean sendStream$default(BleConnector bleConnector, BleKey bleKey, String str, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return bleConnector.sendStream(bleKey, str, i);
    }

    public static /* synthetic */ boolean sendStream$default(BleConnector bleConnector, BleKey bleKey, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return bleConnector.sendStream(bleKey, i, i2);
    }

    public final boolean sendStream(@OOXIXo BleKey bleKey, @OOXIXo InputStream inputStream, int i) {
        IIX0o.x0xO0oo(bleKey, "bleKey");
        IIX0o.x0xO0oo(inputStream, "inputStream");
        try {
            try {
                byte[] x0xO0oo2 = kotlin.io.oIX0oI.x0xO0oo(inputStream);
                kotlin.io.II0xO0.oIX0oI(inputStream, null);
                return sendStream(bleKey, x0xO0oo2, i);
            } finally {
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private final Boolean createBond(String str, int i) {
        boolean z = false;
        if (!BluetoothAdapter.checkBluetoothAddress(str)) {
            return Boolean.FALSE;
        }
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        BluetoothDevice remoteDevice = defaultAdapter != null ? defaultAdapter.getRemoteDevice(str) : null;
        if (remoteDevice != null) {
            try {
                Method method = remoteDevice.getClass().getMethod("createBond", Integer.TYPE);
                method.setAccessible(true);
                Object invoke = method.invoke(remoteDevice, Integer.valueOf(i));
                OI0.oIX0oI.f1507oIX0oI.XO("BleConnector invoke createBond -> " + invoke);
                if (invoke instanceof Boolean) {
                    return (Boolean) invoke;
                }
            } catch (Exception e) {
                OI0.oIX0oI.f1507oIX0oI.Oxx0IOOO("BleConnector invoke createBond getMethod error -> " + e);
            }
        }
        try {
            if (remoteDevice != null) {
                z = remoteDevice.createBond();
            } else {
                OI0.oIX0oI.f1507oIX0oI.Oxx0IOOO("BleConnector createBond error -> device = null");
            }
            return Boolean.valueOf(z);
        } catch (Exception e2) {
            OI0.oIX0oI.f1507oIX0oI.Oxx0IOOO("BleConnector createBond error -> " + e2.getLocalizedMessage());
            return Boolean.FALSE;
        }
    }

    public final boolean sendStream(@OOXIXo BleKey bleKey, @OOXIXo File file, int i) {
        IIX0o.x0xO0oo(bleKey, "bleKey");
        IIX0o.x0xO0oo(file, "file");
        return sendStream(bleKey, new FileInputStream(file), i);
    }

    public final boolean sendStream(@OOXIXo BleKey bleKey, @OOXIXo String path, int i) {
        IIX0o.x0xO0oo(bleKey, "bleKey");
        IIX0o.x0xO0oo(path, "path");
        return sendStream(bleKey, new FileInputStream(path), i);
    }

    public final boolean sendStream(@OOXIXo BleKey bleKey, int i, int i2) {
        IIX0o.x0xO0oo(bleKey, "bleKey");
        InputStream openRawResource = getMContext().getResources().openRawResource(i);
        IIX0o.oO(openRawResource, "openRawResource(...)");
        return sendStream(bleKey, openRawResource, i2);
    }

    public final void mtkOta(@OOXIXo InputStream inputStream) {
        IIX0o.x0xO0oo(inputStream, "inputStream");
        try {
            byte[] x0xO0oo2 = kotlin.io.oIX0oI.x0xO0oo(inputStream);
            kotlin.io.II0xO0.oIX0oI(inputStream, null);
            mtkOta(x0xO0oo2);
        } finally {
        }
    }

    public final void mtkOta(@OOXIXo File file) {
        IIX0o.x0xO0oo(file, "file");
        mtkOta(new FileInputStream(file));
    }

    public final void mtkOta(@OOXIXo String path) {
        IIX0o.x0xO0oo(path, "path");
        mtkOta(new FileInputStream(path));
    }

    public final void mtkOta(int i) {
        InputStream openRawResource = getMContext().getResources().openRawResource(i);
        IIX0o.oO(openRawResource, "openRawResource(...)");
        mtkOta(openRawResource);
    }
}
