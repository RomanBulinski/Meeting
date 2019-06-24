import java.util.*;

public class Main {




    public static String meeting(String s) {

        TreeMap<String, List> people = new TreeMap();
        String[] persons = s.split(";");
        for(String person : persons){
           String[]  fullNames = person.split(":");
           if(  !people.keySet().contains( fullNames[1] ) ){
               List<String> names = new ArrayList<>();
               names.add(fullNames[0]);
               people.put(fullNames[1], names);
           }else if (  people.keySet().contains( fullNames[1] ) ){
                List<String> names = people.get(fullNames[1] );
                names.add(fullNames[0]);
                Collections.sort(names);
                people.put(fullNames[1], names);
            }

        }

        System.out.println(people);

        StringBuilder result = new StringBuilder();
        Set<String> secondNames = people.keySet();

        for(String secondName : secondNames ){
            List<String> names = people.get(secondName);
            for( String name  : names ){
                result.append("(").append(secondName).append(name).append(")");
            }
        }
        return result.toString();
    }


    public static void main(String[] args) {

//        String input = "Alexis:Wahl;John:Bell;Victoria:Schwarz;Jhon:Dorny;Tom:Dorny;Abba:Dorny;";
//        System.out.println(meeting(input));

    }


}
