package com.sma.smartv3.ui.device;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.OSSClient;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.model.ListObjectsRequest;
import com.alibaba.sdk.android.oss.model.ListObjectsResult;
import com.alibaba.sdk.android.oss.model.OSSObjectSummary;
import com.bestmafen.androidbase.adapter.recyclerview.MultiItemTypeAdapter;
import com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder;
import com.bestmafen.androidbase.base.BaseActivity;
import com.blankj.utilcode.util.ToastUtils;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.sma.smartv3.biz.MusicServerManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.ServerOSSMusicItem;
import com.sma.smartv3.work.UploadOSSWorker;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.text.StringsKt__StringsKt;

@kotlin.jvm.internal.XX({"SMAP\nServerMusicActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ServerMusicActivity.kt\ncom/sma/smartv3/ui/device/ServerMusicActivity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,370:1\n1549#2:371\n1620#2,3:372\n766#2:377\n857#2,2:378\n1855#2,2:380\n35#3,2:375\n*S KotlinDebug\n*F\n+ 1 ServerMusicActivity.kt\ncom/sma/smartv3/ui/device/ServerMusicActivity\n*L\n157#1:371\n157#1:372,3\n90#1:377\n90#1:378,2\n93#1:380,2\n364#1:375,2\n*E\n"})
/* loaded from: classes12.dex */
public final class ServerMusicActivity extends BaseActivity {
    private int getMusicNumber;

    @OXOo.oOoXoXO
    private MultiItemTypeAdapter<ServerOSSMusicItem> mAdapter;

