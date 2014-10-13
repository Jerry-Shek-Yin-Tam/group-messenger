package edu.buffalo.cse.cse486586.groupmessenger;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.util.Log;

public class MessengerContentProvider extends ContentProvider {

	private static final String dbname = "chat_history";
	private static final String chatHistory = "chat_history";
	private SQLiteDatabase database;
	private DatabaseHelper dbHelper;
	private Uri CONTENT_URI;
	

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		//Log.i("insert", values.getAsString("key") + " " + values.getAsString("value"));
		database = dbHelper.getWritableDatabase();
		database.insert(chatHistory, null, values);
		return CONTENT_URI;
	}

	@Override
	public boolean onCreate() {
		dbHelper = new DatabaseHelper(getContext());
		CONTENT_URI = buildUri("content",
				"edu.buffalo.cse.cse486586.groupmessenger.provider");
		return true;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		SQLiteDatabase dbQuery = dbHelper.getReadableDatabase();
		return database.query(true, chatHistory, projection, "key = '"
				+ selection + "'", null, null, null, null, null, null);
		// TODO Auto-generated method stub
	}

	static class DatabaseHelper extends SQLiteOpenHelper {

		public DatabaseHelper(Context context) {
			super(context, dbname, null, 1);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL("CREATE TABLE chat_history( key TEXT, value TEXT)");

		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub

		}

	}

	// //////////////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public String getType(Uri uri) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}

	private Uri buildUri(String scheme, String authority) {
		Uri.Builder uriBuilder = new Uri.Builder();
		uriBuilder.authority(authority);
		uriBuilder.scheme(scheme);
		return uriBuilder.build();
	}

}
