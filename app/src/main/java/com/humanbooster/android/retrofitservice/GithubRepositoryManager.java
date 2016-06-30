package com.humanbooster.android.retrofitservice;

import android.content.Context;
import android.content.Intent;

import java.util.Collections;
import java.util.List;

/**
 * Created by fpoyer on 13/06/16.
 */
public class GithubRepositoryManager {

    private static final String USERNAME = "fpoyer";
    private List<Repository> lastResult = Collections.emptyList();
    private Adapter adapter;

    public void setLastResult(List<Repository> lastResult) {
        this.lastResult = lastResult;
        if (adapter != null) {
            adapter.setNewData(lastResult);
        }
    }

    public static String getUSERNAME() {
        return USERNAME;
    }

    public void createRepository(String owner, String name) {
        // TODO
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void refreshRepositories(final Context context, final Adapter adapter) {
        // request fresh list from service ASAP
        Intent intent = new Intent(context, GithubRepositoryListSyncService.class);
        GithubServiceConnection connection = new GithubServiceConnection(this, context);
        context.bindService(intent, connection, Context.BIND_AUTO_CREATE);

        // In the meantime, return last result
        adapter.setNewData(lastResult);
        this.adapter = adapter;
    }


}
