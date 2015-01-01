package com.example.yakovlev_golani.addressbook.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yakovlev_golani.addressbook.R;
import com.example.yakovlev_golani.addressbook.models.User;
import com.example.yakovlev_golani.addressbook.views.AddressListItemView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    List<User> userList;

    public ListAdapter(List<User> userList){
        this.userList = userList;
    }

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.address_list_item, parent, false);

        ViewHolder viewHolder = new ViewHolder((AddressListItemView)v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (userList != null) {
            holder.addressListItemView.setUser(userList.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return userList == null ? 0 : userList.size();
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public AddressListItemView addressListItemView;
        public ViewHolder(AddressListItemView view) {
            super(view);
            addressListItemView = view;
        }
    }
}
