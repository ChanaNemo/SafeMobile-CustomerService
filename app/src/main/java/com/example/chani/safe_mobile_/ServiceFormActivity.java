package com.example.chani.safe_mobile_;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.example.chani.safe_mobile_.R.drawable;
import static com.example.chani.safe_mobile_.R.id;
import static com.example.chani.safe_mobile_.R.layout;
import static com.example.chani.safe_mobile_.R.string;
import static com.example.chani.safe_mobile_.R.string.edit_msg_;
import static com.example.chani.safe_mobile_.R.string.edit_msg_continue;
import static com.example.chani.safe_mobile_.R.string.edit_msg_no;
import static com.example.chani.safe_mobile_.R.string.err_all;
import static com.example.chani.safe_mobile_.R.string.err_email;
import static com.example.chani.safe_mobile_.R.string.err_invalid_email;
import static com.example.chani.safe_mobile_.R.string.err_message;
import static com.example.chani.safe_mobile_.R.string.err_name;
import static com.example.chani.safe_mobile_.R.string.err_type;
import static com.example.chani.safe_mobile_.R.string.helo;
import static com.example.chani.safe_mobile_.R.string.message_email;
import static com.example.chani.safe_mobile_.R.string.message_from;
import static com.example.chani.safe_mobile_.R.string.message_message;
import static com.example.chani.safe_mobile_.R.string.message_type;
import static com.example.chani.safe_mobile_.R.string.new_message;
import static com.example.chani.safe_mobile_.R.string.service;
import static com.example.chani.safe_mobile_.R.string.service_sessage;
import static com.example.chani.safe_mobile_.R.string.spinner_type0;
import static com.example.chani.safe_mobile_.R.string.spinner_type1;
import static com.example.chani.safe_mobile_.R.string.spinner_type2;
import static com.example.chani.safe_mobile_.R.string.spinner_type3;
import static com.example.chani.safe_mobile_.R.string.spinner_type4;
import static com.example.chani.safe_mobile_.R.string.spinner_type5;

/**
 * Created by chani on 02/01/2017.
 */
public class ServiceFormActivity extends Activity {
    ImageView menuBtn;
    String call_type;
    LinearLayout send;
    GMailSender sender;
    public EditText f_name;
    EditText f_email;
    public String f_type;
    EditText f_message;
    public String e_name;
    public String e_email;
    public String e_message;
    Spinner type_dropdown;
    boolean isType;
    FrameLayout spinner_background;

