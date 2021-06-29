package com.example.tictactoe_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import java.util.ArrayList;

class button_state
{
    int button_id, state;
}


public class Game extends AppCompatActivity {
    private int x_or_c=0;
    private ArrayList<button_state> buttons=new ArrayList<>();
    private int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        buttons=add_Buttons(buttons);
    }

    public ArrayList<button_state> add_Buttons(ArrayList<button_state> buttons)
    {
        button_state bs_11 = new button_state();
        button_state bs_12 = new button_state();
        button_state bs_13 = new button_state();
        button_state bs_21 = new button_state();
        button_state bs_22 = new button_state();
        button_state bs_23 = new button_state();
        button_state bs_31 = new button_state();
        button_state bs_32 = new button_state();
        button_state bs_33 = new button_state();

        bs_11.state=0; bs_12.state=0; bs_13.state=0;
        bs_21.state=0; bs_22.state=0; bs_23.state=0;
        bs_31.state=0; bs_32.state=0; bs_33.state=0;

        bs_11.button_id=R.id.button_11;
        buttons.add(bs_11);
        bs_12.button_id=R.id.button_12;
        buttons.add(bs_12);
        bs_13.button_id=R.id.button_13;
        buttons.add(bs_13);
        bs_21.button_id=R.id.button_21;
        buttons.add(bs_21);
        bs_22.button_id=R.id.button_22;
        buttons.add(bs_22);
        bs_23.button_id=R.id.button_23;
        buttons.add(bs_23);
        bs_31.button_id=R.id.button_31;
        buttons.add(bs_31);
        bs_32.button_id=R.id.button_32;
        buttons.add(bs_32);
        bs_33.button_id=R.id.button_33;
        buttons.add(bs_33);


        return buttons;
    }

    public void button_Click(View v)
    {
        count++;
        if(x_or_c==0)
        {
            int x= v.getId();

            for(button_state i: buttons)
            {
                if(x==i.button_id)
                {
                    i.state=1;
                }
            }
            set_Cross(v);
            x_or_c=1;
        }
        else
        {
            set_Circle(v);
            x_or_c=0;
            int x= v.getId();
            for(button_state i: buttons)
            {
                if(x==i.button_id)
                {
                    i.state=2;
                }
            }
        }
        ((Button)v).setEnabled(false);
        check_over();

    }

    public void set_Cross(View v)
    {
        Button b= (Button)v;
        b.setBackgroundResource(R.drawable.testcross);
    }

    public void set_Circle(View v)
    {
        Button b= (Button)v;
        b.setBackgroundResource(R.drawable.circletest2);
    }


    public void check_over()
    {
        int flag=0;
        //horizontal checking

        if((buttons.get(0).state)==(buttons.get(1).state) && (buttons.get(0).state)==(buttons.get(2).state) && (buttons.get(0).state!=0))
        {
            (findViewById(R.id.cut_h1)).setVisibility(View.VISIBLE);

            if((buttons.get(0).state==1))
            {
                flag=1;
            }
            else
            {
                flag=2;
            }
        }
        else if((buttons.get(3).state)==(buttons.get(4).state) && (buttons.get(3).state)==(buttons.get(5).state) && (buttons.get(3).state!=0))
        {

            (findViewById(R.id.cut_h2)).setVisibility(View.VISIBLE);
            if((buttons.get(3).state==1))
            {
                flag=1;
            }
            else
            {
                flag=2;
            }
        }
        else if((buttons.get(6).state)==(buttons.get(7).state) && (buttons.get(6).state)==(buttons.get(8).state) && (buttons.get(6).state!=0))
        {

            (findViewById(R.id.cut_h3)).setVisibility(View.VISIBLE);
            if((buttons.get(6).state==1))
            {
                flag=1;
            }
            else
            {
                flag=2;
            }
        }
        //vertical checking
        else if((buttons.get(0).state)==(buttons.get(3).state) && (buttons.get(0).state)==(buttons.get(6).state) && (buttons.get(0).state!=0))
        {
            (findViewById(R.id.cut_v1)).setVisibility(View.VISIBLE);
            if((buttons.get(0).state==1))
            {
                flag=1;
            }
            else
            {
                flag=2;
            }
        }
        else if((buttons.get(1).state)==(buttons.get(4).state) && (buttons.get(1).state)==(buttons.get(7).state) && (buttons.get(1).state!=0))
        {
            (findViewById(R.id.cut_v2)).setVisibility(View.VISIBLE);
            if((buttons.get(1).state==1))
            {
                flag=1;
            }
            else
            {
                flag=2;
            }
        }
        else if((buttons.get(2).state)==(buttons.get(5).state) && (buttons.get(2).state)==(buttons.get(8).state) && (buttons.get(2).state!=0))
        {
            (findViewById(R.id.cut_v3)).setVisibility(View.VISIBLE);
            if((buttons.get(2).state==1))
            {
                flag=1;
            }
            else
            {
                flag=2;
            }
        }
        //diagonal checking
        else if((buttons.get(0).state)==(buttons.get(4).state) && (buttons.get(0).state)==(buttons.get(8).state) && (buttons.get(0).state!=0))
        {
            (findViewById(R.id.cut_d2)).setVisibility(View.VISIBLE);
            if((buttons.get(0).state==1))
            {
                flag=1;
            }
            else
            {
                flag=2;
            }
        }
        else if((buttons.get(2).state)==(buttons.get(4).state) && (buttons.get(2).state)==(buttons.get(6).state) && (buttons.get(2).state!=0))
        {
            (findViewById(R.id.cut_d1)).setVisibility(View.VISIBLE);
            if((buttons.get(2).state==1))
            {
                flag=1;
            }
            else
            {
                flag=2;
            }
        }

        if(flag==1||flag==2)
        {
            disable_Buttons();
            ((TextView)(findViewById(R.id.text_Over))).setVisibility(View.VISIBLE);
            if(flag==1)
            {
                ((TextView)(findViewById(R.id.text_Player_X))).setVisibility(View.VISIBLE);
            }
            else
            {
                ((TextView)(findViewById(R.id.text_Player_O))).setVisibility(View.VISIBLE);
            }
        }
        else if(count==9)
        {
            ((TextView)(findViewById(R.id.text_Over))).setVisibility(View.VISIBLE);
            ((TextView)(findViewById(R.id.text_Draw))).setVisibility(View.VISIBLE);
        }
    }

    public void disable_Buttons()
    {
        (findViewById(R.id.button_11)).setEnabled(false);
        (findViewById(R.id.button_12)).setEnabled(false);
        (findViewById(R.id.button_13)).setEnabled(false);
        (findViewById(R.id.button_21)).setEnabled(false);
        (findViewById(R.id.button_22)).setEnabled(false);
        (findViewById(R.id.button_23)).setEnabled(false);
        (findViewById(R.id.button_31)).setEnabled(false);
        (findViewById(R.id.button_32)).setEnabled(false);
        (findViewById(R.id.button_33)).setEnabled(false);
    }

    public void restart(View v)
    {
        Intent intent1=new Intent(this,Game.class);
        finish();
        startActivity(intent1);
    }


}