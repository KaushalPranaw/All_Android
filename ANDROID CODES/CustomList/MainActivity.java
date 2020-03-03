                package com.example.dell.customlist;

                import android.support.v7.app.AppCompatActivity;
                import android.os.Bundle;
                import android.widget.ListView;

                import java.util.ArrayList;

                public class MainActivity extends AppCompatActivity
                {

                    ListView lv;
                    ArrayList<Fruit> fruitlist;
                    @Override
                    protected void onCreate(Bundle savedInstanceState) {
                        super.onCreate(savedInstanceState);
                        setContentView(R.layout.activity_main);
                        fruitlist=new ArrayList<Fruit>();
                        lv=(ListView)findViewById(R.id.lv);

                        fruitlist.add(new Fruit("apple",R.drawable.apple));
                        fruitlist.add(new Fruit("mango",R.drawable.mango));

                        fruitlist.add(new Fruit("pineapple",R.drawable.pineapple));

                        //fillList();

                       MyAdapter ad=new MyAdapter(this,fruitlist);

                        lv.setAdapter(ad);

                    }

                   /* void fillList()
                    {



                    }*/





                }
