package com.tenmeter.smlibrary.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import com.baidu.ar.camera.CameraManager;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.tenmeter.smlibrary.R;
import com.tenmeter.smlibrary.entity.SMGameInfo;
import com.tenmeter.smlibrary.entity.SMGameListParent;
import com.tenmeter.smlibrary.entity.SMIconListParent;
import com.tenmeter.smlibrary.entity.SMPOPResultBean;
import com.tenmeter.smlibrary.listener.IGameOpenListener;
import com.tenmeter.smlibrary.utils.SMGameClient;
import com.tenmeter.smlibrary.utils.Utils;

/* loaded from: classes13.dex */
public class SMADActivity extends Activity {
    private SMPOPResultBean bean;
    private ImageView ivAdClose;
    private ImageView ivAdImg;

    /* JADX INFO: Access modifiers changed from: private */
    public void gameClick(SMGameInfo sMGameInfo) {
        if (SMGameClient.getInstance().getGameListItemClickListener() != null) {
            SMGameClient.getInstance().getGameListItemClickListener().gameItemClick(this, sMGameInfo);
        } else {
            SMGameClient.getInstance().startGame(sMGameInfo, this, new IGameOpenListener() { // from class: com.tenmeter.smlibrary.activity.SMADActivity.3
                @Override // com.tenmeter.smlibrary.listener.IGameOpenListener
                public void openResult(boolean z) {
                }
            });
            finish();
        }
    }

    private void initData() {
        Glide.with((Activity) this).load(this.bean.getResource() + "?x-oss-process=image/resize,m_fill,h_" + CameraManager.DEFAULTHEIGHT + ",w_704").diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(this.ivAdImg);
        this.ivAdImg.setOnClickListener(new View.OnClickListener() { // from class: com.tenmeter.smlibrary.activity.SMADActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SMADActivity.this.bean.getLinkType() == 1) {
                    if (SMADActivity.this.bean.isPlayOnce()) {
                        SMGameClient.getInstance().startGame(SMADActivity.this.bean.getGameDto(), SMADActivity.this, new IGameOpenListener() { // from class: com.tenmeter.smlibrary.activity.SMADActivity.2.1
                            @Override // com.tenmeter.smlibrary.listener.IGameOpenListener
                            public void openResult(boolean z) {
                            }
                        });
                        return;
                    } else {
                        SMADActivity sMADActivity = SMADActivity.this;
                        sMADActivity.gameClick(sMADActivity.bean.getGameDto());
                        return;
                    }
                }
                if (SMADActivity.this.bean.getLinkType() == 4) {
                    SMGameClient.getInstance().startWebActivity(SMADActivity.this.bean.getLinkResource(), SMADActivity.this);
                } else if (SMADActivity.this.bean.getLinkType() == 2) {
                    SMADActivity sMADActivity2 = SMADActivity.this;
                    sMADActivity2.process(sMADActivity2.bean.getIcon());
                }
            }
        });
    }

    private void initView() {
        this.ivAdImg = (ImageView) findViewById(R.id.ivAdImg);
        this.ivAdClose = (ImageView) findViewById(R.id.ivClose);
    }

    private void jumpToVip(SMIconListParent sMIconListParent) {
        Intent intent = new Intent(this, (Class<?>) SMVipGameListActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("game", sMIconListParent);
        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void process(SMIconListParent sMIconListParent) {
        if (sMIconListParent.getIconPage() == 2) {
            jumpToVip(sMIconListParent);
            return;
        }
        SMGameListParent sMGameListParent = new SMGameListParent();
        sMGameListParent.setGameList(sMIconListParent.getGameList());
        sMGameListParent.setTagId(sMIconListParent.getIconId());
        sMGameListParent.setTagName(sMIconListParent.getIconPageTitle());
        SMGameClient.getInstance().startGameListSub(sMGameListParent, this);
        finish();
    }

    private void registerListener() {
        this.ivAdClose.setOnClickListener(new View.OnClickListener() { // from class: com.tenmeter.smlibrary.activity.SMADActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SMADActivity.this.finish();
            }
        });
    }

    @Override // android.app.Activity
    public void onBackPressed() {
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        if (bundle != null) {
            Utils.relaunchApp(this, true);
        }
        if (getIntent().getExtras().getParcelable("bean") != null) {
            this.bean = (SMPOPResultBean) getIntent().getExtras().getParcelable("bean");
        } else {
            Toast.makeText(this, "data不能为null", 1).show();
            finish();
        }
        super.onCreate(bundle);
        setContentView(R.layout.activity_sm_ad);
        Utils.setDarkStatusWhite(this, true);
        initView();
        registerListener();
        initData();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }
}
