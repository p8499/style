package p8499.style.core;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 3/3/2018.
 */
public class Condition {
    public static final String STATE_FOCUSED = "android:state_focused";
    public static final String STATE_FIRST = "android:state_first";
    public static final String STATE_ACCELERATED = "android:state_accelerated";
    public static final String STATE_ACTIVATED = "android:state_activated";
    public static final String STATE_ACTIVE = "android:state_active";
    public static final String STATE_DRAG_CAN_ACCEPT = "android:state_drag_can_accept";
    public static final String STATE_DRAG_HOVERED = "android:state_drag_hovered";
    public static final String STATE_ENABLED = "android:state_enabled";
    public static final String STATE_HOVERED = "android:state_hovered";
    public static final String STATE_LAST = "android:state_last";
    public static final String STATE_MIDDLE = "android:state_middle";
    public static final String STATE_SELECTED = "android:state_selected";
    public static final String STATE_SINGLE = "android:state_single";
    public static final String STATE_WINDOW_FOCUSED = "android:state_window_focused";
    public static final String STATE_CHECKABLE = "android:state_checkable";
    public static final String STATE_CHECKED = "android:state_checked";
    public static final String STATE_PRESSED = "android:state_pressed";
    private Map<String, Boolean> mStateMatchMap;

    public Condition() {
        mStateMatchMap = new HashMap<String, Boolean>();
    }

    public Condition and(String state, boolean match) {
        mStateMatchMap.put(state, match);
        return this;
    }

    public Condition and(String state) {
        mStateMatchMap.put(state, true);
        return this;
    }

    public Set<Map.Entry<String, Boolean>> entrySet() {
        return mStateMatchMap.entrySet();
    }

    public static Condition empty() {
        return new Condition();
    }

    public static Condition from(String state, boolean match) {
        return new Condition().and(state, match);
    }

    public static Condition from(String state) {
        return new Condition().and(state, true);
    }
}
