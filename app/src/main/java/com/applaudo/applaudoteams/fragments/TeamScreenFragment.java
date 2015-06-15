package com.applaudo.applaudoteams.fragments;

import android.app.Activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.applaudo.applaudoteams.R;
import com.applaudo.applaudoteams.adapter.ServiceAdapter;
import com.applaudo.applaudoteams.adapter.TeamAdapter;
import com.applaudo.applaudoteams.model.Teams;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class TeamScreenFragment extends ListFragment {

    private Callbacks mCallbacks = CallbacksVacios;
    ListView lv;
    TeamAdapter adapter;
    ArrayList<Teams> list_teams = new ArrayList<Teams>();


    public interface Callbacks {

        public void onEntradaSelecionada(String id , String team_name , String history_team , String video_team ,String img_team ,String lat ,String log , String stadium_team);

    }

    private static Callbacks CallbacksVacios = new Callbacks() {
        @Override
        public void onEntradaSelecionada(String id , String team_name , String history_team , String video_team ,String img_team ,String lat ,String log , String stadium_team) {
        }
    };


    public TeamScreenFragment() {

    }


    public static TeamScreenFragment newInstance() {
        TeamScreenFragment fragment = new TeamScreenFragment();
        return fragment;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (savedInstanceState != null) {

            //Restore the fragment's state here


        }else{
            getTeams();
        }

    }


    private void getTeams(){
        try {
            ServiceAdapter.getInstance().getmApi().getTeams(new Callback<List<Teams>>() {
                @Override
                public void success(List<Teams> teams, Response response) {

                    list_teams = (ArrayList<Teams>) teams;

                    adapter = new TeamAdapter(getActivity(), R.layout.item_team_list, list_teams);
                    setListAdapter(adapter);

                }

                @Override
                public void failure(RetrofitError error) {

                    Toast.makeText(getActivity(), "Failed to load teams", Toast.LENGTH_SHORT).show();


                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                            getActivity());

                    // set title
                    alertDialogBuilder.setTitle("Error Connection");

                    // set dialog message
                    alertDialogBuilder
                            .setMessage("Do you want to try again")
                            .setCancelable(false)
                            .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,int id) {

                                    getTeams();

                                }
                            })
                            .setNegativeButton("No",new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,int id) {
                                    getActivity().finish();
                                    dialog.cancel();
                                }
                            });

                    // create alert dialog
                    AlertDialog alertDialog = alertDialogBuilder.create();

                    // show it
                    alertDialog.show();

                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_team_screen, container, false);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (!(activity instanceof Callbacks)) {
            throw new IllegalStateException("Error: La actividad debe implementar el callback del fragmento");
        }

        mCallbacks = (Callbacks) activity;

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallbacks = CallbacksVacios;
    }


    public void onListItemClick(ListView listView, View view, int posicion, long id) {
        super.onListItemClick(listView, view, posicion, id);

        //String id , String team_name , String history_team , String video_team ,String img_team ,String lat , String lon

        mCallbacks.onEntradaSelecionada(String.valueOf(list_teams.get(posicion).getId()),list_teams.get(posicion).getTeam_name(),list_teams.get(posicion).getDescription(),list_teams.get(posicion).getVideo_url(),list_teams.get(posicion).getImg_logo(),list_teams.get(posicion).getLatitude(),list_teams.get(posicion).getLongitude(), list_teams.get(posicion).getStadium());

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);



    }

}
