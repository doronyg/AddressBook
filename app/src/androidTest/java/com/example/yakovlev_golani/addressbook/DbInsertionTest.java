package com.example.yakovlev_golani.addressbook;

import android.test.AndroidTestCase;

import com.example.yakovlev_golani.addressbook.models.RandomUsers;
import com.example.yakovlev_golani.addressbook.models.User;
import com.example.yakovlev_golani.addressbook.utils.ApiUtils;
import com.example.yakovlev_golani.addressbook.utils.DbHelper;
import com.example.yakovlev_golani.addressbook.utils.NetworkResponseParser;

import junit.framework.Assert;

import java.util.List;

public class DbInsertionTest extends AndroidTestCase {

    final static String EXAMPLE_RESPONSE = "{\"results\":[{\"user\":{\"gender\":\"female\",\"name\":{\"title\":\"mrs\",\"first\":\"wanda\",\"last\":\"riley\"},\"location\":{\"street\":\"6176 railroad st\",\"city\":\"fayetteville\",\"state\":\"new mexico\",\"zip\":\"41534\"},\"email\":\"wanda.riley66@example.com\",\"username\":\"orangemouse233\",\"password\":\"resident\",\"salt\":\"dS0LXOEH\",\"md5\":\"a8cdd06a0670e13c9a80cdc1b49166a3\",\"sha1\":\"fcc2c50a5328d0eb74a1aff5263200c2c8a62024\",\"sha256\":\"b9c8d738904d0b1940b38f481d3890e0539689d2befc9836d275fda3c91bb3e1\",\"registered\":\"1216126043\",\"dob\":\"471446514\",\"phone\":\"(181)-337-5712\",\"cell\":\"(266)-154-6989\",\"SSN\":\"761-95-8505\",\"picture\":{\"large\":\"http://api.randomuser.me/portraits/women/74.jpg\",\"medium\":\"http://api.randomuser.me/portraits/med/women/74.jpg\",\"thumbnail\":\"http://api.randomuser.me/portraits/thumb/women/74.jpg\"},\"version\":\"0.4.1\"},\"seed\":\"e7836fbaadc96c97\"},{\"user\":{\"gender\":\"male\",\"name\":{\"title\":\"mr\",\"first\":\"fernando\",\"last\":\"morgan\"},\"location\":{\"street\":\"4586 cherry st\",\"city\":\"frederick\",\"state\":\"maryland\",\"zip\":\"43114\"},\"email\":\"fernando.morgan65@example.com\",\"username\":\"smallduck86\",\"password\":\"paradox\",\"salt\":\"C6c8K5f1\",\"md5\":\"801da4be428b0eea93565b20274a2df0\",\"sha1\":\"f933d52f280bf82ad7c9e543a6ac86c55a10ddcb\",\"sha256\":\"cce54f599a30cfef24783c40382be66598aa6eab8bf68e20c10f2a811faca05c\",\"registered\":\"1347579386\",\"dob\":\"156203054\",\"phone\":\"(390)-816-3935\",\"cell\":\"(256)-638-1250\",\"SSN\":\"755-57-1515\",\"picture\":{\"large\":\"http://api.randomuser.me/portraits/men/23.jpg\",\"medium\":\"http://api.randomuser.me/portraits/med/men/23.jpg\",\"thumbnail\":\"http://api.randomuser.me/portraits/thumb/men/23.jpg\"},\"version\":\"0.4.1\"},\"seed\":\"6a4b2aa52cadf5fa\"},{\"user\":{\"gender\":\"male\",\"name\":{\"title\":\"mr\",\"first\":\"travis\",\"last\":\"ortiz\"},\"location\":{\"street\":\"5076 mcgowen st\",\"city\":\"albany\",\"state\":\"north dakota\",\"zip\":\"46227\"},\"email\":\"travis.ortiz45@example.com\",\"username\":\"tinywolf234\",\"password\":\"oklahoma\",\"salt\":\"gAURJ6jR\",\"md5\":\"50b8619d75d09dd793b3a37838f5d1b0\",\"sha1\":\"9e81238636a7b1d88c9c430d9f02733bf85ef210\",\"sha256\":\"ab2481ab756f16df6ddadd7dd02f1896ed1141993b3d0aeaab6a7cd34362ccce\",\"registered\":\"1360230149\",\"dob\":\"369997531\",\"phone\":\"(662)-152-9497\",\"cell\":\"(339)-563-3622\",\"SSN\":\"678-32-8559\",\"picture\":{\"large\":\"http://api.randomuser.me/portraits/men/15.jpg\",\"medium\":\"http://api.randomuser.me/portraits/med/men/15.jpg\",\"thumbnail\":\"http://api.randomuser.me/portraits/thumb/men/15.jpg\"},\"version\":\"0.4.1\"},\"seed\":\"d93a10d51f15a7e6\"}]}";

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        DbHelper.clearDb();
    }

    public void testDbInsertion() {
        NetworkResponseParser<RandomUsers> parser = new NetworkResponseParser<>(RandomUsers.class);

        RandomUsers randomUsers = parser.parse(EXAMPLE_RESPONSE);

        DbHelper.DbFetchDoneListener dbFetchDoneListener = new DbHelper.DbFetchDoneListener() {
            @Override
            public void onDone() {}
        };

        DbHelper.getRandomUsersApiListener(dbFetchDoneListener).onSuccess(randomUsers);

        List<User> users = DbHelper.getUsers();
        Assert.assertEquals(3, users.size());
        User user = users.get(0);
        Assert.assertNotNull(user);
        Assert.assertNotNull(user.getLocation());
        Assert.assertNotNull(user.getName());
        Assert.assertNotNull(user.getPicture());
        Assert.assertNotNull(user.getCell());
        Assert.assertNotNull(user.getEmail());
        DbHelper.clearDb();
    }


}
