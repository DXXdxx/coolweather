package com.coolweather.app.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class CoolWeatherOpenHelper extends SQLiteOpenHelper {
    /**
     * Province表建表语句
     */
	public static final String CREATE_PROVICE = "Create table Provice (" + "id integer primary key autoincrement, "
                 + "province_name text, " 
			     + "province_code text)";
	/**
	 * City表建表语句
	 */
	public static final String CREATE_CITY = "Create table City (" + "id integer primary key autoincrement, "
	             + "city_name text" 
			     + "city_code text"
	             + "province_id integer)";
	/**
	 * County表建表语句
	 */
	public static final String CREATE_COUNY = "Create table County (" + "id integer primary key autoincrement, "
	             + "county_name text"
			     + "county_code text"
	             + "city_id integer)";
	
	
	public CoolWeatherOpenHelper(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_PROVICE);
		db.execSQL(CREATE_CITY);
		db.execSQL(CREATE_COUNY);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}
}
