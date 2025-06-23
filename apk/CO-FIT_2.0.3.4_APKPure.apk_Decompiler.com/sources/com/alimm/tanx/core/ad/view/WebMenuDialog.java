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
import android.widget.ListView;
import android.widget.TextView;
import com.alimm.tanx.core.R;
import com.alimm.tanx.core.utils.NotConfused;
import java.util.List;

public class WebMenuDialog extends Dialog implements NotConfused {
    private final Context mContext;
    /* access modifiers changed from: private */
    public final LayoutInflater mInflater;
    /* access modifiers changed from: private */
    public final MenuClick mMenuClick;
    /* access modifiers changed from: private */
    public final List<ActionMenu> mMenuList;
    private final AdapterView.OnItemClickListener onMenuOnItemClickListener = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            WebMenuDialog.this.mMenuClick.click(((ActionMenu) WebMenuDialog.this.mMenuList.get(i)).id);
            WebMenuDialog.this.dismiss();
        }
    };

    public interface MenuClick {
        void click(int i);
    }

    public class tanxc_do extends BaseAdapter {
        public tanxc_do() {
        }

        public int getCount() {
            return WebMenuDialog.this.mMenuList.size();
        }

        public Object getItem(int i) {
            return WebMenuDialog.this.mMenuList.get(i);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            View view2;
            tanxc_if tanxc_if;
            if (view == null) {
                tanxc_if = new tanxc_if();
                view2 = WebMenuDialog.this.mInflater.inflate(R.layout.tanx_layout_browser_simple_popmenu_items, viewGroup, false);
                tanxc_if.tanxc_do = (ImageView) view2.findViewById(R.id.tanx_browser_menu_item_img);
                tanxc_if.tanxc_if = (TextView) view2.findViewById(R.id.tanx_browser_menu_item_title);
                view2.setTag(tanxc_if);
            } else {
                view2 = view;
                tanxc_if = (tanxc_if) view.getTag();
            }
            ActionMenu actionMenu = (ActionMenu) getItem(i);
            tanxc_if.tanxc_do.setImageResource(actionMenu.drawable);
            tanxc_if.tanxc_if.setText(actionMenu.name);
            return view2;
        }
    }

    public static class tanxc_if {
        ImageView tanxc_do;
        TextView tanxc_if;
    }

    public WebMenuDialog(Context context, List<ActionMenu> list, MenuClick menuClick) {
        super(context, R.style.Theme_Tanx_Browser_Dialog);
        this.mContext = context;
        this.mMenuClick = menuClick;
        this.mMenuList = list;
        this.mInflater = LayoutInflater.from(context);
    }

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
        listView.setAdapter(new tanxc_do());
        listView.setOnItemClickListener(this.onMenuOnItemClickListener);
    }
}
