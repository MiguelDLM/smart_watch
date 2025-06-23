package com.baidu.navisdk.module.ar;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.widget.BNNaviDeclareDialog;

/* loaded from: classes7.dex */
public final class a extends BNNaviDeclareDialog {
    public a(@OOXIXo Context context) {
        super(context);
    }

    @Override // com.baidu.navisdk.ui.widget.BNNaviDeclareDialog
    @oOoXoXO
    public View onCreateView(@oOoXoXO Context context, @oOoXoXO ViewGroup viewGroup) {
        LayoutInflater.from(context).inflate(R.layout.bnav_ar_declare_detail, viewGroup, true);
        return null;
    }
}
