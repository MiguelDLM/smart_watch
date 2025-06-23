package com.baidu.navisdk.ugc.quickinput;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ugc.quickinput.sugs.QuickInputPromptView;
import com.baidu.navisdk.ugc.quickinput.tags.TagsLinearLayout;
import com.baidu.navisdk.ugc.report.data.datarepository.f;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.ArrayList;

/* loaded from: classes8.dex */
public class b implements QuickInputPromptView.b, com.baidu.navisdk.ugc.quickinput.tags.a {

    /* renamed from: a, reason: collision with root package name */
    private com.baidu.navisdk.ugc.quickinput.sugs.a f8221a;
    private EditText c;
    private QuickInputPromptView.b d;
    private com.baidu.navisdk.ugc.quickinput.tags.a e;
    private com.baidu.navisdk.ugc.quickinput.tags.b[] f;
    private com.baidu.navisdk.ugc.quickinput.tags.b[] g;
    private TagsLinearLayout h;
    private TagsLinearLayout i;
    private int l;
    private TextWatcher b = null;
    private int j = -1;
    private int k = -1;

    /* loaded from: classes8.dex */
    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (b.this.f8221a != null) {
                b.this.f8221a.a(editable.toString().trim());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    private void c() {
        if (this.b != null) {
            return;
        }
        this.b = new a();
    }

    public void b() {
        com.baidu.navisdk.ugc.quickinput.tags.b[] bVarArr;
        com.baidu.navisdk.ugc.quickinput.tags.b[] bVarArr2;
        TagsLinearLayout tagsLinearLayout = this.h;
        if (tagsLinearLayout != null && (bVarArr2 = this.f) != null) {
            tagsLinearLayout.a(bVarArr2, this.l, 2, this.j);
        }
        TagsLinearLayout tagsLinearLayout2 = this.i;
        if (tagsLinearLayout2 != null && (bVarArr = this.g) != null) {
            tagsLinearLayout2.a(bVarArr, this.l, 1, this.k);
        }
        com.baidu.navisdk.ugc.quickinput.sugs.a aVar = this.f8221a;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void a(Context context, RelativeLayout relativeLayout, int i, com.baidu.navisdk.ugc.quickinput.a aVar) {
        if (relativeLayout != null && context != null && aVar != null) {
            this.l = aVar.f8220a;
            int b = a(aVar) ? b(context, relativeLayout, i, aVar) : i;
            boolean z = i != b;
            if (aVar.c && aVar.f8220a == 1) {
                a(context, relativeLayout, b, aVar, z);
            }
            a(context, relativeLayout, i);
            return;
        }
        g.UGC.e("UgcModule_Sug", "addQuickInputView parentView is null");
    }

    private int b(Context context, RelativeLayout relativeLayout, int i, com.baidu.navisdk.ugc.quickinput.a aVar) {
        if (context == null || relativeLayout == null || aVar == null) {
            return i;
        }
        this.e = aVar.i;
        this.j = aVar.j;
        this.k = aVar.k;
        ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> b = f.e().b(aVar.b);
        if (b != null && !b.isEmpty()) {
            int size = b.size();
            this.f = new com.baidu.navisdk.ugc.quickinput.tags.b[size];
            for (int i2 = 0; i2 < size; i2++) {
                this.f[i2] = new com.baidu.navisdk.ugc.quickinput.tags.b(b.get(i2).f8246a, b.get(i2).b);
            }
        }
        ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> a2 = f.e().a(aVar.b, aVar.g);
        if (a2 != null && !a2.isEmpty()) {
            int size2 = a2.size();
            this.g = new com.baidu.navisdk.ugc.quickinput.tags.b[size2];
            for (int i3 = 0; i3 < size2; i3++) {
                this.g[i3] = new com.baidu.navisdk.ugc.quickinput.tags.b(a2.get(i3).f8246a, a2.get(i3).b);
            }
        }
        int dip2px = ScreenUtil.getInstance().dip2px(10);
        com.baidu.navisdk.ugc.quickinput.tags.b[] bVarArr = this.f;
        if (bVarArr != null && bVarArr.length > 0) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            TagsLinearLayout tagsLinearLayout = new TagsLinearLayout(context);
            this.h = tagsLinearLayout;
            tagsLinearLayout.setOnTagItemClickListener(this);
            TagsLinearLayout tagsLinearLayout2 = this.h;
            int i4 = R.id.ugc_detail_comment_detail_id;
            tagsLinearLayout2.setId(i4);
            layoutParams.addRule(2, i);
            this.h.setPadding(0, dip2px, 0, dip2px);
            relativeLayout.addView(this.h, layoutParams);
            i = i4;
        }
        com.baidu.navisdk.ugc.quickinput.tags.b[] bVarArr2 = this.g;
        if (bVarArr2 == null || bVarArr2.length <= 0) {
            return i;
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        TagsLinearLayout tagsLinearLayout3 = new TagsLinearLayout(context);
        this.i = tagsLinearLayout3;
        tagsLinearLayout3.setOnTagItemClickListener(this);
        TagsLinearLayout tagsLinearLayout4 = this.i;
        int i5 = R.id.ugc_detail_comment_lane_id;
        tagsLinearLayout4.setId(i5);
        layoutParams2.addRule(2, i);
        if (i != R.id.ugc_detail_comment_detail_id) {
            this.i.setPadding(0, dip2px, 0, dip2px);
        } else {
            this.i.setPadding(0, dip2px, 0, 0);
        }
        relativeLayout.addView(this.i, layoutParams2);
        return i5;
    }

    private void a(Context context, RelativeLayout relativeLayout, int i) {
        View view = new View(context);
        view.setBackgroundResource(R.drawable.nsdk_ugc_detail_post_comment_shadow);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, ScreenUtil.getInstance().dip2px(6));
        layoutParams.addRule(2, i);
        view.setLayoutParams(layoutParams);
        relativeLayout.addView(view);
    }

    private void a(Context context, RelativeLayout relativeLayout, int i, com.baidu.navisdk.ugc.quickinput.a aVar, boolean z) {
        QuickInputPromptView quickInputPromptView = (QuickInputPromptView) JarUtils.inflate(context, R.layout.nsdk_layout_ugc_quick_input_prompt, null);
        if (quickInputPromptView == null) {
            g gVar = g.UGC;
            if (gVar.c()) {
                gVar.c("UgcModule_Sug", "addQuickPromptView inflate prompt view is null");
                return;
            }
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        if (i > 0) {
            layoutParams.addRule(2, i);
        }
        quickInputPromptView.setLayoutParams(layoutParams);
        relativeLayout.addView(quickInputPromptView);
        this.d = aVar.e;
        this.f8221a = quickInputPromptView;
        quickInputPromptView.setScreenOrientation(aVar.f8220a);
        this.f8221a.setEventType(aVar.b);
        this.f8221a.setSourceFrom(aVar.f);
        this.f8221a.setPageFrom(aVar.g);
        this.f8221a.setClickPromptListener(this);
        this.f8221a.setIsShowTags(z);
        EditText editText = aVar.h;
        if (editText != null) {
            this.c = editText;
            this.f8221a.setHasInitTextInEdit(!TextUtils.isEmpty(editText.getEditableText().toString().trim()));
            c();
            this.c.addTextChangedListener(this.b);
        }
    }

    @Override // com.baidu.navisdk.ugc.quickinput.sugs.QuickInputPromptView.b
    public void a(String str, String str2) {
        if (this.c != null && !TextUtils.isEmpty(str)) {
            this.c.setText(str);
            this.c.setSelection(str.length());
        }
        QuickInputPromptView.b bVar = this.d;
        if (bVar != null) {
            bVar.a(str, str2);
        }
    }

    private boolean a(com.baidu.navisdk.ugc.quickinput.a aVar) {
        return aVar.d && aVar.f == 2 && aVar.f8220a == 1;
    }

    @Override // com.baidu.navisdk.ugc.quickinput.tags.a
    public void a(int i, String str, int i2) {
        com.baidu.navisdk.ugc.quickinput.tags.a aVar = this.e;
        if (aVar != null) {
            aVar.a(i, str, i2);
        }
    }

    public void a() {
        TextWatcher textWatcher;
        EditText editText = this.c;
        if (editText != null && (textWatcher = this.b) != null) {
            editText.removeTextChangedListener(textWatcher);
            this.c = null;
            this.b = null;
        }
        com.baidu.navisdk.ugc.quickinput.sugs.a aVar = this.f8221a;
        if (aVar != null) {
            aVar.onDestroy();
            this.f8221a = null;
        }
        TagsLinearLayout tagsLinearLayout = this.h;
        if (tagsLinearLayout != null) {
            tagsLinearLayout.setOnTagItemClickListener(null);
            this.h.setVisibility(8);
            this.h.removeAllViews();
            this.h = null;
        }
        TagsLinearLayout tagsLinearLayout2 = this.i;
        if (tagsLinearLayout2 != null) {
            tagsLinearLayout2.setOnTagItemClickListener(null);
            this.i.setVisibility(8);
            this.i.removeAllViews();
            this.i = null;
        }
        this.d = null;
        this.e = null;
        this.g = null;
        this.f = null;
    }
}
