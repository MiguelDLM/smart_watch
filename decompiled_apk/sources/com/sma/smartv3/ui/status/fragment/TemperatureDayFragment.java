package com.sma.smartv3.ui.status.fragment;

import android.app.Activity;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter;
import com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.google.gson.Gson;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.MyDb;
import com.sma.smartv3.db.dao.TemperatureDao;
import com.sma.smartv3.db.entity.Temperature;
import com.sma.smartv3.model.AppUser;
import com.sma.smartv3.ui.status.base.BaseDetailDaysFragment;
import com.sma.smartv3.util.TextConvertKt;
import com.sma.smartv3.util.TimePeriod;
import com.sma.smartv3.util.UtilsKt;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.view.TempProgressBar;
import com.sma.smartv3.view.text.DINCondBold;
import com.sma.smartv3.view.text.PFMedium;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nTemperatureDayFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TemperatureDayFragment.kt\ncom/sma/smartv3/ui/status/fragment/TemperatureDayFragment\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,149:1\n19#2:150\n15#2:151\n1#3:152\n*S KotlinDebug\n*F\n+ 1 TemperatureDayFragment.kt\ncom/sma/smartv3/ui/status/fragment/TemperatureDayFragment\n*L\n36#1:150\n36#1:151\n*E\n"})
/* loaded from: classes12.dex */
public class TemperatureDayFragment extends BaseDetailDaysFragment<Temperature> implements com.bestmafen.androidbase.recycler.I0Io<Temperature> {
    private boolean isImperial;

    @OXOo.OOXIXo
    private final AppUser mAppUser;

    @OXOo.oOoXoXO
    private CommonAdapter<Temperature> mRecyclerAdapter;

    @OXOo.OOXIXo
    private final X0IIOO tempPb$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TempProgressBar>() { // from class: com.sma.smartv3.ui.status.fragment.TemperatureDayFragment$tempPb$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TempProgressBar invoke() {
            View mView;
            mView = TemperatureDayFragment.this.getMView();
            return (TempProgressBar) mView.findViewById(R.id.tempPb);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO rv$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RecyclerView>() { // from class: com.sma.smartv3.ui.status.fragment.TemperatureDayFragment$rv$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RecyclerView invoke() {
            View mView;
            mView = TemperatureDayFragment.this.getMView();
            return (RecyclerView) mView.findViewById(R.id.rv);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO noData$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RelativeLayout>() { // from class: com.sma.smartv3.ui.status.fragment.TemperatureDayFragment$noData$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RelativeLayout invoke() {
            View mView;
            mView = TemperatureDayFragment.this.getMView();
            return (RelativeLayout) mView.findViewById(R.id.noData);
        }
    });

    @OXOo.OOXIXo
    private final TemperatureDao mTemperatureDao = MyDb.INSTANCE.getMDatabase().temperatureDao();

    @OXOo.OOXIXo
    private ArrayList<Temperature> mAllList = new ArrayList<>();

    public TemperatureDayFragment() {
        SPUtils XO2 = Xo0.f24349oIX0oI.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        this.mAppUser = (AppUser) (fromJson != null ? fromJson : appUser);
    }

    private final RelativeLayout getNoData() {
        return (RelativeLayout) this.noData$delegate.getValue();
    }

    private final RecyclerView getRv() {
        return (RecyclerView) this.rv$delegate.getValue();
    }

    private final TempProgressBar getTempPb() {
        return (TempProgressBar) this.tempPb$delegate.getValue();
    }

    private final void updateChartData() {
        int i;
        LogUtils.d(this.mAllList);
        if (this.mAllList.isEmpty()) {
            getNoData().setVisibility(0);
            getRv().setVisibility(8);
            getNowValue().setText(UtilsKt.OxxIIOOXO(0));
            getNowTimeDetails().setText(UtilsKt.OxxIIOOXO(0));
            getTempPb().I0Io(0, this.isImperial);
        } else {
            getNoData().setVisibility(8);
            getRv().setVisibility(0);
            getNowValue().setText(String.valueOf(TextConvertKt.Oxx0xo(((Temperature) CollectionsKt___CollectionsKt.O0OOX0IIx(this.mAllList)).getMTemperature(), this.isImperial)));
            DINCondBold nowTimeDetails = getNowTimeDetails();
            SimpleDateFormat oxXx0IX2 = com.sma.smartv3.util.xoIox.oxXx0IX(false, 1, null);
            Date date = new Date();
            date.setTime(((Temperature) CollectionsKt___CollectionsKt.O0OOX0IIx(this.mAllList)).getMTime());
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
            nowTimeDetails.setText(oxXx0IX2.format(date));
            getTempPb().I0Io(((Temperature) CollectionsKt___CollectionsKt.O0OOX0IIx(this.mAllList)).getMTemperature(), this.isImperial);
        }
        PFMedium valueUnit = getValueUnit();
        if (this.isImperial) {
            i = R.string.fahrenheit;
        } else {
            i = R.string.degree_centigrade;
        }
        valueUnit.setText(i);
        CommonAdapter<Temperature> commonAdapter = this.mRecyclerAdapter;
        if (commonAdapter != null) {
            commonAdapter.notifyDataSetChanged();
        }
    }

