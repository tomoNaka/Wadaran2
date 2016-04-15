package com.wadaran.android;

import android.app.Activity;
import android.app.DownloadManager;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;
import com.squareup.okhttp.*;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by erikotsuda on 4/1/16.
 */
public class AsyncHttpTask extends AsyncTask<String, Void, String>{

    private Activity activity;

    public AsyncHttpTask(Activity activity){
        this.activity = activity;
    }

    @Override
    protected String doInBackground(String... params) {
        String result = null;

        //Create XML
        /*
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder dbuilder = dbFactory.newDocumentBuilder();
            Document document = dbuilder.newDocument();
            Element root = document.createElement("hoge");
            document.appendChild(root);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }*/

        //Send HTTP request
        RequestBody rb = RequestBody.create(MediaType.parse("text/plain"),Constants.PARAM_NAME_SITUATION + "=" + params[0]);
        Request request = new Request.Builder().url(Constants.SERVER_URL+Constants.GET_LIST_BY_SITUATION).post(rb).build();

        OkHttpClient client = new OkHttpClient();

        try {
            Response response = client.newCall(request).execute();
            result = response.body().string();
            Log.i("hoge","doPost success" + result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String result){
        Toast.makeText(this.activity, "Post完了", Toast.LENGTH_LONG).show();
    }
}
