package p8499.style.core;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Administrator on 3/3/2018.
 */
public class DrawableSelector {
    private Style mStyle;
    private String mDrawableSelectorName;
    private File mDrawableSelectorFile;
    private Map<Condition, Drawable> mConditionDrawableMap;

    public DrawableSelector(Style style, String drawableSelectorName) {
        mStyle = style;
        mDrawableSelectorName = drawableSelectorName;
        mDrawableSelectorFile = new File(style.getEnvironment().getTempFolder(), "drawable" + File.separator + style.getStyleName() + "_" + drawableSelectorName + ".xml");
        mConditionDrawableMap = new LinkedHashMap<>();
    }

    public DrawableSelector(Style style, String drawableSelectorName, OnCreateEvent onCreateEvent) {
        this(style, drawableSelectorName);
        onCreateEvent.onCreate(this);
    }

    public Style getStyle() {
        return mStyle;
    }

    public String getDrawableSelectorName() {
        return mDrawableSelectorName;
    }

    public Drawable createDrawable() {
        return new Drawable(this, mConditionDrawableMap.size() + 1);
    }

    public Drawable createDrawable(Drawable.OnCreateEvent onCreateEvent) {
        return new Drawable(this, mConditionDrawableMap.size() + 1, onCreateEvent);
    }

    public DrawableSelector addRoute(Condition condition, String text) {
        mConditionDrawableMap.put(condition, new VectorDrawable(this, mConditionDrawableMap.size() + 1, text));
        return this;
    }

    public DrawableSelector addRoute(Condition condition, Drawable drawable) {
        mConditionDrawableMap.put(condition, drawable);
        return this;
    }

    public DrawableSelector addRoute(Condition condition, Drawable.OnCreateEvent onCreateEvent) {
        mConditionDrawableMap.put(condition, createDrawable(onCreateEvent));
        return this;
    }

    public File print() {
        PrintWriter printWriter = null;
        try {
            mDrawableSelectorFile.getParentFile().mkdirs();
            mDrawableSelectorFile.createNewFile();
            printWriter = new PrintWriter(mDrawableSelectorFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        printHeader(printWriter);
        for (Map.Entry<Condition, Drawable> entry : mConditionDrawableMap.entrySet()) {
            Condition condition = entry.getKey();
            Drawable drawable = entry.getValue();
            printWriter.print(String.format("    <item android:drawable=\"%s\"", drawable));
            for (Map.Entry<String, Boolean> criterion : condition.entrySet()) {
                String status = criterion.getKey();
                boolean match = criterion.getValue();
                printWriter.print(String.format(" %s=\"%b\"", status, match));
            }
            printWriter.println("/>");
            drawable.print();
        }
        printFooter(printWriter);
        printWriter.flush();
        printWriter.close();
        return mDrawableSelectorFile;
    }

    private void printHeader(PrintWriter printWriter) {
        printWriter.println("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        printWriter.println("<selector xmlns:android=\"http://schemas.android.com/apk/res/android\">");
    }

    private void printFooter(PrintWriter printWriter) {
        printWriter.print("</selector>");
    }

    @Override
    public String toString() {
        return "@drawable/" + mStyle.getStyleName() + "_" + mDrawableSelectorName;
    }

    public interface OnCreateEvent {
        void onCreate(DrawableSelector environment);
    }
}
