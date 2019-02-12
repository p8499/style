package p8499.style.core;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 3/2/2018.
 */
public class Style {
    private Environment mEnvironment;
    private String mStyleName;
    private File mStyleFile;
    private Map<String, Object> mNameValueMap;

    public Style(Environment environment, String styleName) {
        mEnvironment = environment;
        mStyleName = styleName;
        mStyleFile = new File(environment.getTempFolder(), "values" + File.separator + "style_" + styleName + ".xml");
        mNameValueMap = new HashMap<>();
    }

    public Style(Environment environment, String styleName, OnCreateEvent onCreateEvent) {
        this(environment, styleName);
        onCreateEvent.onCreate(this);
    }

    public Style(Style origStyle, String styleName) {
        mEnvironment = origStyle.mEnvironment;
        mStyleName = styleName;
        mStyleFile = new File(origStyle.getEnvironment().getTempFolder(), "values" + File.separator + "style_" + styleName + ".xml");
        mNameValueMap = new HashMap<>();
        mNameValueMap.putAll(origStyle.mNameValueMap);
    }

    public Style(Style origStyle, String styleName, OnCreateEvent onCreateEvent) {
        this(origStyle, styleName);
        onCreateEvent.onCreate(this);
    }

    public Environment getEnvironment() {
        return mEnvironment;
    }

    public String getStyleName() {
        return mStyleName;
    }

    public ColorSelector createColorSelector(String colorSelectorName) {
        return new ColorSelector(this, colorSelectorName);
    }

    public ColorSelector createColorSelector(String colorSelectorName, ColorSelector.OnCreateEvent onCreateEvent) {
        return new ColorSelector(this, colorSelectorName, onCreateEvent);
    }

    public DrawableSelector createDrawableSelector(String drawableSelectorName) {
        return new DrawableSelector(this, drawableSelectorName);
    }

    public DrawableSelector createDrawableSelector(String drawableSelectorName, DrawableSelector.OnCreateEvent onCreateEvent) {
        return new DrawableSelector(this, drawableSelectorName, onCreateEvent);
    }

    public Style addItem(String name, String value) {
        mNameValueMap.put(name, value == null ? "@null" : value);
        return this;
    }

    public Style addItem(String name, ColorSelector value) {
        mNameValueMap.put(name, value == null ? "@null" : value);
        return this;
    }

    public Style addItem(String name, String colorSelectorName, ColorSelector.OnCreateEvent onCreateEvent) {
        mNameValueMap.put(name, createColorSelector(colorSelectorName, onCreateEvent));
        return this;
    }

    public Style addItem(String name, DrawableSelector value) {
        mNameValueMap.put(name, value == null ? "@null" : value);
        return this;
    }

    public Style addItem(String name, String drawableSelectorName, DrawableSelector.OnCreateEvent onCreateEvent) {
        mNameValueMap.put(name, createDrawableSelector(drawableSelectorName, onCreateEvent));
        return this;
    }

    public Style addItem(Style... origStyles) {
        for (Style origStyle : origStyles) mNameValueMap.putAll(origStyle.mNameValueMap);
        return this;
    }

