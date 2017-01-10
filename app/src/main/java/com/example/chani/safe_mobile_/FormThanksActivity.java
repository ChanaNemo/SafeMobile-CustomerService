package com.example.chani.safe_mobile_;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by chani on 03/01/2017.
 */
public class FormThanksActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_thanks);

        LinearLayout end_thanks=(LinearLayout)findViewById(R.id.thanks);
        end_thanks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(FormThanksActivity.this, MainActivity.class);
                startActivity(i);
                finish();

            }
        });
    }
}
