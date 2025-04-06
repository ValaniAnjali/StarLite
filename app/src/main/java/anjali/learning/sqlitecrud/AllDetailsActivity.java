package anjali.learning.sqlitecrud;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AllDetailsActivity extends AppCompatActivity {
    helperclass hp = new helperclass(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_all_details);
        TableLayout tb = findViewById(R.id.tableLayout);
        Cursor cursor=hp.readdata();
        if(cursor!=null&&cursor.moveToFirst()){
            do{
                TableRow row = new TableRow(this);

                TextView id = new TextView(this);
                id.setText(cursor.getString(0));
                id.setBackgroundColor(ContextCompat.getColor(AllDetailsActivity.this, R.color.white));

                TextView name = new TextView(this);
                name.setText(cursor.getString(1));
                name.setBackgroundColor(ContextCompat.getColor(AllDetailsActivity.this, R.color.black));
                name.setTextColor(ContextCompat.getColor(this,R.color.white));

                TextView email = new TextView(this);
                email.setText(cursor.getString(2));
                email.setBackgroundColor(ContextCompat.getColor(AllDetailsActivity.this, R.color.white));

                TextView address=new TextView(this);
                address.setText(cursor.getString(4));
                address.setBackgroundColor(ContextCompat.getColor(AllDetailsActivity.this, R.color.black));
                address.setTextColor(ContextCompat.getColor(this,R.color.white));

                TextView mobile=new TextView(this);
                mobile.setText(cursor.getString(3));
                mobile.setBackgroundColor(ContextCompat.getColor(AllDetailsActivity.this, R.color.white));


                row.addView(id);
                row.addView(name);
                row.addView(email);
                row.addView(address);
                row.addView(mobile);

                tb.addView(row);
            }while(cursor.moveToNext());
        }
}
}