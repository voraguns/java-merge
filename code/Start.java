class Start {
    public static void main(String[] args) {
        int[] a = { 71, 80, 72, 38, 45, 63, 12,80, 99 };
        Engine e = new Engine();
        e.partition(a, 0, a.length - 1);
        System.out.println("Before (Partition already) : ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(" " + a[i]);
        }
    }
}

class Engine {
    
    int partition(int[] a, int left, int right) {
        // first version is use the left-most element be the pivot
        // the better version is to random, to prevent the worst-case 
        int pivot = a[left];
        int i = left + 1;      // skip the pivot
        int j = right;
        while(i <= j) {
            while (i <= j && a[i] <= pivot) i++;
            while (i <= j && a[j] >= pivot) j--;
            if (i <= j) {
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }          
        }
        int t = a[left];
        a[left] = a[j];
        a[j] = t;
        return j;
    }
}