package com.baidu.navisdk.util.drivertool.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class a extends Dialog {

    /* renamed from: a, reason: collision with root package name */
    private ImageView f9286a;

    public a(Context context) {
        super(context, R.style.BNDialog);
        this.f9286a = null;
        View inflate = JarUtils.inflate(context, R.layout.nsdk_layout_driving_tool_image_show, null);
        setContentView(inflate);
        this.f9286a = (ImageView) inflate.findViewById(R.id.image_show);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = ScreenUtil.getInstance().getWidthPixels() / 2;
        attributes.height = ScreenUtil.getInstance().getHeightPixels() / 2;
        window.setAttributes(attributes);
        window.setGravity(17);
    }

    public void a(Bitmap bitmap) {
        ImageView imageView = this.f9286a;
        if (imageView != null) {
            imageView.setImageBitmap(bitmap);
        }
    }
}
