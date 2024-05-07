package GeneralPractice.TopQues;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;

class SnakeGame {

    class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    int width, height, x, y;
    LinkedHashSet<Pair> snake=new LinkedHashSet<>();
    List<Pair> food=new ArrayList<>();

    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.x=0;
        this.y=0;
        this.snake.add(new Pair(x,y));
        for(int i=0;i<food.length;i++){
            this.food.add(new Pair(food[i][0],food[i][1]));
        }
    }

    public int move(String direction) {
        switch (direction.charAt(0)) {
            case 'R':
                if(validate(x,y+1)) return -1;
                y++;
                changeSnakeSize(x,y);
                break;
            case 'L':
                if(validate(x,y-1)) return -1;
                y--;
                changeSnakeSize(x,y);
                break;
            case 'U':
                if(validate(x-1,y)) return -1;
                x--;
                changeSnakeSize(x,y);
                break;
            case 'D':
                if(validate(x+1,y)) return -1;
                x++;
                changeSnakeSize(x,y);
                break;
        }
//        System.out.println(snake.size()-1+"");
        return snake.size()-1;
    }

    private void changeSnakeSize(int x, int y) {
        Pair newPair=new Pair(x,y);
        Pair firstFood=null;
        if(food.size()>0)
            firstFood=food.get(0);

        if(firstFood!=null && firstFood.equals(newPair)){
            snake.add(newPair);
            food.remove(0);
        }
        else {
            Pair tail=snake.stream().findFirst().get();
            snake.remove(tail);
            snake.add(newPair);
        }

    }

    private boolean validate(int x, int y) {
        if(x<0||x>=height) return true;
        if(y<0||y>=width) return true;
        if(snake.contains(new Pair(x, y))){
            Pair tail=snake.stream().findFirst().get();
                if(tail.x==x&&tail.y==y)
                    return false;
                else
                    return true;
        }
//        System.out.println("Values of x and y are "+x+"   "+y);
        return false;
    }

//    public static void main(String[] args) {
////      [4,4,[[1,1],[2,2],[3,3],[3,0],[2,1],[1,2],[0,3],[3,3],[1,0],[2,0]]]
//        SnakeGame snakeGame = new SnakeGame(4, 4, new int[][]{{1,1},
//                {2,2},{3,3},{3,0},{2,1},{1,2},{0,3},{3,3},{1,0},{2,0}});
//        System.out.println("res "+snakeGame.move("D")); // return 0
//        System.out.println("res "+snakeGame.move("R")); // return 1
//        System.out.println("res "+snakeGame.move("R")); // return 1, snake eats the first piece of food. The second piece of food appears at (0, 1).
//        System.out.println("res "+snakeGame.move("D")); // return 1
//        System.out.println("res "+snakeGame.move("R")); // return 1, snake eats the second food. No more food appears.
//        System.out.println("res "+snakeGame.move("D")); // return 2, game over because snake collides with border
//        System.out.println("res "+snakeGame.move("L")); // return 2
//        System.out.println("res "+snakeGame.move("L")); // return 2
//        System.out.println("res "+snakeGame.move("L")); // return 2
//        System.out.println("res "+snakeGame.move("U")); // return 2
//        System.out.println("res "+snakeGame.move("R")); // return 2, snake eats the first piece of food. The second piece of food appears at (0, 1).
//        System.out.println("res "+snakeGame.move("U")); // return 3
//        System.out.println("res "+snakeGame.move("R")); // return 3, snake eats the second food. No more food appears.
//        System.out.println("res "+snakeGame.move("R")); // return 3, snake eats the second food. No more food appears.
//        System.out.println("res "+snakeGame.move("U"));
//        System.out.println("res "+snakeGame.move("L")); // return 2
//        System.out.println("res "+snakeGame.move("L")); // return 2
//        System.out.println("res "+snakeGame.move("L")); // return 2
//        System.out.println("res "+snakeGame.move("D")); // return 2
//        System.out.println("res "+snakeGame.move("D")); // return 2
//
//    }
}


/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */