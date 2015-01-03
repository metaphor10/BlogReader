package com.software.arielb.blogreader;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;


public class BlogWebViewActivity extends ActionBarActivity {
    protected String mUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog_web_view);
        Intent intent=getIntent();
        Uri blogUri=intent.getData();
        mUrl=blogUri.toString();
        WebView webView=(WebView) findViewById(R.id.webView);
        webView.loadUrl(mUrl);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_blog_web_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_share) {
            sharePost();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void sharePost() {
        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,mUrl);

        startActivity(Intent.createChooser(intent, getString(R.string.share_chooser_title)));
    }
}
