package com.sma.smartv3.ui.device.dial;

import android.R;
import android.app.Activity;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter;
import com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder;
import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.ImageUtils;
import com.blankj.utilcode.util.LogUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.sma.smartv3.model.WatchFaceInfo;
import com.sma.smartv3.ui.device.dial.DialPickerPopup;
import com.szabh.smable3.component.BleCache;
import java.io.File;
import java.util.List;

@kotlin.jvm.internal.XX({"SMAP\nDialPickerPopup.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DialPickerPopup.kt\ncom/sma/smartv3/ui/device/dial/DialPickerPopup\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,110:1\n90#2:111\n90#2:112\n1#3:113\n*S KotlinDebug\n*F\n+ 1 DialPickerPopup.kt\ncom/sma/smartv3/ui/device/dial/DialPickerPopup\n*L\n47#1:111\n49#1:112\n*E\n"})
/* loaded from: classes12.dex */
public final class DialPickerPopup extends OOOI.oxoX {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public final RecyclerView f22171II0XooXoX;

    @kotlin.jvm.internal.XX({"SMAP\nDialPickerPopup.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DialPickerPopup.kt\ncom/sma/smartv3/ui/device/dial/DialPickerPopup$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,110:1\n1#2:111\n*E\n"})
    /* renamed from: com.sma.smartv3.ui.device.dial.DialPickerPopup$1, reason: invalid class name */
    /* loaded from: classes12.dex */
    public static final class AnonymousClass1 extends CommonAdapter<Integer> {
        final /* synthetic */ xIXX $callback;
        final /* synthetic */ WatchFaceInfo[] $list;
        final /* synthetic */ DialPickerPopup this$0;

        /* renamed from: com.sma.smartv3.ui.device.dial.DialPickerPopup$1$oIX0oI */
        /* loaded from: classes12.dex */
        public static final class oIX0oI extends SimpleTarget<Bitmap> {

            /* renamed from: XO, reason: collision with root package name */
            public final /* synthetic */ ImageView f22172XO;

            public oIX0oI(ImageView imageView) {
                this.f22172XO = imageView;
            }

            @Override // com.bumptech.glide.request.target.Target
            public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
                onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
            }

            public void onResourceReady(@OXOo.OOXIXo Bitmap resource, @OXOo.oOoXoXO Transition<? super Bitmap> transition) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(resource, "resource");
                this.f22172XO.setImageBitmap(resource);
                this.f22172XO.setBackgroundResource(R.color.transparent);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Activity activity, List<Integer> list, DialPickerPopup dialPickerPopup, WatchFaceInfo[] watchFaceInfoArr, xIXX xixx) {
            super(activity, com.sma.smartv3.co_fit.R.layout.item_dial_picker, list);
            this.this$0 = dialPickerPopup;
            this.$list = watchFaceInfoArr;
            this.$callback = xixx;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void convert$lambda$1(xIXX callback, int i, DialPickerPopup this$0, View view) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(callback, "$callback");
            kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
            callback.oIX0oI(i);
            this$0.dismiss();
        }

        @Override // com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter
        public /* bridge */ /* synthetic */ void convert(ViewHolder viewHolder, Integer num, int i) {
            convert(viewHolder, num.intValue(), i);
        }

