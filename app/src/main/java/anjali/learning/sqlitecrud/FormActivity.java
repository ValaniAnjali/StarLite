package anjali.learning.sqlitecrud;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FormActivity extends AppCompatActivity {
EditText name,email,mobile,address;
String NAME,EMAIL,MOBILE,ADDRESS;
Button Add;
//Button View;
    helperclass hp = new helperclass(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_form);
        Add=findViewById(R.id.addbtn);
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        address=findViewById(R.id.address);
        mobile=findViewById(R.id.mobile);
        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                NAME=name.getText().toString().trim();
                EMAIL=email.getText().toString().trim();
                ADDRESS=address.getText().toString().trim();
                MOBILE=mobile.getText().toString().trim();

                if(!(NAME.isEmpty()||EMAIL.isEmpty()||ADDRESS.isEmpty()||MOBILE.isEmpty())){
                    hp.insertData(NAME,EMAIL,ADDRESS,MOBILE);
                }else{
                    Toast.makeText(FormActivity.this,"Enter all fields",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}