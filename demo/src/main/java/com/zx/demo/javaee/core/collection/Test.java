package com.zx.demo.javaee.core.collection;


import java.util.*;

public class Test {

    @org.junit.Test
    public void test(){

        System.out.println(new StudentHashDemo(1).equals(new StudentHashDemo(1)));
        HashMap<StudentHashDemo,Integer> hashMap = new HashMap<>(16);
        hashMap.put(new StudentHashDemo(1),1);
        hashMap.put(new StudentHashDemo(2),2);
        hashMap.put(new StudentHashDemo(1),2);
        hashMap.put(new StudentHashDemo(4),4);
        hashMap.put(new StudentHashDemo(1),5);
        Iterator<Map.Entry<StudentHashDemo, Integer>> iterator = hashMap.entrySet().iterator();
        System.out.println(hashMap.size());
        while(iterator.hasNext()){
            Map.Entry<StudentHashDemo, Integer> entry = iterator.next();
            System.out.print(entry.getKey().getId());
            System.out.print("\t");
            System.out.println(entry.getValue());
        }
    }

    @org.junit.Test
    public void listTest(){
        HashSet<StudentHashDemo> studentHashDemoList = new HashSet<>(16);
        studentHashDemoList.add(new StudentHashDemo(4));
        studentHashDemoList.add(new StudentHashDemo(3));
        studentHashDemoList.add(new StudentHashDemo(5));
        studentHashDemoList.add(new StudentHashDemo(5));
        studentHashDemoList.add(new StudentHashDemo(6));
        studentHashDemoList.add(new StudentHashDemo(7));
        studentHashDemoList.add(new StudentHashDemo(4));
        studentHashDemoList.add(new StudentHashDemo(1));
        Iterator<StudentHashDemo> studentHashDemoIterator = studentHashDemoList.iterator();
        while (studentHashDemoIterator.hasNext()){
            System.out.println(studentHashDemoIterator.next());
        }
    }

    @org.junit.Test
    public void setTest(){
        HashSet<StudentSetDemo> studentHashSet = new HashSet<>(16);
        TreeSet<StudentSetDemo> studentTreeSet = new TreeSet<>();
        Random random = new Random();
        for(int i=0; i<10; i++){
            studentHashSet.add(new StudentSetDemo(random.nextInt(10)));
            studentTreeSet.add(new StudentSetDemo(random.nextInt(10)));
        }
        System.out.println(studentHashSet);

        System.out.println(studentTreeSet);
    }

    @org.junit.Test
    public void arrayList() {
        ArrayList<Integer> arrayList = new ArrayList(100000);
        for(int i=0; i<100000; i++){
            arrayList.add(i);
        }
        Vector<Integer> vector = new Vector(100000);
        for(int i=0; i<100000; i++){
            vector.add(i);
        }
        LinkedList<Integer> linkedList = new LinkedList();
        for(int i=0; i<100000; i++){
            linkedList.add(i);
        }


        long arrayStart = System.currentTimeMillis();
        Random random = new Random();
        for (int i=0; i<10000; i++) {
            arrayList.remove(random.nextInt(10000));
        }
        System.out.println(System.currentTimeMillis() - arrayStart);

        long vectorStart = System.currentTimeMillis();
        for (int i=0; i<10000; i++) {
            vector.remove(random.nextInt(10000));
        }
        System.out.println(System.currentTimeMillis() - vectorStart);

        long linkedListStart = System.currentTimeMillis();
        for (int i=0; i<10000; i++) {
            linkedList.remove(random.nextInt(10000));
        }
        System.out.println(System.currentTimeMillis() - linkedListStart);

    }
}
