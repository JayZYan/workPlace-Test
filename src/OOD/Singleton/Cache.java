package OOD.Singleton;

public class Cache {
    private static Cache cacheInstance;

    private Cache() {
        //Load data

    }
    public static Cache getCacheInstance() {
        if (cacheInstance == null) {
            cacheInstance = new Cache();
        }
        return cacheInstance;
    }



    public static void main(String[] args) {
        Cache cache = Cache.getCacheInstance();
    }
}
