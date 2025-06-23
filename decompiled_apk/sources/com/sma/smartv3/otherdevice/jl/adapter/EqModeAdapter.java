package com.sma.smartv3.otherdevice.jl.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter;
import com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder;
import com.blankj.utilcode.util.Utils;
import com.jieli.jl_rcsp.model.device.EqInfo;
import com.sma.smartv3.co_fit.R;
import java.util.List;
import oo00.oIX0oI;

/* loaded from: classes12.dex */
public class EqModeAdapter extends CommonAdapter<EqInfo> {
    private int selectMode;

    public EqModeAdapter(Context context, List<EqInfo> list) {
        super(context, R.layout.item_eq_mode, list);
        this.selectMode = 0;
    }

    public String getModeNmae(int mode) {
        return Utils.getApp().getResources().getStringArray(R.array.eq_mode_list)[mode];
    }

    public void select(int selectMode) {
        this.selectMode = selectMode;
        notifyDataSetChanged();
    }

    @Override // com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter
    public void convert(ViewHolder holder, EqInfo item, int position) {
        Bitmap decodeFile;
        holder.setText(R.id.tv_eq_mode_name, getModeNmae(item.getMode()));
        holder.getView(R.id.tv_eq_mode_name).setSelected(this.selectMode == item.getMode());
        ImageView imageView = (ImageView) holder.getView(R.id.iv_eq_mode_bmp);
        if (item.getMode() == 6) {
            decodeFile = oIX0oI.II0xO0(item);
        } else {
            decodeFile = BitmapFactory.decodeFile(oIX0oI.xoIox(item));
        }
        imageView.setImageBitmap(decodeFile);
    }
}
