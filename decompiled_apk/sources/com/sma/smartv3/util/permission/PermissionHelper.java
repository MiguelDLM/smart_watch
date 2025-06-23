package com.sma.smartv3.util.permission;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import androidx.annotation.RequiresApi;
import com.bestmafen.androidbase.extension.PermissionStatus;
import com.blankj.utilcode.constant.PermissionConstants;
import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.RomUtils;
import com.blankj.utilcode.util.SPUtils;
import com.huawei.openalliance.ad.constant.x;
import com.kuaishou.weapon.p0.g;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.ble.MyNotificationListenerService;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.pop.XoI0Ixx0;
import com.sma.smartv3.ui.device.X00xOoXI;
import com.sma.smartv3.util.UtilsKt;
import java.util.Arrays;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nPermissionHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PermissionHelper.kt\ncom/sma/smartv3/util/permission/PermissionHelper\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,579:1\n1#2:580\n*E\n"})
/* loaded from: classes12.dex */
public final class PermissionHelper {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OOXIXo
    public static final PermissionHelper f24522oIX0oI = new PermissionHelper();

    /* loaded from: classes12.dex */
    public static final class II0xO0 implements X0o0xo {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ oOoXoXO<Boolean, oXIO0o0XI> f24523oIX0oI;

        /* JADX WARN: Multi-variable type inference failed */
        public II0xO0(oOoXoXO<? super Boolean, oXIO0o0XI> oooxoxo) {
            this.f24523oIX0oI = oooxoxo;
        }

        @Override // com.sma.smartv3.util.permission.X0o0xo
        public void oIX0oI(boolean z) {
            oOoXoXO<Boolean, oXIO0o0XI> oooxoxo = this.f24523oIX0oI;
            if (oooxoxo != null) {
                oooxoxo.invoke(Boolean.valueOf(z));
            }
        }
    }

    /* loaded from: classes12.dex */
    public static final class oIX0oI implements X0o0xo {

        /* renamed from: II0xO0, reason: collision with root package name */
        public final /* synthetic */ oOoXoXO<Boolean, oXIO0o0XI> f24537II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ Ref.BooleanRef f24538oIX0oI;

        /* JADX WARN: Multi-variable type inference failed */
        public oIX0oI(Ref.BooleanRef booleanRef, oOoXoXO<? super Boolean, oXIO0o0XI> oooxoxo) {
            this.f24538oIX0oI = booleanRef;
            this.f24537II0xO0 = oooxoxo;
        }

        @Override // com.sma.smartv3.util.permission.X0o0xo
        public void oIX0oI(boolean z) {
            Ref.BooleanRef booleanRef = this.f24538oIX0oI;
            if (booleanRef.element) {
                return;
            }
            booleanRef.element = true;
            oOoXoXO<Boolean, oXIO0o0XI> oooxoxo = this.f24537II0xO0;
            if (oooxoxo != null) {
                oooxoxo.invoke(Boolean.valueOf(z));
            }
        }
    }

