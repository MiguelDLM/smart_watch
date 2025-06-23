package com.sma.smartv3.ui.device.item;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.angcyo.dsladapter.DslViewHolder;
import com.bestmafen.androidbase.dsl.BaseDslItem;
import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.ImageUtils;
import com.blankj.utilcode.util.LogUtils;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.initializer.IXxxXO;
import com.sma.smartv3.util.x0xO0oo;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.component.BleCache;
import com.szabh.smable3.component.BleConnector;
import com.szabh.smable3.entity.BleDeviceInfo;
import java.io.File;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class MultiDeviceInfoItem extends BaseDslItem {
    private View btnDelete;

    @OOXIXo
    private final BleDeviceInfo deviceInfo;
    private final boolean initEvent;
    private ImageView ivConnection;
    private ImageView ivDevice;
    private ImageView ivPower;
    private Context mContext;

    @oOoXoXO
    private oIX0oI mOnClickListener;
    private ProgressBar pbConnecting;
    private View powerPanel;
    private RelativeLayout rlLayout;
    private TextView tvMac;
    private TextView tvName;
    private TextView tvReconnect;
    private TextView tvState;

    /* loaded from: classes12.dex */
    public interface oIX0oI {
        void onClick(@OOXIXo View view);
    }

    public MultiDeviceInfoItem(@OOXIXo BleDeviceInfo deviceInfo) {
        IIX0o.x0xO0oo(deviceInfo, "deviceInfo");
        this.deviceInfo = deviceInfo;
        this.initEvent = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindView$lambda$0(MultiDeviceInfoItem this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        oIX0oI oix0oi = this$0.mOnClickListener;
        if (oix0oi != null) {
            IIX0o.ooOOo0oXI(view);
            oix0oi.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindView$lambda$1(MultiDeviceInfoItem this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        oIX0oI oix0oi = this$0.mOnClickListener;
        if (oix0oi != null) {
            IIX0o.ooOOo0oXI(view);
            oix0oi.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindView$lambda$2(MultiDeviceInfoItem this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        oIX0oI oix0oi = this$0.mOnClickListener;
        if (oix0oi != null) {
            IIX0o.ooOOo0oXI(view);
            oix0oi.onClick(view);
        }
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void bindView(@OOXIXo DslViewHolder itemHolder) {
        IIX0o.x0xO0oo(itemHolder, "itemHolder");
        Context context = itemHolder.getContext();
        IIX0o.oO(context, "<get-context>(...)");
        this.mContext = context;
        View v = itemHolder.v(R.id.multi_device_item_info_layout);
        IIX0o.ooOOo0oXI(v);
        this.rlLayout = (RelativeLayout) v;
        View v2 = itemHolder.v(R.id.iv_device);
        IIX0o.ooOOo0oXI(v2);
        this.ivDevice = (ImageView) v2;
        View v3 = itemHolder.v(R.id.tv_name);
        IIX0o.ooOOo0oXI(v3);
        this.tvName = (TextView) v3;
        TextView tv = itemHolder.tv(R.id.tv_mac);
        IIX0o.ooOOo0oXI(tv);
        this.tvMac = tv;
        TextView tv2 = itemHolder.tv(R.id.tv_state);
        IIX0o.ooOOo0oXI(tv2);
        this.tvState = tv2;
        View v4 = itemHolder.v(R.id.power_panel);
        IIX0o.ooOOo0oXI(v4);
        this.powerPanel = v4;
        View v5 = itemHolder.v(R.id.iv_connection);
        IIX0o.ooOOo0oXI(v5);
        this.ivConnection = (ImageView) v5;
        View v6 = itemHolder.v(R.id.iv_power);
        IIX0o.ooOOo0oXI(v6);
        this.ivPower = (ImageView) v6;
        TextView tv3 = itemHolder.tv(R.id.tv_reconnect);
        IIX0o.ooOOo0oXI(tv3);
        this.tvReconnect = tv3;
        RelativeLayout relativeLayout = null;
        if (tv3 == null) {
            IIX0o.XOxIOxOx("tvReconnect");
            tv3 = null;
        }
        tv3.setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.item.oxoX
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MultiDeviceInfoItem.bindView$lambda$0(MultiDeviceInfoItem.this, view);
            }
        });
        View view = itemHolder.view(R.id.btn_delete);
        IIX0o.ooOOo0oXI(view);
        this.btnDelete = view;
        if (view == null) {
            IIX0o.XOxIOxOx("btnDelete");
            view = null;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.item.X0o0xo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MultiDeviceInfoItem.bindView$lambda$1(MultiDeviceInfoItem.this, view2);
            }
        });
        RelativeLayout relativeLayout2 = this.rlLayout;
        if (relativeLayout2 == null) {
            IIX0o.XOxIOxOx("rlLayout");
        } else {
            relativeLayout = relativeLayout2;
        }
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.item.XO
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MultiDeviceInfoItem.bindView$lambda$2(MultiDeviceInfoItem.this, view2);
            }
        });
        View v7 = itemHolder.v(R.id.pb_connecting);
        IIX0o.ooOOo0oXI(v7);
        this.pbConnecting = (ProgressBar) v7;
    }

    @OOXIXo
    public final BleDeviceInfo getDeviceInfo() {
        return this.deviceInfo;
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public boolean getInitEvent() {
        return this.initEvent;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v14, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r3v9, types: [android.widget.ImageView] */
    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void initView() {
        TextView textView = this.tvName;
        TextView textView2 = null;
        if (textView == null) {
            IIX0o.XOxIOxOx("tvName");
            textView = null;
        }
        textView.setText(this.deviceInfo.getMBleName());
        TextView textView3 = this.tvMac;
        if (textView3 == null) {
            IIX0o.XOxIOxOx("tvMac");
            textView3 = null;
        }
        textView3.setText(this.deviceInfo.getMBleAddress());
        ProgressBar progressBar = this.pbConnecting;
        if (progressBar == null) {
            IIX0o.XOxIOxOx("pbConnecting");
            progressBar = null;
        }
        progressBar.setVisibility(8);
        View view = this.powerPanel;
        if (view == null) {
            IIX0o.XOxIOxOx("powerPanel");
            view = null;
        }
        view.setVisibility(4);
        if (com.sma.smartv3.biz.oOoXoXO.f20294oIX0oI.II0XooXoX(this.deviceInfo.getMBleAddress())) {
            TextView textView4 = this.tvReconnect;
            if (textView4 == null) {
                IIX0o.XOxIOxOx("tvReconnect");
                textView4 = null;
            }
            textView4.setVisibility(4);
            View view2 = this.btnDelete;
            if (view2 == null) {
                IIX0o.XOxIOxOx("btnDelete");
                view2 = null;
            }
            view2.setVisibility(8);
            ImageView imageView = this.ivConnection;
            if (imageView == null) {
                IIX0o.XOxIOxOx("ivConnection");
                imageView = null;
            }
            imageView.setEnabled(false);
            ImageView imageView2 = this.ivPower;
            if (imageView2 == null) {
                IIX0o.XOxIOxOx("ivPower");
                imageView2 = null;
            }
            imageView2.setImageLevel(BleCache.getInt$default(BleCache.INSTANCE, BleKey.POWER, 0, null, 6, null));
            BleConnector bleConnector = BleConnector.INSTANCE;
            if (bleConnector.isAvailable()) {
                View view3 = this.powerPanel;
                if (view3 == null) {
                    IIX0o.XOxIOxOx("powerPanel");
                    view3 = null;
                }
                view3.setVisibility(0);
                TextView textView5 = this.tvState;
                if (textView5 == null) {
                    IIX0o.XOxIOxOx("tvState");
                    textView5 = null;
                }
                textView5.setText(R.string.device_connectied);
                ?? r3 = this.ivConnection;
                if (r3 == 0) {
                    IIX0o.XOxIOxOx("ivConnection");
                } else {
                    textView2 = r3;
                }
                textView2.setEnabled(bleConnector.isAvailable());
            } else if (bleConnector.isConnecting()) {
                TextView textView6 = this.tvState;
                if (textView6 == null) {
                    IIX0o.XOxIOxOx("tvState");
                    textView6 = null;
                }
                textView6.setText(R.string.device_connecting);
                ProgressBar progressBar2 = this.pbConnecting;
                if (progressBar2 == null) {
                    IIX0o.XOxIOxOx("pbConnecting");
                    progressBar2 = null;
                }
                progressBar2.setVisibility(0);
                TextView textView7 = this.tvReconnect;
                if (textView7 == null) {
                    IIX0o.XOxIOxOx("tvReconnect");
                } else {
                    textView2 = textView7;
                }
                textView2.setVisibility(8);
            } else {
                TextView textView8 = this.tvState;
                if (textView8 == null) {
                    IIX0o.XOxIOxOx("tvState");
                } else {
                    textView2 = textView8;
                }
                textView2.setText(R.string.device_disconnected);
            }
        } else {
            TextView textView9 = this.tvState;
            if (textView9 == null) {
                IIX0o.XOxIOxOx("tvState");
                textView9 = null;
            }
            textView9.setText(R.string.device_disconnected);
            TextView textView10 = this.tvReconnect;
            if (textView10 == null) {
                IIX0o.XOxIOxOx("tvReconnect");
                textView10 = null;
            }
            textView10.setVisibility(0);
            ?? r1 = this.btnDelete;
            if (r1 == 0) {
                IIX0o.XOxIOxOx("btnDelete");
            } else {
                textView2 = r1;
            }
            textView2.setVisibility(0);
        }
        onPairImageChange(new Object());
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public int layoutId() {
        return R.layout.multi_device_item_info;
    }

    @XO0.XO(tag = x0xO0oo.f24577IoOoX)
    public final void onPairImageChange(@OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        LogUtils.d("onPairImageChange");
        ProductManager productManager = ProductManager.f20544oIX0oI;
        ImageView imageView = null;
        if (productManager.O00(this.deviceInfo)) {
            ImageView imageView2 = this.ivDevice;
            if (imageView2 == null) {
                IIX0o.XOxIOxOx("ivDevice");
                imageView2 = null;
            }
            Context context = this.mContext;
            if (context == null) {
                IIX0o.XOxIOxOx("mContext");
                context = null;
            }
            imageView2.setImageDrawable(context.getDrawable(((Number) ProductManager.XoIxOXIXo(productManager, null, 1, null).getFirst()).intValue()));
        } else {
            ImageView imageView3 = this.ivDevice;
            if (imageView3 == null) {
                IIX0o.XOxIOxOx("ivDevice");
                imageView3 = null;
            }
            Context context2 = this.mContext;
            if (context2 == null) {
                IIX0o.XOxIOxOx("mContext");
                context2 = null;
            }
            imageView3.setImageDrawable(context2.getDrawable(productManager.x0XOIxOo(this.deviceInfo)));
        }
        File O0Xx2 = IXxxXO.O0Xx(X00IoxXI.oIX0oI.f3233oIX0oI, this.deviceInfo);
        if (FileUtils.isFileExists(O0Xx2)) {
            ImageView imageView4 = this.ivDevice;
            if (imageView4 == null) {
                IIX0o.XOxIOxOx("ivDevice");
            } else {
                imageView = imageView4;
            }
            imageView.setImageBitmap(ImageUtils.getBitmap(O0Xx2));
        }
    }

    public final void setOnClickListener(@OOXIXo oIX0oI listener) {
        IIX0o.x0xO0oo(listener, "listener");
        this.mOnClickListener = listener;
    }
}
