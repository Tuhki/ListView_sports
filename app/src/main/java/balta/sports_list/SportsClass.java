package balta.sports_list;


import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.renderscript.Allocation;
import android.support.annotation.DrawableRes;

public class SportsClass {

    private String sportImage;
    private String sportName;
    private String sportDescription;

    public String getSportImage() {
        return sportImage;
    }

    public void setSportImage(String sportImage) {
        this.sportImage = sportImage;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public String getSportDescription() {
        return sportDescription;
    }

    public void setSportDescription(String sportDescription) { this.sportDescription = sportDescription; }

}