package com.coolweather.app.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import android.util.Log;

public class HttpUtil {
	public static void sentHttpRequst(final String address, 
			  final HttpCallbackListener listener) {
		new Thread(new Runnable() { 
			@Override
			public void run() {
				HttpURLConnection connection = null;
				try {
					URL url = new URL(address);
					connection = (HttpURLConnection) url.openConnection();
					connection.setRequestMethod("GET");
					connection.setConnectTimeout(8000);
					connection.setReadTimeout(8000);
					
					InputStream in = connection.getInputStream();
					BufferedReader reader = new BufferedReader(new InputStreamReader(in));
					StringBuilder respose = new StringBuilder();
					String line = null;
					
					line = reader.readLine();
					Log.d("MainActivity", line + " wwww");
					
					while ( line != null) {       
						 respose.append(line);    
						 line = reader.readLine();
						 Log.d("MainActivity", line + " www");
					}
					
					if (listener != null) {
						//回调onFinish()
						listener.onFinish(respose.toString());
					}
				} catch (Exception e) {
					Log.e("MainActivity", Log.getStackTraceString(e));
					if (listener != null) {
						//回调onError()方法
						listener.onError(e);
				    }
				} finally {
					if (connection != null) {
						connection.disconnect();
					}
				}
			}
		}).start();
	}
}