        public void convert(@OXOo.OOXIXo ViewHolder holder, int i, final int i2) {
            WatchFaceInfo watchFaceInfo;
            kotlin.jvm.internal.IIX0o.x0xO0oo(holder, "holder");
            ImageView imageView = (ImageView) holder.getView(com.sma.smartv3.co_fit.R.id.iv);
            if (i == 0) {
                DialPickerPopup dialPickerPopup = this.this$0;
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(imageView);
                WatchFaceInfo[] watchFaceInfoArr = this.$list;
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(watchFaceInfoArr);
                dialPickerPopup.X0IIOO(imageView, watchFaceInfoArr[0].getPreviewPath());
            } else if (i >= 1000000) {
                File IoOoX2 = com.sma.smartv3.initializer.IXxxXO.IoOoX(X00IoxXI.oIX0oI.f3233oIX0oI);
                StringBuilder sb = new StringBuilder();
                BleCache bleCache = BleCache.INSTANCE;
                sb.append(bleCache.getMPrototype());
                sb.append('_');
                sb.append(bleCache.getMBleName());
                sb.append('_');
                sb.append(i);
                sb.append(".png");
                File file = new File(IoOoX2, sb.toString());
                if (FileUtils.isFileExists(file)) {
                    imageView.setImageURI(Uri.fromFile(file));
                } else {
                    DialPickerPopup dialPickerPopup2 = this.this$0;
                    kotlin.jvm.internal.IIX0o.ooOOo0oXI(imageView);
                    WatchFaceInfo[] watchFaceInfoArr2 = this.$list;
                    kotlin.jvm.internal.IIX0o.ooOOo0oXI(watchFaceInfoArr2);
                    dialPickerPopup2.X0IIOO(imageView, watchFaceInfoArr2[0].getPreviewPath());
                }
            } else {
                WatchFaceInfo[] watchFaceInfoArr3 = this.$list;
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(watchFaceInfoArr3);
                int length = watchFaceInfoArr3.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        watchFaceInfo = null;
                        break;
                    }
                    watchFaceInfo = watchFaceInfoArr3[i3];
                    if (watchFaceInfo.getId() == i) {
                        break;
                    } else {
                        i3++;
                    }
                }
                LogUtils.d(watchFaceInfo != null ? watchFaceInfo.getPreviewPath() : null);
                imageView.setBackgroundResource(com.sma.smartv3.co_fit.R.color.line_color);
                Glide.with(this.this$0.Oxx0IOOO()).asBitmap().load(watchFaceInfo != null ? watchFaceInfo.getPreviewPath() : null).into((RequestBuilder<Bitmap>) new oIX0oI(imageView));
            }
            ImageView imageView2 = (ImageView) holder.getView(com.sma.smartv3.co_fit.R.id.iv);
            final xIXX xixx = this.$callback;
            final DialPickerPopup dialPickerPopup3 = this.this$0;
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.dial.xOOxIO
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialPickerPopup.AnonymousClass1.convert$lambda$1(xIXX.this, i2, dialPickerPopup3, view);
                }
            });
        }
    }

    /* loaded from: classes12.dex */
    public static final class oIX0oI extends SimpleTarget<Bitmap> {

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ DialPickerPopup f22173Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ ImageView f22174XO;

        public oIX0oI(ImageView imageView, DialPickerPopup dialPickerPopup) {
            this.f22174XO = imageView;
            this.f22173Oo = dialPickerPopup;
        }

        @Override // com.bumptech.glide.request.target.Target
        public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
            onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
        }

        public void onResourceReady(@OXOo.OOXIXo Bitmap resource, @OXOo.oOoXoXO Transition<? super Bitmap> transition) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(resource, "resource");
            this.f22174XO.setImageBitmap(ImageUtils.toGray(resource));
            this.f22174XO.setImageTintList(this.f22173Oo.Oxx0IOOO().getResources().getColorStateList(R.color.darker_gray));
            this.f22174XO.setBackgroundResource(R.color.transparent);
        }
    }

    public /* synthetic */ DialPickerPopup(Activity activity, List list, int i, xIXX xixx, int i2, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this(activity, list, (i2 & 4) != 0 ? 0 : i, xixx);
    }

    @OXOo.OOXIXo
    public final RecyclerView O0xOxO() {
        return this.f22171II0XooXoX;
    }

    public final void X0IIOO(@OXOo.OOXIXo ImageView imageView, @OXOo.OOXIXo String url) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(imageView, "imageView");
        kotlin.jvm.internal.IIX0o.x0xO0oo(url, "url");
        imageView.setBackgroundResource(com.sma.smartv3.co_fit.R.color.line_color);
        Glide.with(Oxx0IOOO()).asBitmap().load(url).into((RequestBuilder<Bitmap>) new oIX0oI(imageView, this));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Removed duplicated region for block: B:11:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x00c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public DialPickerPopup(@OXOo.OOXIXo android.app.Activity r8, @OXOo.OOXIXo java.util.List<java.lang.Integer> r9, int r10, @OXOo.OOXIXo com.sma.smartv3.ui.device.dial.xIXX r11) {
        /*
            r7 = this;
            java.lang.String r0 = "activity"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r8, r0)
            java.lang.String r0 = "ids"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r9, r0)
            java.lang.String r0 = "callback"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r11, r0)
            r7.<init>(r8)
            r0 = 95
            if (r10 != 0) goto L47
            com.sma.smartv3.util.Xo0 r10 = com.sma.smartv3.util.Xo0.f24349oIX0oI
            com.blankj.utilcode.util.SPUtils r10 = r10.I0Io()
            com.google.gson.Gson r1 = new com.google.gson.Gson
            r1.<init>()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "WATCHFACE_LIST"
            r2.append(r3)
            r2.append(r0)
            java.lang.Class<com.sma.smartv3.model.WatchFaceInfo[]> r0 = com.sma.smartv3.model.WatchFaceInfo[].class
            java.lang.String r3 = r0.getName()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r10 = r10.getString(r2)
            java.lang.Object r10 = r1.fromJson(r10, r0)
            com.sma.smartv3.model.WatchFaceInfo[] r10 = (com.sma.smartv3.model.WatchFaceInfo[]) r10
        L45:
            r4 = r10
            goto L92
        L47:
            com.sma.smartv3.util.Xo0 r1 = com.sma.smartv3.util.Xo0.f24349oIX0oI
            com.blankj.utilcode.util.SPUtils r1 = r1.I0Io()
            com.google.gson.Gson r2 = new com.google.gson.Gson
            r2.<init>()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "WATCHFACE_CATEGORY"
            r3.append(r4)
            r3.append(r0)
            java.lang.Class<com.sma.smartv3.model.WatchFaceCategory[]> r0 = com.sma.smartv3.model.WatchFaceCategory[].class
            java.lang.String r4 = r0.getName()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.lang.String r1 = r1.getString(r3)
            java.lang.Object r0 = r2.fromJson(r1, r0)
            com.sma.smartv3.model.WatchFaceCategory[] r0 = (com.sma.smartv3.model.WatchFaceCategory[]) r0
            r1 = 0
            if (r0 == 0) goto L91
            int r2 = r0.length
            r3 = 0
        L7b:
            if (r3 >= r2) goto L89
            r4 = r0[r3]
            int r5 = r4.getType()
            if (r5 != r10) goto L86
            goto L8a
        L86:
            int r3 = r3 + 1
            goto L7b
        L89:
            r4 = r1
        L8a:
            if (r4 == 0) goto L91
            com.sma.smartv3.model.WatchFaceInfo[] r10 = r4.getList()
            goto L45
        L91:
            r4 = r1
        L92:
            android.app.Activity r10 = r7.Oxx0IOOO()
            android.view.LayoutInflater r10 = android.view.LayoutInflater.from(r10)
            r0 = 2131560134(0x7f0d06c6, float:1.8745632E38)
            android.widget.FrameLayout r1 = r7.xxIXOIIO()
            r10.inflate(r0, r1)
            android.widget.FrameLayout r10 = r7.xxIXOIIO()
            r0 = 2131367179(0x7f0a150b, float:1.8354272E38)
            android.view.View r10 = r10.findViewById(r0)
            java.lang.String r0 = "findViewById(...)"
            kotlin.jvm.internal.IIX0o.oO(r10, r0)
            androidx.recyclerview.widget.RecyclerView r10 = (androidx.recyclerview.widget.RecyclerView) r10
            r7.f22171II0XooXoX = r10
            androidx.recyclerview.widget.GridLayoutManager r0 = new androidx.recyclerview.widget.GridLayoutManager
            android.app.Activity r1 = r7.Oxx0IOOO()
            int r2 = r9.size()
            r3 = 2
            if (r2 <= r3) goto Lc7
            r2 = 3
            goto Lcb
        Lc7:
            int r2 = r9.size()
        Lcb:
            r0.<init>(r1, r2)
            r10.setLayoutManager(r0)
            com.sma.smartv3.ui.device.dial.DialPickerPopup$1 r6 = new com.sma.smartv3.ui.device.dial.DialPickerPopup$1
            r0 = r6
            r1 = r8
            r2 = r9
            r3 = r7
            r5 = r11
            r0.<init>(r1, r2, r3, r4, r5)
            r10.setAdapter(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.device.dial.DialPickerPopup.<init>(android.app.Activity, java.util.List, int, com.sma.smartv3.ui.device.dial.xIXX):void");
    }
}
