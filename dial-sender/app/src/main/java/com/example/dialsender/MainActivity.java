package com.example.dialsender;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.example.dialsender.fragments.DeviceFragment;
import com.example.dialsender.fragments.DialsFragment;
import com.example.dialsender.fragments.HomeFragment;
import com.example.dialsender.fragments.StatusFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNav = findViewById(R.id.bottomNav);
        bottomNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_home) {
                loadFragment(new HomeFragment());
            } else if (id == R.id.nav_dials) {
                loadFragment(new DialsFragment());
            } else if (id == R.id.nav_device) {
                loadFragment(new DeviceFragment());
            } else if (id == R.id.nav_health) {
                loadFragment(new StatusFragment());
            } else {
                return false;
            }
            return true;
        });

        if (savedInstanceState == null) {
            bottomNav.setSelectedItemId(R.id.nav_home);
        }
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit();
    }
}
