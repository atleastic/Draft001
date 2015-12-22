package com.example.naman.draft001;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private TextInputLayout mIdTextInput,mPasswdTextInput;
    private EditText mUserEditText,mPassEditText;
    private Button mLoginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mIdTextInput=(TextInputLayout)findViewById(R.id.id_textbox);
        mPasswdTextInput=(TextInputLayout)findViewById(R.id.passwd_textbox);
        mUserEditText=(EditText)findViewById(R.id.input_name);
        mPassEditText=(EditText)findViewById(R.id.input_password);
        mLoginButton=(Button)findViewById(R.id.login_go_button);
        //Verify user id and password
        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mUserEditText.getText().toString().equalsIgnoreCase("user")&&mPassEditText.getText().toString().equalsIgnoreCase("pass")){
                    Intent intent=new Intent(MainActivity.this,HomePageActivity.class);
                    startActivity(intent);
                }
                else{
                    mIdTextInput.setError(getString(R.string.error_id));
                    mPasswdTextInput.setError(getString(R.string.error_passwd));
                    requestFocus(mIdTextInput);
                }
            }
        });
       }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
