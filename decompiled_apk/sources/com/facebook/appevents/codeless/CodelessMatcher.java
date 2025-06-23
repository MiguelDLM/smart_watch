package com.facebook.appevents.codeless;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.annotation.UiThread;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.codeless.CodelessLoggingEventListener;
import com.facebook.appevents.codeless.RCTCodelessLoggingEventListener;
import com.facebook.appevents.codeless.internal.Constants;
import com.facebook.appevents.codeless.internal.EventBinding;
import com.facebook.appevents.codeless.internal.ParameterComponent;
import com.facebook.appevents.codeless.internal.PathComponent;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.InternalSettings;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.text.OxI;

/* loaded from: classes8.dex */
public final class CodelessMatcher {

    @OOXIXo
    private static final String CURRENT_CLASS_NAME = ".";

    @OOXIXo
    private static final String PARENT_CLASS_NAME = "..";

    @oOoXoXO
    private static CodelessMatcher codelessMatcher;

    @OOXIXo
    private final Set<Activity> activitiesSet;

    @OOXIXo
    private final HashMap<Integer, HashSet<String>> activityToListenerMap;

    @OOXIXo
    private HashSet<String> listenerSet;

    @OOXIXo
    private final Handler uiThreadHandler;

    @OOXIXo
    private final Set<ViewMatcher> viewMatchers;

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    @oOoXoXO
    private static final String TAG = CodelessMatcher.class.getCanonicalName();

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @x0XOIxOo
        @OOXIXo
        public final synchronized CodelessMatcher getInstance() {
            CodelessMatcher access$getCodelessMatcher$cp;
            try {
                if (CodelessMatcher.access$getCodelessMatcher$cp() == null) {
                    CodelessMatcher.access$setCodelessMatcher$cp(new CodelessMatcher(null));
                }
                access$getCodelessMatcher$cp = CodelessMatcher.access$getCodelessMatcher$cp();
                if (access$getCodelessMatcher$cp == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.facebook.appevents.codeless.CodelessMatcher");
                }
            } catch (Throwable th) {
                throw th;
            }
            return access$getCodelessMatcher$cp;
        }

