package core;

import helpers.HomePageHelper;

/**
 * Created by Andrii_Chorniak on 8/5/2016.c
 */
public class HelperCreator {
    private static HomePageHelper homePageHelper;

    public static HomePageHelper getHomePageHelper() {
        if (homePageHelper != null)
            return homePageHelper;
        else
            return homePageHelper = new HomePageHelper();

    }


}
