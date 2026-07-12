class Solution {
    public static int[] solution(String[] park, String[] routes) {
        int x = 0;
        int y = 0;
        int[][] arr = {{-1,0},{1,0},{0,-1},{0,1}};
        boolean start = false;
        for(int i=0; i< park.length;i++){
            if(start){
                break;
            }
            for(int j=0; j<park[i].length();j++){
                if(park[i].charAt(j) == 'S'){
                    x = i;
                    y = j;
                    start = true;
                    break;
                }
            }
        }

        for (String route : routes) {
            String[] routeArr = route.split(" ");
            String direction = routeArr[0];
            int distance = Integer.parseInt(routeArr[1]);

            int index = getDirectionIndex(direction);

            if(isWalk(park, x, y, distance, arr[index])){
                x += distance*arr[index][0];
                y += distance*arr[index][1];
            }
        }

        return new int[]{x,y};
    }

    private static boolean isWalk(String[] park, int x, int y, int distance, int[] arr) {
        for(int i = 0; i< distance; i++){
            x+= arr[0];
            y+= arr[1];

            if(y<0 || y> park[0].length()-1 || x<0 || x> park.length-1 || park[x].charAt(y)=='X'){
                return false;
            }
        }
        return true;
    }

    private static int getDirectionIndex(String direction) {
        int index = 0;
        switch (direction){
            case "N":
                break;
            case "S":
                index = 1;
                break;
            case "W":
                index = 2;
                break;
            case "E":
                index = 3;
                break;
        }
        return index;
    }
}