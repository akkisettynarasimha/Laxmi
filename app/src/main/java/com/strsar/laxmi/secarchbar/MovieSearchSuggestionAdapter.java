package com.strsar.laxmi.secarchbar;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.ViewUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import com.strsar.laxmi.R;

import java.util.List;

public class MovieSearchSuggestionAdapter extends CursorAdapter implements View.OnClickListener {
    private final static String TAG = MovieSearchSuggestionAdapter.class.getSimpleName();

    private Context context;
    private final LayoutInflater mInflater;
    private ImageView imageView;
    private TextView suggestionTextView;
    private SearchView searchView;

    private final List<Autocomplete> autocompleteList;

    public MovieSearchSuggestionAdapter(final Context context, final Cursor cursor, final List<Autocomplete> autocompleteList, SearchView searchView) {
        super(context, cursor, 0);

        this.context = context;
        this.searchView = searchView;
        this.autocompleteList = autocompleteList;
        this.mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        final View view = mInflater.inflate(R.layout.search_result_item_layout, parent, false);

        imageView = view.findViewById(R.id.icon);
        suggestionTextView = view.findViewById(R.id.suggestion);

        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        final int position = cursor.getPosition();
        if (cursorInBounds(position)) {

            final Autocomplete auto = autocompleteList.get(position);
            suggestionTextView.setText(auto.getSuggestion());

            if (auto.getContext().equalsIgnoreCase("movie")) {
                imageView.setImageResource(R.drawable.ic_search);
            } else if (auto.getContext().equalsIgnoreCase("history")) {
                imageView.setImageResource(R.drawable.ic_time);
            }

            view.setTag(position);
            view.setOnClickListener(this);
        } else {
            // Something went wrong
        }
    }

    private boolean cursorInBounds(final int position) {
        return position < autocompleteList.size();
    }

    @Override
    public void onClick(final View view) {
        final int position = (Integer) view.getTag();

        if (cursorInBounds(position)) {
            final Autocomplete selected = autocompleteList.get(position);

            ViewUtils.hideKeyboard(context, searchView);
            searchView.setQuery(selected.getSuggestion(), true);
        } else {
            // Something went wrong
        }
    }


}
