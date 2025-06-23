package com.baidu.ar;

import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.lang.reflect.Method;

/* loaded from: classes7.dex */
public class ch {
    final Method mo;
    final Class<?> mp;
    String mq;

    private synchronized void cr() {
        if (this.mq == null) {
            StringBuilder sb = new StringBuilder(64);
            sb.append(this.mo.getDeclaringClass().getName());
            sb.append('#');
            sb.append(this.mo.getName());
            sb.append(HexStringBuilder.COMMENT_BEGIN_CHAR);
            sb.append(this.mp.getName());
            this.mq = sb.toString();
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ch)) {
            return false;
        }
        cr();
        ch chVar = (ch) obj;
        chVar.cr();
        return this.mq.equals(chVar.mq);
    }

    public int hashCode() {
        return this.mo.hashCode();
    }
}
