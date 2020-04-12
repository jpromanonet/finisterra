package model.textures;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import org.jetbrains.annotations.NotNull;

public class RadialProgress {
    public static final Vector2[] POINTS = {
            new Vector2(.5f, 1f),
            new Vector2(1f, 1f),
            new Vector2(1f, .5f),
            new Vector2(1f, 0f),
            new Vector2(.5f, 0f),
            new Vector2(0f, 0f),
            new Vector2(0f, .5f),
            new Vector2(0f, 1f),
            new Vector2(.5f, 1f),
    };

    private final TextureRegion textureRegion;
    private final float[] vertices;
    private int idx = 0;
    private Vector2 centerPt, percentPt;
    private final float x;
    private final float y;
    private final float width;
    private final float height;
    private final float u;
    private final float v;
    private final float u2;
    private final float v2;
    private final float ud;
    private final float vd;
    private float degrees;
    private float percent;
    private final float startAngle;

    private boolean clockwise;

    public RadialProgress(TextureRegion textureRegion) {
        this(textureRegion, 0, 0);
    }

    public RadialProgress(TextureRegion textureRegion, float x, float y) {
        this(textureRegion, x, y, textureRegion.getRegionWidth(), textureRegion.getRegionHeight(), false);
    }

    public RadialProgress(@NotNull TextureRegion textureRegion, float x, float y, float width, float height, boolean clockwise) {
        this.textureRegion = textureRegion;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.u = textureRegion.getU();
        this.v = textureRegion.getV();
        this.u2 = textureRegion.getU2();
        this.v2 = textureRegion.getV2();
        this.ud = u2 - u;
        this.vd = v2 - v;
        this.percent = 0;
        this.vertices = new float[5 * 16];
        this.clockwise = clockwise;
        this.startAngle = 90;
    }

    private void buildVertices() {
        idx = 0;

        if (clockwise)
            degrees = startAngle - (360 * percent % 360);
        else
            degrees = (360 * percent % 360) + startAngle;


        percentPt = new Vector2(
                MathUtils.cosDeg(degrees) + .5f,
                MathUtils.sinDeg(degrees) + .5f
        );

        boolean intersects = false;

        if (clockwise) {
            int i = 0;
            while (!intersects) {
                intersects = buildQuad(POINTS[i++], POINTS[i++], POINTS[i], percentPt);
            }
        } else {
            int i = 8;
            while (!intersects && i > 0) {
                intersects = buildQuad(POINTS[i--], POINTS[i--], POINTS[i], percentPt);
            }
        }
    }

    private boolean buildQuad(Vector2 point1, Vector2 point2, Vector2 point3, Vector2 percentPt) {
        Vector2 intersection = new Vector2();
        centerPt = new Vector2(0.5f, 0.5f);

        float color = Color.WHITE.toFloatBits();

        vert(centerPt, color);
        vert(point1, color);

        if (Intersector.intersectSegments(centerPt, percentPt, point1, point2, intersection)) {
            vert(intersection, color);
            vert(intersection, color);
        } else if (Intersector.intersectSegments(centerPt, percentPt, point2, point3, intersection)) {
            vert(point2, color);
            vert(intersection, color);
        } else {
            vert(point2, color);
            vert(point3, color);
            return false;
        }

        return true;
    }

    private void vert(@NotNull Vector2 point, float color) {
        vert(x + point.x * width, y + point.y * height, color, u + ud * point.x, v + vd * point.y);
    }

    private void vert(float x, float y, float color, float u, float v) {
        vertices[idx++] = x;
        vertices[idx++] = y;
        vertices[idx++] = color;
        vertices[idx++] = u;
        vertices[idx++] = v;
    }

    public void draw(@NotNull SpriteBatch batch) {
        batch.draw(textureRegion.getTexture(), vertices, 0, idx);
    }

    public float getPercent() {
        return percent;
    }

    public void setPercent(float percent) {
        this.percent = percent;
        buildVertices();
    }
}
