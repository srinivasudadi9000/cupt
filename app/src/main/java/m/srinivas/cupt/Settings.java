package m.srinivas.cupt;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static android.content.ContentValues.TAG;

public class Settings extends Activity implements View.OnClickListener {
    TextView changeno_txt, resetpassword_cv, clearchat_id, delete_txt, header_txt;
    ImageView back_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        delete_txt = findViewById(R.id.delete_txt);
        clearchat_id = findViewById(R.id.clearchat_id);
        resetpassword_cv = findViewById(R.id.resetpassword_cv);
        changeno_txt = findViewById(R.id.changeno_txt);

        delete_txt.setOnClickListener(this);
        clearchat_id.setOnClickListener(this);
        resetpassword_cv.setOnClickListener(this);
        changeno_txt.setOnClickListener(this);

        header_txt = findViewById(R.id.header_txt);
        header_txt.setText("Account Settings");

        back_img = findViewById(R.id.back_img);
        back_img.setOnClickListener(this);


    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.resetpassword_cv:
                Intent resetpassword_cv = new Intent(Settings.this, ResetPassword.class);
                startActivity(resetpassword_cv);
                break;

            case R.id.changeno_txt:
                Intent changeno = new Intent(Settings.this, ChangeNumber.class);
                startActivity(changeno);
                break;

            case R.id.clearchat_id:


                break;

            case R.id.delete_txt:
                Intent delete_txt = new Intent(Settings.this, Login.class);
                startActivity(delete_txt);
                break;

            case R.id.back_img:
                finish();
                break;

        }
    }



    ;
}
