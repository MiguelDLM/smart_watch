package com.example.dialsender;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import android.net.Uri;
import android.os.Environment;
import androidx.core.content.FileProvider;
import android.graphics.BitmapFactory;

/**
 * Displays pre-made dials from assets/dials/ and user-created dials from
 * internal storage.
 * Features: preview thumbnails extracted from .bin, long-press rename/delete
 * for user dials.
 */
public class DialLibraryActivity extends AppCompatActivity {

    private RecyclerView dialRecycler;
    private LinearLayout emptyState;
    private List<DialEntry> dialEntries = new ArrayList<>();

    private static class DialEntry {
        String name;
        String path;
        String assetPath;
        long size;
        boolean isPreset;
        Bitmap thumb;

        DialEntry(String name, long size, boolean isPreset) {
            this.name = name;
            this.size = size;
            this.isPreset = isPreset;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SettingsActivity.applyGlobalTheme(this);
        super.onCreate(savedInstanceState);

        if (!Python.isStarted()) {
            Python.start(new AndroidPlatform(this));
        }

        setContentView(R.layout.activity_dial_library);

        dialRecycler = findViewById(R.id.dialRecycler);
        emptyState = findViewById(R.id.emptyState);
        findViewById(R.id.btnBackLibrary).setOnClickListener(v -> finish());

        dialRecycler.setLayoutManager(new LinearLayoutManager(this));
        loadDials();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadDials();
    }

    private void loadDials() {
        dialEntries.clear();

        // 1. Load preset dials from assets/dials/
        try {
            String[] assetDials = getAssets().list("dials");
            if (assetDials != null) {
                for (String name : assetDials) {
                    if (name.endsWith(".bin")) {
                        InputStream is = getAssets().open("dials/" + name);
                        int size = is.available();
                        is.close();

                        DialEntry entry = new DialEntry(name, size, true);
                        entry.assetPath = "dials/" + name;
                        dialEntries.add(entry);
                    }
                }
            }
        } catch (Exception e) {
            // No preset dials
        }

        // 2. Load user-created dials from internal storage
        File userDialsDir = getUserDialsDir();
        if (userDialsDir.exists()) {
            File[] files = userDialsDir.listFiles();
            if (files != null) {
                for (File f : files) {
                    if (f.getName().endsWith(".bin")) {
                        DialEntry entry = new DialEntry(f.getName(), f.length(), false);
                        entry.path = f.getAbsolutePath();
                        dialEntries.add(entry);
                    }
                }
            }
        }

        // Update UI
        if (dialEntries.isEmpty()) {
            emptyState.setVisibility(View.VISIBLE);
            dialRecycler.setVisibility(View.GONE);
        } else {
            emptyState.setVisibility(View.GONE);
            dialRecycler.setVisibility(View.VISIBLE);
            dialRecycler.setAdapter(new DialAdapter());
        }

        // Extract preview thumbnails in background
        extractThumbnailsAsync();
    }

    /**
     * Extracts preview images from .bin files using Python.
     */
    private void extractThumbnailsAsync() {
        new Thread(() -> {
            Python py = Python.getInstance();
            PyObject module = py.getModule("comp_decomp");

            for (int i = 0; i < dialEntries.size(); i++) {
                DialEntry entry = dialEntries.get(i);
                try {
                    File thumbFile = new File(getCacheDir(), "preview_" + entry.name.replace(".bin", ".png"));

                    // CACHING: If thumb already exists, load it directly
                    if (thumbFile.exists() && thumbFile.length() > 0) {
                        entry.thumb = BitmapFactory.decodeFile(thumbFile.getAbsolutePath());
                        continue;
                    }

                    File binFile;
                    if (entry.isPreset) {
                        // Copy asset to cache first
                        binFile = new File(getCacheDir(), "thumb_" + entry.name);
                        if (!binFile.exists()) {
                            InputStream is = getAssets().open(entry.assetPath);
                            FileOutputStream fos = new FileOutputStream(binFile);
                            byte[] buf = new byte[4096];
                            int len;
                            while ((len = is.read(buf)) != -1)
                                fos.write(buf, 0, len);
                            fos.close();
                            is.close();
                        }
                    } else {
                        binFile = new File(entry.path);
                    }

                    // Call Python to extract preview
                    PyObject result = module.callAttr("extract_preview_png",
                            binFile.getAbsolutePath(), thumbFile.getAbsolutePath());

                    String resultPath = result.toString();
                    if (!resultPath.isEmpty() && thumbFile.exists()) {
                        entry.thumb = BitmapFactory.decodeFile(thumbFile.getAbsolutePath());
                    }
                } catch (Exception e) {
                    // Preview extraction failed, will show fallback
                }
            }

            // Notify adapter
            runOnUiThread(() -> {
                if (dialRecycler.getAdapter() != null) {
                    dialRecycler.getAdapter().notifyDataSetChanged();
                }
            });
        }).start();
    }

