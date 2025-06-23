package com.alimm.tanx.core.ad.event.track.interaction;

import android.text.TextUtils;
import com.alimm.tanx.core.ad.listener.bean.ITrackItem;
import com.alimm.tanx.core.net.NetWorkManager;
import com.alimm.tanx.core.net.bean.RequestBean;
import com.alimm.tanx.core.net.callback.NetWorkCallBack;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.NotConfused;
import java.util.List;

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
                } catch (Throwable th) {
                    throw th;
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
        if (list != null) {
            for (ITrackItem iTrackItem : list) {
                if (iTrackItem != null && iTrackItem.getType() == 5) {
                    for (String next : iTrackItem.getUrl()) {
                        if (!TextUtils.isEmpty(next)) {
                            try {
                                if (TextUtils.isEmpty(str)) {
                                    next = next.replace(INTERACT_TYPE, "");
                                } else {
                                    next = next.replace(INTERACT_TYPE, str);
                                }
                                if (TextUtils.isEmpty(str2)) {
                                    next = next.replace(INTERACT_DESC, "");
                                } else {
                                    next = next.replace(INTERACT_DESC, str2);
                                }
                            } catch (Exception e) {
                                LogUtils.e("uploadInteraction", e);
                            }
                            RequestBean build = new RequestBean().setUrl(next).build();
                            build.setOverrideError(true);
                            NetWorkManager.getInstance().sendHttpGet(build, Object.class, false, false, new NetWorkCallBack() {
                                public void error(int i, String str, String str2) {
                                    LogUtils.d(InteractionUpload.TAG, str2);
                                }

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
