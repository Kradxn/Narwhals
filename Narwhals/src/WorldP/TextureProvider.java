package WorldP;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import java.util.HashMap;

/**
 * User: Fritz
 * Date: 13.06.13
 * Time: 14:55
 */
public class TextureProvider {
    HashMap<String, Image> textureMap = new HashMap<String, Image>();
    HashMap<String, Animation> animationMap = new HashMap<String, Animation>();
    public static final TextureProvider instance = new TextureProvider();


    public static void registerTexture(String name, Image image) {
        if (!instance.textureMap.containsKey(name)) instance.textureMap.put(name, image);
    }

    public static void registerTexutrebyPath(String name, String fileName) throws SlickException {
        registerTexture(name, new Image("res/" + fileName + ".png"));
    }

    public static Image getImageforName(String name) {
        return instance.textureMap.get(name);
    }


    public static void registerAnimation(String name, Animation animation) {
        if (!instance.animationMap.containsKey(name)) instance.animationMap.put(name, animation);
    }

    public static void registerAnimation(String name, Image image, int aniNum, int duration) {
        Animation animation = new Animation();
        int aniWidght = image.getWidth() / aniNum;
        int aniHeight = image.getHeight();
        for (int i = 0; i < aniNum; i++) {
            animation.addFrame(image.getSubImage(i * aniWidght, 0, aniWidght, aniHeight), duration);
        }

        if (!instance.animationMap.containsKey(name)) instance.animationMap.put(name, animation);
    }

    public static void registerAnimationbyPath(String name, String fileName, int aniNum, int duration) throws SlickException {
        registerAnimation(name, new Image("res/" + fileName + ".png"), aniNum, duration);
    }

    public static Animation getAnimationforName(String name) {
        return instance.animationMap.get(name);
    }

    public static void unregisterAnimation(String name) {
        instance.animationMap.remove(name);
    }

    public static void unregisterTexture(String name) {
        instance.textureMap.remove(name);
    }
}
