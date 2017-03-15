package software.perfekt.weekendbinary.prototype1.android;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends Activity {

    private WebView webView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webactivity);

        webView = (WebView) findViewById(R.id.webView2);
        WebSettings s = webView.getSettings();

        s.setJavaScriptEnabled(true);
        s.setDatabaseEnabled(true);
        s.setLoadsImagesAutomatically(true);
        s.setGeolocationEnabled(true);
        s.setBlockNetworkImage(false);
        s.setBlockNetworkLoads(false);
        s.setJavaScriptCanOpenWindowsAutomatically(true);
        s.setLoadWithOverviewMode(true);

        // --------------------------------------------------------------------
        // SPEED IMPROVEMENTS
        // --------------------------------------------------------------------

        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.setAnimationCacheEnabled(true);
        s.setRenderPriority(WebSettings.RenderPriority.HIGH);
        s.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        s.setAppCacheEnabled(true);
        s.setDomStorageEnabled(true);
        s.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        s.setUseWideViewPort(true);
        s.setLoadsImagesAutomatically(true);
        s.setUseWideViewPort(true);
        if (Build.VERSION.SDK_INT >= 11) {
            s.setEnableSmoothTransition(true);
        }

        /*
            Android 19 has Chromium engine for WebView. I guess it works better with hardware acceleration.
         */
        if (Build.VERSION.SDK_INT >= 19) {
            webView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        } else if (Build.VERSION.SDK_INT >= 11)  {
            /*
                The solution for us was the opposite. We disabled hardware acceleration on the WebView only (rather than on the entire app in the manifest) by using this code:
                CSS3 animations are smoother now. We are using Android 4.0.
             */
            webView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }

        // --------------------------------------------------------------------

        webView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
        }});

        webView.loadUrl("http://188.166.154.140/");

    }

}