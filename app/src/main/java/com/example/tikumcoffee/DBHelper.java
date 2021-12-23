//package com.example.tikumcoffee;
//
//import android.content.Context;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//
//public class DBHelper extends SQLiteOpenHelper {
//    public static final String DBNAME = "TikumCoffee.db";
//
//    public DBHelper(Context context){
//
//        super(context,"TikumCoffee.db",null,1);
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        String users = "CREATE TABLE users (customerId int NOT NULL PRIMARY KEY AUTOINCREMENT, " +
//                "namaCustomer TEXT," +
//                "password TEXT," +
//                "email TEXT)";
//        db.execSQL(users);
//        String Coffee = "CREATE TABLE Coffee(coffeeId int NOT NULL PRIMARY KEY AUTOINCREMENT, " +
//                "coffeeName TEXT," +
//                " coffeeDescription TEXT," +
//                " coffePrice int," +
//                "coffeeImage TEXT )";
//        db.execSQL(Coffee);
//        String order = "CREATE TABLE orders(orderId int NOT NULL PRIMARY KEY AUTOINCREMENT, " +
//                "dateOrder DATE," +
//                "statusOrder TEXT)";
//        db.execSQL(order);
//        String OrderDetail = "CREATE TABLE detailOrder(detailOrderId int NOT NULL PRIMARY KEY AUTOINCREMENT ,qty int, price int," +
//                "REFERENCE )";
//        db.execSQL(OrderDetail);
//    }
//}
