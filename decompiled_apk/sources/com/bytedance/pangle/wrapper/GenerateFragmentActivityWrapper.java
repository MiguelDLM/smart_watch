package com.bytedance.pangle.wrapper;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.LoaderManager;
import android.app.PendingIntent;
import android.app.PictureInPictureParams;
import android.app.SharedElementCallback;
import android.app.TaskStackBuilder;
import android.app.VoiceInteractor;
import android.app.assist.AssistContent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.LocusId;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.PersistableBundle;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.DragAndDropPermissions;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Toolbar;
import androidx.annotation.Keep;
import androidx.core.app.ComponentActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelStore;
import com.bytedance.pangle.PluginContext;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;
import java.util.function.Consumer;

@Keep
/* loaded from: classes8.dex */
public abstract class GenerateFragmentActivityWrapper extends FragmentActivity implements a {
    public FragmentActivity mOriginActivity;
    public PluginContext pluginContext;

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.mOriginActivity.addContentView(view, layoutParams);
    }

    @Override // android.app.Activity
    public void closeContextMenu() {
        this.mOriginActivity.closeContextMenu();
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        this.mOriginActivity.closeOptionsMenu();
    }

    @Override // android.app.Activity
    public PendingIntent createPendingResult(int i, Intent intent, int i2) {
        return this.mOriginActivity.createPendingResult(i, intent, i2);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.mOriginActivity.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.mOriginActivity.dispatchKeyEvent(keyEvent);
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return this.mOriginActivity.dispatchKeyShortcutEvent(keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.mOriginActivity.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.mOriginActivity.dispatchTouchEvent(motionEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.mOriginActivity.dispatchTrackballEvent(motionEvent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.mOriginActivity.dump(str, fileDescriptor, printWriter, strArr);
    }

    @Override // android.app.Activity
    public void enterPictureInPictureMode() {
        this.mOriginActivity.enterPictureInPictureMode();
    }

    @Override // android.app.Activity
    public View findViewById(int i) {
        return this.mOriginActivity.findViewById(i);
    }

    @Override // android.app.Activity
    public void finish() {
        this.mOriginActivity.finish();
    }

    @Override // android.app.Activity
    public void finishActivity(int i) {
        this.mOriginActivity.finishActivity(i);
    }

    @Override // android.app.Activity
    public void finishActivityFromChild(Activity activity, int i) {
        this.mOriginActivity.finishActivityFromChild(activity, i);
    }

    @Override // android.app.Activity
    public void finishAffinity() {
        this.mOriginActivity.finishAffinity();
    }

    @Override // android.app.Activity
    public void finishAfterTransition() {
        this.mOriginActivity.finishAfterTransition();
    }

    @Override // android.app.Activity
    public void finishAndRemoveTask() {
        this.mOriginActivity.finishAndRemoveTask();
    }

    @Override // android.app.Activity
    public void finishFromChild(Activity activity) {
        this.mOriginActivity.finishFromChild(activity);
    }

    @Override // android.app.Activity
    public ActionBar getActionBar() {
        return this.mOriginActivity.getActionBar();
    }

    @Override // android.app.Activity
    public ComponentName getCallingActivity() {
        return this.mOriginActivity.getCallingActivity();
    }

    @Override // android.app.Activity
    public String getCallingPackage() {
        return this.mOriginActivity.getCallingPackage();
    }

    @Override // android.app.Activity
    public int getChangingConfigurations() {
        return this.mOriginActivity.getChangingConfigurations();
    }

    @Override // android.app.Activity
    public ComponentName getComponentName() {
        return this.mOriginActivity.getComponentName();
    }

    @Override // android.app.Activity
    public Scene getContentScene() {
        return this.mOriginActivity.getContentScene();
    }

    @Override // android.app.Activity
    public TransitionManager getContentTransitionManager() {
        return this.mOriginActivity.getContentTransitionManager();
    }

    @Override // android.app.Activity
    public View getCurrentFocus() {
        return this.mOriginActivity.getCurrentFocus();
    }

    @Override // androidx.core.app.ComponentActivity
    public ComponentActivity.ExtraData getExtraData(Class cls) {
        return this.mOriginActivity.getExtraData(cls);
    }

    @Override // android.app.Activity
    public FragmentManager getFragmentManager() {
        return this.mOriginActivity.getFragmentManager();
    }

    @Override // android.app.Activity
    public Intent getIntent() {
        return this.mOriginActivity.getIntent();
    }

    @Override // android.app.Activity
    public Object getLastNonConfigurationInstance() {
        return this.mOriginActivity.getLastNonConfigurationInstance();
    }

    @Override // android.app.Activity
    public LayoutInflater getLayoutInflater() {
        return this.mOriginActivity.getLayoutInflater();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.mOriginActivity.getLifecycle();
    }

    @Override // android.app.Activity
    public LoaderManager getLoaderManager() {
        return this.mOriginActivity.getLoaderManager();
    }

    @Override // android.app.Activity
    public String getLocalClassName() {
        return this.mOriginActivity.getLocalClassName();
    }

    @Override // android.app.Activity
    public int getMaxNumPictureInPictureActions() {
        int maxNumPictureInPictureActions;
        maxNumPictureInPictureActions = this.mOriginActivity.getMaxNumPictureInPictureActions();
        return maxNumPictureInPictureActions;
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        return this.mOriginActivity.getMenuInflater();
    }

    @Override // android.app.Activity
    public Intent getParentActivityIntent() {
        return this.mOriginActivity.getParentActivityIntent();
    }

    @Override // android.app.Activity
    public SharedPreferences getPreferences(int i) {
        return this.mOriginActivity.getPreferences(i);
    }

    @Override // android.app.Activity
    public Uri getReferrer() {
        Uri referrer;
        referrer = this.mOriginActivity.getReferrer();
        return referrer;
    }

    @Override // android.app.Activity
    public int getRequestedOrientation() {
        return this.mOriginActivity.getRequestedOrientation();
    }

    @Override // androidx.fragment.app.FragmentActivity
    public androidx.fragment.app.FragmentManager getSupportFragmentManager() {
        return this.mOriginActivity.getSupportFragmentManager();
    }

    @Override // androidx.fragment.app.FragmentActivity
    public androidx.loader.app.LoaderManager getSupportLoaderManager() {
        return this.mOriginActivity.getSupportLoaderManager();
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        return this.pluginContext.getSystemService(str);
    }

    @Override // android.app.Activity
    public int getTaskId() {
        return this.mOriginActivity.getTaskId();
    }

    @Override // androidx.activity.ComponentActivity, androidx.lifecycle.ViewModelStoreOwner
    public ViewModelStore getViewModelStore() {
        return this.mOriginActivity.getViewModelStore();
    }

    @Override // android.app.Activity
    public VoiceInteractor getVoiceInteractor() {
        VoiceInteractor voiceInteractor;
        voiceInteractor = this.mOriginActivity.getVoiceInteractor();
        return voiceInteractor;
    }

    @Override // android.app.Activity
    public Window getWindow() {
        return this.mOriginActivity.getWindow();
    }

    @Override // android.app.Activity
    public WindowManager getWindowManager() {
        return this.mOriginActivity.getWindowManager();
    }

    @Override // android.app.Activity
    public boolean hasWindowFocus() {
        return this.mOriginActivity.hasWindowFocus();
    }

    public int hashCode() {
        return this.mOriginActivity.hashCode();
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        this.mOriginActivity.invalidateOptionsMenu();
    }

    @Override // android.app.Activity
    public boolean isActivityTransitionRunning() {
        boolean isActivityTransitionRunning;
        isActivityTransitionRunning = this.mOriginActivity.isActivityTransitionRunning();
        return isActivityTransitionRunning;
    }

    @Override // android.app.Activity
    public boolean isChangingConfigurations() {
        return this.mOriginActivity.isChangingConfigurations();
    }

    @Override // android.app.Activity
    public boolean isDestroyed() {
        return this.mOriginActivity.isDestroyed();
    }

    @Override // android.app.Activity
    public boolean isFinishing() {
        return this.mOriginActivity.isFinishing();
    }

    @Override // android.app.Activity
    public boolean isImmersive() {
        return this.mOriginActivity.isImmersive();
    }

    @Override // android.app.Activity
    public boolean isInMultiWindowMode() {
        boolean isInMultiWindowMode;
        isInMultiWindowMode = this.mOriginActivity.isInMultiWindowMode();
        return isInMultiWindowMode;
    }

    @Override // android.app.Activity
    public boolean isInPictureInPictureMode() {
        boolean isInPictureInPictureMode;
        isInPictureInPictureMode = this.mOriginActivity.isInPictureInPictureMode();
        return isInPictureInPictureMode;
    }

    @Override // android.app.Activity
    public boolean isLocalVoiceInteractionSupported() {
        boolean isLocalVoiceInteractionSupported;
        isLocalVoiceInteractionSupported = this.mOriginActivity.isLocalVoiceInteractionSupported();
        return isLocalVoiceInteractionSupported;
    }

    @Override // android.app.Activity
    public boolean isTaskRoot() {
        return this.mOriginActivity.isTaskRoot();
    }

    @Override // android.app.Activity
    public boolean isVoiceInteraction() {
        boolean isVoiceInteraction;
        isVoiceInteraction = this.mOriginActivity.isVoiceInteraction();
        return isVoiceInteraction;
    }

    @Override // android.app.Activity
    public boolean isVoiceInteractionRoot() {
        boolean isVoiceInteractionRoot;
        isVoiceInteractionRoot = this.mOriginActivity.isVoiceInteractionRoot();
        return isVoiceInteractionRoot;
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z) {
        return this.mOriginActivity.moveTaskToBack(z);
    }

    @Override // android.app.Activity
    public boolean navigateUpTo(Intent intent) {
        return this.mOriginActivity.navigateUpTo(intent);
    }

    @Override // android.app.Activity
    public boolean navigateUpToFromChild(Activity activity, Intent intent) {
        return this.mOriginActivity.navigateUpToFromChild(activity, intent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onActionModeFinished(ActionMode actionMode) {
        this.mOriginActivity.onActionModeFinished(actionMode);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onActionModeStarted(ActionMode actionMode) {
        this.mOriginActivity.onActionModeStarted(actionMode);
    }

    @Override // android.app.Activity
    public void onActivityReenter(int i, Intent intent) {
        this.mOriginActivity.onActivityReenter(i, intent);
    }

    @Override // android.app.Activity
    public void onAttachFragment(Fragment fragment) {
        this.mOriginActivity.onAttachFragment(fragment);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        this.mOriginActivity.onAttachedToWindow();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        this.mOriginActivity.onBackPressed();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.mOriginActivity.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        this.mOriginActivity.onContentChanged();
    }

    @Override // android.app.Activity
    public boolean onContextItemSelected(MenuItem menuItem) {
        return this.mOriginActivity.onContextItemSelected(menuItem);
    }

    @Override // android.app.Activity
    public void onContextMenuClosed(Menu menu) {
        this.mOriginActivity.onContextMenuClosed(menu);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle, PersistableBundle persistableBundle) {
        this.mOriginActivity.onCreate(bundle, persistableBundle);
    }

    @Override // android.app.Activity, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.mOriginActivity.onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // android.app.Activity
    public CharSequence onCreateDescription() {
        return this.mOriginActivity.onCreateDescription();
    }

    @Override // android.app.Activity
    public void onCreateNavigateUpTaskStack(TaskStackBuilder taskStackBuilder) {
        this.mOriginActivity.onCreateNavigateUpTaskStack(taskStackBuilder);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        return this.mOriginActivity.onCreateOptionsMenu(menu);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i, Menu menu) {
        return this.mOriginActivity.onCreatePanelMenu(i, menu);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public View onCreatePanelView(int i) {
        return this.mOriginActivity.onCreatePanelView(i);
    }

    @Override // android.app.Activity
    public boolean onCreateThumbnail(Bitmap bitmap, Canvas canvas) {
        return this.mOriginActivity.onCreateThumbnail(bitmap, canvas);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return this.mOriginActivity.onCreateView(str, context, attributeSet);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        this.mOriginActivity.onDetachedFromWindow();
    }

    @Override // android.app.Activity
    public void onEnterAnimationComplete() {
        this.mOriginActivity.onEnterAnimationComplete();
    }

    @Override // android.app.Activity
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        return this.mOriginActivity.onGenericMotionEvent(motionEvent);
    }

    @Override // android.app.Activity
    public void onGetDirectActions(CancellationSignal cancellationSignal, Consumer consumer) {
        this.mOriginActivity.onGetDirectActions(cancellationSignal, consumer);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.mOriginActivity.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyLongPress(int i, KeyEvent keyEvent) {
        return this.mOriginActivity.onKeyLongPress(i, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        return this.mOriginActivity.onKeyMultiple(i, i2, keyEvent);
    }

    @Override // android.app.Activity
    public boolean onKeyShortcut(int i, KeyEvent keyEvent) {
        return this.mOriginActivity.onKeyShortcut(i, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return this.mOriginActivity.onKeyUp(i, keyEvent);
    }

    @Override // android.app.Activity
    public void onLocalVoiceInteractionStarted() {
        this.mOriginActivity.onLocalVoiceInteractionStarted();
    }

    @Override // android.app.Activity
    public void onLocalVoiceInteractionStopped() {
        this.mOriginActivity.onLocalVoiceInteractionStopped();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        this.mOriginActivity.onLowMemory();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        return this.mOriginActivity.onMenuItemSelected(i, menuItem);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i, Menu menu) {
        return this.mOriginActivity.onMenuOpened(i, menu);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onMultiWindowModeChanged(boolean z, Configuration configuration) {
        this.mOriginActivity.onMultiWindowModeChanged(z, configuration);
    }

    @Override // android.app.Activity
    public boolean onNavigateUp() {
        return this.mOriginActivity.onNavigateUp();
    }

    @Override // android.app.Activity
    public boolean onNavigateUpFromChild(Activity activity) {
        return this.mOriginActivity.onNavigateUpFromChild(activity);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return this.mOriginActivity.onOptionsItemSelected(menuItem);
    }

    @Override // android.app.Activity
    public void onOptionsMenuClosed(Menu menu) {
        this.mOriginActivity.onOptionsMenuClosed(menu);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        this.mOriginActivity.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    public void onPerformDirectAction(String str, Bundle bundle, CancellationSignal cancellationSignal, Consumer consumer) {
        this.mOriginActivity.onPerformDirectAction(str, bundle, cancellationSignal, consumer);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onPictureInPictureModeChanged(boolean z, Configuration configuration) {
        this.mOriginActivity.onPictureInPictureModeChanged(z, configuration);
    }

    @Override // android.app.Activity
    public boolean onPictureInPictureRequested() {
        boolean onPictureInPictureRequested;
        onPictureInPictureRequested = this.mOriginActivity.onPictureInPictureRequested();
        return onPictureInPictureRequested;
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle, PersistableBundle persistableBundle) {
        this.mOriginActivity.onPostCreate(bundle, persistableBundle);
    }

    @Override // android.app.Activity
    public void onPrepareNavigateUpTaskStack(TaskStackBuilder taskStackBuilder) {
        this.mOriginActivity.onPrepareNavigateUpTaskStack(taskStackBuilder);
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        return this.mOriginActivity.onPrepareOptionsMenu(menu);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i, View view, Menu menu) {
        return this.mOriginActivity.onPreparePanel(i, view, menu);
    }

    @Override // android.app.Activity
    public void onProvideAssistContent(AssistContent assistContent) {
        this.mOriginActivity.onProvideAssistContent(assistContent);
    }

    @Override // android.app.Activity
    public void onProvideAssistData(Bundle bundle) {
        this.mOriginActivity.onProvideAssistData(bundle);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onProvideKeyboardShortcuts(List list, Menu menu, int i) {
        this.mOriginActivity.onProvideKeyboardShortcuts(list, menu, i);
    }

    @Override // android.app.Activity
    public Uri onProvideReferrer() {
        Uri onProvideReferrer;
        onProvideReferrer = this.mOriginActivity.onProvideReferrer();
        return onProvideReferrer;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.mOriginActivity.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
        this.mOriginActivity.onRestoreInstanceState(bundle, persistableBundle);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
        this.mOriginActivity.onSaveInstanceState(bundle, persistableBundle);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onSearchRequested(SearchEvent searchEvent) {
        boolean onSearchRequested;
        onSearchRequested = this.mOriginActivity.onSearchRequested(searchEvent);
        return onSearchRequested;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStateNotSaved() {
        this.mOriginActivity.onStateNotSaved();
    }

    @Override // android.app.Activity
    public void onTopResumedActivityChanged(boolean z) {
        this.mOriginActivity.onTopResumedActivityChanged(z);
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mOriginActivity.onTouchEvent(motionEvent);
    }

    @Override // android.app.Activity
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        return this.mOriginActivity.onTrackballEvent(motionEvent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        this.mOriginActivity.onTrimMemory(i);
    }

    @Override // android.app.Activity
    public void onUserInteraction() {
        this.mOriginActivity.onUserInteraction();
    }

    @Override // android.app.Activity
    public void onVisibleBehindCanceled() {
        this.mOriginActivity.onVisibleBehindCanceled();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        this.mOriginActivity.onWindowAttributesChanged(layoutParams);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        this.mOriginActivity.onWindowFocusChanged(z);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return this.mOriginActivity.onWindowStartingActionMode(callback);
    }

    @Override // android.app.Activity
    public void openContextMenu(View view) {
        this.mOriginActivity.openContextMenu(view);
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        this.mOriginActivity.openOptionsMenu();
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        this.mOriginActivity.overridePendingTransition(i, i2);
    }

    @Override // android.app.Activity
    public void postponeEnterTransition() {
        this.mOriginActivity.postponeEnterTransition();
    }

    @Override // androidx.core.app.ComponentActivity
    public void putExtraData(ComponentActivity.ExtraData extraData) {
        this.mOriginActivity.putExtraData(extraData);
    }

    @Override // android.app.Activity
    public void recreate() {
        this.mOriginActivity.recreate();
    }

    @Override // android.app.Activity
    public void registerActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.mOriginActivity.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    @Override // android.app.Activity
    public void registerForContextMenu(View view) {
        this.mOriginActivity.registerForContextMenu(view);
    }

    @Override // android.app.Activity
    public boolean releaseInstance() {
        return this.mOriginActivity.releaseInstance();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void reportFullyDrawn() {
        this.mOriginActivity.reportFullyDrawn();
    }

    @Override // android.app.Activity
    public DragAndDropPermissions requestDragAndDropPermissions(DragEvent dragEvent) {
        DragAndDropPermissions requestDragAndDropPermissions;
        requestDragAndDropPermissions = this.mOriginActivity.requestDragAndDropPermissions(dragEvent);
        return requestDragAndDropPermissions;
    }

    @Override // android.app.Activity
    public boolean requestVisibleBehind(boolean z) {
        return this.mOriginActivity.requestVisibleBehind(z);
    }

    @Override // android.app.Activity
    public void setActionBar(Toolbar toolbar) {
        this.mOriginActivity.setActionBar(toolbar);
    }

    @Override // android.app.Activity
    public void setContentTransitionManager(TransitionManager transitionManager) {
        this.mOriginActivity.setContentTransitionManager(transitionManager);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i) {
        this.mOriginActivity.setContentView(i);
    }

    @Override // android.app.Activity
    public void setEnterSharedElementCallback(SharedElementCallback sharedElementCallback) {
        this.mOriginActivity.setEnterSharedElementCallback(sharedElementCallback);
    }

    @Override // android.app.Activity
    public void setExitSharedElementCallback(SharedElementCallback sharedElementCallback) {
        this.mOriginActivity.setExitSharedElementCallback(sharedElementCallback);
    }

    @Override // android.app.Activity
    public void setFinishOnTouchOutside(boolean z) {
        this.mOriginActivity.setFinishOnTouchOutside(z);
    }

    @Override // android.app.Activity
    public void setImmersive(boolean z) {
        this.mOriginActivity.setImmersive(z);
    }

    @Override // android.app.Activity
    public void setInheritShowWhenLocked(boolean z) {
        this.mOriginActivity.setInheritShowWhenLocked(z);
    }

    @Override // android.app.Activity
    public void setIntent(Intent intent) {
        this.mOriginActivity.setIntent(intent);
    }

    @Override // android.app.Activity
    public void setLocusContext(LocusId locusId, Bundle bundle) {
        this.mOriginActivity.setLocusContext(locusId, bundle);
    }

    @Override // android.app.Activity
    public void setPictureInPictureParams(PictureInPictureParams pictureInPictureParams) {
        this.mOriginActivity.setPictureInPictureParams(pictureInPictureParams);
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i) {
        this.mOriginActivity.setRequestedOrientation(i);
    }

    @Override // android.app.Activity
    public void setShowWhenLocked(boolean z) {
        this.mOriginActivity.setShowWhenLocked(z);
    }

    @Override // android.app.Activity
    public void setTaskDescription(ActivityManager.TaskDescription taskDescription) {
        this.mOriginActivity.setTaskDescription(taskDescription);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        this.mOriginActivity.setTheme(i);
    }

    @Override // android.app.Activity
    public void setTitle(CharSequence charSequence) {
        this.mOriginActivity.setTitle(charSequence);
    }

    @Override // android.app.Activity
    public void setTitleColor(int i) {
        this.mOriginActivity.setTitleColor(i);
    }

    @Override // android.app.Activity
    public boolean setTranslucent(boolean z) {
        boolean translucent;
        translucent = this.mOriginActivity.setTranslucent(z);
        return translucent;
    }

    @Override // android.app.Activity
    public void setTurnScreenOn(boolean z) {
        this.mOriginActivity.setTurnScreenOn(z);
    }

    @Override // android.app.Activity
    public void setVisible(boolean z) {
        this.mOriginActivity.setVisible(z);
    }

    @Override // android.app.Activity
    public void setVrModeEnabled(boolean z, ComponentName componentName) {
        this.mOriginActivity.setVrModeEnabled(z, componentName);
    }

    @Override // com.bytedance.pangle.wrapper.a
    public void setWrapperActivityTheme(int i) {
        try {
            super.setTheme(i);
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Activity
    public boolean shouldShowRequestPermissionRationale(String str) {
        boolean shouldShowRequestPermissionRationale;
        shouldShowRequestPermissionRationale = this.mOriginActivity.shouldShowRequestPermissionRationale(str);
        return shouldShowRequestPermissionRationale;
    }

    @Override // android.app.Activity
    public boolean shouldUpRecreateTask(Intent intent) {
        return this.mOriginActivity.shouldUpRecreateTask(intent);
    }

    @Override // android.app.Activity
    public boolean showAssist(Bundle bundle) {
        boolean showAssist;
        showAssist = this.mOriginActivity.showAssist(bundle);
        return showAssist;
    }

    @Override // android.app.Activity
    public void showLockTaskEscapeMessage() {
        this.mOriginActivity.showLockTaskEscapeMessage();
    }

    @Override // android.app.Activity
    public ActionMode startActionMode(ActionMode.Callback callback) {
        return this.mOriginActivity.startActionMode(callback);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivities(Intent[] intentArr) {
        this.mOriginActivity.startActivities(intentArr);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        this.mOriginActivity.startActivity(intent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent intent, int i) {
        this.mOriginActivity.startActivityForResult(intent, i);
    }

    @Override // android.app.Activity
    public void startActivityFromChild(Activity activity, Intent intent, int i) {
        this.mOriginActivity.startActivityFromChild(activity, intent, i);
    }

    @Override // android.app.Activity
    public void startActivityFromFragment(Fragment fragment, Intent intent, int i) {
        this.mOriginActivity.startActivityFromFragment(fragment, intent, i);
    }

    @Override // android.app.Activity
    public boolean startActivityIfNeeded(Intent intent, int i) {
        return this.mOriginActivity.startActivityIfNeeded(intent, i);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startIntentSender(IntentSender intentSender, Intent intent, int i, int i2, int i3) {
        this.mOriginActivity.startIntentSender(intentSender, intent, i, i2, i3);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) {
        this.mOriginActivity.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    @Override // android.app.Activity
    public void startIntentSenderFromChild(Activity activity, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) {
        this.mOriginActivity.startIntentSenderFromChild(activity, intentSender, i, intent, i2, i3, i4);
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void startIntentSenderFromFragment(androidx.fragment.app.Fragment fragment, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        this.mOriginActivity.startIntentSenderFromFragment(fragment, intentSender, i, intent, i2, i3, i4, bundle);
    }

    @Override // android.app.Activity
    public void startLocalVoiceInteraction(Bundle bundle) {
        this.mOriginActivity.startLocalVoiceInteraction(bundle);
    }

    @Override // android.app.Activity
    public void startLockTask() {
        this.mOriginActivity.startLockTask();
    }

    @Override // android.app.Activity
    public void startManagingCursor(Cursor cursor) {
        this.mOriginActivity.startManagingCursor(cursor);
    }

    @Override // android.app.Activity
    public boolean startNextMatchingActivity(Intent intent) {
        return this.mOriginActivity.startNextMatchingActivity(intent);
    }

    @Override // android.app.Activity
    public void startPostponedEnterTransition() {
        this.mOriginActivity.startPostponedEnterTransition();
    }

    @Override // android.app.Activity
    public void startSearch(String str, boolean z, Bundle bundle, boolean z2) {
        this.mOriginActivity.startSearch(str, z, bundle, z2);
    }

    @Override // android.app.Activity
    public void stopLocalVoiceInteraction() {
        this.mOriginActivity.stopLocalVoiceInteraction();
    }

    @Override // android.app.Activity
    public void stopLockTask() {
        this.mOriginActivity.stopLockTask();
    }

    @Override // android.app.Activity
    public void stopManagingCursor(Cursor cursor) {
        this.mOriginActivity.stopManagingCursor(cursor);
    }

    @Override // androidx.core.app.ComponentActivity, androidx.core.view.KeyEventDispatcher.Component
    public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return this.mOriginActivity.superDispatchKeyEvent(keyEvent);
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void supportFinishAfterTransition() {
        this.mOriginActivity.supportFinishAfterTransition();
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void supportInvalidateOptionsMenu() {
        this.mOriginActivity.supportInvalidateOptionsMenu();
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void supportPostponeEnterTransition() {
        this.mOriginActivity.supportPostponeEnterTransition();
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void supportStartPostponedEnterTransition() {
        this.mOriginActivity.supportStartPostponedEnterTransition();
    }

    @Override // android.app.Activity
    public void takeKeyEvents(boolean z) {
        this.mOriginActivity.takeKeyEvents(z);
    }

    @Override // android.app.Activity
    public void triggerSearch(String str, Bundle bundle) {
        this.mOriginActivity.triggerSearch(str, bundle);
    }

    @Override // android.app.Activity
    public void unregisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.mOriginActivity.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    @Override // android.app.Activity
    public void unregisterForContextMenu(View view) {
        this.mOriginActivity.unregisterForContextMenu(view);
    }

    @Override // android.app.Activity
    public boolean enterPictureInPictureMode(PictureInPictureParams pictureInPictureParams) {
        boolean enterPictureInPictureMode;
        enterPictureInPictureMode = this.mOriginActivity.enterPictureInPictureMode(pictureInPictureParams);
        return enterPictureInPictureMode;
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onAttachFragment(androidx.fragment.app.Fragment fragment) {
        this.mOriginActivity.onAttachFragment(fragment);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.mOriginActivity.onCreateView(view, str, context, attributeSet);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onMultiWindowModeChanged(boolean z) {
        this.mOriginActivity.onMultiWindowModeChanged(z);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onPictureInPictureModeChanged(boolean z) {
        this.mOriginActivity.onPictureInPictureModeChanged(z);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onSearchRequested() {
        return this.mOriginActivity.onSearchRequested();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
        ActionMode onWindowStartingActionMode;
        onWindowStartingActionMode = this.mOriginActivity.onWindowStartingActionMode(callback, i);
        return onWindowStartingActionMode;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view) {
        this.mOriginActivity.setContentView(view);
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void setEnterSharedElementCallback(androidx.core.app.SharedElementCallback sharedElementCallback) {
        this.mOriginActivity.setEnterSharedElementCallback(sharedElementCallback);
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void setExitSharedElementCallback(androidx.core.app.SharedElementCallback sharedElementCallback) {
        this.mOriginActivity.setExitSharedElementCallback(sharedElementCallback);
    }

    @Override // android.app.Activity
    public void setTitle(int i) {
        this.mOriginActivity.setTitle(i);
    }

    @Override // android.app.Activity
    public ActionMode startActionMode(ActionMode.Callback callback, int i) {
        ActionMode startActionMode;
        startActionMode = this.mOriginActivity.startActionMode(callback, i);
        return startActionMode;
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivities(Intent[] intentArr, Bundle bundle) {
        this.mOriginActivity.startActivities(intentArr, bundle);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent, Bundle bundle) {
        this.mOriginActivity.startActivity(intent, bundle);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        this.mOriginActivity.startActivityForResult(intent, i, bundle);
    }

    @Override // android.app.Activity
    public void startActivityFromChild(Activity activity, Intent intent, int i, Bundle bundle) {
        this.mOriginActivity.startActivityFromChild(activity, intent, i, bundle);
    }

    @Override // android.app.Activity
    public void startActivityFromFragment(Fragment fragment, Intent intent, int i, Bundle bundle) {
        this.mOriginActivity.startActivityFromFragment(fragment, intent, i, bundle);
    }

    @Override // android.app.Activity
    public boolean startActivityIfNeeded(Intent intent, int i, Bundle bundle) {
        return this.mOriginActivity.startActivityIfNeeded(intent, i, bundle);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startIntentSender(IntentSender intentSender, Intent intent, int i, int i2, int i3, Bundle bundle) {
        this.mOriginActivity.startIntentSender(intentSender, intent, i, i2, i3, bundle);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        this.mOriginActivity.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }

    @Override // android.app.Activity
    public void startIntentSenderFromChild(Activity activity, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        this.mOriginActivity.startIntentSenderFromChild(activity, intentSender, i, intent, i2, i3, i4, bundle);
    }

    @Override // android.app.Activity
    public boolean startNextMatchingActivity(Intent intent, Bundle bundle) {
        return this.mOriginActivity.startNextMatchingActivity(intent, bundle);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.mOriginActivity.setContentView(view, layoutParams);
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void startActivityFromFragment(androidx.fragment.app.Fragment fragment, Intent intent, int i) {
        this.mOriginActivity.startActivityFromFragment(fragment, intent, i);
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void startActivityFromFragment(androidx.fragment.app.Fragment fragment, Intent intent, int i, Bundle bundle) {
        this.mOriginActivity.startActivityFromFragment(fragment, intent, i, bundle);
    }
}
