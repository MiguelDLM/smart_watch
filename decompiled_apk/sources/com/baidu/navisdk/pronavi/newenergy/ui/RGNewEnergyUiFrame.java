package com.baidu.navisdk.pronavi.newenergy.ui;

import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.navisdk.pronavi.base.RGBaseUiFrame;
import com.baidu.navisdk.pronavi.car.ui.bubble.RGCarBubbleComponent;
import com.baidu.navisdk.pronavi.hd.normal.ui.RGNormalHDComponent;
import com.baidu.navisdk.pronavi.newenergy.a;
import com.baidu.navisdk.pronavi.newenergy.ui.bucket.component.RGNewEnergyBucketModuleGroup;
import com.baidu.navisdk.pronavi.newenergy.ui.bucket.component.RGNewEnergyLeftBuckComponent;
import com.baidu.navisdk.pronavi.newenergy.ui.bucket.component.RGNewEnergyRightBuckComponent;
import com.baidu.navisdk.pronavi.newenergy.ui.charge.RGChargeStationListComponent;
import com.baidu.navisdk.pronavi.ui.base.b;
import com.baidu.navisdk.pronavi.ui.guidepanel.lottie.RGGuidePanelLottieComponent;
import com.baidu.navisdk.pronavi.ui.newnavi.component.RGNewContinueComponent;
import com.baidu.navisdk.pronavi.ui.newnavi.component.RGNewEtaComponent;
import com.baidu.navisdk.pronavi.ui.newnavi.component.RGNewMoreComponent;
import com.baidu.navisdk.pronavi.ui.newnavi.component.RGNewQuitNaviComponent;
import com.baidu.navisdk.pronavi.ui.newnavi.component.RGNewRightComponent;
import com.baidu.navisdk.pronavi.ui.newnavi.component.RGNewRoadConditionComponent;
import com.baidu.navisdk.pronavi.ui.newnavi.component.RGNewSimpleContinueComponent;
import com.baidu.navisdk.pronavi.ui.newnavi.component.RGNewSimpleEtaComponent;
import com.baidu.navisdk.pronavi.ui.park.component.RGParkingLotListComponent;
import com.baidu.navisdk.pronavi.ui.park.component.RGSaveParkComponent;
import com.baidu.navisdk.uiframe.UiModule;

/* loaded from: classes7.dex */
public class RGNewEnergyUiFrame extends RGBaseUiFrame<a> {
    private RGChargeStationListComponent o;

    public RGNewEnergyUiFrame(@NonNull a aVar, View view) {
        super(aVar, view);
    }

    @Override // com.baidu.navisdk.pronavi.base.RGBaseUiFrame
    public void n() {
        UiModule rGNewEnergyBucketModuleGroup = new RGNewEnergyBucketModuleGroup((a) this.f);
        a(rGNewEnergyBucketModuleGroup);
        a(new RGNewEnergyLeftBuckComponent((b) this.f), rGNewEnergyBucketModuleGroup);
        a(new RGNewEnergyRightBuckComponent((b) this.f), rGNewEnergyBucketModuleGroup);
        a(new RGCarBubbleComponent((b) this.f));
        a(new RGNormalHDComponent((b) this.f));
        RGChargeStationListComponent rGChargeStationListComponent = new RGChargeStationListComponent((a) this.f);
        this.o = rGChargeStationListComponent;
        a(rGChargeStationListComponent);
        if (!((a) b()).C()) {
            a(new RGNewQuitNaviComponent((b) this.f));
            a(new RGNewEtaComponent((b) this.f));
            a(new RGNewRoadConditionComponent((b) this.f));
            a(new RGNewMoreComponent((b) this.f));
            a(new RGNewRightComponent((b) this.f));
            a(new RGNewContinueComponent((b) this.f));
            a(new RGNewSimpleEtaComponent((b) this.f));
            a(new RGNewSimpleContinueComponent((b) this.f));
            a(new RGGuidePanelLottieComponent((b) this.f));
            a(new RGSaveParkComponent((b) this.f));
            a(new RGParkingLotListComponent((b) this.f));
        }
    }
}
