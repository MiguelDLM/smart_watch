package com.sma.smartv3.ui.device;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.bestmafen.androidbase.adapter.recyclerview.MultiItemTypeAdapter;
import com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder;
import com.bestmafen.androidbase.base.BaseActivity;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.google.gson.Gson;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.biz.MusicServerManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.TeraBoxListItem;
import com.sma.smartv3.ui.me.WebViewActivity;
import com.sma.smartv3.util.TextConvertKt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@kotlin.jvm.internal.XX({"SMAP\nTeraBoxFileManagerActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TeraBoxFileManagerActivity.kt\ncom/sma/smartv3/ui/device/TeraBoxFileManagerActivity\n+ 2 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,447:1\n87#2,7:448\n94#2,3:456\n70#2,7:459\n97#2:466\n1#3:455\n35#4,2:467\n*S KotlinDebug\n*F\n+ 1 TeraBoxFileManagerActivity.kt\ncom/sma/smartv3/ui/device/TeraBoxFileManagerActivity\n*L\n123#1:448,7\n123#1:456,3\n123#1:459,7\n123#1:466\n123#1:455\n323#1:467,2\n*E\n"})
/* loaded from: classes12.dex */
public final class TeraBoxFileManagerActivity extends BaseActivity {

    @OXOo.OOXIXo
    public static final oIX0oI Companion = new oIX0oI(null);
    public static final int FILE_DIR = 1;
    public static final int FILE_MUSIC = 0;
    private boolean hasLogin;
    private boolean hasNewIntent;
    private MultiItemTypeAdapter<TeraBoxListItem> mAdapter;
    private boolean mTouches;
    private int onResumeSum;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.I0X0x0oIo progressPopup;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.XoI0Ixx0 unLoginPopup;

    @OXOo.OOXIXo
    private String access_tokens = "";

