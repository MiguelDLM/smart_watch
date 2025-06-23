package com.sma.smartv3.ui.device;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bestmafen.androidbase.base.BaseActivity;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.biz.OrderManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.AccountCreateOrder;
import com.sma.smartv3.model.AppUser;
import com.sma.smartv3.model.UserAloneGameDetail;
import com.sma.smartv3.model.UserMember;
import com.sma.smartv3.ui.me.GoogleWebViewActivity;
import com.sma.smartv3.ui.me.WebViewActivity;
import com.sma.smartv3.view.ImageViewRound;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.BleKeyFlag;
import com.szabh.smable3.component.BleConnector;
import com.szabh.smable3.entity.BleGameControl;
import com.tenmeter.smlibrary.entity.SMGameInfo;

@kotlin.jvm.internal.XX({"SMAP\nGameDetailActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GameDetailActivity.kt\ncom/sma/smartv3/ui/device/GameDetailActivity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,344:1\n19#2:345\n15#2:346\n93#2,2:347\n90#2:349\n93#2,2:350\n90#2:352\n93#2,2:353\n90#2:355\n*S KotlinDebug\n*F\n+ 1 GameDetailActivity.kt\ncom/sma/smartv3/ui/device/GameDetailActivity\n*L\n67#1:345\n67#1:346\n108#1:347,2\n108#1:349\n109#1:350,2\n109#1:352\n291#1:353,2\n291#1:355\n*E\n"})
/* loaded from: classes12.dex */
public final class GameDetailActivity extends BaseActivity {
    private boolean isFree;
    private boolean isGetServerData;
    private boolean isNeedPayDialog;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.XoI0Ixx0 mLoginTipPopup;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.XoI0Ixx0 mPayconfirmPopup;
    public SMGameInfo mSMGameInfo;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.XoI0Ixx0 mStartGameTipPopup;

    @OXOo.OOXIXo
    private final AppUser mUser;

    @OXOo.oOoXoXO
    private UserAloneGameDetail mUserAloneGameDetail;

    @OXOo.oOoXoXO
    private UserMember mUserMember;
    private boolean startGameTouch;

    @OXOo.OOXIXo
    private final String TAG = "GameDetailActivity";

