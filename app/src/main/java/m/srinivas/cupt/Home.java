package m.srinivas.cupt;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toast;

public class Home extends Activity implements View.OnClickListener {
    LinearLayout chats_ll, logout_ll,settings_ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        chats_ll = findViewById(R.id.chats_ll);
        chats_ll.setOnClickListener(this);
        logout_ll = findViewById(R.id.logout_ll);
        logout_ll.setOnClickListener(this);

        settings_ll = findViewById(R.id.settings_ll);
        settings_ll.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
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
        }
    }
}
