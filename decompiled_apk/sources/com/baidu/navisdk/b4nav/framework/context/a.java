package com.baidu.navisdk.b4nav.framework.context;

import OXOo.OOXIXo;
import androidx.lifecycle.LifecycleOwner;
import com.baidu.baidumaps.common.util.ScreenUtils;
import com.baidu.navisdk.framework.interfaces.c;
import com.baidu.navisdk.j;
import com.baidu.navisdk.logicframe.b;
import com.baidu.navisdk.util.common.ScreenUtil;
import java.util.Arrays;
import kotlin.jvm.internal.IIX0o;
import kotlin.text.StringsKt__StringsKt;
import o0oIxXOx.IXxxXO;

/* loaded from: classes7.dex */
public class a extends b {
    private final int g;
    private final int h;

    @OOXIXo
    private final LifecycleOwner i;

    @Override // com.baidu.navisdk.context.d, com.baidu.navisdk.context.a
    public void a(@OOXIXo String... describes) {
        boolean z;
        IIX0o.x0xO0oo(describes, "describes");
        if (describes.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            if (!StringsKt__StringsKt.o00xOoIO(describes[0], this.e + IXxxXO.f31153oxoX, false, 2, null)) {
                int length = describes.length;
                int i = length + 1;
                String[] strArr = new String[i];
                strArr[0] = this.e;
                System.arraycopy(describes, 0, strArr, 1, length);
                super.a((String[]) Arrays.copyOf(strArr, i));
                return;
            }
        }
        super.a((String[]) Arrays.copyOf(describes, describes.length));
    }

    @Override // com.baidu.navisdk.context.d, com.baidu.navisdk.context.a
    public void b(@OOXIXo String... describes) {
        boolean z;
        IIX0o.x0xO0oo(describes, "describes");
        if (describes.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            if (!StringsKt__StringsKt.o00xOoIO(describes[0], this.e + IXxxXO.f31153oxoX, false, 2, null)) {
                int length = describes.length;
                int i = length + 1;
                String[] strArr = new String[i];
                strArr[0] = this.e;
                System.arraycopy(describes, 0, strArr, 1, length);
                super.b((String[]) Arrays.copyOf(strArr, i));
                return;
            }
        }
        super.b((String[]) Arrays.copyOf(describes, describes.length));
    }

    @OOXIXo
    public final LifecycleOwner k() {
        return this.i;
    }

    public final int l() {
        if (j.d()) {
            return ScreenUtils.getViewScreenHeight(e());
        }
        ScreenUtil screenUtil = ScreenUtil.getInstance();
        IIX0o.oO(screenUtil, "ScreenUtil.getInstance()");
        return screenUtil.getHeightPixels();
    }

    public final int m() {
        if (j.d()) {
            return ScreenUtils.getScreenWidth(e());
        }
        ScreenUtil screenUtil = ScreenUtil.getInstance();
        IIX0o.oO(screenUtil, "ScreenUtil.getInstance()");
        return screenUtil.getWidthPixels();
    }

    public final int n() {
        return this.h;
    }

    public final int o() {
        return this.g;
    }

    public final boolean p() {
        com.baidu.navisdk.framework.interfaces.pronavi.b h = c.p().h();
        if (h != null && h.x0()) {
            return true;
        }
        return false;
    }
}
