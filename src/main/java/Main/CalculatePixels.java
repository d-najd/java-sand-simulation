package Main;

public class CalculatePixels {

	/**
	 * TODO I think this doesn't work correctly, need to do more checking
	 * used for making stuff use pixels and not percentage of the display because we don't have 1x1 display's but
	 * instead have a 16x9 ratio, this is used for calculating the offsets NOT FOR WIDTH AND HEIGHT
	 * @param val the number of pixels we want the offest to be
	 * @param calWid true if we are calculating width false if height
	 * @return the percentage on the screen that needs to be drawn because opengl uses percentage not pixels
	 */
	public static float calOff(float val, boolean calWid){
		int appVal;
		if (calWid)
			appVal = MainApp.width;
		else
			appVal = MainApp.height;

		System.out.println((val/appVal*200-100)/100);
		return (val/appVal*200-100)/100; //I hate to do this horribleness or the floating value gods start doing weird shit
	}

	public static float calWid(){
		int appWid = MainApp.width;
		int appHei = MainApp.height;

		float ratio = (float) appWid/appHei;



		return 0f;
	}
}
