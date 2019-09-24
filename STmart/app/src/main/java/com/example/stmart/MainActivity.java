package com.example.stmart;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseError;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public ArrayList<ArrayList<String>> electronics;
    public ArrayList<ArrayList<String>> Fashion;
    public ArrayList<ArrayList<String>> sports;
    public ArrayList<ArrayList<String>> grocery;
    public ArrayList<ArrayList<String>> cart;
    public ArrayList<ArrayList<String>> searchresult;
    public HashMap<String,Integer> map;
    public HashMap<String,Integer> searchadd;
    public int checked=0;
    public int t=0;
//    ArrayAdapter<String> adapter;
//    ArrayList<String> list;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        electronics=new ArrayList<ArrayList<String>>();
        Fashion=new ArrayList<ArrayList<String>>();
        sports=new ArrayList<ArrayList<String>>();
        grocery=new ArrayList<ArrayList<String>>();
        cart=new ArrayList<ArrayList<String>>();
        map=new HashMap<>();
        searchadd=new HashMap<>();
        searchresult=new ArrayList<ArrayList<String>>();
        DatabaseReference database=FirebaseDatabase.getInstance().getReference().child("sports");
        ValueEventListener V=new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                TextView txt=findViewById(R.id.loading);
                txt.setVisibility(View.VISIBLE);
                for(DataSnapshot users:dataSnapshot.getChildren()){
                    ArrayList<String> a=new ArrayList<>();
                    a.add(users.child("download").getValue().toString());
                    a.add(users.child("name").getValue().toString());
                    a.add(users.child("price").getValue().toString());
                    sports.add(a);
                    System.out.println("sports "+sports.size()+" "+users.child("download").getValue());
                }
                txt.setVisibility(View.INVISIBLE);
                t++;
                if(t==4){
                    setdefault();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        database.addValueEventListener(V);

        DatabaseReference mDatabase=FirebaseDatabase.getInstance().getReference().child("electronics");
        ValueEventListener v=new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                TextView txt=findViewById(R.id.loading);
                txt.setVisibility(View.VISIBLE);
                for(DataSnapshot users:dataSnapshot.getChildren()){
                    ArrayList<String> a=new ArrayList<>();
                    a.add(users.child("download").getValue().toString());
                    a.add(users.child("name").getValue().toString());
                    a.add(users.child("price").getValue().toString());
                    electronics.add(a);
                    System.out.println("electronics " + electronics.size()+" "+users.child("download").getValue());
                }
                txt.setVisibility(View.INVISIBLE);
                t++;
                if(t==4){
                    setdefault();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        mDatabase.addValueEventListener(v);

        DatabaseReference Database=FirebaseDatabase.getInstance().getReference().child("fashion");
        ValueEventListener tv=new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                TextView txt=findViewById(R.id.loading);
                txt.setVisibility(View.VISIBLE);
                for(DataSnapshot users:dataSnapshot.getChildren()){
                    ArrayList<String> a=new ArrayList<>();
                    a.add(users.child("download").getValue().toString());
                    a.add(users.child("name").getValue().toString());
                    a.add(users.child("price").getValue().toString());
                    Fashion.add(a);
                    System.out.println("fashion "+Fashion.size()+" "+users.child("download").getValue());
                }
                txt.setVisibility(View.INVISIBLE);
                t++;
                if(t==4){
                    setdefault();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        Database.addValueEventListener(tv);




        DatabaseReference ddatabase=FirebaseDatabase.getInstance().getReference().child("Grocery");
        ValueEventListener VV=new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                TextView txt=findViewById(R.id.loading);
                txt.setVisibility(View.VISIBLE);
                for(DataSnapshot users:dataSnapshot.getChildren()){
                    ArrayList<String> a=new ArrayList<>();
                    a.add(users.child("download").getValue().toString());
                    a.add(users.child("name").getValue().toString());
                    a.add(users.child("price").getValue().toString());
                    grocery.add(a);
                    System.out.println("grocery "+grocery.size()+" "+users.child("download").getValue());
                }
                txt.setVisibility(View.INVISIBLE);
                t++;
                if(t==4){
                    setdefault();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        ddatabase.addValueEventListener(VV);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        SearchView searchView=findViewById(R.id.searchbbar);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                checked=6;
                GridView gridview = (GridView) findViewById(R.id.gridview);
                gridview.setAdapter(new ImageAdapter(getBaseContext(),newText));
                System.out.println(newText);
                searchadd=new HashMap<>();
                searchresult=new ArrayList<>();
                return false;
            }
        });

    }

    public void setdefault(){

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.getMenu().getItem(0).setChecked(true);
        navigationView.getMenu().performIdentifierAction(R.id.nav_camera, 0);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressLint("ResourceType")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_camera) {
            checked=1;
        } else if (id == R.id.nav_gallery) {
            checked=2;
        } else if (id == R.id.nav_slideshow) {
            checked=3;
        } else if (id == R.id.nav_manage) {
            checked=4;
        } else if (id == R.id.nav_share) {
            checked=5;
        }

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



    class ImageAdapter extends BaseAdapter
    {
        private Context context;
        private String search;
        public ImageAdapter(Context c) { context = c; }
        public ImageAdapter(Context c,String seearch) { context = c;this.search=seearch; }
        public int getCount() {
//            TextView v= findViewById(R.id.total);
//            v.setText("");
            if(checked==1){
                System.out.println(checked+" returned"+electronics.size());
                return electronics.size();
            }
            if(checked==2){

                System.out.println(checked+" returned"+Fashion.size());
                return Fashion.size();
            }
            if(checked==3){
                System.out.println(checked+" returned"+sports.size());
                return sports.size();
            }
            if(checked==4){
                System.out.println(checked+" returned" +grocery.size());
                return grocery.size();
            }
            if(checked==5){
                long finalsum=0;
                System.out.println(checked+" returned" +cart.size());
                for(int i=0;i<cart.size();i++){
                    for(int j=0;j<cart.get(i).size();j++){
                        System.out.print(cart.get(i).get(j)+" ");
                    }
                    finalsum+= Long.parseLong(cart.get(i).get(2))*Long.parseLong(cart.get(i).get(4));
                    System.out.println();
                }
//                v.setText(finalsum+"");
                return cart.size();
            }
            if(checked==6){
                /*1's index is for name*/
                for(int i=0;i<electronics.size();i++){
                    if(search==null || (electronics.get(i).get(1).contains(search) && !searchadd.containsKey(electronics.get(i).get(1)))){
                        searchadd.put(electronics.get(i).get(1),1);
                        ArrayList<String> a=new ArrayList<>();
                        a.add(electronics.get(i).get(0));
                        a.add(electronics.get(i).get(1));
                        a.add(electronics.get(i).get(2));
                        searchresult.add(a);
                        System.out.println("searchresult "+searchresult.size());
                    }
                }
                for(int i=0;i<grocery.size();i++){
                    if(grocery.get(i).get(1).contains(search) && !searchadd.containsKey(grocery.get(i).get(1))){
                        searchadd.put(grocery.get(i).get(1),1);
                        ArrayList<String> a=new ArrayList<>();
                        a.add(grocery.get(i).get(0));
                        a.add(grocery.get(i).get(1));
                        a.add(grocery.get(i).get(2));
                        searchresult.add(a);
                        System.out.println("searchresult "+searchresult.size());
                    }
                }
                for(int i=0;i<Fashion.size();i++){
                    if(Fashion.get(i).get(1).contains(search) && !searchadd.containsKey(Fashion.get(i).get(1))){
                        searchadd.put(Fashion.get(i).get(1),1);
                        ArrayList<String> a=new ArrayList<>();
                        a.add(Fashion.get(i).get(0));
                        a.add(Fashion.get(i).get(1));
                        a.add(Fashion.get(i).get(2));
                        searchresult.add(a);
                        System.out.println("searchresult "+searchresult.size());
                    }
                }
                for(int i=0;i<sports.size();i++){
                    if(sports.get(i).get(1).contains(search) && !searchadd.containsKey(sports.get(i).get(1))){
                        searchadd.put(sports.get(i).get(1),1);
                        ArrayList<String> a=new ArrayList<>();
                        a.add(sports.get(i).get(0));
                        a.add(sports.get(i).get(1));
                        a.add(sports.get(i).get(2));
                        searchresult.add(a);
                        System.out.println("searchresult "+searchresult.size());
                    }
                }
                return searchresult.size();
            }
            return 0;
        }
        public Object getItem(int position) { return position; }
        public long getItemId(int position) { return position; }


        public View getView(final int position, View convertView, ViewGroup parent)
        {


            LayoutInflater li = LayoutInflater.from(context);
            View v = li.inflate(R.layout.gridview,null,false);
            final ImageView imageView = v.findViewById(R.id.image);
            final TextView pname=v.findViewById(R.id.name);
            final TextView price=v.findViewById(R.id.price);
            final Button b=v.findViewById(R.id.addtocart);
            String s="";

            //onnavigation selection
            if(checked==1){
                s=electronics.get(position).get(0);
                Glide.with(context).load(electronics.get(position).get(0)).into(imageView);
                pname.setText(electronics.get(position).get(1));
                price.setText(electronics.get(position).get(2));
                this.getCount();
            }
            if(checked==2){
                s=Fashion.get(position).get(0);
                Glide.with(context).load(Fashion.get(position).get(0)).into(imageView);
                pname.setText(Fashion.get(position).get(1));
                price.setText(Fashion.get(position).get(2));
                this.getCount();
            }
            if(checked==3){
                s=sports.get(position).get(0);
                Glide.with(context).load(sports.get(position).get(0)).into(imageView);
                pname.setText(sports.get(position).get(1));
                price.setText(sports.get(position).get(2));
                this.getCount();
            }
            if(checked==4){
                s=grocery.get(position).get(0);
                Glide.with(context).load(grocery.get(position).get(0)).into(imageView);
                pname.setText(grocery.get(position).get(1));
                price.setText(grocery.get(position).get(2));
                this.getCount();
            }
            if(checked==6){
                s=searchresult.get(position).get(0);
                Glide.with(context).load(searchresult.get(position).get(0)).into(imageView);
                pname.setText(searchresult.get(position).get(1));
                price.setText(searchresult.get(position).get(2));
                this.getCount();
            }
            if(checked==5){
                final String finalS=cart.get(position).get(0);
                s=finalS;
                Glide.with(context).load(cart.get(position).get(0)).into(imageView);
                pname.setText(cart.get(position).get(1));
                price.setText(cart.get(position).get(2));
                final TextView total=v.findViewById(R.id.total);
                total.setText((cart.get(position).get(4)));
                Button removeb= v.findViewById(R.id.remove);
                removeb.setVisibility(View.VISIBLE);
                removeb.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        for(int i=0;i<cart.size();i++){
                            if(cart.get(i).get(0).equals(finalS)){
                                if(Integer.parseInt(cart.get(i).get(4))==1) {
                                    int j=i;
                                    i++;
                                    for (; i < cart.size(); i++) {
                                        //position changing
                                        ArrayList<String> a = new ArrayList<>();
                                        a.add(cart.get(i).get(0));
                                        a.add(cart.get(i).get(1));
                                        a.add(cart.get(i).get(2));
                                        a.add("" + (i - 1));
                                        a.add(cart.get(i).get(4));
                                        cart.set(i, a);
                                    }
                                    cart.remove(j);
                                    map.remove(finalS);
                                }else{
                                    //only decrement of total
                                    ArrayList<String> a = new ArrayList<>();
                                    a.add(cart.get(i).get(0));
                                    a.add(cart.get(i).get(1));
                                    a.add(cart.get(i).get(2));
                                    a.add(cart.get(i).get(3));
                                    a.add(""+(Integer.parseInt(cart.get(i).get(4))-1));
                                    cart.set(i, a);
                                }
                                break;
                            }
                        }

                        notifyDataSetChanged();
//                        new ImageAdapter(context).getCount();
                    }
                });


            }
            final String finalS = s;
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (map.containsKey(finalS)) {
                        for(int i=0;i<cart.size();i++){
                            if(cart.get(i).get(0)==finalS){
                                ArrayList<String> a= new ArrayList<>();
                                a.add(cart.get(i).get(0));
                                a.add(cart.get(i).get(1));
                                a.add(cart.get(i).get(2));
                                a.add(cart.get(i).get(3));
                                /**item addting to cart*/
                                a.add(""+(Integer.parseInt(cart.get(i).get(4))+1)+"");
                                cart.set(i,a);
                                break;
                            }
                        }
                    } else {
                        map.put(finalS,1);
                        ArrayList<String> a = new ArrayList<>();
                        a.add(finalS);
                        a.add((String) pname.getText());
                        a.add((String) price.getText());
                        a.add(cart.size()+"");
                        a.add(1+"");
                        cart.add(a);
                    }
                    notifyDataSetChanged();
//                    new ImageAdapter(context).getCount();
                }
            });
            imageView.setAdjustViewBounds(true);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent;
                    intent = new Intent(context,image.class);
                    intent.putExtra("download",finalS);
                    intent.putExtra("name",pname.getText());

                    intent.putExtra("price",price.getText());
                    startActivity(intent);
                }
            });


            return v;

        }
    }

}




