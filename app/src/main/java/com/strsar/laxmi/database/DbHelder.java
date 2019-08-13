package com.strsar.laxmi.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelder extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "productD" +
            ".db";


    public  static final String  TABLE_SUB_PRODUCTS_LIST="sub_product_list";
    // coloum
    public  static final String  TABLE_SUB_PRODUCTS_LIST_PRODUCT_ID="product_id";
    public  static final String  TABLE_SUB_PRODUCTS_LIST_P_C_IDS="p_c_ids";
    public  static final String  TABLE_SUB_PRODUCTS_LIST_PS_IDS="ps_ids";


    public DbHelder(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String NOTIFICATIONS ="CREATE TABLE " + TABLE_SUB_PRODUCTS_LIST + "("
                + TABLE_SUB_PRODUCTS_LIST_PRODUCT_ID + " TEXT,"
                + TABLE_SUB_PRODUCTS_LIST_P_C_IDS + " DATETIME DEFAULT CURRENT_TIMESTAMP,"
                + TABLE_SUB_PRODUCTS_LIST_PS_IDS+ " DATETIME " + ")";
        sqLiteDatabase.execSQL(NOTIFICATIONS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DELETE FROM  " + TABLE_SUB_PRODUCTS_LIST);
    }


    public boolean notificationInsert(String product_id,String p_c_ids,String ps_ids){
        ContentValues values = new ContentValues();
        values.put(TABLE_SUB_PRODUCTS_LIST_PRODUCT_ID, product_id);
        values.put(TABLE_SUB_PRODUCTS_LIST_P_C_IDS, p_c_ids);
        values.put(TABLE_SUB_PRODUCTS_LIST_PS_IDS, ps_ids);

        SQLiteDatabase db = getWritableDatabase();

        long result= db.insert(TABLE_SUB_PRODUCTS_LIST, null, values);
        if (result==-1)
            return false;
        else
            return true;
    }
    public Cursor getSelectedData(){
        SQLiteDatabase sqLiteDatabas = this.getWritableDatabase();
        String countQuery = "SELECT * FROM "+TABLE_SUB_PRODUCTS_LIST;// +" where p_c_ids="+passedArg;//+"ORDER BY "+MEAL_ID;//  meal_type=1 ";

        Cursor res = sqLiteDatabas.rawQuery( countQuery,null);

        return res;
    }
}
