package org.coscup.ccip.fragment;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;

import org.coscup.ccip.R;
import org.coscup.ccip.network.webclient.OfficialWebViewClient;
import org.coscup.ccip.network.webclient.WebChromeViewClient;

public class VenueFragment extends Fragment {

    private static final String URL_SPONSORS = "https://coscup.org/2018-assets/img/venue.svg";
    private static WebView webView;
    private static ProgressBar progressBar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_web, container, false);

        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);

        webView = (WebView) view.findViewById(R.id.webView);
        webView.setWebChromeClient(new WebChromeViewClient(progressBar));
        webView.setWebViewClient(new OfficialWebViewClient());
        webView.loadUrl(URL_SPONSORS);

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(WebSettings.MIXED_CONTENT_COMPATIBILITY_MODE);
        }

        return view;
    }
}
