package com.baidu.navisdk.ui.routeguide.module.diyspeak;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class a extends Dialog implements View.OnClickListener, DialogInterface.OnDismissListener {

    /* renamed from: a, reason: collision with root package name */
    private TextView f8990a;
    private ImageView b;
    private String c;
    private com.baidu.navisdk.util.worker.loop.a d;
    private Runnable e;

    /* renamed from: com.baidu.navisdk.ui.routeguide.module.diyspeak.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC0467a implements Runnable {
        public RunnableC0467a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.dismiss();
        }
    }

    public a(Activity activity) {
        super(activity, R.style.AnchorTipsDialog);
        this.c = null;
        this.d = new com.baidu.navisdk.util.worker.loop.a();
        this.e = new RunnableC0467a();
        View inflate = JarUtils.inflate(activity, R.layout.nsdk_layout_anchor_tips_dialog, null);
        setContentView(inflate);
        this.f8990a = (TextView) findViewById(R.id.anchor_tips_tx);
        inflate.setOnClickListener(this);
        this.b = (ImageView) findViewById(R.id.anchor_arrow_iv);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        window.setBackgroundDrawableResource(android.R.color.transparent);
        attributes.width = -2;
        attributes.height = -2;
        attributes.y = com.baidu.navisdk.ui.util.b.d(R.dimen.navi_dimens_99dp);
        attributes.x = com.baidu.navisdk.ui.util.b.d(R.dimen.navi_dimens_15dp);
        window.setAttributes(attributes);
        window.setGravity(51);
    }

    public void a(String str) {
        this.c = str;
        this.f8990a.setText(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        dismiss();
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.d.removeCallbacksAndMessages(null);
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        this.d.postDelayed(this.e, 5000L);
    }

    public void a(View view) {
        int left = view.getLeft() + ((view.getRight() - view.getLeft()) / 2);
        int d = com.baidu.navisdk.ui.util.b.d(R.dimen.navi_dimens_21dp);
        com.baidu.navisdk.pronavi.util.a aVar = com.baidu.navisdk.pronavi.util.a.h;
        if (left > aVar.e() / 2) {
            getWindow().setGravity(53);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.b.getLayoutParams();
            layoutParams.gravity = 5;
            layoutParams.rightMargin = (aVar.e() - left) - d;
            return;
        }
        ((LinearLayout.LayoutParams) this.b.getLayoutParams()).leftMargin = left - d;
    }
}
