package com.example.medcenter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.WindowManager;
<<<<<<< HEAD
import android.widget.TextView;
=======
>>>>>>> 898eee61761e56c0f280cb150f8923f9a817bd83

import com.androidplot.xy.LineAndPointFormatter;
import com.androidplot.xy.PointLabelFormatter;
import com.androidplot.xy.SimpleXYSeries;
import com.androidplot.xy.XYPlot;
import com.androidplot.xy.XYSeries;

/**
 * A straightforward example of using AndroidPlot to plot some data.
 */
public class GraphingActivity extends Activity {

  private XYPlot plot;
  String patientUserName = "";
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    // Get the directory path to the download folder and create an app
    // folder there.
    String directoryPath = Environment.getExternalStoragePublicDirectory(
        Environment.DIRECTORY_DOWNLOADS).toString()
        + "/";
    
<<<<<<< HEAD
    String fileName = UserInformation.userName+ ".txt";
=======
    String fileName = UserInformation.userName + ".txt";
    TextView t = new TextView(this);
    t = (TextView) findViewById(R.id.test);
    t.setText(UserInformation.userName);
>>>>>>> abbf920fafaac5d195f4b7bb3c61606cd9b197d7
    
    //Read existing user data from file.
    String data;
	try {
		data = FileHandler.ReadFile(directoryPath + "medCenter/", fileName);
		String[] patientInfo = UserInformation.parseInfo(data);

	    // fun little snippet that prevents users from taking screenshots
	    // on ICS+ devices :-)
	    getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,
	        WindowManager.LayoutParams.FLAG_SECURE);

	    setContentView(R.layout.activity_graphing);
	    UserInformation.userName = patientUserName;
	    // Get the directory path to the download folder and create an app
	    // folder there.
	  
	    	//Get the patients information.


String ageString = patientInfo[6];
String weightString = patientInfo[7];

ageString = ageString.replace("]","");
weightString = weightString.replace("]","");
ageString = ageString.replace("[","");
weightString = weightString.replace("[","");

String[] weight = weightString.split(":");

String[] age = weightString.split(":");

Integer[] ageArray = new Integer[age.length];
ageArray[age.length] = 10;
Integer[] weightArray = new Integer[weight.length];
weightArray[age.length] = 10;

	    // initialize our XYPlot reference:
	    plot = (XYPlot) findViewById(R.id.mySimpleXYPlot);

	    // Create a couple arrays of y-values to plot:
	    Integer[] xVals = ageArray;
	    Integer[] yVals = weightArray;
	    
	    Log.i("test",ageArray.toString());
	    
	   

	    // Turn the above arrays into XYSeries':
	    XYSeries series1 = new SimpleXYSeries(Arrays.asList(xVals), // SimpleXYSeries
	                                                                // takes a List
	                                                                // so turn our
	                                                                // array into a
	                                                                // List
	        Arrays.asList(yVals), "Weight"); // Set the display title of the series

	    // Create a formatter to use for drawing a series using LineAndPointRenderer
	    // and configure it from xml:
	    LineAndPointFormatter series1Format = new LineAndPointFormatter();
	    series1Format.setPointLabelFormatter(new PointLabelFormatter());
	    series1Format.configure(getApplicationContext(),
	        R.xml.line_point_formatter_with_plf1);

	    // add a new series' to the xyplot:
	    plot.addSeries(series1, series1Format);

	    // reduce the number of range labels
	    plot.setTicksPerRangeLabel(3);
	    plot.getGraphWidget().setDomainLabelOrientation(-45);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

  
}
}