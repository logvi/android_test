package software.perfekt.weekendbinary.prototype1.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.webkit.WebView;
import android.widget.Toast;

public class MainConnectActivity extends Activity {

    private WebView webView;

    private Boolean exit = false;

    @Override
    public void onBackPressed() {
        if (exit) {
            finish();
        } else {
            Toast.makeText(this, "Press Back again to Exit.", Toast.LENGTH_SHORT).show();
            exit = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    exit = false;
                }
            }, 3 * 1000);
        }

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Context context = this;
        Intent intent = new Intent(context, WebActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

}
