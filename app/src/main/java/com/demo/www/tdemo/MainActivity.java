package com.demo.www.tdemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import static com.demo.www.tdemo.R.id.usernameWrapper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText uerName, Password;
    private TextInputLayout userNameWrapper, passwordWrapper;
    private Button btn;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        mContext = this;
        userNameWrapper = (TextInputLayout) findViewById(usernameWrapper);
        passwordWrapper = (TextInputLayout) findViewById(R.id.passwordWrapper);
        userNameWrapper.setHint("UserName");
        passwordWrapper.setHint("Password");

        uerName = (EditText) findViewById(R.id.username);
        Password = (EditText) findViewById(R.id.password);
        hideError(uerName, userNameWrapper);
        hideError(Password, passwordWrapper);

        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn:
                String userName = userNameWrapper.getEditText().getText().toString();
                String password = passwordWrapper.getEditText().getText().toString();

                if (!isEmailValid(userName)) {
                    userNameWrapper.setError("not a valid email");
                } else if (!isPasswordValid(password)) {
                    passwordWrapper.setError("not a valid password");
                } else {
                    hideKeyboard();
                    userNameWrapper.setErrorEnabled(false);
                    passwordWrapper.setErrorEnabled(false);
                    startActivity(new Intent(mContext, ScanerActivity.class));
                    finish();
                }
                break;
            default:
                break;
        }
    }

    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }

    private void hideError(EditText ed, final TextInputLayout ti) {
        ed.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                ti.setErrorEnabled(false);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void hideKeyboard() {
        View view = getCurrentFocus();
        if (view != null) {
            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).
                    hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }
}
