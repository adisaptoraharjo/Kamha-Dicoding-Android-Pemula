package dev.asr.hantu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class HantuDetailActivity extends AppCompatActivity {

    public static String EXTRA_NAME = "hantu_name";
    public static String EXTRA_ORIGIN = "hantu_origin";
    public static String EXTRA_DESC = "hantu_desc";
    public static String EXTRA_IMG = "hantu_photo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hantu_detail);

        ImageView hantuImg = findViewById(R.id.iv_hantu);
        TextView hantuName = findViewById(R.id.tv_hantu_name);
        TextView hantuOrigin = findViewById(R.id.tv_hantu_origin);
        TextView hantuDesc = findViewById(R.id.tv_hantu_desc);

        Glide.with(this).load(getIntent().getStringExtra(EXTRA_IMG)).into(hantuImg);
        hantuName.setText(getIntent().getStringExtra(EXTRA_NAME));
        hantuDesc.setText(getIntent().getStringExtra(EXTRA_DESC));
        hantuOrigin.setText(getIntent().getStringExtra(EXTRA_ORIGIN));

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Detail " + getIntent().getStringExtra(EXTRA_NAME));
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }
}
