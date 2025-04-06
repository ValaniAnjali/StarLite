package anjali.learning.sqlitecrud;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    CardView cardAdd,cardView,cardUpdate,cardDelete,cardAllRecords;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        cardAdd=findViewById(R.id.cardadd);
        cardView=findViewById(R.id.cardView);
        cardUpdate=findViewById(R.id.cardUpdate);
        cardDelete=findViewById(R.id.cardDelete);
        cardAllRecords=findViewById(R.id.cardAllRecords);
        cardAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent redirectToFormactivity = new Intent(MainActivity.this, FormActivity.class);
                startActivity(redirectToFormactivity);
            }
        });
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent redirectToViewDetailsactivity = new Intent(MainActivity.this, ViewDetailsActivity.class);
                startActivity(redirectToViewDetailsactivity);
            }
        });
        cardUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent redirectToUpdateActivity = new Intent(MainActivity.this, UpdateActivity.class);
                startActivity(redirectToUpdateActivity);
            }
        });
        cardDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent redirectToDeleteActivity=new Intent(MainActivity.this, DeleteActivity.class);
                startActivity(redirectToDeleteActivity);
            }
        });
        cardAllRecords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent redirectToDeleteActivity=new Intent(MainActivity.this, AllDetailsActivity.class);
                startActivity(redirectToDeleteActivity);
            }
        });
    }
}