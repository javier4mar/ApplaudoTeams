package com.applaudo.applaudoteams;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.applaudo.applaudoteams.fragments.TeamDetailFragment;

import java.util.List;

public class TeamDetailActivity extends FragmentActivity {

    String name_team;
    String history_team;
    String video_team;
    String img_team;
    String lat_team;
    String log_team;
    String stad_team;
    List games;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_detail);

        String newString;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();

            if (extras == null) {


            } else {

                name_team = extras.getString("name_team");
                history_team = extras.getString("history_team");
                video_team = extras.getString("video_team");
                img_team = extras.getString("img_team");
                lat_team = extras.getString("lat_team");
                log_team = extras.getString("log_team");
                stad_team = extras.getString("stad_team");


                Bundle arguments = new Bundle();
                arguments.putString(TeamDetailFragment.ARG_ID_ENTRADA_SELECIONADA, getIntent().getStringExtra(TeamDetailFragment.ARG_ID_ENTRADA_SELECIONADA));
                arguments.putString("team_name", name_team);
                arguments.putString("team_history",history_team);
                arguments.putString("team_video", video_team);
                arguments.putString("team_img", img_team);
                arguments.putString("team_lat", lat_team);
                arguments.putString("team_log", log_team);
                arguments.putString("team_sta", stad_team);

                TeamDetailFragment fragment = new TeamDetailFragment();
                fragment.setArguments(arguments);

                getSupportFragmentManager().beginTransaction().add(R.id.framelayout_content_detailTeam, fragment).commit();

            }


        } else {


        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_team_detail, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(this,"Applaudo Test" , Toast.LENGTH_SHORT).show();
            return true;
        }else if (id == R.id.share){

            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT,
                    "Hey check out my app at: https://play.google.com/store/apps/details?id=com.google.android.apps.plus");
            sendIntent.setType("text/plain");
            startActivity(sendIntent);

        }

        return super.onOptionsItemSelected(item);
    }
}
