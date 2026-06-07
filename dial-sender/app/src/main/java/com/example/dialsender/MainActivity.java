package com.example.dialsender;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.example.dialsender.ble.BleForegroundService;
import com.example.dialsender.ble.BleManager;
import com.example.dialsender.fragments.DeviceFragment;
import com.example.dialsender.fragments.SettingsFragment;
import com.example.dialsender.fragments.SportFragment;
import com.example.dialsender.fragments.StatusFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNav;

    @Override
    protected void attachBaseContext(android.content.Context base) {
        super.attachBaseContext(LocaleHelper.wrap(base));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (checkSelfPermission(
                    android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[] { android.Manifest.permission.POST_NOTIFICATIONS }, 200);
            }
        }

        // TODO: call stopService(new Intent(this, BleForegroundService.class)) on
        // explicit disconnect
        BleManager ble = BleManager.getInstance(this);
        if (ble.getLastDeviceAddress() != null) {
            Intent serviceIntent = new Intent(this, BleForegroundService.class);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                startForegroundService(serviceIntent);
            } else {
                startService(serviceIntent);
            }
        }

        // Auto-sync when the session becomes ready
        ble.setListener(new BleManager.BleStateListener() {
            @Override
            public void onConnectionStateChange(boolean connected, boolean sessionReady) {
                if (sessionReady) {
                    ble.syncTime();
                    ble.readBattery();
                    ble.syncHealth();
                }
            }

            @Override
            public void onHealthDataReceived(String k, byte[] p) {
            }

            @Override
            public void onHealthSyncComplete() {
            }

            @Override
            public void onTransferProgress(int pct, long done, long tot) {
            }

            @Override
            public void onTransferComplete() {
            }

            @Override
            public void onLogUpdated() {
            }

            @Override
            public void onFindPhoneRequest() {
                runOnUiThread(() -> new androidx.appcompat.app.AlertDialog.Builder(MainActivity.this)
                        .setTitle("📍 Find Phone")
                        .setMessage("Your watch is looking for this phone.")
                        .setPositiveButton("Stop Ringing", (d, w) -> ble.stopFindPhoneAlert())
                        .setCancelable(false)
                        .show());
            }
        });

        bottomNav = findViewById(R.id.bottomNav);
        bottomNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_status) {
                loadFragment(new StatusFragment());
            } else if (id == R.id.nav_sport) {
                loadFragment(new SportFragment());
            } else if (id == R.id.nav_device) {
                loadFragment(new DeviceFragment());
            } else if (id == R.id.nav_me) {
                loadFragment(new SettingsFragment());
            } else {
                return false;
            }
            return true;
        });

        if (savedInstanceState == null) {
            bottomNav.setSelectedItemId(R.id.nav_status);
        }
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit();
    }

    /**
     * Show a fragment in the main container WITHOUT changing the bottom tab —
     * used e.g. to open the watch-face library from inside the Device tab.
     */
    public void showFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .addToBackStack(null)
                .commit();
    }
}
