package com.sma.smartv3.ui.main;

import android.view.MenuItem;
import androidx.fragment.app.Fragment;
import com.blankj.utilcode.util.BarUtils;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.ui.ai.CofitAIFragment;
import com.sma.smartv3.ui.device.CofitDeviceFragment;
import com.sma.smartv3.ui.me.CofitMeFragment;
import com.sma.smartv3.ui.sport.CofitSportFragment;
import com.sma.smartv3.ui.status.CofitStatusFragment;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes12.dex */
public final class MainActivity extends BaseMainActivity {
    @Override // com.sma.smartv3.ui.main.BaseMainActivity, com.bestmafen.androidbase.viewpager.oIX0oI
    @OXOo.OOXIXo
    public List<Fragment> initFragments() {
        setStatusFragment(new CofitStatusFragment());
        ArrayList arrayList = new ArrayList();
        arrayList.add(getStatusFragment());
        ProjectManager projectManager = ProjectManager.f19822oIX0oI;
        if (projectManager.OOOI()) {
            arrayList.add(new CofitSportFragment());
            MenuItem findItem = getBottomNav().getMenu().findItem(R.id.item_bottom_sport);
            if (findItem != null) {
                findItem.setVisible(true);
            }
        } else {
            getBottomNav().getMenu().removeItem(R.id.item_bottom_sport);
        }
        if (projectManager.xOoOIoI()) {
            arrayList.add(new CofitAIFragment());
            MenuItem findItem2 = getBottomNav().getMenu().findItem(R.id.item_bottom_ai);
            if (findItem2 != null) {
                findItem2.setVisible(true);
            }
        } else {
            getBottomNav().getMenu().removeItem(R.id.item_bottom_ai);
        }
        arrayList.add(new CofitDeviceFragment());
        arrayList.add(new CofitMeFragment());
        return arrayList;
    }

    @Override // com.sma.smartv3.ui.main.BaseMainActivity, com.bestmafen.androidbase.viewpager.BaseFragmentPagerActivity, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        BarUtils.transparentStatusBar(this);
    }
}
