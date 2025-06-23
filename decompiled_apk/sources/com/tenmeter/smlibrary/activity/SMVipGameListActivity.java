package com.tenmeter.smlibrary.activity;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.tenmeter.smlibrary.R;
import com.tenmeter.smlibrary.adapter.GameListSubOtherAdapter;
import com.tenmeter.smlibrary.entity.SMGameInfo;
import com.tenmeter.smlibrary.entity.SMIconListParent;
import com.tenmeter.smlibrary.listener.IGameOpenListener;
import com.tenmeter.smlibrary.utils.DisplayUtil;
import com.tenmeter.smlibrary.utils.SGlideRequestListener;
import com.tenmeter.smlibrary.utils.SMGameClient;
import com.tenmeter.smlibrary.utils.URLContent;
import com.tenmeter.smlibrary.utils.Utils;
import com.tenmeter.smlibrary.widget.LoadDia;
import java.util.ArrayList;

/* loaded from: classes13.dex */
public class SMVipGameListActivity extends Activity {
    private SMIconListParent gameListParent;
    private ImageView mBack;
    private RecyclerView mGameList;
    private LoadDia mLoadDia;
    private TextView mSubTitle;
    private TextView mTitle;
    private GameListSubOtherAdapter mTypeAdapter;
    private ImageView mVipBg;

    private void initData() {
        String str;
        String str2;
        TextView textView = this.mSubTitle;
        if (SMGameClient.getInstance().isChina()) {
            str = "会员游戏";
        } else {
            str = "Free content for members";
        }
        textView.setText(str);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mVipBg.getLayoutParams();
        layoutParams.width = DisplayUtil.getScreenWidth() - DisplayUtil.dp2px(44.0f);
        layoutParams.leftMargin = DisplayUtil.dp2px(22.0f);
        layoutParams.height = (int) (((DisplayUtil.getScreenWidth() - DisplayUtil.dp2px(44.0f)) / 324.0d) * 88.0d);
        this.mVipBg.setLayoutParams(layoutParams);
        RequestManager with = Glide.with((Activity) this);
        if (SMGameClient.getInstance().isChina()) {
            str2 = URLContent.VIP_PICTURE_CN;
        } else {
            str2 = URLContent.VIP_PICTURE_EN;
        }
        RequestBuilder<Drawable> load = with.load(str2);
        int i = R.drawable.default_game;
        load.placeholder(ContextCompat.getDrawable(this, i)).error(ContextCompat.getDrawable(this, i)).listener(new SGlideRequestListener(this.mVipBg, ImageView.ScaleType.CENTER_INSIDE, ImageView.ScaleType.CENTER_CROP)).diskCacheStrategy(DiskCacheStrategy.NONE).into(this.mVipBg);
        this.mTitle.setText(this.gameListParent.getIconPageTitle());
        this.mTypeAdapter.setData(this.gameListParent.getGameList());
    }

    private void initView() {
        this.mGameList = (RecyclerView) findViewById(R.id.rv_game_list);
        this.mBack = (ImageView) findViewById(R.id.iv_back);
        this.mTitle = (TextView) findViewById(R.id.tv_title);
        this.mVipBg = (ImageView) findViewById(R.id.iv_vip_bg);
        this.mSubTitle = (TextView) findViewById(R.id.tv_sub_title);
    }

    private void registerListener() {
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.tenmeter.smlibrary.activity.SMVipGameListActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SMVipGameListActivity.this.finish();
            }
        });
        this.mGameList.setLayoutManager(new LinearLayoutManager(this));
        GameListSubOtherAdapter gameListSubOtherAdapter = new GameListSubOtherAdapter(this, new ArrayList(), new GameListSubOtherAdapter.IGameListItemClick() { // from class: com.tenmeter.smlibrary.activity.SMVipGameListActivity.2
            @Override // com.tenmeter.smlibrary.adapter.GameListSubOtherAdapter.IGameListItemClick
            public void itemClick(SMGameInfo sMGameInfo) {
                if (SMGameClient.getInstance().getGameListItemClickListener() != null) {
                    SMGameClient.getInstance().getGameListItemClickListener().gameItemClick(SMVipGameListActivity.this, sMGameInfo);
                } else {
                    SMVipGameListActivity.this.showLoading();
                    SMGameClient.getInstance().startGame(sMGameInfo, SMVipGameListActivity.this, new IGameOpenListener() { // from class: com.tenmeter.smlibrary.activity.SMVipGameListActivity.2.1
                        @Override // com.tenmeter.smlibrary.listener.IGameOpenListener
                        public void openResult(boolean z) {
                            SMVipGameListActivity.this.hideLoading();
                        }
                    });
                }
            }
        });
        this.mTypeAdapter = gameListSubOtherAdapter;
        this.mGameList.setAdapter(gameListSubOtherAdapter);
        this.mVipBg.setOnClickListener(new View.OnClickListener() { // from class: com.tenmeter.smlibrary.activity.SMVipGameListActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SMGameClient.getInstance().getIVipPayClickListener() != null) {
                    SMGameClient.getInstance().getIVipPayClickListener().startVipPay(SMVipGameListActivity.this);
                } else {
                    Toast.makeText(SMVipGameListActivity.this, "IVipPayClickListener is null", 1).show();
                }
            }
        });
    }

    public void hideLoading() {
        LoadDia loadDia = this.mLoadDia;
        if (loadDia != null && loadDia.isShowing()) {
            this.mLoadDia.dismiss();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        if (bundle != null) {
            Utils.relaunchApp(this, true);
        }
        if (getIntent().getExtras().getParcelable("game") != null) {
            this.gameListParent = (SMIconListParent) getIntent().getExtras().getParcelable("game");
        } else {
            Toast.makeText(this, "game不能为null", 1).show();
            finish();
        }
        super.onCreate(bundle);
        setContentView(R.layout.activity_sm_sdk_vip_game_list);
        Utils.setDarkStatusWhite(this, true);
        initView();
        registerListener();
        initData();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    public void showLoading() {
        if (this.mLoadDia == null) {
            this.mLoadDia = new LoadDia(this);
        }
        if (!this.mLoadDia.isShowing()) {
            this.mLoadDia.show();
        }
    }
}
