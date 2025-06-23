package com.tenmeter.smlibrary.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tenmeter.smlibrary.R;
import com.tenmeter.smlibrary.entity.SMGameListParent;
import com.tenmeter.smlibrary.fragment.GameListFragment;
import com.tenmeter.smlibrary.utils.SMGameClient;
import com.tenmeter.smlibrary.utils.Utils;

/* loaded from: classes13.dex */
public class SMGameListNewActivity extends AppCompatActivity {
    private SMGameListParent leisureGameDatas;
    private ImageView mBack;
    private TextView mTitle;

    private void getGameTypeData() {
    }

    private void initData() {
        String str;
        TextView textView = this.mTitle;
        if (SMGameClient.getInstance().isChina()) {
            str = "体感游戏";
        } else {
            str = "Motion-Sensing Game";
        }
        textView.setText(str);
    }

    private void initView() {
        getSupportFragmentManager().beginTransaction().add(R.id.fl_container, new GameListFragment()).commit();
        this.mBack = (ImageView) findViewById(R.id.iv_back);
        this.mTitle = (TextView) findViewById(R.id.tv_title);
    }

    private void registerListener() {
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.tenmeter.smlibrary.activity.SMGameListNewActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SMGameListNewActivity.this.finish();
            }
        });
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (bundle != null) {
            Utils.relaunchApp(this, true);
        }
        super.onCreate(bundle);
        setContentView(R.layout.activity_sm_sdk_game_list_new);
        Utils.setDarkStatusWhite(this, true);
        initView();
        registerListener();
        initData();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }
}
