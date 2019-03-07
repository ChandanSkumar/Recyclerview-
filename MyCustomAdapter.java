package android.com.recyclerviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by M1023050 on 5/26/2017.
 */
public class MyCustomAdapter extends RecyclerView.Adapter<MyCustomAdapter.MovieHolder>{

    private List<Movie> mList;
    private Context mContext;

    public MyCustomAdapter(MainActivity mainActivity, List<Movie> list) {
        this.mContext = mainActivity;
        this.mList = list;
    }



    @Override
    public MovieHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflator = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflator.inflate(R.layout.row, parent, false);

        return new MovieHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieHolder holder, int position) {

        holder.title.setText(mList.get(position).getName());
        holder.description.setText(mList.get(position).getDescription());
        holder.year.setText(mList.get(position).getYear());


    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MovieHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView description;
        public TextView year;

        public MovieHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.text_title);
            description = (TextView) view.findViewById(R.id.text_description);
            year = (TextView) view.findViewById(R.id.text_year);
        }
    }
}
