class Start {
    public static void main(String[] args) {
        // int[] a = { 71, 80, 72, 38, 45, 63, 12, 80, 99 };
        int[] a = new int[10000000];
        for (int i = 0; i < a.length; i++) 
            a[i] = (int)(Math.random() * 1000);
        
        Engine e = new Engine();
        e.sort(a);
        boolean flag = true;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i+1]) {
                flag = false;
            }
        }
        System.out.println(flag);
    }
}

class Engine {
    
    void sort (int[] a) {
        sort(a, 0, a.length - 1);
    }
    
    void sort(int[] a, int left, int right) {
        if (left >= right) return;
        /// pivot located on the right hand side
        int pivot = a[right];  // random is better
        int lower = left;
        int upper = right - 1;
        int i = left;
        while (i <= upper) {
            int compare = a[i] - pivot;
            
            // this element is less than pivot
            if (compare < 0) { 
                int t = a[lower];    // exchange a[i] and a[lower]
                a[lower] = a[i];
                a[i] = t;
                i++;
                lower++;
            }
            
            // this element is equal to pivot
            if (compare == 0) {
                i++;
            }
            
            // this element is greater than pivot
            if (compare > 0) { 
                int t = a[upper];     // exhange a[i] and a[upper]
                a[upper] = a[i];
                a[i] = t;
                upper--;
            }
        }
        int t = a[lower];
        a[lower] = a[right];
        a[right] = t;
        
        sort(a, left, lower - 1);
        sort(a, upper + 1, right);
    }
}