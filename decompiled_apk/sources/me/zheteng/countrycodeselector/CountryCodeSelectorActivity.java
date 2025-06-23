package me.zheteng.countrycodeselector;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/* loaded from: classes6.dex */
public class CountryCodeSelectorActivity extends AppCompatActivity {
    private BroadcastReceiver mResultReceiver = new oIX0oI();

    /* loaded from: classes6.dex */
    public class oIX0oI extends BroadcastReceiver {
        public oIX0oI() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            CountryCodeSelectorActivity.this.finish();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.ccs_activity_country_selector);
        setTitle(R.string.ccs_choose_a_country);
        getSupportFragmentManager().beginTransaction().add(R.id.container, CountryCodeSelectorFragment.newInstance(getIntent())).commit();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        registerReceiver(this.mResultReceiver, new IntentFilter(PhoneInputView.f30984OxI));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.mResultReceiver);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }
}
