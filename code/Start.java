class Start {
    public static void main(String[] args) {
        int[] a = { 8, 3, 5, 2, 1, 7, 4, 1, 3 };  
        Platform p = new Platform();
        Element head = p.create(a);
        head = p.sort(head);       
        p.print(head);        
    }
}

class Platform {
    Element sort(Element head) {
        if (head == null) return null;
        if (head.next == null) return head;
        
        Element back = cut(head);
        head = sort(head);
        back = sort(back);
        return merge(head, back);
     }
    
    Element merge(Element a, Element b) {
        if (a == null && b == null) 
            return null;
        
        
        if (a!= null && b == null) 
            return a;
        
        
        if (a == null && b != null) 
            return b;
        
        if (a.value < b.value) {
            a.next = merge(a.next, b);
            return a;
        } else {
            b.next = merge(a, b.next);
            return b;
        }
    }
    
    
    Element cut(Element e) {
        if (e == null) return null;         // no element
        if (e.next == null) return null;    // one element
        if (e.next.next == null) {          // two element
            Element back = e.next;
            e.next = null;
            return back;
        }
        Element fast = e;
        Element slow = e;
        while(fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        Element back = slow.next;
        slow.next = null;
        return back;
    }
    
    void print(Element e) {
        for (Element current = e; current != null; current = current.next) {
            System.out.print(" " + current.value);
        }
    }
    
    Element create(int[] a) {
        if (a.length == 0) return null;
        Element head = new Element();
        head.value = a[0];
        Element tail = head;
        for (int i = 1; i < a.length; i++) {
            Element e = new Element();
            e.value = a[i];
            tail.next = e;
            tail = tail.next;
        }
        return head;
    }
}

class Element {
    int value;
    Element next;
}