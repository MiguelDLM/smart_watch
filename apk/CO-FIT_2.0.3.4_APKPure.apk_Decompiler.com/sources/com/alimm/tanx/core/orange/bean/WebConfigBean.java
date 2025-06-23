package com.alimm.tanx.core.orange.bean;

import com.alimm.tanx.core.ad.bean.BaseBean;

public class WebConfigBean extends BaseBean {
    public boolean closeInitWebPreload = false;
    public boolean closeNextWebPreload = false;
    public String key;
    public long sdkInitWebViewPreloadDelayed = 0;

    public String toString() {
        return "WebConfigBean{key='" + this.key + '\'' + ", closeInitWebPreload=" + this.closeInitWebPreload + ", closeNextWebPreload=" + this.closeNextWebPreload + ", sdkInitWebViewPreloadDelayed=" + this.sdkInitWebViewPreloadDelayed + "} ";
    }
}
