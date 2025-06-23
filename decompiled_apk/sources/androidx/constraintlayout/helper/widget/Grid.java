package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.VirtualLayout;
import androidx.core.internal.view.SupportMenu;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class Grid extends VirtualLayout {
    private static final boolean DEBUG_BOXES = false;
    public static final int HORIZONTAL = 0;
    private static final String TAG = "Grid";
    public static final int VERTICAL = 1;
    private int[] mBoxViewIds;
    private View[] mBoxViews;
    private int mColumns;
    private int mColumnsSet;
    ConstraintLayout mContainer;
    private float mHorizontalGaps;
    private final int mMaxColumns;
    private final int mMaxRows;
    private int mNextAvailableIndex;
    private int mOrientation;
    private boolean[][] mPositionMatrix;
    private int mRows;
    private int mRowsSet;
    Set<Integer> mSpanIds;
    private String mStrColumnWeights;
    private String mStrRowWeights;
    private String mStrSkips;
    private String mStrSpans;
    private boolean mUseRtl;
    private boolean mValidateInputs;
    private float mVerticalGaps;

    public Grid(Context context) {
        super(context);
        this.mMaxRows = 50;
        this.mMaxColumns = 50;
        this.mNextAvailableIndex = 0;
        this.mSpanIds = new HashSet();
    }

    private boolean arrangeWidgets() {
        View[] views = getViews(this.mContainer);
        for (int i = 0; i < this.mCount; i++) {
            if (!this.mSpanIds.contains(Integer.valueOf(this.mIds[i]))) {
                int nextPosition = getNextPosition();
                int rowByIndex = getRowByIndex(nextPosition);
                int colByIndex = getColByIndex(nextPosition);
                if (nextPosition == -1) {
                    return false;
                }
                connectView(views[i], rowByIndex, colByIndex, 1, 1);
            }
        }
        return true;
    }

    private void buildBoxes() {
        int max = Math.max(this.mRows, this.mColumns);
        View[] viewArr = this.mBoxViews;
        int i = 0;
        if (viewArr == null) {
            this.mBoxViews = new View[max];
            int i2 = 0;
            while (true) {
                View[] viewArr2 = this.mBoxViews;
                if (i2 >= viewArr2.length) {
                    break;
                }
                viewArr2[i2] = makeNewView();
                i2++;
            }
        } else if (max != viewArr.length) {
            View[] viewArr3 = new View[max];
            for (int i3 = 0; i3 < max; i3++) {
                View[] viewArr4 = this.mBoxViews;
                if (i3 < viewArr4.length) {
                    viewArr3[i3] = viewArr4[i3];
                } else {
                    viewArr3[i3] = makeNewView();
                }
            }
            int i4 = max;
            while (true) {
                View[] viewArr5 = this.mBoxViews;
                if (i4 >= viewArr5.length) {
                    break;
                }
                this.mContainer.removeView(viewArr5[i4]);
                i4++;
            }
            this.mBoxViews = viewArr3;
        }
        this.mBoxViewIds = new int[max];
        while (true) {
            View[] viewArr6 = this.mBoxViews;
            if (i < viewArr6.length) {
                this.mBoxViewIds[i] = viewArr6[i].getId();
                i++;
            } else {
                setBoxViewVerticalChains();
                setBoxViewHorizontalChains();
                return;
            }
        }
    }

    private void clearHParams(View view) {
        ConstraintLayout.LayoutParams params = params(view);
        params.horizontalWeight = -1.0f;
        params.leftToRight = -1;
        params.leftToLeft = -1;
        params.rightToLeft = -1;
        params.rightToRight = -1;
        ((ViewGroup.MarginLayoutParams) params).leftMargin = -1;
        view.setLayoutParams(params);
    }

    private void clearVParams(View view) {
        ConstraintLayout.LayoutParams params = params(view);
        params.verticalWeight = -1.0f;
        params.topToBottom = -1;
        params.topToTop = -1;
        params.bottomToTop = -1;
        params.bottomToBottom = -1;
        ((ViewGroup.MarginLayoutParams) params).topMargin = -1;
        view.setLayoutParams(params);
    }

    private void connectView(View view, int i, int i2, int i3, int i4) {
        ConstraintLayout.LayoutParams params = params(view);
        int[] iArr = this.mBoxViewIds;
        params.leftToLeft = iArr[i2];
        params.topToTop = iArr[i];
        params.rightToRight = iArr[(i2 + i4) - 1];
        params.bottomToBottom = iArr[(i + i3) - 1];
        view.setLayoutParams(params);
    }

    private boolean generateGrid(boolean z) {
        boolean z2;
        int[][] parseSpans;
        int[][] parseSpans2;
        if (this.mContainer == null || this.mRows < 1 || this.mColumns < 1) {
            return false;
        }
        if (z) {
            for (int i = 0; i < this.mPositionMatrix.length; i++) {
                int i2 = 0;
                while (true) {
                    boolean[][] zArr = this.mPositionMatrix;
                    if (i2 < zArr[0].length) {
                        zArr[i][i2] = true;
                        i2++;
                    }
                }
            }
            this.mSpanIds.clear();
        }
        this.mNextAvailableIndex = 0;
        buildBoxes();
        String str = this.mStrSkips;
        if (str != null && !str.trim().isEmpty() && (parseSpans2 = parseSpans(this.mStrSkips)) != null) {
            z2 = handleSkips(parseSpans2);
        } else {
            z2 = true;
        }
        String str2 = this.mStrSpans;
        if (str2 != null && !str2.trim().isEmpty() && (parseSpans = parseSpans(this.mStrSpans)) != null) {
            z2 &= handleSpans(this.mIds, parseSpans);
        }
        if (!(z2 & arrangeWidgets()) && this.mValidateInputs) {
            return false;
        }
        return true;
    }

    private int getColByIndex(int i) {
        if (this.mOrientation == 1) {
            return i / this.mRows;
        }
        return i % this.mColumns;
    }

    private int getNextPosition() {
        boolean z = false;
        int i = 0;
        while (!z) {
            i = this.mNextAvailableIndex;
            if (i >= this.mRows * this.mColumns) {
                return -1;
            }
            int rowByIndex = getRowByIndex(i);
            int colByIndex = getColByIndex(this.mNextAvailableIndex);
            boolean[] zArr = this.mPositionMatrix[rowByIndex];
            if (zArr[colByIndex]) {
                zArr[colByIndex] = false;
                z = true;
            }
            this.mNextAvailableIndex++;
        }
        return i;
    }

    private int getRowByIndex(int i) {
        if (this.mOrientation == 1) {
            return i % this.mRows;
        }
        return i / this.mColumns;
    }

    private boolean handleSkips(int[][] iArr) {
        for (int i = 0; i < iArr.length; i++) {
            int rowByIndex = getRowByIndex(iArr[i][0]);
            int colByIndex = getColByIndex(iArr[i][0]);
            int[] iArr2 = iArr[i];
            if (!invalidatePositions(rowByIndex, colByIndex, iArr2[1], iArr2[2])) {
                return false;
            }
        }
        return true;
    }

    private boolean handleSpans(int[] iArr, int[][] iArr2) {
        View[] views = getViews(this.mContainer);
        for (int i = 0; i < iArr2.length; i++) {
            int rowByIndex = getRowByIndex(iArr2[i][0]);
            int colByIndex = getColByIndex(iArr2[i][0]);
            int[] iArr3 = iArr2[i];
            if (!invalidatePositions(rowByIndex, colByIndex, iArr3[1], iArr3[2])) {
                return false;
            }
            View view = views[i];
            int[] iArr4 = iArr2[i];
            connectView(view, rowByIndex, colByIndex, iArr4[1], iArr4[2]);
            this.mSpanIds.add(Integer.valueOf(iArr[i]));
        }
        return true;
    }

    private void initVariables() {
        boolean[][] zArr = (boolean[][]) Array.newInstance((Class<?>) Boolean.TYPE, this.mRows, this.mColumns);
        this.mPositionMatrix = zArr;
        for (boolean[] zArr2 : zArr) {
            Arrays.fill(zArr2, true);
        }
    }

    private boolean invalidatePositions(int i, int i2, int i3, int i4) {
        for (int i5 = i; i5 < i + i3; i5++) {
            for (int i6 = i2; i6 < i2 + i4; i6++) {
                boolean[][] zArr = this.mPositionMatrix;
                if (i5 < zArr.length && i6 < zArr[0].length) {
                    boolean[] zArr2 = zArr[i5];
                    if (zArr2[i6]) {
                        zArr2[i6] = false;
                    }
                }
                return false;
            }
        }
        return true;
    }

    private boolean isSpansValid(CharSequence charSequence) {
        return true;
    }

    private boolean isWeightsValid(String str) {
        return true;
    }

    private View makeNewView() {
        View view = new View(getContext());
        view.setId(View.generateViewId());
        view.setVisibility(4);
        this.mContainer.addView(view, new ConstraintLayout.LayoutParams(0, 0));
        return view;
    }

    private ConstraintLayout.LayoutParams params(View view) {
        return (ConstraintLayout.LayoutParams) view.getLayoutParams();
    }

    private int[][] parseSpans(String str) {
        if (!isSpansValid(str)) {
            return null;
        }
        String[] split = str.split(",");
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, split.length, 3);
        for (int i = 0; i < split.length; i++) {
            String[] split2 = split[i].trim().split(":");
            String[] split3 = split2[1].split("x");
            iArr[i][0] = Integer.parseInt(split2[0]);
            iArr[i][1] = Integer.parseInt(split3[0]);
            iArr[i][2] = Integer.parseInt(split3[1]);
        }
        return iArr;
    }

    private float[] parseWeights(int i, String str) {
        float[] fArr = null;
        if (str != null && !str.trim().isEmpty()) {
            String[] split = str.split(",");
            if (split.length != i) {
                return null;
            }
            fArr = new float[i];
            for (int i2 = 0; i2 < i; i2++) {
                fArr[i2] = Float.parseFloat(split[i2].trim());
            }
        }
        return fArr;
    }

    private void setBoxViewHorizontalChains() {
        int i;
        int id = getId();
        int max = Math.max(this.mRows, this.mColumns);
        float[] parseWeights = parseWeights(this.mColumns, this.mStrColumnWeights);
        int i2 = 0;
        ConstraintLayout.LayoutParams params = params(this.mBoxViews[0]);
        if (this.mColumns == 1) {
            clearHParams(this.mBoxViews[0]);
            params.leftToLeft = id;
            params.rightToRight = id;
            this.mBoxViews[0].setLayoutParams(params);
            return;
        }
        while (true) {
            i = this.mColumns;
            if (i2 >= i) {
                break;
            }
            ConstraintLayout.LayoutParams params2 = params(this.mBoxViews[i2]);
            clearHParams(this.mBoxViews[i2]);
            if (parseWeights != null) {
                params2.horizontalWeight = parseWeights[i2];
            }
            if (i2 > 0) {
                params2.leftToRight = this.mBoxViewIds[i2 - 1];
            } else {
                params2.leftToLeft = id;
            }
            if (i2 < this.mColumns - 1) {
                params2.rightToLeft = this.mBoxViewIds[i2 + 1];
            } else {
                params2.rightToRight = id;
            }
            if (i2 > 0) {
                ((ViewGroup.MarginLayoutParams) params2).leftMargin = (int) this.mHorizontalGaps;
            }
            this.mBoxViews[i2].setLayoutParams(params2);
            i2++;
        }
        while (i < max) {
            ConstraintLayout.LayoutParams params3 = params(this.mBoxViews[i]);
            clearHParams(this.mBoxViews[i]);
            params3.leftToLeft = id;
            params3.rightToRight = id;
            this.mBoxViews[i].setLayoutParams(params3);
            i++;
        }
    }

    private void setBoxViewVerticalChains() {
        int i;
        int id = getId();
        int max = Math.max(this.mRows, this.mColumns);
        float[] parseWeights = parseWeights(this.mRows, this.mStrRowWeights);
        int i2 = 0;
        if (this.mRows == 1) {
            ConstraintLayout.LayoutParams params = params(this.mBoxViews[0]);
            clearVParams(this.mBoxViews[0]);
            params.topToTop = id;
            params.bottomToBottom = id;
            this.mBoxViews[0].setLayoutParams(params);
            return;
        }
        while (true) {
            i = this.mRows;
            if (i2 >= i) {
                break;
            }
            ConstraintLayout.LayoutParams params2 = params(this.mBoxViews[i2]);
            clearVParams(this.mBoxViews[i2]);
            if (parseWeights != null) {
                params2.verticalWeight = parseWeights[i2];
            }
            if (i2 > 0) {
                params2.topToBottom = this.mBoxViewIds[i2 - 1];
            } else {
                params2.topToTop = id;
            }
            if (i2 < this.mRows - 1) {
                params2.bottomToTop = this.mBoxViewIds[i2 + 1];
            } else {
                params2.bottomToBottom = id;
            }
            if (i2 > 0) {
                ((ViewGroup.MarginLayoutParams) params2).topMargin = (int) this.mHorizontalGaps;
            }
            this.mBoxViews[i2].setLayoutParams(params2);
            i2++;
        }
        while (i < max) {
            ConstraintLayout.LayoutParams params3 = params(this.mBoxViews[i]);
            clearVParams(this.mBoxViews[i]);
            params3.topToTop = id;
            params3.bottomToBottom = id;
            this.mBoxViews[i].setLayoutParams(params3);
            i++;
        }
    }

    private void updateActualRowsAndColumns() {
        int i;
        int i2 = this.mRowsSet;
        if (i2 != 0 && (i = this.mColumnsSet) != 0) {
            this.mRows = i2;
            this.mColumns = i;
            return;
        }
        int i3 = this.mColumnsSet;
        if (i3 > 0) {
            this.mColumns = i3;
            this.mRows = ((this.mCount + i3) - 1) / i3;
        } else if (i2 > 0) {
            this.mRows = i2;
            this.mColumns = ((this.mCount + i2) - 1) / i2;
        } else {
            int sqrt = (int) (Math.sqrt(this.mCount) + 1.5d);
            this.mRows = sqrt;
            this.mColumns = ((this.mCount + sqrt) - 1) / sqrt;
        }
    }

    public String getColumnWeights() {
        return this.mStrColumnWeights;
    }

    public int getColumns() {
        return this.mColumnsSet;
    }

    public float getHorizontalGaps() {
        return this.mHorizontalGaps;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public String getRowWeights() {
        return this.mStrRowWeights;
    }

    public int getRows() {
        return this.mRowsSet;
    }

    public String getSkips() {
        return this.mStrSkips;
    }

    public String getSpans() {
        return this.mStrSpans;
    }

    public float getVerticalGaps() {
        return this.mVerticalGaps;
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper
    public void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        this.mUseViewMeasure = true;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.Grid);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.Grid_grid_rows) {
                    this.mRowsSet = obtainStyledAttributes.getInteger(index, 0);
                } else if (index == R.styleable.Grid_grid_columns) {
                    this.mColumnsSet = obtainStyledAttributes.getInteger(index, 0);
                } else if (index == R.styleable.Grid_grid_spans) {
                    this.mStrSpans = obtainStyledAttributes.getString(index);
                } else if (index == R.styleable.Grid_grid_skips) {
                    this.mStrSkips = obtainStyledAttributes.getString(index);
                } else if (index == R.styleable.Grid_grid_rowWeights) {
                    this.mStrRowWeights = obtainStyledAttributes.getString(index);
                } else if (index == R.styleable.Grid_grid_columnWeights) {
                    this.mStrColumnWeights = obtainStyledAttributes.getString(index);
                } else if (index == R.styleable.Grid_grid_orientation) {
                    this.mOrientation = obtainStyledAttributes.getInt(index, 0);
                } else if (index == R.styleable.Grid_grid_horizontalGaps) {
                    this.mHorizontalGaps = obtainStyledAttributes.getDimension(index, 0.0f);
                } else if (index == R.styleable.Grid_grid_verticalGaps) {
                    this.mVerticalGaps = obtainStyledAttributes.getDimension(index, 0.0f);
                } else if (index == R.styleable.Grid_grid_validateInputs) {
                    this.mValidateInputs = obtainStyledAttributes.getBoolean(index, false);
                } else if (index == R.styleable.Grid_grid_useRtl) {
                    this.mUseRtl = obtainStyledAttributes.getBoolean(index, false);
                }
            }
            updateActualRowsAndColumns();
            initVariables();
            obtainStyledAttributes.recycle();
        }
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mContainer = (ConstraintLayout) getParent();
        generateGrid(false);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode()) {
            return;
        }
        Paint paint = new Paint();
        paint.setColor(SupportMenu.CATEGORY_MASK);
        paint.setStyle(Paint.Style.STROKE);
        int top = getTop();
        int left = getLeft();
        int bottom = getBottom();
        int right = getRight();
        View[] viewArr = this.mBoxViews;
        int length = viewArr.length;
        int i = 0;
        while (i < length) {
            View view = viewArr[i];
            int left2 = view.getLeft() - left;
            int top2 = view.getTop() - top;
            int right2 = view.getRight() - left;
            int bottom2 = view.getBottom() - top;
            canvas.drawRect(left2, 0.0f, right2, bottom - top, paint);
            canvas.drawRect(0.0f, top2, right - left, bottom2, paint);
            i++;
            top = top;
        }
    }

    public void setColumnWeights(String str) {
        if (!isWeightsValid(str)) {
            return;
        }
        String str2 = this.mStrColumnWeights;
        if (str2 != null && str2.equals(str)) {
            return;
        }
        this.mStrColumnWeights = str;
        generateGrid(true);
        invalidate();
    }

    public void setColumns(int i) {
        if (i > 50 || this.mColumnsSet == i) {
            return;
        }
        this.mColumnsSet = i;
        updateActualRowsAndColumns();
        initVariables();
        generateGrid(false);
        invalidate();
    }

    public void setHorizontalGaps(float f) {
        if (f < 0.0f || this.mHorizontalGaps == f) {
            return;
        }
        this.mHorizontalGaps = f;
        generateGrid(true);
        invalidate();
    }

    public void setOrientation(int i) {
        if ((i != 0 && i != 1) || this.mOrientation == i) {
            return;
        }
        this.mOrientation = i;
        generateGrid(true);
        invalidate();
    }

    public void setRowWeights(String str) {
        if (!isWeightsValid(str)) {
            return;
        }
        String str2 = this.mStrRowWeights;
        if (str2 != null && str2.equals(str)) {
            return;
        }
        this.mStrRowWeights = str;
        generateGrid(true);
        invalidate();
    }

    public void setRows(int i) {
        if (i > 50 || this.mRowsSet == i) {
            return;
        }
        this.mRowsSet = i;
        updateActualRowsAndColumns();
        initVariables();
        generateGrid(false);
        invalidate();
    }

    public void setSkips(String str) {
        if (!isSpansValid(str)) {
            return;
        }
        String str2 = this.mStrSkips;
        if (str2 != null && str2.equals(str)) {
            return;
        }
        this.mStrSkips = str;
        generateGrid(true);
        invalidate();
    }

    public void setSpans(CharSequence charSequence) {
        if (!isSpansValid(charSequence)) {
            return;
        }
        String str = this.mStrSpans;
        if (str != null && str.contentEquals(charSequence)) {
            return;
        }
        this.mStrSpans = charSequence.toString();
        generateGrid(true);
        invalidate();
    }

    public void setVerticalGaps(float f) {
        if (f < 0.0f || this.mVerticalGaps == f) {
            return;
        }
        this.mVerticalGaps = f;
        generateGrid(true);
        invalidate();
    }

    public Grid(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMaxRows = 50;
        this.mMaxColumns = 50;
        this.mNextAvailableIndex = 0;
        this.mSpanIds = new HashSet();
    }

    public Grid(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMaxRows = 50;
        this.mMaxColumns = 50;
        this.mNextAvailableIndex = 0;
        this.mSpanIds = new HashSet();
    }
}
