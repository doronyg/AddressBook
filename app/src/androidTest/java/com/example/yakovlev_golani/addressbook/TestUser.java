package com.example.yakovlev_golani.addressbook;

import android.test.AndroidTestCase;
import android.test.suitebuilder.annotation.Suppress;

import com.example.yakovlev_golani.addressbook.models.Location;
import com.example.yakovlev_golani.addressbook.models.Name;
import com.example.yakovlev_golani.addressbook.models.Picture;
import com.example.yakovlev_golani.addressbook.models.User;
import com.example.yakovlev_golani.addressbook.utils.DbHelper;

import junit.framework.Assert;

import java.util.List;

public class TestUser extends AndroidTestCase {

    @Suppress
    public static void addUserForTest(String name1){
        Name name = new Name();
        name.setTitle("Mr.");
        name.setFirst(name1);
        name.setLast("Yakovlev Golani");
        name.save();

        Location location = new Location();
        location.setCity("Toronto");
        location.setStreet("1 King Street East");
        location.setState("Ontario");
        location.save();

        Picture picture = new Picture();
        picture.setLarge("http://api.randomuser.me/portraits/men/66.jpg");
        picture.setMedium("http://api.randomuser.me/portraits/med/men/66.jpg");
        picture.setThumbnail("http://api.randomuser.me/portraits/thumb/men/66.jpg");
        picture.save();

        User user = new User();
        user.setName(name);
        user.setLocation(location);
        user.setPicture(picture);
        user.setEmail("rafael.horton72@example.com");
        user.setCell("647-555-5555");
        user.save();
    }

    public void testAddUser(){
        DbHelper.clearDb();
        addUserForTest("Doron");
        List<User> users = DbHelper.getUsers();
        Assert.assertEquals(1, users.size());
        User dbUser = users.get(0);

        Name dbUserName = dbUser.getName();
        Assert.assertEquals("Doron", dbUserName.getFirst());
        Assert.assertEquals("Yakovlev Golani", dbUserName.getLast());
        Assert.assertEquals("Mr.", dbUserName.getTitle());

        Assert.assertEquals("647-555-5555", dbUser.getCell());
        Assert.assertEquals("rafael.horton72@example.com", dbUser.getEmail());

        Location dbUserLocation = dbUser.getLocation();
        Assert.assertEquals("Toronto", dbUserLocation.getCity());
        Assert.assertEquals("1 King Street East", dbUserLocation.getStreet());
        Assert.assertEquals("Ontario", dbUserLocation.getState());

        DbHelper.clearDb();
        List<User> usersListAfterDelete = DbHelper.getUsers();
        Assert.assertEquals(0, usersListAfterDelete.size());
    }

    public void testAddMultipleUsers(){
        DbHelper.clearDb();

        addUserForTest("Doron2");
        addUserForTest("Doron1");
        addUserForTest("Doron3");
        List<User> users = DbHelper.getSortedUserList();
        Assert.assertEquals(3, users.size());

        Assert.assertEquals("Doron1", users.get(0).getName().getFirst());
        Assert.assertEquals("Doron2", users.get(1).getName().getFirst());
        Assert.assertEquals("Doron3", users.get(2).getName().getFirst());
        DbHelper.clearDb();
    }

}
