package com.sma.smartv3.ui.device;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.bestmafen.androidbase.base.BaseActivity;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.VibrateUtils;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.google.gson.Gson;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.initializer.BleInitializer;
import com.sma.smartv3.model.PrayerTime;
import com.sma.smartv3.model.PrayerTimeSettings;
import com.sma.smartv3.model.PrayerTimesKt;
import com.sma.smartv3.model.WeatherRealtime;
import com.sma.smartv3.util.UtilsKt;
import com.sma.smartv3.util.xxIXOIIO;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

@kotlin.jvm.internal.XX({"SMAP\nQiblaOrientationActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 QiblaOrientationActivity.kt\ncom/sma/smartv3/ui/device/QiblaOrientationActivity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,225:1\n18#2,2:226\n15#2:228\n90#2:229\n*S KotlinDebug\n*F\n+ 1 QiblaOrientationActivity.kt\ncom/sma/smartv3/ui/device/QiblaOrientationActivity\n*L\n46#1:226,2\n46#1:228\n79#1:229\n*E\n"})
/* loaded from: classes12.dex */
public final class QiblaOrientationActivity extends BaseActivity {
    private boolean isVibrate;

    @OXOo.oOoXoXO
    private com.sma.smartv3.util.xxIXOIIO mCompass;
    private float mCurAzimuth;

    @OXOo.OOXIXo
    private com.sma.smartv3.location.oIX0oI mLocation;

    @OXOo.oOoXoXO
    private PrayerTime mNextPrayerTime;
    private Map<Long, ? extends List<PrayerTime>> mPrayerTimeData;

