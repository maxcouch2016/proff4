package org;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.androidapplication.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class NextActivity extends Activity{
	ListView list;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.next_layout);
		
		list = (ListView) findViewById(R.id.listView1);
		
		List<String> arr = new ArrayList(Arrays.asList(new String[]{"ab", "cd"}));
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arr);
		
		list.setAdapter(adapter);
	}
}
