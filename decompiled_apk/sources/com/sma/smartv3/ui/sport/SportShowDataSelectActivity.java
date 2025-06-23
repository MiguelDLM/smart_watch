package com.sma.smartv3.ui.sport;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.angcyo.dsladapter.DslAdapter;
import com.angcyo.dsladapter.DslAdapterExKt;
import com.angcyo.dsladapter.DslAdapterItem;
import com.angcyo.dsladapter.DslViewHolder;
import com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.google.gson.Gson;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.entity.Location;
import com.sma.smartv3.db.entity.SportData;
import com.sma.smartv3.model.AppUser;
import com.sma.smartv3.ui.sport.SportManager;
import com.sma.smartv3.ui.sport.SportShowDataSelectActivity$mSportCallback$2;
import com.sma.smartv3.util.TextConvertKt;
import com.sma.smartv3.view.text.DINCondBold;
import com.sma.smartv3.view.text.PFMedium;
import com.szabh.smable3.entity.BleAppSportState;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.oXIO0o0XI;

@kotlin.jvm.internal.XX({"SMAP\nSportShowDataSelectActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SportShowDataSelectActivity.kt\ncom/sma/smartv3/ui/sport/SportShowDataSelectActivity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,315:1\n19#2:316\n15#2:317\n86#2,2:318\n94#2:320\n90#2:321\n*S KotlinDebug\n*F\n+ 1 SportShowDataSelectActivity.kt\ncom/sma/smartv3/ui/sport/SportShowDataSelectActivity\n*L\n29#1:316\n29#1:317\n68#1:318,2\n129#1:320\n129#1:321\n*E\n"})
/* loaded from: classes12.dex */
public final class SportShowDataSelectActivity extends BaseDSLRecyclerActivity {

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mSportCallback$delegate;
    private XIxXXX0x0 sportDataOrder;
    private SportDataType type;

