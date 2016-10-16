package id.sch.smktelkom_mlg.tugas01.xiirpl1038.project001;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    EditText etNama;
    EditText etTahun;
    EditText alamat;
    Button bOk;
    CheckBox rpl, tkj, multi, tata;
    Spinner jalur;
    TextView tvHasil;
    RadioButton laki, perem;
    RadioGroup rgStatus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNama = (EditText) findViewById(R.id.editTextNama);
        etTahun = (EditText) findViewById(R.id.editTextTahun);
        alamat = (EditText) findViewById(R.id.alamat);
        laki = (RadioButton) findViewById(R.id.laki);
        perem = (RadioButton) findViewById(R.id.perem);
        rpl = (CheckBox) findViewById(R.id.rpl);
        tkj = (CheckBox) findViewById(R.id.tkj);
        multi = (CheckBox) findViewById(R.id.multi);
        tata = (CheckBox) findViewById(R.id.tata);
        rgStatus = (RadioGroup) findViewById(R.id.radioGroupStatus);
        bOk = (Button) findViewById(R.id.buttonOK);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);

        bOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                doProcess();
            }
        });
    }

    private void doProcess()
    {
        String nama = etNama.getText().toString();
        String alam = alamat.getText().toString();
        int tahun = Integer.parseInt(etTahun.getText().toString());
        if(isValid())
        {
        }
        String hasil = null;

        if(rgStatus.getCheckedRadioButtonId()!=-1)
        {
            RadioButton rb = (RadioButton)
                    findViewById(rgStatus.getCheckedRadioButtonId());
            hasil = rb.getText().toString();
        }

        if(laki.isChecked())
        {
            hasil = laki.getText().toString();
        }
        else if(laki.isChecked())
        {
            hasil = laki.getText().toString();
        }
        else if(perem.isChecked())
        {
            hasil = perem.getText().toString();
        }
        if (hasil == null)
        {
            tvHasil.setText("Belum memilih");
        }
        else
        {
            tvHasil.setText("Status anda :" + hasil);
        }
        String qwe = "Anda memilih Jurusan :";
        int startlen = qwe.length();
        if(rpl.isChecked()) qwe+=rpl.getText()+"\n";
        if(tkj.isChecked()) qwe+=tkj.getText()+"\n";
        if(multi.isChecked()) qwe+=multi.getText()+"\n";
        if(tata.isChecked()) qwe+=tata.getText()+"\n";

        if (hasil.length()==startlen) hasil+="Tidak ada pada pilihan";
        tvHasil.setText("Nama : "+ nama +"\nTahun Lahir : "+ tahun+"\nJenis Kelamin : "+ hasil+"\nAlamat : "+ alam +"\n"+ qwe);


    }


    private boolean isValid()
    {
        boolean valid = true;

        String nama = etNama.getText().toString();
        String tahun = etTahun.getText().toString();
        String alam = alamat.getText().toString();

        if(nama.isEmpty())
        {
            etNama.setError("Nama Belum Diisi");
            valid = false;
        }
        else if(nama.length()<3)
        {
            etNama.setError("Nama minimal 3 karakter");
            valid = false;
        }
        else
        {
            etNama.setError(null);
        }
        if(tahun.isEmpty())
        {
            etTahun.setError("Tahun Kelahiran belum diisi");
            valid = false;
        }
        else if(tahun.length()!=4)
        {
            etTahun.setError("Format Tahun Kelahiran bukan yyyy");
            valid = false;
        }
        if(alam.isEmpty())
        {
            alamat.setError("Alamat Belum Diisi");
            valid = false;
        }
        else
        {
            etNama.setError(null);
        }
        return false;

    }



}
