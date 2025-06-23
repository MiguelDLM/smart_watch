package com.sma.smartv3.ui.device.item;

import OXOo.OOXIXo;
import android.widget.ImageView;
import android.widget.TextView;
import com.sma.smartv3.ble.ProductManager;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes12.dex */
public final class InfoItem$switchStatusRunnable$2 extends Lambda implements Oox.oIX0oI<Runnable> {
    final /* synthetic */ InfoItem this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InfoItem$switchStatusRunnable$2(InfoItem infoItem) {
        super(0);
        this.this$0 = infoItem;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(InfoItem this$0) {
        IIX0o.x0xO0oo(this$0, "this$0");
        ImageView imageView = this$0.ivConnection;
        TextView textView = null;
        if (imageView == null) {
            IIX0o.XOxIOxOx("ivConnection");
            imageView = null;
        }
        imageView.setEnabled(false);
        ImageView imageView2 = this$0.ivPower;
        if (imageView2 == null) {
            IIX0o.XOxIOxOx("ivPower");
            imageView2 = null;
        }
        imageView2.setVisibility(8);
        if (ProductManager.f20544oIX0oI.X0IOOI()) {
            TextView textView2 = this$0.tvPower;
            if (textView2 == null) {
                IIX0o.XOxIOxOx("tvPower");
            } else {
                textView = textView2;
            }
            textView.setVisibility(8);
        }
    }

    @Override // Oox.oIX0oI
    @OOXIXo
    public final Runnable invoke() {
        final InfoItem infoItem = this.this$0;
        return new Runnable() { // from class: com.sma.smartv3.ui.device.item.I0Io
            @Override // java.lang.Runnable
            public final void run() {
                InfoItem$switchStatusRunnable$2.invoke$lambda$0(InfoItem.this);
            }
        };
    }
}
