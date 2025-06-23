package com.baidu.navisdk.ui.widget.debug;

/* loaded from: classes8.dex */
public class DebugModeMessageSerBean implements Cloneable {
    public boolean flag = false;
    public String key;
    public int type;
    public String value;

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public DebugModeMessageSerBean m97clone() {
        try {
            return (DebugModeMessageSerBean) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
