package com.example.chani.safe_mobile_;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        LinearLayout openPrivacy=(LinearLayout)findViewById(R.id.privacy);
        openPrivacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PrivacyActivity.class);
                startActivity(intent);
            }
        });

        LinearLayout openTurms=(LinearLayout)findViewById(R.id.turms);
        openTurms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TurmsActivity.class);
                startActivity(intent);
            }
        });

        LinearLayout openHtml=(LinearLayout)findViewById(R.id.html);
        openHtml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AndroidHTMLActivity.class);
                startActivity(intent);
              //  Intent intent = new Intent(MainActivity.this, AndroidHTMLActivity.class);
                //startActivity(intent);
            }
        });

        LinearLayout openCustomer=(LinearLayout)findViewById(R.id.customers);
        openCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CustomerServiceActivity.class);
                startActivity(intent);
            }
        });
    }

}
