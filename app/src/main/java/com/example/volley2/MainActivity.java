package com.example.volley2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {


    EditText text;
    String generatedDate=setDate();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn=findViewById(R.id.button);
        btn.setText("Szukaj");
        String nip;
        // nip=String.valueOf(text.getText());
        //526025027452
        text=findViewById(R.id.editText);
        text.setHint("Wprowadz nip");
        //"https://programming-quotes-api.herokuapp.com/quotes/random";
        setDate();
        TextView textView= findViewById(R.id.textView);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //9270101431
                String url = "https://wl-api.mf.gov.pl/api/search/nip/"+text.getText()+generatedDate;
                //"?date=2021-12-05";
                volleyWork(textView,url);

            }
        });

    }



    public void volleyWork(TextView t,String url)
    {
        RequestQueue requestQueue;

// Instantiate the cache
        Cache cache = new DiskBasedCache(getCacheDir(), 1024 * 1024); // 1MB cap

// Set up the network to use HttpURLConnection as the HTTP client.
        Network network = new BasicNetwork(new HurlStack());

// Instantiate the RequestQueue with the cache and network.
        requestQueue = new RequestQueue(cache, network);

// Start the queue
        requestQueue.start();
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();

                        Root root = (Root)gson.fromJson(response, Root.class);
                        System.out.println(root.toString());//data is string form response from server
                        t.setText(root.getResult().getSubject().getStatusVat().toString());

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Handle error
                    }
                });
        requestQueue.add(stringRequest);

    }

    public String setDate()
    {
        Date date=new Date();
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        // System.out.println(formatDate.format(date));
        String stringDate=formatDate.format(date);
        return "?date="+stringDate;
    }

}