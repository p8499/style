package p8499.style.core;

import org.xml.sax.SAXException;

import javax.xml.transform.sax.TransformerHandler;
import java.io.File;

/**
 * Created by Administrator on 3/3/2018.
 */
public class VectorDrawable extends Drawable {
    private String mText;

    public VectorDrawable(DrawableSelector drawableSelector, int index, String text) {
        super(drawableSelector, index);
        mText = text;
    }

    @Override
    public File print() {
        return null;
    }

    @Override
    public String toString() {
        return mText == null ? "@null" : mText;
    }

    public interface Root {
        void output(TransformerHandler handler) throws SAXException;
    }

    public interface OnCreateEvent {
        void onCreate(VectorDrawable environment);
    }
}