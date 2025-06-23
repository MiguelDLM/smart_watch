package com.sma.smartv3.ui.sport.course;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;
import com.bestmafen.androidbase.base.BaseFragment;
import com.sma.smartv3.co_fit.R;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;

/* loaded from: classes12.dex */
public final class DetailIntroduceFragment extends BaseFragment {

    @OXOo.OOXIXo
    private final X0IIOO mDetailIntroduce$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.course.DetailIntroduceFragment$mDetailIntroduce$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = DetailIntroduceFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.course_detail_introduce);
        }
    });

    private final TextView getMDetailIntroduce() {
        return (TextView) this.mDetailIntroduce$delegate.getValue();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        TextView mDetailIntroduce = getMDetailIntroduce();
        if (mDetailIntroduce != null) {
            mDetailIntroduce.setText(Html.fromHtml(getMArg0()));
        }
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.course_fragment_detail_introduce;
    }
}
