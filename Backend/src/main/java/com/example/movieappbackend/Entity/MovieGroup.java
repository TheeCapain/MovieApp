package com.example.movieappbackend.Entity;

import com.example.movieappbackend.component.MovieComponent;

import java.util.ArrayList;
import java.util.Iterator;

public class MovieGroup extends MovieComponent {

    private ArrayList<MovieComponent> movieGroupList = new ArrayList<>();

    private String groupName;
    private String groupDescription;


    public MovieGroup(String groupName, String groupDescription) {
        this.groupName = groupName;
        this.groupDescription = groupDescription;
    }

    public void add(MovieComponent movieComponent) {
        movieGroupList.add(movieComponent);
    }

    public void remove(MovieComponent movieComponent) {
        movieGroupList.remove(movieComponent);
    }

    public MovieComponent get(int componentIndex){
        return (MovieComponent)movieGroupList.get(componentIndex);
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupDescription() {
        return groupDescription;
    }

    public void setGroupDescription(String groupDescription) {
        this.groupDescription = groupDescription;
    }

    public void displayMovieInfo(){
        System.out.println(getGroupName() + " " + getGroupDescription());
        Iterator movieIterator = movieGroupList.iterator();
        while (movieIterator.hasNext()){
            MovieComponent movieInfo = (MovieComponent) movieIterator.next();
            movieInfo.displayMovieInfo();
        }
    }

}
