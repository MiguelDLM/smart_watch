package com.baidu.navisdk.ugc.pictures.show;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.imageloader.ImageLoader;
import com.baidu.navisdk.ui.util.j;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.g;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes8.dex */
public class UgcInputShowPicLayout extends ShowPicLayout {
    private ArrayList<String> d;
    private a e;

    /* loaded from: classes8.dex */
    public interface a {
        void a();

        void a(int i, ArrayList<String> arrayList);
    }

    public UgcInputShowPicLayout(Context context) {
        this(context, null);
    }

    public void a(ArrayList<String> arrayList) {
        g gVar = g.UGC;
        if (gVar.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("addImage(), picPathList = ");
            sb.append(arrayList == null ? "null" : Arrays.toString(arrayList.toArray()));
            gVar.e("UgcInputShowPicLayout", sb.toString());
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            int size = this.d.size();
            int size2 = arrayList.size();
            int i = 3 - size;
            for (int i2 = 0; i2 < i && i2 < size2; i2++) {
                String str = arrayList.get(i2);
                this.d.add(str);
                ImageView[] imageViewArr = this.c;
                ImageView imageView = imageViewArr[size];
                if (imageView == null) {
                    imageViewArr[size] = a(size);
                } else {
                    j.b(imageView);
                }
                a(str, this.c[size]);
                size = this.d.size();
            }
            b();
            return;
        }
        b();
    }

    public void b() {
        int size = this.d.size();
        g gVar = g.UGC;
        if (gVar.e()) {
            gVar.g("UgcInputShowPicLayout", "addPhotographIcon: " + size);
        }
        if (size >= 3) {
            return;
        }
        ImageView[] imageViewArr = this.c;
        ImageView imageView = imageViewArr[size];
        if (imageView == null) {
            imageViewArr[size] = a(size);
        } else {
            j.b(imageView);
        }
        ImageView.ScaleType scaleType = this.c[size].getScaleType();
        ImageView.ScaleType scaleType2 = ImageView.ScaleType.CENTER;
        if (scaleType != scaleType2) {
            this.c[size].setScaleType(scaleType2);
        }
        this.c[size].setImageResource(R.drawable.nsdk_ugc_sub_info_fill_photo_icon);
        this.c[size].setBackgroundResource(R.drawable.nsdk_truck_ugc_report_input_camer_bg);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int intValue = ((Integer) view.getTag(R.id.view_tag_first)).intValue();
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e("UgcInputShowPicLayout", "onClick index: " + intValue);
        }
        if (this.e != null) {
            if (intValue < this.d.size()) {
                ArrayList<String> arrayList = new ArrayList<>(this.d.size());
                arrayList.addAll(this.d);
                this.e.a(intValue, arrayList);
            } else if (intValue == this.d.size()) {
                this.e.a();
            }
        }
    }

    public void setListener(a aVar) {
        this.e = aVar;
    }

    public UgcInputShowPicLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public UgcInputShowPicLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = new ArrayList<>(3);
    }

    private int b(String str) {
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e("UgcInputShowPicLayout", "findIndex path: " + str + ", picList:" + Arrays.toString(this.d.toArray()));
        }
        if (TextUtils.isEmpty(str) || this.d.isEmpty()) {
            return -1;
        }
        return this.d.indexOf(str);
    }

    public void a(String str) {
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e("UgcInputShowPicLayout", "addImage path: " + str + ", picList:" + Arrays.toString(this.d.toArray()));
        }
        int size = this.d.size();
        if (size >= 3) {
            return;
        }
        this.d.add(str);
        ImageView[] imageViewArr = this.c;
        ImageView imageView = imageViewArr[size];
        if (imageView == null) {
            imageViewArr[size] = a(size);
        } else {
            j.b(imageView);
        }
        a(str, this.c[size]);
        b();
    }

    public void a(String str, int i) {
        ImageView imageView;
        int b = b(str);
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e("UgcInputShowPicLayout", "deleteImage(), path = " + str + " index = " + i + ", pathIndex:" + b);
        }
        if (b >= 3 || b < 0 || (imageView = this.c[b]) == null) {
            return;
        }
        j.b(imageView);
        this.d.remove(b);
        int size = this.d.size();
        while (b < size) {
            ImageView imageView2 = this.c[b];
            if (imageView2 != null) {
                j.b(imageView2);
                a(this.d.get(b), imageView2);
            }
            b++;
        }
        b();
        int size2 = this.d.size();
        while (true) {
            size2++;
            ImageView[] imageViewArr = this.c;
            if (size2 >= imageViewArr.length) {
                return;
            } else {
                j.b(imageViewArr[size2]);
            }
        }
    }

    private void a(String str, ImageView imageView) {
        if (TextUtils.isEmpty(str) || imageView == null) {
            return;
        }
        a(imageView);
        if (com.baidu.navisdk.j.d()) {
            ImageLoader.with(getContext()).load(str).rectRoundCorner(ScreenUtil.getInstance().dip2px(4)).into(imageView);
        } else {
            imageView.setImageURI(Uri.fromFile(new File(str)));
        }
    }

    private void a(ImageView imageView) {
        if (imageView == null) {
            return;
        }
        ImageView.ScaleType scaleType = imageView.getScaleType();
        ImageView.ScaleType scaleType2 = ImageView.ScaleType.FIT_XY;
        if (scaleType != scaleType2) {
            imageView.setScaleType(scaleType2);
        }
    }

    @Override // com.baidu.navisdk.ugc.pictures.show.ShowPicLayout
    public void a() {
        super.a();
        this.e = null;
        this.d.clear();
        this.d = null;
    }
}
