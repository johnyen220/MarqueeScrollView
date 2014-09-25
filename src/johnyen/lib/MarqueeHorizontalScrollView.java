package johnyen.lib;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import johnyen.lib.DeviceJudge;

public class MarqueeHorizontalScrollView extends HorizontalScrollView {
    Context mContext;
    Activity activity;
    private LinearLayout childLinearLayout1,linearLayout;
    private int scrollprogress=0;
    private int marqueeTextSize=10;
    private Thread splashTread;
    private List<TextView> marqueeTextViewArray;
	public MarqueeHorizontalScrollView(Context context) {
		super(context);
		this.mContext=context;
		this.activity=(Activity)context;
		// TODO Auto-generated constructor stub
	}

	public MarqueeHorizontalScrollView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		this.mContext=context;
		this.activity=(Activity)context;
	}

	public MarqueeHorizontalScrollView(Context context, AttributeSet attrs,
			int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		this.mContext=context;
		this.activity=(Activity)context;
	}
	 private boolean mScrollable = true;
	 private int textColor=Color.WHITE;

	 public void setIsScrollable(boolean scrollable) {
	        mScrollable = scrollable;
	    }
	 public boolean getIsScrollable(){
	        return mScrollable;
	    }
     public void startMove(){
    	        this.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
    	        linearLayout=(LinearLayout) this.getChildAt(0);
    	        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
    	        int layoutHeight=linearLayout.getMeasuredHeight();
    	        int screenWidth=DeviceJudge.getScreenWidthSize(activity);
    			LayoutParams layoutparams=new LayoutParams(screenWidth,LayoutParams.MATCH_PARENT);
    			childLinearLayout1=new LinearLayout(activity);
    		       
    			childLinearLayout1.setLayoutParams(layoutparams);

    		    linearLayout.addView(childLinearLayout1);
    		    if(marqueeTextViewArray!=null){
    		     for(int i=0;i<marqueeTextViewArray.size();i++){
    		    	     String marqueeString=marqueeTextViewArray.get(i).getText().toString();
    		    	     marqueeString=marqueeString+"        ";
    		    	     marqueeTextViewArray.get(i).setText(marqueeString);
    		    	     marqueeTextViewArray.get(i).setTextSize(20);
    		    	     marqueeTextViewArray.get(i).setTextColor(textColor);
    		    	     linearLayout.addView(marqueeTextViewArray.get(i));
    		     }
    		    }
    		    moveForward();
     }
	/* (non-Javadoc)
	 * @see android.widget.HorizontalScrollView#onTouchEvent(android.view.MotionEvent)
	 */

		private void moveForward(){
			
			splashTread=new Thread(){
				
				
				@Override
				public void run() {
					
				    while(true){
								
								activity.runOnUiThread(new Runnable() {
									@Override
									public void run() {
										// TODO Auto-generated method stub
								       linearLayout.scrollTo(scrollprogress,0);
										int width=linearLayout.getWidth()+DeviceJudge.getScreenWidthSize(activity);
										scrollprogress+=5;
										if(scrollprogress>width){
											scrollprogress=0;
										}
									}
							  });
							try {
								sleep(50);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}	
				    }  
				}
			};
			splashTread.start();
		}

		public void setStringAdapter(List<String> marqueeStringArray) {
			// TODO Auto-generated method stub
			List<TextView> marqueeTextViewArray=new ArrayList<TextView>();
			for(int i=0;i<marqueeStringArray.size();i++){
				TextView textView=new TextView(activity);
				textView.setText(marqueeStringArray.get(i));
				marqueeTextViewArray.add(textView);
			}
			this.marqueeTextViewArray=marqueeTextViewArray;
		}

		public void setMarqueeTextSize(int i) {
			// TODO Auto-generated method stub
			this.marqueeTextSize=i;
		}

		public void setMarqueeTextColor(int color) {
			// TODO Auto-generated method stub
			this.textColor=color;
		}


}
