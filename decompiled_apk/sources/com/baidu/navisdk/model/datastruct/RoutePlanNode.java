package com.baidu.navisdk.model.datastruct;

import XXO0.oIX0oI;
import android.text.TextUtils;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.text.ooOOo0oXI;

/* loaded from: classes7.dex */
public class RoutePlanNode implements Serializable {
    public static final int ENGINE_ICON_TYPE_DEFAULT = 0;
    public static final int ENGINE_ICON_TYPE_QUICK_CHARGING_STATION = 1;
    public static final int ENGINE_ICON_TYPE_SLOW_CHARGING_STATION = 2;
    public static final int FROM_COMPANY = 5;
    public static final int FROM_FAVORITE = 6;
    public static final int FROM_HOME = 4;
    public static final int FROM_MAP_KEYWORD = 2;
    public static final int FROM_MAP_POINT = 1;
    public static final int FROM_MY_POSITION = 3;
    public static final int FROM_NAVI_NEARBY_SEARCH = 7;
    public static final int FROM_POI = 8;
    public static final int FROM_UNKNOWN = 0;
    public static final int ICON_TYPE_CHARGING_STATION = 1;
    public static final int ICON_TYPE_DEFAULT = 0;
    public static final int POI_TYPE_Airport = 983296;
    public static final int POI_TYPE_Airport_Bus = 984576;
    public static final int POI_TYPE_Airport_Door = 983552;
    public static final int POI_TYPE_Bus_Stop = 984832;
    public static final int POI_TYPE_Coach = 984320;
    public static final int POI_TYPE_Gas_Stop = 986368;
    public static final int POI_TYPE_Harbour = 985088;
    public static final int POI_TYPE_Highway_Service = 985600;
    public static final int POI_TYPE_INVALID = 0;
    public static final int POI_TYPE_Parking = 986112;
    public static final int POI_TYPE_Road = 1441792;
    public static final int POI_TYPE_Subway_Stop = 984064;
    public static final int POI_TYPE_Taxi_Stop = 985344;
    public static final int POI_TYPE_Toll_Stop = 985856;
    public static final int POI_TYPE_Train = 983808;
    public static final int POI_TYPE_Trfc_Light = 986624;
    public static final int SUB_TYPE_KEYWORD = 2;
    public static final int SUB_TYPE_MYLOC = 3;
    public static final int SUB_TYPE_POS = 1;
    public static final int SUB_TYPE_SUG = 4;
    public static final int SUB_TYPE_UID = 0;
    private static final long serialVersionUID = -1928773235463634709L;
    public String imageUrl;
    public boolean isPassed;
    public float mAltitude;
    public float mBias;
    public long mBottom;
    public String mBuildingID;
    public int mBusinessPoi;
    public String mCityName;
    public String mDescription;
    public int mDistrictID;
    public String mFloorId;
    public int mFrom;
    public float mGPSAccuracy;
    public float mGPSAngle;
    public float mGPSSpeed;
    public transient GeoPoint mGeoPoint;
    public int mIconType;
    public int mId;
    public long mLeft;
    public float mLevel;
    public int mLocType;
    public String mName;
    public int mNodePrefer;
    public int mNodeType;
    public int mParkType;
    private int mPoiType;
    public long mRight;
    public float mSensorAngle;
    protected ArrayList<GeoPoint> mSubPosList;
    public long mTop;
    public String mUID;
    public transient GeoPoint mViewPoint;

