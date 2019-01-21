package p8499.style.core;

import org.xml.sax.SAXException;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

/**
 * Created by Administrator on 3/3/2018.
 */
public class Drawable {
    private DrawableSelector mDrawableSelector;
    private Integer mIndex;
    private File mDrawableFile;
    private Root mRoot;

    public Drawable(DrawableSelector drawableSelector, int index) {
        mDrawableSelector = drawableSelector;
        mIndex = index;
        mDrawableFile = new File(drawableSelector.getStyle().getEnvironment().getTempFolder(), "drawable" + File.separator + drawableSelector.getStyle().getStyleName() + "_" + drawableSelector.getDrawableSelectorName() + "_" + index + ".xml");
    }

    public Drawable(DrawableSelector drawableSelector, int index, OnCreateEvent onCreateEvent) {
        this(drawableSelector, index);
        onCreateEvent.onCreate(this);
    }

    public Drawable set(Root root) {
        mRoot = root;
        return this;
    }

    public File print() {
        try {
            mDrawableFile.getParentFile().mkdirs();
            mDrawableFile.createNewFile();
            SAXTransformerFactory tff = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
            TransformerHandler handler = tff.newTransformerHandler();
            Transformer tr = handler.getTransformer();
            tr.setOutputProperty(OutputKeys.ENCODING, "utf-8");
            tr.setOutputProperty(OutputKeys.INDENT, "yes");
            tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            Result result = new StreamResult(new FileOutputStream(mDrawableFile));
            handler.setResult(result);
            handler.startDocument();
            handler.startPrefixMapping("android", "http://schemas.android.com/apk/res/android");
            mRoot.output(handler);
            handler.endDocument();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mDrawableFile;
    }

    @Override
    public String toString() {
        return String.format("@drawable/%s_%s_%d", mDrawableSelector.getStyle().getStyleName(), mDrawableSelector.getDrawableSelectorName(), mIndex);
    }

    public interface Root {
        void output(TransformerHandler handler) throws SAXException;
    }

    public interface OnCreateEvent {
        void onCreate(Drawable environment);
    }
}