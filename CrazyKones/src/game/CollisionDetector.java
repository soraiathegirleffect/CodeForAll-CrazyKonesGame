package game;

import gameObjects.*;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class CollisionDetector {

    private Game game;
    private Car car;

    public void collision(Obstacle obstacle) {
        Picture obstaclePic = obstacle.getPic();
        Picture carPic = car.getCarPic();

        if (carPic.getX() + carPic.getWidth() >= obstaclePic.getX() && carPic.getY() + carPic.getHeight() >= obstaclePic.getY() &&
                carPic.getY() <= obstaclePic.getY() + obstaclePic.getHeight() && carPic.getX() <= obstaclePic.getX() + obstaclePic.getWidth()) {
            if(obstacle instanceof Bad){
                game.gameOver();
            }
            if (obstacle instanceof Effect){
                ((Effect) obstacle).fire();
            }
            if (obstacle instanceof Good){
                ((Good) obstacle).plusPoint();
                ((Good) obstacle).outFire();
            }
        }
    }

    public void setCar(Car car){
        this.car = car;
    }

    public void setGame(Game game){
        this.game = game;
    }

    }



