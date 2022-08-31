public class stats
{
    public static int damage;
    public static int health;
    public static int dexterity;
    
    public static int[] hero()
    {
        damage = (int)(Math.random() * 6 + 1);
        health = (int)(Math.random() * 11 + 10); 
        dexterity = (int)(Math.random() * 6 + 3); 
        int[] stats = new int[3];
        stats[0] = damage;
        stats[1] = health;
        stats[2] = dexterity;
        return stats;
    }
    public static int[] monster()
    {
        damage = (int)(Math.random() * 4 + 1);
        health = (int)(Math.random() * 6 + 5); 
        int[] stats = new int[2];
        stats[0] = damage;
        stats[1] = health;
        return stats;
    }
    public static int[] wizard()
    {
        damage = (int)(Math.random() * 5 + 4);
        health = (int)(Math.random() * 13 + 12); 
        int[] stats = new int[2];
        stats[0] = damage;
        stats[1] = health;
        return stats;
    }
}
