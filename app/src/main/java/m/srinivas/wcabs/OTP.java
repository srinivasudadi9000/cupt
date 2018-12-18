package m.srinivas.wcabs;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class OTP extends Activity implements View.OnClickListener {
    TextView header_txt;
    ImageView back_img;
    Button next_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.otp);
        header_txt = findViewById(R.id.header_txt);
        header_txt.setText("Mobile Verification");
        back_img = findViewById(R.id.back_img);
        back_img.setOnClickListener(this);
        next_btn = findViewById(R.id.next_btn);
        next_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_img:
                finish();
                break;
            case R.id.next_btn:
                Intent homw = new Intent(OTP.this,Home.class);
                startActivity(homw);
                break;
        }
    }
}
