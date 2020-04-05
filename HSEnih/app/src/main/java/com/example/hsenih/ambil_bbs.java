package com.example.hsenih;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

public class ambil_bbs extends AppCompatActivity {
    public static final String URL_REGISTER = "http://192.168.0.6/database_android/evaluasi.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ambil_bbs);

    }
    private void registerUser(){
        EditText mata = (EditText)findViewById(R.id.editText31);
        final String matamu = mata.getText().toString().trim();
        Spinner spinner1 = (Spinner)findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(ambil_bbs.this,R.array.spinner1, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView con2 = (TextView)findViewById(R.id.textView46);
                final Integer teks = (Integer) parent.getItemAtPosition(position);
                con2.setText(teks);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Spinner spinner2 = (Spinner)findViewById(R.id.spinner2);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView con2 = (TextView)findViewById(R.id.textView47);
                final Integer teks1 = (Integer) parent.getItemAtPosition(position);
                con2.setText(teks1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Spinner spinner3 = (Spinner)findViewById(R.id.spinner3);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter);
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView con2 = (TextView)findViewById(R.id.textView48);
                final Integer teks2 = (Integer) parent.getItemAtPosition(position);
                con2.setText(teks2);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Spinner spinner4 = (Spinner)findViewById(R.id.spinner4);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner4.setAdapter(adapter);
        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView con2 = (TextView)findViewById(R.id.textView49);
                final Integer teks3 = (Integer) parent.getItemAtPosition(position);
                con2.setText(teks3);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Spinner spinner6 = (Spinner)findViewById(R.id.spinner4);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(ambil_bbs.this,R.array.spinner2, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner6.setAdapter(adapter);
        spinner6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView con2 = (TextView)findViewById(R.id.textView51);
                switch(position){
                    case 1:
                        con2.setText("nilai_akademik1");
                        break;
                    case 2:
                        con2.setText("nilai_akademik2");
                        break;
                    case 3:
                        con2.setText("nilai_akademik3");
                        break;
                    case 4:
                        con2.setText("nilai_akademik4");
                        break;
                    case 5:
                        con2.setText("nilai_akademik5");
                        break;
                    case 6:
                        con2.setText("nilai_akademik6");
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Spinner spinner5 = (Spinner)findViewById(R.id.spinner5);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner5.setAdapter(adapter);
        spinner5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView con2 = (TextView)findViewById(R.id.textView50);
                final Integer teks4 = (Integer) parent.getItemAtPosition(position);
                con2.setText(teks4);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        final StringRequest String = new StringRequest(Request.Method.POST, URL_REGISTER, new Response.Listener<java.lang.String>() {
            @Override
            public void onResponse(java.lang.String response) {
                JSONObject result = null;
                try {
                    result = new JSONObject(response);
                    Toast.makeText(ambil_bbs.this, result.getString("success"), Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(ambil_bbs.this, response.toString(), Toast.LENGTH_SHORT).show();
                }

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(ambil_bbs.this, "Gagal", Toast.LENGTH_SHORT).show();
                    }
                }
        ){
            @Override
            protected Map<java.lang.String, java.lang.String> getParams() throws AuthFailureError {
                TextView teks = (TextView)findViewById(R.id.textView46);
                TextView teks1 = (TextView)findViewById(R.id.textView47);
                TextView teks2 = (TextView)findViewById(R.id.textView48);
                TextView teks3 = (TextView)findViewById(R.id.textView49);
                TextView teks4 = (TextView)findViewById(R.id.textView50);
                TextView sem = (TextView)findViewById(R.id.textView51);
                String a = teks.getText().toString();
                String b = teks1.getText().toString();
                String c = teks2.getText().toString();
                String d = teks3.getText().toString();
                String e = teks4.getText().toString();
                String se = sem.getText().toString();
                Map<String,String> params = new HashMap<>();
                params.put("matkul",matamu);
                params.put("semester",se);
                params.put("a",a);
                params.put("b",b);
                params.put("c",c);
                params.put("d",d);
                params.put("e",e);
                return params;
            }
        };
        RequestQueue request = Volley.newRequestQueue(ambil_bbs.this);
        request.add(String);
    }

}