        @x0XOIxOo
        @OOXIXo
        @UiThread
        public final Bundle getParameters(@oOoXoXO EventBinding eventBinding, @OOXIXo View rootView, @OOXIXo View hostView) {
            List<MatchedView> findViewByPath;
            IIX0o.x0xO0oo(rootView, "rootView");
            IIX0o.x0xO0oo(hostView, "hostView");
            Bundle bundle = new Bundle();
            if (eventBinding == null) {
                return bundle;
            }
            List<ParameterComponent> viewParameters = eventBinding.getViewParameters();
            if (viewParameters != null) {
                for (ParameterComponent parameterComponent : viewParameters) {
                    if (parameterComponent.getValue() != null && parameterComponent.getValue().length() > 0) {
                        bundle.putString(parameterComponent.getName(), parameterComponent.getValue());
                    } else if (parameterComponent.getPath().size() > 0) {
                        if (IIX0o.Oxx0IOOO(parameterComponent.getPathType(), Constants.PATH_TYPE_RELATIVE)) {
                            ViewMatcher.Companion companion = ViewMatcher.Companion;
                            List<PathComponent> path = parameterComponent.getPath();
                            String simpleName = hostView.getClass().getSimpleName();
                            IIX0o.oO(simpleName, "hostView.javaClass.simpleName");
                            findViewByPath = companion.findViewByPath(eventBinding, hostView, path, 0, -1, simpleName);
                        } else {
                            ViewMatcher.Companion companion2 = ViewMatcher.Companion;
                            List<PathComponent> path2 = parameterComponent.getPath();
                            String simpleName2 = rootView.getClass().getSimpleName();
                            IIX0o.oO(simpleName2, "rootView.javaClass.simpleName");
                            findViewByPath = companion2.findViewByPath(eventBinding, rootView, path2, 0, -1, simpleName2);
                        }
                        Iterator<MatchedView> it = findViewByPath.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                MatchedView next = it.next();
                                if (next.getView() != null) {
                                    ViewHierarchy viewHierarchy = ViewHierarchy.INSTANCE;
                                    String textOfView = ViewHierarchy.getTextOfView(next.getView());
                                    if (textOfView.length() > 0) {
                                        bundle.putString(parameterComponent.getName(), textOfView);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return bundle;
        }

        private Companion() {
        }
    }

    /* loaded from: classes8.dex */
    public static final class MatchedView {

        @oOoXoXO
        private final WeakReference<View> view;

        @OOXIXo
        private final String viewMapKey;

        public MatchedView(@OOXIXo View view, @OOXIXo String viewMapKey) {
            IIX0o.x0xO0oo(view, "view");
            IIX0o.x0xO0oo(viewMapKey, "viewMapKey");
            this.view = new WeakReference<>(view);
            this.viewMapKey = viewMapKey;
        }

        @oOoXoXO
        public final View getView() {
            WeakReference<View> weakReference = this.view;
            if (weakReference == null) {
                return null;
            }
            return weakReference.get();
        }

        @OOXIXo
        public final String getViewMapKey() {
            return this.viewMapKey;
        }
    }

    @UiThread
    /* loaded from: classes8.dex */
    public static final class ViewMatcher implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, Runnable {

        @OOXIXo
        public static final Companion Companion = new Companion(null);

        @OOXIXo
        private final String activityName;

        @oOoXoXO
        private List<EventBinding> eventBindings;

        @OOXIXo
        private final Handler handler;

        @OOXIXo
        private final HashSet<String> listenerSet;

        @OOXIXo
        private final WeakReference<View> rootView;

        /* loaded from: classes8.dex */
        public static final class Companion {
            public /* synthetic */ Companion(IIXOooo iIXOooo) {
                this();
            }

            private final List<View> findVisibleChildren(ViewGroup viewGroup) {
                ArrayList arrayList = new ArrayList();
                int childCount = viewGroup.getChildCount();
                if (childCount > 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i + 1;
                        View child = viewGroup.getChildAt(i);
                        if (child.getVisibility() == 0) {
                            IIX0o.oO(child, "child");
                            arrayList.add(child);
                        }
                        if (i2 >= childCount) {
                            break;
                        }
                        i = i2;
                    }
                }
                return arrayList;
            }

            /* JADX WARN: Code restructure failed: missing block: B:14:0x0065, code lost:
            
                if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(r10.getClass().getSimpleName(), (java.lang.String) r12.get(r12.size() - 1)) == false) goto L15;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            private final boolean isTheSameView(android.view.View r10, com.facebook.appevents.codeless.internal.PathComponent r11, int r12) {
                /*
                    Method dump skipped, instructions count: 335
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.codeless.CodelessMatcher.ViewMatcher.Companion.isTheSameView(android.view.View, com.facebook.appevents.codeless.internal.PathComponent, int):boolean");
            }

            @x0XOIxOo
            @OOXIXo
            public final List<MatchedView> findViewByPath(@oOoXoXO EventBinding eventBinding, @oOoXoXO View view, @OOXIXo List<PathComponent> path, int i, int i2, @OOXIXo String mapKey) {
                List<View> findVisibleChildren;
                int size;
                List<View> findVisibleChildren2;
                int size2;
                IIX0o.x0xO0oo(path, "path");
                IIX0o.x0xO0oo(mapKey, "mapKey");
                String str = mapKey + '.' + i2;
                ArrayList arrayList = new ArrayList();
                if (view == null) {
                    return arrayList;
                }
                if (i >= path.size()) {
                    arrayList.add(new MatchedView(view, str));
                } else {
                    PathComponent pathComponent = path.get(i);
                    if (IIX0o.Oxx0IOOO(pathComponent.getClassName(), CodelessMatcher.PARENT_CLASS_NAME)) {
                        ViewParent parent = view.getParent();
                        if ((parent instanceof ViewGroup) && (size = (findVisibleChildren = findVisibleChildren((ViewGroup) parent)).size()) > 0) {
                            int i3 = 0;
                            while (true) {
                                int i4 = i3 + 1;
                                arrayList.addAll(findViewByPath(eventBinding, findVisibleChildren.get(i3), path, i + 1, i3, str));
                                if (i4 >= size) {
                                    break;
                                }
                                i3 = i4;
                            }
                        }
                        return arrayList;
                    }
                    if (IIX0o.Oxx0IOOO(pathComponent.getClassName(), ".")) {
                        arrayList.add(new MatchedView(view, str));
                        return arrayList;
                    }
                    if (!isTheSameView(view, pathComponent, i2)) {
                        return arrayList;
                    }
                    if (i == path.size() - 1) {
                        arrayList.add(new MatchedView(view, str));
                    }
                }
                if ((view instanceof ViewGroup) && (size2 = (findVisibleChildren2 = findVisibleChildren((ViewGroup) view)).size()) > 0) {
                    int i5 = 0;
                    while (true) {
                        int i6 = i5 + 1;
                        arrayList.addAll(findViewByPath(eventBinding, findVisibleChildren2.get(i5), path, i + 1, i5, str));
                        if (i6 >= size2) {
                            break;
                        }
                        i5 = i6;
                    }
                }
                return arrayList;
            }

            private Companion() {
            }
        }

        public ViewMatcher(@oOoXoXO View view, @OOXIXo Handler handler, @OOXIXo HashSet<String> listenerSet, @OOXIXo String activityName) {
            IIX0o.x0xO0oo(handler, "handler");
            IIX0o.x0xO0oo(listenerSet, "listenerSet");
            IIX0o.x0xO0oo(activityName, "activityName");
            this.rootView = new WeakReference<>(view);
            this.handler = handler;
            this.listenerSet = listenerSet;
            this.activityName = activityName;
            handler.postDelayed(this, 200L);
        }

        private final void attachListener(MatchedView matchedView, View view, EventBinding eventBinding) {
            if (eventBinding == null) {
                return;
            }
            try {
                View view2 = matchedView.getView();
                if (view2 == null) {
                    return;
                }
                ViewHierarchy viewHierarchy = ViewHierarchy.INSTANCE;
                View findRCTRootView = ViewHierarchy.findRCTRootView(view2);
                if (findRCTRootView != null && viewHierarchy.isRCTButton(view2, findRCTRootView)) {
                    attachRCTListener(matchedView, view, eventBinding);
                    return;
                }
                String name = view2.getClass().getName();
                IIX0o.oO(name, "view.javaClass.name");
                if (OxI.IOOoXo0Ix(name, "com.facebook.react", false, 2, null)) {
                    return;
                }
                if (!(view2 instanceof AdapterView)) {
                    attachOnClickListener(matchedView, view, eventBinding);
                } else if (view2 instanceof ListView) {
                    attachOnItemClickListener(matchedView, view, eventBinding);
                }
            } catch (Exception e) {
                Utility utility = Utility.INSTANCE;
                Utility.logd(CodelessMatcher.access$getTAG$cp(), e);
            }
        }

        private final void attachOnClickListener(MatchedView matchedView, View view, EventBinding eventBinding) {
            boolean z;
            View view2 = matchedView.getView();
            if (view2 == null) {
                return;
            }
            String viewMapKey = matchedView.getViewMapKey();
            ViewHierarchy viewHierarchy = ViewHierarchy.INSTANCE;
            View.OnClickListener existingOnClickListener = ViewHierarchy.getExistingOnClickListener(view2);
            if (existingOnClickListener instanceof CodelessLoggingEventListener.AutoLoggingOnClickListener) {
                if (existingOnClickListener != null) {
                    if (((CodelessLoggingEventListener.AutoLoggingOnClickListener) existingOnClickListener).getSupportCodelessLogging()) {
                        z = true;
                        if (this.listenerSet.contains(viewMapKey) && !z) {
                            CodelessLoggingEventListener codelessLoggingEventListener = CodelessLoggingEventListener.INSTANCE;
                            view2.setOnClickListener(CodelessLoggingEventListener.getOnClickListener(eventBinding, view, view2));
                            this.listenerSet.add(viewMapKey);
                            return;
                        }
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type com.facebook.appevents.codeless.CodelessLoggingEventListener.AutoLoggingOnClickListener");
                }
            }
            z = false;
            if (this.listenerSet.contains(viewMapKey)) {
            }
        }

        private final void attachOnItemClickListener(MatchedView matchedView, View view, EventBinding eventBinding) {
            boolean z;
            AdapterView adapterView = (AdapterView) matchedView.getView();
            if (adapterView == null) {
                return;
            }
            String viewMapKey = matchedView.getViewMapKey();
            AdapterView.OnItemClickListener onItemClickListener = adapterView.getOnItemClickListener();
            if (onItemClickListener instanceof CodelessLoggingEventListener.AutoLoggingOnItemClickListener) {
                if (onItemClickListener != null) {
                    if (((CodelessLoggingEventListener.AutoLoggingOnItemClickListener) onItemClickListener).getSupportCodelessLogging()) {
                        z = true;
                        if (this.listenerSet.contains(viewMapKey) && !z) {
                            CodelessLoggingEventListener codelessLoggingEventListener = CodelessLoggingEventListener.INSTANCE;
                            adapterView.setOnItemClickListener(CodelessLoggingEventListener.getOnItemClickListener(eventBinding, view, adapterView));
                            this.listenerSet.add(viewMapKey);
                            return;
                        }
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type com.facebook.appevents.codeless.CodelessLoggingEventListener.AutoLoggingOnItemClickListener");
                }
            }
            z = false;
            if (this.listenerSet.contains(viewMapKey)) {
            }
        }

        private final void attachRCTListener(MatchedView matchedView, View view, EventBinding eventBinding) {
            boolean z;
            View view2 = matchedView.getView();
            if (view2 == null) {
                return;
            }
            String viewMapKey = matchedView.getViewMapKey();
            ViewHierarchy viewHierarchy = ViewHierarchy.INSTANCE;
            View.OnTouchListener existingOnTouchListener = ViewHierarchy.getExistingOnTouchListener(view2);
            if (existingOnTouchListener instanceof RCTCodelessLoggingEventListener.AutoLoggingOnTouchListener) {
                if (existingOnTouchListener != null) {
                    if (((RCTCodelessLoggingEventListener.AutoLoggingOnTouchListener) existingOnTouchListener).getSupportCodelessLogging()) {
                        z = true;
                        if (this.listenerSet.contains(viewMapKey) && !z) {
                            RCTCodelessLoggingEventListener rCTCodelessLoggingEventListener = RCTCodelessLoggingEventListener.INSTANCE;
                            view2.setOnTouchListener(RCTCodelessLoggingEventListener.getOnTouchListener(eventBinding, view, view2));
                            this.listenerSet.add(viewMapKey);
                            return;
                        }
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type com.facebook.appevents.codeless.RCTCodelessLoggingEventListener.AutoLoggingOnTouchListener");
                }
            }
            z = false;
            if (this.listenerSet.contains(viewMapKey)) {
            }
        }

        private final void findView(EventBinding eventBinding, View view) {
            if (eventBinding != null && view != null) {
                String activityName = eventBinding.getActivityName();
                if (activityName != null && activityName.length() != 0 && !IIX0o.Oxx0IOOO(eventBinding.getActivityName(), this.activityName)) {
                    return;
                }
                List<PathComponent> viewPath = eventBinding.getViewPath();
                if (viewPath.size() > 25) {
                    return;
                }
                Iterator<MatchedView> it = Companion.findViewByPath(eventBinding, view, viewPath, 0, -1, this.activityName).iterator();
                while (it.hasNext()) {
                    attachListener(it.next(), view, eventBinding);
                }
            }
        }

        @x0XOIxOo
        @OOXIXo
        public static final List<MatchedView> findViewByPath(@oOoXoXO EventBinding eventBinding, @oOoXoXO View view, @OOXIXo List<PathComponent> list, int i, int i2, @OOXIXo String str) {
            return Companion.findViewByPath(eventBinding, view, list, i, i2, str);
        }

        private final void startMatch() {
            int size;
            List<EventBinding> list = this.eventBindings;
            if (list != null && this.rootView.get() != null && list.size() - 1 >= 0) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    findView(list.get(i), this.rootView.get());
                    if (i2 <= size) {
                        i = i2;
                    } else {
                        return;
                    }
                }
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            startMatch();
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            startMatch();
        }

        @Override // java.lang.Runnable
        public void run() {
            View view;
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            try {
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                String applicationId = FacebookSdk.getApplicationId();
                FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
                FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(applicationId);
                if (appSettingsWithoutQuery != null && appSettingsWithoutQuery.getCodelessEventsEnabled()) {
                    List<EventBinding> parseArray = EventBinding.Companion.parseArray(appSettingsWithoutQuery.getEventBindings());
                    this.eventBindings = parseArray;
                    if (parseArray == null || (view = this.rootView.get()) == null) {
                        return;
                    }
                    ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                    if (viewTreeObserver.isAlive()) {
                        viewTreeObserver.addOnGlobalLayoutListener(this);
                        viewTreeObserver.addOnScrollChangedListener(this);
                    }
                    startMatch();
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public /* synthetic */ CodelessMatcher(IIXOooo iIXOooo) {
        this();
    }

    public static final /* synthetic */ CodelessMatcher access$getCodelessMatcher$cp() {
        if (CrashShieldHandler.isObjectCrashing(CodelessMatcher.class)) {
            return null;
        }
        try {
            return codelessMatcher;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, CodelessMatcher.class);
            return null;
        }
    }

    public static final /* synthetic */ String access$getTAG$cp() {
        if (CrashShieldHandler.isObjectCrashing(CodelessMatcher.class)) {
            return null;
        }
        try {
            return TAG;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, CodelessMatcher.class);
            return null;
        }
    }

    public static final /* synthetic */ void access$setCodelessMatcher$cp(CodelessMatcher codelessMatcher2) {
        if (CrashShieldHandler.isObjectCrashing(CodelessMatcher.class)) {
            return;
        }
        try {
            codelessMatcher = codelessMatcher2;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, CodelessMatcher.class);
        }
    }

    @x0XOIxOo
    @OOXIXo
    public static final synchronized CodelessMatcher getInstance() {
        synchronized (CodelessMatcher.class) {
            if (CrashShieldHandler.isObjectCrashing(CodelessMatcher.class)) {
                return null;
            }
            try {
                return Companion.getInstance();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, CodelessMatcher.class);
                return null;
            }
        }
    }

    @x0XOIxOo
    @OOXIXo
    @UiThread
    public static final Bundle getParameters(@oOoXoXO EventBinding eventBinding, @OOXIXo View view, @OOXIXo View view2) {
        if (CrashShieldHandler.isObjectCrashing(CodelessMatcher.class)) {
            return null;
        }
        try {
            return Companion.getParameters(eventBinding, view, view2);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, CodelessMatcher.class);
            return null;
        }
    }

