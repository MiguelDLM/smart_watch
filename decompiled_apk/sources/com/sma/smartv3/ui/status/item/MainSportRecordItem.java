package com.sma.smartv3.ui.status.item;

import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.angcyo.dsladapter.DslViewHolder;
import com.bestmafen.androidbase.dsl.BaseDslItem;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.google.gson.Gson;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.AppUser;
import com.sma.smartv3.model.SportRecordData;
import com.sma.smartv3.model.SportRecordDataKt;
import com.sma.smartv3.model.SportRecordItemAdapter;
import com.sma.smartv3.model.SportRecordItemCommonData;
import com.sma.smartv3.model.SportRecordItemData;
import com.sma.smartv3.ui.sport.SportDetailActivity;
import com.sma.smartv3.ui.sport.SportDetailV2Activity;
import com.sma.smartv3.ui.status.SportRecordsActivity;
import com.sma.smartv3.ui.status.SportRecordsDetailActivity;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.x0xO0oo;
import com.sma.smartv3.view.text.DINCondBold;
import com.sma.smartv3.view.text.PFMedium;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nMainSportRecordItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MainSportRecordItem.kt\ncom/sma/smartv3/ui/status/item/MainSportRecordItem\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,227:1\n19#2:228\n15#2:229\n*S KotlinDebug\n*F\n+ 1 MainSportRecordItem.kt\ncom/sma/smartv3/ui/status/item/MainSportRecordItem\n*L\n39#1:228\n39#1:229\n*E\n"})
/* loaded from: classes12.dex */
public class MainSportRecordItem extends BaseDslItem {
    private ImageView gpsStatusIv;
    private final boolean initEvent;
    public Context mContext;
    public RecyclerView rv;
    private LinearLayout sportItemDetail;
    private PFMedium sportName;

    @OXOo.OOXIXo
    private SportRecordData sportRecordData;

    @OXOo.oOoXoXO
    private SportRecordItemCommonData sportRecordItemCommonData;
    private ImageView sportSourceIv;
    private DINCondBold sportStartTimeTv;
    private ImageView sportTypeIv;

    @OXOo.OOXIXo
    private final AppUser userProfile;

