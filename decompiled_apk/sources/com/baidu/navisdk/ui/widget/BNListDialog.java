package com.baidu.navisdk.ui.widget;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.util.b;
import com.baidu.navisdk.ui.widget.dialog.BNDialog;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.ArrayList;

/* loaded from: classes8.dex */
public class BNListDialog extends BNDialog {
    private final Activity mActivity;
    private final ListView mListView;

    /* loaded from: classes8.dex */
    public class InnerListAdapter extends BaseAdapter {
        private final ArrayList<String> mDataList = new ArrayList<>();

        public InnerListAdapter(ArrayList<String> arrayList) {
            for (int i = 0; i < arrayList.size(); i++) {
                this.mDataList.add(arrayList.get(i));
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            ArrayList<String> arrayList = this.mDataList;
            if (arrayList != null && arrayList.size() > 0) {
                return this.mDataList.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            ArrayList<String> arrayList = this.mDataList;
            if (arrayList != null && i >= 0 && i < arrayList.size()) {
                return this.mDataList.get(i);
            }
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            TextView textView;
            if (view == null) {
                view = JarUtils.inflate(BNListDialog.this.mActivity, R.layout.tv_iv_list_item, null);
                textView = (TextView) view.findViewById(R.id.text_view);
                view.setTag(textView);
            } else {
                textView = (TextView) view.getTag();
            }
            ArrayList<String> arrayList = this.mDataList;
            if (arrayList != null && i >= 0 && i < arrayList.size()) {
                textView.setText(this.mDataList.get(i));
            }
            if (i == getCount() - 1) {
                textView.setTextColor(b.b(R.color.nsdk_poi_city_list_title));
                view.setBackgroundDrawable(b.f(R.drawable.nsdk_common_dialog_chang));
            } else {
                textView.setTextColor(b.b(R.color.nsdk_poi_city_list_title));
                view.setBackgroundDrawable(b.f(R.drawable.nsdk_common_dialog_middle));
            }
            return view;
        }
    }

    public BNListDialog(Activity activity) {
        super(activity);
        this.mActivity = activity;
        View inflate = JarUtils.inflate(activity, R.layout.navi_dialog_listview, null);
        this.mListView = (ListView) inflate.findViewById(R.id.list_view);
        setContentList(inflate);
    }

    public ListView getListView() {
        return this.mListView;
    }

    public BNListDialog setAdapter(ListAdapter listAdapter) {
        this.mListView.setAdapter(listAdapter);
        return this;
    }

    public void setListAdapter(ArrayList<String> arrayList) {
        this.mListView.setAdapter((ListAdapter) new InnerListAdapter(arrayList));
    }

    public BNListDialog setListHeight(int i) {
        ViewGroup.LayoutParams layoutParams = this.mListView.getLayoutParams();
        layoutParams.height = i;
        this.mListView.setLayoutParams(layoutParams);
        return this;
    }

    public BNListDialog setListSelection(int i) {
        this.mListView.setSelection(i);
        return this;
    }

    public BNListDialog setListWidth(int i) {
        ViewGroup.LayoutParams layoutParams = this.mListView.getLayoutParams();
        layoutParams.width = i;
        this.mListView.setLayoutParams(layoutParams);
        return this;
    }

    public BNListDialog setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.mListView.setOnItemClickListener(onItemClickListener);
        return this;
    }

    @Override // com.baidu.navisdk.ui.widget.dialog.BNDialog
    public BNListDialog enableBackKey(boolean z) {
        super.enableBackKey(z);
        return this;
    }

    @Override // com.baidu.navisdk.ui.widget.dialog.BNDialog
    public BNListDialog setContentList(View view) {
        super.setContentList(view);
        return this;
    }

    @Override // com.baidu.navisdk.ui.widget.dialog.BNDialog
    public BNListDialog setFirstBtnEnabled(boolean z) {
        super.setFirstBtnEnabled(z);
        return this;
    }

    @Override // com.baidu.navisdk.ui.widget.dialog.BNDialog
    public BNListDialog setListTitleText(String str) {
        super.setListTitleText(str);
        return this;
    }

    @Override // com.baidu.navisdk.ui.widget.dialog.BNDialog
    public BNListDialog setOnFirstBtnClickListener(BNDialog.OnNaviClickListener onNaviClickListener) {
        super.setOnFirstBtnClickListener(onNaviClickListener);
        return this;
    }

    @Override // com.baidu.navisdk.ui.widget.dialog.BNDialog
    public BNListDialog setOnSecondBtnClickListener(BNDialog.OnNaviClickListener onNaviClickListener) {
        super.setOnSecondBtnClickListener(onNaviClickListener);
        return this;
    }

    @Override // com.baidu.navisdk.ui.widget.dialog.BNDialog
    public BNListDialog setSecondBtnEnabled(boolean z) {
        super.setSecondBtnEnabled(z);
        return this;
    }

    @Override // com.baidu.navisdk.ui.widget.dialog.BNDialog
    public BNListDialog setFirstBtnText(String str) {
        super.setFirstBtnText(str);
        return this;
    }

    @Override // com.baidu.navisdk.ui.widget.dialog.BNDialog
    public BNListDialog setSecondBtnText(String str) {
        super.setSecondBtnText(str);
        return this;
    }

    @Override // com.baidu.navisdk.ui.widget.dialog.BNDialog
    public BNListDialog setTitleText(String str) {
        super.setTitleText(str);
        return this;
    }

    @Override // com.baidu.navisdk.ui.widget.dialog.BNDialog
    public BNListDialog setFirstBtnText(int i) {
        super.setFirstBtnText(i);
        return this;
    }

    @Override // com.baidu.navisdk.ui.widget.dialog.BNDialog
    public BNListDialog setSecondBtnText(int i) {
        super.setSecondBtnText(i);
        return this;
    }

    @Override // com.baidu.navisdk.ui.widget.dialog.BNDialog
    public BNListDialog setTitleText(int i) {
        super.setTitleText(i);
        return this;
    }
}
