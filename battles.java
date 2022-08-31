public class battles
{
    // if turn == 1, hero's turn
    // if turn == 2, monster's turn
    static boolean defend = false;
    static boolean dodge = false;
    public static void fight(int enemy)
    {
        if(enemy == 1)
        {
            System.out.println("You encountered a monster.");
            System.out.println();
            System.out.println("Hero HP: " + Dungeon.hero[1]);
            System.out.println("Monster HP: " + Dungeon.monster[1]);
            System.out.println();
        }
        if(enemy == 2)
        {
            System.out.println("You encountered the wizard.");
            System.out.println();
            System.out.println("Hero HP: " + Dungeon.hero[1]);
            System.out.println("Wizard HP: " + Dungeon.wizard[1]);
            System.out.println();
        }
    }
    //wizard
    public static void attackWizard(int turn)
    {
        if (turn == 1)
        {
            dodge = false;
            if(!defend)
            {
                System.out.println("You attacked the wizard for " + Dungeon.hero[0] + " damage.");
                Dungeon.wizard[1] -= Dungeon.hero[0];
                if(Dungeon.wizard[1] <= 0)
                {
                    Dungeon.wizard[1] = 0;
                }
                System.out.println("Hero HP: " + Dungeon.hero[1]);
                System.out.println("Wizard HP: " + Dungeon.wizard[1]);
                System.out.println();
            }
            else
            {
                System.out.println("You attacked the defending wizard, your attack was cut in half.");
                System.out.println("You attacked the wizard for " + (Dungeon.hero[0] / 2) + " damage.");
                Dungeon.wizard[1] -= (Dungeon.hero[0] / 2);
                if(Dungeon.wizard[1] <= 0)
                {
                    Dungeon.wizard[1] = 0;
                }
                System.out.println("Hero HP: " + Dungeon.hero[1]);
                System.out.println("Wizard HP: " + Dungeon.wizard[1]);
                System.out.println();
            }

            // check if potion is in inventory
            if(accessories.potion)
            {
                System.out.println("Your potion heals you for 1 health.");
                if(Dungeon.hero[1] < Dungeon.heroHealth)
                {
                    Dungeon.hero[1] += 1;
                }
                System.out.println("Hero HP: " + Dungeon.hero[1]);
                System.out.println("Wizard HP: " + Dungeon.wizard[1]);
                System.out.println();
            }
        }
        else
        {
            double wizardTurn = Math.random();
            if(wizardTurn <= 0.7)
            {
                defend = false;
                if(!dodge)
                {
                    // check if shield is in inventory
                    if(accessories.shield)
                    {
                        System.out.println("Shield is activated, the wizard's damage is lowered.");
                        System.out.println("The wizard attacked you for " + (Dungeon.wizard[0] - 1) + " damage.");
                        Dungeon.hero[1] -= (Dungeon.wizard[0] - 1);
                    }
                    else
                    {
                        System.out.println("The wizard attacked you for " + Dungeon.wizard[0] + " damage.");
                        Dungeon.hero[1] -= Dungeon.wizard[0];
                    } 
                    if(Dungeon.hero[1] <= 0)
                    {
                        Dungeon.hero[1] = 0;
                    }
                    System.out.println("Hero HP: " + Dungeon.hero[1]);
                    System.out.println("Wizard HP: " + Dungeon.wizard[1]);
                    System.out.println();
                }
                else
                {
                    System.out.println("The wizard missed their attack.");
                }
            }
            else
            {
                System.out.println("The wizard defends against your next attack.");
                defend = true;
            }

            // check if potion is in inventory
            if(accessories.potion)
            {
                System.out.println("Your potion heals you for 1 health.");
                if(Dungeon.hero[1] < Dungeon.heroHealth)
                {
                    Dungeon.hero[1] += 1;
                }
                System.out.println("Hero HP: " + Dungeon.hero[1]);
                System.out.println("Wizard HP: " + Dungeon.wizard[1]);
                System.out.println();
            }
        }
        
    }

    // monster
    public static void attack(int turn)
    {
        if (turn == 1)
        {
            dodge = false;
            if(!defend)
            {
                System.out.println("You attacked the monster for " + Dungeon.hero[0] + " damage.");
                Dungeon.monster[1] -= Dungeon.hero[0];
                if(Dungeon.monster[1] <= 0)
                {
                    Dungeon.monster[1] = 0;
                }
                System.out.println("Hero HP: " + Dungeon.hero[1]);
                System.out.println("Monster HP: " + Dungeon.monster[1]);
                System.out.println();
            }
            else
            {
                System.out.println("You attacked the defending monster, your attack was cut in half.");
                System.out.println("You attacked the monster for " + (Dungeon.hero[0] / 2) + " damage.");
                Dungeon.monster[1] -= (Dungeon.hero[0] / 2);
                if(Dungeon.monster[1] <= 0)
                {
                    Dungeon.monster[1] = 0;
                }
                System.out.println("Hero HP: " + Dungeon.hero[1]);
                System.out.println("Monster HP: " + Dungeon.monster[1]);
                System.out.println();
            }

            // check if potion is in inventory
            if(accessories.potion)
            {
                System.out.println("Your potion heals you for 1 health.");
                if(Dungeon.hero[1] < Dungeon.heroHealth)
                {
                    Dungeon.hero[1] += 1;
                }
                System.out.println("Hero HP: " + Dungeon.hero[1]);
                System.out.println("Monster HP: " + Dungeon.monster[1]);
                System.out.println();
            }
        }
        else
        {
            double monsterTurn = Math.random();
            if(monsterTurn <= 0.7)
            {
                defend = false;
                if(!dodge)
                {
                    // check if shield is in inventory
                    if(accessories.shield)
                    {
                        System.out.println("Shield is activated, the monster's damage is lowered.");
                        System.out.println("The monster attacked you for " + (Dungeon.monster[0] - 1) + " damage.");
                        Dungeon.hero[1] -= (Dungeon.monster[0] - 1);
                    }
                    else
                    {
                        System.out.println("The monster attacked you for " + Dungeon.monster[0] + " damage.");
                        Dungeon.hero[1] -= Dungeon.monster[0];
                    }
                    if(Dungeon.hero[1] <= 0)
                    {
                        Dungeon.hero[1] = 0;
                    }
                    System.out.println("Hero HP: " + Dungeon.hero[1]);
                    System.out.println("Monster HP: " + Dungeon.monster[1]);
                    System.out.println();
                }
                else
                {
                    System.out.println("The monster missed its attack.");
                }
            }
            else
            {
                System.out.println("The monster defends against your next attack.");
                defend = true;
            }

            // check if potion is in inventory
            if(accessories.potion)
            {
                System.out.println("Your potion heals you for 1 health.");
                if(Dungeon.hero[1] < Dungeon.heroHealth)
                {
                    Dungeon.hero[1] += 1;
                }
                System.out.println("Hero HP: " + Dungeon.hero[1]);
                System.out.println("Monster HP: " + Dungeon.monster[1]);
                System.out.println();
            }
        }
        
    }
    // monster (1)  wizard (2)
    public static void dodge (int enemy)
    {
        double reflex = Dungeon.hero[2] / 10.0;
        double chance = Math.random();
        if(chance <= reflex)
        {
            dodge = true;
            if(enemy == 1)
                System.out.println("You successfully dodge the monster's next attack.");
            if(enemy == 2)
                System.out.println("You successfully dodge the wizard's next attack.");
        }
        else
        {
            dodge = false;
            System.out.println("You failed to dodge the monster's next attack.");
        }
    }
    public static boolean run (int enemy)
    {
        double speed = Dungeon.hero[2] / 10.0;
        double luck = Math.random();
        if(luck <= speed)
        {
            System.out.println("You were able to run away from the battle.");
            return true;
        }
        else
        {
            if(enemy == 1)
                System.out.println("The monster doesn't let you leave the battle.");
            if(enemy == 2)
                System.out.println("The wizard doesn't let you leave the battle.");
            return false;
        }
    }
}
