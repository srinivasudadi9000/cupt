package m.srinivas.cupt;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Prelogin extends Activity implements View.OnClickListener{
    TextView signup_tv,sign_tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prelogin);

        sign_tv = findViewById(R.id.sign_tv);
        signup_tv = findViewById(R.id.signup_tv);

        signup_tv.setOnClickListener(this);
        sign_tv.setOnClickListener(this);


        SharedPreferences.Editor editor = getSharedPreferences("Profile",MODE_PRIVATE).edit();
        editor.putString("name","srinivasu");
        editor.putString("phonenumber","8885270193");
        editor.commit();

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.sign_tv:
                Intent sign_tv = new Intent(Prelogin.this,Login.class);
                startActivity(sign_tv);

                 break;
            case R.id.signup_tv:
                Intent signup_tv = new Intent(Prelogin.this,Signup.class);
                startActivity(signup_tv);
                break;
        }
    }
}
