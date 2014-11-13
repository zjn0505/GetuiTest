package com.example.getuitest;


import com.igexin.sdk.PushManager;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	private TextView tView, tAppkeyView, tAppSecretView, tMasterSecretView,  tAppIdView;
	
	public static EditText tTransMsg;
	private String appkey = "";
	private String appsecret = "";
	private String appid = "";
	
	private static final String MASTERSECRET = "2ljofWMtaVAZjjXQZ7gin6";
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		PushManager.getInstance().initialize(this.getApplicationContext());
		setContentView(R.layout.activity_main);
		
		
		tView = (TextView) findViewById(R.id.tvclientid);
		tAppkeyView = (TextView) findViewById(R.id.tvappkey);
		tAppSecretView = (TextView) findViewById(R.id.tvappsecret);
		tMasterSecretView = (TextView) findViewById(R.id.tvmastersecret);
		tAppIdView = (TextView) findViewById(R.id.tvappid);
		tTransMsg = (EditText) findViewById(R.id.tvTransMsg);
		tTransMsg.setText("");
		
		String packageName = getApplicationContext().getPackageName();
		ApplicationInfo appInfo;
		try {
			appInfo = getPackageManager().getApplicationInfo(packageName, PackageManager.GET_META_DATA);
			if (appInfo.metaData != null) {

				appid = appInfo.metaData.getString("PUSH_APPID");
				appsecret = appInfo.metaData.getString("PUSH_APPSECRET");
				appkey = (appInfo.metaData.get("PUSH_APPKEY") != null) ? appInfo.metaData.get("PUSH_APPKEY").toString() : null;
			}

		} catch (NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		tAppkeyView.setText("AppKey=" + appkey);
		tAppSecretView.setText("AppSecret=" + appsecret);
		tMasterSecretView.setText("MasterSecret=" + MASTERSECRET);
		tAppIdView.setText("AppID=" + appid);
		String cid = PushManager.getInstance().getClientid(this);
		tView.setText(cid);
		
		
		
	}


}
