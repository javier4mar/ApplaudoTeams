package com.applaudo.applaudoteams;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


import com.applaudo.applaudoteams.fragments.TeamDetailFragment;
import com.applaudo.applaudoteams.fragments.TeamScreenFragment;
import com.applaudo.applaudoteams.model.ScheduleGame;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends FragmentActivity implements TeamScreenFragment.Callbacks{

    private boolean doublePanel=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity);

        if (findViewById(R.id.framelayout_content_detailTeam) != null) {
            doublePanel = true;
        }


    }



    @Override
    public void onEntradaSelecionada(String id , String team_name , String history_team , String video_team ,String img_team ,String lat , String lon, String stadium_team) {

        if (doublePanel == true) {

            Bundle arguments = new Bundle();
            arguments.putString("name_team", team_name);
            arguments.putString("history_team", history_team);
            arguments.putString("video_team", video_team);
            arguments.putString("img_team", img_team);
            arguments.putString("lat_team", lat);
            arguments.putString("log_team", lon);
            arguments.putString("stad_team", stadium_team);
            TeamDetailFragment fragment = new TeamDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_content_detailTeam, fragment).commit();

        } else {

            Intent detailIntent = new Intent(this, TeamDetailActivity.class);
            detailIntent.putExtra(TeamDetailFragment.ARG_ID_ENTRADA_SELECIONADA, id);
            detailIntent.putExtra("name_team", team_name);
            detailIntent.putExtra("history_team", history_team);
            detailIntent.putExtra("video_team", video_team);
            detailIntent.putExtra("img_team", img_team);
            detailIntent.putExtra("lat_team", lat);
            detailIntent.putExtra("log_team", lon);
            detailIntent.putExtra("stad_team", stadium_team);
            startActivity(detailIntent);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
