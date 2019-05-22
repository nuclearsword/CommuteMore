package com.dunbar.commutemore;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class dbHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "commuteMore.db";

    public dbHelper(Context context){super(context, DATABASE_NAME, null, 1)}

    @Override
    public void onCreate(SQLiteDatabase db){
        //create tables here
        /*db.execSQL("CREATE TABLE TERM(" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "title TEXT, " +
                "startDate DATE, " +
                "endDate DATE" +
                ")");
        db.execSQL("CREATE TABLE COURSENOTES(" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "courseId INTEGER, " +
                "notes TEXT," +
                "FOREIGN KEY(courseId) REFERENCES COURSE(ID)" +
                ")");*/
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        //drop table statements. One per table.
        /*db.execSQL("DROP TABLE IF EXISTS COURSE");
        db.execSQL("DROP TABLE IF EXISTS TERM");*/
        onCreate(db);
    }

    //CRUD
    /*public Term getTerm(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM TERM WHERE id = " + id,null);

        Term termToReturn = new Term();
        termToReturn.setId(id);

        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            try{
                termToReturn.setTitle(cursor.getString(cursor.getColumnIndex("title")));
                termToReturn.setStartDate((new SimpleDateFormat("MM/dd/yyyy")).parse(cursor.getString(cursor.getColumnIndex("startDate"))));
                termToReturn.setEndDate((new SimpleDateFormat("MM/dd/yyyy")).parse(cursor.getString(cursor.getColumnIndex("endDate"))));
            }catch (ParseException e){
                System.out.println(e.getMessage());
            }
        }
        return termToReturn;
    }
    public ArrayList<Term> getTerms(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM TERM",null);

        ArrayList<Term> termsToReturn = new ArrayList<>();

        if(cursor.getCount() > 0){
            while(cursor.moveToNext()){
                try{
                    Term term = new Term();
                    term.setId(cursor.getInt(cursor.getColumnIndex("ID")));
                    term.setTitle(cursor.getString(cursor.getColumnIndex("title")));
                    term.setStartDate(new SimpleDateFormat("MM/dd/yyyy").parse(cursor.getString(cursor.getColumnIndex("startDate"))));
                    term.setEndDate(new SimpleDateFormat("MM/dd/yyyy").parse(cursor.getString(cursor.getColumnIndex("endDate"))));
                    termsToReturn.add(term);
                }catch(ParseException e){
                    System.out.println(e.getMessage());
                }
            }
        }
        return termsToReturn;
    }
    public Boolean insertTerm(Term term){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("title", term.getTitle());
        values.put("startDate",(new SimpleDateFormat("MM/dd/yyyy")).format(term.getStartDate()));
        values.put("endDate",(new SimpleDateFormat("MM/dd/yyyy")).format(term.getEndDate()));
        long result = db.insert("TERM",null,values);
        if(result != -1){
            return true;
        }else{
            return false;
        }
    }
    public boolean updateTerm(Term term){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id",term.getId());
        values.put("title", term.getTitle());
        values.put("startDate",(new SimpleDateFormat("MM/dd/yyyy")).format(term.getStartDate()));
        values.put("endDate",(new SimpleDateFormat("MM/dd/yyyy")).format(term.getEndDate()));
        long result = db.update("TERM",values,"ID = ?",new String[] { Integer.toString(term.getId()) });
        if(result != -1){
            return true;
        }else{
            return false;
        }
    }
    public Integer deleteTerm(int termId){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("TERM","ID = ?", new String[] {Integer.toString(termId)});
    }*/
}
