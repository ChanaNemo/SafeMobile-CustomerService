package com.example.chani.safe_mobile_;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by chani on 02/01/2017.
 */
public class GetFormActivity extends Activity {
    ImageView menuBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_from);

        Button btn=(Button)findViewById(R.id.next_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(GetFormActivity.this, FormThanksActivity.class);
                startActivity(i);
            }
        });


        //menu
        menuBtn = (ImageView) findViewById(R.id.get_form_menu);
        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(GetFormActivity.this, menuBtn);
                popup.getMenuInflater().inflate(R.menu.menu, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        //Toast.makeText(CustomerServiceActivity.this,"You Clicked : " + item.getTitle(),Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(GetFormActivity.this, PrivacyActivity.class);
                        switch (item.getItemId()) {
                            case R.id.menu_home:
                                finish();
                                intent = new Intent(GetFormActivity.this, MainActivity.class);
                                startActivity(intent);
                                break;
                            case R.id.menu_custom_service:
                                intent = new Intent(GetFormActivity.this, CustomerServiceActivity.class);
                                startActivity(intent);
                                break;
                            case R.id.menu_privacy:
                                intent = new Intent(GetFormActivity.this, PrivacyActivity.class);
                                startActivity(intent);
                                break;
                            case R.id.menu_turms:
                                intent = new Intent(GetFormActivity.this, TurmsActivity.class);
                                startActivity(intent);
                                break;
                            case R.id.menu_survey:
                                intent = new Intent(GetFormActivity.this, AndroidHTMLActivity.class);
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
        ImageView back = (ImageView) findViewById(R.id.get_form_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        TextView name = (TextView) findViewById(R.id.get_name);
        TextView email = (TextView) findViewById(R.id.get_email);
        TextView phone = (TextView) findViewById(R.id.get_phone);
        TextView message = (TextView) findViewById(R.id.get_message);

        Intent form = getIntent();
        Bundle field = form.getExtras();

        if (field != null) {
            String _name = (String) field.get("Name");
            String _email = (String) field.get("Email");
            String _phone = (String) field.get("Type");
            String _message = (String) field.get("Message");
            name.setText(_name.toString());
            email.setText(_email.toString());
            phone.setText(_phone.toString());
            message.setText(_message.toString());
        } else {
            name.setText("no extra");
            email.setText("no extra");
            phone.setText("no extra");
            message.setText("no extra");
        }


    }
}
