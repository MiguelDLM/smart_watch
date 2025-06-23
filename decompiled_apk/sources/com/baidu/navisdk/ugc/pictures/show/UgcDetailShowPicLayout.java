package com.baidu.navisdk.ugc.pictures.show;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.imageloader.ImageLoader;
import com.baidu.navisdk.ui.util.j;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.g;
import java.util.Arrays;

/* loaded from: classes8.dex */
public class UgcDetailShowPicLayout extends ShowPicLayout {
    private String[] d;
    private a e;

    /* loaded from: classes8.dex */
    public interface a {
        void a(int i, String[] strArr);
    }

    public UgcDetailShowPicLayout(Context context) {
        this(context, null);
    }

    public void a(String[] strArr) {
        g gVar = g.UGC;
        if (gVar.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("showImages(), picPathList = ");
            sb.append(strArr == null ? "null" : Arrays.toString(strArr));
            gVar.e("UgcDetailShowPicLayout", sb.toString());
        }
        if (strArr == null || strArr.length == 0) {
            return;
        }
        this.d = strArr;
        for (int i = 0; i < strArr.length && i < 3; i++) {
            ImageView[] imageViewArr = this.c;
            ImageView imageView = imageViewArr[i];
            if (imageView == null) {
                imageViewArr[i] = a(i);
            } else {
                j.b(imageView);
            }
            ImageLoader.with(getContext()).load(strArr[i]).rectRoundCorner(ScreenUtil.getInstance().dip2px(4)).placeHolder(R.color.ugc_place_holder).into(this.c[i]);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String[] strArr;
        int intValue = ((Integer) view.getTag(R.id.view_tag_first)).intValue();
        g gVar = g.UGC;
        if (gVar.e()) {
            gVar.g("UgcDetailShowPicLayout", "onClick index: " + intValue);
        }
        a aVar = this.e;
        if (aVar != null && (strArr = this.d) != null && intValue < strArr.length) {
            aVar.a(intValue, strArr);
        }
    }

    public void setListener(a aVar) {
        this.e = aVar;
    }

    public UgcDetailShowPicLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public UgcDetailShowPicLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.baidu.navisdk.ugc.pictures.show.ShowPicLayout
    public void a() {
        super.a();
        this.e = null;
        this.d = null;
    }
}
