package com.sma.smartv3.ble;

import OXOo.oOoXoXO;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.sma.smartv3.ui.main.MainActivity;

/* loaded from: classes12.dex */
public final class DfuNotificationActivity extends AppCompatActivity {
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@oOoXoXO Bundle bundle) {
        Bundle extras;
        super.onCreate(bundle);
        if (isTaskRoot()) {
            Intent intent = new Intent(this, (Class<?>) MainActivity.class);
            intent.addFlags(268435456);
            Intent intent2 = getIntent();
            if (intent2 != null && (extras = intent2.getExtras()) != null) {
                intent.putExtras(extras);
            }
            startActivity(intent);
        }
        finish();
    }
}
