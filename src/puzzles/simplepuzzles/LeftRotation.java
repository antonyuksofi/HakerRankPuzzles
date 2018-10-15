package puzzles.simplepuzzles;

public class LeftRotation {
    static int[] rotate(int distance, int[] array) {
        if (distance == array.length) {
            return array;
        }

        int[] result = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            if (i + distance < array.length) {
                result[i] = array[i + distance];
            }
            else {
                result[i] = array[i + distance - array.length];
            }
        }

        return result;
    }
}
