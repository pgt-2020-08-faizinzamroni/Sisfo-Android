package com.example.hsenih;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class login extends AppCompatActivity {
    public static final String URL_REGISTER = "http://192.168.0.6/database_android/login.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button but = (Button)findViewById(R.id.button2);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
    }
        private void registerUser(){
            EditText teksnim = (EditText)findViewById(R.id.textView8);
            EditText tekspassword = (EditText)findViewById(R.id.textView9);
            final String nim = teksnim.getText().toString();
            final String pass = tekspassword.getText().toString();
            StringRequest String = new StringRequest(Request.Method.POST, URL_REGISTER, new Response.Listener<java.lang.String>() {
                @Override
                public void onResponse(java.lang.String response) {
                    JSONObject result = null;

                    try {
                        result = new JSONObject(response);
                        String resultnya = result.getString("kon");
                        if(resultnya.equals("1")){
                            Toast.makeText(login.this,"Berhasil Login", Toast.LENGTH_SHORT).show();
                            Intent ii = new Intent(login.this,menu_utama.class);
                            startActivity(ii);
                        }else{
                            Toast.makeText(login.this,"Gagal Login", Toast.LENGTH_SHORT).show();
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                        Toast.makeText(login.this, e.toString(), Toast.LENGTH_SHORT).show();
                    }

                }
            },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(login.this, "Gagal", Toast.LENGTH_SHORT).show();
                        }
                    }
            ){
                @Override
                protected Map<java.lang.String, java.lang.String> getParams() throws AuthFailureError {
                    Map<String,String> params = new HashMap<>();
                    params.put("password",pass);
                    params.put("nim",nim);
                    return params;
                }
            };
            RequestQueue request = Volley.newRequestQueue(login.this);
            request.add(String);
        }
    }

