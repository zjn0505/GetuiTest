package com.example.getuitest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.getuitest.MainActivity;
import com.igexin.sdk.PushConsts;

public class PushDemoReceiver extends BroadcastReceiver {
	
	
	@Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        Log.d("GetuiSdkDemo", "onReceive() action=" + bundle.getInt("action"));
        switch (bundle.getInt(PushConsts.CMD_ACTION)) {
            case PushConsts.GET_MSG_DATA:
                // 获取透传（payload）数据
                byte[] payload = bundle.getByteArray("payload");
                if (payload != null)
                {
                    String data = new String(payload);
                    Log.d("GetuiSdkDemo", "Got Payload:" + data);
                    // TODO:接收处理透传（payload）数据
                    if (MainActivity.tTransMsg != null)
                    	MainActivity.tTransMsg.append(data + "\n");
                }
                break;
            //添加其他case
            //......... 
            default:
                break;
        }
    }

}
