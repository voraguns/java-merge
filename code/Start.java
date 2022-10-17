class Start {
    public static void main(String[] args) {
        int[] a = { 8, 5, 4, 7, 2, 3, 6, 4 };
        for(int i = 0; i < a.length; i++) {
            if(a[i] % 2 == 0) {
                System.out.print(" " + a[i]);
            }
        }
    }
}