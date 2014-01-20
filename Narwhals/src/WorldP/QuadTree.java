package WorldP;

import org.newdawn.slick.geom.Rectangle;

import java.util.List;

/**
 * User: Fritz
 * Date: 27.10.13
 * Time: 23:13
 * QuadTree for 2dRectangle Collision Detection
 */
public class QuadTree {
    static int capacity = 4;
    protected Rectangle bounds;
    List<Rectangle> elements;
    QuadTree[] quads;

    public QuadTree(Rectangle bounds) {
        this.bounds = bounds;
    }

    public boolean insert(Rectangle rectangle) {
        if (!bounds.contains(rectangle)) return false;
        if (quads != null) {
            int pos = getPosition(rectangle);
            if (pos != -1) {
                return quads[pos].insert(rectangle);
            }
        }
        elements.add(rectangle);
        if (elements.size() > capacity && quads == null) {
            split();
            for (int i = 0; i < elements.size(); i++) {
                int pos = getPosition(elements.get(i));
                if (pos != -1) {
                    quads[pos].insert(elements.remove(i));
                }
            }
        }

        return false;
    }

    public void clear() {
        elements.clear();
        if (quads != null) {
            for (int i = 0; i < 4; i++) quads[i].clear();
            quads = null;
        }
    }

    private void split() {
        if (quads != null) return;
        quads = new QuadTree[4];
        float width = bounds.getWidth() / 2;
        float height = bounds.getHeight() / 2;
        quads[2] = new QuadTree(new Rectangle(bounds.getX(), bounds.getY(), width, height));
        quads[3] = new QuadTree(new Rectangle(bounds.getX() + width, bounds.getY(), width, height));
        quads[0] = new QuadTree(new Rectangle(bounds.getX(), bounds.getY() + height, width, height));
        quads[1] = new QuadTree(new Rectangle(bounds.getX() + width, bounds.getY() + height, width, height));
    }

    private int getPosition(Rectangle rectangle) {
        if (quads != null) {
            for (int i = 0; i < 4; i++) if (quads[i].bounds.contains(rectangle)) return i;
        }
        return -1;
    }

    public void getRectangleK(List<Rectangle> rectangles, Rectangle rectangle) {
        int pos = getPosition(rectangle);
        if (pos != -1) {
            quads[pos].getRectangleK(rectangles, rectangle);
        }
        rectangles.addAll(elements);
    }
}
