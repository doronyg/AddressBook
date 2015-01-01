package com.example.yakovlev_golani.addressbook.utils;

import android.os.AsyncTask;

import com.example.yakovlev_golani.addressbook.models.RandomUsers;

import java.util.Locale;

public class ApiUtils {

    public static abstract class RandomUsersApiListener{
        public abstract void onSuccess(RandomUsers users);
        public abstract void onFailure();
    }

    final static String GET_USERS_LIST_URL = "http://api.randomuser.me/?results=100";

    public static void getRandomUsers(final RandomUsersApiListener listener){
        new AsyncTask<Void, Void, RandomUsers>(){
            @Override
            protected RandomUsers doInBackground(Void... params) {
                try {
                    String url = GET_USERS_LIST_URL;
                    NetworkResponseParser<RandomUsers> networkResponseParser = new NetworkResponseParser<>(RandomUsers.class);
                    return networkResponseParser.getResponse(url);
                } catch (Throwable throwable){
                    throwable.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(RandomUsers users) {
                super.onPostExecute(users);
                if (users == null){
                    listener.onFailure();
                } else {
                    listener.onSuccess(users);
                }
            }
        }.execute();
    }

}
