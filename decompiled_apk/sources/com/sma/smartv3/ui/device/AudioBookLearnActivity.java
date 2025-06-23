package com.sma.smartv3.ui.device;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import com.angcyo.dsladapter.DslAdapter;
import com.angcyo.dsladapter.DslAdapterExKt;
import com.angcyo.dsladapter.DslAdapterItem;
import com.angcyo.dsladapter.DslViewHolder;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOUtils;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.AppFileDetail;
import com.sma.smartv3.model.AppStoreFileManager;
import com.sma.smartv3.model.AudioBookItem;
import com.sma.smartv3.ui.me.WebViewActivity;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.BleKeyFlag;
import com.szabh.smable3.component.BleCache;
import com.szabh.smable3.component.BleConnector;
import com.szabh.smable3.entity.BleAppAudioBookList;
import com.szabh.smable3.entity.BleAppAudioBookPath;
import com.szabh.smable3.entity.BleAppOp;
import com.szabh.smable3.entity.BleFilePath;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

@kotlin.jvm.internal.XX({"SMAP\nAudioBookLearnActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AudioBookLearnActivity.kt\ncom/sma/smartv3/ui/device/AudioBookLearnActivity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,372:1\n50#2,3:373\n53#2:379\n55#2,2:381\n50#2,3:402\n53#2:408\n55#2,2:410\n35#2,2:419\n1549#3:376\n1620#3,2:377\n1622#3:380\n1549#3:405\n1620#3,2:406\n1622#3:409\n1855#3:412\n1856#3:414\n1549#3:415\n1620#3,3:416\n1855#3,2:440\n87#4,7:383\n94#4,3:391\n70#4,7:394\n97#4:401\n173#4,7:421\n180#4,3:429\n143#4,7:432\n183#4:439\n1#5:390\n1#5:413\n1#5:428\n*S KotlinDebug\n*F\n+ 1 AudioBookLearnActivity.kt\ncom/sma/smartv3/ui/device/AudioBookLearnActivity\n*L\n71#1:373,3\n71#1:379\n71#1:381,2\n142#1:402,3\n142#1:408\n142#1:410,2\n294#1:419,2\n71#1:376\n71#1:377,2\n71#1:380\n142#1:405\n142#1:406,2\n142#1:409\n148#1:412\n148#1:414\n270#1:415\n270#1:416,3\n349#1:440,2\n86#1:383,7\n86#1:391,3\n86#1:394,7\n86#1:401\n295#1:421,7\n295#1:429,3\n295#1:432,7\n295#1:439\n86#1:390\n295#1:428\n*E\n"})
/* loaded from: classes12.dex */
public final class AudioBookLearnActivity extends BaseJLFileManageActivity {

    @OXOo.OOXIXo
    private final List<AudioBookItem> mAudioBookItemFiles;

    @OXOo.oOoXoXO
    private List<AudioBookItem> mAudioBookItemList;

