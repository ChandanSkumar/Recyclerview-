package android.com.recyclerviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        List<Movie> list = prepareList();
        MyCustomAdapter adapter = new MyCustomAdapter(MainActivity.this,list);
       // mRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        mRecyclerView.setAdapter(adapter);
    }

    private List<Movie> prepareList() {
        List<Movie> list = new ArrayList<>();

        for(int i=0; i<100; i++){
            Movie movie = new Movie();
            movie.setName("Name : " + i);
            movie.setDescription("Description : " + i);
            movie.setYear("Year : " + i);
            list.add(movie);
        }

        return list;
    }
}