    @OXOo.OOXIXo
    private final PrayerTimeSettings mPrayerTimeSettings;
    private int mQiblaDegree;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO bgQibla$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ViewGroup>() { // from class: com.sma.smartv3.ui.device.QiblaOrientationActivity$bgQibla$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ViewGroup invoke() {
            return (ViewGroup) QiblaOrientationActivity.this.findViewById(R.id.qibla_panel);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvQiblaAngle$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.device.QiblaOrientationActivity$tvQiblaAngle$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) QiblaOrientationActivity.this.findViewById(R.id.tv_qibla_angle);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO ivQiblaArrow$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.device.QiblaOrientationActivity$ivQiblaArrow$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) QiblaOrientationActivity.this.findViewById(R.id.iv_qibla_arrow);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO ivQiblaDial$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.device.QiblaOrientationActivity$ivQiblaDial$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) QiblaOrientationActivity.this.findViewById(R.id.iv_qibla_dial);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvAddress$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.device.QiblaOrientationActivity$tvAddress$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) QiblaOrientationActivity.this.findViewById(R.id.tv_address);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvCal$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.device.QiblaOrientationActivity$tvCal$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) QiblaOrientationActivity.this.findViewById(R.id.tv_cal);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvNextTime$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.device.QiblaOrientationActivity$tvNextTime$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) QiblaOrientationActivity.this.findViewById(R.id.tv_next_time);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvAngleBig$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.device.QiblaOrientationActivity$tvAngleBig$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) QiblaOrientationActivity.this.findViewById(R.id.tv_angle_big);
        }
    });

    /* loaded from: classes12.dex */
    public static final class oIX0oI implements xxIXOIIO.II0xO0 {
        public oIX0oI() {
        }

        @Override // com.sma.smartv3.util.xxIXOIIO.II0xO0
        public void oIX0oI(float f) {
            QiblaOrientationActivity.this.adjustQiblaDial(f);
            QiblaOrientationActivity.this.adjustQiblaArrow(f);
        }
    }

    public QiblaOrientationActivity() {
        Object fromJson = new Gson().fromJson(com.sma.smartv3.util.Xo0.f24349oIX0oI.oIX0oI().getString(PrayerTimeSettings.class.getName()), (Class<Object>) PrayerTimeSettings.class);
        this.mPrayerTimeSettings = (PrayerTimeSettings) (fromJson == null ? PrayerTimeSettings.class.newInstance() : fromJson);
        this.mLocation = new com.sma.smartv3.location.oIX0oI(XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, 0.0f, 0, 31, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void adjustQiblaArrow(float f) {
        RotateAnimation rotateAnimation = new RotateAnimation(this.mQiblaDegree + (-this.mCurAzimuth), -f, 1, 0.5f, 1, 0.5f);
        this.mCurAzimuth = f;
        rotateAnimation.setDuration(500L);
        rotateAnimation.setRepeatCount(0);
        rotateAnimation.setFillAfter(true);
        getIvQiblaArrow().startAnimation(rotateAnimation);
        showQiblaArrowDegree();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void adjustQiblaDial(float f) {
        RotateAnimation rotateAnimation = new RotateAnimation(-this.mCurAzimuth, -f, 1, 0.5f, 1, 0.5f);
        this.mCurAzimuth = f;
        rotateAnimation.setDuration(500L);
        rotateAnimation.setRepeatCount(0);
        rotateAnimation.setFillAfter(true);
        getIvQiblaDial().startAnimation(rotateAnimation);
    }

    private final double calculateQiblaDegree(double d, double d2, double d3, double d4) {
        double d5 = d * 0.017453292519943295d;
        double d6 = d3 * 0.017453292519943295d;
        double d7 = (d4 - d2) * 0.017453292519943295d;
        double degrees = Math.toDegrees(Math.atan2(Math.sin(d7) * Math.cos(d6), (Math.cos(d5) * Math.sin(d6)) - ((Math.sin(d5) * Math.cos(d6)) * Math.cos(d7))));
        if (degrees < XIXIX.OOXIXo.f3760XO) {
            return degrees + 360;
        }
        return degrees;
    }

    private final ViewGroup getBgQibla() {
        return (ViewGroup) this.bgQibla$delegate.getValue();
    }

    private final ImageView getIvQiblaArrow() {
        return (ImageView) this.ivQiblaArrow$delegate.getValue();
    }

    private final ImageView getIvQiblaDial() {
        return (ImageView) this.ivQiblaDial$delegate.getValue();
    }

    private final TextView getTvAddress() {
        return (TextView) this.tvAddress$delegate.getValue();
    }

    private final TextView getTvAngleBig() {
        return (TextView) this.tvAngleBig$delegate.getValue();
    }

    private final TextView getTvCal() {
        return (TextView) this.tvCal$delegate.getValue();
    }

    private final TextView getTvNextTime() {
        return (TextView) this.tvNextTime$delegate.getValue();
    }

    private final TextView getTvQiblaAngle() {
        return (TextView) this.tvQiblaAngle$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(View view) {
        BleInitializer.f20700XO.onRequestAgpsPrerequisite();
    }

    private final void showQiblaArrowDegree() {
        float f;
        float f2 = 360;
        float f3 = f2 - this.mCurAzimuth;
        int i = this.mQiblaDegree;
        float f4 = (f3 + i) % f2;
        float f5 = 360 - i;
        if (f4 < f5) {
            f = f2 - (f5 - f4);
        } else {
            f = f4 - f5;
        }
        TextView tvQiblaAngle = getTvQiblaAngle();
        StringBuilder sb = new StringBuilder();
        sb.append((int) f);
        sb.append(kotlin.text.XIxXXX0x0.f29560x0xO0oo);
        tvQiblaAngle.setText(sb.toString());
        if (f4 <= 355.0f && f4 >= 5.0f) {
            this.isVibrate = false;
            getBgQibla().setBackgroundResource(R.drawable.pic_qibla_n_bg);
        } else if (!this.isVibrate) {
            VibrateUtils.vibrate(100L);
            this.isVibrate = true;
            getBgQibla().setBackgroundResource(R.drawable.pic_qibla_bg);
        }
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.BaseActivity, com.bestmafen.androidbase.base.oIX0oI
    public boolean initEvent() {
        return true;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        ((TextView) findViewById(R.id.abh_title_center)).setText(R.string.qibla_orientaiton);
        com.sma.smartv3.util.xxIXOIIO xxixoiio = new com.sma.smartv3.util.xxIXOIIO(this);
        this.mCompass = xxixoiio;
        xxixoiio.I0Io(new oIX0oI());
        getTvAddress().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.oXxx000
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QiblaOrientationActivity.initView$lambda$0(view);
            }
        });
        SPUtils oIX0oI2 = com.sma.smartv3.util.Xo0.f24349oIX0oI.oIX0oI();
        WeatherRealtime weatherRealtime = (WeatherRealtime) new Gson().fromJson(oIX0oI2.getString(com.sma.smartv3.util.XoI0Ixx0.f24491xoO0xx0 + '_' + WeatherRealtime.class.getName()), WeatherRealtime.class);
        if (weatherRealtime != null) {
            getTvAddress().setText(weatherRealtime.getName());
        }
        onInfoChange(new Object());
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_qibla_orientation;
    }

    @XO0.XO(tag = com.sma.smartv3.util.XoI0Ixx0.f24423XX)
    public final void onInfoChange(@OXOo.OOXIXo Object data) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(data, "data");
        com.sma.smartv3.location.oIX0oI ooOOo0oXI2 = UtilsKt.ooOOo0oXI();
        this.mLocation = ooOOo0oXI2;
        this.mQiblaDegree = (int) calculateQiblaDegree(ooOOo0oXI2.II0xO0(), this.mLocation.I0Io(), 21.422507d, 39.826209d);
        TextView tvAngleBig = getTvAngleBig();
        StringBuilder sb = new StringBuilder();
        sb.append(this.mQiblaDegree);
        sb.append(kotlin.text.XIxXXX0x0.f29560x0xO0oo);
        tvAngleBig.setText(sb.toString());
        Calendar calendar = Calendar.getInstance();
        kotlin.jvm.internal.IIX0o.oO(calendar, "getInstance(...)");
        this.mPrayerTimeData = PrayerTimesKt.getPrayerTimeMap$default(this.mPrayerTimeSettings, this.mLocation.II0xO0(), this.mLocation.I0Io(), com.sma.smartv3.util.xoIox.OxxIIOOXO(calendar), 0, 16, null);
        long currentTimeMillis = System.currentTimeMillis();
        PrayerTime.Companion companion = PrayerTime.Companion;
        Map<Long, ? extends List<PrayerTime>> map = this.mPrayerTimeData;
        if (map == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mPrayerTimeData");
            map = null;
        }
        this.mNextPrayerTime = companion.findNextTime(map, currentTimeMillis);
        OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onLocationInfoChange ");
        sb2.append(this.mLocation);
        sb2.append(TokenParser.SP);
        sb2.append(this.mQiblaDegree);
        sb2.append(TokenParser.SP);
        sb2.append(this.mNextPrayerTime);
        sb2.append(", ");
        Map<Long, ? extends List<PrayerTime>> map2 = this.mPrayerTimeData;
        if (map2 == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mPrayerTimeData");
            map2 = null;
        }
        sb2.append(map2);
        oix0oi.oIX0oI(sb2.toString());
        if (this.mNextPrayerTime != null) {
            TextView tvNextTime = getTvNextTime();
            StringBuilder sb3 = new StringBuilder();
            PrayerTime prayerTime = this.mNextPrayerTime;
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(prayerTime);
            sb3.append(getString(prayerTime.getTimeName(getMContext())));
            sb3.append(TokenParser.SP);
            PrayerTime prayerTime2 = this.mNextPrayerTime;
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(prayerTime2);
            sb3.append(prayerTime2.getTimeString());
            tvNextTime.setText(sb3.toString());
        }
        getTvCal().setText(com.sma.smartv3.util.xoIox.oo0xXOI0I().format(Long.valueOf(currentTimeMillis)));
        if (Build.VERSION.SDK_INT >= 26) {
            getTvCal().setText(com.sma.smartv3.util.xoIox.x0xO0oo(System.currentTimeMillis(), 0, 2, null) + " (" + com.sma.smartv3.util.xoIox.oo0xXOI0I().format(Long.valueOf(currentTimeMillis)) + HexStringBuilder.COMMENT_END_CHAR);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        com.sma.smartv3.util.xxIXOIIO xxixoiio = this.mCompass;
        if (xxixoiio != null) {
            xxixoiio.X0o0xo();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.sma.smartv3.util.xxIXOIIO xxixoiio = this.mCompass;
        if (xxixoiio != null) {
            xxixoiio.oxoX();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        com.sma.smartv3.util.xxIXOIIO xxixoiio = this.mCompass;
        if (xxixoiio != null) {
            xxixoiio.oxoX();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        com.sma.smartv3.util.xxIXOIIO xxixoiio = this.mCompass;
        if (xxixoiio != null) {
            xxixoiio.X0o0xo();
        }
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        finish();
    }
}
