package com.sma.smartv3.model;

import OXOo.OOXIXo;
import com.blankj.utilcode.util.Utils;
import com.sma.smartv3.co_fit.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nWeightMeasureData.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WeightMeasureData.kt\ncom/sma/smartv3/model/WeightMeasureItemData\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,475:1\n1855#2,2:476\n*S KotlinDebug\n*F\n+ 1 WeightMeasureData.kt\ncom/sma/smartv3/model/WeightMeasureItemData\n*L\n226#1:476,2\n*E\n"})
/* loaded from: classes12.dex */
public final class WeightMeasureItemData {

    @OOXIXo
    private int[] gridViewImgs;
    private int icon;
    private boolean isMore;
    private boolean isShowBarView;
    private boolean isShowGridView;
    private boolean isShowLevel;
    private boolean isShowTips;
    private boolean isShowValue;
    private int level;

    @OOXIXo
    private int[] levelColor;

    @OOXIXo
    private List<Double> levelRange;

    @OOXIXo
    private String[] levelRangeText;

    @OOXIXo
    private LevelType levelType;

    @OOXIXo
    private String name;
    private int standerLevel;

    @OOXIXo
    private String tipText;

    @OOXIXo
    private String unit;
    private double value;

    public WeightMeasureItemData(int i, @OOXIXo String name, boolean z, double d, @OOXIXo String unit, boolean z2, int i2, int i3, @OOXIXo List<Double> levelRange, @OOXIXo String[] levelRangeText, @OOXIXo int[] levelColor, @OOXIXo LevelType levelType, boolean z3, boolean z4, boolean z5, @OOXIXo int[] gridViewImgs, boolean z6, @OOXIXo String tipText) {
        IIX0o.x0xO0oo(name, "name");
        IIX0o.x0xO0oo(unit, "unit");
        IIX0o.x0xO0oo(levelRange, "levelRange");
        IIX0o.x0xO0oo(levelRangeText, "levelRangeText");
        IIX0o.x0xO0oo(levelColor, "levelColor");
        IIX0o.x0xO0oo(levelType, "levelType");
        IIX0o.x0xO0oo(gridViewImgs, "gridViewImgs");
        IIX0o.x0xO0oo(tipText, "tipText");
        this.icon = i;
        this.name = name;
        this.isShowValue = z;
        this.value = d;
        this.unit = unit;
        this.isShowLevel = z2;
        this.standerLevel = i2;
        this.level = i3;
        this.levelRange = levelRange;
        this.levelRangeText = levelRangeText;
        this.levelColor = levelColor;
        this.levelType = levelType;
        this.isMore = z3;
        this.isShowBarView = z4;
        this.isShowGridView = z5;
        this.gridViewImgs = gridViewImgs;
        this.isShowTips = z6;
        this.tipText = tipText;
        if (IIX0o.Oxx0IOOO(unit, Utils.getApp().getString(R.string.lbs))) {
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = this.levelRange.iterator();
            while (it.hasNext()) {
                arrayList.add(Double.valueOf(WeightMeasureDataKt.centigradeFilter(WeightMeasureDataKt.kg2Lbs(((Number) it.next()).doubleValue()))));
            }
            this.levelRange = arrayList;
        }
        if (!(this.levelRangeText.length == 0)) {
            this.level = WeightMeasureDataKt.getLevel(this.value, this.levelRange);
        }
        int i4 = this.level;
        if (i4 == 0 || i4 > this.levelRangeText.length || this.levelRange.isEmpty()) {
            return;
        }
        this.levelType = WeightMeasureDataKt.getLevelType(this.standerLevel, this.level);
    }

    @OOXIXo
    public final int[] getGridViewImgs() {
        return this.gridViewImgs;
    }

    public final int getIcon() {
        return this.icon;
    }

    public final int getLevel() {
        return this.level;
    }

    @OOXIXo
    public final int[] getLevelColor() {
        return this.levelColor;
    }

    @OOXIXo
    public final List<Double> getLevelRange() {
        return this.levelRange;
    }