    public static /* synthetic */ void XxX0x0xxx(PermissionHelper permissionHelper, Context context, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "";
        }
        if ((i & 4) != 0) {
            str2 = "";
        }
        permissionHelper.xxX(context, str, str2);
    }

    public static /* synthetic */ void oOoXoXO(PermissionHelper permissionHelper, Context context, boolean z, boolean z2, oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 2) != 0) {
            if (Build.VERSION.SDK_INT >= 29 && ProjectManager.f19822oIX0oI.O0()) {
                z = true;
            } else {
                z = false;
            }
        }
        if ((i & 4) != 0) {
            z2 = true;
        }
        permissionHelper.OOXIXo(context, z, z2, oooxoxo);
    }

    public static /* synthetic */ void xoIox(PermissionHelper permissionHelper, Context context, boolean z, oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 2) != 0) {
            if (Build.VERSION.SDK_INT >= 29 && ProjectManager.f19822oIX0oI.O0()) {
                z = true;
            } else {
                z = false;
            }
        }
        permissionHelper.xxIXOIIO(context, z, oooxoxo);
    }

    public final void I0Io(@OOXIXo Context context, @OXOo.oOoXoXO oOoXoXO<? super Boolean, oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(context, "context");
        LogUtils.d("applyAutoRun");
        com.sma.smartv3.util.permission.oIX0oI.xxIXOIIO((Activity) context, new oIX0oI(new Ref.BooleanRef(), oooxoxo));
    }

    public final void II0XooXoX(@OOXIXo Context context, @OXOo.oOoXoXO oOoXoXO<? super Boolean, oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(context, "context");
        LogUtils.d("applyIgnoreBatteryOptimizations");
        oxoX.I0Io((Activity) context, new II0xO0(oooxoxo));
    }

    public final void II0xO0(@OOXIXo Context context, @OXOo.oOoXoXO final oOoXoXO<? super Boolean, oXIO0o0XI> oooxoxo) {
        String str;
        IIX0o.x0xO0oo(context, "context");
        if (Build.VERSION.SDK_INT >= 33) {
            str = "android.permission.READ_MEDIA_IMAGES";
        } else {
            str = PermissionConstants.STORAGE;
        }
        PermissionUtils permission = PermissionUtils.permission(str);
        IIX0o.oO(permission, "permission(...)");
        oOXoIIIo.X0o0xo.II0xO0(permission, UtilsKt.oI0IIXIo(R.string.storage_explain_title), UtilsKt.oI0IIXIo(R.string.storage_explain_content), new oOoXoXO<PermissionStatus, oXIO0o0XI>() { // from class: com.sma.smartv3.util.permission.PermissionHelper$applyAlbumPermission$1

            /* loaded from: classes12.dex */
            public /* synthetic */ class oIX0oI {

                /* renamed from: oIX0oI, reason: collision with root package name */
                public static final /* synthetic */ int[] f24525oIX0oI;

                static {
                    int[] iArr = new int[PermissionStatus.values().length];
                    try {
                        iArr[PermissionStatus.GRANTED.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    f24525oIX0oI = iArr;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(PermissionStatus permissionStatus) {
                invoke2(permissionStatus);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OOXIXo PermissionStatus it) {
                IIX0o.x0xO0oo(it, "it");
                if (oIX0oI.f24525oIX0oI[it.ordinal()] == 1) {
                    oOoXoXO<Boolean, oXIO0o0XI> oooxoxo2 = oooxoxo;
                    if (oooxoxo2 != null) {
                        oooxoxo2.invoke(Boolean.TRUE);
                        return;
                    }
                    return;
                }
                oOoXoXO<Boolean, oXIO0o0XI> oooxoxo3 = oooxoxo;
                if (oooxoxo3 != null) {
                    oooxoxo3.invoke(Boolean.FALSE);
                }
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("No album permission!!!");
            }
        });
    }

    public final boolean IIX0o(@OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "context");
        try {
            Cursor query = context.getContentResolver().query(Uri.parse("content://sms/inbox"), null, null, null, null);
            if (query != null) {
                Cursor cursor = query;
                try {
                    Cursor cursor2 = cursor;
                    oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
                    kotlin.io.II0xO0.oIX0oI(cursor, null);
                } finally {
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public final boolean IIXOooo(@OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "context");
        return PermissionUtils.isGranted("android.permission.READ_CONTACTS");
    }

    public final boolean IXxxXO(@OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "context");
        if (MyNotificationListenerService.f20319OxI.X0o0xo(context) && OxI(context) && IIXOooo(context) && O0xOxO(context) && XI0IXoo(context) && xoXoI(context) && o00(context)) {
            return true;
        }
        return false;
    }

    public final boolean O0xOxO(@OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "context");
        return PermissionUtils.isGranted("android.permission.READ_CALL_LOG", g.c);
    }

    public final void OOXIXo(@OOXIXo final Context context, final boolean z, final boolean z2, @OXOo.oOoXoXO final oOoXoXO<? super Boolean, oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(context, "context");
        if (!OxI(context)) {
            xXxxox0I(context, new oOoXoXO<Boolean, oXIO0o0XI>() { // from class: com.sma.smartv3.util.permission.PermissionHelper$applyLocationPermission2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return oXIO0o0XI.f29392oIX0oI;
                }

                public final void invoke(boolean z3) {
                    if (z3) {
                        PermissionUtils permission = PermissionUtils.permission(PermissionConstants.LOCATION);
                        IIX0o.oO(permission, "permission(...)");
                        final boolean z4 = z;
                        final oOoXoXO<Boolean, oXIO0o0XI> oooxoxo2 = oooxoxo;
                        final Context context2 = context;
                        final boolean z5 = z2;
                        oOXoIIIo.X0o0xo.I0Io(permission, null, null, new oOoXoXO<PermissionStatus, oXIO0o0XI>() { // from class: com.sma.smartv3.util.permission.PermissionHelper$applyLocationPermission2$1.1

                            /* renamed from: com.sma.smartv3.util.permission.PermissionHelper$applyLocationPermission2$1$1$oIX0oI */
                            /* loaded from: classes12.dex */
                            public /* synthetic */ class oIX0oI {

                                /* renamed from: oIX0oI, reason: collision with root package name */
                                public static final /* synthetic */ int[] f24533oIX0oI;

                                static {
                                    int[] iArr = new int[PermissionStatus.values().length];
                                    try {
                                        iArr[PermissionStatus.GRANTED.ordinal()] = 1;
                                    } catch (NoSuchFieldError unused) {
                                    }
                                    try {
                                        iArr[PermissionStatus.DENIED.ordinal()] = 2;
                                    } catch (NoSuchFieldError unused2) {
                                    }
                                    try {
                                        iArr[PermissionStatus.DENIED_FOREVER.ordinal()] = 3;
                                    } catch (NoSuchFieldError unused3) {
                                    }
                                    f24533oIX0oI = iArr;
                                }
                            }

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // Oox.oOoXoXO
                            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(PermissionStatus permissionStatus) {
                                invoke2(permissionStatus);
                                return oXIO0o0XI.f29392oIX0oI;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@OOXIXo PermissionStatus it) {
                                IIX0o.x0xO0oo(it, "it");
                                int i = oIX0oI.f24533oIX0oI[it.ordinal()];
                                if (i != 1) {
                                    if (i != 2) {
                                        if (i != 3) {
                                            return;
                                        }
                                        PermissionHelper.XxX0x0xxx(PermissionHelper.f24522oIX0oI, context2, null, null, 6, null);
                                        return;
                                    } else {
                                        oOoXoXO<Boolean, oXIO0o0XI> oooxoxo3 = oooxoxo2;
                                        if (oooxoxo3 != null) {
                                            oooxoxo3.invoke(Boolean.FALSE);
                                            return;
                                        }
                                        return;
                                    }
                                }
                                if (z4) {
                                    PermissionUtils permission2 = PermissionUtils.permission("android.permission.ACCESS_BACKGROUND_LOCATION");
                                    IIX0o.oO(permission2, "permission(...)");
                                    final Context context3 = context2;
                                    final oOoXoXO<Boolean, oXIO0o0XI> oooxoxo4 = oooxoxo2;
                                    final boolean z6 = z5;
                                    oOXoIIIo.X0o0xo.I0Io(permission2, null, null, new oOoXoXO<PermissionStatus, oXIO0o0XI>() { // from class: com.sma.smartv3.util.permission.PermissionHelper.applyLocationPermission2.1.1.1

                                        /* renamed from: com.sma.smartv3.util.permission.PermissionHelper$applyLocationPermission2$1$1$1$oIX0oI */
                                        /* loaded from: classes12.dex */
                                        public /* synthetic */ class oIX0oI {

                                            /* renamed from: oIX0oI, reason: collision with root package name */
                                            public static final /* synthetic */ int[] f24532oIX0oI;

                                            static {
                                                int[] iArr = new int[PermissionStatus.values().length];
                                                try {
                                                    iArr[PermissionStatus.DENIED_FOREVER.ordinal()] = 1;
                                                } catch (NoSuchFieldError unused) {
                                                }
                                                try {
                                                    iArr[PermissionStatus.DENIED.ordinal()] = 2;
                                                } catch (NoSuchFieldError unused2) {
                                                }
                                                try {
                                                    iArr[PermissionStatus.GRANTED.ordinal()] = 3;
                                                } catch (NoSuchFieldError unused3) {
                                                }
                                                f24532oIX0oI = iArr;
                                            }
                                        }

                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(1);
                                        }

                                        @Override // Oox.oOoXoXO
                                        public /* bridge */ /* synthetic */ oXIO0o0XI invoke(PermissionStatus permissionStatus) {
                                            invoke2(permissionStatus);
                                            return oXIO0o0XI.f29392oIX0oI;
                                        }

                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(@OOXIXo PermissionStatus status) {
                                            oOoXoXO<Boolean, oXIO0o0XI> oooxoxo5;
                                            IIX0o.x0xO0oo(status, "status");
                                            int i2 = oIX0oI.f24532oIX0oI[status.ordinal()];
                                            if (i2 == 1) {
                                                PermissionHelper permissionHelper = PermissionHelper.f24522oIX0oI;
                                                Context context4 = context3;
                                                String string = context4.getString(R.string.request_background_location_permission_denied_tip, AppUtils.getAppName(), AppUtils.getAppName());
                                                IIX0o.oO(string, "getString(...)");
                                                String string2 = context3.getString(R.string.location_permissions);
                                                IIX0o.oO(string2, "getString(...)");
                                                permissionHelper.xxX(context4, string, string2);
                                                return;
                                            }
                                            if (i2 != 2) {
                                                if (i2 == 3 && (oooxoxo5 = oooxoxo4) != null) {
                                                    oooxoxo5.invoke(Boolean.TRUE);
                                                    return;
                                                }
                                                return;
                                            }
                                            oOoXoXO<Boolean, oXIO0o0XI> oooxoxo6 = oooxoxo4;
                                            if (oooxoxo6 != null) {
                                                oooxoxo6.invoke(Boolean.valueOf(!z6));
                                            }
                                        }
                                    }, 3, null);
                                    return;
                                }
                                oOoXoXO<Boolean, oXIO0o0XI> oooxoxo5 = oooxoxo2;
                                if (oooxoxo5 != null) {
                                    oooxoxo5.invoke(Boolean.TRUE);
                                }
                            }
                        }, 3, null);
                    }
                }
            });
        } else if (oooxoxo != null) {
            oooxoxo.invoke(Boolean.TRUE);
        }
    }

    public final boolean Oo(@OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "context");
        if (Build.VERSION.SDK_INT >= 29) {
            return PermissionUtils.isGranted("android.permission.ACTIVITY_RECOGNITION");
        }
        return true;
    }

    public final boolean OxI(@OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "context");
        if (ProjectManager.f19822oIX0oI.O0()) {
            if (PermissionUtils.isGranted(PermissionConstants.LOCATION) && oI0IIXIo(context)) {
                return true;
            }
            return false;
        }
        return PermissionUtils.isGranted(PermissionConstants.LOCATION);
    }

    public final void Oxx0IOOO(@OOXIXo final Context context, @OXOo.oOoXoXO final oOoXoXO<? super Boolean, oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(context, "context");
        PermissionUtils permission = PermissionUtils.permission(PermissionConstants.STORAGE);
        IIX0o.oO(permission, "permission(...)");
        oOXoIIIo.X0o0xo.I0Io(permission, null, null, new oOoXoXO<PermissionStatus, oXIO0o0XI>() { // from class: com.sma.smartv3.util.permission.PermissionHelper$applyExternalStoragePermission$1

            /* loaded from: classes12.dex */
            public /* synthetic */ class oIX0oI {

                /* renamed from: oIX0oI, reason: collision with root package name */
                public static final /* synthetic */ int[] f24529oIX0oI;

                static {
                    int[] iArr = new int[PermissionStatus.values().length];
                    try {
                        iArr[PermissionStatus.GRANTED.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[PermissionStatus.DENIED.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[PermissionStatus.DENIED_FOREVER.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    f24529oIX0oI = iArr;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(PermissionStatus permissionStatus) {
                invoke2(permissionStatus);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OOXIXo PermissionStatus it) {
                IIX0o.x0xO0oo(it, "it");
                int i = oIX0oI.f24529oIX0oI[it.ordinal()];
                if (i == 1) {
                    oOoXoXO<Boolean, oXIO0o0XI> oooxoxo2 = oooxoxo;
                    if (oooxoxo2 != null) {
                        oooxoxo2.invoke(Boolean.TRUE);
                        return;
                    }
                    return;
                }
                if (i != 2) {
                    if (i != 3) {
                        return;
                    }
                    PermissionHelper.XxX0x0xxx(PermissionHelper.f24522oIX0oI, context, null, null, 6, null);
                } else {
                    oOoXoXO<Boolean, oXIO0o0XI> oooxoxo3 = oooxoxo;
                    if (oooxoxo3 != null) {
                        oooxoxo3.invoke(Boolean.FALSE);
                    }
                }
            }
        }, 3, null);
    }

    public final boolean Oxx0xo(@OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "context");
        return SPUtils.getInstance().getBoolean(com.sma.smartv3.util.permission.oIX0oI.f24542II0xO0, false);
    }

    public final boolean OxxIIOOXO(@OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "context");
        if (Build.VERSION.SDK_INT >= 31) {
            return PermissionUtils.isGranted("android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_CONNECT");
        }
        return true;
    }

    public final boolean X0IIOO(@OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "context");
        if (Build.VERSION.SDK_INT >= 33) {
            return PermissionUtils.isGranted(x.cC);
        }
        return true;
    }

    public final void X0o0xo(@OOXIXo Context context, @OXOo.oOoXoXO final oOoXoXO<? super Boolean, oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(context, "context");
        PermissionUtils permission = PermissionUtils.permission(PermissionConstants.CAMERA);
        IIX0o.oO(permission, "permission(...)");
        oOXoIIIo.X0o0xo.II0xO0(permission, UtilsKt.oI0IIXIo(R.string.camera_explain_title), UtilsKt.oI0IIXIo(R.string.camera_explain_content), new oOoXoXO<PermissionStatus, oXIO0o0XI>() { // from class: com.sma.smartv3.util.permission.PermissionHelper$applyCameraPermission$1

            /* loaded from: classes12.dex */
            public /* synthetic */ class oIX0oI {

                /* renamed from: oIX0oI, reason: collision with root package name */
                public static final /* synthetic */ int[] f24527oIX0oI;

                static {
                    int[] iArr = new int[PermissionStatus.values().length];
                    try {
                        iArr[PermissionStatus.GRANTED.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    f24527oIX0oI = iArr;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(PermissionStatus permissionStatus) {
                invoke2(permissionStatus);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OOXIXo PermissionStatus it) {
                IIX0o.x0xO0oo(it, "it");
                if (oIX0oI.f24527oIX0oI[it.ordinal()] == 1) {
                    oOoXoXO<Boolean, oXIO0o0XI> oooxoxo2 = oooxoxo;
                    if (oooxoxo2 != null) {
                        oooxoxo2.invoke(Boolean.TRUE);
                        return;
                    }
                    return;
                }
                oOoXoXO<Boolean, oXIO0o0XI> oooxoxo3 = oooxoxo;
                if (oooxoxo3 != null) {
                    oooxoxo3.invoke(Boolean.FALSE);
                }
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("No camera permission!!!");
            }
        });
    }

    public final boolean XI0IXoo(@OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "context");
        return PermissionUtils.isGranted("android.permission.READ_SMS");
    }

    public final void XIxXXX0x0(@OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "context");
        if (RomUtils.isXiaomi()) {
            try {
                try {
                    Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
                    intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
                    intent.putExtra("extra_pkgname", context.getPackageName());
                    context.startActivity(intent);
                    return;
                } catch (Exception unused) {
                    PermissionUtils.launchAppDetailsSettings();
                    return;
                }
            } catch (Exception unused2) {
                Intent intent2 = new Intent("miui.intent.action.APP_PERM_EDITOR");
                intent2.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
                intent2.putExtra("extra_pkgname", context.getPackageName());
                context.startActivity(intent2);
                return;
            }
        }
        PermissionUtils.launchAppDetailsSettings();
    }

    public final void XO(@OOXIXo final Context context, @OXOo.oOoXoXO final oOoXoXO<? super Boolean, oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(context, "context");
        PermissionUtils permission = PermissionUtils.permission(PermissionConstants.CONTACTS);
        IIX0o.oO(permission, "permission(...)");
        oOXoIIIo.X0o0xo.I0Io(permission, null, null, new oOoXoXO<PermissionStatus, oXIO0o0XI>() { // from class: com.sma.smartv3.util.permission.PermissionHelper$applyContactsPermission$1

            /* loaded from: classes12.dex */
            public /* synthetic */ class oIX0oI {

                /* renamed from: oIX0oI, reason: collision with root package name */
                public static final /* synthetic */ int[] f24528oIX0oI;

                static {
                    int[] iArr = new int[PermissionStatus.values().length];
                    try {
                        iArr[PermissionStatus.GRANTED.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[PermissionStatus.DENIED.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[PermissionStatus.DENIED_FOREVER.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    f24528oIX0oI = iArr;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(PermissionStatus permissionStatus) {
                invoke2(permissionStatus);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OOXIXo PermissionStatus it) {
                IIX0o.x0xO0oo(it, "it");
                int i = oIX0oI.f24528oIX0oI[it.ordinal()];
                if (i == 1) {
                    oOoXoXO<Boolean, oXIO0o0XI> oooxoxo2 = oooxoxo;
                    if (oooxoxo2 != null) {
                        oooxoxo2.invoke(Boolean.TRUE);
                        return;
                    }
                    return;
                }
                if (i != 2) {
                    if (i != 3) {
                        return;
                    }
                    PermissionHelper.XxX0x0xxx(PermissionHelper.f24522oIX0oI, context, null, null, 6, null);
                } else {
                    oOoXoXO<Boolean, oXIO0o0XI> oooxoxo3 = oooxoxo;
                    if (oooxoxo3 != null) {
                        oooxoxo3.invoke(Boolean.FALSE);
                    }
                }
            }
        }, 3, null);
    }

    public final boolean o00(@OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "context");
        return oxoX.II0xO0(context);
    }

    public final boolean oI0IIXIo(@OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "context");
        if (Build.VERSION.SDK_INT >= 29) {
            return PermissionUtils.isGranted("android.permission.ACCESS_BACKGROUND_LOCATION");
        }
        return true;
    }

    public final void oIX0oI(@OOXIXo final Context context, @OXOo.oOoXoXO final oOoXoXO<? super Boolean, oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(context, "context");
        PermissionUtils permission = PermissionUtils.permission(PermissionConstants.ACTIVITY_RECOGNITION);
        IIX0o.oO(permission, "permission(...)");
        oOXoIIIo.X0o0xo.I0Io(permission, null, null, new oOoXoXO<PermissionStatus, oXIO0o0XI>() { // from class: com.sma.smartv3.util.permission.PermissionHelper$applyActivityPermission$1

            /* loaded from: classes12.dex */
            public /* synthetic */ class oIX0oI {

                /* renamed from: oIX0oI, reason: collision with root package name */
                public static final /* synthetic */ int[] f24524oIX0oI;

                static {
                    int[] iArr = new int[PermissionStatus.values().length];
                    try {
                        iArr[PermissionStatus.GRANTED.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[PermissionStatus.DENIED.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[PermissionStatus.DENIED_FOREVER.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    f24524oIX0oI = iArr;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(PermissionStatus permissionStatus) {
                invoke2(permissionStatus);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OOXIXo PermissionStatus it) {
                IIX0o.x0xO0oo(it, "it");
                int i = oIX0oI.f24524oIX0oI[it.ordinal()];
                if (i == 1) {
                    oOoXoXO<Boolean, oXIO0o0XI> oooxoxo2 = oooxoxo;
                    if (oooxoxo2 != null) {
                        oooxoxo2.invoke(Boolean.TRUE);
                        return;
                    }
                    return;
                }
                if (i != 2) {
                    if (i != 3) {
                        return;
                    }
                    PermissionHelper.XxX0x0xxx(PermissionHelper.f24522oIX0oI, context, null, null, 6, null);
                } else {
                    oOoXoXO<Boolean, oXIO0o0XI> oooxoxo3 = oooxoxo;
                    if (oooxoxo3 != null) {
                        oooxoxo3.invoke(Boolean.FALSE);
                    }
                }
            }
        }, 3, null);
    }

    public final void oO(@OOXIXo final Context context, @OXOo.oOoXoXO final oOoXoXO<? super Boolean, oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(context, "context");
        PermissionUtils permission = PermissionUtils.permission(PermissionConstants.SMS);
        IIX0o.oO(permission, "permission(...)");
        oOXoIIIo.X0o0xo.I0Io(permission, null, null, new oOoXoXO<PermissionStatus, oXIO0o0XI>() { // from class: com.sma.smartv3.util.permission.PermissionHelper$applySmsPermission$1

            /* loaded from: classes12.dex */
            public /* synthetic */ class oIX0oI {

                /* renamed from: oIX0oI, reason: collision with root package name */
                public static final /* synthetic */ int[] f24536oIX0oI;

                static {
                    int[] iArr = new int[PermissionStatus.values().length];
                    try {
                        iArr[PermissionStatus.GRANTED.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[PermissionStatus.DENIED.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[PermissionStatus.DENIED_FOREVER.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    f24536oIX0oI = iArr;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(PermissionStatus permissionStatus) {
                invoke2(permissionStatus);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OOXIXo PermissionStatus it) {
                IIX0o.x0xO0oo(it, "it");
                int i = oIX0oI.f24536oIX0oI[it.ordinal()];
                if (i == 1) {
                    oOoXoXO<Boolean, oXIO0o0XI> oooxoxo2 = oooxoxo;
                    if (oooxoxo2 != null) {
                        oooxoxo2.invoke(Boolean.TRUE);
                    }
                    if (RomUtils.isXiaomi()) {
                        PermissionHelper.f24522oIX0oI.IIX0o(context);
                        return;
                    }
                    return;
                }
                if (i != 2) {
                    if (i != 3) {
                        return;
                    }
                    PermissionHelper.XxX0x0xxx(PermissionHelper.f24522oIX0oI, context, null, null, 6, null);
                } else {
                    oOoXoXO<Boolean, oXIO0o0XI> oooxoxo3 = oooxoxo;
                    if (oooxoxo3 != null) {
                        oooxoxo3.invoke(Boolean.FALSE);
                    }
                }
            }
        }, 3, null);
    }

    public final void ooOOo0oXI(@OOXIXo final Context context, @OXOo.oOoXoXO final oOoXoXO<? super Boolean, oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(context, "context");
        PermissionUtils permission = PermissionUtils.permission(PermissionConstants.PHONE);
        IIX0o.oO(permission, "permission(...)");
        oOXoIIIo.X0o0xo.I0Io(permission, null, null, new oOoXoXO<PermissionStatus, oXIO0o0XI>() { // from class: com.sma.smartv3.util.permission.PermissionHelper$applyPhonePermission$1

            /* loaded from: classes12.dex */
            public /* synthetic */ class oIX0oI {

                /* renamed from: oIX0oI, reason: collision with root package name */
                public static final /* synthetic */ int[] f24534oIX0oI;

                static {
                    int[] iArr = new int[PermissionStatus.values().length];
                    try {
                        iArr[PermissionStatus.GRANTED.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[PermissionStatus.DENIED.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[PermissionStatus.DENIED_FOREVER.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    f24534oIX0oI = iArr;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(PermissionStatus permissionStatus) {
                invoke2(permissionStatus);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OOXIXo PermissionStatus it) {
                IIX0o.x0xO0oo(it, "it");
                int i = oIX0oI.f24534oIX0oI[it.ordinal()];
                if (i == 1) {
                    oOoXoXO<Boolean, oXIO0o0XI> oooxoxo2 = oooxoxo;
                    if (oooxoxo2 != null) {
                        oooxoxo2.invoke(Boolean.TRUE);
                        return;
                    }
                    return;
                }
                if (i != 2) {
                    if (i != 3) {
                        return;
                    }
                    PermissionHelper.XxX0x0xxx(PermissionHelper.f24522oIX0oI, context, null, null, 6, null);
                } else {
                    oOoXoXO<Boolean, oXIO0o0XI> oooxoxo3 = oooxoxo;
                    if (oooxoxo3 != null) {
                        oooxoxo3.invoke(Boolean.FALSE);
                    }
                }
            }
        }, 3, null);
    }

    @RequiresApi(31)
    public final void oxoX(@OOXIXo final Context context, @OXOo.oOoXoXO final oOoXoXO<? super Boolean, oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(context, "context");
        PermissionUtils permission = PermissionUtils.permission("android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_CONNECT");
        IIX0o.oO(permission, "permission(...)");
        String string = context.getString(R.string.bluetooth_explain_title);
        IIX0o.oO(string, "getString(...)");
        String string2 = context.getString(R.string.bluetooth_explain_content);
        IIX0o.oO(string2, "getString(...)");
        oOXoIIIo.X0o0xo.II0xO0(permission, string, string2, new oOoXoXO<PermissionStatus, oXIO0o0XI>() { // from class: com.sma.smartv3.util.permission.PermissionHelper$applyBluetoothPermission$1

            /* loaded from: classes12.dex */
            public /* synthetic */ class oIX0oI {

                /* renamed from: oIX0oI, reason: collision with root package name */
                public static final /* synthetic */ int[] f24526oIX0oI;

                static {
                    int[] iArr = new int[PermissionStatus.values().length];
                    try {
                        iArr[PermissionStatus.GRANTED.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[PermissionStatus.DENIED.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[PermissionStatus.DENIED_FOREVER.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    f24526oIX0oI = iArr;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(PermissionStatus permissionStatus) {
                invoke2(permissionStatus);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OOXIXo PermissionStatus it) {
                IIX0o.x0xO0oo(it, "it");
                int i = oIX0oI.f24526oIX0oI[it.ordinal()];
                if (i == 1) {
                    oOoXoXO<Boolean, oXIO0o0XI> oooxoxo2 = oooxoxo;
                    if (oooxoxo2 != null) {
                        oooxoxo2.invoke(Boolean.TRUE);
                        return;
                    }
                    return;
                }
                if (i == 2) {
                    oOoXoXO<Boolean, oXIO0o0XI> oooxoxo3 = oooxoxo;
                    if (oooxoxo3 != null) {
                        oooxoxo3.invoke(Boolean.FALSE);
                        return;
                    }
                    return;
                }
                if (i != 3) {
                    return;
                }
                PermissionHelper permissionHelper = PermissionHelper.f24522oIX0oI;
                Context context2 = context;
                String string3 = context2.getString(R.string.request_bluetooth_permission_denied_tip);
                IIX0o.oO(string3, "getString(...)");
                PermissionHelper.XxX0x0xxx(permissionHelper, context2, string3, null, 4, null);
            }
        });
    }

    public final void x0XOIxOo(@OOXIXo Context context, @OXOo.oOoXoXO final oOoXoXO<? super Boolean, oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(context, "context");
        if (Build.VERSION.SDK_INT >= 33) {
            PermissionUtils permission = PermissionUtils.permission(x.cC);
            IIX0o.oO(permission, "permission(...)");
            String string = context.getString(R.string.notification_explain_title);
            IIX0o.oO(string, "getString(...)");
            String string2 = context.getString(R.string.notification_explain_content);
            IIX0o.oO(string2, "getString(...)");
            oOXoIIIo.X0o0xo.II0xO0(permission, string, string2, new oOoXoXO<PermissionStatus, oXIO0o0XI>() { // from class: com.sma.smartv3.util.permission.PermissionHelper$applyPostNotificationsPermission$1

                /* loaded from: classes12.dex */
                public /* synthetic */ class oIX0oI {

                    /* renamed from: oIX0oI, reason: collision with root package name */
                    public static final /* synthetic */ int[] f24535oIX0oI;

                    static {
                        int[] iArr = new int[PermissionStatus.values().length];
                        try {
                            iArr[PermissionStatus.GRANTED.ordinal()] = 1;
                        } catch (NoSuchFieldError unused) {
                        }
                        f24535oIX0oI = iArr;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(PermissionStatus permissionStatus) {
                    invoke2(permissionStatus);
                    return oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OOXIXo PermissionStatus it) {
                    IIX0o.x0xO0oo(it, "it");
                    if (oIX0oI.f24535oIX0oI[it.ordinal()] == 1) {
                        oOoXoXO<Boolean, oXIO0o0XI> oooxoxo2 = oooxoxo;
                        if (oooxoxo2 != null) {
                            oooxoxo2.invoke(Boolean.TRUE);
                            return;
                        }
                        return;
                    }
                    oOoXoXO<Boolean, oXIO0o0XI> oooxoxo3 = oooxoxo;
                    if (oooxoxo3 != null) {
                        oooxoxo3.invoke(Boolean.FALSE);
                    }
                    OI0.oIX0oI.f1507oIX0oI.oIX0oI("No post notifications permission!!!");
                }
            });
        }
    }

    @OOXIXo
    public final String x0xO0oo(@OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "context");
        StringBuilder sb = new StringBuilder();
        sb.append("notificationSer: ");
        sb.append(MyNotificationListenerService.f20319OxI.X0o0xo(context));
        sb.append("\nlocation: ");
        sb.append(PermissionUtils.isGranted(PermissionConstants.LOCATION));
        sb.append("\nbgLocation: ");
        sb.append(oI0IIXIo(context));
        sb.append("\ncall: ");
        String[] oIX0oI2 = X00xOoXI.oIX0oI();
        sb.append(PermissionUtils.isGranted((String[]) Arrays.copyOf(oIX0oI2, oIX0oI2.length)));
        sb.append("contacts: ");
        sb.append(IIXOooo(context));
        sb.append("\nphone: ");
        sb.append(O0xOxO(context));
        sb.append("\nsms: ");
        sb.append(XI0IXoo(context));
        sb.append("\nsd: ");
        sb.append(xoXoI(context));
        sb.append("\nbattery: ");
        sb.append(o00(context));
        return sb.toString();
    }

    public final void xXxxox0I(@OOXIXo Context context, @OOXIXo final oOoXoXO<? super Boolean, oXIO0o0XI> callback) {
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(callback, "callback");
        XoI0Ixx0 xoI0Ixx0 = new XoI0Ixx0((Activity) context, 0, 2, null);
        xoI0Ixx0.IoOoX(R.string.location_permissions);
        xoI0Ixx0.oo(context.getString(R.string.request_background_location_permission_tip, AppUtils.getAppName()));
        XoI0Ixx0.IO(xoI0Ixx0, Integer.valueOf(R.string.cancel), null, 2, null);
        xoI0Ixx0.x0o(R.string.settings, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.util.permission.PermissionHelper$showLocationExplainPopup$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            @OOXIXo
            public final Boolean invoke() {
                oOoXoXO<Boolean, oXIO0o0XI> oooxoxo = callback;
                Boolean bool = Boolean.TRUE;
                oooxoxo.invoke(bool);
                return bool;
            }
        });
        xoI0Ixx0.IIXOooo();
    }

    public final boolean xoXoI(@OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "context");
        return PermissionUtils.isGranted(g.i, g.j);
    }

    public final void xxIXOIIO(@OOXIXo final Context context, final boolean z, @OXOo.oOoXoXO final oOoXoXO<? super Boolean, oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(context, "context");
        PermissionUtils permission = PermissionUtils.permission(PermissionConstants.LOCATION);
        IIX0o.oO(permission, "permission(...)");
        String string = context.getString(R.string.location_explain_title);
        IIX0o.oO(string, "getString(...)");
        String string2 = context.getString(R.string.location_explain_content);
        IIX0o.oO(string2, "getString(...)");
        oOXoIIIo.X0o0xo.II0xO0(permission, string, string2, new oOoXoXO<PermissionStatus, oXIO0o0XI>() { // from class: com.sma.smartv3.util.permission.PermissionHelper$applyLocationPermission$1

            /* loaded from: classes12.dex */
            public /* synthetic */ class oIX0oI {

                /* renamed from: oIX0oI, reason: collision with root package name */
                public static final /* synthetic */ int[] f24531oIX0oI;

                static {
                    int[] iArr = new int[PermissionStatus.values().length];
                    try {
                        iArr[PermissionStatus.GRANTED.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[PermissionStatus.DENIED.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[PermissionStatus.DENIED_FOREVER.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    f24531oIX0oI = iArr;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(PermissionStatus permissionStatus) {
                invoke2(permissionStatus);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OOXIXo PermissionStatus it) {
                IIX0o.x0xO0oo(it, "it");
                int i = oIX0oI.f24531oIX0oI[it.ordinal()];
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            return;
                        }
                        PermissionHelper.XxX0x0xxx(PermissionHelper.f24522oIX0oI, context, null, null, 6, null);
                        return;
                    } else {
                        oOoXoXO<Boolean, oXIO0o0XI> oooxoxo2 = oooxoxo;
                        if (oooxoxo2 != null) {
                            oooxoxo2.invoke(Boolean.FALSE);
                            return;
                        }
                        return;
                    }
                }
                if (z) {
                    Context context2 = context;
                    IIX0o.x0XOIxOo(context2, "null cannot be cast to non-null type android.app.Activity");
                    XoI0Ixx0 xoI0Ixx0 = new XoI0Ixx0((Activity) context2, 0, 2, null);
                    final Context context3 = context;
                    final oOoXoXO<Boolean, oXIO0o0XI> oooxoxo3 = oooxoxo;
                    xoI0Ixx0.IoOoX(R.string.request_background_location_permission_title);
                    xoI0Ixx0.oo(context3.getString(R.string.request_background_location_permission_tip, AppUtils.getAppName()));
                    xoI0Ixx0.X00IoxXI(Integer.valueOf(R.string.cancel), new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.util.permission.PermissionHelper$applyLocationPermission$1$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // Oox.oIX0oI
                        @OOXIXo
                        public final Boolean invoke() {
                            oOoXoXO<Boolean, oXIO0o0XI> oooxoxo4 = oooxoxo3;
                            if (oooxoxo4 != null) {
                                oooxoxo4.invoke(Boolean.TRUE);
                            }
                            return Boolean.TRUE;
                        }
                    });
                    xoI0Ixx0.x0o(R.string.settings, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.util.permission.PermissionHelper$applyLocationPermission$1$1$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // Oox.oIX0oI
                        @OOXIXo
                        public final Boolean invoke() {
                            PermissionUtils permission2 = PermissionUtils.permission("android.permission.ACCESS_BACKGROUND_LOCATION");
                            IIX0o.oO(permission2, "permission(...)");
                            final Context context4 = context3;
                            final oOoXoXO<Boolean, oXIO0o0XI> oooxoxo4 = oooxoxo3;
                            oOXoIIIo.X0o0xo.I0Io(permission2, null, null, new oOoXoXO<PermissionStatus, oXIO0o0XI>() { // from class: com.sma.smartv3.util.permission.PermissionHelper$applyLocationPermission$1$1$2.1

                                /* renamed from: com.sma.smartv3.util.permission.PermissionHelper$applyLocationPermission$1$1$2$1$oIX0oI */
                                /* loaded from: classes12.dex */
                                public /* synthetic */ class oIX0oI {

                                    /* renamed from: oIX0oI, reason: collision with root package name */
                                    public static final /* synthetic */ int[] f24530oIX0oI;

                                    static {
                                        int[] iArr = new int[PermissionStatus.values().length];
                                        try {
                                            iArr[PermissionStatus.DENIED_FOREVER.ordinal()] = 1;
                                        } catch (NoSuchFieldError unused) {
                                        }
                                        f24530oIX0oI = iArr;
                                    }
                                }

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // Oox.oOoXoXO
                                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(PermissionStatus permissionStatus) {
                                    invoke2(permissionStatus);
                                    return oXIO0o0XI.f29392oIX0oI;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(@OOXIXo PermissionStatus status) {
                                    IIX0o.x0xO0oo(status, "status");
                                    if (oIX0oI.f24530oIX0oI[status.ordinal()] == 1) {
                                        PermissionHelper permissionHelper = PermissionHelper.f24522oIX0oI;
                                        Context context5 = context4;
                                        String string3 = context5.getString(R.string.request_background_location_permission_denied_tip, AppUtils.getAppName(), AppUtils.getAppName());
                                        IIX0o.oO(string3, "getString(...)");
                                        String string4 = context4.getString(R.string.location_permissions);
                                        IIX0o.oO(string4, "getString(...)");
                                        permissionHelper.xxX(context5, string3, string4);
                                        return;
                                    }
                                    oOoXoXO<Boolean, oXIO0o0XI> oooxoxo5 = oooxoxo4;
                                    if (oooxoxo5 != null) {
                                        oooxoxo5.invoke(Boolean.TRUE);
                                    }
                                }
                            }, 3, null);
                            return Boolean.TRUE;
                        }
                    });
                    xoI0Ixx0.IIXOooo();
                    return;
                }
                oOoXoXO<Boolean, oXIO0o0XI> oooxoxo4 = oooxoxo;
                if (oooxoxo4 != null) {
                    oooxoxo4.invoke(Boolean.TRUE);
                }
            }
        });
    }

    public final void xxX(@OOXIXo Context context, @OOXIXo String text, @OOXIXo String title) {
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(text, "text");
        IIX0o.x0xO0oo(title, "title");
        XoI0Ixx0 xoI0Ixx0 = new XoI0Ixx0((Activity) context, 0, 2, null);
        if (title.length() > 0) {
            xoI0Ixx0.Xx000oIo(title);
        } else {
            xoI0Ixx0.IoOoX(R.string.tip);
        }
        if (text.length() > 0) {
            xoI0Ixx0.oo(text);
        } else {
            xoI0Ixx0.xI(Integer.valueOf(R.string.permission_set_remind));
        }
        XoI0Ixx0.IO(xoI0Ixx0, Integer.valueOf(R.string.cancel), null, 2, null);
        xoI0Ixx0.x0o(R.string.settings, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.util.permission.PermissionHelper$permissionRemind$1$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            @OOXIXo
            public final Boolean invoke() {
                PermissionUtils.launchAppDetailsSettings();
                return Boolean.TRUE;
            }
        });
        xoI0Ixx0.IIXOooo();
    }
}
