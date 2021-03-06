package com.example.sanyi.booklisting;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sanyi on 17/06/2017.
 */

public class BookLoader extends AsyncTaskLoader<List<Book>>{

    private String mUrl;

    public BookLoader(Context context,String url) {
        super(context);
        mUrl=url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<Book> loadInBackground() {
       if (mUrl==null){
           return null;
       }
        ArrayList<Book> books=Query.fetchBookData(mUrl);
        return books;
    }
}
