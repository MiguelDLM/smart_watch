package com.tenmeter.smlibrary.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.ar.camera.CameraManager;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.tenmeter.smlibrary.R;
import com.tenmeter.smlibrary.activity.SMVipGameListActivity;
import com.tenmeter.smlibrary.entity.SMGameInfo;
import com.tenmeter.smlibrary.entity.SMGameListParent;
import com.tenmeter.smlibrary.entity.SMIconListParent;
import com.tenmeter.smlibrary.entity.SMPOPResultBean;
import com.tenmeter.smlibrary.listener.IGameOpenListener;
import com.tenmeter.smlibrary.utils.DateFormatUtils;
import com.tenmeter.smlibrary.utils.KLog;
import com.tenmeter.smlibrary.utils.PreferencesUtils;
import com.tenmeter.smlibrary.utils.SMGameClient;

/* loaded from: classes13.dex */
public class AdDia extends Dialog {
    private SMPOPResultBean bean;
    private ImageView ivAdClose;
    private ImageView ivAdImg;
    private View rootView;

    public AdDia(@NonNull Context context) {
        super(context, R.style.ADDiaStyle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gameClick(SMGameInfo sMGameInfo) {
        if (sMGameInfo == null) {
            return;
        }
        if (SMGameClient.getInstance().getGameListItemClickListener() != null) {
            SMGameClient.getInstance().getGameListItemClickListener().gameItemClick(scanForActivity(getContext()), sMGameInfo);
            dismiss();
        } else {
            SMGameClient.getInstance().startGame(sMGameInfo, scanForActivity(getContext()), new IGameOpenListener() { // from class: com.tenmeter.smlibrary.widget.AdDia.3
                @Override // com.tenmeter.smlibrary.listener.IGameOpenListener
                public void openResult(boolean z) {
                }
            });
            dismiss();
        }
    }

    private void jumpToVip(SMIconListParent sMIconListParent) {
        if (sMIconListParent == null) {
            return;
        }
        Intent intent = new Intent(scanForActivity(getContext()), (Class<?>) SMVipGameListActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("game", sMIconListParent);
        intent.putExtras(bundle);
        scanForActivity(getContext()).startActivity(intent);
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void process(SMIconListParent sMIconListParent) {
        if (sMIconListParent == null) {
            return;
        }
        if (sMIconListParent.getIconPage() == 2) {
            jumpToVip(sMIconListParent);
            return;
        }
        SMGameListParent sMGameListParent = new SMGameListParent();
        sMGameListParent.setGameList(sMIconListParent.getGameList());
        sMGameListParent.setTagId(sMIconListParent.getIconId());
        sMGameListParent.setTagName(sMIconListParent.getIconPageTitle());
        SMGameClient.getInstance().startGameListSub(sMGameListParent, scanForActivity(getContext()));
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Activity scanForActivity(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (!(context instanceof ContextWrapper)) {
            return null;
        }
        return scanForActivity(((ContextWrapper) context).getBaseContext());
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().getDecorView().setPadding(0, 0, 0, 0);
        getWindow().setLayout(-1, -1);
        View inflate = View.inflate(getContext(), R.layout.sm_sdk_ad, null);
        this.rootView = inflate;
        setContentView(inflate);
        Window window = getWindow();
        try {
            findViewById(getContext().getResources().getIdentifier("android:id/titleDivider", null, null)).setBackgroundColor(0);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            window.setBackgroundDrawable(new ColorDrawable(0));
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = -1;
            if (Build.VERSION.SDK_INT >= 28) {
                attributes.layoutInDisplayCutoutMode = 1;
            }
            window.setAttributes(attributes);
            window.addFlags(Integer.MIN_VALUE);
            window.getDecorView().setSystemUiVisibility(1280);
            setCancelable(false);
            setCanceledOnTouchOutside(false);
            this.ivAdImg = (ImageView) findViewById(R.id.ivAdImg);
            ImageView imageView = (ImageView) findViewById(R.id.ivClose);
            this.ivAdClose = imageView;
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tenmeter.smlibrary.widget.AdDia.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    SMGameClient.getInstance().clickPopOpeDialog(2, null);
                    AdDia.this.dismiss();
                }
            });
            KLog.i("时间戳++++---===" + DateFormatUtils.format(System.currentTimeMillis(), "yyyyMMdd"));
            PreferencesUtils.putString(SMGameClient.getContext(), PreferencesUtils.SAVE_AD_POP_TIME, DateFormatUtils.format(System.currentTimeMillis(), "yyyyMMdd"));
            Glide.with(getContext()).load(this.bean.getResource() + "?x-oss-process=image/resize,m_fill,h_" + CameraManager.DEFAULTHEIGHT + ",w_704").diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(this.ivAdImg);
            this.ivAdImg.setOnClickListener(new View.OnClickListener() { // from class: com.tenmeter.smlibrary.widget.AdDia.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    SMGameClient.getInstance().clickPopOpeDialog(1, null);
                    if (AdDia.this.bean.getLinkType() == 1) {
                        if (AdDia.this.bean.isPlayOnce()) {
                            if (SMGameClient.getInstance().getIAdGameOpenListener() != null) {
                                SMGameClient.getInstance().getIAdGameOpenListener().didOpenGameBlock(AdDia.scanForActivity(AdDia.this.getContext()), AdDia.this.bean.getGameDto());
                            } else if (AdDia.this.bean.getGameDto() == null) {
                                return;
                            } else {
                                SMGameClient.getInstance().startGame(AdDia.this.bean.getGameDto(), AdDia.scanForActivity(AdDia.this.getContext()), new IGameOpenListener() { // from class: com.tenmeter.smlibrary.widget.AdDia.2.1
                                    @Override // com.tenmeter.smlibrary.listener.IGameOpenListener
                                    public void openResult(boolean z) {
                                    }
                                });
                            }
                            AdDia.this.dismiss();
                            return;
                        }
                        AdDia adDia = AdDia.this;
                        adDia.gameClick(adDia.bean.getGameDto());
                        return;
                    }
                    if (AdDia.this.bean.getLinkType() == 4) {
                        if (AdDia.this.bean.getLinkResource() != null) {
                            if (AdDia.this.bean.getLinkResource() == null || !AdDia.this.bean.getLinkResource().equals("null")) {
                                SMGameClient.getInstance().startWebActivity(AdDia.this.bean.getLinkResource(), AdDia.scanForActivity(AdDia.this.getContext()));
                                AdDia.this.dismiss();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    if (AdDia.this.bean.getLinkType() == 2) {
                        AdDia adDia2 = AdDia.this;
                        adDia2.process(adDia2.bean.getIcon());
                    } else {
                        if (AdDia.this.bean.getLinkType() != 3 || AdDia.this.bean.getBanner() == null) {
                            return;
                        }
                        if (!AdDia.this.bean.getBanner().getRedirectUrl().isEmpty() && !AdDia.this.bean.getBanner().getRedirectUrl().equals("null")) {
                            SMGameClient.getInstance().startWebActivity(AdDia.this.bean.getBanner().getRedirectUrl(), AdDia.scanForActivity(AdDia.this.getContext()));
                            AdDia.this.dismiss();
                        } else {
                            AdDia adDia3 = AdDia.this;
                            adDia3.gameClick(adDia3.bean.getBanner().getGame());
                        }
                    }
                }
            });
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
    }

    public AdDia(@NonNull Context context, SMPOPResultBean sMPOPResultBean) {
        super(context, R.style.ADDiaStyle);
        this.bean = sMPOPResultBean;
    }

    public AdDia(@NonNull Context context, int i) {
        super(context, R.style.ADDiaStyle);
    }

    public AdDia(@NonNull Context context, boolean z, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
    }
}
