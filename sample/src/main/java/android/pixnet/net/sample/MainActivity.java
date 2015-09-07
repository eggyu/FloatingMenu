package android.pixnet.net.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((FloatingView) findViewById(R.id.FLV)).setOnItemClickListener(new FloatingView.OnItemClickListener() {
            @Override
            public void onClick(View v, int child) {
                Toast.makeText(MainActivity.this, "is click " + Integer.toString(child), Toast.LENGTH_SHORT).show();
            }
        });
    }


}
