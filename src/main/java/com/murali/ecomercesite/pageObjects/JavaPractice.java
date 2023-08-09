package com.murali.ecomercesite.pageObjects;

import com.google.gson.internal.bind.util.ISO8601Utils;
import org.openqa.selenium.devtools.v112.css.model.Value;
import org.testng.annotations.Test;

import java.security.Key;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class JavaPractice {

    private static int vowels = 0;
    private static int consonants = 0;
    private static final String TEXT = "Java is Popular Programming Language";
    @Test
    public void sortNumbers() {
        List<Integer> al = Arrays.asList(7, 3, 10, 1, 8, 4, 6, 5, 2, 9);
        al.stream().sorted().forEach(n -> System.out.print(n + "\t"));
    }

    @Test
    public void sortStrings() {
        List<String> companies = Arrays.asList(
                "Infosys",
                "Capgemini",
                "Hexaware",
                "LTI",
                "Accenture"
        );
        companies.stream().sorted().forEach(n -> System.out.println(n + "\t"));
    }

    @Test
    public void ComparatorSort() {

        List<Player> players = Arrays.asList(
                new Player(1, "Dravid", 88.55, 2),
                new Player(2, "Sehwag", 55.65, 5),
                new Player(3, "Laxman", 77.75, 3),
                new Player(4, "Sachin", 99.25, 1),
                new Player(5, "Sourav", 66.15, 4)
        );

        List<Player> sortById = players.stream().sorted((a, b) -> a.getId() - b.getId()).collect(Collectors.toList());
        sortById.forEach(n -> System.out.println(n));
        System.out.println("\n=================================================\n");

        List<Player> sortByName = players.stream().sorted((a, b) -> a.getName().compareTo(b.getName())).collect(Collectors.toList());
        sortByName.forEach(n -> System.out.println(n));
        System.out.println("\n=================================================\n");

        List<Player> sortByRank = players.stream().sorted((a, b) -> Integer.compare(a.getRank(), b.getRank())).collect(Collectors.toList());
        sortByRank.forEach(n -> System.out.println(n));

    }

    @Test
    public void sortIntReverse() {
        List<Integer> numbers = Arrays.asList(
                35, 15, 10, 5, 50, 20, 45, 30, 25, 40
        );

        numbers.stream().sorted(Collections.reverseOrder()).forEach(n -> System.out.print(n + "\t"));
        System.out.println("\n=================================================\n");
        numbers.stream().sorted(Comparator.reverseOrder()).forEach(n -> System.out.print(n + "\t"));
    }

    @Test
    public void sortStringReverse() {
        List<String> companies = Arrays.asList(
                "Infosys",
                "Capgemini",
                "Hexaware",
                "LTI",
                "Accenture"
        );

        companies.stream().sorted(Collections.reverseOrder()).forEach(n -> System.out.print(n + "\t"));
        System.out.println("\n=================================================\n");
        companies.stream().sorted(Comparator.reverseOrder()).forEach(n -> System.out.print(n + "\t"));
        System.out.println("\n=================================================\n");
        companies.stream().sorted(Comparator.naturalOrder()).forEach(n -> System.out.print(n + "\t"));
    }

    @Test
    public void customObjectReverse() {
        List<Player> players = Arrays.asList(
                new Player(1, "Dravid", 88.55, 2),
                new Player(2, "Sehwag", 55.65, 5),
                new Player(3, "Laxman", 77.75, 3),
                new Player(4, "Sachin", 99.25, 1),
                new Player(5, "Sourav", 66.15, 4)
        );

        List<Player> sortById = players.stream().sorted((a, b) -> b.getId() - a.getId()).collect(Collectors.toList());
        sortById.forEach(n -> System.out.println(n));
        System.out.println("\n=================================================\n");

        List<Player> sortByName = players.stream().sorted((a, b) -> b.getName().compareTo(a.getName())).collect(Collectors.toList());
        sortByName.forEach(n -> System.out.println(n));
        System.out.println("\n=================================================\n");

        List<Player> sortByRank = players.stream().sorted((a, b) -> Integer.compare(b.getRank(), a.getRank())).collect(Collectors.toList());
        sortByRank.forEach(n -> System.out.println(n));
    }

    @Test
    public void parallelVsSequentialStream() {
        LocalDateTime startLocalDateTime = null;
        LocalDateTime endLocalDateTime = null;
        Duration duration = null;
        List<String> names = Arrays.asList(
                "Vijay", "Ajith",
                "Kamal",
                "Rajini",
                "Dhanush",
                "Simbhu",
                "Surya",
                "Vikram",
                "Arya",
                "Vishal"
        );

        startLocalDateTime = LocalDateTime.now();
        names.stream().map(n -> n.toUpperCase()).forEachOrdered(System.out::println);
        endLocalDateTime = LocalDateTime.now();
        duration = Duration.between(startLocalDateTime, endLocalDateTime);
        System.out.println("TimeTaken:=>" + duration.toMillis());

        System.out.println("\n=================================================\n");

        startLocalDateTime = LocalDateTime.now();
        names.parallelStream().map(n -> n.toUpperCase()).forEachOrdered(System.out::println);
        endLocalDateTime = LocalDateTime.now();
        duration = Duration.between(startLocalDateTime, endLocalDateTime);
        System.out.println("TimeTaken:=>" + duration.toMillis());
    }

    @Test
    public void removeDuplicateFromList() {
        List<String> students = new ArrayList<String>();
        // add values to list
        students.add("Roger");
        students.add("Rafael");
        students.add("Djokovic");
        students.add("Roger");
        students.add("Murray");
        students.add("Rafael");

        //Approach 1 using : distinct()
        List<String> newList = students.stream().distinct().collect(Collectors.toList());
        newList.forEach(n -> System.out.println(n));
        System.out.println("\n=================================================\n");

        //Approach 2 using : sorting
        List<String> newList1 = students.stream().distinct().sorted().collect(Collectors.toList());
        newList1.forEach(n -> System.out.println(n));
        System.out.println("\n=================================================\n");

        //Approach 3 using : set
        Set<String> newSet = students.stream().collect(Collectors.toSet());
        newSet.forEach(n -> System.out.println(n));
    }

    @Test
    public void removeDupwithCustomObjects() {

        List<Player> players = new ArrayList<>();
        players.add(new Player(1, "Dravid", 88.55, 2));
        players.add(new Player(2, "Sehwag", 55.65, 5));
        players.add(new Player(3, "Laxman", 77.75, 3));
        players.add(new Player(4, "Sachin", 99.25, 1));
        players.add(new Player(5, "Sourav", 66.15, 4));
        players.add(new Player(1, "Dravid", 88.55, 2));
        System.out.println("\n=================================================\n");

        // Java 8 - Collector.toCollection()
        Set<Player> uniqueStudentSet = players
                .stream() // get stream for original list
                .collect(Collectors.toCollection(//distinct elements stored into new SET
                        () -> new TreeSet<>(Comparator.comparing(Player::getId)))
                ); //Id comparison
        uniqueStudentSet.forEach(n -> System.out.println(n));
        System.out.println("\n=================================================\n");

        // Java 8 - sorting in ascending order of Student's Rank
        List<Player> sortedList = uniqueStudentSet
                .stream() // get stream for unique SET
                .sorted(Comparator.comparing(Player::getRank)) // rank comparing
                .collect(Collectors.toList()); // elements stored to new list
        sortedList.forEach(n -> System.out.println(n));

    }

    @Test
    public void removeDupByOverridingEqualandHashcode() {
        // Java 8 - Collector.toCollection()
        List<Player> players = new ArrayList<>();
        players.add(new Player(1, "Dravid", 88.55, 2));
        players.add(new Player(2, "Sehwag", 55.65, 5));
        players.add(new Player(3, "Laxman", 77.75, 3));
        players.add(new Player(4, "Sachin", 99.25, 1));
        players.add(new Player(5, "Sourav", 66.15, 4));
        players.add(new Player(1, "Dravid", 88.55, 2));
        players.add(new Player(5, "Sourav", 66.15, 4));
        players.add(new Player(1, "Dravid", 88.55, 2));
        System.out.println("\n=================================================\n");

        Set<Player> uniqueStudentSet = players
                .stream() // get stream for original list
                .distinct() // removes duplicate
                .collect(Collectors.toSet());

        uniqueStudentSet.forEach(n -> System.out.println(n));
    }

    @Test
    public void filterEvenNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numbers.stream().filter(n -> n % 2 == 0).forEach(n -> System.out.println(n));
    }

    @Test
    public void printStringToUpper() {
        List<String> names = Arrays.asList(
                "Vijay",
                "Ajith",
                "Kamal",
                "Rajini",
                "Dhanush",
                "Simbhu",
                "Surya",
                "Vikram",
                "Arya",
                "Vishal"
        );
        List<String> toupper = names.stream().map(n -> n.toUpperCase()).collect(Collectors.toList());
        System.out.println("1. Iterable forEach method using lambda expression : \n");
        toupper.forEach(n -> System.out.println(n));
        System.out.println("\n\n2. Iterable forEach method using method reference : \n");
        toupper.forEach(System.out::println);

        Queue<String> partsOfComputer = new PriorityQueue<>(Arrays.asList(
                "CPU",
                "Monitor",
                "Keyboard",
                "Mouse",
                "Motherboard"
        ));

        System.out.println("1. Iterable forEach method using lambda expression : \n");

        partsOfComputer.forEach(dept -> System.out.println(dept));
        System.out.println("\n=================================================\n");
        partsOfComputer.forEach(System.out::println);

        Map<Integer, String> rankCompany = new HashMap<>();

        // add few entries in HashMap

        rankCompany.put(1, "Google");
        rankCompany.put(2, "Microsoft");
        rankCompany.put(3, "Yahoo");
        rankCompany.put(4, "Oracle");
        rankCompany.put(5, "Facebook");
        System.out.println("\n=================================================\n");
        rankCompany.forEach((key, value) -> System.out.println("Rank : " + key + "\tCompany : " + value));
        System.out.println("\n=================================================\n");
        rankCompany.entrySet().forEach(n -> System.out.println("Rank : " + n.getKey()
                + "\tCompany : " + n.getValue())
        );

    }

    @Test
    public void mapvsflatMap() {
        // 1. create 1st List with 3 String elements
        List<String> firstList = Arrays.asList("Apple", "Banana", "WaterMelon");

        // 2. create 1st List with 3 String elements
        List<String> secondList = Arrays.asList("MuskMelon", "Pomegranate", "Papaya");

        // 3. create 1st List with 3 String elements
        List<String> thirdList = Arrays.asList("Pineapple", "Chikko", "Orange", "Grapes");

        // finally, create List of Lists
        List<List<String>> fruitsList = Arrays.asList(
                firstList,
                secondList,
                thirdList
        );

        System.out.println("1. Before flatMap and flattening :- \n\n"
                + fruitsList);

        // fruitsList.stream().flatMap(n-> n.stream()).forEach(n-> System.out.println(n));
        List<String> resultingList = fruitsList
                .stream() // 1. get stream
                .flatMap(list -> list.stream()) // 2. intermediate operation
                .collect(Collectors.toList()); // 3. terminal operation

        resultingList.forEach(n -> System.out.println(n));
        /*
        map() method does only transformation/mapping; whereas flatMap() method does mapping as well as flattening
        map() method produces single output for each elements in input Stream; whereas flatMap() produces Stream of values or List of values for each input value
        map() method is referred as One-to-One mapping as there is one output for every input; whereas flatMap() method is referred as One-to-Many mapping as for each input it produces Stream of values
        Transformation for map() method is from Stream<T> to Stream<R>
        Transformation and flattening for flatMap() method is from Stream<Stream<T>> to Stream<R>
        */

    }

    @Test
    public void flatMapExample(){
        // 1. create 1st List with 3 String elements
        List<String> firstList = Arrays.asList("Stephen", "Nathan", "Williams");

        // 2. create 1st List with 3 String elements
        List<String> secondList = Arrays.asList("Bob", "John", "Alice");

        // 3. create 1st List with 3 String elements
        List<String> thirdList = Arrays.asList("Ramesh", "Suresh", "Naresh", "Rajesh");

        // finally, create List of Lists
        List<List<String>> namesList = Arrays.asList(
                firstList,
                secondList,
                thirdList
        );

        namesList.stream().flatMap(n->n.stream()).forEach(n-> System.out.println(n));

        // 1. create 1st List with 3 Integer elements
        List<Integer> fl = Arrays.asList(1, 2, 3);

        // 2. create 1st List with 3 Integer elements
        List<Integer> sl = Arrays.asList(4, 5, 6);

        // 3. create 1st List with 3 Integer elements
        List<Integer> tl = Arrays.asList(7, 8, 9, 10);

        // finally, create List of Lists
        List<List<Integer>> numberList = Arrays.asList(
                fl,
                sl,
                tl
        );
        numberList.stream().flatMap(n->n.stream()).forEach(n-> System.out.println(n));
    }

    @Test
    public void mergeArrays(){
        // create 2-dimensional Arrays
        String[][] namesArray = new String[][] {
                {"Stephen", "Nathan", "Williams"},
                {"Bob", "John", "Alice"},
                {"Ramesh", "Suresh", "Naresh", "Rajesh"}
        };

        System.out.println("1. Before flatMap and flattening :- \n");

        for(int index=0; index < namesArray.length; index++) {
            System.out.println(Arrays.toString(namesArray[index]));
        }
        // merge Arrays of Arrays of String into single List
        List<String> resultingList = Arrays.stream(namesArray) // 1. get stream
                .flatMap(str -> Arrays.stream(str)) // 2. intermediate operation
                .collect(Collectors.toList()); // 3. terminal operation

        System.out.println("\n\n2. Merging Arrays of Arrays into single List :- \n\n"
                + resultingList);
    }

    @Test
    public void removeDupInmultipleArray(){
        // 1. create 1st List with 3 String elements
        List<String> firstList = Arrays.asList("Stephen", "Nathan", "Williams", "Rajesh");

        // 2. create 1st List with 3 String elements
        List<String> secondList = Arrays.asList("Bob", "John", "Alice", "Rajesh");

        // 3. create 1st List with 3 String elements
        List<String> thirdList = Arrays.asList("Ramesh", "Suresh", "Naresh", "Rajesh");

        // finally, create List of Lists
        List<List<String>> namesList = Arrays.asList(
                firstList,
                secondList,
                thirdList
        );

        namesList.stream().flatMap(n->n.stream()).distinct().forEach(n-> System.out.println(n));
        System.out.println("\n=======================================================\n");
        namesList.stream().flatMap(n->n.stream()).distinct().sorted().forEach(n-> System.out.println(n));
        System.out.println("\n=========================2.3 sorted() intermediate operation==============================\n");
        namesList.stream().flatMap(n->n.stream()).distinct().sorted(String::compareTo).forEach(n-> System.out.println(n));
    }

    @Test
    public void StreamMapFilterExample(){

        List<Player> players = new ArrayList<>();
        players.add(new Player(1, "Dravid", 88.55, 2));
        players.add(new Player(2, "Sehwag", 55.65, 5));
        players.add(new Player(3, "Laxman", 77.75, 3));
        players.add(new Player(4, "Sachin", 99.25, 1));
        players.add(new Player(5, "Sourav", 66.15, 4));
        players.add(new Player(1, "Dravid", 88.55, 2));
        players.add(new Player(5, "Sourav", 66.15, 4));
        players.add(new Player(1, "Dravid", 88.55, 2));
        System.out.println("\n=================================================\n");

        players.stream().map(n->n.getAverage()).filter(n ->n > 60).forEach(n-> System.out.println(n));

    }

    @Test
    public void getNamesGreaterthanfie(){
        List<String> names = Arrays.asList(
                "Sachin",
                "Rahul",
                "Sehwag",
                "Anil",
                "Sourav",
                "Sunil",
                "Laxman"
        );
        names.stream().filter(n->n.length()>5).forEach(n-> System.out.println(n));
    }

    @Test
    public void countNumberofChars(){
        String input = "JavaJavaEE";
        Map < Character, Long> result= input.chars().mapToObj(c->(char) c).collect(Collectors.groupingBy(c->c,Collectors.counting()));
        result.forEach((key,value)-> System.out.println(key+":"+value));
    }

    @Test
    public void countNofDuplicateWords(){
        String str="Super Man Bat Man Spider Man";
        List<String> al=Arrays.asList(str.split(" "));
        Map<String, Integer> dupWordsMapWithCount = new HashMap<>();
        for(String i: al){
            dupWordsMapWithCount.put(i,Collections.frequency(al,i));
        }
//        final Set < String > wordsInString = dupWordsMapWithCount.keySet();
//
//        for (String word: wordsInString) {
//            // if word count is greater than 1
//
//            if (dupWordsMapWithCount.get(word) > 1) {
//                // Printing that word and it's count
//                System.out.println(word + " : " + dupWordsMapWithCount.get(word));
//            }
//        }
        dupWordsMapWithCount.entrySet().stream().filter(n->n.getValue()>1).forEach(n-> System.out.println(n));
    }

    @Test
    public void reverseEachWordInString(){
        String str="Super Man Bat Man Spider Man";
        List<String> al=Arrays.asList(str.split(" "));
        al.stream().sorted(Comparator.reverseOrder()).forEach(n-> System.out.println(n));


    }

    @Test
    public void CountVowelsAndConsonants(){

        System.out.println("Input text: \n" + TEXT + "\n");

        System.out.println("String.charAt() solution:");

        countVowelsAndConsonants(TEXT);

        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
        System.out.println("\n===============================================================================\n");
        countVowelsAndConsonantsjava8(TEXT);
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
        System.out.println("\n===============================================================================\n");
    }

    private void countVowelsAndConsonants(String str) {
        if (str == null) {
            // or throw IllegalArgumentException
            throw new IllegalArgumentException("Input String can't be null");
        }

        str = str.toLowerCase();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowels++;
            } else if ((ch >= 'a' && ch <= 'z')) {
                consonants++;
            }
        }
    }

    private void countVowelsAndConsonantsjava8(String str){
        if (str == null) {
            // or throw IllegalArgumentException
            throw new IllegalArgumentException("Input String can't be null");
        }
        str = str.toLowerCase();
        vowels=(int)Math.round(str.chars().filter(ch -> (ch == 'a' || ch == 'e' ||ch == 'i' || ch == 'o' || ch == 'u')).count());

        consonants=(int)Math.round(str.chars().filter(ch->(ch != 'a' && ch != 'e' &&
                ch != 'i' && ch != 'o' && ch != 'u')).filter(ch -> (ch >= 'a' && ch <= 'z')).count());
    }


    @Test
    public void sortMultipleList(){
        // 1. create 1st List with 3 String elements
        List<String> firstList = Arrays.asList("Stephen", "Nathan", "Williams");

        // 2. create 1st List with 3 String elements
        List<String> secondList = Arrays.asList("Bob", "John", "Alice");

        // 3. create 1st List with 3 String elements
        List<String> thirdList = Arrays.asList("Ramesh", "Suresh", "Naresh", "Rajesh");

        // finally, create List of Lists
        List<List<String>> namesList = Arrays.asList(
                firstList,
                secondList,
                thirdList
        );

        namesList.stream().flatMap(n->n.stream()).sorted().forEach(n-> System.out.println(n));
    }

    @Test
    public void FilterStartWithLetter(){
        // 1. create 1st List with 3 String elements
        List<String> firstList = Arrays.asList("Stephen", "Nathan", "Williams");

        // 2. create 1st List with 3 String elements
        List<String> secondList = Arrays.asList("Bob", "John", "Alice");

        // 3. create 1st List with 3 String elements
        List<String> thirdList = Arrays.asList("Ramesh", "Suresh", "Naresh", "Rajesh");

        // finally, create List of Lists
        List<List<String>> namesList = Arrays.asList(
                firstList,
                secondList,
                thirdList
        );
        namesList.stream().flatMap(n-> n.stream()).filter(n->n.startsWith("S")).forEach(n-> System.out.println(n));
        System.out.println("\n=================================================\n");
        namesList.stream().flatMap(n-> n.stream()).filter(n->n.endsWith("h")).forEach(n-> System.out.println(n));
        System.out.println("\n=================================================\n");
        namesList.stream().flatMap(n-> n.stream()).filter(n->n.contains("a")).forEach(n-> System.out.println(n));
    }
    @Test
    public void getSquareOfGivenNumbers() {
        List<Integer> listOfNaturalNumbers = Arrays.asList(1, 2, 3, 4, 5);
        listOfNaturalNumbers.stream().map(n -> n * n).forEach(n -> System.out.println(n));
    }

    @Test
    public void getPlayersRank() {
        List<Player> players = new ArrayList<>();
        players.add(new Player(1, "Dravid", 88.55, 2));
        players.add(new Player(2, "Sehwag", 55.65, 5));
        players.add(new Player(3, "Laxman", 77.75, 3));
        players.add(new Player(4, "Sachin", 99.25, 1));
        players.add(new Player(5, "Sourav", 66.15, 4));

        players.stream().map(n -> n.getRank()).forEach(n -> System.out.println(n));
    }

    @Test
    public void streamex1(){
        List<Integer> list = Arrays.asList(1,5,6,7,8,9,10);
        System.out.println(list.stream().filter(n->n>5).mapToInt(i->i).sum());
    }

    @Test
    public void maxOddNumber(){
        List<Integer> list = Arrays.asList(11,43,56,82,51,29,10);
        System.out.println(list.stream().filter(n->n%2==1).max(Integer::compare).orElse(0));
    }

    @Test
    public void checkGivenNumberis(){
        int x=35;
    }


}

class Player {
    private int id;
    private String name;
    private double average;
    private int rank;

    public Player(int id, String name, double average, int rank) {
        this.id = id;
        this.name = name;
        this.average = average;
        this.rank = rank;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", average=" + average +
                ", rank=" + rank +
                '}';
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Player other = (Player) obj;
        if (id != other.id)
            return false;
        return true;
    }
}
