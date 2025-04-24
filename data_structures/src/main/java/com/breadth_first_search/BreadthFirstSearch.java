package com.breadth_first_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BreadthFirstSearch {
    protected Map<String, List<Person>> directory;

    public BreadthFirstSearch() {
        directory = new HashMap<>();
    }

    private void populateDirectory() {
        Person abby = new Person("Abby", "Chicago");
        Person jason = new Person("Jason", "New York City");
        Person thomas = new Person("Thomas", "Atlanta");
        Person sammy = new Person("Sammy", "Charlotte");
        Person alex = new Person("Alex", "Los Angeles");
        Person austin = new Person("Austin", "Denver");
        Person connor = new Person("Connor", "Buffalo");
        Person kaitlyn = new Person("Kaitlyn", "Topeka");
        Person vanessa = new Person("Vanessa", "Nashville");

        directory.put(abby.getName(), Arrays.asList(sammy, alex));
        directory.put(jason.getName(), Arrays.asList(abby));
        directory.put(thomas.getName(), Arrays.asList(kaitlyn, abby, sammy));
        directory.put(sammy.getName(), Arrays.asList());
        directory.put(alex.getName(), Arrays.asList(austin, thomas));
        directory.put(connor.getName(), Arrays.asList(jason));
        directory.put(austin.getName(), Arrays.asList(connor));
        directory.put(kaitlyn.getName(), Arrays.asList(kaitlyn, sammy));
        directory.put(vanessa.getName(), Arrays.asList(jason, alex, austin));
    }

    public static void main(String[] args) {
        BreadthFirstSearch bs = new BreadthFirstSearch();
        bs.populateDirectory();

        bs.search("Abby", "Kaitlyn");
    }

    public Person search(String startingName, String targetCity) {
        if(!directory.containsKey(startingName)) {
            System.out.println("Starting name not found");
            return null;
        }

        Queue<Person> possibleContacts = new LinkedList<>(directory.get(startingName));
        List<Person> searched = new ArrayList<>();
        System.out.println(startingName);

        while(!possibleContacts.isEmpty()) {
            Person possibleContact = possibleContacts.remove();
            System.out.println(possibleContact);

            if(possibleContact.getCity().equals(targetCity)) return possibleContact;
            
            searched.add(possibleContact);

            for(Person p : directory.get(possibleContact.getName())) {
                if(!searched.contains(p) && !possibleContacts.contains(p)) {
                    possibleContacts.add(p);
                }
            }

        }

        return null;
    }


}
