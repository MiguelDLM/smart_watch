package com.sma.smartv3.ui.timezonepicker;

import OoOoXO0.xoXoI;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ThreadUtils;
import com.l4digital.fastscroll.FastScrollRecyclerView;
import com.miguelcatalan.materialsearchview.MaterialSearchView;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.ui.timezonepicker.TimeZonePicker;
import com.sma.smartv3.ui.timezonepicker.oIX0oI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes12.dex */
public class TimeZonePickerActivity extends AppCompatActivity implements MaterialSearchView.II0XooXoX {
    private static final boolean DEBUG = false;
    public static final String EXTRA_RESULT_SELECTION = "extra_result_selection";
    private static final String TAG = "TimeZonePickerActivity";
    private com.sma.smartv3.ui.timezonepicker.oIX0oI adapter;
    private Integer animationCloseEnter;
    private Integer animationCloseExit;
    private TimeZonePicker.Builder builder;
    private LinearLayout controlPanel;
    private ThreadUtils.SimpleTask loadTask;
    private ProgressBar progressBar;
    private ProgressBar progressBarAsnc;
    private FastScrollRecyclerView recyclerView;
    private MenuItem searchMenuItem;
    private MaterialSearchView searchView;
    private Toolbar toolbar;
    private TextView tvNoData;
    private TextView tvSelectAll;
    private TextView tvSelectBtn;
    private ArrayList<TimeZoneInfo> mTimeZones = new ArrayList<>();
    private boolean allSelected = false;

