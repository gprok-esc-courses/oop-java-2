public class Test {
    public static void main(String[] args) {
        System.out.println("Hello");

        int a = 1;
        double d = 3.14;
        char c = 'A';
        boolean b = false;

        var x = 10;

        System.out.println(a);
        String s = "Hello World!";

        System.out.println(s);

        // Single line comment

        /*
        Multi line comment
        Many lines can be added
        */

        /**
         * Documentation comment
         */

        // Selection, if - else if - else, switch
        if (a == 5) {
            System.out.println("It's 5");
        }
        else if (a < 5) {
            System.out.println("Less than 5");
        }
        else {
            System.out.println("Greater than 5");
        }

        switch(a) {
            case 1:
                System.out.println("one");
                break;
            case 2:
                System.out.println("two");
                break;
            case 3:
                System.out.println("three");
                break;
            default:
                System.out.println("other");
                break;
        }

        // Repetition: for, while, do-while, for each
        for(int i = 0; i < 10; i++) {
            System.out.println(i);
        }

        int i = 0;
        while(i < 10) {
            System.out.println(i);
            i++;
        }

        i = 0;
        do {
            System.out.println(i);
            i++;
        } while(i < 10);

        // Arrays
        int [] data = new int[5];
        data[0] = 10;

        String [] names = {"Mike", "John", "Alice", "Mary"};

        for(String name : names) {
            System.out.println(name);
        }

        for(int j = 0; j < names.length; j++) {
            System.out.println(names[j]);
        }
    }
}
