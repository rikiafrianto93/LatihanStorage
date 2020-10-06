package com.rikiafrianto.latihanstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;


public class InternalActivity extends AppCompatActivity implements View.OnClickListener{
    public static final String FILENAME="namafile.txt";
    Button buatFile, ubahFile, bacaFile, hapusFile;
    TextView textBaca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal);

        buatFile=findViewById(R.id.buttonBuatFile);
        ubahFile=findViewById(R.id.buttonUbahFile);
        bacaFile=findViewById(R.id.buttonBacaFile);
        hapusFile=findViewById(R.id.buttonHapusFile);
        textBaca=findViewById(R.id.textBaca);

        buatFile.setOnClickListener(this);
        ubahFile.setOnClickListener(this);
        bacaFile.setOnClickListener(this);
        hapusFile.setOnClickListener(this);
    }

        void buatFile(){
            String isiFile="Coba isi dari Riki Afrianto";
            File file=new File(getFilesDir(),FILENAME);

            FileOutputStream outputStream=null;
            try {
                file.createNewFile();
                outputStream=new FileOutputStream(file,true);
                outputStream.write(isiFile.getBytes());
                outputStream.flush();
                outputStream.close();
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        void hapusFile(){
            File file=new File(getFilesDir(),FILENAME);
            if (file.exists()){
                file.delete();
            }
        }
    }

    @Override
    public void onClick(View v) { jalankanPerintah(v.getId());}

    public void jalankanPerintah(int id){
        switch (id){
            case R.id.buttonBuatFile:
                buatFile();
                break;
            case R.id.buttonBacaFile:
                bacaFile();
                break;
            case R.id.buttonUbahFile:
                ubahFile();
                break;
            case R.id.buttonHapusFile:
                hapusFile();
                break;
        }
    }
}
