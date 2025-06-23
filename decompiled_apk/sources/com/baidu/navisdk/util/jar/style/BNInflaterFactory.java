package com.baidu.navisdk.util.jar.style;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.navisdk.ui.util.b;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes8.dex */
public class BNInflaterFactory implements LayoutInflater.Factory2 {
    public static final int ID_NULL = 0;
    private static final String TAG = "BNInflaterFactory";
    private static long mLastReleaseTime;
    private final ConcurrentHashMap<Integer, StyleCommonView> mStyleCommonViewMap = new ConcurrentHashMap<>();
    private static final String[] sClassPrefixList = {"android.widget.", "android.webkit.", "android.view.", "android.app."};
    private static final HashMap<String, Constructor<? extends View>> mConstructorMap = new HashMap<>();
    private static volatile BNInflaterFactory mInstance = null;

    private BNInflaterFactory() {
    }

    private synchronized void addToCache(StyleCommonView styleCommonView) {
        this.mStyleCommonViewMap.put(Integer.valueOf(styleCommonView.mKey), styleCommonView);
    }

    private StyleAttr createAttr(String str, String str2, Resources resources) {
        int parseInt;
        if (str2 == null || !str2.startsWith("@") || (parseInt = Integer.parseInt(str2.substring(1))) == 0) {
            return null;
        }
        return createAttr(str, parseInt, resources);
    }

    private StyleCommonView createStyleCommonView(View view) {
        if (view instanceof TextView) {
            return new StyleTextView(view);
        }
        if (view instanceof ImageView) {
            return new StyleImageView(view);
        }
        return new StyleCommonView(view);
    }

    public static BNInflaterFactory getInstance() {
        if (mInstance == null) {
            synchronized (BNInflaterFactory.class) {
                try {
                    if (mInstance == null) {
                        mInstance = new BNInflaterFactory();
                    }
                } finally {
                }
            }
        }
        return mInstance;
    }

    private synchronized StyleCommonView getStyleView(View view) {
        StyleCommonView styleCommonView;
        styleCommonView = this.mStyleCommonViewMap.get(Integer.valueOf(view.hashCode()));
        if (styleCommonView == null) {
            styleCommonView = createStyleCommonView(view);
            addToCache(styleCommonView);
        }
        return styleCommonView;
    }

    private View handleCreateView(String str, Context context, AttributeSet attributeSet) {
        View view = null;
        if (-1 == str.indexOf(46)) {
            for (String str2 : sClassPrefixList) {
                try {
                    view = handleCreateView(str, str2, context, attributeSet);
                } catch (ClassNotFoundException unused) {
                }
                if (view != null) {
                    return view;
                }
            }
            return view;
        }
        try {
            return handleCreateView(str, null, context, attributeSet);
        } catch (ClassNotFoundException unused2) {
            return null;
        }
    }

