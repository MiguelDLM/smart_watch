package com.sma.smartv3.pop.dial;

import OXOo.OOXIXo;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter;
import com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.ResourcesIdInfo;
import com.sma.smartv3.pop.dial.DialPointerPopup;
import com.sma.smartv3.util.oOoXoXO;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class DialPointerPopup extends OOOI.oxoX {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    @OOXIXo
    public final RecyclerView f21420II0XooXoX;

    /* renamed from: xoIox, reason: collision with root package name */
    @OOXIXo
    public final Button f21421xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    @OOXIXo
    public final RecyclerView f21422xxIXOIIO;

    /* renamed from: com.sma.smartv3.pop.dial.DialPointerPopup$3, reason: invalid class name */
    /* loaded from: classes12.dex */
    public static final class AnonymousClass3 extends CommonAdapter<ResourcesIdInfo> {
        final /* synthetic */ oOoXoXO<Integer> $callback;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(Activity activity, List<ResourcesIdInfo> list, oOoXoXO<Integer> oooxoxo) {
            super(activity, R.layout.item_pointer_select, list);
            this.$callback = oooxoxo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void convert$lambda$0(AnonymousClass3 this$0, ResourcesIdInfo resourcesIdInfo, oOoXoXO callback, int i, View view) {
            IIX0o.x0xO0oo(this$0, "this$0");
            IIX0o.x0xO0oo(resourcesIdInfo, "$resourcesIdInfo");
            IIX0o.x0xO0oo(callback, "$callback");
            Iterator it = ((CommonAdapter) this$0).mDatas.iterator();
            while (it.hasNext()) {
                ((ResourcesIdInfo) it.next()).setSelect(false);
            }
            resourcesIdInfo.setSelect(true);
            callback.oIX0oI(Integer.valueOf(i));
            this$0.notifyDataSetChanged();
        }

        @Override // com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter
        public void convert(@OOXIXo ViewHolder holder, @OOXIXo final ResourcesIdInfo resourcesIdInfo, final int i) {
            IIX0o.x0xO0oo(holder, "holder");
            IIX0o.x0xO0oo(resourcesIdInfo, "resourcesIdInfo");
            ((ImageView) holder.getView(R.id.pointerIv)).setImageResource(resourcesIdInfo.getResId());
            ((ImageView) holder.getView(R.id.selectStatus)).setVisibility(resourcesIdInfo.isSelect() ? 0 : 8);
            RelativeLayout relativeLayout = (RelativeLayout) holder.getView(R.id.rv);
            final oOoXoXO<Integer> oooxoxo = this.$callback;
            relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.dial.X0o0xo
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialPointerPopup.AnonymousClass3.convert$lambda$0(DialPointerPopup.AnonymousClass3.this, resourcesIdInfo, oooxoxo, i, view);
                }
            });
        }
    }

    /* renamed from: com.sma.smartv3.pop.dial.DialPointerPopup$4, reason: invalid class name */
    /* loaded from: classes12.dex */
    public static final class AnonymousClass4 extends CommonAdapter<ResourcesIdInfo> {
        final /* synthetic */ oOoXoXO<Integer> $callback;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(Activity activity, List<ResourcesIdInfo> list, oOoXoXO<Integer> oooxoxo) {
            super(activity, R.layout.item_pointer_select, list);
            this.$callback = oooxoxo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void convert$lambda$0(AnonymousClass4 this$0, ResourcesIdInfo resourcesIdInfo, oOoXoXO callback, int i, View view) {
            IIX0o.x0xO0oo(this$0, "this$0");
            IIX0o.x0xO0oo(resourcesIdInfo, "$resourcesIdInfo");
            IIX0o.x0xO0oo(callback, "$callback");
            Iterator it = ((CommonAdapter) this$0).mDatas.iterator();
            while (it.hasNext()) {
                ((ResourcesIdInfo) it.next()).setSelect(false);
            }
            resourcesIdInfo.setSelect(true);
            callback.II0xO0(Integer.valueOf(i));
            this$0.notifyDataSetChanged();
        }

        @Override // com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter
        public void convert(@OOXIXo ViewHolder holder, @OOXIXo final ResourcesIdInfo resourcesIdInfo, final int i) {
            IIX0o.x0xO0oo(holder, "holder");
            IIX0o.x0xO0oo(resourcesIdInfo, "resourcesIdInfo");
            ((ImageView) holder.getView(R.id.pointerIv)).setImageResource(resourcesIdInfo.getResId());
            ((ImageView) holder.getView(R.id.selectStatus)).setVisibility(resourcesIdInfo.isSelect() ? 0 : 8);
            RelativeLayout relativeLayout = (RelativeLayout) holder.getView(R.id.rv);
            final oOoXoXO<Integer> oooxoxo = this.$callback;
            relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.dial.XO
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialPointerPopup.AnonymousClass4.convert$lambda$0(DialPointerPopup.AnonymousClass4.this, resourcesIdInfo, oooxoxo, i, view);
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialPointerPopup(@OOXIXo Activity activity, @OOXIXo List<ResourcesIdInfo> pointers, @OOXIXo List<ResourcesIdInfo> scales, @OOXIXo oOoXoXO<Integer> callback) {
        super(activity);
        IIX0o.x0xO0oo(activity, "activity");
        IIX0o.x0xO0oo(pointers, "pointers");
        IIX0o.x0xO0oo(scales, "scales");
        IIX0o.x0xO0oo(callback, "callback");
        LayoutInflater.from(Oxx0IOOO()).inflate(R.layout.pop_dial_point, xxIXOIIO());
        View findViewById = xxIXOIIO().findViewById(R.id.rvPointer);
        IIX0o.oO(findViewById, "findViewById(...)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.f21420II0XooXoX = recyclerView;
        View findViewById2 = xxIXOIIO().findViewById(R.id.rvScale);
        IIX0o.oO(findViewById2, "findViewById(...)");
        RecyclerView recyclerView2 = (RecyclerView) findViewById2;
        this.f21422xxIXOIIO = recyclerView2;
        View findViewById3 = xxIXOIIO().findViewById(R.id.confirmButton);
        IIX0o.oO(findViewById3, "findViewById(...)");
        Button button = (Button) findViewById3;
        this.f21421xoIox = button;
        button.setVisibility(8);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        linearLayoutManager.setOrientation(0);
        recyclerView.setLayoutManager(linearLayoutManager);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(activity);
        linearLayoutManager2.setOrientation(0);
        recyclerView2.setLayoutManager(linearLayoutManager2);
        recyclerView.setAdapter(new AnonymousClass3(activity, pointers, callback));
        recyclerView2.setAdapter(new AnonymousClass4(activity, scales, callback));
    }

    @OOXIXo
    public final Button O0xOxO() {
        return this.f21421xoIox;
    }

    @OOXIXo
    public final RecyclerView X0IIOO() {
        return this.f21420II0XooXoX;
    }

    @OOXIXo
    public final RecyclerView XI0IXoo() {
        return this.f21422xxIXOIIO;
    }
}
