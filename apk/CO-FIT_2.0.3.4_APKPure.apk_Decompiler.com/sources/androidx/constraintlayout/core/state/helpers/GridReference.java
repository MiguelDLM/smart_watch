package androidx.constraintlayout.core.state.helpers;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.state.HelperReference;
import androidx.constraintlayout.core.state.State;
import androidx.constraintlayout.core.utils.GridCore;
import androidx.constraintlayout.core.widgets.HelperWidget;

public class GridReference extends HelperReference {
    private static final String SPANS_RESPECT_WIDGET_ORDER_STRING = "spansrespectwidgetorder";
    private static final String SUB_GRID_BY_COL_ROW_STRING = "subgridbycolrow";
    private String mColumnWeights;
    private int mColumnsSet;
    private int mFlags;
    private GridCore mGrid;
    private float mHorizontalGaps;
    private int mOrientation;
    private int mPaddingBottom = 0;
    private int mPaddingEnd = 0;
    private int mPaddingStart = 0;
    private int mPaddingTop = 0;
    private String mRowWeights;
    private int mRowsSet;
    private String mSkips;
    private String mSpans;
    private float mVerticalGaps;

    public GridReference(@NonNull State state, @NonNull State.Helper helper) {
        super(state, helper);
        if (helper == State.Helper.ROW) {
            this.mRowsSet = 1;
        } else if (helper == State.Helper.COLUMN) {
            this.mColumnsSet = 1;
        }
    }

    public void apply() {
        getHelperWidget();
        this.mGrid.setOrientation(this.mOrientation);
        int i = this.mRowsSet;
        if (i != 0) {
            this.mGrid.setRows(i);
        }
        int i2 = this.mColumnsSet;
        if (i2 != 0) {
            this.mGrid.setColumns(i2);
        }
        float f = this.mHorizontalGaps;
        if (f != 0.0f) {
            this.mGrid.setHorizontalGaps(f);
        }
        float f2 = this.mVerticalGaps;
        if (f2 != 0.0f) {
            this.mGrid.setVerticalGaps(f2);
        }
        String str = this.mRowWeights;
        if (str != null && !str.isEmpty()) {
            this.mGrid.setRowWeights(this.mRowWeights);
        }
        String str2 = this.mColumnWeights;
        if (str2 != null && !str2.isEmpty()) {
            this.mGrid.setColumnWeights(this.mColumnWeights);
        }
        String str3 = this.mSpans;
        if (str3 != null && !str3.isEmpty()) {
            this.mGrid.setSpans(this.mSpans);
        }
        String str4 = this.mSkips;
        if (str4 != null && !str4.isEmpty()) {
            this.mGrid.setSkips(this.mSkips);
        }
        this.mGrid.setFlags(this.mFlags);
        this.mGrid.setPaddingStart(this.mPaddingStart);
        this.mGrid.setPaddingEnd(this.mPaddingEnd);
        this.mGrid.setPaddingTop(this.mPaddingTop);
        this.mGrid.setPaddingBottom(this.mPaddingBottom);
        applyBase();
    }

    @Nullable
    public String getColumnWeights() {
        return this.mColumnWeights;
    }

    public int getColumnsSet() {
        return this.mColumnsSet;
    }

    public int getFlags() {
        return this.mFlags;
    }

    @NonNull
    public HelperWidget getHelperWidget() {
        if (this.mGrid == null) {
            this.mGrid = new GridCore();
        }
        return this.mGrid;
    }

    public float getHorizontalGaps() {
        return this.mHorizontalGaps;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public int getPaddingBottom() {
        return this.mPaddingBottom;
    }

    public int getPaddingEnd() {
        return this.mPaddingEnd;
    }

    public int getPaddingStart() {
        return this.mPaddingStart;
    }

    public int getPaddingTop() {
        return this.mPaddingTop;
    }

    @Nullable
    public String getRowWeights() {
        return this.mRowWeights;
    }

    public int getRowsSet() {
        return this.mRowsSet;
    }

    @Nullable
    public String getSkips() {
        return this.mSkips;
    }

    @Nullable
    public String getSpans() {
        return this.mSpans;
    }

    public float getVerticalGaps() {
        return this.mVerticalGaps;
    }

    public void setColumnWeights(@NonNull String str) {
        this.mColumnWeights = str;
    }

    public void setColumnsSet(int i) {
        if (super.getType() != State.Helper.ROW) {
            this.mColumnsSet = i;
        }
    }

    public void setFlags(int i) {
        this.mFlags = i;
    }

    public void setHelperWidget(@Nullable HelperWidget helperWidget) {
        if (helperWidget instanceof GridCore) {
            this.mGrid = (GridCore) helperWidget;
        } else {
            this.mGrid = null;
        }
    }

    public void setHorizontalGaps(float f) {
        this.mHorizontalGaps = f;
    }

    public void setOrientation(int i) {
        this.mOrientation = i;
    }

    public void setPaddingBottom(int i) {
        this.mPaddingBottom = i;
    }

    public void setPaddingEnd(int i) {
        this.mPaddingEnd = i;
    }

    public void setPaddingStart(int i) {
        this.mPaddingStart = i;
    }

    public void setPaddingTop(int i) {
        this.mPaddingTop = i;
    }

    public void setRowWeights(@NonNull String str) {
        this.mRowWeights = str;
    }

    public void setRowsSet(int i) {
        if (super.getType() != State.Helper.COLUMN) {
            this.mRowsSet = i;
        }
    }

    public void setSkips(@NonNull String str) {
        this.mSkips = str;
    }

    public void setSpans(@NonNull String str) {
        this.mSpans = str;
    }

    public void setVerticalGaps(float f) {
        this.mVerticalGaps = f;
    }

    public void setFlags(@NonNull String str) {
        if (!str.isEmpty()) {
            String[] split = str.split("\\|");
            this.mFlags = 0;
            for (String lowerCase : split) {
                String lowerCase2 = lowerCase.toLowerCase();
                lowerCase2.hashCode();
                if (lowerCase2.equals(SUB_GRID_BY_COL_ROW_STRING)) {
                    this.mFlags |= 1;
                } else if (lowerCase2.equals(SPANS_RESPECT_WIDGET_ORDER_STRING)) {
                    this.mFlags |= 2;
                }
            }
        }
    }
}
