package com.airballdigital.duckduckgo.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.airballdigital.duckduckgo.Models.RelatedTopic;
import com.airballdigital.duckduckgo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Allen Carden on 8/6/2016.
 */
public class CustomAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private List<RelatedTopic> relatedTopics;
    private RelatedTopic relatedTopic;
    private Holder holder;

    public CustomAdapter(Context context) {
        context = context;
        inflater = LayoutInflater.from(context);
        relatedTopics = new ArrayList<>(0);
    }

    public void setData(List<RelatedTopic> data) {
        relatedTopics = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return relatedTopics.size();
    }

    @Override
    public RelatedTopic getItem(int position) {
        return relatedTopics.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (null == convertView) {
            convertView = inflater.inflate(R.layout.row, parent, false);
            holder = new Holder();
            holder.mContentTextView = (TextView) convertView.findViewById(R.id.textview_content);
            convertView.setTag(holder);
        }

        relatedTopic = getItem(position);
        holder = (Holder) convertView.getTag();
        holder.mContentTextView.setText(relatedTopic.getText());

        return convertView;
    }

    private static class Holder {
        public TextView mContentTextView;
    }
}
