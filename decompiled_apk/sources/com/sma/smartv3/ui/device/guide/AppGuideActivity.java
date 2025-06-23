package com.sma.smartv3.ui.device.guide;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.RomUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.ble.MyNotificationListenerService;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.ui.device.AutoBindActivity;
import com.sma.smartv3.util.permission.PermissionHelper;
import com.szabh.smable3.component.BleConnector;
import java.util.Iterator;
import java.util.List;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nAppGuideActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppGuideActivity.kt\ncom/sma/smartv3/ui/device/guide/AppGuideActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,159:1\n1#2:160\n254#3:161\n*S KotlinDebug\n*F\n+ 1 AppGuideActivity.kt\ncom/sma/smartv3/ui/device/guide/AppGuideActivity\n*L\n150#1:161\n*E\n"})
/* loaded from: classes12.dex */
public final class AppGuideActivity extends BaseAppGuideActivity {
    private boolean isNeedConnectClassic;
    private boolean isNeedConnectHID;

    @OOXIXo
    private final X0IIOO nextButton$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.device.guide.AppGuideActivity$nextButton$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) AppGuideActivity.this.findViewById(R.id.next);
        }
    });

    @OOXIXo
    private final X0IIOO doneButton$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.device.guide.AppGuideActivity$doneButton$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) AppGuideActivity.this.findViewById(R.id.done);
        }
    });

    private final TextView getDoneButton() {
        return (TextView) this.doneButton$delegate.getValue();
    }

    private final TextView getNextButton() {
        return (TextView) this.nextButton$delegate.getValue();
    }

    @OOXIXo
    public final TextView getNext() {
        TextView nextButton = getNextButton();
        IIX0o.oO(nextButton, "<get-nextButton>(...)");
        return nextButton;
    }

    public final boolean isNeedConnectClassic() {
        return this.isNeedConnectClassic;
    }

    public final boolean isNeedConnectHID() {
        return this.isNeedConnectHID;
    }

    @Override // com.github.appintro.AppIntroBase, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }

    @Override // com.sma.smartv3.ui.device.guide.BaseAppGuideActivity, com.github.appintro.AppIntroBase, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@oOoXoXO Bundle bundle) {
        super.onCreate(bundle);
        ProjectManager projectManager = ProjectManager.f19822oIX0oI;
        setSkipButtonEnabled(projectManager.oOXoIIIo());
        showStatusBar(true);
        addSlide(new WelcomeGuideFragment());
        OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
        StringBuilder sb = new StringBuilder();
        sb.append("AppGuideActivity");
        ProductManager productManager = ProductManager.f20544oIX0oI;
        Object obj = null;
        sb.append(ProductManager.xOOxIO(productManager, null, 1, null));
        sb.append(TokenParser.SP);
        sb.append(productManager.xxxI());
        oix0oi.oxoX(sb.toString());
        if (ProductManager.xOOxIO(productManager, null, 1, null) || productManager.xxxI()) {
            addSlide(new EarphonesGuideFragment());
        }
        PermissionHelper permissionHelper = PermissionHelper.f24522oIX0oI;
        if (!permissionHelper.OxI(this)) {
            addSlide(new BgLocationGuideFragment());
        }
        if (productManager.OOOI() && !BleConnector.INSTANCE.isBoundClassic()) {
            this.isNeedConnectClassic = true;
            if (projectManager.OX()) {
                addSlide(new ClassicPairGuide2Fragment());
            } else {
                addSlide(new ClassicPairGuideFragment());
            }
        }
        if (productManager.xoIXOxX() && !BleConnector.INSTANCE.isBoundHID()) {
            this.isNeedConnectHID = true;
            addSlide(new HIDGuideFragment());
        }
        if (!productManager.Xo()) {
            if (!MyNotificationListenerService.f20319OxI.X0o0xo(this) && (productManager.oOo() || productManager.IoIOOxIIo())) {
                addSlide(new NotificationGuideFragment());
            }
            if (productManager.oOo() || productManager.IoIOOxIIo()) {
                addSlide(new NotificationSetGuideFragment());
            }
        }
        if (productManager.O0IoXXOx() && !productManager.xIx()) {
            addSlide(new WarmTipGuideFragment());
        }
        if (!permissionHelper.o00(this) && !productManager.Xo()) {
            addSlide(new BgRunGuideFragment());
        }
        if (productManager.X00IxOx()) {
            addSlide(new BloodGlucoseGuideFragment());
            if (productManager.xoIXOxX() && BleConnector.INSTANCE.isBoundHID() && RomUtils.isXiaomi()) {
                addSlide(new WelcomeGuideFragment());
            }
        }
        List<Activity> activityList = ActivityUtils.getActivityList();
        IIX0o.oO(activityList, "getActivityList(...)");
        Iterator<T> it = activityList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((Activity) next) instanceof AutoBindActivity) {
                obj = next;
                break;
            }
        }
        Activity activity = (Activity) obj;
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.isNeedConnectClassic) {
            BleConnector.INSTANCE.connectClassic();
        } else if (this.isNeedConnectHID) {
            BleConnector.INSTANCE.connectHID();
        }
    }

    @Override // com.github.appintro.AppIntroBase
    public void onDonePressed(@oOoXoXO Fragment fragment) {
        super.onDonePressed(fragment);
        setResult(-1);
        finish();
    }

    @Override // com.github.appintro.AppIntroBase
    public void onSkipPressed(@oOoXoXO Fragment fragment) {
        super.onSkipPressed(fragment);
        setResult(-1);
        finish();
    }

    @Override // com.github.appintro.AppIntroBase
    public void onSlideChanged(@oOoXoXO Fragment fragment, @oOoXoXO Fragment fragment2) {
        int i = 8;
        if ((fragment2 instanceof ClassicPairGuide2Fragment) && !((ClassicPairGuide2Fragment) fragment2).getCanSwipe()) {
            setSwipe(false);
            getNext().setVisibility(8);
            return;
        }
        if ((fragment2 instanceof HIDGuideFragment) && !((HIDGuideFragment) fragment2).getCanSwipe()) {
            setSwipe(false);
            getNext().setVisibility(8);
            return;
        }
        setSwipe(true);
        TextView next = getNext();
        TextView doneButton = getDoneButton();
        IIX0o.oO(doneButton, "<get-doneButton>(...)");
        if (doneButton.getVisibility() != 0) {
            i = 0;
        }
        next.setVisibility(i);
    }

    public final void setNeedConnectClassic(boolean z) {
        this.isNeedConnectClassic = z;
    }

    public final void setNeedConnectHID(boolean z) {
        this.isNeedConnectHID = z;
    }
}
