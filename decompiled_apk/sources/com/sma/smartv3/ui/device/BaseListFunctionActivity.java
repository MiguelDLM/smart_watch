package com.sma.smartv3.ui.device;

import android.content.Intent;
import android.view.View;
import com.bestmafen.androidbase.list.BaseListActivity;
import com.blankj.utilcode.util.PermissionUtils;
import com.sma.smartv3.co_fit.R;

/* loaded from: classes12.dex */
public abstract class BaseListFunctionActivity<T> extends BaseListActivity<T> {

    @OXOo.OOXIXo
    public static final oIX0oI Companion = new oIX0oI(null);
    public static final int REQUEST_ENABLE_BLUETOOTH = 1;
    public static final int REQUEST_LOCATION_SERVER = 2;
    public static final int REQUEST_PERMISSION_SERVER = 3;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.XoI0Ixx0 mLocationServerPopup;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.XoI0Ixx0 mPermissionBackgroundPopup;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.XoI0Ixx0 mPermissionPopup;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO rootView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>(this) { // from class: com.sma.smartv3.ui.device.BaseListFunctionActivity$rootView$2
        final /* synthetic */ BaseListFunctionActivity<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
            this.this$0 = this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return this.this$0.findViewById(R.id.root_view);
        }
    });

    /* loaded from: classes12.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        public oIX0oI() {
        }
    }

    @OXOo.oOoXoXO
    public final com.sma.smartv3.pop.XoI0Ixx0 getMPermissionBackgroundPopup() {
        return this.mPermissionBackgroundPopup;
    }

    public final View getRootView() {
        return (View) this.rootView$delegate.getValue();
    }

    public final void locationServerRemind() {
        if (this.mLocationServerPopup == null) {
            com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0 = new com.sma.smartv3.pop.XoI0Ixx0(this, 0, 2, null);
            xoI0Ixx0.IoOoX(R.string.location_server_notification);
            com.sma.smartv3.pop.XoI0Ixx0.IO(xoI0Ixx0, Integer.valueOf(R.string.cancel), null, 2, null);
            xoI0Ixx0.x0o(R.string.settings, new Oox.oIX0oI<Boolean>(this) { // from class: com.sma.smartv3.ui.device.BaseListFunctionActivity$locationServerRemind$1$1
                final /* synthetic */ BaseListFunctionActivity<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.this$0 = this;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OXOo.OOXIXo
                public final Boolean invoke() {
                    this.this$0.startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 2);
                    return Boolean.TRUE;
                }
            });
            this.mLocationServerPopup = xoI0Ixx0;
        }
        com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx02 = this.mLocationServerPopup;
        if (xoI0Ixx02 != null) {
            View rootView = getRootView();
            kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
            xoI0Ixx02.OxxIIOOXO(rootView);
        }
    }

    public final void permissionRemind() {
        if (this.mPermissionPopup == null) {
            com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0 = new com.sma.smartv3.pop.XoI0Ixx0(this, 0, 2, null);
            xoI0Ixx0.IoOoX(R.string.permission_set_remind);
            com.sma.smartv3.pop.XoI0Ixx0.IO(xoI0Ixx0, Integer.valueOf(R.string.cancel), null, 2, null);
            xoI0Ixx0.x0o(R.string.settings, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.device.BaseListFunctionActivity$permissionRemind$1$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OXOo.OOXIXo
                public final Boolean invoke() {
                    PermissionUtils.launchAppDetailsSettings();
                    return Boolean.TRUE;
                }
            });
            this.mPermissionPopup = xoI0Ixx0;
        }
        com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx02 = this.mPermissionPopup;
        if (xoI0Ixx02 != null) {
            View rootView = getRootView();
            kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
            xoI0Ixx02.OxxIIOOXO(rootView);
        }
    }

    public final void setMPermissionBackgroundPopup(@OXOo.oOoXoXO com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0) {
        this.mPermissionBackgroundPopup = xoI0Ixx0;
    }
}
