package com.sma.smartv3.ui.device;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentTransaction;
import com.bestmafen.androidbase.base.BaseActivity;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.google.gson.Gson;
import com.sma.smartv3.biz.OrderManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.UserMember;
import com.tenmeter.smlibrary.fragment.GameListFragment;

@kotlin.jvm.internal.XX({"SMAP\nGameStoreActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GameStoreActivity.kt\ncom/sma/smartv3/ui/device/GameStoreActivity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,96:1\n93#2,2:97\n90#2:99\n*S KotlinDebug\n*F\n+ 1 GameStoreActivity.kt\ncom/sma/smartv3/ui/device/GameStoreActivity\n*L\n52#1:97,2\n52#1:99\n*E\n"})
/* loaded from: classes12.dex */
public final class GameStoreActivity extends BaseActivity {
    private GameListFragment gameListFragment;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO abhTitleRight$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.device.GameStoreActivity$abhTitleRight$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) GameStoreActivity.this.findViewById(R.id.abh_title_right);
        }
    });

    @OXOo.OOXIXo
    private Handler mHandler = new Handler(Looper.getMainLooper());

    private final ImageView getAbhTitleRight() {
        return (ImageView) this.abhTitleRight$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(GameStoreActivity this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.showAILackingTip();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        ((TextView) findViewById(R.id.abh_title_center)).setText(R.string.game_list_title);
        this.gameListFragment = new GameListFragment();
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        GameListFragment gameListFragment = this.gameListFragment;
        if (gameListFragment == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("gameListFragment");
            gameListFragment = null;
        }
        beginTransaction.add(R.id.content, gameListFragment).commit();
        getAbhTitleRight().setVisibility(0);
        getAbhTitleRight().setImageResource(R.drawable.ic_game_right);
        this.mHandler.postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.device.XXXI
            @Override // java.lang.Runnable
            public final void run() {
                GameStoreActivity.initView$lambda$0(GameStoreActivity.this);
            }
        }, 100L);
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_game_store;
    }

    @Override // com.bestmafen.androidbase.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        finish();
    }

    public final void onTitleRightClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        com.sma.smartv3.biz.OOXIXo.f20119oIX0oI.xxX(this);
    }

    public final void showAILackingTip() {
        String str;
        com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
        long j = xo0.XO().getLong(com.sma.smartv3.util.XoI0Ixx0.f24453oXIoO, 0L);
        SPUtils XO2 = xo0.XO();
        Object fromJson = new Gson().fromJson(XO2.getString(com.sma.smartv3.util.x0xO0oo.f24656xOoOIoI + '_' + UserMember.class.getName()), (Class<Object>) UserMember.class);
        if (fromJson == null) {
            fromJson = UserMember.class.newInstance();
        }
        UserMember userMember = (UserMember) fromJson;
        LogUtils.d("GameStoreActivity showAILackingTip  mIsShowTime = " + j + " mUserMember = " + userMember);
        if (userMember.getLatestGameMemberDateTime() > 0) {
            OrderManager orderManager = OrderManager.f20130oIX0oI;
            if (orderManager.XO(j, 1)) {
                if (OrderManager.X0o0xo(orderManager, userMember.getLatestGameMemberDateTime(), 0, 2, null)) {
                    str = getString(R.string.game_store_to_expired_tip);
                } else if (System.currentTimeMillis() - userMember.getLatestGameMemberDateTime() > 0) {
                    str = getString(R.string.game_store_expired_tip);
                } else {
                    str = "";
                }
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(str);
                LogUtils.d("GameStoreActivity showAILackingTip  tipString = " + str + " , currentTimeMillis() = " + System.currentTimeMillis() + "  , latestGameMemberDateTime = " + userMember.getLatestGameMemberDateTime() + TokenParser.SP);
                if (str.length() > 0) {
                    xo0.XO().put(com.sma.smartv3.util.XoI0Ixx0.f24453oXIoO, System.currentTimeMillis());
                    com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0 = new com.sma.smartv3.pop.XoI0Ixx0(this, 0, 2, null);
                    xoI0Ixx0.IoOoX(R.string.tip);
                    xoI0Ixx0.oo(str);
                    xoI0Ixx0.oo0xXOI0I(1);
                    com.sma.smartv3.pop.XoI0Ixx0.IO(xoI0Ixx0, Integer.valueOf(R.string.cancel), null, 2, null);
                    xoI0Ixx0.x0o(R.string.confirm, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.device.GameStoreActivity$showAILackingTip$1$1
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // Oox.oIX0oI
                        @OXOo.OOXIXo
                        public final Boolean invoke() {
                            com.sma.smartv3.biz.OOXIXo.f20119oIX0oI.oI0IIXIo(GameStoreActivity.this);
                            return Boolean.TRUE;
                        }
                    });
                    xoI0Ixx0.IIXOooo();
                }
            }
        }
    }
}
