package com.alimm.tanx.core.orange.bean;

import com.alimm.tanx.core.ad.bean.BaseBean;

/* loaded from: classes.dex */
public class WebConfigBean extends BaseBean {
    public String key;
    public boolean closeInitWebPreload = false;
    public boolean closeNextWebPreload = false;
    public long sdkInitWebViewPreloadDelayed = 0;

    public String toString() {
        return "WebConfigBean{key='" + this.key + "', closeInitWebPreload=" + this.closeInitWebPreload + ", closeNextWebPreload=" + this.closeNextWebPreload + ", sdkInitWebViewPreloadDelayed=" + this.sdkInitWebViewPreloadDelayed + "} ";
    }
}
