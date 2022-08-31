import java.util.*;

public class accessories
{
    public static ArrayList<String> items = new ArrayList<String>();
    public static boolean potion = false;
    public static boolean shield = false;
    public static void setItems()
    {
        items.add("key");
        items.add("potion");
        items.add("ring");
        items.add("shield");
        //randomly generate the 4 different accessories in the 4 "A" locations on the map (arr[1][1] arr[1][3] arr[3][1] arr[3][3])
        //key opens gate to wizard [0][2]
        //potion heals 1 health to every round of a battle (up to the hero's maximum health) hero[1]
        //ring increases dexterity by 1 (Dungeon.hero[2] + 1)
        //sheild decreases damage taken by 1 (Dungeon.wizard[0]-1 && Dungeon.monster[0]-1)
    }
    public static void getItem()
    {
        Scanner in = new Scanner(System.in);
        int rand = (int)(Math.random() * items.size());
        if(items.size() > 0)
        {
            System.out.println("You have found a " + items.get(rand) + " in this room. Would you like to pick it up? Yes (1) or No (2): ");
            int choice = in.nextInt();
            if(choice == 1 && Dungeon.inventory.size() < 3)
            {
                Dungeon.inventory.add(items.get(rand));
                System.out.println("You have added " + items.get(rand) + " to your inventory.");
                // add accessory buff
                if(items.get(rand).equals("potion"))
                {
                    System.out.println("The potion is now healing you for 1 health every round of a battle.");
                    potion = true;
                }
                if(items.get(rand).equals("ring"))
                {
                    System.out.println("The ring is now increasing your dexterity by 1.");
                    Dungeon.hero[2] += 1;
                }
                if(items.get(rand).equals("shield"))
                {
                    System.out.println("The shield is now decreasing your damage taken by 1.");
                    shield = true;
                }
                items.remove(rand);
            }
            else
            {
                System.out.println("Sorry, your inventory is full. Please drop an item in your inventory to equip the new item.");
            }
        }
        else
        {
            System.out.println("There is no item is this room.");
        }
    }
    public static void dropItem()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("What item would you like to drop? ");
        String item = in.nextLine();
        if(Dungeon.inventory.contains(item))
        {
            // remove accessory buff
            if (item.equals("potion"))
            {
                System.out.println("You have removed the potion from your inventory.");
                potion = false;
            }
            else if (item.equals("ring"))
            {
                System.out.println("You have removed the ring from your inventory.");
                Dungeon.hero[2] -= 1;
            }
            else if (item.equals("shield"))
            {
                System.out.println("You have removed the shield from your inventory.");
                shield = false;
            }
            Dungeon.inventory.remove(item);
        }
        else
            System.out.println("That item isn't in your inventory.");
    }
}