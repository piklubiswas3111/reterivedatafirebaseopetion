package westbengal.book;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    TextView pdfname, pdflink;
    WebView pdfview;
    ProgressDialog pd;
    String pdfpp;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
//        pdfname = (TextView) findViewById(R.id.textrpdfname);
//        pdflink = (TextView) findViewById(R.id.textrpdfur);
        pdfview = (WebView) findViewById(R.id.webview);
        String pdfnamee = getIntent().getStringExtra("pdfn");
        pdfpp = getIntent().getStringExtra("url");

//        pdfname.setText(pdfnamee);
//        pdflink.setText(pdfpp);

        pd = new ProgressDialog(this);
        pd.setTitle(pdfnamee);
        pd.setMessage("Opening....");

        WebSettings webSettings = pdfview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        pdfview.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                pd.show();
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                pd.dismiss();
            }
        });



        String qw = "";
        try {
            qw = URLEncoder.encode(pdfpp, "UTF-8");
        } catch (Exception exception) {

        }
       // pdfview.loadUrl("https://docs.google.com/gview?embedded=true&url=" + qw);

        pdfview.loadUrl("https://firebasestorage.googleapis.com/v0/b/west-bengla-all-book.appspot.com/o/java_tutorial.pdf?alt=media&token="+qw);
    }

}