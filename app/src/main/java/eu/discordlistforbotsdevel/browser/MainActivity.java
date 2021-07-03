package eu.discordlistforbotsdevel.browser;

import androidx.constraintlayout.utils.widget.ImageFilterButton;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.webkit.WebView;
import android.widget.Button;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;


public class MainActivity extends Activity {

    EditText URLText;
    ImageFilterButton GoButton;
    WebView Browser;
    ImageFilterButton AppSettings;
    ImageFilterButton Home;


    String androidAppVersion = "1.1";

    private class MyWebViewClient extends WebViewClient implements OnClickListener {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onClick(View v) {

        }
   }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        URLText = (EditText)findViewById(R.id.editText1);
        GoButton = (ImageFilterButton) findViewById(R.id.button1);
        Browser = (WebView)findViewById(R.id.webView1);
        AppSettings = (ImageFilterButton)findViewById(R.id.settings);
        Home = (ImageFilterButton)findViewById(R.id.gohome);

        Browser.loadUrl("https://www.google.com");

        Browser.getSettings().setJavaScriptEnabled(true);
        Browser.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        Browser.getSettings().setSupportZoom(true);
        Browser.getSettings().supportMultipleWindows();


        GoButton.setOnClickListener(v -> {
            Browser.setWebViewClient(new MyWebViewClient());
            Browser.loadUrl("https://"+URLText.getText().toString());
        });


        /* AppSettings.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialog2 = new AlertDialog.Builder(MainActivity.this);

                alertDialog2.setTitle("App Information");

                alertDialog2.setMessage(
                        "Android Browser v" + androidAppVersion + "\n" +
                                "More functions will comming soon!"
                );

                AlertDialog.Builder alertDialog3 = new AlertDialog.Builder(MainActivity.this);

                alertDialog3.setTitle("App Information");

                alertDialog3.setMessage(
                        "To update the browser, visit the GitHub page of this browser. To get to the page, click on 'Visit'"

                );

                alertDialog2.setIcon(R.drawable.full_icon);
                alertDialog3.setIcon(R.drawable.full_icon);

                alertDialog2.setPositiveButton("Ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // Write your code here to execute after dialog
                                Toast.makeText(getApplicationContext(),
                                        "Thank you for using this Browser <3", Toast.LENGTH_SHORT)
                                        .show();
                            }
                        });

                alertDialog2.setNeutralButton("Continue",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // Write your code here to execute after dialog
                                alertDialog3.show();
                            }
                        });


                alertDialog3.setPositiveButton("Ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // Write your code here to execute after dialog
                                dialog.cancel();
                            }
                        });

                alertDialog3.setNeutralButton("Visit",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // Write your code here to execute after dialog
                                dialog.cancel();
                                Browser.loadUrl("https://github.com/Juliaaan2502/simpleWebBrowserAndroid.Java/releases");
                            }
                        });



                alertDialog2.show();
            }
        }); */


        // Browser Settings
        AppSettings.setOnClickListener(v -> setContentView(R.layout.settings));
        Browser.setOnClickListener(v -> setContentView(R.layout.settings));
        Home.setOnClickListener(v -> Browser.loadUrl("https://google.com"));
    }

    public void goToHome(View v) {
        setContentView(R.layout.settings);
    }

}
