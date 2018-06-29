package com.example.dell.project1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button save;
    EditText txt;
    ListView show;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      txt=(EditText)findViewById(R.id.editext);
      save=(Button)findViewById(R.id.button);
      save.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {


Intent it=new Intent(MainActivity.this, projectlink.class);
              String getinput=txt.getText().toString();
              it.putExtra( "value",getinput);
              ((EditText)findViewById(R.id.editext)).setText(" ");
              startActivity(it);

              finish();

          }
      });
    }
}
