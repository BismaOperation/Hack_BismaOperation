package hackfest_bismaoperation.com.hackfest_bismaoperation.Activity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.Calendar;

import hackfest_bismaoperation.com.hackfest_bismaoperation.Model.APIBaseResponse;
import hackfest_bismaoperation.com.hackfest_bismaoperation.R;
import hackfest_bismaoperation.com.hackfest_bismaoperation.REST.RestClient;
import retrofit.Call;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private RadioGroup radioSexGroup;
    private RadioButton radioSexButton,rbL,rbP;
    private Button btnSimpan;
    private EditText txtDate,namaDepan,namaBelakang,nomorTlp,txtinputEmail,txtinputUsername,txtinputPassword,txtTempatLahir;
    private int mYear, mMonth, mDay;
    private Call<APIBaseResponse> callSignup;
    private RestClient.GitApiInterface service;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        radioSexGroup=(RadioGroup)findViewById(R.id.radioGroup);
        int selectedId=radioSexGroup.getCheckedRadioButtonId();
        radioSexButton=(RadioButton)findViewById(selectedId);
        rbP=(RadioButton)findViewById(R.id.rbPerempuan);
        rbL=(RadioButton)findViewById(R.id.rbLakilaki);
        txtDate=(EditText)findViewById(R.id.input_tgllahir);

        namaDepan=(EditText)findViewById(R.id.input_namadepan);
        namaBelakang=(EditText)findViewById(R.id.input_namabelakang);
        nomorTlp=(EditText)findViewById(R.id.input_nomortelp);
        txtDate.setOnClickListener(this);
        txtinputEmail=(EditText)findViewById(R.id.input_emailmurid);
        txtinputUsername=(EditText)findViewById(R.id.input_username);
        txtinputPassword=(EditText)findViewById(R.id.input_password);
        txtTempatLahir=(EditText)findViewById(R.id.input_tempatlahir);
        btnSimpan=(Button) findViewById(R.id.btn_Simpan);


    }
    @Override
    public void onClick(View v) {


        if (v == btnSimpan) {
            if (!validate()) {

                return;
            }

            final ProgressDialog progressDialog = new ProgressDialog(RegisterActivity.this, R.style.ProgressDialog);
            progressDialog.setIndeterminate(true);
            progressDialog.setMessage("Membuat Akun...");
            progressDialog.show();

            // TODO: Implement your own signup logic here.
            String email = txtinputEmail.getText().toString();
            String username = txtinputUsername.getText().toString();
            String password = txtinputPassword.getText().toString();
            service = RestClient.getClient();
            callSignup = service.signUp(namaDepan,namaBelakang,"",nomorTlp,jenisKelamin,birthDateFormat,"","",email,username,password,"","","","");
            callSignup.enqueue(new Callback<ApiBaseResponse>() {
                @Override
                public void onResponse(Response<ApiBaseResponse> response) {
                    Log.d("Register2", "Status Code = " + response.code());
                    if (response.isSuccess()) {
                        // request successful (status code 200, 201)
                        ApiBaseResponse result = response.body();
                        Log.d("Register2", "response = " + new Gson().toJson(result));
                        if (result != null) {
                            Toast.makeText(getBaseContext(), "Berhasil Mendaftar", Toast.LENGTH_LONG).show();
                            progressDialog.dismiss();
                            finishAffinity();
                            Intent intent = new Intent(Register2.this ,MainActivity.class);
                            startActivity(intent);
                        }

                    } else {
                        // response received but request not successful (like 400,401,403 etc)
                        //Handle errors
                        Toast.makeText(getBaseContext(), "Gagal Mendaftar", Toast.LENGTH_LONG).show();
                        progressDialog.dismiss();
                    }
                }

                @Override
                public void onFailure(Throwable t) {
                    Toast.makeText(getBaseContext(), "Gagal Mendaftar", Toast.LENGTH_LONG).show();
                    progressDialog.dismiss();
                }
            });

        }



        if (v == txtDate) {
            // Get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {
                            txtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
    }

    public boolean validate() {
        boolean valid = true;

        String namadepan=namaDepan.getText().toString();
        String namabelakang=namaBelakang.getText().toString();
        String nomortelp=nomorTlp.getText().toString();
        String email = txtinputEmail.getText().toString();
        String username=txtinputUsername.getText().toString();
        String password=txtinputPassword.getText().toString();
        String tempatlahir=txtTempatLahir.getText().toString();


        if (namadepan.isEmpty()) {
            namaDepan.setError("Nama Depan tidak boleh kosong");
            valid = false;
        } else {
            namaDepan.setError(null);
        }

        if (tempatlahir.isEmpty()) {
            txtTempatLahir.setError("Nama Depan tidak boleh kosong");
            valid = false;
        } else {
            txtTempatLahir.setError(null);
        }
        if (namabelakang.isEmpty()) {
            namaBelakang.setError("Nama Belakang tidak boleh kosong");
            valid = false;
        } else {
            namaBelakang.setError(null);
        }

        if (nomortelp.isEmpty()) {
            nomorTlp.setError("Nomor Telp  tidak boleh kosong");
            valid = false;
        } else {
            nomorTlp.setError(null);
        }

        if (password.isEmpty()) {
            txtinputPassword.setError("Password tidak boleh kosong");
            valid = false;
        } else {
            txtinputPassword.setError(null);
        }

        if (username.isEmpty()) {
            txtinputUsername.setError("Username tidak boleh kosong");
            valid = false;
        } else {
            txtinputUsername.setError(null);
        }

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            txtinputEmail.setError("Email tidak sesuai dengan format");
            valid = false;
        } else {
            txtinputEmail.setError(null);
        }
        return valid;
    }


}
