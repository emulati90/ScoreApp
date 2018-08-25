package com.example.sarahemmanuels.scoreapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;

public class WcupActivity extends AppCompatActivity {

    ImageSwitcher swHome;
    ImageSwitcher swAway;

    Button Home_left_btn;
    Button Home_right_btn;
    Button Away_left_btn;
    Button Away_right_btn;
    Button goalBtn1_home;
    Button goalBtn2_home;
    Button goalBtn1_away;
    Button goalBtn2_away;
    Button cornerBtn1_home;
    Button cornerBtn2_home;
    Button cornerBtn1_away;
    Button cornerBtn2_away;
    Button yellowBtn1_home;
    Button yellowBtn2_home;
    Button yellowBtn1_away;
    Button yellowBtn2_away;
    Button red_Btn1_home;
    Button red_Btn2_home;
    Button red_Btn1_away;
    Button red_Btn2_away;
    Button onTargetBtn1_home;
    Button onTargetBtn2_home;
    Button onTargetBtn1_away;
    Button onTargetBtn2_away;
    Button offTargetBtn1_home;
    Button offTargetBtn2_home;
    Button offTargetBtn1_away;
    Button offTargetBtn2_away;
    Button resetBtn;

    int images[] = {R.drawable.wcup0, R.drawable.wcup2, R.drawable.wcup1, R.drawable.wcup0};

