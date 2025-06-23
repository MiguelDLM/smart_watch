package com.sma.smartv3.ui.ai;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.angcyo.dsladapter.DslAdapter;
import com.angcyo.dsladapter.DslAdapterExKt;
import com.angcyo.dsladapter.DslAdapterItem;
import com.angcyo.dsladapter.DslViewHolder;
import com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity;
import com.blankj.utilcode.util.ClipboardUtils;
import com.blankj.utilcode.util.IntentUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.biz.ad.ADPAdError;
import com.sma.smartv3.biz.ad.ADPAdListener;
import com.sma.smartv3.biz.ad.ADPCAdError;
import com.sma.smartv3.biz.ad.ADPCAdListener;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.MyDb;
import com.sma.smartv3.db.dao.AIRecordsDao;
import com.sma.smartv3.db.entity.AIRecords;
import com.sma.smartv3.model.AIFunction;
import com.sma.smartv3.model.AIFunctionType;
import com.sma.smartv3.model.AIRecordsViewData;
import com.sma.smartv3.pop.XoI0Ixx0;
import com.sma.smartv3.view.ad.ADPAdContainerView;
import com.sma.smartv3.view.ad.ADPCAdContainerView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nAIRecordsActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AIRecordsActivity.kt\ncom/sma/smartv3/ui/ai/AIRecordsActivity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,280:1\n1855#2,2:281\n*S KotlinDebug\n*F\n+ 1 AIRecordsActivity.kt\ncom/sma/smartv3/ui/ai/AIRecordsActivity\n*L\n190#1:281,2\n*E\n"})
/* loaded from: classes12.dex */
public class AIRecordsActivity extends BaseDSLRecyclerActivity {

    @OXOo.OOXIXo
    public static final oIX0oI Companion = new oIX0oI(null);
    private static final int REQUEST_DELETE = 255;

    @OXOo.oOoXoXO
    private AIFunction mAIFunction;
    public List<AIRecordsViewData> mAdapterData;

    @OXOo.oOoXoXO
    private XoI0Ixx0 mAllDeleteTipPopup;

    @OXOo.oOoXoXO
    private XoI0Ixx0 mDeleteTipPopup;

    @OXOo.oOoXoXO
    private List<AIRecords> mList;

    @OXOo.OOXIXo
    private final String TAG = "AIRecords";

