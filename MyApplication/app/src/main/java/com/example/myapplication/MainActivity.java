package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class MainActivity extends AppCompatActivity {

    int flag=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button add = findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView t=findViewById(R.id.textView);
                t.setText(t.getText()+"+");
                flag=0;
                refine();
            }
        });


        Button sub = findViewById(R.id.sub);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView t=findViewById(R.id.textView);
                t.setText(t.getText()+"-");
                flag=0;
                refine();
            }
        });

        Button mul = findViewById(R.id.mul);
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView t=findViewById(R.id.textView);
                t.setText(t.getText()+"*");
                flag=0;
                refine();
            }
        });


        Button div = findViewById(R.id.div);
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView t=findViewById(R.id.textView);
                t.setText(t.getText()+"/");
                flag=0;
                refine();
            }
        });


        Button c = findViewById(R.id.c);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView t=findViewById(R.id.textView);
                StringBuilder str=new StringBuilder(t.getText());
                if(str.length()>0 && str.charAt(str.length()-1)=='.'){
                    flag=0;
                }
                if(str.length()>1){
                    t.setText(str.substring(0,str.length()-1));
                }else{
                    t.setText("0");
                }

                refine();
            }
        });

        Button ac = findViewById(R.id.ac);
        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView t=findViewById(R.id.textView);
                t.setText("0");
                flag=0;
                refine();
            }
        });
        Button dot = findViewById(R.id.dot);
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag==0) {
                    TextView t = findViewById(R.id.textView);
                    t.setText(t.getText() + ".");
                }
                flag=1;
                refine();
            }
        });


        Button one = findViewById(R.id.one);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView t=findViewById(R.id.textView);
                t.setText(t.getText()+"1");
                refine();
            }
        });
        Button two = findViewById(R.id.two);
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView t=findViewById(R.id.textView);
                t.setText(t.getText()+"2");
                refine();
            }
        });
        Button three = findViewById(R.id.three);
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView t=findViewById(R.id.textView);
                t.setText(t.getText()+"3");
                refine();
            }
        });
        Button four = findViewById(R.id.four);
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView t=findViewById(R.id.textView);
                t.setText(t.getText()+"4");
                refine();
            }
        });
        Button five = findViewById(R.id.five);
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView t=findViewById(R.id.textView);
                t.setText(t.getText()+"5");
                refine();
            }
        });
        Button six = findViewById(R.id.six);
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView t=findViewById(R.id.textView);
                t.setText(t.getText()+"6");
                refine();
            }
        });
        Button seven = findViewById(R.id.seven);
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView t=findViewById(R.id.textView);
                t.setText(t.getText()+"7");
                refine();
            }
        });
        Button eight = findViewById(R.id.eight);
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView t=findViewById(R.id.textView);
                t.setText(t.getText()+"8");
                refine();
            }
        });
        Button nine = findViewById(R.id.nine);
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView t=findViewById(R.id.textView);
                t.setText(t.getText()+"9");
                refine();
            }
        });
        Button zero = findViewById(R.id.zero);
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView t=findViewById(R.id.textView);
                t.setText(t.getText()+"0");
                refine();
            }
        });

        Button answer = findViewById(R.id.answer);
        answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ScriptEngineManager r =  new ScriptEngineManager();
                ScriptEngine engine = r.getEngineByName("javascript");
                try{
                    TextView t=findViewById(R.id.textView);
                    String s = engine.eval(t.getText().toString()).toString();
                    double d =Double.parseDouble(s);
                    if(d==(long)(d)){
                        t.setText(""+(long)d);
                    }else{
                        t.setText(s);
                    }
                }catch(Exception e){
                    TextView t=findViewById(R.id.textView);
                    t.setText("Please Give Proper Input");
                }
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean isdigit(Character c){
        if(c>='0' && c<='9'){
            return true;
        }
        return false;
    }
    public void refine(){
        TextView t = findViewById(R.id.textView);
        String s = t.getText().toString();
        StringBuilder r = new StringBuilder("");
        for(int i=0;i<s.length();){
            if(!isdigit(s.charAt(i))){
                r.append(s.charAt(i));
                i++;
            }else{
                long ans=0;
                while(i<s.length() && isdigit(s.charAt(i))){
                    ans=ans*10+(s.charAt(i)-'0');
                    i++;
                }
                r.append(ans);
                if(i<s.length() && s.charAt(i)=='.') {
                    r.append(s.charAt(i));
                    i++;
                    while (i < s.length() && isdigit(s.charAt(i))) {
                        r.append(s.charAt(i));
                        i++;
                    }
                }
            }
        }
        t.setText(r.toString());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
