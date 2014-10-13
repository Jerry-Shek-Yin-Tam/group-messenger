package edu.buffalo.cse.cse486586.groupmessenger;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Calendar;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

public class GroupMessengerActivity extends Activity {
	private static Calendar c = Calendar.getInstance(); // stuff
	public static String outputConcat = "";
	public static int sequencerCounter = 0;
	public static String portID;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_group_messenger);
		new ServerTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);

		// pTest Listener
		TextView tv = (TextView) findViewById(R.id.textView1);
		tv.setMovementMethod(new ScrollingMovementMethod());
		findViewById(R.id.button1).setOnClickListener(
				new OnPTestClickListener(tv, getContentResolver()));
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_group_messenger, menu);
		return true;
	}
	
	
/********************************* TEST 1 ****************************************/
	// Test1 class
	public class Test1 extends AsyncTask<String, String, Void> {
		static final String avd0 = "5554";
		static final String avd1 = "5556";
		static final String avd2 = "5558";

		@Override
		protected Void doInBackground(String... params) {

			try {
				Socket socket1 = null;
				Socket socket2 = null;
				Socket socket3 = null;
				
					if (params[0].equals("5554")) {
						for (int i = 0; i < 5; i++) {
						socket1 = new Socket("10.0.2.2", 11112);
						socket2 = new Socket("10.0.2.2", 11116);
						socket3 = new Socket("10.0.2.2", 11108);
						PrintWriter out = new PrintWriter(new DataOutputStream(
								socket1.getOutputStream()));
						PrintWriter out2 = new PrintWriter(new DataOutputStream(
								socket2.getOutputStream()));
						PrintWriter out3 = new PrintWriter(new DataOutputStream(
								socket3.getOutputStream()));
						out.print("AVD0: " + Integer.toString(sequencerCounter));
						out2.print("AVD0: " + Integer.toString(sequencerCounter));
						out3.print("AVD0: " + Integer.toString(sequencerCounter));
						out.flush();
						out2.flush();
						out3.flush();
						socket1.close();
						socket2.close();
						socket3.close();
						Thread.sleep(3000);
						sequencerCounter++;
						}
					}

					else if (params[0].equals("5556")) {
						for (int i = 0; i < 5; i++) {
							socket1 = new Socket("10.0.2.2", 11112);
							socket2 = new Socket("10.0.2.2", 11116);
							socket3 = new Socket("10.0.2.2", 11108);
							PrintWriter out = new PrintWriter(new DataOutputStream(
									socket1.getOutputStream()));
							PrintWriter out2 = new PrintWriter(new DataOutputStream(
									socket2.getOutputStream()));
							PrintWriter out3 = new PrintWriter(new DataOutputStream(
									socket3.getOutputStream()));
							out.print("AVD1: " + Integer.toString(sequencerCounter));
							out2.print("AVD1: " + Integer.toString(sequencerCounter));
							out3.print("AVD1: " + Integer.toString(sequencerCounter));
							out.flush();
							out2.flush();
							out3.flush();
							socket1.close();
							socket2.close();
							socket3.close();
							Thread.sleep(3000);
							sequencerCounter++;
						}
					}

					else {
						for (int i = 0; i < 5; i++) {
							socket1 = new Socket("10.0.2.2", 11112);
							socket2 = new Socket("10.0.2.2", 11116);
							socket3 = new Socket("10.0.2.2", 11108);
							PrintWriter out = new PrintWriter(new DataOutputStream(
									socket1.getOutputStream()));
							PrintWriter out2 = new PrintWriter(new DataOutputStream(
									socket2.getOutputStream()));
							PrintWriter out3 = new PrintWriter(new DataOutputStream(
									socket3.getOutputStream()));
							out.print("AVD2: " + Integer.toString(sequencerCounter));
							out2.print("AVD2: " + Integer.toString(sequencerCounter));
							out3.print("AVD2: " + Integer.toString(sequencerCounter));
							out.flush();
							out2.flush();
							out3.flush();
							socket1.close();
							socket2.close();
							socket3.close();
							Thread.sleep(3000);
							sequencerCounter++;
						}
					}
			} // end try

			catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			return null;
		}

	}
	
	// Test1 listener
	public void test1(View view){
		TelephonyManager tel = (TelephonyManager) getBaseContext()
				.getSystemService(Context.TELEPHONY_SERVICE);
		final String portStr = tel.getLine1Number().substring(
				tel.getLine1Number().length() - 4); //
		//final EditText editText = (EditText) findViewById(R.id.editText1);		
		//TextView textView = (TextView) findViewById(R.id.textView1);
		new Test1().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, portStr);
		
	}
	
