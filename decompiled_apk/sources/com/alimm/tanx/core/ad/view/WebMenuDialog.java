package com.alimm.tanx.core.ad.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.alimm.tanx.core.R;
import com.alimm.tanx.core.utils.NotConfused;
import java.util.List;

/* loaded from: classes.dex */
public class WebMenuDialog extends Dialog implements NotConfused {
    private final Context mContext;
    private final LayoutInflater mInflater;
    private final MenuClick mMenuClick;
    private final List<ActionMenu> mMenuList;
    private final AdapterView.OnItemClickListener onMenuOnItemClickListener;

    /* loaded from: classes.dex */
    public interface MenuClick {
        void click(int i);
    }

    /* loaded from: classes.dex */
    public class tanxc_do extends BaseAdapter {
        public tanxc_do() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return WebMenuDialog.this.mMenuList.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return WebMenuDialog.this.mMenuList.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view2;
            tanxc_if tanxc_ifVar;
            if (view == null) {
                tanxc_ifVar = new tanxc_if();
                view2 = WebMenuDialog.this.mInflater.inflate(R.layout.tanx_layout_browser_simple_popmenu_items, viewGroup, false);
                tanxc_ifVar.tanxc_do = (ImageView) view2.findViewById(R.id.tanx_browser_menu_item_img);
                tanxc_ifVar.tanxc_if = (TextView) view2.findViewById(R.id.tanx_browser_menu_item_title);
                view2.setTag(tanxc_ifVar);
            } else {
                view2 = view;
                tanxc_ifVar = (tanxc_if) view.getTag();
            }
            ActionMenu actionMenu = (ActionMenu) getItem(i);
            tanxc_ifVar.tanxc_do.setImageResource(actionMenu.drawable);
            tanxc_ifVar.tanxc_if.setText(actionMenu.name);
            return view2;
        }
    }

    /* loaded from: classes.dex */
    public static class tanxc_if {
        ImageView tanxc_do;
        TextView tanxc_if;
    }

    public WebMenuDialog(Context context, List<ActionMenu> list, MenuClick menuClick) {
        super(context, R.style.Theme_Tanx_Browser_Dialog);
        this.onMenuOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.alimm.tanx.core.ad.view.WebMenuDialog.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                WebMenuDialog.this.mMenuClick.click(((ActionMenu) WebMenuDialog.this.mMenuList.get(i)).id);
                WebMenuDialog.this.dismiss();
            }
        };
        this.mContext = context;
        this.mMenuClick = menuClick;
        this.mMenuList = list;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setCanceledOnTouchOutside(true);
        if (getWindow() != null) {
            getWindow().setGravity(53);
            getWindow().getAttributes().y = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tanx_browser_default_height);
            getWindow().getAttributes().width = -2;
            getWindow().getAttributes().height = -2;
        }
        setContentView(R.layout.tanx_layout_browser_popmenu);
        ListView listView = (ListView) findViewById(R.id.tanx_browser_menu_listview);
        listView.setAdapter((ListAdapter) new tanxc_do());
        listView.setOnItemClickListener(this.onMenuOnItemClickListener);
    }
}
