package anjali.learning.sqlitecrud;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ViewDetailsActivity extends AppCompatActivity {
    TextView showdetails;
    helperclass hp = new helperclass(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_view_details);
        showdetails=findViewById(R.id.showdetails);
        Cursor cursor = hp.readdata();
//        StringBuilder b=new StringBuilder();

        while (cursor.moveToNext()){
            showdetails.setText("ID: "+cursor.getString(0)+"\n"+"Name: "+cursor.getString(1)+"\n"+"Email: "+cursor.getString(2)+"\n"+"Address: "+cursor.getString(4)+"\n"+"Mobile: "+cursor.getString(3)+"\n");
        }


    }
}