    @OXOo.OOXIXo
    private final kotlin.X0IIOO rootView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.device.TeraBoxFileManagerActivity$rootView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return TeraBoxFileManagerActivity.this.findViewById(R.id.rootView);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mTitle$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.device.TeraBoxFileManagerActivity$mTitle$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) TeraBoxFileManagerActivity.this.findViewById(R.id.abh_title_center);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO abhTitleRight$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.device.TeraBoxFileManagerActivity$abhTitleRight$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) TeraBoxFileManagerActivity.this.findViewById(R.id.abh_title_right);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mEditText$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<EditText>() { // from class: com.sma.smartv3.ui.device.TeraBoxFileManagerActivity$mEditText$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final EditText invoke() {
            return (EditText) TeraBoxFileManagerActivity.this.findViewById(R.id.tera_box_file_et);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mClearImageView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.device.TeraBoxFileManagerActivity$mClearImageView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) TeraBoxFileManagerActivity.this.findViewById(R.id.tera_box_file_et_clear);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mSearchImageView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.device.TeraBoxFileManagerActivity$mSearchImageView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) TeraBoxFileManagerActivity.this.findViewById(R.id.tera_box_file_search);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mSwipeRefreshLayout$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<SwipeRefreshLayout>() { // from class: com.sma.smartv3.ui.device.TeraBoxFileManagerActivity$mSwipeRefreshLayout$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final SwipeRefreshLayout invoke() {
            return (SwipeRefreshLayout) TeraBoxFileManagerActivity.this.findViewById(R.id.tera_box_file_srf);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mRecyclerView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RecyclerView>() { // from class: com.sma.smartv3.ui.device.TeraBoxFileManagerActivity$mRecyclerView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RecyclerView invoke() {
            return (RecyclerView) TeraBoxFileManagerActivity.this.findViewById(R.id.tera_box_file_recycler);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mEmptyView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.device.TeraBoxFileManagerActivity$mEmptyView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return TeraBoxFileManagerActivity.this.findViewById(R.id.empty_view);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mShareView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.device.TeraBoxFileManagerActivity$mShareView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return TeraBoxFileManagerActivity.this.findViewById(R.id.tera_box_share_layout);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mButton$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<Button>() { // from class: com.sma.smartv3.ui.device.TeraBoxFileManagerActivity$mButton$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final Button invoke() {
            return (Button) TeraBoxFileManagerActivity.this.findViewById(R.id.btn_bottom);
        }
    });

    @OXOo.OOXIXo
    private final HashMap<String, List<TeraBoxListItem>> mMapData = new HashMap<>();

    @OXOo.OOXIXo
    private final HashMap<String, String> mMapTitle = new HashMap<>();

    @OXOo.OOXIXo
    private final ArrayList<String> mKeyIndex = new ArrayList<>();

    @OXOo.OOXIXo
    private final ArrayList<TeraBoxListItem> mCheckedListID = new ArrayList<>();

    @OXOo.OOXIXo
    private String mCurDir = "/";
    private int page = 1;

    /* loaded from: classes12.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        public oIX0oI() {
        }
    }

    private final void analyzeURL(Uri uri) {
        String str;
        LogUtils.d("handleIntent  -->  uri = " + uri);
        if (uri != null) {
            str = uri.getQueryParameter("code");
        } else {
            str = null;
        }
        if (str != null && str.length() > 0) {
            this.hasNewIntent = true;
            showLoadPopup();
            MusicServerManager.f20080oIX0oI.IXxxXO(str, new Oox.oOoXoXO<String, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.TeraBoxFileManagerActivity$analyzeURL$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(String str2) {
                    invoke2(str2);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.oOoXoXO String str2) {
                    ImageView abhTitleRight;
                    if (str2 != null && str2.length() > 0) {
                        TeraBoxFileManagerActivity.this.setAccess_tokens(str2);
                        TeraBoxFileManagerActivity.this.mCurDir = "/";
                        TeraBoxFileManagerActivity.this.getTeraBoxList();
                        TeraBoxFileManagerActivity.this.getTeraShareUrl();
                        abhTitleRight = TeraBoxFileManagerActivity.this.getAbhTitleRight();
                        abhTitleRight.setVisibility(0);
                    } else {
                        LogUtils.d("handleIntent login error it = " + str2);
                        ToastUtils.showLong("handleIntent login error it = " + str2, new Object[0]);
                    }
                    TeraBoxFileManagerActivity.this.dismissLoadPopup();
                }
            });
            return;
        }
        ToastUtils.showLong("handleIntent login error", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageView getAbhTitleRight() {
        return (ImageView) this.abhTitleRight$delegate.getValue();
    }

    private final Button getMButton() {
        return (Button) this.mButton$delegate.getValue();
    }

    private final ImageView getMClearImageView() {
        return (ImageView) this.mClearImageView$delegate.getValue();
    }

    private final EditText getMEditText() {
        return (EditText) this.mEditText$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View getMEmptyView() {
        return (View) this.mEmptyView$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RecyclerView getMRecyclerView() {
        return (RecyclerView) this.mRecyclerView$delegate.getValue();
    }

    private final ImageView getMSearchImageView() {
        return (ImageView) this.mSearchImageView$delegate.getValue();
    }

    private final View getMShareView() {
        return (View) this.mShareView$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SwipeRefreshLayout getMSwipeRefreshLayout() {
        return (SwipeRefreshLayout) this.mSwipeRefreshLayout$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView getMTitle() {
        return (TextView) this.mTitle$delegate.getValue();
    }

    private final View getRootView() {
        return (View) this.rootView$delegate.getValue();
    }

    private final void handleIntent(Intent intent) {
        analyzeURL(intent.getData());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(TeraBoxFileManagerActivity this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.getMEditText().getText().clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(TeraBoxFileManagerActivity this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        if (this$0.mTouches) {
            return;
        }
        this$0.mTouches = true;
        this$0.showLoadPopup();
        String obj = this$0.getMEditText().getText().toString();
        this$0.mCurDir = this$0.getString(R.string.search) + ':' + obj;
        this$0.getMTitle().setText(this$0.getString(R.string.search) + ':' + obj);
        this$0.getTeraBoxSearchFile(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(TeraBoxFileManagerActivity this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.refreshData();
    }

    private final void refreshData() {
        getMSwipeRefreshLayout().setRefreshing(true);
        getTeraBoxList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showShareView$lambda$0(String url, TeraBoxFileManagerActivity this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(url, "$url");
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        if (!kotlin.text.OxI.IOOoXo0Ix(url, "http", false, 2, null)) {
            if (ProjectManager.f19822oIX0oI.xxxI()) {
                url = "https://terabox.com/s/1aDs3IL6xbpMQvsbHZ6l0vg";
            } else {
                url = "https://pan.baidu.com/s/1GatP9OXF9mmy2MTwtohHOw?pwd=k7y4";
            }
        }
        Intent intent = new Intent();
        intent.setData(Uri.parse(url));
        intent.setAction("android.intent.action.VIEW");
        this$0.startActivity(intent);
    }

    public final void dismissLoadPopup() {
        com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo = this.progressPopup;
        if (i0X0x0oIo != null) {
            i0X0x0oIo.dismiss();
        }
    }

    @OXOo.OOXIXo
    public final String getAccess_tokens() {
        return this.access_tokens;
    }

    @OXOo.oOoXoXO
    public final com.sma.smartv3.pop.I0X0x0oIo getProgressPopup() {
        return this.progressPopup;
    }

    public final void getTeraBoxCode() {
        if (ProjectManager.f19822oIX0oI.xxxI()) {
            Intent intent = new Intent();
            intent.setData(Uri.parse(MusicServerManager.f20080oIX0oI.XO(this)));
            intent.setAction("android.intent.action.VIEW");
            startActivity(intent);
            return;
        }
        String XO2 = MusicServerManager.f20080oIX0oI.XO(this);
        Bundle bundle = new Bundle();
        bundle.putString("mArg0", XO2);
        bundle.putInt("mArg1", 2);
        bundle.putParcelable("mArg2", null);
        bundle.putSerializable("mArg3", null);
        Intent intent2 = new Intent(this, (Class<?>) WebViewActivity.class);
        intent2.putExtras(bundle);
        startActivity(intent2);
    }

    public final void getTeraBoxList() {
        if (this.mTouches) {
            return;
        }
        this.mTouches = true;
        showLoadPopup();
        MusicServerManager.x0xO0oo(MusicServerManager.f20080oIX0oI, this.access_tokens, this.mCurDir, this.page, 0, new Oox.oOoXoXO<List<? extends TeraBoxListItem>, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.TeraBoxFileManagerActivity$getTeraBoxList$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(List<? extends TeraBoxListItem> list) {
                invoke2((List<TeraBoxListItem>) list);
                return kotlin.oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.oOoXoXO List<TeraBoxListItem> list) {
                RecyclerView mRecyclerView;
                View mEmptyView;
                SwipeRefreshLayout mSwipeRefreshLayout;
                int i;
                HashMap hashMap;
                String str;
                ArrayList arrayList;
                String str2;
                ArrayList arrayList2;
                String str3;
                TeraBoxFileManagerActivity.this.mTouches = false;
                if (list != null) {
                    i = TeraBoxFileManagerActivity.this.page;
                    if (i == 1) {
                        hashMap = TeraBoxFileManagerActivity.this.mMapData;
                        str = TeraBoxFileManagerActivity.this.mCurDir;
                        hashMap.put(str, list);
                        arrayList = TeraBoxFileManagerActivity.this.mKeyIndex;
                        str2 = TeraBoxFileManagerActivity.this.mCurDir;
                        if (!arrayList.contains(str2)) {
                            arrayList2 = TeraBoxFileManagerActivity.this.mKeyIndex;
                            str3 = TeraBoxFileManagerActivity.this.mCurDir;
                            arrayList2.add(str3);
                        }
                    }
                    TeraBoxFileManagerActivity.this.initData(list);
                } else {
                    mRecyclerView = TeraBoxFileManagerActivity.this.getMRecyclerView();
                    mRecyclerView.setVisibility(8);
                    mEmptyView = TeraBoxFileManagerActivity.this.getMEmptyView();
                    mEmptyView.setVisibility(0);
                }
                mSwipeRefreshLayout = TeraBoxFileManagerActivity.this.getMSwipeRefreshLayout();
                mSwipeRefreshLayout.setRefreshing(false);
                TeraBoxFileManagerActivity.this.dismissLoadPopup();
            }
        }, 8, null);
    }

    public final void getTeraBoxSearchFile(@OXOo.OOXIXo final String text) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(text, "text");
        MusicServerManager.f20080oIX0oI.ooOOo0oXI(this.access_tokens, text, new Oox.oOoXoXO<List<? extends TeraBoxListItem>, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.TeraBoxFileManagerActivity$getTeraBoxSearchFile$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(List<? extends TeraBoxListItem> list) {
                invoke2((List<TeraBoxListItem>) list);
                return kotlin.oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.oOoXoXO List<TeraBoxListItem> list) {
                HashMap hashMap;
                String str;
                HashMap hashMap2;
                String str2;
                ArrayList arrayList;
                String str3;
                TeraBoxFileManagerActivity.this.mTouches = false;
                if (list != null) {
                    hashMap = TeraBoxFileManagerActivity.this.mMapData;
                    str = TeraBoxFileManagerActivity.this.mCurDir;
                    hashMap.put(str, list);
                    hashMap2 = TeraBoxFileManagerActivity.this.mMapTitle;
                    str2 = TeraBoxFileManagerActivity.this.mCurDir;
                    hashMap2.put(str2, TeraBoxFileManagerActivity.this.getString(R.string.search) + ':' + text);
                    arrayList = TeraBoxFileManagerActivity.this.mKeyIndex;
                    str3 = TeraBoxFileManagerActivity.this.mCurDir;
                    arrayList.add(str3);
                    TeraBoxFileManagerActivity.this.initData(list);
                }
                TeraBoxFileManagerActivity.this.dismissLoadPopup();
            }
        });
    }

    public final void getTeraShareUrl() {
        MusicServerManager.f20080oIX0oI.OOXIXo(new Oox.oOoXoXO<String, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.TeraBoxFileManagerActivity$getTeraShareUrl$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(String str) {
                invoke2(str);
                return kotlin.oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo String it) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                if (it.length() > 0) {
                    TeraBoxFileManagerActivity.this.showShareView(it);
                }
            }
        });
    }

    @OXOo.oOoXoXO
    public final com.sma.smartv3.pop.XoI0Ixx0 getUnLoginPopup() {
        return this.unLoginPopup;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
        String string = com.sma.smartv3.util.Xo0.f24349oIX0oI.XO().getString(com.sma.smartv3.util.XoI0Ixx0.f24397OoO);
        kotlin.jvm.internal.IIX0o.oO(string, "getString(...)");
        this.access_tokens = string;
        if (string.length() == 0) {
            this.onResumeSum = 0;
            this.hasLogin = true;
            getTeraBoxCode();
        } else {
            this.mCurDir = "/";
            getTeraBoxList();
            getTeraShareUrl();
        }
    }

    public final void initData(@OXOo.oOoXoXO final List<TeraBoxListItem> list) {
        if (list != null && list.size() > 0) {
            dismissLoadPopup();
            this.mAdapter = new MultiItemTypeAdapter<TeraBoxListItem>(this, list) { // from class: com.sma.smartv3.ui.device.TeraBoxFileManagerActivity$initData$1

                /* loaded from: classes12.dex */
                public static final class II0xO0 implements oo.xoXoI<TeraBoxListItem> {

                    /* renamed from: oIX0oI, reason: collision with root package name */
                    public final /* synthetic */ TeraBoxFileManagerActivity f22046oIX0oI;

                    public II0xO0(TeraBoxFileManagerActivity teraBoxFileManagerActivity) {
                        this.f22046oIX0oI = teraBoxFileManagerActivity;
                    }

                    public static final void XO(TeraBoxFileManagerActivity this$0, TeraBoxListItem mTeraBoxListItem, ImageView imageView, View view) {
                        ArrayList arrayList;
                        ArrayList arrayList2;
                        ArrayList arrayList3;
                        ArrayList arrayList4;
                        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
                        kotlin.jvm.internal.IIX0o.x0xO0oo(mTeraBoxListItem, "$mTeraBoxListItem");
                        arrayList = this$0.mCheckedListID;
                        if (arrayList.contains(mTeraBoxListItem)) {
                            arrayList4 = this$0.mCheckedListID;
                            arrayList4.remove(mTeraBoxListItem);
                            imageView.setImageResource(R.drawable.file_uncheck_icon);
                        } else {
                            arrayList2 = this$0.mCheckedListID;
                            if (arrayList2.size() < 20) {
                                arrayList3 = this$0.mCheckedListID;
                                arrayList3.add(mTeraBoxListItem);
                                imageView.setImageResource(R.drawable.file_check_icon);
                            } else {
                                imageView.setImageResource(R.drawable.file_uncheck_icon);
                                ToastUtils.showLong(R.string.too_manyfile_tip);
                            }
                        }
                        this$0.setButtonText();
                    }

                    @Override // oo.xoXoI
                    public int II0xO0() {
                        return R.layout.item_tera_box_music_file;
                    }

                    @Override // oo.xoXoI
                    /* renamed from: Oxx0IOOO, reason: merged with bridge method [inline-methods] */
                    public boolean oIX0oI(@OXOo.oOoXoXO TeraBoxListItem teraBoxListItem, int i) {
                        if (teraBoxListItem == null || teraBoxListItem.getIsdir() != 0) {
                            return false;
                        }
                        return true;
                    }

                    @Override // oo.xoXoI
                    /* renamed from: X0o0xo, reason: merged with bridge method [inline-methods] */
                    public void I0Io(@OXOo.OOXIXo ViewHolder holder, @OXOo.OOXIXo final TeraBoxListItem mTeraBoxListItem, int i) {
                        ArrayList arrayList;
                        int i2;
                        kotlin.jvm.internal.IIX0o.x0xO0oo(holder, "holder");
                        kotlin.jvm.internal.IIX0o.x0xO0oo(mTeraBoxListItem, "mTeraBoxListItem");
                        TextView textView = (TextView) holder.getView(R.id.item_tera_box_title);
                        TextView textView2 = (TextView) holder.getView(R.id.item_tera_box_tip);
                        final ImageView imageView = (ImageView) holder.getView(R.id.item_check_music);
                        textView.setText(mTeraBoxListItem.getServer_filename());
                        textView2.setText(com.sma.smartv3.util.xoIox.x0xO().format(Long.valueOf(mTeraBoxListItem.getLocal_mtime())) + TokenParser.SP + TextConvertKt.oOXoIIIo((mTeraBoxListItem.getSize() / 1024.0f) / 1024.0f, false, 2, null) + "MB");
                        arrayList = this.f22046oIX0oI.mCheckedListID;
                        if (arrayList.contains(mTeraBoxListItem)) {
                            i2 = R.drawable.file_check_icon;
                        } else {
                            i2 = R.drawable.file_uncheck_icon;
                        }
                        imageView.setImageResource(i2);
                        View view = holder.itemView;
                        final TeraBoxFileManagerActivity teraBoxFileManagerActivity = this.f22046oIX0oI;
                        view.setOnClickListener(
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0087: INVOKE 
                              (r7v1 'view' android.view.View)
                              (wrap:android.view.View$OnClickListener:0x0084: CONSTRUCTOR 
                              (r9v13 'teraBoxFileManagerActivity' com.sma.smartv3.ui.device.TeraBoxFileManagerActivity A[DONT_INLINE])
                              (r8v0 'mTeraBoxListItem' com.sma.smartv3.model.TeraBoxListItem A[DONT_INLINE])
                              (r1v2 'imageView' android.widget.ImageView A[DONT_INLINE])
                             A[MD:(com.sma.smartv3.ui.device.TeraBoxFileManagerActivity, com.sma.smartv3.model.TeraBoxListItem, android.widget.ImageView):void (m), WRAPPED] (LINE:133) call: com.sma.smartv3.ui.device.OXooXo.<init>(com.sma.smartv3.ui.device.TeraBoxFileManagerActivity, com.sma.smartv3.model.TeraBoxListItem, android.widget.ImageView):void type: CONSTRUCTOR)
                             VIRTUAL call: android.view.View.setOnClickListener(android.view.View$OnClickListener):void A[MD:(android.view.View$OnClickListener):void (c)] (LINE:136) in method: com.sma.smartv3.ui.device.TeraBoxFileManagerActivity$initData$1.II0xO0.X0o0xo(com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder, com.sma.smartv3.model.TeraBoxListItem, int):void, file: classes12.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
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
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.sma.smartv3.ui.device.OXooXo, state: NOT_LOADED
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
                            	... 15 more
                            */
                        /*
                            this = this;
                            java.lang.String r9 = "holder"
                            kotlin.jvm.internal.IIX0o.x0xO0oo(r7, r9)
                            java.lang.String r9 = "mTeraBoxListItem"
                            kotlin.jvm.internal.IIX0o.x0xO0oo(r8, r9)
                            r9 = 2131364928(0x7f0a0c40, float:1.8349707E38)
                            android.view.View r9 = r7.getView(r9)
                            android.widget.TextView r9 = (android.widget.TextView) r9
                            r0 = 2131364927(0x7f0a0c3f, float:1.8349705E38)
                            android.view.View r0 = r7.getView(r0)
                            android.widget.TextView r0 = (android.widget.TextView) r0
                            r1 = 2131364811(0x7f0a0bcb, float:1.834947E38)
                            android.view.View r1 = r7.getView(r1)
                            android.widget.ImageView r1 = (android.widget.ImageView) r1
                            java.lang.String r2 = r8.getServer_filename()
                            r9.setText(r2)
                            java.lang.StringBuilder r9 = new java.lang.StringBuilder
                            r9.<init>()
                            java.text.SimpleDateFormat r2 = com.sma.smartv3.util.xoIox.x0xO()
                            long r3 = r8.getLocal_mtime()
                            java.lang.Long r3 = java.lang.Long.valueOf(r3)
                            java.lang.String r2 = r2.format(r3)
                            r9.append(r2)
                            r2 = 32
                            r9.append(r2)
                            int r2 = r8.getSize()
                            float r2 = (float) r2
                            r3 = 1149239296(0x44800000, float:1024.0)
                            float r2 = r2 / r3
                            float r2 = r2 / r3
                            r3 = 2
                            r4 = 0
                            r5 = 0
                            java.lang.String r2 = com.sma.smartv3.util.TextConvertKt.oOXoIIIo(r2, r5, r3, r4)
                            r9.append(r2)
                            java.lang.String r2 = "MB"
                            r9.append(r2)
                            java.lang.String r9 = r9.toString()
                            r0.setText(r9)
                            com.sma.smartv3.ui.device.TeraBoxFileManagerActivity r9 = r6.f22046oIX0oI
                            java.util.ArrayList r9 = com.sma.smartv3.ui.device.TeraBoxFileManagerActivity.access$getMCheckedListID$p(r9)
                            boolean r9 = r9.contains(r8)
                            if (r9 == 0) goto L78
                            r9 = 2131233517(0x7f080aed, float:1.8083174E38)
                            goto L7b
                        L78:
                            r9 = 2131233518(0x7f080aee, float:1.8083176E38)
                        L7b:
                            r1.setImageResource(r9)
                            android.view.View r7 = r7.itemView
                            com.sma.smartv3.ui.device.TeraBoxFileManagerActivity r9 = r6.f22046oIX0oI
                            com.sma.smartv3.ui.device.OXooXo r0 = new com.sma.smartv3.ui.device.OXooXo
                            r0.<init>(r9, r8, r1)
                            r7.setOnClickListener(r0)
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.device.TeraBoxFileManagerActivity$initData$1.II0xO0.I0Io(com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder, com.sma.smartv3.model.TeraBoxListItem, int):void");
                    }
                }

                /* loaded from: classes12.dex */
                public static final class oIX0oI implements oo.xoXoI<TeraBoxListItem> {

                    /* renamed from: oIX0oI, reason: collision with root package name */
                    public final /* synthetic */ TeraBoxFileManagerActivity f22047oIX0oI;

                    public oIX0oI(TeraBoxFileManagerActivity teraBoxFileManagerActivity) {
                        this.f22047oIX0oI = teraBoxFileManagerActivity;
                    }

                    public static final void XO(TeraBoxFileManagerActivity this$0, TeraBoxListItem mTeraBoxListItem, View view) {
                        HashMap hashMap;
                        String str;
                        TextView mTitle;
                        HashMap hashMap2;
                        String str2;
                        ArrayList arrayList;
                        String str3;
                        HashMap hashMap3;
                        String str4;
                        ArrayList arrayList2;
                        String str5;
                        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
                        kotlin.jvm.internal.IIX0o.x0xO0oo(mTeraBoxListItem, "$mTeraBoxListItem");
                        this$0.mCurDir = mTeraBoxListItem.getPath();
                        hashMap = this$0.mMapTitle;
                        str = this$0.mCurDir;
                        hashMap.put(str, mTeraBoxListItem.getServer_filename());
                        mTitle = this$0.getMTitle();
                        mTitle.setText(mTeraBoxListItem.getServer_filename());
                        hashMap2 = this$0.mMapData;
                        str2 = this$0.mCurDir;
                        if (hashMap2.containsKey(str2)) {
                            arrayList = this$0.mKeyIndex;
                            str3 = this$0.mCurDir;
                            if (!arrayList.contains(str3)) {
                                arrayList2 = this$0.mKeyIndex;
                                str5 = this$0.mCurDir;
                                arrayList2.add(str5);
                            }
                            hashMap3 = this$0.mMapData;
                            str4 = this$0.mCurDir;
                            this$0.initData((List) hashMap3.get(str4));
                            return;
                        }
                        this$0.page = 1;
                        this$0.getTeraBoxList();
                    }

                    @Override // oo.xoXoI
                    public int II0xO0() {
                        return R.layout.item_tera_box_dir;
                    }

                    @Override // oo.xoXoI
                    /* renamed from: Oxx0IOOO, reason: merged with bridge method [inline-methods] */
                    public boolean oIX0oI(@OXOo.oOoXoXO TeraBoxListItem teraBoxListItem, int i) {
                        if (teraBoxListItem == null || teraBoxListItem.getIsdir() != 1) {
                            return false;
                        }
                        return true;
                    }

                    @Override // oo.xoXoI
                    /* renamed from: X0o0xo, reason: merged with bridge method [inline-methods] */
                    public void I0Io(@OXOo.OOXIXo ViewHolder holder, @OXOo.OOXIXo final TeraBoxListItem mTeraBoxListItem, int i) {
                        kotlin.jvm.internal.IIX0o.x0xO0oo(holder, "holder");
                        kotlin.jvm.internal.IIX0o.x0xO0oo(mTeraBoxListItem, "mTeraBoxListItem");
                        TextView textView = (TextView) holder.getView(R.id.item_tera_box_title);
                        TextView textView2 = (TextView) holder.getView(R.id.item_tera_box_tip);
                        textView.setText(mTeraBoxListItem.getServer_filename());
                        textView2.setText(com.sma.smartv3.util.xoIox.x0xO().format(Long.valueOf(mTeraBoxListItem.getLocal_mtime())));
                        View view = holder.itemView;
                        final TeraBoxFileManagerActivity teraBoxFileManagerActivity = this.f22047oIX0oI;
                        view.setOnClickListener(
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x003f: INVOKE 
                              (r4v1 'view' android.view.View)
                              (wrap:android.view.View$OnClickListener:0x003c: CONSTRUCTOR 
                              (r6v8 'teraBoxFileManagerActivity' com.sma.smartv3.ui.device.TeraBoxFileManagerActivity A[DONT_INLINE])
                              (r5v0 'mTeraBoxListItem' com.sma.smartv3.model.TeraBoxListItem A[DONT_INLINE])
                             A[MD:(com.sma.smartv3.ui.device.TeraBoxFileManagerActivity, com.sma.smartv3.model.TeraBoxListItem):void (m), WRAPPED] (LINE:61) call: com.sma.smartv3.ui.device.oXoXxOo.<init>(com.sma.smartv3.ui.device.TeraBoxFileManagerActivity, com.sma.smartv3.model.TeraBoxListItem):void type: CONSTRUCTOR)
                             VIRTUAL call: android.view.View.setOnClickListener(android.view.View$OnClickListener):void A[MD:(android.view.View$OnClickListener):void (c)] (LINE:64) in method: com.sma.smartv3.ui.device.TeraBoxFileManagerActivity$initData$1.oIX0oI.X0o0xo(com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder, com.sma.smartv3.model.TeraBoxListItem, int):void, file: classes12.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
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
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.sma.smartv3.ui.device.oXoXxOo, state: NOT_LOADED
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
                            	... 15 more
                            */
                        /*
                            this = this;
                            java.lang.String r6 = "holder"
                            kotlin.jvm.internal.IIX0o.x0xO0oo(r4, r6)
                            java.lang.String r6 = "mTeraBoxListItem"
                            kotlin.jvm.internal.IIX0o.x0xO0oo(r5, r6)
                            r6 = 2131364928(0x7f0a0c40, float:1.8349707E38)
                            android.view.View r6 = r4.getView(r6)
                            android.widget.TextView r6 = (android.widget.TextView) r6
                            r0 = 2131364927(0x7f0a0c3f, float:1.8349705E38)
                            android.view.View r0 = r4.getView(r0)
                            android.widget.TextView r0 = (android.widget.TextView) r0
                            java.lang.String r1 = r5.getServer_filename()
                            r6.setText(r1)
                            java.text.SimpleDateFormat r6 = com.sma.smartv3.util.xoIox.x0xO()
                            long r1 = r5.getLocal_mtime()
                            java.lang.Long r1 = java.lang.Long.valueOf(r1)
                            java.lang.String r6 = r6.format(r1)
                            r0.setText(r6)
                            android.view.View r4 = r4.itemView
                            com.sma.smartv3.ui.device.TeraBoxFileManagerActivity r6 = r3.f22047oIX0oI
                            com.sma.smartv3.ui.device.oXoXxOo r0 = new com.sma.smartv3.ui.device.oXoXxOo
                            r0.<init>(r6, r5)
                            r4.setOnClickListener(r0)
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.device.TeraBoxFileManagerActivity$initData$1.oIX0oI.I0Io(com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder, com.sma.smartv3.model.TeraBoxListItem, int):void");
                    }
                }

                {
                    addItemViewDelegate(1, new oIX0oI(this));
                    addItemViewDelegate(0, new II0xO0(this));
                }
            };
            getMRecyclerView().setVisibility(0);
            getMEmptyView().setVisibility(8);
            RecyclerView mRecyclerView = getMRecyclerView();
            MultiItemTypeAdapter<TeraBoxListItem> multiItemTypeAdapter = this.mAdapter;
            if (multiItemTypeAdapter == null) {
                kotlin.jvm.internal.IIX0o.XOxIOxOx("mAdapter");
                multiItemTypeAdapter = null;
            }
            mRecyclerView.setAdapter(multiItemTypeAdapter);
            return;
        }
        getMRecyclerView().setVisibility(8);
        getMEmptyView().setVisibility(0);
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        getMTitle().setText(R.string.tera_box_file_title);
        this.progressPopup = new com.sma.smartv3.pop.I0X0x0oIo(this);
        getMButton().setEnabled(false);
        HashMap<String, String> hashMap = this.mMapTitle;
        String str = this.mCurDir;
        String string = getString(R.string.tera_box_file_title);
        kotlin.jvm.internal.IIX0o.oO(string, "getString(...)");
        hashMap.put(str, string);
        getMRecyclerView().setLayoutManager(new LinearLayoutManager(this, 1, false));
        if (this.access_tokens.length() > 0) {
            getAbhTitleRight().setVisibility(0);
        }
        getAbhTitleRight().setImageResource(R.drawable.tera_box_clean_icon);
        getAbhTitleRight().setImageTintList(oIxOXo.oxoX.X0o0xo(this, R.color.text_color));
        getMClearImageView().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.o00xOoIO
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TeraBoxFileManagerActivity.initView$lambda$1(TeraBoxFileManagerActivity.this, view);
            }
        });
        getMSearchImageView().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.IxI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TeraBoxFileManagerActivity.initView$lambda$2(TeraBoxFileManagerActivity.this, view);
            }
        });
        String string2 = com.sma.smartv3.util.Xo0.f24349oIX0oI.XO().getString(com.sma.smartv3.util.XoI0Ixx0.f24427XXoOx0);
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(string2);
        if (string2.length() > 0) {
            showShareView(string2);
        }
        getMSwipeRefreshLayout().setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.sma.smartv3.ui.device.xIXOoI
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                TeraBoxFileManagerActivity.initView$lambda$3(TeraBoxFileManagerActivity.this);
            }
        });
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_tera_box_file_manager;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        String str = "/";
        if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.mCurDir, "/")) {
            super.onBackPressed();
            return;
        }
        int indexOf = this.mKeyIndex.indexOf(this.mCurDir);
        if (indexOf > 0) {
            this.mKeyIndex.remove(indexOf);
            String str2 = this.mKeyIndex.get(indexOf - 1);
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(str2);
            str = str2;
        }
        this.mCurDir = str;
        getMTitle().setText(this.mMapTitle.get(this.mCurDir));
        LogUtils.d("back mCurDir = " + this.mCurDir);
        initData(this.mMapData.get(this.mCurDir));
    }

    public final void onBottomClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        com.sma.smartv3.util.Xo0.f24349oIX0oI.XO().put(com.sma.smartv3.util.XoI0Ixx0.f24416XIXIxO, new Gson().toJson(this.mCheckedListID));
        com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.XoI0Ixx0.f24416XIXIxO, null, 2, null);
        finish();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(@OXOo.OOXIXo Intent intent) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(intent, "intent");
        super.onNewIntent(intent);
        setIntent(intent);
        handleIntent(intent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        int i = this.onResumeSum + 1;
        this.onResumeSum = i;
        if (this.hasLogin && !this.hasNewIntent && i > 1) {
            ToastUtils.showLong(getString(R.string.login_failed), new Object[0]);
            finish();
        }
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        onBackPressed();
    }

    public final void onTitleRightClick(@OXOo.OOXIXo View view) {
        com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0;
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx02 = new com.sma.smartv3.pop.XoI0Ixx0(getMContext(), 0, 2, null);
        xoI0Ixx02.IoOoX(R.string.logout_tip);
        xoI0Ixx02.X00IoxXI(Integer.valueOf(R.string.cancel), new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.device.TeraBoxFileManagerActivity$onTitleRightClick$1$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            @OXOo.OOXIXo
            public final Boolean invoke() {
                return Boolean.TRUE;
            }
        });
        xoI0Ixx02.x0o(R.string.confirm, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.device.TeraBoxFileManagerActivity$onTitleRightClick$1$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            @OXOo.OOXIXo
            public final Boolean invoke() {
                com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
                xo0.XO().remove(com.sma.smartv3.util.XoI0Ixx0.f24397OoO);
                xo0.XO().remove(com.sma.smartv3.util.XoI0Ixx0.f24386OIOoIIOIx);
                TeraBoxFileManagerActivity.this.finish();
                return Boolean.TRUE;
            }
        });
        this.unLoginPopup = xoI0Ixx02;
        if (!xoI0Ixx02.isShowing() && (xoI0Ixx0 = this.unLoginPopup) != null) {
            xoI0Ixx0.IIXOooo();
        }
    }

    public final void setAccess_tokens(@OXOo.OOXIXo String str) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<set-?>");
        this.access_tokens = str;
    }

    public final void setButtonText() {
        boolean z;
        Button mButton = getMButton();
        if (this.mCheckedListID.size() == 0) {
            getMButton().setText(getString(R.string.tera_box_download_btn));
            z = false;
        } else {
            getMButton().setText(getString(R.string.tera_box_download_btn) + HexStringBuilder.COMMENT_BEGIN_CHAR + this.mCheckedListID.size() + HexStringBuilder.COMMENT_END_CHAR);
            z = true;
        }
        mButton.setEnabled(z);
    }

    public final void setProgressPopup(@OXOo.oOoXoXO com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo) {
        this.progressPopup = i0X0x0oIo;
    }

    public final void setUnLoginPopup(@OXOo.oOoXoXO com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0) {
        this.unLoginPopup = xoI0Ixx0;
    }

    public final void showLoadPopup() {
        dismissLoadPopup();
        com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo = this.progressPopup;
        if (i0X0x0oIo != null) {
            View rootView = getRootView();
            kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
            i0X0x0oIo.OxxIIOOXO(rootView);
        }
    }

    public final void showShareView(@OXOo.OOXIXo final String url) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(url, "url");
        getMShareView().setVisibility(0);
        getMShareView().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.OIoxIx
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TeraBoxFileManagerActivity.showShareView$lambda$0(url, this, view);
            }
        });
    }
}
