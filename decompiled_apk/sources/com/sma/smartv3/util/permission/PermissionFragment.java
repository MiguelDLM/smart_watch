package com.sma.smartv3.util.permission;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.blankj.utilcode.util.RomUtils;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class PermissionFragment extends Fragment {

    /* renamed from: IXxxXO, reason: collision with root package name */
    @oOoXoXO
    public static X0o0xo f24518IXxxXO;

    /* renamed from: XO, reason: collision with root package name */
    @OOXIXo
    public static final oIX0oI f24520XO = new oIX0oI(null);

    /* renamed from: Oo, reason: collision with root package name */
    @OOXIXo
    public static PermissionType f24519Oo = PermissionType.AUTO_RUN;

    /* loaded from: classes12.dex */
    public /* synthetic */ class II0xO0 {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f24521oIX0oI;

        static {
            int[] iArr = new int[PermissionType.values().length];
            try {
                iArr[PermissionType.AUTO_RUN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PermissionType.BATTERY_OPTIMIZATIONS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f24521oIX0oI = iArr;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes12.dex */
    public static final class PermissionType {
        private static final /* synthetic */ kotlin.enums.oIX0oI $ENTRIES;
        private static final /* synthetic */ PermissionType[] $VALUES;
        public static final PermissionType AUTO_RUN = new PermissionType(com.sma.smartv3.util.permission.oIX0oI.f24542II0xO0, 0);
        public static final PermissionType BATTERY_OPTIMIZATIONS = new PermissionType("BATTERY_OPTIMIZATIONS", 1);

        private static final /* synthetic */ PermissionType[] $values() {
            return new PermissionType[]{AUTO_RUN, BATTERY_OPTIMIZATIONS};
        }

        static {
            PermissionType[] $values = $values();
            $VALUES = $values;
            $ENTRIES = kotlin.enums.I0Io.I0Io($values);
        }

        private PermissionType(String str, int i) {
        }

        @OOXIXo
        public static kotlin.enums.oIX0oI<PermissionType> getEntries() {
            return $ENTRIES;
        }

        public static PermissionType valueOf(String str) {
            return (PermissionType) Enum.valueOf(PermissionType.class, str);
        }

        public static PermissionType[] values() {
            return (PermissionType[]) $VALUES.clone();
        }
    }

    /* loaded from: classes12.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(IIXOooo iIXOooo) {
            this();
        }

        public final void I0Io(@OOXIXo PermissionType permissionType) {
            IIX0o.x0xO0oo(permissionType, "<set-?>");
            PermissionFragment.f24519Oo = permissionType;
        }

        public final void II0xO0(@OOXIXo Activity activity, @OOXIXo PermissionType permissionType, @OOXIXo X0o0xo onPermissionResult) {
            IIX0o.x0xO0oo(activity, "activity");
            IIX0o.x0xO0oo(permissionType, "permissionType");
            IIX0o.x0xO0oo(onPermissionResult, "onPermissionResult");
            PermissionFragment.f24520XO.I0Io(permissionType);
            PermissionFragment.f24518IXxxXO = onPermissionResult;
            activity.getFragmentManager().beginTransaction().add(new PermissionFragment(), activity.getLocalClassName()).commitAllowingStateLoss();
        }

        @OOXIXo
        public final PermissionType oIX0oI() {
            return PermissionFragment.f24519Oo;
        }

        public oIX0oI() {
        }
    }

    public static final void XO(int i, PermissionFragment this$0) {
        IIX0o.x0xO0oo(this$0, "this$0");
        if (i != 101) {
            if (i == 201) {
                Activity activity = this$0.getActivity();
                IIX0o.oO(activity, "getActivity(...)");
                this$0.X0o0xo(oxoX.II0xO0(activity));
                return;
            }
            return;
        }
        this$0.X0o0xo(false);
    }

    public final void X0o0xo(boolean z) {
        X0o0xo x0o0xo = f24518IXxxXO;
        if (x0o0xo != null) {
            x0o0xo.oIX0oI(z);
        }
        if (!RomUtils.isSamsung() && !RomUtils.isOppo()) {
            getFragmentManager().beginTransaction().remove(this).commitAllowingStateLoss();
        }
    }

    @Override // android.app.Fragment
    public void onActivityCreated(@oOoXoXO Bundle bundle) {
        super.onActivityCreated(bundle);
        int i = II0xO0.f24521oIX0oI[f24519Oo.ordinal()];
        if (i != 1) {
            if (i == 2) {
                oxoX.f24545oIX0oI.oxoX(this);
                return;
            }
            return;
        }
        com.sma.smartv3.util.permission.oIX0oI.f24543oIX0oI.xoIox(this);
    }

    @Override // android.app.Fragment
    public void onActivityResult(final int i, int i2, @oOoXoXO Intent intent) {
        new Handler().postDelayed(new Runnable() { // from class: com.sma.smartv3.util.permission.XO
            @Override // java.lang.Runnable
            public final void run() {
                PermissionFragment.XO(i, this);
            }
        }, 500L);
    }
}
