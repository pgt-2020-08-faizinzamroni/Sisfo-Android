package com.example.hsenih;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class menu_utama extends AppCompatActivity {
    int angka = 0;
    int angka1 = 0;
    int angka2 = 0;
    int angka3 = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_utama);
        ImageView gambarbbs = (ImageView)findViewById(R.id.imageView8);
        ImageView patrol = (ImageView)findViewById(R.id.imageView9);
        ImageView ambilbbs = (ImageView)findViewById(R.id.imageView10);
        ImageView ambilpatrol = (ImageView)findViewById(R.id.imageView11);
        ImageView tanya = (ImageView)findViewById(R.id.imageView3);
        ImageView khs = (ImageView)findViewById(R.id.imageView13);
        ImageView input_nilai = (ImageView)findViewById(R.id.imageView7);

        tanya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(menu_utama.this, "Klik dua kali untuk membuka halaman yang berbeda", Toast.LENGTH_LONG).show();
            }
        });

        gambarbbs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                angka += 1;
                if(angka == 1){
                    Toast.makeText(menu_utama.this, "Klik lagi untuk buka form Profil Mahasiswa", Toast.LENGTH_SHORT).show();
                }
                if (angka == 2) {
                    Intent intent = new Intent(menu_utama.this, bbs.class);

                    startActivity(intent);
                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        angka = 0;
                    }
                },2000);
            }

        });
        khs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                angka += 1;
                if(angka == 1){
                    Toast.makeText(menu_utama.this, "Klik lagi untuk buka form KHS", Toast.LENGTH_SHORT).show();
                }
                if (angka == 2) {
                    Intent intent = new Intent(menu_utama.this, ambil_patrol.class);

                    startActivity(intent);
                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        angka = 0;
                    }
                },2000);
            }

        });
        khs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                angka += 1;
                if(angka == 1){
                    Toast.makeText(menu_utama.this, "Klik lagi untuk buka form KHS", Toast.LENGTH_SHORT).show();
                }
                if (angka == 2) {
                    Intent intent = new Intent(menu_utama.this, ambil_patrol.class);

                    startActivity(intent);
                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        angka = 0;
                    }
                },2000);
            }

        });
        input_nilai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                angka1 += 1;
                if(angka1 == 1){
                    Toast.makeText(menu_utama.this, "Klik lagi untuk buka form Input Nilai", Toast.LENGTH_SHORT).show();
                }
                if(angka1 == 2) {
                    Intent intentt = new Intent(menu_utama.this, patrol.class);

                    startActivity(intentt);
                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        angka1 = 0;
                    }
                },2000);
            }
        });

        ambilbbs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                angka2 += 1;
                if(angka2 == 1){
                    Toast.makeText(menu_utama.this, "Klik lagi untuk buka form evaluasi Dosen", Toast.LENGTH_SHORT).show();
                }
                if (angka2 == 2) {
                    Intent intenttt = new Intent(menu_utama.this, ambil_bbs.class);

                    startActivity(intenttt);
                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        angka2 = 0;
                    }
                },2000);
            }
        });

        ambilpatrol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                angka3 += 1;
                if(angka3 == 1){
                    Toast.makeText(menu_utama.this, "Klik lagi untuk buka form history patrol", Toast.LENGTH_SHORT).show();
                }
                if (angka3 == 2) {
                    Intent intento = new Intent(menu_utama.this, ambil_patrol.class);

                    startActivity(intento);
                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        angka3 = 0;
                    }
                },2000);
            }
        });
    }
}
