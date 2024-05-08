package KuleshovI.HashMaps;


public class Program {

    public static void main(String[] args) {
/*
        Employee employee1 = new Employee("AAAA", 35);
        System.out.println(employee1.hashCode());
        Employee employee2 = new Employee("AAAA", 33);
        System.out.println(employee2.hashCode());
        Employee employee3 = new Employee("CCCC", 47);
        System.out.println(employee3.hashCode());
*/
        HashMaps<String, String> hashMap1 = new HashMaps<>(4);
         String oldValue;

        oldValue =  hashMap1.put("+790002348", "LKJKHGA3");
        System.out.println("Old value for key +790002348: " + oldValue);

        oldValue = hashMap1.put("+790002345", "AAAAAA");
        System.out.println("Value for key +790002345: " + hashMap1.get("+790002345"));

        oldValue = hashMap1.put("+790002355", "DDDDDA");
        System.out.println("Value for key +790002355: " + hashMap1.get("+790002355"));

        oldValue = hashMap1.put("+790002345", "LKJKHGA");
        System.out.println("Value for key +790002345: " + hashMap1.get("+790002345"));

        oldValue = hashMap1.put("+790002346", "LKJKHGA1");
        System.out.println("Value for key +790002346: " + hashMap1.get("+790002346"));

        oldValue = hashMap1.put("+790002347", "LKJKHGA2");
        System.out.println("Value for key +790002347: " + hashMap1.get("+790002347"));

        oldValue = hashMap1.put("+790002348", "LKJKHGA3");
        System.out.println("Value for key +790002348: " + hashMap1.get("+790002348"));
    }
}
