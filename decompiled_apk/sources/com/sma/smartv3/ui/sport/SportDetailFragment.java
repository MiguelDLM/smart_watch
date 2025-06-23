package com.sma.smartv3.ui.sport;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.gridlayout.widget.GridLayout;
import com.bestmafen.androidbase.base.BaseFragment;
import com.blankj.utilcode.util.ImageUtils;
import com.blankj.utilcode.util.SPUtils;
import com.google.gson.Gson;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.MyDb;
import com.sma.smartv3.db.dao.LocationDao;
import com.sma.smartv3.db.entity.Location;
import com.sma.smartv3.db.entity.Workout;
import com.sma.smartv3.model.AppUser;
import com.sma.smartv3.util.TextConvertKt;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@kotlin.jvm.internal.XX({"SMAP\nSportDetailFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SportDetailFragment.kt\ncom/sma/smartv3/ui/sport/SportDetailFragment\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,152:1\n19#2:153\n15#2:154\n*S KotlinDebug\n*F\n+ 1 SportDetailFragment.kt\ncom/sma/smartv3/ui/sport/SportDetailFragment\n*L\n52#1:153\n52#1:154\n*E\n"})
/* loaded from: classes12.dex */
public final class SportDetailFragment extends BaseFragment {
    private boolean isLocationEmpty;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mLocationDao$delegate;
    private Workout mWorkout;

