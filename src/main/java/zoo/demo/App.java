package zoo.demo;

import java.util.*;

public class App {
    private static Map<Animal, List<Animal>> friendMap = new HashMap<>();
    private static List<Animal> animalList = new ArrayList<>();
    private static Random random = new Random();

    public static void main(String[] args) {
        Animal dog_1 = new Dog("Dog one", "Meat", "Hunting dog");
        Animal dog_2 = new Dog("Dog two", "Fresh meat", "Assistance dog");
        Animal dog_3 = new Dog("Dog three", "Pedigree", "Racing dog");

        Animal parrot_1 = new Parrot("Parrot one", "Grain", "0.25", false);
        Animal parrot_2 = new Parrot("Parrot two", "Corn", "0,5", true);

        Animal chicken_1 = new Chicken("Chicken one", "Corn", "0,75", true);
        Animal chicken_2 = new Chicken("Chicken two", "Corn", "0,75", false);

        animalList = Arrays.asList(dog_1, dog_2, dog_3, parrot_1, parrot_2, chicken_1, chicken_2);
        animalList.forEach(animal -> addAnimal(animal));
        while (true) {
            System.out.println("\n" + "Please choose options(1, 2 or 3): ");
            System.out.println("1 >> SHOW_ANIMALS");
            System.out.println("2 >> LIVE_ONE_DAY");
            System.out.println("3 >> Exit");
            Scanner input = new Scanner(System.in);
            switch (input.nextInt()) {
                case 1:
                    display_AllAnimals();
                    break;

                case 2:
                    liveOneDay(animalList);
                    break;

                case 3:
                    System.exit(0);
            }
        }
    }

    private static void addAnimal(Animal animal) {
        friendMap.putIfAbsent(animal, new ArrayList<>());
    }

    private static void display_AllAnimals() {
        friendMap.forEach((animal, friends) -> {
            if (animal instanceof Dog) {
                System.out.println("Name: " + animal.getName() + ", " + "Favourite Food: " + animal.getFavouriteFood() + ", " + "Type: " + ((Dog) animal).getType());
            }

            if (animal instanceof Parrot) {
                System.out.println("Name: " + animal.getName() + ", " + "Favourite Food: " + animal.getFavouriteFood() + ", " + "Can Speak: " + ((Parrot) animal).isCanSpeak());
            }

            if (animal instanceof Chicken) {
                System.out.println("Name: " + animal.getName() + ", " + "Favourite Food: " + animal.getFavouriteFood() + ", " + "Is Broiler: " + ((Chicken) animal).isBroiler());
            }
            System.out.print("Friends: ");
            friends.forEach(friend -> {
                System.out.print(friend.getName() + "  ");
            });
            System.out.println("\n");
        });
    }

    private static void liveOneDay(List<Animal> animalList) {
        friendMap.forEach((animal, friends) -> {
            //Start: Break friendship logic.
            int remove = -1;
            //Animal can lose friend only if they have at least one friend.
            if (friends.size() > 0) {
                //Get random index from friends list.
                remove = random.nextInt(friends.size());
                String lostFriendName = friends.get(remove).getName();
                //Remove friend from friends list.
                removeFriendsFromMap(animal, friends.get(remove));
                System.out.print(animal.getName() + " has lost " + lostFriendName);
            } else {
                System.out.print(animal.getName() + " has no friends");
            }
            //End: Break friendship logic.

            //Start: Establish friendship logic.
            //Get random index to choose random animal from animal list while making friendship.
            int add = generateRandomIndex(animalList.indexOf(animal), remove, friends, animalList);
            //If random index is greater than animalList size that means animal is not interested in making new friend.
            if (add >= animalList.size()) {
                System.out.print("; " + animal.getName() + " has established zero friendship." + "\n");
            } else {
                //Random index is within 0 and animalList size then add respective animal to friends list.
                addFriendsToMap(animal, animalList.get(add));
                System.out.print("; " + animal.getName() + " has established a friendship with " + animalList.get(add).getName() + ".\n");
            }
            //End: Establish friendship logic.
            System.out.println();
        });
    }

    /**
     * 1. Generate random index while making friendship. If A loses friendship with B then generateRandomIndex method makes sure that return index
     * is not of A(selfIndex), B(removedIndex) and not from existing friendList instead return index for some other animal in animalList.
     * 2. generateRandomIndex returns index between 0 to 8. Index 7 and 8 is used randomly to make decision that animal wants to make zero friend.
     * @param selfIndex
     * @param removedIndex
     * @return
     */
    private static int generateRandomIndex(int selfIndex, int removedIndex, List friends, List animalList) {
        int index;
        while (true) {
            index = random.nextInt(9);
            if (index < animalList.size()) {
                if (index != selfIndex && index != removedIndex && !friends.contains(animalList.get(index))) {
                    break;
                }
            } else {
                break;
            }
        }
        return index;
    }

    /**
     * animal_1 wants to be friend with animal_2. And as per rule animal_2 also makes friendship automatically with animal_1.
     * @param animal_1
     * @param animal_2
     */
    private static void addFriendsToMap(Animal animal_1, Animal animal_2) {
        List<Animal> existingFriends_animal_1 = friendMap.get(animal_1);
        existingFriends_animal_1.add(animal_2);

        List<Animal> existingFriends_animal_2 = friendMap.get(animal_2);
        existingFriends_animal_2.add(animal_1);
    }

    /**
     * animal_1 wants to un-friend with animal_2. And as per rule animal_2 also breaks friendship automatically with animal_1.
     * @param animal_1
     * @param animal_2
     */
    private static void removeFriendsFromMap(Animal animal_1, Animal animal_2) {
        List<Animal> existingFriends_animal_1 = friendMap.get(animal_1);
        List<Animal> existingFriends_animal_2 = friendMap.get(animal_2);
        if (existingFriends_animal_1 != null) {
            friendMap.get(animal_1).remove(animal_2);
        }
        if (existingFriends_animal_2 != null) {
            friendMap.get(animal_2).remove(animal_1);
        }
    }
}