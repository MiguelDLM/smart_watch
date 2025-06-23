package com.sma.smartv3.ui.device;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.bestmafen.androidbase.list.BaseListActivity;
import com.blankj.utilcode.util.SizeUtils;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.BleKeyFlag;
import com.szabh.smable3.component.BleCache;
import com.szabh.smable3.component.BleConnector;
import com.szabh.smable3.entity.BleSchedule;
import java.text.SimpleDateFormat;
import java.util.List;

@kotlin.jvm.internal.XX({"SMAP\nSchedulesActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SchedulesActivity.kt\ncom/sma/smartv3/ui/device/SchedulesActivity\n+ 2 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,110:1\n173#2,7:111\n180#2,3:119\n143#2,7:122\n183#2:129\n173#2,7:130\n180#2,3:138\n143#2,7:141\n183#2:148\n1#3:118\n1#3:137\n*S KotlinDebug\n*F\n+ 1 SchedulesActivity.kt\ncom/sma/smartv3/ui/device/SchedulesActivity\n*L\n99#1:111,7\n99#1:119,3\n99#1:122,7\n99#1:129\n59#1:130,7\n59#1:138,3\n59#1:141,7\n59#1:148\n99#1:118\n59#1:137\n*E\n"})
/* loaded from: classes12.dex */
public final class SchedulesActivity extends BaseListActivity<BleSchedule> {

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvTip$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.device.SchedulesActivity$tvTip$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) SchedulesActivity.this.findViewById(R.id.tv_tip);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO btnBottom$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.device.SchedulesActivity$btnBottom$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return SchedulesActivity.this.findViewById(R.id.btn_bottom);
        }
    });

    @OXOo.OOXIXo
    private final SimpleDateFormat mDateFormat = com.sma.smartv3.util.xoIox.oxxXoxO(ProjectManager.f19822oIX0oI.IO(), false, 2, null);

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkScheduleCount() {
        int i;
        boolean z = true;
        TextView tvTip = getTvTip();
        if (getMList().size() == 0) {
            i = 8;
        } else {
            i = 0;
        }
        tvTip.setVisibility(i);
        int xoIxX2 = ProductManager.f20544oIX0oI.xoIxX();
        getTvTip().setText(getString(R.string.schedule_max_tip, Integer.valueOf(xoIxX2)));
        View btnBottom = getBtnBottom();
        if (getMList().size() >= xoIxX2) {
            z = false;
        }
        btnBottom.setEnabled(z);
    }

    private final View getBtnBottom() {
        return (View) this.btnBottom$delegate.getValue();
    }

    private final TextView getTvTip() {
        return (TextView) this.tvTip$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3$lambda$1(SchedulesActivity this$0, IIX0o.II0xO0 iI0xO0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        IIX0o.oxoX oxox = new IIX0o.oxoX(this$0.getMContext());
        oxox.Oo(SizeUtils.dp2px(72.0f));
        oxox.xoIox(R.drawable.ic_delete);
        oxox.II0XooXoX(R.drawable.hr_color);
        iI0xO0.oIX0oI(oxox);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initView$lambda$3$lambda$2(final SchedulesActivity this$0, final int i, IIX0o.II0xO0 iI0xO0, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        return !com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.SchedulesActivity$initView$1$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(BleConnector bleConnector) {
                invoke2(bleConnector);
                return kotlin.oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo BleConnector it) {
                List mList;
                XIOOI.oIX0oI mListAdapter;
                kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                mList = SchedulesActivity.this.getMList();
                BleConnector.sendInt8$default(it, BleKey.SCHEDULE, BleKeyFlag.DELETE, ((BleSchedule) mList.remove(i)).getMId(), false, false, 24, null);
                mListAdapter = SchedulesActivity.this.getMListAdapter();
                mListAdapter.notifyDataSetChanged();
                SchedulesActivity.this.checkScheduleCount();
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4(SchedulesActivity this$0, AdapterView adapterView, View view, int i, long j) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        Bundle bundle = new Bundle();
        bundle.putString("mArg0", null);
        bundle.putInt("mArg1", i);
        bundle.putParcelable("mArg2", null);
        bundle.putSerializable("mArg3", null);
        Intent intent = new Intent(this$0, (Class<?>) ScheduleEditActivity.class);
        intent.putExtras(bundle);
        this$0.startActivityForResult(intent, 0);
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.list.II0xO0
    @OXOo.OOXIXo
    public List<BleSchedule> initList() {
        return BleCache.getList$default(BleCache.INSTANCE, BleKey.SCHEDULE, BleSchedule.class, null, 4, null);
    }

    @Override // com.bestmafen.androidbase.list.BaseListActivity, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        getMListView().setEmptyView(findViewById(R.id.empty));
        ((TextView) findViewById(R.id.abh_title_center)).setText(R.string.schedule);
        ListView mListView = getMListView();
        kotlin.jvm.internal.IIX0o.x0XOIxOo(mListView, "null cannot be cast to non-null type com.baoyz.swipemenulistview.SwipeMenuListView");
        SwipeMenuListView swipeMenuListView = (SwipeMenuListView) mListView;
        swipeMenuListView.setMenuCreator(new IIX0o.I0Io() { // from class: com.sma.smartv3.ui.device.O0OOX0IIx
            @Override // IIX0o.I0Io
            public final void oIX0oI(IIX0o.II0xO0 iI0xO0) {
                SchedulesActivity.initView$lambda$3$lambda$1(SchedulesActivity.this, iI0xO0);
            }
        });
        swipeMenuListView.setOnMenuItemClickListener(new SwipeMenuListView.II0xO0() { // from class: com.sma.smartv3.ui.device.OIxx0I0
            @Override // com.baoyz.swipemenulistview.SwipeMenuListView.II0xO0
            public final boolean oIX0oI(int i, IIX0o.II0xO0 iI0xO0, int i2) {
                boolean initView$lambda$3$lambda$2;
                initView$lambda$3$lambda$2 = SchedulesActivity.initView$lambda$3$lambda$2(SchedulesActivity.this, i, iI0xO0, i2);
                return initView$lambda$3$lambda$2;
            }
        });
        getMListView().setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.sma.smartv3.ui.device.OooO0XOx
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                SchedulesActivity.initView$lambda$4(SchedulesActivity.this, adapterView, view, i, j);
            }
        });
    }

    @Override // com.bestmafen.androidbase.list.II0xO0
    public int itemLayoutId() {
        return R.layout.item_schedule;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_schedules;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @OXOo.oOoXoXO Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            getMList().clear();
            getMList().addAll(BleCache.getList$default(BleCache.INSTANCE, BleKey.SCHEDULE, BleSchedule.class, null, 4, null));
            getMListAdapter().notifyDataSetChanged();
        }
    }

    public final void onBottomClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        Bundle bundle = new Bundle();
        bundle.putString("mArg0", null);
        bundle.putInt("mArg1", -1);
        bundle.putParcelable("mArg2", null);
        bundle.putSerializable("mArg3", null);
        Intent intent = new Intent(this, (Class<?>) ScheduleEditActivity.class);
        intent.putExtras(bundle);
        startActivityForResult(intent, 0);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        checkScheduleCount();
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        finish();
    }

    @Override // com.bestmafen.androidbase.list.I0Io
    public void initItem(@OXOo.OOXIXo XIOOI.I0Io holder, @OXOo.OOXIXo BleSchedule item, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(holder, "holder");
        kotlin.jvm.internal.IIX0o.x0xO0oo(item, "item");
        ((TextView) holder.X0o0xo(R.id.tv_title)).setText(item.getMTitle());
        ((TextView) holder.X0o0xo(R.id.tv_time)).setText(this.mDateFormat.format(XxXX.oIX0oI(item)));
    }
}
