package com.example.chani.safe_mobile_;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.PopupMenu;

import java.lang.reflect.Field;
import java.lang.reflect.Method;


public class AndroidHTMLActivity extends Activity {

    ImageView menuBtn;
    WebView myBrowser;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surveys);

        //menu
        menuBtn = (ImageView) findViewById(R.id.survey_menu);
        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(AndroidHTMLActivity.this, menuBtn);
                popup.getMenuInflater().inflate(R.menu.menu, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        //Toast.makeText(CustomerServiceActivity.this,"You Clicked : " + item.getTitle(),Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(AndroidHTMLActivity.this, PrivacyActivity.class);
                        switch (item.getItemId()) {
                            case R.id.menu_home:
                                finish();
                                intent = new Intent(AndroidHTMLActivity.this, MainActivity.class);
                                intent.putExtra("PreviousUrl", "AndroidHTMLActivity.class");
                                startActivity(intent);
                                break;
                            case R.id.menu_custom_service:
                                intent = new Intent(AndroidHTMLActivity.this, CustomerServiceActivity.class);
                                startActivity(intent);
                                break;
                            case R.id.menu_privacy:
                                intent = new Intent(AndroidHTMLActivity.this, PrivacyActivity.class);
                                startActivity(intent);
                                break;
                            case R.id.menu_turms:
                                intent = new Intent(AndroidHTMLActivity.this, TurmsActivity.class);
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

        //back
        ImageView back = (ImageView) findViewById(R.id.survey_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        myBrowser = (WebView) findViewById(R.id.mybrowser);
        WebSettings webSettings = myBrowser.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myBrowser.setWebViewClient(new WebViewClient());


        //this is the right url!!!
        myBrowser.loadUrl("http://safemobile.mailman.co.il/form.html");


    }


}