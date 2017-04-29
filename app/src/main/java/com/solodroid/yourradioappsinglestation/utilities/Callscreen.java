package com.solodroid.yourradioappsinglestation.utilities;

import android.app.Activity;
import android.content.Intent;

import com.solodroid.yourradioappsinglestation.activities.BaseWebviewActivity;
import com.solodroid.yourradioappsinglestation.activities.ContactUsActivity;
import com.solodroid.yourradioappsinglestation.activities.ScheduleActivity;

/**
 * Created by leandro.luis.cuvelo on 2/5/2017.
 */

public class Callscreen {

    public static void renderURL(Activity mActivity, String url, String title) {
        Intent i = new Intent(mActivity, BaseWebviewActivity.class);
        i.putExtra(BaseWebviewActivity.URL_TO_RENDER_TAG,url);
        i.putExtra(BaseWebviewActivity.TITLE, title);
        mActivity.startActivity(i);
    }

    public static void goToContactUsActivity(Activity mActivity){
        Intent i = new Intent(mActivity, ContactUsActivity.class);
        mActivity.startActivity(i);
    }

    public static void goScheduleActivity(Activity mActivity){
        Intent i = new Intent(mActivity, ScheduleActivity.class);
        mActivity.startActivity(i);
    }


}
