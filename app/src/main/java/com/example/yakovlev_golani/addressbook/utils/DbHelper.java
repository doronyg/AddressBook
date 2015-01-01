package com.example.yakovlev_golani.addressbook.utils;

import android.util.Log;

import com.example.yakovlev_golani.addressbook.models.Location;
import com.example.yakovlev_golani.addressbook.models.Name;
import com.example.yakovlev_golani.addressbook.models.Picture;
import com.example.yakovlev_golani.addressbook.models.RandomUsers;
import com.example.yakovlev_golani.addressbook.models.Result;
import com.example.yakovlev_golani.addressbook.models.User;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public class DbHelper {

    public static List<User> getUsers() {
        try {
            return User.listAll(User.class);
        } catch (Throwable throwable){
            return null;
        }

    }

    public static List<User> getSortedUserList(){
        List<User> users = getUsers();
        Collections.sort(users);
        return users;
    }

    public static void createDbFromSampleData(final DbFetchDoneListener dbFetchDoneListener){
        ApiUtils.getRandomUsers(getRandomUsersApiListener(dbFetchDoneListener));
    }

    public static ApiUtils.RandomUsersApiListener getRandomUsersApiListener(final DbFetchDoneListener dbFetchDoneListener) {
        return new ApiUtils.RandomUsersApiListener() {
            @Override
            public void onSuccess(RandomUsers users) {
                if (users != null){
                    for (Result result: users.getResults()){
                        User user = result.getUser();
                        boolean saved = false;
                        if (user != null) {

                            Name name = user.getName();
                            Location location = user.getLocation();
                            Picture picture = user.getPicture();
                            if (name != null && location != null && picture != null) {
                                picture.save();
                                name.save();
                                location.save();
                                user.save();
                                saved = true;
                            }
                        }

                        if (!saved){
                            Log.w("db", "User not saved");
                        }
                    }
                }
                dbFetchDoneListener.onDone();
            }

            @Override
            public void onFailure() {
                dbFetchDoneListener.onDone();
            }
        };
    }

    public static void clearDb(){
        try {
            User.deleteAll(User.class);
            Name.deleteAll(Name.class);
            Picture.deleteAll(Picture.class);
            Location.deleteAll(Location.class);
        } catch (Throwable throwable){

        }
    }

    public static abstract class DbFetchDoneListener{
        public abstract void onDone();
    }
}