    @OXOo.OOXIXo
    private final X0IIOO abhTitleRight$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.ai.AIRecordsActivity$abhTitleRight$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) AIRecordsActivity.this.findViewById(R.id.abh_title_right);
        }
    });

    @OXOo.OOXIXo
    private final AIRecordsDao mRecordsDao = MyDb.INSTANCE.getMDatabase().aiRecordsDao();
    private boolean showItemClick = true;

    /* loaded from: classes12.dex */
    public static final class I0Io extends ADPAdListener {
        public I0Io() {
        }

        public void onAdFailed(@OXOo.OOXIXo ADPAdError error) {
            IIX0o.x0xO0oo(error, "error");
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(AIRecordsActivity.this.TAG + " -> Ad State : Error, Info: " + error.getCode() + ", " + error.getMsg());
        }

        public void onAdLoaded() {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(AIRecordsActivity.this.TAG + " -> Ad State : Loaded");
        }
    }

    /* loaded from: classes12.dex */
    public static final class II0xO0 extends ADPCAdListener {
        public II0xO0() {
        }

        @Override // com.sma.smartv3.biz.ad.ADPCAdListener
        public void onADError(@OXOo.OOXIXo ADPCAdError error) {
            IIX0o.x0xO0oo(error, "error");
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(AIRecordsActivity.this.TAG + " -> Ad State : Error, Info: " + error.getCode() + ", " + error.getMsg());
        }

        @Override // com.sma.smartv3.biz.ad.ADPCAdListener
        public void onADReceive() {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(AIRecordsActivity.this.TAG + " -> Ad State : Loaded");
        }
    }

    /* loaded from: classes12.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(IIXOooo iIXOooo) {
            this();
        }

        public oIX0oI() {
        }
    }

    private final ImageView getAbhTitleRight() {
        return (ImageView) this.abhTitleRight$delegate.getValue();
    }

    @OXOo.oOoXoXO
    public final AIFunction getMAIFunction() {
        return this.mAIFunction;
    }

    @OXOo.OOXIXo
    public final List<AIRecordsViewData> getMAdapterData() {
        List<AIRecordsViewData> list = this.mAdapterData;
        if (list != null) {
            return list;
        }
        IIX0o.XOxIOxOx("mAdapterData");
        return null;
    }

    @OXOo.oOoXoXO
    public final List<AIRecords> getMList() {
        return this.mList;
    }

    @OXOo.OOXIXo
    public final AIRecordsDao getMRecordsDao() {
        return this.mRecordsDao;
    }

    public final boolean getShowItemClick() {
        return this.showItemClick;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
        Serializable mArg3 = getMArg3();
        IIX0o.x0XOIxOo(mArg3, "null cannot be cast to non-null type com.sma.smartv3.model.AIFunction");
        this.mAIFunction = (AIFunction) mArg3;
    }

    @OXOo.OOXIXo
    public List<AIRecordsViewData> initList() {
        AIFunctionType aIFunctionType;
        AIRecordsDao aIRecordsDao = this.mRecordsDao;
        AIFunction aIFunction = this.mAIFunction;
        if (aIFunction != null) {
            aIFunctionType = aIFunction.getType();
        } else {
            aIFunctionType = null;
        }
        IIX0o.ooOOo0oXI(aIFunctionType);
        this.mList = aIRecordsDao.getListASC(aIFunctionType.getType());
        setMAdapterData(new ArrayList());
        List<AIRecords> list = this.mList;
        if (list != null) {
            AIRecordsViewData aIRecordsViewData = null;
            for (AIRecords aIRecords : list) {
                if (aIRecords.getMType() == 1) {
                    aIRecordsViewData = new AIRecordsViewData(null, null, 3, null);
                    aIRecordsViewData.setFirst(aIRecords);
                } else if (aIRecords.getMType() == 2 && aIRecordsViewData != null) {
                    aIRecordsViewData.setLast(aIRecords);
                    getMAdapterData().add(aIRecordsViewData);
                }
            }
        }
        setMAdapterData(CollectionsKt___CollectionsKt.o0Xo0XII(CollectionsKt___CollectionsKt.OOoOoO0o(getMAdapterData())));
        return getMAdapterData();
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        ADPAdContainerView aDPAdContainerView;
        super.initView();
        TextView textView = (TextView) findViewById(R.id.abh_title_center);
        if (textView != null) {
            textView.setText(R.string.history_record);
        }
        getAbhTitleRight().setVisibility(0);
        getAbhTitleRight().setImageResource(R.drawable.ai_answer_clean_icon);
        getAbhTitleRight().setImageTintList(oIxOXo.oxoX.X0o0xo(this, R.color.text_color));
        getDslAdapter().getDslAdapterStatusItem().getItemStateLayoutMap().put(1, Integer.valueOf(R.layout.layout_sms_empty));
        initList();
        showList(getMAdapterData());
        ProjectManager projectManager = ProjectManager.f19822oIX0oI;
        if (projectManager.IIX0()) {
            ADPCAdContainerView aDPCAdContainerView = (ADPCAdContainerView) findViewById(R.id.adpcAdContainerView);
            if (aDPCAdContainerView != null) {
                OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " -> id:" + aDPCAdContainerView.getAdUnitId());
                aDPCAdContainerView.setAdListener(new II0xO0());
                ADPCAdContainerView.loadAdView$default(aDPCAdContainerView, null, 0, false, null, 15, null);
                return;
            }
            return;
        }
        if (projectManager.oXIO0o0XI() && (aDPAdContainerView = (ADPAdContainerView) findViewById(R.id.adpAdContainerView)) != null) {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " -> id:" + aDPAdContainerView.getAdUnitId());
            aDPAdContainerView.setAdListener(new I0Io());
            ADPAdContainerView.loadAdView$default(aDPAdContainerView, null, 0, false, null, 15, null);
        }
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_ai_records;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @OXOo.oOoXoXO Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 255) {
            initList();
            showList(getMAdapterData());
        }
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity
    public void onRefresh() {
        initList();
        getRefreshLayout().setRefreshing(false);
        getDslAdapter().notifyDataSetChanged();
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        finish();
    }

    public void onTitleRightClick(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        showAllDeletePopup();
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity
    public int recyclerViewId() {
        return R.id.rv;
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity
    public int refreshLayoutId() {
        return R.id.srf;
    }

    public final void setMAIFunction(@OXOo.oOoXoXO AIFunction aIFunction) {
        this.mAIFunction = aIFunction;
    }

    public final void setMAdapterData(@OXOo.OOXIXo List<AIRecordsViewData> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.mAdapterData = list;
    }

    public final void setMList(@OXOo.oOoXoXO List<AIRecords> list) {
        this.mList = list;
    }

    public final void setShowItemClick(boolean z) {
        this.showItemClick = z;
    }

    public final void share(@OXOo.OOXIXo String content) {
        IIX0o.x0xO0oo(content, "content");
        ClipboardUtils.copyText(content);
        startActivity(IntentUtils.getShareTextIntent(content));
    }

    public final void showAllDeletePopup() {
        if (this.mAllDeleteTipPopup == null) {
            XoI0Ixx0 xoI0Ixx0 = new XoI0Ixx0(this, 0, 2, null);
            xoI0Ixx0.IoOoX(R.string.tip);
            xoI0Ixx0.xI(Integer.valueOf(R.string.clear_ai_chat_records_list));
            xoI0Ixx0.oo0xXOI0I(1);
            xoI0Ixx0.X00IoxXI(Integer.valueOf(R.string.cancel), new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.ai.AIRecordsActivity$showAllDeletePopup$1$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OXOo.OOXIXo
                public final Boolean invoke() {
                    return Boolean.TRUE;
                }
            });
            xoI0Ixx0.x0o(R.string.confirm, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.ai.AIRecordsActivity$showAllDeletePopup$1$2
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OXOo.OOXIXo
                public final Boolean invoke() {
                    List<AIRecords> mList = AIRecordsActivity.this.getMList();
                    if (mList != null) {
                        for (AIRecords aIRecords : mList) {
                            aIRecords.setMIsDelete(1);
                            aIRecords.setMIsSync(0);
                        }
                    }
                    AIRecordsDao mRecordsDao = AIRecordsActivity.this.getMRecordsDao();
                    List<AIRecords> mList2 = AIRecordsActivity.this.getMList();
                    IIX0o.ooOOo0oXI(mList2);
                    mRecordsDao.update(mList2);
                    AIRecordsActivity.this.getMAdapterData().clear();
                    AIRecordsActivity aIRecordsActivity = AIRecordsActivity.this;
                    aIRecordsActivity.showList(aIRecordsActivity.getMAdapterData());
                    AIRecordsActivity.this.getDslAdapter().notifyDataSetChanged();
                    ToastUtils.showLong(R.string.clear_success);
                    com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24646oxxXoxO, null, 2, null);
                    return Boolean.TRUE;
                }
            });
            this.mAllDeleteTipPopup = xoI0Ixx0;
        }
        XoI0Ixx0 xoI0Ixx02 = this.mAllDeleteTipPopup;
        if (xoI0Ixx02 != null) {
            xoI0Ixx02.IIXOooo();
        }
    }

    public final void showDeletePopup(@OXOo.OOXIXo final AIRecords mQuestion, @OXOo.OOXIXo final AIRecords mResults, final int i) {
        IIX0o.x0xO0oo(mQuestion, "mQuestion");
        IIX0o.x0xO0oo(mResults, "mResults");
        if (this.mDeleteTipPopup == null) {
            XoI0Ixx0 xoI0Ixx0 = new XoI0Ixx0(this, 0, 2, null);
            xoI0Ixx0.IoOoX(R.string.tip);
            xoI0Ixx0.xI(Integer.valueOf(R.string.clear_ai_chat_current_records));
            xoI0Ixx0.oo0xXOI0I(1);
            xoI0Ixx0.X00IoxXI(Integer.valueOf(R.string.cancel), new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.ai.AIRecordsActivity$showDeletePopup$1$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OXOo.OOXIXo
                public final Boolean invoke() {
                    return Boolean.TRUE;
                }
            });
            xoI0Ixx0.x0o(R.string.confirm, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.ai.AIRecordsActivity$showDeletePopup$1$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // Oox.oIX0oI
                @OXOo.OOXIXo
                public final Boolean invoke() {
                    AIRecords.this.setMIsDelete(1);
                    AIRecords.this.setMIsSync(0);
                    mResults.setMIsDelete(1);
                    mResults.setMIsSync(0);
                    this.getMRecordsDao().update(AIRecords.this);
                    this.getMRecordsDao().update(mResults);
                    this.getMAdapterData().remove(i);
                    AIRecordsActivity aIRecordsActivity = this;
                    aIRecordsActivity.showList(aIRecordsActivity.getMAdapterData());
                    this.getDslAdapter().notifyDataSetChanged();
                    ToastUtils.showLong(R.string.success);
                    com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24646oxxXoxO, null, 2, null);
                    if (!this.getShowItemClick()) {
                        this.setResult(-1);
                        this.finish();
                    }
                    return Boolean.TRUE;
                }
            });
            this.mDeleteTipPopup = xoI0Ixx0;
        }
        XoI0Ixx0 xoI0Ixx02 = this.mDeleteTipPopup;
        if (xoI0Ixx02 != null) {
            xoI0Ixx02.IIXOooo();
        }
    }

    public final void showList(@OXOo.OOXIXo final List<AIRecordsViewData> list) {
        IIX0o.x0xO0oo(list, "list");
        getDslAdapter().resetItem(new ArrayList());
        renderAdapter(new Oox.oOoXoXO<DslAdapter, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.ai.AIRecordsActivity$showList$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                IIX0o.x0xO0oo(renderAdapter, "$this$renderAdapter");
                if (list.isEmpty()) {
                    DslAdapter.setAdapterStatus$default(this.getDslAdapter(), 1, null, 2, null);
                    return;
                }
                DslAdapter.setAdapterStatus$default(this.getDslAdapter(), 0, null, 2, null);
                for (final AIRecordsViewData aIRecordsViewData : list) {
                    final AIRecordsActivity aIRecordsActivity = this;
                    DslAdapterExKt.oO(renderAdapter, R.layout.item_ai_records, new Oox.oOoXoXO<DslAdapterItem, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.ai.AIRecordsActivity$showList$1.1

                        @XX({"SMAP\nAIRecordsActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AIRecordsActivity.kt\ncom/sma/smartv3/ui/ai/AIRecordsActivity$showList$1$1$1\n+ 2 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,280:1\n173#2,7:281\n180#2,3:289\n143#2,7:292\n183#2:299\n1#3:288\n*S KotlinDebug\n*F\n+ 1 AIRecordsActivity.kt\ncom/sma/smartv3/ui/ai/AIRecordsActivity$showList$1$1$1\n*L\n140#1:281,7\n140#1:289,3\n140#1:292,7\n140#1:299\n140#1:288\n*E\n"})
                        /* renamed from: com.sma.smartv3.ui.ai.AIRecordsActivity$showList$1$1$1, reason: invalid class name and collision with other inner class name */
                        /* loaded from: classes12.dex */
                        public static final class C09331 extends Lambda implements Oox.Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, oXIO0o0XI> {
                            final /* synthetic */ AIRecordsViewData $item;
                            final /* synthetic */ AIRecordsActivity this$0;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            public C09331(AIRecordsViewData aIRecordsViewData, AIRecordsActivity aIRecordsActivity) {
                                super(4);
                                this.$item = aIRecordsViewData;
                                this.this$0 = aIRecordsActivity;
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public static final void invoke$lambda$0(AIRecordsActivity this$0, AIRecords questionRecords, AIRecords resultsRecords, int i, View view) {
                                IIX0o.x0xO0oo(this$0, "this$0");
                                IIX0o.x0xO0oo(questionRecords, "$questionRecords");
                                IIX0o.x0xO0oo(resultsRecords, "$resultsRecords");
                                this$0.showDeletePopup(questionRecords, resultsRecords, i);
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public static final void invoke$lambda$1(AIRecordsActivity this$0, String question, String results, View view) {
                                IIX0o.x0xO0oo(this$0, "this$0");
                                IIX0o.x0xO0oo(question, "$question");
                                IIX0o.x0xO0oo(results, "$results");
                                this$0.share(question + "\n\n" + results);
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public static final void invoke$lambda$2(AIRecordsActivity this$0, AIRecordsViewData item, View view) {
                                IIX0o.x0xO0oo(this$0, "this$0");
                                IIX0o.x0xO0oo(item, "$item");
                                Bundle bundle = new Bundle();
                                bundle.putString("mArg0", null);
                                bundle.putParcelable("mArg2", null);
                                bundle.putSerializable("mArg3", item);
                                Intent intent = new Intent(this$0, (Class<?>) AIRecordsDetailActivity.class);
                                intent.putExtras(bundle);
                                this$0.startActivityForResult(intent, 255);
                            }

                            @Override // Oox.Oxx0xo
                            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslViewHolder dslViewHolder, Integer num, DslAdapterItem dslAdapterItem, List<? extends Object> list) {
                                invoke(dslViewHolder, num.intValue(), dslAdapterItem, list);
                                return oXIO0o0XI.f29392oIX0oI;
                            }

                            public final void invoke(@OXOo.OOXIXo DslViewHolder itemHolder, final int i, @OXOo.OOXIXo DslAdapterItem dslAdapterItem, @OXOo.OOXIXo List<? extends Object> list) {
                                Activity mContext;
                                IIX0o.x0xO0oo(itemHolder, "itemHolder");
                                IIX0o.x0xO0oo(dslAdapterItem, "<anonymous parameter 2>");
                                IIX0o.x0xO0oo(list, "<anonymous parameter 3>");
                                final AIRecords first = this.$item.getFirst();
                                IIX0o.ooOOo0oXI(first);
                                final AIRecords last = this.$item.getLast();
                                IIX0o.ooOOo0oXI(last);
                                final String str = this.this$0.getString(R.string.problem) + " : " + first.getMContent();
                                if (this.this$0.getShowItemClick()) {
                                    final String str2 = this.this$0.getString(R.string.generate_results) + " : " + last.getMContent();
                                    TextView tv = itemHolder.tv(R.id.item_ai_records_results);
                                    if (tv != null) {
                                        tv.setMaxHeight(300);
                                    }
                                    View view = itemHolder.view(R.id.item_ai_records_delete);
                                    if (view != null) {
                                        view.setVisibility(0);
                                    }
                                    View view2 = itemHolder.view(R.id.item_ai_records_share);
                                    if (view2 != null) {
                                        view2.setVisibility(0);
                                    }
                                    View view3 = itemHolder.view(R.id.item_ai_records_delete);
                                    if (view3 != null) {
                                        final AIRecordsActivity aIRecordsActivity = this.this$0;
                                        view3.setOnClickListener(
                                        /*  JADX ERROR: Method code generation error
                                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00a0: INVOKE 
                                              (r6v1 'view3' android.view.View)
                                              (wrap:android.view.View$OnClickListener:0x009d: CONSTRUCTOR 
                                              (r7v6 'aIRecordsActivity' com.sma.smartv3.ui.ai.AIRecordsActivity A[DONT_INLINE])
                                              (r12v3 'first' com.sma.smartv3.db.entity.AIRecords A[DONT_INLINE])
                                              (r13v2 'last' com.sma.smartv3.db.entity.AIRecords A[DONT_INLINE])
                                              (r11v0 'i' int A[DONT_INLINE])
                                             A[MD:(com.sma.smartv3.ui.ai.AIRecordsActivity, com.sma.smartv3.db.entity.AIRecords, com.sma.smartv3.db.entity.AIRecords, int):void (m), WRAPPED] call: com.sma.smartv3.ui.ai.oOoXoXO.<init>(com.sma.smartv3.ui.ai.AIRecordsActivity, com.sma.smartv3.db.entity.AIRecords, com.sma.smartv3.db.entity.AIRecords, int):void type: CONSTRUCTOR)
                                             VIRTUAL call: android.view.View.setOnClickListener(android.view.View$OnClickListener):void A[MD:(android.view.View$OnClickListener):void (c)] in method: com.sma.smartv3.ui.ai.AIRecordsActivity.showList.1.1.1.invoke(com.angcyo.dsladapter.DslViewHolder, int, com.angcyo.dsladapter.DslAdapterItem, java.util.List<? extends java.lang.Object>):void, file: classes12.dex
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.sma.smartv3.ui.ai.oOoXoXO, state: NOT_LOADED
                                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1117)
                                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:884)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                            	... 27 more
                                            */
                                        /*
                                            Method dump skipped, instructions count: 330
                                            To view this dump add '--comments-level debug' option
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.ai.AIRecordsActivity$showList$1.AnonymousClass1.C09331.invoke(com.angcyo.dsladapter.DslViewHolder, int, com.angcyo.dsladapter.DslAdapterItem, java.util.List):void");
                                    }
                                }

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                    IIX0o.x0xO0oo(dslItem, "$this$dslItem");
                                    dslItem.setItemBindOverride(new C09331(AIRecordsViewData.this, aIRecordsActivity));
                                }
                            });
                        }
                    }
                });
            }
        }
