package eu.discordlistforbotsdevel.browser;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import androidx.constraintlayout.utils.widget.ImageFilterButton;

public class MainActivity extends Activity {

    EditText URLText;
    ImageFilterButton GoButton;
    WebView Browser;
    ImageFilterButton AppSettings;
    ImageFilterButton Home;
    Button GoBack;
    Button Update;


    private static class MyWebViewClient extends WebViewClient implements OnClickListener {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onClick(View v) {

        }
    }


    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        URLText = (EditText)findViewById(R.id.editText1);
        GoButton = (ImageFilterButton) findViewById(R.id.button1);
        Browser = (WebView)findViewById(R.id.webView1);
        AppSettings = (ImageFilterButton)findViewById(R.id.settings);
        Home = (ImageFilterButton)findViewById(R.id.gohome);
        GoBack = (Button)findViewById(R.id.goBack);
        Update = (Button)findViewById(R.id.update);


        if (Browser.canGoBack()) {
            Browser.goBack();
        }



        Browser.loadUrl("https://www.google.com");

        Browser.getSettings().setJavaScriptEnabled(true);
        Browser.getSettings().setAppCacheEnabled(true);
        Browser.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        Browser.getSettings().setSupportZoom(true);
        Browser.getSettings().supportMultipleWindows();


        GoButton.setOnClickListener(v -> {
            Browser.setWebViewClient(new MyWebViewClient());
            Browser.loadUrl("https://"+URLText.getText().toString());
        });

        Home.setOnClickListener(v -> {
            Browser.setWebViewClient(new MyWebViewClient());
            Browser.loadUrl("https://google.com");
        });

        AppSettings.setOnClickListener(v -> setContentView(R.layout.settings));
        // Browser.setOnClickListener(v -> setContentView(R.layout.settings));

    }

    @Override
    public void onBackPressed() {
        if(Browser.canGoBack()) {
            Browser.goBack();
        }
        else {
            finish();
        }
    }
}
