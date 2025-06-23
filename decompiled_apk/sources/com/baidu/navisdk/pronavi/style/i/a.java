package com.baidu.navisdk.pronavi.style.i;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.navisdk.pronavi.style.d;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes7.dex */
public interface a {
    @OOXIXo
    String a();

    void a(@oOoXoXO View view);

    void a(@oOoXoXO ImageView imageView);

    void a(@oOoXoXO TextView textView);

    void a(@oOoXoXO String str);

    <V extends View> void a(@OOXIXo String str, @oOoXoXO V v);

    void a(@oOoXoXO String str, @oOoXoXO HashMap<String, ? super d> hashMap);

    void b();

    void b(@oOoXoXO View view);

    void b(@oOoXoXO ImageView imageView);

    void b(@oOoXoXO String str);

    <V extends View> void b(@OOXIXo String str, @oOoXoXO V v);

    @oOoXoXO
    String c(@oOoXoXO String str);

    void c();

    @OOXIXo
    List<Integer> d();

    void onDestroy();
}
