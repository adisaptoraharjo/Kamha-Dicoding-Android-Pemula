package dev.asr.hantu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

import dev.asr.hantu.adapters.HantuListAdapter;
import dev.asr.hantu.dummy.HantuDummy;
import dev.asr.hantu.models.Hantu;


public class MainActivity extends AppCompatActivity {

    private RecyclerView rvHantu;
    private ArrayList<Hantu> listHantu = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvHantu = findViewById(R.id.rv_main);
        rvHantu.setHasFixedSize(true);
        listHantu.addAll(HantuDummy.getData());

        showRecyclerList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about_me:
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showRecyclerList() {
        rvHantu.setLayoutManager(new LinearLayoutManager(this));
        HantuListAdapter HantuListAdapter = new HantuListAdapter(listHantu);
        rvHantu.setAdapter(HantuListAdapter);
        HantuListAdapter.setOnItemClickCallback(new HantuListAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Hantu data) {
                moveToDetail(data);
            }
        });

    }

    private void moveToDetail(Hantu data) {
        Intent intent = new Intent(MainActivity.this, HantuDetailActivity.class);
        intent.putExtra(HantuDetailActivity.EXTRA_NAME, data.getName());
        intent.putExtra(HantuDetailActivity.EXTRA_ORIGIN, data.getOrigin());
        intent.putExtra(HantuDetailActivity.EXTRA_DESC, data.getDescription());
        intent.putExtra(HantuDetailActivity.EXTRA_IMG, data.getPhoto());
        startActivity(intent);
    }
}
