package general.knowledge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
public class Question extends Activity  {
	private AdView adView;
	private static final String AD_UNIT_ID = "ca-app-pub-5446788340942490/4558444162";
	String qstr, op1,op2,op3,op4,ans;
	BufferedReader reader;
	RadioGroup rg;
	int i=0, j,  tv, fv;
	Button btnPre, btnFin, btnNext,btnExit;
	TextView Timer, tv1, tv2;
	RadioButton rb1, rb2, rb3, rb4;
	Intent myIntent;
	int totalQues=50;
	int[] score = new int[totalQues]; 
	String[] ch = new String[8];
	int[] rv = new int[totalQues];
	
	public String formatTime(long millis)
	{
	    String output="00:00";
	    long second=millis/1000;
	    long minute=second/60;
	    second=second%60;
	    minute=minute%60;
	    String sec=String.valueOf(second);
	    String min=String.valueOf(minute);
	    output=min+":"+sec;
	    return output;
	}
	
	@Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        adView = new AdView(this);
 		adView.setAdSize(AdSize.BANNER);
 		adView.setAdUnitId(AD_UNIT_ID);
 		LinearLayout layout = (LinearLayout) findViewById(R.id.linearLayout);
 		layout.addView(adView);
 		AdRequest adRequest = new AdRequest.Builder()
 			.addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
 			.addTestDevice("INSERT_YOUR_HASHED_DEVICE_ID_HERE")		
         .build();
 	       adView.loadAd(adRequest);
        btnPre = (Button) findViewById(R.id.btnpre);
        btnFin = (Button) findViewById(R.id.btnfin);
        btnNext = (Button) findViewById(R.id.btnnext);
        btnExit = (Button) findViewById(R.id.btnexit);
        tv1 = (TextView)findViewById(R.id.textView1);
        Timer = (TextView)findViewById(R.id.textView2);
        tv2 = (TextView)findViewById(R.id.textView3);
        rg = (RadioGroup) findViewById(R.id.radiogroup);
        rb1=(RadioButton)findViewById(R.id.radioButton1);
        rb2=(RadioButton)findViewById(R.id.radioButton2);
        rb3=(RadioButton)findViewById(R.id.radioButton3); 
        rb4=(RadioButton)findViewById(R.id.radioButton4);
        btnPre.setTypeface(null, Typeface.BOLD);
        btnFin.setTypeface(null, Typeface.BOLD);
        btnNext.setTypeface(null, Typeface.BOLD);
        btnExit.setTypeface(null, Typeface.BOLD);
        Timer.setTypeface(null, Typeface.BOLD);
        tv1.setTypeface(null, Typeface.BOLD);
        tv2.setTypeface(null, Typeface.BOLD);
        rb1.setTypeface(null, Typeface.BOLD);
        rb2.setTypeface(null, Typeface.BOLD);
        rb3.setTypeface(null, Typeface.BOLD);
        rb4.setTypeface(null, Typeface.BOLD);
        tv1.setTextColor(Color.WHITE);
        tv2.setTextColor(Color.WHITE);
        Timer.setTextColor(Color.WHITE);
        rb1.setTextColor(Color.WHITE);
        rb2.setTextColor(Color.WHITE);
        rb3.setTextColor(Color.WHITE);
        rb4.setTextColor(Color.WHITE);
        btnFin.setTextColor(Color.WHITE);
        btnExit.setTextColor(Color.WHITE);         
        Timer.setTextSize(16);
        tv1.setTextSize(14);
        tv2.setTextSize(14);
        rb1.setTextSize(14);
        rb2.setTextSize(14);
        rb3.setTextSize(14);
        rb4.setTextSize(14);      
        btnFin.setText("FINISH");
        btnExit.setText("MAIN MENU");       
        loadDataFromAsset();
        Timer();
        
        for(j=0; j<totalQues;j++)
        {
        	score[j]=0;
        	rv[i]=0;
        }
        
        btnFin.setEnabled(false);
    	btnPre.setEnabled(false);	
    	
        btnPre.setOnClickListener(new Button.OnClickListener()
        {
        	public void onClick(View v)
        	{
        		rg.clearCheck();
        		btnNext.setClickable(true);
        		if(i>0)
        		{
        			i--;
        			loadDataFromAsset();
        		}
        		if(rv[i]==1)
    			{
    				rb1.setChecked(true);
    			}
    			else if(rv[i]==2)
    			{
    				rb2.setChecked(true);
    			}
    			else if(rv[i]==3)
    			{
    				rb3.setChecked(true);
    			}
    			else if(rv[i]==4)
    			{
    				rb4.setChecked(true);
    			}
    			else if(rv[i]==0)
    			{
    				rg.clearCheck();
    			}	
        	}				
        });
         
        btnFin.setOnClickListener(new Button.OnClickListener()
        {
        	public void onClick(View v)
        	{
        		Bundle myData = new Bundle();
        		myIntent = new Intent(Question.this, Result.class);
        		for(j=0; j<totalQues; j++)
        		{
        			tv+=score[j];
        		}
        		myData.putInt("myInt1", tv);
        		fv=totalQues-tv;
        		myData.putInt("myInt2", fv);
        		myIntent.putExtras(myData);
        		startActivity(myIntent);
        	}
        });
        
