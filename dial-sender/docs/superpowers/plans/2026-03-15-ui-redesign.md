# UI Redesign — Gauges, Settings Tab & Bug Fixes Implementation Plan

> **For agentic workers:** REQUIRED: Use superpowers:subagent-driven-development (if subagents available) or superpowers:executing-plans to implement this plan. Steps use checkbox (`- [ ]`) syntax for tracking.

**Goal:** Redesign the Home screen with gauge charts, move health charts behind gauge taps, rename "Salud" tab to "Ajustes" with app settings, and fix 3 bugs.

**Architecture:** New `GaugeView` custom View + `MetricDetailBottomSheet` replaces the old 2×2 metric card grid in Home. `SettingsFragment` replaces `StatusFragment` in the nav tab. `StatusFragment` is kept and reused inside `MetricDetailBottomSheet`.

**Tech Stack:** Android Java, MPAndroidChart, Material Components, SharedPreferences, LocalBroadcastManager, Canvas drawing APIs

**Spec:** `docs/superpowers/specs/2026-03-15-ui-redesign-design.md`

---

## Chunk 1: Bug Fixes

### Task 1: Fix invisible button text in DeviceFragment

**Files:**
- Modify: `app/src/main/res/layout/fragment_device.xml`

- [ ] **Step 1: Read the current button XML**

  Read `fragment_device.xml` lines 285–325. Confirm the two buttons `btnCopyLog` and `btnSaveLog` have `android:layout_height="38dp"` and `style="@style/ButtonPrimary"`.

- [ ] **Step 2: Add `android:minHeight="0dp"` to both buttons**

  In `fragment_device.xml`, add `android:minHeight="0dp"` to `btnCopyLog` and `btnSaveLog`. This removes the Material Components default 48dp minimum height enforcement that clips the text at 38dp height.

  ```xml
  <Button android:id="@+id/btnCopyLog"
      android:layout_width="0dp"
      android:layout_height="38dp"
      android:minHeight="0dp"
      android:layout_weight="1"
      android:text="Copiar"
      android:textSize="12sp"
      android:layout_marginEnd="6dp"
      style="@style/ButtonPrimary"/>

  <Button android:id="@+id/btnSaveLog"
      android:layout_width="0dp"
      android:layout_height="38dp"
      android:minHeight="0dp"
      android:layout_weight="1"
      android:text="Guardar"
      android:textSize="12sp"
      style="@style/ButtonPrimary"/>
  ```

- [ ] **Step 3: Commit**

  ```bash
  git add app/src/main/res/layout/fragment_device.xml
  git commit -m "fix(ui): make log buttons visible by removing Material minHeight override"
  ```

---

### Task 2: Fix blood oxygen showing 0 in StatusFragment

**Files:**
- Modify: `app/src/main/java/com/example/dialsender/fragments/StatusFragment.java`

- [ ] **Step 1: Read the value display code**

  Read `StatusFragment.java` around line 190 where `String.valueOf(latestToday)` is used. Understand the loop structure.

- [ ] **Step 2: Add zero-guard for blood_oxygen**

  In `StatusFragment.renderMetrics()`, find where `valueText.setText(String.valueOf(latestToday))` is called. Replace with:

  ```java
  String displayVal;
  if (latestToday == 0 && metric.equals("blood_oxygen")) {
      displayVal = "—";
  } else {
      displayVal = String.valueOf(latestToday);
  }
  valueText.setText(displayVal);
  ```

- [ ] **Step 3: Commit**

  ```bash
  git add app/src/main/java/com/example/dialsender/fragments/StatusFragment.java
  git commit -m "fix(health): show dash instead of 0 for blood oxygen when no data"
  ```

---

### Task 3: Fix missing notification apps in NotificationSettingsActivity

**Files:**
- Modify: `app/src/main/java/com/example/dialsender/NotificationSettingsActivity.java`

- [ ] **Step 1: Read the current app-loading code**

  Read `NotificationSettingsActivity.java` lines 58–74. Note the nested loop pattern.