    /* loaded from: classes12.dex */
    public class I0Io implements View.OnClickListener {
        public I0Io() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TimeZonePickerActivity.this.allSelected = !r3.allSelected;
            if (TimeZonePickerActivity.this.adapter != null) {
                TimeZonePickerActivity.this.adapter.setAllSelected(TimeZonePickerActivity.this.allSelected);
            }
            if (TimeZonePickerActivity.this.allSelected) {
                TimeZonePickerActivity.this.tvSelectAll.setText(TimeZonePickerActivity.this.getString(R.string.text_unselect_all));
            } else {
                TimeZonePickerActivity.this.tvSelectAll.setText(TimeZonePickerActivity.this.getString(R.string.text_select_all));
            }
        }
    }

    /* loaded from: classes12.dex */
    public class II0xO0 implements View.OnClickListener {
        public II0xO0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TimeZonePickerActivity timeZonePickerActivity = TimeZonePickerActivity.this;
            timeZonePickerActivity.finishPicking(timeZonePickerActivity.adapter.oOoXoXO());
        }
    }

    /* loaded from: classes12.dex */
    public class oIX0oI implements oIX0oI.I0Io {
        public oIX0oI() {
        }

        @Override // com.sma.smartv3.ui.timezonepicker.oIX0oI.I0Io
        public void oIX0oI(TimeZoneInfo timezone, int totalSelectedTimeZones) {
            TimeZonePickerActivity.this.updateSelectBarContents(totalSelectedTimeZones);
            if (TimeZonePickerActivity.this.builder.selectionMode == 1) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(timezone);
                TimeZonePickerActivity.this.finishPicking(arrayList);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class oxoX extends ThreadUtils.SimpleTask<Object> {
        public oxoX() {
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        public Object doInBackground() {
            TimeZonePickerActivity timeZonePickerActivity = TimeZonePickerActivity.this;
            timeZonePickerActivity.loadTzsInZoneTab(timeZonePickerActivity);
            Collections.sort(TimeZonePickerActivity.this.mTimeZones);
            return null;
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        public void onSuccess(Object result) {
            if (TimeZonePickerActivity.this.mTimeZones.size() == 0) {
                TimeZonePickerActivity.this.tvNoData.setVisibility(0);
            }
            if (TimeZonePickerActivity.this.adapter != null && TimeZonePickerActivity.this.builder.loadingMode == 1) {
                TimeZonePickerActivity.this.adapter.notifyDataSetChanged();
            }
            if (TimeZonePickerActivity.this.adapter != null) {
                TimeZonePickerActivity timeZonePickerActivity = TimeZonePickerActivity.this;
                timeZonePickerActivity.updateSelectBarContents(timeZonePickerActivity.adapter.ooOOo0oXI());
            }
            TimeZonePickerActivity.this.progressBar.setVisibility(8);
            TimeZonePickerActivity.this.progressBarAsnc.setVisibility(8);
            TimeZonePickerActivity.this.recyclerView.setVisibility(0);
            TimeZonePickerActivity.this.tvSelectAll.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishPicking(List<TimeZoneInfo> selectedTimeZones) {
        Intent intent = new Intent();
        intent.putExtra("extra_result_selection", TimeZonePicker.oIX0oI(selectedTimeZones));
        setResult(-1, intent);
        finish();
        overrideAnimation();
    }

    private String getCountryNames(String lang, String countryCode) {
        String displayCountry = new Locale(lang, countryCode).getDisplayCountry(Locale.getDefault());
        if (!countryCode.equals(displayCountry)) {
            return displayCountry;
        }
        return countryCode;
    }

    private int getIdenticalTimeZoneInTheCountry(TimeZoneInfo timeZoneInfo) {
        Iterator<TimeZoneInfo> it = this.mTimeZones.iterator();
        int i = 0;
        while (it.hasNext()) {
            TimeZoneInfo next = it.next();
            if (next.hasSameRules(timeZoneInfo)) {
                if (next.getCountry() == null) {
                    if (timeZoneInfo.getCountry() == null) {
                        return i;
                    }
                } else if (next.getCountry().equals(timeZoneInfo.getCountry())) {
                    return i;
                }
            }
            i++;
        }
        return -1;
    }

    private void initialiseUI(TimeZonePicker.Builder builder) {
        setSupportActionBar(this.toolbar);
        this.searchView.setOnQueryTextListener(this);
        this.animationCloseEnter = builder.animationCloseEnter;
        this.animationCloseExit = builder.animationCloseExit;
        int i = builder.bubbleColor;
        if (i != 0) {
            this.recyclerView.setBubbleColor(i);
        }
        int i2 = builder.handleColor;
        if (i2 != 0) {
            this.recyclerView.setHandleColor(i2);
        }
        int i3 = builder.bubbleTextColor;
        if (i3 != 0) {
            this.recyclerView.setBubbleTextColor(i3);
        }
        int i4 = builder.trackColor;
        if (i4 != 0) {
            this.recyclerView.setTrackColor(i4);
        }
        this.recyclerView.setHideScrollbar(builder.hideScrollbar);
        this.recyclerView.setTrackVisible(builder.showTrack);
        if (builder.selectionMode == 1) {
            this.controlPanel.setVisibility(8);
        } else {
            this.controlPanel.setVisibility(0);
        }
        String str = builder.titleText;
        if (str != null) {
            setTitle(str);
        }
    }

    private void loadData() {
        this.tvSelectAll.setEnabled(false);
        if (this.builder.loadingMode == 0) {
            this.progressBarAsnc.setVisibility(0);
            this.recyclerView.setVisibility(4);
        } else {
            this.progressBar.setVisibility(0);
            this.recyclerView.setVisibility(4);
        }
        oxoX oxox = new oxoX();
        this.loadTask = oxox;
        ThreadUtils.executeByIo(oxox);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadTzsInZoneTab(Context context) {
        AssetManager assets = context.getAssets();
        InputStream inputStream = null;
        try {
            try {
                String language = Locale.getDefault().getLanguage();
                inputStream = assets.open("zone.tab");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    if (!readLine.startsWith(xoXoI.f2670oxoX)) {
                        String[] split = readLine.split("\t");
                        String str = split[2];
                        String str2 = split[0];
                        TimeZone timeZone = TimeZone.getTimeZone(str);
                        if (timeZone == null) {
                            Log.e(TAG, "Timezone not found: " + str);
                        } else if (str2 != null || str.startsWith("Etc/GMT")) {
                            TimeZoneInfo timeZoneInfo = new TimeZoneInfo(context, timeZone, getCountryNames(language, str2));
                            if (getIdenticalTimeZoneInTheCountry(timeZoneInfo) == -1) {
                                this.mTimeZones.add(timeZoneInfo);
                                if (this.builder.selectedItems.contains(timeZoneInfo.getCityName())) {
                                    this.adapter.x0XOIxOo(timeZoneInfo.getCityName());
                                }
                            }
                        }
                    }
                }
                TimeZoneInfo timeZoneInfo2 = new TimeZoneInfo(context, TimeZone.getTimeZone("America/Los_Angeles"), getString(R.string.las_vegas));
                timeZoneInfo2.setCityName(getString(R.string.las_vegas));
                this.mTimeZones.add(timeZoneInfo2);
                if (inputStream == null) {
                    return;
                }
            } catch (IOException unused) {
                Log.e(TAG, "Failed to read 'zone.tab'.");
                if (inputStream == null) {
                    return;
                }
            }
            try {
                inputStream.close();
            } catch (IOException unused2) {
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused3) {
                }
            }
            throw th;
        }
    }

    private void overrideAnimation() {
        Integer num = this.animationCloseEnter;
        if (num != null && this.animationCloseExit != null) {
            overridePendingTransition(num.intValue(), this.animationCloseExit.intValue());
        }
    }

    private void setSearchIconColor(MenuItem menuItem, final Integer color) {
        Drawable icon;
        if (color != null && (icon = menuItem.getIcon()) != null) {
            Drawable wrap = DrawableCompat.wrap(icon);
            DrawableCompat.setTint(wrap.mutate(), color.intValue());
            menuItem.setIcon(wrap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSelectBarContents(int totalSelectedTimeZones) {
        boolean z;
        TextView textView = this.tvSelectBtn;
        if (totalSelectedTimeZones > 0) {
            z = true;
        } else {
            z = false;
        }
        textView.setEnabled(z);
        if (totalSelectedTimeZones > 0) {
            if (this.builder.maxSelectCount == 0) {
                this.tvSelectBtn.setText(getString(R.string.text_done_1, String.valueOf(totalSelectedTimeZones)));
                return;
            } else {
                this.tvSelectBtn.setText(getString(R.string.text_done_2, String.valueOf(totalSelectedTimeZones), String.valueOf(this.builder.maxSelectCount)));
                return;
            }
        }
        this.tvSelectBtn.setText(getString(R.string.text_done));
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.searchView.Oxx0xo()) {
            this.searchView.ooOOo0oXI();
        } else {
            super.onBackPressed();
            overrideAnimation();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        TimeZonePicker.Builder builder = (TimeZonePicker.Builder) intent.getSerializableExtra("builder");
        this.builder = builder;
        setTheme(builder.theme);
        setContentView(R.layout.activity_timezone_picker);
        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.searchView = (MaterialSearchView) findViewById(R.id.search_view);
        this.controlPanel = (LinearLayout) findViewById(R.id.controlPanel);
        this.progressBar = (ProgressBar) findViewById(R.id.progressBar);
        this.progressBarAsnc = (ProgressBar) findViewById(R.id.progressBar_async);
        this.tvSelectAll = (TextView) findViewById(R.id.tvSelectAll);
        this.tvSelectBtn = (TextView) findViewById(R.id.tvSelect);
        this.tvNoData = (TextView) findViewById(R.id.tvNoData);
        this.recyclerView = (FastScrollRecyclerView) findViewById(R.id.recyclerView);
        initialiseUI(this.builder);
        if (this.builder.maxSelectCount != 0) {
            this.tvSelectAll.setVisibility(8);
        }
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.adapter = new com.sma.smartv3.ui.timezonepicker.oIX0oI(this.builder, this.mTimeZones, new oIX0oI());
        loadData();
        this.recyclerView.setAdapter(this.adapter);
        this.tvSelectBtn.setOnClickListener(new II0xO0());
        this.tvSelectAll.setOnClickListener(new I0Io());
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.pick_menu_main, menu);
        MenuItem findItem = menu.findItem(R.id.mcp_action_search);
        this.searchMenuItem = findItem;
        setSearchIconColor(findItem, this.builder.searchIconColor);
        this.searchView.setMenuItem(this.searchMenuItem);
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ThreadUtils.SimpleTask simpleTask = this.loadTask;
        if (simpleTask != null && !simpleTask.isDone()) {
            LogUtils.d("Cancel loadTask");
            ThreadUtils.cancel(this.loadTask);
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == 16908332) {
            setResult(0);
            finish();
            overrideAnimation();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override // com.miguelcatalan.materialsearchview.MaterialSearchView.II0XooXoX
    public boolean onQueryTextChange(String newText) {
        com.sma.smartv3.ui.timezonepicker.oIX0oI oix0oi = this.adapter;
        if (oix0oi != null) {
            oix0oi.filterOnText(newText);
            return false;
        }
        return false;
    }

    @Override // com.miguelcatalan.materialsearchview.MaterialSearchView.II0XooXoX
    public boolean onQueryTextSubmit(String query) {
        com.sma.smartv3.ui.timezonepicker.oIX0oI oix0oi = this.adapter;
        if (oix0oi != null) {
            oix0oi.filterOnText(query);
            return false;
        }
        return false;
    }
}
