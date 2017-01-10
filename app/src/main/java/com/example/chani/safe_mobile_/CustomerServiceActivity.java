package com.example.chani.safe_mobile_;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by chani on 01/01/2017.
 */
public class CustomerServiceActivity extends Activity{
    ImageView menuBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customers_service);

        //menu
        menuBtn=(ImageView)findViewById(R.id.customer_menu);
        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(CustomerServiceActivity.this, menuBtn);
                popup.getMenuInflater().inflate(R.menu.menu, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        //Toast.makeText(CustomerServiceActivity.this,"You Clicked : " + item.getTitle(),Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(CustomerServiceActivity.this, PrivacyActivity.class);
                        switch (item.getItemId()) {
                            case R.id.menu_home:
                                finish();
                                intent = new Intent(CustomerServiceActivity.this, MainActivity.class);
                                startActivity(intent);
                                break;
                            case R.id.menu_custom_service:

                                break;
                            case R.id.menu_privacy:
                                intent = new Intent(CustomerServiceActivity.this, PrivacyActivity.class);
                                startActivity(intent);
                                break;
                            case R.id.menu_turms:
                                intent = new Intent(CustomerServiceActivity.this, TurmsActivity.class);
                                startActivity(intent);
                                break;
                            case R.id.menu_survey:
                                intent = new Intent(CustomerServiceActivity.this, AndroidHTMLActivity.class);
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
        ImageView back=(ImageView)findViewById(R.id.customer_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //open form
        LinearLayout oprnForm=(LinearLayout)findViewById(R.id.open_form);
        oprnForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CustomerServiceActivity.this,ServiceFormActivity.class);
                startActivity(i);
            }
        });

        //1
        final LinearLayout question1=(LinearLayout)findViewById(R.id.q_1);
        final TextView answer1=(TextView)findViewById(R.id.a_1);
        question1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer1.getVisibility()==View.GONE)
                {
                    ResetQuestion();
                    answer1.setVisibility(View.VISIBLE);
                    question1.setBackgroundColor(getResources().getColor(R.color.Gray_SafeMobile));
                }
                else {
                    answer1.setVisibility(View.GONE);
                    question1.setBackgroundColor(getResources().getColor(R.color.White));
                }
            }
        });


        //2
        final LinearLayout question2=(LinearLayout)findViewById(R.id.q_2);
        final TextView answer2=(TextView)findViewById(R.id.a_2);
        question2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer2.getVisibility()==View.GONE)
                {
                    ResetQuestion();
                    answer2.setVisibility(View.VISIBLE);
                    question2.setBackgroundColor(getResources().getColor(R.color.Gray_SafeMobile));
                }
                else {
                    answer2.setVisibility(View.GONE);
                    question2.setBackgroundColor(getResources().getColor(R.color.White));
                }
            }
        });

        //3
        final LinearLayout question3=(LinearLayout)findViewById(R.id.q_3);
        final TextView answer3=(TextView)findViewById(R.id.a_3);
        question3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer3.getVisibility()==View.GONE)
                {
                    ResetQuestion();
                    answer3.setVisibility(View.VISIBLE);
                    question3.setBackgroundColor(getResources().getColor(R.color.Gray_SafeMobile));
                }
                else {
                    answer3.setVisibility(View.GONE);
                    question3.setBackgroundColor(getResources().getColor(R.color.White));
                }
            }
        });

        //4
        final LinearLayout question4=(LinearLayout)findViewById(R.id.q_4);
        final TextView answer4=(TextView)findViewById(R.id.a_4);
        question4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer4.getVisibility()==View.GONE)
                {
                    ResetQuestion();
                    answer4.setVisibility(View.VISIBLE);
                    question4.setBackgroundColor(getResources().getColor(R.color.Gray_SafeMobile));
                }
                else {
                    answer4.setVisibility(View.GONE);
                    question4.setBackgroundColor(getResources().getColor(R.color.White));
                }
            }
        });

        //5
        final LinearLayout question5=(LinearLayout)findViewById(R.id.q_5);
        final TextView answer5=(TextView)findViewById(R.id.a_5);
        question5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer5.getVisibility()==View.GONE)
                {
                    ResetQuestion();
                    answer5.setVisibility(View.VISIBLE);
                    question5.setBackgroundColor(getResources().getColor(R.color.Gray_SafeMobile));
                }
                else {
                    answer5.setVisibility(View.GONE);
                    question5.setBackgroundColor(getResources().getColor(R.color.White));
                }
            }
        });

        //6
        final LinearLayout question6=(LinearLayout)findViewById(R.id.q_6);
        final TextView answer6=(TextView)findViewById(R.id.a_6);
        question6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer6.getVisibility()==View.GONE)
                {
                    ResetQuestion();
                    answer6.setVisibility(View.VISIBLE);
                    question6.setBackgroundColor(getResources().getColor(R.color.Gray_SafeMobile));
                }
                else {
                    answer6.setVisibility(View.GONE);
                    question6.setBackgroundColor(getResources().getColor(R.color.White));
                }
            }
        });

        //7
        final LinearLayout question7=(LinearLayout)findViewById(R.id.q_7);
        final TextView answer7=(TextView)findViewById(R.id.a_7);
        question7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer7.getVisibility()==View.GONE)
                {
                    ResetQuestion();
                    answer7.setVisibility(View.VISIBLE);
                    question7.setBackgroundColor(getResources().getColor(R.color.Gray_SafeMobile));
                }
                else {
                    answer7.setVisibility(View.GONE);
                    question7.setBackgroundColor(getResources().getColor(R.color.White));
                }
            }
        });

        //8
        final LinearLayout question8=(LinearLayout)findViewById(R.id.q_8);
        final TextView answer8=(TextView)findViewById(R.id.a_8);
        question8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer8.getVisibility()==View.GONE)
                {
                    ResetQuestion();
                    answer8.setVisibility(View.VISIBLE);
                    question8.setBackgroundColor(getResources().getColor(R.color.Gray_SafeMobile));
                }
                else {
                    answer8.setVisibility(View.GONE);
                    question8.setBackgroundColor(getResources().getColor(R.color.White));
                }
            }
        });
    }

    public void ResetQuestion(){
        TextView tv;
        LinearLayout ll;
        //1
        ll = (LinearLayout)findViewById(R.id.q_1);
        ll.setBackgroundColor(getResources().getColor(R.color.White));
        tv=(TextView)findViewById(R.id.a_1);
        tv.setVisibility(View.GONE);
        //2
        ll = (LinearLayout)findViewById(R.id.q_2);
        ll.setBackgroundColor(getResources().getColor(R.color.White));
        tv=(TextView)findViewById(R.id.a_2);
        tv.setVisibility(View.GONE);
        //3
        ll = (LinearLayout)findViewById(R.id.q_3);
        ll.setBackgroundColor(getResources().getColor(R.color.White));
        tv=(TextView)findViewById(R.id.a_3);
        tv.setVisibility(View.GONE);
        //4
        ll = (LinearLayout)findViewById(R.id.q_4);
        ll.setBackgroundColor(getResources().getColor(R.color.White));
        tv=(TextView)findViewById(R.id.a_4);
        tv.setVisibility(View.GONE);
        //5
        ll = (LinearLayout)findViewById(R.id.q_5);
        ll.setBackgroundColor(getResources().getColor(R.color.White));
        tv=(TextView)findViewById(R.id.a_5);
        tv.setVisibility(View.GONE);
        //6
        ll = (LinearLayout)findViewById(R.id.q_6);
        ll.setBackgroundColor(getResources().getColor(R.color.White));
        tv=(TextView)findViewById(R.id.a_6);
        tv.setVisibility(View.GONE);
        //7
        ll = (LinearLayout)findViewById(R.id.q_7);
        ll.setBackgroundColor(getResources().getColor(R.color.White));
        tv=(TextView)findViewById(R.id.a_7);
        tv.setVisibility(View.GONE);
        //8
        ll = (LinearLayout)findViewById(R.id.q_8);
        ll.setBackgroundColor(getResources().getColor(R.color.White));
        tv=(TextView)findViewById(R.id.a_8);
        tv.setVisibility(View.GONE);
    }
}

