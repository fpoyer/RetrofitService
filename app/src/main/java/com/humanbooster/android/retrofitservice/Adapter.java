package com.humanbooster.android.retrofitservice;

import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by fpoyer on 13/06/16.
 */
public interface Adapter {
    void setNewData(List<Repository> data);


}

class AdapterImpl implements Adapter {
    private List<Repository> data = Collections.emptyList();
    private TextView view;

    public void setView(TextView view) {
        this.view = view;
        view.setText(computeText());
    }

    private String computeText() {
        StringBuilder builder = new StringBuilder("List of repos online : \n");
        for (Repository repo :
                data) {
            builder.append(repo.getName()).append('\n');
        }
        return builder.toString();
    }

    @Override
    public void setNewData(List<Repository> data) {
        this.data = data;
        if (view != null) {

            view.setText(computeText());
        }
    }


}
