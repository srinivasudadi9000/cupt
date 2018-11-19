package m.srinivas.cupt;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Signup extends Activity implements View.OnClickListener {
    TextView signup_tv, user_tv, admin_tv;
    EditText drivinglicence_et, emailid_et;
    TextInputLayout driving_til, emailid_til;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        emailid_et = findViewById(R.id.emailid_et);
        drivinglicence_et = findViewById(R.id.drivinglicence_et);
        user_tv = findViewById(R.id.user_tv);
        admin_tv = findViewById(R.id.admin_tv);
        driving_til = findViewById(R.id.driving_til);
        emailid_til = findViewById(R.id.emailid_til);
        admin_tv.setOnClickListener(this);
        user_tv.setOnClickListener(this);
    }

    @SuppressLint("NewApi")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.user_tv:

                if (user_tv.getBackground().equals(getResources().getDrawable(R.drawable.greenleftbutton))) {
                    user_tv.setBackground(getResources().getDrawable(R.drawable.whiteleftbutton));
                    user_tv.setTextColor(getResources().getColor(R.color.black));
                    admin_tv.setBackground(getResources().getDrawable(R.drawable.greenrightbutton));
                    admin_tv.setTextColor(getResources().getColor(R.color.white));

                } else {
                    user_tv.setBackground(getResources().getDrawable(R.drawable.greenleftbutton));
                    user_tv.setTextColor(getResources().getColor(R.color.white));
                    admin_tv.setBackground(getResources().getDrawable(R.drawable.whiterightbutton));
                    admin_tv.setTextColor(getResources().getColor(R.color.black));
                }


                if (drivinglicence_et.getVisibility() == View.VISIBLE) {
                    driving_til.setVisibility(View.GONE);
                    emailid_til.setVisibility(View.VISIBLE);
                } else {
                    driving_til.setVisibility(View.VISIBLE);
                    emailid_til.setVisibility(View.GONE);
                }
                break;
            case R.id.admin_tv:

                if (admin_tv.getBackground().equals(getResources().getDrawable(R.drawable.whiterightbutton))) {
                    admin_tv.setBackground(getResources().getDrawable(R.drawable.greenrightbutton));
                    admin_tv.setTextColor(getResources().getColor(R.color.white));
                    user_tv.setBackground(getResources().getDrawable(R.drawable.whiteleftbutton));
                    user_tv.setTextColor(getResources().getColor(R.color.black));

                } else {
                    admin_tv.setBackground(getResources().getDrawable(R.drawable.greenrightbutton));
                    admin_tv.setTextColor(getResources().getColor(R.color.white));
                    user_tv.setBackground(getResources().getDrawable(R.drawable.whiteleftbutton));
                    user_tv.setTextColor(getResources().getColor(R.color.black));
                }

                if (drivinglicence_et.getVisibility() == View.VISIBLE) {
                    driving_til.setVisibility(View.VISIBLE);
                    emailid_til.setVisibility(View.GONE);
                } else {
                    emailid_til.setVisibility(View.VISIBLE);
                    driving_til.setVisibility(View.GONE);
                }


                break;

        }
    }
}
