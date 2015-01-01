package com.example.yakovlev_golani.addressbook.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.yakovlev_golani.addressbook.R;
import com.example.yakovlev_golani.addressbook.models.Location;
import com.example.yakovlev_golani.addressbook.models.Name;
import com.example.yakovlev_golani.addressbook.models.User;
import com.squareup.picasso.Picasso;

public class AddressListItemView extends LinearLayout {

    private ImageView thumbnailImage;
    private TextView firstName;
    private TextView lastName;
    private TextView addressText;
    private User user;

    public AddressListItemView(Context context) {
        super(context);
    }

    public AddressListItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AddressListItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setUser(User user){
        this.user = user;
        initViews();
        Picasso.with(getContext()).load(user.getPicture().getMedium()).into(thumbnailImage);

        Name name = user.getName();
        firstName.setText(name.getFirst());
        lastName.setText(name.getLast());

        Location location = user.getLocation();
        addressText.setText(location.getStreet() + ", " + location.getCity() + ", " + location.getState());
    }

    private void initViews(){
        if (thumbnailImage == null) {
            thumbnailImage = (ImageView) findViewById(R.id.thumbnailImage);
            firstName = (TextView) findViewById(R.id.firstName);
            lastName = (TextView) findViewById(R.id.lastName);
            addressText = (TextView) findViewById(R.id.addressText);
        }
    }



}
