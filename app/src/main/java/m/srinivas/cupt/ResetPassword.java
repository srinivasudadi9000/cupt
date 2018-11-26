package m.srinivas.cupt;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URLEncoder;

public class ResetPassword extends Activity implements View.OnClickListener {

    ImageView back_img;
    TextView header_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resetpassword);

        header_txt = findViewById(R.id.header_txt);
        header_txt.setText("Reset Password");

        back_img = findViewById(R.id.back_img);
        back_img.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.back_img:
                finish();
                break;


        }
    }


}
