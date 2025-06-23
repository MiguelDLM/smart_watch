package com.sma.smartv3.ui.me;

import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.TextAppearanceSpan;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentActivity;
import com.angcyo.dsladapter.DslAdapter;
import com.angcyo.dsladapter.DslAdapterExKt;
import com.angcyo.dsladapter.DslViewHolder;
import com.bestmafen.androidbase.dsl.BaseDslItem;
import com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragment;
import com.blankj.utilcode.util.ClipboardUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.biz.DeviceInfoChecker;
import com.sma.smartv3.biz.OrderManager;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.AppUser;
import com.sma.smartv3.ui.me.item.MainAvatarItem;
import com.sma.smartv3.ui.me.item.MainBottomItem;
import com.sma.smartv3.ui.me.item.MainMiddleItem;
import com.sma.smartv3.ui.me.item.MainUserOrderItem;
import com.sma.smartv3.ui.me.item.MeADPBannerItem;
import com.sma.smartv3.ui.me.item.MeADPCBannerItem;
import com.sma.smartv3.ui.order.OrderDetailActivity;
import com.sma.smartv3.ui.order.PointsDetailActivity;
import com.sma.smartv3.util.UtilsKt;
import com.szabh.smable3.component.BleConnector;
import kotlin.text.StringsKt__StringsKt;

@kotlin.jvm.internal.XX({"SMAP\nMainMeFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MainMeFragment.kt\ncom/sma/smartv3/ui/me/MainMeFragment\n+ 2 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,404:1\n78#2,3:405\n81#2,5:409\n78#2,3:417\n81#2,5:421\n78#2,3:426\n81#2,5:430\n78#2,3:435\n81#2,5:439\n78#2,3:444\n81#2,5:448\n78#2,3:453\n81#2,5:457\n99#2,7:462\n106#2,3:470\n79#2,7:473\n109#2:480\n78#2,3:481\n81#2,5:485\n1#3:408\n1#3:420\n1#3:429\n1#3:438\n1#3:447\n1#3:456\n1#3:469\n1#3:484\n19#4:414\n15#4:415\n90#4:416\n19#4:490\n15#4:491\n90#4:492\n90#4:493\n*S KotlinDebug\n*F\n+ 1 MainMeFragment.kt\ncom/sma/smartv3/ui/me/MainMeFragment\n*L\n150#1:405,3\n150#1:409,5\n183#1:417,3\n183#1:421,5\n211#1:426,3\n211#1:430,5\n257#1:435,3\n257#1:439,5\n258#1:444,3\n258#1:448,5\n261#1:453,3\n261#1:457,5\n263#1:462,7\n263#1:470,3\n263#1:473,7\n263#1:480\n266#1:481,3\n266#1:485,5\n150#1:408\n183#1:420\n211#1:429\n257#1:438\n258#1:447\n261#1:456\n263#1:469\n266#1:484\n165#1:414\n165#1:415\n168#1:416\n269#1:490\n269#1:491\n323#1:492\n343#1:493\n*E\n"})
/* loaded from: classes11.dex */
public class MainMeFragment extends BaseDSLRecyclerFragment implements View.OnClickListener {

    @OXOo.oOoXoXO
    private BaseDslItem bannerItem;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.XoI0Ixx0 mFirmwareRepairPopup;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.x0xO0oo mFreePointPopup;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.XoI0Ixx0 mUserIdentityRemindPopup;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.XoI0Ixx0 mWelfarePopup;

