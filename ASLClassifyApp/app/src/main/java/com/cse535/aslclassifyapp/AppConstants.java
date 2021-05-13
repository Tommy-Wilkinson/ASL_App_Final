package com.cse535.aslclassifyapp;

import java.util.HashMap;
import java.util.Map;

public final class AppConstants {
    public static final String SP_LAST_NAME_KEY = "userLastName";
    public static final String SP_COUNTER_KEY = "practice_counter";
    public static final String EXTRA_SEL_GESTURE_KEY = "selectedGesture";
    public static final String EXTRA_VIDEO_ABS_PATH = "videoAbsolutePath";
    public static final String ASL_APP = "ASL_APP";
    public static final String FILENAME_PREFIX = "GESTURE_PRACTICE_";
    public static final String ARG_MESSAGE = "message";

    public static final boolean USE_GESTURE_URLS = true;

    public static final Map<String, String> GESTURE_URLS = new HashMap<>();
    static {
        GESTURE_URLS.put("buy", "https://www.signingsavvy.com/media/mp4-ld/6/6442.mp4");
        GESTURE_URLS.put("house", "https://www.signingsavvy.com/media/mp4-ld/23/23234.mp4");
        GESTURE_URLS.put("fun", "https://www.signingsavvy.com/media/mp4-ld/22/22976.mp4");
        GESTURE_URLS.put("hope", "https://www.signingsavvy.com/media/mp4-ld/22/22197.mp4");
        GESTURE_URLS.put("arrive", "https://www.signingsavvy.com/media/mp4-ld/26/26971.mp4");
        GESTURE_URLS.put("really", "https://www.signingsavvy.com/media/mp4-ld/24/24977.mp4");
        GESTURE_URLS.put("read", "https://www.signingsavvy.com/media/mp4-ld/7/7042.mp4");
        GESTURE_URLS.put("lip", "https://www.signingsavvy.com/media/mp4-ld/26/26085.mp4");
        GESTURE_URLS.put("mouth", "https://www.signingsavvy.com/media/mp4-ld/22/22188.mp4");
        GESTURE_URLS.put("some", "https://www.signingsavvy.com/media/mp4-ld/23/23931.mp4");
        GESTURE_URLS.put("communicate", "https://www.signingsavvy.com/media/mp4-ld/22/22897.mp4");
        GESTURE_URLS.put("write", "https://www.signingsavvy.com/media/mp4-ld/27/27923.mp4");
        GESTURE_URLS.put("create", "https://www.signingsavvy.com/media/mp4-ld/22/22337.mp4");
        GESTURE_URLS.put("pretend", "https://www.signingsavvy.com/media/mp4-ld/25/25901.mp4");
        GESTURE_URLS.put("sister", "https://www.signingsavvy.com/media/mp4-ld/21/21587.mp4");
        GESTURE_URLS.put("man", "https://www.signingsavvy.com/media/mp4-ld/21/21568.mp4");
        GESTURE_URLS.put("one", "https://www.signingsavvy.com/media/mp4-ld/26/26492.mp4");
        GESTURE_URLS.put("drive", "https://www.signingsavvy.com/media/mp4-ld/23/23918.mp4");
        GESTURE_URLS.put("perfect", "https://www.signingsavvy.com/media/mp4-ld/24/24791.mp4");
        GESTURE_URLS.put("mother", "https://www.signingsavvy.com/media/mp4-ld/21/21571.mp4");
    }

    public static final Map<String, Integer> GESTURE_LOCAL_IDS = new HashMap<>();
    static {
        GESTURE_LOCAL_IDS.put("buy", R.raw.buy);
        GESTURE_LOCAL_IDS.put("house", R.raw.house);
        GESTURE_LOCAL_IDS.put("fun", R.raw.fun);
        GESTURE_LOCAL_IDS.put("hope", R.raw.hope);
        GESTURE_LOCAL_IDS.put("arrive", R.raw.arrive);
        GESTURE_LOCAL_IDS.put("really", R.raw.really);
        GESTURE_LOCAL_IDS.put("read", R.raw.read);
        GESTURE_LOCAL_IDS.put("lip", R.raw.lip);
        GESTURE_LOCAL_IDS.put("mouth", R.raw.mouth);
        GESTURE_LOCAL_IDS.put("some", R.raw.some);
        GESTURE_LOCAL_IDS.put("communicate", R.raw.communicate);
        GESTURE_LOCAL_IDS.put("write", R.raw.write);
        GESTURE_LOCAL_IDS.put("create", R.raw.create);
        GESTURE_LOCAL_IDS.put("pretend", R.raw.pretend);
        GESTURE_LOCAL_IDS.put("sister", R.raw.sister);
        GESTURE_LOCAL_IDS.put("man", R.raw.man);
        GESTURE_LOCAL_IDS.put("one", R.raw.one);
        GESTURE_LOCAL_IDS.put("drive", R.raw.drive);
        GESTURE_LOCAL_IDS.put("perfect", R.raw.perfect);
        GESTURE_LOCAL_IDS.put("mother", R.raw.mother);
    }
}
