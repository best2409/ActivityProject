package com.example.activityproject;

import android.app.*;
import android.content.*;
import android.os.*;
import android.util.*;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.*;

/*
 * 1. App 초기 실행 : onCreate() -> onStart() -> onResume() 
 * 2. Home 버튼 : onSaveInstanceState() -> onPause() -> onStop()
 *    App 다시 실행 : onRestart() -> onStart() -> onResume() 
 * 3. 이전 버튼 : onPause() -> onStop() -> onDestroy()
 *    App 다시 실행 : onCreate() -> onStart() -> onResume() 
 * 4. App 실행 상태에서 전화 : onSaveInstanceState() -> onPause() -> onStop()
 *    전화 등 다른 앱에서 이전 버튼 : onRestart() -> onStart() -> onResume() 
 * 5. 디바이스 회전 : onSaveInstanceState() -> onPause() -> onStop() -> onDestroy() -> onCreate() -> onStart() -> onRestoreInstanceState() -> onResume() 
 * 6. 강제종료 후 재실행 : onCreate() -> onStart() -> onRestoreInstanceState() -> onResume() 
 * 7. 새로운 Activity 실행 : osnSaveInstanceState() -> onPause() -> onStop()
 *    새로운 Activity를 닫았을 때 : onRestart() -> onStart() -> onResume() 
 */


public class MainActivity extends Activity {
	private Button subBtn,dialogBtn;
	private EditText editText;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Log.e("myinfo", "Main onCreate");
		
		editText = (EditText) findViewById(R.id.editText);
		subBtn = (Button) findViewById(R.id.mainBtn);
		dialogBtn = (Button) findViewById(R.id.dialogBtn);
		
		subBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, SubActivity.class);
				startActivity(intent);
			}
		});
		
		dialogBtn.setOnClickListener(new OnClickListener() {
			final CharSequence[] items = {"Red", "Green", "Blue"};
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
				
				builder.setTitle("Select Color").setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener(){   
					 // 목록 클릭시 설정
					public void onClick(DialogInterface dialog, int index){
						//Toast.makeText(getApplicationContext(), items[index], Toast.LENGTH_SHORT).show();
						
						editText.setTextColor(index);
					}
				});
				
				AlertDialog dialog = builder.create();    // 알림창 객체 생성
				dialog.show();
				
			}
			
		});
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.i("myinfo", "Main onDestroy");
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.i("myinfo", "Main onPause");
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		Log.i("myinfo", "Main onRestart");
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onRestoreInstanceState(savedInstanceState);
		Log.i("myinfo", "Main onRestoreInstanceState");
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.i("myinfo", "Main onResume");
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		Log.i("myinfo", "Main onSaveInstanceState");
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.i("myinfo", "Main onStart");
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.i("myinfo", "Main onStop");
	}
	
}
