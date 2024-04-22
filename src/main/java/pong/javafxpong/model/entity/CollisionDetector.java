package pong.javafxpong.model.entity;

public class CollisionDetector {
    public static boolean checkCollision(Entity entity1, Entity entity2) {
        return entity1.getX() < entity2.getX() + entity2.getWidth() &&
                entity1.getX() + entity1.getWidth() > entity2.getX() &&
                entity1.getY() < entity2.getY() + entity2.getHeight() &&
                entity1.getY() + entity1.getHeight() > entity2.getY();
    }
}
