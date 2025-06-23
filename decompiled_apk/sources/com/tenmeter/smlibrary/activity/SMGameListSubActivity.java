package com.tenmeter.smlibrary.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tenmeter.smlibrary.R;
import com.tenmeter.smlibrary.adapter.GameListSubOtherAdapter;
import com.tenmeter.smlibrary.entity.SMGameInfo;
import com.tenmeter.smlibrary.entity.SMGameListParent;
import com.tenmeter.smlibrary.listener.IGameOpenListener;
import com.tenmeter.smlibrary.utils.SMGameClient;
import com.tenmeter.smlibrary.utils.Utils;
import com.tenmeter.smlibrary.widget.LoadDia;
import java.util.ArrayList;

/* loaded from: classes13.dex */
public class SMGameListSubActivity extends Activity {
    private SMGameListParent gameListParent;
    private ImageView mBack;
    private RecyclerView mGameList;
    private LoadDia mLoadDia;
    private TextView mTitle;
    private GameListSubOtherAdapter mTypeAdapter;

    private void initData() {
        this.mTitle.setText(this.gameListParent.getTagName());
        this.mTypeAdapter.setData(this.gameListParent.getGameList());
    }

    private void initView() {
        this.mGameList = (RecyclerView) findViewById(R.id.rv_game_list);
        this.mBack = (ImageView) findViewById(R.id.iv_back);
        this.mTitle = (TextView) findViewById(R.id.tv_title);
    }

    private void registerListener() {
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.tenmeter.smlibrary.activity.SMGameListSubActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SMGameListSubActivity.this.finish();
            }
        });
        this.mGameList.setLayoutManager(new LinearLayoutManager(this));
        GameListSubOtherAdapter gameListSubOtherAdapter = new GameListSubOtherAdapter(this, new ArrayList(), new GameListSubOtherAdapter.IGameListItemClick() { // from class: com.tenmeter.smlibrary.activity.SMGameListSubActivity.2
            @Override // com.tenmeter.smlibrary.adapter.GameListSubOtherAdapter.IGameListItemClick
            public void itemClick(SMGameInfo sMGameInfo) {
                if (SMGameClient.getInstance().getGameListItemClickListener() != null) {
                    SMGameClient.getInstance().getGameListItemClickListener().gameItemClick(SMGameListSubActivity.this, sMGameInfo);
                } else {
                    SMGameListSubActivity.this.showLoading();
                    SMGameClient.getInstance().startGame(sMGameInfo, SMGameListSubActivity.this, new IGameOpenListener() { // from class: com.tenmeter.smlibrary.activity.SMGameListSubActivity.2.1
                        @Override // com.tenmeter.smlibrary.listener.IGameOpenListener
                        public void openResult(boolean z) {
                            SMGameListSubActivity.this.hideLoading();
                        }
                    });
                }
            }
        });
        this.mTypeAdapter = gameListSubOtherAdapter;
        this.mGameList.setAdapter(gameListSubOtherAdapter);
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
            this.gameListParent = (SMGameListParent) getIntent().getExtras().getParcelable("game");
        } else {
            Toast.makeText(this, "game不能为null", 1).show();
            finish();
        }
        super.onCreate(bundle);
        setContentView(R.layout.activity_sm_sdk_game_list_sub);
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
