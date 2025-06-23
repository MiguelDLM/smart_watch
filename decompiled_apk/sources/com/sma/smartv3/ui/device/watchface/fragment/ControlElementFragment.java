package com.sma.smartv3.ui.device.watchface.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.ResourcesIdInfo;
import java.util.Iterator;
import java.util.List;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nControlElementFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ControlElementFragment.kt\ncom/sma/smartv3/ui/device/watchface/fragment/ControlElementFragment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,100:1\n1855#2,2:101\n*S KotlinDebug\n*F\n+ 1 ControlElementFragment.kt\ncom/sma/smartv3/ui/device/watchface/fragment/ControlElementFragment\n*L\n96#1:101,2\n*E\n"})
/* loaded from: classes12.dex */
public class ControlElementFragment extends BaseElementFragment {

    @OXOo.OOXIXo
    private final XO<Integer> callback;

    @OXOo.OOXIXo
    private final List<ResourcesIdInfo> colors;

    @OXOo.OOXIXo
    private final X0IIOO dialSelect0$delegate;

    @OXOo.OOXIXo
    private final X0IIOO dialSelect1$delegate;

    @OXOo.OOXIXo
    private final X0IIOO dialSelect2$delegate;

    @OXOo.OOXIXo
    private final X0IIOO dialSelect3$delegate;

    @OXOo.OOXIXo
    private final X0IIOO dialSelectStatus0$delegate;

    @OXOo.OOXIXo
    private final X0IIOO dialSelectStatus1$delegate;

    @OXOo.OOXIXo
    private final X0IIOO dialSelectStatus2$delegate;

    @OXOo.OOXIXo
    private final X0IIOO dialSelectStatus3$delegate;
    private final boolean isRound;

    @OXOo.OOXIXo
    private final X0IIOO ivDialSelect0$delegate;

    @OXOo.OOXIXo
    private final X0IIOO ivDialSelect1$delegate;

    @OXOo.OOXIXo
    private final X0IIOO ivDialSelect2$delegate;

    @OXOo.OOXIXo
    private final X0IIOO ivDialSelect3$delegate;

    @OXOo.OOXIXo
    private final X0IIOO rv$delegate;

