package m.srinivas.cupt;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toast;

import static android.content.ContentValues.TAG;

public class Home extends Activity implements View.OnClickListener {
    LinearLayout chats_ll, logout_ll, settings_ll, gallery_ll, share_ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        chats_ll = findViewById(R.id.chats_ll);
        chats_ll.setOnClickListener(this);
        logout_ll = findViewById(R.id.logout_ll);
        logout_ll.setOnClickListener(this);

        share_ll = findViewById(R.id.share_ll);
        share_ll.setOnClickListener(this);

        settings_ll = findViewById(R.id.settings_ll);
        settings_ll.setOnClickListener(this);

        gallery_ll = findViewById(R.id.gallery_ll);
        gallery_ll.setOnClickListener(this);

        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.CAMERA,
                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    android.Manifest.permission.ACCESS_COARSE_LOCATION, android.Manifest.permission.ACCESS_FINE_LOCATION,
                    android.Manifest.permission.ACCESS_NETWORK_STATE}, 0);
        }

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Log.v(TAG, "Permission: " + permissions[0] + "was " + grantResults[0]);
            //resume tasks needing this permission
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.gallery_ll:
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://media/internal/images/media"));
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), 123);

                break;
            case R.id.chats_ll:
                Intent chats = new Intent(Home.this, Chathome.class);
                startActivity(chats);
                break;

            case R.id.logout_ll:
                finish();
                break;

            case R.id.settings_ll:
                Intent settings = new Intent(Home.this, Settings.class);
                startActivity(settings);
                break;
            case R.id.share_ll:

                try {
                    Intent i = new Intent(Intent.ACTION_SEND);
                    i.setType("text/plain");
                    i.putExtra(Intent.EXTRA_SUBJECT, "My application name");
                    String sAux = "\nLet me recommend you this application\n\n";
                    sAux = sAux + "https://play.google.com/store/apps/details?id=the.package.id \n\n";
                    i.putExtra(Intent.EXTRA_TEXT, sAux);
                    startActivity(Intent.createChooser(i, "choose one"));
                } catch (Exception e) {
                    //e.toString();
                }
                break;


        }
    }
}
