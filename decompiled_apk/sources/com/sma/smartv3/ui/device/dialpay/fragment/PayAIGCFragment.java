package com.sma.smartv3.ui.device.dialpay.fragment;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import androidx.fragment.app.FragmentActivity;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ThreadUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.sma.smartv3.biz.AIManager;
import com.sma.smartv3.biz.OrderManager;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.DeductionConfig;
import com.sma.smartv3.pop.I0X0x0oIo;
import com.sma.smartv3.pop.xxOXOOoIX;
import com.sma.smartv3.ui.device.dial.AIGCFragment;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.XoI0Ixx0;
import com.sma.smartv3.view.AbhSettingsItem;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.oXIO0o0XI;

/* loaded from: classes12.dex */
public final class PayAIGCFragment extends AIGCFragment {

    @OXOo.oOoXoXO
    private xxOXOOoIX mModleSetPopup;
    private int openAIDeductionPoints;

    @OXOo.OOXIXo
    private final String TAG = "PayAIGCFragment";

    @OXOo.OOXIXo
    private final X0IIOO itemModle$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AbhSettingsItem>() { // from class: com.sma.smartv3.ui.device.dialpay.fragment.PayAIGCFragment$itemModle$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AbhSettingsItem invoke() {
            View mView;
            mView = PayAIGCFragment.this.getMView();
            return (AbhSettingsItem) mView.findViewById(R.id.item_model);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO btnGen$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<Button>() { // from class: com.sma.smartv3.ui.device.dialpay.fragment.PayAIGCFragment$btnGen$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final Button invoke() {
            View mView;
            mView = PayAIGCFragment.this.getMView();
            return (Button) mView.findViewById(R.id.btn_gen);
        }
    });
    private int mCurModle = AIManager.oOoXoXO(AIManager.f19833oIX0oI, false, 1, null);

    private final void dismissLoadPopup() {
        ThreadUtils.runOnUiThread(new Runnable() { // from class: com.sma.smartv3.ui.device.dialpay.fragment.II0XooXoX
            @Override // java.lang.Runnable
            public final void run() {
                PayAIGCFragment.dismissLoadPopup$lambda$8(PayAIGCFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dismissLoadPopup$lambda$8(PayAIGCFragment this$0) {
        IIX0o.x0xO0oo(this$0, "this$0");
        I0X0x0oIo mLoadingPopup = this$0.getMLoadingPopup();
        if (mLoadingPopup != null) {
            mLoadingPopup.dismiss();
        }
    }

    private final Button getBtnGen() {
        return (Button) this.btnGen$delegate.getValue();
    }

    private final void getDeductionConfig() {
        OrderManager.f20130oIX0oI.xoIox(new Oox.oOoXoXO<DeductionConfig, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.dialpay.fragment.PayAIGCFragment$getDeductionConfig$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DeductionConfig deductionConfig) {
                invoke2(deductionConfig);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.oOoXoXO DeductionConfig deductionConfig) {
                if (deductionConfig != null) {
                    PayAIGCFragment.this.setOpenAIDeductionPoints(deductionConfig.getOpenAI_ImgPoints());
                    PayAIGCFragment.this.setBtnGenText();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AbhSettingsItem getItemModle() {
        return (AbhSettingsItem) this.itemModle$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(PayAIGCFragment this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        IIX0o.ooOOo0oXI(view);
        this$0.onSetStyle(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(PayAIGCFragment this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        IIX0o.ooOOo0oXI(view);
        this$0.onSetModel(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(PayAIGCFragment this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        if (!ProductManager.f20544oIX0oI.XOx()) {
            IIX0o.ooOOo0oXI(view);
            this$0.onSearch(view);
        } else {
            ToastUtils.showLong(R.string.parameter_check_failed);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(PayAIGCFragment this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        IIX0o.ooOOo0oXI(view);
        this$0.onGen(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initView$lambda$4(PayAIGCFragment this$0, View view, int i, KeyEvent keyEvent) {
        I0X0x0oIo mLoadingPopup;
        IIX0o.x0xO0oo(this$0, "this$0");
        if (keyEvent.getAction() != 1 || i != 4 || (mLoadingPopup = this$0.getMLoadingPopup()) == null || !mLoadingPopup.isShowing()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$5(PayAIGCFragment this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        IIX0o.ooOOo0oXI(view);
        this$0.onAgain(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$6(PayAIGCFragment this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.onNextStep();
    }

    private final void showLoadPopup(String str) {
        I0X0x0oIo mLoadingPopup;
        if (getMLoadingPopup() == null) {
            FragmentActivity requireActivity = requireActivity();
            IIX0o.oO(requireActivity, "requireActivity(...)");
            I0X0x0oIo i0X0x0oIo = new I0X0x0oIo(requireActivity);
            if (str.length() > 0) {
                i0X0x0oIo.XxX0x0xxx(str);
            }
            setMLoadingPopup(i0X0x0oIo);
        }
        I0X0x0oIo mLoadingPopup2 = getMLoadingPopup();
        if ((mLoadingPopup2 == null || !mLoadingPopup2.isShowing()) && (mLoadingPopup = getMLoadingPopup()) != null) {
            mLoadingPopup.IIXOooo();
        }
    }

    public static /* synthetic */ void showLoadPopup$default(PayAIGCFragment payAIGCFragment, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = payAIGCFragment.getString(R.string.working_generate_tip);
            IIX0o.oO(str, "getString(...)");
        }
        payAIGCFragment.showLoadPopup(str);
    }

    public final int getOpenAIDeductionPoints() {
        return this.openAIDeductionPoints;
    }

    @Override // com.sma.smartv3.ui.device.dial.AIGCFragment, com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.sma.smartv3.ui.device.dial.AIGCFragment, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        int i;
        AbhSettingsItem itemStyle = getItemStyle();
        String str = getResources().getStringArray(R.array.aigc_styles)[getMCurStyle()];
        IIX0o.oO(str, "get(...)");
        itemStyle.setMRightText(str);
        getItemStyle().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.dialpay.fragment.oIX0oI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PayAIGCFragment.initView$lambda$0(PayAIGCFragment.this, view);
            }
        });
        AbhSettingsItem itemStyle2 = getItemStyle();
        ProductManager productManager = ProductManager.f20544oIX0oI;
        int i2 = 8;
        if (productManager.OOIXx0x()) {
            i = 0;
        } else {
            i = 8;
        }
        itemStyle2.setVisibility(i);
        AbhSettingsItem itemModle = getItemModle();
        if (productManager.xXo()) {
            i2 = 0;
        }
        itemModle.setVisibility(i2);
        AbhSettingsItem itemModle2 = getItemModle();
        String str2 = getResources().getStringArray(R.array.ai_models)[this.mCurModle];
        IIX0o.oO(str2, "get(...)");
        itemModle2.setMRightText(str2);
        getItemModle().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.dialpay.fragment.II0xO0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PayAIGCFragment.initView$lambda$1(PayAIGCFragment.this, view);
            }
        });
        getBtnSearch().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.dialpay.fragment.I0Io
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PayAIGCFragment.initView$lambda$2(PayAIGCFragment.this, view);
            }
        });
        getBtnGen().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.dialpay.fragment.oxoX
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PayAIGCFragment.initView$lambda$3(PayAIGCFragment.this, view);
            }
        });
        getBtnGen().setOnKeyListener(new View.OnKeyListener() { // from class: com.sma.smartv3.ui.device.dialpay.fragment.X0o0xo
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i3, KeyEvent keyEvent) {
                boolean initView$lambda$4;
                initView$lambda$4 = PayAIGCFragment.initView$lambda$4(PayAIGCFragment.this, view, i3, keyEvent);
                return initView$lambda$4;
            }
        });
        getBtnAgain().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.dialpay.fragment.XO
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PayAIGCFragment.initView$lambda$5(PayAIGCFragment.this, view);
            }
        });
        getBtnNextStep().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.dialpay.fragment.Oxx0IOOO
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PayAIGCFragment.initView$lambda$6(PayAIGCFragment.this, view);
            }
        });
        getDeductionConfig();
    }

    @Override // com.sma.smartv3.ui.device.dial.AIGCFragment, com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.fragment_aigc_v2;
    }

    public final void onSetModel(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        if (this.mModleSetPopup == null) {
            FragmentActivity requireActivity = requireActivity();
            IIX0o.oO(requireActivity, "requireActivity(...)");
            xxOXOOoIX xxoxoooix = new xxOXOOoIX(requireActivity, R.array.ai_models, 0, 4, (IIXOooo) null);
            xxoxoooix.xI(R.string.pay_dail_aigc_modle);
            xxoxoooix.ooXIXxIX(new Oox.oOoXoXO<Integer, Boolean>() { // from class: com.sma.smartv3.ui.device.dialpay.fragment.PayAIGCFragment$onSetModel$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                    return invoke(num.intValue());
                }

                @OXOo.OOXIXo
                public final Boolean invoke(int i) {
                    int i2;
                    AbhSettingsItem itemModle;
                    int i3;
                    PayAIGCFragment.this.mCurModle = i;
                    SPUtils XO2 = Xo0.f24349oIX0oI.XO();
                    i2 = PayAIGCFragment.this.mCurModle;
                    XO2.put(XoI0Ixx0.f24379O00XxXI, i2);
                    itemModle = PayAIGCFragment.this.getItemModle();
                    String[] stringArray = PayAIGCFragment.this.getResources().getStringArray(R.array.ai_models);
                    i3 = PayAIGCFragment.this.mCurModle;
                    String str = stringArray[i3];
                    IIX0o.oO(str, "get(...)");
                    itemModle.setMRightText(str);
                    com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24618Xo0, null, 2, null);
                    PayAIGCFragment.this.setBtnGenText();
                    return Boolean.TRUE;
                }
            });
            this.mModleSetPopup = xxoxoooix;
        }
        xxOXOOoIX xxoxoooix2 = this.mModleSetPopup;
        if (xxoxoooix2 != null) {
            xxoxoooix2.IIX0o(this.mCurModle);
            xxoxoooix2.IIXOooo();
        }
    }

    public final void setBtnGenText() {
        String string;
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " setBtnGenText openAIDeductionPoints = " + this.openAIDeductionPoints);
        Button btnGen = getBtnGen();
        if (this.mCurModle == 0 && this.openAIDeductionPoints != 0 && ProductManager.f20544oIX0oI.XOx()) {
            string = getString(R.string.generate) + " (-" + this.openAIDeductionPoints + getString(R.string.points) + HexStringBuilder.COMMENT_END_CHAR;
        } else {
            string = getString(R.string.generate);
        }
        btnGen.setText(string);
    }

    public final void setOpenAIDeductionPoints(int i) {
        this.openAIDeductionPoints = i;
    }
}
