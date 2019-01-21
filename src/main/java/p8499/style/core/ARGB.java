package p8499.style.core;

/**
 * Created by Administrator on 3/1/2018.
 */
public class ARGB implements Cloneable {
    private float mA, mR, mG, mB;

    public ARGB() {
        this(0, 0, 0, 0);
    }

    public ARGB(float r, float g, float b) {
        this(0xff, r, g, b);
    }

    public ARGB(float a, float r, float g, float b) {
        mA = a;
        mR = r;
        mG = g;
        mB = b;
    }

    public float getA() {
        return mA;
    }

    public ARGB setA(float a) {
        return new ARGB(a, mR, mG, mB);
    }

    public float getR() {
        return mR;
    }

    public ARGB setR(float r) {
        return new ARGB(mA, r, mG, mB);
    }

    public float getG() {
        return mG;
    }

    public ARGB setG(float g) {
        return new ARGB(mA, mR, g, mB);
    }

    public float getB() {
        return mB;
    }

    public ARGB setB(float b) {
        return new ARGB(mA, mR, mG, b);
    }

    public ARGB lighter(float ratio) {
        return toHSL().lighter(ratio).toARGB();
    }

    public ARGB darker(float ratio) {
        return toHSL().darker(ratio).toARGB();
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("#");
        String a = Integer.toHexString(Math.round(mA) & 0xff);
        String r = Integer.toHexString(Math.round(mR) & 0xff);
        String g = Integer.toHexString(Math.round(mG) & 0xff);
        String b = Integer.toHexString(Math.round(mB) & 0xff);
        sb.append(a.length() < 2 ? "0" + a : a);
        sb.append(r.length() < 2 ? "0" + r : r);
        sb.append(g.length() < 2 ? "0" + g : g);
        sb.append(b.length() < 2 ? "0" + b : b);
        return sb.toString();
    }

    @Override
    public ARGB clone() {
        return new ARGB(mA, mR, mG, mB);
    }

    public HSL toHSL() {
        float r = mR / 255f, g = mG / 255f, b = mB / 255f;
        float max = Math.max(r, Math.max(g, b)), min = Math.min(r, Math.min(g, b));
        float h, s, l = (max + min) / 2f;

        if (max == min) {
            h = s = 0f;
        } else {
            float d = max - min;
            s = l > 0.5f ? d / (2f - max - min) : d / (max + min);
            if (max == r)
                h = (g - b) / d + (g < b ? 6f : 0f);
            else if (max == g)
                h = (b - r) / d + 2f;
            else
                h = (r - g) / d + 4f;
            h /= 6f;
        }
        return new HSL(h * 255f, s * 255f, l * 255f);
    }

