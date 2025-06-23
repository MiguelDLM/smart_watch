package com.sma.smartv3.ui.device;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.bestmafen.androidbase.extension.PermissionStatus;
import com.blankj.utilcode.constant.PermissionConstants;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.PermissionUtils;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.initializer.BleInitializer;
import com.sma.smartv3.ui.device.NotificationSettingsActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.text.StringsKt__StringsKt;

@kotlin.jvm.internal.XX({"SMAP\nNotificationSettingsActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NotificationSettingsActivity.kt\ncom/sma/smartv3/ui/device/NotificationSettingsActivity\n+ 2 TextView.kt\nandroidx/core/widget/TextViewKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,353:1\n65#2,16:354\n93#2,3:370\n1549#3:373\n1620#3,3:374\n1549#3:377\n1620#3,3:378\n766#3:381\n857#3,2:382\n766#3:384\n857#3,2:385\n13309#4,2:387\n1#5:389\n*S KotlinDebug\n*F\n+ 1 NotificationSettingsActivity.kt\ncom/sma/smartv3/ui/device/NotificationSettingsActivity\n*L\n118#1:354,16\n118#1:370,3\n127#1:373\n127#1:374,3\n132#1:377\n132#1:378,3\n155#1:381\n155#1:382,2\n162#1:384\n162#1:385,2\n177#1:387,2\n*E\n"})
/* loaded from: classes12.dex */
public final class NotificationSettingsActivity extends BaseListFunctionActivity<x0XOIxOo> implements CompoundButton.OnCheckedChangeListener {
    public XIOOI.oIX0oI<x0XOIxOo> mCommonAdapter;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.I0X0x0oIo mLoadingPopup;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO ll$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.device.NotificationSettingsActivity$ll$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return NotificationSettingsActivity.this.findViewById(R.id.ll);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO checkCall$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<CheckBox>() { // from class: com.sma.smartv3.ui.device.NotificationSettingsActivity$checkCall$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final CheckBox invoke() {
            return (CheckBox) NotificationSettingsActivity.this.findViewById(R.id.check_call);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO checkSms$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<CheckBox>() { // from class: com.sma.smartv3.ui.device.NotificationSettingsActivity$checkSms$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final CheckBox invoke() {
            return (CheckBox) NotificationSettingsActivity.this.findViewById(R.id.check_sms);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO checkMirrorPhone$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<CheckBox>() { // from class: com.sma.smartv3.ui.device.NotificationSettingsActivity$checkMirrorPhone$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final CheckBox invoke() {
            return (CheckBox) NotificationSettingsActivity.this.findViewById(R.id.check_mirror_phone);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO otherPanel$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.device.NotificationSettingsActivity$otherPanel$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return NotificationSettingsActivity.this.findViewById(R.id.other_panel);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO abhTitleRight$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.device.NotificationSettingsActivity$abhTitleRight$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) NotificationSettingsActivity.this.findViewById(R.id.abh_title_right);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO defautListView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ListView>() { // from class: com.sma.smartv3.ui.device.NotificationSettingsActivity$defautListView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ListView invoke() {
            return (ListView) NotificationSettingsActivity.this.findViewById(R.id.default_list_view);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO searchEditText$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<EditText>() { // from class: com.sma.smartv3.ui.device.NotificationSettingsActivity$searchEditText$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final EditText invoke() {
            return (EditText) NotificationSettingsActivity.this.findViewById(R.id.notification_search);
        }
    });

    @OXOo.OOXIXo
    private final List<x0XOIxOo> mDefaultList = new ArrayList();

    @OXOo.OOXIXo
    private List<x0XOIxOo> mCacheDefaultList = new ArrayList();

    @OXOo.OOXIXo
    private List<x0XOIxOo> mCacheList = new ArrayList();

    /* loaded from: classes12.dex */
    public static final class II0xO0 extends XIOOI.oIX0oI<x0XOIxOo> {
        public II0xO0(Activity activity, List<x0XOIxOo> list) {
            super(activity, R.layout.item_notification, list);
        }

        public static final void Oxx0IOOO(NotificationSettingsActivity this$0, int i, View view) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
            this$0.getMDefaultList().get(i).X0o0xo(!this$0.getMDefaultList().get(i).oxoX());
            com.sma.smartv3.util.Xo0.f24349oIX0oI.I0Io().put(com.sma.smartv3.util.XoI0Ixx0.f24443oIX0oI + this$0.getMDefaultList().get(i).I0Io(), this$0.getMDefaultList().get(i).oxoX());
            LogUtils.d(this$0.getMDefaultList().get(i).toString());
        }

        @Override // XIOOI.oIX0oI, XIOOI.II0xO0
        /* renamed from: XO, reason: merged with bridge method [inline-methods] */
        public void II0xO0(@OXOo.OOXIXo XIOOI.I0Io holder, @OXOo.OOXIXo x0XOIxOo item, final int i) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(holder, "holder");
            kotlin.jvm.internal.IIX0o.x0xO0oo(item, "item");
            final NotificationSettingsActivity notificationSettingsActivity = NotificationSettingsActivity.this;
            holder.oOoXoXO(R.id.iv_icon, notificationSettingsActivity.getMDefaultList().get(i).oIX0oI());
            holder.o00(R.id.tv_name, notificationSettingsActivity.getMDefaultList().get(i).II0xO0());
            notificationSettingsActivity.getMDefaultList().get(i).X0o0xo(com.sma.smartv3.util.Xo0.f24349oIX0oI.I0Io().getBoolean(com.sma.smartv3.util.XoI0Ixx0.f24443oIX0oI + notificationSettingsActivity.getMDefaultList().get(i).I0Io(), false));
            holder.xoIox(R.id.check_enabled, notificationSettingsActivity.getMDefaultList().get(i).oxoX());
            oOXoIIIo.Oxx0IOOO.oIX0oI(holder, R.id.check_enabled, new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.xxx00
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NotificationSettingsActivity.II0xO0.Oxx0IOOO(NotificationSettingsActivity.this, i, view);
                }
            });
        }

        @Override // XIOOI.II0xO0, android.widget.Adapter
        public int getCount() {
            return NotificationSettingsActivity.this.getMDefaultList().size();
        }
    }

    @kotlin.jvm.internal.XX({"SMAP\nTextView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1\n+ 2 NotificationSettingsActivity.kt\ncom/sma/smartv3/ui/device/NotificationSettingsActivity\n+ 3 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$1\n+ 4 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$2\n*L\n1#1,97:1\n121#2,2:98\n71#3:100\n77#4:101\n*E\n"})
    /* loaded from: classes12.dex */
    public static final class oIX0oI implements TextWatcher {
        public oIX0oI() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@OXOo.oOoXoXO Editable editable) {
            NotificationSettingsActivity.this.textChanged(editable);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@OXOo.oOoXoXO CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@OXOo.oOoXoXO CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    private final ImageView getAbhTitleRight() {
        return (ImageView) this.abhTitleRight$delegate.getValue();
    }

    private final CheckBox getCheckCall() {
        return (CheckBox) this.checkCall$delegate.getValue();
    }

    private final CheckBox getCheckMirrorPhone() {
        return (CheckBox) this.checkMirrorPhone$delegate.getValue();
    }

    private final CheckBox getCheckSms() {
        return (CheckBox) this.checkSms$delegate.getValue();
    }

    private final ListView getDefautListView() {
        return (ListView) this.defautListView$delegate.getValue();
    }

    private final View getLl() {
        return (View) this.ll$delegate.getValue();
    }

    private final View getOtherPanel() {
        return (View) this.otherPanel$delegate.getValue();
    }

    private final EditText getSearchEditText() {
        return (EditText) this.searchEditText$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initItem$lambda$10$lambda$9(NotificationSettingsActivity this$0, int i, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.getMList().get(i).X0o0xo(!this$0.getMList().get(i).oxoX());
        com.sma.smartv3.util.Xo0.f24349oIX0oI.I0Io().put(com.sma.smartv3.util.XoI0Ixx0.f24443oIX0oI + this$0.getMList().get(i).I0Io(), this$0.getMList().get(i).oxoX());
        LogUtils.d(this$0.getMList().get(i).toString());
    }

    private final void showDefaultList() {
        ApplicationInfo applicationInfo;
        for (String str : ProjectManager.f19822oIX0oI.oI0IIXIo()) {
            try {
                applicationInfo = getPackageManager().getApplicationInfo(str, 0);
            } catch (Exception unused) {
                applicationInfo = null;
            }
            if (applicationInfo != null) {
                x0XOIxOo x0xoixoo = new x0XOIxOo();
                x0xoixoo.XO(applicationInfo.loadIcon(getPackageManager()));
                x0xoixoo.Oxx0IOOO(applicationInfo.loadLabel(getPackageManager()).toString());
                x0xoixoo.II0XooXoX(applicationInfo.packageName);
                this.mDefaultList.add(x0xoixoo);
            } else if (ProjectManager.f19822oIX0oI.OIx00oxx()) {
                Pair<Integer, String> oIX0oI2 = com.sma.smartv3.util.O0Xx.f24313oIX0oI.oIX0oI(str);
                int intValue = oIX0oI2.component1().intValue();
                String component2 = oIX0oI2.component2();
                if (component2.length() > 0) {
                    x0XOIxOo x0xoixoo2 = new x0XOIxOo();
                    x0xoixoo2.XO(getDrawable(intValue));
                    x0xoixoo2.Oxx0IOOO(component2);
                    x0xoixoo2.II0XooXoX(str);
                    this.mDefaultList.add(x0xoixoo2);
                }
            }
        }
        II0xO0 iI0xO0 = new II0xO0(getMContext(), this.mDefaultList);
        getDefautListView().setAdapter((ListAdapter) iI0xO0);
        setMCommonAdapter(iI0xO0);
    }

    private final void showOthersList() {
        xoIXOxX.II0xO0.I0Io(false, false, null, null, 0, new NotificationSettingsActivity$showOthersList$1(this), 31, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void textChanged(Editable editable) {
        if (this.mCacheDefaultList.size() == 0 && !this.mDefaultList.isEmpty()) {
            List<x0XOIxOo> list = this.mDefaultList;
            ArrayList arrayList = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(Boolean.valueOf(this.mCacheDefaultList.add((x0XOIxOo) it.next())));
            }
        }
        if (this.mCacheList.size() == 0 && !getMList().isEmpty()) {
            List<x0XOIxOo> mList = getMList();
            ArrayList arrayList2 = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(mList, 10));
            Iterator<T> it2 = mList.iterator();
            while (it2.hasNext()) {
                arrayList2.add(Boolean.valueOf(this.mCacheList.add((x0XOIxOo) it2.next())));
            }
        }
        if (editable != null && editable.length() == 0) {
            showLoadingPopup();
            ArrayList arrayList3 = (ArrayList) CollectionsKt___CollectionsKt.X0oX(this.mCacheDefaultList, new ArrayList());
            this.mDefaultList.clear();
            this.mDefaultList.addAll(arrayList3);
            getMCommonAdapter().notifyDataSetChanged();
            ArrayList arrayList4 = (ArrayList) CollectionsKt___CollectionsKt.X0oX(this.mCacheList, new ArrayList());
            getMList().clear();
            getMList().addAll(arrayList4);
            getMListAdapter().notifyDataSetChanged();
            getMListView().postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.device.X0O0I0
                @Override // java.lang.Runnable
                public final void run() {
                    NotificationSettingsActivity.textChanged$lambda$4(NotificationSettingsActivity.this);
                }
            }, 1000L);
            return;
        }
        if (!this.mDefaultList.isEmpty()) {
            List<x0XOIxOo> list2 = this.mDefaultList;
            ArrayList arrayList5 = new ArrayList();
            for (Object obj : list2) {
                String II0xO02 = ((x0XOIxOo) obj).II0xO0();
                if (II0xO02 != null && StringsKt__StringsKt.o00xOoIO(II0xO02, String.valueOf(editable), false, 2, null)) {
                    arrayList5.add(obj);
                }
            }
            this.mDefaultList.clear();
            this.mDefaultList.addAll(arrayList5);
            getMCommonAdapter().notifyDataSetChanged();
        }
        if (!getMList().isEmpty()) {
            List<x0XOIxOo> mList2 = getMList();
            ArrayList arrayList6 = new ArrayList();
            for (Object obj2 : mList2) {
                String II0xO03 = ((x0XOIxOo) obj2).II0xO0();
                if (II0xO03 != null && StringsKt__StringsKt.o00xOoIO(II0xO03, String.valueOf(editable), false, 2, null)) {
                    arrayList6.add(obj2);
                }
            }
            getMList().clear();
            getMList().addAll(arrayList6);
            getMListAdapter().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void textChanged$lambda$4(NotificationSettingsActivity this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.disLoadingPopup();
    }

    private final void updateOthers(final boolean z) {
        new Handler().post(new Runnable() { // from class: com.sma.smartv3.ui.device.OxO
            @Override // java.lang.Runnable
            public final void run() {
                NotificationSettingsActivity.updateOthers$lambda$11(NotificationSettingsActivity.this, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateOthers$lambda$11(NotificationSettingsActivity this$0, boolean z) {
        int i;
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        View otherPanel = this$0.getOtherPanel();
        if (z) {
            i = 8;
        } else {
            i = 0;
        }
        otherPanel.setVisibility(i);
    }

    public final void disLoadingPopup() {
        com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo = this.mLoadingPopup;
        if (i0X0x0oIo != null) {
            i0X0x0oIo.dismiss();
        }
    }

    @OXOo.OOXIXo
    public final List<x0XOIxOo> getMCacheDefaultList() {
        return this.mCacheDefaultList;
    }

    @OXOo.OOXIXo
    public final List<x0XOIxOo> getMCacheList() {
        return this.mCacheList;
    }

    @OXOo.OOXIXo
    public final XIOOI.oIX0oI<x0XOIxOo> getMCommonAdapter() {
        XIOOI.oIX0oI<x0XOIxOo> oix0oi = this.mCommonAdapter;
        if (oix0oi != null) {
            return oix0oi;
        }
        kotlin.jvm.internal.IIX0o.XOxIOxOx("mCommonAdapter");
        return null;
    }

    @OXOo.OOXIXo
    public final List<x0XOIxOo> getMDefaultList() {
        return this.mDefaultList;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.list.II0xO0
    @OXOo.OOXIXo
    public List<x0XOIxOo> initList() {
        return new ArrayList();
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x00a5, code lost:
    
        if (com.blankj.utilcode.util.PermissionUtils.isGranted((java.lang.String[]) java.util.Arrays.copyOf(r5, r5.length)) != false) goto L21;
     */
    @Override // com.bestmafen.androidbase.list.BaseListActivity, com.bestmafen.androidbase.base.oIX0oI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void initView() {
        /*
            r8 = this;
            super.initView()
            r0 = 2131361824(0x7f0a0020, float:1.8343411E38)
            android.view.View r0 = r8.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 2132019588(0x7f140984, float:1.9677515E38)
            r0.setText(r1)
            android.widget.ImageView r0 = r8.getAbhTitleRight()
            r1 = 2131236805(0x7f0817c5, float:1.8089843E38)
            r0.setImageResource(r1)
            android.widget.ImageView r0 = r8.getAbhTitleRight()
            r1 = 0
            r0.setVisibility(r1)
            com.sma.smartv3.ble.ProductManager r0 = com.sma.smartv3.ble.ProductManager.f20544oIX0oI
            boolean r0 = r0.IoIOOxIIo()
            r2 = 1
            java.lang.String r3 = "notification_call"
            r4 = 8
            if (r0 == 0) goto L60
            android.view.View r0 = r8.getLl()
            r0.setVisibility(r1)
            com.sma.smartv3.util.Xo0 r0 = com.sma.smartv3.util.Xo0.f24349oIX0oI
            com.blankj.utilcode.util.SPUtils r0 = r0.I0Io()
            boolean r0 = r0.getBoolean(r3, r1)
            android.widget.CheckBox r3 = r8.getCheckCall()
            if (r0 == 0) goto L5b
            java.lang.String[] r0 = com.sma.smartv3.ui.device.X00xOoXI.oIX0oI()
            int r5 = r0.length
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r0, r5)
            java.lang.String[] r0 = (java.lang.String[]) r0
            boolean r0 = com.blankj.utilcode.util.PermissionUtils.isGranted(r0)
            if (r0 == 0) goto L5b
            r0 = 1
            goto L5c
        L5b:
            r0 = 0
        L5c:
            r3.setChecked(r0)
            goto L75
        L60:
            android.view.View r0 = r8.getLl()
            r0.setVisibility(r4)
            com.sma.smartv3.util.Xo0 r0 = com.sma.smartv3.util.Xo0.f24349oIX0oI
            com.blankj.utilcode.util.SPUtils r0 = r0.I0Io()
            r0.put(r3, r1)
            com.sma.smartv3.initializer.BleInitializer r0 = com.sma.smartv3.initializer.BleInitializer.f20700XO
            r0.Ox0O()
        L75:
            com.sma.smartv3.app.ProjectManager r0 = com.sma.smartv3.app.ProjectManager.f19822oIX0oI
            boolean r3 = r0.xoIxX()
            if (r3 == 0) goto L84
            android.view.View r3 = r8.getLl()
            r3.setVisibility(r4)
        L84:
            com.sma.smartv3.util.Xo0 r3 = com.sma.smartv3.util.Xo0.f24349oIX0oI
            com.blankj.utilcode.util.SPUtils r5 = r3.I0Io()
            java.lang.String r6 = "notification_sms"
            boolean r5 = r5.getBoolean(r6, r1)
            android.widget.CheckBox r6 = r8.getCheckSms()
            if (r5 == 0) goto La8
            java.lang.String[] r5 = com.sma.smartv3.ui.device.X00xOoXI.II0xO0()
            int r7 = r5.length
            java.lang.Object[] r5 = java.util.Arrays.copyOf(r5, r7)
            java.lang.String[] r5 = (java.lang.String[]) r5
            boolean r5 = com.blankj.utilcode.util.PermissionUtils.isGranted(r5)
            if (r5 == 0) goto La8
            goto La9
        La8:
            r2 = 0
        La9:
            r6.setChecked(r2)
            com.blankj.utilcode.util.SPUtils r2 = r3.I0Io()
            java.lang.String r3 = "notification_mirror_phone"
            boolean r1 = r2.getBoolean(r3, r1)
            android.widget.CheckBox r2 = r8.getCheckMirrorPhone()
            r2.setChecked(r1)
            r8.updateOthers(r1)
            android.widget.CheckBox r1 = r8.getCheckCall()
            r1.setOnCheckedChangeListener(r8)
            android.widget.CheckBox r1 = r8.getCheckSms()
            r1.setOnCheckedChangeListener(r8)
            android.widget.CheckBox r1 = r8.getCheckMirrorPhone()
            r1.setOnCheckedChangeListener(r8)
            android.widget.ListView r1 = r8.getMListView()
            r2 = 2131364148(0x7f0a0934, float:1.8348125E38)
            android.view.View r2 = r8.findViewById(r2)
            r1.setEmptyView(r2)
            r8.showDefaultList()
            r8.showOthersList()
            android.widget.EditText r1 = r8.getSearchEditText()
            if (r1 == 0) goto L101
            android.app.Activity r2 = r8.getMContext()
            r3 = 2131101780(0x7f060854, float:1.781598E38)
            int r2 = oIxOXo.oxoX.I0Io(r2, r3)
            android.content.res.ColorStateList r2 = android.content.res.ColorStateList.valueOf(r2)
            r1.setBackgroundTintList(r2)
        L101:
            boolean r0 = r0.IO0XoXxO()
            if (r0 == 0) goto L10e
            android.widget.EditText r0 = r8.getSearchEditText()
            r0.setVisibility(r4)
        L10e:
            android.widget.EditText r0 = r8.getSearchEditText()
            java.lang.String r1 = "<get-searchEditText>(...)"
            kotlin.jvm.internal.IIX0o.oO(r0, r1)
            com.sma.smartv3.ui.device.NotificationSettingsActivity$oIX0oI r1 = new com.sma.smartv3.ui.device.NotificationSettingsActivity$oIX0oI
            r1.<init>()
            r0.addTextChangedListener(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.device.NotificationSettingsActivity.initView():void");
    }

    @Override // com.bestmafen.androidbase.list.II0xO0
    public int itemLayoutId() {
        return R.layout.item_notification_others;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_notification_settings;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(@OXOo.OOXIXo final CompoundButton buttonView, final boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(buttonView, "buttonView");
        int id = buttonView.getId();
        if (id != R.id.check_call) {
            if (id != R.id.check_mirror_phone) {
                if (id == R.id.check_sms) {
                    if (z) {
                        PermissionUtils permission = PermissionUtils.permission(PermissionConstants.SMS);
                        kotlin.jvm.internal.IIX0o.oO(permission, "permission(...)");
                        oOXoIIIo.X0o0xo.I0Io(permission, null, null, new Oox.oOoXoXO<PermissionStatus, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.NotificationSettingsActivity$onCheckedChanged$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // Oox.oOoXoXO
                            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(PermissionStatus permissionStatus) {
                                invoke2(permissionStatus);
                                return kotlin.oXIO0o0XI.f29392oIX0oI;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@OXOo.OOXIXo PermissionStatus it) {
                                kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                                if (it == PermissionStatus.GRANTED) {
                                    com.sma.smartv3.util.Xo0.f24349oIX0oI.I0Io().put(com.sma.smartv3.util.XoI0Ixx0.f24352I0Io, z);
                                    BleInitializer.f20700XO.xOOOX();
                                } else {
                                    this.permissionRemind();
                                    buttonView.setChecked(!z);
                                }
                            }
                        }, 3, null);
                        return;
                    }
                    com.sma.smartv3.util.Xo0.f24349oIX0oI.I0Io().put(com.sma.smartv3.util.XoI0Ixx0.f24352I0Io, z);
                    return;
                }
                return;
            }
            com.sma.smartv3.util.Xo0.f24349oIX0oI.I0Io().put(com.sma.smartv3.util.XoI0Ixx0.f24466oxoX, z);
            updateOthers(z);
            return;
        }
        if (z) {
            PermissionUtils permission2 = PermissionUtils.permission(PermissionConstants.PHONE, PermissionConstants.CONTACTS);
            kotlin.jvm.internal.IIX0o.oO(permission2, "permission(...)");
            oOXoIIIo.X0o0xo.I0Io(permission2, null, null, new Oox.oOoXoXO<PermissionStatus, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.NotificationSettingsActivity$onCheckedChanged$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(PermissionStatus permissionStatus) {
                    invoke2(permissionStatus);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo PermissionStatus it) {
                    Activity mContext;
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    if (it == PermissionStatus.GRANTED) {
                        com.sma.smartv3.util.Xo0.f24349oIX0oI.I0Io().put(com.sma.smartv3.util.XoI0Ixx0.f24358II0xO0, z);
                        BleInitializer bleInitializer = BleInitializer.f20700XO;
                        bleInitializer.Ox0O();
                        mContext = this.getMContext();
                        bleInitializer.XIXIxO(mContext);
                        return;
                    }
                    this.permissionRemind();
                    buttonView.setChecked(!z);
                }
            }, 3, null);
        } else {
            com.sma.smartv3.util.Xo0.f24349oIX0oI.I0Io().put(com.sma.smartv3.util.XoI0Ixx0.f24358II0xO0, z);
            BleInitializer.f20700XO.Ox0O();
        }
    }

    @Override // com.bestmafen.androidbase.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        disLoadingPopup();
        super.onDestroy();
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        finish();
    }

    public final void onTitleRightClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        ProjectManager.f19822oIX0oI.oo0oIXo(getMContext());
    }

    public final void setMCacheDefaultList(@OXOo.OOXIXo List<x0XOIxOo> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<set-?>");
        this.mCacheDefaultList = list;
    }

    public final void setMCacheList(@OXOo.OOXIXo List<x0XOIxOo> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<set-?>");
        this.mCacheList = list;
    }

    public final void setMCommonAdapter(@OXOo.OOXIXo XIOOI.oIX0oI<x0XOIxOo> oix0oi) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(oix0oi, "<set-?>");
        this.mCommonAdapter = oix0oi;
    }

    public final void showLoadingPopup() {
        com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo;
        if (this.mLoadingPopup == null) {
            this.mLoadingPopup = new com.sma.smartv3.pop.I0X0x0oIo(this);
        }
        com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo2 = this.mLoadingPopup;
        if ((i0X0x0oIo2 == null || !i0X0x0oIo2.isShowing()) && (i0X0x0oIo = this.mLoadingPopup) != null) {
            i0X0x0oIo.IIXOooo();
        }
    }

    @Override // com.bestmafen.androidbase.list.I0Io
    public void initItem(@OXOo.OOXIXo XIOOI.I0Io holder, @OXOo.OOXIXo x0XOIxOo item, final int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(holder, "holder");
        kotlin.jvm.internal.IIX0o.x0xO0oo(item, "item");
        holder.oOoXoXO(R.id.iv_icon, getMList().get(i).oIX0oI());
        holder.o00(R.id.tv_name, getMList().get(i).II0xO0());
        getMList().get(i).X0o0xo(com.sma.smartv3.util.Xo0.f24349oIX0oI.I0Io().getBoolean(com.sma.smartv3.util.XoI0Ixx0.f24443oIX0oI + getMList().get(i).I0Io(), false));
        holder.xoIox(R.id.check_enabled, getMList().get(i).oxoX());
        oOXoIIIo.Oxx0IOOO.oIX0oI(holder, R.id.check_enabled, new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.o0oxo0oI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NotificationSettingsActivity.initItem$lambda$10$lambda$9(NotificationSettingsActivity.this, i, view);
            }
        });
    }
}
