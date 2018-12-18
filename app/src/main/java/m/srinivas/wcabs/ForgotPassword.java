package m.srinivas.wcabs;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ForgotPassword extends Activity implements View.OnClickListener {

    ImageView back_img;
    TextView header_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgotpassword);

        header_txt = findViewById(R.id.header_txt);
        header_txt.setText("Forgot Password");

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
