package com.example.feelman_museum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class test extends AppCompatActivity {

    DBHelper helper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView =(ListView)findViewById(R.id.listview);

        helper = new DBHelper(test.this, "newdb.db", null, 1);
        db = helper.getWritableDatabase();
        helper.onCreate(db);

//        String sql1 = "INSERT INTO mytable('txt') values('상준이형');";
//        db.execSQL(sql1);

        String sql = "select * from mytable;";
        Cursor c = db.rawQuery(sql, null);
        String[] strs = new String[]{"txt"};
        int[] ints = new int[] {R.id.listview_txt};

        SimpleCursorAdapter adapter = null;
        adapter = new SimpleCursorAdapter(listView.getContext(), R.layout.listview, c, strs, ints,0);

        listView.setAdapter(adapter);

    }
}