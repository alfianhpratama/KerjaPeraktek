package id.alfiandroid.kpsukses;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;


public class DetailActivity extends AppCompatActivity {

    TextView jadwalTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        jadwalTitle = findViewById(R.id.titleDetail);
        jadwalTitle.setText(getIntent().getStringExtra("title"));


    }

    public void info(View view) {
    }
}
