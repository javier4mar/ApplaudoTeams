package com.applaudo.applaudoteams.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.applaudo.applaudoteams.R;
import com.applaudo.applaudoteams.model.Teams;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Javier Hernandez on 14/06/2015.
 */
public class TeamAdapter extends ArrayAdapter<Teams> {

    private Activity mContext;
    private List<Teams> teamsList;

    public TeamAdapter(Context context, int resource, List<Teams> objects) {

        super(context, resource, objects);
        this.mContext = (Activity) context;
        this.teamsList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        Teams team = teamsList.get(position);

        if (convertView == null) {
            LayoutInflater inflater = mContext.getLayoutInflater();
            convertView = inflater.inflate(R.layout.item_team_list, null);

            viewHolder = new ViewHolder();

            viewHolder.TeamName = (TextView) convertView.findViewById(R.id.tvTitle);
            viewHolder.TeamAddress = (TextView) convertView.findViewById(R.id.tvAddress);
            viewHolder.TeamImg = (ImageView) convertView.findViewById(R.id.ivItemImage);

            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        if (team != null) {

            viewHolder.TeamName.setText(team.getTeam_name());
            viewHolder.TeamAddress.setText(team.getAddress());
            Glide.with(mContext)
                    .load(team.getImg_logo())
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_logo)
                    .into(viewHolder.TeamImg);
        }

        return convertView;

    }

    static class ViewHolder {
        TextView TeamName;
        TextView TeamAddress;
        ImageView TeamImg;

    }

}
