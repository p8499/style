package p8499.style.core.drawable;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;
import p8499.style.core.Dimension;
import p8499.style.core.Drawable;

import javax.xml.transform.sax.TransformerHandler;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 3/13/2018.
 */
public class LayerList implements Drawable.Root {
    private List<Item> mItemList;

    private LayerList() {
        mItemList = new ArrayList<>();
    }

    public static LayerList only(String top, String bottom, String left, String right, Shape shape) {
        return new LayerList().put(top, bottom, left, right, shape);
    }

    public static LayerList only(String padding, Shape shape) {
        return only(padding, padding, padding, padding, shape);
    }

    public static LayerList only(Shape shape) {
        return only(Dimension.DP_00, shape);
    }

    public LayerList put(String top, String bottom, String left, String right, Shape shape) {
        mItemList.add(new Item(top, bottom, left, right, shape));
        return this;
    }

    public LayerList put(Shape shape) {
        mItemList.add(new Item(Dimension.DP_00, Dimension.DP_00, Dimension.DP_00, Dimension.DP_00, shape));
        return this;
    }

    @Override
    public void output(TransformerHandler handler) throws SAXException {
        handler.startElement("", "", "layer-list", null);
        for (Item item : mItemList)
            item.output(handler);
        handler.endElement("", "", "layer-list");
    }

    static class Item {
        private String mTop;
        private String mBottom;
        private String mLeft;
        private String mRight;
        private Shape mShape;

        public Item(String top, String bottom, String left, String right, Shape shape) {
            mTop = top;
            mBottom = bottom;
            mLeft = left;
            mRight = right;
            mShape = shape;
        }

        public String getTop() {
            return mTop;
        }

        public String getBottom() {
            return mBottom;
        }

        public String getLeft() {
            return mLeft;
        }

        public String getRight() {
            return mRight;
        }

        public Shape getShape() {
            return mShape;
        }

        public Item setTop(String top) {
            mTop = top;
            return this;
        }

        public Item setBottom(String bottom) {
            mBottom = bottom;
            return this;
        }

        public Item setLeft(String left) {
            mLeft = left;
            return this;
        }

        public Item setRight(String right) {
            mRight = right;
            return this;
        }

        public Item setShape(Shape shape) {
            mShape = shape;
            return this;
        }

        void output(TransformerHandler handler) throws SAXException {
            AttributesImpl attrsItem = new AttributesImpl();
            attrsItem.addAttribute("", "", "android:top", "", mTop);
            attrsItem.addAttribute("", "", "android:bottom", "", mBottom);
            attrsItem.addAttribute("", "", "android:left", "", mLeft);
            attrsItem.addAttribute("", "", "android:right", "", mRight);
            handler.startElement("", "", "item", attrsItem);
            mShape.output(handler);
            handler.endElement("", "", "item");
        }
    }
}
