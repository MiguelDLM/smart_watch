package com.sma.smartv3.ui.status;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.angcyo.dsladapter.DslAdapter;
import com.angcyo.dsladapter.DslAdapterItem;
import com.angcyo.dsladapter.LibExKt;
import com.bestmafen.androidbase.base.BaseActivity;
import com.blankj.utilcode.util.ImageUtils;
import com.blankj.utilcode.util.UriUtils;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.entity.HealthyReport;
import com.sma.smartv3.model.TodayData;
import com.sma.smartv3.ui.status.item.HeathAIAnalyzeItem;
import com.sma.smartv3.ui.status.item.HeathReportsBaseItem;
import com.sma.smartv3.ui.status.item.HeathReportsTopItem;
import com.sma.smartv3.ui.status.item.MainStatusFunctionsItem;
import com.sma.smartv3.util.HeathReportsUtils;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.XoI0Ixx0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nHeathReportsResultActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HeathReportsResultActivity.kt\ncom/sma/smartv3/ui/status/HeathReportsResultActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n*L\n1#1,147:1\n1#2:148\n1#2:160\n1549#3:149\n1620#3,3:150\n1549#3:153\n1620#3,3:154\n69#4,3:157\n72#4,5:161\n*S KotlinDebug\n*F\n+ 1 HeathReportsResultActivity.kt\ncom/sma/smartv3/ui/status/HeathReportsResultActivity\n*L\n144#1:160\n107#1:149\n107#1:150,3\n112#1:153\n112#1:154,3\n144#1:157,3\n144#1:161,5\n*E\n"})
/* loaded from: classes12.dex */
public final class HeathReportsResultActivity extends BaseActivity {

    @OXOo.oOoXoXO
    private DslAdapter dslAdapter;

    @OXOo.oOoXoXO
    private HealthyReport mHealthyReport;

    @OXOo.oOoXoXO
    private RecyclerView mRecyclerView;

    @OXOo.oOoXoXO
    private List<TodayData> mTodayDataList;

    @OXOo.OOXIXo
    private final String TAG = "HeathReportsResultActivity";

