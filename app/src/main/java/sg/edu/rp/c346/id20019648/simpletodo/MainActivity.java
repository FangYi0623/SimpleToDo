package sg.edu.rp.c346.id20019648.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText etTD;
    Button btnAdd, btnClear;
    ListView lv;

    ArrayList<String> Todo;
    ArrayAdapter<String> aaTodo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTD = findViewById(R.id.etTD);
        btnAdd = findViewById(R.id.btnAdd);
        btnClear = findViewById(R.id.btnClear);
        lv = findViewById(R.id.lv);

        Todo = new ArrayList<String>();
        aaTodo = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Todo);
        lv.setAdapter(aaTodo);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String assignment = etTD.getText().toString();
                Todo.add(assignment);
                aaTodo.notifyDataSetChanged();
                etTD.setText(null);
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Todo.clear();
                aaTodo.notifyDataSetChanged();
            }
        });
    }
}