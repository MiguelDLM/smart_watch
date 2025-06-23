package com.sma.smartv3.ui.musicpicker;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
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
import com.sma.smartv3.ui.musicpicker.MusicPicker;
import com.sma.smartv3.ui.musicpicker.oxoX;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes11.dex */
public class MusicPickerActivity extends AppCompatActivity implements MaterialSearchView.II0XooXoX {
    public static final String EXTRA_RESULT_SELECTION = "extra_result_selection";
    private com.sma.smartv3.ui.musicpicker.oxoX adapter;
    private Integer animationCloseEnter;
    private Integer animationCloseExit;
    private MusicPicker.Builder builder;
    private LinearLayout controlPanel;
    private ThreadUtils.SimpleTask loadTask;
    private ProgressBar progressBar;
    private ProgressBar progressBarAsnc;
    private FastScrollRecyclerView recyclerView;
    private MenuItem searchMenuItem;
    private MaterialSearchView searchView;
    private Toolbar toolbar;
    private TextView tvNoMusics;
    private TextView tvSelectAll;
    private TextView tvSelectBtn;
    private List<com.sma.smartv3.ui.musicpicker.oIX0oI> musicList = new ArrayList();
    private boolean allSelected = false;

    /* loaded from: classes11.dex */
    public class I0Io implements View.OnClickListener {
        public I0Io() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MusicPickerActivity.this.allSelected = !r3.allSelected;
            if (MusicPickerActivity.this.adapter != null) {
                MusicPickerActivity.this.adapter.setAllSelected(MusicPickerActivity.this.allSelected);
            }
            if (MusicPickerActivity.this.allSelected) {
                MusicPickerActivity.this.tvSelectAll.setText(MusicPickerActivity.this.getString(R.string.text_unselect_all));
            } else {
                MusicPickerActivity.this.tvSelectAll.setText(MusicPickerActivity.this.getString(R.string.text_select_all));
            }
        }
    }

    /* loaded from: classes11.dex */
    public class II0xO0 implements View.OnClickListener {
        public II0xO0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MusicPickerActivity.this.finishPicking();
        }
    }

    /* loaded from: classes11.dex */
    public class oIX0oI implements oxoX.I0Io {
        public oIX0oI() {
        }

        @Override // com.sma.smartv3.ui.musicpicker.oxoX.I0Io
        public void oIX0oI(com.sma.smartv3.ui.musicpicker.oIX0oI music, int totalSelectedMusics) {
            MusicPickerActivity.this.updateSelectBarContents(totalSelectedMusics);
            if (MusicPickerActivity.this.builder.selectionMode == 1) {
                MusicPickerActivity.this.finishPicking();
            }
        }
    }

    /* loaded from: classes11.dex */
    public class oxoX extends ThreadUtils.SimpleTask<Object> {

        /* renamed from: Oo, reason: collision with root package name */
        public com.sma.smartv3.ui.musicpicker.I0Io f23671Oo = new oIX0oI();

        /* renamed from: XO, reason: collision with root package name */
        public com.sma.smartv3.ui.musicpicker.II0xO0 f23672XO;

        /* loaded from: classes11.dex */
        public class oIX0oI implements com.sma.smartv3.ui.musicpicker.I0Io {

            /* renamed from: com.sma.smartv3.ui.musicpicker.MusicPickerActivity$oxoX$oIX0oI$oIX0oI, reason: collision with other inner class name */
            /* loaded from: classes11.dex */
            public class RunnableC0975oIX0oI implements Runnable {
                public RunnableC0975oIX0oI() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (MusicPickerActivity.this.adapter != null) {
                        MusicPickerActivity.this.adapter.notifyDataSetChanged();
                    }
                }
            }

            public oIX0oI() {
            }

            @Override // com.sma.smartv3.ui.musicpicker.I0Io
            public void oIX0oI(com.sma.smartv3.ui.musicpicker.oIX0oI music) {
                MusicPickerActivity.this.musicList.add(music);
                if (MusicPickerActivity.this.builder.selectedItems.contains(Long.valueOf(music.oOoXoXO()))) {
                    MusicPickerActivity.this.adapter.ooOOo0oXI(music.oOoXoXO());
                }
                if (MusicPickerActivity.this.builder.loadingMode == 0) {
                    MusicPickerActivity.this.runOnUiThread(new RunnableC0975oIX0oI());
                }
            }

            @Override // com.sma.smartv3.ui.musicpicker.I0Io
            public void onComplete() {
                if (MusicPickerActivity.this.musicList.size() == 0) {
                    MusicPickerActivity.this.tvNoMusics.setVisibility(0);
                }
                if (MusicPickerActivity.this.adapter != null && MusicPickerActivity.this.builder.loadingMode == 1) {
                    MusicPickerActivity.this.adapter.notifyDataSetChanged();
                }
                if (MusicPickerActivity.this.adapter != null) {
                    MusicPickerActivity musicPickerActivity = MusicPickerActivity.this;
                    musicPickerActivity.updateSelectBarContents(musicPickerActivity.adapter.oOoXoXO());
                }
                MusicPickerActivity.this.progressBar.setVisibility(8);
                MusicPickerActivity.this.progressBarAsnc.setVisibility(8);
                MusicPickerActivity.this.tvSelectAll.setEnabled(true);
            }
        }

        public oxoX() {
            this.f23672XO = new com.sma.smartv3.ui.musicpicker.II0xO0(MusicPickerActivity.this);
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        public Object doInBackground() throws Throwable {
            this.f23672XO.oxoX(this.f23671Oo);
            return null;
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.SimpleTask, com.blankj.utilcode.util.ThreadUtils.Task
        public void onCancel() {
            super.onCancel();
            this.f23672XO.X0o0xo(true);
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.SimpleTask, com.blankj.utilcode.util.ThreadUtils.Task
        public void onFail(Throwable t) {
            super.onFail(t);
            this.f23672XO.X0o0xo(true);
            t.printStackTrace();
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        public void onSuccess(Object result) {
            this.f23671Oo.onComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishPicking() {
        Intent intent = new Intent();
        intent.putExtra("extra_result_selection", MusicPicker.oIX0oI(this.adapter.OOXIXo()));
        setResult(-1, intent);
        finish();
        overrideAnimation();
    }

    private void initialiseUI(MusicPicker.Builder builder) {
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
        if (builder.selectionMode == 1 && builder.selectedItems.size() > 0) {
            throw new RuntimeException("You must be using MusicPicker.CHOICE_MODE_MULTIPLE in order to use setSelectedMusics()");
        }
        String str = builder.titleText;
        if (str != null) {
            setTitle(str);
        }
    }

    private void loadMusics() {
        this.tvSelectAll.setEnabled(false);
        if (this.builder.loadingMode == 0) {
            this.progressBarAsnc.setVisibility(0);
        } else {
            this.progressBar.setVisibility(0);
        }
        oxoX oxox = new oxoX();
        this.loadTask = oxox;
        ThreadUtils.executeByIo(oxox);
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
    public void updateSelectBarContents(int totalSelectedMusics) {
        boolean z;
        TextView textView = this.tvSelectBtn;
        if (totalSelectedMusics > 0) {
            z = true;
        } else {
            z = false;
        }
        textView.setEnabled(z);
        if (totalSelectedMusics > 0) {
            if (this.builder.maxSelectCount == 0) {
                this.tvSelectBtn.setText(getString(R.string.text_done_1, String.valueOf(totalSelectedMusics)));
                return;
            } else {
                this.tvSelectBtn.setText(getString(R.string.text_done_2, String.valueOf(totalSelectedMusics), String.valueOf(this.builder.maxSelectCount)));
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
        MusicPicker.Builder builder = (MusicPicker.Builder) intent.getSerializableExtra("builder");
        this.builder = builder;
        setTheme(builder.theme);
        setContentView(R.layout.activity_music_picker);
        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.searchView = (MaterialSearchView) findViewById(R.id.search_view);
        this.controlPanel = (LinearLayout) findViewById(R.id.controlPanel);
        this.progressBar = (ProgressBar) findViewById(R.id.progressBar);
        this.progressBarAsnc = (ProgressBar) findViewById(R.id.progressBar_async);
        this.tvSelectAll = (TextView) findViewById(R.id.tvSelectAll);
        this.tvSelectBtn = (TextView) findViewById(R.id.tvSelect);
        this.tvNoMusics = (TextView) findViewById(R.id.tvNoMusics);
        this.recyclerView = (FastScrollRecyclerView) findViewById(R.id.recyclerView);
        initialiseUI(this.builder);
        if (this.builder.maxSelectCount != 0) {
            this.tvSelectAll.setVisibility(8);
        }
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.adapter = new com.sma.smartv3.ui.musicpicker.oxoX(this.builder, this.musicList, new oIX0oI());
        loadMusics();
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
        com.sma.smartv3.ui.musicpicker.oxoX oxox = this.adapter;
        if (oxox != null) {
            oxox.filterOnText(newText);
            return false;
        }
        return false;
    }

    @Override // com.miguelcatalan.materialsearchview.MaterialSearchView.II0XooXoX
    public boolean onQueryTextSubmit(String query) {
        com.sma.smartv3.ui.musicpicker.oxoX oxox = this.adapter;
        if (oxox != null) {
            oxox.filterOnText(query);
            return false;
        }
        return false;
    }
}