    public ControlElementFragment(@OXOo.OOXIXo List<ResourcesIdInfo> colors, boolean z, @OXOo.OOXIXo XO<Integer> callback) {
        IIX0o.x0xO0oo(colors, "colors");
        IIX0o.x0xO0oo(callback, "callback");
        this.colors = colors;
        this.isRound = z;
        this.callback = callback;
        this.rv$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RecyclerView>() { // from class: com.sma.smartv3.ui.device.watchface.fragment.ControlElementFragment$rv$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final RecyclerView invoke() {
                View mView;
                mView = ControlElementFragment.this.getMView();
                return (RecyclerView) mView.findViewById(R.id.rv);
            }
        });
        this.dialSelect0$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.device.watchface.fragment.ControlElementFragment$dialSelect0$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final LinearLayout invoke() {
                View mView;
                mView = ControlElementFragment.this.getMView();
                return (LinearLayout) mView.findViewById(R.id.dialSelect0);
            }
        });
        this.dialSelect1$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.device.watchface.fragment.ControlElementFragment$dialSelect1$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final LinearLayout invoke() {
                View mView;
                mView = ControlElementFragment.this.getMView();
                return (LinearLayout) mView.findViewById(R.id.dialSelect1);
            }
        });
        this.dialSelect2$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.device.watchface.fragment.ControlElementFragment$dialSelect2$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final LinearLayout invoke() {
                View mView;
                mView = ControlElementFragment.this.getMView();
                return (LinearLayout) mView.findViewById(R.id.dialSelect2);
            }
        });
        this.dialSelect3$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.device.watchface.fragment.ControlElementFragment$dialSelect3$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final LinearLayout invoke() {
                View mView;
                mView = ControlElementFragment.this.getMView();
                return (LinearLayout) mView.findViewById(R.id.dialSelect3);
            }
        });
        this.dialSelectStatus0$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.device.watchface.fragment.ControlElementFragment$dialSelectStatus0$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final ImageView invoke() {
                View mView;
                mView = ControlElementFragment.this.getMView();
                return (ImageView) mView.findViewById(R.id.dialSelectStatus0);
            }
        });
        this.dialSelectStatus1$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.device.watchface.fragment.ControlElementFragment$dialSelectStatus1$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final ImageView invoke() {
                View mView;
                mView = ControlElementFragment.this.getMView();
                return (ImageView) mView.findViewById(R.id.dialSelectStatus1);
            }
        });
        this.dialSelectStatus2$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.device.watchface.fragment.ControlElementFragment$dialSelectStatus2$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final ImageView invoke() {
                View mView;
                mView = ControlElementFragment.this.getMView();
                return (ImageView) mView.findViewById(R.id.dialSelectStatus2);
            }
        });
        this.dialSelectStatus3$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.device.watchface.fragment.ControlElementFragment$dialSelectStatus3$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final ImageView invoke() {
                View mView;
                mView = ControlElementFragment.this.getMView();
                return (ImageView) mView.findViewById(R.id.dialSelectStatus3);
            }
        });
        this.ivDialSelect0$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.device.watchface.fragment.ControlElementFragment$ivDialSelect0$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final ImageView invoke() {
                View mView;
                mView = ControlElementFragment.this.getMView();
                return (ImageView) mView.findViewById(R.id.ivDialSelect0);
            }
        });
        this.ivDialSelect1$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.device.watchface.fragment.ControlElementFragment$ivDialSelect1$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final ImageView invoke() {
                View mView;
                mView = ControlElementFragment.this.getMView();
                return (ImageView) mView.findViewById(R.id.ivDialSelect1);
            }
        });
        this.ivDialSelect2$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.device.watchface.fragment.ControlElementFragment$ivDialSelect2$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final ImageView invoke() {
                View mView;
                mView = ControlElementFragment.this.getMView();
                return (ImageView) mView.findViewById(R.id.ivDialSelect2);
            }
        });
        this.ivDialSelect3$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.device.watchface.fragment.ControlElementFragment$ivDialSelect3$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final ImageView invoke() {
                View mView;
                mView = ControlElementFragment.this.getMView();
                return (ImageView) mView.findViewById(R.id.ivDialSelect3);
            }
        });
    }

    private final RecyclerView getRv() {
        return (RecyclerView) this.rv$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(ControlElementFragment this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        View.OnClickListener mOnViewClickListener = this$0.getMOnViewClickListener();
        if (mOnViewClickListener != null) {
            mOnViewClickListener.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(ControlElementFragment this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        View.OnClickListener mOnViewClickListener = this$0.getMOnViewClickListener();
        if (mOnViewClickListener != null) {
            mOnViewClickListener.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(ControlElementFragment this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        View.OnClickListener mOnViewClickListener = this$0.getMOnViewClickListener();
        if (mOnViewClickListener != null) {
            mOnViewClickListener.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4(ControlElementFragment this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        View.OnClickListener mOnViewClickListener = this$0.getMOnViewClickListener();
        if (mOnViewClickListener != null) {
            mOnViewClickListener.onClick(view);
        }
    }

    @OXOo.OOXIXo
    public final XO<Integer> getCallback() {
        return this.callback;
    }

    @OXOo.OOXIXo
    public final List<ResourcesIdInfo> getColors() {
        return this.colors;
    }

    public final LinearLayout getDialSelect0() {
        return (LinearLayout) this.dialSelect0$delegate.getValue();
    }

    public final LinearLayout getDialSelect1() {
        return (LinearLayout) this.dialSelect1$delegate.getValue();
    }

    public final LinearLayout getDialSelect2() {
        return (LinearLayout) this.dialSelect2$delegate.getValue();
    }

    public final LinearLayout getDialSelect3() {
        return (LinearLayout) this.dialSelect3$delegate.getValue();
    }

    public final ImageView getDialSelectStatus0() {
        return (ImageView) this.dialSelectStatus0$delegate.getValue();
    }

    public final ImageView getDialSelectStatus1() {
        return (ImageView) this.dialSelectStatus1$delegate.getValue();
    }

    public final ImageView getDialSelectStatus2() {
        return (ImageView) this.dialSelectStatus2$delegate.getValue();
    }

    public final ImageView getDialSelectStatus3() {
        return (ImageView) this.dialSelectStatus3$delegate.getValue();
    }

    public final ImageView getIvDialSelect0() {
        return (ImageView) this.ivDialSelect0$delegate.getValue();
    }

    public final ImageView getIvDialSelect1() {
        return (ImageView) this.ivDialSelect1$delegate.getValue();
    }

    public final ImageView getIvDialSelect2() {
        return (ImageView) this.ivDialSelect2$delegate.getValue();
    }

    public final ImageView getIvDialSelect3() {
        return (ImageView) this.ivDialSelect3$delegate.getValue();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        if (this.isRound) {
            getIvDialSelect0().setBackgroundResource(R.drawable.shape_dial_control_bg);
            getIvDialSelect1().setBackgroundResource(R.drawable.shape_dial_control_bg);
            getIvDialSelect2().setBackgroundResource(R.drawable.shape_dial_control_bg);
            getIvDialSelect3().setBackgroundResource(R.drawable.shape_dial_control_bg);
        } else {
            getIvDialSelect0().setBackgroundResource(R.drawable.shape_dial_control_bg_r);
            getIvDialSelect1().setBackgroundResource(R.drawable.shape_dial_control_bg_r);
            getIvDialSelect2().setBackgroundResource(R.drawable.shape_dial_control_bg_r);
            getIvDialSelect3().setBackgroundResource(R.drawable.shape_dial_control_bg_r);
        }
        RecyclerView rv = getRv();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(0);
        rv.setLayoutManager(linearLayoutManager);
        getRv().setAdapter(new ControlElementFragment$initView$2(this, getActivity(), this.colors));
        getDialSelect0().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.watchface.fragment.oIX0oI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ControlElementFragment.initView$lambda$1(ControlElementFragment.this, view);
            }
        });
        getDialSelect1().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.watchface.fragment.II0xO0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ControlElementFragment.initView$lambda$2(ControlElementFragment.this, view);
            }
        });
        getDialSelect2().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.watchface.fragment.I0Io
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ControlElementFragment.initView$lambda$3(ControlElementFragment.this, view);
            }
        });
        getDialSelect3().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.watchface.fragment.oxoX
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ControlElementFragment.initView$lambda$4(ControlElementFragment.this, view);
            }
        });
    }

    public final boolean isRound() {
        return this.isRound;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.layout_watchface_control;
    }

    @Override // com.sma.smartv3.ui.device.watchface.fragment.BaseElementFragment
    public void reset() {
        RecyclerView.Adapter adapter = getRv().getAdapter();
        IIX0o.x0XOIxOo(adapter, "null cannot be cast to non-null type com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter<com.sma.smartv3.model.ResourcesIdInfo>");
        CommonAdapter commonAdapter = (CommonAdapter) adapter;
        Iterable datas = commonAdapter.getDatas();
        IIX0o.oO(datas, "getDatas(...)");
        Iterator it = datas.iterator();
        while (it.hasNext()) {
            ((ResourcesIdInfo) it.next()).setSelect(false);
        }
        commonAdapter.notifyDataSetChanged();
    }
}
