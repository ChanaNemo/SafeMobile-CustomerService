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
public class TurmsActivity extends Activity {
    ImageView menuBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turms_of_use);

        //menu
        menuBtn=(ImageView)findViewById(R.id.turms_menu);
        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(TurmsActivity.this, menuBtn);
                popup.getMenuInflater().inflate(R.menu.menu, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        //Toast.makeText(CustomerServiceActivity.this,"You Clicked : " + item.getTitle(),Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(TurmsActivity.this, PrivacyActivity.class);
                        switch (item.getItemId()) {
                            case R.id.menu_home:
                                finish();
                                intent = new Intent(TurmsActivity.this, MainActivity.class);
                                startActivity(intent);
                                break;
                            case R.id.menu_custom_service:
                                intent = new Intent(TurmsActivity.this, CustomerServiceActivity.class);
                                startActivity(intent);
                                break;
                            case R.id.menu_privacy:
                                intent = new Intent(TurmsActivity.this, PrivacyActivity.class);
                                startActivity(intent);
                                break;
                            case R.id.menu_turms:

                                break;
                            case R.id.menu_survey:
                                intent = new Intent(TurmsActivity.this, AndroidHTMLActivity.class);
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
        ImageView back=(ImageView)findViewById(R.id.turms_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });





        final WebView myWebView = (WebView) findViewById(R.id.turms_of_use);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.loadUrl("http://www.safemobile.co.il/eula/");



        final MyWebClient myWebViewClient = new MyWebClient();
        myWebView.setWebViewClient(myWebViewClient);

//////////id="fancy-header" - do not display
        ////////id="footer" - do not display
    }

    public class MyWebClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            view.loadUrl("javascript:your javascript");
        }
    }
}
