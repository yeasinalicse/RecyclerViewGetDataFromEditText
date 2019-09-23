package info.yeasin.recyclerviewgetdatafromedittext;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private RecyclerView recyclerView;
    private CustomAdapter customAdapter;
    public ArrayList<Model> modelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        btn = (Button) findViewById(R.id.btn);

        modelArrayList = populateList();
        customAdapter = new CustomAdapter(this, modelArrayList);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < CustomAdapter.modelArrayList.size(); i++) {

                    Toast.makeText(MainActivity.this, "" + CustomAdapter.modelArrayList.get(i).getEditTextValue() + System.getProperty("line.separator"), Toast.LENGTH_SHORT).show();

                }

            }
        });

    }

    private ArrayList<Model> populateList() {

        ArrayList<Model> list = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            Model model = new Model();
            model.setEditTextValue(String.valueOf(i));
            list.add(model);
        }

        return list;
    }

}
