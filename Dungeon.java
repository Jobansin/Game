import java.util.*;

public class Dungeon
{
    public static int [] hero = stats.hero();
    public static final int heroHealth = hero[1];
    public static int [] monster;
    public static int [] wizard = stats.wizard();
    public static ArrayList<String> inventory = new ArrayList<String>();
    public static String weapon = "N/A";
    public static boolean gameOver = false;
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        // set the Dungeon layout
        layout.map();

        // set the weapons
        weapons.setWeapon();

        // set the accessories
        accessories.setItems();

        System.out.println("-------------------------------------------");
        System.out.println("| Reincarnated As A Hero In Another World! |");
        System.out.println("-------------------------------------------");
        System.out.println();
        System.out.println("Hero HP: " + Dungeon.hero[1]);
        System.out.println("Hero Damage: " + Dungeon.hero[0]);
        System.out.println("Hero Dexterity: " + Dungeon.hero[2]);
        System.out.println("Inventory: " + Arrays.toString(inventory.toArray()));
        System.out.println("Weapon: " + weapon);
        System.out.println();
        // start
        int x = 4, y = 2;
        System.out.println("You are at the entrance of the dungeon.");
        System.out.println("Would you like to go N, S, E, or W: ");
        String position = in.next();
        String room = null;

        while(!gameOver)
        {
            while(room == null)
            {
                if(position.equals("N"))
                {
                    x -= 1;
                    room = layout.location(x, y);
                    if(room == null)
                        x += 1;
                }
                if(position.equals("S"))
                {
                    x += 1;
                    room = layout.location(x, y);
                    if(room == null)
                        x -= 1;
                }
                if(position.equals("E"))
                {
                    y += 1;
                    room = layout.location(x, y);
                    if(room == null)
                        y -= 1;
                }
                if(position.equals("W"))
                {
                    y -= 1;
                    room = layout.location(x, y);
                    if(room == null)
                        y += 1;
                }
                if(room == null)
                {
                    System.out.println("Sorry, you can't go in that direction.");
                    System.out.println("Would you like to go N, S, E, or W: ");
                    position = in.next();
                }
                if(x == 0 && y == 2 && !inventory.contains("key"))
                {
                    System.out.println("Sorry, you can't go in the boss's room without the key.");
                    x = 1;
                    y = 2;
                }
            }
            // weapon
            if (room.equals("W"))
            {
                weapons.getWeapon();
            }
            if (room.equals("A"))
            {
                accessories.getItem();
            }
            //fountain *make sure can only drink once*
            if (room.equals("F"))
            {
                if(!fountain.hasDrank)
                {
                    System.out.println("Would you like to drink from the fountain? Yes (1) or No (2): ");
                    int choice = in.nextInt();
                    if(choice == 1)
                        fountain.drink();
                    else
                        System.out.println("You have proceeded in not drinking from the fountain.");
                }
                else
                    System.out.println("You have already drank from the fountain.");
            }
            // monster (1) 
            if (room.equals("M"))
            {
                monster = stats.monster();
                battles.fight(1);
                System.out.println("Would you like to attack (1), dodge (2), or run (3)? ");
                int choice = in.nextInt();
                while(hero[1] > 0 && monster[1] > 0)
                {
                    if(choice == 1)
                        battles.attack(1);
                    else if(choice == 2)
                        battles.dodge(1);
                    else
                    {
                        if(battles.run(1))
                            break;
                    }
                    if(monster[1] > 0)
                    {
                        battles.attack(2);
                        if(hero[1] > 0)
                        {
                            System.out.println("Would you like to attack (1), dodge (2), or run (3)? ");
                            choice = in.nextInt();
                        }
                    }
                }        
                if(hero[1] <= 0)
                {
                    System.out.println("You lost against the monster.");
                    System.out.println("Game Over.");
                    gameOver = true;
                    break;
                }
                if(monster[1] <= 0)
                    System.out.println("You won against the monster.");
            }

            // wizard(2)
            if(room.equals("B") && inventory.contains("key"))
            {
                battles.fight(2);
                System.out.println("Would you like to attack (1), dodge (2), or run (3)? ");
                int choice = in.nextInt();
                while(hero[1] > 0 && wizard[1] > 0)
                {
                    if(choice == 1)
                        battles.attackWizard(1);
                    else if(choice == 2)
                        battles.dodge(2);
                    else
                    {
                        if(battles.run(2))
                            break;
                    }
                    if(wizard[1] > 0)
                    {
                        battles.attackWizard(2);
                        if(hero[1] > 0)
                        {
                            System.out.println("Would you like to attack (1), dodge (2), or run (3)? ");
                            choice = in.nextInt();
                        }
                    }
                }        
                if(hero[1] <= 0)
                {
                    System.out.println("You lost against the wizard.");
                    System.out.println("Game Over.");
                    gameOver = true;
                    break;
                }
                if(wizard[1] <= 0)
                    System.out.println("You won against the wizard.");
                    System.out.println("You won the game!");
                    gameOver = true;
                    break;
            }
            
            System.out.println("Would you like to continue moving in the dungeon (1) or drop an item in your inventory (2) or drop your weapon (3): ");
            int option = in.nextInt();
            while(option != 1)
            {
                if(option == 2)
                    accessories.dropItem();
                else if(option == 3)
                    weapons.dropWeapon();
                System.out.println("Would you like to continue moving in the dungeon (1) or drop an item in your inventory (2) or drop your weapon (3): ");
                option = in.nextInt();
            }
            System.out.println();
            System.out.println("Hero HP: " + Dungeon.hero[1]);
            System.out.println("Hero Damage: " + Dungeon.hero[0]);
            System.out.println("Hero Dexterity: " + Dungeon.hero[2]);
            System.out.println(Arrays.toString(inventory.toArray()));
            System.out.println("Weapon: " + weapon);
            System.out.println("Would you like to go N, S, E, or W: ");
            position = in.next();
            room = null;
        }
    }
}