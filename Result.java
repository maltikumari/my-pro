package general.knowledge;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Result extends Activity
{
	int i, j,aq;
	Intent myIntent;
	TextView tv1, tv2,tv3;
	Button btnRestart;
	
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        
        tv1 = (TextView)findViewById(R.id.textView1);
        tv2 = (TextView)findViewById(R.id.textView2);
        tv3 = (TextView)findViewById(R.id.textView3);
        btnRestart = (Button) findViewById(R.id.btnrestart);
        
        tv1.setTypeface(null, Typeface.BOLD);
        tv2.setTypeface(null, Typeface.BOLD);
        tv3.setTypeface(null, Typeface.BOLD);
        btnRestart.setTypeface(null, Typeface.BOLD);
        
        tv1.setTextColor(Color.WHITE);
        tv2.setTextColor(Color.WHITE);
        tv3.setTextColor(Color.WHITE);
        btnRestart.setTextColor(Color.BLACK);
        
        tv1.setTextSize(16);
        tv2.setTextSize(16);
        tv3.setTextSize(16);
        
        Intent myLocalIntent = getIntent();
    	Bundle myBundle = myLocalIntent.getExtras();
    	Integer i = myBundle.getInt("myInt1");
    	Integer j = myBundle.getInt("myInt2");
    	aq=i+j;
    	tv1.setText("   Total Number Of Question is 50");
    	tv2.setText("   Right Answer is " +i);
    	tv3.setText("   Wrong Answer is " +j);
    	btnRestart.setText("Restart");
    	
    	btnRestart.setOnClickListener(new Button.OnClickListener()
	        {
	        	public void onClick(View v)
	        	{
	        		Intent myIntent = new Intent(Result.this, MainActivity.class);
	        		startActivity(myIntent);
	        		
	        	}
	        });
        
    }

    
}
