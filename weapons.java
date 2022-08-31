import java.util.*;
public class weapons
{
    public static ArrayList<String> attackDamage = new ArrayList<String>();
    public static void setWeapon()
    {

        attackDamage.add("sword");
        attackDamage.add("flamethrower");
    }
    public static void getWeapon()
    {
        Scanner in = new Scanner(System.in);
        
        int rand = (int)(Math.random() * attackDamage.size());
        System.out.println("You have found a " + attackDamage.get(rand) + " in this room. Would you like to pick it up? Yes (1) or No (2): ");
        int choice = in.nextInt();
        if(choice == 1)
        {
            if(Dungeon.weapon.equals("N/A"))
            {
                Dungeon.weapon = attackDamage.get(rand);
                System.out.println("You have picked up the " + attackDamage.get(rand) + ".");
                // add weapon buff
                if(attackDamage.get(rand).equals("sword"))
                {
                    System.out.println("The sword is now increasing your damage by 3.");
                    Dungeon.hero[0] += 3;
                }
                else if(attackDamage.get(rand).equals("flamethrower"))
                {
                    System.out.println("The flamethrower is now increasing your damage by 10 but decreasing your dexterity by 2.");
                    Dungeon.hero[0] += 10;
                    Dungeon.hero[2] -= 2;
                }
                else
                    System.out.println("That item isn't in your hand.");
                attackDamage.remove(rand);
            }
            else
            {
                System.out.println("You already have a weapon equipped, please drop your weapon to equip the new weapon.");
            }
        }
        else
        {
            System.out.println("You did not pick up the weapon.");
        }
    }
    public static void dropWeapon()
    {
        // remove weapon buff
        if (Dungeon.weapon.equals("sword"))
        {
            System.out.println("You have dropped your sword.");
            Dungeon.hero[0] -= 3;
        }
        else if (Dungeon.weapon.equals("flamethrower"))
        {
            System.out.println("You have dropped your flamethrower.");
            Dungeon.hero[0] -= 10;
            Dungeon.hero[2] += 2;
        }
        else
            System.out.println("You have no weapons equipped.");

        Dungeon.weapon = "N/A";
    }
}