    private void parseAttrs(Context context, AttributeSet attributeSet, View view) {
        int resourceId;
        int resourceId2;
        if (view == null) {
            LogUtil.e(TAG, "parseAttrs fail view is null");
            return;
        }
        Resources resources = context.getResources();
        int attributeCount = attributeSet.getAttributeCount();
        StyleAttr styleAttr = null;
        StyleAttr styleAttr2 = null;
        StyleAttr styleAttr3 = null;
        StyleAttr[] styleAttrArr = null;
        StyleAttr styleAttr4 = null;
        for (int i = 0; i < attributeCount; i++) {
            String attributeName = attributeSet.getAttributeName(i);
            String attributeValue = attributeSet.getAttributeValue(i);
            if (StyleAttr.NAME_BACKGROUND.equals(attributeName)) {
                styleAttr2 = createAttr(attributeName, attributeValue, resources);
            } else if (StyleAttr.NAME_TEXT_COLOR.equals(attributeName)) {
                styleAttr3 = createAttr(attributeName, attributeValue, resources);
            } else if (StyleAttr.NAME_DRAWABLE_LEFT.equals(attributeName)) {
                if (styleAttrArr == null) {
                    styleAttrArr = new StyleAttr[4];
                }
                styleAttrArr[0] = createAttr(attributeName, attributeValue, resources);
            } else if (StyleAttr.NAME_DRAWABLE_TOP.equals(attributeName)) {
                if (styleAttrArr == null) {
                    styleAttrArr = new StyleAttr[4];
                }
                styleAttrArr[1] = createAttr(attributeName, attributeValue, resources);
            } else if (StyleAttr.NAME_DRAWABLE_RIGHT.equals(attributeName)) {
                if (styleAttrArr == null) {
                    styleAttrArr = new StyleAttr[4];
                }
                styleAttrArr[2] = createAttr(attributeName, attributeValue, resources);
            } else if (StyleAttr.NAME_DRAWABLE_BOTTOM.equals(attributeName)) {
                if (styleAttrArr == null) {
                    styleAttrArr = new StyleAttr[4];
                }
                styleAttrArr[3] = createAttr(attributeName, attributeValue, resources);
            } else if ("src".equals(attributeName) && (view instanceof ImageView)) {
                styleAttr4 = createAttr(attributeName, attributeValue, resources);
            } else if ("style".equals(attributeName)) {
                styleAttr = createAttr(attributeName, attributeValue, resources);
            }
        }
        if (styleAttr != null && (styleAttr2 == null || styleAttr3 == null)) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(styleAttr.mId, new int[]{R.attr.textColor, R.attr.background});
            if (styleAttr3 == null && obtainStyledAttributes.hasValue(0) && (resourceId2 = obtainStyledAttributes.getResourceId(0, 0)) != 0) {
                styleAttr3 = createAttr(StyleAttr.NAME_TEXT_COLOR, resourceId2, resources);
            }
            if (styleAttr2 == null && obtainStyledAttributes.hasValue(1) && (resourceId = obtainStyledAttributes.getResourceId(1, 0)) != 0) {
                styleAttr2 = createAttr(StyleAttr.NAME_BACKGROUND, resourceId, resources);
            }
            obtainStyledAttributes.recycle();
        }
        if (styleAttr2 != null || styleAttr3 != null || styleAttrArr != null || styleAttr4 != null) {
            StyleCommonView createStyleCommonView = createStyleCommonView(view);
            createStyleCommonView.mBackGroundAttr = styleAttr2;
            if (createStyleCommonView instanceof StyleTextView) {
                StyleTextView styleTextView = (StyleTextView) createStyleCommonView;
                styleTextView.mTextColorAttr = styleAttr3;
                styleTextView.mComponentDrawableAttr = styleAttrArr;
            }
            if (createStyleCommonView instanceof StyleImageView) {
                ((StyleImageView) createStyleCommonView).mImageResourceAttr = styleAttr4;
            }
            createStyleCommonView.updateStyle();
            addToCache(createStyleCommonView);
        }
    }

    private synchronized void removeFromCache(StyleCommonView styleCommonView) {
        this.mStyleCommonViewMap.remove(Integer.valueOf(styleCommonView.mKey));
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(@Nullable @oOoXoXO View view, @NonNull @OOXIXo String str, @NonNull @OOXIXo Context context, @NonNull @OOXIXo AttributeSet attributeSet) {
        View handleCreateView = handleCreateView(str, context, attributeSet);
        if (handleCreateView == null) {
            LogUtil.e(TAG, "view is null name:" + str);
        } else {
            parseAttrs(context, attributeSet, handleCreateView);
        }
        return handleCreateView;
    }

    public void releaseNullStyle() {
        WeakReference<View> weakReference;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime - mLastReleaseTime > 5000) {
            return;
        }
        Iterator<Map.Entry<Integer, StyleCommonView>> it = this.mStyleCommonViewMap.entrySet().iterator();
        while (it.hasNext()) {
            StyleCommonView value = it.next().getValue();
            if (value == null || (weakReference = value.mView) == null || weakReference.get() == null) {
                it.remove();
            }
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "releaseNullStyle cost time:" + (SystemClock.elapsedRealtime() - elapsedRealtime));
        }
    }

    public void setBackground(View view, int i) {
        StyleCommonView styleView = getStyleView(view);
        if (i == 0) {
            styleView.mBackGroundAttr = null;
        } else {
            styleView.mBackGroundAttr = createAttr(StyleAttr.NAME_BACKGROUND, i, JarUtils.getResources());
        }
        styleView.updateStyle();
    }

    public void setCompoundDrawables(TextView textView, int i, int i2, int i3, int i4) {
        StyleTextView styleTextView = (StyleTextView) getStyleView(textView);
        StyleAttr[] styleAttrArr = new StyleAttr[4];
        styleTextView.mComponentDrawableAttr = styleAttrArr;
        if (i > 0) {
            styleAttrArr[0] = createAttr(StyleAttr.NAME_DRAWABLE_LEFT, i, JarUtils.getResources());
        }
        if (i2 > 0) {
            styleTextView.mComponentDrawableAttr[1] = createAttr(StyleAttr.NAME_DRAWABLE_TOP, i2, JarUtils.getResources());
        }
        if (i3 > 0) {
            styleTextView.mComponentDrawableAttr[2] = createAttr(StyleAttr.NAME_DRAWABLE_RIGHT, i2, JarUtils.getResources());
        }
        if (i4 > 0) {
            styleTextView.mComponentDrawableAttr[3] = createAttr(StyleAttr.NAME_DRAWABLE_BOTTOM, i2, JarUtils.getResources());
        }
        styleTextView.updateStyle();
    }

    public void setImageResource(View view, int i) {
        StyleImageView styleImageView = (StyleImageView) getStyleView(view);
        styleImageView.mImageResourceAttr = createAttr(StyleAttr.NAME_BACKGROUND, i, JarUtils.getResources());
        styleImageView.updateStyle();
    }

    public void setTextColor(TextView textView, int i) {
        StyleCommonView styleView = getStyleView(textView);
        if (!(styleView instanceof StyleTextView)) {
            removeFromCache(styleView);
            if (LogUtil.LOGGABLE) {
                LogUtil.e(TAG, "setTextColor error StyleTextView error");
            }
        }
        StyleTextView styleTextView = (StyleTextView) getStyleView(textView);
        styleTextView.mTextColorAttr = createAttr(StyleAttr.NAME_TEXT_COLOR, i, JarUtils.getResources());
        styleTextView.updateStyle();
    }

    public void updateStyle(boolean z) {
        WeakReference<View> weakReference;
        if (z == b.b()) {
            return;
        }
        b.b(z);
        Iterator<Map.Entry<Integer, StyleCommonView>> it = this.mStyleCommonViewMap.entrySet().iterator();
        while (it.hasNext()) {
            StyleCommonView value = it.next().getValue();
            if (value != null && (weakReference = value.mView) != null && weakReference.get() != null) {
                value.updateStyle();
            } else {
                it.remove();
            }
        }
    }

    public synchronized void removeFromCache(View view) {
        this.mStyleCommonViewMap.remove(Integer.valueOf(view.hashCode()));
    }

    private StyleAttr createAttr(String str, int i, Resources resources) {
        StyleAttr styleAttr = new StyleAttr();
        String resourceEntryName = resources.getResourceEntryName(i);
        String resourceTypeName = resources.getResourceTypeName(i);
        styleAttr.mAttrName = str;
        styleAttr.mId = i;
        styleAttr.mEntryName = resourceEntryName;
        styleAttr.mEntryType = resourceTypeName;
        return styleAttr;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View handleCreateView = handleCreateView(str, context, attributeSet);
        if (handleCreateView == null) {
            LogUtil.e(TAG, "view is null name:" + str);
        } else {
            parseAttrs(context, attributeSet, handleCreateView);
        }
        return handleCreateView;
    }

    private View handleCreateView(String str, String str2, Context context, AttributeSet attributeSet) throws ClassNotFoundException {
        String str3;
        ClassLoader classLoader = context.getClassLoader();
        HashMap<String, Constructor<? extends View>> hashMap = mConstructorMap;
        Constructor<? extends View> constructor = hashMap.get(str);
        if (constructor == null) {
            if (str2 == null) {
                str3 = str;
            } else {
                str3 = str2 + str;
            }
            Class<? extends U> asSubclass = classLoader.loadClass(str3).asSubclass(View.class);
            if (asSubclass == 0) {
                LogUtil.e(TAG, "handleCreateView fail c is null name=" + str);
                return null;
            }
            try {
                constructor = asSubclass.getConstructor(Context.class, AttributeSet.class);
                hashMap.put(str, constructor);
            } catch (Exception e) {
                if (LogUtil.LOGGABLE) {
                    e.printStackTrace();
                    LogUtil.printException(TAG, e);
                }
            }
        }
        try {
            View newInstance = constructor.newInstance(context, attributeSet);
            if (newInstance instanceof ViewStub) {
                ViewStub viewStub = (ViewStub) newInstance;
                LayoutInflater cloneInContext = LayoutInflater.from(viewStub.getContext()).cloneInContext(viewStub.getContext());
                cloneInContext.setFactory(getInstance());
                viewStub.setLayoutInflater(cloneInContext);
            }
            return newInstance;
        } catch (Exception e2) {
            if (LogUtil.LOGGABLE) {
                e2.printStackTrace();
                LogUtil.printException(TAG, e2);
            }
            return null;
        }
    }
}
