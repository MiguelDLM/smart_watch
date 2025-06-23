package com.baidu.mapclient.liteapp;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.navisdk.adapter.BNRoutePlanNode;
import com.baidu.navisdk.adapter.BaiduNaviManagerFactory;
import com.baidu.navisdk.adapter.struct.BNMotorInfo;
import com.baidu.navisdk.adapter.struct.BNTruckInfo;

/* loaded from: classes7.dex */
public class BNFactory {
    public static final int AXLES_NUMBER = 6;
    public static final int AXLES_WEIGHT = 100;
    public static final double DOUBLE = 0.5d;
    public static final int HEIGHT = 10;
    public static final double LATITUDE = 40.04169d;
    public static final double LATITUDE1 = 39.90856d;
    public static final int LENGTH = 25;
    public static final int LOAD_WEIGHT = 80;
    public static final double LONGITUDE = 116.306333d;
    public static final double LONGITUDE1 = 116.397609d;
    public static final String NAME = "百度大厦";
    public static final String NAME1 = "北京天安门";
    public static final String OIL_COST = "40000";
    public static final int WEIGHT = 100;
    public static final float WIDTH = 5.0f;
    private BNRoutePlanNode endNode;
    private BNRoutePlanNode startNode;

    /* loaded from: classes7.dex */
    public static class Holder {
        private static BNFactory instance = new BNFactory();

        private Holder() {
        }
    }

    public static BNFactory getInstance() {
        return Holder.instance;
    }

    public BNRoutePlanNode getCurrentNode(Context context, float f) {
        String string = BNUtils.getString(context, "current_node");
        if (!TextUtils.isEmpty(string)) {
            String[] split = string.split(",");
            double d = f;
            return new BNRoutePlanNode.Builder().longitude(Double.parseDouble(split[0]) + d).latitude(Double.parseDouble(split[1]) + d).build();
        }
        return getStartNode(context);
    }

    public BNRoutePlanNode getEndNode(Context context) {
        String string = BNUtils.getString(context, "end_node");
        if (!TextUtils.isEmpty(string)) {
            String[] split = string.split(",");
            this.endNode = new BNRoutePlanNode.Builder().longitude(Double.parseDouble(split[0])).latitude(Double.parseDouble(split[1])).build();
        }
        return this.endNode;
    }

    public BNRoutePlanNode getNewNode(Context context) {
        String string = BNUtils.getString(context, "start_node");
        if (!TextUtils.isEmpty(string)) {
            String[] split = string.split(",");
            this.startNode = new BNRoutePlanNode.Builder().longitude(Double.parseDouble(split[0]) + 0.5d).latitude(Double.parseDouble(split[1]) + 0.5d).build();
        }
        return this.startNode;
    }

    public BNRoutePlanNode getStartNode(Context context) {
        String string = BNUtils.getString(context, "start_node");
        if (!TextUtils.isEmpty(string)) {
            String[] split = string.split(",");
            this.startNode = new BNRoutePlanNode.Builder().longitude(Double.parseDouble(split[0])).latitude(Double.parseDouble(split[1])).build();
        }
        return this.startNode;
    }

    public void initCarInfo() {
        BaiduNaviManagerFactory.getCommonSettingManager().setTruckInfo(new BNTruckInfo.Builder().truckUsage(17).plate("京A88888").axlesNumber(6).axlesWeight(100.0f).emissionLimit(3).length(25.0f).weight(100.0f).loadWeight(80.0f).oilCost(OIL_COST).plateType(2).powerType(1).truckType(4).height(10.0f).width(5.0f).build());
        BaiduNaviManagerFactory.getCommonSettingManager().setMotorInfo(new BNMotorInfo.Builder().plate("京A88888").plateType(2).motorType(0).displacement("").build());
        BaiduNaviManagerFactory.getCommonSettingManager().setNodeClick(true);
    }

    public void initRoutePlanNode() {
        this.startNode = new BNRoutePlanNode.Builder().latitude(40.04169d).longitude(116.306333d).name(NAME).description(NAME).build();
        this.endNode = new BNRoutePlanNode.Builder().latitude(39.90856d).longitude(116.397609d).name(NAME1).description(NAME1).build();
    }

    public void setEndNode(Context context, String str) {
        BNUtils.setString(context, "end_node", str);
    }

    public void setStartNode(Context context, String str) {
        BNUtils.setString(context, "start_node", str);
    }

    private BNFactory() {
    }
}