    public final int getCount() {
        return this.mAllList.size();
    }

    @Override // com.bestmafen.androidbase.list.II0xO0
    @OXOo.OOXIXo
    public List<Temperature> initList() {
        return new ArrayList();
    }

    @Override // com.sma.smartv3.ui.status.base.BaseDetailsFragment, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        boolean z = true;
        if (TextConvertKt.XI0IXoo(this.mAppUser.getUnit()) != 1) {
            z = false;
        }
        this.isImperial = z;
        super.initView();
        final Activity mActivity = getMActivity();
        final int itemLayoutId = itemLayoutId();
        final ArrayList<Temperature> arrayList = this.mAllList;
        CommonAdapter<Temperature> commonAdapter = new CommonAdapter<Temperature>(mActivity, itemLayoutId, arrayList) { // from class: com.sma.smartv3.ui.status.fragment.TemperatureDayFragment$initView$1
            @Override // com.bestmafen.androidbase.adapter.recyclerview.MultiItemTypeAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
            public int getItemCount() {
                return TemperatureDayFragment.this.getCount();
            }

            @Override // com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter
            public void convert(@OXOo.OOXIXo ViewHolder viewHolder, @OXOo.OOXIXo Temperature item, int i) {
                IIX0o.x0xO0oo(viewHolder, "viewHolder");
                IIX0o.x0xO0oo(item, "item");
                TemperatureDayFragment.this.initItem(viewHolder, item, i);
            }
        };
        getRv().setAdapter(commonAdapter);
        this.mRecyclerAdapter = commonAdapter;
        getRv().setLayoutManager(new LinearLayoutManager(getMActivity()));
        CommonAdapter<Temperature> commonAdapter2 = this.mRecyclerAdapter;
        if (commonAdapter2 != null) {
            commonAdapter2.notifyDataSetChanged();
        }
    }

    @Override // com.bestmafen.androidbase.list.II0xO0
    public int itemLayoutId() {
        return R.layout.temp_day_item;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.fragment_status_temp_day;
    }

    @Override // com.sma.smartv3.ui.status.base.BaseDetailsFragment
    public void onDataChange(@OXOo.OOXIXo List<Temperature> data) {
        IIX0o.x0xO0oo(data, "data");
        this.mAllList.clear();
        this.mAllList.addAll(data);
        updateChartData();
    }

    @Override // com.sma.smartv3.ui.status.base.BaseDetailsFragment
    @OXOo.OOXIXo
    public List<Temperature> onTimePeriodChange(@OXOo.OOXIXo Calendar calendar, int i, @OXOo.OOXIXo TimePeriod timePeriod) {
        IIX0o.x0xO0oo(calendar, "calendar");
        IIX0o.x0xO0oo(timePeriod, "timePeriod");
        setRange(com.sma.smartv3.util.xoIox.o00(calendar, timePeriod, i));
        LogUtils.d(getRange());
        return this.mTemperatureDao.getListDesc(getRange()[0], getRange()[1]);
    }

    @OXOo.OOXIXo
    public final String setDataLabel() {
        return "temp day Data";
    }

    @Override // com.bestmafen.androidbase.recycler.I0Io
    public void initItem(@OXOo.OOXIXo ViewHolder holder, @OXOo.OOXIXo Temperature item, int i) {
        int color;
        int i2;
        IIX0o.x0xO0oo(holder, "holder");
        IIX0o.x0xO0oo(item, "item");
        double Oxx0xo2 = TextConvertKt.Oxx0xo(item.getMTemperature(), false);
        if (Oxx0xo2 < 36.0d) {
            color = getResources().getColor(R.color.temp_day_item_center_4);
            i2 = R.string.low;
        } else if (Oxx0xo2 >= 36.0d && Oxx0xo2 < 37.4d) {
            color = getResources().getColor(R.color.temp_day_item_center_5);
            i2 = R.string.normal;
        } else {
            color = getResources().getColor(R.color.temp_day_item_center_6);
            i2 = R.string.high;
        }
        float Oxx0xo3 = TextConvertKt.Oxx0xo(item.getMTemperature(), this.isImperial);
        DINCondBold dINCondBold = (DINCondBold) holder.getView(R.id.tempItemValue);
        dINCondBold.setText(String.valueOf(Oxx0xo3));
        dINCondBold.setTextColor(color);
        ((DINCondBold) holder.getView(R.id.tempItemUnit)).setText(this.isImperial ? R.string.fahrenheit : R.string.degree_centigrade);
        DINCondBold dINCondBold2 = (DINCondBold) holder.getView(R.id.tempItemTime);
        SimpleDateFormat oxXx0IX2 = com.sma.smartv3.util.xoIox.oxXx0IX(false, 1, null);
        Date date = new Date();
        date.setTime(item.getMTime());
        oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
        dINCondBold2.setText(oxXx0IX2.format(date));
        PFMedium pFMedium = (PFMedium) holder.getView(R.id.tempItemStatus);
        pFMedium.setText(i2);
        pFMedium.setTextColor(color);
    }
}
