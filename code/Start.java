class Start {
    public static void main(String[] args) {
        int[] a = { 8, 5, 4, 7, 2, 3, 6, 4 };
        
        System.out.println("Original Version :");
        for(int i = 0; i < a.length; i++) {
            System.out.print(" " + a[i]);
        }
        System.out.println("");
        
        System.out.println("Print all even : ");
        for(int i = 0; i < a.length; i++) {
            if(a[i] % 2 == 0) {
                System.out.print(" " + a[i]);
            }
        }
        
        System.out.println("");
        
        System.out.println("Reverse all even values only : ");
        int left = 0;
        int right = a.length - 1;
        while(left <= right) {
            if (a[left] % 2 == 0 && a[right] % 2 == 0) {
                int x = a[left];
                int y = a[right];
                a[left] = y;
                a[right] = x;
                left++; 
                right--;
                continue;
            }
            if (a[left] % 2 != 0 && a[right] % 2 == 0) { left++; continue; }
            if (a[left] % 2 == 0 && a[right] % 2 != 0) { right--; continue; }
            if (a[left] % 2 != 0 && a[right] % 2 != 0) { left++; right--; continue; }
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(" " + a[i]);
        }
    }
}