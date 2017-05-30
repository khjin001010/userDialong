package khjin001010.kr.hs.emirim.userdialong;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    View dlgV;
    Button but;
    TextView textName, textEmail;
    EditText editName, editEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        but = (Button)findViewById(R.id.but);
        textName = (TextView)findViewById(R.id.text_name);
        textEmail = (TextView)findViewById(R.id.text_email);

        but.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        dlgV = View.inflate(this, R.layout.dialog, null); //getApplicationContext == this
        //inflation == xml에 있는 것을 가지고 객체 생성하는 것.
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        //getApplicationContext == this
        dialog.setTitle("Input User Information");
        dialog.setIcon(R.mipmap.ic_launcher);
        dialog.setView(dlgV);
        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                editName = (EditText)dlgV.findViewById(R.id.edit_name);
                editEmail = (EditText)dlgV.findViewById(R.id.edit_email);
                textName.setText(editName.getText());
                textEmail.setText(editEmail.getText());
            }
        });
        dialog.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast toast = new Toast(MainActivity.this);
                View toastV = View.inflate(MainActivity.this, R.layout.toast, null);
                TextView textToast = (TextView)toastV.findViewById(R.id.text_toast);
                textToast.setText("취소되었습니다.");
                toast.setView(toastV);
                toast.show();
            }
        });
        dialog.show();
    }
}