    public static final ARGB RED_050 = new ARGB(0xff, 0xff, 0xeb, 0xee);
    public static final ARGB RED_100 = new ARGB(0xff, 0xff, 0xcd, 0xd2);
    public static final ARGB RED_200 = new ARGB(0xff, 0xef, 0x9a, 0x9a);
    public static final ARGB RED_300 = new ARGB(0xff, 0xe5, 0x73, 0x73);
    public static final ARGB RED_400 = new ARGB(0xff, 0xef, 0x53, 0x50);
    public static final ARGB RED_500 = new ARGB(0xff, 0xf4, 0x43, 0x36);
    public static final ARGB RED_600 = new ARGB(0xff, 0xe5, 0x39, 0x35);
    public static final ARGB RED_700 = new ARGB(0xff, 0xd3, 0x2f, 0x2f);
    public static final ARGB RED_800 = new ARGB(0xff, 0xc6, 0x28, 0x28);
    public static final ARGB RED_900 = new ARGB(0xff, 0xb7, 0x1c, 0x1c);
    public static final ARGB PINK_050 = new ARGB(0xff, 0xfc, 0xe4, 0xec);
    public static final ARGB PINK_100 = new ARGB(0xff, 0xf8, 0xbb, 0xd0);
    public static final ARGB PINK_200 = new ARGB(0xff, 0xf4, 0x8f, 0xb1);
    public static final ARGB PINK_300 = new ARGB(0xff, 0xf0, 0x62, 0x92);
    public static final ARGB PINK_400 = new ARGB(0xff, 0xec, 0x40, 0x7a);
    public static final ARGB PINK_500 = new ARGB(0xff, 0xe9, 0x1e, 0x63);
    public static final ARGB PINK_600 = new ARGB(0xff, 0xd8, 0x1b, 0x60);
    public static final ARGB PINK_700 = new ARGB(0xff, 0xc2, 0x18, 0x5b);
    public static final ARGB PINK_800 = new ARGB(0xff, 0xad, 0x14, 0x57);
    public static final ARGB PINK_900 = new ARGB(0xff, 0x88, 0x0e, 0x4f);
    public static final ARGB PURPLE_050 = new ARGB(0xff, 0xf3, 0xe5, 0xf5);
    public static final ARGB PURPLE_100 = new ARGB(0xff, 0xe1, 0xbe, 0xe7);
    public static final ARGB PURPLE_200 = new ARGB(0xff, 0xce, 0x93, 0xd8);
    public static final ARGB PURPLE_300 = new ARGB(0xff, 0xba, 0x68, 0xc8);
    public static final ARGB PURPLE_400 = new ARGB(0xff, 0xab, 0x47, 0xbc);
    public static final ARGB PURPLE_500 = new ARGB(0xff, 0x9c, 0x27, 0xb0);
    public static final ARGB PURPLE_600 = new ARGB(0xff, 0x8e, 0x24, 0xaa);
    public static final ARGB PURPLE_700 = new ARGB(0xff, 0x7b, 0x1f, 0xa2);
    public static final ARGB PURPLE_800 = new ARGB(0xff, 0x6a, 0x1b, 0x9a);
    public static final ARGB PURPLE_900 = new ARGB(0xff, 0x4a, 0x14, 0x8c);
    public static final ARGB INDIGO_050 = new ARGB(0xff, 0xe8, 0xea, 0xf6);
    public static final ARGB INDIGO_100 = new ARGB(0xff, 0xc5, 0xca, 0xe9);
    public static final ARGB INDIGO_200 = new ARGB(0xff, 0x9f, 0xa8, 0xda);
    public static final ARGB INDIGO_300 = new ARGB(0xff, 0x79, 0x86, 0xcb);
    public static final ARGB INDIGO_400 = new ARGB(0xff, 0x5c, 0x6b, 0xc0);
    public static final ARGB INDIGO_500 = new ARGB(0xff, 0x3f, 0x51, 0xb5);
    public static final ARGB INDIGO_600 = new ARGB(0xff, 0x39, 0x49, 0xab);
    public static final ARGB INDIGO_700 = new ARGB(0xff, 0x30, 0x3f, 0x9f);
    public static final ARGB INDIGO_800 = new ARGB(0xff, 0x28, 0x35, 0x93);
    public static final ARGB INDIGO_900 = new ARGB(0xff, 0x1a, 0x23, 0x7e);
    public static final ARGB BLUE_050 = new ARGB(0xff, 0xe3, 0xf2, 0xfd);
    public static final ARGB BLUE_100 = new ARGB(0xff, 0xbb, 0xde, 0xfb);
    public static final ARGB BLUE_200 = new ARGB(0xff, 0x90, 0xca, 0xf9);
    public static final ARGB BLUE_300 = new ARGB(0xff, 0x64, 0xb5, 0xf6);
    public static final ARGB BLUE_400 = new ARGB(0xff, 0x42, 0xa5, 0xf5);
    public static final ARGB BLUE_500 = new ARGB(0xff, 0x21, 0x96, 0xf3);
    public static final ARGB BLUE_600 = new ARGB(0xff, 0x1e, 0x88, 0xe5);
    public static final ARGB BLUE_700 = new ARGB(0xff, 0x19, 0x76, 0xd2);
    public static final ARGB BLUE_800 = new ARGB(0xff, 0x15, 0x65, 0xc0);
    public static final ARGB BLUE_900 = new ARGB(0xff, 0x0d, 0x47, 0xa1);
    public static final ARGB CYAN_050 = new ARGB(0xff, 0xe0, 0xf7, 0xfa);
    public static final ARGB CYAN_100 = new ARGB(0xff, 0xb2, 0xeb, 0xf2);
    public static final ARGB CYAN_200 = new ARGB(0xff, 0x80, 0xde, 0xea);
    public static final ARGB CYAN_300 = new ARGB(0xff, 0x4d, 0xd0, 0xe1);
    public static final ARGB CYAN_400 = new ARGB(0xff, 0x26, 0xc6, 0xda);
    public static final ARGB CYAN_500 = new ARGB(0xff, 0x00, 0xbc, 0xd4);
    public static final ARGB CYAN_600 = new ARGB(0xff, 0x00, 0xac, 0xc1);
    public static final ARGB CYAN_700 = new ARGB(0xff, 0x00, 0x97, 0xa7);
    public static final ARGB CYAN_800 = new ARGB(0xff, 0x00, 0x83, 0x8f);
    public static final ARGB CYAN_900 = new ARGB(0xff, 0x00, 0x60, 0x64);
    public static final ARGB TEAL_050 = new ARGB(0xff, 0xe0, 0xf2, 0xf1);
    public static final ARGB TEAL_100 = new ARGB(0xff, 0xb2, 0xdf, 0xdb);
    public static final ARGB TEAL_200 = new ARGB(0xff, 0x80, 0xcb, 0xc4);
    public static final ARGB TEAL_300 = new ARGB(0xff, 0x4d, 0xb6, 0xac);
    public static final ARGB TEAL_400 = new ARGB(0xff, 0x26, 0xa6, 0x9a);
    public static final ARGB TEAL_500 = new ARGB(0xff, 0x00, 0x96, 0x88);
    public static final ARGB TEAL_600 = new ARGB(0xff, 0x00, 0x89, 0x7b);
    public static final ARGB TEAL_700 = new ARGB(0xff, 0x00, 0x79, 0x6b);
    public static final ARGB TEAL_800 = new ARGB(0xff, 0x00, 0x69, 0x5c);
    public static final ARGB TEAL_900 = new ARGB(0xff, 0x00, 0x4d, 0x40);
    public static final ARGB GREEN_050 = new ARGB(0xff, 0xe8, 0xf5, 0xe9);
    public static final ARGB GREEN_100 = new ARGB(0xff, 0xc8, 0xe6, 0xc9);
    public static final ARGB GREEN_200 = new ARGB(0xff, 0xa5, 0xd6, 0xa7);
    public static final ARGB GREEN_300 = new ARGB(0xff, 0x81, 0xc7, 0x84);
    public static final ARGB GREEN_400 = new ARGB(0xff, 0x66, 0xbb, 0x6a);
    public static final ARGB GREEN_500 = new ARGB(0xff, 0x4c, 0xaf, 0x50);
    public static final ARGB GREEN_600 = new ARGB(0xff, 0x43, 0xa0, 0x47);
    public static final ARGB GREEN_700 = new ARGB(0xff, 0x38, 0x8e, 0x3c);
    public static final ARGB GREEN_800 = new ARGB(0xff, 0x2e, 0x7d, 0x32);
    public static final ARGB GREEN_900 = new ARGB(0xff, 0x1b, 0x5e, 0x20);
    public static final ARGB LIME_050 = new ARGB(0xff, 0xf9, 0xfb, 0xe7);
    public static final ARGB LIME_100 = new ARGB(0xff, 0xf0, 0xf4, 0xc3);
    public static final ARGB LIME_200 = new ARGB(0xff, 0xe6, 0xee, 0x9c);
    public static final ARGB LIME_300 = new ARGB(0xff, 0xdc, 0xe7, 0x75);
    public static final ARGB LIME_400 = new ARGB(0xff, 0xd4, 0xe1, 0x57);
    public static final ARGB LIME_500 = new ARGB(0xff, 0xcd, 0xdc, 0x39);
    public static final ARGB LIME_600 = new ARGB(0xff, 0xc0, 0xca, 0x33);
    public static final ARGB LIME_700 = new ARGB(0xff, 0xaf, 0xb4, 0x2b);
    public static final ARGB LIME_800 = new ARGB(0xff, 0x9e, 0x9d, 0x24);
    public static final ARGB LIME_900 = new ARGB(0xff, 0x82, 0x77, 0x17);
    public static final ARGB YELLOW_050 = new ARGB(0xff, 0xff, 0xfd, 0xe7);
    public static final ARGB YELLOW_100 = new ARGB(0xff, 0xff, 0xf9, 0xc4);
    public static final ARGB YELLOW_200 = new ARGB(0xff, 0xff, 0xf5, 0x9d);
    public static final ARGB YELLOW_300 = new ARGB(0xff, 0xff, 0xf1, 0x76);
    public static final ARGB YELLOW_400 = new ARGB(0xff, 0xff, 0xee, 0x58);
    public static final ARGB YELLOW_500 = new ARGB(0xff, 0xff, 0xeb, 0x3b);
    public static final ARGB YELLOW_600 = new ARGB(0xff, 0xfd, 0xd8, 0x35);
    public static final ARGB YELLOW_700 = new ARGB(0xff, 0xfb, 0xc0, 0x2d);
    public static final ARGB YELLOW_800 = new ARGB(0xff, 0xf9, 0xa8, 0x25);
    public static final ARGB YELLOW_900 = new ARGB(0xff, 0xf5, 0x7f, 0x17);
    public static final ARGB AMBER_050 = new ARGB(0xff, 0xff, 0xf8, 0xe1);
    public static final ARGB AMBER_100 = new ARGB(0xff, 0xff, 0xec, 0xb3);
    public static final ARGB AMBER_200 = new ARGB(0xff, 0xff, 0xe0, 0x82);
    public static final ARGB AMBER_300 = new ARGB(0xff, 0xff, 0xd5, 0x4f);
    public static final ARGB AMBER_400 = new ARGB(0xff, 0xff, 0xca, 0x28);
    public static final ARGB AMBER_500 = new ARGB(0xff, 0xff, 0xc1, 0x07);
    public static final ARGB AMBER_600 = new ARGB(0xff, 0xff, 0xb3, 0x00);
    public static final ARGB AMBER_700 = new ARGB(0xff, 0xff, 0xa0, 0x00);
    public static final ARGB AMBER_800 = new ARGB(0xff, 0xff, 0x8f, 0x00);
    public static final ARGB AMBER_900 = new ARGB(0xff, 0xff, 0x6f, 0x00);
    public static final ARGB ORANGE_050 = new ARGB(0xff, 0xff, 0xf3, 0xe0);
    public static final ARGB ORANGE_100 = new ARGB(0xff, 0xff, 0xe0, 0xb2);
    public static final ARGB ORANGE_200 = new ARGB(0xff, 0xff, 0xcc, 0x80);
    public static final ARGB ORANGE_300 = new ARGB(0xff, 0xff, 0xb7, 0x4d);
    public static final ARGB ORANGE_400 = new ARGB(0xff, 0xff, 0xa7, 0x26);
    public static final ARGB ORANGE_500 = new ARGB(0xff, 0xff, 0x98, 0x00);
    public static final ARGB ORANGE_600 = new ARGB(0xff, 0xfb, 0x8c, 0x00);
    public static final ARGB ORANGE_700 = new ARGB(0xff, 0xf5, 0x7c, 0x00);
    public static final ARGB ORANGE_800 = new ARGB(0xff, 0xef, 0x6c, 0x00);
    public static final ARGB ORANGE_900 = new ARGB(0xff, 0xe6, 0x51, 0x00);
    public static final ARGB BROWN_050 = new ARGB(0xff, 0xef, 0xeb, 0xe9);
    public static final ARGB BROWN_100 = new ARGB(0xff, 0xd7, 0xcc, 0xc8);
    public static final ARGB BROWN_200 = new ARGB(0xff, 0xbc, 0xaa, 0xa4);
    public static final ARGB BROWN_300 = new ARGB(0xff, 0xa1, 0x88, 0x7f);
    public static final ARGB BROWN_400 = new ARGB(0xff, 0x8d, 0x6e, 0x63);
    public static final ARGB BROWN_500 = new ARGB(0xff, 0x79, 0x55, 0x48);
    public static final ARGB BROWN_600 = new ARGB(0xff, 0x6d, 0x4c, 0x41);
    public static final ARGB BROWN_700 = new ARGB(0xff, 0x5d, 0x40, 0x37);
    public static final ARGB BROWN_800 = new ARGB(0xff, 0x4e, 0x34, 0x2e);
    public static final ARGB BROWN_900 = new ARGB(0xff, 0x3e, 0x27, 0x23);
    public static final ARGB GREY_050 = new ARGB(0xff, 0xfa, 0xfa, 0xfa);
    public static final ARGB GREY_100 = new ARGB(0xff, 0xf5, 0xf5, 0xf5);
    public static final ARGB GREY_200 = new ARGB(0xff, 0xee, 0xee, 0xee);
    public static final ARGB GREY_300 = new ARGB(0xff, 0xe0, 0xe0, 0xe0);
    public static final ARGB GREY_400 = new ARGB(0xff, 0xbd, 0xbd, 0xbd);
    public static final ARGB GREY_500 = new ARGB(0xff, 0x9e, 0x9e, 0x9e);
    public static final ARGB GREY_600 = new ARGB(0xff, 0x75, 0x75, 0x75);
    public static final ARGB GREY_700 = new ARGB(0xff, 0x61, 0x61, 0x61);
    public static final ARGB GREY_800 = new ARGB(0xff, 0x42, 0x42, 0x42);
    public static final ARGB GREY_900 = new ARGB(0xff, 0x21, 0x21, 0x21);
    public static final ARGB BLACK = new ARGB(0xff, 0x00, 0x00, 0x00);
    public static final ARGB WHITE = new ARGB(0xff, 0xff, 0xff, 0xff);
    public static final ARGB TRANSPARENT = new ARGB(0x00, 0x00, 0x00, 0x00);
}