    @SuppressLint("NewApi")
    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_service_form);
        call_type = "";
        isType = false;

        f_name = (EditText) findViewById(id.form_name);
        f_email = (EditText) findViewById(id.form_email);
        f_type = call_type;
        spinner_background = (FrameLayout) findViewById(id.spinner_background);
        f_message = (EditText) findViewById(id.form_message);

        /*
        //menu
        menuBtn = (ImageView) findViewById(id.form_menu);
        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(ServiceFormActivity.this, menuBtn);
                popup.getMenuInflater().inflate(menu.menu, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        //Toast.makeText(CustomerServiceActivity.this,"You Clicked : " + item.getTitle(),Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(ServiceFormActivity.this, PrivacyActivity.class);
                        switch (item.getItemId()) {
                            case id.menu_home:
                                intent = new Intent(ServiceFormActivity.this, MainActivity.class);
                                startActivity(intent);
                                break;
                            case id.menu_custom_service:
                                intent = new Intent(ServiceFormActivity.this, CustomerServiceActivity.class);
                                startActivity(intent);
                                break;
                            case id.menu_privacy:
                                intent = new Intent(ServiceFormActivity.this, PrivacyActivity.class);
                                startActivity(intent);
                                break;
                            case id.menu_turms:
                                intent = new Intent(ServiceFormActivity.this, TurmsActivity.class);
                                startActivity(intent);
                                break;
                            case id.menu_survey:
                                intent = new Intent(ServiceFormActivity.this, AndroidHTMLActivity.class);
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
*/

        //back
        ImageView back = (ImageView) findViewById(id.form_back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (f_name.getText().length() != 0 || f_email.getText().length() != 0 || call_type.length() != 0 || f_message.getText().length() != 0) {
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(ServiceFormActivity.this);
                    builder1.setMessage(edit_msg_);
                    builder1.setCancelable(true);

                    builder1.setPositiveButton(
                            edit_msg_continue,
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });

                    builder1.setNegativeButton(
                            edit_msg_no,
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    finish();
                                    dialog.cancel();
                                }
                            });

                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                } else
                    finish();

            }
        });

        //fill type drop down
        type_dropdown = (Spinner) findViewById(id.form_type);
        String[] items = new String[]{
                getString(spinner_type0),
                getString(spinner_type1),
                getString(spinner_type2),
                getString(spinner_type3),
                getString(spinner_type4),
                getString(spinner_type5)};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        type_dropdown.setAdapter(adapter);
        type_dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                View v = view;

                TextView tv = (TextView) v;
                if (position == 0) {
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                } else {
                    tv.setTextColor(Color.BLACK);
                }
                if (position > 0) {
                    isType = true;
                    call_type = (String) parent.getItemAtPosition(position);
                } else {
                    isType = false;
                    call_type = "";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //type_dropdown.set

        sender = new GMailSender("chana.nemo@gmail.com", "chana8859");

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.
                Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
        //send form
        send = (LinearLayout) findViewById(id.form_send_btn);
        send.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                ResetBorder();

                if(InputValidation()){

                    // Send the message
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(ServiceFormActivity.this);
                    builder1.setMessage(e_name + ", " + e_email + ", " + " " + e_message);
                    builder1.setTitle(R.string.send_msg);
                    builder1.setCancelable(true);
                    builder1.setPositiveButton(
                            "שלח",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                    try {
                                        new MyAsyncClass().execute();

                                    } catch (Exception ex) {
                                        Toast.makeText(getApplicationContext(), ex.toString(), Toast.LENGTH_LONG).show();
                                    }
                                }
                            });

                    builder1.setNegativeButton(
                            "חזור לעריכה",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });

                    AlertDialog alert11 = builder1.show();
                    alert11.show();
                }

            }
        });// send.onClick

    }//onCreate

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public boolean InputValidation() {

        e_name = "";
        e_email = "";
        e_name = f_name.getText().toString();
        e_email = f_email.getText().toString();
        f_type = call_type;
        e_message = f_message.getText().toString();

        boolean isAll = false;

        //check Name validation
        if (f_name.getText().length() == 0) {
            {
                f_name.setBackground(getDrawable(drawable.round_white_input_error));
                isAll = false;
            }
            //email
            if (f_email.getText().length() == 0 || !isValidEmail(f_email.getText().toString())) {
                f_email.setBackground(getDrawable(drawable.round_white_input_error));
                isAll = true;
            }
            // call type
            if (!isType) {
                spinner_background.setBackground(getDrawable(drawable.round_white_input_error));
                isAll = true;
            }
            //message
            if (f_message.getText().length() == 0) {
                f_message.setBackground(getDrawable(drawable.round_white_input_error));
                isAll = true;
            }
            if (!isAll)
                Toast.makeText(getApplicationContext(), err_name, Toast.LENGTH_LONG).show();
            else
                Toast.makeText(getApplicationContext(), err_all, Toast.LENGTH_LONG).show();
        }
        //check Email validation
        else if (f_email.getText().length() == 0 || !isValidEmail(f_email.getText().toString())) {
            f_email.setBackground(getDrawable(drawable.round_white_input_error));
            isAll = false;
            //call type
            if (!isType) {
                spinner_background.setBackground(getDrawable(drawable.round_white_input_error));
                isAll = true;
            }//message
            if (f_message.getText().length() == 0) {
                f_message.setBackground(getDrawable(drawable.round_white_input_error));
                isAll = true;
            }
            if (!isAll) {
                if (f_email.getText().length() == 0)
                    Toast.makeText(getApplicationContext(), err_email, Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getApplicationContext(), err_invalid_email, Toast.LENGTH_LONG).show();
            } else
                Toast.makeText(getApplicationContext(), err_all, Toast.LENGTH_LONG).show();
        }
        // check Call Type validation
        else if (!isType) {
            spinner_background.setBackground(getDrawable(drawable.round_white_input_error));
            isAll = false;
            // message
            if (f_message.getText().length() == 0) {
                f_message.setBackground(getDrawable(drawable.round_white_input_error));
                isAll = true;
            }
            if (!isAll)
                Toast.makeText(getApplicationContext(), err_type, Toast.LENGTH_LONG).show();
            else
                Toast.makeText(getApplicationContext(), err_all, Toast.LENGTH_LONG).show();
        }
        // check Message validation
        else if (f_message.getText().length() == 0) {
            f_message.setBackground(getDrawable(drawable.round_white_input_error));
            Toast.makeText(getApplicationContext(), err_message, Toast.LENGTH_LONG).show();
        } else {
            return true;
        }

        return false;
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void ResetBorder() {
        f_name.setBackground(getDrawable(drawable.round_white_input));
        f_email.setBackground(getDrawable(drawable.round_white_input));
        spinner_background.setBackground(getDrawable(drawable.round_white_input));
        f_message.setBackground(getDrawable(drawable.round_white_input));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it          //     is present.
        // getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    class MyAsyncClass extends AsyncTask<Void, Void, Void> {

        ProgressDialog pDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            pDialog = new ProgressDialog(ServiceFormActivity.this);
            pDialog.setMessage(getString(string.please_waite));
            pDialog.show();

        }

        @Override
        protected Void doInBackground(Void... mApi) {
            try {

                // Add subject, Body, your mail Id, and receiver mail Id.
                sender.sendMail(" " + getText(new_message) + " " + e_name,
                        getText(message_from) + " " + e_name + ", " + getText(message_email) + " " + e_email +
                                ", " + getText(message_type) + " " + call_type + ", " + getText(message_message) + " " + e_message,
                        "chana.nemo@gmail.com",
                        "chana.nemo@gmail.com");
                //send email to customer
                sender.sendMail(getText(service).toString(),
                        getText(helo) + " " + e_name + ", " + getText(service_sessage),
                        "chana.nemo@gmail.com",
                        e_email);
                /*
                // testing
                sender.sendMail(" " + getText(R.string.new_message) + " " + e_name,
                        getText(R.string.message_from) + " " + e_name + ", " + getText(R.string.message_email) + " " + e_email +
                                ", " + getText(R.string.message_type) + " " + call_type + ", " + getText(R.string.message_message) + " " + e_message,
                        "chana.nemo@gmail.com",
                        "chana.nemo@gmail.com");
                        */
            } catch (Exception ex) {

            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            pDialog.cancel();
            // Toast.makeText(getApplicationContext(), "Email Sent", Toast.LENGTH_LONG).show();


            Intent i = new Intent(ServiceFormActivity.this, FormThanksActivity.class);
            startActivity(i);
        }
    }

    public boolean isValidEmail(String email) {
        boolean isValidEmail = false;

        String emailExpression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(emailExpression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValidEmail = true;
        }
        return isValidEmail;
    }

}
