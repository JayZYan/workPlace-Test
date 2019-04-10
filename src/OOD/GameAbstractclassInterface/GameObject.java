package OOD.GameAbstractclassInterface;

public abstract class GameObject {
    private int x;
    public void blah() {

    }
    GameObject() {
        x = 5;
    }
    // This method must be implemented by any class that extends GameObject
    public abstract void draw();


    public static void main(String[] args) {
        GameObject player = new Player();
        //GameObject myObject = new GameObject();
        //abstract classes exist to be extended, they can not be instantiated
        //player.draw();
        GameObject menu = new Menu();
        //menu.draw();
        GameObject[] gameObjects = new GameObject[2];
        gameObjects[0] = player;
        gameObjects[1] = menu;

        for (GameObject obj : gameObjects) {
            obj.draw();
        }

    }
}
