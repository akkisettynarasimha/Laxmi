package com.strsar.laxmi.secarchbar;

import android.graphics.Movie;
import android.support.v7.widget.RecyclerView;

import needle.Needle;

public class SearchResultListItemRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final static String TAG = SearchResultListItemRecyclerViewAdapter.class.getSimpleName();

    private List<Movie> movieList;
    private List<ListItem> listItems;
    private final OnSearchCompletedListener onSearchCompletedListener;
    private final OnSearchResultListItemSelectedListener onSearchResultListItemSelectedListener;

    SearchResultListItemRecyclerViewAdapter(List<Movie> items, OnSearchResultListItemSelectedListener onSearchResultListItemSelectedListener, OnSearchCompletedListener onSearchCompletedListener) {
        listItems = new ArrayList<>();
        this.onSearchResultListItemSelectedListener = onSearchResultListItemSelectedListener;
        this.onSearchCompletedListener = onSearchCompletedListener;
        setMovieList(items);

        globalMovieSearch(null);
    }

    @Override
    public int getItemViewType(int position) {
        return listItems.get(position).getType();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ListItem.TYPE_HEADER) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.generic_list_header_item, parent, false);
            return new GenericListHeaderViewHolder(itemView);
        }

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_search_result_grid_list_item, parent, false);
        return new MovieSearchResultGridListItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);

        if (type == ListItem.TYPE_HEADER) {
            GenericListHeaderItem genericListHeaderItem = (GenericListHeaderItem) listItems.get(position);
            GenericListHeaderViewHolder genericListHeaderItemViewHolder = (GenericListHeaderViewHolder) holder;
            genericListHeaderItemViewHolder.setLabelText(genericListHeaderItem.getLabel());
            return;
        } else {
            final MovieGridListItem movieGridListItem = (MovieGridListItem) listItems.get(position);
            MovieSearchResultGridListItemViewHolder movieSearchResultGridListItemViewHolder = (MovieSearchResultGridListItemViewHolder) holder;
            movieSearchResultGridListItemViewHolder.setMoviePosition(movieGridListItem.getMoviePosition());
            movieSearchResultGridListItemViewHolder.setMovie(movieGridListItem.getMovie(), CinemanApplication.getCurrentAppInstance().getApplicationContext());
            movieSearchResultGridListItemViewHolder.view.setOnClickListener(v -> onSearchResultListItemSelectedListener.onMovieGridListItemSelected(movieGridListItem.getMovie()));
        }
    }


    @Override
    public int getItemCount() {
        return listItems.size();
    }

    void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

    /**
     * Replace "CinemanAPI.movie().searchMovies()" with your own REST call / data access with the search query from the parameter for the search. The return type in this example is an ArrayList with Movie objects which gets forwarded to the formatMovieList() method where we format the list to head- and body-type of recycler list (or grid for that matter) items. This way we could group the search results in various sections i.e. movies, theatres etc.
     *
     * @param query
     */
    public void globalMovieSearch(final String query) {
        if ((query != null) && (query.trim().length() > 2)) {
            CinemanAPI.movie().searchMovies(query.trim(), new RepositoryEntityListCallback<Movie>() {

                @Override
                public void onSuccess(List<Movie> mList, boolean isCachedResponse) {
                    movieList.clear();
                    movieList.addAll(mList);

                    formatMovieList(mList);
                }

                @Override
                public void onFailure(Exception e) {
                    Log.e(TAG, e.getLocalizedMessage());
                    formatMovieList(new ArrayList<>());
                }
            });
        } else {
            movieList.clear();
        }
    }

    /**
     * Loop through the movie list and create head- and movie items
     *
     * @param mList
     */
    private void formatMovieList(List<Movie> mList) {
        final List<ListItem> newListItems = new ArrayList<>();

        Needle.onBackgroundThread().withTaskType("globalMovieSearch").serially().execute(() -> {
            GenericListHeaderItem genericListHeaderItem = new GenericListHeaderItem();
            genericListHeaderItem.setLabel(CinemanApplication.getCurrentAppInstance().getString(R.string.movies_title));
            newListItems.add(genericListHeaderItem);

            int i = 2;
            for (Movie movie : mList) {
                MovieGridListItem movieGridListItem = new MovieGridListItem();
                movieGridListItem.setMoviePosition(++i);
                movieGridListItem.setMovie(movie);
                newListItems.add(movieGridListItem);
            }

            if (mList.size() == 0) {
                newListItems.clear();
            }

            Needle.onMainThread().execute(() -> {
                listItems.clear();
                listItems.addAll(newListItems);
                notifyDataSetChanged();
                onSearchCompletedListener.onOnSearchCompleted();
            });
        });
    }

}
