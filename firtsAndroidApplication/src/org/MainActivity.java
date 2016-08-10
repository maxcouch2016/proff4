package org;

import com.example.androidapplication.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity{
	EditText text;
	Button btn1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);
		
		text = (EditText) findViewById(R.id.editText1);
		btn1 = (Button) findViewById(R.id.button1);
		
		btn1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				text.setText("btn1 clicked!");
				
			}
		});
	}
	public void myClick(View view){
		//text.setText(text.getText().toString()+", btn2 clicked!");
		Intent intent = new Intent(this, NextActivity.class);
		intent.putExtra("parametr", "value");
		startActivity(intent);
		//
		/*
		Intent intent1 = getIntent();
		String str = intent1.getStringExtra("parametr");
		str = intent1.getParcelableExtra("parametr");
		*/		
	}
}