        btnNext.setOnClickListener(new Button.OnClickListener()
        {
        	public void onClick(View v)
        	{
        		btnPre.setEnabled(true);
        		rg.clearCheck();
        		if(i<totalQues)
        		{
        			i++;
        			loadDataFromAsset();
        		}
        		
        		if(i==totalQues-1)
        		{
        			btnFin.setEnabled(true);
        			btnNext.setClickable(false);
        		}
        		        		
        		if(rv[i]==1)
    			{
    				rb1.setChecked(true);
    			}
    			else if(rv[i]==2)
    			{
    				rb2.setChecked(true);
    			}
    			else if(rv[i]==3)
    			{
    				rb3.setChecked(true);
    			}
    			else if(rv[i]==4)
    			{
    				rb4.setChecked(true);
    			}
    			else if(rv[i]==0)
    			{
    				rg.clearCheck();
    			}
        			
        	}				
       });
        
        btnExit.setOnClickListener(new Button.OnClickListener()
        {
        	public void onClick(View v)
        	{
        		Intent myIntent = new Intent(Question.this, MainActivity.class);
        		startActivity(myIntent);
        		
        	}
        });    
        
        
   }
        
	private void Timer() 
    {
		new CountDownTimer(1800000,1000)
    	{
	        public void onTick(long hoursUntilFinished)
	        {
	        	Timer.setText(formatTime(hoursUntilFinished));
	        }
	        
	    public void onFinish()
	    {
	    	tv2.setText("Time's Up!");
	        btnPre.setEnabled(false);
    		btnNext.setEnabled(false);
    		btnFin.setEnabled(true);
    		Timer.setText("00:00");
    		
	    }
	    }.start();
     }

        
    public void loadDataFromAsset()
    {
    	
    	try
    	{
    		InputStream is = getAssets().open(i+".txt");
    		reader = new BufferedReader(new InputStreamReader(is));
    	    qstr = reader.readLine();
    	    op1 = reader.readLine();
    	    op2 = reader.readLine();
    	    op3 = reader.readLine();
    	    op4 = reader.readLine();
    	    ans = reader.readLine();
    	}
    	catch (IOException ex) 
    	{
    		return;
    	}	
    	
    	tv1.setText(qstr); 
        rb1.setText(op1); 
        rb2.setText(op2); 
        rb3.setText(op3); 
        rb4.setText(op4); 
        
        
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() 
        {
			
			public void onCheckedChanged(RadioGroup arg0, int arg1) 
			{
				if(rb1.isChecked()==true && rb1.getText().toString().compareTo(ans)==0)
    	        {
    	        	score[i]=1;
    	        	rv[i]=1;
    	        	System.out.println(score[i]);
    	        	
    	        }
				else if(rb2.isChecked()==true && rb2.getText().toString().compareTo(ans)==0)
				{
					score[i]=1;
					rv[i]=2;
					System.out.println(score[i]);
    	        	
				}
				else if(rb3.isChecked()==true && rb3.getText().toString().compareTo(ans)==0)
				{
					score[i]=1;
					rv[i]=3;
					System.out.println(score[i]);
    	        	
				}
				else if(rb4.isChecked()==true && rb4.getText().toString().compareTo(ans)==0)
				{
					score[i]=1;
					rv[i]=4;
					System.out.println(score[i]);
    	        	
				}
				else if(rb1.isChecked()==true && rb1.getText().toString().compareTo(ans)!=0)
	    	        {
	    	        	score[i]=0;
	    	        	System.out.println(score[i]);
	    	        }
					else if(rb2.isChecked()==true && rb2.getText().toString().compareTo(ans)!=0)
					{
						score[i]=0;
						System.out.println(score[i]);
					}
					else if(rb3.isChecked()==true && rb3.getText().toString().compareTo(ans)!=0)
					{
						score[i]=0;
						System.out.println(score[i]);
					}
					else if(rb4.isChecked()==true && rb4.getText().toString().compareTo(ans)!=0)
					{
						score[i]=0;
						System.out.println(score[i]);	
					}
				if(rb1.isChecked()==true)
				{
					rv[i]=1;
				}
				else if(rb2.isChecked()==true)
				{
					rv[i]=2;
				}
				else if(rb3.isChecked()==true)
				{
					rv[i]=3;
				}
				else if(rb4.isChecked()==true)
				{
					rv[i]=4;
				}
			}				
        }); 
        
    	
     }
  public void onResume() {
		super.onResume();
	    if (adView != null) {
	    	adView.resume();
	    }
	}

	@Override
	public void onPause() {
		super.onPause();
		if (adView != null) {
			adView.pause();
	    }	    
	}
	@Override
	public void onDestroy() {
	// Destroy the AdView.
	    super.onDestroy();
		if (adView != null) {
			adView.destroy();
	    }
	}
}
    
    