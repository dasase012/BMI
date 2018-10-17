import java.util.TimerTask;
import java.util.*;

public class SampleTimer {

	public static int count;
	public static void main(String[] args) {
		count=0;
		
		Timer t = new Timer();
		TimerTask ttask = new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
					if(count<5) {
						System.out.println("test");
						count++;
					}else {
						t.cancel();
						
					}
				}
		};
		t.schedule(ttask, 5000,2000);
	}
}
