# Redesign Dark Neón — Implementation Plan

> **For agentic workers:** REQUIRED: Use superpowers:subagent-driven-development (if subagents available) or superpowers:executing-plans to implement this plan. Steps use checkbox (`- [ ]`) syntax for tracking.

**Goal:** Replace the current UI with a dark neón design system inspired by Huawei Health, with cyan accent (#22D3EE), metric cards with color gradients, and a 4-tab bottom navigation (Inicio · Carátulas · Dispositivo · Salud).

**Architecture:** Three-chunk approach: (1) design tokens, (2) navigation restructure + new fragments, (3) existing fragment and activity layout updates. Logic layer (BLE, dial compiler, health sync) is untouched throughout.

**Tech Stack:** Android (Java), Material Components 1.x, ConstraintLayout, MPAndroidChart (existing)

**Spec:** `docs/superpowers/specs/2026-03-14-redesign-dark-neon-design.md`

---

## Current navigation mapping (read before starting)

| Current ID | Current Fragment | Current role | New tab |
|------------|-----------------|--------------|---------|
| `nav_status` | `StatusFragment` | Health charts | → **Salud** (tab 4) |
| `nav_sport` | `SportFragment` | Unused/placeholder | → **Carátulas** (tab 2, new `DialsFragment`) |
| `nav_device` | `DeviceFragment` | BLE + log | → **Dispositivo** (tab 3) |
| `nav_me` | `MeFragment` | Placeholder | → **Inicio** (tab 1, new `HomeFragment`) |

`SportFragment` and `MeFragment` are replaced in-place with new fragments. Their Java files are rewritten from scratch. `StatusFragment` and `DeviceFragment` keep all logic — only their layouts change.

---

## Chunk 1: Design tokens (colors, styles, drawables)

**Files:**
- Modify: `app/src/main/res/values/colors.xml`
- Delete: `app/src/main/res/values-night/colors.xml` (dark is the only mode)
- Modify: `app/src/main/res/values/styles.xml`
- Modify: `app/src/main/res/drawable/bg_card.xml`
- Modify: `app/src/main/res/drawable/bg_gradient.xml`
- Modify: `app/src/main/res/drawable/bg_status.xml`
- Modify: `app/src/main/res/drawable/indicator_connected.xml`
- Modify: `app/src/main/res/drawable/indicator_disconnected.xml`
- Delete: `app/src/main/res/drawable/bg_card_create.xml` (superseded by new metric drawables)
- Delete: `app/src/main/res/drawable/bg_card_send.xml` (superseded)
- Delete: `app/src/main/res/drawable/bg_card_library.xml` (superseded)
- Create: `app/src/main/res/drawable/indicator_scanning.xml`
- Create: `app/src/main/res/drawable/bg_card_steps.xml`
- Create: `app/src/main/res/drawable/bg_card_heart.xml`
- Create: `app/src/main/res/drawable/bg_card_calories.xml`
- Create: `app/src/main/res/drawable/bg_card_sleep.xml`
- Create: `app/src/main/res/drawable/bg_bottom_nav.xml`
- Create: `app/src/main/res/drawable/bg_chip_active.xml`
- Create: `app/src/main/res/drawable/bg_chip_inactive.xml`

### Task 1: Replace color palette

- [ ] **Step 1: Replace `values/colors.xml` entirely**

```xml
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <!-- Backgrounds -->
    <color name="bg_primary">#060810</color>
    <color name="bg_surface">#0D1117</color>
    <color name="bg_card">#111827</color>
    <color name="bg_elevated">#1C2333</color>

    <!-- Accents -->
    <color name="accent_primary">#22D3EE</color>
    <color name="accent_primary_dark">#06B6D4</color>
    <color name="accent_health">#34D399</color>
    <color name="accent_heart">#F87171</color>
    <color name="accent_calories">#FBBF24</color>
    <color name="accent_danger">#F85149</color>
    <color name="accent_warning">#F0883E</color>
    <color name="accent_purple">#BC8CFF</color>

    <!-- Text -->
    <color name="text_primary">#F0F6FC</color>
    <color name="text_secondary">#8B949E</color>
    <color name="text_muted">#484F58</color>

    <!-- Status -->
    <color name="status_connected">#34D399</color>
    <color name="status_disconnected">#F85149</color>
    <color name="status_scanning">#F0883E</color>

    <!-- Metric card gradients -->
    <color name="card_steps_start">#064E3B</color>
    <color name="card_steps_end">#065F46</color>
    <color name="card_heart_start">#7F1D1D</color>
    <color name="card_heart_end">#991B1B</color>
    <color name="card_calories_start">#78350F</color>
    <color name="card_calories_end">#92400E</color>
    <color name="card_sleep_start">#1E3A5F</color>
    <color name="card_sleep_end">#1E40AF</color>

    <!-- Misc -->
    <color name="divider">#1F2937</color>
    <color name="ripple">#1A22D3EE</color>
    <color name="progress_track">#1C2333</color>
    <color name="progress_fill">#22D3EE</color>
    <color name="bottom_nav_bg">#0D1117</color>
    <color name="bottom_nav_active">#22D3EE</color>
    <color name="bottom_nav_inactive">#484F58</color>

    <!-- Legacy tokens kept temporarily so existing layouts/drawables compile until replaced in Chunk 3 -->
    <color name="card_create_start">#1E3A5F</color>
    <color name="card_create_end">#060810</color>
    <color name="card_send_start">#1F3D2F</color>
    <color name="card_send_end">#060810</color>
    <color name="card_library_start">#2A1A3A</color>
    <color name="card_library_end">#060810</color>
    <color name="card_border_create">#1A22D3EE</color>
    <color name="card_border_send">#1A34D399</color>
    <color name="card_border_library">#2ABC8CFF</color>
    <color name="gradient_start">#1A1F36</color>
    <color name="gradient_end">#060810</color>
    <color name="accent_secondary">#34D399</color>
    <color name="status_stroke">#1F2937</color>
    <!-- accent_cyan is still referenced by item_layer.xml and item_dial.xml -->
    <color name="accent_cyan">#22D3EE</color>
</resources>
```

- [ ] **Step 2: Delete `values-night/colors.xml`**

Delete the file `app/src/main/res/values-night/colors.xml`. The app uses dark as its only mode going forward.

- [ ] **Step 3: Verify build compiles**

Run: `./gradlew assembleDebug` from `dial-sender/`
Expected: BUILD SUCCESSFUL (no resource errors)

- [ ] **Step 4: Commit — colors and legacy drawable removal**

```bash
git add app/src/main/res/values/colors.xml
git rm app/src/main/res/values-night/colors.xml
git rm app/src/main/res/drawable/bg_card_create.xml
git rm app/src/main/res/drawable/bg_card_send.xml
git rm app/src/main/res/drawable/bg_card_library.xml
git commit -m "feat(design): replace color palette with dark neon system, remove legacy card drawables"
```

---

### Task 2: Update styles

- [ ] **Step 1: Replace `values/styles.xml`**

```xml
<?xml version="1.0" encoding="utf-8"?>
<resources xmlns:tools="http://schemas.android.com/tools">
    <style name="AppTheme" parent="Theme.MaterialComponents.DayNight.NoActionBar">
        <item name="colorPrimary">@color/accent_primary</item>
        <item name="colorPrimaryDark">@color/bg_primary</item>
        <item name="colorAccent">@color/accent_primary</item>
        <item name="android:windowBackground">@color/bg_primary</item>
        <item name="android:statusBarColor">@color/bg_surface</item>
        <item name="android:navigationBarColor">@color/bg_surface</item>
        <item name="android:textColorPrimary">@color/text_primary</item>
        <item name="android:textColorSecondary">@color/text_secondary</item>
        <item name="android:forceDarkAllowed" tools:targetApi="q">false</item>
    </style>

    <style name="CardStyle">
        <item name="android:background">@drawable/bg_card</item>
        <item name="android:padding">16dp</item>
    </style>

    <style name="ButtonPrimary" parent="Widget.MaterialComponents.Button">
        <item name="backgroundTint">@color/accent_primary</item>
        <item name="android:textColor">#060810</item>
        <item name="cornerRadius">12dp</item>
        <item name="android:textSize">15sp</item>
        <item name="android:textStyle">bold</item>
        <item name="android:textAllCaps">false</item>
        <item name="android:paddingTop">14dp</item>
        <item name="android:paddingBottom">14dp</item>
    </style>

    <style name="ButtonSecondary" parent="Widget.MaterialComponents.Button.OutlinedButton">
        <item name="strokeColor">@color/accent_primary</item>
        <item name="android:textColor">@color/accent_primary</item>
        <item name="cornerRadius">12dp</item>
        <item name="android:textSize">14sp</item>
        <item name="android:textAllCaps">false</item>
    </style>

    <style name="ButtonDanger" parent="Widget.MaterialComponents.Button">
        <item name="backgroundTint">@color/accent_danger</item>
        <item name="android:textColor">#FFFFFF</item>
        <item name="cornerRadius">12dp</item>
        <item name="android:textAllCaps">false</item>
    </style>

    <style name="ScreenTitle">
        <item name="android:textSize">20sp</item>
        <item name="android:textStyle">bold</item>
        <item name="android:textColor">@color/text_primary</item>
    </style>

    <style name="MetricValue">
        <item name="android:textSize">22sp</item>
        <item name="android:textColor">#FFFFFF</item>
        <item name="android:textStyle">bold</item>
    </style>

    <style name="MetricLabel">
        <item name="android:textSize">9sp</item>
        <item name="android:textColor">#99FFFFFF</item>
        <item name="android:textAllCaps">true</item>
        <item name="android:letterSpacing">0.08</item>
    </style>

    <style name="ButtonSuccess" parent="Widget.MaterialComponents.Button">
        <item name="backgroundTint">@color/accent_health</item>
        <item name="android:textColor">#060810</item>
        <item name="cornerRadius">12dp</item>
        <item name="android:textAllCaps">false</item>
    </style>

    <style name="ToolbarStyle">
        <item name="android:background">@color/bg_surface</item>
        <item name="android:padding">16dp</item>
        <item name="android:elevation">0dp</item>
    </style>
</resources>
```

- [ ] **Step 2: Build**

Run: `./gradlew assembleDebug`
Expected: BUILD SUCCESSFUL

- [ ] **Step 3: Commit**

```bash
git add app/src/main/res/values/styles.xml
git commit -m "feat(design): update styles for dark neon theme"
```

---

### Task 3: Update card and status drawables

- [ ] **Step 1: Update `drawable/bg_card.xml`**

```xml
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android"
    android:shape="rectangle">
    <solid android:color="@color/bg_card"/>
    <stroke android:width="1dp" android:color="@color/divider"/>
    <corners android:radius="12dp"/>
</shape>
```

- [ ] **Step 2: Update `drawable/bg_status.xml`**

```xml
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android"
    android:shape="rectangle">
    <solid android:color="@color/bg_card"/>
    <stroke android:width="1dp" android:color="@color/divider"/>
    <corners android:radius="12dp"/>
</shape>
```

- [ ] **Step 3: Update `drawable/bg_gradient.xml`**

```xml
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android"
    android:shape="rectangle">
    <solid android:color="@color/bg_primary"/>
</shape>
```

- [ ] **Step 4: Update `drawable/indicator_connected.xml`**

```xml
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android"
    android:shape="oval">
    <solid android:color="@color/status_connected"/>
</shape>
```

- [ ] **Step 5: Update `drawable/indicator_disconnected.xml`**

```xml
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android"
    android:shape="oval">
    <solid android:color="@color/status_disconnected"/>
</shape>
```

- [ ] **Step 6: Create `drawable/indicator_scanning.xml`**

```xml
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android"
    android:shape="oval">
    <solid android:color="@color/status_scanning"/>
</shape>
```

- [ ] **Step 7: Create `drawable/bg_bottom_nav.xml`**

```xml
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android"
    android:shape="rectangle">
    <solid android:color="@color/bg_surface"/>
    <stroke android:width="1dp" android:color="@color/divider"/>
</shape>
```

- [ ] **Step 8: Create `drawable/bg_chip_active.xml`**

```xml
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android"
    android:shape="rectangle">
    <solid android:color="#1A22D3EE"/>
    <stroke android:width="1dp" android:color="#4022D3EE"/>
    <corners android:radius="20dp"/>
</shape>
```

- [ ] **Step 9: Create `drawable/bg_chip_inactive.xml`**

```xml
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android"
    android:shape="rectangle">
    <solid android:color="@color/bg_elevated"/>
    <corners android:radius="20dp"/>
</shape>
```

- [ ] **Step 10: Update `drawable/progress_bar.xml`** (references removed `accent_cyan` token)

```xml
<?xml version="1.0" encoding="utf-8"?>
<layer-list xmlns:android="http://schemas.android.com/apk/res/android">
    <item>
        <shape android:shape="rectangle">
            <corners android:radius="8dp"/>
            <solid android:color="@color/progress_track"/>
        </shape>
    </item>
    <item android:id="@android:id/progress">
        <clip>
            <shape android:shape="rectangle">
                <corners android:radius="8dp"/>
                <solid android:color="@color/progress_fill"/>
            </shape>
        </clip>
    </item>
</layer-list>
```

- [ ] **Step 11: Create metric card gradient drawables**

Create `drawable/bg_card_steps.xml`:
```xml
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android"
    android:shape="rectangle">
    <gradient android:startColor="@color/card_steps_start"
              android:endColor="@color/card_steps_end"
              android:angle="135"/>
    <corners android:radius="12dp"/>
</shape>
```

Create `drawable/bg_card_heart.xml`:
```xml
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android"
    android:shape="rectangle">
    <gradient android:startColor="@color/card_heart_start"
              android:endColor="@color/card_heart_end"
              android:angle="135"/>
    <corners android:radius="12dp"/>
</shape>
```

Create `drawable/bg_card_calories.xml`:
```xml
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android"
    android:shape="rectangle">
    <gradient android:startColor="@color/card_calories_start"
              android:endColor="@color/card_calories_end"
              android:angle="135"/>
    <corners android:radius="12dp"/>
</shape>
```

Create `drawable/bg_card_sleep.xml`:
```xml
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android"
    android:shape="rectangle">
    <gradient android:startColor="@color/card_sleep_start"
              android:endColor="@color/card_sleep_end"
              android:angle="135"/>
    <corners android:radius="12dp"/>
</shape>
```

- [ ] **Step 11: Build**

Run: `./gradlew assembleDebug`
Expected: BUILD SUCCESSFUL

- [ ] **Step 12: Commit**

```bash
git add app/src/main/res/drawable/
git commit -m "feat(design): update drawables and add metric card gradients"
```

---

## Chunk 2: Navigation restructure + new fragments

**Files:**
- Modify: `app/src/main/res/menu/bottom_nav_menu.xml`
- Modify: `app/src/main/res/layout/activity_main.xml`
- Modify: `app/src/main/java/com/example/dialsender/MainActivity.java`
- Create: `app/src/main/res/layout/fragment_home.xml`
- Rewrite: `app/src/main/java/com/example/dialsender/fragments/MeFragment.java` → becomes `HomeFragment.java`
- Create: `app/src/main/java/com/example/dialsender/fragments/HomeFragment.java`
- Create: `app/src/main/res/layout/fragment_dials.xml`
- Rewrite: `app/src/main/java/com/example/dialsender/fragments/SportFragment.java` → becomes `DialsFragment.java`
- Create: `app/src/main/java/com/example/dialsender/fragments/DialsFragment.java`

### Task 4: Rename tab labels in strings

- [ ] **Step 1: Add new nav strings to `values/strings.xml`**

Add inside `<resources>`:
```xml
<!-- Bottom nav tab labels -->
<string name="nav_home">Inicio</string>
<string name="nav_dials">Carátulas</string>
<string name="nav_device">Dispositivo</string>
<string name="nav_health">Salud</string>
```

Also add to `values-es/strings.xml` if it exists (same values are fine for Spanish).

- [ ] **Step 2: Commit**

```bash
git add app/src/main/res/values/strings.xml app/src/main/res/values-es/strings.xml
git commit -m "feat(nav): add bottom nav tab label strings"
```

---

### Task 5: Update bottom nav menu and main layout

- [ ] **Step 1: Replace `menu/bottom_nav_menu.xml`**

```xml
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android">
    <item
        android:id="@+id/nav_home"
        android:icon="@drawable/ic_nav_status"
        android:title="@string/nav_home" />
    <item
        android:id="@+id/nav_dials"
        android:icon="@drawable/ic_nav_sport"
        android:title="@string/nav_dials" />
    <item
        android:id="@+id/nav_device"
        android:icon="@drawable/ic_nav_device"
        android:title="@string/nav_device" />
    <item
        android:id="@+id/nav_health"
        android:icon="@drawable/ic_nav_me"
        android:title="@string/nav_health" />
</menu>
```

Note: Reuses existing icon drawables. Icon assignments can be refined later without affecting layout.

- [ ] **Step 2: Replace `layout/activity_main.xml`**

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@color/bg_primary">

    <FrameLayout
        android:id="@+id/fragmentContainer"
        android:layout_width="0dp"
        android:layout_height="0dp"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintBottom_toTopOf="@+id/bottomNav"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent" />

    <com.google.android.material.bottomnavigation.BottomNavigationView
        android:id="@+id/bottomNav"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:background="@drawable/bg_bottom_nav"
        app:itemIconTint="@color/bottom_nav_selector"
        app:itemTextColor="@color/bottom_nav_selector"
        app:menu="@menu/bottom_nav_menu"
        app:labelVisibilityMode="labeled"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent" />

</androidx.constraintlayout.widget.ConstraintLayout>
```

- [ ] **Step 3: Create `res/color/bottom_nav_selector.xml`** (color state list — must be in `res/color/`, not `res/drawable/`)

```bash
mkdir -p app/src/main/res/color
```

```xml
<?xml version="1.0" encoding="utf-8"?>
<selector xmlns:android="http://schemas.android.com/apk/res/android">
    <item android:color="@color/bottom_nav_active" android:state_checked="true"/>
    <item android:color="@color/bottom_nav_inactive"/>
</selector>
```

The layout uses `@color/bottom_nav_selector` — Android resolves color state lists from `res/color/`. Placing this file in `res/drawable/` would cause a resource compile error.

- [ ] **Step 4: Update `MainActivity.java`**

```java
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
```

Note: `SettingsActivity.applyGlobalTheme(this)` is removed because the theme is now always dark — forced via `AppTheme` with `forceDarkAllowed=false`.

- [ ] **Step 5: Build** *(informational — Java compile errors expected here)*

Run: `./gradlew assembleDebug`
Expected: Resource errors = 0. Java compile errors for `HomeFragment` and `DialsFragment` are expected at this point and are resolved in Tasks 6–7. Do not treat Java-only errors as a blocker for this step.

- [ ] **Step 6: Commit**

```bash
git add app/src/main/res/menu/bottom_nav_menu.xml \
        app/src/main/res/layout/activity_main.xml \
        app/src/main/res/color/bottom_nav_selector.xml \
        app/src/main/java/com/example/dialsender/MainActivity.java
git commit -m "feat(nav): restructure bottom nav to 4 tabs (home/dials/device/health)"
```

---

### Task 6: Create HomeFragment (Tab 1 — Inicio)

- [ ] **Step 1: Create `layout/fragment_home.xml`**

```xml
<?xml version="1.0" encoding="utf-8"?>
<ScrollView xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@color/bg_primary"
    android:fillViewport="true">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical"
        android:padding="20dp">

        <!-- Header -->
        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="horizontal"
            android:gravity="center_vertical"
            android:layout_marginBottom="20dp">

            <LinearLayout
                android:layout_width="0dp"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:orientation="vertical">

                <TextView
                    android:id="@+id/txtGreeting"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:text="Dial Studio"
                    android:textColor="@color/text_primary"
                    android:textSize="20sp"
                    android:textStyle="bold"/>

                <TextView
                    android:id="@+id/txtDate"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:textColor="@color/text_secondary"
                    android:textSize="12sp"
                    android:layout_marginTop="2dp"/>
            </LinearLayout>

            <!-- Connection chip -->
            <LinearLayout
                android:id="@+id/chipConnection"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:orientation="horizontal"
                android:gravity="center_vertical"
                android:background="@drawable/bg_chip_inactive"
                android:paddingStart="10dp"
                android:paddingEnd="10dp"
                android:paddingTop="6dp"
                android:paddingBottom="6dp"
                android:clickable="false">

                <View
                    android:id="@+id/homeStatusDot"
                    android:layout_width="7dp"
                    android:layout_height="7dp"
                    android:background="@drawable/indicator_disconnected"
                    android:layout_marginEnd="6dp"/>

                <TextView
                    android:id="@+id/homeStatusText"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:text="Desconectado"
                    android:textColor="@color/status_disconnected"
                    android:textSize="10sp"
                    android:textStyle="bold"/>
            </LinearLayout>
        </LinearLayout>

        <!-- Metric cards grid (2x2) -->
        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="horizontal"
            android:layout_marginBottom="10dp">

            <!-- Steps -->
            <LinearLayout
                android:layout_width="0dp"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:background="@drawable/bg_card_steps"
                android:orientation="vertical"
                android:padding="14dp"
                android:layout_marginEnd="6dp">

                <TextView
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:text="PASOS"
                    style="@style/MetricLabel"/>

                <TextView
                    android:id="@+id/txtSteps"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:text="—"
                    style="@style/MetricValue"
                    android:layout_marginTop="4dp"/>

                <ProgressBar
                    android:id="@+id/progressSteps"
                    style="?android:attr/progressBarStyleHorizontal"
                    android:layout_width="match_parent"
                    android:layout_height="3dp"
                    android:progressDrawable="@drawable/progress_bar"
                    android:max="10000"
                    android:progress="0"
                    android:layout_marginTop="8dp"/>

                <TextView
                    android:id="@+id/txtStepsGoal"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:text="Meta: 10,000"
                    android:textColor="#80FFFFFF"
                    android:textSize="9sp"
                    android:layout_marginTop="3dp"/>
            </LinearLayout>

            <!-- Heart rate -->
            <LinearLayout
                android:layout_width="0dp"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:background="@drawable/bg_card_heart"
                android:orientation="vertical"
                android:padding="14dp"
                android:layout_marginStart="6dp">

                <TextView
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:text="FREC. CARDÍACA"
                    style="@style/MetricLabel"/>

                <LinearLayout
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:orientation="horizontal"
                    android:gravity="baseline"
                    android:layout_marginTop="4dp">

                    <TextView
                        android:id="@+id/txtHeartRate"
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:text="—"
                        style="@style/MetricValue"/>

                    <TextView
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:text=" bpm"
                        android:textColor="#80FFFFFF"
                        android:textSize="10sp"/>
                </LinearLayout>

                <TextView
                    android:id="@+id/txtHeartRateSub"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:text="Sin datos"
                    android:textColor="#80FFFFFF"
                    android:textSize="9sp"
                    android:layout_marginTop="8dp"/>
            </LinearLayout>
        </LinearLayout>

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="horizontal"
            android:layout_marginBottom="16dp">

            <!-- Calories -->
            <LinearLayout
                android:layout_width="0dp"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:background="@drawable/bg_card_calories"
                android:orientation="vertical"
                android:padding="14dp"
                android:layout_marginEnd="6dp">

                <TextView
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:text="CALORÍAS"
                    style="@style/MetricLabel"/>

                <LinearLayout
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:orientation="horizontal"
                    android:gravity="baseline"
                    android:layout_marginTop="4dp">

                    <TextView
                        android:id="@+id/txtCalories"
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:text="—"
                        style="@style/MetricValue"/>

                    <TextView
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:text=" kcal"
                        android:textColor="#80FFFFFF"
                        android:textSize="10sp"/>
                </LinearLayout>

                <TextView
                    android:id="@+id/txtCaloriesSub"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:text="Meta: 2,000 kcal"
                    android:textColor="#80FFFFFF"
                    android:textSize="9sp"
                    android:layout_marginTop="8dp"/>
            </LinearLayout>

            <!-- Sleep -->
            <LinearLayout
                android:layout_width="0dp"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:background="@drawable/bg_card_sleep"
                android:orientation="vertical"
                android:padding="14dp"
                android:layout_marginStart="6dp">

                <TextView
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:text="SUEÑO"
                    style="@style/MetricLabel"/>

                <TextView
                    android:id="@+id/txtSleep"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:text="—"
                    style="@style/MetricValue"
                    android:layout_marginTop="4dp"/>

                <TextView
                    android:id="@+id/txtSleepSub"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:text="Sin datos"
                    android:textColor="#80FFFFFF"
                    android:textSize="9sp"
                    android:layout_marginTop="8dp"/>
            </LinearLayout>
        </LinearLayout>

        <!-- Quick action: Send dial -->
        <LinearLayout
            android:id="@+id/cardSendDialHome"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:background="@drawable/bg_card"
            android:orientation="horizontal"
            android:gravity="center_vertical"
            android:padding="16dp"
            android:clickable="true"
            android:focusable="true">

            <LinearLayout
                android:layout_width="36dp"
                android:layout_height="36dp"
                android:background="@drawable/bg_chip_active"
                android:gravity="center"
                android:layout_marginEnd="12dp">

                <ImageView
                    android:layout_width="18dp"
                    android:layout_height="18dp"
                    android:src="@drawable/ic_send"
                    android:contentDescription="Send"/>
            </LinearLayout>

            <LinearLayout
                android:layout_width="0dp"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:orientation="vertical">

                <TextView
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:text="Enviar carátula"
                    android:textColor="@color/text_primary"
                    android:textSize="13sp"
                    android:textStyle="bold"/>

                <TextView
                    android:id="@+id/txtLastDial"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:text="Última: —"
                    android:textColor="@color/text_secondary"
                    android:textSize="11sp"
                    android:layout_marginTop="2dp"/>
            </LinearLayout>

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="›"
                android:textColor="@color/accent_primary"
                android:textSize="22sp"/>
        </LinearLayout>

    </LinearLayout>
</ScrollView>
```

- [ ] **Step 2: Create `HomeFragment.java`**

```java
package com.example.dialsender.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.dialsender.DialLibraryActivity;
import com.example.dialsender.R;
import com.example.dialsender.ble.BleManager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class HomeFragment extends Fragment implements BleManager.BleStateListener {

    private static final String PREF_NAME = "dial_sender_prefs";
    private static final String PREF_HEALTH_PREFIX = "health_";

    private TextView txtGreeting, txtDate, txtSteps, txtStepsGoal;
    private TextView txtHeartRate, txtHeartRateSub, txtCalories, txtCaloriesSub;
    private TextView txtSleep, txtSleepSub, txtLastDial;
    private TextView homeStatusText;
    private View homeStatusDot;
    private ProgressBar progressSteps;
    private SharedPreferences prefs;
    private BleManager bleManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        txtGreeting = view.findViewById(R.id.txtGreeting);
        txtDate = view.findViewById(R.id.txtDate);
        txtSteps = view.findViewById(R.id.txtSteps);
        txtStepsGoal = view.findViewById(R.id.txtStepsGoal);
        txtHeartRate = view.findViewById(R.id.txtHeartRate);
        txtHeartRateSub = view.findViewById(R.id.txtHeartRateSub);
        txtCalories = view.findViewById(R.id.txtCalories);
        txtCaloriesSub = view.findViewById(R.id.txtCaloriesSub);
        txtSleep = view.findViewById(R.id.txtSleep);
        txtSleepSub = view.findViewById(R.id.txtSleepSub);
        txtLastDial = view.findViewById(R.id.txtLastDial);
        homeStatusText = view.findViewById(R.id.homeStatusText);
        homeStatusDot = view.findViewById(R.id.homeStatusDot);
        progressSteps = view.findViewById(R.id.progressSteps);

        prefs = requireContext().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        bleManager = BleManager.getInstance(requireContext());

        view.findViewById(R.id.cardSendDialHome).setOnClickListener(v -> {
            Intent intent = new Intent(requireContext(), DialLibraryActivity.class);
            startActivity(intent);
        });

        updateDate();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        bleManager.setListener(this);
        refreshMetrics();
        updateConnectionState(bleManager.isSessionReady());
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    private void updateDate() {
        if (txtDate == null) return;
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE, d MMM", new Locale("es", "ES"));
        txtDate.setText(sdf.format(new Date()));
    }

    private void refreshMetrics() {
        if (!isAdded() || prefs == null) return;

        // Steps
        int steps = getLatestMetricValue("steps");
        txtSteps.setText(steps > 0 ? String.format(Locale.US, "%,d", steps) : "—");
        progressSteps.setProgress(Math.min(steps, 10000));

        // Heart rate
        int hr = getLatestMetricValue("heart_rate");
        txtHeartRate.setText(hr > 0 ? String.valueOf(hr) : "—");
        txtHeartRateSub.setText(hr > 0 ? "Normal" : "Sin datos");

        // Calories
        int cal = getLatestMetricValue("calories");
        txtCalories.setText(cal > 0 ? String.format(Locale.US, "%,d", cal) : "—");

        // Sleep (stored in minutes)
        int sleepMin = getLatestMetricValue("sleep");
        if (sleepMin > 0) {
            int h = sleepMin / 60;
            int m = sleepMin % 60;
            txtSleep.setText(h + "h " + m + "m");
            txtSleepSub.setText(h >= 7 ? "Bueno" : h >= 5 ? "Regular" : "Insuficiente");
        } else {
            txtSleep.setText("—");
            txtSleepSub.setText("Sin datos");
        }
    }

    private int getLatestMetricValue(String metric) {
        String history = prefs.getString(PREF_HEALTH_PREFIX + metric, "");
        if (history.isEmpty()) return 0;
        String[] entries = history.split(",");
        String last = entries[entries.length - 1].trim();
        try {
            if (last.contains(":")) {
                return Integer.parseInt(last.split(":")[1]);
            }
            return Integer.parseInt(last);
        } catch (Exception e) {
            return 0;
        }
    }

    private void updateConnectionState(boolean connected) {
        if (!isAdded()) return;
        if (connected) {
            homeStatusDot.setBackgroundResource(R.drawable.indicator_connected);
            homeStatusText.setText("Conectado");
            homeStatusText.setTextColor(requireContext().getColor(R.color.status_connected));
        } else {
            homeStatusDot.setBackgroundResource(R.drawable.indicator_disconnected);
            homeStatusText.setText("Desconectado");
            homeStatusText.setTextColor(requireContext().getColor(R.color.status_disconnected));
        }
    }

    // BleStateListener
    @Override
    public void onConnectionStateChange(boolean connected, boolean sessionReady) {
        if (!isAdded()) return;
        requireActivity().runOnUiThread(() -> updateConnectionState(sessionReady));
    }

    @Override public void onHealthDataReceived(String keyName, byte[] payload) {}
    @Override public void onHealthSyncComplete() {
        if (!isAdded()) return;
        requireActivity().runOnUiThread(this::refreshMetrics);
    }
    @Override public void onTransferProgress(int percent, long bytesTransferred, long totalBytes) {}
    @Override public void onTransferComplete() {}
    @Override public void onLogUpdated() {}
}
```

- [ ] **Step 3: Build**

Run: `./gradlew assembleDebug`
Expected: BUILD SUCCESSFUL

- [ ] **Step 4: Commit**

```bash
git add app/src/main/res/layout/fragment_home.xml \
        app/src/main/java/com/example/dialsender/fragments/HomeFragment.java
git commit -m "feat(home): add HomeFragment with health dashboard layout"
```

---

### Task 7: Create DialsFragment (Tab 2 — Carátulas)

- [ ] **Step 1: Create `layout/fragment_dials.xml`**

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:background="@color/bg_primary">

    <!-- Header -->
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical"
        android:paddingStart="20dp"
        android:paddingEnd="20dp"
        android:paddingTop="20dp"
        android:paddingBottom="12dp">

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@string/nav_dials"
            style="@style/ScreenTitle"/>

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Biblioteca y creación"
            android:textColor="@color/text_secondary"
            android:textSize="12sp"
            android:layout_marginTop="2dp"/>
    </LinearLayout>

    <!-- Tabs: Mis carátulas / Presets -->
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        android:paddingStart="20dp"
        android:paddingEnd="20dp"
        android:paddingBottom="14dp">

        <TextView
            android:id="@+id/tabMyDials"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Mis carátulas"
            android:textColor="@color/accent_primary"
            android:textSize="12sp"
            android:textStyle="bold"
            android:background="@drawable/bg_chip_active"
            android:paddingStart="14dp"
            android:paddingEnd="14dp"
            android:paddingTop="7dp"
            android:paddingBottom="7dp"
            android:layout_marginEnd="8dp"
            android:clickable="true"
            android:focusable="true"/>

        <TextView
            android:id="@+id/tabPresets"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Presets"
            android:textColor="@color/text_secondary"
            android:textSize="12sp"
            android:background="@drawable/bg_chip_inactive"
            android:paddingStart="14dp"
            android:paddingEnd="14dp"
            android:paddingTop="7dp"
            android:paddingBottom="7dp"
            android:clickable="true"
            android:focusable="true"/>
    </LinearLayout>

    <!-- Dial grid (populated by DialLibraryActivity or inline via RecyclerView in future) -->
    <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/dialsGrid"
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="1"
        android:paddingStart="16dp"
        android:paddingEnd="16dp"
        android:clipToPadding="false"/>

    <!-- FAB: Create new dial -->
    <com.google.android.material.button.MaterialButton
        android:id="@+id/btnCreateDial"
        style="@style/ButtonPrimary"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="+ Crear nueva carátula"
        android:layout_marginStart="20dp"
        android:layout_marginEnd="20dp"
        android:layout_marginTop="12dp"
        android:layout_marginBottom="16dp"/>

</LinearLayout>
```

- [ ] **Step 2: Create `DialsFragment.java`**

```java
package com.example.dialsender.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dialsender.DialEditorActivity;
import com.example.dialsender.DialLibraryActivity;
import com.example.dialsender.R;

public class DialsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dials, container, false);

        RecyclerView grid = view.findViewById(R.id.dialsGrid);
        grid.setLayoutManager(new GridLayoutManager(requireContext(), 3));

        view.findViewById(R.id.btnCreateDial).setOnClickListener(v -> {
            Intent intent = new Intent(requireContext(), DialEditorActivity.class);
            startActivity(intent);
        });

        view.findViewById(R.id.tabMyDials).setOnClickListener(v -> {
            Intent intent = new Intent(requireContext(), DialLibraryActivity.class);
            startActivity(intent);
        });

        view.findViewById(R.id.tabPresets).setOnClickListener(v -> {
            Intent intent = new Intent(requireContext(), DialLibraryActivity.class);
            intent.putExtra("tab", "presets");
            startActivity(intent);
        });

        return view;
    }
}
```

- [ ] **Step 3: Delete `SportFragment.java` and `MeFragment.java`** (no longer used)

```bash
git rm app/src/main/java/com/example/dialsender/fragments/SportFragment.java
git rm app/src/main/java/com/example/dialsender/fragments/MeFragment.java
```

- [ ] **Step 4: Build**

Run: `./gradlew assembleDebug`
Expected: BUILD SUCCESSFUL

- [ ] **Step 5: Commit**

```bash
git add app/src/main/res/layout/fragment_dials.xml \
        app/src/main/java/com/example/dialsender/fragments/DialsFragment.java
git commit -m "feat(dials): add DialsFragment for watch face library tab"
```

---

## Chunk 3: Existing fragment and activity layout updates

**Files:**
- Modify: `app/src/main/res/layout/fragment_device.xml`
- Modify: `app/src/main/res/layout/fragment_status.xml`
- Delete: references to `fragment_status.xml` back button (already handled in StatusFragment.java)
- Modify: `app/src/main/res/layout/activity_dial_library.xml`
- Modify: `app/src/main/res/layout/activity_settings.xml`
- Modify: `app/src/main/res/layout/activity_dial_editor.xml` (color/style pass)
- Modify: `app/src/main/res/layout/activity_log.xml` (color/style pass)

### Task 8: Update DeviceFragment layout (Tab 3 — Dispositivo)

- [ ] **Step 1: Replace `layout/fragment_device.xml`**

```xml
<?xml version="1.0" encoding="utf-8"?>
<ScrollView xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@color/bg_primary"
    android:fillViewport="true">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical"
        android:padding="20dp">

        <!-- Header -->
        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@string/nav_device"
            style="@style/ScreenTitle"
            android:layout_marginBottom="16dp"/>

        <!-- Device status card -->
        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:background="@drawable/bg_card"
            android:orientation="vertical"
            android:padding="16dp"
            android:layout_marginBottom="12dp">

            <!-- Device info row -->
            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:orientation="horizontal"
                android:gravity="center_vertical"
                android:layout_marginBottom="14dp">

                <!-- Watch icon -->
                <LinearLayout
                    android:layout_width="44dp"
                    android:layout_height="44dp"
                    android:background="@drawable/bg_chip_inactive"
                    android:gravity="center"
                    android:layout_marginEnd="12dp">

                    <View
                        android:id="@+id/statusIndicator"
                        android:layout_width="16dp"
                        android:layout_height="16dp"
                        android:background="@drawable/indicator_disconnected"/>
                </LinearLayout>

                <LinearLayout
                    android:layout_width="0dp"
                    android:layout_height="wrap_content"
                    android:layout_weight="1"
                    android:orientation="vertical">

                    <TextView
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:text="Smart Watch"
                        android:textColor="@color/text_primary"
                        android:textSize="14sp"
                        android:textStyle="bold"/>

                    <TextView
                        android:id="@+id/txtStatus"
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:text="@string/disconnected"
                        android:textColor="@color/status_disconnected"
                        android:textSize="11sp"
                        android:layout_marginTop="2dp"/>
                </LinearLayout>
            </LinearLayout>

            <!-- Battery / RSSI chips -->
            <LinearLayout
                android:id="@+id/statsRow"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:orientation="horizontal"
                android:layout_marginBottom="12dp"
                android:visibility="gone">

                <LinearLayout
                    android:layout_width="0dp"
                    android:layout_height="wrap_content"
                    android:layout_weight="1"
                    android:background="@drawable/bg_chip_inactive"
                    android:orientation="vertical"
                    android:padding="10dp"
                    android:gravity="center"
                    android:layout_marginEnd="6dp">

                    <TextView
                        android:id="@+id/txtBattery"
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:text="—%"
                        android:textColor="@color/accent_primary"
                        android:textSize="16sp"
                        android:textStyle="bold"/>

                    <TextView
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:text="Batería"
                        android:textColor="@color/text_secondary"
                        android:textSize="10sp"/>
                </LinearLayout>

                <LinearLayout
                    android:layout_width="0dp"
                    android:layout_height="wrap_content"
                    android:layout_weight="1"
                    android:background="@drawable/bg_chip_inactive"
                    android:orientation="vertical"
                    android:padding="10dp"
                    android:gravity="center"
                    android:layout_marginStart="6dp">

                    <TextView
                        android:id="@+id/txtRssi"
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:text="—"
                        android:textColor="@color/accent_primary"
                        android:textSize="16sp"
                        android:textStyle="bold"/>

                    <TextView
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:text="RSSI"
                        android:textColor="@color/text_secondary"
                        android:textSize="10sp"/>
                </LinearLayout>
            </LinearLayout>

            <!-- Connect button -->
            <Button
                android:id="@+id/btnConnect"
                style="@style/ButtonPrimary"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="@string/scan_connect"/>

            <!-- Note: statsRow visibility is toggled to VISIBLE in DeviceFragment.java
                 when onConnectionStateChange(true, true) fires. Battery/RSSI values
                 can be populated if BleManager exposes them; otherwise the row stays
                 hidden with gone visibility. No Java changes required to keep existing
                 behavior — the chips are additive UI only. -->
        </LinearLayout>

        <!-- Watch face shortcuts -->
        <LinearLayout
            android:id="@+id/btnWatchFaceGallery"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:background="@drawable/bg_card"
            android:padding="16dp"
            android:orientation="horizontal"
            android:gravity="center_vertical"
            android:clickable="true"
            android:focusable="true"
            android:layout_marginBottom="8dp">

            <ImageView
                android:layout_width="28dp"
                android:layout_height="28dp"
                android:src="@drawable/ic_back"
                android:rotation="180"
                android:layout_marginEnd="14dp"
                android:contentDescription="Gallery"/>

            <TextView
                android:layout_width="0dp"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:text="Watch Face Gallery"
                android:textColor="@color/text_primary"
                android:textSize="14sp"
                android:textStyle="bold"/>

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="›"
                android:textColor="@color/accent_primary"
                android:textSize="20sp"/>
        </LinearLayout>

        <LinearLayout
            android:id="@+id/btnWatchFaceBuilder"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:background="@drawable/bg_card"
            android:padding="16dp"
            android:orientation="horizontal"
            android:gravity="center_vertical"
            android:clickable="true"
            android:focusable="true"
            android:layout_marginBottom="16dp">

            <ImageView
                android:layout_width="28dp"
                android:layout_height="28dp"
                android:src="@drawable/ic_create"
                android:layout_marginEnd="14dp"
                android:contentDescription="Builder"/>

            <TextView
                android:layout_width="0dp"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:text="Watch Face Builder"
                android:textColor="@color/text_primary"
                android:textSize="14sp"
                android:textStyle="bold"/>

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="›"
                android:textColor="@color/accent_primary"
                android:textSize="20sp"/>
        </LinearLayout>

        <!-- BLE Log section -->
        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:background="@drawable/bg_card"
            android:orientation="vertical"
            android:padding="16dp">

            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:gravity="center_vertical"
                android:layout_marginBottom="10dp">

                <TextView
                    android:layout_width="0dp"
                    android:layout_height="wrap_content"
                    android:layout_weight="1"
                    android:text="Log BLE"
                    android:textColor="@color/text_primary"
                    android:textSize="14sp"
                    android:textStyle="bold"/>

                <TextView
                    android:id="@+id/txtLogCount"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:text="0 líneas"
                    android:textColor="@color/text_secondary"
                    android:textSize="11sp"/>
            </LinearLayout>

            <ScrollView
                android:id="@+id/logScrollView"
                android:layout_width="match_parent"
                android:layout_height="160dp"
                android:background="@color/bg_surface"
                android:padding="10dp"
                android:layout_marginBottom="10dp">

                <TextView
                    android:id="@+id/txtBleLog"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:fontFamily="monospace"
                    android:textColor="@color/accent_primary"
                    android:textSize="10sp"
                    android:text="Waiting for BLE events..."/>
            </ScrollView>

            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:orientation="horizontal">

                <Button
                    android:id="@+id/btnCopyLog"
                    android:layout_width="0dp"
                    android:layout_height="38dp"
                    android:layout_weight="1"
                    android:text="Copiar"
                    android:textSize="12sp"
                    android:layout_marginEnd="6dp"
                    style="@style/ButtonPrimary"/>

                <Button
                    android:id="@+id/btnSaveLog"
                    android:layout_width="0dp"
                    android:layout_height="38dp"
                    android:layout_weight="1"
                    android:text="Guardar"
                    android:textSize="12sp"
                    android:layout_marginEnd="6dp"
                    style="@style/ButtonPrimary"/>

                <Button
                    android:id="@+id/btnClearLog"
                    android:layout_width="0dp"
                    android:layout_height="38dp"
                    android:layout_weight="1"
                    android:text="Limpiar"
                    android:textSize="12sp"
                    style="@style/ButtonDanger"/>
            </LinearLayout>
        </LinearLayout>

    </LinearLayout>
</ScrollView>
```

- [ ] **Step 2: Build**

Run: `./gradlew assembleDebug`
Expected: BUILD SUCCESSFUL

- [ ] **Step 3: Commit**

```bash
git add app/src/main/res/layout/fragment_device.xml
git commit -m "feat(device): redesign DeviceFragment layout with dark neon style"
```

---

### Task 9: Update StatusFragment layout (Tab 4 — Salud)

- [ ] **Step 1: Replace `layout/fragment_status.xml`**

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:background="@color/bg_primary">

    <!-- Header -->
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        android:gravity="center_vertical"
        android:paddingStart="20dp"
        android:paddingEnd="20dp"
        android:paddingTop="20dp"
        android:paddingBottom="12dp">

        <TextView
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="@string/nav_health"
            style="@style/ScreenTitle"/>

        <Button
            android:id="@+id/btnSyncHealthFromScreen"
            style="@style/ButtonSecondary"
            android:layout_width="wrap_content"
            android:layout_height="36dp"
            android:text="@string/sync_now"/>
    </LinearLayout>

    <!-- Time range chips -->
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        android:paddingStart="20dp"
        android:paddingEnd="20dp"
        android:paddingBottom="12dp">

        <com.google.android.material.button.MaterialButtonToggleGroup
            android:id="@+id/toggleTimeRange"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            app:singleSelection="true"
            app:checkedButton="@+id/btnRangeDay">

            <com.google.android.material.button.MaterialButton
                android:id="@+id/btnRangeDay"
                style="?attr/materialButtonOutlinedStyle"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:textAllCaps="false"
                android:textSize="12sp"
                android:text="Día"/>

            <com.google.android.material.button.MaterialButton
                android:id="@+id/btnRangeWeek"
                style="?attr/materialButtonOutlinedStyle"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:textAllCaps="false"
                android:textSize="12sp"
                android:text="Semana"/>

            <com.google.android.material.button.MaterialButton
                android:id="@+id/btnRangeMonth"
                style="?attr/materialButtonOutlinedStyle"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:textAllCaps="false"
                android:textSize="12sp"
                android:text="Mes"/>
        </com.google.android.material.button.MaterialButtonToggleGroup>
    </LinearLayout>

    <!-- Health metrics scroll -->
    <ScrollView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:fillViewport="true">

        <LinearLayout
            android:id="@+id/healthContainer"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="vertical"
            android:paddingStart="16dp"
            android:paddingEnd="16dp"
            android:paddingBottom="16dp"/>
    </ScrollView>
</LinearLayout>
```

Note: The `btnBackHealth` view is removed (StatusFragment.java already hides it — the view no longer exists so the `if (btnBack != null)` guard in StatusFragment will handle it cleanly).

- [ ] **Step 2: Update metric card colors in `StatusFragment.java`**

In `StatusFragment.java`, inside the `for (String metric : METRICS)` loop, locate and replace this exact block:

```java
            androidx.cardview.widget.CardView card = new androidx.cardview.widget.CardView(requireContext());
            LinearLayout.LayoutParams cardParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            cardParams.setMargins(0, 0, 0, dpToPx(24));
            card.setLayoutParams(cardParams);
            card.setRadius(dpToPx(24));
            card.setCardElevation(dpToPx(8));
            card.setCardBackgroundColor(ContextCompat.getColor(requireContext(), R.color.card_library_start));
```

Replace it with:

```java
// Map metric to gradient drawable
int bgRes;
switch (metric) {
    case "heart_rate": bgRes = R.drawable.bg_card_heart; break;
    case "calories":   bgRes = R.drawable.bg_card_calories; break;
    case "sleep":      bgRes = R.drawable.bg_card_sleep; break;
    default:           bgRes = R.drawable.bg_card_steps; break;
}

androidx.cardview.widget.CardView card = new androidx.cardview.widget.CardView(requireContext());
LinearLayout.LayoutParams cardParams = new LinearLayout.LayoutParams(
        LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
cardParams.setMargins(0, 0, 0, dpToPx(16));
card.setLayoutParams(cardParams);
card.setRadius(dpToPx(12));
card.setCardElevation(0);
card.setCardBackgroundColor(android.graphics.Color.TRANSPARENT);
card.setBackground(ContextCompat.getDrawable(requireContext(), bgRes));
```

The `bgRes` switch is placed immediately *before* the `CardView` constructor so `bgRes` is in scope when `setBackground` is called.

- [ ] **Step 3: Build**

Run: `./gradlew assembleDebug`
Expected: BUILD SUCCESSFUL

- [ ] **Step 4: Commit**

```bash
git add app/src/main/res/layout/fragment_status.xml \
        app/src/main/java/com/example/dialsender/fragments/StatusFragment.java
git commit -m "feat(health): redesign health tab with metric card gradients"
```

---

### Task 10: Update secondary activity layouts

**activity_settings.xml** — already uses new color tokens. Two changes:
- [ ] **Step 1: Update `activity_settings.xml`**

  Change 1 — Toolbar elevation: find `android:elevation="4dp"` inside the first `LinearLayout` child (the toolbar, ~line 15) and change to `android:elevation="0dp"`.

  Change 2 — Remove `applyGlobalTheme`: in `SettingsActivity.java`, `applyGlobalTheme(this)` is called in `onCreate`. Remove that call (theme is now forced dark via `AppTheme`). The `applyGlobalTheme` method itself can remain (it may be used elsewhere) — just remove the call in `SettingsActivity.onCreate`.

**activity_dial_library.xml / DialLibraryActivity.java** — two changes:
- [ ] **Step 2: Update `activity_dial_library.xml` and `DialLibraryActivity.java`**

  Change 1 — Toolbar elevation in `activity_dial_library.xml`: find `android:elevation="4dp"` (~line 15) and change to `android:elevation="0dp"`.

  Change 2 — Remove `applyGlobalTheme` call in `DialLibraryActivity.java` `onCreate`, same as Step 1.

**activity_log.xml / LogActivity.java** — token mismatch, elevation, and theme call:
- [ ] **Step 3: Update `activity_log.xml` and `LogActivity.java`**

  Change 1 — Log text color: `android:textColor="@color/accent_cyan"` (~line 76) → `android:textColor="@color/accent_primary"` (`accent_cyan` removed from palette).

  Change 2 — Toolbar elevation (~line 15): `android:elevation="4dp"` → `android:elevation="0dp"`.

  Change 3 — Remove `applyGlobalTheme` call in `LogActivity.java` `onCreate`.

**activity_dial_editor.xml / DialEditorActivity.java** — hardcoded color, elevation, and theme call:
- [ ] **Step 4: Update `activity_dial_editor.xml` and `DialEditorActivity.java`**

  Change 1 — Preview background: `android:background="#050810"` (preview `FrameLayout`, ~line 58) → `android:background="@color/bg_primary"`.

  Change 2 — Toolbar elevation (~line 15): `android:elevation="4dp"` → `android:elevation="0dp"`.

  Change 3 — Remove `applyGlobalTheme` call in `DialEditorActivity.java` `onCreate`.

  No other changes needed — `ButtonSuccess`, `ButtonSecondary`, and all color tokens are compatible.

- [ ] **Step 5: Build**

Run: `./gradlew assembleDebug`
Expected: BUILD SUCCESSFUL

- [ ] **Step 6: Commit**

```bash
git add app/src/main/res/layout/activity_settings.xml \
        app/src/main/res/layout/activity_dial_library.xml \
        app/src/main/res/layout/activity_log.xml \
        app/src/main/res/layout/activity_dial_editor.xml \
        app/src/main/java/com/example/dialsender/SettingsActivity.java \
        app/src/main/java/com/example/dialsender/DialLibraryActivity.java \
        app/src/main/java/com/example/dialsender/LogActivity.java \
        app/src/main/java/com/example/dialsender/DialEditorActivity.java
git commit -m "feat(design): apply dark neon style to secondary activity layouts and remove applyGlobalTheme"
```

---

### Task 11: Final build and smoke test

- [ ] **Step 1: Clean build**

Run: `./gradlew clean assembleDebug`
Expected: BUILD SUCCESSFUL with no warnings about missing resources

- [ ] **Step 2: Visual smoke test on device/emulator**

Install APK and verify:
- [ ] App launches on Home tab with dark background and metric grid
- [ ] Bottom nav shows 4 tabs with cyan active state
- [ ] Carátulas tab opens with grid layout
- [ ] Dispositivo tab shows connection card and BLE log
- [ ] Salud tab shows time range selector and metric cards
- [ ] No white/light background flashes on any screen

- [ ] **Step 3: Final commit**

Run `git status` first to confirm no unintended untracked files. Then:

```bash
git add app/src/main/res/ app/src/main/java/com/example/dialsender/
git commit -m "feat(design): complete dark neon UI redesign

- New 4-tab navigation: Inicio, Carátulas, Dispositivo, Salud
- Dark color system (#060810 bg, #22D3EE cyan accent)
- Huawei Health-style metric cards with per-category gradients
- HomeFragment with health dashboard
- DialsFragment for watch face library
- All layouts updated to dark neon system"
```