    @OXOo.OOXIXo
    private final kotlin.X0IIOO abhTitleRight$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.device.GameDetailActivity$abhTitleRight$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) GameDetailActivity.this.findViewById(R.id.abh_title_right);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mGameIcon$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageViewRound>() { // from class: com.sma.smartv3.ui.device.GameDetailActivity$mGameIcon$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageViewRound invoke() {
            return (ImageViewRound) GameDetailActivity.this.findViewById(R.id.game_detail_iv_avatar);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mGameTitle$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.device.GameDetailActivity$mGameTitle$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) GameDetailActivity.this.findViewById(R.id.game_detail_title);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mGamePlayNum$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.device.GameDetailActivity$mGamePlayNum$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) GameDetailActivity.this.findViewById(R.id.game_detail_play_num);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mGameNewLabel$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.device.GameDetailActivity$mGameNewLabel$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) GameDetailActivity.this.findViewById(R.id.game_detail_new_label);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mGamePayLabel$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.device.GameDetailActivity$mGamePayLabel$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) GameDetailActivity.this.findViewById(R.id.game_detail_pay_label);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mGameImg$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageViewRound>() { // from class: com.sma.smartv3.ui.device.GameDetailActivity$mGameImg$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageViewRound invoke() {
            return (ImageViewRound) GameDetailActivity.this.findViewById(R.id.game_detail_content_icon);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mGameContent$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.device.GameDetailActivity$mGameContent$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) GameDetailActivity.this.findViewById(R.id.game_detail_content);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mGamePayLayout$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.device.GameDetailActivity$mGamePayLayout$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return GameDetailActivity.this.findViewById(R.id.game_pay_layout);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mGameAlonePayBtn$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<Button>() { // from class: com.sma.smartv3.ui.device.GameDetailActivity$mGameAlonePayBtn$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final Button invoke() {
            return (Button) GameDetailActivity.this.findViewById(R.id.game_alone_pay_btn);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mGamePayMemberBtn$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<Button>() { // from class: com.sma.smartv3.ui.device.GameDetailActivity$mGamePayMemberBtn$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final Button invoke() {
            return (Button) GameDetailActivity.this.findViewById(R.id.game_pay_member_btn);
        }
    });

    @OXOo.OOXIXo
    private String orderNum = "";

    public GameDetailActivity() {
        SPUtils XO2 = com.sma.smartv3.util.Xo0.f24349oIX0oI.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        this.mUser = (AppUser) (fromJson != null ? fromJson : appUser);
    }

    private final ImageView getAbhTitleRight() {
        return (ImageView) this.abhTitleRight$delegate.getValue();
    }

    private final Button getMGameAlonePayBtn() {
        return (Button) this.mGameAlonePayBtn$delegate.getValue();
    }

    private final TextView getMGameContent() {
        return (TextView) this.mGameContent$delegate.getValue();
    }

    private final ImageViewRound getMGameIcon() {
        return (ImageViewRound) this.mGameIcon$delegate.getValue();
    }

    private final ImageViewRound getMGameImg() {
        return (ImageViewRound) this.mGameImg$delegate.getValue();
    }

    private final TextView getMGameNewLabel() {
        return (TextView) this.mGameNewLabel$delegate.getValue();
    }

    private final TextView getMGamePayLabel() {
        return (TextView) this.mGamePayLabel$delegate.getValue();
    }

    private final View getMGamePayLayout() {
        return (View) this.mGamePayLayout$delegate.getValue();
    }

    private final Button getMGamePayMemberBtn() {
        return (Button) this.mGamePayMemberBtn$delegate.getValue();
    }

    private final TextView getMGamePlayNum() {
        return (TextView) this.mGamePlayNum$delegate.getValue();
    }

    private final TextView getMGameTitle() {
        return (TextView) this.mGameTitle$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(final GameDetailActivity this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        if (this$0.mUserAloneGameDetail != null) {
            if (!ProjectManager.f19822oIX0oI.xIOXX()) {
                showLoginTipPopup$default(this$0, 0, 1, null);
                return;
            } else {
                OrderManager.f20130oIX0oI.oIX0oI("Game", String.valueOf(this$0.getMSMGameInfo().getGid()), this$0, new Oox.oOoXoXO<AccountCreateOrder, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.GameDetailActivity$initView$1$1
                    {
                        super(1);
                    }

                    @Override // Oox.oOoXoXO
                    public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(AccountCreateOrder accountCreateOrder) {
                        invoke2(accountCreateOrder);
                        return kotlin.oXIO0o0XI.f29392oIX0oI;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@OXOo.oOoXoXO AccountCreateOrder accountCreateOrder) {
                        String str;
                        String str2;
                        if (accountCreateOrder != null) {
                            GameDetailActivity.this.setNeedPayDialog(true);
                            GameDetailActivity.this.orderNum = accountCreateOrder.getOrderNum();
                            if (ProjectManager.f19822oIX0oI.Oxx0xo()) {
                                GameDetailActivity gameDetailActivity = GameDetailActivity.this;
                                com.sma.smartv3.biz.OOXIXo oOXIXo = com.sma.smartv3.biz.OOXIXo.f20119oIX0oI;
                                str2 = gameDetailActivity.orderNum;
                                String OOXIXo2 = oOXIXo.OOXIXo(str2);
                                Bundle bundle = new Bundle();
                                bundle.putString("mArg0", OOXIXo2);
                                bundle.putInt("mArg1", 2);
                                bundle.putParcelable("mArg2", null);
                                bundle.putSerializable("mArg3", null);
                                Intent intent = new Intent(gameDetailActivity, (Class<?>) GoogleWebViewActivity.class);
                                intent.putExtras(bundle);
                                gameDetailActivity.startActivity(intent);
                                return;
                            }
                            GameDetailActivity gameDetailActivity2 = GameDetailActivity.this;
                            com.sma.smartv3.biz.OOXIXo oOXIXo2 = com.sma.smartv3.biz.OOXIXo.f20119oIX0oI;
                            str = gameDetailActivity2.orderNum;
                            String OOXIXo3 = oOXIXo2.OOXIXo(str);
                            Bundle bundle2 = new Bundle();
                            bundle2.putString("mArg0", OOXIXo3);
                            bundle2.putInt("mArg1", 2);
                            bundle2.putParcelable("mArg2", null);
                            bundle2.putSerializable("mArg3", null);
                            Intent intent2 = new Intent(gameDetailActivity2, (Class<?>) WebViewActivity.class);
                            intent2.putExtras(bundle2);
                            gameDetailActivity2.startActivity(intent2);
                            return;
                        }
                        ToastUtils.showLong(GameDetailActivity.this.getString(R.string.fail_order), new Object[0]);
                    }
                });
                return;
            }
        }
        com.sma.smartv3.biz.OOXIXo.f20119oIX0oI.oI0IIXIo(this$0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(GameDetailActivity this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        String str = null;
        if (!ProjectManager.f19822oIX0oI.xIOXX() && !this$0.isFree) {
            showLoginTipPopup$default(this$0, 0, 1, null);
            return;
        }
        com.sma.smartv3.biz.OOXIXo oOXIXo = com.sma.smartv3.biz.OOXIXo.f20119oIX0oI;
        UserMember userMember = this$0.mUserMember;
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(userMember);
        if (!oOXIXo.o00(userMember)) {
            UserAloneGameDetail userAloneGameDetail = this$0.mUserAloneGameDetail;
            if (userAloneGameDetail != null) {
                str = userAloneGameDetail.getPayStatus();
            }
            if (!kotlin.jvm.internal.IIX0o.Oxx0IOOO(str, "Payed") && !this$0.isFree) {
                oOXIXo.oI0IIXIo(this$0);
                return;
            }
        }
        this$0.startGame();
    }

    public static /* synthetic */ void showLoginTipPopup$default(GameDetailActivity gameDetailActivity, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = R.string.game_nologin_tip;
        }
        gameDetailActivity.showLoginTipPopup(i);
    }

    private final void showPayConfirm() {
        if (this.mPayconfirmPopup == null) {
            com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0 = new com.sma.smartv3.pop.XoI0Ixx0(this, 0, 2, null);
            xoI0Ixx0.x0xO0oo(false);
            xoI0Ixx0.IoOoX(R.string.payment_completed_tip);
            xoI0Ixx0.X00IoxXI(Integer.valueOf(R.string.cancel), new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.device.GameDetailActivity$showPayConfirm$1$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OXOo.OOXIXo
                public final Boolean invoke() {
                    return Boolean.TRUE;
                }
            });
            xoI0Ixx0.x0o(R.string.yes_payment, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.device.GameDetailActivity$showPayConfirm$1$2
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OXOo.OOXIXo
                public final Boolean invoke() {
                    GameDetailActivity.this.onOrderPayStatusChange("");
                    return Boolean.TRUE;
                }
            });
            this.mPayconfirmPopup = xoI0Ixx0;
        }
        com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx02 = this.mPayconfirmPopup;
        if (xoI0Ixx02 != null) {
            xoI0Ixx02.IIXOooo();
        }
    }

    @OXOo.OOXIXo
    public final SMGameInfo getMSMGameInfo() {
        SMGameInfo sMGameInfo = this.mSMGameInfo;
        if (sMGameInfo != null) {
            return sMGameInfo;
        }
        kotlin.jvm.internal.IIX0o.XOxIOxOx("mSMGameInfo");
        return null;
    }

    @OXOo.OOXIXo
    public final AppUser getMUser() {
        return this.mUser;
    }

    @OXOo.oOoXoXO
    public final UserAloneGameDetail getMUserAloneGameDetail() {
        return this.mUserAloneGameDetail;
    }

    @OXOo.oOoXoXO
    public final UserMember getMUserMember() {
        return this.mUserMember;
    }

    public final void getServerData() {
        boolean contains = com.sma.smartv3.biz.OOXIXo.f20119oIX0oI.xxIXOIIO().contains(Integer.valueOf(getMSMGameInfo().getGid()));
        this.isFree = contains;
        if (!contains) {
            if (ProjectManager.f19822oIX0oI.xIOXX()) {
                this.isGetServerData = true;
                OrderManager.f20130oIX0oI.xxX(new Oox.oOoXoXO<Boolean, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.GameDetailActivity$getServerData$1
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
                        OrderManager.f20130oIX0oI.x0XOIxOo(String.valueOf(GameDetailActivity.this.getMSMGameInfo().getGid()), new Oox.oOoXoXO<Boolean, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.GameDetailActivity$getServerData$1.1
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
                });
                return;
            }
            View mGamePayLayout = getMGamePayLayout();
            if (mGamePayLayout != null) {
                mGamePayLayout.setVisibility(0);
            }
            Button mGameAlonePayBtn = getMGameAlonePayBtn();
            if (mGameAlonePayBtn != null) {
                mGameAlonePayBtn.setVisibility(8);
            }
        }
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
        Parcelable mArg2 = getMArg2();
        kotlin.jvm.internal.IIX0o.x0XOIxOo(mArg2, "null cannot be cast to non-null type com.tenmeter.smlibrary.entity.SMGameInfo");
        setMSMGameInfo((SMGameInfo) mArg2);
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " gid = " + getMSMGameInfo().getGid() + "  " + getMSMGameInfo().getLabel());
    }

    @Override // com.bestmafen.androidbase.base.BaseActivity, com.bestmafen.androidbase.base.oIX0oI
    public boolean initEvent() {
        return true;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        int color;
        String I0Io2;
        String string;
        if (!this.isGetServerData) {
            getServerData();
        }
        com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
        SPUtils XO2 = xo0.XO();
        Object fromJson = new Gson().fromJson(XO2.getString(com.sma.smartv3.util.x0xO0oo.f24656xOoOIoI + '_' + UserMember.class.getName()), (Class<Object>) UserMember.class);
        if (fromJson == null) {
            fromJson = UserMember.class.newInstance();
        }
        this.mUserMember = (UserMember) fromJson;
        SPUtils XO3 = xo0.XO();
        Object fromJson2 = new Gson().fromJson(XO3.getString(com.sma.smartv3.util.x0xO0oo.f24597OoO + '_' + UserAloneGameDetail.class.getName()), (Class<Object>) UserAloneGameDetail.class);
        if (fromJson2 == null) {
            fromJson2 = UserAloneGameDetail.class.newInstance();
        }
        this.mUserAloneGameDetail = (UserAloneGameDetail) fromJson2;
        ((TextView) findViewById(R.id.abh_title_center)).setText(R.string.game_detail_title);
        Glide.with((FragmentActivity) this).load(getMSMGameInfo().getBackground()).into(getMGameIcon());
        Glide.with((FragmentActivity) this).load(getMSMGameInfo().getBackground()).into(getMGameImg());
        getAbhTitleRight().setImageResource(R.drawable.game_detail_right_icon);
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (this.isFree) {
            getMGamePayLayout().setVisibility(0);
            getMGamePayLabel().setText(getString(R.string.free_order_amount));
            color = getResources().getColor(R.color.game_member_free_tv_color);
        } else {
            getMGamePayLabel().setText(getString(R.string.game_detail_pay_tip));
            color = getResources().getColor(R.color.game_member_pay_tv_color);
        }
        gradientDrawable.setCornerRadii(new float[]{20.0f, 20.0f, 20.0f, 20.0f, 20.0f, 20.0f, 0.0f, 0.0f});
        gradientDrawable.setColor(color);
        getMGamePayLabel().setBackground(gradientDrawable);
        getMGameTitle().setText(getMSMGameInfo().getGname());
        getMGamePlayNum().setText(getString(R.string.game_play_num, Long.valueOf(getMSMGameInfo().getPlayNum())));
        getMGameContent().setText(getMSMGameInfo().getDetails());
        Button mGameAlonePayBtn = getMGameAlonePayBtn();
        ProjectManager projectManager = ProjectManager.f19822oIX0oI;
        String str = null;
        if (projectManager.Oxx0xo()) {
            UserAloneGameDetail userAloneGameDetail = this.mUserAloneGameDetail;
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(userAloneGameDetail);
            I0Io2 = com.sma.smartv3.ui.device.dialpay.oIX0oI.I0Io(userAloneGameDetail.getDollar(), null, 2, null);
        } else {
            UserAloneGameDetail userAloneGameDetail2 = this.mUserAloneGameDetail;
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(userAloneGameDetail2);
            I0Io2 = com.sma.smartv3.ui.device.dialpay.oIX0oI.I0Io(userAloneGameDetail2.getAmount(), null, 2, null);
        }
        mGameAlonePayBtn.setText(I0Io2);
        Button mGamePayMemberBtn = getMGamePayMemberBtn();
        com.sma.smartv3.biz.OOXIXo oOXIXo = com.sma.smartv3.biz.OOXIXo.f20119oIX0oI;
        UserMember userMember = this.mUserMember;
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(userMember);
        if (!oOXIXo.o00(userMember)) {
            UserAloneGameDetail userAloneGameDetail3 = this.mUserAloneGameDetail;
            if (userAloneGameDetail3 != null) {
                str = userAloneGameDetail3.getPayStatus();
            }
            if (!kotlin.jvm.internal.IIX0o.Oxx0IOOO(str, "Payed") && !this.isFree) {
                UserMember userMember2 = this.mUserMember;
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(userMember2);
                if (userMember2.getLatestGameMemberDateTime() > 0) {
                    string = getString(R.string.game_detail_renewal_member);
                } else if (projectManager.xIOXX()) {
                    string = getString(R.string.game_detail_pay_member);
                } else {
                    string = getString(R.string.game_detail_start_game);
                }
                mGamePayMemberBtn.setText(string);
                getMGameAlonePayBtn().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.IOoo
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        GameDetailActivity.initView$lambda$0(GameDetailActivity.this, view);
                    }
                });
                getMGamePayMemberBtn().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.oIIxXoo
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        GameDetailActivity.initView$lambda$1(GameDetailActivity.this, view);
                    }
                });
                getAbhTitleRight().setVisibility(0);
            }
        }
        getMGameAlonePayBtn().setVisibility(8);
        string = getString(R.string.game_detail_start_game);
        mGamePayMemberBtn.setText(string);
        getMGameAlonePayBtn().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.IOoo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GameDetailActivity.initView$lambda$0(GameDetailActivity.this, view);
            }
        });
        getMGamePayMemberBtn().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.oIIxXoo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GameDetailActivity.initView$lambda$1(GameDetailActivity.this, view);
            }
        });
        getAbhTitleRight().setVisibility(0);
    }

    public final boolean isFree() {
        return this.isFree;
    }

    public final boolean isGetServerData() {
        return this.isGetServerData;
    }

    public final boolean isNeedPayDialog() {
        return this.isNeedPayDialog;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_game_detail;
    }

    @Override // com.bestmafen.androidbase.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        BleConnector.sendObject$default(BleConnector.INSTANCE, BleKey.GAME_CONTROL, BleKeyFlag.UPDATE, new BleGameControl(4, 0, 0, 0, 14, null), false, false, 24, null);
    }

    @XO0.XO(tag = com.sma.smartv3.util.x0xO0oo.f24583O0)
    public final void onOrderPayStatusChange(@OXOo.OOXIXo Object data) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(data, "data");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " onOrderPayStatusChange");
        this.isNeedPayDialog = false;
        com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0 = this.mPayconfirmPopup;
        if (xoI0Ixx0 != null && xoI0Ixx0 != null) {
            xoI0Ixx0.dismiss();
        }
        getMGamePayLayout().setVisibility(8);
        getServerData();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.isNeedPayDialog) {
            this.isNeedPayDialog = false;
            showPayConfirm();
        }
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        finish();
    }

    public final void onTitleRightClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (ProjectManager.f19822oIX0oI.xIOXX()) {
            com.sma.smartv3.biz.OOXIXo.f20119oIX0oI.oI0IIXIo(this);
        } else {
            showLoginTipPopup$default(this, 0, 1, null);
        }
    }

    @XO0.XO(tag = com.sma.smartv3.util.x0xO0oo.f24597OoO)
    public final void onUserGameDetailChange(@OXOo.OOXIXo Object data) {
        String str;
        String I0Io2;
        kotlin.jvm.internal.IIX0o.x0xO0oo(data, "data");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " onUserMemberChange");
        getMGamePayLayout().setVisibility(0);
        SPUtils XO2 = com.sma.smartv3.util.Xo0.f24349oIX0oI.XO();
        Object fromJson = new Gson().fromJson(XO2.getString(com.sma.smartv3.util.x0xO0oo.f24597OoO + '_' + UserAloneGameDetail.class.getName()), (Class<Object>) UserAloneGameDetail.class);
        if (fromJson == null) {
            fromJson = UserAloneGameDetail.class.newInstance();
        }
        UserAloneGameDetail userAloneGameDetail = (UserAloneGameDetail) fromJson;
        this.mUserAloneGameDetail = userAloneGameDetail;
        if (userAloneGameDetail != null) {
            str = userAloneGameDetail.getPayStatus();
        } else {
            str = null;
        }
        if (!kotlin.jvm.internal.IIX0o.Oxx0IOOO(str, "Payed")) {
            com.sma.smartv3.biz.OOXIXo oOXIXo = com.sma.smartv3.biz.OOXIXo.f20119oIX0oI;
            UserMember userMember = this.mUserMember;
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(userMember);
            if (!oOXIXo.o00(userMember)) {
                Button mGameAlonePayBtn = getMGameAlonePayBtn();
                if (ProjectManager.f19822oIX0oI.Oxx0xo()) {
                    UserAloneGameDetail userAloneGameDetail2 = this.mUserAloneGameDetail;
                    kotlin.jvm.internal.IIX0o.ooOOo0oXI(userAloneGameDetail2);
                    I0Io2 = com.sma.smartv3.ui.device.dialpay.oIX0oI.I0Io(userAloneGameDetail2.getDollar(), null, 2, null);
                } else {
                    UserAloneGameDetail userAloneGameDetail3 = this.mUserAloneGameDetail;
                    kotlin.jvm.internal.IIX0o.ooOOo0oXI(userAloneGameDetail3);
                    I0Io2 = com.sma.smartv3.ui.device.dialpay.oIX0oI.I0Io(userAloneGameDetail3.getAmount(), null, 2, null);
                }
                mGameAlonePayBtn.setText(I0Io2);
                getMGameAlonePayBtn().setVisibility(0);
            }
        }
        initView();
    }

    public final void setFree(boolean z) {
        this.isFree = z;
    }

    public final void setGetServerData(boolean z) {
        this.isGetServerData = z;
    }

    public final void setMSMGameInfo(@OXOo.OOXIXo SMGameInfo sMGameInfo) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sMGameInfo, "<set-?>");
        this.mSMGameInfo = sMGameInfo;
    }

    public final void setMUserAloneGameDetail(@OXOo.oOoXoXO UserAloneGameDetail userAloneGameDetail) {
        this.mUserAloneGameDetail = userAloneGameDetail;
    }

    public final void setMUserMember(@OXOo.oOoXoXO UserMember userMember) {
        this.mUserMember = userMember;
    }

    public final void setNeedPayDialog(boolean z) {
        this.isNeedPayDialog = z;
    }

    public final void showLoginTipPopup(int i) {
        com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0;
        if (this.mLoginTipPopup == null) {
            com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx02 = new com.sma.smartv3.pop.XoI0Ixx0(this, 0, 2, null);
            xoI0Ixx02.IoOoX(R.string.tip);
            xoI0Ixx02.xI(Integer.valueOf(i));
            xoI0Ixx02.oo0xXOI0I(1);
            com.sma.smartv3.pop.XoI0Ixx0.IO(xoI0Ixx02, Integer.valueOf(R.string.cancel), null, 2, null);
            xoI0Ixx02.x0o(R.string.yes_payment_go, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.device.GameDetailActivity$showLoginTipPopup$1$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OXOo.OOXIXo
                public final Boolean invoke() {
                    Activity mContext;
                    ProjectManager projectManager = ProjectManager.f19822oIX0oI;
                    mContext = GameDetailActivity.this.getMContext();
                    projectManager.OooO0XOx(mContext);
                    return Boolean.TRUE;
                }
            });
            this.mLoginTipPopup = xoI0Ixx02;
        }
        com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx03 = this.mLoginTipPopup;
        if ((xoI0Ixx03 == null || !xoI0Ixx03.isShowing()) && (xoI0Ixx0 = this.mLoginTipPopup) != null) {
            xoI0Ixx0.IIXOooo();
        }
    }

    public final void showStartGameTipPopup() {
        if (this.mStartGameTipPopup == null) {
            final com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0 = new com.sma.smartv3.pop.XoI0Ixx0(this, 0, 2, null);
            xoI0Ixx0.IoOoX(R.string.tip);
            xoI0Ixx0.xI(Integer.valueOf(R.string.game_detail_guidance_content));
            xoI0Ixx0.oo0xXOI0I(1);
            com.sma.smartv3.pop.XoI0Ixx0.IO(xoI0Ixx0, null, null, 2, null);
            xoI0Ixx0.x0o(R.string.game_detail_guidance_knew, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.device.GameDetailActivity$showStartGameTipPopup$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OXOo.OOXIXo
                public final Boolean invoke() {
                    boolean z;
                    boolean z2;
                    GameDetailActivity gameDetailActivity = GameDetailActivity.this;
                    z = gameDetailActivity.startGameTouch;
                    gameDetailActivity.startGameTouch = !z;
                    z2 = GameDetailActivity.this.startGameTouch;
                    if (z2) {
                        com.sma.smartv3.biz.OOXIXo.f20119oIX0oI.XI0IXoo(GameDetailActivity.this.getMSMGameInfo(), GameDetailActivity.this);
                    }
                    xoI0Ixx0.dismiss();
                    return Boolean.TRUE;
                }
            });
            this.mStartGameTipPopup = xoI0Ixx0;
        }
        this.startGameTouch = false;
        com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx02 = this.mStartGameTipPopup;
        if (xoI0Ixx02 != null) {
            xoI0Ixx02.IIXOooo();
        }
    }

    public final void startGame() {
        com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
        String string = xo0.oIX0oI().getString(com.sma.smartv3.util.XoI0Ixx0.f24356I0xX0 + this.mUser.getIdentity(), "");
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(string);
        if (string.length() > 0) {
            if (!kotlin.jvm.internal.IIX0o.Oxx0IOOO(string, this.mUser.getNickname() + this.mUser.getAvatarUrl())) {
                xo0.oIX0oI().put(com.sma.smartv3.util.XoI0Ixx0.f24356I0xX0 + this.mUser.getIdentity(), this.mUser.getNickname() + this.mUser.getAvatarUrl());
                com.sma.smartv3.biz.OOXIXo.f20119oIX0oI.OxI(this.mUser.getIdentity(), this.mUser.getNickname(), this.mUser.getAvatarUrl());
                showStartGameTipPopup();
            }
        }
        com.sma.smartv3.biz.OOXIXo.f20119oIX0oI.X0IIOO(this.mUser.getIdentity(), this.mUser.getNickname(), this.mUser.getAvatarUrl());
        showStartGameTipPopup();
    }
}
