package com.baidu.navisdk.ui.routeguide.module.diyspeak;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.module.diyspeak.f;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.tenmeter.smlibrary.utils.FileUtils;

/* loaded from: classes8.dex */
public class b extends BaseExpandableListAdapter {
    private Context b;

    /* renamed from: a, reason: collision with root package name */
    private f.a[] f8992a = null;
    private long c = -1;
    private com.baidu.navisdk.ui.routeguide.module.diyspeak.c d = null;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ f.c f8993a;

        public a(f.c cVar) {
            this.f8993a = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.d != null) {
                b.this.d.a(this.f8993a.c);
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.module.diyspeak.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0468b implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ f.d f8994a;

        public C0468b(f.d dVar) {
            this.f8994a = dVar;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            int length = this.f8994a.b.length;
            for (int i = 0; i < length; i++) {
                b bVar = b.this;
                bVar.c = k.a(bVar.c, this.f8994a.b[i].b, !z ? 1 : 0);
            }
            if (b.this.d != null) {
                b.this.d.a();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ f.c f8995a;

        public c(f.c cVar) {
            this.f8995a = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.d != null) {
                b.this.d.a(this.f8995a.c);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements RadioGroup.OnCheckedChangeListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ f.d f8996a;

        public d(f.d dVar) {
            this.f8996a = dVar;
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            b bVar = b.this;
            long j = bVar.c;
            f.b bVar2 = this.f8996a.b[i];
            bVar.c = k.a(j, bVar2.b, bVar2.d);
            if (b.this.d != null) {
                b.this.d.b();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ f.c f8997a;

        public e(f.c cVar) {
            this.f8997a = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.d != null) {
                b.this.d.a(this.f8997a.c);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ f.d f8998a;

        public f(f.d dVar) {
            this.f8998a = dVar;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            int id = compoundButton.getId();
            b bVar = b.this;
            bVar.c = k.a(bVar.c, this.f8998a.b[id].b, !z ? 1 : 0);
            if (b.this.d != null) {
                b.this.d.a();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class g {

        /* renamed from: a, reason: collision with root package name */
        public TextView f8999a;
        public ImageView b;
    }

    /* loaded from: classes8.dex */
    public static class h {

        /* renamed from: a, reason: collision with root package name */
        public TextView f9000a;
        public ImageView b;
        public CheckBox c;
    }

    public b(Context context) {
        this.b = context;
    }

    private View c(View view, int i, int i2) {
        f.c cVar = this.f8992a[i].b[i2];
        LinearLayout linearLayout = new LinearLayout(this.b);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        linearLayout.setPadding(0, com.baidu.navisdk.ui.util.b.d(R.dimen.navi_dimens_16dp), 0, com.baidu.navisdk.ui.util.b.d(R.dimen.navi_dimens_17dp));
        LinearLayout linearLayout2 = new LinearLayout(this.b);
        linearLayout.addView(linearLayout2);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        TextView textView = new TextView(this.b);
        textView.setTextColor(JarUtils.getResources().getColor(R.color.nsdk_cl_text_a));
        textView.setTextSize(0, com.baidu.navisdk.ui.util.b.d(R.dimen.navi_dimens_13dp));
        linearLayout2.addView(textView);
        textView.setText((i2 + 1) + FileUtils.FILE_EXTENSION_SEPARATOR + cVar.b);
        if (!TextUtils.isEmpty(cVar.c)) {
            ImageView imageView = new ImageView(this.b);
            imageView.setImageResource(R.drawable.nsdk_drawable_diyspeak_preview);
            linearLayout2.addView(imageView);
            imageView.setOnClickListener(new c(cVar));
        }
        f.d dVar = cVar.e[0];
        LinearLayout linearLayout3 = new LinearLayout(this.b);
        linearLayout.addView(linearLayout3);
        linearLayout3.setOrientation(0);
        linearLayout3.setGravity(16);
        int length = dVar.b.length;
        RadioGroup radioGroup = new RadioGroup(this.b);
        radioGroup.setOrientation(0);
        radioGroup.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout3.addView(radioGroup);
        for (int i3 = 0; i3 < length; i3++) {
            RadioButton radioButton = new RadioButton(this.b);
            radioGroup.addView(radioButton);
            if (i3 != length - 1) {
                RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(0, 1);
                layoutParams.weight = 1.0f;
                View view2 = new View(this.b);
                view2.setLayoutParams(layoutParams);
                radioGroup.addView(view2);
            }
            radioButton.setId(i3);
            radioButton.setClickable(true);
            radioButton.setTextColor(JarUtils.getResources().getColor(R.color.nsdk_cl_text_f));
            radioButton.setTextSize(0, com.baidu.navisdk.ui.util.b.d(R.dimen.navi_dimens_13dp));
            radioButton.setButtonDrawable(android.R.color.transparent);
            radioButton.setBackgroundResource(android.R.color.transparent);
            radioButton.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, JarUtils.getResources().getDrawable(R.drawable.nsdk_rg_circle_checkbox_selector), (Drawable) null);
            radioButton.setCompoundDrawablePadding(com.baidu.navisdk.ui.util.b.d(R.dimen.navi_dimens_2dp));
            radioButton.setText(dVar.b[i3].e);
            long j = this.c;
            f.b bVar = dVar.b[i3];
            if (k.b(j, bVar.b, bVar.d)) {
                radioGroup.check(i3);
            }
        }
        radioGroup.setOnCheckedChangeListener(new d(dVar));
        return linearLayout;
    }

    private View d(View view, int i, int i2) {
        int i3 = this.f8992a[i].b[i2].f9006a;
        if (i3 == 1) {
            View a2 = a(view);
            a(a2, i, i2);
            return a2;
        }
        if (i3 == 2) {
            return c(view, i, i2);
        }
        if (i3 == 3) {
            return b(view, i, i2);
        }
        return null;
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getChild(int i, int i2) {
        f.a[] aVarArr = this.f8992a;
        if (aVarArr != null) {
            return aVarArr[i].b[i2];
        }
        return null;
    }

    @Override // android.widget.ExpandableListAdapter
    public long getChildId(int i, int i2) {
        return i2;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        return d(view, i, i2);
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int i) {
        f.a[] aVarArr = this.f8992a;
        if (aVarArr != null) {
            return aVarArr[i].b.length;
        }
        return 0;
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getGroup(int i) {
        f.a[] aVarArr = this.f8992a;
        if (aVarArr != null) {
            return aVarArr[i];
        }
        return null;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getGroupCount() {
        f.a[] aVarArr = this.f8992a;
        if (aVarArr != null) {
            return aVarArr.length;
        }
        return 0;
    }

    @Override // android.widget.ExpandableListAdapter
    public long getGroupId(int i) {
        return i;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        if (view == null) {
            g gVar = new g();
            LinearLayout linearLayout = new LinearLayout(this.b);
            linearLayout.setOrientation(0);
            linearLayout.setGravity(16);
            TextView textView = new TextView(this.b);
            textView.setTextColor(JarUtils.getResources().getColor(R.color.nsdk_cl_text_a));
            textView.setTextSize(0, com.baidu.navisdk.ui.util.b.d(R.dimen.navi_dimens_17dp));
            linearLayout.addView(textView);
            gVar.f8999a = textView;
            View view2 = new View(this.b);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, 1);
            layoutParams.weight = 1.0f;
            linearLayout.addView(view2, layoutParams);
            ImageView imageView = new ImageView(this.b);
            imageView.setImageResource(R.drawable.nsdk_nearby_search_up_arrow);
            imageView.setPadding(0, 0, com.baidu.navisdk.ui.util.b.d(R.dimen.navi_dimens_3dp), 0);
            linearLayout.addView(imageView);
            gVar.b = imageView;
            linearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.navisdk.ui.util.b.d(R.dimen.navi_dimens_52dp)));
            linearLayout.setTag(gVar);
            view = linearLayout;
        }
        g gVar2 = (g) view.getTag();
        gVar2.f8999a.setText(this.f8992a[i].f9004a);
        if (z) {
            gVar2.b.setImageResource(R.drawable.nsdk_nearby_search_up_arrow);
        } else {
            gVar2.b.setImageResource(R.drawable.nsdk_nearby_search_down_arrow);
        }
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean hasStableIds() {
        return true;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean isChildSelectable(int i, int i2) {
        return true;
    }

    private View b(View view, int i, int i2) {
        int i3;
        f.c cVar = this.f8992a[i].b[i2];
        LinearLayout linearLayout = new LinearLayout(this.b);
        boolean z = true;
        linearLayout.setOrientation(1);
        int i4 = -1;
        linearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        linearLayout.setPadding(0, com.baidu.navisdk.ui.util.b.d(R.dimen.navi_dimens_16dp), 0, com.baidu.navisdk.ui.util.b.d(R.dimen.navi_dimens_20dp));
        LinearLayout linearLayout2 = new LinearLayout(this.b);
        linearLayout.addView(linearLayout2);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        TextView textView = new TextView(this.b);
        textView.setTextColor(JarUtils.getResources().getColor(R.color.nsdk_cl_text_a));
        textView.setTextSize(0, com.baidu.navisdk.ui.util.b.d(R.dimen.navi_dimens_13dp));
        linearLayout2.addView(textView);
        textView.setText((i2 + 1) + FileUtils.FILE_EXTENSION_SEPARATOR + cVar.b);
        if (!TextUtils.isEmpty(cVar.c)) {
            ImageView imageView = new ImageView(this.b);
            imageView.setImageResource(R.drawable.nsdk_drawable_diyspeak_preview);
            linearLayout2.addView(imageView);
            imageView.setOnClickListener(new e(cVar));
        }
        int length = cVar.e.length;
        int i5 = 0;
        while (i5 < length) {
            f.d dVar = cVar.e[i5];
            TextView textView2 = new TextView(this.b);
            textView2.setTextColor(JarUtils.getResources().getColor(R.color.nsdk_cl_text_f));
            textView2.setTextSize(0, com.baidu.navisdk.ui.util.b.d(R.dimen.navi_dimens_12dp));
            textView2.setText(dVar.f9007a);
            textView2.setPadding(0, com.baidu.navisdk.ui.util.b.d(R.dimen.navi_dimens_17dp), 0, 0);
            linearLayout.addView(textView2);
            LinearLayout linearLayout3 = new LinearLayout(this.b);
            linearLayout3.setOrientation(0);
            linearLayout3.setGravity(16);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i4, -2);
            layoutParams.topMargin = com.baidu.navisdk.ui.util.b.d(R.dimen.navi_dimens_10dp);
            linearLayout3.setLayoutParams(layoutParams);
            int length2 = dVar.b.length;
            int i6 = 0;
            while (i6 < length2) {
                CheckBox checkBox = new CheckBox(this.b);
                linearLayout3.addView(checkBox);
                if (i6 != length2 - 1) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    checkBox.setLayoutParams(layoutParams2);
                    layoutParams2.rightMargin = com.baidu.navisdk.ui.util.b.d(R.dimen.navi_dimens_18dp);
                }
                checkBox.setId(i6);
                checkBox.setButtonDrawable(android.R.color.transparent);
                checkBox.setBackgroundResource(android.R.color.transparent);
                checkBox.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, JarUtils.getResources().getDrawable(R.drawable.nsdk_rg_rectangle_checkbox_selector), (Drawable) null);
                checkBox.setCompoundDrawablePadding(com.baidu.navisdk.ui.util.b.d(R.dimen.navi_dimens_2dp));
                checkBox.setTextColor(JarUtils.getResources().getColor(R.color.nsdk_cl_text_f));
                checkBox.setTextSize(0, com.baidu.navisdk.ui.util.b.d(R.dimen.navi_dimens_13dp));
                checkBox.setText(dVar.b[i6].e);
                checkBox.setTag(dVar.b[i6]);
                if (dVar.b[i6].f9005a) {
                    checkBox.setChecked(z);
                    checkBox.setEnabled(false);
                    i3 = length;
                } else {
                    checkBox.setEnabled(z);
                    i3 = length;
                    checkBox.setChecked(k.a(this.c, dVar.b[i6].b));
                }
                checkBox.setOnCheckedChangeListener(new f(dVar));
                i6++;
                length = i3;
                z = true;
            }
            linearLayout.addView(linearLayout3);
            i5++;
            z = true;
            i4 = -1;
        }
        return linearLayout;
    }

    public void a(f.a[] aVarArr) {
        this.f8992a = aVarArr;
    }

    public void a(long j) {
        if (this.c == j) {
            return;
        }
        this.c = j;
        notifyDataSetChanged();
    }

    public long a() {
        return this.c;
    }

    public void a(com.baidu.navisdk.ui.routeguide.module.diyspeak.c cVar) {
        this.d = cVar;
    }

    private View a(View view) {
        h hVar = new h();
        LinearLayout linearLayout = new LinearLayout(this.b);
        linearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, ScreenUtil.getInstance().dip2px(46)));
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        TextView textView = new TextView(this.b);
        hVar.f9000a = textView;
        linearLayout.addView(textView);
        textView.setTextColor(JarUtils.getResources().getColor(R.color.nsdk_cl_text_a));
        textView.setTextSize(0, com.baidu.navisdk.ui.util.b.d(R.dimen.navi_dimens_13dp));
        ImageView imageView = new ImageView(this.b);
        hVar.b = imageView;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = com.baidu.navisdk.ui.util.b.d(R.dimen.navi_dimens_4dp);
        imageView.setLayoutParams(layoutParams);
        imageView.setImageResource(R.drawable.nsdk_drawable_diyspeak_preview);
        linearLayout.addView(imageView);
        View view2 = new View(this.b);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, 1);
        layoutParams2.weight = 1.0f;
        linearLayout.addView(view2, layoutParams2);
        CheckBox checkBox = new CheckBox(this.b);
        hVar.c = checkBox;
        linearLayout.addView(checkBox);
        checkBox.setButtonDrawable(android.R.color.transparent);
        checkBox.setBackgroundResource(android.R.color.transparent);
        checkBox.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, JarUtils.getResources().getDrawable(R.drawable.nsdk_rg_circle_checkbox_selector_big), (Drawable) null);
        checkBox.setCompoundDrawablePadding(com.baidu.navisdk.ui.util.b.d(R.dimen.navi_dimens_20dp));
        checkBox.setText("  ");
        linearLayout.setTag(hVar);
        return linearLayout;
    }

    private void a(View view, int i, int i2) {
        f.c cVar = this.f8992a[i].b[i2];
        h hVar = (h) view.getTag();
        String str = (i2 + 1) + FileUtils.FILE_EXTENSION_SEPARATOR + cVar.b;
        if (cVar.d) {
            str = str + "(必选)";
        }
        hVar.f9000a.setText(str);
        if (!TextUtils.isEmpty(cVar.c)) {
            hVar.b.setVisibility(0);
            hVar.b.setOnClickListener(new a(cVar));
        } else {
            hVar.b.setVisibility(8);
        }
        if (cVar.d) {
            hVar.c.setChecked(true);
            hVar.c.setEnabled(false);
            return;
        }
        hVar.c.setEnabled(true);
        f.d dVar = cVar.e[0];
        int length = dVar.b.length;
        boolean z = false;
        for (int i3 = 0; i3 < length; i3++) {
            z = k.a(this.c, dVar.b[i3].b);
            if (z) {
                break;
            }
        }
        hVar.c.setChecked(z);
        hVar.c.setOnCheckedChangeListener(new C0468b(dVar));
    }
}