/************************************* END TEST 1 ************************************************/
	
/*************************************** TEST 2 **************************************************/
	// Test1 class
		public class Test2 extends AsyncTask<String, String, Void> {
			static final String avd0 = "5554";
			static final String avd1 = "5556";
			static final String avd2 = "5558";
			

			@Override
			protected Void doInBackground(String... params) {

				try {
					Socket socket1 = null;
					Socket socket2 = null;
					Socket socket3 = null;
					
					
						if (params[0].equals("5554")) {
							socket1 = new Socket("10.0.2.2", 11112);
							socket2 = new Socket("10.0.2.2", 11116);
							socket3 = new Socket("10.0.2.2", 11108);
							PrintWriter out = new PrintWriter(new DataOutputStream(
									socket1.getOutputStream()));
							PrintWriter out2 = new PrintWriter(new DataOutputStream(
									socket2.getOutputStream()));
							PrintWriter out3 = new PrintWriter(new DataOutputStream(
									socket3.getOutputStream()));
							out.print("avd0: " + Integer.toString(sequencerCounter) + " out" + "\n");
							out2.print("avd0: " + Integer.toString(sequencerCounter) + " out" + "\n");
							out3.print("avd0: " + Integer.toString(sequencerCounter) + " out" + "\n");
			
							out.flush();
							out2.flush();
							out3.flush();
							socket1.close();
							socket2.close();
							socket3.close();
							Thread.sleep(3000);
							sequencerCounter++;
						}

						else if (params[0].equals("5556")) {
								socket1 = new Socket("10.0.2.2", 11112);
								socket2 = new Socket("10.0.2.2", 11116);
								socket3 = new Socket("10.0.2.2", 11108);
								
								PrintWriter out = new PrintWriter(new DataOutputStream(
										socket1.getOutputStream()));
								PrintWriter out2 = new PrintWriter(new DataOutputStream(
										socket2.getOutputStream()));
								PrintWriter out3 = new PrintWriter(new DataOutputStream(
										socket3.getOutputStream()));
								
								out.print("avd1: " + Integer.toString(sequencerCounter));
								out2.print("avd1: " + Integer.toString(sequencerCounter));
								out3.print("avd1: " + Integer.toString(sequencerCounter));
								out.flush();
								out2.flush();
								out3.flush();
								socket1.close();
								socket2.close();
								socket3.close();
								Thread.sleep(3000);
								sequencerCounter++;
						}

						else {
								socket1 = new Socket("10.0.2.2", 11112);
								socket2 = new Socket("10.0.2.2", 11116);
								socket3 = new Socket("10.0.2.2", 11108);
								PrintWriter out = new PrintWriter(new DataOutputStream(
										socket1.getOutputStream()));
								PrintWriter out2 = new PrintWriter(new DataOutputStream(
										socket2.getOutputStream()));
								PrintWriter out3 = new PrintWriter(new DataOutputStream(
										socket3.getOutputStream()));
								out.print("avd2: " + Integer.toString(sequencerCounter));
								out2.print("avd2: " + Integer.toString(sequencerCounter));
								out3.print("avd2: " + Integer.toString(sequencerCounter));
								out.flush();
								out2.flush();
								out3.flush();
								socket1.close();
								socket2.close();
								socket3.close();
								Thread.sleep(3000);
								sequencerCounter++;
						}
				} // end try

				catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				return null;
			}
			
		}
	
	
	// Test2 listener
		public void test2(View view){
			TelephonyManager tel = (TelephonyManager) getBaseContext()
					.getSystemService(Context.TELEPHONY_SERVICE);
			final String portStr = tel.getLine1Number().substring(
					tel.getLine1Number().length() - 4); //
			portID = portStr;
			new Test2().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, portStr);
			
		}	
	
