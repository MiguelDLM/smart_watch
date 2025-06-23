package com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.i;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.view.View;

/* loaded from: classes7.dex */
public interface a {

    /* renamed from: com.baidu.navisdk.pronavi.ui.buttoncollect.btnlogic.i.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0342a {
        public static /* synthetic */ boolean a(a aVar, com.baidu.navisdk.pronavi.ui.base.b bVar, View view, Object obj, int i, Object obj2) {
            if (obj2 == null) {
                if ((i & 4) != 0) {
                    obj = null;
                }
                return aVar.a(bVar, view, obj);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onClickAction");
        }
    }

    boolean a(@OOXIXo com.baidu.navisdk.pronavi.ui.base.b bVar, @OOXIXo View view, @oOoXoXO Object obj);
}
