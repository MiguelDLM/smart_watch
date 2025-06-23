package com.baidu.navisdk.ui.routeguide.model;

import XIXIX.OOXIXo;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes8.dex */
public class RGLaneInfoModel {
    public static final int CURRENT_MAX_LINE = 14;
    public static final int DEFAULT_ERROR_ID = 99;
    public static final int ENLARGE_TYPE = 100;
    public static final int LANE_SOURCE = 2;
    public static final int MAX_LINE_NUMBER = 16;
    public static final int NORMAL_LANE = 101;
    public static final String TAG = "com.baidu.navisdk.ui.routeguide.model.RGLaneInfoModel";
    public static RGLaneInfoModel mInstance = new RGLaneInfoModel();
    public int mAceUpdate;
    public int needDisplay;
    public RGLineItem[] mLaneLineList = new RGLineItem[16];
    public int mLineNumber = 0;
    public int mStartDist = 0;
    public int mRemainDist = 0;
    public int mID = 0;
    public double mX = OOXIXo.f3760XO;
    public double mY = OOXIXo.f3760XO;
    public int mDriveHabbit = 0;
    public boolean isLaneShow = false;
    private final HashMap<String, Integer> mImageMap = new HashMap<>();
    private final HashMap<String, String> mImageNameMap = new HashMap<>();
    public boolean isShow = false;
    public ArrayList<Integer> mImageIdList = new ArrayList<>();
    private final r mRGLaneInfoRightHandHelper = new r();

    private int getImageID(String str) {
        int i;
        if (this.mDriveHabbit == 1) {
            str = this.mRGLaneInfoRightHandHelper.a(str);
        }
        HashMap<String, Integer> hashMap = this.mImageMap;
        if (hashMap != null && hashMap.containsKey(str)) {
            i = this.mImageMap.get(str).intValue();
        } else {
            i = 99;
        }
        LogUtil.e(TAG, "getImageID id is " + i);
        return i;
    }

    private String getImageName(String str) {
        String str2;
        if (this.mDriveHabbit == 1) {
            str = this.mRGLaneInfoRightHandHelper.a(str);
        }
        HashMap<String, String> hashMap = this.mImageNameMap;
        if (hashMap != null && hashMap.containsKey(str)) {
            str2 = this.mImageNameMap.get(str);
        } else {
            str2 = null;
        }
        LogUtil.e(TAG, "getImageID id is " + str2);
        return str2;
    }

    public static RGLaneInfoModel getModel(boolean z) {
        if (z || mInstance == null) {
            mInstance = new RGLaneInfoModel();
        }
        return mInstance;
    }

