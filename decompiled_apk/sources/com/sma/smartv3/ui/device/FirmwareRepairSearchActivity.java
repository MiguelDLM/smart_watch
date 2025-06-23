package com.sma.smartv3.ui.device;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.bestmafen.baseble.scanner.BleDevice;
import com.bestmafen.baseble.scanner.ScanMode;
import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.initializer.BleInitializer;
import com.sma.smartv3.model.FirmwareVersion;
import com.sma.smartv3.util.UtilsKt;
import com.szabh.smable3.component.BleConnector;
import com.szabh.smable3.entity.BleDeviceInfo;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.text.StringsKt__StringsKt;

@kotlin.jvm.internal.XX({"SMAP\nFirmwareRepairSearchActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FirmwareRepairSearchActivity.kt\ncom/sma/smartv3/ui/device/FirmwareRepairSearchActivity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,170:1\n18#2,2:171\n15#2:173\n15#2:174\n11#2,2:175\n87#3,7:177\n94#3,3:185\n70#3,7:188\n97#3:195\n87#3,7:196\n94#3,3:204\n70#3,7:207\n97#3:214\n1#4:184\n1#4:203\n*S KotlinDebug\n*F\n+ 1 FirmwareRepairSearchActivity.kt\ncom/sma/smartv3/ui/device/FirmwareRepairSearchActivity\n*L\n26#1:171,2\n26#1:173\n27#1:174\n96#1:175,2\n98#1:177,7\n98#1:185,3\n98#1:188,7\n98#1:195\n100#1:196,7\n100#1:204,3\n100#1:207,7\n100#1:214\n98#1:184\n100#1:203\n*E\n"})
/* loaded from: classes12.dex */
public final class FirmwareRepairSearchActivity extends BaseListFunctionActivity<BleDevice> {

    @OXOo.OOXIXo
    private final BleDeviceInfo mDeviceInfo;

