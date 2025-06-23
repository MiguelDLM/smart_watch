package com.sma.smartv3.ui.me;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.annotation.RequiresApi;
import com.bestmafen.androidbase.extension.PermissionStatus;
import com.bestmafen.baseble.scanner.BleDevice;
import com.bestmafen.baseble.scanner.ScanMode;
import com.blankj.utilcode.constant.PermissionConstants;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.kuaishou.weapon.p0.g;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.ui.device.BaseListFunctionActivity;
import com.sma.smartv3.util.UtilsKt;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@kotlin.jvm.internal.XX({"SMAP\nDeveloperTuyaStartActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeveloperTuyaStartActivity.kt\ncom/sma/smartv3/ui/me/DeveloperTuyaStartActivity\n+ 2 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,165:1\n69#2,3:166\n72#2,5:170\n1#3:169\n*S KotlinDebug\n*F\n+ 1 DeveloperTuyaStartActivity.kt\ncom/sma/smartv3/ui/me/DeveloperTuyaStartActivity\n*L\n66#1:166,3\n66#1:170,5\n66#1:169\n*E\n"})
/* loaded from: classes11.dex */
public final class DeveloperTuyaStartActivity extends BaseListFunctionActivity<BleDevice> {

    @OXOo.OOXIXo
    private final kotlin.X0IIOO etOldBleName$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<EditText>() { // from class: com.sma.smartv3.ui.me.DeveloperTuyaStartActivity$etOldBleName$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final EditText invoke() {
            return (EditText) DeveloperTuyaStartActivity.this.findViewById(R.id.et_old_ble_name);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO etSignal$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<EditText>() { // from class: com.sma.smartv3.ui.me.DeveloperTuyaStartActivity$etSignal$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final EditText invoke() {
            return (EditText) DeveloperTuyaStartActivity.this.findViewById(R.id.et_signal);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mScanner$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<XOxIOxOx.II0xO0>() { // from class: com.sma.smartv3.ui.me.DeveloperTuyaStartActivity$mScanner$2

        @kotlin.jvm.internal.XX({"SMAP\nDeveloperTuyaStartActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeveloperTuyaStartActivity.kt\ncom/sma/smartv3/ui/me/DeveloperTuyaStartActivity$mScanner$2$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,165:1\n1002#2,2:166\n*S KotlinDebug\n*F\n+ 1 DeveloperTuyaStartActivity.kt\ncom/sma/smartv3/ui/me/DeveloperTuyaStartActivity$mScanner$2$2\n*L\n52#1:166,2\n*E\n"})
        /* loaded from: classes11.dex */
        public static final class II0xO0 implements XOxIOxOx.oxoX {

            /* renamed from: oIX0oI, reason: collision with root package name */
            public final /* synthetic */ DeveloperTuyaStartActivity f23257oIX0oI;

            @kotlin.jvm.internal.XX({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2\n+ 2 DeveloperTuyaStartActivity.kt\ncom/sma/smartv3/ui/me/DeveloperTuyaStartActivity$mScanner$2$2\n*L\n1#1,328:1\n52#2:329\n*E\n"})
            /* loaded from: classes11.dex */
            public static final class oIX0oI<T> implements Comparator {
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return xX0ox.Oxx0IOOO.oOoXoXO(Integer.valueOf(-((BleDevice) t).getMRssi()), Integer.valueOf(-((BleDevice) t2).getMRssi()));
                }
            }

            public II0xO0(DeveloperTuyaStartActivity developerTuyaStartActivity) {
                this.f23257oIX0oI = developerTuyaStartActivity;
            }

            @Override // XOxIOxOx.oxoX
            public void I0Io() {
            }

            @Override // XOxIOxOx.oxoX
            public void II0xO0(@OXOo.OOXIXo BleDevice device) {
                List mList;
                List mList2;
                List mList3;
                XIOOI.oIX0oI mListAdapter;
                kotlin.jvm.internal.IIX0o.x0xO0oo(device, "device");
                mList = this.f23257oIX0oI.getMList();
                if (!mList.contains(device)) {
                    mList2 = this.f23257oIX0oI.getMList();
                    mList2.add(device);
                    mList3 = this.f23257oIX0oI.getMList();
                    if (mList3.size() > 1) {
                        kotlin.collections.o00.OO0x0xX(mList3, new oIX0oI());
                    }
                    mListAdapter = this.f23257oIX0oI.getMListAdapter();
                    mListAdapter.notifyDataSetChanged();
                }
            }

            @Override // XOxIOxOx.oxoX
            public void oIX0oI(boolean z) {
            }
        }

        /* loaded from: classes11.dex */
        public static final class oIX0oI implements XOxIOxOx.X0o0xo {
            @Override // XOxIOxOx.X0o0xo
            public boolean oIX0oI(@OXOo.OOXIXo BleDevice device) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(device, "device");
                com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
                String string = xo0.II0xO0().getString(com.sma.smartv3.util.XoI0Ixx0.f24429XoI0Ixx0, "");
                kotlin.jvm.internal.IIX0o.oO(string, "getString(...)");
                if (string.length() == 0) {
                    if (device.getMRssi() <= xo0.II0xO0().getInt(com.sma.smartv3.util.XoI0Ixx0.f24428Xo0, -60)) {
                        return false;
                    }
                } else if (device.getMRssi() <= xo0.II0xO0().getInt(com.sma.smartv3.util.XoI0Ixx0.f24428Xo0, -60) || !kotlin.jvm.internal.IIX0o.Oxx0IOOO(ProductManager.f20544oIX0oI.x0xO0oo(device.getMName()), xo0.II0xO0().getString(com.sma.smartv3.util.XoI0Ixx0.f24429XoI0Ixx0, ""))) {
                    return false;
                }
                return true;
            }
        }

        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final XOxIOxOx.II0xO0 invoke() {
            return XOxIOxOx.oO.II0xO0(XOxIOxOx.oO.f3971oIX0oI, null, ScanMode.LOW_LATENCY, 1, null).Oo(10).IXxxXO(new oIX0oI()).ooOOo0oXI(new II0xO0(DeveloperTuyaStartActivity.this));
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public final EditText getEtOldBleName() {
        return (EditText) this.etOldBleName$delegate.getValue();
    }

    private final EditText getEtSignal() {
        return (EditText) this.etSignal$delegate.getValue();
    }

    private final XOxIOxOx.II0xO0 getMScanner() {
        return (XOxIOxOx.II0xO0) this.mScanner$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(DeveloperTuyaStartActivity this$0, AdapterView adapterView, View view, int i, long j) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        Bundle bundle = new Bundle();
        bundle.putString("name", this$0.getMList().get(i).getMName());
        String address = this$0.getMList().get(i).getMBluetoothDevice().getAddress();
        kotlin.jvm.internal.IIX0o.oO(address, "getAddress(...)");
        bundle.putString("mac", kotlin.text.OxI.IIOIX(address, ":", "", false, 4, null));
        Intent intent = new Intent(this$0, (Class<?>) DeveloperTuyaQueryActivity.class);
        intent.putExtras(bundle);
        this$0.startActivity(intent);
    }

    @RequiresApi(29)
    private final void permissionBackgroundLocationRemind() {
        if (getMPermissionBackgroundPopup() == null) {
            com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0 = new com.sma.smartv3.pop.XoI0Ixx0(this, 0, 2, null);
            xoI0Ixx0.IoOoX(R.string.background_set_remind);
            com.sma.smartv3.pop.XoI0Ixx0.IO(xoI0Ixx0, Integer.valueOf(R.string.cancel), null, 2, null);
            xoI0Ixx0.x0o(R.string.settings, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.me.DeveloperTuyaStartActivity$permissionBackgroundLocationRemind$1$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OXOo.OOXIXo
                public final Boolean invoke() {
                    Activity mContext;
                    mContext = DeveloperTuyaStartActivity.this.getMContext();
                    mContext.requestPermissions(new String[]{g.g, "android.permission.ACCESS_BACKGROUND_LOCATION"}, 3);
                    return Boolean.TRUE;
                }
            });
            setMPermissionBackgroundPopup(xoI0Ixx0);
        }
        com.sma.smartv3.pop.XoI0Ixx0 mPermissionBackgroundPopup = getMPermissionBackgroundPopup();
        if (mPermissionBackgroundPopup != null) {
            View rootView = getRootView();
            kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
            mPermissionBackgroundPopup.OxxIIOOXO(rootView);
        }
    }

    private final void requestEnableBluetooth() {
        oOXoIIIo.oIX0oI.IXxxXO(this, "android.bluetooth.adapter.action.REQUEST_ENABLE", 1, 0, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestLocationPermission() {
        if (Build.VERSION.SDK_INT >= 29) {
            permissionBackgroundLocationRemind();
            return;
        }
        PermissionUtils permission = PermissionUtils.permission(PermissionConstants.LOCATION);
        kotlin.jvm.internal.IIX0o.oO(permission, "permission(...)");
        oOXoIIIo.X0o0xo.I0Io(permission, null, null, new Oox.oOoXoXO<PermissionStatus, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.DeveloperTuyaStartActivity$requestLocationPermission$1

            /* loaded from: classes11.dex */
            public /* synthetic */ class oIX0oI {

                /* renamed from: oIX0oI, reason: collision with root package name */
                public static final /* synthetic */ int[] f23258oIX0oI;

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
                    f23258oIX0oI = iArr;
                }
            }

            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(PermissionStatus permissionStatus) {
                invoke2(permissionStatus);
                return kotlin.oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo PermissionStatus it) {
                EditText etOldBleName;
                kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                int i = oIX0oI.f23258oIX0oI[it.ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        DeveloperTuyaStartActivity.this.requestLocationPermission();
                        return;
                    } else {
                        DeveloperTuyaStartActivity.this.permissionRemind();
                        return;
                    }
                }
                DeveloperTuyaStartActivity developerTuyaStartActivity = DeveloperTuyaStartActivity.this;
                etOldBleName = developerTuyaStartActivity.getEtOldBleName();
                kotlin.jvm.internal.IIX0o.oO(etOldBleName, "access$getEtOldBleName(...)");
                developerTuyaStartActivity.startSearch(etOldBleName);
            }
        }, 3, null);
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.list.II0xO0
    @OXOo.OOXIXo
    public List<BleDevice> initList() {
        return new ArrayList();
    }

    @Override // com.bestmafen.androidbase.list.BaseListActivity, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        getMListView().setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.sma.smartv3.ui.me.x0OxxIOxX
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                DeveloperTuyaStartActivity.initView$lambda$1(DeveloperTuyaStartActivity.this, adapterView, view, i, j);
            }
        });
    }

    @Override // com.bestmafen.androidbase.list.II0xO0
    public int itemLayoutId() {
        return R.layout.item_device;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_developer_test_tuya_start;
    }

    @Override // com.bestmafen.androidbase.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        getMScanner().II0xO0();
    }

    public final void startSearch(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (!PermissionUtils.isGranted(g.g)) {
            requestLocationPermission();
            return;
        }
        if (!BluetoothAdapter.getDefaultAdapter().isEnabled()) {
            requestEnableBluetooth();
            return;
        }
        if (!UtilsKt.oo()) {
            locationServerRemind();
            return;
        }
        ToastUtils.showLong(R.string.search_device_remind);
        if (getEtSignal().getText().toString().length() == 0) {
            getEtSignal().setText("60");
        }
        com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
        xo0.II0xO0().put(com.sma.smartv3.util.XoI0Ixx0.f24428Xo0, -Integer.parseInt(getEtSignal().getText().toString()));
        xo0.II0xO0().put(com.sma.smartv3.util.XoI0Ixx0.f24429XoI0Ixx0, getEtOldBleName().getText().toString());
        getMList().clear();
        getMListAdapter().notifyDataSetChanged();
        getMScanner().oOoXoXO(true);
    }

    @Override // com.bestmafen.androidbase.list.I0Io
    public void initItem(@OXOo.OOXIXo XIOOI.I0Io holder, @OXOo.OOXIXo BleDevice item, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(holder, "holder");
        kotlin.jvm.internal.IIX0o.x0xO0oo(item, "item");
        holder.o00(R.id.tv_name, item.getMName());
        holder.o00(R.id.tv_address, item.getMBluetoothDevice().getAddress());
        ((ImageView) holder.X0o0xo(R.id.iv_rssi)).setImageLevel(-item.getMRssi());
    }
}
