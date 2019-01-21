package p8499.style.core;

import p8499.style.core.drawable.LayerList;
import p8499.style.core.drawable.Shape;

import java.io.IOException;

/**
 * Created by Administrator on 3/2/2018.
 */
public class ImeMain {
    public static void main(String[] args) throws IOException {
        System.out.println(Environment.create("ime", environment -> environment
                .addStyle("keyboard", style -> style
                        .addItem(Style.ANDROID_BACKGROUND, new ARGB(0xd9, 0xd9, 0xd9).toString())
                        .addItem(Style.ANDROID_KEYBACKGROUND, "kbg", (DrawableSelector drawableSelector) -> drawableSelector
                                //checked pressed: background lighter 0.2
                                .addRoute(Condition.from(Condition.STATE_CHECKABLE).and(Condition.STATE_CHECKED).and(Condition.STATE_PRESSED), drawable -> drawable
                                        .set(LayerList
                                                .only(Dimension.DP_01, Dimension.DP_01, Dimension.DP_01, Dimension.DP_01, Shape.rectangle().setRadius(Dimension.DP_04).setBackgroundColor(new ARGB(0xb1, 0xb1, 0xb1)))
                                                .put(Dimension.DP_01H, Dimension.DP_02, Dimension.DP_01H, Dimension.DP_01H, Shape.rectangle().setRadius(Dimension.DP_04).setBackgroundColor(new ARGB(0xcc, 0xcc, 0xcc)))))
                                //checked: background lighter 0.1, border
                                .addRoute(Condition.from(Condition.STATE_CHECKABLE).and(Condition.STATE_CHECKED).and(Condition.STATE_PRESSED, false), drawable -> drawable
                                        .set(LayerList
                                                .only(Dimension.DP_01, Dimension.DP_01, Dimension.DP_01, Dimension.DP_01, Shape.rectangle().setRadius(Dimension.DP_04).setBackgroundColor(new ARGB(0xb1, 0xb1, 0xb1)))
                                                .put(Dimension.DP_01H, Dimension.DP_02, Dimension.DP_01H, Dimension.DP_01H, Shape.rectangle().setRadius(Dimension.DP_04).setBackgroundColor(new ARGB(0xeb, 0xeb, 0xeb)))))
                                //checkable pressed: background lighter 0.2, border
                                .addRoute(Condition.from(Condition.STATE_CHECKABLE).and(Condition.STATE_CHECKED, false).and(Condition.STATE_PRESSED), drawable -> drawable
                                        .set(LayerList
                                                .only(Dimension.DP_01, Dimension.DP_01, Dimension.DP_01, Dimension.DP_01, Shape.rectangle().setRadius(Dimension.DP_04).setBackgroundColor(new ARGB(0xb1, 0xb1, 0xb1)))
                                                .put(Dimension.DP_01H, Dimension.DP_02, Dimension.DP_01H, Dimension.DP_01H, Shape.rectangle().setRadius(Dimension.DP_04).setBackgroundColor(new ARGB(0xcc, 0xcc, 0xcc)))))
                                //checkable
                                .addRoute(Condition.from(Condition.STATE_CHECKABLE).and(Condition.STATE_CHECKED, false).and(Condition.STATE_PRESSED, false), drawable -> drawable
                                        .set(LayerList
                                                .only(Dimension.DP_01, Dimension.DP_01, Dimension.DP_01, Dimension.DP_01, Shape.rectangle().setRadius(Dimension.DP_04).setBackgroundColor(new ARGB(0xb1, 0xb1, 0xb1)))
                                                .put(Dimension.DP_01H, Dimension.DP_02, Dimension.DP_01H, Dimension.DP_01H, Shape.rectangle().setRadius(Dimension.DP_04).setBackgroundColor(ARGB.WHITE))))
                                //normal pressed: background lighter 0.2
                                .addRoute(Condition.from(Condition.STATE_CHECKABLE, false).and(Condition.STATE_PRESSED), drawable -> drawable
                                        .set(LayerList
                                                .only(Dimension.DP_01, Dimension.DP_01, Dimension.DP_01, Dimension.DP_01, Shape.rectangle().setRadius(Dimension.DP_04).setBackgroundColor(new ARGB(0xb1, 0xb1, 0xb1)))
                                                .put(Dimension.DP_01H, Dimension.DP_02, Dimension.DP_01H, Dimension.DP_01H, Shape.rectangle().setRadius(Dimension.DP_04).setBackgroundColor(new ARGB(0xcc, 0xcc, 0xcc)))))
                                //normal
                                .addRoute(Condition.from(Condition.STATE_CHECKABLE, false).and(Condition.STATE_PRESSED, false), drawable -> drawable
                                        .set(LayerList
                                                .only(Dimension.DP_01, Dimension.DP_01, Dimension.DP_01, Dimension.DP_01, Shape.rectangle().setRadius(Dimension.DP_04).setBackgroundColor(new ARGB(0xb1, 0xb1, 0xb1)))
                                                .put(Dimension.DP_01H, Dimension.DP_02, Dimension.DP_01H, Dimension.DP_01H, Shape.rectangle().setRadius(Dimension.DP_04).setBackgroundColor(ARGB.WHITE)))))
                        .addItem(Style.ANDROID_KEYPREVIEWLAYOUT, (String) null)
                        .addItem(Style.ANDROID_KEYTEXTCOLOR, ARGB.BLACK.toString())
                        .addItem(Style.ANDROID_KEYTEXTSIZE, Dimension.TEXTSIZE_G)
                        .addItem(Style.ANDROID_SHADOWRADIUS, "0"))
                .addStyle("menu", style -> style
                        .addItem(Style.ANDROID_BACKGROUND, "bg", (DrawableSelector drawableSelector) -> drawableSelector
                                .addRoute(Condition.empty(), drawable -> drawable
                                        .set(LayerList
                                                .only(Dimension.DP_00, Dimension.DP_00, Dimension.DP_00, Dimension.DP_00, Shape.rectangle().setBackgroundColor(new ARGB(0xae, 0xae, 0xae)))
                                                .put(Dimension.DP_01, Dimension.DP_01, Dimension.DP_00, Dimension.DP_00, Shape.rectangle().setBackgroundColor(new ARGB(0xf5, 0xf5, 0xf5)))))))
                .addStyle("menuitem", style -> style
                        .addItem(Style.ANDROID_BACKGROUND, "bg", (DrawableSelector drawableSelector) -> drawableSelector
                                .addRoute(Condition.from(Condition.STATE_PRESSED), drawable -> drawable
                                        .set(Shape.rectangle().setRadius(Dimension.DP_04).setBackgroundColor(new ARGB(0xe8, 0xe8, 0xe8)).setBorderColor(new ARGB(0xca, 0xca, 0xca))))
                                .addRoute(Condition.empty(), drawable -> drawable
                                        .set(Shape.rectangle().setRadius(Dimension.DP_04))))
                        .addItem(Style.ANDROID_CLICKABLE, "true")
                        .addItem(Style.ANDROID_SCALETYPE, "fitXY"))
                .addStyle("popupitemsingle", style -> style
                        .addItem(Style.ANDROID_BACKGROUND, "bg", (DrawableSelector drawableSelector) -> drawableSelector
                                .addRoute(Condition.from(Condition.STATE_SELECTED), drawable -> drawable
                                        .set(Shape.rectangle().setRadius(Dimension.DP_04).setBackgroundColor(new ARGB(0x0, 0x99, 0xe5))))
                                .addRoute(Condition.empty(), drawable -> drawable
                                        .set(Shape.rectangle().setRadius(Dimension.DP_04).setBackgroundColor(new ARGB(0xd9, 0xdb, 0xdd)))))
                        .addItem(Style.ANDROID_TEXTCOLOR, "tc", (ColorSelector colorSelector) -> colorSelector
                                .addRoute(Condition.from(Condition.STATE_SELECTED), ARGB.WHITE)
                                .addRoute(Condition.empty(), new ARGB(0x66, 0x66, 0x66)))
                        .addItem(Style.ANDROID_GRAVITY, "left|center_vertical")
                        .addItem(Style.ANDROID_TEXTSIZE, Dimension.TEXTSIZE_G)
                        .addItem(Style.ANDROID_TYPEFACE, "monospace"))
                .addStyle("popupitemfirst", style -> style
                        .addItem(Style.ANDROID_BACKGROUND, "bg", (DrawableSelector drawableSelector) -> drawableSelector
                                .addRoute(Condition.from(Condition.STATE_SELECTED), drawable -> drawable
                                        .set(Shape.rectangle().setRadiusTop(Dimension.DP_04).setBackgroundColor(new ARGB(0x0, 0x99, 0xe5))))
                                .addRoute(Condition.empty(), drawable -> drawable
                                        .set(Shape.rectangle().setRadiusTop(Dimension.DP_04).setBackgroundColor(new ARGB(0xd9, 0xdb, 0xdd)))))
                        .addItem(Style.ANDROID_TEXTCOLOR, "tc", (ColorSelector colorSelector) -> colorSelector
                                .addRoute(Condition.from(Condition.STATE_SELECTED), ARGB.WHITE)
                                .addRoute(Condition.empty(), new ARGB(0x66, 0x66, 0x66)))
                        .addItem(Style.ANDROID_GRAVITY, "left|center_vertical")
                        .addItem(Style.ANDROID_TEXTSIZE, Dimension.TEXTSIZE_G)
                        .addItem(Style.ANDROID_TYPEFACE, "monospace"))
                .addStyle("popupitemmiddle", style -> style
                        .addItem(Style.ANDROID_BACKGROUND, "bg", (DrawableSelector drawableSelector) -> drawableSelector
                                .addRoute(Condition.from(Condition.STATE_SELECTED), drawable -> drawable
                                        .set(Shape.rectangle().setBackgroundColor(new ARGB(0x0, 0x99, 0xe5))))
                                .addRoute(Condition.empty(), drawable -> drawable
                                        .set(Shape.rectangle().setBackgroundColor(new ARGB(0xd9, 0xdb, 0xdd)))))
                        .addItem(Style.ANDROID_TEXTCOLOR, "tc", (ColorSelector colorSelector) -> colorSelector
                                .addRoute(Condition.from(Condition.STATE_SELECTED), ARGB.WHITE)
                                .addRoute(Condition.empty(), new ARGB(0x66, 0x66, 0x66)))
                        .addItem(Style.ANDROID_GRAVITY, "left|center_vertical")
                        .addItem(Style.ANDROID_TEXTSIZE, Dimension.TEXTSIZE_G)
                        .addItem(Style.ANDROID_TYPEFACE, "monospace"))
                .addStyle("popupitemlast", style -> style
                        .addItem(Style.ANDROID_BACKGROUND, "bg", (DrawableSelector drawableSelector) -> drawableSelector
                                .addRoute(Condition.from(Condition.STATE_SELECTED), drawable -> drawable
                                        .set(Shape.rectangle().setRadiusBottom(Dimension.DP_04).setBackgroundColor(new ARGB(0x0, 0x99, 0xe5))))
                                .addRoute(Condition.empty(), drawable -> drawable
                                        .set(Shape.rectangle().setRadiusBottom(Dimension.DP_04).setBackgroundColor(new ARGB(0xd9, 0xdb, 0xdd)))))
                        .addItem(Style.ANDROID_TEXTCOLOR, "tc", (ColorSelector colorSelector) -> colorSelector
                                .addRoute(Condition.from(Condition.STATE_SELECTED), ARGB.WHITE)
                                .addRoute(Condition.empty(), new ARGB(0x66, 0x66, 0x66)))
                        .addItem(Style.ANDROID_GRAVITY, "left|center_vertical")
                        .addItem(Style.ANDROID_TEXTSIZE, Dimension.TEXTSIZE_G)
                        .addItem(Style.ANDROID_TYPEFACE, "monospace"))
                .addStyle("compbefore", style -> style
                        .addItem(Style.ANDROID_GRAVITY, "center")
                        .addItem(Style.ANDROID_TEXTCOLOR, new ARGB(0x00, 0x99, 0xe5).toString())
                        .addItem(Style.ANDROID_TEXTSIZE, Dimension.TEXTSIZE_G)
                        .addItem(Style.ANDROID_TYPEFACE, "monospace"))
                .addStyle("compsel", style -> style
                        .addItem(Style.ANDROID_GRAVITY, "center")
                        .addItem(Style.ANDROID_TEXTCOLOR, ARGB.BLACK.toString())
                        .addItem(Style.ANDROID_TEXTSIZE, Dimension.TEXTSIZE_G)
                        .addItem(Style.ANDROID_TYPEFACE, "monospace"))
                .addStyle("compafter", style -> style
                        .addItem(Style.ANDROID_GRAVITY, "center")
                        .addItem(Style.ANDROID_TEXTCOLOR, new ARGB(0x98, 0x98, 0x98).toString())
                        .addItem(Style.ANDROID_TEXTSIZE, Dimension.TEXTSIZE_G)
                        .addItem(Style.ANDROID_TYPEFACE, "monospace"))
                .addStyle("cand", style -> style
                        .addItem(Style.ANDROID_BACKGROUND, "bg", (DrawableSelector drawableSelector) -> drawableSelector
                                .addRoute(Condition.from(Condition.STATE_PRESSED), drawable -> drawable.set(Shape.rectangle().setBackgroundColor(new ARGB(0xdd, 0xdd, 0xdd))))
                                .addRoute(Condition.empty(), drawable -> drawable.set(Shape.rectangle())))
                        .addItem(Style.ANDROID_CLICKABLE, "true"))
                .addStyle("candindex", style -> style
                        .addItem(Style.ANDROID_GRAVITY, "center_vertical|right")
                        .addItem(Style.ANDROID_TEXTCOLOR, new ARGB(0x98, 0x98, 0x98).toString())
                        .addItem(Style.ANDROID_TEXTSIZE, Dimension.TEXTSIZE_J)
                        .addItem(Style.ANDROID_TYPEFACE, "monospace"))
                .addStyle("candtext", style -> style
                        .addItem(Style.ANDROID_GRAVITY, "center")
                        .addItem(Style.ANDROID_TEXTCOLOR, "tc", (ColorSelector colorSelector) -> colorSelector
                                .addRoute(Condition.from(Condition.STATE_ACTIVATED), new ARGB(0x00, 0x99, 0xe5))
                                .addRoute(Condition.empty(), ARGB.BLACK))
                        .addItem(Style.ANDROID_TEXTSIZE, Dimension.TEXTSIZE_E)
                        .addItem(Style.ANDROID_TYPEFACE, "monospace"))
                .addStyle("opt", style -> style
                        .addItem(Style.ANDROID_CLICKABLE, "true")
                        .addItem(Style.ANDROID_BACKGROUND, "bg", (DrawableSelector drawableSelector) -> drawableSelector
                                .addRoute(Condition.from(Condition.STATE_PRESSED), drawable -> drawable.set(Shape.rectangle().setBackgroundColor(new ARGB(0xf2, 0xf2, 0xf2))))
                                .addRoute(Condition.empty(), drawable -> drawable.set(Shape.rectangle().setBackgroundColor(ARGB.WHITE)))))
                .addStyle("optlabel", style -> style
                        .addItem(Style.ANDROID_TEXTCOLOR, new ARGB(0x33, 0x33, 0x33).toString())
                        .addItem(Style.ANDROID_TEXTSIZE, Dimension.TEXTSIZE_G))
                .addStyle("optval", style -> style
                        .addItem(Style.ANDROID_TEXTCOLOR, new ARGB(0x66, 0x66, 0x66).toString())
                        .addItem(Style.ANDROID_TEXTSIZE, Dimension.TEXTSIZE_G))
        ).print());
    }

