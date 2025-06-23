package com.sma.smartv3.ui.sport.course;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.bestmafen.androidbase.base.BaseActivity;
import com.bestmafen.androidbase.base.BaseFragment;
import com.bestmafen.androidbase.viewpager.BaseFragmentPagerAdapter;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.CourseDetails;
import com.sma.smartv3.model.ProgressMarkers;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nCourseIntroduceActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CourseIntroduceActivity.kt\ncom/sma/smartv3/ui/sport/course/CourseIntroduceActivity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 BaseFragment.kt\ncom/bestmafen/androidbase/base/BaseFragment$Companion\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,91:1\n1855#2:92\n1856#2:109\n80#3,9:93\n89#3,3:103\n75#3,3:106\n1#4:102\n*S KotlinDebug\n*F\n+ 1 CourseIntroduceActivity.kt\ncom/sma/smartv3/ui/sport/course/CourseIntroduceActivity\n*L\n85#1:92\n85#1:109\n86#1:93,9\n86#1:103,3\n86#1:106,3\n86#1:102\n*E\n"})
/* loaded from: classes12.dex */
public final class CourseIntroduceActivity extends BaseActivity implements com.bestmafen.androidbase.viewpager.oIX0oI {
    private int curPosition;
    private CourseDetails mCourseDetails;
    protected BaseFragmentPagerAdapter mFragmentPagerAdapter;

    @OXOo.OOXIXo
    private final X0IIOO mViewPager$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ViewPager>() { // from class: com.sma.smartv3.ui.sport.course.CourseIntroduceActivity$mViewPager$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ViewPager invoke() {
            return (ViewPager) CourseIntroduceActivity.this.findViewById(R.id.course_introduce_viewpager);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mIntroduceCur$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.course.CourseIntroduceActivity$mIntroduceCur$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) CourseIntroduceActivity.this.findViewById(R.id.introduce_tv_cur);
        }
    });

    private final ViewPager getMViewPager() {
        return (ViewPager) this.mViewPager$delegate.getValue();
    }

    public final int getCurPosition() {
        return this.curPosition;
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

    public final TextView getMIntroduceCur() {
        return (TextView) this.mIntroduceCur$delegate.getValue();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
        this.curPosition = getMArg1();
        Serializable mArg3 = getMArg3();
        IIX0o.x0XOIxOo(mArg3, "null cannot be cast to non-null type com.sma.smartv3.model.CourseDetails");
        this.mCourseDetails = (CourseDetails) mArg3;
    }

    @Override // com.bestmafen.androidbase.viewpager.oIX0oI
    @OXOo.OOXIXo
    public List<Fragment> initFragments() {
        ArrayList arrayList = new ArrayList();
        CourseDetails courseDetails = this.mCourseDetails;
        if (courseDetails == null) {
            IIX0o.XOxIOxOx("mCourseDetails");
            courseDetails = null;
        }
        for (ProgressMarkers progressMarkers : courseDetails.getProgressMarkers()) {
            BaseFragment.oIX0oI oix0oi = BaseFragment.Companion;
            Bundle bundle = new Bundle();
            bundle.putString("mArg0", null);
            bundle.putParcelable("mArg2", null);
            bundle.putSerializable("mArg3", progressMarkers);
            BaseFragment baseFragment = (BaseFragment) CourseIntroduceFragment.class.newInstance();
            baseFragment.setArguments(bundle);
            arrayList.add((CourseIntroduceFragment) baseFragment);
        }
        return arrayList;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        BaseFragmentPagerAdapter baseFragmentPagerAdapter = new BaseFragmentPagerAdapter(this);
        getMViewPager().setAdapter(baseFragmentPagerAdapter);
        getMViewPager().setOffscreenPageLimit(baseFragmentPagerAdapter.getCount());
        setMFragmentPagerAdapter(baseFragmentPagerAdapter);
        getMViewPager().addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.sma.smartv3.ui.sport.course.CourseIntroduceActivity$initView$2
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                CourseIntroduceActivity.this.setCurPosition(i);
                CourseIntroduceActivity.this.getMIntroduceCur().setText(String.valueOf(CourseIntroduceActivity.this.getCurPosition() + 1));
            }
        });
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_course_introduce;
    }

    public final void onBeforeIntroduce(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        int i = this.curPosition;
        if (i != 0) {
            this.curPosition = i - 1;
        } else {
            CourseDetails courseDetails = this.mCourseDetails;
            if (courseDetails == null) {
                IIX0o.XOxIOxOx("mCourseDetails");
                courseDetails = null;
            }
            this.curPosition = courseDetails.getProgressMarkers().size() - 1;
        }
        getMViewPager().setCurrentItem(this.curPosition);
    }

    public final void onNextIntroduce(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        int i = this.curPosition;
        CourseDetails courseDetails = this.mCourseDetails;
        if (courseDetails == null) {
            IIX0o.XOxIOxOx("mCourseDetails");
            courseDetails = null;
        }
        if (i == courseDetails.getProgressMarkers().size() - 1) {
            this.curPosition = 0;
        } else {
            this.curPosition++;
        }
        getMViewPager().setCurrentItem(this.curPosition);
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        finish();
    }

    @Override // com.bestmafen.androidbase.viewpager.oIX0oI
    @OXOo.OOXIXo
    public FragmentManager provideFragmentManager() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        IIX0o.oO(supportFragmentManager, "getSupportFragmentManager(...)");
        return supportFragmentManager;
    }

    public final void setCurPosition(int i) {
        this.curPosition = i;
    }

    public final void setMFragmentPagerAdapter(@OXOo.OOXIXo BaseFragmentPagerAdapter baseFragmentPagerAdapter) {
        IIX0o.x0xO0oo(baseFragmentPagerAdapter, "<set-?>");
        this.mFragmentPagerAdapter = baseFragmentPagerAdapter;
    }
}
