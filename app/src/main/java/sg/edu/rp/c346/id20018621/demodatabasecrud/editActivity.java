package sg.edu.rp.c346.id20018621.demodatabasecrud;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class editActivity extends AppCompatActivity {

    TextView ID, content;
    EditText editcontent;
    Button update, delete;
    Note data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        //initialize the variables with UI here
        content = findViewById(R.id.content);
        editcontent = findViewById(R.id.editContent);
        ID = findViewById(R.id.tvID);
        update = findViewById(R.id.btnUpdate);
        delete = findViewById(R.id.btnDelete);
        Intent i = getIntent();
        data = (Note) i.getSerializableExtra("data");

        ID.setText("ID: " + data.getId());
        editcontent.setText(data.getNoteContent());


        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(editActivity.this);
                data.setNoteContent(editcontent.getText().toString());
                dbh.updateNote(data);
                dbh.close();
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(editActivity.this);
                dbh.deleteNote(data.getId());

            }
        });


    }
}