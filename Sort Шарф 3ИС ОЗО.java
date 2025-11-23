public class Sort {
    
    public static void bubbleSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        
        int n = array.length;
        boolean swapped;
        
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }
    
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("=== СОРТИРОВКА ПУЗЫРЬКОМ (BUBBLE SORT) ===");
        
        int[] array = {64, 34, 25, 12, 22, 11, 90, 5};
        
        System.out.println("Исходный массив:");
        printArray(array);
        
        bubbleSort(array);
        
        System.out.println("Отсортированный массив:");
        printArray(array);
    }
}