    public static File getUserDialsDir(Activity activity) {
        File dir = new File(activity.getFilesDir(), "user_dials");
        if (!dir.exists())
            dir.mkdirs();
        return dir;
    }

    private File getUserDialsDir() {
        return getUserDialsDir(this);
    }

    private void sendDial(DialEntry entry) {
        try {
            File fileToSend;

            if (entry.isPreset) {
                fileToSend = new File(getCacheDir(), entry.name);
                InputStream is = getAssets().open(entry.assetPath);
                FileOutputStream fos = new FileOutputStream(fileToSend);
                byte[] buf = new byte[4096];
                int len;
                while ((len = is.read(buf)) != -1)
                    fos.write(buf, 0, len);
                fos.close();
                is.close();
            } else {
                fileToSend = new File(entry.path);
            }

            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("dial_file_path", fileToSend.getAbsolutePath());
            startActivity(intent);

        } catch (Exception e) {
            Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void editDial(DialEntry entry) {
        try {
            File file = prepareFile(entry);
            String safeName = entry.name.replace(".bin", "");
            File editDir = new File(getCacheDir(), "edit_" + safeName);
            if (!editDir.exists())
                editDir.mkdirs();

            Python py = Python.getInstance();
            PyObject module = py.getModule("comp_decomp");
            PyObject result = module.callAttr("extract_dial", file.getAbsolutePath(), editDir.getAbsolutePath());

            if (result != null && result.toBoolean()) {
                Intent intent = new Intent(this, DialEditorActivity.class);
                intent.putExtra("edit_dial_folder", editDir.getAbsolutePath());
                intent.putExtra("edit_dial_name", safeName);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Failed to extract dial", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Edit error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    // ===================== RENAME / DELETE =====================

    private void showDialContextMenu(DialEntry entry, int position) {
        List<String> opts = new ArrayList<>();
        opts.add(getString(R.string.send_arrow));
        opts.add(getString(R.string.edit));
        opts.add(getString(R.string.share));
        opts.add(getString(R.string.export));

        if (!entry.isPreset) {
            opts.add(getString(R.string.rename));
            opts.add(getString(R.string.delete));
        }

        new AlertDialog.Builder(this)
                .setTitle(entry.name.replace(".bin", ""))
                .setItems(opts.toArray(new String[0]), (dialog, which) -> {
                    String choice = opts.get(which);
                    if (choice.equals(getString(R.string.send_arrow))) {
                        sendDial(entry);
                    } else if (choice.equals(getString(R.string.edit))) {
                        editDial(entry);
                    } else if (choice.equals(getString(R.string.share))) {
                        shareDial(entry);
                    } else if (choice.equals(getString(R.string.export))) {
                        exportDial(entry);
                    } else if (choice.equals(getString(R.string.rename))) {
                        showRenameDialog(entry, position);
                    } else if (choice.equals(getString(R.string.delete))) {
                        showDeleteConfirm(entry, position);
                    }
                })
                .show();
    }

    private void showRenameDialog(DialEntry entry, int position) {
        EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        input.setText(entry.name.replace(".bin", ""));
        input.setPadding(48, 24, 48, 24);

        new AlertDialog.Builder(this)
                .setTitle(R.string.rename_dial)
                .setView(input)
                .setPositiveButton(R.string.save, (dialog, which) -> {
                    String newName = input.getText().toString().trim();
                    if (newName.isEmpty())
                        return;
                    newName = newName.replaceAll("[^a-zA-Z0-9_\\-]", "_") + ".bin";

                    File oldFile = new File(entry.path);
                    File newFile = new File(oldFile.getParentFile(), newName);

                    if (newFile.exists()) {
                        Toast.makeText(this, "Name already exists", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if (oldFile.renameTo(newFile)) {
                        // Also rename thumbnail cache if exists
                        File oldThumb = new File(getCacheDir(), "preview_" + entry.name.replace(".bin", ".png"));
                        File newThumb = new File(getCacheDir(), "preview_" + newName.replace(".bin", ".png"));
                        if (oldThumb.exists())
                            oldThumb.renameTo(newThumb);

                        entry.name = newName;
                        entry.path = newFile.getAbsolutePath();
                        if (dialRecycler.getAdapter() != null) {
                            dialRecycler.getAdapter().notifyItemChanged(position);
                        }
                        Toast.makeText(this, R.string.dial_renamed, Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton(R.string.cancel, null)
                .show();
    }

    private void showDeleteConfirm(DialEntry entry, int position) {
        new AlertDialog.Builder(this)
                .setTitle(R.string.delete)
                .setMessage(R.string.confirm_delete)
                .setPositiveButton(R.string.delete, (dialog, which) -> {
                    File file = new File(entry.path);
                    file.delete();
                    // Also delete cached preview
                    File thumbFile = new File(getCacheDir(), "preview_" + entry.name.replace(".bin", ".png"));
                    thumbFile.delete();

                    dialEntries.remove(position);
                    if (dialRecycler.getAdapter() != null) {
                        dialRecycler.getAdapter().notifyItemRemoved(position);
                    }
                    if (dialEntries.isEmpty()) {
                        emptyState.setVisibility(View.VISIBLE);
                        dialRecycler.setVisibility(View.GONE);
                    }
                    Toast.makeText(this, R.string.dial_deleted, Toast.LENGTH_SHORT).show();
                })
                .setNegativeButton(R.string.cancel, null)
                .show();
    }

    private void shareDial(DialEntry entry) {
        try {
            File file = prepareFile(entry);
            Uri uri = FileProvider.getUriForFile(this, getPackageName() + ".provider", file);

            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("application/octet-stream");
            intent.putExtra(Intent.EXTRA_STREAM, uri);
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            startActivity(Intent.createChooser(intent, getString(R.string.share)));
        } catch (Exception e) {
            Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void exportDial(DialEntry entry) {
        try {
            File src = prepareFile(entry);
            File downloads = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
            File destDir = new File(downloads, "DialStudio");
            if (!destDir.exists())
                destDir.mkdirs();

            File dest = new File(destDir, entry.name);
            copyFile(src, dest);

            Toast.makeText(this, getString(R.string.dial_exported), Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(this, "Export error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private File prepareFile(DialEntry entry) throws Exception {
        if (!entry.isPreset)
            return new File(entry.path);

        File cached = new File(getCacheDir(), entry.name);
        if (!cached.exists()) {
            InputStream is = getAssets().open(entry.assetPath);
            FileOutputStream fos = new FileOutputStream(cached);
            byte[] buf = new byte[4096];
            int len;
            while ((len = is.read(buf)) != -1)
                fos.write(buf, 0, len);
            fos.close();
            is.close();
        }
        return cached;
    }

    private void copyFile(File src, File dst) throws Exception {
        InputStream in = new java.io.FileInputStream(src);
        FileOutputStream out = new FileOutputStream(dst);
        byte[] buf = new byte[4096];
        int len;
        while ((len = in.read(buf)) != -1)
            out.write(buf, 0, len);
        in.close();
        out.close();
    }

    // --- Adapter ---

    private class DialAdapter extends RecyclerView.Adapter<DialAdapter.VH> {
        @NonNull
        @Override
        public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dial, parent, false);
            return new VH(v);
        }

        @Override
        public void onBindViewHolder(@NonNull VH holder, int position) {
            DialEntry entry = dialEntries.get(position);
            holder.txtName.setText(entry.name.replace(".bin", ""));
            String sizeStr = entry.size > 1024
                    ? String.format("%.1f KB", entry.size / 1024.0)
                    : entry.size + " bytes";
            holder.txtSize.setText(sizeStr);
            holder.txtSource.setText(entry.isPreset ? getString(R.string.preset) : getString(R.string.custom));
            holder.txtSource.setTextColor(getResources().getColor(
                    entry.isPreset ? R.color.accent_cyan : R.color.accent_secondary));

            // Thumbnail
            if (entry.thumb != null) {
                holder.imgThumb.setImageBitmap(entry.thumb);
            } else {
                holder.imgThumb.setImageResource(android.R.color.darker_gray);
            }

            holder.btnSend.setText(R.string.send_arrow);
            holder.btnSend.setOnClickListener(v -> sendDial(entry));
            holder.itemView.setOnClickListener(v -> sendDial(entry));

            // Long press for rename/delete (user dials only)
            holder.itemView.setOnLongClickListener(v -> {
                showDialContextMenu(entry, position);
                return true;
            });
        }

        @Override
        public int getItemCount() {
            return dialEntries.size();
        }

        class VH extends RecyclerView.ViewHolder {
            ImageView imgThumb;
            TextView txtName, txtSize, txtSource, btnSend;

            VH(View v) {
                super(v);
                imgThumb = v.findViewById(R.id.imgDialThumb);
                txtName = v.findViewById(R.id.txtDialName);
                txtSize = v.findViewById(R.id.txtDialSize);
                txtSource = v.findViewById(R.id.txtDialSource);
                btnSend = v.findViewById(R.id.btnSendDial);
            }
        }
    }
}