    @OXOo.oOoXoXO
    private List<AppFileDetail> mAudioBookLearnList;
    private final int mResultCode;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO abhTitleRight$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.device.AudioBookLearnActivity$abhTitleRight$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) AudioBookLearnActivity.this.findViewById(R.id.abh_title_right);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO abhTitleOtherRight$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.device.AudioBookLearnActivity$abhTitleOtherRight$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) AudioBookLearnActivity.this.findViewById(R.id.abh_title_other_right);
        }
    });

    @OXOo.OOXIXo
    private final String TAG = "AudioBookLearnActivity";

    @OXOo.OOXIXo
    private final List<String> deleteFilePath = new ArrayList();

    /* loaded from: classes12.dex */
    public static final class oIX0oI extends TypeToken<List<? extends AudioBookItem>> {
    }

    public AudioBookLearnActivity() {
        String str;
        if (getMArg1() == 0) {
            str = DeviceFileManager.f21739X0o0xo;
        } else {
            str = DeviceFileManager.f21740XO;
        }
        setMSDCardName(str);
        this.mAudioBookItemFiles = new ArrayList();
        this.mResultCode = 254;
    }

    private final void downloadAppFile() {
        int i;
        int i2;
        getTaskPanel().setVisibility(0);
        getRecyclerView().setVisibility(8);
        TextView tvProgressTip = getTvProgressTip();
        if (getMArg1() == 0) {
            i = R.string.audiobooks_transmission_tip;
        } else {
            i = R.string.studycard_transmission_tip;
        }
        tvProgressTip.setText(i);
        getRightBtn().setVisibility(8);
        getRecyclerViewTitle().setVisibility(8);
        getTvCancel().setVisibility(8);
        getTvRetry().setVisibility(8);
        List<AudioBookItem> list = this.mAudioBookItemList;
        if (list != null) {
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(list);
            if (!list.isEmpty()) {
                List<AudioBookItem> list2 = this.mAudioBookItemList;
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(list2);
                setMAudioBookItem((AudioBookItem) CollectionsKt___CollectionsKt.O0OOX0IIx(list2));
                AppStoreFileManager appStoreFileManager = AppStoreFileManager.INSTANCE;
                AudioBookItem mAudioBookItem = getMAudioBookItem();
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(mAudioBookItem);
                String binOnlinePath = mAudioBookItem.getBinOnlinePath();
                AudioBookItem mAudioBookItem2 = getMAudioBookItem();
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(mAudioBookItem2);
                String mPackage = mAudioBookItem2.getMPackage();
                if (getMArg1() == 0) {
                    i2 = 3;
                } else {
                    i2 = 4;
                }
                AppStoreFileManager.downloadAppFile$default(appStoreFileManager, binOnlinePath, mPackage, i2, 0, 8, null);
            }
        }
    }

    private final ImageView getAbhTitleOtherRight() {
        return (ImageView) this.abhTitleOtherRight$delegate.getValue();
    }

    private final ImageView getAbhTitleRight() {
        return (ImageView) this.abhTitleRight$delegate.getValue();
    }

    @Override // com.sma.smartv3.ui.device.BaseJLFileManageActivity
    public void allSelect(boolean z) {
        int i;
        super.allSelect(z);
        Iterator<T> it = this.mAudioBookItemFiles.iterator();
        while (it.hasNext()) {
            ((AudioBookItem) it.next()).setChoose(isAllSelect());
        }
        if (getOpenDeleteType()) {
            if (isAllSelect()) {
                i = this.mAudioBookItemFiles.size();
            } else {
                i = 0;
            }
            setDeleteNum(i);
            changeDeleteBtnText(getDeleteNum());
        }
        getDslAdapter().notifyDataChanged();
    }

    @Override // com.sma.smartv3.ui.device.BaseJLFileManageActivity
    public void cleanListData() {
        super.cleanListData();
        List<AppFileDetail> list = this.mAudioBookLearnList;
        if (list != null) {
            list.clear();
        }
    }

    @Override // com.sma.smartv3.ui.device.BaseJLFileManageActivity
    public void confirmDeleteFile() {
        super.confirmDeleteFile();
        if (this.deleteFilePath.size() > 0) {
            BaseJLFileManageActivity.showLoading$default(this, false, 1, null);
            BleConnector.sendObject$default(BleConnector.INSTANCE, BleKey.FILE_PATH, BleKeyFlag.DELETE, new BleAppAudioBookPath(this.deleteFilePath.size(), CollectionsKt___CollectionsKt.oOo0o(this.deleteFilePath)), false, false, 24, null);
        }
    }

    @Override // com.sma.smartv3.ui.device.BaseJLFileManageActivity
    public void deleteFilePath(boolean z) {
        super.deleteFilePath(z);
        dismissLoading();
        if (z) {
            Iterator<AudioBookItem> it = this.mAudioBookItemFiles.iterator();
            while (it.hasNext()) {
                if (it.next().isChoose()) {
                    it.remove();
                }
            }
            showList();
            setOpenDeleteType(false);
            changeActivityState();
            return;
        }
        ToastUtils.showLong(R.string.failed_to_delete);
    }

    @OXOo.OOXIXo
    public final List<String> getDeleteFilePath() {
        return this.deleteFilePath;
    }

    @Override // com.sma.smartv3.ui.device.BaseJLFileManageActivity
    public void getFile() {
        super.getFile();
        com.sma.smartv3.util.Xo0.f24349oIX0oI.oxoX().put(com.sma.smartv3.util.XoI0Ixx0.f24394OX, new Gson().toJson(this.mAudioBookItemFiles));
        int i = this.mResultCode;
        String obj = getTvFreeSpace().getText().toString();
        int mArg1 = getMArg1();
        Bundle bundle = new Bundle();
        bundle.putString("mArg0", obj);
        bundle.putInt("mArg1", mArg1);
        bundle.putParcelable("mArg2", null);
        bundle.putSerializable("mArg3", null);
        Intent intent = new Intent(this, (Class<?>) OnLineLearningFileActivity.class);
        intent.putExtras(bundle);
        startActivityForResult(intent, i);
    }

    @OXOo.OOXIXo
    public final List<AudioBookItem> getMAudioBookItemFiles() {
        return this.mAudioBookItemFiles;
    }

    @OXOo.oOoXoXO
    public final List<AudioBookItem> getMAudioBookItemList() {
        return this.mAudioBookItemList;
    }

    @OXOo.oOoXoXO
    public final List<AppFileDetail> getMAudioBookLearnList() {
        return this.mAudioBookLearnList;
    }

    public final int getMResultCode() {
        return this.mResultCode;
    }

    @Override // com.sma.smartv3.ui.device.BaseJLFileManageActivity, com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        String string;
        Collection ooXIXxIX2;
        String str;
        super.initView();
        TextView textView = (TextView) findViewById(R.id.abh_title_center);
        if (getMArg1() == 0) {
            string = getString(R.string.item_audio_book_learn_title);
        } else {
            string = getString(R.string.item_learn_card_title);
        }
        textView.setText(string);
        if (ProjectManager.f19822oIX0oI.X0xxXX0()) {
            getAbhTitleRight().setVisibility(0);
            getAbhTitleRight().setImageResource(R.drawable.icon_sound_learn_help);
            getAbhTitleRight().setImageTintList(oIxOXo.oxoX.X0o0xo(this, R.color.text_color));
        }
        try {
            JsonArray asJsonArray = JsonParser.parseString(com.sma.smartv3.util.Xo0.f24349oIX0oI.XO().getString(getMSDCardName())).getAsJsonArray();
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(asJsonArray);
            ooXIXxIX2 = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(asJsonArray, 10));
            Iterator<JsonElement> it = asJsonArray.iterator();
            while (it.hasNext()) {
                ooXIXxIX2.add(new Gson().fromJson(it.next(), AppFileDetail.class));
            }
        } catch (Exception unused) {
            ooXIXxIX2 = CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        List<AppFileDetail> o0Xo0XII = CollectionsKt___CollectionsKt.o0Xo0XII(ooXIXxIX2);
        this.mAudioBookLearnList = o0Xo0XII;
        if (o0Xo0XII == null || (o0Xo0XII != null && o0Xo0XII.size() == 0)) {
            AppStoreFileManager appStoreFileManager = AppStoreFileManager.INSTANCE;
            if (getMArg1() == 0) {
                str = "2";
            } else {
                str = "3";
            }
            appStoreFileManager.getAudioBookFileList(str, new Oox.oOoXoXO<List<? extends AppFileDetail>, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.AudioBookLearnActivity$initView$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(List<? extends AppFileDetail> list) {
                    invoke2((List<AppFileDetail>) list);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.oOoXoXO List<AppFileDetail> list) {
                    if (list != null) {
                        com.sma.smartv3.util.Xo0.f24349oIX0oI.XO().put(AudioBookLearnActivity.this.getMSDCardName(), new Gson().toJson(CollectionsKt___CollectionsKt.o0Xo0XII(list)));
                    }
                    AudioBookLearnActivity.this.setMAudioBookLearnList(list != null ? CollectionsKt___CollectionsKt.o0Xo0XII(list) : null);
                }
            });
        }
    }

    @Override // com.sma.smartv3.ui.device.BaseJLFileManageActivity, com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_audio_book_learn;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @OXOo.oOoXoXO Intent intent) {
        Serializable serializable;
        int i3;
        super.onActivityResult(i, i2, intent);
        if (i == this.mResultCode && i2 == -1) {
            if (intent != null) {
                serializable = intent.getSerializableExtra("chooseItem");
            } else {
                serializable = null;
            }
            kotlin.jvm.internal.IIX0o.x0XOIxOo(serializable, "null cannot be cast to non-null type kotlin.String");
            Type type = new oIX0oI().getType();
            List<AudioBookItem> list = (List) new Gson().fromJson((String) serializable, type);
            this.mAudioBookItemList = list;
            if (list != null) {
                i3 = list.size();
            } else {
                i3 = 1;
            }
            setMTotalListSize(i3);
            setMCurListSize(1);
            downloadAppFile();
        }
    }

    @Override // com.sma.smartv3.ui.device.BaseJLFileManageActivity
    public void onAudioAppOpUpdate(@OXOo.OOXIXo BleAppOp appOp) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(appOp, "appOp");
        if (appOp.getMStatus() == 1) {
            List<AudioBookItem> list = this.mAudioBookItemList;
            if (list != null) {
                kotlin.jvm.internal.XoX.oIX0oI(list).remove(getMAudioBookItem());
            }
            List<AudioBookItem> list2 = this.mAudioBookItemList;
            if (list2 != null) {
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(list2);
                if (!list2.isEmpty()) {
                    setMCurListSize(getMCurListSize() + 1);
                    downloadAppFile();
                    return;
                }
            }
            super.onAudioAppOpUpdate(appOp);
        }
    }

    public final void onBottomClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        List<AudioBookItem> list = this.mAudioBookItemFiles;
        ArrayList arrayList = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(list, 10));
        for (AudioBookItem audioBookItem : list) {
            if (audioBookItem.isChoose()) {
                this.deleteFilePath.add(getMSDCardName() + IOUtils.DIR_SEPARATOR_UNIX + audioBookItem.getMPackage());
            }
            arrayList.add(kotlin.oXIO0o0XI.f29392oIX0oI);
        }
        if (getOpenDeleteType()) {
            if (this.mAudioBookItemFiles.size() > 0) {
                showDeleteTipPopup(R.string.audio_book_delete_pop_title, R.string.audio_book_delete_pop_content, R.string.audio_book_delete_pop_sure);
                return;
            } else {
                ToastUtils.showLong(R.string.select_file_tip);
                return;
            }
        }
        getFile();
    }

    public final void onBottomLinkJump(@OXOo.OOXIXo View view) {
        String str;
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        StringBuilder sb = new StringBuilder();
        sb.append("https://dev.iot-solution.net/audiobookDownload/dist?appModuleId=");
        if (getMArg1() == 0) {
            str = "2";
        } else {
            str = "3";
        }
        sb.append(str);
        sb.append("&bleName=");
        BleCache bleCache = BleCache.INSTANCE;
        sb.append(bleCache.getMBleName());
        sb.append("&flag=");
        sb.append(bleCache.getMFirmwareFlag());
        oOXoIIIo.oIX0oI.xxX(this, sb.toString());
    }

    @Override // com.sma.smartv3.ui.device.BaseJLFileManageActivity, com.bestmafen.androidbase.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ArrayList arrayList = new ArrayList();
        Locale locale = Locale.getDefault();
        kotlin.jvm.internal.IIX0o.oO(locale, "getDefault(...)");
        String upperCase = "music".toUpperCase(locale);
        kotlin.jvm.internal.IIX0o.oO(upperCase, "toUpperCase(...)");
        arrayList.add(upperCase);
        BleConnector.sendObject$default(BleConnector.INSTANCE, BleKey.FILE_PATH, BleKeyFlag.UPDATE, new BleAppAudioBookPath(1, CollectionsKt___CollectionsKt.oOo0o(arrayList)), false, false, 24, null);
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity
    public void onInitBaseLayoutAfter() {
        String str;
        super.onInitBaseLayoutAfter();
        if (getMArg1() == 0) {
            str = DeviceFileManager.f21739X0o0xo;
        } else {
            str = DeviceFileManager.f21740XO;
        }
        setMSDCardName(str);
        ArrayList arrayList = new ArrayList();
        String mSDCardName = getMSDCardName();
        Locale locale = Locale.getDefault();
        kotlin.jvm.internal.IIX0o.oO(locale, "getDefault(...)");
        String upperCase = mSDCardName.toUpperCase(locale);
        kotlin.jvm.internal.IIX0o.oO(upperCase, "toUpperCase(...)");
        arrayList.add(upperCase);
        BleConnector.sendObject$default(BleConnector.INSTANCE, BleKey.FILE_PATH, BleKeyFlag.UPDATE, new BleAppAudioBookPath(1, CollectionsKt___CollectionsKt.oOo0o(arrayList)), false, false, 24, null);
        getRecyclerView().setLayoutManager(new GridLayoutManager(this, 3));
        readListData();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (getDslAdapter() != null) {
            getDslAdapter().notifyDataChanged();
        }
    }

    public final void onTitleRightClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        Bundle bundle = new Bundle();
        bundle.putString("mArg0", "https://api.iot-solution.net/web/help/audio_book_download_help.html");
        bundle.putInt("mArg1", 2);
        bundle.putParcelable("mArg2", null);
        bundle.putSerializable("mArg3", null);
        Intent intent = new Intent(this, (Class<?>) WebViewActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override // com.sma.smartv3.ui.device.BaseJLFileManageActivity
    public void readListData() {
        ArrayList arrayList = new ArrayList();
        String mSDCardName = getMSDCardName();
        Locale locale = Locale.getDefault();
        kotlin.jvm.internal.IIX0o.oO(locale, "getDefault(...)");
        String upperCase = mSDCardName.toUpperCase(locale);
        kotlin.jvm.internal.IIX0o.oO(upperCase, "toUpperCase(...)");
        arrayList.add(upperCase);
        BleConnector.sendObject$default(BleConnector.INSTANCE, BleKey.FILE_PATH, BleKeyFlag.READ, new BleAppAudioBookPath(1, CollectionsKt___CollectionsKt.oOo0o(arrayList)), false, false, 24, null);
    }

    public final void setMAudioBookItemList(@OXOo.oOoXoXO List<AudioBookItem> list) {
        this.mAudioBookItemList = list;
    }

    public final void setMAudioBookLearnList(@OXOo.oOoXoXO List<AppFileDetail> list) {
        this.mAudioBookLearnList = list;
    }

    @Override // com.sma.smartv3.ui.device.BaseJLFileManageActivity
    public void showList() {
        super.showList();
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " showList -> mAudioBookItemFiles = " + this.mAudioBookItemFiles);
        getDslAdapter().resetItem(new ArrayList());
        renderAdapter(new Oox.oOoXoXO<DslAdapter, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.AudioBookLearnActivity$showList$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(DslAdapter dslAdapter) {
                invoke2(dslAdapter);
                return kotlin.oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo DslAdapter renderAdapter) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(renderAdapter, "$this$renderAdapter");
                for (final AudioBookItem audioBookItem : AudioBookLearnActivity.this.getMAudioBookItemFiles()) {
                    DslAdapter dslAdapter = AudioBookLearnActivity.this.getDslAdapter();
                    final AudioBookLearnActivity audioBookLearnActivity = AudioBookLearnActivity.this;
                    DslAdapterExKt.oO(dslAdapter, R.layout.item_list_audio_book_learn, new Oox.oOoXoXO<DslAdapterItem, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.AudioBookLearnActivity$showList$1.1

                        /* renamed from: com.sma.smartv3.ui.device.AudioBookLearnActivity$showList$1$1$1, reason: invalid class name and collision with other inner class name */
                        /* loaded from: classes12.dex */
                        public static final class C09411 extends Lambda implements Oox.Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, kotlin.oXIO0o0XI> {
                            final /* synthetic */ AudioBookItem $item;
                            final /* synthetic */ AudioBookLearnActivity this$0;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            public C09411(AudioBookItem audioBookItem, AudioBookLearnActivity audioBookLearnActivity) {
                                super(4);
                                this.$item = audioBookItem;
                                this.this$0 = audioBookLearnActivity;
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public static final void invoke$lambda$0(AudioBookItem item, AudioBookLearnActivity this$0, ImageView imageView, View view) {
                                kotlin.jvm.internal.IIX0o.x0xO0oo(item, "$item");
                                kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
                                item.setChoose(!item.isChoose());
                                if (item.isChoose()) {
                                    this$0.setDeleteNum(this$0.getDeleteNum() + 1);
                                } else {
                                    this$0.setDeleteNum(this$0.getDeleteNum() - 1);
                                }
                                this$0.changeDeleteBtnText(this$0.getDeleteNum());
                                if (item.isChoose()) {
                                    kotlin.jvm.internal.IIX0o.ooOOo0oXI(imageView);
                                    Glide.with(imageView.getContext()).load(Integer.valueOf(R.drawable.audio_book_item_choose_icon)).into(imageView);
                                } else {
                                    kotlin.jvm.internal.IIX0o.ooOOo0oXI(imageView);
                                    Glide.with(imageView.getContext()).load(Integer.valueOf(R.drawable.audio_book_unchoose_icon)).into(imageView);
                                }
                            }

                            @Override // Oox.Oxx0xo
                            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(DslViewHolder dslViewHolder, Integer num, DslAdapterItem dslAdapterItem, List<? extends Object> list) {
                                invoke(dslViewHolder, num.intValue(), dslAdapterItem, list);
                                return kotlin.oXIO0o0XI.f29392oIX0oI;
                            }

                            public final void invoke(@OXOo.OOXIXo DslViewHolder itemHolder, int i, @OXOo.OOXIXo DslAdapterItem adapterItem, @OXOo.OOXIXo List<? extends Object> list) {
                                int i2;
                                kotlin.jvm.internal.IIX0o.x0xO0oo(itemHolder, "itemHolder");
                                kotlin.jvm.internal.IIX0o.x0xO0oo(adapterItem, "adapterItem");
                                kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<anonymous parameter 3>");
                                TextView tv = itemHolder.tv(R.id.tv);
                                if (tv != null) {
                                    tv.setText(this.$item.getName());
                                }
                                TextView tv2 = itemHolder.tv(R.id.audio_book_file_size);
                                if (tv2 != null) {
                                    tv2.setText(this.$item.getSize() + "kb");
                                }
                                ImageView img = itemHolder.img(R.id.iv);
                                kotlin.jvm.internal.IIX0o.ooOOo0oXI(img);
                                Glide.with(img.getContext()).load(this.$item.getOnlinePath()).error(R.drawable.audiobook_normal_icon).into(img);
                                final ImageView img2 = itemHolder.img(R.id.list_item_choose_iv);
                                if (this.$item.isChoose()) {
                                    kotlin.jvm.internal.IIX0o.ooOOo0oXI(img2);
                                    Glide.with(img2.getContext()).load(Integer.valueOf(R.drawable.audio_book_item_choose_icon)).into(img2);
                                } else {
                                    kotlin.jvm.internal.IIX0o.ooOOo0oXI(img2);
                                    Glide.with(img2.getContext()).load(Integer.valueOf(R.drawable.audio_book_unchoose_icon)).into(img2);
                                }
                                if (this.this$0.getOpenDeleteType()) {
                                    View view = itemHolder.itemView;
                                    final AudioBookItem audioBookItem = this.$item;
                                    final AudioBookLearnActivity audioBookLearnActivity = this.this$0;
                                    view.setOnClickListener(
                                    /*  JADX ERROR: Method code generation error
                                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00c3: INVOKE 
                                          (r2v3 'view' android.view.View)
                                          (wrap:android.view.View$OnClickListener:0x00c0: CONSTRUCTOR 
                                          (r4v13 'audioBookItem' com.sma.smartv3.model.AudioBookItem A[DONT_INLINE])
                                          (r5v6 'audioBookLearnActivity' com.sma.smartv3.ui.device.AudioBookLearnActivity A[DONT_INLINE])
                                          (r3v11 'img2' android.widget.ImageView A[DONT_INLINE])
                                         A[MD:(com.sma.smartv3.model.AudioBookItem, com.sma.smartv3.ui.device.AudioBookLearnActivity, android.widget.ImageView):void (m), WRAPPED] call: com.sma.smartv3.ui.device.oO.<init>(com.sma.smartv3.model.AudioBookItem, com.sma.smartv3.ui.device.AudioBookLearnActivity, android.widget.ImageView):void type: CONSTRUCTOR)
                                         VIRTUAL call: android.view.View.setOnClickListener(android.view.View$OnClickListener):void A[MD:(android.view.View$OnClickListener):void (c)] in method: com.sma.smartv3.ui.device.AudioBookLearnActivity.showList.1.1.1.invoke(com.angcyo.dsladapter.DslViewHolder, int, com.angcyo.dsladapter.DslAdapterItem, java.util.List<? extends java.lang.Object>):void, file: classes12.dex
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
                                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.sma.smartv3.ui.device.oO, state: NOT_LOADED
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
                                        	... 21 more
                                        */
                                    /*
                                        this = this;
                                        java.lang.String r3 = "itemHolder"
                                        kotlin.jvm.internal.IIX0o.x0xO0oo(r2, r3)
                                        java.lang.String r3 = "adapterItem"
                                        kotlin.jvm.internal.IIX0o.x0xO0oo(r4, r3)
                                        java.lang.String r3 = "<anonymous parameter 3>"
                                        kotlin.jvm.internal.IIX0o.x0xO0oo(r5, r3)
                                        r3 = 2131368123(0x7f0a18bb, float:1.8356187E38)
                                        android.widget.TextView r3 = r2.tv(r3)
                                        if (r3 != 0) goto L19
                                        goto L22
                                    L19:
                                        com.sma.smartv3.model.AudioBookItem r4 = r1.$item
                                        java.lang.String r4 = r4.getName()
                                        r3.setText(r4)
                                    L22:
                                        r3 = 2131362054(0x7f0a0106, float:1.8343878E38)
                                        android.widget.TextView r3 = r2.tv(r3)
                                        if (r3 != 0) goto L2c
                                        goto L46
                                    L2c:
                                        java.lang.StringBuilder r4 = new java.lang.StringBuilder
                                        r4.<init>()
                                        com.sma.smartv3.model.AudioBookItem r5 = r1.$item
                                        int r5 = r5.getSize()
                                        r4.append(r5)
                                        java.lang.String r5 = "kb"
                                        r4.append(r5)
                                        java.lang.String r4 = r4.toString()
                                        r3.setText(r4)
                                    L46:
                                        r3 = 2131364945(0x7f0a0c51, float:1.8349741E38)
                                        android.widget.ImageView r3 = r2.img(r3)
                                        kotlin.jvm.internal.IIX0o.ooOOo0oXI(r3)
                                        android.content.Context r4 = r3.getContext()
                                        com.bumptech.glide.RequestManager r4 = com.bumptech.glide.Glide.with(r4)
                                        com.sma.smartv3.model.AudioBookItem r5 = r1.$item
                                        java.lang.String r5 = r5.getOnlinePath()
                                        com.bumptech.glide.RequestBuilder r4 = r4.load(r5)
                                        r5 = 2131232383(0x7f08067f, float:1.8080874E38)
                                        com.bumptech.glide.request.BaseRequestOptions r4 = r4.error(r5)
                                        com.bumptech.glide.RequestBuilder r4 = (com.bumptech.glide.RequestBuilder) r4
                                        r4.into(r3)
                                        r3 = 2131365828(0x7f0a0fc4, float:1.8351532E38)
                                        android.widget.ImageView r3 = r2.img(r3)
                                        com.sma.smartv3.model.AudioBookItem r4 = r1.$item
                                        boolean r4 = r4.isChoose()
                                        if (r4 == 0) goto L97
                                        kotlin.jvm.internal.IIX0o.ooOOo0oXI(r3)
                                        android.content.Context r4 = r3.getContext()
                                        com.bumptech.glide.RequestManager r4 = com.bumptech.glide.Glide.with(r4)
                                        r5 = 2131232380(0x7f08067c, float:1.8080868E38)
                                        java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                                        com.bumptech.glide.RequestBuilder r4 = r4.load(r5)
                                        r4.into(r3)
                                        goto Lb0
                                    L97:
                                        kotlin.jvm.internal.IIX0o.ooOOo0oXI(r3)
                                        android.content.Context r4 = r3.getContext()
                                        com.bumptech.glide.RequestManager r4 = com.bumptech.glide.Glide.with(r4)
                                        r5 = 2131232381(0x7f08067d, float:1.808087E38)
                                        java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                                        com.bumptech.glide.RequestBuilder r4 = r4.load(r5)
                                        r4.into(r3)
                                    Lb0:
                                        com.sma.smartv3.ui.device.AudioBookLearnActivity r4 = r1.this$0
                                        boolean r4 = r4.getOpenDeleteType()
                                        if (r4 == 0) goto Lc8
                                        android.view.View r2 = r2.itemView
                                        com.sma.smartv3.model.AudioBookItem r4 = r1.$item
                                        com.sma.smartv3.ui.device.AudioBookLearnActivity r5 = r1.this$0
                                        com.sma.smartv3.ui.device.oO r0 = new com.sma.smartv3.ui.device.oO
                                        r0.<init>(r4, r5, r3)
                                        r2.setOnClickListener(r0)
                                        r2 = 0
                                        goto Lca
                                    Lc8:
                                        r2 = 8
                                    Lca:
                                        r3.setVisibility(r2)
                                        return
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.device.AudioBookLearnActivity$showList$1.AnonymousClass1.C09411.invoke(com.angcyo.dsladapter.DslViewHolder, int, com.angcyo.dsladapter.DslAdapterItem, java.util.List):void");
                                }
                            }

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // Oox.oOoXoXO
                            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(DslAdapterItem dslAdapterItem) {
                                invoke2(dslAdapterItem);
                                return kotlin.oXIO0o0XI.f29392oIX0oI;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@OXOo.OOXIXo DslAdapterItem dslItem) {
                                kotlin.jvm.internal.IIX0o.x0xO0oo(dslItem, "$this$dslItem");
                                dslItem.setItemBindOverride(new C09411(AudioBookItem.this, audioBookLearnActivity));
                            }
                        });
                    }
                }
            });
            getDslAdapter().notifyDataChanged();
        }

        @Override // com.sma.smartv3.ui.device.BaseJLFileManageActivity
        public void upListData(@OXOo.OOXIXo BleAppAudioBookList filePath) {
            Collection ooXIXxIX2;
            Integer num;
            Object obj;
            String appGroupName;
            kotlin.jvm.internal.IIX0o.x0xO0oo(filePath, "filePath");
            this.mAudioBookItemFiles.clear();
            List<AppFileDetail> list = this.mAudioBookLearnList;
            if (list == null || (list != null && list.size() == 0)) {
                try {
                    JsonArray asJsonArray = JsonParser.parseString(com.sma.smartv3.util.Xo0.f24349oIX0oI.XO().getString(getMSDCardName())).getAsJsonArray();
                    kotlin.jvm.internal.IIX0o.ooOOo0oXI(asJsonArray);
                    ooXIXxIX2 = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(asJsonArray, 10));
                    Iterator<JsonElement> it = asJsonArray.iterator();
                    while (it.hasNext()) {
                        ooXIXxIX2.add(new Gson().fromJson(it.next(), AppFileDetail.class));
                    }
                } catch (Exception unused) {
                    ooXIXxIX2 = CollectionsKt__CollectionsKt.ooXIXxIX();
                }
                this.mAudioBookLearnList = CollectionsKt___CollectionsKt.o0Xo0XII(ooXIXxIX2);
            }
            OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
            StringBuilder sb = new StringBuilder();
            sb.append(this.TAG);
            sb.append(" mAudioBookLearnList = ");
            List<AppFileDetail> list2 = this.mAudioBookLearnList;
            if (list2 != null) {
                num = Integer.valueOf(list2.size());
            } else {
                num = null;
            }
            sb.append(num);
            sb.append("  mSDCardName = ");
            sb.append(getMSDCardName());
            oix0oi.oIX0oI(sb.toString());
            oix0oi.II0xO0(this.TAG + " filePath = " + filePath.getMList().size() + "  mSDCardName = " + filePath);
            for (BleFilePath bleFilePath : filePath.getMList()) {
                List<AppFileDetail> list3 = this.mAudioBookLearnList;
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(list3);
                Iterator<T> it2 = list3.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        obj = it2.next();
                        String appPackName = ((AppFileDetail) obj).getAppPackName();
                        Locale locale = Locale.ROOT;
                        String lowerCase = appPackName.toLowerCase(locale);
                        kotlin.jvm.internal.IIX0o.oO(lowerCase, "toLowerCase(...)");
                        String lowerCase2 = bleFilePath.getMName().toLowerCase(locale);
                        kotlin.jvm.internal.IIX0o.oO(lowerCase2, "toLowerCase(...)");
                        if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(lowerCase, lowerCase2)) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                AppFileDetail appFileDetail = (AppFileDetail) obj;
                if (appFileDetail != null) {
                    List<AudioBookItem> list4 = this.mAudioBookItemFiles;
                    String appPreImg = appFileDetail.getAppPreImg();
                    String appPackName2 = appFileDetail.getAppPackName();
                    if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(getMSDCardName(), DeviceFileManager.f21739X0o0xo)) {
                        appGroupName = appFileDetail.getAppName();
                    } else {
                        appGroupName = appFileDetail.getAppGroupName();
                    }
                    list4.add(new AudioBookItem(0, appGroupName, (int) (appFileDetail.getAppSize() * 1024), false, appPreImg, null, false, appPackName2, 0, 361, null));
                } else {
                    this.mAudioBookItemFiles.add(new AudioBookItem(0, bleFilePath.getMName(), bleFilePath.getMSize() / 1024, false, "", null, false, bleFilePath.getMName(), 0, 361, null));
                }
            }
            showList();
        }
    }
