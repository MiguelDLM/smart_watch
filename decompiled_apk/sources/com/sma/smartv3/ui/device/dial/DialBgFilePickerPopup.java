package com.sma.smartv3.ui.device.dial;

import android.app.Activity;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter;
import com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder;
import com.blankj.utilcode.util.FileUtils;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.ui.device.dial.DialBgFilePickerPopup;
import java.io.File;
import java.util.List;

/* loaded from: classes12.dex */
public final class DialBgFilePickerPopup extends OOOI.oxoX {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Button f22158II0XooXoX;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final RecyclerView f22159xxIXOIIO;

    /* renamed from: com.sma.smartv3.ui.device.dial.DialBgFilePickerPopup$1, reason: invalid class name */
    /* loaded from: classes12.dex */
    public static final class AnonymousClass1 extends CommonAdapter<String> {
        final /* synthetic */ OxI $callback;
        final /* synthetic */ DialBgFilePickerPopup this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Activity activity, List<String> list, OxI oxI, DialBgFilePickerPopup dialBgFilePickerPopup) {
            super(activity, R.layout.item_dial_bg_file_picker, list);
            this.$callback = oxI;
            this.this$0 = dialBgFilePickerPopup;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void convert$lambda$0(OxI callback, int i, DialBgFilePickerPopup this$0, View view) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(callback, "$callback");
            kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
            callback.oIX0oI(i);
            this$0.dismiss();
        }

        @Override // com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter
        public void convert(@OXOo.OOXIXo ViewHolder holder, @OXOo.OOXIXo String path, final int i) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(holder, "holder");
            kotlin.jvm.internal.IIX0o.x0xO0oo(path, "path");
            ImageView imageView = (ImageView) holder.getView(R.id.iv);
            if (FileUtils.isFileExists(path)) {
                imageView.setImageURI(Uri.fromFile(new File(path)));
            }
            ImageView imageView2 = (ImageView) holder.getView(R.id.iv);
            final OxI oxI = this.$callback;
            final DialBgFilePickerPopup dialBgFilePickerPopup = this.this$0;
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.dial.O0xOxO
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialBgFilePickerPopup.AnonymousClass1.convert$lambda$0(OxI.this, i, dialBgFilePickerPopup, view);
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialBgFilePickerPopup(@OXOo.OOXIXo Activity activity, @OXOo.OOXIXo List<String> paths, @OXOo.OOXIXo OxI callback) {
        super(activity);
        kotlin.jvm.internal.IIX0o.x0xO0oo(activity, "activity");
        kotlin.jvm.internal.IIX0o.x0xO0oo(paths, "paths");
        kotlin.jvm.internal.IIX0o.x0xO0oo(callback, "callback");
        LayoutInflater.from(Oxx0IOOO()).inflate(R.layout.pop_dial_bg_file_picker, xxIXOIIO());
        View findViewById = xxIXOIIO().findViewById(R.id.btn_bottom);
        kotlin.jvm.internal.IIX0o.oO(findViewById, "findViewById(...)");
        this.f22158II0XooXoX = (Button) findViewById;
        View findViewById2 = xxIXOIIO().findViewById(R.id.rv);
        kotlin.jvm.internal.IIX0o.oO(findViewById2, "findViewById(...)");
        RecyclerView recyclerView = (RecyclerView) findViewById2;
        this.f22159xxIXOIIO = recyclerView;
        recyclerView.setLayoutManager(new GridLayoutManager(Oxx0IOOO(), 2));
        recyclerView.setAdapter(new AnonymousClass1(activity, paths, callback, this));
    }

    @OXOo.OOXIXo
    public final Button O0xOxO() {
        return this.f22158II0XooXoX;
    }

    @OXOo.OOXIXo
    public final RecyclerView X0IIOO() {
        return this.f22159xxIXOIIO;
    }
}
