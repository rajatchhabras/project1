package com.example.dell.project1;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.service.media.MediaBrowserService;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class projectlink extends AppCompatActivity {
    static ArrayList<String> arraylist=new ArrayList<String>();
   Button save;
    ListView show;
    static String st;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projectlink);
        save=(Button)findViewById(R.id.btn);
        show=(ListView)findViewById(R.id.Listview);

      st=getIntent().getExtras().getString("value");
                arraylist.add(st);
                ArrayAdapter<String> adapter=new ArrayAdapter<String>(projectlink.this, android.R.layout.simple_list_item_1,arraylist);
                show.setAdapter(adapter);
                show.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        //Toast.makeText(projectlink.this, arraylist.get(i), Toast.LENGTH_SHORT).show();
                        if (arraylist.get(i).equals("dialpad"))
                        {
                            Intent its=new Intent(Intent.ACTION_DIAL);
                            its.setData(Uri.parse("tel: 9876212394"));
                            startActivity(its);
                        }
                        else if (arraylist.get(i).equals("browser"))
                        {
                            Intent intent=new Intent(Intent.ACTION_VIEW);
                            intent.setData(Uri.parse("https://www.gmail.com"));
                            startActivity(intent);

                        }
                        else if(arraylist.get(i).equals("camera"))
                        {
                            Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                            startActivity(intent);

                        }

                        else
                        {
                            Intent it=new Intent(projectlink.this, project1link.class);
                            String getinput=arraylist.get(i).toString();
                            it.putExtra( "value",getinput);
                            startActivity(it);
                        }
                    }
                });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(projectlink.this, MainActivity.class);
                startActivity(it);
            }
        });


                          }


    }