    public RoutePlanNode() {
        this.mUID = null;
        this.mDistrictID = 0;
        this.mLevel = -1.0f;
        this.mTop = -1L;
        this.mRight = -1L;
        this.mBottom = -1L;
        this.mLeft = -1L;
        this.mGPSAngle = -2.0f;
        this.mGPSAccuracy = -2.0f;
        this.mGPSSpeed = -2.0f;
        this.mBias = -1.0f;
        this.mNodeType = -1;
        this.mAltitude = -1.0f;
        this.mBusinessPoi = -1;
        this.mSensorAngle = -1.0f;
        this.mLocType = -1;
        this.isPassed = false;
        this.mPoiType = 0;
        this.mBuildingID = null;
        this.mParkType = 0;
        this.mNodePrefer = 0;
        this.mId = 0;
        this.mName = "";
        this.mDescription = "";
        this.mGeoPoint = new GeoPoint();
        this.mFrom = 0;
    }

    private static void deepCopy(RoutePlanNode routePlanNode, RoutePlanNode routePlanNode2) {
        GeoPoint geoPoint;
        routePlanNode2.mFrom = routePlanNode.mFrom;
        routePlanNode2.mDistrictID = routePlanNode.mDistrictID;
        routePlanNode2.mLevel = routePlanNode.mLevel;
        routePlanNode2.mTop = routePlanNode.mTop;
        routePlanNode2.mRight = routePlanNode.mRight;
        routePlanNode2.mBottom = routePlanNode.mBottom;
        routePlanNode2.mLeft = routePlanNode.mLeft;
        routePlanNode2.mGPSAngle = routePlanNode.mGPSAngle;
        routePlanNode2.mGPSAccuracy = routePlanNode.mGPSAccuracy;
        routePlanNode2.mGPSSpeed = routePlanNode.mGPSSpeed;
        routePlanNode2.mBias = routePlanNode.mBias;
        routePlanNode2.mNodeType = routePlanNode.mNodeType;
        routePlanNode2.mAltitude = routePlanNode.mAltitude;
        routePlanNode2.mBusinessPoi = routePlanNode.mBusinessPoi;
        routePlanNode2.mSensorAngle = routePlanNode.mSensorAngle;
        routePlanNode2.mLocType = routePlanNode.mLocType;
        routePlanNode2.isPassed = routePlanNode.isPassed;
        routePlanNode2.mPoiType = routePlanNode.mPoiType;
        routePlanNode2.mIconType = routePlanNode.mIconType;
        routePlanNode2.mNodePrefer = routePlanNode.mNodePrefer;
        routePlanNode2.mId = routePlanNode.mId;
        if (TextUtils.isEmpty(routePlanNode.mName)) {
            routePlanNode2.mName = "";
        } else {
            routePlanNode2.mName = routePlanNode.mName;
        }
        if (TextUtils.isEmpty(routePlanNode.mDescription)) {
            routePlanNode2.mDescription = "";
        } else {
            routePlanNode2.mDescription = routePlanNode.mDescription;
        }
        if (TextUtils.isEmpty(routePlanNode.mUID)) {
            routePlanNode2.mUID = "";
        } else {
            routePlanNode2.mUID = routePlanNode.mUID;
        }
        if (!TextUtils.isEmpty(routePlanNode.mBuildingID)) {
            routePlanNode2.mBuildingID = routePlanNode.mBuildingID;
        }
        if (!TextUtils.isEmpty(routePlanNode.mFloorId)) {
            routePlanNode2.mFloorId = routePlanNode.mFloorId;
        }
        if (TextUtils.isEmpty(routePlanNode.mCityName)) {
            routePlanNode2.mCityName = "";
        } else {
            routePlanNode2.mCityName = routePlanNode.mCityName;
        }
        if (routePlanNode.mGeoPoint != null) {
            if (routePlanNode2.mGeoPoint == null) {
                routePlanNode2.mGeoPoint = new GeoPoint();
            }
            routePlanNode2.mGeoPoint.setLongitudeE6(routePlanNode.mGeoPoint.getLongitudeE6());
            routePlanNode2.mGeoPoint.setLatitudeE6(routePlanNode.mGeoPoint.getLatitudeE6());
        }
        if (routePlanNode.mViewPoint != null) {
            if (routePlanNode2.mViewPoint == null) {
                routePlanNode2.mViewPoint = new GeoPoint();
            }
            routePlanNode2.mViewPoint.setLongitudeE6(routePlanNode.mViewPoint.getLongitudeE6());
            routePlanNode2.mViewPoint.setLatitudeE6(routePlanNode.mViewPoint.getLatitudeE6());
        }
        if (routePlanNode.mSubPosList != null) {
            ArrayList<GeoPoint> arrayList = routePlanNode2.mSubPosList;
            if (arrayList == null) {
                routePlanNode2.mSubPosList = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            Iterator<GeoPoint> it = routePlanNode.mSubPosList.iterator();
            while (it.hasNext()) {
                GeoPoint next = it.next();
                if (next != null) {
                    geoPoint = new GeoPoint();
                    geoPoint.setLongitudeE6(next.getLongitudeE6());
                    geoPoint.setLatitudeE6(next.getLatitudeE6());
                } else {
                    geoPoint = null;
                }
                routePlanNode2.mSubPosList.add(geoPoint);
            }
        }
        routePlanNode2.mParkType = routePlanNode.mParkType;
    }

    private String getFromDescription(int i) {
        switch (i) {
            case 0:
                return "未知来源";
            case 1:
                return "来源地图选点";
            case 2:
                return "来源地图关键字";
            case 3:
                return "来源我的位置";
            case 4:
                return "来源家";
            case 5:
                return "来源公司";
            case 6:
                return "来源用户收藏";
            case 7:
                return "来源导航搜周边";
            case 8:
                return "来源poi";
            default:
                return "from 异常，请注意";
        }
    }

    private String getLocTypeDescription(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? "locType 异常，请注意" : "基站定位" : "WiFi定位" : "卫星定位" : "默认值，不属于卫星/WiFi/基站定位";
    }

    private String getNodeTypeDescription(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? "nodeType 异常，请注意" : "SUG" : "我的位置" : "key word" : "经纬度" : " uid";
    }

    public void clearSubPoiList() {
        ArrayList<GeoPoint> arrayList = this.mSubPosList;
        if (arrayList != null) {
            arrayList.clear();
        }
        this.mSubPosList = null;
    }

    public void copy(RoutePlanNode routePlanNode) {
        if (routePlanNode == null) {
            return;
        }
        deepCopy(routePlanNode, this);
    }

    public float getAltitude() {
        return this.mAltitude;
    }

    public String getCityName() {
        return this.mCityName;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public int getDistrictID() {
        return this.mDistrictID;
    }

    public String getFloorId() {
        return this.mFloorId;
    }

    public int getFrom() {
        return this.mFrom;
    }

    public GeoPoint getGeoPoint() {
        return new GeoPoint(this.mGeoPoint);
    }

    public int getIconType() {
        return this.mIconType;
    }

    public int getId() {
        return this.mId;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public int getLatitudeE6() {
        GeoPoint geoPoint = this.mGeoPoint;
        if (geoPoint == null) {
            return Integer.MIN_VALUE;
        }
        return geoPoint.getLatitudeE6();
    }

    public int getLongitudeE6() {
        GeoPoint geoPoint = this.mGeoPoint;
        if (geoPoint == null) {
            return Integer.MIN_VALUE;
        }
        return geoPoint.getLongitudeE6();
    }

    public String getName() {
        return this.mName;
    }

    public int getNodePrefer() {
        return this.mNodePrefer;
    }

    public int getNodeType() {
        return this.mNodeType;
    }

    public int getParkType() {
        return this.mParkType;
    }

    public int getPoiType() {
        return this.mPoiType;
    }

    public ArrayList<GeoPoint> getSubPosList() {
        ArrayList<GeoPoint> arrayList = this.mSubPosList;
        if (arrayList != null) {
            return (ArrayList) arrayList.clone();
        }
        return null;
    }

    public String getUID() {
        return this.mUID;
    }

    public GeoPoint getViewPoint() {
        GeoPoint geoPoint = this.mViewPoint;
        if (geoPoint != null) {
            return new GeoPoint(geoPoint);
        }
        return new GeoPoint(this.mGeoPoint);
    }

    public int getViewtLatitudeE6() {
        GeoPoint geoPoint = this.mViewPoint;
        if (geoPoint == null) {
            geoPoint = this.mGeoPoint;
        }
        if (geoPoint == null) {
            return Integer.MIN_VALUE;
        }
        return geoPoint.getLatitudeE6();
    }

    public int getViewtLongitudeE6() {
        GeoPoint geoPoint = this.mViewPoint;
        if (geoPoint == null) {
            geoPoint = this.mGeoPoint;
        }
        if (geoPoint == null) {
            return Integer.MIN_VALUE;
        }
        return geoPoint.getLongitudeE6();
    }

    public boolean isNodeIntegrated() {
        GeoPoint geoPoint = this.mGeoPoint;
        if (geoPoint == null || geoPoint.getLatitudeE6() == Integer.MIN_VALUE || this.mGeoPoint.getLongitudeE6() == Integer.MIN_VALUE) {
            return false;
        }
        if ("".equals(this.mName) && "".equals(this.mDescription)) {
            return false;
        }
        return true;
    }

    public boolean isNodeSettedData() {
        GeoPoint geoPoint = this.mGeoPoint;
        if (geoPoint == null || geoPoint.getLatitudeE6() == Integer.MIN_VALUE || this.mGeoPoint.getLongitudeE6() == Integer.MIN_VALUE) {
            return false;
        }
        return true;
    }

    public boolean isPassed() {
        return this.isPassed;
    }

    public void setBuildingID(String str) {
        this.mBuildingID = str;
    }

    public void setCityName(String str) {
        this.mCityName = str;
    }

    public void setDescription(String str) {
        this.mDescription = str;
    }

    public void setDistrictID(int i) {
        this.mDistrictID = i;
    }

    public void setFloorId(String str) {
        this.mFloorId = str;
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public void setGeoPoint(GeoPoint geoPoint) {
        this.mGeoPoint = new GeoPoint(geoPoint);
    }

    public void setIconType(int i) {
        this.mIconType = i;
    }

    public void setId(int i) {
        this.mId = i;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setNodePrefer(int i) {
        this.mNodePrefer = i;
    }

    public void setNodeType(int i) {
        this.mNodeType = i;
    }

    public void setParkType(int i) {
        this.mParkType = i;
    }

    public void setPassed(boolean z) {
        this.isPassed = z;
    }

    public void setPoiType(int i) {
        this.mPoiType = i;
    }

    public void setSubPosList(ArrayList<GeoPoint> arrayList) {
        if (arrayList != null) {
            if (this.mSubPosList == null) {
                this.mSubPosList = new ArrayList<>();
            }
            ArrayList<GeoPoint> arrayList2 = this.mSubPosList;
            if (arrayList2 != null) {
                arrayList2.clear();
                Iterator<GeoPoint> it = arrayList.iterator();
                while (it.hasNext()) {
                    this.mSubPosList.add(it.next());
                }
                return;
            }
            return;
        }
        clearSubPoiList();
    }

    public void setUID(String str) {
        this.mUID = str;
    }

    public void setViewPoint(GeoPoint geoPoint) {
        this.mViewPoint = new GeoPoint(geoPoint);
    }

    public String toString() {
        int size;
        StringBuilder sb = new StringBuilder();
        sb.append("RoutePlanNode{");
        sb.append("mName:");
        sb.append(this.mName);
        sb.append(",");
        sb.append("mFrom:");
        sb.append(this.mFrom);
        if (LogUtil.LOGGABLE) {
            sb.append(oIX0oI.I0Io.f4096II0xO0);
            sb.append(getFromDescription(this.mFrom));
            sb.append("),");
        } else {
            sb.append(",");
        }
        sb.append("mLocType:");
        sb.append(this.mLocType);
        if (LogUtil.LOGGABLE) {
            sb.append(oIX0oI.I0Io.f4096II0xO0);
            sb.append(getLocTypeDescription(this.mLocType));
            sb.append("),");
        } else {
            sb.append(",");
        }
        sb.append("mNodeType:");
        sb.append(this.mNodeType);
        if (LogUtil.LOGGABLE) {
            sb.append(oIX0oI.I0Io.f4096II0xO0);
            sb.append(getNodeTypeDescription(this.mNodeType));
            sb.append("),");
        } else {
            sb.append(",");
        }
        sb.append("mPoiType:");
        sb.append(this.mPoiType);
        sb.append(",");
        sb.append("mUID:");
        sb.append(this.mUID);
        sb.append(",");
        sb.append("mIconType:");
        sb.append(this.mIconType);
        sb.append(",");
        sb.append("mFloorId:");
        sb.append(this.mFloorId);
        sb.append(",");
        sb.append("mBuildingID:");
        sb.append(this.mBuildingID);
        sb.append(",");
        sb.append("mDistrictID:");
        sb.append(this.mDistrictID);
        sb.append(",");
        sb.append("mCityName:");
        sb.append(this.mCityName);
        sb.append(",");
        sb.append("mGPSAngle:");
        sb.append(this.mGPSAngle);
        sb.append(",");
        sb.append("mGPSAccuracy:");
        sb.append(this.mGPSAccuracy);
        sb.append(",");
        sb.append("mGPSSpeed:");
        sb.append(this.mGPSSpeed);
        sb.append(",");
        sb.append("mBias:");
        sb.append(this.mBias);
        sb.append(",");
        sb.append("mAltitude:");
        sb.append(this.mAltitude);
        sb.append(",");
        sb.append("mSensorAngle:");
        sb.append(this.mSensorAngle);
        sb.append(",");
        sb.append("mDescription:");
        sb.append(this.mDescription);
        sb.append(",");
        sb.append("mLevel:");
        sb.append(this.mLevel);
        sb.append(",");
        sb.append("mTop:");
        sb.append(this.mTop);
        sb.append(",");
        sb.append("mRight:");
        sb.append(this.mRight);
        sb.append(",");
        sb.append("mBottom:");
        sb.append(this.mBottom);
        sb.append(",");
        sb.append("mLeft:");
        sb.append(this.mLeft);
        sb.append(",");
        sb.append("mBusinessPoi:");
        sb.append(this.mBusinessPoi);
        sb.append(",");
        sb.append("isPassed:");
        sb.append(this.isPassed);
        sb.append(",");
        sb.append("mViewPoint:");
        GeoPoint geoPoint = this.mViewPoint;
        if (geoPoint == null) {
            geoPoint = this.mGeoPoint;
        }
        sb.append(geoPoint.toString());
        sb.append(",");
        sb.append("mGeoPoint:");
        sb.append(this.mGeoPoint.toString());
        sb.append(",");
        sb.append("parkType:");
        sb.append(this.mParkType);
        sb.append(",");
        StringBuffer stringBuffer = new StringBuffer();
        ArrayList<GeoPoint> arrayList = this.mSubPosList;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            GeoPoint geoPoint2 = this.mSubPosList.get(0);
            stringBuffer.append("{");
            stringBuffer.append(geoPoint2.toString());
            for (int i = 1; i < size; i++) {
                GeoPoint geoPoint3 = this.mSubPosList.get(i);
                stringBuffer.append(",");
                stringBuffer.append(geoPoint3.toString());
            }
        }
        sb.append("mSubPosList:");
        sb.append(stringBuffer);
        sb.append(ooOOo0oXI.f33074oOoXoXO);
        return sb.toString();
    }

    public String toStringForAutoCheck() {
        String str;
        ArrayList<GeoPoint> arrayList = this.mSubPosList;
        String str2 = "";
        if (arrayList != null && arrayList.size() > 0) {
            for (int i = 0; i < this.mSubPosList.size(); i++) {
                if (i == this.mSubPosList.size() - 1) {
                    str2 = str2 + this.mSubPosList.get(i).toStringForAutoCheck();
                } else {
                    str2 = str2 + this.mSubPosList.get(i).toStringForAutoCheck() + ",";
                }
            }
        }
        String str3 = "[" + str2 + "]";
        GeoPoint geoPoint = this.mGeoPoint;
        if (geoPoint != null) {
            str = geoPoint.toStringForAutoCheck();
        } else {
            str = null;
        }
        return "{\"mName\":\"" + this.mName + "\", \"mDescription\":\"" + this.mDescription + "\", \"mUID\":\"" + this.mUID + "\", \"mIconType\":\"" + this.mIconType + "\", \"mGeoPoint\":" + str + ", \"mViewPoint\":" + this.mViewPoint + ", \"mFrom\":" + this.mFrom + ", \"mDistrictID\":" + this.mDistrictID + ", \"mCityName\":\"" + this.mCityName + "\", \"mLevel\":" + this.mLevel + ", \"mTop\":" + this.mTop + ", \"mRight\":" + this.mRight + ", \"mBottom\":" + this.mBottom + ", \"mLeft\":" + this.mLeft + ", \"mGPSAngle\":" + this.mGPSAngle + ", \"mGPSAccuracy\":" + this.mGPSAccuracy + ", \"mGPSSpeed\":" + this.mGPSSpeed + ", \"mBias\":" + this.mBias + ", \"mNodeType\":" + this.mNodeType + ", \"mAltitude\":" + this.mAltitude + ", \"mBusinessPoi\":" + this.mBusinessPoi + ", \"mSensorAngle\":" + this.mSensorAngle + ", \"mLocType\":" + this.mLocType + ", \"isPassed\":" + this.isPassed + ", \"mSubPosList\":" + str3 + '}';
    }

    @Override // 
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public RoutePlanNode mo81clone() {
        RoutePlanNode routePlanNode = new RoutePlanNode();
        deepCopy(this, routePlanNode);
        return routePlanNode;
    }

    public RoutePlanNode(RoutePlanNode routePlanNode) {
        this();
        copy(routePlanNode);
    }

    public RoutePlanNode(int i, int i2, int i3, String str, String str2) {
        this(i, i2, i3, str, str2, (String) null);
    }

    public RoutePlanNode(int i, int i2, int i3, String str, String str2, String str3) {
        this.mUID = null;
        this.mDistrictID = 0;
        this.mLevel = -1.0f;
        this.mTop = -1L;
        this.mRight = -1L;
        this.mBottom = -1L;
        this.mLeft = -1L;
        this.mGPSAngle = -2.0f;
        this.mGPSAccuracy = -2.0f;
        this.mGPSSpeed = -2.0f;
        this.mBias = -1.0f;
        this.mNodeType = -1;
        this.mAltitude = -1.0f;
        this.mBusinessPoi = -1;
        this.mSensorAngle = -1.0f;
        this.mLocType = -1;
        this.isPassed = false;
        this.mPoiType = 0;
        this.mBuildingID = null;
        this.mParkType = 0;
        this.mNodePrefer = 0;
        this.mId = 0;
        if (i2 >= 0 && i >= 0) {
            this.mGeoPoint = new GeoPoint(i2, i);
        } else {
            this.mGeoPoint = new GeoPoint();
        }
        if (i3 != 3 && i3 != 4 && i3 != 5 && i3 != 1 && i3 != 8 && i3 != 6 && i3 != 7 && i3 != 2) {
            this.mFrom = 0;
        } else {
            this.mFrom = i3;
        }
        if (str == null) {
            this.mName = "";
        } else {
            this.mName = str;
        }
        if (str2 == null) {
            this.mDescription = "";
        } else {
            this.mDescription = str2;
        }
        this.mUID = str3;
    }

    public RoutePlanNode(GeoPoint geoPoint, int i, String str, String str2) {
        this(geoPoint, i, str, str2, (String) null);
    }

    public RoutePlanNode(GeoPoint geoPoint, int i, String str, String str2, int i2) {
        this(geoPoint, i, str, str2, (String) null);
        this.mNodePrefer = i2;
    }

    public RoutePlanNode(GeoPoint geoPoint, int i, String str, String str2, String str3) {
        this.mUID = null;
        this.mDistrictID = 0;
        this.mLevel = -1.0f;
        this.mTop = -1L;
        this.mRight = -1L;
        this.mBottom = -1L;
        this.mLeft = -1L;
        this.mGPSAngle = -2.0f;
        this.mGPSAccuracy = -2.0f;
        this.mGPSSpeed = -2.0f;
        this.mBias = -1.0f;
        this.mNodeType = -1;
        this.mAltitude = -1.0f;
        this.mBusinessPoi = -1;
        this.mSensorAngle = -1.0f;
        this.mLocType = -1;
        this.isPassed = false;
        this.mPoiType = 0;
        this.mBuildingID = null;
        this.mParkType = 0;
        this.mNodePrefer = 0;
        this.mId = 0;
        if (geoPoint == null) {
            this.mGeoPoint = new GeoPoint();
        } else {
            this.mGeoPoint = new GeoPoint(geoPoint.getLongitudeE6(), geoPoint.getLatitudeE6());
        }
        if (i != 3 && i != 4 && i != 5 && i != 1 && i != 8 && i != 6 && i != 7 && i != 2) {
            this.mFrom = 0;
        } else {
            this.mFrom = i;
        }
        if (str == null) {
            this.mName = "";
        } else {
            this.mName = str;
        }
        if (str2 == null) {
            this.mDescription = "";
        } else {
            this.mDescription = str2;
        }
        this.mUID = str3;
    }

    public RoutePlanNode(GeoPoint geoPoint, GeoPoint geoPoint2, int i, String str, String str2) {
        this(geoPoint, geoPoint2, i, str, str2, (String) null);
    }

    public RoutePlanNode(GeoPoint geoPoint, GeoPoint geoPoint2, int i, String str, String str2, String str3) {
        this.mUID = null;
        this.mDistrictID = 0;
        this.mLevel = -1.0f;
        this.mTop = -1L;
        this.mRight = -1L;
        this.mBottom = -1L;
        this.mLeft = -1L;
        this.mGPSAngle = -2.0f;
        this.mGPSAccuracy = -2.0f;
        this.mGPSSpeed = -2.0f;
        this.mBias = -1.0f;
        this.mNodeType = -1;
        this.mAltitude = -1.0f;
        this.mBusinessPoi = -1;
        this.mSensorAngle = -1.0f;
        this.mLocType = -1;
        this.isPassed = false;
        this.mPoiType = 0;
        this.mBuildingID = null;
        this.mParkType = 0;
        this.mNodePrefer = 0;
        this.mId = 0;
        if (geoPoint == null) {
            this.mGeoPoint = new GeoPoint();
        } else {
            this.mGeoPoint = new GeoPoint(geoPoint.getLongitudeE6(), geoPoint.getLatitudeE6());
        }
        if (geoPoint2 != null) {
            this.mViewPoint = new GeoPoint(geoPoint2);
        }
        if (i != 3 && i != 4 && i != 5 && i != 1 && i != 8 && i != 6 && i != 7 && i != 2) {
            this.mFrom = 0;
        } else {
            this.mFrom = i;
        }
        if (str == null) {
            this.mName = "";
        } else {
            this.mName = str;
        }
        if (str2 == null) {
            this.mDescription = "";
        } else {
            this.mDescription = str2;
        }
        this.mUID = str3;
    }
}
