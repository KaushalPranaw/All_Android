                    package com.example.dell.customlist;

                    import android.app.Activity;
                    import android.content.Context;
                    import android.graphics.BitmapFactory;
                    import android.view.LayoutInflater;
                    import android.view.View;
                    import android.view.ViewGroup;
                    import android.widget.BaseAdapter;
                    import android.widget.ImageView;
                    import android.widget.TextView;
                    import android.widget.Toast;

                    import java.io.ByteArrayInputStream;
                    import java.util.List;


                    public class MyAdapter extends BaseAdapter

                    {
                        private  List<Fruit>mylist;
                        //String name;

                        private LayoutInflater lf=null;
                        Context ctx=null;
                        public MyAdapter(Activity activity, List<Fruit>mylist)
                        {
                            ctx= activity.getApplicationContext();
                            this.mylist=mylist;
                            lf=LayoutInflater.from(activity);
                        }

                        @Override
                        public int getCount() {
                            return mylist.size();
                        }

                        @Override
                        public Object getItem(int position) {
                            return mylist.get(position);
                        }

                        @Override
                        public long getItemId(int position) {
                            return position;

                        }

                        @Override
                        public View getView(int position, View convertView, ViewGroup parent)
                        {
                            Toast.makeText(ctx,"view created",Toast.LENGTH_LONG).show();
                            if(convertView==null) {
                         convertView = lf.inflate(R.layout.mycustom, parent,false);
                                  }
                             TextView tv=(TextView)convertView.findViewById(R.id.tv);
                              ImageView im=(ImageView)convertView.findViewById(R.id.img1) ;
                                Fruit f=mylist.get(position);
                                tv.setText(f.getName());


                            /* byte[]arr=   f.getHodPic();
                            ByteArrayInputStream bs=new ByteArrayInputStream(arr);

                            Bitmap bm=BitmapFactory.decodeStream(bs);
                            im.setImageBitmap(bm);*/
                            im.setImageResource(f.getId());


                            return convertView;



                        }
                    }
