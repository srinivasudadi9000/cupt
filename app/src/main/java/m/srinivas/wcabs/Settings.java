package m.srinivas.wcabs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Settings extends Activity implements View.OnClickListener {
    TextView vehicle_txt, device_txt, account_txt, payment_txt, support_txt,header_txt;
    ImageView back_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        support_txt = findViewById(R.id.support_txt);
        payment_txt = findViewById(R.id.payment_txt);
        account_txt = findViewById(R.id.account_txt);
        device_txt = findViewById(R.id.device_txt);
        vehicle_txt = findViewById(R.id.vehicle_txt);

        payment_txt.setOnClickListener(this);
        account_txt.setOnClickListener(this);
        vehicle_txt.setOnClickListener(this);
        device_txt.setOnClickListener(this);
        support_txt.setOnClickListener(this);

        header_txt = findViewById(R.id.header_txt);
        header_txt.setText("Help");

        back_img = findViewById(R.id.back_img);
        back_img.setOnClickListener(this);


    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.vehicle_txt:

                break;


            case R.id.device_txt:


                break;

            case R.id.account_txt:

                break;
            case R.id.payment_txt:
                break;
            case R.id.support_txt:
                break;

            case R.id.back_img:
                finish();
                break;

        }
    }



    ;
}
