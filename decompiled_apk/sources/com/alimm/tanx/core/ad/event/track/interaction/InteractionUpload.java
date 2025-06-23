package com.alimm.tanx.core.ad.event.track.interaction;

import android.text.TextUtils;
import com.alimm.tanx.core.ad.listener.bean.ITrackItem;
import com.alimm.tanx.core.net.NetWorkManager;
import com.alimm.tanx.core.net.bean.RequestBean;
import com.alimm.tanx.core.net.callback.NetWorkCallBack;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.NotConfused;
import java.util.List;

/* loaded from: classes.dex */
public class InteractionUpload implements NotConfused {
    public static final int CLOSE = 3;
    private static final String INTERACT_DESC = "__INTERACT_DESC__";
    private static final String INTERACT_TYPE = "__INTERACT_TYPE__";
    public static final int POOR_CONTENT = 5;
    private static final String TAG = "InteractionUpload";
    public static final int UNINTERESTED = 4;
    private static InteractionUpload instance;

    public static InteractionUpload getInstance() {
        if (instance == null) {
            synchronized (InteractionUpload.class) {
                try {
                    if (instance == null) {
                        instance = new InteractionUpload();
                    }
                } finally {
                }
            }
        }
        return instance;
    }

    public void uploadInteraction(List<? extends ITrackItem> list, int i) {
        uploadInteraction(list, i, "");
    }

    public void uploadInteraction(List<? extends ITrackItem> list, int i, String str) {
        uploadInteraction(list, i + "", str);
    }

    public void uploadInteraction(List<? extends ITrackItem> list, String str, String str2) {
        String replace;
        if (list != null) {
            for (ITrackItem iTrackItem : list) {
                if (iTrackItem != null && iTrackItem.getType() == 5) {
                    for (String str3 : iTrackItem.getUrl()) {
                        if (!TextUtils.isEmpty(str3)) {
                            try {
                                if (TextUtils.isEmpty(str)) {
                                    replace = str3.replace(INTERACT_TYPE, "");
                                } else {
                                    replace = str3.replace(INTERACT_TYPE, str);
                                }
                                if (TextUtils.isEmpty(str2)) {
                                    str3 = replace.replace(INTERACT_DESC, "");
                                } else {
                                    str3 = replace.replace(INTERACT_DESC, str2);
                                }
                            } catch (Exception e) {
                                LogUtils.e("uploadInteraction", e);
                            }
                            RequestBean build = new RequestBean().setUrl(str3).build();
                            build.setOverrideError(true);
                            NetWorkManager.getInstance().sendHttpGet(build, Object.class, false, false, new NetWorkCallBack() { // from class: com.alimm.tanx.core.ad.event.track.interaction.InteractionUpload.1
                                @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
                                public void error(int i, String str4, String str5) {
                                    LogUtils.d(InteractionUpload.TAG, str5);
                                }

                                @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
                                public void succ(Object obj) {
                                    LogUtils.d(InteractionUpload.TAG, "");
                                }
                            });
                        }
                    }
                }
            }
        }
    }
}
