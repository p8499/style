package p8499.style.core;

import p8499.style.core.drawable.LayerList;
import p8499.style.core.drawable.Shape;

/**
 * Created by jdeuser on 2018/7/21.
 */
public class FormMain {
    /**
     * group
     * <p>
     * level_1
     * level_2
     * <p>
     * row
     * splitter
     * spacer
     * <p>
     * title
     * comment
     * label
     * <p>
     * input
     * <p>
     * value
     * <p>
     * switch
     * <p>
     * message
     * warning
     * error
     */
    public static void main(String[] args) {
        sales();
    }

    private static void sales() {
        Environment sales = Environment.create("sales");
        //通用
        bar(sales);//适用于会被scroll隐藏的头上部分
        search(sales);//often consists bar
        indicatorBar(sales);//often consists bar
        popupSelection(sales);//indicator bar的弹出组件
        options(sales);//显示当前搜索条件的一种组件
        lce(sales);//适用于Loading, Content, Error模式
        action(sales);//适用于bottom bar
        form(sales);//适用于普通行显示的界面
        bottomSelection(sales);
        employee(sales);

        System.out.print(sales.print());
    }

    private static void bar(Environment environment) {
        environment.addStyle("bar", style -> style
                .addItem(Style.ANDROID_LAYOUT_WIDTH, "match_parent")
                .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
                .addItem(Style.ANDROID_ORIENTATION, "vertical"));
    }

    private static void search(Environment environment) {
        environment.addStyle("search", style -> style
                .addItem(Style.ANDROID_LAYOUT_WIDTH, "match_parent")
                .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
                .addItem(Style.ICONIFIEDBYDEFAULT, "false")
                .addItem(Style.SEARCHICON, "@null")
                .addItem(Style.ANDROID_BACKGROUND, ARGB.GREY_100.toString())
                .addItem(Style.QUERYBACKGROUND, "qb", (DrawableSelector drawableSelector) -> drawableSelector
                        .addRoute(Condition.empty(), drawable -> drawable
                                .set(LayerList.only(Dimension.DP_08, Dimension.DP_08, Dimension.DP_00, Dimension.DP_00, Shape.rectangle().setRadius(Dimension.DP_08).setBackgroundColor(ARGB.WHITE).setBorderWidth(Dimension.DP_01).setBorderColor(ARGB.GREY_200))))));
    }

    private static void indicatorBar(Environment environment) {
        environment.addStyle("indicator_bar", style -> style
                .addItem(Style.ANDROID_LAYOUT_WIDTH, "match_parent")
                .addItem(Style.ANDROID_LAYOUT_HEIGHT, "32dp")
                .addItem(Style.ANDROID_BASELINEALIGNED, "false")
                .addItem(Style.ANDROID_ORIENTATION, "horizontal")
                .addItem(Style.ANDROID_BACKGROUND, ARGB.GREY_100.toString()));
        environment.addStyle("indicator_bar_region", style -> style
                .addItem(Style.ANDROID_LAYOUT_WIDTH, Dimension.DP_00)
                .addItem(Style.ANDROID_LAYOUT_HEIGHT, "match_parent")
                .addItem(Style.ANDROID_LAYOUT_WEIGHT, "1")
                .addItem(Style.ANDROID_LAYOUT_GRAVITY, "center_vertical")
                .addItem(Style.ANDROID_PADDINGSTART, Dimension.DP_16)
                .addItem(Style.ANDROID_PADDINGEND, Dimension.DP_16));
        environment.addStyle("indicator_bar_region_text", style -> style
                .addItem(Style.ANDROID_LAYOUT_WIDTH, "wrap_content")
                .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
                .addItem(Style.ANDROID_LAYOUT_GRAVITY, "start|center_vertical")
                .addItem(Style.ANDROID_TEXTCOLOR, "tc", (ColorSelector colorSelector) -> colorSelector
                        .addRoute(Condition.from(Condition.STATE_ACTIVATED), ARGB.BLUE_400)
                        .addRoute(Condition.empty(), ARGB.BLACK)));
        environment.addStyle("indicator_bar_region_icon", style -> style
                .addItem(Style.ANDROID_LAYOUT_WIDTH, "24dp")
                .addItem(Style.ANDROID_LAYOUT_HEIGHT, "24dp")
                .addItem(Style.ANDROID_LAYOUT_GRAVITY, "end|center_vertical")
                .addItem(Style.ANDROID_SCALETYPE, "centerCrop")
                .addItem(Style.ANDROID_SRC, "sc", (DrawableSelector drawableSelector) -> drawableSelector
                        .addRoute(Condition.from(Condition.STATE_SELECTED), "@drawable/ic_drop_down_black_24dp")
                        .addRoute(Condition.empty(), "@drawable/ic_drop_down_grey_24dp")));
    }

    private static void popupSelection(Environment environment) {
        environment.addStyle("popup_selection", style -> style
                .addItem(Style.ANDROID_LAYOUT_WIDTH, "match_parent")
                .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
                .addItem(Style.ANDROID_ORIENTATION, "vertical")
                .addItem(Style.ANDROID_BACKGROUND, "bg", (DrawableSelector drawableSelector) -> drawableSelector
                        .addRoute(Condition.empty(), drawable -> drawable
                                .set(Shape.rectangle().setRadiusBottom(Dimension.DP_04).setBackgroundColor(ARGB.GREY_100).setBorderWidth(Dimension.DP_01).setBorderColor(ARGB.GREY_200)))));
        environment.addStyle("popup_selection_recycler", style -> style
                .addItem(Style.ANDROID_LAYOUT_WIDTH, "match_parent")
                .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
                .addItem(Style.ANDROID_OVERSCROLLMODE, "never"));
        environment.addStyle("popup_selection_ok", style -> style
                .addItem(Style.ANDROID_LAYOUT_WIDTH, "match_parent")
                .addItem(Style.ANDROID_LAYOUT_HEIGHT, "32dp")
                .addItem(Style.ANDROID_LAYOUT_GRAVITY, "center")
                .addItem(Style.ANDROID_MARGINTOP, "8dp")
                .addItem(Style.ANDROID_MARGINBOTTOM, "8dp")
                .addItem(Style.ANDROID_MARGINSTART, "16dp")
                .addItem(Style.ANDROID_MARGINEND, "16dp")
                .addItem(Style.ANDROID_MARGINLEFT, "16dp")
                .addItem(Style.ANDROID_MARGINRIGHT, "16dp")
                .addItem(Style.ANDROID_TEXTALLCAPS, "false")
                .addItem(Style.ANDROID_TEXTSIZE, Dimension.TEXTSIZE_H)
                .addItem(Style.ANDROID_TEXTCOLOR, "tc", (ColorSelector colorSelector) -> colorSelector
                        .addRoute(Condition.from(Condition.STATE_PRESSED), ARGB.BLUE_400)
                        .addRoute(Condition.empty(), ARGB.WHITE))
                .addItem(Style.ANDROID_BACKGROUND, "bg", (DrawableSelector drawableSelector) -> drawableSelector
                        .addRoute(Condition.from(Condition.STATE_PRESSED), drawable -> drawable
                                .set(Shape.rectangle().setRadius(Dimension.DP_04).setBackgroundColor(ARGB.WHITE).setBorderWidth(Dimension.DP_01).setBorderColor(ARGB.BLUE_400)))
                        .addRoute(Condition.empty(), drawable -> drawable
                                .set(Shape.rectangle().setRadius(Dimension.DP_04).setBackgroundColor(ARGB.BLUE_400)))));
        environment.addStyle("popup_selection_row", style -> style
                .addItem(Style.ANDROID_LAYOUT_WIDTH, "match_parent")
                .addItem(Style.ANDROID_LAYOUT_HEIGHT, "32dp")
                .addItem(Style.ANDROID_PADDINGSTART, "16dp")
                .addItem(Style.ANDROID_PADDINGEND, "16dp")
                .addItem(Style.ANDROID_PADDINGLEFT, "16dp")
                .addItem(Style.ANDROID_PADDINGRIGHT, "16dp")
                .addItem(Style.ANDROID_ORIENTATION, "horizontal"));
        environment.addStyle("popup_selection_row_text", style -> style
                .addItem(Style.ANDROID_LAYOUT_WIDTH, "wrap_content")
                .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
                .addItem(Style.ANDROID_LAYOUT_GRAVITY, "center_vertical")
                .addItem(Style.ANDROID_TEXTSIZE, Dimension.TEXTSIZE_H)
                .addItem(Style.ANDROID_TEXTCOLOR, "tc", (ColorSelector colorSelector) -> colorSelector
                        .addRoute(Condition.from(Condition.STATE_ACTIVATED), ARGB.BLUE_400)
                        .addRoute(Condition.empty(), ARGB.BLACK)));
        environment.addStyle("popup_selection_row_icon", style -> style
                .addItem(Style.ANDROID_LAYOUT_WIDTH, "24dp")
                .addItem(Style.ANDROID_LAYOUT_HEIGHT, "24dp")
                .addItem(Style.ANDROID_LAYOUT_GRAVITY, "center_vertical")
                .addItem(Style.ANDROID_SCALETYPE, "centerCrop")
                .addItem(Style.ANDROID_SRC, "sc", (DrawableSelector drawableSelector) -> drawableSelector
                        .addRoute(Condition.from(Condition.STATE_ACTIVATED), "@drawable/ic_check_blue_24dp")
                        .addRoute(Condition.empty(), "@android:color/transparent")));
    }

