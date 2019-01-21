package p8499.style.core;

/**
 * Created by Administrator on 3/1/2018.
 */
public class HSL {
    private float mH, mS, mL;

    public HSL() {
        this(0, 0, 0);
    }

    public HSL(float r, float g, float b) {
        mH = r;
        mS = g;
        mL = b;
    }

    public float getH() {
        return mH;
    }

    public HSL setH(float h) {
        return new HSL(h, mS, mL);
    }

    public float getS() {
        return mS;
    }

    public HSL setS(float s) {
        return new HSL(mH, s, mL);
    }

    public float getL() {
        return mL;
    }

    public HSL setL(float l) {
        return new HSL(mH, mS, l);
    }

    public HSL hueApproachTop(float ratio) {
        return new HSL(mH + (255 - mH) * ratio, mS, mL);
    }

    public HSL hueApproachBottom(float ratio) {
        return new HSL(mH - mH * ratio, mS, mL);
    }

    public HSL saturationApproachTop(float ratio) {
        return new HSL(mH, mS + (255 - mS) * ratio, mL);
    }

    public HSL saturationApproachBottom(float ratio) {
        return new HSL(mH, mS - mS * ratio, mL);
    }

    public HSL lighter(float ratio) {
        return new HSL(mH, mS, mL + (255 - mL) * ratio);
    }

    public HSL darker(float ratio) {
        return new HSL(mH, mS, mL - mL * ratio);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("#");
        String h = Integer.toHexString(Math.round(mH) & 0xff);
        String s = Integer.toHexString(Math.round(mS) & 0xff);
        String l = Integer.toHexString(Math.round(mL) & 0xff);
        sb.append(h.length() < 2 ? "0" + h : h);
        sb.append(s.length() < 2 ? "0" + s : s);
        sb.append(l.length() < 2 ? "0" + l : l);
        return sb.toString();
    }

    public ARGB toARGB() {
        float h = mH / 255f, s = mS / 255f, l = mL / 255f;
        float r, g, b;
        if (s == 0f) {
            r = g = b = l;
        } else {
            float q = l < 0.5f ? l * (1f + s) : l + s - l * s;
            float p = 2f * l - q;
            r = hue2rgb(p, q, h + 1f / 3f);
            g = hue2rgb(p, q, h);
            b = hue2rgb(p, q, h - 1f / 3f);
        }
        return new ARGB(0xff, r * 255f, g * 255f, b * 255f);
    }

    private float hue2rgb(float p, float q, float t) {
        if (t < 0f) t += 1f;
        if (t > 1f) t -= 1f;
        if (t < 1f / 6f) return p + (q - p) * 6f * t;
        if (t < 1f / 2f) return q;
        if (t < 2f / 3f) return p + (q - p) * (2f / 3f - t) * 6f;
        return p;
    }
}