    @OXOo.OOXIXo
    private final X0IIOO abhTitleCenter$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.HeathReportsResultActivity$abhTitleCenter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) HeathReportsResultActivity.this.findViewById(R.id.abh_title_center);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO abhTitleRight$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.status.HeathReportsResultActivity$abhTitleRight$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) HeathReportsResultActivity.this.findViewById(R.id.abh_title_right);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO abhTitleOtherRight$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.status.HeathReportsResultActivity$abhTitleOtherRight$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) HeathReportsResultActivity.this.findViewById(R.id.abh_title_other_right);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mShareLayout$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.status.HeathReportsResultActivity$mShareLayout$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return HeathReportsResultActivity.this.findViewById(R.id.share_layout);
        }
    });

    @OXOo.OOXIXo
    private final ArrayList<DslAdapterItem> showList = new ArrayList<>();

    @OXOo.OOXIXo
    private final X0IIOO mGenerateBtn$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.HeathReportsResultActivity$mGenerateBtn$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) HeathReportsResultActivity.this.findViewById(R.id.tv_generate_report);
        }
    });
    private long reportsId = -1;

    private final TextView getAbhTitleCenter() {
        return (TextView) this.abhTitleCenter$delegate.getValue();
    }

    private final ImageView getAbhTitleOtherRight() {
        return (ImageView) this.abhTitleOtherRight$delegate.getValue();
    }

    private final ImageView getAbhTitleRight() {
        return (ImageView) this.abhTitleRight$delegate.getValue();
    }

    private final TextView getMGenerateBtn() {
        return (TextView) this.mGenerateBtn$delegate.getValue();
    }

    private final View getMShareLayout() {
        return (View) this.mShareLayout$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final ArrayList<DslAdapterItem> getShowList() {
        return this.showList;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
        long j;
        String mArg0 = getMArg0();
        if (mArg0 != null) {
            j = Long.parseLong(mArg0);
        } else {
            j = -1;
        }
        this.reportsId = j;
        if (j > -1) {
            HeathReportsUtils heathReportsUtils = HeathReportsUtils.f24217oIX0oI;
            HealthyReport Oxx0xo2 = heathReportsUtils.Oxx0xo(j);
            this.mHealthyReport = Oxx0xo2;
            this.mTodayDataList = heathReportsUtils.X00IoxXI(Oxx0xo2);
        }
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        getAbhTitleCenter().setText(getString(R.string.health_report));
        LibExKt.oxxXoxO(getMGenerateBtn(), true);
        getAbhTitleRight().setVisibility(0);
        getAbhTitleRight().setImageResource(R.drawable.icon_share_hrg);
        getAbhTitleRight().setImageTintList(oIxOXo.oxoX.X0o0xo(this, R.color.text_color));
        getAbhTitleOtherRight().setVisibility(0);
        getAbhTitleOtherRight().setImageResource(R.drawable.ic_waring);
        getAbhTitleOtherRight().setImageTintList(oIxOXo.oxoX.X0o0xo(this, R.color.text_color));
        showCard();
        View findViewById = findViewById(R.id.rv);
        IIX0o.ooOOo0oXI(findViewById);
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.mRecyclerView = recyclerView;
        if (recyclerView != null) {
            recyclerView.setItemViewCacheSize(10);
        }
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 != null) {
            recyclerView2.setItemAnimator(null);
        }
        RecyclerView recyclerView3 = this.mRecyclerView;
        if (recyclerView3 != null) {
            recyclerView3.setLayoutManager(new GridLayoutManager(getMContext(), 1));
        }
        DslAdapter dslAdapter = new DslAdapter(this.showList);
        RecyclerView recyclerView4 = this.mRecyclerView;
        if (recyclerView4 != null) {
            recyclerView4.setAdapter(dslAdapter);
        }
        this.dslAdapter = dslAdapter;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_heath_reports;
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        finish();
    }

    public final void onTitleRightClick(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        Bitmap createBitmap = Bitmap.createBitmap(getMShareLayout().getWidth(), getMShareLayout().getHeight(), Bitmap.Config.ARGB_8888);
        IIX0o.oO(createBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(createBitmap);
        com.sma.smartv3.util.Oxx0IOOO oxx0IOOO = com.sma.smartv3.util.Oxx0IOOO.f24316oIX0oI;
        View mShareLayout = getMShareLayout();
        IIX0o.oO(mShareLayout, "<get-mShareLayout>(...)");
        canvas.drawBitmap(oxx0IOOO.II0xO0(mShareLayout), 0.0f, 0.0f, (Paint) null);
        X00IoxXI.oIX0oI oix0oi = X00IoxXI.oIX0oI.f3233oIX0oI;
        ImageUtils.save(createBitmap, com.sma.smartv3.initializer.IXxxXO.oxXx0IX(oix0oi), Bitmap.CompressFormat.JPEG);
        Intent intent = new Intent("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", "");
        intent.putExtra("android.intent.extra.STREAM", UriUtils.file2Uri(com.sma.smartv3.initializer.IXxxXO.oxXx0IX(oix0oi)));
        intent.setType("image/*");
        Intent createChooser = Intent.createChooser(intent, "");
        IIX0o.oO(createChooser, "createChooser(...)");
        createChooser.addFlags(268435456);
        startActivity(createChooser);
    }

    public final void onTitleRightOtherClick(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        startActivity(new Intent(this, (Class<?>) HistoryDefinitionActivity.class));
    }

    @OXOo.OOXIXo
    public final ArrayList<DslAdapterItem> showCard() {
        long j;
        this.showList.clear();
        HealthyReport healthyReport = this.mHealthyReport;
        if (healthyReport != null) {
            j = healthyReport.getMTime();
        } else {
            j = Xo0.f24349oIX0oI.oIX0oI().getLong(XoI0Ixx0.f24436o0IXXIx, 0L);
        }
        this.showList.add(new HeathReportsTopItem(j, true, this.mHealthyReport));
        ArrayList arrayList = new ArrayList();
        List<TodayData> list = this.mTodayDataList;
        if (list != null) {
            List<TodayData> list2 = list;
            ArrayList arrayList2 = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList2.add(Boolean.valueOf(arrayList.add(new HeathReportsBaseItem((TodayData) it.next()))));
            }
        }
        ArrayList<DslAdapterItem> arrayList3 = this.showList;
        MainStatusFunctionsItem mainStatusFunctionsItem = new MainStatusFunctionsItem();
        mainStatusFunctionsItem.setItems(arrayList);
        arrayList3.add(mainStatusFunctionsItem);
        List<TodayData> list3 = this.mTodayDataList;
        if (list3 != null) {
            List<TodayData> list4 = list3;
            ArrayList arrayList4 = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(list4, 10));
            Iterator<T> it2 = list4.iterator();
            while (it2.hasNext()) {
                arrayList4.add(Boolean.valueOf(this.showList.add(new HeathAIAnalyzeItem((TodayData) it2.next()))));
            }
        }
        return this.showList;
    }
}
