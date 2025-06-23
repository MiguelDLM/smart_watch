package com.baidu.navisdk.ui.util;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;

/* loaded from: classes8.dex */
public class c extends Dialog {

    /* renamed from: a, reason: collision with root package name */
    private TextView f9197a;
    private Context b;
    private Handler c;

    /* loaded from: classes8.dex */
    public class a extends com.baidu.navisdk.util.worker.loop.a {
        public a(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.util.worker.loop.a
        public void onMessage(Message message) {
            try {
                int i = message.what;
                if (i != 1) {
                    if (i == 2) {
                        LogUtil.e(e.f9199a, "showToastMessage START_MSG");
                        String str = (String) message.obj;
                        int i2 = message.arg2;
                        c.this.f9197a.setText(str);
                        if ((c.this.b instanceof Activity) && !((Activity) c.this.b).isFinishing()) {
                            c.this.show();
                            if (c.this.c != null) {
                                c.this.c.sendEmptyMessageDelayed(1, i2);
                            }
                        }
                    }
                } else {
                    LogUtil.e(e.f9199a, "showToastMessage STOP_MSG");
                    c.this.dismiss();
                }
            } catch (Exception unused) {
            }
        }
    }

    public c(Context context, int i, String str) {
        super(context, i);
        this.f9197a = null;
        this.c = new a("TD");
        this.b = context;
        context.getResources().newTheme().applyStyle(R.style.TiptoolDialog, true);
        requestWindowFeature(1);
        setContentView(LayoutInflater.from(context).inflate(R.layout.nsdk_layout_tiptool_dialog, (ViewGroup) null));
        this.f9197a = (TextView) findViewById(R.id.toast_tx);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        window.setBackgroundDrawableResource(android.R.color.transparent);
        int length = str.length();
        LogUtil.e(e.f9199a, "dialog lenght is " + length);
        attributes.width = a(length, str);
        attributes.height = ScreenUtil.getInstance().dip2px(44);
        attributes.y = ScreenUtil.getInstance().dip2px(64);
        window.setAttributes(attributes);
        window.setGravity(80);
    }

    private int a(int i, String str) {
        int a2 = a(str);
        return ScreenUtil.getInstance().dip2px((((i - 1) - a2) * 14) + 38 + (a2 * 8));
    }

    private void b() {
        Handler handler = this.c;
        if (handler != null) {
            handler.removeMessages(1);
        }
    }

    private int a(String str) {
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if ((charAt >= '0' && charAt <= '9') || ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z'))) {
                i++;
            }
        }
        return i;
    }

    public void a() {
        Handler handler = this.c;
        if (handler != null) {
            handler.removeMessages(1);
            this.c.removeMessages(2);
        }
        this.c = null;
    }

    public void a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        b();
        Message obtainMessage = this.c.obtainMessage();
        obtainMessage.what = 2;
        obtainMessage.arg2 = i;
        obtainMessage.obj = str;
        this.c.sendMessage(obtainMessage);
    }
}
