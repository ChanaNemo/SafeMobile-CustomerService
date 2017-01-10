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

/**
 * Created by chani on 26/12/2016.
 */
public class PrivacyActivity extends Activity {

    ImageView menuBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_policy);

        WebView myWebView = (WebView) findViewById(R.id.privacy_policy);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.loadUrl("http://www.safemobile.co.il/privacy/");

        //menu
        menuBtn=(ImageView)findViewById(R.id.privacy_menu);
        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(PrivacyActivity.this, menuBtn);
                popup.getMenuInflater().inflate(R.menu.menu, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        //Toast.makeText(CustomerServiceActivity.this,"You Clicked : " + item.getTitle(),Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(PrivacyActivity.this, PrivacyActivity.class);
                        switch (item.getItemId()) {
                            case R.id.menu_home:
                                finish();
                                intent = new Intent(PrivacyActivity.this, MainActivity.class);
                                startActivity(intent);
                                break;
                            case R.id.menu_custom_service:
                                intent = new Intent(PrivacyActivity.this, CustomerServiceActivity.class);
                                startActivity(intent);
                                break;
                            case R.id.menu_turms:
                                intent = new Intent(PrivacyActivity.this, TurmsActivity.class);
                                startActivity(intent);
                                break;
                            case R.id.menu_privacy:
                                break;
                            case R.id.menu_survey:
                                intent = new Intent(PrivacyActivity.this, AndroidHTMLActivity.class);
                                startActivity(intent);
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
        ImageView back=(ImageView)findViewById(R.id.privacy_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