    @OXOo.OOXIXo
    private final AppUser userProfile;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO rootView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<NestedScrollView>() { // from class: com.sma.smartv3.ui.sport.SportDetailFragment$rootView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final NestedScrollView invoke() {
            View mView;
            mView = SportDetailFragment.this.getMView();
            return (NestedScrollView) mView.findViewById(R.id.root_view);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvDateTime$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.SportDetailFragment$tvDateTime$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = SportDetailFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.tv_dateTime);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvDuration$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.SportDetailFragment$tvDuration$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = SportDetailFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.tv_duration);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvStepValue$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.SportDetailFragment$tvStepValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = SportDetailFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.tv_step_value);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO stepPanel$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.sport.SportDetailFragment$stepPanel$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            View mView;
            mView = SportDetailFragment.this.getMView();
            return mView.findViewById(R.id.step_panel);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvAvgSpmValue$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.SportDetailFragment$tvAvgSpmValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = SportDetailFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.tv_spm_value);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO spmPanel$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.sport.SportDetailFragment$spmPanel$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            View mView;
            mView = SportDetailFragment.this.getMView();
            return mView.findViewById(R.id.spm_panel);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvDistanceValue$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.SportDetailFragment$tvDistanceValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = SportDetailFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.tv_distance_value);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO distancePanel$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.sport.SportDetailFragment$distancePanel$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            View mView;
            mView = SportDetailFragment.this.getMView();
            return mView.findViewById(R.id.distance_panel);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvDistanceUnit$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.SportDetailFragment$tvDistanceUnit$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = SportDetailFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.tv_distance_unit);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvCaloriesValue$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.SportDetailFragment$tvCaloriesValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = SportDetailFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.tv_calories_value);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvAvgHrValue$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.SportDetailFragment$tvAvgHrValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = SportDetailFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.tv_hr_value);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvAvgSpeedValue$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.SportDetailFragment$tvAvgSpeedValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = SportDetailFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.tv_speed_value);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO speedPanel$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.sport.SportDetailFragment$speedPanel$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            View mView;
            mView = SportDetailFragment.this.getMView();
            return mView.findViewById(R.id.speed_panel);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvAvgSpeedUnit$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.SportDetailFragment$tvAvgSpeedUnit$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = SportDetailFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.tv_speed_unit);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvAvgPaceValue$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.SportDetailFragment$tvAvgPaceValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = SportDetailFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.tv_pace_value);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvAvgPaceUnit$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.SportDetailFragment$tvAvgPaceUnit$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = SportDetailFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.tv_pace_unit);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO pacePanel$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.sport.SportDetailFragment$pacePanel$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            View mView;
            mView = SportDetailFragment.this.getMView();
            return mView.findViewById(R.id.pace_panel);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvAltitudeValue$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.SportDetailFragment$tvAltitudeValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = SportDetailFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.tv_altitude_value);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvAltitudeUnit$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.SportDetailFragment$tvAltitudeUnit$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = SportDetailFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.tv_altitude_unit);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO altitudePanel$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.sport.SportDetailFragment$altitudePanel$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            View mView;
            mView = SportDetailFragment.this.getMView();
            return mView.findViewById(R.id.altitude_panel);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvAirpressureValue$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.SportDetailFragment$tvAirpressureValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = SportDetailFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.tv_airpressure_value);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvAirpressureUnit$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.SportDetailFragment$tvAirpressureUnit$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = SportDetailFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.tv_airpressure_unit);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO airpressurePanel$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.sport.SportDetailFragment$airpressurePanel$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            View mView;
            mView = SportDetailFragment.this.getMView();
            return mView.findViewById(R.id.airpressure_panel);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvPressureValue$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.SportDetailFragment$tvPressureValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = SportDetailFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.tv_pressure_value);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO pressurePanel$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.sport.SportDetailFragment$pressurePanel$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            View mView;
            mView = SportDetailFragment.this.getMView();
            return mView.findViewById(R.id.pressure_panel);
        }
    });

    public SportDetailFragment() {
        SPUtils XO2 = com.sma.smartv3.util.Xo0.f24349oIX0oI.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        this.userProfile = (AppUser) (fromJson != null ? fromJson : appUser);
        this.mLocationDao$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LocationDao>() { // from class: com.sma.smartv3.ui.sport.SportDetailFragment$mLocationDao$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            @OXOo.OOXIXo
            public final LocationDao invoke() {
                return MyDb.INSTANCE.getMDatabase().locationDao();
            }
        });
        this.isLocationEmpty = true;
    }

    private final View getAirpressurePanel() {
        return (View) this.airpressurePanel$delegate.getValue();
    }

    private final View getAltitudePanel() {
        return (View) this.altitudePanel$delegate.getValue();
    }

    private final View getDistancePanel() {
        return (View) this.distancePanel$delegate.getValue();
    }

    private final LocationDao getMLocationDao() {
        return (LocationDao) this.mLocationDao$delegate.getValue();
    }

    private final View getPacePanel() {
        return (View) this.pacePanel$delegate.getValue();
    }

    private final View getPressurePanel() {
        return (View) this.pressurePanel$delegate.getValue();
    }

    private final NestedScrollView getRootView() {
        return (NestedScrollView) this.rootView$delegate.getValue();
    }

    private final View getSpeedPanel() {
        return (View) this.speedPanel$delegate.getValue();
    }

    private final View getSpmPanel() {
        return (View) this.spmPanel$delegate.getValue();
    }

    private final View getStepPanel() {
        return (View) this.stepPanel$delegate.getValue();
    }

    private final TextView getTvAirpressureUnit() {
        return (TextView) this.tvAirpressureUnit$delegate.getValue();
    }

    private final TextView getTvAirpressureValue() {
        return (TextView) this.tvAirpressureValue$delegate.getValue();
    }

    private final TextView getTvAltitudeUnit() {
        return (TextView) this.tvAltitudeUnit$delegate.getValue();
    }

    private final TextView getTvAltitudeValue() {
        return (TextView) this.tvAltitudeValue$delegate.getValue();
    }

    private final TextView getTvAvgHrValue() {
        return (TextView) this.tvAvgHrValue$delegate.getValue();
    }

    private final TextView getTvAvgPaceUnit() {
        return (TextView) this.tvAvgPaceUnit$delegate.getValue();
    }

    private final TextView getTvAvgPaceValue() {
        return (TextView) this.tvAvgPaceValue$delegate.getValue();
    }

    private final TextView getTvAvgSpeedUnit() {
        return (TextView) this.tvAvgSpeedUnit$delegate.getValue();
    }

    private final TextView getTvAvgSpeedValue() {
        return (TextView) this.tvAvgSpeedValue$delegate.getValue();
    }

    private final TextView getTvAvgSpmValue() {
        return (TextView) this.tvAvgSpmValue$delegate.getValue();
    }

    private final TextView getTvCaloriesValue() {
        return (TextView) this.tvCaloriesValue$delegate.getValue();
    }

    private final TextView getTvDateTime() {
        return (TextView) this.tvDateTime$delegate.getValue();
    }

    private final TextView getTvDistanceUnit() {
        return (TextView) this.tvDistanceUnit$delegate.getValue();
    }

    private final TextView getTvDistanceValue() {
        return (TextView) this.tvDistanceValue$delegate.getValue();
    }

    private final TextView getTvDuration() {
        return (TextView) this.tvDuration$delegate.getValue();
    }

    private final TextView getTvPressureValue() {
        return (TextView) this.tvPressureValue$delegate.getValue();
    }

    private final TextView getTvStepValue() {
        return (TextView) this.tvStepValue$delegate.getValue();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.BaseFragment, com.bestmafen.androidbase.base.oIX0oI
    public boolean initEvent() {
        return true;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        boolean z;
        int Xx000oIo2;
        int i;
        int i2;
        int i3;
        int i4;
        Serializable mArg3 = getMArg3();
        kotlin.jvm.internal.IIX0o.x0XOIxOo(mArg3, "null cannot be cast to non-null type com.sma.smartv3.db.entity.Workout");
        this.mWorkout = (Workout) mArg3;
        LocationDao mLocationDao = getMLocationDao();
        Workout workout = this.mWorkout;
        Workout workout2 = null;
        if (workout == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mWorkout");
            workout = null;
        }
        long mStart = workout.getMStart();
        Workout workout3 = this.mWorkout;
        if (workout3 == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mWorkout");
            workout3 = null;
        }
        List<Location> location = mLocationDao.getLocation(mStart, workout3.getMEnd());
        if (!location.isEmpty() && location.size() >= 2) {
            z = false;
        } else {
            z = true;
        }
        this.isLocationEmpty = z;
        GridLayout gridLayout = (GridLayout) getMView().findViewById(R.id.gl);
        TextView tvDateTime = getTvDateTime();
        SimpleDateFormat oxxXoxO2 = com.sma.smartv3.util.xoIox.oxxXoxO(false, false, 3, null);
        Workout workout4 = this.mWorkout;
        if (workout4 == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mWorkout");
            workout4 = null;
        }
        tvDateTime.setText(oxxXoxO2.format(new Date(workout4.getMStart())));
        TextView tvDuration = getTvDuration();
        Workout workout5 = this.mWorkout;
        if (workout5 == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mWorkout");
            workout5 = null;
        }
        tvDuration.setText(com.sma.smartv3.util.xoIox.IoOoX(workout5.getMDuration() * 1000));
        TextView tvCaloriesValue = getTvCaloriesValue();
        Workout workout6 = this.mWorkout;
        if (workout6 == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mWorkout");
            workout6 = null;
        }
        tvCaloriesValue.setText(String.valueOf(workout6.getMCalorie() / 1000));
        TextView tvAvgHrValue = getTvAvgHrValue();
        Workout workout7 = this.mWorkout;
        if (workout7 == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mWorkout");
            workout7 = null;
        }
        tvAvgHrValue.setText(String.valueOf(workout7.getMAvgBpm()));
        ProductManager productManager = ProductManager.f20544oIX0oI;
        Workout workout8 = this.mWorkout;
        if (workout8 == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mWorkout");
            workout8 = null;
        }
        if (productManager.IOooo0o(workout8.getMMode())) {
            TextView tvStepValue = getTvStepValue();
            Workout workout9 = this.mWorkout;
            if (workout9 == null) {
                kotlin.jvm.internal.IIX0o.XOxIOxOx("mWorkout");
                workout9 = null;
            }
            tvStepValue.setText(String.valueOf(workout9.getMStep()));
            TextView tvAvgSpmValue = getTvAvgSpmValue();
            Workout workout10 = this.mWorkout;
            if (workout10 == null) {
                kotlin.jvm.internal.IIX0o.XOxIOxOx("mWorkout");
                workout10 = null;
            }
            tvAvgSpmValue.setText(String.valueOf(workout10.getMSpm()));
        } else {
            gridLayout.removeView(getStepPanel());
            gridLayout.removeView(getSpmPanel());
        }
        Workout workout11 = this.mWorkout;
        if (workout11 == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mWorkout");
            workout11 = null;
        }
        if (ProductManager.IXX(productManager, workout11.getMMode(), false, 2, null)) {
            TextView tvDistanceValue = getTvDistanceValue();
            Workout workout12 = this.mWorkout;
            if (workout12 == null) {
                kotlin.jvm.internal.IIX0o.XOxIOxOx("mWorkout");
                workout12 = null;
            }
            tvDistanceValue.setText(String.valueOf(TextConvertKt.ooOOo0oXI(workout12.getMDistance(), this.userProfile.getUnit(), false, 4, null)));
            getTvDistanceUnit().setText(getString(TextConvertKt.oI0IIXIo(this.userProfile.getUnit())));
            TextView tvAvgSpeedValue = getTvAvgSpeedValue();
            Workout workout13 = this.mWorkout;
            if (workout13 == null) {
                kotlin.jvm.internal.IIX0o.XOxIOxOx("mWorkout");
                workout13 = null;
            }
            tvAvgSpeedValue.setText(String.valueOf(TextConvertKt.xo0x(workout13.getMSpeed() / 1000.0d, this.userProfile.getUnit())));
            TextView tvAvgSpeedUnit = getTvAvgSpeedUnit();
            if (this.userProfile.getUnit() == 0) {
                i3 = R.string.km_h;
            } else {
                i3 = R.string.mi_h;
            }
            tvAvgSpeedUnit.setText(getString(i3));
            TextView tvAvgPaceValue = getTvAvgPaceValue();
            Workout workout14 = this.mWorkout;
            if (workout14 == null) {
                kotlin.jvm.internal.IIX0o.XOxIOxOx("mWorkout");
                workout14 = null;
            }
            tvAvgPaceValue.setText(TextConvertKt.OI0(workout14.getMPace(), this.userProfile.getUnit()));
            TextView tvAvgPaceUnit = getTvAvgPaceUnit();
            if (this.userProfile.getUnit() == 0) {
                i4 = R.string.pace_km;
            } else {
                i4 = R.string.pace_mi;
            }
            tvAvgPaceUnit.setText(getString(i4));
        } else {
            gridLayout.removeView(getDistancePanel());
            gridLayout.removeView(getSpeedPanel());
            gridLayout.removeView(getPacePanel());
        }
        Workout workout15 = this.mWorkout;
        if (workout15 == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mWorkout");
            workout15 = null;
        }
        if (productManager.OooO0XOx(workout15.getMMode(), true ^ this.isLocationEmpty)) {
            TextView tvAltitudeValue = getTvAltitudeValue();
            Workout workout16 = this.mWorkout;
            if (workout16 == null) {
                kotlin.jvm.internal.IIX0o.XOxIOxOx("mWorkout");
                workout16 = null;
            }
            tvAltitudeValue.setText(TextConvertKt.X00IoxXI(workout16.getMAltitude(), this.userProfile.getUnit()));
            TextView tvAltitudeUnit = getTvAltitudeUnit();
            if (this.userProfile.getUnit() == 0) {
                i2 = R.string.m;
            } else {
                i2 = R.string.yd;
            }
            tvAltitudeUnit.setText(getString(i2));
        } else {
            gridLayout.removeView(getAltitudePanel());
        }
        Workout workout17 = this.mWorkout;
        if (workout17 == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mWorkout");
            workout17 = null;
        }
        if (workout17.getMAirPressure() != 0) {
            TextView tvAirpressureValue = getTvAirpressureValue();
            if (this.userProfile.getUnit() == 0) {
                Workout workout18 = this.mWorkout;
                if (workout18 == null) {
                    kotlin.jvm.internal.IIX0o.XOxIOxOx("mWorkout");
                    workout18 = null;
                }
                Xx000oIo2 = workout18.getMAirPressure();
            } else {
                Workout workout19 = this.mWorkout;
                if (workout19 == null) {
                    kotlin.jvm.internal.IIX0o.XOxIOxOx("mWorkout");
                    workout19 = null;
                }
                Xx000oIo2 = (int) TextConvertKt.Xx000oIo(workout19.getMAirPressure());
            }
            tvAirpressureValue.setText(String.valueOf(Xx000oIo2));
            TextView tvAirpressureUnit = getTvAirpressureUnit();
            if (this.userProfile.getUnit() == 0) {
                i = R.string.kpa;
            } else {
                i = R.string.psi;
            }
            tvAirpressureUnit.setText(getString(i));
        } else {
            gridLayout.removeView(getAirpressurePanel());
        }
        Workout workout20 = this.mWorkout;
        if (workout20 == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mWorkout");
            workout20 = null;
        }
        if (productManager.xx(workout20.getMMode())) {
            TextView tvPressureValue = getTvPressureValue();
            Workout workout21 = this.mWorkout;
            if (workout21 == null) {
                kotlin.jvm.internal.IIX0o.XOxIOxOx("mWorkout");
            } else {
                workout2 = workout21;
            }
            tvPressureValue.setText(String.valueOf(workout2.getMAvgStress()));
            return;
        }
        gridLayout.removeView(getPressurePanel());
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.fragment_sport_detail;
    }

    public final void share() {
        com.sma.smartv3.util.Oxx0IOOO oxx0IOOO = com.sma.smartv3.util.Oxx0IOOO.f24316oIX0oI;
        NestedScrollView rootView = getRootView();
        kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
        ImageUtils.save(oxx0IOOO.I0Io(rootView), com.sma.smartv3.initializer.IXxxXO.oxXx0IX(X00IoxXI.oIX0oI.f3233oIX0oI), Bitmap.CompressFormat.PNG);
    }
}
