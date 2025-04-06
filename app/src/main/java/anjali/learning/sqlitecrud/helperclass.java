package anjali.learning.sqlitecrud;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class helperclass extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="Student.db";
    private static final String TABLE_NAME="Student";
    private static final String COL_ID="ID";
    private static final String COL_NAME="Name";
    private static final String COL_EMAIL="Email";
    private static final String COL_ADDRESS="Address";
    private static final String COL_MOBILE="Mobile";
    private Context context;
    public helperclass(Context context) {
        super(context, DATABASE_NAME, null, 1);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String Query = "CREATE TABLE "+TABLE_NAME+"( "+COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT ,"+COL_NAME+" TEXT,"+COL_EMAIL+" TEXT,"+COL_MOBILE+" TEXT,"+COL_ADDRESS+" TEXT)";
        db.execSQL(Query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists "+TABLE_NAME);
    }

    public void insertData(String name,String email,String address,String mobile){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_NAME,name);
        cv.put(COL_EMAIL,email);
        cv.put(COL_ADDRESS,address);
        cv.put(COL_MOBILE,mobile);
       long result= db.insert(TABLE_NAME,null,cv);
       if(result!=-1){
           Toast.makeText(context,"Insert success",Toast.LENGTH_SHORT).show();
       }else{
           Toast.makeText(context,"Insert error",Toast.LENGTH_SHORT).show();
       }
    }
    public Cursor readdata(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        return cursor;
    }
    public void deletedata(String ID){
        SQLiteDatabase db = this.getWritableDatabase();
        int result = db.delete(TABLE_NAME,COL_ID+"=?",new String[]{ID});
        if(result!=-1){
            Toast.makeText(context,"Deleted successfully",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context,"Delete error",Toast.LENGTH_SHORT).show();
        }
    }
    public Cursor fetchData(String ID){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from "+TABLE_NAME+" where "+COL_ID+"=?",new String[]{String.valueOf(ID)});

        return cursor;
    }
    public void updateData(String id,String name,String address,String mobile,String email){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_NAME,name);
        cv.put(COL_EMAIL,email);
        cv.put(COL_ADDRESS,address);
        cv.put(COL_MOBILE,mobile);
        long result =db.update(TABLE_NAME,cv,COL_ID+"=?",new String[]{id});
        if(result!=-1){
            Toast.makeText(context,"Update success",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context,"Update error",Toast.LENGTH_SHORT).show();
        }

    }
}
