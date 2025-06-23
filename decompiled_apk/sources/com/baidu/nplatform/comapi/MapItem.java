package com.baidu.nplatform.comapi;

import android.os.Bundle;
import java.io.Serializable;

/* loaded from: classes8.dex */
public class MapItem implements Serializable {
    public static final int INDOOR_PARK_AVAILABLE = 5;
    public static final int INDOOR_PARK_OCCUPATION = 6;
    public static final int INDOOR_PARK_UNKNOWN = 7;
    public static final String KEY_BZID = "bzid";
    public static final String KEY_CHAT_ID = "chatid";
    public static final String KEY_CLICK_TAG = "tag";
    public static final String KEY_CLICK_TYPE = "eClickType";
    public static final String KEY_CUR_ROUTE_INDEX = "nCurRouteIdx";
    public static final String KEY_EXT = "ext";
    public static final String KEY_INDOOR_PARK_GEO = "geo";
    public static final String KEY_IS_EXPAND = "isExpand";
    public static final String KEY_IS_INDOOR_PARK = "indoorpoi";
    public static final String KEY_IS_MAP_ITEM = "navi";
    public static final String KEY_ITEM_ID = "in";
    public static final String KEY_ITEM_SID = "sid";
    public static final String KEY_ITEM_TYPE = "ty";
    public static final String KEY_JAM_INDEX = "jamIndex";
    public static final String KEY_LABEL_CLICK_TYPE = "labelClickType";
    public static final String KEY_LATITUDE = "fLatitude";
    public static final String KEY_LONGITUDE = "fLongitude";
    public static final String KEY_ONLINE_TYPE = "onlineType";
    public static final String KEY_TITLE = "tx";
    public static final String KEY_UID = "ud";
    public static final int MAP_ITEM_CLICK_TAG_ADD = 1;
    public static final int MAP_ITEM_CLICK_TAG_DEFAULT = 0;
    public static final int MAP_ITEM_CLICK_TAG_PANORAMA = 2;
    public static final int NE_Map_Item_Msg_Car = 2;
    public static final int NE_Map_Item_Msg_Label = 0;
    public static final int NE_Map_Item_Msg_Route = 1;
    public static final int NE_Map_item_Route_Explain = 8;
    public static final int NE_Map_item_Route_Explain_Bubble = 10;
    private static final long serialVersionUID = 1;
    public String chatId;
    public Bundle mBundleParams;
    public int mBzid;
    public int mClickTag;
    public int mClickType = 1;
    public int mCurRouteIdx;
    public long mEventId;
    public boolean mIsExpand;
    public boolean mIsIndoorpoi;
    public int mItemID;
    public String mItemSID;
    public int mItemType;
    public int mJamIndex;
    public int mLabelClickType;
    public int mLatitude;
    public double mLatitudeMc;
    public int mLongitude;
    public double mLongitudeMc;
    public int mOnlineType;
    public String mTitle;
    public String mUid;
    public int nFrom;

    public String toString() {
        return "MapItem{mItemID=" + this.mItemID + ", mItemSID=" + this.mItemSID + ", mItemType=" + this.mItemType + ", mUid='" + this.mUid + "', mEventId='" + this.mEventId + "', mTitle='" + this.mTitle + "', mLongitude=" + this.mLongitude + ", mLatitude=" + this.mLatitude + ", mCurRouteIdx=" + this.mCurRouteIdx + ", mClickType=" + this.mClickType + ", mLongitudeMc=" + this.mLongitudeMc + ", mLatitudeMc=" + this.mLatitudeMc + ", mLabelClickType=" + this.mLabelClickType + ", mIsExpand=" + this.mIsExpand + ", mJamIndex=" + this.mJamIndex + ", mBundleParams=" + this.mBundleParams + ", mIsIndoorpoi=" + this.mIsIndoorpoi + ", mOnlineType=" + this.mOnlineType + ", mBzid=" + this.mBzid + ", mClickTag=" + this.mClickTag + '}';
    }
}