- [ ] **Step 2: Replace nested loop with direct ResolveInfo extraction**

  Replace the entire block from `List<ApplicationInfo> allApps` through `launcherApps.add(ai)`:

  ```java
  // Before (nested loop — can miss apps):
  // List<ApplicationInfo> allApps = pm.getInstalledApplications(PackageManager.GET_META_DATA);
  // List<ApplicationInfo> launcherApps = new ArrayList<>();
  // Intent launcherIntent = new Intent(Intent.ACTION_MAIN, null);
  // launcherIntent.addCategory(Intent.CATEGORY_LAUNCHER);
  // for (ResolveInfo ri : pm.queryIntentActivities(launcherIntent, 0)) {
  //     for (ApplicationInfo ai : allApps) {
  //         if (ai.packageName.equals(ri.activityInfo.packageName)) {
  //             launcherApps.add(ai);
  //             break;
  //         }
  //     }
  // }
  ```

  Replace with:

  ```java
  List<ApplicationInfo> launcherApps = new ArrayList<>();
  Intent launcherIntent = new Intent(Intent.ACTION_MAIN, null);
  launcherIntent.addCategory(Intent.CATEGORY_LAUNCHER);
  for (ResolveInfo ri : pm.queryIntentActivities(launcherIntent, 0)) {
      launcherApps.add(ri.activityInfo.applicationInfo);
  }
  ```

  Remove the import `android.content.pm.ApplicationInfo` if it becomes unused (it won't be — it is still used in the type declaration of `launcherApps`).

- [ ] **Step 3: Commit**

  ```bash
  git add app/src/main/java/com/example/dialsender/NotificationSettingsActivity.java
  git commit -m "fix(notifications): use ResolveInfo directly to include all launcher apps"
  ```

---

## Chunk 2: Log Toggle

### Task 4: Add BLE log show/hide toggle in DeviceFragment

**Files:**
- Modify: `app/src/main/res/layout/fragment_device.xml`
- Modify: `app/src/main/java/com/example/dialsender/fragments/DeviceFragment.java`

- [ ] **Step 1: Read the log section of fragment_device.xml**

  Read `fragment_device.xml` from line 260 to end. Identify the `ScrollView` or container that holds the log text and the buttons row.

- [ ] **Step 2: Add toggle button above the log container**

  In `fragment_device.xml`, immediately above the log container (`ScrollView` with the `TextView` for log), add:

  ```xml
  <Button
      android:id="@+id/btnToggleLog"
      android:layout_width="wrap_content"
      android:layout_height="wrap_content"
      android:text="Ocultar log"
      android:textSize="11sp"
      android:minHeight="0dp"
      android:layout_gravity="end"
      android:layout_marginBottom="4dp"
      style="@style/Widget.MaterialComponents.Button.OutlinedButton"/>
  ```

- [ ] **Step 3: Wire up the toggle in DeviceFragment.java**

  In `DeviceFragment.java` `onCreateView()`, after existing view bindings:

  ```java
  Button btnToggleLog = view.findViewById(R.id.btnToggleLog);
  View logContainer = view.findViewById(R.id.logScrollView); // use actual ID
  View logButtonsRow = view.findViewById(R.id.logButtonsRow); // use actual ID of the copy/save row

  btnToggleLog.setOnClickListener(v -> {
      boolean isVisible = logContainer.getVisibility() == View.VISIBLE;
      logContainer.setVisibility(isVisible ? View.GONE : View.VISIBLE);
      logButtonsRow.setVisibility(isVisible ? View.GONE : View.VISIBLE);
      btnToggleLog.setText(isVisible ? "Mostrar log" : "Ocultar log");
  });
  ```

  Note: verify the actual view IDs for `logScrollView` and `logButtonsRow` by reading `fragment_device.xml` before writing this code.

- [ ] **Step 4: Commit**

  ```bash
  git add app/src/main/res/layout/fragment_device.xml \
          app/src/main/java/com/example/dialsender/fragments/DeviceFragment.java
  git commit -m "feat(device): add toggle button to show/hide BLE log"
  ```

---

## Chunk 3: GaugeView Custom View

### Task 5: Create GaugeView

**Files:**
- Create: `app/src/main/java/com/example/dialsender/views/GaugeView.java`
- Create: `app/src/main/res/values/attrs_gauge.xml`

- [ ] **Step 1: Create attrs_gauge.xml**

  ```xml
  <?xml version="1.0" encoding="utf-8"?>
  <resources>
      <declare-styleable name="GaugeView">
          <attr name="gv_value" format="float"/>
          <attr name="gv_label" format="string"/>
          <attr name="gv_valueText" format="string"/>
          <attr name="gv_subText" format="string"/>
          <attr name="gv_color" format="color"/>
      </declare-styleable>
  </resources>
  ```

- [ ] **Step 2: Create GaugeView.java**

  ```java
  package com.example.dialsender.views;

  import android.content.Context;
  import android.content.res.TypedArray;
  import android.graphics.Canvas;
  import android.graphics.Color;
  import android.graphics.Paint;
  import android.graphics.RectF;
  import android.util.AttributeSet;
  import android.view.View;

  import com.example.dialsender.R;

  public class GaugeView extends View {

      // Style constants
      public static final String STYLE_A = "A"; // semi-circle, 180°
      public static final String STYLE_B = "B"; // donut, 270°
      public static final String STYLE_C = "C"; // thin ring, 270°

      private Paint trackPaint;
      private Paint arcPaint;
      private Paint textPaint;
      private Paint labelPaint;
      private Paint subPaint;

      private float value = 0f; // 0.0–1.0
      private String label = "";
      private String valueText = "";
      private String subText = "";
      private int arcColor = Color.parseColor("#22D3EE");
      private String gaugeStyle = STYLE_A;

      private RectF oval = new RectF();
      private static final int TRACK_COLOR = Color.parseColor("#1a2332");
      private static final float STROKE_WIDTH_NORMAL = 18f;
      private static final float STROKE_WIDTH_THIN = 8f;

      public GaugeView(Context context) {
          super(context);
          init(context, null);
      }

      public GaugeView(Context context, AttributeSet attrs) {
          super(context, attrs);
          init(context, attrs);
      }

      public GaugeView(Context context, AttributeSet attrs, int defStyle) {
          super(context, attrs, defStyle);
          init(context, attrs);
      }

      private void init(Context context, AttributeSet attrs) {
          if (attrs != null) {
              TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.GaugeView);
              value = a.getFloat(R.styleable.GaugeView_gv_value, 0f);
              label = a.getString(R.styleable.GaugeView_gv_label);
              valueText = a.getString(R.styleable.GaugeView_gv_valueText);
              subText = a.getString(R.styleable.GaugeView_gv_subText);
              arcColor = a.getColor(R.styleable.GaugeView_gv_color, arcColor);
              a.recycle();
          }

          trackPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
          trackPaint.setStyle(Paint.Style.STROKE);
          trackPaint.setColor(TRACK_COLOR);
          trackPaint.setStrokeCap(Paint.Cap.ROUND);

          arcPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
          arcPaint.setStyle(Paint.Style.STROKE);
          arcPaint.setColor(arcColor);
          arcPaint.setStrokeCap(Paint.Cap.ROUND);

          textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
          textPaint.setColor(Color.parseColor("#F0F6FC"));
          textPaint.setTextAlign(Paint.Align.CENTER);
          textPaint.setFakeBoldText(true);

          labelPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
          labelPaint.setColor(arcColor);
          labelPaint.setTextAlign(Paint.Align.CENTER);

          subPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
          subPaint.setColor(Color.parseColor("#484F58"));
          subPaint.setTextAlign(Paint.Align.CENTER);
      }

      public void setValue(float value) {
          this.value = Math.max(0f, Math.min(1f, value));
          invalidate();
      }

      public void setValueText(String text) {
          this.valueText = text != null ? text : "";
          invalidate();
      }

      public void setLabel(String text) {
          this.label = text != null ? text : "";
          invalidate();
      }

      public void setSubText(String text) {
          this.subText = text != null ? text : "";
          invalidate();
      }

      public void setArcColor(int color) {
          this.arcColor = color;
          arcPaint.setColor(color);
          labelPaint.setColor(color);
          invalidate();
      }

      public void setGaugeStyle(String style) {
          this.gaugeStyle = style != null ? style : STYLE_A;
          invalidate();
      }

      @Override
      protected void onDraw(Canvas canvas) {
          super.onDraw(canvas);
          int w = getWidth();
          int h = getHeight();

          float stroke = STYLE_C.equals(gaugeStyle) ? STROKE_WIDTH_THIN : STROKE_WIDTH_NORMAL;
          trackPaint.setStrokeWidth(stroke);
          arcPaint.setStrokeWidth(stroke);

          float margin = stroke / 2f + 2f;
          float textAreaHeight = h * 0.35f; // reserve bottom area for text

          boolean isSemi = STYLE_A.equals(gaugeStyle);
          float startAngle = isSemi ? 180f : 135f;
          float sweepTotal = isSemi ? 180f : 270f;

          float arcDiameter = Math.min(w - 2 * margin, isSemi ? (h - textAreaHeight) * 2 : h - 2 * margin);
          float left = (w - arcDiameter) / 2f;
          float top = isSemi ? (h - textAreaHeight - arcDiameter / 2f) : (h - arcDiameter) / 2f;

          oval.set(left + margin, top + margin, left + arcDiameter - margin, top + arcDiameter - margin);

          // Track
          canvas.drawArc(oval, startAngle, sweepTotal, false, trackPaint);

          // Filled arc
          float sweep = sweepTotal * Math.max(0f, Math.min(1f, value));
          if (sweep > 0) {
              canvas.drawArc(oval, startAngle, sweep, false, arcPaint);
          }

          // Text sizing
          float textY;
          float valueSp, labelSp, subSp;
          if (isSemi) {
              textY = top + arcDiameter / 2f + stroke;
              valueSp = w * 0.22f;
              labelSp = w * 0.10f;
              subSp = w * 0.08f;
          } else {
              textY = oval.centerY() - (w * 0.06f);
              valueSp = w * 0.20f;
              labelSp = w * 0.09f;
              subSp = w * 0.07f;
          }

          // Value text
          textPaint.setTextSize(valueSp);
          String displayVal = valueText != null ? valueText : "";
          canvas.drawText(displayVal, w / 2f, textY + valueSp * 0.8f, textPaint);

          // Label
          labelPaint.setTextSize(labelSp);
          canvas.drawText(label != null ? label : "", w / 2f, textY + valueSp * 0.8f + labelSp * 1.2f, labelPaint);

          // Sub text
          subPaint.setTextSize(subSp);
          canvas.drawText(subText != null ? subText : "", w / 2f, textY + valueSp * 0.8f + labelSp * 1.2f + subSp * 1.3f, subPaint);
      }
  }
  ```

- [ ] **Step 3: Commit**

  ```bash
  git add app/src/main/java/com/example/dialsender/views/GaugeView.java \
          app/src/main/res/values/attrs_gauge.xml
  git commit -m "feat(ui): add GaugeView custom View with semi-circle, donut, and ring styles"
  ```

---

## Chunk 4: Home Screen Redesign

### Task 6: Rewrite fragment_home.xml with gauge grid

**Files:**
- Modify: `app/src/main/res/layout/fragment_home.xml`

- [ ] **Step 1: Replace the 2×2 card grid and send-dial card with gauge cards**

  Keep the header (greeting, date, connection chip). Replace everything from `<!-- Metric cards grid (2x2) -->` to the end of `</ScrollView>` with:

  ```xml
  <!-- 2x2 Gauge grid: Steps, Heart Rate, Calories, SpO2 -->
  <LinearLayout
      android:layout_width="match_parent"
      android:layout_height="wrap_content"
      android:orientation="horizontal"
      android:layout_marginBottom="10dp">

      <LinearLayout
          android:id="@+id/gaugeCardSteps"
          android:layout_width="0dp"
          android:layout_height="130dp"
          android:layout_weight="1"
          android:background="@drawable/bg_card"
          android:orientation="vertical"
          android:gravity="center"
          android:padding="8dp"
          android:layout_marginEnd="6dp"
          android:clickable="true"
          android:focusable="true">
          <com.example.dialsender.views.GaugeView
              android:id="@+id/gaugeSteps"
              android:layout_width="match_parent"
              android:layout_height="match_parent"
              app:gv_label="PASOS"
              app:gv_valueText="—"
              app:gv_subText="meta 10K"
              app:gv_color="#34D399"
              app:gv_value="0"/>
      </LinearLayout>

      <LinearLayout
          android:id="@+id/gaugeCardHeart"
          android:layout_width="0dp"
          android:layout_height="130dp"
          android:layout_weight="1"
          android:background="@drawable/bg_card"
          android:orientation="vertical"
          android:gravity="center"
          android:padding="8dp"
          android:layout_marginStart="6dp"
          android:clickable="true"
          android:focusable="true">
          <com.example.dialsender.views.GaugeView
              android:id="@+id/gaugeHeart"
              android:layout_width="match_parent"
              android:layout_height="match_parent"
              app:gv_label="BPM"
              app:gv_valueText="—"
              app:gv_subText="Normal"
              app:gv_color="#F87171"
              app:gv_value="0"/>
      </LinearLayout>
  </LinearLayout>

  <LinearLayout
      android:layout_width="match_parent"
      android:layout_height="wrap_content"
      android:orientation="horizontal"
      android:layout_marginBottom="10dp">

      <LinearLayout
          android:id="@+id/gaugeCardCalories"
          android:layout_width="0dp"
          android:layout_height="130dp"
          android:layout_weight="1"
          android:background="@drawable/bg_card"
          android:orientation="vertical"
          android:gravity="center"
          android:padding="8dp"
          android:layout_marginEnd="6dp"
          android:clickable="true"
          android:focusable="true">
          <com.example.dialsender.views.GaugeView
              android:id="@+id/gaugeCalories"
              android:layout_width="match_parent"
              android:layout_height="match_parent"
              app:gv_label="KCAL"
              app:gv_valueText="—"
              app:gv_subText="meta 500"
              app:gv_color="#FBBF24"
              app:gv_value="0"/>
      </LinearLayout>

      <LinearLayout
          android:id="@+id/gaugeCardSpo2"
          android:layout_width="0dp"
          android:layout_height="130dp"
          android:layout_weight="1"
          android:background="@drawable/bg_card"
          android:orientation="vertical"
          android:gravity="center"
          android:padding="8dp"
          android:layout_marginStart="6dp"
          android:clickable="true"
          android:focusable="true">
          <com.example.dialsender.views.GaugeView
              android:id="@+id/gaugeSpo2"
              android:layout_width="match_parent"
              android:layout_height="match_parent"
              app:gv_label="SPO2"
              app:gv_valueText="—"
              app:gv_subText="Normal"
              app:gv_color="#22D3EE"
              app:gv_value="0"/>
      </LinearLayout>
  </LinearLayout>

  <!-- Sleep gauge — full width -->
  <LinearLayout
      android:id="@+id/gaugeCardSleep"
      android:layout_width="match_parent"
      android:layout_height="130dp"
      android:background="@drawable/bg_card"
      android:orientation="horizontal"
      android:gravity="center_vertical"
      android:padding="12dp"
      android:layout_marginBottom="16dp"
      android:clickable="true"
      android:focusable="true">

      <com.example.dialsender.views.GaugeView
          android:id="@+id/gaugeSleep"
          android:layout_width="110dp"
          android:layout_height="match_parent"
          app:gv_label="SUEÑO"
          app:gv_valueText="—"
          app:gv_subText="meta 8h"
          app:gv_color="#BC8CFF"
          app:gv_value="0"/>

      <LinearLayout
          android:layout_width="0dp"
          android:layout_height="wrap_content"
          android:layout_weight="1"
          android:orientation="vertical"
          android:layout_marginStart="8dp">

          <TextView
              android:id="@+id/txtSleepPhases"
              android:layout_width="wrap_content"
              android:layout_height="wrap_content"
              android:text="Sin datos"
              android:textColor="@color/text_secondary"
              android:textSize="11sp"/>
      </LinearLayout>
  </LinearLayout>
  ```

  Add `xmlns:app="http://schemas.android.com/apk/res-auto"` to the root `ScrollView`.

- [ ] **Step 2: Commit**

  ```bash
  git add app/src/main/res/layout/fragment_home.xml
  git commit -m "feat(home): replace metric cards with gauge grid layout"
  ```

---

### Task 7: Rewrite HomeFragment.java to use gauges

**Files:**
- Modify: `app/src/main/java/com/example/dialsender/fragments/HomeFragment.java`

- [ ] **Step 1: Remove old view bindings and add gauge references**

  Remove `ProgressBar`, `txtStepsGoal`, `txtCaloriesSub`, `txtSleepSub`, `txtHeartRateSub`, `txtLastDial`. Add:

  ```java
  private GaugeView gaugeSteps, gaugeHeart, gaugeCalories, gaugeSpo2, gaugeSleep;
  private TextView txtSleepPhases;
  private BroadcastReceiver gaugeStyleReceiver;
  ```

- [ ] **Step 2: Bind views in onCreateView()**

  ```java
  gaugeSteps = view.findViewById(R.id.gaugeSteps);
  gaugeHeart = view.findViewById(R.id.gaugeHeart);
  gaugeCalories = view.findViewById(R.id.gaugeCalories);
  gaugeSpo2 = view.findViewById(R.id.gaugeSpo2);
  gaugeSleep = view.findViewById(R.id.gaugeSleep);
  txtSleepPhases = view.findViewById(R.id.txtSleepPhases);

  // Click listeners — open bottom sheet
  view.findViewById(R.id.gaugeCardSteps).setOnClickListener(v ->
      MetricDetailBottomSheet.newInstance("steps").show(getChildFragmentManager(), "detail"));
  view.findViewById(R.id.gaugeCardHeart).setOnClickListener(v ->
      MetricDetailBottomSheet.newInstance("heart_rate").show(getChildFragmentManager(), "detail"));
  view.findViewById(R.id.gaugeCardCalories).setOnClickListener(v ->
      MetricDetailBottomSheet.newInstance("calories").show(getChildFragmentManager(), "detail"));
  view.findViewById(R.id.gaugeCardSpo2).setOnClickListener(v ->
      MetricDetailBottomSheet.newInstance("blood_oxygen").show(getChildFragmentManager(), "detail"));
  view.findViewById(R.id.gaugeCardSleep).setOnClickListener(v ->
      MetricDetailBottomSheet.newInstance("sleep").show(getChildFragmentManager(), "detail"));
  ```

- [ ] **Step 3: Register gauge style broadcast receiver in onResume / unregister in onPause**

  ```java
  @Override
  public void onResume() {
      super.onResume();
      bleManager.setListener(this);
      applyGaugeStyle();
      refreshMetrics();
      updateConnectionState(bleManager.isSessionReady());
      gaugeStyleReceiver = new BroadcastReceiver() {
          @Override public void onReceive(Context context, Intent intent) { applyGaugeStyle(); }
      };
      LocalBroadcastManager.getInstance(requireContext()).registerReceiver(
          gaugeStyleReceiver, new IntentFilter(SettingsFragment.ACTION_GAUGE_STYLE_CHANGED));
  }

  @Override
  public void onPause() {
      super.onPause();
      if (gaugeStyleReceiver != null) {
          LocalBroadcastManager.getInstance(requireContext()).unregisterReceiver(gaugeStyleReceiver);
          gaugeStyleReceiver = null;
      }
  }

  private void applyGaugeStyle() {
      String style = prefs.getString("gauge_style", GaugeView.STYLE_A);
      GaugeView[] gauges = {gaugeSteps, gaugeHeart, gaugeCalories, gaugeSpo2, gaugeSleep};
      for (GaugeView g : gauges) { if (g != null) g.setGaugeStyle(style); }
  }
  ```

- [ ] **Step 4: Rewrite refreshMetrics() to update gauges**

  ```java
  private void refreshMetrics() {
      if (!isAdded() || prefs == null) return;

      int goalSteps = prefs.getInt("goal_steps", 10000);
      int goalCal   = prefs.getInt("goal_calories", 500);
      int goalSleep = prefs.getInt("goal_sleep_min", 480);

      // Steps
      int steps = getLatestMetricValue("steps");
      gaugeSteps.setValue(steps > 0 ? (float) steps / goalSteps : 0f);
      gaugeSteps.setValueText(steps > 0 ? formatSteps(steps) : "—");
      gaugeSteps.setSubText("meta " + formatSteps(goalSteps));

      // Heart rate
      int hr = getLatestMetricValue("heart_rate");
      gaugeHeart.setValue(hr > 0 ? (float) hr / 200f : 0f);
      gaugeHeart.setValueText(hr > 0 ? String.valueOf(hr) : "—");
      gaugeHeart.setSubText(hr > 0 ? "Normal" : "Sin datos");

      // Calories
      int cal = getLatestMetricValue("calories");
      gaugeCalories.setValue(cal > 0 ? (float) cal / goalCal : 0f);
      gaugeCalories.setValueText(cal > 0 ? String.valueOf(cal) : "—");
      gaugeCalories.setSubText("meta " + goalCal);

      // SpO2
      int spo2 = getLatestMetricValue("blood_oxygen");
      gaugeSpo2.setValue(spo2 > 0 ? (float) spo2 / 100f : 0f);
      gaugeSpo2.setValueText(spo2 > 0 ? spo2 + "%" : "—");
      gaugeSpo2.setSubText(spo2 > 0 ? "Normal" : "Sin datos");

      // Sleep
      String sleepData = prefs.getString(PREF_HEALTH_PREFIX + "sleep", "");
      SleepAnalyzer.SleepResult sr = SleepAnalyzer.analyze(sleepData);
      int sleepMin = sr.totalMinutes;
      gaugeSleep.setValue(sleepMin > 0 ? (float) sleepMin / goalSleep : 0f);
      if (sleepMin > 0) {
          int h = sleepMin / 60, m = sleepMin % 60;
          gaugeSleep.setValueText(h > 0 ? h + "h" + m + "m" : m + "m");
          StringBuilder phases = new StringBuilder();
          if (sr.deepMin > 0) phases.append("Prof: ").append(formatMins(sr.deepMin)).append("  ");
          if (sr.lightMin > 0) phases.append("Lig: ").append(formatMins(sr.lightMin)).append("  ");
          if (sr.remMin > 0)   phases.append("REM: ").append(formatMins(sr.remMin));
          txtSleepPhases.setText(phases.toString().trim().isEmpty() ? "Sin desglose" : phases.toString().trim());
      } else {
          gaugeSleep.setValueText("—");
          txtSleepPhases.setText("Sin datos");
      }
  }

  private String formatSteps(int steps) {
      return steps >= 1000 ? (steps / 1000) + "." + ((steps % 1000) / 100) + "K" : String.valueOf(steps);
  }

  private String formatMins(int mins) {
      int h = mins / 60, m = mins % 60;
      return h > 0 ? h + "h" + m + "m" : m + "m";
  }
  ```

- [ ] **Step 5: Remove cardSendDialHome click listener and old view references**

  Delete the `view.findViewById(R.id.cardSendDialHome)` click listener and all old `txt*` field bindings and `progressSteps`. Remove unused imports.

- [ ] **Step 6: Commit**

  ```bash
  git add app/src/main/java/com/example/dialsender/fragments/HomeFragment.java
  git commit -m "feat(home): rewrite HomeFragment to use GaugeView and open MetricDetailBottomSheet"
  ```

---

## Chunk 5: MetricDetailBottomSheet + SleepTimelineView

### Task 8: Create SleepTimelineView

**Files:**
- Create: `app/src/main/java/com/example/dialsender/views/SleepTimelineView.java`

- [ ] **Step 1: Create SleepTimelineView.java**

  ```java
  package com.example.dialsender.views;

  import android.content.Context;
  import android.graphics.Canvas;
  import android.graphics.Color;
  import android.graphics.Paint;
  import android.graphics.Rect;
  import android.util.AttributeSet;
  import android.view.View;

  import com.example.dialsender.ble.BleSleep;

  import java.text.SimpleDateFormat;
  import java.util.ArrayList;
  import java.util.Date;
  import java.util.List;
  import java.util.Locale;

  public class SleepTimelineView extends View {

      private static final int COLOR_DEEP     = Color.parseColor("#34D399");
      private static final int COLOR_LIGHT    = Color.parseColor("#22D3EE");
      private static final int COLOR_REM      = Color.parseColor("#BC8CFF");
      private static final int COLOR_AWAKE    = Color.parseColor("#F87171");
      private static final int COLOR_UNKNOWN  = Color.parseColor("#1a2332");

      private static class Segment {
          long startTs, endTs;
          int mode;
          Segment(long s, long e, int m) { startTs = s; endTs = e; mode = m; }
      }

      private List<Segment> segments = new ArrayList<>();
      private long sessionStart, sessionEnd;
      private Paint segPaint = new Paint();
      private Paint labelPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

      public SleepTimelineView(Context context) { super(context); }
      public SleepTimelineView(Context context, AttributeSet a) { super(context, a); }

      public void setSleepData(String rawPrefsString) {
          segments.clear();
          sessionStart = 0;
          sessionEnd = 0;
          if (rawPrefsString == null || rawPrefsString.isEmpty()) { invalidate(); return; }

          String[] records = rawPrefsString.split(",");

          // Find last complete session (MODE_END, scan back for MODE_START)
          int endIdx = -1;
          for (int i = records.length - 1; i >= 0; i--) {
              if (parseMode(records[i]) == BleSleep.MODE_END) { endIdx = i; break; }
          }
          if (endIdx < 0) { invalidate(); return; }

          int startIdx = -1;
          for (int i = endIdx - 1; i >= 0; i--) {
              if (parseMode(records[i]) == BleSleep.MODE_START) { startIdx = i; break; }
          }
          if (startIdx < 0) { invalidate(); return; }

          sessionStart = parseTs(records[startIdx]);
          sessionEnd   = parseTs(records[endIdx]);

          int prevMode = BleSleep.MODE_AWAKE;
          long prevTs  = sessionStart;

          for (int i = startIdx + 1; i <= endIdx; i++) {
              long ts   = parseTs(records[i]);
              int  mode = parseMode(records[i]);
              if (ts <= 0 || ts < prevTs) continue;
              // Skip marker records for segment drawing
              if (prevMode != BleSleep.MODE_START && prevMode != BleSleep.MODE_END) {
                  segments.add(new Segment(prevTs, ts, prevMode));
              }
              prevMode = mode;
              prevTs   = ts;
          }
          invalidate();
      }

      @Override
      protected void onDraw(Canvas canvas) {
          super.onDraw(canvas);
          if (segments.isEmpty() || sessionEnd <= sessionStart) {
              labelPaint.setColor(Color.parseColor("#8B949E"));
              labelPaint.setTextSize(32f);
              labelPaint.setTextAlign(Paint.Align.CENTER);
              canvas.drawText("Sin datos de sueño", getWidth() / 2f, getHeight() / 2f, labelPaint);
              return;
          }

          float w = getWidth(), h = getHeight();
          float barH = h * 0.55f;
          float barTop = h * 0.05f;
          float duration = sessionEnd - sessionStart;

          for (Segment seg : segments) {
              float x1 = (seg.startTs - sessionStart) / duration * w;
              float x2 = (seg.endTs   - sessionStart) / duration * w;
              segPaint.setColor(colorForMode(seg.mode));
              canvas.drawRect(x1, barTop, x2, barTop + barH, segPaint);
          }

          // Time labels
          labelPaint.setColor(Color.parseColor("#484F58"));
          labelPaint.setTextAlign(Paint.Align.CENTER);
          labelPaint.setTextSize(h * 0.15f);
          SimpleDateFormat sdf = new SimpleDateFormat("HH:mm", Locale.getDefault());
          int labelCount = 5;
          for (int i = 0; i <= labelCount; i++) {
              long ts = sessionStart + (long)(duration * i / labelCount);
              float x = w * i / labelCount;
              canvas.drawText(sdf.format(new Date(ts * 1000)), x, barTop + barH + h * 0.25f, labelPaint);
          }

          // Phase legend
          int[] modes = {BleSleep.MODE_DEEP, BleSleep.MODE_LIGHT, BleSleep.MODE_REM, BleSleep.MODE_AWAKE};
          String[] names = {"Profundo", "Ligero", "REM", "Despierto"};
          float legendY = h * 0.92f;
          float cellW = w / modes.length;
          Paint dotPaint = new Paint();
          labelPaint.setTextSize(h * 0.13f);
          for (int i = 0; i < modes.length; i++) {
              float cx = cellW * i + cellW * 0.12f;
              dotPaint.setColor(colorForMode(modes[i]));
              canvas.drawRect(cx, legendY - h * 0.10f, cx + h * 0.10f, legendY, dotPaint);
              labelPaint.setTextAlign(Paint.Align.LEFT);
              canvas.drawText(names[i], cx + h * 0.13f, legendY, labelPaint);
          }
      }

      private int colorForMode(int mode) {
          switch (mode) {
              case BleSleep.MODE_DEEP:      return COLOR_DEEP;
              case BleSleep.MODE_LIGHT:
              case BleSleep.MODE_PIECEMEAL: return COLOR_LIGHT;
              case BleSleep.MODE_REM:       return COLOR_REM;
              case BleSleep.MODE_AWAKE:     return COLOR_AWAKE;
              default:                      return COLOR_UNKNOWN;
          }
      }

      private long parseTs(String record) {
          try { return Long.parseLong(record.split(":")[0]); } catch (Exception e) { return 0; }
      }

      private int parseMode(String record) {
          try { return Integer.parseInt(record.split(":")[1]); } catch (Exception e) { return 0; }
      }
  }
  ```

- [ ] **Step 2: Commit**

  ```bash
  git add app/src/main/java/com/example/dialsender/views/SleepTimelineView.java
  git commit -m "feat(health): add SleepTimelineView for sleep phase timeline display"
  ```

---

### Task 9: Create MetricDetailBottomSheet

**Files:**
- Create: `app/src/main/java/com/example/dialsender/fragments/MetricDetailBottomSheet.java`
- Create: `app/src/main/res/layout/bottom_sheet_metric_detail.xml`

- [ ] **Step 1: Create bottom_sheet_metric_detail.xml**

  ```xml
  <?xml version="1.0" encoding="utf-8"?>
  <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
      xmlns:app="http://schemas.android.com/apk/res-auto"
      android:layout_width="match_parent"
      android:layout_height="wrap_content"
      android:orientation="vertical"
      android:background="@color/bg_primary"
      android:padding="20dp">

      <!-- Header row: title + current value -->
      <LinearLayout
          android:layout_width="match_parent"
          android:layout_height="wrap_content"
          android:orientation="horizontal"
          android:gravity="center_vertical"
          android:layout_marginBottom="12dp">

          <TextView
              android:id="@+id/txtDetailTitle"
              android:layout_width="0dp"
              android:layout_height="wrap_content"
              android:layout_weight="1"
              android:textColor="@color/text_primary"
              android:textSize="18sp"
              android:textStyle="bold"/>

          <TextView
              android:id="@+id/txtDetailValue"
              android:layout_width="wrap_content"
              android:layout_height="wrap_content"
              android:textColor="@color/accent_primary"
              android:textSize="20sp"
              android:textStyle="bold"/>
      </LinearLayout>

      <!-- Time range toggle -->
      <com.google.android.material.button.MaterialButtonToggleGroup
          android:id="@+id/toggleDetailRange"
          android:layout_width="wrap_content"
          android:layout_height="wrap_content"
          android:layout_marginBottom="16dp"
          app:singleSelection="true"
          app:selectionRequired="true">

          <Button android:id="@+id/btnDetailDay"
              style="@style/Widget.MaterialComponents.Button.OutlinedButton"
              android:layout_width="wrap_content" android:layout_height="36dp"
              android:minHeight="0dp" android:text="Día" android:textSize="12sp"/>

          <Button android:id="@+id/btnDetailWeek"
              style="@style/Widget.MaterialComponents.Button.OutlinedButton"
              android:layout_width="wrap_content" android:layout_height="36dp"
              android:minHeight="0dp" android:text="Semana" android:textSize="12sp"/>

          <Button android:id="@+id/btnDetailMonth"
              style="@style/Widget.MaterialComponents.Button.OutlinedButton"
              android:layout_width="wrap_content" android:layout_height="36dp"
              android:minHeight="0dp" android:text="Mes" android:textSize="12sp"/>
      </com.google.android.material.button.MaterialButtonToggleGroup>

      <!-- Chart container — either BarChart or SleepTimelineView -->
      <FrameLayout
          android:id="@+id/detailChartContainer"
          android:layout_width="match_parent"
          android:layout_height="220dp"
          android:layout_marginBottom="16dp"/>

      <!-- Sync button -->
      <Button
          android:id="@+id/btnSyncDetail"
          android:layout_width="wrap_content"
          android:layout_height="wrap_content"
          android:minHeight="0dp"
          android:text="Sincronizar datos"
          android:textSize="12sp"
          style="@style/Widget.MaterialComponents.Button.OutlinedButton"/>

  </LinearLayout>
  ```

- [ ] **Step 2: Create MetricDetailBottomSheet.java**

  Reuse `StatusFragment`'s chart-building logic (copy/adapt the `renderMetrics()` BarChart block for non-sleep metrics; use `SleepTimelineView` for sleep):

  ```java
  package com.example.dialsender.fragments;

  import android.content.Context;
  import android.content.SharedPreferences;
  import android.os.Bundle;
  import android.view.LayoutInflater;
  import android.view.View;
  import android.view.ViewGroup;
  import android.widget.Button;
  import android.widget.FrameLayout;
  import android.widget.TextView;
  import android.widget.Toast;

  import androidx.annotation.NonNull;
  import androidx.annotation.Nullable;
  import androidx.core.content.ContextCompat;

  import com.example.dialsender.R;
  import com.example.dialsender.ble.BleManager;
  import com.example.dialsender.ble.SleepAnalyzer;
  import com.example.dialsender.views.SleepTimelineView;
  import com.github.mikephil.charting.charts.BarChart;
  import com.github.mikephil.charting.components.XAxis;
  import com.github.mikephil.charting.data.BarData;
  import com.github.mikephil.charting.data.BarDataSet;
  import com.github.mikephil.charting.data.BarEntry;
  import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
  import com.google.android.material.button.MaterialButtonToggleGroup;

  import java.util.ArrayList;
  import java.util.List;
  import java.util.Locale;

  public class MetricDetailBottomSheet extends BottomSheetDialogFragment {

      private static final String ARG_METRIC = "metric_key";
      private static final String PREF_NAME = "dial_sender_prefs";
      private static final String PREF_HEALTH_PREFIX = "health_";

      private static final int RANGE_DAY = 0, RANGE_WEEK = 1, RANGE_MONTH = 2;
      private int currentRange = RANGE_DAY;

      private String metricKey;
      private SharedPreferences prefs;
      private FrameLayout chartContainer;
      private TextView txtTitle, txtValue;

      public static MetricDetailBottomSheet newInstance(String metricKey) {
          MetricDetailBottomSheet sheet = new MetricDetailBottomSheet();
          Bundle args = new Bundle();
          args.putString(ARG_METRIC, metricKey);
          sheet.setArguments(args);
          return sheet;
      }

      @Nullable
      @Override
      public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                               @Nullable Bundle savedInstanceState) {
          View view = inflater.inflate(R.layout.bottom_sheet_metric_detail, container, false);

          metricKey = getArguments() != null ? getArguments().getString(ARG_METRIC, "steps") : "steps";
          prefs = requireContext().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);

          txtTitle = view.findViewById(R.id.txtDetailTitle);
          txtValue = view.findViewById(R.id.txtDetailValue);
          chartContainer = view.findViewById(R.id.detailChartContainer);

          txtTitle.setText(metricKey.replace("_", " ").toUpperCase(Locale.US));

          MaterialButtonToggleGroup toggle = view.findViewById(R.id.toggleDetailRange);
          toggle.check(R.id.btnDetailDay);
          toggle.addOnButtonCheckedListener((group, checkedId, isChecked) -> {
              if (isChecked) {
                  if (checkedId == R.id.btnDetailDay)   currentRange = RANGE_DAY;
                  else if (checkedId == R.id.btnDetailWeek) currentRange = RANGE_WEEK;
                  else currentRange = RANGE_MONTH;
                  renderChart();
              }
          });

          Button btnSync = view.findViewById(R.id.btnSyncDetail);
          btnSync.setOnClickListener(v -> {
              BleManager ble = BleManager.getInstance(requireContext());
              if (ble.isSessionReady()) {
                  ble.syncHealth();
                  Toast.makeText(requireContext(), "Sincronizando...", Toast.LENGTH_SHORT).show();
              } else {
                  Toast.makeText(requireContext(), "No conectado", Toast.LENGTH_SHORT).show();
              }
          });

          renderChart();
          return view;
      }

      private void renderChart() {
          chartContainer.removeAllViews();
          String history = prefs.getString(PREF_HEALTH_PREFIX + metricKey, "");

          if ("sleep".equals(metricKey)) {
              SleepTimelineView stv = new SleepTimelineView(requireContext());
              stv.setSleepData(history);
              chartContainer.addView(stv, new FrameLayout.LayoutParams(
                      FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));
              // Update current value
              SleepAnalyzer.SleepResult sr = SleepAnalyzer.analyze(history);
              if (sr.totalMinutes > 0) {
                  int h = sr.totalMinutes / 60, m = sr.totalMinutes % 60;
                  txtValue.setText(h + "h " + m + "m");
              } else {
                  txtValue.setText("—");
              }
          } else {
              long now = System.currentTimeMillis() / 1000;
              long todayStart = getTodayStart();
              long rangeStart;
              int numBuckets, bucketSize;
              if (currentRange == RANGE_DAY) { rangeStart = todayStart; numBuckets = 24; bucketSize = 3600; }
              else if (currentRange == RANGE_WEEK) { rangeStart = todayStart - 6 * 86400; numBuckets = 7; bucketSize = 86400; }
              else { rangeStart = todayStart - 29 * 86400; numBuckets = 30; bucketSize = 86400; }

              float[] buckets = new float[numBuckets];
              int latestVal = 0;
              if (!history.isEmpty()) {
                  for (String entry : history.split(",")) {
                      long ts = 0; int val = 0;
                      if (entry.contains(":")) {
                          try { ts = Long.parseLong(entry.split(":")[0]); val = Integer.parseInt(entry.split(":")[1]); } catch (Exception ignored) {}
                      } else {
                          try { val = Integer.parseInt(entry.trim()); ts = todayStart + 3600; } catch (Exception ignored) {}
                      }
                      if (ts >= rangeStart && ts <= now + 86400) {
                          int idx = (int)((ts - rangeStart) / bucketSize);
                          if (idx >= 0 && idx < numBuckets && val > buckets[idx]) buckets[idx] = val;
                      }
                      if (ts >= todayStart || !entry.contains(":")) latestVal = val;
                  }
              }

              String displayVal = (latestVal == 0 && metricKey.equals("blood_oxygen")) ? "—" : String.valueOf(latestVal);
              txtValue.setText(displayVal);

              List<BarEntry> entries = new ArrayList<>();
              for (int i = 0; i < numBuckets; i++) entries.add(new BarEntry(i, buckets[i]));
              BarDataSet ds = new BarDataSet(entries, "Data");
              ds.setColor(ContextCompat.getColor(requireContext(), R.color.accent_primary));
              ds.setDrawValues(false);
              BarData data = new BarData(ds);
              data.setBarWidth(0.7f);

              BarChart chart = new BarChart(requireContext());
              chart.setData(data);
              chart.getDescription().setEnabled(false);
              chart.getLegend().setEnabled(false);
              chart.getXAxis().setDrawGridLines(false);
              chart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
              chart.getXAxis().setTextColor(ContextCompat.getColor(requireContext(), R.color.text_secondary));
              chart.getAxisLeft().setTextColor(ContextCompat.getColor(requireContext(), R.color.text_secondary));
              chart.getAxisLeft().setAxisMinimum(0f);
              chart.getAxisRight().setEnabled(false);
              chart.setTouchEnabled(false);
              chart.animateY(600);
              chartContainer.addView(chart, new FrameLayout.LayoutParams(
                      FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));
          }
      }

      private long getTodayStart() {
          java.util.Calendar cal = java.util.Calendar.getInstance();
          cal.set(java.util.Calendar.HOUR_OF_DAY, 0);
          cal.set(java.util.Calendar.MINUTE, 0);
          cal.set(java.util.Calendar.SECOND, 0);
          cal.set(java.util.Calendar.MILLISECOND, 0);
          return cal.getTimeInMillis() / 1000;
      }
  }
  ```

- [ ] **Step 3: Commit**

  ```bash
  git add app/src/main/java/com/example/dialsender/fragments/MetricDetailBottomSheet.java \
          app/src/main/res/layout/bottom_sheet_metric_detail.xml
  git commit -m "feat(health): add MetricDetailBottomSheet with bar chart and sleep timeline"
  ```

---

## Chunk 6: Settings Tab

### Task 10: Create SettingsFragment and layout

**Files:**
- Create: `app/src/main/java/com/example/dialsender/fragments/SettingsFragment.java`
- Create: `app/src/main/res/layout/fragment_settings.xml`

- [ ] **Step 1: Create fragment_settings.xml**

  ```xml
  <?xml version="1.0" encoding="utf-8"?>
  <ScrollView xmlns:android="http://schemas.android.com/apk/res/android"
      android:layout_width="match_parent"
      android:layout_height="match_parent"
      android:background="@color/bg_primary">

      <LinearLayout
          android:layout_width="match_parent"
          android:layout_height="wrap_content"
          android:orientation="vertical"
          android:padding="20dp">

          <TextView
              android:layout_width="wrap_content"
              android:layout_height="wrap_content"
              android:text="Ajustes"
              android:textColor="@color/text_primary"
              android:textSize="22sp"
              android:textStyle="bold"
              android:layout_marginBottom="20dp"/>

          <!-- Section: Notificaciones -->
          <TextView android:layout_width="wrap_content" android:layout_height="wrap_content"
              android:text="NOTIFICACIONES" android:textColor="@color/accent_primary"
              android:textSize="11sp" android:textStyle="bold" android:layout_marginBottom="8dp"/>

          <LinearLayout
              android:id="@+id/rowNotifications"
              android:layout_width="match_parent"
              android:layout_height="52dp"
              android:background="@drawable/bg_card"
              android:orientation="horizontal"
              android:gravity="center_vertical"
              android:padding="16dp"
              android:layout_marginBottom="20dp"
              android:clickable="true"
              android:focusable="true">
              <TextView android:layout_width="0dp" android:layout_height="wrap_content"
                  android:layout_weight="1"
                  android:text="Apps con notificaciones"
                  android:textColor="@color/text_primary" android:textSize="14sp"/>
              <TextView android:layout_width="wrap_content" android:layout_height="wrap_content"
                  android:text="›" android:textColor="@color/accent_primary" android:textSize="22sp"/>
          </LinearLayout>

          <!-- Section: Estilo de Gauge -->
          <TextView android:layout_width="wrap_content" android:layout_height="wrap_content"
              android:text="ESTILO DE GAUGE" android:textColor="@color/accent_primary"
              android:textSize="11sp" android:textStyle="bold" android:layout_marginBottom="8dp"/>

          <LinearLayout android:layout_width="match_parent" android:layout_height="wrap_content"
              android:background="@drawable/bg_card" android:orientation="vertical"
              android:padding="16dp" android:layout_marginBottom="20dp">

              <RadioGroup android:id="@+id/radioGaugeStyle"
                  android:layout_width="match_parent" android:layout_height="wrap_content">
                  <RadioButton android:id="@+id/radioGaugeA" android:layout_width="wrap_content"
                      android:layout_height="wrap_content"
                      android:text="A — Semi-círculo (por defecto)"
                      android:textColor="@color/text_primary"/>
                  <RadioButton android:id="@+id/radioGaugeB" android:layout_width="wrap_content"
                      android:layout_height="wrap_content"
                      android:text="B — Donut (270°)"
                      android:textColor="@color/text_primary"/>
                  <RadioButton android:id="@+id/radioGaugeC" android:layout_width="wrap_content"
                      android:layout_height="wrap_content"
                      android:text="C — Anillo fino"
                      android:textColor="@color/text_primary"/>
              </RadioGroup>
          </LinearLayout>

          <!-- Section: Unidades -->
          <TextView android:layout_width="wrap_content" android:layout_height="wrap_content"
              android:text="UNIDADES" android:textColor="@color/accent_primary"
              android:textSize="11sp" android:textStyle="bold" android:layout_marginBottom="8dp"/>

          <LinearLayout android:layout_width="match_parent" android:layout_height="wrap_content"
              android:background="@drawable/bg_card" android:orientation="vertical"
              android:padding="16dp" android:layout_marginBottom="20dp">

              <!-- Distance -->
              <LinearLayout android:layout_width="match_parent" android:layout_height="wrap_content"
                  android:orientation="horizontal" android:gravity="center_vertical"
                  android:layout_marginBottom="12dp">
                  <TextView android:layout_width="0dp" android:layout_height="wrap_content"
                      android:layout_weight="1"
                      android:text="Distancia" android:textColor="@color/text_primary" android:textSize="14sp"/>
                  <Spinner android:id="@+id/spinnerDistance"
                      android:layout_width="120dp" android:layout_height="36dp"/>
              </LinearLayout>

              <!-- Weight -->
              <LinearLayout android:layout_width="match_parent" android:layout_height="wrap_content"
                  android:orientation="horizontal" android:gravity="center_vertical">
                  <TextView android:layout_width="0dp" android:layout_height="wrap_content"
                      android:layout_weight="1"
                      android:text="Peso" android:textColor="@color/text_primary" android:textSize="14sp"/>
                  <Spinner android:id="@+id/spinnerWeight"
                      android:layout_width="120dp" android:layout_height="36dp"/>
              </LinearLayout>
          </LinearLayout>

          <!-- Section: Metas diarias -->
          <TextView android:layout_width="wrap_content" android:layout_height="wrap_content"
              android:text="METAS DIARIAS" android:textColor="@color/accent_primary"
              android:textSize="11sp" android:textStyle="bold" android:layout_marginBottom="8dp"/>

          <LinearLayout android:layout_width="match_parent" android:layout_height="wrap_content"
              android:background="@drawable/bg_card" android:orientation="vertical"
              android:padding="16dp" android:layout_marginBottom="20dp">

              <!-- Steps goal -->
              <LinearLayout android:layout_width="match_parent" android:layout_height="wrap_content"
                  android:orientation="horizontal" android:gravity="center_vertical"
                  android:layout_marginBottom="12dp">
                  <TextView android:layout_width="0dp" android:layout_height="wrap_content"
                      android:layout_weight="1"
                      android:text="Pasos" android:textColor="@color/text_primary" android:textSize="14sp"/>
                  <EditText android:id="@+id/etGoalSteps"
                      android:layout_width="80dp" android:layout_height="36dp"
                      android:inputType="number" android:textColor="@color/text_primary"
                      android:textSize="13sp" android:background="@drawable/bg_card"/>
                  <TextView android:layout_width="wrap_content" android:layout_height="wrap_content"
                      android:text="  pasos" android:textColor="@color/text_secondary" android:textSize="12sp"/>
              </LinearLayout>

              <!-- Sleep goal -->
              <LinearLayout android:layout_width="match_parent" android:layout_height="wrap_content"
                  android:orientation="horizontal" android:gravity="center_vertical"
                  android:layout_marginBottom="12dp">
                  <TextView android:layout_width="0dp" android:layout_height="wrap_content"
                      android:layout_weight="1"
                      android:text="Sueño" android:textColor="@color/text_primary" android:textSize="14sp"/>
                  <EditText android:id="@+id/etGoalSleep"
                      android:layout_width="80dp" android:layout_height="36dp"
                      android:inputType="number" android:textColor="@color/text_primary"
                      android:textSize="13sp" android:background="@drawable/bg_card"/>
                  <TextView android:layout_width="wrap_content" android:layout_height="wrap_content"
                      android:text="  minutos" android:textColor="@color/text_secondary" android:textSize="12sp"/>
              </LinearLayout>

              <!-- Calories goal -->
              <LinearLayout android:layout_width="match_parent" android:layout_height="wrap_content"
                  android:orientation="horizontal" android:gravity="center_vertical"
                  android:layout_marginBottom="12dp">
                  <TextView android:layout_width="0dp" android:layout_height="wrap_content"
                      android:layout_weight="1"
                      android:text="Calorías" android:textColor="@color/text_primary" android:textSize="14sp"/>
                  <EditText android:id="@+id/etGoalCalories"
                      android:layout_width="80dp" android:layout_height="36dp"
                      android:inputType="number" android:textColor="@color/text_primary"
                      android:textSize="13sp" android:background="@drawable/bg_card"/>
                  <TextView android:layout_width="wrap_content" android:layout_height="wrap_content"
                      android:text="  kcal" android:textColor="@color/text_secondary" android:textSize="12sp"/>
              </LinearLayout>

              <!-- Distance goal -->
              <LinearLayout android:layout_width="match_parent" android:layout_height="wrap_content"
                  android:orientation="horizontal" android:gravity="center_vertical">
                  <TextView android:layout_width="0dp" android:layout_height="wrap_content"
                      android:layout_weight="1"
                      android:text="Distancia" android:textColor="@color/text_primary" android:textSize="14sp"/>
                  <EditText android:id="@+id/etGoalDistance"
                      android:layout_width="80dp" android:layout_height="36dp"
                      android:inputType="numberDecimal" android:textColor="@color/text_primary"
                      android:textSize="13sp" android:background="@drawable/bg_card"/>
                  <TextView android:id="@+id/lblDistanceUnit"
                      android:layout_width="wrap_content" android:layout_height="wrap_content"
                      android:text="  km" android:textColor="@color/text_secondary" android:textSize="12sp"/>
              </LinearLayout>
          </LinearLayout>

      </LinearLayout>
  </ScrollView>
  ```

- [ ] **Step 2: Create SettingsFragment.java**

  ```java
  package com.example.dialsender.fragments;

  import android.content.Context;
  import android.content.Intent;
  import android.content.SharedPreferences;
  import android.os.Bundle;
  import android.view.LayoutInflater;
  import android.view.View;
  import android.view.ViewGroup;
  import android.widget.AdapterView;
  import android.widget.ArrayAdapter;
  import android.widget.EditText;
  import android.widget.RadioGroup;
  import android.widget.Spinner;
  import android.widget.TextView;

  import androidx.annotation.NonNull;
  import androidx.annotation.Nullable;
  import androidx.fragment.app.Fragment;
  import androidx.localbroadcastmanager.content.LocalBroadcastManager;

  import com.example.dialsender.NotificationSettingsActivity;
  import com.example.dialsender.R;

  public class SettingsFragment extends Fragment {

      public static final String ACTION_GAUGE_STYLE_CHANGED = "com.example.dialsender.GAUGE_STYLE_CHANGED";
      private static final String PREF_NAME = "dial_sender_prefs";

      private SharedPreferences prefs;
      private boolean initializing = false;

      @Nullable
      @Override
      public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                               @Nullable Bundle savedInstanceState) {
          View view = inflater.inflate(R.layout.fragment_settings, container, false);
          prefs = requireContext().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);

          // Notifications row
          view.findViewById(R.id.rowNotifications).setOnClickListener(v ->
              startActivity(new Intent(requireContext(), NotificationSettingsActivity.class)));

          // Gauge style
          RadioGroup radioGauge = view.findViewById(R.id.radioGaugeStyle);
          String currentStyle = prefs.getString("gauge_style", "A");
          initializing = true;
          if ("B".equals(currentStyle)) radioGauge.check(R.id.radioGaugeB);
          else if ("C".equals(currentStyle)) radioGauge.check(R.id.radioGaugeC);
          else radioGauge.check(R.id.radioGaugeA);
          initializing = false;

          radioGauge.setOnCheckedChangeListener((group, checkedId) -> {
              if (initializing) return;
              String style;
              if (checkedId == R.id.radioGaugeB) style = "B";
              else if (checkedId == R.id.radioGaugeC) style = "C";
              else style = "A";
              prefs.edit().putString("gauge_style", style).apply();
              LocalBroadcastManager.getInstance(requireContext())
                  .sendBroadcast(new Intent(ACTION_GAUGE_STYLE_CHANGED));
          });

          // Distance unit spinner
          Spinner spinnerDist = view.findViewById(R.id.spinnerDistance);
          ArrayAdapter<String> distAdapter = new ArrayAdapter<>(requireContext(),
              android.R.layout.simple_spinner_dropdown_item, new String[]{"km", "millas"});
          spinnerDist.setAdapter(distAdapter);
          spinnerDist.setSelection("mi".equals(prefs.getString("unit_distance", "km")) ? 1 : 0);
          spinnerDist.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
              boolean first = true;
              @Override public void onItemSelected(AdapterView<?> p, View v, int pos, long id) {
                  if (first) { first = false; return; }
                  prefs.edit().putString("unit_distance", pos == 1 ? "mi" : "km").apply();
                  TextView lbl = getView() != null ? getView().findViewById(R.id.lblDistanceUnit) : null;
                  if (lbl != null) lbl.setText("  " + (pos == 1 ? "mi" : "km"));
              }
              @Override public void onNothingSelected(AdapterView<?> p) {}
          });

          // Weight unit spinner
          Spinner spinnerWeight = view.findViewById(R.id.spinnerWeight);
          ArrayAdapter<String> weightAdapter = new ArrayAdapter<>(requireContext(),
              android.R.layout.simple_spinner_dropdown_item, new String[]{"kg", "libras"});
          spinnerWeight.setAdapter(weightAdapter);
          spinnerWeight.setSelection("lb".equals(prefs.getString("unit_weight", "kg")) ? 1 : 0);
          spinnerWeight.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
              boolean first = true;
              @Override public void onItemSelected(AdapterView<?> p, View v, int pos, long id) {
                  if (first) { first = false; return; }
                  prefs.edit().putString("unit_weight", pos == 1 ? "lb" : "kg").apply();
              }
              @Override public void onNothingSelected(AdapterView<?> p) {}
          });

          // Goal fields
          setupGoalField(view, R.id.etGoalSteps,    "goal_steps",     10000);
          setupGoalField(view, R.id.etGoalSleep,    "goal_sleep_min", 480);
          setupGoalField(view, R.id.etGoalCalories, "goal_calories",  500);
          setupGoalField(view, R.id.etGoalDistance, "goal_distance",  5);

          // Distance unit label
          TextView lblDist = view.findViewById(R.id.lblDistanceUnit);
          lblDist.setText("  " + prefs.getString("unit_distance", "km"));

          return view;
      }

      private void setupGoalField(View root, int editTextId, String prefKey, int defaultVal) {
          EditText et = root.findViewById(editTextId);
          et.setText(String.valueOf(prefs.getInt(prefKey, defaultVal)));
          et.setOnFocusChangeListener((v, hasFocus) -> {
              if (!hasFocus) {
                  try {
                      int val = Integer.parseInt(et.getText().toString().trim());
                      prefs.edit().putInt(prefKey, val).apply();
                  } catch (NumberFormatException ignored) {
                      et.setText(String.valueOf(prefs.getInt(prefKey, defaultVal)));
                  }
              }
          });
      }
  }
  ```

- [ ] **Step 3: Commit**

  ```bash
  git add app/src/main/java/com/example/dialsender/fragments/SettingsFragment.java \
          app/src/main/res/layout/fragment_settings.xml
  git commit -m "feat(settings): add SettingsFragment with gauge style, units and goals config"
  ```

---

### Task 11: Wire SettingsFragment into MainActivity and rename tab

**Files:**
- Modify: `app/src/main/res/values/strings.xml`
- Modify: `app/src/main/res/values-es/strings.xml` (if exists)
- Modify: `app/src/main/java/com/example/dialsender/MainActivity.java`

- [ ] **Step 1: Update strings.xml**

  Change `nav_health` value from `"Salud"` to `"Ajustes"` in both:
  - `app/src/main/res/values/strings.xml`
  - `app/src/main/res/values-es/strings.xml` (if the file exists and contains `nav_health`)

- [ ] **Step 2: Swap fragment in MainActivity**

  Read the `nav_health` case in `MainActivity.java`. Replace `StatusFragment` instantiation with `SettingsFragment`:

  ```java
  case R.id.nav_health:
      fragment = new SettingsFragment();
      break;
  ```

- [ ] **Step 3: Commit**

  ```bash
  git add app/src/main/res/values/strings.xml \
          app/src/main/res/values-es/strings.xml \
          app/src/main/java/com/example/dialsender/MainActivity.java
  git commit -m "feat(nav): rename Salud tab to Ajustes and load SettingsFragment"
  ```

---

## Final Step: Build Verification

- [ ] Run `./gradlew assembleDebug` from the project root.
- [ ] Confirm BUILD SUCCESSFUL with 0 errors.
- [ ] If there are compile errors, fix them before claiming the task is complete.
