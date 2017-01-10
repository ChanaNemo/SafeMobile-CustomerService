package com.example.chani.safe_mobile_;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by chani on 26/12/2016.
 */
public class SurveyActivity extends Activity {
    ImageView menuBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surveys);

        //menu
        menuBtn=(ImageView)findViewById(R.id.survey_menu);
        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(SurveyActivity.this, menuBtn);
                popup.getMenuInflater().inflate(R.menu.menu, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        //Toast.makeText(CustomerServiceActivity.this,"You Clicked : " + item.getTitle(),Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(SurveyActivity.this, PrivacyActivity.class);
                        switch (item.getItemId()) {
                            case R.id.menu_home:
                                intent = new Intent(SurveyActivity.this, MainActivity.class);
                                startActivity(intent);
                                break;
                            case R.id.menu_custom_service:
                                intent = new Intent(SurveyActivity.this, CustomerServiceActivity.class);
                                startActivity(intent);
                                break;
                            case R.id.menu_privacy:
                                intent = new Intent(SurveyActivity.this, PrivacyActivity.class);
                                startActivity(intent);
                                break;
                            case R.id.menu_turms:
                                intent = new Intent(SurveyActivity.this, TurmsActivity.class);
                                startActivity(intent);
                                break;
                            case R.id.menu_survey:

                                break;
                        }
                        return true;
                    }
                });
                //set Icons on popup menu
                try {
                    Field[] fields = popup.getClass().getDeclaredFields();
                    for (Field field : fields) {
                        if ("mPopup".equals(field.getName())) {
                            field.setAccessible(true);
                            Object menuPopupHelper = field.get(popup);
                            Class<?> classPopupHelper = Class.forName(menuPopupHelper
                                    .getClass().getName());
                            Method setForceIcons = classPopupHelper.getMethod(
                                    "setForceShowIcon", boolean.class);
                            setForceIcons.invoke(menuPopupHelper, true);
                            break;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                popup.show();
            }
        });


        /*Button back=(Button)findViewById(R.id.survey_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SurveyActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        */

        Button submit=(Button)findViewById(R.id.submit_btn);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = getApplicationContext();
                CharSequence text = "תודה שהשתתפתם בסקר!";
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                Intent intent=new Intent(SurveyActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
