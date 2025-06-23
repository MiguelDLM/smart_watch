package com.sma.smartv3.ui.sport.course;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter;
import com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder;
import com.bestmafen.androidbase.base.BaseActivity;
import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.ImageUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.google.gson.Gson;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.AppUser;
import com.sma.smartv3.model.CourseDetails;
import com.sma.smartv3.model.ProgressMarkers;
import com.sma.smartv3.ui.me.UserInfoActivity;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.view.ImageViewRound;
import com.sma.smartv3.view.text.PFBold;
import com.sma.smartv3.view.text.PFMedium;
import com.szabh.smable3.component.BleCache;
import com.szabh.smable3.entity.BleDeviceInfo;
import java.io.File;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nCompleteCourseActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CompleteCourseActivity.kt\ncom/sma/smartv3/ui/sport/course/CompleteCourseActivity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n*L\n1#1,252:1\n19#2:253\n15#2:254\n1#3:255\n1#3:259\n69#4,3:256\n72#4,5:260\n*S KotlinDebug\n*F\n+ 1 CompleteCourseActivity.kt\ncom/sma/smartv3/ui/sport/course/CompleteCourseActivity\n*L\n125#1:253\n125#1:254\n123#1:259\n123#1:256,3\n123#1:260,5\n*E\n"})
/* loaded from: classes12.dex */
public final class CompleteCourseActivity extends BaseActivity {
    private CourseDetails mCourseDetails;
    private final int mFeel;

    @OXOo.OOXIXo
    private final X0IIOO abhTitleRight$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.sport.course.CompleteCourseActivity$abhTitleRight$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) CompleteCourseActivity.this.findViewById(R.id.abh_title_right);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mUserAvatar$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageViewRound>() { // from class: com.sma.smartv3.ui.sport.course.CompleteCourseActivity$mUserAvatar$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageViewRound invoke() {
            return (ImageViewRound) CompleteCourseActivity.this.findViewById(R.id.iv_avatar);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mUserNickname$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.sport.course.CompleteCourseActivity$mUserNickname$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) CompleteCourseActivity.this.findViewById(R.id.tv_nickname);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mDateTime$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.sport.course.CompleteCourseActivity$mDateTime$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) CompleteCourseActivity.this.findViewById(R.id.tv_timne);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mRelativeLayout$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RelativeLayout>() { // from class: com.sma.smartv3.ui.sport.course.CompleteCourseActivity$mRelativeLayout$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RelativeLayout invoke() {
            return (RelativeLayout) CompleteCourseActivity.this.findViewById(R.id.course_details_pic_layout);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mRoundPicImage$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageViewRound>() { // from class: com.sma.smartv3.ui.sport.course.CompleteCourseActivity$mRoundPicImage$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageViewRound invoke() {
            return (ImageViewRound) CompleteCourseActivity.this.findViewById(R.id.course_details_pic);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mCourseName$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFBold>() { // from class: com.sma.smartv3.ui.sport.course.CompleteCourseActivity$mCourseName$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFBold invoke() {
            return (PFBold) CompleteCourseActivity.this.findViewById(R.id.course_details_name);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mCourseDiff$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.sport.course.CompleteCourseActivity$mCourseDiff$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) CompleteCourseActivity.this.findViewById(R.id.course_details_diff);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mCourseTime$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.sport.course.CompleteCourseActivity$mCourseTime$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) CompleteCourseActivity.this.findViewById(R.id.course_details_time);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mCourseHeat$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.sport.course.CompleteCourseActivity$mCourseHeat$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) CompleteCourseActivity.this.findViewById(R.id.course_details_heat);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mCourseNumber$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.sport.course.CompleteCourseActivity$mCourseNumber$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) CompleteCourseActivity.this.findViewById(R.id.course_name_number);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mRecyclerView$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RecyclerView>() { // from class: com.sma.smartv3.ui.sport.course.CompleteCourseActivity$mRecyclerView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RecyclerView invoke() {
            return (RecyclerView) CompleteCourseActivity.this.findViewById(R.id.course_recycler);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mTrainingExperience$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.sport.course.CompleteCourseActivity$mTrainingExperience$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            return (LinearLayout) CompleteCourseActivity.this.findViewById(R.id.training_experience_layout);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mTrainingExperienceSelect$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.sport.course.CompleteCourseActivity$mTrainingExperienceSelect$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            return (LinearLayout) CompleteCourseActivity.this.findViewById(R.id.training_experience_layout_select);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mTrainingExperienceSelect1$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.sport.course.CompleteCourseActivity$mTrainingExperienceSelect1$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            return (LinearLayout) CompleteCourseActivity.this.findViewById(R.id.training_experience_layout_1);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mTrainingExperienceSelect2$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.sport.course.CompleteCourseActivity$mTrainingExperienceSelect2$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            return (LinearLayout) CompleteCourseActivity.this.findViewById(R.id.training_experience_layout_2);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mTrainingExperienceSelect3$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.sport.course.CompleteCourseActivity$mTrainingExperienceSelect3$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            return (LinearLayout) CompleteCourseActivity.this.findViewById(R.id.training_experience_layout_3);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mTrainingExperienceSelect4$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.sport.course.CompleteCourseActivity$mTrainingExperienceSelect4$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            return (LinearLayout) CompleteCourseActivity.this.findViewById(R.id.training_experience_layout_4);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mTrainingExperienceSelect5$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.sport.course.CompleteCourseActivity$mTrainingExperienceSelect5$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            return (LinearLayout) CompleteCourseActivity.this.findViewById(R.id.training_experience_layout_5);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mTrainingExperienceResult$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.sport.course.CompleteCourseActivity$mTrainingExperienceResult$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            return (LinearLayout) CompleteCourseActivity.this.findViewById(R.id.training_experience_layout_result);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mTrainingExperienceResultImg$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.sport.course.CompleteCourseActivity$mTrainingExperienceResultImg$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) CompleteCourseActivity.this.findViewById(R.id.training_experience_img_result);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mTrainingExperienceResultTv$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.course.CompleteCourseActivity$mTrainingExperienceResultTv$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) CompleteCourseActivity.this.findViewById(R.id.training_experience_tv_result);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mDeviceSources$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.sport.course.CompleteCourseActivity$mDeviceSources$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            return (LinearLayout) CompleteCourseActivity.this.findViewById(R.id.device_sources);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mDeviceImg$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.sport.course.CompleteCourseActivity$mDeviceImg$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) CompleteCourseActivity.this.findViewById(R.id.device_img);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mDeviceName$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.course.CompleteCourseActivity$mDeviceName$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) CompleteCourseActivity.this.findViewById(R.id.device_name);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mDeviceQRCode$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.sport.course.CompleteCourseActivity$mDeviceQRCode$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) CompleteCourseActivity.this.findViewById(R.id.device_qr_code);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mDeviceQRCodeLayout$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LinearLayout>() { // from class: com.sma.smartv3.ui.sport.course.CompleteCourseActivity$mDeviceQRCodeLayout$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LinearLayout invoke() {
            return (LinearLayout) CompleteCourseActivity.this.findViewById(R.id.device_qr_code_ll);
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
            CompleteCourseActivity.this.setLayoutHeight(resource.getWidth(), resource.getHeight());
            CompleteCourseActivity.this.getMRoundPicImage().setImageBitmap(resource);
        }
    }

    private final void avatarShow() {
        getMUserAvatar().setImageDrawable(oIxOXo.oxoX.Oxx0IOOO(getMUserAvatar().getContext(), R.drawable.pic_avatar_default));
        X00IoxXI.oIX0oI oix0oi = X00IoxXI.oIX0oI.f3233oIX0oI;
        if (com.sma.smartv3.initializer.IXxxXO.xxIXOIIO(oix0oi).exists()) {
            getMUserAvatar().setImageURI(Uri.fromFile(com.sma.smartv3.initializer.IXxxXO.xxIXOIIO(oix0oi)));
        }
    }

    private final ImageView getAbhTitleRight() {
        return (ImageView) this.abhTitleRight$delegate.getValue();
    }

    private final PFMedium getMDateTime() {
        return (PFMedium) this.mDateTime$delegate.getValue();
    }

    private final ImageView getMDeviceImg() {
        return (ImageView) this.mDeviceImg$delegate.getValue();
    }

    private final TextView getMDeviceName() {
        return (TextView) this.mDeviceName$delegate.getValue();
    }

    private final ImageView getMDeviceQRCode() {
        return (ImageView) this.mDeviceQRCode$delegate.getValue();
    }

    private final LinearLayout getMDeviceQRCodeLayout() {
        return (LinearLayout) this.mDeviceQRCodeLayout$delegate.getValue();
    }

    private final LinearLayout getMDeviceSources() {
        return (LinearLayout) this.mDeviceSources$delegate.getValue();
    }

    private final LinearLayout getMTrainingExperience() {
        return (LinearLayout) this.mTrainingExperience$delegate.getValue();
    }

    private final LinearLayout getMTrainingExperienceResult() {
        return (LinearLayout) this.mTrainingExperienceResult$delegate.getValue();
    }

    private final ImageView getMTrainingExperienceResultImg() {
        return (ImageView) this.mTrainingExperienceResultImg$delegate.getValue();
    }

    private final TextView getMTrainingExperienceResultTv() {
        return (TextView) this.mTrainingExperienceResultTv$delegate.getValue();
    }

    private final LinearLayout getMTrainingExperienceSelect() {
        return (LinearLayout) this.mTrainingExperienceSelect$delegate.getValue();
    }

    private final LinearLayout getMTrainingExperienceSelect1() {
        return (LinearLayout) this.mTrainingExperienceSelect1$delegate.getValue();
    }

    private final LinearLayout getMTrainingExperienceSelect2() {
        return (LinearLayout) this.mTrainingExperienceSelect2$delegate.getValue();
    }

    private final LinearLayout getMTrainingExperienceSelect3() {
        return (LinearLayout) this.mTrainingExperienceSelect3$delegate.getValue();
    }

    private final LinearLayout getMTrainingExperienceSelect4() {
        return (LinearLayout) this.mTrainingExperienceSelect4$delegate.getValue();
    }

    private final LinearLayout getMTrainingExperienceSelect5() {
        return (LinearLayout) this.mTrainingExperienceSelect5$delegate.getValue();
    }

    private final ImageViewRound getMUserAvatar() {
        return (ImageViewRound) this.mUserAvatar$delegate.getValue();
    }

    private final PFMedium getMUserNickname() {
        return (PFMedium) this.mUserNickname$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(CompleteCourseActivity this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.startActivity(new Intent(this$0, (Class<?>) UserInfoActivity.class));
    }

    private final void setTrainingExperience(int i) {
        findViewById(R.id.training_experience_hint_tv).setVisibility(8);
        getMTrainingExperienceSelect().setVisibility(8);
        getMTrainingExperienceResult().setVisibility(0);
        getMTrainingExperienceResultImg().setImageResource(getTrainingExperienceImage(this, i));
        getMTrainingExperienceResultTv().setText(getString(getTrainingExperienceName(this, i)));
        getMTrainingExperience().setBackgroundResource(R.drawable.ripple_training_experience_bg);
    }

    private final void trainingExperienceSelect() {
        int i = this.mFeel;
        if (i > 0) {
            setTrainingExperience(i);
            return;
        }
        getMTrainingExperienceSelect().setVisibility(0);
        getMTrainingExperienceResult().setVisibility(8);
        getMTrainingExperienceSelect1().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.sport.course.ooOOo0oXI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CompleteCourseActivity.trainingExperienceSelect$lambda$2(CompleteCourseActivity.this, view);
            }
        });
        getMTrainingExperienceSelect2().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.sport.course.x0XOIxOo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CompleteCourseActivity.trainingExperienceSelect$lambda$3(CompleteCourseActivity.this, view);
            }
        });
        getMTrainingExperienceSelect3().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.sport.course.oO
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CompleteCourseActivity.trainingExperienceSelect$lambda$4(CompleteCourseActivity.this, view);
            }
        });
        getMTrainingExperienceSelect4().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.sport.course.x0xO0oo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CompleteCourseActivity.trainingExperienceSelect$lambda$5(CompleteCourseActivity.this, view);
            }
        });
        getMTrainingExperienceSelect5().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.sport.course.IXxxXO
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CompleteCourseActivity.trainingExperienceSelect$lambda$6(CompleteCourseActivity.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void trainingExperienceSelect$lambda$2(CompleteCourseActivity this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.trainingSelectListener(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void trainingExperienceSelect$lambda$3(CompleteCourseActivity this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.trainingSelectListener(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void trainingExperienceSelect$lambda$4(CompleteCourseActivity this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.trainingSelectListener(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void trainingExperienceSelect$lambda$5(CompleteCourseActivity this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.trainingSelectListener(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void trainingExperienceSelect$lambda$6(CompleteCourseActivity this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.trainingSelectListener(5);
    }

    private final void trainingSelectListener(int i) {
        setTrainingExperience(i);
        com.sma.smartv3.util.x0xO0oo.oIX0oI(com.sma.smartv3.util.x0xO0oo.f24607XI0oooXX, Integer.valueOf(i));
    }

    public final PFMedium getMCourseDiff() {
        return (PFMedium) this.mCourseDiff$delegate.getValue();
    }

    public final PFMedium getMCourseHeat() {
        return (PFMedium) this.mCourseHeat$delegate.getValue();
    }

    public final PFBold getMCourseName() {
        return (PFBold) this.mCourseName$delegate.getValue();
    }

    public final PFMedium getMCourseNumber() {
        return (PFMedium) this.mCourseNumber$delegate.getValue();
    }

    public final PFMedium getMCourseTime() {
        return (PFMedium) this.mCourseTime$delegate.getValue();
    }

    public final int getMFeel() {
        return this.mFeel;
    }

    public final RecyclerView getMRecyclerView() {
        return (RecyclerView) this.mRecyclerView$delegate.getValue();
    }

    public final RelativeLayout getMRelativeLayout() {
        return (RelativeLayout) this.mRelativeLayout$delegate.getValue();
    }

    public final ImageViewRound getMRoundPicImage() {
        return (ImageViewRound) this.mRoundPicImage$delegate.getValue();
    }

    public final int getTrainingExperienceImage(@OXOo.OOXIXo Context mContext, int i) {
        IIX0o.x0xO0oo(mContext, "mContext");
        try {
            return mContext.getResources().getIdentifier("icon_training_experience_" + i, "drawable", mContext.getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
            return R.drawable.icon_training_experience_1;
        }
    }

    public final int getTrainingExperienceName(@OXOo.OOXIXo Context mContext, int i) {
        IIX0o.x0xO0oo(mContext, "mContext");
        try {
            return mContext.getResources().getIdentifier("training_experience_" + i, TypedValues.Custom.S_STRING, mContext.getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
            return R.string.training_experience_1;
        }
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
        Serializable mArg3 = getMArg3();
        IIX0o.x0XOIxOo(mArg3, "null cannot be cast to non-null type com.sma.smartv3.model.CourseDetails");
        this.mCourseDetails = (CourseDetails) mArg3;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        Integer num;
        ((TextView) findViewById(R.id.abh_title_center)).setText("(功能开发中..)");
        getAbhTitleRight().setVisibility(0);
        getAbhTitleRight().setImageResource(R.drawable.icon_course_share);
        getMUserAvatar().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.sport.course.oOoXoXO
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CompleteCourseActivity.initView$lambda$0(CompleteCourseActivity.this, view);
            }
        });
        PFMedium mUserNickname = getMUserNickname();
        SPUtils XO2 = Xo0.f24349oIX0oI.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        if (fromJson != null) {
            appUser = fromJson;
        }
        mUserNickname.setText(((AppUser) appUser).getNickname());
        CourseDetails courseDetails = null;
        getMDateTime().setText(com.sma.smartv3.util.xoIox.oxxXoxO(false, false, 3, null).format(new Date()));
        RequestBuilder<Bitmap> asBitmap = Glide.with(getMRoundPicImage().getContext()).asBitmap();
        CourseDetails courseDetails2 = this.mCourseDetails;
        if (courseDetails2 == null) {
            IIX0o.XOxIOxOx("mCourseDetails");
            courseDetails2 = null;
        }
        asBitmap.load(courseDetails2.getCoursePic1()).into((RequestBuilder<Bitmap>) new oIX0oI());
        PFBold mCourseName = getMCourseName();
        CourseDetails courseDetails3 = this.mCourseDetails;
        if (courseDetails3 == null) {
            IIX0o.XOxIOxOx("mCourseDetails");
            courseDetails3 = null;
        }
        mCourseName.setText(courseDetails3.getCourseName());
        PFMedium mCourseDiff = getMCourseDiff();
        CourseDetails courseDetails4 = this.mCourseDetails;
        if (courseDetails4 == null) {
            IIX0o.XOxIOxOx("mCourseDetails");
            courseDetails4 = null;
        }
        mCourseDiff.setText(courseDetails4.getCourseDiff());
        PFMedium mCourseTime = getMCourseTime();
        StringBuilder sb = new StringBuilder();
        CourseDetails courseDetails5 = this.mCourseDetails;
        if (courseDetails5 == null) {
            IIX0o.XOxIOxOx("mCourseDetails");
            courseDetails5 = null;
        }
        String courseTime = courseDetails5.getCourseTime();
        if (courseTime != null) {
            num = Integer.valueOf(Integer.parseInt(courseTime) / 60);
        } else {
            num = null;
        }
        sb.append(num);
        sb.append("分钟");
        mCourseTime.setText(sb.toString());
        PFMedium mCourseHeat = getMCourseHeat();
        StringBuilder sb2 = new StringBuilder();
        CourseDetails courseDetails6 = this.mCourseDetails;
        if (courseDetails6 == null) {
            IIX0o.XOxIOxOx("mCourseDetails");
            courseDetails6 = null;
        }
        sb2.append(courseDetails6.getCourseHeat());
        sb2.append(getString(R.string.kpa));
        mCourseHeat.setText(sb2.toString());
        PFMedium mCourseNumber = getMCourseNumber();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("课程名称:");
        CourseDetails courseDetails7 = this.mCourseDetails;
        if (courseDetails7 == null) {
            IIX0o.XOxIOxOx("mCourseDetails");
            courseDetails7 = null;
        }
        sb3.append(courseDetails7.getCourseName());
        sb3.append("  第一次完成");
        mCourseNumber.setText(sb3.toString());
        getMRecyclerView().setLayoutManager(new LinearLayoutManager(getMContext(), 1, false));
        final Activity mContext = getMContext();
        CourseDetails courseDetails8 = this.mCourseDetails;
        if (courseDetails8 == null) {
            IIX0o.XOxIOxOx("mCourseDetails");
        } else {
            courseDetails = courseDetails8;
        }
        final List<ProgressMarkers> progressMarkers = courseDetails.getProgressMarkers();
        getMRecyclerView().setAdapter(new CommonAdapter<ProgressMarkers>(mContext, progressMarkers) { // from class: com.sma.smartv3.ui.sport.course.CompleteCourseActivity$initView$mAdapter$1
            @Override // com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter
            public void convert(@OXOo.OOXIXo ViewHolder viewHolder, @OXOo.OOXIXo ProgressMarkers item, int i) {
                IIX0o.x0xO0oo(viewHolder, "viewHolder");
                IIX0o.x0xO0oo(item, "item");
                viewHolder.setText(R.id.course_number, String.valueOf(i + 1));
                viewHolder.setText(R.id.course_action_name, item.getTitle());
                viewHolder.setText(R.id.course_time, com.sma.smartv3.util.xoIox.IoOoo(item.getTime()));
            }
        });
        avatarShow();
        trainingExperienceSelect();
        setDeviceSource();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_course_complete;
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        finish();
    }

    public final void onTitleRightClick(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        ToastUtils.showLong("功能开发中..", new Object[0]);
    }

    public final void setDeviceSource() {
        BleCache bleCache = BleCache.INSTANCE;
        if (bleCache.getMBleName().length() == 0) {
            getMDeviceSources().setVisibility(8);
            return;
        }
        File I0oOIX2 = com.sma.smartv3.initializer.IXxxXO.I0oOIX(X00IoxXI.oIX0oI.f3233oIX0oI, bleCache.getMBleName(), bleCache.getMFirmwareFlag());
        getMDeviceImg().setImageDrawable(getDrawable(ProductManager.f20544oIX0oI.x0XOIxOo(new BleDeviceInfo(0, null, bleCache.getMBleName(), null, null, null, bleCache.getMPrototype(), bleCache.getMFirmwareFlag(), 0, 0L, 0, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -197, -1, -1, oI00o.XO.f31358oIX0oI, null))));
        if (FileUtils.isFileExists(I0oOIX2)) {
            getMDeviceImg().setImageBitmap(ImageUtils.getBitmap(I0oOIX2));
        }
        getMDeviceName().setText(bleCache.getMBleName());
    }

    public final void setLayoutHeight(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = getMRelativeLayout().getLayoutParams();
        layoutParams.height = ((ScreenUtils.getAppScreenWidth() - SizeUtils.dp2px(30.0f)) * i2) / i;
        getMRelativeLayout().setLayoutParams(layoutParams);
    }
}
