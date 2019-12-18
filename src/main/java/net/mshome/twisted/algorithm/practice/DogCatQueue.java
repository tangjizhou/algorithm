package net.mshome.twisted.algorithm.practice;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * 猫狗队列
 *
 * @author tangjizhouchn@foxmail.com
 * @date 2019/12/18
 */
public class DogCatQueue {

    private static class Pet {

        private String type;

        public Pet(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }

    }


    private static class Dog extends Pet {

        public Dog() {
            super("dog");
        }

    }

    private static class Cat extends Pet {

        public Cat() {
            super("cat");
        }

    }


    private static class PetQueue {

        private Pet pet;
        private Long count;

        public PetQueue(Pet pet, Long count) {
            this.pet = pet;
            this.count = count;
        }

        public static PetQueue of(Pet pet) {
            return new PetQueue(pet, System.currentTimeMillis());
        }

        public String getType() {
            return this.pet.getType();
        }

        public Long getCount() {
            return count;
        }

        public Pet getPet() {
            return pet;
        }

    }


    private Queue<PetQueue> dogQueue;
    private Queue<PetQueue> catQueue;

    public DogCatQueue() {
        this.dogQueue = new LinkedList<>();
        this.catQueue = new LinkedList<>();
    }

    public void add(Pet pet) {
        if (Objects.equals("dog", pet.getType())) {
            dogQueue.add(PetQueue.of(pet));
        } else if (Objects.equals("cat", pet.getType())) {
            catQueue.add(PetQueue.of(pet));
        }
    }

    public Dog pollDog() {
        if (this.dogQueue.isEmpty()) {
            throw new RuntimeException("empty dog queue");
        }
        return (Dog) this.dogQueue.poll().getPet();
    }

    public Cat pollCat() {
        if (this.catQueue.isEmpty()) {
            throw new RuntimeException("empty cat queue");
        }
        return (Cat) this.catQueue.poll().getPet();
    }

    public boolean isEmpty() {
        return this.dogQueue.isEmpty() && this.catQueue.isEmpty();
    }

    public boolean isDogEmpty() {
        return this.dogQueue.isEmpty();
    }

    public boolean isCatEmpty() {
        return this.catQueue.isEmpty();
    }

    public Pet pollAll() {
        if (!isDogEmpty() && !isCatEmpty()) {
            PetQueue dogQueue = this.dogQueue.peek();
            PetQueue catQueue = this.catQueue.peek();
            return dogQueue.getCount() < catQueue.getCount() ? pollDog() : pollCat();
        }

        if (!isDogEmpty()) {
            return pollDog();
        }
        if (!isCatEmpty()) {
            return pollCat();
        }
        throw new RuntimeException("empty queue");
    }


}
