package com.example.hsenih;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.TextViewCompat;

import android.os.Bundle;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class patrol extends AppCompatActivity {
    public static final String URL_REGISTER = "http://192.168.0.6/database_android/daftar_proil.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patrol);
registerUser();
    }
    private void registerUser(){
            final TextView teksnama = (TextView) findViewById(R.id.editText17);
        final TextView teksnim = (TextView) findViewById(R.id.editText18);
        final TextView tekstgl = (TextView) findViewById(R.id.editText19);
        final TextView tekstempat= (TextView) findViewById(R.id.editText20);
        final TextView tekspemb = (TextView) findViewById(R.id.editText21);
        final TextView teksprodi = (TextView) findViewById(R.id.editText22);
        final TextView tekskelas = (TextView) findViewById(R.id.editText23);

        StringRequest String = new StringRequest(Request.Method.POST, URL_REGISTER, new Response.Listener<java.lang.String>() {
            @Override
            public void onResponse(java.lang.String response) {
                JSONObject result = null;
                try {
                    result = new JSONObject(response);
                    JSONArray data = result.getJSONArray("data");

                        JSONObject ambildata = data.getJSONObject(2);
                        String nama = ambildata.getString("nama");
                    JSONObject ambildata1 = data.getJSONObject(1);
                        String nim = ambildata1.getString("nim");
                    JSONObject ambildata2 = data.getJSONObject(6);
                        String tgl = ambildata2.getString("tanggal_lahir");
                    JSONObject ambildata3 = data.getJSONObject(5);
                        String tmp = ambildata3.getString("tempat_lahir");
                    JSONObject ambildata4 = data.getJSONObject(11);
                        String pemb = ambildata4.getString("pembimbing");
                    JSONObject ambildata5 = data.getJSONObject(4);
                        String prodi = ambildata5.getString("program_studi");
                    JSONObject ambildata6 = data.getJSONObject(9);
                        String kels = ambildata.getString("kelas");
                        teksnama.setText(nama);
                        teksnim.setText(nim);
                        tekstgl.setText(tgl);
                        tekstempat.setText(tmp);
                        tekspemb.setText(pemb);
                        teksprodi.setText(prodi);
                        tekskelas.setText(kels);


                } catch (JSONException e) {
                    e.printStackTrace();

                }

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(patrol.this, "Gagal", Toast.LENGTH_SHORT).show();
                    }
                }
        ){
            @Override
            protected Map<java.lang.String, java.lang.String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                return params;
            }
        };
        RequestQueue request = Volley.newRequestQueue(patrol.this);
        request.add(String);
    }
}