    @OXOo.OOXIXo
    private final MainBottomItem mainBottomItem;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO rootView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.me.MainMeFragment$rootView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            View mView;
            mView = MainMeFragment.this.getMView();
            return mView.findViewById(R.id.root_view);
        }
    });

    public MainMeFragment() {
        MainBottomItem mainBottomItem = new MainBottomItem();
        mainBottomItem.setMOnClick(this);
        this.mainBottomItem = mainBottomItem;
    }

    private final View getRootView() {
        return (View) this.rootView$delegate.getValue();
    }

    private final void getUserPoins() {
        ProjectManager projectManager = ProjectManager.f19822oIX0oI;
        if (projectManager.ooOx()) {
            if (projectManager.oIIxXoo()) {
                OrderManager.f20130oIX0oI.xxX(new Oox.oOoXoXO<Boolean, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.MainMeFragment$getUserPoins$1
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@OXOo.oOoXoXO Boolean bool) {
                    }

                    @Override // Oox.oOoXoXO
                    public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(Boolean bool) {
                        invoke2(bool);
                        return kotlin.oXIO0o0XI.f29392oIX0oI;
                    }
                });
            } else {
                OrderManager.f20130oIX0oI.XxX0x0xxx();
            }
        }
    }

    private final void selectGoal() {
        startActivity(new Intent(getActivity(), (Class<?>) GoalSettingActivity.class));
    }

    public void customOnClick(int i) {
    }

    @OXOo.oOoXoXO
    public BaseDslItem getAdBannerItem() {
        ProjectManager projectManager = ProjectManager.f19822oIX0oI;
        if (projectManager.oOo()) {
            return new MeADPCBannerItem();
        }
        if (projectManager.xOOOX()) {
            return new MeADPBannerItem();
        }
        return null;
    }

    @OXOo.oOoXoXO
    public final BaseDslItem getBannerItem() {
        return this.bannerItem;
    }

    @OXOo.OOXIXo
    public final MainBottomItem getMainBottomItem() {
        return this.mainBottomItem;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
        getUserPoins();
    }

    @Override // com.bestmafen.androidbase.base.BaseFragment, com.bestmafen.androidbase.base.oIX0oI
    public boolean initEvent() {
        return true;
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragment, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
    }

    public int layoutId() {
        return R.layout.fragment_rv;
    }

    @XO0.XO(tag = com.sma.smartv3.util.x0xO0oo.f24576IoIOOxIIo)
    public final void onAdStateChange(@OXOo.OOXIXo Object data) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(data, "data");
        OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
        StringBuilder sb = new StringBuilder();
        sb.append("Me Ad State -> ");
        ProjectManager projectManager = ProjectManager.f19822oIX0oI;
        sb.append(projectManager.oXIO0o0XI());
        sb.append(", ");
        sb.append(projectManager.IIX0());
        oix0oi.oIX0oI(sb.toString());
        renderAdapterMethod();
    }

    @XO0.XO(tag = com.sma.smartv3.util.x0xO0oo.f24638oo0xXOI0I)
    public final void onAvatarChange(@OXOo.OOXIXo Object data) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(data, "data");
        getDslAdapter().notifyDataSetChanged();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@OXOo.OOXIXo View view) {
        int i;
        com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0;
        Resources resources;
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        int id = view.getId();
        switch (id) {
            case R.id.ImgWelfareAnim /* 2131361802 */:
            case R.id.WelfareAnimtv /* 2131361820 */:
                SPUtils XO2 = com.sma.smartv3.util.Xo0.f24349oIX0oI.XO();
                Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
                Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
                if (fromJson != null) {
                    appUser = fromJson;
                }
                AppUser appUser2 = (AppUser) appUser;
                if (appUser2.getEmail() != null && appUser2.getEmail().length() > 0) {
                    if (ProjectManager.f19822oIX0oI.oIIxXoo()) {
                        OrderManager.f20130oIX0oI.oOoXoXO(new Oox.oOoXoXO<Boolean, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.MainMeFragment$onClick$5
                            {
                                super(1);
                            }

                            @Override // Oox.oOoXoXO
                            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(Boolean bool) {
                                invoke2(bool);
                                return kotlin.oXIO0o0XI.f29392oIX0oI;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@OXOo.oOoXoXO Boolean bool) {
                                if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(bool, Boolean.TRUE)) {
                                    MainMeFragment.this.onGetFreePoints();
                                    OrderManager.f20130oIX0oI.xxX(new Oox.oOoXoXO<Boolean, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.MainMeFragment$onClick$5.1
                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(@OXOo.oOoXoXO Boolean bool2) {
                                        }

                                        @Override // Oox.oOoXoXO
                                        public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(Boolean bool2) {
                                            invoke2(bool2);
                                            return kotlin.oXIO0o0XI.f29392oIX0oI;
                                        }
                                    });
                                }
                            }
                        });
                        return;
                    } else {
                        OrderManager.f20130oIX0oI.ooOOo0oXI(new Oox.oOoXoXO<Boolean, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.MainMeFragment$onClick$6
                            {
                                super(1);
                            }

                            @Override // Oox.oOoXoXO
                            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(Boolean bool) {
                                invoke2(bool);
                                return kotlin.oXIO0o0XI.f29392oIX0oI;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@OXOo.oOoXoXO Boolean bool) {
                                if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(bool, Boolean.TRUE)) {
                                    MainMeFragment.this.onGetFreePoints();
                                    OrderManager.f20130oIX0oI.XxX0x0xxx();
                                }
                            }
                        });
                        return;
                    }
                }
                com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx02 = new com.sma.smartv3.pop.XoI0Ixx0(getMActivity(), 0, 2, null);
                FragmentActivity activity = getActivity();
                if (activity != null && (resources = activity.getResources()) != null) {
                    i = resources.getColor(R.color.order_text_orange);
                } else {
                    i = ViewCompat.MEASURED_STATE_MASK;
                }
                xoI0Ixx02.oOXoIIIo(i);
                if (ProjectManager.f19822oIX0oI.oIIxXoo()) {
                    xoI0Ixx02.IoOoX(R.string.get_free_ai_privileges);
                    xoI0Ixx02.xI(Integer.valueOf(R.string.can_not_get_ai_privileges_tip));
                } else {
                    xoI0Ixx02.IoOoX(R.string.free_points);
                    xoI0Ixx02.xI(Integer.valueOf(R.string.welfare_point_remind));
                }
                com.sma.smartv3.pop.XoI0Ixx0.IO(xoI0Ixx02, Integer.valueOf(R.string.cancel), null, 2, null);
                xoI0Ixx02.x0o(R.string.confirm, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.me.MainMeFragment$onClick$7$1
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // Oox.oIX0oI
                    @OXOo.OOXIXo
                    public final Boolean invoke() {
                        MainMeFragment mainMeFragment = MainMeFragment.this;
                        mainMeFragment.startActivity(new Intent(mainMeFragment.getActivity(), (Class<?>) UserInfoActivity.class));
                        return Boolean.TRUE;
                    }
                });
                this.mWelfarePopup = xoI0Ixx02;
                if (!xoI0Ixx02.isShowing() && (xoI0Ixx0 = this.mWelfarePopup) != null) {
                    View rootView = getRootView();
                    kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
                    xoI0Ixx0.OxxIIOOXO(rootView);
                    return;
                }
                return;
            case R.id.btGoal /* 2131363368 */:
                selectGoal();
                return;
            case R.id.btHelp /* 2131363370 */:
                ProjectManager.f19822oIX0oI.XxIo(getMActivity());
                return;
            case R.id.iv_avatar /* 2131364966 */:
                break;
            case R.id.userID /* 2131371828 */:
                showUserIdentityCopyPopup();
                return;
            default:
                switch (id) {
                    case R.id.btAbout /* 2131363360 */:
                        ProjectManager.f19822oIX0oI.xo(getMActivity());
                        return;
                    case R.id.btContactUs /* 2131363361 */:
                        ProjectManager.f19822oIX0oI.Ix0(getMActivity());
                        return;
                    case R.id.btExercise /* 2131363362 */:
                        com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.MainMeFragment$onClick$1
                            {
                                super(1);
                            }

                            @Override // Oox.oOoXoXO
                            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(BleConnector bleConnector) {
                                invoke2(bleConnector);
                                return kotlin.oXIO0o0XI.f29392oIX0oI;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@OXOo.OOXIXo BleConnector it) {
                                kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                                if (ProductManager.f20544oIX0oI.I0oOoX() == 1) {
                                    MainMeFragment mainMeFragment = MainMeFragment.this;
                                    mainMeFragment.startActivity(new Intent(mainMeFragment.getActivity(), (Class<?>) CoachingsActivity.class));
                                }
                            }
                        }, 1, null);
                        return;
                    case R.id.btFAQ /* 2131363363 */:
                        ProjectManager.f19822oIX0oI.xox(getMActivity());
                        return;
                    case R.id.btFeedBack /* 2131363364 */:
                        ProjectManager.f19822oIX0oI.xIxooxXX(getMActivity());
                        return;
                    case R.id.btFirmwareRepair /* 2131363365 */:
                        final com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx03 = new com.sma.smartv3.pop.XoI0Ixx0(getMActivity(), 0, 2, null);
                        xoI0Ixx03.IoOoX(R.string.firmware_repair_remind);
                        com.sma.smartv3.pop.XoI0Ixx0.IO(xoI0Ixx03, Integer.valueOf(R.string.cancel), null, 2, null);
                        xoI0Ixx03.x0o(R.string.confirm, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.me.MainMeFragment$onClick$4$1
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // Oox.oIX0oI
                            @OXOo.OOXIXo
                            public final Boolean invoke() {
                                UtilsKt.OI0(com.sma.smartv3.pop.XoI0Ixx0.this.Oxx0IOOO(), new Oox.oIX0oI<kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.MainMeFragment$onClick$4$1.1
                                    @Override // Oox.oIX0oI
                                    public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke() {
                                        invoke2();
                                        return kotlin.oXIO0o0XI.f29392oIX0oI;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2() {
                                        com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24620XoX, null, 2, null);
                                    }
                                });
                                return Boolean.TRUE;
                            }
                        });
                        this.mFirmwareRepairPopup = xoI0Ixx03;
                        View rootView2 = getRootView();
                        kotlin.jvm.internal.IIX0o.oO(rootView2, "<get-rootView>(...)");
                        xoI0Ixx03.OxxIIOOXO(rootView2);
                        return;
                    case R.id.btFont /* 2131363366 */:
                        final com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx04 = new com.sma.smartv3.pop.XoI0Ixx0(getMActivity(), 0, 2, null);
                        xoI0Ixx04.IoOoX(R.string.language_repair_remind);
                        com.sma.smartv3.pop.XoI0Ixx0.IO(xoI0Ixx04, Integer.valueOf(R.string.cancel), null, 2, null);
                        xoI0Ixx04.x0o(R.string.confirm, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.me.MainMeFragment$onClick$2$1
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // Oox.oIX0oI
                            @OXOo.OOXIXo
                            public final Boolean invoke() {
                                Activity Oxx0IOOO2 = com.sma.smartv3.pop.XoI0Ixx0.this.Oxx0IOOO();
                                final com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx05 = com.sma.smartv3.pop.XoI0Ixx0.this;
                                UtilsKt.OI0(Oxx0IOOO2, new Oox.oIX0oI<kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.MainMeFragment$onClick$2$1.1
                                    {
                                        super(0);
                                    }

                                    @Override // Oox.oIX0oI
                                    public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke() {
                                        invoke2();
                                        return kotlin.oXIO0o0XI.f29392oIX0oI;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2() {
                                        DeviceInfoChecker.OxI(DeviceInfoChecker.f19983oIX0oI, com.sma.smartv3.pop.XoI0Ixx0.this.Oxx0IOOO(), null, 2, null);
                                    }
                                });
                                return Boolean.TRUE;
                            }
                        });
                        this.mFirmwareRepairPopup = xoI0Ixx04;
                        View rootView3 = getRootView();
                        kotlin.jvm.internal.IIX0o.oO(rootView3, "<get-rootView>(...)");
                        xoI0Ixx04.OxxIIOOXO(rootView3);
                        return;
                    default:
                        switch (id) {
                            case R.id.btPermissionSetting /* 2131363372 */:
                                startActivity(new Intent(getActivity(), (Class<?>) PermissionSettingsActivity.class));
                                return;
                            case R.id.btPointsDetail /* 2131363373 */:
                                startActivity(new Intent(getActivity(), (Class<?>) PointsDetailActivity.class));
                                return;
                            case R.id.btRecharge /* 2131363374 */:
                                String IIX0o2 = OrderManager.IIX0o(OrderManager.f20130oIX0oI, null, null, 3, null);
                                Bundle bundle = new Bundle();
                                bundle.putString("mArg0", IIX0o2);
                                bundle.putInt("mArg1", 2);
                                bundle.putParcelable("mArg2", null);
                                bundle.putSerializable("mArg3", null);
                                Intent intent = new Intent(getActivity(), (Class<?>) GoogleWebViewActivity.class);
                                intent.putExtras(bundle);
                                startActivity(intent);
                                return;
                            default:
                                switch (id) {
                                    case R.id.btSetting /* 2131363376 */:
                                        startActivity(new Intent(getActivity(), (Class<?>) SettingsActivity.class));
                                        return;
                                    case R.id.btSwitch /* 2131363377 */:
                                        startActivity(new Intent(getActivity(), (Class<?>) ThemeActivity.class));
                                        return;
                                    case R.id.btTalk /* 2131363378 */:
                                        ProjectManager.f19822oIX0oI.O0x(getMActivity());
                                        return;
                                    case R.id.btUiRepair /* 2131363379 */:
                                        final com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx05 = new com.sma.smartv3.pop.XoI0Ixx0(getMActivity(), 0, 2, null);
                                        xoI0Ixx05.IoOoX(R.string.ui_repair_remind);
                                        com.sma.smartv3.pop.XoI0Ixx0.IO(xoI0Ixx05, Integer.valueOf(R.string.cancel), null, 2, null);
                                        xoI0Ixx05.x0o(R.string.confirm, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.me.MainMeFragment$onClick$3$1
                                            {
                                                super(0);
                                            }

                                            /* JADX WARN: Can't rename method to resolve collision */
                                            @Override // Oox.oIX0oI
                                            @OXOo.OOXIXo
                                            public final Boolean invoke() {
                                                Activity Oxx0IOOO2 = com.sma.smartv3.pop.XoI0Ixx0.this.Oxx0IOOO();
                                                final com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx06 = com.sma.smartv3.pop.XoI0Ixx0.this;
                                                UtilsKt.OI0(Oxx0IOOO2, new Oox.oIX0oI<kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.MainMeFragment$onClick$3$1.1
                                                    {
                                                        super(0);
                                                    }

                                                    @Override // Oox.oIX0oI
                                                    public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke() {
                                                        invoke2();
                                                        return kotlin.oXIO0o0XI.f29392oIX0oI;
                                                    }

                                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                    public final void invoke2() {
                                                        DeviceInfoChecker.XIxXXX0x0(DeviceInfoChecker.f19983oIX0oI, com.sma.smartv3.pop.XoI0Ixx0.this.Oxx0IOOO(), null, 2, null);
                                                    }
                                                });
                                                return Boolean.TRUE;
                                            }
                                        });
                                        this.mFirmwareRepairPopup = xoI0Ixx05;
                                        View rootView4 = getRootView();
                                        kotlin.jvm.internal.IIX0o.oO(rootView4, "<get-rootView>(...)");
                                        xoI0Ixx05.OxxIIOOXO(rootView4);
                                        return;
                                    case R.id.btUserInfo /* 2131363380 */:
                                        break;
                                    case R.id.btUserOrder /* 2131363381 */:
                                        startActivity(new Intent(getActivity(), (Class<?>) OrderDetailActivity.class));
                                        return;
                                    default:
                                        customOnClick(view.getId());
                                        return;
                                }
                        }
                }
        }
        startActivity(new Intent(getActivity(), (Class<?>) UserInfoActivity.class));
    }

    public final void onGetFreePoints() {
        LogUtils.d("onGetFreePoints");
        if (this.mFreePointPopup == null) {
            FragmentActivity requireActivity = requireActivity();
            kotlin.jvm.internal.IIX0o.oO(requireActivity, "requireActivity(...)");
            com.sma.smartv3.pop.x0xO0oo x0xo0oo = new com.sma.smartv3.pop.x0xO0oo(requireActivity, R.layout.pop_center_prompt_free_point);
            ColorStateList valueOf = ColorStateList.valueOf(getResources().getColor(R.color.order_text_orange));
            kotlin.jvm.internal.IIX0o.oO(valueOf, "valueOf(...)");
            if (ProjectManager.f19822oIX0oI.oIIxXoo()) {
                SPUtils XO2 = com.sma.smartv3.util.Xo0.f24349oIX0oI.XO();
                String str = (String) new Gson().fromJson(XO2.getString(com.sma.smartv3.util.XoI0Ixx0.f24375IxIX0I + '_' + String.class.getName()), String.class);
                if (str == null) {
                    str = "0";
                }
                String string = getString(R.string.ai_privileges_giveaway_tip, Integer.valueOf(Integer.parseInt(str)));
                kotlin.jvm.internal.IIX0o.oO(string, "getString(...)");
                x0xo0oo.oOXoIIIo(R.string.ai_privileges_delivered);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
                String str2 = str;
                spannableStringBuilder.setSpan(new TextAppearanceSpan(null, 0, oI00o.II0xO0.II0xO0(requireActivity(), 16.0f), valueOf, null), StringsKt__StringsKt.O0O0Io00X(string, str2, 0, false, 6, null), StringsKt__StringsKt.O0O0Io00X(string, str2, 0, false, 6, null) + 1, 34);
                x0xo0oo.oo(spannableStringBuilder);
            } else {
                SPUtils XO3 = com.sma.smartv3.util.Xo0.f24349oIX0oI.XO();
                String str3 = (String) new Gson().fromJson(XO3.getString(com.sma.smartv3.util.x0xO0oo.f24598Ox0O + '_' + String.class.getName()), String.class);
                if (str3 == null) {
                    str3 = "0";
                }
                String string2 = getString(R.string.free_points_arrived_tip, Integer.valueOf(Integer.parseInt(str3)));
                kotlin.jvm.internal.IIX0o.oO(string2, "getString(...)");
                x0xo0oo.oOXoIIIo(R.string.free_points_arrived);
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(string2);
                String str4 = str3;
                spannableStringBuilder2.setSpan(new TextAppearanceSpan(null, 0, oI00o.II0xO0.II0xO0(requireActivity(), 16.0f), valueOf, null), StringsKt__StringsKt.O0O0Io00X(string2, str4, 0, false, 6, null), StringsKt__StringsKt.O0O0Io00X(string2, str4, 0, false, 6, null) + 1, 34);
                x0xo0oo.oo(spannableStringBuilder2);
            }
            this.mFreePointPopup = x0xo0oo;
        }
        com.sma.smartv3.pop.x0xO0oo x0xo0oo2 = this.mFreePointPopup;
        if (x0xo0oo2 != null) {
            View rootView = getRootView();
            kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
            x0xo0oo2.xoXoI(rootView);
        }
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragment
    public void onInitBaseLayoutAfter() {
        super.onInitBaseLayoutAfter();
        renderAdapterMethod();
    }

    @XO0.XO(tag = com.sma.smartv3.util.x0xO0oo.f24563I0X0x0oIo)
    public final void onLoginDone(@OXOo.OOXIXo Object data) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(data, "data");
        getUserPoins();
    }

    @XO0.XO(tag = com.sma.smartv3.util.x0xO0oo.f24637oo)
    public final void onNicknameChange(@OXOo.OOXIXo String nickname) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(nickname, "nickname");
        getDslAdapter().notifyDataSetChanged();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        OrderManager orderManager = OrderManager.f20130oIX0oI;
        if (orderManager.o00()) {
            orderManager.oo0xXOI0I(false);
            getUserPoins();
        }
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragment
    public int recyclerViewId() {
        return R.id.rv;
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragment
    public int refreshLayoutId() {
        return 0;
    }

    public void renderAdapterMethod() {
        renderAdapter(new Oox.oOoXoXO<DslAdapter, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.MainMeFragment$renderAdapterMethod$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(DslAdapter dslAdapter) {
                invoke2(dslAdapter);
                return kotlin.oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo DslAdapter renderAdapter) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(renderAdapter, "$this$renderAdapter");
                DslViewHolder dslViewHolder = MainMeFragment.this.getDslViewHolder();
                final MainMeFragment mainMeFragment = MainMeFragment.this;
                dslViewHolder.post(new Oox.oIX0oI<kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.MainMeFragment$renderAdapterMethod$1.1
                    {
                        super(0);
                    }

                    @Override // Oox.oIX0oI
                    public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke() {
                        invoke2();
                        return kotlin.oXIO0o0XI.f29392oIX0oI;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        MainMeFragment.this.getDslAdapter().clearAllItems();
                        final MainMeFragment mainMeFragment2 = MainMeFragment.this;
                        mainMeFragment2.renderAdapter(new Oox.oOoXoXO<DslAdapter, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.MainMeFragment.renderAdapterMethod.1.1.1
                            {
                                super(1);
                            }

                            @Override // Oox.oOoXoXO
                            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(DslAdapter dslAdapter) {
                                invoke2(dslAdapter);
                                return kotlin.oXIO0o0XI.f29392oIX0oI;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@OXOo.OOXIXo DslAdapter renderAdapter2) {
                                BaseDslItem bannerItem;
                                kotlin.jvm.internal.IIX0o.x0xO0oo(renderAdapter2, "$this$renderAdapter");
                                MainAvatarItem mainAvatarItem = new MainAvatarItem();
                                mainAvatarItem.setMOnClick(MainMeFragment.this);
                                DslAdapterExKt.IXxxXO(renderAdapter2, mainAvatarItem, null, 2, null);
                                MainMiddleItem mainMiddleItem = new MainMiddleItem();
                                mainMiddleItem.setMOnClick(MainMeFragment.this);
                                DslAdapterExKt.IXxxXO(renderAdapter2, mainMiddleItem, null, 2, null);
                                MainUserOrderItem mainUserOrderItem = new MainUserOrderItem();
                                mainUserOrderItem.setMOnClick(MainMeFragment.this);
                                DslAdapterExKt.IXxxXO(renderAdapter2, mainUserOrderItem, null, 2, null);
                                DslAdapterExKt.IXxxXO(renderAdapter2, MainMeFragment.this.getMainBottomItem(), null, 2, null);
                                if (ProductManager.f20544oIX0oI.oX000x()) {
                                    if (MainMeFragment.this.getBannerItem() == null) {
                                        MainMeFragment mainMeFragment3 = MainMeFragment.this;
                                        mainMeFragment3.setBannerItem(mainMeFragment3.getAdBannerItem());
                                    }
                                    if (!ProjectManager.f19822oIX0oI.IoOoX() || (bannerItem = MainMeFragment.this.getBannerItem()) == null) {
                                        return;
                                    }
                                    DslAdapterExKt.IXxxXO(renderAdapter2, bannerItem, null, 2, null);
                                }
                            }
                        });
                    }
                });
            }
        });
    }

    public final void setBannerItem(@OXOo.oOoXoXO BaseDslItem baseDslItem) {
        this.bannerItem = baseDslItem;
    }

    public final void showUserIdentityCopyPopup() {
        if (this.mUserIdentityRemindPopup == null) {
            com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0 = new com.sma.smartv3.pop.XoI0Ixx0(getMActivity(), 0, 2, null);
            xoI0Ixx0.IoOoX(R.string.user_identity_use_remind);
            com.sma.smartv3.pop.XoI0Ixx0.IO(xoI0Ixx0, null, null, 2, null);
            xoI0Ixx0.x0o(R.string.confirm, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.me.MainMeFragment$showUserIdentityCopyPopup$1$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OXOo.OOXIXo
                public final Boolean invoke() {
                    return Boolean.TRUE;
                }
            });
            this.mUserIdentityRemindPopup = xoI0Ixx0;
        }
        com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx02 = this.mUserIdentityRemindPopup;
        if (xoI0Ixx02 == null || !xoI0Ixx02.isShowing()) {
            com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx03 = this.mUserIdentityRemindPopup;
            if (xoI0Ixx03 != null) {
                View rootView = getRootView();
                kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
                xoI0Ixx03.OxxIIOOXO(rootView);
            }
            com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
            SPUtils XO2 = xo0.XO();
            Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
            Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
            if (fromJson != null) {
                appUser = fromJson;
            }
            String identity = ((AppUser) appUser).getIdentity();
            if (identity.length() == 0) {
                SPUtils oIX0oI2 = xo0.oIX0oI();
                AppUser appUser2 = (AppUser) new Gson().fromJson(oIX0oI2.getString(com.sma.smartv3.util.XoI0Ixx0.f24462ox + '_' + AppUser.class.getName()), AppUser.class);
                if (appUser2 != null) {
                    identity = appUser2.getIdentity();
                }
            }
            ClipboardUtils.copyText(identity);
            ToastUtils.showLong(R.string.copied);
        }
    }
}
