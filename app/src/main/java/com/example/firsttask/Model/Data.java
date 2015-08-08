package com.example.firsttask.Model;

/**
 * Created by HP PROBOOK 450 on 4/27/2015.
 */
public class Data {
    public Data(String country, int rank, String population, String flag) {
        this.country = country;
        this.rank = rank;
        this.population = population;
        this.flag = flag;
    }

    public int rank;
    public  String country,population,flag;

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
