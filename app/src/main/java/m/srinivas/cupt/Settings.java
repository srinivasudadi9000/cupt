package m.srinivas.cupt;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

public class Settings extends Activity implements View.OnClickListener {
   TextView resetpassword_cv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        resetpassword_cv = findViewById(R.id.resetpassword_cv);
        resetpassword_cv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.resetpassword_cv:
                Intent resetpassword_cv = new Intent(Settings.this,ResetPassword.class);
                startActivity(resetpassword_cv);
                break;
        }
    }
}