    @OXOo.OOXIXo
    private final AppUser userProfile;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO itemValue$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.sport.SportShowDataSelectActivity$itemValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            return (DINCondBold) SportShowDataSelectActivity.this.findViewById(R.id.itemValue);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO itemDesc$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.sport.SportShowDataSelectActivity$itemDesc$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) SportShowDataSelectActivity.this.findViewById(R.id.itemDesc);
        }
    });

    /* loaded from: classes12.dex */
    public /* synthetic */ class oIX0oI {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f23857oIX0oI;

        static {
            int[] iArr = new int[SportDataType.values().length];
            try {
                iArr[SportDataType.TIME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SportDataType.DISTANCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SportDataType.PACE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SportDataType.CALORIES.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[SportDataType.STEP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[SportDataType.SPM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[SportDataType.ALTITUDE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[SportDataType.HEARTRATE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[SportDataType.SPEED.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            f23857oIX0oI = iArr;
        }
    }

    public SportShowDataSelectActivity() {
        SPUtils XO2 = com.sma.smartv3.util.Xo0.f24349oIX0oI.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        this.userProfile = (AppUser) (fromJson != null ? fromJson : appUser);
        this.mSportCallback$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<SportShowDataSelectActivity$mSportCallback$2.oIX0oI>() { // from class: com.sma.smartv3.ui.sport.SportShowDataSelectActivity$mSportCallback$2

            /* loaded from: classes12.dex */
            public static final class oIX0oI implements SportManager.oIX0oI {

                /* renamed from: oIX0oI, reason: collision with root package name */
                public final /* synthetic */ SportShowDataSelectActivity f23856oIX0oI;

                public oIX0oI(SportShowDataSelectActivity sportShowDataSelectActivity) {
                    this.f23856oIX0oI = sportShowDataSelectActivity;
                }

                @Override // com.sma.smartv3.ui.sport.SportManager.oIX0oI
                public void I0Io(boolean z) {
                    SportManager.oIX0oI.C0990oIX0oI.oIX0oI(this, z);
                }

                @Override // com.sma.smartv3.ui.sport.SportManager.oIX0oI
                public void II0xO0(@OXOo.OOXIXo BleAppSportState bleAppSportState) {
                    SportManager.oIX0oI.C0990oIX0oI.X0o0xo(this, bleAppSportState);
                }

                @Override // com.sma.smartv3.ui.sport.SportManager.oIX0oI
                public void X0o0xo(@OXOo.OOXIXo SportData sportData) {
                    SportDataType sportDataType;
                    kotlin.jvm.internal.IIX0o.x0xO0oo(sportData, "sportData");
                    SportShowDataSelectActivity sportShowDataSelectActivity = this.f23856oIX0oI;
                    sportDataType = sportShowDataSelectActivity.type;
                    if (sportDataType == null) {
                        kotlin.jvm.internal.IIX0o.XOxIOxOx("type");
                        sportDataType = null;
                    }
                    sportShowDataSelectActivity.showItemValue(sportDataType, sportData);
                }

                @Override // com.sma.smartv3.ui.sport.SportManager.oIX0oI
                public void oIX0oI(int i) {
                    SportManager.oIX0oI.C0990oIX0oI.II0xO0(this, i);
                }

                @Override // com.sma.smartv3.ui.sport.SportManager.oIX0oI
                public void oxoX(@OXOo.OOXIXo Location location) {
                    SportManager.oIX0oI.C0990oIX0oI.I0Io(this, location);
                }
            }

            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            @OXOo.OOXIXo
            public final oIX0oI invoke() {
                return new oIX0oI(SportShowDataSelectActivity.this);
            }
        });
    }

    private final SportShowDataSelectActivity$mSportCallback$2.oIX0oI getMSportCallback() {
        return (SportShowDataSelectActivity$mSportCallback$2.oIX0oI) this.mSportCallback$delegate.getValue();
    }

    private final Pair<String, String> getOneContent(SportDataType sportDataType, SportData sportData) {
        switch (oIX0oI.f23857oIX0oI[sportDataType.ordinal()]) {
            case 1:
                return new Pair<>(com.sma.smartv3.util.xoIox.IoOoX(sportData.getMDuration() * 1000), getString(R.string.time));
            case 2:
                return new Pair<>(String.valueOf(TextConvertKt.ooOOo0oXI(sportData.getMDistance(), this.userProfile.getUnit(), false, 4, null)), getString(R.string.distance));
            case 3:
                return new Pair<>(TextConvertKt.OI0(sportData.getMPace(), this.userProfile.getUnit()), getString(R.string.pace));
            case 4:
                return new Pair<>(String.valueOf(sportData.getMCalorie()), getString(R.string.calories));
            case 5:
                return new Pair<>(String.valueOf(sportData.getMStep()), getString(R.string.steps));
            case 6:
                return new Pair<>(String.valueOf(sportData.getMSpm()), getString(R.string.spm));
            case 7:
                return new Pair<>(String.valueOf(sportData.getMAltitude()), getString(R.string.altitude));
            case 8:
                return new Pair<>(String.valueOf(SportManager.f23843oIX0oI.IIXOooo()), getString(R.string.heart_rate));
            case 9:
                return new Pair<>(String.valueOf(TextConvertKt.ooOOo0oXI(sportData.getMSpeed(), this.userProfile.getUnit(), false, 4, null)), getString(R.string.speed));
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showData(SportDataType sportDataType) {
        XIxXXX0x0 xIxXXX0x0 = this.sportDataOrder;
        XIxXXX0x0 xIxXXX0x02 = null;
        if (xIxXXX0x0 == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("sportDataOrder");
            xIxXXX0x0 = null;
        }
        for (Map.Entry<SportDataType, Integer> entry : xIxXXX0x0.oxoX().entrySet()) {
            SportDataType key = entry.getKey();
            if (entry.getValue().intValue() == getMArg1()) {
                XIxXXX0x0 xIxXXX0x03 = this.sportDataOrder;
                if (xIxXXX0x03 == null) {
                    kotlin.jvm.internal.IIX0o.XOxIOxOx("sportDataOrder");
                    xIxXXX0x03 = null;
                }
                xIxXXX0x03.oxoX().put(key, 0);
            }
        }
        XIxXXX0x0 xIxXXX0x04 = this.sportDataOrder;
        if (xIxXXX0x04 == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("sportDataOrder");
            xIxXXX0x04 = null;
        }
        xIxXXX0x04.oxoX().put(sportDataType, Integer.valueOf(getMArg1()));
        this.type = sportDataType;
        if (sportDataType == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("type");
            sportDataType = null;
        }
        SportManager sportManager = SportManager.f23843oIX0oI;
        showItemValue(sportDataType, sportManager.O0xOxO());
        SPUtils XO2 = com.sma.smartv3.util.Xo0.f24349oIX0oI.XO();
        String valueOf = String.valueOf(sportManager.O0xOxO().getMMode());
        XIxXXX0x0 xIxXXX0x05 = this.sportDataOrder;
        if (xIxXXX0x05 == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("sportDataOrder");
            xIxXXX0x05 = null;
        }
        XO2.put(valueOf + '_' + XIxXXX0x0.class.getName(), new Gson().toJson(xIxXXX0x05));
        XIxXXX0x0 xIxXXX0x06 = this.sportDataOrder;
        if (xIxXXX0x06 == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("sportDataOrder");
        } else {
            xIxXXX0x02 = xIxXXX0x06;
        }
        LogUtils.i("sportDataOrder", xIxXXX0x02);
        new Handler().postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.sport.OO0x0xX
            @Override // java.lang.Runnable
            public final void run() {
                SportShowDataSelectActivity.showData$lambda$0(SportShowDataSelectActivity.this);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showData$lambda$0(SportShowDataSelectActivity this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showItemValue(SportDataType sportDataType, SportData sportData) {
        Pair<String, String> oneContent = getOneContent(sportDataType, sportData);
        String component1 = oneContent.component1();
        String component2 = oneContent.component2();
        getItemValue().setText(component1);
        getItemDesc().setText(component2);
    }

    public final PFMedium getItemDesc() {
        return (PFMedium) this.itemDesc$delegate.getValue();
    }

    public final DINCondBold getItemValue() {
        return (DINCondBold) this.itemValue$delegate.getValue();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_sport_show_data_select;
    }

    @Override // com.bestmafen.androidbase.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        SportManager.f23843oIX0oI.x0o(getMSportCallback());
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity
    public void onInitBaseLayoutAfter() {
        super.onInitBaseLayoutAfter();
        SPUtils XO2 = com.sma.smartv3.util.Xo0.f24349oIX0oI.XO();
        String valueOf = String.valueOf(SportManager.f23843oIX0oI.O0xOxO().getMMode());
        SportDataType sportDataType = null;
        Object xIxXXX0x0 = new XIxXXX0x0(null, 1, null);
        Object fromJson = new Gson().fromJson(XO2.getString(valueOf + '_' + XIxXXX0x0.class.getName()), (Class<Object>) XIxXXX0x0.class);
        if (fromJson != null) {
            xIxXXX0x0 = fromJson;
        }
        XIxXXX0x0 xIxXXX0x02 = (XIxXXX0x0) xIxXXX0x0;
        this.sportDataOrder = xIxXXX0x02;
        for (Map.Entry<SportDataType, Integer> entry : xIxXXX0x02.oxoX().entrySet()) {
            SportDataType key = entry.getKey();
            if (entry.getValue().intValue() == getMArg1()) {
                this.type = key;
            }
        }
        SportDataType sportDataType2 = this.type;
        if (sportDataType2 == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("type");
        } else {
            sportDataType = sportDataType2;
        }
        SportManager sportManager = SportManager.f23843oIX0oI;
        showItemValue(sportDataType, sportManager.O0xOxO());
        sportManager.oOoXoXO(getMSportCallback());
        setTitle("");
        getRecyclerView().setLayoutManager(new StaggeredGridLayoutManager(3, 1));
        renderAdapter(new Oox.oOoXoXO<DslAdapter, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.SportShowDataSelectActivity$onInitBaseLayoutAfter$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslAdapter dslAdapter) {
                invoke2(dslAdapter);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo DslAdapter renderAdapter) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(renderAdapter, "$this$renderAdapter");
                DslViewHolder dslViewHolder = SportShowDataSelectActivity.this.getDslViewHolder();
                final SportShowDataSelectActivity sportShowDataSelectActivity = SportShowDataSelectActivity.this;
                dslViewHolder.post(new Oox.oIX0oI<oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.SportShowDataSelectActivity$onInitBaseLayoutAfter$1.1
                    {
                        super(0);
                    }

                    @Override // Oox.oIX0oI
                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke() {
                        invoke2();
                        return oXIO0o0XI.f29392oIX0oI;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        final SportShowDataSelectActivity sportShowDataSelectActivity2 = SportShowDataSelectActivity.this;
                        sportShowDataSelectActivity2.renderAdapter(new Oox.oOoXoXO<DslAdapter, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.SportShowDataSelectActivity.onInitBaseLayoutAfter.1.1.1
                            {
                                super(1);
                            }

                            @Override // Oox.oOoXoXO
                            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslAdapter dslAdapter) {
                                invoke2(dslAdapter);
                                return oXIO0o0XI.f29392oIX0oI;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@OXOo.OOXIXo DslAdapter renderAdapter2) {
                                kotlin.jvm.internal.IIX0o.x0xO0oo(renderAdapter2, "$this$renderAdapter");
                                final SportShowDataSelectActivity sportShowDataSelectActivity3 = SportShowDataSelectActivity.this;
                                DslAdapterExKt.oO(renderAdapter2, R.layout.item_sport_data, new Oox.oOoXoXO<DslAdapterItem, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.SportShowDataSelectActivity.onInitBaseLayoutAfter.1.1.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // Oox.oOoXoXO
                                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslAdapterItem dslAdapterItem) {
                                        invoke2(dslAdapterItem);
                                        return oXIO0o0XI.f29392oIX0oI;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(@OXOo.OOXIXo DslAdapterItem dslItem) {
                                        XIxXXX0x0 xIxXXX0x03;
                                        final int i;
                                        kotlin.jvm.internal.IIX0o.x0xO0oo(dslItem, "$this$dslItem");
                                        xIxXXX0x03 = SportShowDataSelectActivity.this.sportDataOrder;
                                        if (xIxXXX0x03 == null) {
                                            kotlin.jvm.internal.IIX0o.XOxIOxOx("sportDataOrder");
                                            xIxXXX0x03 = null;
                                        }
                                        Integer num = xIxXXX0x03.oxoX().get(SportDataType.TIME);
                                        if (num != null && num.intValue() == 0) {
                                            final SportShowDataSelectActivity sportShowDataSelectActivity4 = SportShowDataSelectActivity.this;
                                            dslItem.setItemClick(new Oox.oOoXoXO<View, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.SportShowDataSelectActivity.onInitBaseLayoutAfter.1.1.1.1.1
                                                {
                                                    super(1);
                                                }

                                                @Override // Oox.oOoXoXO
                                                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(View view) {
                                                    invoke2(view);
                                                    return oXIO0o0XI.f29392oIX0oI;
                                                }

                                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                public final void invoke2(@OXOo.OOXIXo View it) {
                                                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                                                    SportShowDataSelectActivity.this.showData(SportDataType.TIME);
                                                }
                                            });
                                            i = R.drawable.icon_time_n_108;
                                        } else {
                                            i = R.drawable.icon_time_108;
                                        }
                                        dslItem.setItemBindOverride(new Oox.Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.SportShowDataSelectActivity.onInitBaseLayoutAfter.1.1.1.1.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(4);
                                            }

                                            @Override // Oox.Oxx0xo
                                            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslViewHolder dslViewHolder2, Integer num2, DslAdapterItem dslAdapterItem, List<? extends Object> list) {
                                                invoke(dslViewHolder2, num2.intValue(), dslAdapterItem, list);
                                                return oXIO0o0XI.f29392oIX0oI;
                                            }

                                            public final void invoke(@OXOo.OOXIXo DslViewHolder itemHolder, int i2, @OXOo.OOXIXo DslAdapterItem dslAdapterItem, @OXOo.OOXIXo List<? extends Object> list) {
                                                kotlin.jvm.internal.IIX0o.x0xO0oo(itemHolder, "itemHolder");
                                                kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "<anonymous parameter 2>");
                                                kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<anonymous parameter 3>");
                                                TextView tv = itemHolder.tv(R.id.tv);
                                                if (tv != null) {
                                                    tv.setText(R.string.time);
                                                }
                                                ImageView img = itemHolder.img(R.id.iv);
                                                if (img != null) {
                                                    img.setImageResource(i);
                                                }
                                            }
                                        });
                                    }
                                });
                                final SportShowDataSelectActivity sportShowDataSelectActivity4 = SportShowDataSelectActivity.this;
                                DslAdapterExKt.oO(renderAdapter2, R.layout.item_sport_data, new Oox.oOoXoXO<DslAdapterItem, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.SportShowDataSelectActivity.onInitBaseLayoutAfter.1.1.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // Oox.oOoXoXO
                                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslAdapterItem dslAdapterItem) {
                                        invoke2(dslAdapterItem);
                                        return oXIO0o0XI.f29392oIX0oI;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(@OXOo.OOXIXo DslAdapterItem dslItem) {
                                        XIxXXX0x0 xIxXXX0x03;
                                        final int i;
                                        kotlin.jvm.internal.IIX0o.x0xO0oo(dslItem, "$this$dslItem");
                                        xIxXXX0x03 = SportShowDataSelectActivity.this.sportDataOrder;
                                        if (xIxXXX0x03 == null) {
                                            kotlin.jvm.internal.IIX0o.XOxIOxOx("sportDataOrder");
                                            xIxXXX0x03 = null;
                                        }
                                        Integer num = xIxXXX0x03.oxoX().get(SportDataType.DISTANCE);
                                        if (num != null && num.intValue() == 0) {
                                            final SportShowDataSelectActivity sportShowDataSelectActivity5 = SportShowDataSelectActivity.this;
                                            dslItem.setItemClick(new Oox.oOoXoXO<View, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.SportShowDataSelectActivity.onInitBaseLayoutAfter.1.1.1.2.1
                                                {
                                                    super(1);
                                                }

                                                @Override // Oox.oOoXoXO
                                                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(View view) {
                                                    invoke2(view);
                                                    return oXIO0o0XI.f29392oIX0oI;
                                                }

                                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                public final void invoke2(@OXOo.OOXIXo View it) {
                                                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                                                    SportShowDataSelectActivity.this.showData(SportDataType.DISTANCE);
                                                }
                                            });
                                            i = R.drawable.icon_distance_n_108;
                                        } else {
                                            i = R.drawable.icon_distance_108;
                                        }
                                        dslItem.setItemBindOverride(new Oox.Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.SportShowDataSelectActivity.onInitBaseLayoutAfter.1.1.1.2.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(4);
                                            }

                                            @Override // Oox.Oxx0xo
                                            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslViewHolder dslViewHolder2, Integer num2, DslAdapterItem dslAdapterItem, List<? extends Object> list) {
                                                invoke(dslViewHolder2, num2.intValue(), dslAdapterItem, list);
                                                return oXIO0o0XI.f29392oIX0oI;
                                            }

                                            public final void invoke(@OXOo.OOXIXo DslViewHolder itemHolder, int i2, @OXOo.OOXIXo DslAdapterItem dslAdapterItem, @OXOo.OOXIXo List<? extends Object> list) {
                                                kotlin.jvm.internal.IIX0o.x0xO0oo(itemHolder, "itemHolder");
                                                kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "<anonymous parameter 2>");
                                                kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<anonymous parameter 3>");
                                                TextView tv = itemHolder.tv(R.id.tv);
                                                if (tv != null) {
                                                    tv.setText(R.string.distance);
                                                }
                                                ImageView img = itemHolder.img(R.id.iv);
                                                if (img != null) {
                                                    img.setImageResource(i);
                                                }
                                            }
                                        });
                                    }
                                });
                                SportManager sportManager2 = SportManager.f23843oIX0oI;
                                if (sportManager2.O0xOxO().getMMode() == 10) {
                                    final SportShowDataSelectActivity sportShowDataSelectActivity5 = SportShowDataSelectActivity.this;
                                    DslAdapterExKt.oO(renderAdapter2, R.layout.item_sport_data, new Oox.oOoXoXO<DslAdapterItem, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.SportShowDataSelectActivity.onInitBaseLayoutAfter.1.1.1.3
                                        {
                                            super(1);
                                        }

                                        @Override // Oox.oOoXoXO
                                        public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslAdapterItem dslAdapterItem) {
                                            invoke2(dslAdapterItem);
                                            return oXIO0o0XI.f29392oIX0oI;
                                        }

                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(@OXOo.OOXIXo DslAdapterItem dslItem) {
                                            XIxXXX0x0 xIxXXX0x03;
                                            final int i;
                                            kotlin.jvm.internal.IIX0o.x0xO0oo(dslItem, "$this$dslItem");
                                            xIxXXX0x03 = SportShowDataSelectActivity.this.sportDataOrder;
                                            if (xIxXXX0x03 == null) {
                                                kotlin.jvm.internal.IIX0o.XOxIOxOx("sportDataOrder");
                                                xIxXXX0x03 = null;
                                            }
                                            Integer num = xIxXXX0x03.oxoX().get(SportDataType.SPEED);
                                            if (num != null && num.intValue() == 0) {
                                                final SportShowDataSelectActivity sportShowDataSelectActivity6 = SportShowDataSelectActivity.this;
                                                dslItem.setItemClick(new Oox.oOoXoXO<View, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.SportShowDataSelectActivity.onInitBaseLayoutAfter.1.1.1.3.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // Oox.oOoXoXO
                                                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(View view) {
                                                        invoke2(view);
                                                        return oXIO0o0XI.f29392oIX0oI;
                                                    }

                                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                    public final void invoke2(@OXOo.OOXIXo View it) {
                                                        kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                                                        SportShowDataSelectActivity.this.showData(SportDataType.SPEED);
                                                    }
                                                });
                                                i = R.drawable.icon_speed_no_108;
                                            } else {
                                                i = R.drawable.icon_speed_108;
                                            }
                                            dslItem.setItemBindOverride(new Oox.Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.SportShowDataSelectActivity.onInitBaseLayoutAfter.1.1.1.3.2
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(4);
                                                }

                                                @Override // Oox.Oxx0xo
                                                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslViewHolder dslViewHolder2, Integer num2, DslAdapterItem dslAdapterItem, List<? extends Object> list) {
                                                    invoke(dslViewHolder2, num2.intValue(), dslAdapterItem, list);
                                                    return oXIO0o0XI.f29392oIX0oI;
                                                }

                                                public final void invoke(@OXOo.OOXIXo DslViewHolder itemHolder, int i2, @OXOo.OOXIXo DslAdapterItem dslAdapterItem, @OXOo.OOXIXo List<? extends Object> list) {
                                                    kotlin.jvm.internal.IIX0o.x0xO0oo(itemHolder, "itemHolder");
                                                    kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "<anonymous parameter 2>");
                                                    kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<anonymous parameter 3>");
                                                    TextView tv = itemHolder.tv(R.id.tv);
                                                    if (tv != null) {
                                                        tv.setText(R.string.speed);
                                                    }
                                                    ImageView img = itemHolder.img(R.id.iv);
                                                    if (img != null) {
                                                        img.setImageResource(i);
                                                    }
                                                }
                                            });
                                        }
                                    });
                                } else {
                                    final SportShowDataSelectActivity sportShowDataSelectActivity6 = SportShowDataSelectActivity.this;
                                    DslAdapterExKt.oO(renderAdapter2, R.layout.item_sport_data, new Oox.oOoXoXO<DslAdapterItem, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.SportShowDataSelectActivity.onInitBaseLayoutAfter.1.1.1.4
                                        {
                                            super(1);
                                        }

                                        @Override // Oox.oOoXoXO
                                        public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslAdapterItem dslAdapterItem) {
                                            invoke2(dslAdapterItem);
                                            return oXIO0o0XI.f29392oIX0oI;
                                        }

                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(@OXOo.OOXIXo DslAdapterItem dslItem) {
                                            XIxXXX0x0 xIxXXX0x03;
                                            final int i;
                                            kotlin.jvm.internal.IIX0o.x0xO0oo(dslItem, "$this$dslItem");
                                            xIxXXX0x03 = SportShowDataSelectActivity.this.sportDataOrder;
                                            if (xIxXXX0x03 == null) {
                                                kotlin.jvm.internal.IIX0o.XOxIOxOx("sportDataOrder");
                                                xIxXXX0x03 = null;
                                            }
                                            Integer num = xIxXXX0x03.oxoX().get(SportDataType.PACE);
                                            if (num != null && num.intValue() == 0) {
                                                final SportShowDataSelectActivity sportShowDataSelectActivity7 = SportShowDataSelectActivity.this;
                                                dslItem.setItemClick(new Oox.oOoXoXO<View, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.SportShowDataSelectActivity.onInitBaseLayoutAfter.1.1.1.4.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // Oox.oOoXoXO
                                                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(View view) {
                                                        invoke2(view);
                                                        return oXIO0o0XI.f29392oIX0oI;
                                                    }

                                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                    public final void invoke2(@OXOo.OOXIXo View it) {
                                                        kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                                                        SportShowDataSelectActivity.this.showData(SportDataType.PACE);
                                                    }
                                                });
                                                i = R.drawable.icon_pace_n_108;
                                            } else {
                                                i = R.drawable.icon_pace_108;
                                            }
                                            dslItem.setItemBindOverride(new Oox.Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.SportShowDataSelectActivity.onInitBaseLayoutAfter.1.1.1.4.2
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(4);
                                                }

                                                @Override // Oox.Oxx0xo
                                                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslViewHolder dslViewHolder2, Integer num2, DslAdapterItem dslAdapterItem, List<? extends Object> list) {
                                                    invoke(dslViewHolder2, num2.intValue(), dslAdapterItem, list);
                                                    return oXIO0o0XI.f29392oIX0oI;
                                                }

                                                public final void invoke(@OXOo.OOXIXo DslViewHolder itemHolder, int i2, @OXOo.OOXIXo DslAdapterItem dslAdapterItem, @OXOo.OOXIXo List<? extends Object> list) {
                                                    kotlin.jvm.internal.IIX0o.x0xO0oo(itemHolder, "itemHolder");
                                                    kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "<anonymous parameter 2>");
                                                    kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<anonymous parameter 3>");
                                                    TextView tv = itemHolder.tv(R.id.tv);
                                                    if (tv != null) {
                                                        tv.setText(R.string.pace);
                                                    }
                                                    ImageView img = itemHolder.img(R.id.iv);
                                                    if (img != null) {
                                                        img.setImageResource(i);
                                                    }
                                                }
                                            });
                                        }
                                    });
                                }
                                final SportShowDataSelectActivity sportShowDataSelectActivity7 = SportShowDataSelectActivity.this;
                                DslAdapterExKt.oO(renderAdapter2, R.layout.item_sport_data, new Oox.oOoXoXO<DslAdapterItem, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.SportShowDataSelectActivity.onInitBaseLayoutAfter.1.1.1.5
                                    {
                                        super(1);
                                    }

                                    @Override // Oox.oOoXoXO
                                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslAdapterItem dslAdapterItem) {
                                        invoke2(dslAdapterItem);
                                        return oXIO0o0XI.f29392oIX0oI;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(@OXOo.OOXIXo DslAdapterItem dslItem) {
                                        XIxXXX0x0 xIxXXX0x03;
                                        final int i;
                                        kotlin.jvm.internal.IIX0o.x0xO0oo(dslItem, "$this$dslItem");
                                        xIxXXX0x03 = SportShowDataSelectActivity.this.sportDataOrder;
                                        if (xIxXXX0x03 == null) {
                                            kotlin.jvm.internal.IIX0o.XOxIOxOx("sportDataOrder");
                                            xIxXXX0x03 = null;
                                        }
                                        Integer num = xIxXXX0x03.oxoX().get(SportDataType.CALORIES);
                                        if (num != null && num.intValue() == 0) {
                                            final SportShowDataSelectActivity sportShowDataSelectActivity8 = SportShowDataSelectActivity.this;
                                            dslItem.setItemClick(new Oox.oOoXoXO<View, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.SportShowDataSelectActivity.onInitBaseLayoutAfter.1.1.1.5.1
                                                {
                                                    super(1);
                                                }

                                                @Override // Oox.oOoXoXO
                                                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(View view) {
                                                    invoke2(view);
                                                    return oXIO0o0XI.f29392oIX0oI;
                                                }

                                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                public final void invoke2(@OXOo.OOXIXo View it) {
                                                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                                                    SportShowDataSelectActivity.this.showData(SportDataType.CALORIES);
                                                }
                                            });
                                            i = R.drawable.icon_calories_n_108;
                                        } else {
                                            i = R.drawable.icon_calories_108;
                                        }
                                        dslItem.setItemBindOverride(new Oox.Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.SportShowDataSelectActivity.onInitBaseLayoutAfter.1.1.1.5.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(4);
                                            }

                                            @Override // Oox.Oxx0xo
                                            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslViewHolder dslViewHolder2, Integer num2, DslAdapterItem dslAdapterItem, List<? extends Object> list) {
                                                invoke(dslViewHolder2, num2.intValue(), dslAdapterItem, list);
                                                return oXIO0o0XI.f29392oIX0oI;
                                            }

                                            public final void invoke(@OXOo.OOXIXo DslViewHolder itemHolder, int i2, @OXOo.OOXIXo DslAdapterItem dslAdapterItem, @OXOo.OOXIXo List<? extends Object> list) {
                                                kotlin.jvm.internal.IIX0o.x0xO0oo(itemHolder, "itemHolder");
                                                kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "<anonymous parameter 2>");
                                                kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<anonymous parameter 3>");
                                                TextView tv = itemHolder.tv(R.id.tv);
                                                if (tv != null) {
                                                    tv.setText(R.string.calories);
                                                }
                                                ImageView img = itemHolder.img(R.id.iv);
                                                if (img != null) {
                                                    img.setImageResource(i);
                                                }
                                            }
                                        });
                                    }
                                });
                                final SportShowDataSelectActivity sportShowDataSelectActivity8 = SportShowDataSelectActivity.this;
                                DslAdapterExKt.oO(renderAdapter2, R.layout.item_sport_data, new Oox.oOoXoXO<DslAdapterItem, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.SportShowDataSelectActivity.onInitBaseLayoutAfter.1.1.1.6
                                    {
                                        super(1);
                                    }

                                    @Override // Oox.oOoXoXO
                                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslAdapterItem dslAdapterItem) {
                                        invoke2(dslAdapterItem);
                                        return oXIO0o0XI.f29392oIX0oI;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(@OXOo.OOXIXo DslAdapterItem dslItem) {
                                        XIxXXX0x0 xIxXXX0x03;
                                        final int i;
                                        kotlin.jvm.internal.IIX0o.x0xO0oo(dslItem, "$this$dslItem");
                                        xIxXXX0x03 = SportShowDataSelectActivity.this.sportDataOrder;
                                        if (xIxXXX0x03 == null) {
                                            kotlin.jvm.internal.IIX0o.XOxIOxOx("sportDataOrder");
                                            xIxXXX0x03 = null;
                                        }
                                        Integer num = xIxXXX0x03.oxoX().get(SportDataType.HEARTRATE);
                                        if (num != null && num.intValue() == 0) {
                                            final SportShowDataSelectActivity sportShowDataSelectActivity9 = SportShowDataSelectActivity.this;
                                            dslItem.setItemClick(new Oox.oOoXoXO<View, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.SportShowDataSelectActivity.onInitBaseLayoutAfter.1.1.1.6.1
                                                {
                                                    super(1);
                                                }

                                                @Override // Oox.oOoXoXO
                                                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(View view) {
                                                    invoke2(view);
                                                    return oXIO0o0XI.f29392oIX0oI;
                                                }

                                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                public final void invoke2(@OXOo.OOXIXo View it) {
                                                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                                                    SportShowDataSelectActivity.this.showData(SportDataType.HEARTRATE);
                                                }
                                            });
                                            i = R.drawable.icon_n_hr_108;
                                        } else {
                                            i = R.drawable.icon_hr_108;
                                        }
                                        dslItem.setItemBindOverride(new Oox.Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.SportShowDataSelectActivity.onInitBaseLayoutAfter.1.1.1.6.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(4);
                                            }

                                            @Override // Oox.Oxx0xo
                                            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslViewHolder dslViewHolder2, Integer num2, DslAdapterItem dslAdapterItem, List<? extends Object> list) {
                                                invoke(dslViewHolder2, num2.intValue(), dslAdapterItem, list);
                                                return oXIO0o0XI.f29392oIX0oI;
                                            }

                                            public final void invoke(@OXOo.OOXIXo DslViewHolder itemHolder, int i2, @OXOo.OOXIXo DslAdapterItem dslAdapterItem, @OXOo.OOXIXo List<? extends Object> list) {
                                                kotlin.jvm.internal.IIX0o.x0xO0oo(itemHolder, "itemHolder");
                                                kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "<anonymous parameter 2>");
                                                kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<anonymous parameter 3>");
                                                TextView tv = itemHolder.tv(R.id.tv);
                                                if (tv != null) {
                                                    tv.setText(R.string.heart_rate);
                                                }
                                                ImageView img = itemHolder.img(R.id.iv);
                                                if (img != null) {
                                                    img.setImageResource(i);
                                                }
                                            }
                                        });
                                    }
                                });
                                ProductManager productManager = ProductManager.f20544oIX0oI;
                                if (productManager.IOooo0o(sportManager2.O0xOxO().getMMode())) {
                                    final SportShowDataSelectActivity sportShowDataSelectActivity9 = SportShowDataSelectActivity.this;
                                    DslAdapterExKt.oO(renderAdapter2, R.layout.item_sport_data, new Oox.oOoXoXO<DslAdapterItem, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.SportShowDataSelectActivity.onInitBaseLayoutAfter.1.1.1.7
                                        {
                                            super(1);
                                        }

                                        @Override // Oox.oOoXoXO
                                        public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslAdapterItem dslAdapterItem) {
                                            invoke2(dslAdapterItem);
                                            return oXIO0o0XI.f29392oIX0oI;
                                        }

                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(@OXOo.OOXIXo DslAdapterItem dslItem) {
                                            XIxXXX0x0 xIxXXX0x03;
                                            final int i;
                                            kotlin.jvm.internal.IIX0o.x0xO0oo(dslItem, "$this$dslItem");
                                            xIxXXX0x03 = SportShowDataSelectActivity.this.sportDataOrder;
                                            if (xIxXXX0x03 == null) {
                                                kotlin.jvm.internal.IIX0o.XOxIOxOx("sportDataOrder");
                                                xIxXXX0x03 = null;
                                            }
                                            Integer num = xIxXXX0x03.oxoX().get(SportDataType.STEP);
                                            if (num != null && num.intValue() == 0) {
                                                final SportShowDataSelectActivity sportShowDataSelectActivity10 = SportShowDataSelectActivity.this;
                                                dslItem.setItemClick(new Oox.oOoXoXO<View, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.SportShowDataSelectActivity.onInitBaseLayoutAfter.1.1.1.7.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // Oox.oOoXoXO
                                                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(View view) {
                                                        invoke2(view);
                                                        return oXIO0o0XI.f29392oIX0oI;
                                                    }

                                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                    public final void invoke2(@OXOo.OOXIXo View it) {
                                                        kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                                                        SportShowDataSelectActivity.this.showData(SportDataType.STEP);
                                                    }
                                                });
                                                i = R.drawable.icon_step_n_108;
                                            } else {
                                                i = R.drawable.icon_step_108;
                                            }
                                            dslItem.setItemBindOverride(new Oox.Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.SportShowDataSelectActivity.onInitBaseLayoutAfter.1.1.1.7.2
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(4);
                                                }

                                                @Override // Oox.Oxx0xo
                                                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslViewHolder dslViewHolder2, Integer num2, DslAdapterItem dslAdapterItem, List<? extends Object> list) {
                                                    invoke(dslViewHolder2, num2.intValue(), dslAdapterItem, list);
                                                    return oXIO0o0XI.f29392oIX0oI;
                                                }

                                                public final void invoke(@OXOo.OOXIXo DslViewHolder itemHolder, int i2, @OXOo.OOXIXo DslAdapterItem dslAdapterItem, @OXOo.OOXIXo List<? extends Object> list) {
                                                    kotlin.jvm.internal.IIX0o.x0xO0oo(itemHolder, "itemHolder");
                                                    kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "<anonymous parameter 2>");
                                                    kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<anonymous parameter 3>");
                                                    TextView tv = itemHolder.tv(R.id.tv);
                                                    if (tv != null) {
                                                        tv.setText(R.string.steps);
                                                    }
                                                    ImageView img = itemHolder.img(R.id.iv);
                                                    if (img != null) {
                                                        img.setImageResource(i);
                                                    }
                                                }
                                            });
                                        }
                                    });
                                    final SportShowDataSelectActivity sportShowDataSelectActivity10 = SportShowDataSelectActivity.this;
                                    DslAdapterExKt.oO(renderAdapter2, R.layout.item_sport_data, new Oox.oOoXoXO<DslAdapterItem, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.SportShowDataSelectActivity.onInitBaseLayoutAfter.1.1.1.8
                                        {
                                            super(1);
                                        }

                                        @Override // Oox.oOoXoXO
                                        public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslAdapterItem dslAdapterItem) {
                                            invoke2(dslAdapterItem);
                                            return oXIO0o0XI.f29392oIX0oI;
                                        }

                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(@OXOo.OOXIXo DslAdapterItem dslItem) {
                                            XIxXXX0x0 xIxXXX0x03;
                                            final int i;
                                            kotlin.jvm.internal.IIX0o.x0xO0oo(dslItem, "$this$dslItem");
                                            xIxXXX0x03 = SportShowDataSelectActivity.this.sportDataOrder;
                                            if (xIxXXX0x03 == null) {
                                                kotlin.jvm.internal.IIX0o.XOxIOxOx("sportDataOrder");
                                                xIxXXX0x03 = null;
                                            }
                                            Integer num = xIxXXX0x03.oxoX().get(SportDataType.SPM);
                                            if (num != null && num.intValue() == 0) {
                                                final SportShowDataSelectActivity sportShowDataSelectActivity11 = SportShowDataSelectActivity.this;
                                                dslItem.setItemClick(new Oox.oOoXoXO<View, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.SportShowDataSelectActivity.onInitBaseLayoutAfter.1.1.1.8.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // Oox.oOoXoXO
                                                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(View view) {
                                                        invoke2(view);
                                                        return oXIO0o0XI.f29392oIX0oI;
                                                    }

                                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                    public final void invoke2(@OXOo.OOXIXo View it) {
                                                        kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                                                        SportShowDataSelectActivity.this.showData(SportDataType.SPM);
                                                    }
                                                });
                                                i = R.drawable.icon_spm_n_108;
                                            } else {
                                                i = R.drawable.icon_spm_108;
                                            }
                                            dslItem.setItemBindOverride(new Oox.Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.SportShowDataSelectActivity.onInitBaseLayoutAfter.1.1.1.8.2
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(4);
                                                }

                                                @Override // Oox.Oxx0xo
                                                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslViewHolder dslViewHolder2, Integer num2, DslAdapterItem dslAdapterItem, List<? extends Object> list) {
                                                    invoke(dslViewHolder2, num2.intValue(), dslAdapterItem, list);
                                                    return oXIO0o0XI.f29392oIX0oI;
                                                }

                                                public final void invoke(@OXOo.OOXIXo DslViewHolder itemHolder, int i2, @OXOo.OOXIXo DslAdapterItem dslAdapterItem, @OXOo.OOXIXo List<? extends Object> list) {
                                                    kotlin.jvm.internal.IIX0o.x0xO0oo(itemHolder, "itemHolder");
                                                    kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "<anonymous parameter 2>");
                                                    kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<anonymous parameter 3>");
                                                    TextView tv = itemHolder.tv(R.id.tv);
                                                    if (tv != null) {
                                                        tv.setText(R.string.spm);
                                                    }
                                                    ImageView img = itemHolder.img(R.id.iv);
                                                    if (img != null) {
                                                        img.setImageResource(i);
                                                    }
                                                }
                                            });
                                        }
                                    });
                                }
                                if (ProductManager.XxXX(productManager, sportManager2.O0xOxO().getMMode(), false, 2, null)) {
                                    final SportShowDataSelectActivity sportShowDataSelectActivity11 = SportShowDataSelectActivity.this;
                                    DslAdapterExKt.oO(renderAdapter2, R.layout.item_sport_data, new Oox.oOoXoXO<DslAdapterItem, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.SportShowDataSelectActivity.onInitBaseLayoutAfter.1.1.1.9
                                        {
                                            super(1);
                                        }

                                        @Override // Oox.oOoXoXO
                                        public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslAdapterItem dslAdapterItem) {
                                            invoke2(dslAdapterItem);
                                            return oXIO0o0XI.f29392oIX0oI;
                                        }

                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(@OXOo.OOXIXo DslAdapterItem dslItem) {
                                            XIxXXX0x0 xIxXXX0x03;
                                            final int i;
                                            kotlin.jvm.internal.IIX0o.x0xO0oo(dslItem, "$this$dslItem");
                                            xIxXXX0x03 = SportShowDataSelectActivity.this.sportDataOrder;
                                            if (xIxXXX0x03 == null) {
                                                kotlin.jvm.internal.IIX0o.XOxIOxOx("sportDataOrder");
                                                xIxXXX0x03 = null;
                                            }
                                            Integer num = xIxXXX0x03.oxoX().get(SportDataType.ALTITUDE);
                                            if (num != null && num.intValue() == 0) {
                                                final SportShowDataSelectActivity sportShowDataSelectActivity12 = SportShowDataSelectActivity.this;
                                                dslItem.setItemClick(new Oox.oOoXoXO<View, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.SportShowDataSelectActivity.onInitBaseLayoutAfter.1.1.1.9.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // Oox.oOoXoXO
                                                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(View view) {
                                                        invoke2(view);
                                                        return oXIO0o0XI.f29392oIX0oI;
                                                    }

                                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                    public final void invoke2(@OXOo.OOXIXo View it) {
                                                        kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                                                        SportShowDataSelectActivity.this.showData(SportDataType.ALTITUDE);
                                                    }
                                                });
                                                i = R.drawable.icon_altitude_n_108;
                                            } else {
                                                i = R.drawable.icon_altitude_108;
                                            }
                                            dslItem.setItemBindOverride(new Oox.Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.SportShowDataSelectActivity.onInitBaseLayoutAfter.1.1.1.9.2
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(4);
                                                }

                                                @Override // Oox.Oxx0xo
                                                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslViewHolder dslViewHolder2, Integer num2, DslAdapterItem dslAdapterItem, List<? extends Object> list) {
                                                    invoke(dslViewHolder2, num2.intValue(), dslAdapterItem, list);
                                                    return oXIO0o0XI.f29392oIX0oI;
                                                }

                                                public final void invoke(@OXOo.OOXIXo DslViewHolder itemHolder, int i2, @OXOo.OOXIXo DslAdapterItem dslAdapterItem, @OXOo.OOXIXo List<? extends Object> list) {
                                                    kotlin.jvm.internal.IIX0o.x0xO0oo(itemHolder, "itemHolder");
                                                    kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "<anonymous parameter 2>");
                                                    kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<anonymous parameter 3>");
                                                    TextView tv = itemHolder.tv(R.id.tv);
                                                    if (tv != null) {
                                                        tv.setText(R.string.altitude);
                                                    }
                                                    ImageView img = itemHolder.img(R.id.iv);
                                                    if (img != null) {
                                                        img.setImageResource(i);
                                                    }
                                                }
                                            });
                                        }
                                    });
                                }
                            }
                        });
                    }
                });
            }
        });
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        finish();
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity
    public int recyclerViewId() {
        return R.id.rv;
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity
    public int refreshLayoutId() {
        return 0;
    }
}
