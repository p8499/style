package p8499.style.core;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Administrator on 3/3/2018.
 */
public class ColorSelector {
    private Style mStyle;
    private String mColorSelectorName;
    private File mColorSelectorFile;
    private Map<Condition, ARGB> mConditionColorMap;

    public ColorSelector(Style style, String colorSelectorName) {
        mStyle = style;
        mColorSelectorName = colorSelectorName;
        mColorSelectorFile = new File(style.getEnvironment().getTempFolder(), "color" + File.separator + style.getStyleName() + "_" + colorSelectorName + ".xml");
        mConditionColorMap = new LinkedHashMap<>();
    }

    public ColorSelector(Style style, String colorSelectorName, OnCreateEvent onCreateEvent) {
        this(style, colorSelectorName);
        onCreateEvent.onCreate(this);
    }


    public ColorSelector addRoute(Condition condition, ARGB color) {
        mConditionColorMap.put(condition, color);
        return this;
    }

    public File print() {
        PrintWriter printWriter = null;
        try {
            mColorSelectorFile.getParentFile().mkdirs();
            mColorSelectorFile.createNewFile();
            printWriter = new PrintWriter(mColorSelectorFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        printHeader(printWriter);
        for (Map.Entry<Condition, ARGB> entry : mConditionColorMap.entrySet()) {
            Condition condition = entry.getKey();
            ARGB color = entry.getValue();
            printWriter.print(String.format("    <item android:color=\"%s\"", color));
            for (Map.Entry<String, Boolean> criterion : condition.entrySet()) {
                String status = criterion.getKey();
                boolean match = criterion.getValue();
                printWriter.print(String.format(" %s=\"%b\"", status, match));
            }
            printWriter.println("/>");
        }
        printFooter(printWriter);
        printWriter.flush();
        printWriter.close();
        return mColorSelectorFile;
    }

    @Override
    public String toString() {
        return "@color/" + mStyle.getStyleName() + "_" + mColorSelectorName;
    }

    private void printHeader(PrintWriter printWriter) {
        printWriter.println("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        printWriter.println("<selector xmlns:android=\"http://schemas.android.com/apk/res/android\">");
    }

    private void printFooter(PrintWriter printWriter) {
        printWriter.print("</selector>");
    }

    public interface OnCreateEvent {
        void onCreate(ColorSelector environment);
    }
}
