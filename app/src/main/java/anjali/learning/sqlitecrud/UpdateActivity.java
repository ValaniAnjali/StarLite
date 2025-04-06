package anjali.learning.sqlitecrud;

import android.database.Cursor;
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

public class UpdateActivity extends AppCompatActivity {
String ID,NAME,ADDRESS,EMAIL,MOBILE;
Button Fetch,Update;
EditText Id , Name , Address, Email,Mobile;
helperclass hp = new helperclass(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_update);
        Id=findViewById(R.id.ID);
        Name=findViewById(R.id.name);
        Address=findViewById(R.id.address);
        Email=findViewById(R.id.email);
        Mobile=findViewById(R.id.mobile);
        Fetch=findViewById(R.id.fetchbtn);
        Update=findViewById(R.id.updatebtn);
        Fetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //id name email mobile address
                ID=Id.getText().toString().trim();
                Cursor cs =hp.fetchData(ID);
                if(!(ID.isEmpty())&&cs.moveToFirst()){

                        if(cs.getCount()>0){
                            Id.setText(cs.getString(0));
                            Name.setText(cs.getString(1));
                            Email.setText(cs.getString(2));
                            Mobile.setText(cs.getString(3));
                            Address.setText(cs.getString(4));
                        }else{
                            Toast.makeText(UpdateActivity.this,"No Recored exist with this perticular ID",Toast.LENGTH_SHORT).show();

                        }


                }else{
                    Toast.makeText(UpdateActivity.this,"Enter ID",Toast.LENGTH_SHORT).show();
                }

            }
        });
        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ID=Id.getText().toString().trim();
                NAME=Name.getText().toString().trim();
                EMAIL=Email.getText().toString().trim();
                ADDRESS=Address.getText().toString().trim();
                MOBILE=Mobile.getText().toString().trim();
                if(!(ID.isEmpty()||NAME.isEmpty()||EMAIL.isEmpty()||ADDRESS.isEmpty()||MOBILE.isEmpty())){
                    hp.updateData(ID,NAME,ADDRESS,MOBILE,EMAIL);
                }else{
                    Toast.makeText(UpdateActivity.this,"All fields necessary",Toast.LENGTH_SHORT).show();

                }

            }
        });
    }
}