    private void initImageNameMap() {
        this.mImageNameMap.put("011000000", "nsdk_ic_lane_turn_left_90");
        this.mImageNameMap.put("010000000", "nsdk_ic_lane_turn_left_90_gray");
        this.mImageNameMap.put("000110000", "nsdk_ic_lane_turn_right_90");
        this.mImageNameMap.put("000100000", "nsdk_ic_lane_turn_right_90_gray");
        this.mImageNameMap.put("000001100", "nsdk_ic_lane_straight");
        this.mImageNameMap.put("000001000", "nsdk_ic_lane_straight_gray");
        this.mImageNameMap.put("000000011", "nsdk_ic_lane_turn_around_left");
        this.mImageNameMap.put("000000010", "nsdk_ic_lane_turn_around_left_gray");
        this.mImageNameMap.put("010001000", "nsdk_ic_lane_2cross_left_straight_gray");
        this.mImageNameMap.put("011001000", "nsdk_ic_lane_2cross_turn_left");
        this.mImageNameMap.put("010001100", "nsdk_ic_lane_2cross_left_straight");
        this.mImageNameMap.put("000101000", "nsdk_ic_lane_2cross_right_straight_gray");
        this.mImageNameMap.put("000111000", "nsdk_ic_lane_2cross_turn_right");
        this.mImageNameMap.put("000101100", "nsdk_ic_lane_2cross_right_straight");
        this.mImageNameMap.put("010101000", "nsdk_ic_lane_3cross_gray");
        this.mImageNameMap.put("011101000", "nsdk_ic_lane_3cross_turn_left");
        this.mImageNameMap.put("010111000", "nsdk_ic_lane_3cross_turn_right");
        this.mImageNameMap.put("010101100", "nsdk_ic_lane_3cross_straight");
        this.mImageNameMap.put("010000010", "nsdk_ic_lane_around_and_left_gray");
        this.mImageNameMap.put("011000010", "nsdk_ic_lane_left_and_around");
        this.mImageNameMap.put("010000011", "nsdk_ic_lane_around_and_left");
        this.mImageNameMap.put("010100000", "nsdk_ic_lane_left_and_right_gray");
        this.mImageNameMap.put("011100000", "nsdk_ic_lane_left_and_right");
        this.mImageNameMap.put("010110000", "nsdk_ic_lane_right_and_left");
        this.mImageNameMap.put("000100010", "nsdk_ic_lane_around_and_right_gray");
        this.mImageNameMap.put("000110010", "nsdk_ic_lane_right_and_around");
        this.mImageNameMap.put("000100011", "nsdk_ic_lane_around_and_right");
        this.mImageNameMap.put("000001010", "nsdk_ic_lane_around_and_straight_gray");
        this.mImageNameMap.put("000001110", "nsdk_ic_lane_straight_and_around");
        this.mImageNameMap.put("000001011", "nsdk_ic_lane_around_and_straight");
        this.mImageNameMap.put("010100010", "nsdk_ic_lane_around_left_right_gray");
        this.mImageNameMap.put("011100010", "nsdk_ic_lane_left_around_right");
        this.mImageNameMap.put("010110010", "nsdk_ic_lane_right_around_left");
        this.mImageNameMap.put("010100011", "nsdk_ic_lane_around_left_right");
        this.mImageNameMap.put("010001010", "nsdk_ic_lane_around_left_straight_gray");
        this.mImageNameMap.put("011001010", "nsdk_ic_lane_left_around_straight");
        this.mImageNameMap.put("010001110", "nsdk_ic_lane_straight_left_around");
        this.mImageNameMap.put("010001011", "nsdk_ic_lane_around_left_straight");
        this.mImageNameMap.put("000101010", "nsdk_ic_lane_around_right_straight_gray");
        this.mImageNameMap.put("000111010", "nsdk_ic_lane_right_around_straight");
        this.mImageNameMap.put("000101110", "nsdk_ic_lane_straight_right_around");
        this.mImageNameMap.put("000101011", "nsdk_ic_lane_around_right_straight");
        this.mImageNameMap.put("010101010", "nsdk_ic_lane_around_left_right_straight_gray");
        this.mImageNameMap.put("011101010", "nsdk_ic_lane_left_around_right_straight");
        this.mImageNameMap.put("010111010", "nsdk_ic_lane_right_around_left_straight");
        this.mImageNameMap.put("010101110", "nsdk_ic_lane_straight_around_left_right");
        this.mImageNameMap.put("010101011", "nsdk_ic_lane_around_left_right_straight");
        this.mImageNameMap.put("111000000", "nsdk_ic_lane_bus_left");
        this.mImageNameMap.put("100110000", "nsdk_ic_lane_bus_right");
        this.mImageNameMap.put("100001100", "nsdk_ic_lane_bus_front");
        this.mImageNameMap.put("100000011", "nsdk_ic_lane_bus_back");
        this.mImageNameMap.put("210001000", "nsdk_ic_lane_bus_left_straight_gray");
        this.mImageNameMap.put("200101000", "nsdk_ic_lane_bus_right_straight_gray");
        this.mImageNameMap.put("210101000", "nsdk_ic_lane_bus_3cross_gray");
        this.mImageNameMap.put("210000010", "nsdk_ic_lane_bus_around_and_left_gray");
        this.mImageNameMap.put("200100010", "nsdk_ic_lane_bus_around_and_right_gray");
        this.mImageNameMap.put("200001010", "nsdk_ic_lane_bus_around_and_straight_gray");
        this.mImageNameMap.put("210100010", "nsdk_ic_lane_bus_around_left_right_gray");
        this.mImageNameMap.put("210001010", "nsdk_ic_lane_bus_around_left_straight_gray");
        this.mImageNameMap.put("200101010", "nsdk_ic_lane_bus_around_right_straight_gray");
        this.mImageNameMap.put("210100000", "nsdk_ic_lane_bus_left_and_right_gray");
        this.mImageNameMap.put("200001000", "nsdk_ic_lane_bus_straight_gray");
        this.mImageNameMap.put("200000010", "nsdk_ic_lane_bus_turn_around_left_gray");
        this.mImageNameMap.put("210000000", "nsdk_ic_lane_bus_turn_left_90_gray");
        this.mImageNameMap.put("200100000", "nsdk_ic_lane_bus_turn_right_90_gray");
    }

