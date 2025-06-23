package com.alimm.tanx.core.ut.core;

import com.alimm.tanx.core.ut.bean.UtItemBean;
import java.util.List;

/* loaded from: classes.dex */
public interface IUserReport {
    public static final String TAG = "UserReport :";

    void send(UtItemBean utItemBean);

    void send(List<UtItemBean> list);
}
