package com.serif.sqlproject;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{
            //1-----VERİ TABANI OLUŞTURMA-----
    SQLiteDatabase database=this.openOrCreateDatabase("Musicians",MODE_PRIVATE,null);
           //-------TABLO OLUŞTURMA-------SAYFA SHİFT
    database.execSQL("CREATE TABLE IF NOT EXISTS musicians(name VARCHAR, age INTEGER)");// bir tablo oluştur eğer yoksa
            //TABLOYA VERİ EKLEME
    database.execSQL("INSERT INTO musicians (name,age)VALUES('Ferdi Tayfur',70)");
   // database.execSQL("INSERT INTO musicians (name,age)VALUES('Orhan Gencebay',70)");
   // database.execSQL("INSERT INTO musicians (name,age)VALUES('Müslüm  Gürses',65)");
            //OKUMA-ÇEKME
    Cursor cursor=database.rawQuery("SELECT*FROM musicians",null); // musicians içindeki herşeyi çek
            // Cursor a hangi colum(sütun)lara gideceğini söyleme
    int nameIx=cursor.getColumnIndex("name"); // name in index ine gider
    int ageIx=cursor.getColumnIndex("age");   // age in index ine gider

            // while loop ile cursor ilerleyebildiği kadar gitsin bütün verileri tek tek gezsin
            // ve o sırada benim yapmak istediğim bazı şeyler var:"değerleri okumak"

            //CONSOLO YAZDIRMA
       while (cursor.moveToNext()){

           System.out.println("Name: "+cursor.getString(nameIx));
           System.out.println("Age: "+cursor.getInt(ageIx));
       }
       cursor.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}