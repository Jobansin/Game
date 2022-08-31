public class fountain
{
    public static boolean hasDrank = false;
    public static void drink()
    {

        double probability = Math.random();
        System.out.println("You drank from the fountain... ");
        if (probability <= 0.2)
        {
            Dungeon.hero[0] += 2;
            System.out.println("Hero gained two more points in damage.");
        }
        else if(probability <= 0.4)
        { 
            Dungeon.hero[2] += 1;
            System.out.println("Hero gained one point in dexterity.");
        }
        else if(probability <= 0.6)
        {
            Dungeon.hero[1] -= 2;
            System.out.println("It was poisonous and the hero lost 2 health points.");
        }
        else 
        {
            System.out.println("Nothing happened.");
        }
        hasDrank = true;
    }
}