package com;

import com.example.mysecondapplication.R;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;

public class TestActivity extends Activity{
	DBHelper dbHelper;
	Button btn;
	DatePicker d;
	LinearLayout obj;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test_layout);
		dbHelper = new DBHelper(this);
		Log.d("NameTag", "message");
		obj = (LinearLayout) findViewById(R.id.myAddLayout);
	}
	public void myClickAdd(View view){
		Button btn1 = (Button) view;
		
		Button btn = new Button(this);
		btn.setText("add button");
		obj.addView(btn);		
	}

public void onClick(){
	SQLiteDatabase database = dbHelper.getWritableDatabase();
	ContentValues contentValues = new ContentValues();
	/* add */
	contentValues.put(DBHelper.KEY_NAME, "..");
	contentValues.put(DBHelper.KEY_MAIL, "..");
	database.insert(DBHelper.TABLE_CONTACTS, null, contentValues);
	/* read */
	Cursor cursor = database.query(DBHelper.TABLE_CONTACTS,null,null,null,null,null,null);
	if(cursor.moveToFirst()){
		int idIndex = cursor.getColumnIndex(DBHelper.KEY_ID);
		int nameIndex = cursor.getColumnIndex(DBHelper.KEY_NAME);
		int emailIndex = cursor.getColumnIndex(DBHelper.KEY_MAIL);
		
		do{
			Log.i("mLOg","id"+cursor.getInt(idIndex)
				+",name"+cursor.getString(nameIndex)
				+",mail="+cursor.getString(emailIndex));
		}while(cursor.moveToNext());
	
	} else Log.d("mLog","0 rows");
	cursor.close();
	/* clear*/
	database.delete(DBHelper.TABLE_CONTACTS, null, null);
	
	database.close();	
	dbHelper.close();
	
}

}
