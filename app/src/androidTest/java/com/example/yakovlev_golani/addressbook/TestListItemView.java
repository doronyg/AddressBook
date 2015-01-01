package com.example.yakovlev_golani.addressbook;

import android.test.ActivityTestCase;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.example.yakovlev_golani.addressbook.models.User;
import com.example.yakovlev_golani.addressbook.utils.DbHelper;
import com.example.yakovlev_golani.addressbook.views.AddressListItemView;

import junit.framework.Assert;

import java.util.List;

public class TestListItemView extends ActivityTestCase {

    private AddressListItemView addressListItem;
    boolean setupDone = false;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        setActivity(launchActivity("com.example.yakovlev_golani.addressbook", AddressBookActivity.class, null));
        DbHelper.clearDb();
        TestUser.addUserForTest("Doron");
        addressListItem = (AddressListItemView) LayoutInflater.from(getActivity())
                .inflate(R.layout.address_list_item, null);

        List<User> users = DbHelper.getUsers();
        final User dbUser = users.get(0);

        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                addressListItem.setUser(dbUser);
                setupDone = true;
            }
        });

        while (!setupDone) {
            Thread.sleep(100);
        }
    }

    public void testViewPopulation() {
        Assert.assertEquals("Doron", ((TextView) addressListItem.findViewById(R.id.firstName)).getText());
        Assert.assertEquals("Yakovlev Golani", ((TextView) addressListItem.findViewById(R.id.lastName)).getText());
        Assert.assertEquals("1 King Street East, Toronto, Ontario", ((TextView) addressListItem.findViewById(R.id.addressText)).getText());
    }


}
