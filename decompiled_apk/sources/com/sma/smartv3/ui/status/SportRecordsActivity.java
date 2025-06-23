package com.sma.smartv3.ui.status;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.activity.result.ActivityResultCaller;
import androidx.fragment.app.Fragment;
import com.blankj.utilcode.util.LogUtils;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.ui.status.base.StatusBaseActivity;
import com.sma.smartv3.ui.status.fragment.SportRecordsFragment;
import com.sma.smartv3.ui.status.fragment.SportRecordsV2Fragment;
import java.util.List;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class SportRecordsActivity extends StatusBaseActivity {

    @OXOo.OOXIXo
    public static final oIX0oI Companion = new oIX0oI(null);

    @OXOo.OOXIXo
    public static final String TAG = "SportRecordsActivity";

    @OXOo.oOoXoXO
    private SportRecordsFragment mSportRecordsFragment;

    @OXOo.oOoXoXO
    private SportRecordsV2Fragment mSportRecordsV2Fragment;

    /* loaded from: classes12.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        public oIX0oI() {
        }
    }

    @OXOo.oOoXoXO
    public final SportRecordsFragment getMSportRecordsFragment() {
        return this.mSportRecordsFragment;
    }

    @OXOo.oOoXoXO
    public final SportRecordsV2Fragment getMSportRecordsV2Fragment() {
        return this.mSportRecordsV2Fragment;
    }

    @Override // com.sma.smartv3.ui.status.base.StatusBaseActivity
    public void initFragment() {
    }

    @Override // com.sma.smartv3.ui.status.base.StatusBaseActivity, com.bestmafen.androidbase.viewpager.oIX0oI
    @OXOo.OOXIXo
    public List<Fragment> initFragments() {
        ActivityResultCaller activityResultCaller;
        StringBuilder sb = new StringBuilder();
        sb.append(TAG);
        ProjectManager projectManager = ProjectManager.f19822oIX0oI;
        sb.append(projectManager.OO0());
        LogUtils.i(sb.toString());
        if (projectManager.OO0()) {
            this.mSportRecordsV2Fragment = new SportRecordsV2Fragment();
            if (getMArg1() > -1) {
                Bundle bundle = new Bundle();
                bundle.putInt("mArg1", getMArg1());
                SportRecordsV2Fragment sportRecordsV2Fragment = this.mSportRecordsV2Fragment;
                IIX0o.ooOOo0oXI(sportRecordsV2Fragment);
                sportRecordsV2Fragment.setArguments(bundle);
            }
            ActivityResultCaller activityResultCaller2 = this.mSportRecordsV2Fragment;
            IIX0o.ooOOo0oXI(activityResultCaller2);
            activityResultCaller = activityResultCaller2;
        } else {
            SportRecordsFragment sportRecordsFragment = new SportRecordsFragment();
            this.mSportRecordsFragment = sportRecordsFragment;
            IIX0o.ooOOo0oXI(sportRecordsFragment);
            activityResultCaller = sportRecordsFragment;
        }
        return kotlin.collections.oI0IIXIo.OOXIXo(activityResultCaller);
    }

    @Override // com.sma.smartv3.ui.status.base.StatusBaseActivity, com.bestmafen.androidbase.viewpager.BaseFragmentPagerActivity, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        int i = 8;
        findViewById(R.id.top_line).setVisibility(8);
        getTable().setVisibility(8);
        ImageView abhTitleRight = getAbhTitleRight();
        if (ProjectManager.f19822oIX0oI.OO0()) {
            getAbhTitleRight().setImageResource(R.drawable.icon_calendar_records_normal);
            i = 0;
        }
        abhTitleRight.setVisibility(i);
    }

    @Override // com.sma.smartv3.ui.status.base.StatusBaseActivity
    public void onTitleRightClick(@OXOo.OOXIXo View view) {
        SportRecordsV2Fragment sportRecordsV2Fragment;
        IIX0o.x0xO0oo(view, "view");
        if (ProjectManager.f19822oIX0oI.OO0() && (sportRecordsV2Fragment = this.mSportRecordsV2Fragment) != null) {
            sportRecordsV2Fragment.showCalendarPopop();
        }
    }

    public final void setMSportRecordsFragment(@OXOo.oOoXoXO SportRecordsFragment sportRecordsFragment) {
        this.mSportRecordsFragment = sportRecordsFragment;
    }

    public final void setMSportRecordsV2Fragment(@OXOo.oOoXoXO SportRecordsV2Fragment sportRecordsV2Fragment) {
        this.mSportRecordsV2Fragment = sportRecordsV2Fragment;
    }

    @Override // com.sma.smartv3.ui.status.base.StatusBaseActivity
    @OXOo.OOXIXo
    public String setTitle() {
        if (getMArg1() > -1) {
            String string = getString(R.string.game_record);
            IIX0o.oO(string, "getString(...)");
            return string;
        }
        String string2 = getString(R.string.sports_record);
        IIX0o.oO(string2, "getString(...)");
        return string2;
    }
}