    public MainSportRecordItem() {
        SPUtils XO2 = Xo0.f24349oIX0oI.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        this.userProfile = (AppUser) (fromJson != null ? fromJson : appUser);
        this.initEvent = true;
        this.sportRecordData = new SportRecordData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bindView$lambda$1$lambda$0(MainSportRecordItem this$0, View view, MotionEvent motionEvent) {
        IIX0o.x0xO0oo(this$0, "this$0");
        LinearLayout linearLayout = this$0.sportItemDetail;
        if (linearLayout == null) {
            IIX0o.XOxIOxOx("sportItemDetail");
            linearLayout = null;
        }
        return linearLayout.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindView$lambda$2(MainSportRecordItem this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        if (com.sma.smartv3.ui.status.x0XOIxOo.f24154oIX0oI.oIX0oI()) {
            LogUtils.i("sportRecordData.mSource" + this$0.sportRecordData.getMSource());
            int mSource = this$0.sportRecordData.getMSource();
            if (mSource != 1) {
                if (mSource != 2) {
                    this$0.getMContext().startActivity(new Intent(this$0.getMContext(), (Class<?>) SportRecordsDetailActivity.class).putExtra("mArg2", this$0.sportRecordData));
                    return;
                } else if (ProjectManager.f19822oIX0oI.OO0()) {
                    this$0.getMContext().startActivity(new Intent(this$0.getMContext(), (Class<?>) SportDetailV2Activity.class).putExtra("mArg1", this$0.sportRecordData.getMWorkoutId()));
                    return;
                } else {
                    this$0.getMContext().startActivity(new Intent(this$0.getMContext(), (Class<?>) SportDetailActivity.class).putExtra("mArg1", this$0.sportRecordData.getMWorkoutId()));
                    return;
                }
            }
            ProjectManager projectManager = ProjectManager.f19822oIX0oI;
            if (projectManager.OO0()) {
                this$0.getMContext().startActivity(new Intent(this$0.getMContext(), (Class<?>) SportDetailV2Activity.class).putExtra("mArg1", this$0.sportRecordData.getMWorkoutId()));
            } else if (projectManager.XoIxOXIXo()) {
                this$0.getMContext().startActivity(new Intent(this$0.getMContext(), (Class<?>) SportDetailActivity.class).putExtra("mArg1", this$0.sportRecordData.getMWorkoutId()));
            } else {
                this$0.getMContext().startActivity(new Intent(this$0.getMContext(), (Class<?>) SportRecordsDetailActivity.class).putExtra("mArg2", this$0.sportRecordData));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindView$lambda$3(MainSportRecordItem this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        if (com.sma.smartv3.ui.status.x0XOIxOo.f24154oIX0oI.oIX0oI()) {
            this$0.getMContext().startActivity(new Intent(this$0.getMContext(), (Class<?>) SportRecordsActivity.class));
        }
    }

    private final void noData() {
        setItemHidden(true);
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void bindView(@OXOo.OOXIXo DslViewHolder itemHolder) {
        IIX0o.x0xO0oo(itemHolder, "itemHolder");
        View v = itemHolder.v(R.id.sportSourceIv);
        IIX0o.ooOOo0oXI(v);
        this.sportSourceIv = (ImageView) v;
        View v2 = itemHolder.v(R.id.sportTypeIv);
        IIX0o.ooOOo0oXI(v2);
        this.sportTypeIv = (ImageView) v2;
        View v3 = itemHolder.v(R.id.gpsStatusIv);
        IIX0o.ooOOo0oXI(v3);
        this.gpsStatusIv = (ImageView) v3;
        View v4 = itemHolder.v(R.id.sportName);
        IIX0o.ooOOo0oXI(v4);
        this.sportName = (PFMedium) v4;
        View v5 = itemHolder.v(R.id.sportStartTime);
        IIX0o.ooOOo0oXI(v5);
        this.sportStartTimeTv = (DINCondBold) v5;
        View v6 = itemHolder.v(R.id.sportItemDetail);
        IIX0o.ooOOo0oXI(v6);
        this.sportItemDetail = (LinearLayout) v6;
        View v7 = itemHolder.v(R.id.rv);
        IIX0o.ooOOo0oXI(v7);
        setRv((RecyclerView) v7);
        getRv().setOnTouchListener(new View.OnTouchListener() { // from class: com.sma.smartv3.ui.status.item.XO
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean bindView$lambda$1$lambda$0;
                bindView$lambda$1$lambda$0 = MainSportRecordItem.bindView$lambda$1$lambda$0(MainSportRecordItem.this, view, motionEvent);
                return bindView$lambda$1$lambda$0;
            }
        });
        LinearLayout linearLayout = this.sportItemDetail;
        if (linearLayout == null) {
            IIX0o.XOxIOxOx("sportItemDetail");
            linearLayout = null;
        }
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.status.item.Oxx0IOOO
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainSportRecordItem.bindView$lambda$2(MainSportRecordItem.this, view);
            }
        });
        View view = itemHolder.view(R.id.sportRecordList);
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.status.item.II0XooXoX
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    MainSportRecordItem.bindView$lambda$3(MainSportRecordItem.this, view2);
                }
            });
        }
        Context context = getRv().getContext();
        IIX0o.oO(context, "getContext(...)");
        setMContext(context);
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public boolean getInitEvent() {
        return this.initEvent;
    }

    @OXOo.OOXIXo
    public final Context getMContext() {
        Context context = this.mContext;
        if (context != null) {
            return context;
        }
        IIX0o.XOxIOxOx("mContext");
        return null;
    }

    @OXOo.OOXIXo
    public RecyclerView getRv() {
        RecyclerView recyclerView = this.rv;
        if (recyclerView != null) {
            return recyclerView;
        }
        IIX0o.XOxIOxOx("rv");
        return null;
    }

    @OXOo.OOXIXo
    public final SportRecordData getSportRecordData() {
        return this.sportRecordData;
    }

    @OXOo.oOoXoXO
    public final SportRecordItemCommonData getSportRecordItemCommonData() {
        return this.sportRecordItemCommonData;
    }

    @OXOo.OOXIXo
    public final AppUser getUserProfile() {
        return this.userProfile;
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void initView() {
        int i;
        ArrayList<SportRecordData> sportRecordList = SportRecordDataKt.getSportRecordList(0, 20);
        if (sportRecordList.isEmpty()) {
            noData();
            return;
        }
        setItemHidden(false);
        SportRecordData sportRecordData = sportRecordList.get(0);
        IIX0o.oO(sportRecordData, "get(...)");
        this.sportRecordData = sportRecordData;
        this.sportRecordItemCommonData = parseSportRecordItemCommonDataMethod();
        ImageView imageView = this.sportSourceIv;
        String str = null;
        if (imageView == null) {
            IIX0o.XOxIOxOx("sportSourceIv");
            imageView = null;
        }
        if (this.sportRecordData.getMSource() == 2) {
            i = R.drawable.icon_phone;
        } else {
            i = R.drawable.icon_watch;
        }
        imageView.setImageResource(i);
        ImageView imageView2 = this.sportTypeIv;
        if (imageView2 == null) {
            IIX0o.XOxIOxOx("sportTypeIv");
            imageView2 = null;
        }
        SportRecordItemCommonData sportRecordItemCommonData = this.sportRecordItemCommonData;
        IIX0o.ooOOo0oXI(sportRecordItemCommonData);
        imageView2.setImageResource(sportRecordItemCommonData.getWorkoutImg());
        ImageView imageView3 = this.gpsStatusIv;
        if (imageView3 == null) {
            IIX0o.XOxIOxOx("gpsStatusIv");
            imageView3 = null;
        }
        SportRecordItemCommonData sportRecordItemCommonData2 = this.sportRecordItemCommonData;
        IIX0o.ooOOo0oXI(sportRecordItemCommonData2);
        imageView3.setImageResource(sportRecordItemCommonData2.getGpsState());
        PFMedium pFMedium = this.sportName;
        if (pFMedium == null) {
            IIX0o.XOxIOxOx("sportName");
            pFMedium = null;
        }
        SportRecordItemCommonData sportRecordItemCommonData3 = this.sportRecordItemCommonData;
        IIX0o.ooOOo0oXI(sportRecordItemCommonData3);
        pFMedium.setText(sportRecordItemCommonData3.getWorkoutModeName());
        DINCondBold dINCondBold = this.sportStartTimeTv;
        if (dINCondBold == null) {
            IIX0o.XOxIOxOx("sportStartTimeTv");
            dINCondBold = null;
        }
        SportRecordItemCommonData sportRecordItemCommonData4 = this.sportRecordItemCommonData;
        if (sportRecordItemCommonData4 != null) {
            str = sportRecordItemCommonData4.getSportStartTime();
        }
        dINCondBold.setText(str);
        setAdapterMethod(getRv());
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public int layoutId() {
        return R.layout.status_item_sport_record;
    }

    @XO0.XO(tag = x0xO0oo.f24629oIX0oI)
    public final void onActivityChanged(@OXOo.OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        LogUtils.v("onActivityChanged");
        initView();
    }

    @XO0.XO(tag = x0xO0oo.f24567II0xO0)
    public final void onHeartRateChanged(@OXOo.OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        LogUtils.v("onHeartRateChanged");
        initView();
    }

    @XO0.XO(tag = x0xO0oo.f24593OOXIXo)
    public final void onLocationChanged(@OXOo.OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        LogUtils.v("onLocationChanged");
        initView();
    }

    @XO0.XO(tag = x0xO0oo.f24605X0o0xo)
    public final void onWorkoutChanged(@OXOo.OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        LogUtils.v("onWorkoutChanged");
        initView();
    }

    @OXOo.OOXIXo
    public SportRecordItemCommonData parseSportRecordItemCommonDataMethod() {
        return SportRecordDataKt.parseSportRecordItemCommonData(getMContext(), this.userProfile, this.sportRecordData);
    }

    public void setAdapterMethod(@OXOo.OOXIXo RecyclerView recyclerView) {
        IIX0o.x0xO0oo(recyclerView, "<this>");
        Context context = recyclerView.getContext();
        SportRecordItemCommonData sportRecordItemCommonData = this.sportRecordItemCommonData;
        IIX0o.ooOOo0oXI(sportRecordItemCommonData);
        recyclerView.setLayoutManager(new GridLayoutManager(context, sportRecordItemCommonData.getSpanCount()));
        SportRecordItemCommonData sportRecordItemCommonData2 = this.sportRecordItemCommonData;
        IIX0o.ooOOo0oXI(sportRecordItemCommonData2);
        List<SportRecordItemData> contentList = sportRecordItemCommonData2.getContentList();
        Context context2 = recyclerView.getContext();
        IIX0o.oO(context2, "getContext(...)");
        recyclerView.setAdapter(new SportRecordItemAdapter(contentList, context2));
    }

    public final void setMContext(@OXOo.OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "<set-?>");
        this.mContext = context;
    }

    public void setRv(@OXOo.OOXIXo RecyclerView recyclerView) {
        IIX0o.x0xO0oo(recyclerView, "<set-?>");
        this.rv = recyclerView;
    }

    public final void setSportRecordData(@OXOo.OOXIXo SportRecordData sportRecordData) {
        IIX0o.x0xO0oo(sportRecordData, "<set-?>");
        this.sportRecordData = sportRecordData;
    }

    public final void setSportRecordItemCommonData(@OXOo.oOoXoXO SportRecordItemCommonData sportRecordItemCommonData) {
        this.sportRecordItemCommonData = sportRecordItemCommonData;
    }
}