    private static void options(Environment environment) {
        environment.addStyle("options", style -> style
                .addItem(Style.ANDROID_LAYOUT_WIDTH, "match_parent")
                .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
                .addItem(Style.ANDROID_PADDINGSTART, Dimension.DP_08)
                .addItem(Style.ANDROID_PADDINGEND, Dimension.DP_08));
        environment.addStyle("options_recycler", style -> style
                .addItem(Style.ANDROID_LAYOUT_WIDTH, "match_parent")
                .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content"));
        environment.addStyle("options_row", style -> style
                .addItem(Style.ANDROID_LAYOUT_WIDTH, "wrap_content")
                .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
                .addItem(Style.ANDROID_BACKGROUND, "bg", (DrawableSelector drawableSelector) -> drawableSelector
                        .addRoute(Condition.empty(), (Drawable drawable) ->
                                drawable.set(Shape.rectangle().setRadius(Dimension.DP_08).setBackgroundColor(ARGB.GREY_200))))
                .addItem(Style.ANDROID_PADDINGSTART, Dimension.DP_08)
                .addItem(Style.ANDROID_PADDINGEND, Dimension.DP_08)
                .addItem(Style.ANDROID_PADDINGTOP, Dimension.DP_06)
                .addItem(Style.ANDROID_PADDINGBOTTOM, Dimension.DP_06)
                .addItem(Style.ANDROID_ORIENTATION, "horizontal"));
        environment.addStyle("options_row_label", style -> style
                .addItem(Style.ANDROID_LAYOUT_WIDTH, "wrap_content")
                .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
                .addItem(Style.ANDROID_LAYOUT_GRAVITY, "center_vertical"));
        environment.addStyle("options_row_icon", style -> style
                .addItem(Style.ANDROID_LAYOUT_WIDTH, Dimension.DP_16)
                .addItem(Style.ANDROID_LAYOUT_HEIGHT, Dimension.DP_16)
                .addItem(Style.ANDROID_LAYOUT_GRAVITY, "center_vertical")
                .addItem(Style.ANDROID_MARGINSTART, Dimension.DP_08)
                .addItem(Style.ANDROID_SCALETYPE, "centerCrop"));
    }

    private static void lce(Environment environment) {
        environment.addStyle("lce", style -> style
                .addItem(Style.ANDROID_LAYOUT_WIDTH, "match_parent")
                .addItem(Style.ANDROID_LAYOUT_HEIGHT, "match_parent"));
        environment.addStyle("lce_loading", style -> style
                .addItem(Style.ANDROID_LAYOUT_WIDTH, "wrap_content")
                .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
                .addItem(Style.ANDROID_LAYOUT_GRAVITY, "center"));
        environment.addStyle("lce_refresh", style -> style
                .addItem(Style.ANDROID_LAYOUT_WIDTH, "match_parent")
                .addItem(Style.ANDROID_LAYOUT_HEIGHT, "match_parent"));
        environment.addStyle("lce_content", style -> style
                .addItem(Style.ANDROID_LAYOUT_WIDTH, "match_parent")
                .addItem(Style.ANDROID_LAYOUT_HEIGHT, "match_parent"));
        environment.addStyle("lce_error", style -> style
                .addItem(Style.ANDROID_LAYOUT_WIDTH, "wrap_content")
                .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
                .addItem(Style.ANDROID_LAYOUT_GRAVITY, "center")
                .addItem(Style.ANDROID_CLICKABLE, "true")
                .addItem(Style.ANDROID_FOCUSABLE, "true")
                .addItem(Style.ANDROID_TEXTSIZE, Dimension.TEXTSIZE_F));
    }

    private static void action(Environment environment) {
        environment.addStyle("action", style -> style
                .addItem(Style.ANDROID_LAYOUT_WIDTH, "match_parent")
                .addItem(Style.ANDROID_LAYOUT_HEIGHT, "48dp")
                .addItem(Style.ANDROID_PADDINGSTART, Dimension.DP_16)
                .addItem(Style.ANDROID_PADDINGEND, Dimension.DP_16)
                .addItem(Style.ANDROID_BACKGROUND, ARGB.GREY_200.toString()));
        environment.addStyle("action_hint", style -> style
                .addItem(Style.ANDROID_LAYOUT_WIDTH, "wrap_content")
                .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
                .addItem(Style.ANDROID_LAYOUT_ALIGNPARENTSTART, "true")
                .addItem(Style.ANDROID_LAYOUT_CENTERVERTICAL, "true"));
        environment.addStyle("action_ok", style -> style
                .addItem(Style.ANDROID_LAYOUT_WIDTH, "72dp")
                .addItem(Style.ANDROID_LAYOUT_HEIGHT, "match_parent")
                .addItem(Style.ANDROID_LAYOUT_CENTERVERTICAL, "true")
                .addItem(Style.ANDROID_TEXTALLCAPS, "false")
                .addItem(Style.ANDROID_BACKGROUND, "@null")
                .addItem(Style.ANDROID_TEXTCOLOR, "tc", (ColorSelector colorSelector) -> colorSelector
                        .addRoute(Condition.from(Condition.STATE_PRESSED), ARGB.RED_800)
                        .addRoute(Condition.empty(), ARGB.RED_400)));
        environment.addStyle("action_cancel", style -> style
                .addItem(Style.ANDROID_LAYOUT_WIDTH, "72dp")
                .addItem(Style.ANDROID_LAYOUT_HEIGHT, "match_parent")
                .addItem(Style.ANDROID_LAYOUT_ALIGNPARENTEND, "true")
                .addItem(Style.ANDROID_LAYOUT_CENTERVERTICAL, "true")
                .addItem(Style.ANDROID_TEXTALLCAPS, "false")
                .addItem(Style.ANDROID_BACKGROUND, "@null")
                .addItem(Style.ANDROID_TEXTCOLOR, "tc", (ColorSelector colorSelector) -> colorSelector
                        .addRoute(Condition.from(Condition.STATE_PRESSED), ARGB.GREY_400)
                        .addRoute(Condition.empty(), ARGB.GREY_800)));
    }

    private static void bottomSelection(Environment environment) {
        environment.addStyle("bottom_selection", style -> style
                .addItem(Style.ANDROID_LAYOUT_WIDTH, "match_parent")
                .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
                .addItem(Style.ANDROID_ORIENTATION, "vertical")
                .addItem(Style.ANDROID_BACKGROUND, "bg", (DrawableSelector drawableSelector) -> drawableSelector
                        .addRoute(Condition.empty(), drawable -> drawable
                                .set(Shape.rectangle().setRadiusBottom(Dimension.DP_04).setBackgroundColor(ARGB.GREY_100).setBorderWidth(Dimension.DP_01).setBorderColor(ARGB.GREY_200)))));
        environment.addStyle("bottom_selection_recycler", style -> style
                .addItem(Style.ANDROID_LAYOUT_WIDTH, "match_parent")
                .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
                .addItem(Style.ANDROID_OVERSCROLLMODE, "never"));
        environment.addStyle("bottom_selection_ok", style -> style
                .addItem(Style.ANDROID_LAYOUT_WIDTH, "match_parent")
                .addItem(Style.ANDROID_LAYOUT_HEIGHT, "32dp")
                .addItem(Style.ANDROID_LAYOUT_GRAVITY, "center")
                .addItem(Style.ANDROID_MARGINTOP, "8dp")
                .addItem(Style.ANDROID_MARGINBOTTOM, "8dp")
                .addItem(Style.ANDROID_MARGINSTART, "16dp")
                .addItem(Style.ANDROID_MARGINEND, "16dp")
                .addItem(Style.ANDROID_MARGINLEFT, "16dp")
                .addItem(Style.ANDROID_MARGINRIGHT, "16dp")
                .addItem(Style.ANDROID_TEXTALLCAPS, "false")
                .addItem(Style.ANDROID_TEXTSIZE, Dimension.TEXTSIZE_H)
                .addItem(Style.ANDROID_TEXTCOLOR, "tc", (ColorSelector colorSelector) -> colorSelector
                        .addRoute(Condition.from(Condition.STATE_PRESSED), ARGB.BLUE_400)
                        .addRoute(Condition.empty(), ARGB.WHITE))
                .addItem(Style.ANDROID_BACKGROUND, "bg", (DrawableSelector drawableSelector) -> drawableSelector
                        .addRoute(Condition.from(Condition.STATE_PRESSED), drawable -> drawable
                                .set(Shape.rectangle().setRadius(Dimension.DP_04).setBackgroundColor(ARGB.WHITE).setBorderWidth(Dimension.DP_01).setBorderColor(ARGB.BLUE_400)))
                        .addRoute(Condition.empty(), drawable -> drawable
                                .set(Shape.rectangle().setRadius(Dimension.DP_04).setBackgroundColor(ARGB.BLUE_400)))));
        environment.addStyle("bottom_selection_row", style -> style
                .addItem(Style.ANDROID_LAYOUT_WIDTH, "match_parent")
                .addItem(Style.ANDROID_LAYOUT_HEIGHT, "32dp")
                .addItem(Style.ANDROID_PADDINGSTART, "16dp")
                .addItem(Style.ANDROID_PADDINGEND, "16dp")
                .addItem(Style.ANDROID_PADDINGLEFT, "16dp")
                .addItem(Style.ANDROID_PADDINGRIGHT, "16dp")
                .addItem(Style.ANDROID_ORIENTATION, "horizontal"));
        environment.addStyle("bottom_selection_row_text", style -> style
                .addItem(Style.ANDROID_LAYOUT_WIDTH, "wrap_content")
                .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
                .addItem(Style.ANDROID_LAYOUT_GRAVITY, "center_vertical")
                .addItem(Style.ANDROID_TEXTSIZE, Dimension.TEXTSIZE_H)
                .addItem(Style.ANDROID_TEXTCOLOR, "tc", (ColorSelector colorSelector) -> colorSelector
                        .addRoute(Condition.from(Condition.STATE_ACTIVATED), ARGB.BLUE_400)
                        .addRoute(Condition.empty(), ARGB.BLACK)));
        environment.addStyle("bottom_selection_row_icon", style -> style
                .addItem(Style.ANDROID_LAYOUT_WIDTH, "24dp")
                .addItem(Style.ANDROID_LAYOUT_HEIGHT, "24dp")
                .addItem(Style.ANDROID_LAYOUT_GRAVITY, "center_vertical")
                .addItem(Style.ANDROID_SCALETYPE, "centerCrop")
                .addItem(Style.ANDROID_SRC, "sc", (DrawableSelector drawableSelector) -> drawableSelector
                        .addRoute(Condition.from(Condition.STATE_ACTIVATED), "@drawable/ic_check_blue_24dp")
                        .addRoute(Condition.empty(), "@android:color/transparent")));
    }

    private static void employee(Environment environment) {
        environment.addStyle("employee_row", style -> style
                .addItem(Style.ANDROID_LAYOUT_WIDTH, "match_parent")
                .addItem(Style.ANDROID_LAYOUT_HEIGHT, "64dp")
                .addItem(Style.ANDROID_PADDINGSTART, Dimension.DP_16)
                .addItem(Style.ANDROID_PADDINGEND, Dimension.DP_16)
                .addItem(Style.ANDROID_PADDINGTOP, Dimension.DP_08)
                .addItem(Style.ANDROID_PADDINGBOTTOM, Dimension.DP_08)
                .addItem(Style.ANDROID_BACKGROUND, "bg", (DrawableSelector drawableSelector) -> drawableSelector
                        .addRoute(Condition.from(Condition.STATE_ACTIVATED), (Drawable drawable) ->
                                drawable.set(LayerList.only(Shape.rectangle().setRadius(Dimension.DP_08).setBackgroundColor(ARGB.WHITE).setBorderWidth(Dimension.DP_01).setBorderColor(ARGB.BLUE_400))))
                        .addRoute(Condition.empty(), (Drawable drawable) ->
                                drawable.set(LayerList.only(Shape.rectangle().setRadius(Dimension.DP_08).setBackgroundColor(ARGB.WHITE).setBorderWidth(Dimension.DP_01).setBorderColor(ARGB.GREY_200))))));
        environment.addStyle("employee_row_portrait", style -> style
                .addItem(Style.ANDROID_LAYOUT_WIDTH, "48dp")
                .addItem(Style.ANDROID_LAYOUT_HEIGHT, "48dp")
                .addItem(Style.ANDROID_LAYOUT_GRAVITY, "center_vertical")
                .addItem(Style.ANDROID_SCALETYPE, "centerCrop"));
        environment.addStyle("employee_row_content", style -> style
                .addItem(Style.ANDROID_LAYOUT_WIDTH, "match_parent")
                .addItem(Style.ANDROID_LAYOUT_HEIGHT, "48dp")
                .addItem(Style.ANDROID_LAYOUT_GRAVITY, "center_vertical")
                .addItem(Style.ANDROID_MARGINSTART, Dimension.DP_08));
        environment.addStyle("employee_row_content_emgender", style -> style
                .addItem(Style.ANDROID_LAYOUT_WIDTH, "24dp")
                .addItem(Style.ANDROID_LAYOUT_HEIGHT, "24dp")
                .addItem(Style.ANDROID_LAYOUT_GRAVITY, "center_vertical")
                .addItem(Style.ANDROID_SCALETYPE, "centerCrop"));
        environment.addStyle("employee_row_content_emid", style -> style
                .addItem(Style.ANDROID_LAYOUT_WIDTH, "wrap_content")
                .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
                .addItem(Style.ANDROID_LAYOUT_GRAVITY, "center_vertical")
                .addItem(Style.ANDROID_MARGINSTART, Dimension.DP_08)
                .addItem(Style.ANDROID_TEXTSIZE, Dimension.TEXTSIZE_H));
        environment.addStyle("employee_row_content_emname", style -> style
                .addItem(Style.ANDROID_LAYOUT_WIDTH, Dimension.DP_00)
                .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
                .addItem(Style.ANDROID_LAYOUT_WEIGHT, "1")
                .addItem(Style.ANDROID_LAYOUT_GRAVITY, "center_vertical")
                .addItem(Style.ANDROID_MARGINSTART, Dimension.DP_08)
                .addItem(Style.ANDROID_TEXTSIZE, Dimension.TEXTSIZE_H)
                .addItem(Style.ANDROID_ELLIPSIZE, "end")
                .addItem(Style.ANDROID_MAXLINES, "1"));
        environment.addStyle("employee_row_content_emamount", style -> style
                .addItem(Style.ANDROID_LAYOUT_WIDTH, "wrap_content")
                .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
                .addItem(Style.ANDROID_LAYOUT_GRAVITY, "center_vertical")
                .addItem(Style.ANDROID_MARGINSTART, Dimension.DP_08)
                .addItem(Style.ANDROID_TEXTSIZE, Dimension.TEXTSIZE_H));
    }

    private static void form(Environment environment) {
        environment.addStyle("form_group", style -> style
                .addItem(Style.ANDROID_LAYOUT_WIDTH, "match_parent")
                .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
                .addItem(Style.ANDROID_PADDINGSTART, Dimension.DP_16)
                .addItem(Style.ANDROID_PADDINGEND, Dimension.DP_16)
                .addItem(Style.ANDROID_ORIENTATION, "vertical")
                .addItem(Style.ANDROID_BACKGROUND, "bg", (DrawableSelector drawableSelector) -> drawableSelector
                        .addRoute(Condition.empty(), (Drawable drawable) ->
                                drawable.set(LayerList
                                        .only(Shape.rectangle().setBackgroundColor(ARGB.GREY_400))
                                        .put(Dimension.DP_01, Dimension.DP_01, Dimension.DP_00, Dimension.DP_00, Shape.rectangle().setBackgroundColor(ARGB.WHITE))))));
        environment.addStyle("form_group_row", style -> style
                .addItem(Style.ANDROID_LAYOUT_WIDTH, "match_parent")
                .addItem(Style.ANDROID_LAYOUT_HEIGHT, "36dp")
                .addItem(Style.ANDROID_ORIENTATION, "horizontal"));
        environment.addStyle("form_group_dividor", style -> style
                .addItem(Style.ANDROID_LAYOUT_WIDTH, "match_parent")
                .addItem(Style.ANDROID_LAYOUT_HEIGHT, Dimension.DP_01)
                .addItem(Style.ANDROID_BACKGROUND, ARGB.GREY_400.toString()));
        environment.addStyle("form_group_row_label", style -> style
                .addItem(Style.ANDROID_LAYOUT_WIDTH, "wrap_content")
                .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
                .addItem(Style.ANDROID_LAYOUT_GRAVITY, "center_vertical")
                .addItem(Style.ANDROID_TEXTSIZE, Dimension.TEXTSIZE_H)
                .addItem(Style.ANDROID_TEXTCOLOR, ARGB.BLACK.toString())
                .addItem(Style.ANDROID_MAXLINES, "1")
                .addItem(Style.ANDROID_ELLIPSIZE, "end"));
        environment.addStyle("form_group_row_switch", style -> style
                .addItem(Style.ANDROID_LAYOUT_WIDTH, "0dp")
                .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
                .addItem(Style.ANDROID_LAYOUT_WEIGHT, "1")
                .addItem(Style.ANDROID_LAYOUT_GRAVITY, "center_vertical")
                .addItem(Style.ANDROID_MARGINSTART, Dimension.DP_08)
                .addItem(Style.ANDROID_MARGINEND, "32dp")
                .addItem(Style.ANDROID_GRAVITY, "end"));
        environment.addStyle("form_group_row_edittext", style -> style
                .addItem(Style.ANDROID_LAYOUT_WIDTH, "0dp")
                .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
                .addItem(Style.ANDROID_LAYOUT_WEIGHT, "1")
                .addItem(Style.ANDROID_LAYOUT_GRAVITY, "center_vertical")
                .addItem(Style.ANDROID_MARGINSTART, Dimension.DP_08)
                .addItem(Style.ANDROID_MARGINEND, "32dp")
                .addItem(Style.ANDROID_GRAVITY, "end")
                .addItem(Style.ANDROID_BACKGROUND, "@null")
                .addItem(Style.ANDROID_TEXTSIZE, Dimension.TEXTSIZE_H)
                .addItem(Style.ANDROID_TEXTCOLOR, ARGB.BLACK.toString())
                .addItem(Style.ANDROID_INPUTTYPE, "textNoSuggestions")
                .addItem(Style.ANDROID_TEXTCOLORHINT, ARGB.GREY_400.toString()));
        environment.addStyle("form_group_row_textview", style -> style
                .addItem(Style.ANDROID_LAYOUT_WIDTH, "0dp")
                .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
                .addItem(Style.ANDROID_LAYOUT_WEIGHT, "1")
                .addItem(Style.ANDROID_LAYOUT_GRAVITY, "center_vertical")
                .addItem(Style.ANDROID_MARGINSTART, Dimension.DP_08)
                .addItem(Style.ANDROID_MARGINEND, "32dp")
                .addItem(Style.ANDROID_GRAVITY, "end")
                .addItem(Style.ANDROID_TEXTSIZE, Dimension.TEXTSIZE_H)
                .addItem(Style.ANDROID_TEXTCOLOR, ARGB.BLACK.toString())
                .addItem(Style.ANDROID_TEXTCOLORHINT, ARGB.GREY_400.toString()));
        environment.addStyle("form_group_row_indictor", style -> style
                .addItem(Style.ANDROID_LAYOUT_WIDTH, "24dp")
                .addItem(Style.ANDROID_LAYOUT_HEIGHT, "24dp")
                .addItem(Style.ANDROID_LAYOUT_GRAVITY, "center_vertical")
                .addItem(Style.ANDROID_SCALETYPE, "centerCrop")
                .addItem(Style.ANDROID_BACKGROUND, "@drawable/ic_right_arrow_grey_24dp"));
    }

    public static void display() {
        final String textSizef = Dimension.TEXTSIZE_F;
        final String textSizeg = Dimension.TEXTSIZE_G;
        final String textSizeh = Dimension.TEXTSIZE_H;
        final String textSizei = Dimension.TEXTSIZE_I;
        final String monochrome0 = new ARGB(0x00, 0x00, 0x00).toString();
        final String monochrome1 = new ARGB(0x40, 0x40, 0x40).toString();
        final String monochrome2 = new ARGB(0x80, 0x80, 0x80).toString();
        final String monochrome3 = new ARGB(0xc0, 0xc0, 0xc0).toString();
        final ARGB blue = new ARGB(0x42, 0x8b, 0xca);
        final ARGB green = new ARGB(0x3c, 0x76, 0x3d);
        final ARGB cyan = new ARGB(0x31, 0x70, 0x8f);
        final ARGB yellow = new ARGB(0x8a, 0x6d, 0x3b);
        final ARGB red = new ARGB(0xa9, 0x44, 0x42);
        final ARGB divider = new ARGB(0xa0, 0xa0, 0xa0);
        final ARGB hint = new ARGB(0xb0, 0xb0, 0xb0);
        final ARGB pressed = new ARGB(0xc0, 0xc0, 0xc0);
        final ARGB selected = new ARGB(0xd0, 0xd0, 0xd0);

        System.out.print(Environment.create("display", environment -> environment
                .addStyle("textview_f_monochrome0", style -> style
                        .addItem(Style.ANDROID_LAYOUT_WIDTH, "wrap_content")
                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
                        .addItem(Style.ANDROID_TEXTSIZE, textSizef)
                        .addItem(Style.ANDROID_TEXTCOLOR, monochrome0)
                        .addItem(Style.ANDROID_ELLIPSIZE, "end")
                        .addItem(Style.ANDROID_MAXLINES, "1"))
                .addStyle("textview_f_monochrome1", style -> style
                        .addItem(Style.ANDROID_LAYOUT_WIDTH, "wrap_content")
                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
                        .addItem(Style.ANDROID_TEXTSIZE, textSizef)
                        .addItem(Style.ANDROID_TEXTCOLOR, monochrome1)
                        .addItem(Style.ANDROID_ELLIPSIZE, "end")
                        .addItem(Style.ANDROID_MAXLINES, "1"))
                .addStyle("textview_f_monochrome2", style -> style
                        .addItem(Style.ANDROID_LAYOUT_WIDTH, "wrap_content")
                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
                        .addItem(Style.ANDROID_TEXTSIZE, textSizef)
                        .addItem(Style.ANDROID_TEXTCOLOR, monochrome2)
                        .addItem(Style.ANDROID_ELLIPSIZE, "end")
                        .addItem(Style.ANDROID_MAXLINES, "1"))
                .addStyle("textview_f_monochrome3", style -> style
                        .addItem(Style.ANDROID_LAYOUT_WIDTH, "wrap_content")
                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
                        .addItem(Style.ANDROID_TEXTSIZE, textSizef)
                        .addItem(Style.ANDROID_TEXTCOLOR, monochrome3)
                        .addItem(Style.ANDROID_ELLIPSIZE, "end")
                        .addItem(Style.ANDROID_MAXLINES, "1"))
                .addStyle("textview_f_label_blue", style -> style
                        .addItem(Style.ANDROID_LAYOUT_WIDTH, "wrap_content")
                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
                        .addItem(Style.ANDROID_PADDINGSTART, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGLEFT, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGEND, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGRIGHT, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGTOP, Dimension.DP_02)
                        .addItem(Style.ANDROID_PADDINGBOTTOM, Dimension.DP_02)
                        .addItem(Style.ANDROID_TYPEFACE, "monospace")
                        .addItem(Style.ANDROID_TEXTSIZE, textSizef)
                        .addItem(Style.ANDROID_TEXTCOLOR, ARGB.WHITE.toString())
                        .addItem(Style.ANDROID_ELLIPSIZE, "end")
                        .addItem(Style.ANDROID_MAXLINES, "1")
                        .addItem(Style.ANDROID_BACKGROUND, "bg", (DrawableSelector drawableSelector) -> drawableSelector
                                .addRoute(Condition.empty(), drawable -> drawable
                                        .set(Shape.rectangle().setRadius(Dimension.DP_04).setBackgroundColor(blue)))))
                .addStyle("textview_f_label_green", style -> style
                        .addItem(Style.ANDROID_LAYOUT_WIDTH, "wrap_content")
                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
                        .addItem(Style.ANDROID_PADDINGSTART, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGLEFT, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGEND, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGRIGHT, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGTOP, Dimension.DP_02)
                        .addItem(Style.ANDROID_PADDINGBOTTOM, Dimension.DP_02)
                        .addItem(Style.ANDROID_TYPEFACE, "monospace")
                        .addItem(Style.ANDROID_TEXTSIZE, textSizef)
                        .addItem(Style.ANDROID_TEXTCOLOR, ARGB.WHITE.toString())
                        .addItem(Style.ANDROID_ELLIPSIZE, "end")
                        .addItem(Style.ANDROID_MAXLINES, "1")
                        .addItem(Style.ANDROID_BACKGROUND, "bg", (DrawableSelector drawableSelector) -> drawableSelector
                                .addRoute(Condition.empty(), drawable -> drawable
                                        .set(Shape.rectangle().setRadius(Dimension.DP_04).setBackgroundColor(green)))))
                .addStyle("textview_f_label_cyan", style -> style
                        .addItem(Style.ANDROID_LAYOUT_WIDTH, "wrap_content")
                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
                        .addItem(Style.ANDROID_PADDINGSTART, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGLEFT, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGEND, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGRIGHT, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGTOP, Dimension.DP_02)
                        .addItem(Style.ANDROID_PADDINGBOTTOM, Dimension.DP_02)
                        .addItem(Style.ANDROID_TYPEFACE, "monospace")
                        .addItem(Style.ANDROID_TEXTSIZE, textSizef)
                        .addItem(Style.ANDROID_TEXTCOLOR, ARGB.WHITE.toString())
                        .addItem(Style.ANDROID_ELLIPSIZE, "end")
                        .addItem(Style.ANDROID_MAXLINES, "1")
                        .addItem(Style.ANDROID_BACKGROUND, "bg", (DrawableSelector drawableSelector) -> drawableSelector
                                .addRoute(Condition.empty(), drawable -> drawable
                                        .set(Shape.rectangle().setRadius(Dimension.DP_04).setBackgroundColor(cyan)))))
                .addStyle("textview_f_label_yellow", style -> style
                        .addItem(Style.ANDROID_LAYOUT_WIDTH, "wrap_content")
                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
                        .addItem(Style.ANDROID_PADDINGSTART, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGLEFT, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGEND, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGRIGHT, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGTOP, Dimension.DP_02)
                        .addItem(Style.ANDROID_PADDINGBOTTOM, Dimension.DP_02)
                        .addItem(Style.ANDROID_TYPEFACE, "monospace")
                        .addItem(Style.ANDROID_TEXTSIZE, textSizef)
                        .addItem(Style.ANDROID_TEXTCOLOR, ARGB.WHITE.toString())
                        .addItem(Style.ANDROID_ELLIPSIZE, "end")
                        .addItem(Style.ANDROID_MAXLINES, "1")
                        .addItem(Style.ANDROID_BACKGROUND, "bg", (DrawableSelector drawableSelector) -> drawableSelector
                                .addRoute(Condition.empty(), drawable -> drawable
                                        .set(Shape.rectangle().setRadius(Dimension.DP_04).setBackgroundColor(yellow)))))
                .addStyle("textview_f_label_red", style -> style
                        .addItem(Style.ANDROID_LAYOUT_WIDTH, "wrap_content")
                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
                        .addItem(Style.ANDROID_PADDINGSTART, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGLEFT, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGEND, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGRIGHT, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGTOP, Dimension.DP_02)
                        .addItem(Style.ANDROID_PADDINGBOTTOM, Dimension.DP_02)
                        .addItem(Style.ANDROID_TYPEFACE, "monospace")
                        .addItem(Style.ANDROID_TEXTSIZE, textSizef)
                        .addItem(Style.ANDROID_TEXTCOLOR, ARGB.WHITE.toString())
                        .addItem(Style.ANDROID_ELLIPSIZE, "end")
                        .addItem(Style.ANDROID_MAXLINES, "1")
                        .addItem(Style.ANDROID_BACKGROUND, "bg", (DrawableSelector drawableSelector) -> drawableSelector
                                .addRoute(Condition.empty(), drawable -> drawable
                                        .set(Shape.rectangle().setRadius(Dimension.DP_04).setBackgroundColor(red)))))
                .addStyle("textview_g_monochrome0", style -> style
                        .addItem(Style.ANDROID_LAYOUT_WIDTH, "wrap_content")
                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
                        .addItem(Style.ANDROID_TEXTSIZE, textSizeg)
                        .addItem(Style.ANDROID_TEXTCOLOR, monochrome0)
                        .addItem(Style.ANDROID_ELLIPSIZE, "end")
                        .addItem(Style.ANDROID_MAXLINES, "1"))
                .addStyle("textview_g_monochrome1", style -> style
                        .addItem(Style.ANDROID_LAYOUT_WIDTH, "wrap_content")
                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
                        .addItem(Style.ANDROID_TEXTSIZE, textSizeg)
                        .addItem(Style.ANDROID_TEXTCOLOR, monochrome1)
                        .addItem(Style.ANDROID_ELLIPSIZE, "end")
                        .addItem(Style.ANDROID_MAXLINES, "1"))
                .addStyle("textview_g_monochrome2", style -> style
                        .addItem(Style.ANDROID_LAYOUT_WIDTH, "wrap_content")
                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
                        .addItem(Style.ANDROID_TEXTSIZE, textSizeg)
                        .addItem(Style.ANDROID_TEXTCOLOR, monochrome2)
                        .addItem(Style.ANDROID_ELLIPSIZE, "end")
                        .addItem(Style.ANDROID_MAXLINES, "1"))
                .addStyle("textview_g_monochrome3", style -> style
                        .addItem(Style.ANDROID_LAYOUT_WIDTH, "wrap_content")
                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
                        .addItem(Style.ANDROID_TEXTSIZE, textSizeg)
                        .addItem(Style.ANDROID_TEXTCOLOR, monochrome3)
                        .addItem(Style.ANDROID_ELLIPSIZE, "end")
                        .addItem(Style.ANDROID_MAXLINES, "1"))
                .addStyle("textview_g_label_blue", style -> style
                        .addItem(Style.ANDROID_LAYOUT_WIDTH, "wrap_content")
                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
                        .addItem(Style.ANDROID_PADDINGSTART, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGLEFT, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGEND, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGRIGHT, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGTOP, Dimension.DP_02)
                        .addItem(Style.ANDROID_PADDINGBOTTOM, Dimension.DP_02)
                        .addItem(Style.ANDROID_TYPEFACE, "monospace")
                        .addItem(Style.ANDROID_TEXTSIZE, textSizeg)
                        .addItem(Style.ANDROID_TEXTCOLOR, ARGB.WHITE.toString())
                        .addItem(Style.ANDROID_ELLIPSIZE, "end")
                        .addItem(Style.ANDROID_MAXLINES, "1")
                        .addItem(Style.ANDROID_BACKGROUND, "bg", (DrawableSelector drawableSelector) -> drawableSelector
                                .addRoute(Condition.empty(), drawable -> drawable
                                        .set(Shape.rectangle().setRadius(Dimension.DP_04).setBackgroundColor(blue)))))
                .addStyle("textview_g_label_green", style -> style
                        .addItem(Style.ANDROID_LAYOUT_WIDTH, "wrap_content")
                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
                        .addItem(Style.ANDROID_PADDINGSTART, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGLEFT, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGEND, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGRIGHT, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGTOP, Dimension.DP_02)
                        .addItem(Style.ANDROID_PADDINGBOTTOM, Dimension.DP_02)
                        .addItem(Style.ANDROID_TYPEFACE, "monospace")
                        .addItem(Style.ANDROID_TEXTSIZE, textSizeg)
                        .addItem(Style.ANDROID_TEXTCOLOR, ARGB.WHITE.toString())
                        .addItem(Style.ANDROID_ELLIPSIZE, "end")
                        .addItem(Style.ANDROID_MAXLINES, "1")
                        .addItem(Style.ANDROID_BACKGROUND, "bg", (DrawableSelector drawableSelector) -> drawableSelector
                                .addRoute(Condition.empty(), drawable -> drawable
                                        .set(Shape.rectangle().setRadius(Dimension.DP_04).setBackgroundColor(green)))))
                .addStyle("textview_g_label_cyan", style -> style
                        .addItem(Style.ANDROID_LAYOUT_WIDTH, "wrap_content")
                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
                        .addItem(Style.ANDROID_PADDINGSTART, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGLEFT, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGEND, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGRIGHT, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGTOP, Dimension.DP_02)
                        .addItem(Style.ANDROID_PADDINGBOTTOM, Dimension.DP_02)
                        .addItem(Style.ANDROID_TYPEFACE, "monospace")
                        .addItem(Style.ANDROID_TEXTSIZE, textSizeg)
                        .addItem(Style.ANDROID_TEXTCOLOR, ARGB.WHITE.toString())
                        .addItem(Style.ANDROID_ELLIPSIZE, "end")
                        .addItem(Style.ANDROID_MAXLINES, "1")
                        .addItem(Style.ANDROID_BACKGROUND, "bg", (DrawableSelector drawableSelector) -> drawableSelector
                                .addRoute(Condition.empty(), drawable -> drawable
                                        .set(Shape.rectangle().setRadius(Dimension.DP_04).setBackgroundColor(cyan)))))
                .addStyle("textview_g_label_yellow", style -> style
                        .addItem(Style.ANDROID_LAYOUT_WIDTH, "wrap_content")
                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
                        .addItem(Style.ANDROID_PADDINGSTART, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGLEFT, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGEND, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGRIGHT, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGTOP, Dimension.DP_02)
                        .addItem(Style.ANDROID_PADDINGBOTTOM, Dimension.DP_02)
                        .addItem(Style.ANDROID_TYPEFACE, "monospace")
                        .addItem(Style.ANDROID_TEXTSIZE, textSizeg)
                        .addItem(Style.ANDROID_TEXTCOLOR, ARGB.WHITE.toString())
                        .addItem(Style.ANDROID_ELLIPSIZE, "end")
                        .addItem(Style.ANDROID_MAXLINES, "1")
                        .addItem(Style.ANDROID_BACKGROUND, "bg", (DrawableSelector drawableSelector) -> drawableSelector
                                .addRoute(Condition.empty(), drawable -> drawable
                                        .set(Shape.rectangle().setRadius(Dimension.DP_04).setBackgroundColor(yellow)))))
                .addStyle("textview_g_label_red", style -> style
                        .addItem(Style.ANDROID_LAYOUT_WIDTH, "wrap_content")
                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
                        .addItem(Style.ANDROID_PADDINGSTART, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGLEFT, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGEND, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGRIGHT, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGTOP, Dimension.DP_02)
                        .addItem(Style.ANDROID_PADDINGBOTTOM, Dimension.DP_02)
                        .addItem(Style.ANDROID_TYPEFACE, "monospace")
                        .addItem(Style.ANDROID_TEXTSIZE, textSizeg)
                        .addItem(Style.ANDROID_TEXTCOLOR, ARGB.WHITE.toString())
                        .addItem(Style.ANDROID_ELLIPSIZE, "end")
                        .addItem(Style.ANDROID_MAXLINES, "1")
                        .addItem(Style.ANDROID_BACKGROUND, "bg", (DrawableSelector drawableSelector) -> drawableSelector
                                .addRoute(Condition.empty(), drawable -> drawable
                                        .set(Shape.rectangle().setRadius(Dimension.DP_04).setBackgroundColor(red)))))
                .addStyle("textview_h_monochrome0", style -> style
                        .addItem(Style.ANDROID_LAYOUT_WIDTH, "wrap_content")
                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
                        .addItem(Style.ANDROID_TEXTSIZE, textSizeh)
                        .addItem(Style.ANDROID_TEXTCOLOR, monochrome0)
                        .addItem(Style.ANDROID_ELLIPSIZE, "end")
                        .addItem(Style.ANDROID_MAXLINES, "1"))
                .addStyle("textview_h_monochrome1", style -> style
                        .addItem(Style.ANDROID_LAYOUT_WIDTH, "wrap_content")
                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
                        .addItem(Style.ANDROID_TEXTSIZE, textSizeh)
                        .addItem(Style.ANDROID_TEXTCOLOR, monochrome1)
                        .addItem(Style.ANDROID_ELLIPSIZE, "end")
                        .addItem(Style.ANDROID_MAXLINES, "1"))
                .addStyle("textview_h_monochrome2", style -> style
                        .addItem(Style.ANDROID_LAYOUT_WIDTH, "wrap_content")
                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
                        .addItem(Style.ANDROID_TEXTSIZE, textSizeh)
                        .addItem(Style.ANDROID_TEXTCOLOR, monochrome2))
                .addStyle("textview_h_monochrome3", style -> style
                        .addItem(Style.ANDROID_LAYOUT_WIDTH, "wrap_content")
                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
                        .addItem(Style.ANDROID_TEXTSIZE, textSizeh)
                        .addItem(Style.ANDROID_TEXTCOLOR, monochrome3)
                        .addItem(Style.ANDROID_ELLIPSIZE, "end")
                        .addItem(Style.ANDROID_MAXLINES, "1"))
                .addStyle("textview_h_label_blue", style -> style
                        .addItem(Style.ANDROID_LAYOUT_WIDTH, "wrap_content")
                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
                        .addItem(Style.ANDROID_PADDINGSTART, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGLEFT, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGEND, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGRIGHT, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGTOP, Dimension.DP_02)
                        .addItem(Style.ANDROID_PADDINGBOTTOM, Dimension.DP_02)
                        .addItem(Style.ANDROID_TYPEFACE, "monospace").addItem(Style.ANDROID_TEXTSIZE, textSizeh)
                        .addItem(Style.ANDROID_TEXTCOLOR, ARGB.WHITE.toString())
                        .addItem(Style.ANDROID_ELLIPSIZE, "end")
                        .addItem(Style.ANDROID_MAXLINES, "1")
                        .addItem(Style.ANDROID_BACKGROUND, "bg", (DrawableSelector drawableSelector) -> drawableSelector
                                .addRoute(Condition.empty(), drawable -> drawable
                                        .set(Shape.rectangle().setRadius(Dimension.DP_04).setBackgroundColor(blue)))))
                .addStyle("textview_h_label_green", style -> style
                        .addItem(Style.ANDROID_LAYOUT_WIDTH, "wrap_content")
                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
                        .addItem(Style.ANDROID_PADDINGSTART, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGLEFT, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGEND, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGRIGHT, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGTOP, Dimension.DP_02)
                        .addItem(Style.ANDROID_PADDINGBOTTOM, Dimension.DP_02)
                        .addItem(Style.ANDROID_TYPEFACE, "monospace")
                        .addItem(Style.ANDROID_TEXTSIZE, textSizeh)
                        .addItem(Style.ANDROID_TEXTCOLOR, ARGB.WHITE.toString())
                        .addItem(Style.ANDROID_ELLIPSIZE, "end")
                        .addItem(Style.ANDROID_MAXLINES, "1")
                        .addItem(Style.ANDROID_BACKGROUND, "bg", (DrawableSelector drawableSelector) -> drawableSelector
                                .addRoute(Condition.empty(), drawable -> drawable
                                        .set(Shape.rectangle().setRadius(Dimension.DP_04).setBackgroundColor(green)))))
                .addStyle("textview_h_label_cyan", style -> style
                        .addItem(Style.ANDROID_LAYOUT_WIDTH, "wrap_content")
                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
                        .addItem(Style.ANDROID_PADDINGSTART, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGLEFT, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGEND, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGRIGHT, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGTOP, Dimension.DP_02)
                        .addItem(Style.ANDROID_PADDINGBOTTOM, Dimension.DP_02)
                        .addItem(Style.ANDROID_TYPEFACE, "monospace")
                        .addItem(Style.ANDROID_TEXTSIZE, textSizeh)
                        .addItem(Style.ANDROID_TEXTCOLOR, ARGB.WHITE.toString())
                        .addItem(Style.ANDROID_ELLIPSIZE, "end")
                        .addItem(Style.ANDROID_MAXLINES, "1")
                        .addItem(Style.ANDROID_BACKGROUND, "bg", (DrawableSelector drawableSelector) -> drawableSelector
                                .addRoute(Condition.empty(), drawable -> drawable
                                        .set(Shape.rectangle().setRadius(Dimension.DP_04).setBackgroundColor(cyan)))))
                .addStyle("textview_h_label_yellow", style -> style
                        .addItem(Style.ANDROID_LAYOUT_WIDTH, "wrap_content")
                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
                        .addItem(Style.ANDROID_PADDINGSTART, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGLEFT, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGEND, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGRIGHT, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGTOP, Dimension.DP_02)
                        .addItem(Style.ANDROID_PADDINGBOTTOM, Dimension.DP_02)
                        .addItem(Style.ANDROID_TYPEFACE, "monospace")
                        .addItem(Style.ANDROID_TEXTSIZE, textSizeh)
                        .addItem(Style.ANDROID_TEXTCOLOR, ARGB.WHITE.toString())
                        .addItem(Style.ANDROID_ELLIPSIZE, "end")
                        .addItem(Style.ANDROID_MAXLINES, "1")
                        .addItem(Style.ANDROID_BACKGROUND, "bg", (DrawableSelector drawableSelector) -> drawableSelector
                                .addRoute(Condition.empty(), drawable -> drawable
                                        .set(Shape.rectangle().setRadius(Dimension.DP_04).setBackgroundColor(yellow)))))
                .addStyle("textview_h_label_red", style -> style
                        .addItem(Style.ANDROID_LAYOUT_WIDTH, "wrap_content")
                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
                        .addItem(Style.ANDROID_PADDINGSTART, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGLEFT, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGEND, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGRIGHT, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGTOP, Dimension.DP_02)
                        .addItem(Style.ANDROID_PADDINGBOTTOM, Dimension.DP_02)
                        .addItem(Style.ANDROID_TYPEFACE, "monospace")
                        .addItem(Style.ANDROID_TEXTSIZE, textSizeh)
                        .addItem(Style.ANDROID_TEXTCOLOR, ARGB.WHITE.toString())
                        .addItem(Style.ANDROID_ELLIPSIZE, "end")
                        .addItem(Style.ANDROID_MAXLINES, "1")
                        .addItem(Style.ANDROID_BACKGROUND, "bg", (DrawableSelector drawableSelector) -> drawableSelector
                                .addRoute(Condition.empty(), drawable -> drawable
                                        .set(Shape.rectangle().setRadius(Dimension.DP_04).setBackgroundColor(red)))))
                .addStyle("textview_i_monochrome0", style -> style
                        .addItem(Style.ANDROID_LAYOUT_WIDTH, "wrap_content")
                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
                        .addItem(Style.ANDROID_TEXTSIZE, textSizei)
                        .addItem(Style.ANDROID_TEXTCOLOR, monochrome0)
                        .addItem(Style.ANDROID_ELLIPSIZE, "end")
                        .addItem(Style.ANDROID_MAXLINES, "1"))
                .addStyle("textview_i_monochrome1", style -> style
                        .addItem(Style.ANDROID_LAYOUT_WIDTH, "wrap_content")
                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
                        .addItem(Style.ANDROID_TEXTSIZE, textSizei)
                        .addItem(Style.ANDROID_TEXTCOLOR, monochrome1)
                        .addItem(Style.ANDROID_ELLIPSIZE, "end")
                        .addItem(Style.ANDROID_MAXLINES, "1"))
                .addStyle("textview_i_monochrome2", style -> style
                        .addItem(Style.ANDROID_LAYOUT_WIDTH, "wrap_content")
                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
                        .addItem(Style.ANDROID_TEXTSIZE, textSizei)
                        .addItem(Style.ANDROID_TEXTCOLOR, monochrome2)
                        .addItem(Style.ANDROID_ELLIPSIZE, "end")
                        .addItem(Style.ANDROID_MAXLINES, "1"))
                .addStyle("textview_i_monochrome3", style -> style
                        .addItem(Style.ANDROID_LAYOUT_WIDTH, "wrap_content")
                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
                        .addItem(Style.ANDROID_TEXTSIZE, textSizei)
                        .addItem(Style.ANDROID_TEXTCOLOR, monochrome3)
                        .addItem(Style.ANDROID_ELLIPSIZE, "end")
                        .addItem(Style.ANDROID_MAXLINES, "1"))
                .addStyle("textview_i_label_blue", style -> style
                        .addItem(Style.ANDROID_LAYOUT_WIDTH, "wrap_content")
                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
                        .addItem(Style.ANDROID_PADDINGSTART, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGLEFT, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGEND, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGRIGHT, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGTOP, Dimension.DP_02)
                        .addItem(Style.ANDROID_PADDINGBOTTOM, Dimension.DP_02)
                        .addItem(Style.ANDROID_TYPEFACE, "monospace")
                        .addItem(Style.ANDROID_TEXTSIZE, textSizei)
                        .addItem(Style.ANDROID_TEXTCOLOR, ARGB.WHITE.toString())
                        .addItem(Style.ANDROID_ELLIPSIZE, "end")
                        .addItem(Style.ANDROID_MAXLINES, "1")
                        .addItem(Style.ANDROID_BACKGROUND, "bg", (DrawableSelector drawableSelector) -> drawableSelector
                                .addRoute(Condition.empty(), drawable -> drawable
                                        .set(Shape.rectangle().setRadius(Dimension.DP_04).setBackgroundColor(blue)))))
                .addStyle("textview_i_label_green", style -> style
                        .addItem(Style.ANDROID_LAYOUT_WIDTH, "wrap_content")
                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
                        .addItem(Style.ANDROID_PADDINGSTART, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGLEFT, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGEND, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGRIGHT, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGTOP, Dimension.DP_02)
                        .addItem(Style.ANDROID_PADDINGBOTTOM, Dimension.DP_02)
                        .addItem(Style.ANDROID_TYPEFACE, "monospace")
                        .addItem(Style.ANDROID_TEXTSIZE, textSizei)
                        .addItem(Style.ANDROID_TEXTCOLOR, ARGB.WHITE.toString())
                        .addItem(Style.ANDROID_ELLIPSIZE, "end")
                        .addItem(Style.ANDROID_MAXLINES, "1")
                        .addItem(Style.ANDROID_BACKGROUND, "bg", (DrawableSelector drawableSelector) -> drawableSelector
                                .addRoute(Condition.empty(), drawable -> drawable
                                        .set(Shape.rectangle().setRadius(Dimension.DP_04).setBackgroundColor(green)))))
                .addStyle("textview_i_label_cyan", style -> style
                        .addItem(Style.ANDROID_LAYOUT_WIDTH, "wrap_content")
                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
                        .addItem(Style.ANDROID_PADDINGSTART, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGLEFT, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGEND, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGRIGHT, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGTOP, Dimension.DP_02)
                        .addItem(Style.ANDROID_PADDINGBOTTOM, Dimension.DP_02)
                        .addItem(Style.ANDROID_TYPEFACE, "monospace")
                        .addItem(Style.ANDROID_TEXTSIZE, textSizei)
                        .addItem(Style.ANDROID_TEXTCOLOR, ARGB.WHITE.toString())
                        .addItem(Style.ANDROID_ELLIPSIZE, "end")
                        .addItem(Style.ANDROID_MAXLINES, "1")
                        .addItem(Style.ANDROID_BACKGROUND, "bg", (DrawableSelector drawableSelector) -> drawableSelector
                                .addRoute(Condition.empty(), drawable -> drawable
                                        .set(Shape.rectangle().setRadius(Dimension.DP_04).setBackgroundColor(cyan)))))
                .addStyle("textview_i_label_yellow", style -> style
                        .addItem(Style.ANDROID_LAYOUT_WIDTH, "wrap_content")
                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
                        .addItem(Style.ANDROID_PADDINGSTART, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGLEFT, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGEND, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGRIGHT, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGTOP, Dimension.DP_02)
                        .addItem(Style.ANDROID_PADDINGBOTTOM, Dimension.DP_02)
                        .addItem(Style.ANDROID_TYPEFACE, "monospace")
                        .addItem(Style.ANDROID_TEXTSIZE, textSizei)
                        .addItem(Style.ANDROID_TEXTCOLOR, ARGB.WHITE.toString())
                        .addItem(Style.ANDROID_ELLIPSIZE, "end")
                        .addItem(Style.ANDROID_MAXLINES, "1")
                        .addItem(Style.ANDROID_BACKGROUND, "bg", (DrawableSelector drawableSelector) -> drawableSelector
                                .addRoute(Condition.empty(), drawable -> drawable
                                        .set(Shape.rectangle().setRadius(Dimension.DP_04).setBackgroundColor(yellow)))))
                .addStyle("textview_i_label_red", style -> style
                        .addItem(Style.ANDROID_LAYOUT_WIDTH, "wrap_content")
                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
                        .addItem(Style.ANDROID_PADDINGSTART, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGLEFT, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGEND, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGRIGHT, Dimension.DP_04)
                        .addItem(Style.ANDROID_PADDINGTOP, Dimension.DP_02)
                        .addItem(Style.ANDROID_PADDINGBOTTOM, Dimension.DP_02)
                        .addItem(Style.ANDROID_TYPEFACE, "monospace")
                        .addItem(Style.ANDROID_TEXTSIZE, textSizei)
                        .addItem(Style.ANDROID_TEXTCOLOR, ARGB.WHITE.toString())
                        .addItem(Style.ANDROID_ELLIPSIZE, "end")
                        .addItem(Style.ANDROID_MAXLINES, "1")
                        .addItem(Style.ANDROID_BACKGROUND, "bg", (DrawableSelector drawableSelector) -> drawableSelector
                                .addRoute(Condition.empty(), drawable -> drawable
                                        .set(Shape.rectangle().setRadius(Dimension.DP_04).setBackgroundColor(red)))))
                .addStyle("imageview_16", style -> style
                        .addItem(Style.ANDROID_LAYOUT_WIDTH, "16dp")
                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, "16dp")
                        .addItem(Style.ANDROID_SCALETYPE, "centerCrop"))
                .addStyle("imageview_24", style -> style
                        .addItem(Style.ANDROID_LAYOUT_WIDTH, "24dp")
                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, "24dp")
                        .addItem(Style.ANDROID_SCALETYPE, "centerCrop"))
                .addStyle("imageview_32", style -> style
                        .addItem(Style.ANDROID_LAYOUT_WIDTH, "32dp")
                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, "32dp")
                        .addItem(Style.ANDROID_SCALETYPE, "centerCrop"))
                .addStyle("imageview_48", style -> style
                        .addItem(Style.ANDROID_LAYOUT_WIDTH, "48dp")
                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, "48dp")
                        .addItem(Style.ANDROID_SCALETYPE, "centerCrop"))
                .addStyle("imageview_64", style -> style
                        .addItem(Style.ANDROID_LAYOUT_WIDTH, "64dp")
                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, "64dp")
                        .addItem(Style.ANDROID_SCALETYPE, "centerCrop"))
                .addStyle("editview_f", style -> style
                        .addItem(Style.ANDROID_LAYOUT_WIDTH, "wrap_content")
                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
                        .addItem(Style.ANDROID_BACKGROUND, "@null")
                        .addItem(Style.ANDROID_INPUTTYPE, "textNoSuggestions")
                        .addItem(Style.ANDROID_TEXTCOLORHINT, hint.toString())
                        .addItem(Style.ANDROID_TEXTSIZE, Dimension.TEXTSIZE_F))
                .addStyle("editview_f_locked", style -> style
                        .addItem(Style.ANDROID_LAYOUT_WIDTH, "wrap_content")
                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
                        .addItem(Style.ANDROID_ENABLED, "false")
                        .addItem(Style.ANDROID_CLICKABLE, "false")
                        .addItem(Style.ANDROID_LONGCLICKABLE, "false")
                        .addItem(Style.ANDROID_CONTEXTCLICKABLE, "false")
                        .addItem(Style.ANDROID_BACKGROUND, "@null")
                        .addItem(Style.ANDROID_INPUTTYPE, "textNoSuggestions")
                        .addItem(Style.ANDROID_TEXTCOLORHINT, hint.toString())
                        .addItem(Style.ANDROID_TEXTSIZE, Dimension.TEXTSIZE_F))
                .addStyle("switch_f", style -> style
                        .addItem(Style.ANDROID_LAYOUT_WIDTH, "wrap_content")
                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content"))
                .addStyle("view_divider", style -> style
                        .addItem(Style.ANDROID_LAYOUT_WIDTH, "match_parent")
                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, Dimension.DP_01)
                        .addItem(Style.ANDROID_BACKGROUND, divider.toString()))
                .addStyle("view_recycler", style -> style
                        .addItem(Style.ANDROID_BACKGROUND, "bg", (DrawableSelector drawableSelector) -> drawableSelector
                                .addRoute(Condition.from(Condition.STATE_PRESSED), drawable -> drawable.set(Shape.rectangle().setBackgroundColor(pressed)))
                                .addRoute(Condition.from(Condition.STATE_SELECTED), drawable -> drawable.set(Shape.rectangle().setBackgroundColor(selected)))
                                .addRoute(Condition.empty(), drawable -> drawable.set(Shape.rectangle().setBackgroundColor(ARGB.WHITE)))))).print());
    }