    private int parseSpecialLaneLine(RGLineItem rGLineItem) {
        boolean z;
        boolean z2;
        if (rGLineItem == null) {
            LogUtil.e(TAG, "parseSpecialLaneLine->item = null,return -1!");
            return -1;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "parseSpecialLaneLine->RGLineItem:" + rGLineItem.toString());
        }
        if (rGLineItem.isORNLane) {
            return R.drawable.nsdk_ic_lane_winter_olympic_text;
        }
        if (rGLineItem.isBusLaneTextBright) {
            return R.drawable.nsdk_ic_lane_bus_text;
        }
        if (rGLineItem.isVariableBright) {
            if (this.mAceUpdate == 0) {
                return R.drawable.nsdk_ic_lane_variable_bright;
            }
            if (rGLineItem.isLeftBright) {
                return R.drawable.nsdk_ic_lane_changable_left_bright;
            }
            if (rGLineItem.isRightBright) {
                return R.drawable.nsdk_ic_lane_changable_right_bright;
            }
            if (rGLineItem.isFrontBright) {
                return R.drawable.nsdk_ic_lane_changable_front_bright;
            }
            if (rGLineItem.isBackBright) {
                return R.drawable.nsdk_ic_lane_changable_back_bright;
            }
            return R.drawable.nsdk_ic_lane_variable_bright;
        }
        if (rGLineItem.isVariable) {
            if (this.mAceUpdate == 0) {
                return R.drawable.nsdk_ic_lane_variable;
            }
            boolean z3 = rGLineItem.isLeft;
            if ((z3 && rGLineItem.isRight) || ((z3 && rGLineItem.isFront) || ((z3 && rGLineItem.isBack) || (((z = rGLineItem.isRight) && rGLineItem.isBack) || ((z && rGLineItem.isFront) || ((z2 = rGLineItem.isFront) && rGLineItem.isBack)))))) {
                return R.drawable.nsdk_ic_lane_variable;
            }
            if (z3) {
                return R.drawable.nsdk_ic_lane_changable_left;
            }
            if (z) {
                return R.drawable.nsdk_ic_lane_changable_right;
            }
            if (z2) {
                return R.drawable.nsdk_ic_lane_changable_front;
            }
            if (rGLineItem.isBack) {
                return R.drawable.nsdk_ic_lane_changable_back;
            }
            return R.drawable.nsdk_ic_lane_variable;
        }
        if (rGLineItem.isHov) {
            return R.drawable.nsdk_ic_lane_hov;
        }
        if (rGLineItem.isHovBright) {
            return R.drawable.nsdk_ic_lane_hov_bright;
        }
        if (rGLineItem.isTidalTextBright) {
            return R.drawable.nsdk_ic_lane_tidal_text_bright;
        }
        if (rGLineItem.isTidalText) {
            return R.drawable.nsdk_ic_lane_tidal_text;
        }
        if (rGLineItem.isTidalAvailableBright) {
            return R.drawable.nsdk_ic_lane_tidal_available_bright;
        }
        if (rGLineItem.isTidalAvailable) {
            return R.drawable.nsdk_ic_lane_tidal_available;
        }
        if (rGLineItem.isTidalFrontBright) {
            if (rGLineItem.isLeft) {
                return R.drawable.nsdk_ic_lane_tidal_left_bright;
            }
            if (rGLineItem.isRight) {
                return R.drawable.nsdk_ic_lane_tidal_right_bright;
            }
            if (rGLineItem.isFront) {
                return R.drawable.nsdk_ic_lane_tidal_front_bright;
            }
            if (rGLineItem.isBack) {
                return R.drawable.nsdk_ic_lane_tidal_back_bright;
            }
        } else if (rGLineItem.isTidalFront) {
            if (rGLineItem.isLeft) {
                return R.drawable.nsdk_ic_lane_tidal_left;
            }
            if (rGLineItem.isRight) {
                return R.drawable.nsdk_ic_lane_tidal_right;
            }
            if (rGLineItem.isFront) {
                return R.drawable.nsdk_ic_lane_tidal_front;
            }
            if (rGLineItem.isBack) {
                return R.drawable.nsdk_ic_lane_tidal_back;
            }
        }
        return -1;
    }

    private String parseSpecialLaneLineToString(RGLineItem rGLineItem) {
        if (rGLineItem == null) {
            LogUtil.e(TAG, "parseSpecialLaneLine->item = null,return -1!");
            return null;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "parseSpecialLaneLine->RGLineItem:" + rGLineItem.toString());
        }
        if (rGLineItem.isORNLane) {
            return "nsdk_ic_lane_winter_olympic_text";
        }
        if (rGLineItem.isBusLaneTextBright) {
            return "nsdk_ic_lane_bus_text";
        }
        if (rGLineItem.isVariableBright) {
            return "nsdk_ic_lane_variable_bright";
        }
        if (rGLineItem.isVariable) {
            return "nsdk_ic_lane_variable";
        }
        if (rGLineItem.isHov) {
            return "nsdk_ic_lane_hov";
        }
        if (rGLineItem.isHovBright) {
            return "nsdk_ic_lane_hov_bright";
        }
        if (rGLineItem.isTidalTextBright) {
            return "nsdk_ic_lane_tidal_text_bright";
        }
        if (rGLineItem.isTidalText) {
            return "nsdk_ic_lane_tidal_text";
        }
        if (rGLineItem.isTidalAvailableBright) {
            return "nsdk_ic_lane_tidal_available_bright";
        }
        if (rGLineItem.isTidalAvailable) {
            return "nsdk_ic_lane_tidal_available";
        }
        if (rGLineItem.isTidalFrontBright) {
            if (rGLineItem.isLeft) {
                return "nsdk_ic_lane_tidal_left_bright";
            }
            if (rGLineItem.isRight) {
                return "nsdk_ic_lane_tidal_right_bright";
            }
            if (rGLineItem.isFront) {
                return "nsdk_ic_lane_tidal_front_bright";
            }
            if (rGLineItem.isBack) {
                return "nsdk_ic_lane_tidal_back_bright";
            }
        } else if (rGLineItem.isTidalFront) {
            if (rGLineItem.isLeft) {
                return "nsdk_ic_lane_tidal_left";
            }
            if (rGLineItem.isRight) {
                return "nsdk_ic_lane_tidal_right";
            }
            if (rGLineItem.isFront) {
                return "nsdk_ic_lane_tidal_front";
            }
            if (rGLineItem.isBack) {
                return "nsdk_ic_lane_tidal_back";
            }
        }
        return null;
    }

    public void cloneData(RGLineItem[] rGLineItemArr) {
        if (rGLineItemArr != null && rGLineItemArr.length > 0) {
            for (int i = 0; i < rGLineItemArr.length; i++) {
                this.mLaneLineList[i] = rGLineItemArr[i];
                LogUtil.e(TAG, "cloneData is " + this.mLaneLineList[i].toString());
            }
            LogUtil.e(TAG, "cloneData size = " + this.mLaneLineList.length);
        }
    }

    public int getDriveHabbit() {
        RGLaneInfoModel rGLaneInfoModel = mInstance;
        if (rGLaneInfoModel != null) {
            return rGLaneInfoModel.mDriveHabbit;
        }
        return 0;
    }

    public int getImageIDFromItem(RGLineItem rGLineItem) {
        int parseSpecialLaneLine = parseSpecialLaneLine(rGLineItem);
        if (parseSpecialLaneLine > -1) {
            return parseSpecialLaneLine;
        }
        return getImageID(parseItem(rGLineItem));
    }

    public String getImageNameFromItem(RGLineItem rGLineItem) {
        String parseSpecialLaneLineToString = parseSpecialLaneLineToString(rGLineItem);
        if (parseSpecialLaneLineToString != null) {
            return parseSpecialLaneLineToString;
        }
        return getImageName(parseItem(rGLineItem));
    }

    public void initMap() {
        if (this.mImageMap.size() > 0) {
            return;
        }
        this.mImageMap.put("011000000", Integer.valueOf(R.drawable.nsdk_ic_lane_turn_left_90));
        this.mImageMap.put("010000000", Integer.valueOf(R.drawable.nsdk_ic_lane_turn_left_90_gray));
        this.mImageMap.put("000110000", Integer.valueOf(R.drawable.nsdk_ic_lane_turn_right_90));
        this.mImageMap.put("000100000", Integer.valueOf(R.drawable.nsdk_ic_lane_turn_right_90_gray));
        this.mImageMap.put("000001100", Integer.valueOf(R.drawable.nsdk_ic_lane_straight));
        this.mImageMap.put("000001000", Integer.valueOf(R.drawable.nsdk_ic_lane_straight_gray));
        this.mImageMap.put("000000011", Integer.valueOf(R.drawable.nsdk_ic_lane_turn_around_left));
        this.mImageMap.put("000000010", Integer.valueOf(R.drawable.nsdk_ic_lane_turn_around_left_gray));
        this.mImageMap.put("010001000", Integer.valueOf(R.drawable.nsdk_ic_lane_2cross_left_straight_gray));
        this.mImageMap.put("011001000", Integer.valueOf(R.drawable.nsdk_ic_lane_2cross_turn_left));
        this.mImageMap.put("010001100", Integer.valueOf(R.drawable.nsdk_ic_lane_2cross_left_straight));
        this.mImageMap.put("011001100", Integer.valueOf(R.drawable.nsdk_ic_lane_2cross_left_straight_bright));
        this.mImageMap.put("000101000", Integer.valueOf(R.drawable.nsdk_ic_lane_2cross_right_straight_gray));
        this.mImageMap.put("000111000", Integer.valueOf(R.drawable.nsdk_ic_lane_2cross_turn_right));
        this.mImageMap.put("000101100", Integer.valueOf(R.drawable.nsdk_ic_lane_2cross_right_straight));
        this.mImageMap.put("000111100", Integer.valueOf(R.drawable.nsdk_ic_lane_2cross_right_straight_bright));
        this.mImageMap.put("010101000", Integer.valueOf(R.drawable.nsdk_ic_lane_3cross_gray));
        this.mImageMap.put("011101000", Integer.valueOf(R.drawable.nsdk_ic_lane_3cross_turn_left));
        this.mImageMap.put("010111000", Integer.valueOf(R.drawable.nsdk_ic_lane_3cross_turn_right));
        this.mImageMap.put("010101100", Integer.valueOf(R.drawable.nsdk_ic_lane_3cross_straight));
        this.mImageMap.put("011111100", Integer.valueOf(R.drawable.nsdk_ic_lane_3cross_bright));
        this.mImageMap.put("010000010", Integer.valueOf(R.drawable.nsdk_ic_lane_around_and_left_gray));
        this.mImageMap.put("011000010", Integer.valueOf(R.drawable.nsdk_ic_lane_left_and_around));
        this.mImageMap.put("010000011", Integer.valueOf(R.drawable.nsdk_ic_lane_around_and_left));
        this.mImageMap.put("011000011", Integer.valueOf(R.drawable.nsdk_ic_lane_around_and_left_bright));
        this.mImageMap.put("010100000", Integer.valueOf(R.drawable.nsdk_ic_lane_left_and_right_gray));
        this.mImageMap.put("011100000", Integer.valueOf(R.drawable.nsdk_ic_lane_left_and_right));
        this.mImageMap.put("010110000", Integer.valueOf(R.drawable.nsdk_ic_lane_right_and_left));
        this.mImageMap.put("011110000", Integer.valueOf(R.drawable.nsdk_ic_lane_left_and_right_bright));
        this.mImageMap.put("000100010", Integer.valueOf(R.drawable.nsdk_ic_lane_around_and_right_gray));
        this.mImageMap.put("000110010", Integer.valueOf(R.drawable.nsdk_ic_lane_right_and_around));
        this.mImageMap.put("000100011", Integer.valueOf(R.drawable.nsdk_ic_lane_around_and_right));
        this.mImageMap.put("000110011", Integer.valueOf(R.drawable.nsdk_ic_lane_around_and_right_bright));
        this.mImageMap.put("000001010", Integer.valueOf(R.drawable.nsdk_ic_lane_around_and_straight_gray));
        this.mImageMap.put("000001110", Integer.valueOf(R.drawable.nsdk_ic_lane_straight_and_around));
        this.mImageMap.put("000001011", Integer.valueOf(R.drawable.nsdk_ic_lane_around_and_straight));
        this.mImageMap.put("000001111", Integer.valueOf(R.drawable.nsdk_ic_lane_around_and_straight_bright));
        this.mImageMap.put("010100010", Integer.valueOf(R.drawable.nsdk_ic_lane_around_left_right_gray));
        this.mImageMap.put("011100010", Integer.valueOf(R.drawable.nsdk_ic_lane_left_around_right));
        this.mImageMap.put("010110010", Integer.valueOf(R.drawable.nsdk_ic_lane_right_around_left));
        this.mImageMap.put("010100011", Integer.valueOf(R.drawable.nsdk_ic_lane_around_left_right));
        this.mImageMap.put("011110011", Integer.valueOf(R.drawable.nsdk_ic_lane_around_left_right_bright));
        this.mImageMap.put("010001010", Integer.valueOf(R.drawable.nsdk_ic_lane_around_left_straight_gray));
        this.mImageMap.put("011001010", Integer.valueOf(R.drawable.nsdk_ic_lane_left_around_straight));
        this.mImageMap.put("010001110", Integer.valueOf(R.drawable.nsdk_ic_lane_straight_left_around));
        this.mImageMap.put("010001011", Integer.valueOf(R.drawable.nsdk_ic_lane_around_left_straight));
        this.mImageMap.put("011001111", Integer.valueOf(R.drawable.nsdk_ic_lane_around_left_straight_bright));
        this.mImageMap.put("000101010", Integer.valueOf(R.drawable.nsdk_ic_lane_around_right_straight_gray));
        this.mImageMap.put("000111010", Integer.valueOf(R.drawable.nsdk_ic_lane_right_around_straight));
        this.mImageMap.put("000101110", Integer.valueOf(R.drawable.nsdk_ic_lane_straight_right_around));
        this.mImageMap.put("000101011", Integer.valueOf(R.drawable.nsdk_ic_lane_around_right_straight));
        this.mImageMap.put("000111111", Integer.valueOf(R.drawable.nsdk_ic_lane_around_right_straight_bright));
        this.mImageMap.put("010101010", Integer.valueOf(R.drawable.nsdk_ic_lane_around_left_right_straight_gray));
        this.mImageMap.put("011101010", Integer.valueOf(R.drawable.nsdk_ic_lane_left_around_right_straight));
        this.mImageMap.put("010111010", Integer.valueOf(R.drawable.nsdk_ic_lane_right_around_left_straight));
        this.mImageMap.put("010101110", Integer.valueOf(R.drawable.nsdk_ic_lane_straight_around_left_right));
        this.mImageMap.put("010101011", Integer.valueOf(R.drawable.nsdk_ic_lane_around_left_right_straight));
        this.mImageMap.put("011111111", Integer.valueOf(R.drawable.nsdk_ic_lane_around_left_right_straight_bright));
        HashMap<String, Integer> hashMap = this.mImageMap;
        int i = R.drawable.nsdk_ic_lane_bus_straight_gray;
        hashMap.put("200001000", Integer.valueOf(i));
        this.mImageMap.put("100001100", Integer.valueOf(R.drawable.nsdk_ic_lane_bus_front));
        HashMap<String, Integer> hashMap2 = this.mImageMap;
        int i2 = R.drawable.nsdk_ic_lane_bus_turn_around_left_gray;
        hashMap2.put("200000010", Integer.valueOf(i2));
        this.mImageMap.put("100000011", Integer.valueOf(R.drawable.nsdk_ic_lane_bus_back));
        HashMap<String, Integer> hashMap3 = this.mImageMap;
        int i3 = R.drawable.nsdk_ic_lane_bus_turn_left_90_gray;
        hashMap3.put("210000000", Integer.valueOf(i3));
        this.mImageMap.put("111000000", Integer.valueOf(R.drawable.nsdk_ic_lane_bus_left));
        HashMap<String, Integer> hashMap4 = this.mImageMap;
        int i4 = R.drawable.nsdk_ic_lane_bus_turn_right_90_gray;
        hashMap4.put("200100000", Integer.valueOf(i4));
        this.mImageMap.put("100110000", Integer.valueOf(R.drawable.nsdk_ic_lane_bus_right));
        this.mImageMap.put("210001000", Integer.valueOf(R.drawable.nsdk_ic_lane_bus_left_straight_gray));
        this.mImageMap.put("111001100", Integer.valueOf(R.drawable.nsdk_ic_lane_bus_2cross_left_straight_bright));
        this.mImageMap.put("200101000", Integer.valueOf(R.drawable.nsdk_ic_lane_bus_right_straight_gray));
        this.mImageMap.put("100111100", Integer.valueOf(R.drawable.nsdk_ic_lane_bus_2cross_right_straight_bright));
        this.mImageMap.put("210101000", Integer.valueOf(R.drawable.nsdk_ic_lane_bus_3cross_gray));
        this.mImageMap.put("111111100", Integer.valueOf(R.drawable.nsdk_ic_lane_bus_3cross_bright));
        this.mImageMap.put("210000010", Integer.valueOf(R.drawable.nsdk_ic_lane_bus_around_and_left_gray));
        this.mImageMap.put("111000011", Integer.valueOf(R.drawable.nsdk_ic_lane_bus_around_and_left_bright));
        this.mImageMap.put("200100010", Integer.valueOf(R.drawable.nsdk_ic_lane_bus_around_and_right_gray));
        this.mImageMap.put("100110011", Integer.valueOf(R.drawable.nsdk_ic_lane_bus_around_and_right_bright));
        this.mImageMap.put("200001010", Integer.valueOf(R.drawable.nsdk_ic_lane_bus_around_and_straight_gray));
        this.mImageMap.put("100001111", Integer.valueOf(R.drawable.nsdk_ic_lane_bus_around_and_straight_bright));
        this.mImageMap.put("210100010", Integer.valueOf(R.drawable.nsdk_ic_lane_bus_around_left_right_gray));
        this.mImageMap.put("111110011", Integer.valueOf(R.drawable.nsdk_ic_lane_bus_around_left_right_bright));
        this.mImageMap.put("210001010", Integer.valueOf(R.drawable.nsdk_ic_lane_bus_around_left_straight_gray));
        this.mImageMap.put("111001111", Integer.valueOf(R.drawable.nsdk_ic_lane_bus_around_left_straight_bright));
        this.mImageMap.put("200101010", Integer.valueOf(R.drawable.nsdk_ic_lane_bus_around_right_straight_gray));
        this.mImageMap.put("100111111", Integer.valueOf(R.drawable.nsdk_ic_lane_bus_around_right_straight_bright));
        this.mImageMap.put("210100000", Integer.valueOf(R.drawable.nsdk_ic_lane_bus_left_and_right_gray));
        this.mImageMap.put("200001000", Integer.valueOf(i));
        this.mImageMap.put("200000010", Integer.valueOf(i2));
        this.mImageMap.put("210000000", Integer.valueOf(i3));
        this.mImageMap.put("200100000", Integer.valueOf(i4));
        this.mImageMap.put("111110000", Integer.valueOf(R.drawable.nsdk_ic_lane_bus_left_and_right_bright));
        initImageNameMap();
    }

    public boolean isNeedDisplay(int i) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(TAG, "isNeedDisplay: " + i);
        }
        if ((this.needDisplay & i) == i) {
            return true;
        }
        return false;
    }

    public boolean isShowLaneLineView() {
        if (this.isShow && this.isLaneShow) {
            return true;
        }
        return false;
    }

    public String parseItem(RGLineItem rGLineItem) {
        int i;
        if (rGLineItem == null) {
            return "0";
        }
        StringBuffer stringBuffer = new StringBuffer();
        boolean z = rGLineItem.isBusLaneBright;
        if (z && rGLineItem.isBusLine) {
            i = 1;
        } else if (rGLineItem.isBusLine && !z) {
            i = 2;
        } else {
            i = 0;
        }
        stringBuffer.append(i);
        stringBuffer.append(rGLineItem.isLeft ? 1 : 0);
        stringBuffer.append(rGLineItem.isLeftBright ? 1 : 0);
        stringBuffer.append(rGLineItem.isRight ? 1 : 0);
        stringBuffer.append(rGLineItem.isRightBright ? 1 : 0);
        stringBuffer.append(rGLineItem.isFront ? 1 : 0);
        stringBuffer.append(rGLineItem.isFrontBright ? 1 : 0);
        stringBuffer.append(rGLineItem.isBack ? 1 : 0);
        stringBuffer.append(rGLineItem.isBackBright ? 1 : 0);
        LogUtil.e(TAG, "parseItemToLong long is " + stringBuffer.toString());
        return stringBuffer.toString();
    }

    public String toString() {
        return String.format("[%d,%d,%d,%b,%d]", Integer.valueOf(this.mLineNumber), Integer.valueOf(this.mStartDist), Integer.valueOf(this.mID), Boolean.valueOf(this.isLaneShow), Integer.valueOf(this.needDisplay));
    }
}
