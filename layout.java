public class layout
{
    public static String [][] arr = new String [5] [5];;
    public static void map()
    {
        
                                                arr[0][2] = "B";

                            arr[1][1] = "A";    arr[1][2] = "M";    arr[1][3] = "A";

        arr[2][0] = "W";    arr[2][1] = "M";    arr[2][2] = "F";    arr[2][3] = "M";    arr[2][4] = "W";

                            arr[3][1] = "A";    arr[3][2] = "M";    arr[3][3] = "A";

                                                arr[4][2] = "S";
    }
    public static String location(int x, int y)
    {
        
        if(x > 4 || x < 0)
            return null;
        else if(y > 4 || y < 0)
            return null;
        else if(arr[x][y] == null)
            return null;
        else
            return arr[x][y];
    }
}