    public File print() {
        PrintWriter printWriter = null;
        try {
            mStyleFile.getParentFile().mkdirs();
            mStyleFile.createNewFile();
            printWriter = new PrintWriter(mStyleFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        printHeader(printWriter);
        for (Map.Entry<String, Object> entry : mNameValueMap.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            printWriter.println(String.format("        <item name=\"%s\">%s</item>", key, value.toString()));
            if (value instanceof ColorSelector)
                ((ColorSelector) value).print();
            if (value instanceof DrawableSelector)
                ((DrawableSelector) value).print();
        }
        printFooter(printWriter);
        printWriter.flush();
        printWriter.close();
        return mStyleFile;
    }

    private void printHeader(PrintWriter printWriter) {
        printWriter.println("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        printWriter.println("<resources>");
        printWriter.println("    <style name=\"" + mStyleName + "\">");
    }

    private void printFooter(PrintWriter printWriter) {
        printWriter.println("    </style>");
        printWriter.println("</resources>");
    }

    public static final String ANDROID_LAYOUT_WIDTH = "android:layout_width";
    public static final String ANDROID_LAYOUT_HEIGHT = "android:layout_height";
    public static final String ANDROID_LAYOUT_WEIGHT = "android:layout_weight";
    public static final String ANDROID_LAYOUT_GRAVITY = "android:layout_gravity";
    public static final String ANDROID_MINWIDTH = "android:minWidth";
    public static final String ANDROID_MINHEIGHT = "android:minHeight";
    public static final String ANDROID_MARGINLEFT = "android:layout_marginLeft";
    public static final String ANDROID_MARGINSTART = "android:layout_marginStart";
    public static final String ANDROID_MARGINRIGHT = "android:layout_marginRight";
    public static final String ANDROID_MARGINEND = "android:layout_marginEnd";
    public static final String ANDROID_MARGINTOP = "android:layout_marginTop";
    public static final String ANDROID_MARGINBOTTOM = "android:layout_marginBottom";
    public static final String ANDROID_PADDINGLEFT = "android:paddingLeft";
    public static final String ANDROID_PADDINGSTART = "android:paddingStart";
    public static final String ANDROID_PADDINGRIGHT = "android:paddingRight";
    public static final String ANDROID_PADDINGEND = "android:paddingEnd";
    public static final String ANDROID_PADDINGTOP = "android:paddingTop";
    public static final String ANDROID_PADDINGBOTTOM = "android:paddingBottom";
    public static final String ANDROID_ENABLED = "android:enabled";
    public static final String ANDROID_ORIENTATION = "android:orientation";
    public static final String ANDROID_BASELINEALIGNED = "android:baselineAligned";
    public static final String ANDROID_LAYOUT_ALIGNPARENTSTART = "android:layout_alignParentStart";
    public static final String ANDROID_LAYOUT_ALIGNPARENTEND = "android:layout_alignParentEnd";
    public static final String ANDROID_LAYOUT_CENTERVERTICAL = "android:layout_centerVertical";
    public static final String ANDROID_GRAVITY = "android:gravity";
    public static final String ANDROID_SCALETYPE = "android:scaleType";
    public static final String ANDROID_FOCUSABLE = "android:focusable";
    public static final String ANDROID_CLICKABLE = "android:clickable";
    public static final String ANDROID_LONGCLICKABLE = "android:longClickable";
    public static final String ANDROID_CONTEXTCLICKABLE = "android:contextClickable";
    public static final String ANDROID_BACKGROUND = "android:background";
    public static final String ANDROID_INPUTTYPE = "android:inputType";
    public static final String ANDROID_IMEOPTIONS = "android:imeOptions";
    public static final String ANDROID_TEXTALLCAPS = "android:textAllCaps";
    public static final String ANDROID_TEXTSIZE = "android:textSize";
    public static final String ANDROID_TEXTCOLOR = "android:textColor";
    public static final String ANDROID_TEXTCOLORHINT = "android:textColorHint";
    public static final String ANDROID_SRC = "android:src";
    public static final String ANDROID_TYPEFACE = "android:typeface";
    public static final String ANDROID_ELLIPSIZE = "android:ellipsize";
    public static final String ANDROID_MAXLINES = "android:maxLines";
    public static final String ANDROID_OVERSCROLLMODE = "android:overScrollMode";
    public static final String ANDROID_KEYPREVIEWLAYOUT = "android:keyPreviewLayout";
    public static final String ANDROID_KEYTEXTCOLOR = "android:keyTextColor";
    public static final String ANDROID_KEYTEXTSIZE = "android:keyTextSize";
    public static final String ANDROID_KEYBACKGROUND = "android:keyBackground";
    public static final String ANDROID_SHADOWRADIUS = "android:shadowRadius";
    public static final String ICONIFIEDBYDEFAULT = "iconifiedByDefault";
    public static final String QUERYBACKGROUND = "queryBackground";
    public static final String SEARCHHINTICON = "searchHintIcon";
    public static final String SEARCHICON = "searchIcon";


    public interface OnCreateEvent {
        void onCreate(Style style);
    }
}
