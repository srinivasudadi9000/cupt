package m.srinivas.cupt;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URLEncoder;

public class Login extends Activity implements View.OnClickListener {
    TextView signup_tv, forgot_password;

    Button sign_btn_call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        signup_tv = findViewById(R.id.signup_tv);
        signup_tv.setOnClickListener(this);

        sign_btn_call = findViewById(R.id.sign_btn_call);
        sign_btn_call.setOnClickListener(this);

        forgot_password = findViewById(R.id.forgot_password);
        forgot_password.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.forgot_password:
                //openWhatsApp("7****");

                Intent whatsappIntent = new Intent(Intent.ACTION_SEND);
                whatsappIntent.setType("text/plain");
                whatsappIntent.setPackage("com.whatsapp");
                whatsappIntent.putExtra(Intent.EXTRA_TEXT, "The text you wanted to share");
                try {
                    startActivity(whatsappIntent);
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(Login.this, "Whatsapp have not been installed.",
                            Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.signup_tv:
                Intent signup_tv = new Intent(Login.this, Signup.class);
                startActivity(signup_tv);
                finish();


                // openWhatsApp("+91 9948777449");
                break;

            case R.id.sign_btn_call:
                //openWhatsApp("+91 7032224366");
                Intent home = new Intent(Login.this, Home.class);
                startActivity(home);
                break;
        }
    }


    private void openWhatsApp(String phone) {
        String smsNumber = phone; // E164 format without '+' sign
        /* */

        PackageManager packageManager = Login.this.getPackageManager();
        Intent i = new Intent(Intent.ACTION_VIEW);

        try {
            String url = "https://api.whatsapp.com/send?phone=" + smsNumber + "&text=" + URLEncoder.encode("hello", "UTF-8");
            i.setPackage("com.whatsapp");
            i.setData(Uri.parse(url));
            if (i.resolveActivity(packageManager) != null) {
                startActivity(i);
            }
        } catch (Exception e) {
            e.printStackTrace();

            Intent sendIntent = new Intent(Intent.ACTION_SEND);
            sendIntent.setType("text/plain");
            sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
            sendIntent.putExtra("jid", smsNumber + "@s.whatsapp.net"); //phone number without "+" prefix
            sendIntent.setPackage("com.whatsapp");
            startActivity(sendIntent);


        }
    }

}