    private static void test() {
//        RectangleWriter btn1_drawable = new RectangleWriter()
//                .setBackgroundColor(ARGB.BLUE_100)
//                .setBorderColor(ARGB.BLUE_900)
//                .setBorderWidth(Dimension.DP_01)
//                .setRadiusTopLeft(Dimension.DP_04)
//                .setRadiusTopRight(Dimension.DP_04)
//                .setRadiusBottomLeft(Dimension.DP_04)
//                .setRadiusBottomRight(Dimension.DP_04);
//        System.out.println(Environment.create("ime", environment -> environment
//                .addStyle("btn1", style -> style
//                        .addItem(Style.ANDROID_TEXTSIZE, Dimension.TEXTSIZE_F)
//                        .addItem(Style.ANDROID_TEXTCOLOR, "tc", (ColorSelector colorSelector) -> colorSelector
//                                .addRoute(Condition.from(Condition.STATE_ENABLED), ARGB.GREY_900)
//                                .addRoute(Condition.empty(), ARGB.GREY_900.clone().lighter(0.2f)))
//                        .addItem(Style.ANDROID_BACKGROUND, "bg", (DrawableSelector drawableSelector) -> drawableSelector
//                                .addRoute(Condition.from(Condition.STATE_ENABLED).and(Condition.STATE_PRESSED), drawable -> drawable.setWriter(btn1_drawable.clone().setBackgroundColor(btn1_drawable.getBackgroundColor().darker(0.1f))))
//                                .addRoute(Condition.from(Condition.STATE_ENABLED).and(Condition.STATE_PRESSED, false), drawable -> drawable.setWriter(btn1_drawable))
//                                .addRoute(Condition.empty(), drawable -> drawable.setWriter(btn1_drawable.setBackgroundColor(btn1_drawable.clone().getBackgroundColor().lighter(0.1f))))))).print());
    }
}
