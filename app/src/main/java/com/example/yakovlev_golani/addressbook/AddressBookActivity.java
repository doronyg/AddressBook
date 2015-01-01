package com.example.yakovlev_golani.addressbook;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.yakovlev_golani.addressbook.adapters.ListAdapter;
import com.example.yakovlev_golani.addressbook.models.User;
import com.example.yakovlev_golani.addressbook.utils.DbHelper;

import java.util.List;


public class AddressBookActivity extends ActionBarActivity {
    ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_book);

        List<User> users = DbHelper.getUsers();
        if (users == null || users.size() == 0) {
            DbHelper.createDbFromSampleData(new DbHelper.DbFetchDoneListener() {
                @Override
                public void onDone() {
                    initList();
                }
            });
        } else {
            initList();
        }


    }

    private void initList(){
        listAdapter = new ListAdapter(DbHelper.getSortedUserList());
        ((RecyclerView)findViewById(R.id.address_recycler_view)).setAdapter(listAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_address_book, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
