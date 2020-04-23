package com.example.stackoverflowapi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stackoverflowapi.R;
import com.example.stackoverflowapi.models.Users;

import org.w3c.dom.Text;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class StackAdapter extends RecyclerView.Adapter<StackAdapter.StackViewHolder> {

    private Context fContext;
    private List<Users > fUsersList;
    private LayoutInflater fLayoutInflater;

    public StackAdapter( Context context, List< Users > list ) {
        fContext = context;
        fUsersList = list;
        fLayoutInflater = LayoutInflater.from( context );
    }

    @NonNull
    @Override
    public StackViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = fLayoutInflater.inflate( R.layout.layout_item, parent, false );

        return new StackViewHolder( rootView );
    }

    @Override
    public void onBindViewHolder(@NonNull StackViewHolder holder, int position) {
        holder.tUsername.setText(String.format("%s %s", fContext.getString(R.string.username_string), fUsersList.get(position).getUsername()));
        holder.tReputation.setText(String.format("%s %s", fContext.getString(R.string.reputation_string), fUsersList.get(position).getReputation()));
        holder.tLocation.setText(String.format("%s %s", fContext.getString(R.string.location_string), fUsersList.get(position).getLocation()));

        Iterator<Map.Entry< String, Integer>>  iterator = fUsersList.get( position ).getBadges().entrySet().iterator();
        Map.Entry< String, Integer>  pair = iterator.next();

        holder.tGoldBadge.setText(String.format("%s : ", pair.getKey()));
        holder.tGoldBadgeCount.setText( pair.getValue().toString() );

        pair = iterator.next();
        holder.tSilverBadge.setText( pair.getKey() + " : ");
        holder.tSilverBadgeCount.setText( pair.getValue().toString() );

        pair = iterator.next();
        holder.tBronzeBadge.setText( pair.getKey() + " : " );
        holder.tBronzeBadgeCount.setText( pair.getValue().toString() );
    }

    @Override
    public int getItemCount() {
        return fUsersList.size();
    }

    public static class StackViewHolder extends RecyclerView.ViewHolder {

        TextView tUsername, tReputation, tLocation;
        TextView tSilverBadge, tSilverBadgeCount;
        TextView tBronzeBadge, tBronzeBadgeCount;
        TextView tGoldBadge, tGoldBadgeCount;

        public StackViewHolder(@NonNull View itemView) {
            super(itemView);

            tUsername = ( TextView ) itemView.findViewById( R.id.tvUsername );
            tReputation = ( TextView ) itemView.findViewById( R.id.tvReputation );
            tLocation = ( TextView ) itemView.findViewById( R.id.tvLocation );
            tSilverBadge = ( TextView ) itemView.findViewById( R.id.tvSilverBadge );
            tSilverBadgeCount = ( TextView ) itemView.findViewById( R.id.tvSilverBadgeCount );
            tBronzeBadge = ( TextView ) itemView.findViewById( R.id.tvBronzeBadge );
            tBronzeBadgeCount = ( TextView ) itemView.findViewById( R.id.tvBronzeBadgeCount );
            tGoldBadge = ( TextView ) itemView.findViewById( R.id.tvGoldBadge );
            tGoldBadgeCount = ( TextView ) itemView.findViewById( R.id.tvGoldBadgeCount );


        }
    }
}
