package com.example.asynchrone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void research(View myView) throws JSONException {
        String cityName = findViewById(R.id.cityId).toString();
        String api = "http://api.worldweatheronline.com/premium/v1/weather.ashx?key=94440190782e4b10b84105802221702&q="+ cityName+"&fx=no&cc=no&mca=yes&format=xml";
        GetData gt = new GetData();
        String jsonData = "";
        try {
            jsonData = gt.execute(api).get();
        }
        catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        JSONObject object = new JSONObject(jsonData);
        String location = (String) object.get("data");
        TextView t = findViewById(R.id.description);
        t.setText();
    }
}