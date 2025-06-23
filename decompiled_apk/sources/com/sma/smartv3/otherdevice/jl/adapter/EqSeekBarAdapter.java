package com.sma.smartv3.otherdevice.jl.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter;
import com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder;
import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.jieli.jl_rcsp.model.device.EqInfo;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.otherdevice.jl.adapter.EqSeekBarAdapter;
import com.sma.smartv3.otherdevice.jl.view.VerticalSeekBarView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import xX.OOXIXo;

/* loaded from: classes12.dex */
public final class EqSeekBarAdapter extends CommonAdapter<OOXIXo> {
    private boolean ban;
    private EqInfo mEqInfo;
    private boolean mHasHoverView;
    private RecyclerView mRecyclerView;
    private oIX0oI mValueChange;
    private int selectMode;

    /* loaded from: classes12.dex */
    public interface oIX0oI {
        void oIX0oI(int index, EqInfo eqInfo, boolean end);
    }

    public EqSeekBarAdapter(Context context, List<OOXIXo> list, oIX0oI valueChange) {
        super(context, R.layout.item_eq_seekbar, list);
        this.selectMode = -1;
        this.mHasHoverView = false;
        this.mEqInfo = new EqInfo();
        this.mValueChange = valueChange;
    }

    public static String freqValueToFreqShowText(int value) {
        int i = value / 1000;
        if (i > 0) {
            return i + "K";
        }
        return value + "";
    }

    public static int getScreenWidth(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$convert$0(int i, OOXIXo oOXIXo, int i2, boolean z) {
        if (i < 0) {
            return;
        }
        oOXIXo.XO(i2);
        this.mEqInfo.getValue()[oOXIXo.II0xO0()] = (byte) oOXIXo.I0Io();
        this.mValueChange.oIX0oI(oOXIXo.II0xO0(), this.mEqInfo, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$convert$1(boolean z) {
        this.mHasHoverView = z;
    }

    private void setNewInstance(List<OOXIXo> list) {
        try {
            ((CommonAdapter) this).mDatas.clear();
            ((CommonAdapter) this).mDatas.addAll(list);
            notifyDataSetChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int[] getValues() {
        int size = getDatas().size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = getDatas().get(i).I0Io();
        }
        return iArr;
    }

    public boolean hasHoverView() {
        return this.mHasHoverView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.mRecyclerView = recyclerView;
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public void reset() {
        Iterator<OOXIXo> it = getDatas().iterator();
        while (it.hasNext()) {
            it.next().XO(0);
        }
        notifyDataSetChanged();
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public void select(int selectMode) {
        this.selectMode = selectMode;
        notifyDataSetChanged();
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public void setBan(boolean ban) {
        this.ban = ban;
        notifyDataSetChanged();
    }

    public void updateSeekBar(EqInfo eqInfo) {
        this.mEqInfo = eqInfo;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < eqInfo.getValue().length && i < eqInfo.getFreqs().length; i++) {
            arrayList.add(new OOXIXo(i, freqValueToFreqShowText(eqInfo.getFreqs()[i]), eqInfo.getValue()[i]));
        }
        setNewInstance(arrayList);
    }

    @Override // com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter
    public void convert(ViewHolder holder, final OOXIXo item, final int position) {
        int i;
        if (getDatas().size() > 0) {
            ViewGroup viewGroup = (ViewGroup) holder.getView(R.id.cl_main);
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            if (getDatas().size() < 7) {
                if (this.mRecyclerView.getWidth() != 0) {
                    i = this.mRecyclerView.getWidth() / getDatas().size();
                } else {
                    i = (ScreenUtils.getScreenWidth() - SizeUtils.dp2px(60.0f)) / getDatas().size();
                }
            } else {
                layoutParams.width = SizeUtils.dp2px(50.0f);
                i = 0;
            }
            if (i != 0) {
                layoutParams.width = i;
                viewGroup.setLayoutParams(layoutParams);
            }
        }
        VerticalSeekBarView verticalSeekBarView = (VerticalSeekBarView) holder.getView(R.id.vsb_eq);
        verticalSeekBarView.setText(item.oIX0oI());
        verticalSeekBarView.setValue(item.I0Io());
        verticalSeekBarView.setIndex(item.II0xO0());
        verticalSeekBarView.setEnable(!this.ban);
        this.mEqInfo.getValue()[item.II0xO0()] = (byte) item.I0Io();
        verticalSeekBarView.setValueListener(new VerticalSeekBarView.II0xO0() { // from class: xX.xxIXOIIO
            @Override // com.sma.smartv3.otherdevice.jl.view.VerticalSeekBarView.II0xO0
            public final void oIX0oI(int i2, boolean z) {
                EqSeekBarAdapter.this.lambda$convert$0(position, item, i2, z);
            }
        });
        verticalSeekBarView.setHoverListener(new VerticalSeekBarView.oIX0oI() { // from class: xX.xoIox
            @Override // com.sma.smartv3.otherdevice.jl.view.VerticalSeekBarView.oIX0oI
            public final void oIX0oI(boolean z) {
                EqSeekBarAdapter.this.lambda$convert$1(z);
            }
        });
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public void updateSeekBar(int[] value) {
        if (this.mHasHoverView) {
            return;
        }
        List<OOXIXo> datas = getDatas();
        int i = 0;
        int i2 = -1;
        for (int i3 = 0; i3 < datas.size() && i3 < value.length; i3++) {
            if (value[i3] != datas.get(i3).I0Io()) {
                i++;
                i2 = i3;
            }
            datas.get(i3).XO(value[i3]);
        }
        if (i > 1) {
            notifyDataSetChanged();
        } else if (i2 != -1) {
            notifyItemChanged(i2);
        }
    }
}
