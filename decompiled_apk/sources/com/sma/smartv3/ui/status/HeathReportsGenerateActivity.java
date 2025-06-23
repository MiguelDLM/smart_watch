package com.sma.smartv3.ui.status;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.angcyo.dsladapter.DslAdapter;
import com.angcyo.dsladapter.DslAdapterItem;
import com.bestmafen.androidbase.base.BaseActivity;
import com.blankj.utilcode.util.ImageUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.UriUtils;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.TodayData;
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
import kotlin.oXIO0o0XI;

@XX({"SMAP\nHeathReportsGenerateActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HeathReportsGenerateActivity.kt\ncom/sma/smartv3/ui/status/HeathReportsGenerateActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,197:1\n1#2:198\n1549#3:199\n1620#3,3:200\n*S KotlinDebug\n*F\n+ 1 HeathReportsGenerateActivity.kt\ncom/sma/smartv3/ui/status/HeathReportsGenerateActivity\n*L\n165#1:199\n165#1:200,3\n*E\n"})
/* loaded from: classes12.dex */
public final class HeathReportsGenerateActivity extends BaseActivity {

    @OXOo.oOoXoXO
    private DslAdapter dslAdapter;

    @OXOo.oOoXoXO
    private List<TodayData> mTodayDataList;

    @OXOo.OOXIXo
    private final X0IIOO abhTitleCenter$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.HeathReportsGenerateActivity$abhTitleCenter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) HeathReportsGenerateActivity.this.findViewById(R.id.abh_title_center);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO abhTitleRight$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.status.HeathReportsGenerateActivity$abhTitleRight$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) HeathReportsGenerateActivity.this.findViewById(R.id.abh_title_right);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mGenerateBtn$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.status.HeathReportsGenerateActivity$mGenerateBtn$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) HeathReportsGenerateActivity.this.findViewById(R.id.tv_generate_report);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mGenerateImgView$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.status.HeathReportsGenerateActivity$mGenerateImgView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return HeathReportsGenerateActivity.this.findViewById(R.id.iv_reports_generation);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mGenerateTvView$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.status.HeathReportsGenerateActivity$mGenerateTvView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return HeathReportsGenerateActivity.this.findViewById(R.id.tv_reports_generation);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mRecyclerView$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RecyclerView>() { // from class: com.sma.smartv3.ui.status.HeathReportsGenerateActivity$mRecyclerView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RecyclerView invoke() {
            return (RecyclerView) HeathReportsGenerateActivity.this.findViewById(R.id.rv);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mShareLayout$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.status.HeathReportsGenerateActivity$mShareLayout$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return HeathReportsGenerateActivity.this.findViewById(R.id.share_layout);
        }
    });

    @OXOo.OOXIXo
    private final ArrayList<DslAdapterItem> showList = new ArrayList<>();

    @OXOo.OOXIXo
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private int forNumber = 1;

    private final TextView getAbhTitleCenter() {
        return (TextView) this.abhTitleCenter$delegate.getValue();
    }

    private final ImageView getAbhTitleRight() {
        return (ImageView) this.abhTitleRight$delegate.getValue();
    }

    private final TextView getMGenerateBtn() {
        return (TextView) this.mGenerateBtn$delegate.getValue();
    }

    private final View getMGenerateImgView() {
        return (View) this.mGenerateImgView$delegate.getValue();
    }

    private final View getMGenerateTvView() {
        return (View) this.mGenerateTvView$delegate.getValue();
    }

    private final RecyclerView getMRecyclerView() {
        return (RecyclerView) this.mRecyclerView$delegate.getValue();
    }

    private final View getMShareLayout() {
        return (View) this.mShareLayout$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initRecyclerView() {
        getMRecyclerView().setItemViewCacheSize(30);
        getMRecyclerView().setItemAnimator(null);
        getMRecyclerView().setLayoutManager(new LinearLayoutManager(getMContext(), 1, false));
        DslAdapter dslAdapter = new DslAdapter(this.showList);
        getMRecyclerView().setAdapter(dslAdapter);
        this.dslAdapter = dslAdapter;
        IIX0o.ooOOo0oXI(dslAdapter);
        dslAdapter.notifyDataChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(HeathReportsGenerateActivity this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        if (this$0.mTodayDataList != null) {
            this$0.getMGenerateImgView().setVisibility(0);
            this$0.getMGenerateTvView().setVisibility(0);
            this$0.getMRecyclerView().setVisibility(8);
            this$0.getMGenerateBtn().setVisibility(8);
            this$0.forNumber = 1;
            List<TodayData> list = this$0.mTodayDataList;
            IIX0o.ooOOo0oXI(list);
            if (list.size() > 0) {
                this$0.startAIAnalyze();
                return;
            }
            return;
        }
        ToastUtils.showLong(R.string.heath_reports_lack_of_data_tip);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ArrayList<DslAdapterItem> showCard(List<TodayData> list) {
        this.mTodayDataList = list;
        this.showList.clear();
        this.showList.add(new HeathReportsTopItem(Xo0.f24349oIX0oI.oIX0oI().getLong(XoI0Ixx0.f24436o0IXXIx, 0L), false, null));
        ArrayList arrayList = new ArrayList();
        List<TodayData> list2 = list;
        ArrayList arrayList2 = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList2.add(Boolean.valueOf(arrayList.add(new HeathReportsBaseItem((TodayData) it.next()))));
        }
        ArrayList<DslAdapterItem> arrayList3 = this.showList;
        MainStatusFunctionsItem mainStatusFunctionsItem = new MainStatusFunctionsItem();
        mainStatusFunctionsItem.setItems(arrayList);
        arrayList3.add(mainStatusFunctionsItem);
        return this.showList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startAIAnalyze() {
        List<TodayData> list = this.mTodayDataList;
        IIX0o.ooOOo0oXI(list);
        final TodayData todayData = list.get(this.forNumber - 1);
        HeathReportsUtils heathReportsUtils = HeathReportsUtils.f24217oIX0oI;
        String O0xOxO2 = HeathReportsUtils.O0xOxO(heathReportsUtils, todayData.getDataType(), todayData.getTitle(), todayData.getValue(), 0, 8, null);
        if (O0xOxO2.length() > 0) {
            HeathReportsUtils.xo0x(heathReportsUtils, O0xOxO2, 0, new Oox.oOoXoXO<String, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.status.HeathReportsGenerateActivity$startAIAnalyze$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(String str) {
                    invoke2(str);
                    return oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo String answer) {
                    List list2;
                    List<TodayData> list3;
                    IIX0o.x0xO0oo(answer, "answer");
                    HeathReportsGenerateActivity heathReportsGenerateActivity = HeathReportsGenerateActivity.this;
                    heathReportsGenerateActivity.setForNumber(heathReportsGenerateActivity.getForNumber() + 1);
                    if (answer.length() > 0) {
                        todayData.setMExtraInfo(answer);
                    }
                    int forNumber = HeathReportsGenerateActivity.this.getForNumber();
                    list2 = HeathReportsGenerateActivity.this.mTodayDataList;
                    IIX0o.ooOOo0oXI(list2);
                    if (forNumber != list2.size()) {
                        HeathReportsGenerateActivity.this.startAIAnalyze();
                        return;
                    }
                    HeathReportsUtils heathReportsUtils2 = HeathReportsUtils.f24217oIX0oI;
                    list3 = HeathReportsGenerateActivity.this.mTodayDataList;
                    final HeathReportsGenerateActivity heathReportsGenerateActivity2 = HeathReportsGenerateActivity.this;
                    heathReportsUtils2.IO(list3, new Oox.oOoXoXO<Long, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.status.HeathReportsGenerateActivity$startAIAnalyze$1.1
                        {
                            super(1);
                        }

                        @Override // Oox.oOoXoXO
                        public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Long l) {
                            invoke(l.longValue());
                            return oXIO0o0XI.f29392oIX0oI;
                        }

                        public final void invoke(long j) {
                            if (j > 0) {
                                Xo0.f24349oIX0oI.oIX0oI().put(XoI0Ixx0.f24436o0IXXIx, System.currentTimeMillis());
                                HeathReportsGenerateActivity heathReportsGenerateActivity3 = HeathReportsGenerateActivity.this;
                                String valueOf = String.valueOf(j);
                                Bundle bundle = new Bundle();
                                bundle.putString("mArg0", valueOf);
                                bundle.putParcelable("mArg2", null);
                                bundle.putSerializable("mArg3", null);
                                Intent intent = new Intent(heathReportsGenerateActivity3, (Class<?>) HeathReportsResultActivity.class);
                                intent.putExtras(bundle);
                                heathReportsGenerateActivity3.startActivity(intent);
                                HeathReportsGenerateActivity.this.finish();
                                return;
                            }
                            ToastUtils.showLong(HeathReportsGenerateActivity.this.getString(R.string.generate_failed), new Object[0]);
                        }
                    });
                }
            }, 2, null);
        }
    }

    public final int getForNumber() {
        return this.forNumber;
    }

    @OXOo.OOXIXo
    public final ArrayList<DslAdapterItem> getShowList() {
        return this.showList;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    @SuppressLint({"NotifyDataSetChanged"})
    public void initView() {
        getAbhTitleCenter().setText(getString(R.string.health_report));
        getAbhTitleRight().setVisibility(0);
        getAbhTitleRight().setImageResource(R.drawable.icon_share_hrg);
        getAbhTitleRight().setImageTintList(oIxOXo.oxoX.X0o0xo(this, R.color.text_color));
        initRecyclerView();
        getMGenerateBtn().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.status.oxoX
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HeathReportsGenerateActivity.initView$lambda$0(HeathReportsGenerateActivity.this, view);
            }
        });
        xoIXOxX.II0xO0.I0Io(false, false, null, null, 0, new HeathReportsGenerateActivity$initView$2(this), 31, null);
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

    public final void setForNumber(int i) {
        this.forNumber = i;
    }
}
