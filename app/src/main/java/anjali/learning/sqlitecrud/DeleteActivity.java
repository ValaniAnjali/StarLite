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

public class DeleteActivity extends AppCompatActivity {
Button delete;
EditText userid;
String ID;
helperclass hp = new helperclass(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_delete);
        userid=findViewById(R.id.userid);
        delete=findViewById(R.id.deltebtn);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ID=userid.getText().toString().trim();
                if(!(ID.isEmpty())){
                    hp.deletedata(ID);
                }else{
                    Toast.makeText(DeleteActivity.this,"Enter id please",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}