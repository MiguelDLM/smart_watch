package me.devilsen.czxing;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

/* loaded from: classes6.dex */
public class ResultActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView resultTxt;

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ((ClipboardManager) getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("", this.resultTxt.getText().toString()));
        Toast.makeText(this, "已复制", 0).show();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_scan_result);
        String stringExtra = getIntent().getStringExtra("result");
        this.resultTxt = (TextView) findViewById(R.id.text_view_scan_result);
        Button button = (Button) findViewById(R.id.button_scan_copy);
        this.resultTxt.setText(stringExtra);
        button.setOnClickListener(this);
    }
}
