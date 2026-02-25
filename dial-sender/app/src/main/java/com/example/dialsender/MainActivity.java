package com.example.dialsender;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.example.dialsender.fragments.DeviceFragment;
import com.example.dialsender.fragments.MeFragment;
import com.example.dialsender.fragments.SportFragment;
import com.example.dialsender.fragments.StatusFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SettingsActivity.applyGlobalTheme(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNav = findViewById(R.id.bottomNav);
        bottomNav.setOnItemSelectedListener(item -> {
            boolean isChecked = true;
            if (item.getItemId() == R.id.nav_status) {
                loadFragment(new StatusFragment());
            } else if (item.getItemId() == R.id.nav_sport) {
                loadFragment(new SportFragment());
            } else if (item.getItemId() == R.id.nav_device) {
                loadFragment(new DeviceFragment());
            } else if (item.getItemId() == R.id.nav_me) {
                loadFragment(new MeFragment());
            } else {
                return false;
            }
            return true;
        });

        // Load default fragment
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
}
