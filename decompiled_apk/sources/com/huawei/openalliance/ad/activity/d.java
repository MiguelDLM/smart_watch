package com.huawei.openalliance.ad.activity;

import android.app.Activity;
import android.app.assist.AssistContent;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import com.huawei.hms.ads.fb;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.utils.SafeIntent;

/* loaded from: classes10.dex */
public abstract class d extends Activity {
    private static final String Code = "SafeActivity";

    public SafeIntent F() {
        try {
            return new SafeIntent(super.getIntent());
        } catch (Throwable th) {
            Log.w(Code, "getIntent: " + th.getClass().getSimpleName());
            return new SafeIntent(new Intent());
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        try {
            return super.dispatchKeyEvent(keyEvent);
        } catch (Throwable unused) {
            fb.I(Code, "dispatchKeyEvent Throwable  ex.");
            return false;
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            return super.dispatchTouchEvent(motionEvent);
        } catch (Throwable unused) {
            fb.I(Code, "dispatchTouchEvent Throwable  ex.");
            return false;
        }
    }

    @Override // android.app.Activity
    public <T extends View> T findViewById(int i) {
        try {
            return (T) getWindow().findViewById(i);
        } catch (Throwable unused) {
            fb.I(Code, "findViewById Throwable  ex.");
            return null;
        }
    }

    @Override // android.app.Activity
    public void finish() {
        try {
            super.finish();
        } catch (Throwable unused) {
            fb.I(Code, "finish Throwable  ex.", Boolean.TRUE);
        }
    }

    @Override // android.app.Activity
    public void finishAffinity() {
        try {
            super.finishAffinity();
        } catch (Throwable unused) {
            fb.I(Code, "finishAffinity ex.");
        }
    }

    @Override // android.app.Activity
    public ComponentName getCallingActivity() {
        try {
            return super.getCallingActivity();
        } catch (Throwable unused) {
            fb.I(Code, "getCallingActivity ex.");
            return null;
        }
    }

    @Override // android.app.Activity
    public String getCallingPackage() {
        try {
            return super.getCallingPackage();
        } catch (Throwable unused) {
            fb.I(Code, "getCallingPackage Throwable  ex.");
            return null;
        }
    }

    @Override // android.app.Activity
    public Intent getIntent() {
        try {
            return new SafeIntent(super.getIntent());
        } catch (Throwable unused) {
            fb.I(Code, "getIntent ex.");
            return new SafeIntent(new Intent());
        }
    }

    @Override // android.app.Activity
    public Uri getReferrer() {
        try {
            return super.getReferrer();
        } catch (Throwable unused) {
            fb.I(Code, "getReferrer ex.");
            return null;
        }
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        try {
            return super.getSystemService(str);
        } catch (Throwable unused) {
            fb.I(Code, "finishAffinity ex.");
            return null;
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        try {
            super.onActivityResult(i, i2, new SafeIntent(intent));
        } catch (Throwable unused) {
            fb.I(Code, "onActivityResult Throwable  ex.");
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        try {
            super.onBackPressed();
        } catch (Throwable unused) {
            fb.I(Code, "onBackPressed Throwable  ex.");
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        try {
            super.onConfigurationChanged(configuration);
        } catch (Throwable unused) {
            fb.I(Code, "onConfigurationChanged Throwable  ex.");
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
        } catch (Throwable unused) {
            fb.I(Code, "onCreate Throwable  ex.");
        }
    }

    @Override // android.app.Activity
    public CharSequence onCreateDescription() {
        try {
            return super.onCreateDescription();
        } catch (Throwable unused) {
            fb.I(Code, "onCreateDescription Throwable  ex.");
            return null;
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        try {
            super.onDestroy();
        } catch (Throwable unused) {
            fb.I(Code, "onDestroy Throwable  ex.");
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        try {
            return super.onKeyDown(i, keyEvent);
        } catch (Throwable unused) {
            fb.I(Code, "onKeyDown Throwable  ex.");
            return false;
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyLongPress(int i, KeyEvent keyEvent) {
        try {
            return super.onKeyLongPress(i, keyEvent);
        } catch (Throwable unused) {
            fb.I(Code, "onKeyLongPress Throwable  ex.");
            return false;
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        try {
            return super.onKeyMultiple(i, i2, keyEvent);
        } catch (Throwable unused) {
            fb.I(Code, "onKeyMultiple Throwable  ex.");
            return false;
        }
    }

    @Override // android.app.Activity
    public boolean onKeyShortcut(int i, KeyEvent keyEvent) {
        try {
            return super.onKeyShortcut(i, keyEvent);
        } catch (Throwable unused) {
            fb.I(Code, "onKeyShortcut Throwable  ex.");
            return false;
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        try {
            return super.onKeyUp(i, keyEvent);
        } catch (Throwable unused) {
            fb.I(Code, "onKeyUp Throwable  ex.");
            return false;
        }
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z, Configuration configuration) {
        try {
            super.onMultiWindowModeChanged(z, configuration);
        } catch (Throwable unused) {
            fb.I(Code, "onMultiWindowModeChanged Throwable  ex.");
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        try {
            super.onNewIntent(intent);
        } catch (Throwable unused) {
            fb.I(Code, "onNewIntent Throwable  ex.");
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        try {
            super.onPause();
        } catch (Throwable unused) {
            fb.I(Code, "onPause Throwable  ex.");
        }
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        try {
            super.onPostCreate(bundle);
        } catch (Throwable unused) {
            fb.I(Code, "onPostCreate Throwable  ex.");
        }
    }

    @Override // android.app.Activity
    public void onPostResume() {
        try {
            super.onPostResume();
        } catch (Throwable unused) {
            fb.I(Code, "onPostResume Throwable  ex.");
        }
    }

    @Override // android.app.Activity
    public void onProvideAssistContent(AssistContent assistContent) {
        try {
            super.onProvideAssistContent(assistContent);
        } catch (Throwable unused) {
            fb.I(Code, "onProvideAssistContent Throwable  ex.");
        }
    }

    @Override // android.app.Activity
    public void onProvideAssistData(Bundle bundle) {
        try {
            super.onProvideAssistData(bundle);
        } catch (Throwable unused) {
            fb.I(Code, "onProvideAssistData Throwable  ex.");
        }
    }

    @Override // android.app.Activity
    public Uri onProvideReferrer() {
        try {
            return super.onProvideReferrer();
        } catch (Throwable unused) {
            fb.I(Code, "onProvideReferrer ex.");
            return null;
        }
    }

    @Override // android.app.Activity
    public void onRestart() {
        try {
            super.onRestart();
        } catch (Throwable unused) {
            fb.I(Code, "onRestart Throwable  ex.");
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        try {
            super.onRestoreInstanceState(bundle);
        } catch (Throwable unused) {
            fb.I(Code, "onRestoreInstanceState Throwable  ex.");
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        try {
            super.onResume();
        } catch (Throwable unused) {
            fb.I(Code, "onResume Throwable  ex.");
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        try {
            super.onSaveInstanceState(bundle);
        } catch (Throwable unused) {
            fb.I(Code, "onSaveInstanceState Throwable  ex.");
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        try {
            super.onStart();
        } catch (Throwable unused) {
            fb.I(Code, "onStart Throwable  ex.");
        }
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        try {
            super.onStateNotSaved();
        } catch (Throwable unused) {
            fb.I(Code, "onStateNotSaved Throwable  ex.");
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        try {
            super.onStop();
        } catch (Throwable unused) {
            fb.I(Code, "onStop Throwable  ex.");
        }
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            return super.onTouchEvent(motionEvent);
        } catch (Throwable unused) {
            fb.I(Code, "onKeyShortcut Throwable  ex.");
            return false;
        }
    }

    @Override // android.app.Activity
    public void onUserLeaveHint() {
        try {
            super.onUserLeaveHint();
        } catch (Throwable unused) {
            fb.I(Code, "onUserLeaveHint Throwable  ex.");
        }
    }

    @Override // android.app.Activity
    public void recreate() {
        try {
            super.recreate();
        } catch (Throwable unused) {
            fb.I(Code, "recreate ex.");
        }
    }

    @Override // android.app.Activity
    public void setIntent(Intent intent) {
        try {
            super.setIntent(new SafeIntent(intent));
        } catch (Throwable unused) {
            fb.I(Code, "setIntent ex.");
        }
    }

    @Override // android.app.Activity
    public boolean showAssist(Bundle bundle) {
        try {
            return super.showAssist(bundle);
        } catch (Throwable unused) {
            fb.I(Code, "showAssist Throwable  ex.");
            return false;
        }
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivities(Intent[] intentArr) {
        try {
            super.startActivities(intentArr);
        } catch (Throwable unused) {
            fb.I(Code, "startActivities ex.");
        }
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        try {
            intent.setClipData(x.cM);
            super.startActivity(new SafeIntent(intent));
        } catch (Throwable unused) {
            fb.I(Code, "startActivity ex.");
        }
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i) {
        try {
            intent.setClipData(x.cM);
            super.startActivityForResult(new SafeIntent(intent), i);
        } catch (Throwable unused) {
            fb.I(Code, "startActivity ex.");
        }
    }

    @Override // android.app.Activity
    public boolean startActivityIfNeeded(Intent intent, int i) {
        try {
            return super.startActivityIfNeeded(intent, i);
        } catch (Throwable unused) {
            fb.I(Code, "startActivityIfNeeded ex.");
            return false;
        }
    }

    @Override // android.app.Activity
    public boolean startNextMatchingActivity(Intent intent) {
        try {
            return super.startNextMatchingActivity(intent);
        } catch (Throwable unused) {
            fb.I(Code, "startNextMatchingActivity ex.");
            return false;
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle, PersistableBundle persistableBundle) {
        try {
            super.onCreate(bundle, persistableBundle);
        } catch (Throwable unused) {
            fb.I(Code, "onCreate Throwable  ex.");
        }
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle, PersistableBundle persistableBundle) {
        try {
            super.onPostCreate(bundle, persistableBundle);
        } catch (Throwable unused) {
            fb.I(Code, "onPostCreate Throwable  ex.");
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
        try {
            super.onRestoreInstanceState(bundle, persistableBundle);
        } catch (Throwable unused) {
            fb.I(Code, "onRestoreInstanceState Throwable  ex.");
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
        try {
            super.onSaveInstanceState(bundle, persistableBundle);
        } catch (Throwable unused) {
            fb.I(Code, "onSaveInstanceState Throwable  ex.");
        }
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivities(Intent[] intentArr, Bundle bundle) {
        try {
            super.startActivities(intentArr, bundle);
        } catch (Throwable unused) {
            fb.I(Code, "startActivities ex.");
        }
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent, Bundle bundle) {
        try {
            intent.setClipData(x.cM);
            super.startActivity(new SafeIntent(intent), bundle);
        } catch (Throwable unused) {
            fb.I(Code, "startActivity ex.");
        }
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        try {
            intent.setClipData(x.cM);
            super.startActivityForResult(new SafeIntent(intent), i, bundle);
        } catch (Throwable unused) {
            fb.I(Code, "startActivity ex.");
        }
    }

    @Override // android.app.Activity
    public boolean startActivityIfNeeded(Intent intent, int i, Bundle bundle) {
        try {
            return super.startActivityIfNeeded(intent, i, bundle);
        } catch (Throwable unused) {
            fb.I(Code, "startActivityIfNeeded ex.");
            return false;
        }
    }

    @Override // android.app.Activity
    public boolean startNextMatchingActivity(Intent intent, Bundle bundle) {
        try {
            return super.startNextMatchingActivity(intent, bundle);
        } catch (Throwable unused) {
            fb.I(Code, "startNextMatchingActivity ex.");
            return false;
        }
    }
}
