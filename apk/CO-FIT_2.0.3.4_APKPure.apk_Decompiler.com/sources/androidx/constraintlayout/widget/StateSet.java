package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;

public class StateSet {
    private static final boolean DEBUG = false;
    public static final String TAG = "ConstraintLayoutStates";
    private ConstraintsChangedListener mConstraintsChangedListener = null;
    int mCurrentConstraintNumber = -1;
    int mCurrentStateId = -1;
    int mDefaultState = -1;
    private SparseArray<State> mStateList = new SparseArray<>();

    public static class State {
        int mConstraintID = -1;
        int mId;
        boolean mIsLayout;
        ArrayList<Variant> mVariants = new ArrayList<>();

        public State(Context context, XmlPullParser xmlPullParser) {
            this.mIsLayout = false;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.State);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.State_android_id) {
                    this.mId = obtainStyledAttributes.getResourceId(index, this.mId);
                } else if (index == R.styleable.State_constraints) {
                    this.mConstraintID = obtainStyledAttributes.getResourceId(index, this.mConstraintID);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.mConstraintID);
                    context.getResources().getResourceName(this.mConstraintID);
                    if ("layout".equals(resourceTypeName)) {
                        this.mIsLayout = true;
                    }
                }
            }
            obtainStyledAttributes.recycle();
        }

        public void add(Variant variant) {
            this.mVariants.add(variant);
        }

        public int findMatch(float f, float f2) {
            for (int i = 0; i < this.mVariants.size(); i++) {
                if (this.mVariants.get(i).match(f, f2)) {
                    return i;
                }
            }
            return -1;
        }
    }

    public static class Variant {
        int mConstraintID = -1;
        int mId;
        boolean mIsLayout;
        float mMaxHeight = Float.NaN;
        float mMaxWidth = Float.NaN;
        float mMinHeight = Float.NaN;
        float mMinWidth = Float.NaN;

        public Variant(Context context, XmlPullParser xmlPullParser) {
            this.mIsLayout = false;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.Variant);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.Variant_constraints) {
                    this.mConstraintID = obtainStyledAttributes.getResourceId(index, this.mConstraintID);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.mConstraintID);
                    context.getResources().getResourceName(this.mConstraintID);
                    if ("layout".equals(resourceTypeName)) {
                        this.mIsLayout = true;
                    }
                } else if (index == R.styleable.Variant_region_heightLessThan) {
                    this.mMaxHeight = obtainStyledAttributes.getDimension(index, this.mMaxHeight);
                } else if (index == R.styleable.Variant_region_heightMoreThan) {
                    this.mMinHeight = obtainStyledAttributes.getDimension(index, this.mMinHeight);
                } else if (index == R.styleable.Variant_region_widthLessThan) {
                    this.mMaxWidth = obtainStyledAttributes.getDimension(index, this.mMaxWidth);
                } else if (index == R.styleable.Variant_region_widthMoreThan) {
                    this.mMinWidth = obtainStyledAttributes.getDimension(index, this.mMinWidth);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            obtainStyledAttributes.recycle();
        }

        public boolean match(float f, float f2) {
            if (!Float.isNaN(this.mMinWidth) && f < this.mMinWidth) {
                return false;
            }
            if (!Float.isNaN(this.mMinHeight) && f2 < this.mMinHeight) {
                return false;
            }
            if (!Float.isNaN(this.mMaxWidth) && f > this.mMaxWidth) {
                return false;
            }
            if (Float.isNaN(this.mMaxHeight) || f2 <= this.mMaxHeight) {
                return true;
            }
            return false;
        }
    }

    public StateSet(Context context, XmlPullParser xmlPullParser) {
        load(context, xmlPullParser);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void load(android.content.Context r11, org.xmlpull.v1.XmlPullParser r12) {
        /*
            r10 = this;
            java.lang.String r0 = "Error parsing XML resource"
            java.lang.String r1 = "ConstraintLayoutStates"
            android.util.AttributeSet r2 = android.util.Xml.asAttributeSet(r12)
            int[] r3 = androidx.constraintlayout.widget.R.styleable.StateSet
            android.content.res.TypedArray r2 = r11.obtainStyledAttributes(r2, r3)
            int r3 = r2.getIndexCount()
            r4 = 0
            r5 = 0
        L_0x0014:
            if (r5 >= r3) goto L_0x0029
            int r6 = r2.getIndex(r5)
            int r7 = androidx.constraintlayout.widget.R.styleable.StateSet_defaultState
            if (r6 != r7) goto L_0x0026
            int r7 = r10.mDefaultState
            int r6 = r2.getResourceId(r6, r7)
            r10.mDefaultState = r6
        L_0x0026:
            int r5 = r5 + 1
            goto L_0x0014
        L_0x0029:
            r2.recycle()
            int r2 = r12.getEventType()     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0048 }
            r3 = 0
        L_0x0031:
            r5 = 1
            if (r2 == r5) goto L_0x00a6
            java.lang.String r6 = "StateSet"
            r7 = 3
            r8 = 2
            if (r2 == r8) goto L_0x004c
            if (r2 == r7) goto L_0x003d
            goto L_0x009a
        L_0x003d:
            java.lang.String r2 = r12.getName()     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0048 }
            boolean r2 = r6.equals(r2)     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0048 }
            if (r2 == 0) goto L_0x009a
            return
        L_0x0048:
            r11 = move-exception
            goto L_0x009f
        L_0x004a:
            r11 = move-exception
            goto L_0x00a3
        L_0x004c:
            java.lang.String r2 = r12.getName()     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0048 }
            int r9 = r2.hashCode()     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0048 }
            switch(r9) {
                case 80204913: goto L_0x0073;
                case 1301459538: goto L_0x0069;
                case 1382829617: goto L_0x0062;
                case 1901439077: goto L_0x0058;
                default: goto L_0x0057;
            }     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0048 }
        L_0x0057:
            goto L_0x007d
        L_0x0058:
            java.lang.String r5 = "Variant"
            boolean r2 = r2.equals(r5)     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0048 }
            if (r2 == 0) goto L_0x007d
            r5 = 3
            goto L_0x007e
        L_0x0062:
            boolean r2 = r2.equals(r6)     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0048 }
            if (r2 == 0) goto L_0x007d
            goto L_0x007e
        L_0x0069:
            java.lang.String r5 = "LayoutDescription"
            boolean r2 = r2.equals(r5)     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0048 }
            if (r2 == 0) goto L_0x007d
            r5 = 0
            goto L_0x007e
        L_0x0073:
            java.lang.String r5 = "State"
            boolean r2 = r2.equals(r5)     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0048 }
            if (r2 == 0) goto L_0x007d
            r5 = 2
            goto L_0x007e
        L_0x007d:
            r5 = -1
        L_0x007e:
            if (r5 == r8) goto L_0x008e
            if (r5 == r7) goto L_0x0083
            goto L_0x009a
        L_0x0083:
            androidx.constraintlayout.widget.StateSet$Variant r2 = new androidx.constraintlayout.widget.StateSet$Variant     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0048 }
            r2.<init>(r11, r12)     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0048 }
            if (r3 == 0) goto L_0x009a
            r3.add(r2)     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0048 }
            goto L_0x009a
        L_0x008e:
            androidx.constraintlayout.widget.StateSet$State r3 = new androidx.constraintlayout.widget.StateSet$State     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0048 }
            r3.<init>(r11, r12)     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0048 }
            android.util.SparseArray<androidx.constraintlayout.widget.StateSet$State> r2 = r10.mStateList     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0048 }
            int r5 = r3.mId     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0048 }
            r2.put(r5, r3)     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0048 }
        L_0x009a:
            int r2 = r12.next()     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0048 }
            goto L_0x0031
        L_0x009f:
            android.util.Log.e(r1, r0, r11)
            goto L_0x00a6
        L_0x00a3:
            android.util.Log.e(r1, r0, r11)
        L_0x00a6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.StateSet.load(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }

    public int convertToConstraintSet(int i, int i2, float f, float f2) {
        State state = this.mStateList.get(i2);
        if (state == null) {
            return i2;
        }
        if (f != -1.0f && f2 != -1.0f) {
            Iterator<Variant> it = state.mVariants.iterator();
            Variant variant = null;
            while (it.hasNext()) {
                Variant next = it.next();
                if (next.match(f, f2)) {
                    if (i == next.mConstraintID) {
                        return i;
                    }
                    variant = next;
                }
            }
            if (variant != null) {
                return variant.mConstraintID;
            }
            return state.mConstraintID;
        } else if (state.mConstraintID == i) {
            return i;
        } else {
            Iterator<Variant> it2 = state.mVariants.iterator();
            while (it2.hasNext()) {
                if (i == it2.next().mConstraintID) {
                    return i;
                }
            }
            return state.mConstraintID;
        }
    }

    public boolean needsToChange(int i, float f, float f2) {
        Object obj;
        int i2 = this.mCurrentStateId;
        if (i2 != i) {
            return true;
        }
        if (i == -1) {
            obj = this.mStateList.valueAt(0);
        } else {
            obj = this.mStateList.get(i2);
        }
        State state = (State) obj;
        int i3 = this.mCurrentConstraintNumber;
        if ((i3 == -1 || !state.mVariants.get(i3).match(f, f2)) && this.mCurrentConstraintNumber != state.findMatch(f, f2)) {
            return true;
        }
        return false;
    }

    public void setOnConstraintsChanged(ConstraintsChangedListener constraintsChangedListener) {
        this.mConstraintsChangedListener = constraintsChangedListener;
    }

    public int stateGetConstraintID(int i, int i2, int i3) {
        return updateConstraints(-1, i, (float) i2, (float) i3);
    }

    public int updateConstraints(int i, int i2, float f, float f2) {
        State state;
        int findMatch;
        if (i == i2) {
            if (i2 == -1) {
                state = this.mStateList.valueAt(0);
            } else {
                state = this.mStateList.get(this.mCurrentStateId);
            }
            if (state == null) {
                return -1;
            }
            if ((this.mCurrentConstraintNumber != -1 && state.mVariants.get(i).match(f, f2)) || i == (findMatch = state.findMatch(f, f2))) {
                return i;
            }
            if (findMatch == -1) {
                return state.mConstraintID;
            }
            return state.mVariants.get(findMatch).mConstraintID;
        }
        State state2 = this.mStateList.get(i2);
        if (state2 == null) {
            return -1;
        }
        int findMatch2 = state2.findMatch(f, f2);
        if (findMatch2 == -1) {
            return state2.mConstraintID;
        }
        return state2.mVariants.get(findMatch2).mConstraintID;
    }
}
