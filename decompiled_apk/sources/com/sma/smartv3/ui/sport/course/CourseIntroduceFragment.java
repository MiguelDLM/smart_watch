package com.sma.smartv3.ui.sport.course;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bestmafen.androidbase.base.BaseFragment;
import com.blankj.utilcode.util.ScreenUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.ProgressMarkers;
import java.io.Serializable;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class CourseIntroduceFragment extends BaseFragment {
    private ProgressMarkers mProgressMarkers;

    @OXOo.OOXIXo
    private final X0IIOO mRoundPicImage$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.sport.course.CourseIntroduceFragment$mRoundPicImage$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            View mView;
            mView = CourseIntroduceFragment.this.getMView();
            return (ImageView) mView.findViewById(R.id.item_special_course_pic);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mTitleTextView$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.course.CourseIntroduceFragment$mTitleTextView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = CourseIntroduceFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.item_special_course_title);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mIntroduceTextView$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.course.CourseIntroduceFragment$mIntroduceTextView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = CourseIntroduceFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.item_special_course_introduce);
        }
    });

    /* loaded from: classes12.dex */
    public static final class oIX0oI extends SimpleTarget<Bitmap> {
        public oIX0oI() {
        }

        @Override // com.bumptech.glide.request.target.Target
        public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
            onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
        }

        public void onResourceReady(@OXOo.OOXIXo Bitmap resource, @OXOo.oOoXoXO Transition<? super Bitmap> transition) {
            IIX0o.x0xO0oo(resource, "resource");
            CourseIntroduceFragment.this.setLayoutHeight(resource.getWidth(), resource.getHeight());
            CourseIntroduceFragment.this.getMRoundPicImage().setImageBitmap(resource);
        }
    }

    public final TextView getMIntroduceTextView() {
        return (TextView) this.mIntroduceTextView$delegate.getValue();
    }

    public final ImageView getMRoundPicImage() {
        return (ImageView) this.mRoundPicImage$delegate.getValue();
    }

    public final TextView getMTitleTextView() {
        return (TextView) this.mTitleTextView$delegate.getValue();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
        Serializable mArg3 = getMArg3();
        IIX0o.x0XOIxOo(mArg3, "null cannot be cast to non-null type com.sma.smartv3.model.ProgressMarkers");
        this.mProgressMarkers = (ProgressMarkers) mArg3;
    }

    public final void initImage() {
        RequestBuilder<Bitmap> asBitmap = Glide.with(getMRoundPicImage().getContext()).asBitmap();
        ProgressMarkers progressMarkers = this.mProgressMarkers;
        if (progressMarkers == null) {
            IIX0o.XOxIOxOx("mProgressMarkers");
            progressMarkers = null;
        }
        asBitmap.load(progressMarkers.getCoverUrl()).into((RequestBuilder<Bitmap>) new oIX0oI());
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        initImage();
        TextView mTitleTextView = getMTitleTextView();
        ProgressMarkers progressMarkers = this.mProgressMarkers;
        ProgressMarkers progressMarkers2 = null;
        if (progressMarkers == null) {
            IIX0o.XOxIOxOx("mProgressMarkers");
            progressMarkers = null;
        }
        mTitleTextView.setText(progressMarkers.getTitle());
        TextView mIntroduceTextView = getMIntroduceTextView();
        ProgressMarkers progressMarkers3 = this.mProgressMarkers;
        if (progressMarkers3 == null) {
            IIX0o.XOxIOxOx("mProgressMarkers");
        } else {
            progressMarkers2 = progressMarkers3;
        }
        mIntroduceTextView.setText(Html.fromHtml(progressMarkers2.getDescribe()));
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.fragment_course_introduce;
    }

    public final void setLayoutHeight(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = getMRoundPicImage().getLayoutParams();
        layoutParams.height = (ScreenUtils.getAppScreenWidth() * i2) / i;
        getMRoundPicImage().setLayoutParams(layoutParams);
    }
}
