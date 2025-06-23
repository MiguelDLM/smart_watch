package com.baidu.navisdk.pronavi.hd.normal.i;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import android.os.Message;
import android.view.View;
import androidx.lifecycle.LiveData;
import com.baidu.navisdk.framework.interfaces.pronavi.hd.f;
import com.baidu.navisdk.pronavi.hd.normal.data.c;
import kotlin.Pair;

/* loaded from: classes7.dex */
public interface a extends com.baidu.navisdk.pronavi.logic.i.a {
    @oOoXoXO
    View a(@OOXIXo Context context, int i);

    @OOXIXo
    f a();

    @oOoXoXO
    String a(@oOoXoXO String str);

    void a(int i);

    void a(int i, int i2, boolean z);

    void a(int i, boolean z);

    void a(@OOXIXo Message message);

    void a(@OOXIXo String str, boolean z);

    void a(boolean z);

    void a(boolean z, int i, boolean z2);

    @OOXIXo
    LiveData<Boolean> b();

    void b(int i);

    void c(int i);

    boolean c();

    int d();

    @OOXIXo
    Pair<Integer, Integer> d(int i);

    boolean e();

    @OOXIXo
    LiveData<c> f();

    @OOXIXo
    Pair<Integer, Integer> f(int i);

    @OOXIXo
    Pair<Integer, Integer> g(int i);

    boolean g();

    int h();

    void i();

    void setShowRect(int i, boolean z);
}
