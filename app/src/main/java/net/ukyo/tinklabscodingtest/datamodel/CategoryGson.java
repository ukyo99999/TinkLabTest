package net.ukyo.tinklabscodingtest.datamodel;

import java.util.ArrayList;

/**
 * Created by ukyo on 2017/7/12.
 *
 * Category data model, using Gson library
 */

public class CategoryGson {
    public int page;
    public ArrayList<Result> results = new ArrayList<>();
    public int total_results;
    public int total_pages;

    public class Result {
        public String poster_path;
        public String overview;
        public String title;
        public String backdrop_path;
        public float vote_average;
        public String release_date;
        public String id;
    }
}