    int position1;
    int position2;
    int goals1;
    int goals2;
    int corner1;
    int corner2;
    int yellow1;
    int yellow2;
    int red1;
    int red2;
    int onTarget1;
    int onTarget2;
    int offTarget1;
    int offTarget2;
    int possess1;
    int possess2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wcup);
        Home_left_btn = (Button) findViewById(R.id.Home_left_button);
        Home_right_btn = (Button) findViewById(R.id.Home_right_button);
        Away_left_btn = (Button) findViewById(R.id.Away_left_button);
        Away_right_btn = (Button) findViewById(R.id.Away_right_button);

        goalBtn1_home = (Button) findViewById(R.id.goalBtn1_home);
        goalBtn2_home = (Button) findViewById(R.id.goalBtn2_home);
        goalBtn1_away = (Button) findViewById(R.id.goalBtn1_away);
        goalBtn2_away = (Button) findViewById(R.id.goalBtn2_away);

        cornerBtn1_home = (Button) findViewById(R.id.cornerBtn1_home);
        cornerBtn2_home = (Button) findViewById(R.id.cornerBtn2_home);
        cornerBtn1_away = (Button) findViewById(R.id.cornerBtn1_away);
        cornerBtn2_away = (Button) findViewById(R.id.cornerBtn2_away);

        yellowBtn1_home = (Button) findViewById(R.id.yellow_Btn1_home);
        yellowBtn2_home = (Button) findViewById(R.id.yellow_Btn2_home);
        yellowBtn1_away = (Button) findViewById(R.id.yellow_Btn1_away);
        yellowBtn2_away = (Button) findViewById(R.id.yellow_Btn2_away);

        red_Btn1_home = (Button) findViewById(R.id.red_Btn1_home);
        red_Btn2_home = (Button) findViewById(R.id.red_Btn2_home);
        red_Btn1_away = (Button) findViewById(R.id.red_Btn1_away);
        red_Btn2_away = (Button) findViewById(R.id.red_Btn2_away);

        onTargetBtn1_home = (Button) findViewById(R.id.onTargetBtn1_home);
        onTargetBtn2_home = (Button) findViewById(R.id.onTargetBtn2_home);
        onTargetBtn1_away = (Button) findViewById(R.id.onTargetBtn1_away);
        onTargetBtn2_away = (Button) findViewById(R.id.onTargetBtn2_away);

        offTargetBtn1_home = (Button) findViewById(R.id.offTargetBtn1_home);
        offTargetBtn2_home = (Button) findViewById(R.id.offTargetBtn2_home);
        offTargetBtn1_away = (Button) findViewById(R.id.offTargetBtn1_away);
        offTargetBtn2_away = (Button) findViewById(R.id.offTargetBtn2_away);

        resetBtn = (Button) findViewById(R.id.resetBtn);

        swHome = (ImageSwitcher) findViewById(R.id.Home_imgSw);
        swHome.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView homeView = new ImageView(WcupActivity.this);
                homeView.setImageResource(images[position1]);
                return homeView;
            }
        });

        swAway = (ImageSwitcher) findViewById(R.id.Away_imgSw);
        swAway.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView awayView = new ImageView(WcupActivity.this);
                awayView.setImageResource(images[position2]);
                return awayView;
            }
        });

        swHome.setInAnimation(this, android.R.anim.slide_in_left);
        swHome.setOutAnimation(this, android.R.anim.slide_out_right);

        swAway.setInAnimation(this, android.R.anim.slide_in_left);
        swAway.setOutAnimation(this, android.R.anim.slide_out_right);

        Home_left_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position1 > 0)
                    position1--;
                if (position1 < 0)
                    position1 = 0;
                swHome.setImageResource(images[position1]);
                goals1 = 0;
                corner1 = 0;
                yellow1 = 0;
                red1 = 0;
                onTarget1 = 0;
                offTarget1 = 0;
                possess1 = 0;
                displayGoal1(goals1);
                displayCorner1(corner1);
                displayYellow1(yellow1);
                displayRed1(red1);
                displayOnTarget1(onTarget1);
                displayOffTarget1(offTarget1);
            }
        });

        Home_right_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position1 < images.length)
                    position1++;
                if (position1 >= images.length)
                    position1 = images.length - 1;
                swHome.setImageResource(images[position1]);
                goals1 = 0;
                corner1 = 0;
                yellow1 = 0;
                red1 = 0;
                onTarget1 = 0;
                offTarget1 = 0;
                possess1 = 0;
                displayGoal1(goals1);
                displayCorner1(corner1);
                displayYellow1(yellow1);
                displayRed1(red1);
                displayOnTarget1(onTarget1);
                displayOffTarget1(offTarget1);
            }
        });

        Away_left_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position2 > 0)
                    position2--;
                if (position2 < 0)
                    position2 = 0;
                swAway.setImageResource(images[position2]);
                goals2 = 0;
                corner2 = 0;
                yellow2 = 0;
                red2 = 0;
                onTarget2 = 0;
                offTarget2 = 0;
                possess2 = 0;
                displayGoal2(goals2);
                displayCorner2(corner2);
                displayYellow2(yellow2);
                displayRed2(red2);
                displayOnTarget2(onTarget2);
                displayOffTarget2(offTarget2);
            }
        });

        Away_right_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position2 < images.length)
                    position2++;
                if (position2 >= images.length)
                    position2 = images.length - 1;
                swAway.setImageResource(images[position2]);
                goals2 = 0;
                corner2 = 0;
                yellow2 = 0;
                red2 = 0;
                onTarget2 = 0;
                offTarget2 = 0;
                possess2 = 0;
                displayGoal2(goals2);
                displayCorner2(corner2);
                displayYellow2(yellow2);
                displayRed2(red2);
                displayOnTarget2(onTarget2);
                displayOffTarget2(offTarget2);
            }
        });

        goalBtn1_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (goals1 > 0)
                    goals1--;
                if (goals1 < 0)
                    goals1 = 0;
                displayGoal1(goals1);
            }
        });

        goalBtn2_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goals1 += 1;
                displayGoal1(goals1);
            }
        });

        goalBtn1_away.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (goals2 >= 0)
                    goals2--;
                if (goals2 <= 0)
                    goals2 = 0;
                displayGoal2(goals2);
            }
        });

        goalBtn2_away.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goals2 += 1;
                displayGoal2(goals2);
            }
        });

        cornerBtn1_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (corner1 > 0)
                    corner1--;
                if (corner1 < 0)
                    corner1 = 0;
                displayCorner1(corner1);
            }
        });

        cornerBtn2_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                corner1 += 1;
                displayCorner1(corner1);
            }
        });

        cornerBtn1_away.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (corner2 >= 0)
                    corner2--;
                if (corner2 <= 0)
                    corner2 = 0;
                displayCorner2(corner2);
            }
        });

        cornerBtn2_away.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                corner2 += 1;
                displayCorner2(corner2);
            }
        });

        yellowBtn1_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (yellow1 > 0)
                    yellow1--;
                if (yellow1 < 0)
                    yellow1 = 0;
                displayYellow1(yellow1);
            }
        });

        yellowBtn2_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yellow1 += 1;
                displayYellow1(yellow1);
            }
        });

        yellowBtn1_away.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (yellow2 >= 0)
                    yellow2--;
                if (yellow2 <= 0)
                    yellow2 = 0;
                displayYellow2(yellow2);
            }
        });

        yellowBtn2_away.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yellow2 += 1;
                displayYellow2(yellow2);
            }
        });

        red_Btn1_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (red1 > 0)
                    red1--;
                if (red1 < 0)
                    red1 = 0;
                displayRed1(red1);
            }
        });

        red_Btn2_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                red1 += 1;
                displayRed1(red1);
            }
        });

        red_Btn1_away.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (red2 >= 0)
                    red2--;
                if (red2 <= 0)
                    red2 = 0;
                displayRed2(red2);
            }
        });

        red_Btn2_away.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                red2 += 1;
                displayRed2(red2);
            }
        });

        onTargetBtn1_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onTarget1 > 0)
                    onTarget1--;
                if (onTarget1 < 0)
                    onTarget1 = 0;
                displayOnTarget1(onTarget1);
            }
        });

        onTargetBtn2_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onTarget1 += 1;
                displayOnTarget1(onTarget1);
            }
        });

        onTargetBtn1_away.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onTarget2 >= 0)
                    onTarget2--;
                if (onTarget2 <= 0)
                    onTarget2 = 0;
                displayOnTarget2(onTarget2);
            }
        });

        onTargetBtn2_away.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onTarget2 += 1;
                displayOnTarget2(onTarget2);
            }
        });

        offTargetBtn1_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (offTarget1 > 0)
                    offTarget1--;
                if (offTarget1 < 0)
                    offTarget1 = 0;
                displayOffTarget1(offTarget1);
            }
        });

        offTargetBtn2_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                offTarget1 += 1;
                displayOffTarget1(offTarget1);
            }
        });

        offTargetBtn1_away.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (offTarget2 >= 0)
                    offTarget2--;
                if (offTarget2 <= 0)
                    offTarget2 = 0;
                displayOffTarget2(offTarget2);
            }
        });

        offTargetBtn2_away.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                offTarget2 += 1;
                displayOffTarget2(offTarget2);
            }
        });

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                swHome.setImageResource(R.drawable.wcup0);
                position1 = 0;
                swAway.setImageResource(R.drawable.wcup0);
                position2 = 0;
                goals1 = 0;
                goals2 = 0;
                corner1 = 0;
                corner2 = 0;
                yellow1 = 0;
                yellow2 = 0;
                red1 = 0;
                red2 = 0;
                onTarget1 = 0;
                onTarget2 = 0;
                offTarget1 = 0;
                offTarget2 = 0;
                possess1 = 0;
                possess2 = 0;
                displayGoal1(goals1);
                displayGoal2(goals2);
                displayCorner1(corner1);
                displayCorner2(corner2);
                displayYellow1(yellow1);
                displayYellow2(yellow2);
                displayRed1(red1);
                displayRed2(red2);
                displayOnTarget1(onTarget1);
                displayOnTarget2(onTarget2);
                displayOffTarget1(offTarget1);
                displayOffTarget2(offTarget2);
            }
        });
    }

    private void displayGoal1(int goals1) {
        TextView goal1TextView = (TextView) findViewById(R.id.goals1);
        goal1TextView.setText("" + goals1);
    }

    private void displayGoal2(int goals2) {
        TextView goal2TextView = (TextView) findViewById(R.id.goals2);
        goal2TextView.setText("" + goals2);
    }

    private void displayCorner1(int corner1) {
        TextView corner1TextView = (TextView) findViewById(R.id.corner1);
        corner1TextView.setText("" + corner1);
    }

    private void displayCorner2(int corner2){
        TextView corner2TextView = (TextView) findViewById(R.id.corner2);
        corner2TextView.setText("" + corner2);
    }

    private void displayYellow1(int yellow1) {
        TextView yellow1TextView = (TextView) findViewById(R.id.yellow1);
        yellow1TextView.setText("" + yellow1);
    }

    private void displayYellow2(int yellow2){
        TextView yellow2TextView = (TextView) findViewById(R.id.yellow2);
        yellow2TextView.setText("" + yellow2);
    }

    private void displayRed1(int yellow1) {
        TextView red1TextView = (TextView) findViewById(R.id.red1);
        red1TextView.setText("" + yellow1);
    }
    private void displayRed2(int red2){
        TextView red2TextView = (TextView) findViewById(R.id.red2);
        red2TextView.setText("" + red2);
    }

    private void displayOnTarget1(int onTarget1) {
        TextView onTarget1TextView = (TextView) findViewById(R.id.onTarget1);
        onTarget1TextView.setText("" + onTarget1);
    }
    private void displayOnTarget2(int onTarget2) {
        TextView onTarget2TextView = (TextView) findViewById(R.id.onTarget2);
        onTarget2TextView.setText("" + onTarget2);
    }

    private void displayOffTarget1(int offTarget1) {
        TextView offTarget1TextView = (TextView) findViewById(R.id.offTarget1);
        offTarget1TextView.setText("" + offTarget1);
    }
    private void displayOffTarget2(int offTarget2) {
        TextView offTarget2TextView = (TextView) findViewById(R.id.offTarget2);
        offTarget2TextView.setText("" + offTarget2);
    }

    long startTime = 0;
    public void startTimer(View view) {
        Timer stopwatchTimer = new Timer();
        startTime = System.currentTimeMillis();
        stopwatchTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        TextView timerTextView = findViewById(R.id.time);
                        timerTextView.setText(stopwatch());
                    }
                });
            }
        },0, 10);
    }
    // Returns the combined string for the stopwatch, counting in tenths of seconds.
    public String stopwatch() {
        long nowTime = System.currentTimeMillis();
        long cast = nowTime - startTime;
        Date date = new Date(cast);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.S");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat.format(date);
    }
}