//    public static void layout() {
//        System.out.print(Environment.create("layout", environment -> environment
//                .addStyle("frame_container", style -> style
//                        .addItem(Style.ANDROID_LAYOUT_WIDTH, "wrap_content")
//                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content"))
//                .addStyle("linear_columns", style -> style
//                        .addItem(Style.ANDROID_LAYOUT_WIDTH, "match_parent")
//                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, "match_parent")
//                        .addItem(Style.ANDROID_ORIENTATION, "horizontal"))
//                .addStyle("view_column", style -> style
//                        .addItem(Style.ANDROID_LAYOUT_WIDTH, "wrap_content")
//                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, "match_parent")
//                        .addItem(Style.ANDROID_LAYOUT_GRAVITY, "center_vertical"))
//                .addStyle("view_column_x", style -> style//fill the width of columns
//                        .addItem(Style.ANDROID_LAYOUT_WIDTH, "0dp")
//                        .addItem(Style.ANDROID_LAYOUT_WEIGHT, "1")
//                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, "match_parent")
//                        .addItem(Style.ANDROID_LAYOUT_GRAVITY, "center_vertical"))
//                .addStyle("view_column_y", style -> style//define the height of columns
//                        .addItem(Style.ANDROID_LAYOUT_WIDTH, "wrap_content")
//                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
//                        .addItem(Style.ANDROID_LAYOUT_GRAVITY, "center_vertical"))
//                .addStyle("view_column_xy", style -> style//both xy
//                        .addItem(Style.ANDROID_LAYOUT_WIDTH, "0dp")
//                        .addItem(Style.ANDROID_LAYOUT_WEIGHT, "1")
//                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
//                        .addItem(Style.ANDROID_LAYOUT_GRAVITY, "center_vertical"))
//                .addStyle("view_column_4", style -> style
//                        .addItem(Style.ANDROID_LAYOUT_WIDTH, Dimension.DP_04)
//                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, "match_parent")
//                        .addItem(Style.ANDROID_LAYOUT_GRAVITY, "center_vertical"))
//                .addStyle("view_column_8", style -> style
//                        .addItem(Style.ANDROID_LAYOUT_WIDTH, Dimension.DP_08)
//                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, "match_parent")
//                        .addItem(Style.ANDROID_LAYOUT_GRAVITY, "center_vertical"))
//                .addStyle("view_column_16", style -> style
//                        .addItem(Style.ANDROID_LAYOUT_WIDTH, Dimension.DP_16)
//                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, "match_parent")
//                        .addItem(Style.ANDROID_LAYOUT_GRAVITY, "center_vertical"))
//                .addStyle("linear_rows", style -> style
//                        .addItem(Style.ANDROID_LAYOUT_WIDTH, "match_parent")
//                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, "match_parent")
//                        .addItem(Style.ANDROID_ORIENTATION, "vertical"))
//                .addStyle("view_row", style -> style
//                        .addItem(Style.ANDROID_LAYOUT_WIDTH, "match_parent")
//                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
//                        .addItem(Style.ANDROID_LAYOUT_GRAVITY, "center_horizontal"))
//                .addStyle("view_row_y", style -> style//fill the height of rows
//                        .addItem(Style.ANDROID_LAYOUT_WIDTH, "match_parent")
//                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, "0dp")
//                        .addItem(Style.ANDROID_LAYOUT_WEIGHT, "1")
//                        .addItem(Style.ANDROID_LAYOUT_GRAVITY, "center_horizontal"))
//                .addStyle("view_row_x", style -> style//define the width of rows
//                        .addItem(Style.ANDROID_LAYOUT_WIDTH, "wrap_content")
//                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
//                        .addItem(Style.ANDROID_LAYOUT_GRAVITY, "center_horizontal"))
//                .addStyle("view_row_yx", style -> style//both yx
//                        .addItem(Style.ANDROID_LAYOUT_WIDTH, "wrap_content")
//                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, "0dp")
//                        .addItem(Style.ANDROID_LAYOUT_WEIGHT, "1")
//                        .addItem(Style.ANDROID_LAYOUT_GRAVITY, "center_horizontal"))
//                .addStyle("view_row_4", style -> style
//                        .addItem(Style.ANDROID_LAYOUT_WIDTH, "match_parent")
//                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, Dimension.DP_04)
//                        .addItem(Style.ANDROID_LAYOUT_GRAVITY, "center_horizontal"))
//                .addStyle("view_row_8", style -> style
//                        .addItem(Style.ANDROID_LAYOUT_WIDTH, "match_parent")
//                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, Dimension.DP_08)
//                        .addItem(Style.ANDROID_LAYOUT_GRAVITY, "center_horizontal"))
//                .addStyle("view_row_16", style -> style
//                        .addItem(Style.ANDROID_LAYOUT_WIDTH, "match_parent")
//                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, Dimension.DP_16)
//                        .addItem(Style.ANDROID_LAYOUT_GRAVITY, "center_horizontal"))
//        ).print());
//    }
//
//    public static void form() {
//        final ARGB dividerColor = new ARGB(0x80, 0x80, 0x80);
//        final ARGB labelTextColor = new ARGB(0x00, 0x00, 0x00);
//        final ARGB valueTextColor = new ARGB(0x70, 0x70, 0x70);
//        final ARGB valueHintColor = valueTextColor.lighter(0.2f);
//
//        System.out.print(Environment.create("form", environment -> environment
//                .addStyle("frame_group_spacer", style -> style
//                        .addItem(Style.ANDROID_LAYOUT_WIDTH, "match_parent")
//                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
//                        .addItem(Style.ANDROID_MINHEIGHT, "32dp"))
//                .addStyle("linear_group", style -> style
//                        .addItem(Style.ANDROID_LAYOUT_WIDTH, "match_parent")
//                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
//                        .addItem(Style.ANDROID_ORIENTATION, "vertical")
//                        .addItem(Style.ANDROID_BACKGROUND, "bg", (DrawableSelector drawableSelector) -> drawableSelector
//                                .addRoute(Condition.empty(), drawable -> drawable
//                                        .set(LayerList
//                                                .only(Shape.rectangle().setBackgroundColor(dividerColor))
//                                                .put(Dimension.DP_01, Dimension.DP_01, Dimension.DP_00, Dimension.DP_00, Shape.rectangle().setBackgroundColor(ARGB.WHITE))))))
//                .addStyle("frame_row_indent_1", style -> style
//                        .addItem(Style.ANDROID_LAYOUT_WIDTH, "match_parent")
//                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
//                        .addItem(Style.ANDROID_PADDINGSTART, Dimension.DP_16)
//                        .addItem(Style.ANDROID_PADDINGEND, Dimension.DP_16))
//                .addStyle("linear_content", style -> style
//                        .addItem(Style.ANDROID_LAYOUT_WIDTH, "match_parent")
//                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
//                        .addItem(Style.ANDROID_MINHEIGHT, "48dp")
//                        .addItem(Style.ANDROID_ORIENTATION, "horizontal"))
//                .addStyle("view_control_spacer", style -> style
//                        .addItem(Style.ANDROID_LAYOUT_WIDTH, Dimension.DP_08)
//                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, "match_parent"))
//                .addStyle("tv_label", style -> style
//                        .addItem(Style.ANDROID_LAYOUT_WIDTH, "wrap_content")
//                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
//                        .addItem(Style.ANDROID_LAYOUT_GRAVITY, "center_vertical")
//                        .addItem(Style.ANDROID_TEXTCOLOR, labelTextColor.toString())
//                        .addItem(Style.ANDROID_TEXTSIZE, Dimension.TEXTSIZE_F))
//                .addStyle("tv_value", style -> style
//                        .addItem(Style.ANDROID_LAYOUT_WIDTH, Dimension.DP_00)
//                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
//                        .addItem(Style.ANDROID_LAYOUT_WEIGHT, "1")
//                        .addItem(Style.ANDROID_LAYOUT_GRAVITY, "center_vertical")
//                        .addItem(Style.ANDROID_GRAVITY, "right")
//                        .addItem(Style.ANDROID_TEXTCOLOR, valueTextColor.toString())
//                        .addItem(Style.ANDROID_TEXTSIZE, Dimension.TEXTSIZE_F))
//                .addStyle("et_value", style -> style
//                        .addItem(Style.ANDROID_LAYOUT_WIDTH, Dimension.DP_00)
//                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
//                        .addItem(Style.ANDROID_LAYOUT_WEIGHT, "1")
//                        .addItem(Style.ANDROID_LAYOUT_GRAVITY, "center_vertical")
//                        .addItem(Style.ANDROID_GRAVITY, "right")
//                        .addItem(Style.ANDROID_BACKGROUND, "@null")
//                        .addItem(Style.ANDROID_INPUTTYPE, "textNoSuggestions")
//                        .addItem(Style.ANDROID_TEXTCOLOR, valueTextColor.toString())
//                        .addItem(Style.ANDROID_TEXTCOLORHINT, valueHintColor.toString())
//                        .addItem(Style.ANDROID_TEXTSIZE, Dimension.TEXTSIZE_F))
//                .addStyle("et_value_locked", style -> style
//                        .addItem(Style.ANDROID_LAYOUT_WIDTH, Dimension.DP_00)
//                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
//                        .addItem(Style.ANDROID_LAYOUT_WEIGHT, "1")
//                        .addItem(Style.ANDROID_LAYOUT_GRAVITY, "center_vertical")
//                        .addItem(Style.ANDROID_ENABLED, "false")
//                        .addItem(Style.ANDROID_CLICKABLE, "false")
//                        .addItem(Style.ANDROID_LONGCLICKABLE, "false")
//                        .addItem(Style.ANDROID_CONTEXTCLICKABLE, "false")
//                        .addItem(Style.ANDROID_GRAVITY, "right")
//                        .addItem(Style.ANDROID_BACKGROUND, "@null")
//                        .addItem(Style.ANDROID_INPUTTYPE, "textNoSuggestions")
//                        .addItem(Style.ANDROID_TEXTCOLOR, valueTextColor.toString())
//                        .addItem(Style.ANDROID_TEXTCOLORHINT, valueHintColor.toString())
//                        .addItem(Style.ANDROID_TEXTSIZE, Dimension.TEXTSIZE_F))
//                .addStyle("sw_value", style -> style
//                        .addItem(Style.ANDROID_LAYOUT_WIDTH, Dimension.DP_00)
//                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, "wrap_content")
//                        .addItem(Style.ANDROID_LAYOUT_WEIGHT, "1")
//                        .addItem(Style.ANDROID_LAYOUT_GRAVITY, "center_vertical"))
//                .addStyle("iv_instr", style -> style
//                        .addItem(Style.ANDROID_LAYOUT_WIDTH, "24dp")
//                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, "24dp")
//                        .addItem(Style.ANDROID_LAYOUT_GRAVITY, "center_vertical")
//                        .addItem(Style.ANDROID_SCALETYPE, "centerCrop"))
//                .addStyle("view_divider", style -> style
//                        .addItem(Style.ANDROID_LAYOUT_WIDTH, "match_parent")
//                        .addItem(Style.ANDROID_LAYOUT_HEIGHT, Dimension.DP_01)
//                        .addItem(Style.ANDROID_BACKGROUND, dividerColor.toString()))).print());
//    }
}
