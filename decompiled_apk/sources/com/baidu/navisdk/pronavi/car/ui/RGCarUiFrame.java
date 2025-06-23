package com.baidu.navisdk.pronavi.car.ui;

import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.navisdk.pronavi.base.RGBaseUiFrame;
import com.baidu.navisdk.pronavi.car.a;
import com.baidu.navisdk.pronavi.car.ui.bubble.RGCarBubbleComponent;
import com.baidu.navisdk.pronavi.hd.normal.ui.RGNormalHDComponent;
import com.baidu.navisdk.pronavi.ui.base.b;
import com.baidu.navisdk.pronavi.ui.bucket.RGLeftBucketComponent;
import com.baidu.navisdk.pronavi.ui.bucket.RGRightBucketComponent;
import com.baidu.navisdk.pronavi.ui.bucket.component.RGBucketGroupComponent;
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

/* loaded from: classes7.dex */
public class RGCarUiFrame extends RGBaseUiFrame<a> {
    public RGCarUiFrame(@NonNull a aVar, View view) {
        super(aVar, view);
    }

    @Override // com.baidu.navisdk.pronavi.base.RGBaseUiFrame
    public void n() {
        RGBucketGroupComponent rGBucketGroupComponent = new RGBucketGroupComponent((b) this.f);
        a(rGBucketGroupComponent);
        a(new RGLeftBucketComponent((b) this.f), rGBucketGroupComponent);
        a(new RGRightBucketComponent((b) this.f), rGBucketGroupComponent);
        a(new RGCarBubbleComponent((b) this.f));
        a(new RGNormalHDComponent((b) this.f));
        if (!b().C()) {
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
        super.n();
    }
}
