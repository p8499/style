package p8499.style.core;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 3/2/2018.
 */
public class Environment {
    private String mEnvironmentName;
    private File mTempFolder;
    private List<Style> mStyleList;

    public Environment(String environmentName) {
        mEnvironmentName = environmentName;
        mTempFolder = new File(System.getProperty("java.io.tmpdir"), environmentName);
        mStyleList = new ArrayList<>();
    }

    public Environment(String environmentName, OnCreateEvent onCreateEvent) {
        this(environmentName);
        onCreateEvent.onCreate(this);
    }

    public File getTempFolder() {
        return mTempFolder;
    }

    public Style createStyle(String styleName) {
        return new Style(this, styleName);
    }

    public Style createStyle(String styleName, Style.OnCreateEvent onCreateEvent) {
        return new Style(this, styleName, onCreateEvent);
    }

    public Environment addStyle(Style style) {
        mStyleList.add(style);
        return this;
    }

    public Environment addStyle(String styleName) {
        mStyleList.add(createStyle(styleName));
        return this;
    }

    public Environment addStyle(String styleName, Style.OnCreateEvent onCreateEvent) {
        mStyleList.add(createStyle(styleName, onCreateEvent));
        return this;
    }

    public Environment plusAssign(Style style) {
        addStyle(style);
        return this;
    }

    public Style get(String styleName) {
        for (Style style : mStyleList)
            if (style.getStyleName().equals(styleName))
                return style;
        return null;
    }

    public static Environment create(String environmentName) {
        return new Environment(environmentName);
    }

    public static Environment create(String environmentName, OnCreateEvent onCreateEvent) {
        return new Environment(environmentName, onCreateEvent);
    }

    public File print() {
        mTempFolder.delete();
        for (Style style : mStyleList)
            style.print();
        return mTempFolder;
    }

    public interface OnCreateEvent {
        void onCreate(Environment environment);
    }
}
