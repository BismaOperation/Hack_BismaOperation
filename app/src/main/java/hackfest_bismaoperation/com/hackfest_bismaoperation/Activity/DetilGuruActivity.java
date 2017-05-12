package hackfest_bismaoperation.com.hackfest_bismaoperation.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import hackfest_bismaoperation.com.hackfest_bismaoperation.R;


public class DetilGuruActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnorder;
    private String namaDepan,jk;
    private String nomorTlp;
    private String status;
    TextView txtnama,txttlp,txtstatus,txtjk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detil_guru);
        btnorder = (Button) findViewById(R.id.btnOrder);
        txtnama=(TextView)findViewById(R.id.txtnama);
        txttlp=(TextView)findViewById(R.id.txttlp);
        txtstatus=(TextView)findViewById(R.id.txtstatus);
        txtjk=(TextView)findViewById(R.id.txtJk);
        btnorder.setOnClickListener(this);
        Bundle b=getIntent().getExtras();
        namaDepan=b.getString("nama");
        nomorTlp=b.getString("notlp");
        status=b.getString("status");
        jk=b.getString("jk");

        txtnama.setText(namaDepan);
        txttlp.setText(nomorTlp);
        txtstatus.setText(status);
        txtjk.setText(jk);

    }
    public void onClick(View v) {
        if (v == btnorder) {
            Intent intent = new Intent(this, PopUpOrderActivity.class);
            Bundle extras = new Bundle();
            extras.putString("notlp", nomorTlp.toString());
            intent.putExtras(extras);
            startActivity(intent);

        }

    }


}