    @OOXIXo
    public final String[] getLevelRangeText() {
        return this.levelRangeText;
    }

    @OOXIXo
    public final LevelType getLevelType() {
        return this.levelType;
    }

    @OOXIXo
    public final String getName() {
        return this.name;
    }

    public final int getStanderLevel() {
        return this.standerLevel;
    }

    @OOXIXo
    public final String getTipText() {
        return this.tipText;
    }

    @OOXIXo
    public final String getUnit() {
        return this.unit;
    }

    public final double getValue() {
        return this.value;
    }

    public final boolean isMore() {
        return this.isMore;
    }

    public final boolean isShowBarView() {
        return this.isShowBarView;
    }

    public final boolean isShowGridView() {
        return this.isShowGridView;
    }

    public final boolean isShowLevel() {
        return this.isShowLevel;
    }

    public final boolean isShowTips() {
        return this.isShowTips;
    }

    public final boolean isShowValue() {
        return this.isShowValue;
    }

    public final void setGridViewImgs(@OOXIXo int[] iArr) {
        IIX0o.x0xO0oo(iArr, "<set-?>");
        this.gridViewImgs = iArr;
    }

    public final void setIcon(int i) {
        this.icon = i;
    }

    public final void setLevel(int i) {
        this.level = i;
    }

    public final void setLevelColor(@OOXIXo int[] iArr) {
        IIX0o.x0xO0oo(iArr, "<set-?>");
        this.levelColor = iArr;
    }

    public final void setLevelRange(@OOXIXo List<Double> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.levelRange = list;
    }

    public final void setLevelRangeText(@OOXIXo String[] strArr) {
        IIX0o.x0xO0oo(strArr, "<set-?>");
        this.levelRangeText = strArr;
    }

    public final void setLevelType(@OOXIXo LevelType levelType) {
        IIX0o.x0xO0oo(levelType, "<set-?>");
        this.levelType = levelType;
    }

    public final void setMore(boolean z) {
        this.isMore = z;
    }

    public final void setName(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.name = str;
    }

    public final void setShowBarView(boolean z) {
        this.isShowBarView = z;
    }

    public final void setShowGridView(boolean z) {
        this.isShowGridView = z;
    }

    public final void setShowLevel(boolean z) {
        this.isShowLevel = z;
    }

    public final void setShowTips(boolean z) {
        this.isShowTips = z;
    }

    public final void setShowValue(boolean z) {
        this.isShowValue = z;
    }

    public final void setStanderLevel(int i) {
        this.standerLevel = i;
    }

    public final void setTipText(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.tipText = str;
    }

    public final void setUnit(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.unit = str;
    }

    public final void setValue(double d) {
        this.value = d;
    }

    public /* synthetic */ WeightMeasureItemData(int i, String str, boolean z, double d, String str2, boolean z2, int i2, int i3, List list, String[] strArr, int[] iArr, LevelType levelType, boolean z3, boolean z4, boolean z5, int[] iArr2, boolean z6, String str3, int i4, IIXOooo iIXOooo) {
        this(i, str, (i4 & 4) != 0 ? false : z, d, (i4 & 16) != 0 ? "" : str2, (i4 & 32) != 0 ? false : z2, (i4 & 64) != 0 ? 0 : i2, (i4 & 128) != 0 ? 0 : i3, (i4 & 256) != 0 ? CollectionsKt__CollectionsKt.ooXIXxIX() : list, (i4 & 512) != 0 ? new String[0] : strArr, (i4 & 1024) != 0 ? new int[0] : iArr, (i4 & 2048) != 0 ? LevelType.ALL : levelType, (i4 & 4096) != 0 ? true : z3, (i4 & 8192) != 0 ? false : z4, (i4 & 16384) != 0 ? false : z5, (32768 & i4) != 0 ? new int[0] : iArr2, (65536 & i4) != 0 ? false : z6, (i4 & 131072) != 0 ? "" : str3);
    }
}
