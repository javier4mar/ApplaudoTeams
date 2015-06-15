package com.applaudo.applaudoteams.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Javier Hernandez on 14/06/2015.
 */
public class Teams {

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("team_name")
    @Expose
    private String team_name;

    @SerializedName("since")
    @Expose
    private String since;

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("coach")
    @Expose
    private String coach;

    @SerializedName("team_nickname")
    @Expose
    private String team_nickname;

    @SerializedName("stadium")
    @Expose
    private String stadium;

    @SerializedName("img_logo")
    @Expose
    private String img_logo;

    @SerializedName("img_stadium")
    @Expose
    private String img_stadium;

    @SerializedName("latitude")
    @Expose
    private String latitude;

    @SerializedName("longitude")
    @Expose
    private String longitude;

    @SerializedName("website")
    @Expose
    private String website;

    @SerializedName("tickets_url")
    @Expose
    private String tickets_url;

    @SerializedName("address")
    @Expose
    String address;

    @SerializedName("phone_number")
    @Expose
    String phone_number;

    @SerializedName("description")
    @Expose
    String description;

    @SerializedName("video_url")
    @Expose
    String video_url;

    @SerializedName("schedule_games")
    @Expose
    private List<ScheduleGame> scheduleGames = new ArrayList<ScheduleGame>();


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public String getSince() {
        return since;
    }

    public void setSince(String since) {
        this.since = since;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public String getTeam_nickname() {
        return team_nickname;
    }

    public void setTeam_nickname(String team_nickname) {
        this.team_nickname = team_nickname;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public String getImg_logo() {
        return img_logo;
    }

    public void setImg_logo(String img_logo) {
        this.img_logo = img_logo;
    }

    public String getImg_stadium() {
        return img_stadium;
    }

    public void setImg_stadium(String img_stadium) {
        this.img_stadium = img_stadium;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getTickets_url() {
        return tickets_url;
    }

    public void setTickets_url(String tickets_url) {
        this.tickets_url = tickets_url;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVideo_url() {
        return video_url;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }

    public List<ScheduleGame> getScheduleGames() {
        return scheduleGames;
    }

    public void setScheduleGames(List<ScheduleGame> scheduleGames) {
        this.scheduleGames = scheduleGames;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
