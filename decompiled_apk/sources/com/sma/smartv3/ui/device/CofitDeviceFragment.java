package com.sma.smartv3.ui.device;

import android.content.Intent;
import android.view.View;
import com.angcyo.dsladapter.DslAdapterItem;
import com.blankj.utilcode.util.BarUtils;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.ui.device.item.AGPSUpgradeItem;
import com.sma.smartv3.ui.device.item.AudioBookLearnItem;
import com.sma.smartv3.ui.device.item.BacCalibrationItem;
import com.sma.smartv3.ui.device.item.BaseDeviceItem;
import com.sma.smartv3.ui.device.item.CofitListItem;
import com.sma.smartv3.ui.device.item.EBookManagerItem;
import com.sma.smartv3.ui.device.item.EarphoneItem;
import com.sma.smartv3.ui.device.item.FirmwareItem;
import com.sma.smartv3.ui.device.item.GameStoreItem;
import com.sma.smartv3.ui.device.item.HardWareAlipayItem;
import com.sma.smartv3.ui.device.item.InfoItem;
import com.sma.smartv3.ui.device.item.LanguageItem;
import com.sma.smartv3.ui.device.item.LearnCardItem;
import com.sma.smartv3.ui.device.item.MemoryManagerItem;
import com.sma.smartv3.ui.device.item.MusicManagerItem;
import com.sma.smartv3.ui.device.item.NFCGuideItem;
import com.sma.smartv3.ui.device.item.NavigationItem;
import com.sma.smartv3.ui.device.item.RecordingItem;
import com.sma.smartv3.ui.device.item.RemoteCameraItem;
import com.sma.smartv3.ui.device.item.SOSManagerItem;
import com.sma.smartv3.ui.device.item.ScheduleItem;
import com.sma.smartv3.ui.device.item.SplitLine4DPItem;
import com.sma.smartv3.ui.device.item.StockMarketItem;
import com.sma.smartv3.ui.device.item.SyncContactItem;
import com.sma.smartv3.ui.device.item.TouchSetItem;
import com.sma.smartv3.ui.device.item.VoiceItem;
import com.sma.smartv3.ui.device.item.WatchPasswordItem;
import com.sma.smartv3.ui.device.item.WorldClockItem;
import com.sma.smartv3.ui.me.DeveloperBacCalibrationActivity;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* loaded from: classes12.dex */
public final class CofitDeviceFragment extends DeviceFragment {
    @Override // com.sma.smartv3.ui.device.DeviceFragment
    @OXOo.OOXIXo
    public List<DslAdapterItem> getItems() {
        InfoItem infoItem = getInfoItem();
        EarphoneItem earphoneItem = getEarphoneItem();
        GameStoreItem gameStoreItem = getGameStoreItem();
        CofitListItem cofitListItem = new CofitListItem();
        cofitListItem.setItems(CollectionsKt__CollectionsKt.XOxIOxOx(getClassicPairItem(), getQiblaItem(), getDialItem(), getMessagePushItem()));
        kotlin.oXIO0o0XI oxio0o0xi = kotlin.oXIO0o0XI.f29392oIX0oI;
        CofitListItem cofitListItem2 = new CofitListItem();
        cofitListItem2.setItems(CollectionsKt__CollectionsKt.XOxIOxOx(getAppStoreItem(), getIncomingCallItem(), getAntiLostItem(), getNoDisturbItem(), getNoDisturb2Item(), getAlarmClockItem(), getGameTimeSetItem(), getMedicationAlarmItem(), getSedentarinessItem(), getDrinkWaterItem(), getBloodOxyGenItem(), getWashItem(), getMeasureUnitItem(), getDateFormatItem(), getTimeFormatItem(), getPressureItem(), getStandbyWatchFaceItem(), getDoubleClickScreenItem()));
        CofitListItem cofitListItem3 = new CofitListItem();
        cofitListItem3.setItems(CollectionsKt__CollectionsKt.XOxIOxOx(getShockItem(), getShockSettingsItem(), getBackLightItem(), getGestureWakeItem(), getGestureWake2Item(), getWearWayItem(), getHrMonitoringItem(), getEcgMonitoringItem(), getTempMonitoringItem(), getMusicControlItem(), getGameSettingsItem(), getNotificationLightScreenItem(), getFindWatchItem(), getSmsQuickReplyItem()));
        CofitListItem cofitListItem4 = new CofitListItem();
        ScheduleItem scheduleItem = getScheduleItem();
        RecordingItem recordingItem = getRecordingItem();
        BaseDeviceItem girlCareItem = getGirlCareItem();
        RemoteCameraItem remoteCameraItem = getRemoteCameraItem();
        LanguageItem languageItem = getLanguageItem();
        TouchSetItem touchSetItem = getTouchSetItem();
        FirmwareItem firmwareItem = getFirmwareItem();
        MemoryManagerItem memoryManagerItem = getMemoryManagerItem();
        AGPSUpgradeItem aGPSUpgradeItem = getAGPSUpgradeItem();
        SyncContactItem syncContactItem = getSyncContactItem();
        BaseDeviceItem macQrcodeItem = getMacQrcodeItem();
        StockMarketItem stockMarketItem = getStockMarketItem();
        WorldClockItem worldClockItem = getWorldClockItem();
        BaseDeviceItem logoFileItem = getLogoFileItem();
        WatchPasswordItem watchPasswordItem = getWatchPasswordItem();
        BaseDeviceItem powerSaveModeItem = getPowerSaveModeItem();
        BaseDeviceItem standbySetItem = getStandbySetItem();
        BaseDeviceItem alipaySetItem = getAlipaySetItem();
        HardWareAlipayItem hardWareAlipay = getHardWareAlipay();
        NavigationItem navigationItem = getNavigationItem();
        VoiceItem voiceItem = getVoiceItem();
        SOSManagerItem sosManagerItem = getSosManagerItem();
        LearnCardItem learnCardItem = getLearnCardItem();
        AudioBookLearnItem audioBookLearnItem = getAudioBookLearnItem();
        MusicManagerItem musicManagerItem = getMusicManagerItem();
        EBookManagerItem ebookManagerItem = getEbookManagerItem();
        NFCGuideItem nfcGuideItem = getNfcGuideItem();
        BaseDeviceItem incomingCallRingItem = getIncomingCallRingItem();
        BacCalibrationItem bacCalibrationItem = new BacCalibrationItem();
        bacCalibrationItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.CofitDeviceFragment$getItems$4$1$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                invoke2(view);
                return kotlin.oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo View it) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                CofitDeviceFragment cofitDeviceFragment = CofitDeviceFragment.this;
                cofitDeviceFragment.startActivity(new Intent(cofitDeviceFragment.getActivity(), (Class<?>) DeveloperBacCalibrationActivity.class));
            }
        });
        cofitListItem4.setItems(CollectionsKt__CollectionsKt.XOxIOxOx(scheduleItem, recordingItem, girlCareItem, remoteCameraItem, languageItem, touchSetItem, firmwareItem, memoryManagerItem, aGPSUpgradeItem, syncContactItem, macQrcodeItem, stockMarketItem, worldClockItem, logoFileItem, watchPasswordItem, powerSaveModeItem, standbySetItem, alipaySetItem, hardWareAlipay, navigationItem, voiceItem, sosManagerItem, learnCardItem, audioBookLearnItem, musicManagerItem, ebookManagerItem, nfcGuideItem, incomingCallRingItem, bacCalibrationItem, getIncomingCallRingVibrationItem(), getResetItem()));
        CofitListItem cofitListItem5 = new CofitListItem();
        cofitListItem5.setItems(CollectionsKt__CollectionsKt.XOxIOxOx(getNucleicAcidCodeItem(), getMyCardCodeItem(), getMyCardCode2Item(), getReceiptCodeItem(), getReceiptCode2Item()));
        return CollectionsKt__CollectionsKt.XOxIOxOx(infoItem, earphoneItem, gameStoreItem, cofitListItem, cofitListItem2, cofitListItem3, cofitListItem4, cofitListItem5, getUnpairItem());
    }

    @Override // com.sma.smartv3.ui.device.DeviceFragment
    @OXOo.OOXIXo
    public List<DslAdapterItem> getRingItems() {
        InfoItem infoItem = getInfoItem();
        SplitLine4DPItem splitLine4DPItem = new SplitLine4DPItem();
        CofitListItem cofitListItem = new CofitListItem();
        cofitListItem.setItems(CollectionsKt__CollectionsKt.XOxIOxOx(getHrMonitoringItem(), getBloodOxyGenItem(), getPressureItem()));
        kotlin.oXIO0o0XI oxio0o0xi = kotlin.oXIO0o0XI.f29392oIX0oI;
        SplitLine4DPItem splitLine4DPItem2 = new SplitLine4DPItem();
        CofitListItem cofitListItem2 = new CofitListItem();
        cofitListItem2.setItems(CollectionsKt__CollectionsKt.XOxIOxOx(getTouchSetItem(), getFirmwareItem(), getResetItem(), getShutdownItem()));
        return CollectionsKt__CollectionsKt.XOxIOxOx(infoItem, splitLine4DPItem, cofitListItem, splitLine4DPItem2, cofitListItem2, getUnpairItem());
    }

    @Override // com.sma.smartv3.ui.device.DeviceFragment, com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragment, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        BarUtils.addMarginTopEqualStatusBarHeight(getMView().findViewById(R.id.rv));
    }

    @Override // com.sma.smartv3.ui.device.DeviceFragment, com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.cofit_fragment_rv;
    }
}
