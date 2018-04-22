package general.knowledge;

import java.io.BufferedReader;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;

	public class MainActivity extends Activity {
		String intr;
		BufferedReader reader1;
				@Override
		    public void onCreate(Bundle savedInstanceState) 
		    {
		        super.onCreate(savedInstanceState);
		        setContentView(R.layout.activity_main);		        
		        final Button btnStart = (Button) findViewById(R.id.btnstart);
		        btnStart.setText("START");		        
		        btnStart.setTextColor(Color.BLUE);
		        btnStart.setTextSize(30);		     
		        btnStart.setTypeface(null, Typeface.BOLD);	        		        
		        btnStart.setOnClickListener(new Button.OnClickListener()
		        {
		        	public void onClick(View v)
		        	{
		        		Intent myIntent = new Intent(MainActivity.this, Question.class);
		        		startActivity(myIntent);
		        		
		        	}
		        });
		    }		    
		}
