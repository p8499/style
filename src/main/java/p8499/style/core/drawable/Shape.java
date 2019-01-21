package p8499.style.core.drawable;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;
import p8499.style.core.ARGB;
import p8499.style.core.Dimension;
import p8499.style.core.Drawable;

import javax.xml.transform.sax.TransformerHandler;

/**
 * Created by Administrator on 3/13/2018.
 */
public class Shape implements Drawable.Root {
    private String mShape;
    private ARGB mBackgroundColor;
    private ARGB mBorderColor;
    private String mRadiusTopLeft;
    private String mRadiusTopRight;
    private String mRadiusBottomLeft;
    private String mRadiusBottomRight;
    private String mBorderWidth;
    private String mPaddingTop;
    private String mPaddingBottom;
    private String mPaddingLeft;
    private String mPaddingRight;

    private Shape(String shape) {
        mShape = shape;
        mBackgroundColor = new ARGB();
        mBorderColor = new ARGB();
        mRadiusTopLeft = Dimension.DP_00;
        mRadiusTopRight = Dimension.DP_00;
        mRadiusBottomLeft = Dimension.DP_00;
        mRadiusBottomRight = Dimension.DP_00;
        mBorderWidth = Dimension.DP_00;
        mPaddingTop = Dimension.DP_00;
        mPaddingBottom = Dimension.DP_00;
        mPaddingLeft = Dimension.DP_00;
        mPaddingRight = Dimension.DP_00;
    }

    public static Shape rectangle() {
        return new Shape("rectangle");
    }

    public String getShape() {
        return mShape;
    }

    public ARGB getBackgroundColor() {
        return mBackgroundColor;
    }

    public ARGB getBorderColor() {
        return mBorderColor;
    }

    public String getRadiusTopLeft() {
        return mRadiusTopLeft;
    }

    public String getRadiusTopRight() {
        return mRadiusTopRight;
    }

    public String getRadiusBottomLeft() {
        return mRadiusBottomLeft;
    }

    public String getRadiusBottomRight() {
        return mRadiusBottomRight;
    }

    public String getBorderWidth() {
        return mBorderWidth;
    }

    public String getPaddingTop() {
        return mPaddingTop;
    }

    public String getPaddingBottom() {
        return mPaddingBottom;
    }

    public String getPaddingLeft() {
        return mPaddingLeft;
    }

    public String getPaddingRight() {
        return mPaddingRight;
    }

    public Shape setShape(String shape) {
        mShape = shape;
        return this;
    }

    public Shape setBackgroundColor(ARGB backgroundColor) {
        mBackgroundColor = backgroundColor;
        return this;
    }

    public Shape setBorderColor(ARGB borderColor) {
        mBorderColor = borderColor;
        return this;
    }

    public Shape setRadius(String radius) {
        mRadiusTopLeft = mRadiusTopRight = mRadiusBottomLeft = mRadiusBottomRight = radius;
        return this;
    }

    public Shape setRadiusLeft(String radiusLeft) {
        mRadiusTopLeft = mRadiusBottomLeft = radiusLeft;
        return this;
    }

    public Shape setRadiusRight(String radiusRight) {
        mRadiusTopRight = mRadiusBottomRight = radiusRight;
        return this;
    }

    public Shape setRadiusTop(String radiusTop) {
        mRadiusTopLeft = mRadiusTopRight = radiusTop;
        return this;
    }

    public Shape setRadiusBottom(String radiusBottom) {
        mRadiusBottomLeft = mRadiusBottomRight = radiusBottom;
        return this;
    }

    public Shape setRadiusTopLeft(String radiusTopLeft) {
        mRadiusTopLeft = radiusTopLeft;
        return this;
    }

    public Shape setRadiusTopRight(String radiusTopRight) {
        mRadiusTopRight = radiusTopRight;
        return this;
    }

    public Shape setRadiusBottomLeft(String radiusBottomLeft) {
        mRadiusBottomLeft = radiusBottomLeft;
        return this;
    }

    public Shape setRadiusBottomRight(String radiusBottomRight) {
        mRadiusBottomRight = radiusBottomRight;
        return this;
    }

    public Shape setBorderWidth(String borderWidth) {
        mBorderWidth = borderWidth;
        return this;
    }

    public Shape setPaddingTop(String paddingTop) {
        this.mPaddingTop = paddingTop;
        return this;
    }

    public Shape setPaddingBottom(String paddingBottom) {
        this.mPaddingBottom = paddingBottom;
        return this;
    }

    public Shape setPaddingLeft(String paddingLeft) {
        this.mPaddingLeft = paddingLeft;
        return this;
    }

    public Shape setPaddingRight(String paddingRight) {
        this.mPaddingRight = paddingRight;
        return this;
    }

    public Shape setPadding(String padding) {
        this.mPaddingTop = this.mPaddingBottom = this.mPaddingLeft = this.mPaddingRight = padding;
        return this;
    }

    @Override
    public void output(TransformerHandler handler) throws SAXException {
        AttributesImpl attrsShape = new AttributesImpl();
        attrsShape.addAttribute("", "", "android:shape", "", mShape);
        handler.startElement("", "", "shape", attrsShape);

        AttributesImpl attrsSolid = new AttributesImpl();
        attrsSolid.addAttribute("", "", "android:color", "", mBackgroundColor.toString());
        handler.startElement("", "", "solid", attrsSolid);
        handler.endElement("", "", "solid");

        AttributesImpl attrsPadding = new AttributesImpl();
        attrsPadding.addAttribute("", "", "android:top", "", mPaddingTop);
        attrsPadding.addAttribute("", "", "android:left", "", mPaddingLeft);
        attrsPadding.addAttribute("", "", "android:right", "", mPaddingRight);
        attrsPadding.addAttribute("", "", "android:bottom", "", mPaddingBottom);
        handler.startElement("", "", "padding", attrsPadding);
        handler.endElement("", "", "padding");

        AttributesImpl attrsCorners = new AttributesImpl();
        attrsCorners.addAttribute("", "", "android:topLeftRadius", "", mRadiusTopLeft);
        attrsCorners.addAttribute("", "", "android:topRightRadius", "", mRadiusTopRight);
        attrsCorners.addAttribute("", "", "android:bottomLeftRadius", "", mRadiusBottomLeft);
        attrsCorners.addAttribute("", "", "android:bottomRightRadius", "", mRadiusBottomRight);
        handler.startElement("", "", "corners", attrsCorners);
        handler.endElement("", "", "corners");

        AttributesImpl attrsStroke = new AttributesImpl();
        attrsStroke.addAttribute("", "", "android:width", "", mBorderWidth);
        attrsStroke.addAttribute("", "", "android:color", "", mBorderColor.toString());
        handler.startElement("", "", "stroke", attrsStroke);
        handler.endElement("", "", "stroke");

        handler.endElement("", "", "shape");
    }
}