    @OXOo.oOoXoXO
    private final FirmwareVersion mLatestFirmware;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mScanner$delegate;
    private int mSearchTime;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO btnSearchAgain$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<Button>() { // from class: com.sma.smartv3.ui.device.FirmwareRepairSearchActivity$btnSearchAgain$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final Button invoke() {
            return (Button) FirmwareRepairSearchActivity.this.findViewById(R.id.btn_search_again);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO llSearchAgain$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.device.FirmwareRepairSearchActivity$llSearchAgain$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return FirmwareRepairSearchActivity.this.findViewById(R.id.ll_search_again);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO llTryOrigin$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.device.FirmwareRepairSearchActivity$llTryOrigin$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return FirmwareRepairSearchActivity.this.findViewById(R.id.ll_try_origin);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvSearchTip$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.device.FirmwareRepairSearchActivity$tvSearchTip$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) FirmwareRepairSearchActivity.this.findViewById(R.id.tv_search_tip);
        }
    });

    public FirmwareRepairSearchActivity() {
        com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
        Object fromJson = new Gson().fromJson(xo0.oxoX().getString(BleDeviceInfo.class.getName()), (Class<Object>) BleDeviceInfo.class);
        this.mDeviceInfo = (BleDeviceInfo) (fromJson == null ? BleDeviceInfo.class.newInstance() : fromJson);
        this.mLatestFirmware = (FirmwareVersion) new Gson().fromJson(xo0.II0xO0().getString(FirmwareVersion.class.getName()), FirmwareVersion.class);
        this.mScanner$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<XOxIOxOx.II0xO0>() { // from class: com.sma.smartv3.ui.device.FirmwareRepairSearchActivity$mScanner$2

            @kotlin.jvm.internal.XX({"SMAP\nFirmwareRepairSearchActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FirmwareRepairSearchActivity.kt\ncom/sma/smartv3/ui/device/FirmwareRepairSearchActivity$mScanner$2$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,170:1\n1002#2,2:171\n*S KotlinDebug\n*F\n+ 1 FirmwareRepairSearchActivity.kt\ncom/sma/smartv3/ui/device/FirmwareRepairSearchActivity$mScanner$2$2\n*L\n67#1:171,2\n*E\n"})
            /* loaded from: classes12.dex */
            public static final class II0xO0 implements XOxIOxOx.oxoX {

                /* renamed from: oIX0oI, reason: collision with root package name */
                public final /* synthetic */ FirmwareRepairSearchActivity f21812oIX0oI;

                @kotlin.jvm.internal.XX({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2\n+ 2 FirmwareRepairSearchActivity.kt\ncom/sma/smartv3/ui/device/FirmwareRepairSearchActivity$mScanner$2$2\n*L\n1#1,328:1\n67#2:329\n*E\n"})
                /* loaded from: classes12.dex */
                public static final class oIX0oI<T> implements Comparator {
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return xX0ox.Oxx0IOOO.oOoXoXO(Integer.valueOf(-((BleDevice) t).getMRssi()), Integer.valueOf(-((BleDevice) t2).getMRssi()));
                    }
                }

                public II0xO0(FirmwareRepairSearchActivity firmwareRepairSearchActivity) {
                    this.f21812oIX0oI = firmwareRepairSearchActivity;
                }

                @Override // XOxIOxOx.oxoX
                public void I0Io() {
                }

                @Override // XOxIOxOx.oxoX
                public void II0xO0(@OXOo.OOXIXo BleDevice device) {
                    BleDeviceInfo bleDeviceInfo;
                    List mList;
                    ListView mListView;
                    TextView tvSearchTip;
                    View llSearchAgain;
                    List mList2;
                    List mList3;
                    XIOOI.oIX0oI mListAdapter;
                    kotlin.jvm.internal.IIX0o.x0xO0oo(device, "device");
                    if (UtilsKt.xI(device) && UtilsKt.oo0xXOI0I(device)) {
                        String mName = device.getMName();
                        bleDeviceInfo = this.f21812oIX0oI.mDeviceInfo;
                        if (StringsKt__StringsKt.o00xOoIO(mName, bleDeviceInfo.getMBleName(), false, 2, null)) {
                            mList = this.f21812oIX0oI.getMList();
                            if (!mList.contains(device)) {
                                mListView = this.f21812oIX0oI.getMListView();
                                mListView.setVisibility(0);
                                tvSearchTip = this.f21812oIX0oI.getTvSearchTip();
                                tvSearchTip.setVisibility(8);
                                llSearchAgain = this.f21812oIX0oI.getLlSearchAgain();
                                llSearchAgain.setVisibility(8);
                                mList2 = this.f21812oIX0oI.getMList();
                                mList2.add(device);
                                mList3 = this.f21812oIX0oI.getMList();
                                if (mList3.size() > 1) {
                                    kotlin.collections.o00.OO0x0xX(mList3, new oIX0oI());
                                }
                                mListAdapter = this.f21812oIX0oI.getMListAdapter();
                                mListAdapter.notifyDataSetChanged();
                            }
                        }
                    }
                }

                @Override // XOxIOxOx.oxoX
                public void oIX0oI(boolean z) {
                    if (z) {
                        this.f21812oIX0oI.onScanStarted();
                    } else {
                        this.f21812oIX0oI.onScanStopped();
                    }
                }
            }

            /* loaded from: classes12.dex */
            public static final class oIX0oI implements XOxIOxOx.X0o0xo {
                @Override // XOxIOxOx.X0o0xo
                public boolean oIX0oI(@OXOo.OOXIXo BleDevice device) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(device, "device");
                    if (TextUtils.isEmpty(device.getMName()) || device.getMRssi() <= -120) {
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
                return XOxIOxOx.oO.II0xO0(XOxIOxOx.oO.f3971oIX0oI, null, ScanMode.LOW_LATENCY, 1, null).Oo(10).IXxxXO(new oIX0oI()).ooOOo0oXI(new II0xO0(FirmwareRepairSearchActivity.this));
            }
        });
    }

    private final Button getBtnSearchAgain() {
        return (Button) this.btnSearchAgain$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View getLlSearchAgain() {
        return (View) this.llSearchAgain$delegate.getValue();
    }

    private final View getLlTryOrigin() {
        return (View) this.llTryOrigin$delegate.getValue();
    }

    private final XOxIOxOx.II0xO0 getMScanner() {
        return (XOxIOxOx.II0xO0) this.mScanner$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView getTvSearchTip() {
        return (TextView) this.tvSearchTip$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(FirmwareRepairSearchActivity this$0, AdapterView adapterView, View view, int i, long j) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        ToastUtils.showLong(String.valueOf(i), new Object[0]);
        this$0.getMScanner().oOoXoXO(false);
        this$0.toRepair(this$0.getMList().get(i));
        this$0.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(FirmwareRepairSearchActivity this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.scan();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onScanStarted() {
        getMListView().setVisibility(8);
        getTvSearchTip().setVisibility(0);
        getLlSearchAgain().setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onScanStopped() {
        getTvSearchTip().setVisibility(8);
        if (getMList().isEmpty()) {
            getMListView().setVisibility(8);
            getLlSearchAgain().setVisibility(0);
            if (!BleConnector.INSTANCE.isAvailable() && this.mSearchTime >= 2) {
                try {
                    BluetoothDevice remoteDevice = BluetoothAdapter.getDefaultAdapter().getRemoteDevice(UtilsKt.XO(this.mDeviceInfo.getMBleAddress()));
                    kotlin.jvm.internal.IIX0o.oO(remoteDevice, "getRemoteDevice(...)");
                    final BleDevice bleDevice = new BleDevice(remoteDevice, 0, null, this.mDeviceInfo.getMBleName(), 0, UtilsKt.XO(this.mDeviceInfo.getMBleAddress()));
                    getLlTryOrigin().setVisibility(0);
                    getLlTryOrigin().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.oX
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            FirmwareRepairSearchActivity.onScanStopped$lambda$2(FirmwareRepairSearchActivity.this, bleDevice, view);
                        }
                    });
                    ((TextView) findViewById(R.id.tv_name)).setText(bleDevice.getMName());
                    ((TextView) findViewById(R.id.tv_address)).setText(bleDevice.getMAddress());
                    ((ImageView) findViewById(R.id.iv_rssi)).setImageLevel(-bleDevice.getMRssi());
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        getMListView().setVisibility(0);
        getLlSearchAgain().setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onScanStopped$lambda$2(FirmwareRepairSearchActivity this$0, BleDevice device, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        kotlin.jvm.internal.IIX0o.x0xO0oo(device, "$device");
        this$0.toRepair(device);
    }

    private final void scan() {
        this.mSearchTime++;
        getMList().clear();
        getMScanner().oOoXoXO(true);
    }

    private final void toRepair(BleDevice bleDevice) {
        String str;
        this.mDeviceInfo.setMBleAddress(UtilsKt.oOoXoXO(bleDevice));
        com.sma.smartv3.util.Xo0.f24349oIX0oI.oxoX().put(BleDeviceInfo.class.getName(), new Gson().toJson(this.mDeviceInfo));
        FirmwareVersion firmwareVersion = this.mLatestFirmware;
        if (firmwareVersion != null) {
            str = firmwareVersion.getFileUrl2();
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            String mAddress = bleDevice.getMAddress();
            Bundle bundle = new Bundle();
            bundle.putString("mArg0", mAddress);
            bundle.putParcelable("mArg2", null);
            bundle.putSerializable("mArg3", null);
            Intent intent = new Intent(this, (Class<?>) FirmwareRepairJ2Activity.class);
            intent.putExtras(bundle);
            startActivity(intent);
            return;
        }
        String mAddress2 = bleDevice.getMAddress();
        Bundle bundle2 = new Bundle();
        bundle2.putString("mArg0", mAddress2);
        bundle2.putParcelable("mArg2", null);
        bundle2.putSerializable("mArg3", null);
        Intent intent2 = new Intent(this, (Class<?>) FirmwareRepairJActivity.class);
        intent2.putExtras(bundle2);
        startActivity(intent2);
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
        BleInitializer.f20700XO.xx0X0(true);
        ((TextView) findViewById(R.id.abh_title_center)).setText(R.string.firmware_repair);
        getMListView().setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.sma.smartv3.ui.device.Xo0
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                FirmwareRepairSearchActivity.initView$lambda$0(FirmwareRepairSearchActivity.this, adapterView, view, i, j);
            }
        });
        getBtnSearchAgain().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.XoI0Ixx0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FirmwareRepairSearchActivity.initView$lambda$1(FirmwareRepairSearchActivity.this, view);
            }
        });
        scan();
    }

    @Override // com.bestmafen.androidbase.list.II0xO0
    public int itemLayoutId() {
        return R.layout.item_device;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_firmware_repair_search;
    }

    @Override // com.bestmafen.androidbase.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        BleInitializer.f20700XO.xx0X0(false);
        getMScanner().II0xO0();
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        finish();
    }

    @Override // com.bestmafen.androidbase.list.I0Io
    public void initItem(@OXOo.OOXIXo XIOOI.I0Io holder, @OXOo.OOXIXo BleDevice item, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(holder, "holder");
        kotlin.jvm.internal.IIX0o.x0xO0oo(item, "item");
        holder.o00(R.id.tv_name, item.getMName());
        holder.o00(R.id.tv_address, item.getMAddress());
        ((ImageView) holder.X0o0xo(R.id.iv_rssi)).setImageLevel(-item.getMRssi());
    }
}
