package com.example.the_cake_fairy;

import android.content.Context;
import android.database.CursorIndexOutOfBoundsException;
import android.database.sqlite.SQLiteDatabase;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import com.example.the_cake_fairy.Database.DBHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;

@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    DBHandler database;
    SQLiteDatabase db1;
    SQLiteDatabase db2;

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.the_cake_fairy", appContext.getPackageName());
    }

    @Before
    public void setUp(){
        database = new DBHandler(InstrumentationRegistry.getInstrumentation().getTargetContext());
    }

    @After
    public void finish(){
        db1.close();
        db2.close();
    }

    @Test
    public void testNotNullDB(){
        assertNotNull(database);
    }

    @Test
    public void addInfo() throws CursorIndexOutOfBoundsException{
        String cakename = "cakename";
        String  weight = "weight";
        String category = "category";
        String price = "price";
        long result = database.addInfo(cakename,weight,category,price);
        //assertTrue(result);
    }

    @Test
    public void updateInfo() throws CursorIndexOutOfBoundsException{
        String cakename = "cakename";
        String  weight = "weight";
        String category = "category";
        String price = "price";
        boolean result = database.updateInfo(cakename,weight,category,price);
        assertTrue(result);
    }

    @Test
    public void deleteInfo() throws CursorIndexOutOfBoundsException{
        String cakename = "cakename";
        boolean result = database.deleteInfo(cakename);
        assertTrue(result);
    }

}