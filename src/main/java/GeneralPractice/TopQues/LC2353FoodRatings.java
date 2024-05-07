package GeneralPractice.TopQues;

import java.util.*;

public class LC2353FoodRatings {

    // Map food with its rating.
    private Map<String, Integer> foodRatingMap = new HashMap<>();
    // Map food with cuisine it belongs to.
    private Map<String, String> foodCuisineMap = new HashMap<>();

    // Store all food of a cuisine in set (to sort them on ratings/name)
    // Set element -> Pair: (-1 * foodRating, foodName)
    private Map<String, TreeSet<Pair<Integer, String>>> cuisineFoodMap = new HashMap<>();

    public LC2353FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; ++i) {
            // Store 'rating' and 'cuisine' of current 'food' in 'foodRatingMap' and 'foodCuisineMap' maps.
            foodRatingMap.put(foods[i], ratings[i]);
            foodCuisineMap.put(foods[i], cuisines[i]);

            // Insert the '(-1 * rating, name)' element in the current cuisine's set.
            cuisineFoodMap
                    .computeIfAbsent(cuisines[i], k -> new TreeSet<>((a, b) -> {
                        int compareByRating = Integer.compare(a.getKey(), b.getKey());
                        if (compareByRating == 0) {
                            // If ratings are equal, compare by food name (in ascending order).
                            return a.getValue().compareTo(b.getValue());
                        }
                        return compareByRating;
                    }))
                    .add(new Pair(-ratings[i], foods[i]));
        }
    }

    public void changeRating(String food, int newRating) {
        // Fetch cuisine name for food.
        String cuisineName = foodCuisineMap.get(food);

        // Find and delete the element from the respective cuisine's set.
        TreeSet<Pair<Integer, String>> cuisineSet = cuisineFoodMap.get(cuisineName);
        Pair<Integer, String> oldElement = new Pair<>(-foodRatingMap.get(food), food);
        cuisineSet.remove(oldElement);

        // Update food's rating in 'foodRating' map.
        foodRatingMap.put(food, newRating);
        // Insert the '(-1 * new rating, name)' element in the respective cuisine's set.
        cuisineSet.add(new Pair<>(-newRating, food));
    }

    public String highestRated(String cuisine) {
        Pair<Integer, String> highestRated = cuisineFoodMap.get(cuisine).first();
        // Return name of the highest rated 'food' of 'cuisine'.
        return highestRated.getValue();
    }

    public static void main(String[] args) {
        LC2353FoodRatings lc2353FoodRatings= new LC2353FoodRatings(
                new String[]{"tjokfmxg","xmiuwozpmj","uqklk","mnij","iwntdyqxi","cduc","cm","mzwfjk"}
                ,new String[]{"waxlau","ldpiabqb","ldpiabqb","waxlau","ldpiabqb","waxlau","waxlau","waxlau"},
                new int[]{9,13,7,16,10,17,16,17});

        lc2353FoodRatings.changeRating("tjokfmxg",19);
        lc2353FoodRatings.highestRated("waxlau");
        lc2353FoodRatings.changeRating("uqklk",7);
        lc2353FoodRatings.highestRated("waxlau");
        lc2353FoodRatings.highestRated("waxlau");
        lc2353FoodRatings.changeRating("tjokfmxg",14);
        lc2353FoodRatings.highestRated("waxlau");
        lc2353FoodRatings.highestRated("waxlau");
        lc2353FoodRatings.changeRating("tjokfmxg",4);
        lc2353FoodRatings.highestRated("waxlau");
        lc2353FoodRatings.changeRating("mnij",18);
        lc2353FoodRatings.highestRated("waxlau");
    }

    class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() { return key; }
        public V getValue() { return value; }
    }
}