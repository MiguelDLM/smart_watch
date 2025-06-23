package com.sma.smartv3.ui.sport.course;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.bestmafen.androidbase.base.BaseActivity;
import com.bestmafen.androidbase.base.BaseFragment;
import com.bestmafen.androidbase.viewpager.BaseFragmentPagerAdapter;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.sma.smartv3.biz.CourseManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.AppUser;
import com.sma.smartv3.model.CourseDetails;
import com.sma.smartv3.model.ProgressMarkers;
import com.sma.smartv3.model.VideoFile;
import com.sma.smartv3.network.Api;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.view.text.PFMedium;
import java.io.File;
import java.util.List;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nCourseDetailsActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CourseDetailsActivity.kt\ncom/sma/smartv3/ui/sport/course/CourseDetailsActivity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 BaseFragment.kt\ncom/bestmafen/androidbase/base/BaseFragment$Companion\n*L\n1#1,263:1\n19#2:264\n15#2:265\n87#3,7:266\n94#3,3:274\n70#3,7:277\n97#3:284\n1#4:273\n1#4:294\n1#4:310\n80#5,9:285\n89#5,3:295\n75#5,3:298\n80#5,9:301\n89#5,3:311\n75#5,3:314\n*S KotlinDebug\n*F\n+ 1 CourseDetailsActivity.kt\ncom/sma/smartv3/ui/sport/course/CourseDetailsActivity\n*L\n63#1:264\n63#1:265\n240#1:266,7\n240#1:274,3\n240#1:277,7\n240#1:284\n240#1:273\n258#1:294\n259#1:310\n258#1:285,9\n258#1:295,3\n258#1:298,3\n259#1:301,9\n259#1:311,3\n259#1:314,3\n*E\n"})
/* loaded from: classes12.dex */
public final class CourseDetailsActivity extends BaseActivity implements com.bestmafen.androidbase.viewpager.oIX0oI {
    private boolean courseCollect;
    private boolean isButtonClick;
    private boolean isDownload;

    @OXOo.oOoXoXO
    private CourseDetails mCourseDetails;
    protected BaseFragmentPagerAdapter mFragmentPagerAdapter;
    protected ViewPager mViewPager;
    private int widthPixels;