    @OXOo.OOXIXo
    private final String TAG = "ServerMusicActivity";

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mTitle$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.device.ServerMusicActivity$mTitle$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) ServerMusicActivity.this.findViewById(R.id.abh_title_center);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mEditText$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<EditText>() { // from class: com.sma.smartv3.ui.device.ServerMusicActivity$mEditText$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final EditText invoke() {
            return (EditText) ServerMusicActivity.this.findViewById(R.id.server_music_file_et);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mClearImageView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.device.ServerMusicActivity$mClearImageView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) ServerMusicActivity.this.findViewById(R.id.server_music_file_et_clear);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mSearchImageView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.device.ServerMusicActivity$mSearchImageView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) ServerMusicActivity.this.findViewById(R.id.server_music_file_search);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mRecyclerView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RecyclerView>() { // from class: com.sma.smartv3.ui.device.ServerMusicActivity$mRecyclerView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RecyclerView invoke() {
            return (RecyclerView) ServerMusicActivity.this.findViewById(R.id.server_music_file_recycler);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mEmptyView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.device.ServerMusicActivity$mEmptyView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return ServerMusicActivity.this.findViewById(R.id.empty_view);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mButton$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<Button>() { // from class: com.sma.smartv3.ui.device.ServerMusicActivity$mButton$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final Button invoke() {
            return (Button) ServerMusicActivity.this.findViewById(R.id.btn_bottom);
        }
    });

    @OXOo.OOXIXo
    private final ArrayList<ServerOSSMusicItem> mCheckedListID = new ArrayList<>();

    @OXOo.OOXIXo
    private final List<String> mCacheList = new ArrayList();

    @OXOo.OOXIXo
    private final HashMap<String, List<ServerOSSMusicItem>> mMapData = new HashMap<>();

    @OXOo.OOXIXo
    private String mCurDir = "/";

    @OXOo.OOXIXo
    private String nextMarker = "";

    @OXOo.OOXIXo
    private final List<ServerOSSMusicItem> rootList = new ArrayList();

    @OXOo.OOXIXo
    private final String musicPath = "var-www/cloud-music/";

    @kotlin.jvm.internal.XX({"SMAP\nServerMusicActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ServerMusicActivity.kt\ncom/sma/smartv3/ui/device/ServerMusicActivity$getOssMusicList$1\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,370:1\n35#2,2:371\n*S KotlinDebug\n*F\n+ 1 ServerMusicActivity.kt\ncom/sma/smartv3/ui/device/ServerMusicActivity$getOssMusicList$1\n*L\n209#1:371,2\n*E\n"})
    /* loaded from: classes12.dex */
    public static final class oIX0oI implements OSSCompletedCallback<ListObjectsRequest, ListObjectsResult> {

        /* renamed from: I0Io, reason: collision with root package name */
        public final /* synthetic */ OSSClient f22021I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public final /* synthetic */ String f22022II0xO0;

        public oIX0oI(String str, OSSClient oSSClient) {
            this.f22022II0xO0 = str;
            this.f22021I0Io = oSSClient;
        }

        @Override // com.alibaba.sdk.android.oss.callback.OSSCompletedCallback
        /* renamed from: II0xO0, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@OXOo.oOoXoXO ListObjectsRequest listObjectsRequest, @OXOo.OOXIXo ListObjectsResult result) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(result, "result");
            OI0.oIX0oI.f1507oIX0oI.II0xO0(ServerMusicActivity.this.TAG + " onSuccess    " + result.getNextMarker() + TokenParser.SP);
            for (OSSObjectSummary oSSObjectSummary : result.getObjectSummaries()) {
                MusicServerManager musicServerManager = MusicServerManager.f20080oIX0oI;
                String key = oSSObjectSummary.getKey();
                kotlin.jvm.internal.IIX0o.oO(key, "getKey(...)");
                if (musicServerManager.oI0IIXIo(key)) {
                    List list = ServerMusicActivity.this.mCacheList;
                    String key2 = oSSObjectSummary.getKey();
                    kotlin.jvm.internal.IIX0o.oO(key2, "getKey(...)");
                    list.add(key2);
                }
            }
            if (result.isTruncated() && result.getNextMarker() != null && ServerMusicActivity.this.getMusicNumber < 10) {
                ServerMusicActivity serverMusicActivity = ServerMusicActivity.this;
                String nextMarker = result.getNextMarker();
                kotlin.jvm.internal.IIX0o.oO(nextMarker, "getNextMarker(...)");
                serverMusicActivity.setNextMarker(nextMarker);
                ServerMusicActivity.this.getOssMusicList(this.f22022II0xO0, this.f22021I0Io);
                return;
            }
            com.sma.smartv3.util.Xo0.f24349oIX0oI.oIX0oI().put(com.sma.smartv3.util.XoI0Ixx0.f24454oXX0IoI, new Gson().toJson(ServerMusicActivity.this.mCacheList));
            ServerMusicActivity.this.formatMusicData();
        }

        @Override // com.alibaba.sdk.android.oss.callback.OSSCompletedCallback
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public void onFailure(@OXOo.oOoXoXO ListObjectsRequest listObjectsRequest, @OXOo.OOXIXo ClientException clientException, @OXOo.OOXIXo ServiceException serviceException) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(clientException, "clientException");
            kotlin.jvm.internal.IIX0o.x0xO0oo(serviceException, "serviceException");
            ToastUtils.showLong(R.string.request_error);
            OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
            oix0oi.II0xO0(ServerMusicActivity.this.TAG + " ErrorCode " + serviceException.getErrorCode());
            clientException.printStackTrace();
            oix0oi.II0xO0(ServerMusicActivity.this.TAG + " ErrorCode " + serviceException.getErrorCode());
            oix0oi.II0xO0(ServerMusicActivity.this.TAG + " RequestId  " + serviceException.getRequestId());
            oix0oi.II0xO0(ServerMusicActivity.this.TAG + " HostId   " + serviceException.getHostId());
            oix0oi.II0xO0(ServerMusicActivity.this.TAG + " RawMessag   " + serviceException.getRawMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0073, code lost:
    
        if (r5 == null) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void formatMusicData() {
        /*
            Method dump skipped, instructions count: 259
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.device.ServerMusicActivity.formatMusicData():void");
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

    private final View getMEmptyView() {
        return (View) this.mEmptyView$delegate.getValue();
    }

    private final RecyclerView getMRecyclerView() {
        return (RecyclerView) this.mRecyclerView$delegate.getValue();
    }

    private final ImageView getMSearchImageView() {
        return (ImageView) this.mSearchImageView$delegate.getValue();
    }

    private final TextView getMTitle() {
        return (TextView) this.mTitle$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getOssMusicList(String str, OSSClient oSSClient) {
        ListObjectsRequest listObjectsRequest = new ListObjectsRequest(str);
        listObjectsRequest.setPrefix(this.musicPath);
        listObjectsRequest.setMaxKeys(1000);
        this.getMusicNumber++;
        if (this.nextMarker.length() > 0) {
            listObjectsRequest.setMarker(this.nextMarker);
        }
        oSSClient.asyncListObjects(listObjectsRequest, new oIX0oI(str, oSSClient));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(ServerMusicActivity this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.getMEditText().getText().clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(ServerMusicActivity this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        if (this$0.getMEditText().getText().toString().length() > 0) {
            List<String> list = this$0.mCacheList;
            ArrayList<String> arrayList = new ArrayList();
            for (Object obj : list) {
                if (StringsKt__StringsKt.o00xOoIO((String) obj, this$0.getMEditText().getText().toString(), false, 2, null)) {
                    arrayList.add(obj);
                }
            }
            if (!arrayList.isEmpty()) {
                ArrayList arrayList2 = new ArrayList();
                for (String str : arrayList) {
                    List XXoO0oX2 = StringsKt__StringsKt.XXoO0oX(str, new String[]{"/"}, false, 0, 6, null);
                    if (!XXoO0oX2.isEmpty()) {
                        arrayList2.add(new ServerOSSMusicItem(str, (String) XXoO0oX2.get(XXoO0oX2.size() - 1), 1));
                    }
                }
                this$0.initData(arrayList2);
                return;
            }
            ToastUtils.showLong(R.string.no_data);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showRootList$lambda$5(ServerMusicActivity this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.mCurDir = "/";
        this$0.getMTitle().setText(this$0.getString(R.string.server_music_title));
        this$0.initData(this$0.rootList);
        MultiItemTypeAdapter<ServerOSSMusicItem> multiItemTypeAdapter = this$0.mAdapter;
        if (multiItemTypeAdapter != null) {
            multiItemTypeAdapter.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void upMusicData$lambda$6(ServerMusicActivity this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.getMTitle().setText(this$0.mCurDir);
        this$0.initData(this$0.mMapData.get(this$0.mCurDir));
        MultiItemTypeAdapter<ServerOSSMusicItem> multiItemTypeAdapter = this$0.mAdapter;
        if (multiItemTypeAdapter != null) {
            multiItemTypeAdapter.notifyDataSetChanged();
        }
    }

    @OXOo.OOXIXo
    public final String getNextMarker() {
        return this.nextMarker;
    }

    @OXOo.OOXIXo
    public final List<ServerOSSMusicItem> getRootList() {
        return this.rootList;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    public final void initData(@OXOo.oOoXoXO final List<ServerOSSMusicItem> list) {
        List<ServerOSSMusicItem> list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            this.mAdapter = new MultiItemTypeAdapter<ServerOSSMusicItem>(this, list) { // from class: com.sma.smartv3.ui.device.ServerMusicActivity$initData$1

                /* loaded from: classes12.dex */
                public static final class II0xO0 implements oo.xoXoI<ServerOSSMusicItem> {

                    /* renamed from: oIX0oI, reason: collision with root package name */
                    public final /* synthetic */ ServerMusicActivity f22019oIX0oI;

                    public II0xO0(ServerMusicActivity serverMusicActivity) {
                        this.f22019oIX0oI = serverMusicActivity;
                    }

                    public static final void XO(ServerMusicActivity this$0, ServerOSSMusicItem mServerOSSMusicItem, ImageView imageView, View view) {
                        ArrayList arrayList;
                        ArrayList arrayList2;
                        ArrayList arrayList3;
                        ArrayList arrayList4;
                        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
                        kotlin.jvm.internal.IIX0o.x0xO0oo(mServerOSSMusicItem, "$mServerOSSMusicItem");
                        arrayList = this$0.mCheckedListID;
                        if (arrayList.contains(mServerOSSMusicItem)) {
                            arrayList4 = this$0.mCheckedListID;
                            arrayList4.remove(mServerOSSMusicItem);
                            imageView.setImageResource(R.drawable.file_uncheck_icon);
                        } else {
                            arrayList2 = this$0.mCheckedListID;
                            if (arrayList2.size() < 20) {
                                arrayList3 = this$0.mCheckedListID;
                                arrayList3.add(mServerOSSMusicItem);
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
                    public boolean oIX0oI(@OXOo.oOoXoXO ServerOSSMusicItem serverOSSMusicItem, int i) {
                        if (serverOSSMusicItem == null || serverOSSMusicItem.getIsdir() != 0) {
                            return false;
                        }
                        return true;
                    }

                    @Override // oo.xoXoI
                    /* renamed from: X0o0xo, reason: merged with bridge method [inline-methods] */
                    public void I0Io(@OXOo.OOXIXo ViewHolder holder, @OXOo.OOXIXo final ServerOSSMusicItem mServerOSSMusicItem, int i) {
                        ArrayList arrayList;
                        int i2;
                        kotlin.jvm.internal.IIX0o.x0xO0oo(holder, "holder");
                        kotlin.jvm.internal.IIX0o.x0xO0oo(mServerOSSMusicItem, "mServerOSSMusicItem");
                        TextView textView = (TextView) holder.getView(R.id.item_tera_box_title);
                        ((TextView) holder.getView(R.id.item_tera_box_tip)).setVisibility(8);
                        final ImageView imageView = (ImageView) holder.getView(R.id.item_check_music);
                        textView.setText(mServerOSSMusicItem.getTitle());
                        arrayList = this.f22019oIX0oI.mCheckedListID;
                        if (arrayList.contains(mServerOSSMusicItem)) {
                            i2 = R.drawable.file_check_icon;
                        } else {
                            i2 = R.drawable.file_uncheck_icon;
                        }
                        imageView.setImageResource(i2);
                        View view = holder.itemView;
                        final ServerMusicActivity serverMusicActivity = this.f22019oIX0oI;
                        view.setOnClickListener(
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0050: INVOKE 
                              (r3v1 'view' android.view.View)
                              (wrap:android.view.View$OnClickListener:0x004d: CONSTRUCTOR 
                              (r5v11 'serverMusicActivity' com.sma.smartv3.ui.device.ServerMusicActivity A[DONT_INLINE])
                              (r4v0 'mServerOSSMusicItem' com.sma.smartv3.model.ServerOSSMusicItem A[DONT_INLINE])
                              (r0v5 'imageView' android.widget.ImageView A[DONT_INLINE])
                             A[MD:(com.sma.smartv3.ui.device.ServerMusicActivity, com.sma.smartv3.model.ServerOSSMusicItem, android.widget.ImageView):void (m), WRAPPED] (LINE:78) call: com.sma.smartv3.ui.device.x0oox0.<init>(com.sma.smartv3.ui.device.ServerMusicActivity, com.sma.smartv3.model.ServerOSSMusicItem, android.widget.ImageView):void type: CONSTRUCTOR)
                             VIRTUAL call: android.view.View.setOnClickListener(android.view.View$OnClickListener):void A[MD:(android.view.View$OnClickListener):void (c)] (LINE:81) in method: com.sma.smartv3.ui.device.ServerMusicActivity$initData$1.II0xO0.X0o0xo(com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder, com.sma.smartv3.model.ServerOSSMusicItem, int):void, file: classes12.dex
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
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.sma.smartv3.ui.device.x0oox0, state: NOT_LOADED
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
                            java.lang.String r5 = "holder"
                            kotlin.jvm.internal.IIX0o.x0xO0oo(r3, r5)
                            java.lang.String r5 = "mServerOSSMusicItem"
                            kotlin.jvm.internal.IIX0o.x0xO0oo(r4, r5)
                            r5 = 2131364928(0x7f0a0c40, float:1.8349707E38)
                            android.view.View r5 = r3.getView(r5)
                            android.widget.TextView r5 = (android.widget.TextView) r5
                            r0 = 2131364927(0x7f0a0c3f, float:1.8349705E38)
                            android.view.View r0 = r3.getView(r0)
                            android.widget.TextView r0 = (android.widget.TextView) r0
                            r1 = 8
                            r0.setVisibility(r1)
                            r0 = 2131364811(0x7f0a0bcb, float:1.834947E38)
                            android.view.View r0 = r3.getView(r0)
                            android.widget.ImageView r0 = (android.widget.ImageView) r0
                            java.lang.String r1 = r4.getTitle()
                            r5.setText(r1)
                            com.sma.smartv3.ui.device.ServerMusicActivity r5 = r2.f22019oIX0oI
                            java.util.ArrayList r5 = com.sma.smartv3.ui.device.ServerMusicActivity.access$getMCheckedListID$p(r5)
                            boolean r5 = r5.contains(r4)
                            if (r5 == 0) goto L41
                            r5 = 2131233517(0x7f080aed, float:1.8083174E38)
                            goto L44
                        L41:
                            r5 = 2131233518(0x7f080aee, float:1.8083176E38)
                        L44:
                            r0.setImageResource(r5)
                            android.view.View r3 = r3.itemView
                            com.sma.smartv3.ui.device.ServerMusicActivity r5 = r2.f22019oIX0oI
                            com.sma.smartv3.ui.device.x0oox0 r1 = new com.sma.smartv3.ui.device.x0oox0
                            r1.<init>(r5, r4, r0)
                            r3.setOnClickListener(r1)
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.device.ServerMusicActivity$initData$1.II0xO0.I0Io(com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder, com.sma.smartv3.model.ServerOSSMusicItem, int):void");
                    }
                }

                /* loaded from: classes12.dex */
                public static final class oIX0oI implements oo.xoXoI<ServerOSSMusicItem> {

                    /* renamed from: oIX0oI, reason: collision with root package name */
                    public final /* synthetic */ ServerMusicActivity f22020oIX0oI;

                    public oIX0oI(ServerMusicActivity serverMusicActivity) {
                        this.f22020oIX0oI = serverMusicActivity;
                    }

                    public static final void XO(ServerMusicActivity this$0, ServerOSSMusicItem mServerOSSMusicItem, View view) {
                        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
                        kotlin.jvm.internal.IIX0o.x0xO0oo(mServerOSSMusicItem, "$mServerOSSMusicItem");
                        this$0.mCurDir = mServerOSSMusicItem.getTitle();
                        this$0.upMusicData();
                    }

                    @Override // oo.xoXoI
                    public int II0xO0() {
                        return R.layout.item_tera_box_dir;
                    }

                    @Override // oo.xoXoI
                    /* renamed from: Oxx0IOOO, reason: merged with bridge method [inline-methods] */
                    public boolean oIX0oI(@OXOo.oOoXoXO ServerOSSMusicItem serverOSSMusicItem, int i) {
                        if (serverOSSMusicItem == null || serverOSSMusicItem.getIsdir() != 1) {
                            return false;
                        }
                        return true;
                    }

                    @Override // oo.xoXoI
                    /* renamed from: X0o0xo, reason: merged with bridge method [inline-methods] */
                    public void I0Io(@OXOo.OOXIXo ViewHolder holder, @OXOo.OOXIXo final ServerOSSMusicItem mServerOSSMusicItem, int i) {
                        kotlin.jvm.internal.IIX0o.x0xO0oo(holder, "holder");
                        kotlin.jvm.internal.IIX0o.x0xO0oo(mServerOSSMusicItem, "mServerOSSMusicItem");
                        TextView textView = (TextView) holder.getView(R.id.item_tera_box_title);
                        TextView textView2 = (TextView) holder.getView(R.id.item_tera_box_tip);
                        textView.setText(mServerOSSMusicItem.getTitle());
                        textView2.setVisibility(8);
                        View view = holder.itemView;
                        final ServerMusicActivity serverMusicActivity = this.f22020oIX0oI;
                        view.setOnClickListener(
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0031: INVOKE 
                              (r3v1 'view' android.view.View)
                              (wrap:android.view.View$OnClickListener:0x002e: CONSTRUCTOR 
                              (r5v7 'serverMusicActivity' com.sma.smartv3.ui.device.ServerMusicActivity A[DONT_INLINE])
                              (r4v0 'mServerOSSMusicItem' com.sma.smartv3.model.ServerOSSMusicItem A[DONT_INLINE])
                             A[MD:(com.sma.smartv3.ui.device.ServerMusicActivity, com.sma.smartv3.model.ServerOSSMusicItem):void (m), WRAPPED] (LINE:47) call: com.sma.smartv3.ui.device.OXIOoo0X0.<init>(com.sma.smartv3.ui.device.ServerMusicActivity, com.sma.smartv3.model.ServerOSSMusicItem):void type: CONSTRUCTOR)
                             VIRTUAL call: android.view.View.setOnClickListener(android.view.View$OnClickListener):void A[MD:(android.view.View$OnClickListener):void (c)] (LINE:50) in method: com.sma.smartv3.ui.device.ServerMusicActivity$initData$1.oIX0oI.X0o0xo(com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder, com.sma.smartv3.model.ServerOSSMusicItem, int):void, file: classes12.dex
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
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.sma.smartv3.ui.device.OXIOoo0X0, state: NOT_LOADED
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
                            java.lang.String r5 = "holder"
                            kotlin.jvm.internal.IIX0o.x0xO0oo(r3, r5)
                            java.lang.String r5 = "mServerOSSMusicItem"
                            kotlin.jvm.internal.IIX0o.x0xO0oo(r4, r5)
                            r5 = 2131364928(0x7f0a0c40, float:1.8349707E38)
                            android.view.View r5 = r3.getView(r5)
                            android.widget.TextView r5 = (android.widget.TextView) r5
                            r0 = 2131364927(0x7f0a0c3f, float:1.8349705E38)
                            android.view.View r0 = r3.getView(r0)
                            android.widget.TextView r0 = (android.widget.TextView) r0
                            java.lang.String r1 = r4.getTitle()
                            r5.setText(r1)
                            r5 = 8
                            r0.setVisibility(r5)
                            android.view.View r3 = r3.itemView
                            com.sma.smartv3.ui.device.ServerMusicActivity r5 = r2.f22020oIX0oI
                            com.sma.smartv3.ui.device.OXIOoo0X0 r0 = new com.sma.smartv3.ui.device.OXIOoo0X0
                            r0.<init>(r5, r4)
                            r3.setOnClickListener(r0)
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.device.ServerMusicActivity$initData$1.oIX0oI.I0Io(com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder, com.sma.smartv3.model.ServerOSSMusicItem, int):void");
                    }
                }

                {
                    addItemViewDelegate(1, new oIX0oI(this));
                    addItemViewDelegate(0, new II0xO0(this));
                }
            };
            getMRecyclerView().setVisibility(0);
            getMEmptyView().setVisibility(8);
            getMRecyclerView().setAdapter(this.mAdapter);
            return;
        }
        getMRecyclerView().setVisibility(8);
        getMEmptyView().setVisibility(0);
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        getMTitle().setText(getString(R.string.server_music_title));
        getMButton().setEnabled(false);
        getMClearImageView().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.o0Oo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ServerMusicActivity.initView$lambda$0(ServerMusicActivity.this, view);
            }
        });
        getMSearchImageView().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.OIxOX
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ServerMusicActivity.initView$lambda$3(ServerMusicActivity.this, view);
            }
        });
        getMRecyclerView().setLayoutManager(new LinearLayoutManager(this, 1, false));
        MusicServerManager.f20080oIX0oI.OxxIIOOXO(new Oox.oOoXoXO<Pair<? extends UploadOSSWorker.StsRamData, ? extends Integer>, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.ServerMusicActivity$initView$3
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(Pair<? extends UploadOSSWorker.StsRamData, ? extends Integer> pair) {
                invoke2((Pair<UploadOSSWorker.StsRamData, Integer>) pair);
                return kotlin.oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo Pair<UploadOSSWorker.StsRamData, Integer> pair) {
                List ooXIXxIX2;
                kotlin.jvm.internal.IIX0o.x0xO0oo(pair, "pair");
                Integer second = pair.getSecond();
                ServerMusicActivity serverMusicActivity = ServerMusicActivity.this;
                int intValue = second.intValue();
                if (intValue != 0) {
                    if (intValue != 1) {
                        return;
                    }
                    UploadOSSWorker.StsRamData first = pair.getFirst();
                    OSSClient II0xO02 = MusicServerManager.f20080oIX0oI.II0xO0(first);
                    if (first != null && II0xO02 != null) {
                        serverMusicActivity.getOssMusicList(first.getBucket(), II0xO02);
                        return;
                    } else {
                        ToastUtils.showLong(R.string.request_error);
                        return;
                    }
                }
                try {
                    JsonArray asJsonArray = JsonParser.parseString(com.sma.smartv3.util.Xo0.f24349oIX0oI.oIX0oI().getString(com.sma.smartv3.util.XoI0Ixx0.f24454oXX0IoI)).getAsJsonArray();
                    kotlin.jvm.internal.IIX0o.ooOOo0oXI(asJsonArray);
                    ooXIXxIX2 = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(asJsonArray, 10));
                    Iterator<JsonElement> it = asJsonArray.iterator();
                    while (it.hasNext()) {
                        ooXIXxIX2.add(new Gson().fromJson(it.next(), String.class));
                    }
                } catch (Exception unused) {
                    ooXIXxIX2 = CollectionsKt__CollectionsKt.ooXIXxIX();
                }
                if (!ooXIXxIX2.isEmpty()) {
                    OI0.oIX0oI.f1507oIX0oI.oIX0oI(serverMusicActivity.TAG + " mCacheList = " + ooXIXxIX2.size() + TokenParser.SP);
                    serverMusicActivity.mCacheList.addAll(ooXIXxIX2);
                    serverMusicActivity.formatMusicData();
                    return;
                }
                UploadOSSWorker.StsRamData first2 = pair.getFirst();
                OSSClient II0xO03 = MusicServerManager.f20080oIX0oI.II0xO0(first2);
                if (first2 != null && II0xO03 != null) {
                    serverMusicActivity.getOssMusicList(first2.getBucket(), II0xO03);
                } else {
                    ToastUtils.showLong(R.string.request_error);
                }
            }
        });
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_server_music_file_manager;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.mCurDir, "/")) {
            super.onBackPressed();
        } else {
            showRootList();
        }
    }

    public final void onBottomClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        com.sma.smartv3.util.Xo0.f24349oIX0oI.XO().put(com.sma.smartv3.util.XoI0Ixx0.f24426XXXI, new Gson().toJson(this.mCheckedListID));
        com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.XoI0Ixx0.f24426XXXI, null, 2, null);
        finish();
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        onBackPressed();
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

    public final void setNextMarker(@OXOo.OOXIXo String str) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<set-?>");
        this.nextMarker = str;
    }

    public final void showRootList() {
        runOnUiThread(new Runnable() { // from class: com.sma.smartv3.ui.device.IXoIo
            @Override // java.lang.Runnable
            public final void run() {
                ServerMusicActivity.showRootList$lambda$5(ServerMusicActivity.this);
            }
        });
    }

    public final void upMusicData() {
        runOnUiThread(new Runnable() { // from class: com.sma.smartv3.ui.device.x0OOI
            @Override // java.lang.Runnable
            public final void run() {
                ServerMusicActivity.upMusicData$lambda$6(ServerMusicActivity.this);
            }
        });
    }
}
