package com.example.hsenih;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

import java.util.HashMap;
import java.util.Map;

public class bbs extends AppCompatActivity {
    public static final String URL_REGISTER = "http://192.168.0.6/database_android/register.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bbs);

        Button tom = (Button)findViewById(R.id.button4);
        tom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
    }
        private void registerUser(){
            EditText teksnama = (EditText)findViewById(R.id.editText10);
            EditText teksnim = (EditText)findViewById(R.id.editText11);
            EditText tekstgl = (EditText)findViewById(R.id.editText12);
            EditText tekstempat = (EditText)findViewById(R.id.editText13);
            EditText tekspemb = (EditText)findViewById(R.id.editText14);
            EditText tekskelas = (EditText)findViewById(R.id.editText16);
            EditText teksprodi = (EditText)findViewById(R.id.editText33);
            final String nama = teksnama.getText().toString();
            final String tgl = tekstgl.getText().toString();
            final String tmp = tekstempat.getText().toString();
            final String pemb = tekspemb.getText().toString();
            final String kls = tekskelas.getText().toString();
            final String prodi = teksprodi.getText().toString();
            final String nim = teksnim.getText().toString();
            StringRequest String = new StringRequest(Request.Method.POST, URL_REGISTER, new Response.Listener<java.lang.String>() {
                @Override
                public void onResponse(java.lang.String response) {
                    JSONObject result = null;
                    try {
                        result = new JSONObject(response);
                        Toast.makeText(bbs.this, result.getString("success"), Toast.LENGTH_SHORT).show();
                    } catch (JSONException e) {
                        e.printStackTrace();
                        Toast.makeText(bbs.this, response.toString(), Toast.LENGTH_SHORT).show();
                    }

                }
            },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(bbs.this, "Gagal", Toast.LENGTH_SHORT).show();
                        }
                    }
            ){
                @Override
                protected Map<java.lang.String, java.lang.String> getParams() throws AuthFailureError {
                    Map<String,String> params = new HashMap<>();
                    params.put("name",nama);
                    params.put("nim",nim);
                    params.put("kelas",kls);
                    params.put("tempat",tmp);
                    params.put("tanggal",tgl);
                    params.put("pembimbing",pemb);
                    params.put("program",prodi);
                    return params;
                }
            };
            RequestQueue request = Volley.newRequestQueue(bbs.this);
            request.add(String);
        }

    }