    @OXOo.OOXIXo
    private final X0IIOO table$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TabLayout>() { // from class: com.sma.smartv3.ui.sport.course.CourseDetailsActivity$table$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TabLayout invoke() {
            return (TabLayout) CourseDetailsActivity.this.findViewById(R.id.table);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mCardViewLayout$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<CardView>() { // from class: com.sma.smartv3.ui.sport.course.CourseDetailsActivity$mCardViewLayout$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final CardView invoke() {
            return (CardView) CourseDetailsActivity.this.findViewById(R.id.course_cardView);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mRoundPicImage$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.sport.course.CourseDetailsActivity$mRoundPicImage$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) CourseDetailsActivity.this.findViewById(R.id.course_details_pic);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO abhTitleRight$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.sport.course.CourseDetailsActivity$abhTitleRight$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) CourseDetailsActivity.this.findViewById(R.id.abh_title_right);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO abhTitleOtherRight$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.sport.course.CourseDetailsActivity$abhTitleOtherRight$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) CourseDetailsActivity.this.findViewById(R.id.abh_title_other_right);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mCourseName$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.course.CourseDetailsActivity$mCourseName$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) CourseDetailsActivity.this.findViewById(R.id.course_details_name);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mCourseDiff$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.sport.course.CourseDetailsActivity$mCourseDiff$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) CourseDetailsActivity.this.findViewById(R.id.course_details_diff);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mCourseTime$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.sport.course.CourseDetailsActivity$mCourseTime$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) CourseDetailsActivity.this.findViewById(R.id.course_details_time);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mCourseHeat$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.sport.course.CourseDetailsActivity$mCourseHeat$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) CourseDetailsActivity.this.findViewById(R.id.course_details_heat);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mCourseDetailsHot$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.sport.course.CourseDetailsActivity$mCourseDetailsHot$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) CourseDetailsActivity.this.findViewById(R.id.course_details_hot);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mButton$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<Button>() { // from class: com.sma.smartv3.ui.sport.course.CourseDetailsActivity$mButton$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final Button invoke() {
            return (Button) CourseDetailsActivity.this.findViewById(R.id.course_details_btn);
        }
    });

    @OXOo.OOXIXo
    private String mIdentity = "";

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
            CourseDetailsActivity.this.setLayoutHeight(resource.getWidth(), resource.getHeight());
            CourseDetailsActivity.this.getMRoundPicImage().setImageBitmap(resource);
        }
    }

    private final ImageView getAbhTitleOtherRight() {
        return (ImageView) this.abhTitleOtherRight$delegate.getValue();
    }

    private final ImageView getAbhTitleRight() {
        return (ImageView) this.abhTitleRight$delegate.getValue();
    }

    public final boolean getCourseCollect() {
        return this.courseCollect;
    }

    public final Button getMButton() {
        return (Button) this.mButton$delegate.getValue();
    }

    public final CardView getMCardViewLayout() {
        return (CardView) this.mCardViewLayout$delegate.getValue();
    }

    public final PFMedium getMCourseDetailsHot() {
        return (PFMedium) this.mCourseDetailsHot$delegate.getValue();
    }

    public final PFMedium getMCourseDiff() {
        return (PFMedium) this.mCourseDiff$delegate.getValue();
    }

    public final PFMedium getMCourseHeat() {
        return (PFMedium) this.mCourseHeat$delegate.getValue();
    }

    public final TextView getMCourseName() {
        return (TextView) this.mCourseName$delegate.getValue();
    }

    public final PFMedium getMCourseTime() {
        return (PFMedium) this.mCourseTime$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final BaseFragmentPagerAdapter getMFragmentPagerAdapter() {
        BaseFragmentPagerAdapter baseFragmentPagerAdapter = this.mFragmentPagerAdapter;
        if (baseFragmentPagerAdapter != null) {
            return baseFragmentPagerAdapter;
        }
        IIX0o.XOxIOxOx("mFragmentPagerAdapter");
        return null;
    }

    @OXOo.OOXIXo
    public final String getMIdentity() {
        return this.mIdentity;
    }

    public final ImageView getMRoundPicImage() {
        return (ImageView) this.mRoundPicImage$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final ViewPager getMViewPager() {
        ViewPager viewPager = this.mViewPager;
        if (viewPager != null) {
            return viewPager;
        }
        IIX0o.XOxIOxOx("mViewPager");
        return null;
    }

    public final TabLayout getTable() {
        return (TabLayout) this.table$delegate.getValue();
    }

    public final int getWidthPixels() {
        return this.widthPixels;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
        SPUtils XO2 = Xo0.f24349oIX0oI.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        if (fromJson != null) {
            appUser = fromJson;
        }
        this.mIdentity = ((AppUser) appUser).getIdentity();
        if (getMArg0() != null) {
            CourseManager courseManager = CourseManager.f19940oIX0oI;
            String mArg0 = getMArg0();
            IIX0o.ooOOo0oXI(mArg0);
            courseManager.OOXIXo(mArg0, this.mIdentity, new Oox.oOoXoXO<CourseDetails, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.course.CourseDetailsActivity$init$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(CourseDetails courseDetails) {
                    invoke2(courseDetails);
                    return oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.oOoXoXO CourseDetails courseDetails) {
                    CourseDetails courseDetails2;
                    if (courseDetails != null) {
                        CourseDetailsActivity.this.mCourseDetails = courseDetails;
                        courseDetails2 = CourseDetailsActivity.this.mCourseDetails;
                        List<ProgressMarkers> progressMarkers = courseDetails2 != null ? courseDetails2.getProgressMarkers() : null;
                        if (progressMarkers != null) {
                            int i = -1;
                            for (ProgressMarkers progressMarkers2 : progressMarkers) {
                                if (i == -1) {
                                    i = Integer.parseInt(progressMarkers2.getOffset());
                                } else {
                                    i = Integer.parseInt(progressMarkers2.getOffset()) - i;
                                }
                                progressMarkers2.setTime(i);
                            }
                        }
                        CourseDetailsActivity.this.setView();
                        return;
                    }
                    ToastUtils.showLong(R.string.auto_retry_active_tip);
                }
            });
        } else {
            ToastUtils.showLong(R.string.request_error);
        }
        this.widthPixels = ScreenUtils.getAppScreenWidth();
    }

    @Override // com.bestmafen.androidbase.viewpager.oIX0oI
    @OXOo.OOXIXo
    public List<Fragment> initFragments() {
        String str;
        BaseFragment.oIX0oI oix0oi = BaseFragment.Companion;
        CourseDetails courseDetails = this.mCourseDetails;
        if (courseDetails != null) {
            str = courseDetails.getCourseIntro();
        } else {
            str = null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("mArg0", str);
        bundle.putParcelable("mArg2", null);
        bundle.putSerializable("mArg3", null);
        BaseFragment baseFragment = (BaseFragment) DetailIntroduceFragment.class.newInstance();
        baseFragment.setArguments(bundle);
        CourseDetails courseDetails2 = this.mCourseDetails;
        Bundle bundle2 = new Bundle();
        bundle2.putString("mArg0", null);
        bundle2.putParcelable("mArg2", null);
        bundle2.putSerializable("mArg3", courseDetails2);
        BaseFragment baseFragment2 = (BaseFragment) CourseActionFragment.class.newInstance();
        baseFragment2.setArguments(bundle2);
        return CollectionsKt__CollectionsKt.X00IoxXI((DetailIntroduceFragment) baseFragment, (CourseActionFragment) baseFragment2);
    }

    public final void initImage() {
        String str;
        RequestBuilder<Bitmap> asBitmap = Glide.with(getMRoundPicImage().getContext()).asBitmap();
        CourseDetails courseDetails = this.mCourseDetails;
        if (courseDetails != null) {
            str = courseDetails.getCoursePic1();
        } else {
            str = null;
        }
        asBitmap.load(str).into((RequestBuilder<Bitmap>) new oIX0oI());
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        getTable().setBackgroundColor(oIxOXo.oxoX.I0Io(getMContext(), R.color.view_page_tablayout_bg));
        setCollectImage();
        getAbhTitleOtherRight().setImageResource(R.drawable.icon_course_share);
    }

    public final boolean isButtonClick() {
        return this.isButtonClick;
    }

    public final boolean isDownload() {
        return this.isDownload;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_course_details;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.isDownload) {
            ToastUtils.showLong(R.string.music_down_transmit_tip);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressLint({"SetTextI18n"})
    public final void onButtonClick(@OXOo.OOXIXo View view) {
        VideoFile videoFile;
        VideoFile videoFile2;
        IIX0o.x0xO0oo(view, "view");
        if (this.isButtonClick) {
            return;
        }
        CourseDetails courseDetails = this.mCourseDetails;
        String str = null;
        if (courseDetails != null) {
            videoFile = courseDetails.getVideoFile();
        } else {
            videoFile = null;
        }
        if (videoFile == null) {
            ToastUtils.showLong(R.string.no_exit_file_doload);
            return;
        }
        this.isButtonClick = true;
        String str2 = "course" + getMArg0() + ".mp4";
        final File file = new File(com.sma.smartv3.initializer.IXxxXO.XX0(X00IoxXI.oIX0oI.f3233oIX0oI).getAbsolutePath(), str2);
        if (!file.exists()) {
            this.isDownload = true;
            CourseManager courseManager = CourseManager.f19940oIX0oI;
            CourseDetails courseDetails2 = this.mCourseDetails;
            if (courseDetails2 != null && (videoFile2 = courseDetails2.getVideoFile()) != null) {
                str = videoFile2.getFilePath();
            }
            IIX0o.ooOOo0oXI(str);
            courseManager.X0o0xo(str, str2, new Oox.oOoXoXO<Integer, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.course.CourseDetailsActivity$onButtonClick$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Integer num) {
                    invoke(num.intValue());
                    return oXIO0o0XI.f29392oIX0oI;
                }

                public final void invoke(int i) {
                    if (i > 100) {
                        CourseDetailsActivity.this.getMButton().setText(R.string.start_training);
                        CourseDetailsActivity courseDetailsActivity = CourseDetailsActivity.this;
                        String absolutePath = file.getAbsolutePath();
                        IIX0o.oO(absolutePath, "getAbsolutePath(...)");
                        courseDetailsActivity.playVideo(absolutePath);
                        return;
                    }
                    if (i == -1) {
                        if (file.exists()) {
                            file.delete();
                        }
                        CourseDetailsActivity.this.getMButton().setText(R.string.get_music_down_link_error);
                        CourseDetailsActivity.this.setButtonClick(false);
                        return;
                    }
                    String string = CourseDetailsActivity.this.getString(R.string.downloading);
                    IIX0o.oO(string, "getString(...)");
                    CourseDetailsActivity.this.getMButton().setText(string + i + org.apache.log4j.helpers.x0XOIxOo.f33309xxIXOIIO);
                }
            });
            return;
        }
        String absolutePath = file.getAbsolutePath();
        IIX0o.oO(absolutePath, "getAbsolutePath(...)");
        playVideo(absolutePath);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        initImage();
        this.isButtonClick = false;
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        finish();
    }

    public final void onTitleRightClick(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        ToastUtils.showLong("功能开发中..", new Object[0]);
    }

    public final void onTitleRightOtherClick(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
    }

    public final void playVideo(@OXOo.OOXIXo String absolutePath) {
        IIX0o.x0xO0oo(absolutePath, "absolutePath");
        this.isDownload = false;
        CourseDetails courseDetails = this.mCourseDetails;
        Bundle bundle = new Bundle();
        bundle.putString("mArg0", absolutePath);
        bundle.putParcelable("mArg2", null);
        bundle.putSerializable("mArg3", courseDetails);
        Intent intent = new Intent(this, (Class<?>) CourseVideoActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
        this.isButtonClick = false;
    }

    @Override // com.bestmafen.androidbase.viewpager.oIX0oI
    @OXOo.OOXIXo
    public FragmentManager provideFragmentManager() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        IIX0o.oO(supportFragmentManager, "getSupportFragmentManager(...)");
        return supportFragmentManager;
    }

    public final void setButtonClick(boolean z) {
        this.isButtonClick = z;
    }

    public final void setCollectImage() {
        int i;
        ImageView abhTitleRight = getAbhTitleRight();
        if (this.courseCollect) {
            i = R.drawable.icon_course_collection_true;
        } else {
            i = R.drawable.icon_course_collection;
        }
        abhTitleRight.setImageResource(i);
    }

    public final void setCourseCollect(boolean z) {
        this.courseCollect = z;
    }

    public final void setDownload(boolean z) {
        this.isDownload = z;
    }

    public final void setLayoutHeight(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = getMCardViewLayout().getLayoutParams();
        layoutParams.height = ((this.widthPixels - SizeUtils.dp2px(30.0f)) * i2) / i;
        getMCardViewLayout().setLayoutParams(layoutParams);
    }

    public final void setMFragmentPagerAdapter(@OXOo.OOXIXo BaseFragmentPagerAdapter baseFragmentPagerAdapter) {
        IIX0o.x0xO0oo(baseFragmentPagerAdapter, "<set-?>");
        this.mFragmentPagerAdapter = baseFragmentPagerAdapter;
    }

    public final void setMIdentity(@OXOo.OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mIdentity = str;
    }

    public final void setMViewPager(@OXOo.OOXIXo ViewPager viewPager) {
        IIX0o.x0xO0oo(viewPager, "<set-?>");
        this.mViewPager = viewPager;
    }

    @SuppressLint({"SetTextI18n"})
    public final void setView() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        TextView textView = (TextView) findViewById(R.id.abh_title_center);
        CourseDetails courseDetails = this.mCourseDetails;
        String str7 = null;
        if (courseDetails != null) {
            str = courseDetails.getCourseName();
        } else {
            str = null;
        }
        textView.setText(str);
        initImage();
        TextView mCourseName = getMCourseName();
        CourseDetails courseDetails2 = this.mCourseDetails;
        if (courseDetails2 != null) {
            str2 = courseDetails2.getCourseName();
        } else {
            str2 = null;
        }
        mCourseName.setText(str2);
        PFMedium mCourseDetailsHot = getMCourseDetailsHot();
        StringBuilder sb = new StringBuilder();
        CourseDetails courseDetails3 = this.mCourseDetails;
        if (courseDetails3 != null) {
            str3 = courseDetails3.getCourseClass();
        } else {
            str3 = null;
        }
        sb.append(str3);
        sb.append(getString(R.string.people_join));
        mCourseDetailsHot.setText(sb.toString());
        PFMedium mCourseDiff = getMCourseDiff();
        CourseDetails courseDetails4 = this.mCourseDetails;
        if (courseDetails4 != null) {
            str4 = courseDetails4.getCourseDiff();
        } else {
            str4 = null;
        }
        mCourseDiff.setText(str4);
        PFMedium mCourseTime = getMCourseTime();
        StringBuilder sb2 = new StringBuilder();
        CourseDetails courseDetails5 = this.mCourseDetails;
        if (courseDetails5 != null) {
            str5 = courseDetails5.getCourseTime();
        } else {
            str5 = null;
        }
        sb2.append(str5);
        sb2.append(getMContext().getString(R.string.minute));
        mCourseTime.setText(sb2.toString());
        PFMedium mCourseHeat = getMCourseHeat();
        StringBuilder sb3 = new StringBuilder();
        CourseDetails courseDetails6 = this.mCourseDetails;
        if (courseDetails6 != null) {
            str6 = courseDetails6.getCourseHeat();
        } else {
            str6 = null;
        }
        sb3.append(str6);
        sb3.append(getString(R.string.kcal));
        mCourseHeat.setText(sb3.toString());
        CourseDetails courseDetails7 = this.mCourseDetails;
        if (courseDetails7 != null) {
            str7 = courseDetails7.getCollectFlag();
        }
        this.courseCollect = IIX0o.Oxx0IOOO(str7, Api.Y);
        setCollectImage();
        View findViewById = findViewById(R.id.view_pager);
        IIX0o.oO(findViewById, "findViewById(...)");
        setMViewPager((ViewPager) findViewById);
        BaseFragmentPagerAdapter baseFragmentPagerAdapter = new BaseFragmentPagerAdapter(this);
        getMViewPager().setAdapter(baseFragmentPagerAdapter);
        getMViewPager().setOffscreenPageLimit(baseFragmentPagerAdapter.getCount());
        setMFragmentPagerAdapter(baseFragmentPagerAdapter);
        getMFragmentPagerAdapter().setTitles(new String[]{getMContext().getString(R.string.heath_course_description), getMContext().getString(R.string.course_action)});
        getTable().setupWithViewPager(getMViewPager());
    }

    public final void setWidthPixels(int i) {
        this.widthPixels = i;
    }
}
