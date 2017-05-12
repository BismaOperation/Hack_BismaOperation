package hackfest_bismaoperation.com.hackfest_bismaoperation.Activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import hackfest_bismaoperation.com.hackfest_bismaoperation.R;

public class RegisterActivity extends AppCompatActivity {

    private RadioGroup radioSexGroup;
    private RadioButton radioSexButton,rbL,rbP;
    EditText txtDate,namaDepan,namaBelakang,nomorTlp;
    Button btnSelanjutnya;
    private int mYear, mMonth, mDay;
    private Bundle bundle;
    private ProgressDialog pDialog;
    private Bundle reg1 = new Bundle();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
//        btnSelanjutnya=(Button)findViewById(R.id.buttonSelanjutnya);
//        radioSexGroup=(RadioGroup)findViewById(R.id.radioGroup);
//        int selectedId=radioSexGroup.getCheckedRadioButtonId();
//        radioSexButton=(RadioButton)findViewById(selectedId);
//        rbP=(RadioButton)findViewById(R.id.rbPerempuan);
//        rbL=(RadioButton)findViewById(R.id.rbLakilaki);
//        txtDate=(EditText)findViewById(R.id.birth_date);
//        namaDepan=(EditText)findViewById(R.id.input_namadepan);
//
//        namaBelakang=(EditText)findViewById(R.id.input_namabelakang);
//        nomorTlp=(EditText)findViewById(R.id.input_nomortelp);
//
//        txtDate.setOnClickListener(this);
//        btnSelanjutnya.setOnClickListener(this);
    }


}