/************************************* END TEST 2 ************************************************/
	
	public void sendMessage(View view) {
		TelephonyManager tel = (TelephonyManager) this
				.getSystemService(Context.TELEPHONY_SERVICE); // container of
																// device last 4
																// digit
		final String portStr = tel.getLine1Number().substring(
				tel.getLine1Number().length() - 4); //
		final EditText editText = (EditText) findViewById(R.id.editText1); // creates an edit text to input text
							
		String msg = editText.getText().toString();

		new ClientTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,
				portStr, msg);

	}

	/******************************** SERVER TASK *******************************/
	private class ServerTask extends AsyncTask<String, String, Void> {

		@Override
		protected Void doInBackground(String... msgs) {
			ServerSocket serverSocket = null;
			try {
				serverSocket = new ServerSocket(10000);
			} catch (IOException e2) {
				e2.printStackTrace();
			}

			Socket socket;
			String msg;

			try {
				while (true) {
					socket = serverSocket.accept();
					BufferedReader in = new BufferedReader(
							new InputStreamReader(socket.getInputStream()));
					msg = in.readLine();
					publishProgress(msg);
					in.close();
					socket.close();
				}
			}

			catch (IOException e) {}
			return null;
		}

		protected void onProgressUpdate(String... string) { // This sends the
															// message to the
															// other device
			
			if(string[0].contains("avd0")){
				
					TextView textView = (TextView) findViewById(R.id.textView1);
					textView.append(string[0] + "\n" );	
					new ClientTask().executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, "5554", "response to avd 0");
					new ClientTask().executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, "5556", "response to avd 0");

			}
			else if(string[0].contains("avd1")){
				
					TextView textView = (TextView) findViewById(R.id.textView1);
					textView.append(string[0] + "\n");	
					new ClientTask().executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, "5554", "response to avd 1");
					new ClientTask().executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, "5556", "response to avd 1");
				
			}
			else if(string[0].contains("avd2")){
				
					TextView textView = (TextView) findViewById(R.id.textView1);
					textView.append(string[0] + "\n");	
					new ClientTask().executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, "5554", "response to avd 2");
					new ClientTask().executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, "5556", "response to avd 2");
				
			}
			else{
				TextView textView = (TextView) findViewById(R.id.textView1);
				textView.append(string[0] + "\n");
			}
		}
	}

	/****************************** CLIENT TASK ********************************************/
	private class ClientTask extends AsyncTask<String, String, Void> {

		protected Void doInBackground(String... msgs) {

			Socket socket1 = null;
			Socket socket2 = null;
			Socket socket3 = null;

			try {
				String client = "ClientTask";

				if (msgs[0].equals("5554")) {
					socket1 = new Socket("10.0.2.2", 11112);
					socket2 = new Socket("10.0.2.2", 11116);
					socket3 = new Socket("10.0.2.2", 11108);
					PrintWriter out = new PrintWriter(new DataOutputStream(
							socket1.getOutputStream()));
					PrintWriter out2 = new PrintWriter(new DataOutputStream(
							socket2.getOutputStream()));
					PrintWriter out3 = new PrintWriter(new DataOutputStream(
							socket3.getOutputStream()));
					out.print(msgs[1]);
					out2.print(msgs[1]);
					out3.print(msgs[1]);
					out.flush();
					out2.flush();
					out3.flush();
					socket1.close();
					socket2.close();
					socket3.close();
				}

				else if (msgs[0].equals("5556")) {
					socket1 = new Socket("10.0.2.2", 11108);
					socket2 = new Socket("10.0.2.2", 11116);
					socket3 = new Socket("10.0.2.2", 11112);
					PrintWriter out = new PrintWriter(new DataOutputStream(
							socket1.getOutputStream()));
					PrintWriter out2 = new PrintWriter(new DataOutputStream(
							socket2.getOutputStream()));
					PrintWriter out3 = new PrintWriter(new DataOutputStream(
							socket3.getOutputStream()));
					out.print(msgs[1]);
					out2.print(msgs[1]);
					out3.print(msgs[1]);
					out.flush();
					out2.flush();
					out3.flush();
					socket1.close();
					socket2.close();
					socket3.close();
				}

				else {
					socket1 = new Socket("10.0.2.2", 11108);
					socket2 = new Socket("10.0.2.2", 11112);
					socket3 = new Socket("10.0.2.2", 11116);
					PrintWriter out = new PrintWriter(new DataOutputStream(
							socket1.getOutputStream()));
					PrintWriter out2 = new PrintWriter(new DataOutputStream(
							socket2.getOutputStream()));
					PrintWriter out3 = new PrintWriter(new DataOutputStream(
							socket3.getOutputStream()));
					out.print(msgs[1]);
					out2.print(msgs[1]);
					out3.print(msgs[1]);
					out.flush(); 
					out2.flush();
					out3.flush();
					socket1.close();
					socket2.close();
					socket3.close();
				}
			}

			catch (IOException e) {
			}
			;
			return null;

		}// end doInBackground
	}// end ClientTask
}