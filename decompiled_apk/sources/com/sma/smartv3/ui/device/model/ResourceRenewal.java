package com.sma.smartv3.ui.device.model;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.blankj.utilcode.util.LogUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.AppFileDetail;
import com.sma.smartv3.model.AppStoreFileList;
import com.sma.smartv3.model.AppStoreFileManager;
import com.sma.smartv3.util.UtilsKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.oXIO0o0XI;

/* loaded from: classes12.dex */
public final class ResourceRenewal extends ViewModel {

    @OOXIXo
    public static final oIX0oI Companion = new oIX0oI(null);
    public static final int QURAN_AUDIO = 1;
    public static final int QURAN_TEXT = 0;
    public static final int RESOURCE_RENEWAL = -1;
    public static final int SACRAL_PUNISHMENT = 2;

    @OOXIXo
    private final MutableLiveData<ArrayList<AppFileDetail>> renewalLiveData = new MutableLiveData<>();

    /* loaded from: classes12.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(IIXOooo iIXOooo) {
            this();
        }

        public oIX0oI() {
        }
    }

    private final void getQuranAudioData(int i) {
        postData(i);
    }

    private final void getQuranTextData(int i) {
        postData(i);
    }

    private final void getResourceRenewalData() {
        ArrayList<AppFileDetail> arrayList = new ArrayList<>();
        arrayList.add(new AppFileDetail(UtilsKt.oI0IIXIo(R.string.quran_text), "0", XIXIX.OOXIXo.f3760XO, 0L, null, null, null, null, null, null, null, null, false, 8188, null));
        arrayList.add(new AppFileDetail(UtilsKt.oI0IIXIo(R.string.quran_audio), "1", XIXIX.OOXIXo.f3760XO, 0L, null, null, null, null, null, null, null, null, false, 8188, null));
        arrayList.add(new AppFileDetail(UtilsKt.oI0IIXIo(R.string.sacral_punishment), "2", XIXIX.OOXIXo.f3760XO, 0L, null, null, null, null, null, null, null, null, false, 8188, null));
        this.renewalLiveData.postValue(arrayList);
    }

    private final void getSacralPunishmentData(int i) {
        postData(i);
    }

    private final void postData(final int i) {
        AppStoreFileManager.INSTANCE.getAppStoreFileList("4", new oOoXoXO<List<? extends AppStoreFileList>, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.model.ResourceRenewal$postData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(List<? extends AppStoreFileList> list) {
                invoke2((List<AppStoreFileList>) list);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.oOoXoXO List<AppStoreFileList> list) {
                if (list != null) {
                    LogUtils.i("postData " + list.size() + TokenParser.SP + i + ':');
                    ArrayList<AppFileDetail> arrayList = new ArrayList<>();
                    int i2 = i;
                    for (AppStoreFileList appStoreFileList : list) {
                        AppFileDetail[] appx = appStoreFileList.getAppx();
                        if (appx != null) {
                            for (AppFileDetail appFileDetail : appx) {
                                if (IIX0o.Oxx0IOOO(String.valueOf(i2 + 1), appStoreFileList.getGroupId())) {
                                    arrayList.add(appFileDetail);
                                }
                            }
                        }
                    }
                    this.getRenewalLiveData().postValue(arrayList);
                    return;
                }
                this.getRenewalLiveData().postValue(new ArrayList<>());
            }
        });
    }

    public final void downloadFile(int i, @OOXIXo AppFileDetail appFileDetail) {
        IIX0o.x0xO0oo(appFileDetail, "appFileDetail");
        String appPack = appFileDetail.getAppPack();
        if (appPack != null) {
            AppStoreFileManager.downloadAppFile$default(AppStoreFileManager.INSTANCE, appPack, appFileDetail.getAppPackName(), getBleType(i), 0, 8, null);
        }
    }

    public final int getBleType(int i) {
        if (i == 0) {
            return 5;
        }
        if (i != 1) {
            return i != 2 ? 5 : 7;
        }
        return 6;
    }

    public final void getData(int i) {
        if (i != -1) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        getResourceRenewalData();
                        return;
                    } else {
                        getSacralPunishmentData(i);
                        return;
                    }
                }
                getQuranAudioData(i);
                return;
            }
            getQuranTextData(i);
            return;
        }
        getResourceRenewalData();
    }

    public final int getLayoutId(int i) {
        return i == -1 ? R.layout.item_resource_renewal_list : R.layout.item_quran_list;
    }

    @OOXIXo
    public final MutableLiveData<ArrayList<AppFileDetail>> getRenewalLiveData() {
        return this.renewalLiveData;
    }

    @OOXIXo
    public final String getTitleString(int i) {
        if (i != -1) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        return UtilsKt.oI0IIXIo(R.string.resource_renewal);
                    }
                    return UtilsKt.oI0IIXIo(R.string.sacral_punishment);
                }
                return UtilsKt.oI0IIXIo(R.string.quran_audio);
            }
            return UtilsKt.oI0IIXIo(R.string.quran_text);
        }
        return UtilsKt.oI0IIXIo(R.string.resource_renewal);
    }
}
