package com.sma.smartv3.ui.ai;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.entity.AIRecords;
import com.sma.smartv3.model.AIRecordsViewData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class AIRecordsDetailActivity extends AIRecordsActivity {

    @OXOo.OOXIXo
    private final X0IIOO abhTitleRight$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.ai.AIRecordsDetailActivity$abhTitleRight$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) AIRecordsDetailActivity.this.findViewById(R.id.abh_title_right);
        }
    });
    public AIRecordsViewData mAIRecordsViewData;

    public AIRecordsDetailActivity() {
        setShowItemClick(false);
    }

    private final ImageView getAbhTitleRight() {
        return (ImageView) this.abhTitleRight$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final AIRecordsViewData getMAIRecordsViewData() {
        AIRecordsViewData aIRecordsViewData = this.mAIRecordsViewData;
        if (aIRecordsViewData != null) {
            return aIRecordsViewData;
        }
        IIX0o.XOxIOxOx("mAIRecordsViewData");
        return null;
    }

    @Override // com.sma.smartv3.ui.ai.AIRecordsActivity, com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
        Serializable mArg3 = getMArg3();
        IIX0o.x0XOIxOo(mArg3, "null cannot be cast to non-null type com.sma.smartv3.model.AIRecordsViewData");
        setMAIRecordsViewData((AIRecordsViewData) mArg3);
    }

    @Override // com.sma.smartv3.ui.ai.AIRecordsActivity
    @OXOo.OOXIXo
    public List<AIRecordsViewData> initList() {
        setMAdapterData(new ArrayList());
        getMAdapterData().add(getMAIRecordsViewData());
        return getMAdapterData();
    }

    @Override // com.sma.smartv3.ui.ai.AIRecordsActivity, com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        TextView textView = (TextView) findViewById(R.id.abh_title_center);
        if (textView != null) {
            textView.setText(R.string.history_record);
        }
        getAbhTitleRight().setVisibility(0);
        getAbhTitleRight().setImageResource(R.drawable.ai_answer_clean_icon);
        getAbhTitleRight().setImageTintList(oIxOXo.oxoX.X0o0xo(this, R.color.text_color));
    }

    @Override // com.sma.smartv3.ui.ai.AIRecordsActivity, com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_ai_records_detail;
    }

    public final void onBottomClick(@OXOo.OOXIXo View view) {
        String str;
        IIX0o.x0xO0oo(view, "view");
        StringBuilder sb = new StringBuilder();
        sb.append(getString(R.string.problem));
        sb.append(" : ");
        AIRecords first = getMAIRecordsViewData().getFirst();
        String str2 = null;
        if (first != null) {
            str = first.getMContent();
        } else {
            str = null;
        }
        sb.append(str);
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(getString(R.string.generate_results));
        sb3.append(" : ");
        AIRecords last = getMAIRecordsViewData().getLast();
        if (last != null) {
            str2 = last.getMContent();
        }
        sb3.append(str2);
        share(sb2 + "\n\n" + sb3.toString());
    }

    @Override // com.sma.smartv3.ui.ai.AIRecordsActivity
    public void onTitleRightClick(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        AIRecords first = getMAIRecordsViewData().getFirst();
        IIX0o.ooOOo0oXI(first);
        AIRecords last = getMAIRecordsViewData().getLast();
        IIX0o.ooOOo0oXI(last);
        showDeletePopup(first, last, 0);
    }

    @Override // com.sma.smartv3.ui.ai.AIRecordsActivity, com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity
    public int recyclerViewId() {
        return R.id.rv;
    }

    @Override // com.sma.smartv3.ui.ai.AIRecordsActivity, com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity
    public int refreshLayoutId() {
        return R.id.srf;
    }

    public final void setMAIRecordsViewData(@OXOo.OOXIXo AIRecordsViewData aIRecordsViewData) {
        IIX0o.x0xO0oo(aIRecordsViewData, "<set-?>");
        this.mAIRecordsViewData = aIRecordsViewData;
    }
}
