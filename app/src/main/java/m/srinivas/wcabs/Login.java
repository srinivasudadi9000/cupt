package m.srinivas.wcabs;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

import java.net.URLEncoder;

import static android.support.constraint.Constraints.TAG;

public class Login extends Activity implements View.OnClickListener {
    TextView signup_tv, forgot_password;
    SignInButton sign_in_button;
    Button sign_btn_call;
    GoogleSignInClient mGoogleSignInClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        signup_tv = findViewById(R.id.signup_tv);
        signup_tv.setOnClickListener(this);
        sign_in_button = (SignInButton) findViewById(R.id.sign_in_button);
        sign_in_button.setOnClickListener(this);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
          mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        sign_btn_call = findViewById(R.id.sign_btn_call);
        sign_btn_call.setOnClickListener(this);

        forgot_password = findViewById(R.id.forgot_password);
        forgot_password.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sign_in_button:
                signIn();
                break;
            case R.id.forgot_password:
                //openWhatsApp("7****");

                Intent ForgotPassword = new Intent(Login.this, ForgotPassword.class);
                startActivity(ForgotPassword);
                finish();


                break;
            case R.id.signup_tv:
                Intent signup_tv = new Intent(Login.this, Signup.class);
                startActivity(signup_tv);
                finish();


                // openWhatsApp("+91 9948777449");
                break;

            case R.id.sign_btn_call:
                //openWhatsApp("+91 7032224366");
                Intent home = new Intent(Login.this, OTP.class);
                startActivity(home);
                break;
        }
    }
    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, 100);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == 100) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);

            // Signed in successfully, show authenticated UI.
           // updateUI(account);
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w(TAG, "signInResult:failed code=" + e.getStatusCode());
           // updateUI(null);
        }
    }

}
