package m.srinivas.wcabs;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Signup extends Activity implements View.OnClickListener {
TextView signin_tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        signin_tv = findViewById(R.id.signin_tv);
        signin_tv.setOnClickListener(this);
    }

    @SuppressLint("NewApi")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.signin_tv:
                Intent login = new Intent(Signup.this,Login.class);
                startActivity(login);
                finish();
                break;
        }
    }
}