    private final void matchViews() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            for (Activity activity : this.activitiesSet) {
                if (activity != null) {
                    AppEventUtility appEventUtility = AppEventUtility.INSTANCE;
                    View rootView = AppEventUtility.getRootView(activity);
                    String simpleName = activity.getClass().getSimpleName();
                    IIX0o.oO(simpleName, "activity.javaClass.simpleName");
                    this.viewMatchers.add(new ViewMatcher(rootView, this.uiThreadHandler, this.listenerSet, simpleName));
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private final void startTracking() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                matchViews();
            } else {
                this.uiThreadHandler.post(new Runnable() { // from class: com.facebook.appevents.codeless.oxoX
                    @Override // java.lang.Runnable
                    public final void run() {
                        CodelessMatcher.m153startTracking$lambda1(CodelessMatcher.this);
                    }
                });
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: startTracking$lambda-1, reason: not valid java name */
    public static final void m153startTracking$lambda1(CodelessMatcher this$0) {
        if (CrashShieldHandler.isObjectCrashing(CodelessMatcher.class)) {
            return;
        }
        try {
            IIX0o.x0xO0oo(this$0, "this$0");
            this$0.matchViews();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, CodelessMatcher.class);
        }
    }

    @UiThread
    public final void add(@OOXIXo Activity activity) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            IIX0o.x0xO0oo(activity, "activity");
            InternalSettings internalSettings = InternalSettings.INSTANCE;
            if (InternalSettings.isUnityApp()) {
                return;
            }
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                this.activitiesSet.add(activity);
                this.listenerSet.clear();
                HashSet<String> hashSet = this.activityToListenerMap.get(Integer.valueOf(activity.hashCode()));
                if (hashSet != null) {
                    this.listenerSet = hashSet;
                }
                startTracking();
                return;
            }
            throw new FacebookException("Can't add activity to CodelessMatcher on non-UI thread");
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @UiThread
    public final void destroy(@OOXIXo Activity activity) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            IIX0o.x0xO0oo(activity, "activity");
            this.activityToListenerMap.remove(Integer.valueOf(activity.hashCode()));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @UiThread
    public final void remove(@OOXIXo Activity activity) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            IIX0o.x0xO0oo(activity, "activity");
            InternalSettings internalSettings = InternalSettings.INSTANCE;
            if (InternalSettings.isUnityApp()) {
                return;
            }
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                this.activitiesSet.remove(activity);
                this.viewMatchers.clear();
                this.activityToListenerMap.put(Integer.valueOf(activity.hashCode()), (HashSet) this.listenerSet.clone());
                this.listenerSet.clear();
                return;
            }
            throw new FacebookException("Can't remove activity from CodelessMatcher on non-UI thread");
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private CodelessMatcher() {
        this.uiThreadHandler = new Handler(Looper.getMainLooper());
        Set<Activity> newSetFromMap = Collections.newSetFromMap(new WeakHashMap());
        IIX0o.oO(newSetFromMap, "newSetFromMap(WeakHashMap())");
        this.activitiesSet = newSetFromMap;
        this.viewMatchers = new LinkedHashSet();
        this.listenerSet = new HashSet<>();
        this.activityToListenerMap = new HashMap<>();
    }
}
