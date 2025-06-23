package com.sma.smartv3.ui.me;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bestmafen.androidbase.list.BaseListActivity;
import com.blankj.utilcode.util.SPUtils;
import com.google.gson.Gson;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.view.CompletionValueView;
import com.sma.smartv3.view.swipelist.DragListView;
import com.sma.smartv3.view.swipelist.SwipeLayout;
import com.szabh.smable3.component.BleConnector;
import com.szabh.smable3.entity.BleCoaching;
import com.szabh.smable3.entity.BleCoachingSegment;
import com.szabh.smable3.entity.CompletionCondition;
import com.szabh.smable3.entity.SegmentActivity;
import com.szabh.smable3.entity.Stage;
import java.util.Collections;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;

@kotlin.jvm.internal.XX({"SMAP\nCoachingSegmentsActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoachingSegmentsActivity.kt\ncom/sma/smartv3/ui/me/CoachingSegmentsActivity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n*L\n1#1,206:1\n18#2,2:207\n15#2:209\n18#2,2:211\n15#2:213\n18#2,2:214\n15#2:216\n11#2,2:217\n1#3:210\n1#3:226\n173#4,7:219\n180#4,3:227\n143#4,7:230\n183#4:237\n*S KotlinDebug\n*F\n+ 1 CoachingSegmentsActivity.kt\ncom/sma/smartv3/ui/me/CoachingSegmentsActivity\n*L\n93#1:207,2\n93#1:209\n159#1:211,2\n159#1:213\n161#1:214,2\n161#1:216\n179#1:217,2\n180#1:226\n180#1:219,7\n180#1:227,3\n180#1:230,7\n180#1:237\n*E\n"})
/* loaded from: classes11.dex */
public final class CoachingSegmentsActivity extends BaseListActivity<BleCoachingSegment> {

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.XoI0Ixx0 mDeleteFailedPopup;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.XoI0Ixx0 mDeletePopup;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO titleRight$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.me.CoachingSegmentsActivity$titleRight$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return CoachingSegmentsActivity.this.findViewById(R.id.abh_title_right);
        }
    });

    @OXOo.OOXIXo
    private final Rect mDragRect = new Rect();
    private int mIndex = -1;

    /* loaded from: classes11.dex */
    public static final class oIX0oI extends DragListView.I0Io {
        public oIX0oI() {
        }

        @Override // com.sma.smartv3.view.swipelist.DragListView.II0xO0
        public boolean I0Io(@OXOo.oOoXoXO View view, int i, int i2) {
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(view);
            View findViewById = view.findViewById(R.id.iv_reorder);
            if (findViewById == null || findViewById.getVisibility() != 0) {
                return false;
            }
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildAt(0).getTranslationX() < 0.0f) {
                return false;
            }
            float x = i - viewGroup.getX();
            float y = i2 - viewGroup.getY();
            findViewById.getHitRect(CoachingSegmentsActivity.this.mDragRect);
            return CoachingSegmentsActivity.this.mDragRect.contains((int) x, (int) y);
        }

        @Override // com.sma.smartv3.view.swipelist.DragListView.II0xO0
        public void X0o0xo(@OXOo.oOoXoXO View view) {
        }

        @Override // com.sma.smartv3.view.swipelist.DragListView.II0xO0
        public boolean XO(int i, int i2) {
            Collections.swap(CoachingSegmentsActivity.this.getMList(), i, i2);
            CoachingSegmentsActivity.this.getMListAdapter().notifyDataSetChanged();
            return true;
        }

        @Override // com.sma.smartv3.view.swipelist.DragListView.II0xO0
        @OXOo.oOoXoXO
        public Bitmap oxoX(@OXOo.oOoXoXO View view, @OXOo.oOoXoXO Bitmap bitmap) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkCount() {
        boolean z;
        View titleRight = getTitleRight();
        if (getMList().size() < ProductManager.f20544oIX0oI.XOxIOxOx()) {
            z = true;
        } else {
            z = false;
        }
        titleRight.setEnabled(z);
    }

    private final View getTitleRight() {
        return (View) this.titleRight$delegate.getValue();
    }

    private final BleCoachingSegment newSegment() {
        return new BleCoachingSegment(CompletionCondition.DURATION.getCondition(), "", SegmentActivity.TIMER.getActivity(), Stage.GO_FOR.getStage(), 0, 0, 16, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void toEdit(int i) {
        BleCoachingSegment bleCoachingSegment;
        this.mIndex = i;
        if (i < 0) {
            bleCoachingSegment = newSegment();
        } else {
            bleCoachingSegment = getMList().get(i);
        }
        com.sma.smartv3.util.Xo0.f24349oIX0oI.oxoX().put(BleCoachingSegment.class.getName(), new Gson().toJson(bleCoachingSegment));
        int i2 = this.mIndex;
        Bundle bundle = new Bundle();
        bundle.putString("mArg0", null);
        bundle.putInt("mArg1", i2);
        bundle.putParcelable("mArg2", null);
        bundle.putSerializable("mArg3", null);
        Intent intent = new Intent(this, (Class<?>) CoachingSegmentEditActivity.class);
        intent.putExtras(bundle);
        startActivityForResult(intent, 0);
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.list.II0xO0
    @OXOo.OOXIXo
    public List<BleCoachingSegment> initList() {
        Object fromJson = new Gson().fromJson(com.sma.smartv3.util.Xo0.f24349oIX0oI.oxoX().getString(BleCoaching.class.getName()), (Class<Object>) BleCoaching.class);
        if (fromJson == null) {
            fromJson = BleCoaching.class.newInstance();
        }
        return CollectionsKt___CollectionsKt.o0Xo0XII(((BleCoaching) fromJson).getMSegments());
    }

    @Override // com.bestmafen.androidbase.list.BaseListActivity, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        ((TextView) findViewById(R.id.abh_title_center)).setText(R.string.coaching_segments);
        ImageView imageView = (ImageView) findViewById(R.id.abh_title_right);
        imageView.setImageResource(R.drawable.ic_coaching_add);
        imageView.setVisibility(0);
        ListView mListView = getMListView();
        kotlin.jvm.internal.IIX0o.x0XOIxOo(mListView, "null cannot be cast to non-null type com.sma.smartv3.view.swipelist.DragListView");
        ((DragListView) mListView).setDragItemListener(new oIX0oI());
        checkCount();
    }

    @Override // com.bestmafen.androidbase.list.II0xO0
    public int itemLayoutId() {
        return R.layout.item_coaching_segment;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_coaching_segments;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @OXOo.oOoXoXO Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (this.mIndex < 0) {
                List<BleCoachingSegment> mList = getMList();
                Object fromJson = new Gson().fromJson(com.sma.smartv3.util.Xo0.f24349oIX0oI.oxoX().getString(BleCoachingSegment.class.getName()), (Class<Object>) BleCoachingSegment.class);
                if (fromJson == null) {
                    fromJson = BleCoachingSegment.class.newInstance();
                }
                mList.add(fromJson);
            } else {
                List<BleCoachingSegment> mList2 = getMList();
                int i3 = this.mIndex;
                Object fromJson2 = new Gson().fromJson(com.sma.smartv3.util.Xo0.f24349oIX0oI.oxoX().getString(BleCoachingSegment.class.getName()), (Class<Object>) BleCoachingSegment.class);
                if (fromJson2 == null) {
                    fromJson2 = BleCoachingSegment.class.newInstance();
                }
                mList2.set(i3, fromJson2);
            }
            getMListAdapter().notifyDataSetChanged();
            checkCount();
        }
    }

    public final void onBottomClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.CoachingSegmentsActivity$onBottomClick$1
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
                kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                SPUtils oxoX2 = com.sma.smartv3.util.Xo0.f24349oIX0oI.oxoX();
                CoachingSegmentsActivity coachingSegmentsActivity = CoachingSegmentsActivity.this;
                Object fromJson = new Gson().fromJson(oxoX2.getString(BleCoaching.class.getName()), (Class<Object>) BleCoaching.class);
                if (fromJson == null) {
                    fromJson = BleCoaching.class.newInstance();
                }
                ((BleCoaching) fromJson).setMSegments(coachingSegmentsActivity.getMList());
                oxoX2.put(BleCoaching.class.getName(), new Gson().toJson(fromJson));
                CoachingSegmentsActivity.this.setResult(-1);
                CoachingSegmentsActivity.this.finish();
            }
        }, 1, null);
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        finish();
    }

    public final void onTitleRightClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        toEdit(-1);
    }

    @Override // com.bestmafen.androidbase.list.I0Io
    public void initItem(@OXOo.OOXIXo XIOOI.I0Io holder, @OXOo.OOXIXo BleCoachingSegment item, final int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(holder, "holder");
        kotlin.jvm.internal.IIX0o.x0xO0oo(item, "item");
        BleCoachingSegment bleCoachingSegment = getMList().get(i);
        holder.ooOOo0oXI(R.id.iv_activity, oOXoIIIo.oIX0oI.oIX0oI(getMContext(), "ic_segment_activity" + bleCoachingSegment.getMActivity(), "drawable", R.drawable.ic_segment_activity0));
        oOXoIIIo.Oxx0IOOO.oxoX(holder, R.id.tv_stage, oOXoIIIo.oIX0oI.oIX0oI(getMContext(), "segment_stage" + bleCoachingSegment.getMStage(), TypedValues.Custom.S_STRING, R.string.segment_stage255));
        String mName = bleCoachingSegment.getMName();
        if (kotlin.text.OxI.X0O0I0(mName)) {
            mName = getString(R.string.coaching_segment_d, Integer.valueOf(i + 1));
            kotlin.jvm.internal.IIX0o.oO(mName, "getString(...)");
        }
        holder.o00(R.id.tv_name, mName);
        CompletionValueView completionValueView = (CompletionValueView) holder.X0o0xo(R.id.completion_value);
        int mCompletionCondition = bleCoachingSegment.getMCompletionCondition();
        if (mCompletionCondition == CompletionCondition.DURATION.getCondition() || mCompletionCondition == CompletionCondition.DURATION_IN_HR_ZONE.getCondition()) {
            completionValueView.setMDuration(bleCoachingSegment.getMCompletionValue());
        } else if (mCompletionCondition != CompletionCondition.MANUAL.getCondition() && (mCompletionCondition == CompletionCondition.HR_BELOW.getCondition() || mCompletionCondition == CompletionCondition.HR_ABOVE.getCondition())) {
            completionValueView.setMBpm(bleCoachingSegment.getMCompletionValue());
        }
        SwipeLayout swipeLayout = (SwipeLayout) holder.X0o0xo(R.id.swipe_layout);
        swipeLayout.X0o0xo(true);
        swipeLayout.setSwipeListener(new SwipeLayout.II0xO0() { // from class: com.sma.smartv3.ui.me.CoachingSegmentsActivity$initItem$2$1
            @Override // com.sma.smartv3.view.swipelist.SwipeLayout.II0xO0
            public void onClick() {
                CoachingSegmentsActivity.this.toEdit(i);
            }

            @Override // com.sma.smartv3.view.swipelist.SwipeLayout.II0xO0
            public void onDelete() {
                com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0;
                com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx02;
                Activity mContext;
                CoachingSegmentsActivity.this.mIndex = i;
                xoI0Ixx0 = CoachingSegmentsActivity.this.mDeletePopup;
                if (xoI0Ixx0 == null) {
                    CoachingSegmentsActivity coachingSegmentsActivity = CoachingSegmentsActivity.this;
                    mContext = CoachingSegmentsActivity.this.getMContext();
                    com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx03 = new com.sma.smartv3.pop.XoI0Ixx0(mContext, 0, 2, null);
                    final CoachingSegmentsActivity coachingSegmentsActivity2 = CoachingSegmentsActivity.this;
                    xoI0Ixx03.IoOoX(R.string.delete_segment_tip);
                    com.sma.smartv3.pop.XoI0Ixx0.IO(xoI0Ixx03, Integer.valueOf(R.string.cancel), null, 2, null);
                    xoI0Ixx03.x0o(R.string.confirm, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.me.CoachingSegmentsActivity$initItem$2$1$onDelete$1$1
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // Oox.oIX0oI
                        @OXOo.OOXIXo
                        public final Boolean invoke() {
                            int i2;
                            com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx04;
                            com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx05;
                            Activity mContext2;
                            if (CoachingSegmentsActivity.this.getMList().size() <= 1) {
                                xoI0Ixx04 = CoachingSegmentsActivity.this.mDeleteFailedPopup;
                                if (xoI0Ixx04 == null) {
                                    CoachingSegmentsActivity coachingSegmentsActivity3 = CoachingSegmentsActivity.this;
                                    mContext2 = CoachingSegmentsActivity.this.getMContext();
                                    com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx06 = new com.sma.smartv3.pop.XoI0Ixx0(mContext2, 0, 2, null);
                                    xoI0Ixx06.IoOoX(R.string.failed_to_delete);
                                    xoI0Ixx06.xI(Integer.valueOf(R.string.segment_delete_failed_tip));
                                    com.sma.smartv3.pop.XoI0Ixx0.IO(xoI0Ixx06, null, null, 2, null);
                                    com.sma.smartv3.pop.XoI0Ixx0.XOxIOxOx(xoI0Ixx06, R.string.confirm, null, 2, null);
                                    coachingSegmentsActivity3.mDeleteFailedPopup = xoI0Ixx06;
                                }
                                xoI0Ixx05 = CoachingSegmentsActivity.this.mDeleteFailedPopup;
                                if (xoI0Ixx05 != null) {
                                    xoI0Ixx05.IIXOooo();
                                }
                            } else {
                                List mList = CoachingSegmentsActivity.this.getMList();
                                i2 = CoachingSegmentsActivity.this.mIndex;
                                mList.remove(i2);
                                CoachingSegmentsActivity.this.getMListAdapter().notifyDataSetChanged();
                                CoachingSegmentsActivity.this.checkCount();
                            }
                            return Boolean.TRUE;
                        }
                    });
                    coachingSegmentsActivity.mDeletePopup = xoI0Ixx03;
                }
                xoI0Ixx02 = CoachingSegmentsActivity.this.mDeletePopup;
                if (xoI0Ixx02 != null) {
                    xoI0Ixx02.IIXOooo();
                }
            }
        });
    }
}
